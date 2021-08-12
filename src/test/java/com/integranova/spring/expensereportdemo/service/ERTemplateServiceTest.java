package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ERTemplateServiceTest extends ClassTest {

    @InjectMocks
    private ERTemplateService instanceERTemplateService;
    
    @Mock
    private static ERTemplateJpaRepository mockRepository;
    
    @Mock
    private static ERTemplateService mockERTemplateService;
    
    @Mock
    private static ProjectService mockProjectService;
    
    @Mock
    private static EmployeeService mockEmployeeService;
    
    @Mock
    private static ExpenseCurrencyService mockExpenseCurrencyService;
    
    @Mock
    private static ERLTemplateService mockERLTemplateService;

    private static ERTemplate mockInstance1;
    
    private static ERTemplate mockInstance2;

    private static List<ERTemplate> mockPopulation;

    private static Long mockeRTemplateid;

    private static Optional<ERTemplate> mockERTemplate; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ERTemplate> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ERTemplate> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFERTemplates_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFERTemplates_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFERTemplates_NoFVarsResult;

    // test4getDynamicPopulationByFilterFERTemplates_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFERTemplates_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFERTemplates_WithFVarsResult;

    // test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4
    private static QueryRequest test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Arg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Result;

    // test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1
    private static QueryRequest test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Arg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Result;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static Long test4getByIdArg1;
    private static ERTemplate test4getByIdResult;

    // test4getByRelated
    private static ERTemplate test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ERTemplate> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ERTemplate test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ERTemplate> test4getInstancesByRelatedResult;

    // test4getERTemplateDynamic
    private static ERTemplateOid test4getERTemplateDynamicArg1;
    private static String test4getERTemplateDynamicArg2;
    private static InstanceResponseViewModel test4getERTemplateDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ERTemplateOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ERTemplateOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4buildRelatedInstance4RoleProjectsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectsWithRemainingPath
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3;

    // test4getDSERTemplates
    private static String test4getDSERTemplatesArg1;
    private static String test4getDSERTemplatesArg2;
    private static String test4getDSERTemplatesArg3;
    private static DSERTemplates test4getDSERTemplatesResult;

    // test4piuPIUERTemplates
    private static QueryRequest test4piuPIUERTemplatesArg1;
    private static List<DSERTemplates> test4piuPIUERTemplatesResult;

    // test4getCount4PIUERTemplates
    private static QueryRequest test4getCount4PIUERTemplatesArg1;
    private static int test4getCount4PIUERTemplatesResult;

    // test4piuPIUERTemplatesWithFilterFERTemplates_NoFVars
    private static QueryRequest test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsArg1;
    private static List<DSERTemplates> test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsResult;

    // test4piuPIUERTemplatesWithFilterFERTemplates_WithFVars
    private static QueryRequest test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsArg1;
    private static List<DSERTemplates> test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsResult;

    // test4createinstanceDefault
    private static CreateinstanceRequest test4createinstanceDefaultArg1;

    // test4createinstanceInitializedArguments
    private static CreateinstanceRequest test4createinstanceInitializedArgumentsArg1;

    // test4createinstanceTxnDefault
    private static CreateinstanceRequest test4createinstanceTxnDefaultArg1;
    private static ServiceResponse test4createinstanceTxnDefaultResult;

    // test4createinstanceTxnInitializedArguments
    private static CreateinstanceRequest test4createinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceTxnInitializedArgumentsResult;

    // test4createinstanceImplementationDefault
    private static CreateinstanceRequest test4createinstanceImplementationDefaultArg1;
    private static ServiceResponse test4createinstanceImplementationDefaultResult;

    // test4createinstanceImplementationInitializedArguments
    private static CreateinstanceRequest test4createinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceImplementationInitializedArgumentsResult;

    // test4deleteinstanceDefault
    private static DeleteinstanceRequest test4deleteinstanceDefaultArg1;

    // test4deleteinstanceInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceInitializedArgumentsArg1;

    // test4deleteinstanceTxnDefault
    private static DeleteinstanceRequest test4deleteinstanceTxnDefaultArg1;
    private static ServiceResponse test4deleteinstanceTxnDefaultResult;

    // test4deleteinstanceTxnInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceTxnInitializedArgumentsResult;

    // test4deleteinstanceImplementationDefault
    private static DeleteinstanceRequest test4deleteinstanceImplementationDefaultArg1;
    private static ServiceResponse test4deleteinstanceImplementationDefaultResult;

    // test4deleteinstanceImplementationInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceImplementationInitializedArgumentsResult;

    // test4editinstanceDefault
    private static EditinstanceRequest test4editinstanceDefaultArg1;

    // test4editinstanceInitializedArguments
    private static EditinstanceRequest test4editinstanceInitializedArgumentsArg1;

    // test4editinstanceTxnDefault
    private static EditinstanceRequest test4editinstanceTxnDefaultArg1;
    private static ServiceResponse test4editinstanceTxnDefaultResult;

    // test4editinstanceTxnInitializedArguments
    private static EditinstanceRequest test4editinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceTxnInitializedArgumentsResult;

    // test4editinstanceImplementationDefault
    private static EditinstanceRequest test4editinstanceImplementationDefaultArg1;
    private static ServiceResponse test4editinstanceImplementationDefaultResult;

    // test4editinstanceImplementationInitializedArguments
    private static EditinstanceRequest test4editinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceImplementationInitializedArgumentsResult;

    // test4editNameDefault
    private static EditNameRequest test4editNameDefaultArg1;

    // test4editNameInitializedArguments
    private static EditNameRequest test4editNameInitializedArgumentsArg1;

    // test4editNameTxnDefault
    private static EditNameRequest test4editNameTxnDefaultArg1;
    private static ServiceResponse test4editNameTxnDefaultResult;

    // test4editNameTxnInitializedArguments
    private static EditNameRequest test4editNameTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editNameTxnInitializedArgumentsResult;

    // test4editNameImplementationDefault
    private static EditNameRequest test4editNameImplementationDefaultArg1;
    private static ServiceResponse test4editNameImplementationDefaultResult;

    // test4editNameImplementationInitializedArguments
    private static EditNameRequest test4editNameImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editNameImplementationInitializedArgumentsResult;

    // test4editDescriptionDefault
    private static EditDescriptionRequest test4editDescriptionDefaultArg1;

    // test4editDescriptionInitializedArguments
    private static EditDescriptionRequest test4editDescriptionInitializedArgumentsArg1;

    // test4editDescriptionTxnDefault
    private static EditDescriptionRequest test4editDescriptionTxnDefaultArg1;
    private static ServiceResponse test4editDescriptionTxnDefaultResult;

    // test4editDescriptionTxnInitializedArguments
    private static EditDescriptionRequest test4editDescriptionTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editDescriptionTxnInitializedArgumentsResult;

    // test4editDescriptionImplementationDefault
    private static EditDescriptionRequest test4editDescriptionImplementationDefaultArg1;
    private static ServiceResponse test4editDescriptionImplementationDefaultResult;

    // test4editDescriptionImplementationInitializedArguments
    private static EditDescriptionRequest test4editDescriptionImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editDescriptionImplementationInitializedArgumentsResult;

    // test4clearNameDefault
    private static ClearNameRequest test4clearNameDefaultArg1;

    // test4clearNameInitializedArguments
    private static ClearNameRequest test4clearNameInitializedArgumentsArg1;

    // test4clearNameTxnDefault
    private static ClearNameRequest test4clearNameTxnDefaultArg1;
    private static ServiceResponse test4clearNameTxnDefaultResult;

    // test4clearNameTxnInitializedArguments
    private static ClearNameRequest test4clearNameTxnInitializedArgumentsArg1;
    private static ServiceResponse test4clearNameTxnInitializedArgumentsResult;

    // test4clearNameImplementationDefault
    private static ClearNameRequest test4clearNameImplementationDefaultArg1;
    private static ServiceResponse test4clearNameImplementationDefaultResult;

    // test4clearNameImplementationInitializedArguments
    private static ClearNameRequest test4clearNameImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4clearNameImplementationInitializedArgumentsResult;

    // test4clearDescriptionDefault
    private static ClearDescriptionRequest test4clearDescriptionDefaultArg1;

    // test4clearDescriptionInitializedArguments
    private static ClearDescriptionRequest test4clearDescriptionInitializedArgumentsArg1;

    // test4clearDescriptionTxnDefault
    private static ClearDescriptionRequest test4clearDescriptionTxnDefaultArg1;
    private static ServiceResponse test4clearDescriptionTxnDefaultResult;

    // test4clearDescriptionTxnInitializedArguments
    private static ClearDescriptionRequest test4clearDescriptionTxnInitializedArgumentsArg1;
    private static ServiceResponse test4clearDescriptionTxnInitializedArgumentsResult;

    // test4clearDescriptionImplementationDefault
    private static ClearDescriptionRequest test4clearDescriptionImplementationDefaultArg1;
    private static ServiceResponse test4clearDescriptionImplementationDefaultResult;

    // test4clearDescriptionImplementationInitializedArguments
    private static ClearDescriptionRequest test4clearDescriptionImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4clearDescriptionImplementationInitializedArgumentsResult;

    // test4enableDefault
    private static EnableRequest test4enableDefaultArg1;

    // test4enableInitializedArguments
    private static EnableRequest test4enableInitializedArgumentsArg1;

    // test4enableTxnDefault
    private static EnableRequest test4enableTxnDefaultArg1;
    private static ServiceResponse test4enableTxnDefaultResult;

    // test4enableTxnInitializedArguments
    private static EnableRequest test4enableTxnInitializedArgumentsArg1;
    private static ServiceResponse test4enableTxnInitializedArgumentsResult;

    // test4enableImplementationDefault
    private static EnableRequest test4enableImplementationDefaultArg1;
    private static ServiceResponse test4enableImplementationDefaultResult;

    // test4enableImplementationInitializedArguments
    private static EnableRequest test4enableImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4enableImplementationInitializedArgumentsResult;

    // test4disableDefault
    private static DisableRequest test4disableDefaultArg1;

    // test4disableInitializedArguments
    private static DisableRequest test4disableInitializedArgumentsArg1;

    // test4disableTxnDefault
    private static DisableRequest test4disableTxnDefaultArg1;
    private static ServiceResponse test4disableTxnDefaultResult;

    // test4disableTxnInitializedArguments
    private static DisableRequest test4disableTxnInitializedArgumentsArg1;
    private static ServiceResponse test4disableTxnInitializedArgumentsResult;

    // test4disableImplementationDefault
    private static DisableRequest test4disableImplementationDefaultArg1;
    private static ServiceResponse test4disableImplementationDefaultResult;

    // test4disableImplementationInitializedArguments
    private static DisableRequest test4disableImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4disableImplementationInitializedArgumentsResult;

    // test4assignTemplateToProjectDefault
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectDefaultArg1;

    // test4assignTemplateToProjectInitializedArguments
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectInitializedArgumentsArg1;

    // test4assignTemplateToProjectTxnDefault
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectTxnDefaultArg1;
    private static ServiceResponse test4assignTemplateToProjectTxnDefaultResult;

    // test4assignTemplateToProjectTxnInitializedArguments
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectTxnInitializedArgumentsArg1;
    private static ServiceResponse test4assignTemplateToProjectTxnInitializedArgumentsResult;

    // test4assignTemplateToProjectImplementationDefault
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectImplementationDefaultArg1;
    private static boolean test4assignTemplateToProjectImplementationDefaultArg2;
    private static ServiceResponse test4assignTemplateToProjectImplementationDefaultResult;

    // test4assignTemplateToProjectImplementationInitializedArguments
    private static AssignTemplateToProjectRequest test4assignTemplateToProjectImplementationInitializedArgumentsArg1;
    private static boolean test4assignTemplateToProjectImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4assignTemplateToProjectImplementationInitializedArgumentsResult;

    // test4deassignTemplateDefault
    private static DeassignTemplateRequest test4deassignTemplateDefaultArg1;

    // test4deassignTemplateInitializedArguments
    private static DeassignTemplateRequest test4deassignTemplateInitializedArgumentsArg1;

    // test4deassignTemplateTxnDefault
    private static DeassignTemplateRequest test4deassignTemplateTxnDefaultArg1;
    private static ServiceResponse test4deassignTemplateTxnDefaultResult;

    // test4deassignTemplateTxnInitializedArguments
    private static DeassignTemplateRequest test4deassignTemplateTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deassignTemplateTxnInitializedArgumentsResult;

    // test4deassignTemplateImplementationDefault
    private static DeassignTemplateRequest test4deassignTemplateImplementationDefaultArg1;
    private static boolean test4deassignTemplateImplementationDefaultArg2;
    private static ServiceResponse test4deassignTemplateImplementationDefaultResult;

    // test4deassignTemplateImplementationInitializedArguments
    private static DeassignTemplateRequest test4deassignTemplateImplementationInitializedArgumentsArg1;
    private static boolean test4deassignTemplateImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4deassignTemplateImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockeRTemplateid = Long.valueOf(0);
        mockInstance1 = new ERTemplate();
        mockInstance2 = new ERTemplate();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockERTemplate = Optional.of(new ERTemplate(new ERTemplateOid(mockeRTemplateid)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFERTemplates_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFERTemplates_WithFVars();
        setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4();
        setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getERTemplateDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4buildRelatedInstance4RoleProjectsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectsWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath();
        setUpMockData4test4getDSERTemplates();
        setUpMockData4test4piuPIUERTemplates();
        setUpMockData4test4getCount4PIUERTemplates();
        setUpMockData4test4piuPIUERTemplatesWithFilterFERTemplates_NoFVars();
        setUpMockData4test4piuPIUERTemplatesWithFilterFERTemplates_WithFVars();
        setUpMockData4test4createinstanceDefault();
        setUpMockData4test4createinstanceInitializedArguments();
        setUpMockData4test4createinstanceTxnDefault();
        setUpMockData4test4createinstanceTxnInitializedArguments();
        setUpMockData4test4createinstanceImplementationDefault();
        setUpMockData4test4createinstanceImplementationInitializedArguments();
        setUpMockData4test4deleteinstanceDefault();
        setUpMockData4test4deleteinstanceInitializedArguments();
        setUpMockData4test4deleteinstanceTxnDefault();
        setUpMockData4test4deleteinstanceTxnInitializedArguments();
        setUpMockData4test4deleteinstanceImplementationDefault();
        setUpMockData4test4deleteinstanceImplementationInitializedArguments();
        setUpMockData4test4editinstanceDefault();
        setUpMockData4test4editinstanceInitializedArguments();
        setUpMockData4test4editinstanceTxnDefault();
        setUpMockData4test4editinstanceTxnInitializedArguments();
        setUpMockData4test4editinstanceImplementationDefault();
        setUpMockData4test4editinstanceImplementationInitializedArguments();
        setUpMockData4test4editNameDefault();
        setUpMockData4test4editNameInitializedArguments();
        setUpMockData4test4editNameTxnDefault();
        setUpMockData4test4editNameTxnInitializedArguments();
        setUpMockData4test4editNameImplementationDefault();
        setUpMockData4test4editNameImplementationInitializedArguments();
        setUpMockData4test4editDescriptionDefault();
        setUpMockData4test4editDescriptionInitializedArguments();
        setUpMockData4test4editDescriptionTxnDefault();
        setUpMockData4test4editDescriptionTxnInitializedArguments();
        setUpMockData4test4editDescriptionImplementationDefault();
        setUpMockData4test4editDescriptionImplementationInitializedArguments();
        setUpMockData4test4clearNameDefault();
        setUpMockData4test4clearNameInitializedArguments();
        setUpMockData4test4clearNameTxnDefault();
        setUpMockData4test4clearNameTxnInitializedArguments();
        setUpMockData4test4clearNameImplementationDefault();
        setUpMockData4test4clearNameImplementationInitializedArguments();
        setUpMockData4test4clearDescriptionDefault();
        setUpMockData4test4clearDescriptionInitializedArguments();
        setUpMockData4test4clearDescriptionTxnDefault();
        setUpMockData4test4clearDescriptionTxnInitializedArguments();
        setUpMockData4test4clearDescriptionImplementationDefault();
        setUpMockData4test4clearDescriptionImplementationInitializedArguments();
        setUpMockData4test4enableDefault();
        setUpMockData4test4enableInitializedArguments();
        setUpMockData4test4enableTxnDefault();
        setUpMockData4test4enableTxnInitializedArguments();
        setUpMockData4test4enableImplementationDefault();
        setUpMockData4test4enableImplementationInitializedArguments();
        setUpMockData4test4disableDefault();
        setUpMockData4test4disableInitializedArguments();
        setUpMockData4test4disableTxnDefault();
        setUpMockData4test4disableTxnInitializedArguments();
        setUpMockData4test4disableImplementationDefault();
        setUpMockData4test4disableImplementationInitializedArguments();
        setUpMockData4test4assignTemplateToProjectDefault();
        setUpMockData4test4assignTemplateToProjectInitializedArguments();
        setUpMockData4test4assignTemplateToProjectTxnDefault();
        setUpMockData4test4assignTemplateToProjectTxnInitializedArguments();
        setUpMockData4test4assignTemplateToProjectImplementationDefault();
        setUpMockData4test4assignTemplateToProjectImplementationInitializedArguments();
        setUpMockData4test4deassignTemplateDefault();
        setUpMockData4test4deassignTemplateInitializedArguments();
        setUpMockData4test4deassignTemplateTxnDefault();
        setUpMockData4test4deassignTemplateTxnInitializedArguments();
        setUpMockData4test4deassignTemplateImplementationDefault();
        setUpMockData4test4deassignTemplateImplementationInitializedArguments();
    }

    private static void setUpMockData4test4solveQuery() {
        test4solveQueryArg1 = new QueryRequest();
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4get() {
        test4getResult = new ArrayList<>();
    }

    private static void setUpMockData4test4getQueryRequest() {
        test4getQueryRequestArg1 = new QueryRequest();
        test4getQueryRequestResult = mockPopulation;
    }

    private static void setUpMockData4test4getDynamicPopulation() {
        test4getDynamicPopulationArg1 = new QueryRequest();
        test4getDynamicPopulationArg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFERTemplates_NoFVars() {
        test4getDynamicPopulationByFilterFERTemplates_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFERTemplates_NoFVarsArg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationByFilterFERTemplates_NoFVarsArg1.addFilterRequest(new FilterRequest(ERTemplateConstants.FILTER_NAME_FERTEMPLATES,new ArrayList<>()));
        test4getDynamicPopulationByFilterFERTemplates_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFERTemplates_WithFVars() {
        test4getDynamicPopulationByFilterFERTemplates_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFERTemplates_WithFVarsArg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationByFilterFERTemplates_WithFVarsArg1.addFilterRequest(new FilterRequest(ERTemplateConstants.FILTER_NAME_FERTEMPLATES,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VNAME, ""), new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VDESCRIPTION, ""), new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VENABLED, false)))));
        test4getDynamicPopulationByFilterFERTemplates_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4() {
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Arg1 = new QueryRequest();
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Arg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Arg1.addFilterRequest(new FilterRequest("ExpenseReport_TNEWFROMTEMPLATE_pTemplate_NavFilter0",new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE, new Employee()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY, new ExpenseCurrency()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT, new Project()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE)), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE, ""), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES, Double.valueOf(0)), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE, new ERTemplate())))));
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Result = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1() {
        test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Arg1 = new QueryRequest();
        test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Arg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Arg1.addFilterRequest(new FilterRequest("Clas_1057569177600719FiltNav_1",new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.SELECTEDOBJECT, new Project())))));
        test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Result = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("eRTemplateid");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ERTemplateOid(Long.valueOf(0)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = Long.valueOf(0);
        test4getByIdResult = mockERTemplate.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ERTemplate();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ERTemplate();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getERTemplateDynamic() {
        test4getERTemplateDynamicArg1 = new ERTemplateOid();
        test4getERTemplateDynamicArg2 = "";
        test4getERTemplateDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ERTemplateOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ERTemplateOid(Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2 = ERTemplateConstants.ROLE_NAME_PROJECTS;
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectsWithRemainingPath() {
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2 = ERTemplateConstants.ROLE_NAME_PROJECTS;
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1 = new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2 = ERTemplateConstants.ROLE_NAME_TEMPLATELINES;
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath() {
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1 = new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2 = ERTemplateConstants.ROLE_NAME_TEMPLATELINES;
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSERTemplates() {
        test4getDSERTemplatesArg1 = "";
        test4getDSERTemplatesArg2 = "";
        test4getDSERTemplatesArg3 = "";
        test4getDSERTemplatesResult = new DSERTemplates();
    }

    private static void setUpMockData4test4piuPIUERTemplates() {
        test4piuPIUERTemplatesArg1 = new QueryRequest();
        test4piuPIUERTemplatesResult = mockPopulation.stream().map(i -> new DSERTemplates(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUERTemplates() {
        test4getCount4PIUERTemplatesArg1 = new QueryRequest();
        test4getCount4PIUERTemplatesResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUERTemplatesWithFilterFERTemplates_NoFVars() {
        test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsArg1 = new QueryRequest();
        test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsArg1.addFilterRequest(new FilterRequest(ERTemplateConstants.FILTER_NAME_FERTEMPLATES,new ArrayList<>()));
        test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsResult = mockPopulation.stream().map(i -> new DSERTemplates(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUERTemplatesWithFilterFERTemplates_WithFVars() {
        test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsArg1 = new QueryRequest();
        test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsArg1.addFilterRequest(new FilterRequest(ERTemplateConstants.FILTER_NAME_FERTEMPLATES,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VNAME, ""), new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VDESCRIPTION, ""), new FilterVariableRequest(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VENABLED, false)))));
        test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsResult = mockPopulation.stream().map(i -> new DSERTemplates(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setERTemplatecreateinstancepatrname("");
        test4createinstanceInitializedArgumentsArg1.setERTemplatecreateinstancepatrdescription("");
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setERTemplatecreateinstancepatrname("");
        test4createinstanceTxnInitializedArgumentsArg1.setERTemplatecreateinstancepatrdescription("");
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setERTemplatecreateinstancepatrname("");
        test4createinstanceImplementationInitializedArgumentsArg1.setERTemplatecreateinstancepatrdescription("");
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deleteinstanceInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplateInstance(new ERTemplate(test4deleteinstanceInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplate()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deleteinstanceTxnInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplateInstance(new ERTemplate(test4deleteinstanceTxnInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplate()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setERTemplatedeleteinstancepthisERTemplateInstance(new ERTemplate(test4deleteinstanceImplementationInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplate()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplateInstance(new ERTemplate(test4editinstanceInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplate()));
        test4editinstanceInitializedArgumentsArg1.setERTemplateeditinstancepname("");
        test4editinstanceInitializedArgumentsArg1.setERTemplateeditinstancepdescription("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplateInstance(new ERTemplate(test4editinstanceTxnInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplate()));
        test4editinstanceTxnInitializedArgumentsArg1.setERTemplateeditinstancepname("");
        test4editinstanceTxnInitializedArgumentsArg1.setERTemplateeditinstancepdescription("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setERTemplateeditinstancepthisERTemplateInstance(new ERTemplate(test4editinstanceImplementationInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplate()));
        test4editinstanceImplementationInitializedArgumentsArg1.setERTemplateeditinstancepname("");
        test4editinstanceImplementationInitializedArgumentsArg1.setERTemplateeditinstancepdescription("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editNameDefault() {
        test4editNameDefaultArg1 = new EditNameRequest();
    }

    private static void setUpMockData4test4editNameInitializedArguments() {
        test4editNameInitializedArgumentsArg1 = new EditNameRequest();
        test4editNameInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editNameInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplateInstance(new ERTemplate(test4editNameInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplate()));
        test4editNameInitializedArgumentsArg1.setERTemplateeditNamepName("");
    }

    private static void setUpMockData4test4editNameTxnDefault() {
        test4editNameTxnDefaultArg1 = new EditNameRequest();
        test4editNameTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editNameTxnInitializedArguments() {
        test4editNameTxnInitializedArgumentsArg1 = new EditNameRequest();
        test4editNameTxnInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editNameTxnInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplateInstance(new ERTemplate(test4editNameTxnInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplate()));
        test4editNameTxnInitializedArgumentsArg1.setERTemplateeditNamepName("");
        test4editNameTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editNameImplementationDefault() {
        test4editNameImplementationDefaultArg1 = new EditNameRequest();
        test4editNameImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editNameImplementationInitializedArguments() {
        test4editNameImplementationInitializedArgumentsArg1 = new EditNameRequest();
        test4editNameImplementationInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editNameImplementationInitializedArgumentsArg1.setERTemplateeditNamepthisERTemplateInstance(new ERTemplate(test4editNameImplementationInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplate()));
        test4editNameImplementationInitializedArgumentsArg1.setERTemplateeditNamepName("");
        test4editNameImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionDefault() {
        test4editDescriptionDefaultArg1 = new EditDescriptionRequest();
    }

    private static void setUpMockData4test4editDescriptionInitializedArguments() {
        test4editDescriptionInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editDescriptionInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplateInstance(new ERTemplate(test4editDescriptionInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplate()));
        test4editDescriptionInitializedArgumentsArg1.setERTemplateeditDescriptionpDescription("");
    }

    private static void setUpMockData4test4editDescriptionTxnDefault() {
        test4editDescriptionTxnDefaultArg1 = new EditDescriptionRequest();
        test4editDescriptionTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionTxnInitializedArguments() {
        test4editDescriptionTxnInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionTxnInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editDescriptionTxnInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplateInstance(new ERTemplate(test4editDescriptionTxnInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplate()));
        test4editDescriptionTxnInitializedArgumentsArg1.setERTemplateeditDescriptionpDescription("");
        test4editDescriptionTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionImplementationDefault() {
        test4editDescriptionImplementationDefaultArg1 = new EditDescriptionRequest();
        test4editDescriptionImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionImplementationInitializedArguments() {
        test4editDescriptionImplementationInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionImplementationInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4editDescriptionImplementationInitializedArgumentsArg1.setERTemplateeditDescriptionpthisERTemplateInstance(new ERTemplate(test4editDescriptionImplementationInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplate()));
        test4editDescriptionImplementationInitializedArgumentsArg1.setERTemplateeditDescriptionpDescription("");
        test4editDescriptionImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearNameDefault() {
        test4clearNameDefaultArg1 = new ClearNameRequest();
    }

    private static void setUpMockData4test4clearNameInitializedArguments() {
        test4clearNameInitializedArgumentsArg1 = new ClearNameRequest();
        test4clearNameInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearNameInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplateInstance(new ERTemplate(test4clearNameInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplate()));
    }

    private static void setUpMockData4test4clearNameTxnDefault() {
        test4clearNameTxnDefaultArg1 = new ClearNameRequest();
        test4clearNameTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearNameTxnInitializedArguments() {
        test4clearNameTxnInitializedArgumentsArg1 = new ClearNameRequest();
        test4clearNameTxnInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearNameTxnInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplateInstance(new ERTemplate(test4clearNameTxnInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplate()));
        test4clearNameTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearNameImplementationDefault() {
        test4clearNameImplementationDefaultArg1 = new ClearNameRequest();
        test4clearNameImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearNameImplementationInitializedArguments() {
        test4clearNameImplementationInitializedArgumentsArg1 = new ClearNameRequest();
        test4clearNameImplementationInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearNameImplementationInitializedArgumentsArg1.setERTemplateclearNamepthisERTemplateInstance(new ERTemplate(test4clearNameImplementationInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplate()));
        test4clearNameImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionDefault() {
        test4clearDescriptionDefaultArg1 = new ClearDescriptionRequest();
    }

    private static void setUpMockData4test4clearDescriptionInitializedArguments() {
        test4clearDescriptionInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearDescriptionInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplateInstance(new ERTemplate(test4clearDescriptionInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplate()));
    }

    private static void setUpMockData4test4clearDescriptionTxnDefault() {
        test4clearDescriptionTxnDefaultArg1 = new ClearDescriptionRequest();
        test4clearDescriptionTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionTxnInitializedArguments() {
        test4clearDescriptionTxnInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionTxnInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearDescriptionTxnInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplateInstance(new ERTemplate(test4clearDescriptionTxnInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplate()));
        test4clearDescriptionTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionImplementationDefault() {
        test4clearDescriptionImplementationDefaultArg1 = new ClearDescriptionRequest();
        test4clearDescriptionImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionImplementationInitializedArguments() {
        test4clearDescriptionImplementationInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionImplementationInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4clearDescriptionImplementationInitializedArgumentsArg1.setERTemplateclearDescriptionpthisERTemplateInstance(new ERTemplate(test4clearDescriptionImplementationInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplate()));
        test4clearDescriptionImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4enableDefault() {
        test4enableDefaultArg1 = new EnableRequest();
    }

    private static void setUpMockData4test4enableInitializedArguments() {
        test4enableInitializedArgumentsArg1 = new EnableRequest();
        test4enableInitializedArgumentsArg1.setERTemplateenablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4enableInitializedArgumentsArg1.setERTemplateenablepthisERTemplateInstance(new ERTemplate(test4enableInitializedArgumentsArg1.getERTemplateenablepthisERTemplate()));
    }

    private static void setUpMockData4test4enableTxnDefault() {
        test4enableTxnDefaultArg1 = new EnableRequest();
        test4enableTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4enableTxnInitializedArguments() {
        test4enableTxnInitializedArgumentsArg1 = new EnableRequest();
        test4enableTxnInitializedArgumentsArg1.setERTemplateenablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4enableTxnInitializedArgumentsArg1.setERTemplateenablepthisERTemplateInstance(new ERTemplate(test4enableTxnInitializedArgumentsArg1.getERTemplateenablepthisERTemplate()));
        test4enableTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4enableImplementationDefault() {
        test4enableImplementationDefaultArg1 = new EnableRequest();
        test4enableImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4enableImplementationInitializedArguments() {
        test4enableImplementationInitializedArgumentsArg1 = new EnableRequest();
        test4enableImplementationInitializedArgumentsArg1.setERTemplateenablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4enableImplementationInitializedArgumentsArg1.setERTemplateenablepthisERTemplateInstance(new ERTemplate(test4enableImplementationInitializedArgumentsArg1.getERTemplateenablepthisERTemplate()));
        test4enableImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4disableDefault() {
        test4disableDefaultArg1 = new DisableRequest();
    }

    private static void setUpMockData4test4disableInitializedArguments() {
        test4disableInitializedArgumentsArg1 = new DisableRequest();
        test4disableInitializedArgumentsArg1.setERTemplatedisablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4disableInitializedArgumentsArg1.setERTemplatedisablepthisERTemplateInstance(new ERTemplate(test4disableInitializedArgumentsArg1.getERTemplatedisablepthisERTemplate()));
    }

    private static void setUpMockData4test4disableTxnDefault() {
        test4disableTxnDefaultArg1 = new DisableRequest();
        test4disableTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4disableTxnInitializedArguments() {
        test4disableTxnInitializedArgumentsArg1 = new DisableRequest();
        test4disableTxnInitializedArgumentsArg1.setERTemplatedisablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4disableTxnInitializedArgumentsArg1.setERTemplatedisablepthisERTemplateInstance(new ERTemplate(test4disableTxnInitializedArgumentsArg1.getERTemplatedisablepthisERTemplate()));
        test4disableTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4disableImplementationDefault() {
        test4disableImplementationDefaultArg1 = new DisableRequest();
        test4disableImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4disableImplementationInitializedArguments() {
        test4disableImplementationInitializedArgumentsArg1 = new DisableRequest();
        test4disableImplementationInitializedArgumentsArg1.setERTemplatedisablepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4disableImplementationInitializedArgumentsArg1.setERTemplatedisablepthisERTemplateInstance(new ERTemplate(test4disableImplementationInitializedArgumentsArg1.getERTemplatedisablepthisERTemplate()));
        test4disableImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectDefault() {
        test4assignTemplateToProjectDefaultArg1 = new AssignTemplateToProjectRequest();
    }

    private static void setUpMockData4test4assignTemplateToProjectInitializedArguments() {
        test4assignTemplateToProjectInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplateInstance(new ERTemplate(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplate()));
        test4assignTemplateToProjectInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProjectInstance(new Project(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProject()));
    }

    private static void setUpMockData4test4assignTemplateToProjectTxnDefault() {
        test4assignTemplateToProjectTxnDefaultArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectTxnInitializedArguments() {
        test4assignTemplateToProjectTxnInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplateInstance(new ERTemplate(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplate()));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProjectInstance(new Project(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProject()));
        test4assignTemplateToProjectTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectImplementationDefault() {
        test4assignTemplateToProjectImplementationDefaultArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectImplementationDefaultArg2 = true;
        test4assignTemplateToProjectImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectImplementationInitializedArguments() {
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpthisERTemplateInstance(new ERTemplate(test4assignTemplateToProjectImplementationInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplate()));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setERTemplateassignTemplateToProjectpevcProjectInstance(new Project(test4assignTemplateToProjectImplementationInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProject()));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg2 = true;
        test4assignTemplateToProjectImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateDefault() {
        test4deassignTemplateDefaultArg1 = new DeassignTemplateRequest();
    }

    private static void setUpMockData4test4deassignTemplateInitializedArguments() {
        test4deassignTemplateInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplateInstance(new ERTemplate(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplate()));
        test4deassignTemplateInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProjectInstance(new Project(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProject()));
    }

    private static void setUpMockData4test4deassignTemplateTxnDefault() {
        test4deassignTemplateTxnDefaultArg1 = new DeassignTemplateRequest();
        test4deassignTemplateTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateTxnInitializedArguments() {
        test4deassignTemplateTxnInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateTxnInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateTxnInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplateInstance(new ERTemplate(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplate()));
        test4deassignTemplateTxnInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateTxnInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProjectInstance(new Project(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProject()));
        test4deassignTemplateTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateImplementationDefault() {
        test4deassignTemplateImplementationDefaultArg1 = new DeassignTemplateRequest();
        test4deassignTemplateImplementationDefaultArg2 = true;
        test4deassignTemplateImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateImplementationInitializedArguments() {
        test4deassignTemplateImplementationInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateImplementationInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setERTemplatedeassignTemplatepthisERTemplateInstance(new ERTemplate(test4deassignTemplateImplementationInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplate()));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setERTemplatedeassignTemplatepevcProjectInstance(new Project(test4deassignTemplateImplementationInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProject()));
        test4deassignTemplateImplementationInitializedArgumentsArg2 = true;
        test4deassignTemplateImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceERTemplateService, "eRTemplateSrv", instanceERTemplateService);

        when(mockERTemplateService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplate())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplate())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getERTemplatedeleteinstancepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplate())).thenReturn(test4editinstanceInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplate())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getERTemplateeditinstancepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editNameInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplate())).thenReturn(test4editNameInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editNameTxnInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplate())).thenReturn(test4editNameTxnInitializedArgumentsArg1.getERTemplateeditNamepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editDescriptionInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplate())).thenReturn(test4editDescriptionInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4editDescriptionTxnInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplate())).thenReturn(test4editDescriptionTxnInitializedArgumentsArg1.getERTemplateeditDescriptionpthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4clearNameInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplate())).thenReturn(test4clearNameInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4clearNameTxnInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplate())).thenReturn(test4clearNameTxnInitializedArgumentsArg1.getERTemplateclearNamepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4clearDescriptionInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplate())).thenReturn(test4clearDescriptionInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4clearDescriptionTxnInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplate())).thenReturn(test4clearDescriptionTxnInitializedArgumentsArg1.getERTemplateclearDescriptionpthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4enableInitializedArgumentsArg1.getERTemplateenablepthisERTemplate())).thenReturn(test4enableInitializedArgumentsArg1.getERTemplateenablepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4enableTxnInitializedArgumentsArg1.getERTemplateenablepthisERTemplate())).thenReturn(test4enableTxnInitializedArgumentsArg1.getERTemplateenablepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4disableInitializedArgumentsArg1.getERTemplatedisablepthisERTemplate())).thenReturn(test4disableInitializedArgumentsArg1.getERTemplatedisablepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4disableTxnInitializedArgumentsArg1.getERTemplatedisablepthisERTemplate())).thenReturn(test4disableTxnInitializedArgumentsArg1.getERTemplatedisablepthisERTemplateInstance());

        when(mockERTemplateService.getByOIDWithHV(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplate())).thenReturn(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProject())).thenReturn(test4assignTemplateToProjectInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplate())).thenReturn(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpthisERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProject())).thenReturn(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getERTemplateassignTemplateToProjectpevcProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplate())).thenReturn(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProject())).thenReturn(test4deassignTemplateInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplate())).thenReturn(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepthisERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProject())).thenReturn(test4deassignTemplateTxnInitializedArgumentsArg1.getERTemplatedeassignTemplatepevcProjectInstance());

        when(mockRepository.findById(mockeRTemplateid)).thenAnswer(new Answer<Optional<ERTemplate>>(){
        	public Optional<ERTemplate> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockeRTemplateid)) {
        			return mockERTemplate;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ERTemplate.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceERTemplateService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceERTemplateService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceERTemplateService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceERTemplateService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceERTemplateService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFERTemplates_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFERTemplates_NoFVarsResult), getResult(RESULTCODE, instanceERTemplateService.getDynamic(test4getDynamicPopulationByFilterFERTemplates_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFERTemplates_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFERTemplates_WithFVarsResult), getResult(RESULTCODE, instanceERTemplateService.getDynamic(test4getDynamicPopulationByFilterFERTemplates_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Result), getResult(RESULTCODE, instanceERTemplateService.getDynamic(test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_4Arg1)));
    }

    @Test
    public void test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Result), getResult(RESULTCODE, instanceERTemplateService.getDynamic(test4getDynamicPopulationByNavFilterClas_1057569177600719FiltNav_1Arg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceERTemplateService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceERTemplateService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceERTemplateService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceERTemplateService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceERTemplateService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getERTemplateDynamic() {
        assertEquals(test4getERTemplateDynamicResult.getResultCode(), instanceERTemplateService.getERTemplateDynamic(test4getERTemplateDynamicArg1, test4getERTemplateDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceERTemplateService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceERTemplateService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectsWithoutRemainingPath() {
        instanceERTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectsWithRemainingPath() {
        instanceERTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1, test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2, test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath() {
        instanceERTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath() {
        instanceERTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1, test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2, test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4getDSERTemplates() {
        assertEquals(test4getDSERTemplatesResult.getClass(), instanceERTemplateService.getDSERTemplates(test4getDSERTemplatesArg1, test4getDSERTemplatesArg2, test4getDSERTemplatesArg3).getClass());
    }

    @Test
    public void test4piuPIUERTemplates() {
        instanceERTemplateService.piuPIUERTemplates(test4piuPIUERTemplatesArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4getCount4PIUERTemplates() {
        instanceERTemplateService.getCount4PIUERTemplates(test4getCount4PIUERTemplatesArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4piuPIUERTemplatesWithFilterFERTemplates_NoFVars() {
        instanceERTemplateService.piuPIUERTemplates(test4piuPIUERTemplatesWithFilterFERTemplates_NoFVarsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4piuPIUERTemplatesWithFilterFERTemplates_WithFVars() {
        instanceERTemplateService.piuPIUERTemplates(test4piuPIUERTemplatesWithFilterFERTemplates_WithFVarsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceERTemplateService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceERTemplateService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceERTemplateService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceERTemplateService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceERTemplateService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceERTemplateService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editNameDefault() {
        instanceERTemplateService.editName(test4editNameDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editNameInitializedArguments() {
        instanceERTemplateService.editName(test4editNameInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editNameTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editNameTxn(test4editNameTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editNameTxnDefaultResult;
        }
        assertEquals(test4editNameTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editNameTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editNameTxn(test4editNameTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editNameTxnInitializedArgumentsResult;
        }
        assertEquals(test4editNameTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editNameImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editNameImplementation(test4editNameImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editNameImplementationDefaultResult;
        }
        assertEquals(test4editNameImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editNameImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editNameImplementation(test4editNameImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editNameImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editNameImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionDefault() {
        instanceERTemplateService.editDescription(test4editDescriptionDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editDescriptionInitializedArguments() {
        instanceERTemplateService.editDescription(test4editDescriptionInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4editDescriptionTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editDescriptionTxn(test4editDescriptionTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editDescriptionTxnDefaultResult;
        }
        assertEquals(test4editDescriptionTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editDescriptionTxn(test4editDescriptionTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editDescriptionTxnInitializedArgumentsResult;
        }
        assertEquals(test4editDescriptionTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editDescriptionImplementation(test4editDescriptionImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editDescriptionImplementationDefaultResult;
        }
        assertEquals(test4editDescriptionImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.editDescriptionImplementation(test4editDescriptionImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editDescriptionImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editDescriptionImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearNameDefault() {
        instanceERTemplateService.clearName(test4clearNameDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4clearNameInitializedArguments() {
        instanceERTemplateService.clearName(test4clearNameInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4clearNameTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearNameTxn(test4clearNameTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4clearNameTxnDefaultResult;
        }
        assertEquals(test4clearNameTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearNameTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearNameTxn(test4clearNameTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearNameTxnInitializedArgumentsResult;
        }
        assertEquals(test4clearNameTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearNameImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearNameImplementation(test4clearNameImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4clearNameImplementationDefaultResult;
        }
        assertEquals(test4clearNameImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearNameImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearNameImplementation(test4clearNameImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearNameImplementationInitializedArgumentsResult;
        }
        assertEquals(test4clearNameImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionDefault() {
        instanceERTemplateService.clearDescription(test4clearDescriptionDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4clearDescriptionInitializedArguments() {
        instanceERTemplateService.clearDescription(test4clearDescriptionInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4clearDescriptionTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearDescriptionTxn(test4clearDescriptionTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4clearDescriptionTxnDefaultResult;
        }
        assertEquals(test4clearDescriptionTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearDescriptionTxn(test4clearDescriptionTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearDescriptionTxnInitializedArgumentsResult;
        }
        assertEquals(test4clearDescriptionTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearDescriptionImplementation(test4clearDescriptionImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4clearDescriptionImplementationDefaultResult;
        }
        assertEquals(test4clearDescriptionImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.clearDescriptionImplementation(test4clearDescriptionImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearDescriptionImplementationInitializedArgumentsResult;
        }
        assertEquals(test4clearDescriptionImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4enableDefault() {
        instanceERTemplateService.enable(test4enableDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4enableInitializedArguments() {
        instanceERTemplateService.enable(test4enableInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4enableTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.enableTxn(test4enableTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4enableTxnDefaultResult;
        }
        assertEquals(test4enableTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4enableTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.enableTxn(test4enableTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4enableTxnInitializedArgumentsResult;
        }
        assertEquals(test4enableTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4enableImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.enableImplementation(test4enableImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4enableImplementationDefaultResult;
        }
        assertEquals(test4enableImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4enableImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.enableImplementation(test4enableImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4enableImplementationInitializedArgumentsResult;
        }
        assertEquals(test4enableImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4disableDefault() {
        instanceERTemplateService.disable(test4disableDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4disableInitializedArguments() {
        instanceERTemplateService.disable(test4disableInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4disableTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.disableTxn(test4disableTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4disableTxnDefaultResult;
        }
        assertEquals(test4disableTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4disableTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.disableTxn(test4disableTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4disableTxnInitializedArgumentsResult;
        }
        assertEquals(test4disableTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4disableImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.disableImplementation(test4disableImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4disableImplementationDefaultResult;
        }
        assertEquals(test4disableImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4disableImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.disableImplementation(test4disableImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4disableImplementationInitializedArgumentsResult;
        }
        assertEquals(test4disableImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectDefault() {
        instanceERTemplateService.assignTemplateToProject(test4assignTemplateToProjectDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4assignTemplateToProjectInitializedArguments() {
        instanceERTemplateService.assignTemplateToProject(test4assignTemplateToProjectInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4assignTemplateToProjectTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.assignTemplateToProjectTxn(test4assignTemplateToProjectTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4assignTemplateToProjectTxnDefaultResult;
        }
        assertEquals(test4assignTemplateToProjectTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.assignTemplateToProjectTxn(test4assignTemplateToProjectTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4assignTemplateToProjectTxnInitializedArgumentsResult;
        }
        assertEquals(test4assignTemplateToProjectTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.assignTemplateToProjectImplementation(test4assignTemplateToProjectImplementationDefaultArg1, test4assignTemplateToProjectImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4assignTemplateToProjectImplementationDefaultResult;
        }
        assertEquals(test4assignTemplateToProjectImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.assignTemplateToProjectImplementation(test4assignTemplateToProjectImplementationInitializedArgumentsArg1, test4assignTemplateToProjectImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4assignTemplateToProjectImplementationInitializedArgumentsResult;
        }
        assertEquals(test4assignTemplateToProjectImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateDefault() {
        instanceERTemplateService.deassignTemplate(test4deassignTemplateDefaultArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4deassignTemplateInitializedArguments() {
        instanceERTemplateService.deassignTemplate(test4deassignTemplateInitializedArgumentsArg1);
        assertNotNull(instanceERTemplateService);
    }

    @Test
    public void test4deassignTemplateTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deassignTemplateTxn(test4deassignTemplateTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deassignTemplateTxnDefaultResult;
        }
        assertEquals(test4deassignTemplateTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deassignTemplateTxn(test4deassignTemplateTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deassignTemplateTxnInitializedArgumentsResult;
        }
        assertEquals(test4deassignTemplateTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deassignTemplateImplementation(test4deassignTemplateImplementationDefaultArg1, test4deassignTemplateImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4deassignTemplateImplementationDefaultResult;
        }
        assertEquals(test4deassignTemplateImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERTemplateService.deassignTemplateImplementation(test4deassignTemplateImplementationInitializedArgumentsArg1, test4deassignTemplateImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4deassignTemplateImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deassignTemplateImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
