package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
public class ERLTemplateServiceTest extends ClassTest {

    @InjectMocks
    private ERLTemplateService instanceERLTemplateService;
    
    @Mock
    private static ERLTemplateJpaRepository mockRepository;
    
    @Mock
    private static ERLTemplateService mockERLTemplateService;
    
    @Mock
    private static ERTemplateService mockERTemplateService;
    
    @Mock
    private static ExpenseTypeService mockExpenseTypeService;

    private static ERLTemplate mockInstance1;
    
    private static ERLTemplate mockInstance2;

    private static List<ERLTemplate> mockPopulation;

    private static Long mockeRTemplateTemplateid;

    private static Long mockeRLTemplateid;

    private static ERLTemplateOid mockERLTemplateOid;

    private static Optional<ERLTemplate> mockERLTemplate; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ERLTemplate> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ERLTemplate> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByOrderCriteriaOCTemplateLines
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCTemplateLinesArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCTemplateLinesResult;

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
    private static Long test4getByIdArg2;
    private static ERLTemplate test4getByIdResult;

    // test4getByRelated
    private static ERLTemplate test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ERLTemplate> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ERLTemplate test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ERLTemplate> test4getInstancesByRelatedResult;

    // test4getERLTemplateDynamic
    private static ERLTemplateOid test4getERLTemplateDynamicArg1;
    private static String test4getERLTemplateDynamicArg2;
    private static InstanceResponseViewModel test4getERLTemplateDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ERLTemplateOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ERLTemplateOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4buildRelatedInstance4RoleTemplateWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleTemplateWithRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3;

    // test4getDSTemplateLines
    private static String test4getDSTemplateLinesArg1;
    private static String test4getDSTemplateLinesArg2;
    private static String test4getDSTemplateLinesArg3;
    private static DSTemplateLines test4getDSTemplateLinesResult;

    // test4piuPIUTemplateLines
    private static QueryRequest test4piuPIUTemplateLinesArg1;
    private static List<DSTemplateLines> test4piuPIUTemplateLinesResult;

    // test4getCount4PIUTemplateLines
    private static QueryRequest test4getCount4PIUTemplateLinesArg1;
    private static int test4getCount4PIUTemplateLinesResult;

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

    // test4editUnitsDefault
    private static EditUnitsRequest test4editUnitsDefaultArg1;

    // test4editUnitsInitializedArguments
    private static EditUnitsRequest test4editUnitsInitializedArgumentsArg1;

    // test4editUnitsTxnDefault
    private static EditUnitsRequest test4editUnitsTxnDefaultArg1;
    private static ServiceResponse test4editUnitsTxnDefaultResult;

    // test4editUnitsTxnInitializedArguments
    private static EditUnitsRequest test4editUnitsTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editUnitsTxnInitializedArgumentsResult;

    // test4editUnitsImplementationDefault
    private static EditUnitsRequest test4editUnitsImplementationDefaultArg1;
    private static ServiceResponse test4editUnitsImplementationDefaultResult;

    // test4editUnitsImplementationInitializedArguments
    private static EditUnitsRequest test4editUnitsImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editUnitsImplementationInitializedArgumentsResult;

    // test4editPriceDefault
    private static EditPriceRequest test4editPriceDefaultArg1;

    // test4editPriceInitializedArguments
    private static EditPriceRequest test4editPriceInitializedArgumentsArg1;

    // test4editPriceTxnDefault
    private static EditPriceRequest test4editPriceTxnDefaultArg1;
    private static ServiceResponse test4editPriceTxnDefaultResult;

    // test4editPriceTxnInitializedArguments
    private static EditPriceRequest test4editPriceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editPriceTxnInitializedArgumentsResult;

    // test4editPriceImplementationDefault
    private static EditPriceRequest test4editPriceImplementationDefaultArg1;
    private static ServiceResponse test4editPriceImplementationDefaultResult;

    // test4editPriceImplementationInitializedArguments
    private static EditPriceRequest test4editPriceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editPriceImplementationInitializedArgumentsResult;

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

    // test4clearUnitsDefault
    private static ClearUnitsRequest test4clearUnitsDefaultArg1;

    // test4clearUnitsInitializedArguments
    private static ClearUnitsRequest test4clearUnitsInitializedArgumentsArg1;

    // test4clearUnitsTxnDefault
    private static ClearUnitsRequest test4clearUnitsTxnDefaultArg1;
    private static ServiceResponse test4clearUnitsTxnDefaultResult;

    // test4clearUnitsTxnInitializedArguments
    private static ClearUnitsRequest test4clearUnitsTxnInitializedArgumentsArg1;
    private static ServiceResponse test4clearUnitsTxnInitializedArgumentsResult;

    // test4clearUnitsImplementationDefault
    private static ClearUnitsRequest test4clearUnitsImplementationDefaultArg1;
    private static ServiceResponse test4clearUnitsImplementationDefaultResult;

    // test4clearUnitsImplementationInitializedArguments
    private static ClearUnitsRequest test4clearUnitsImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4clearUnitsImplementationInitializedArgumentsResult;

    // test4clearPriceDefault
    private static ClearPriceRequest test4clearPriceDefaultArg1;

    // test4clearPriceInitializedArguments
    private static ClearPriceRequest test4clearPriceInitializedArgumentsArg1;

    // test4clearPriceTxnDefault
    private static ClearPriceRequest test4clearPriceTxnDefaultArg1;
    private static ServiceResponse test4clearPriceTxnDefaultResult;

    // test4clearPriceTxnInitializedArguments
    private static ClearPriceRequest test4clearPriceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4clearPriceTxnInitializedArgumentsResult;

    // test4clearPriceImplementationDefault
    private static ClearPriceRequest test4clearPriceImplementationDefaultArg1;
    private static ServiceResponse test4clearPriceImplementationDefaultResult;

    // test4clearPriceImplementationInitializedArguments
    private static ClearPriceRequest test4clearPriceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4clearPriceImplementationInitializedArgumentsResult;

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

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockeRTemplateTemplateid = Long.valueOf(0);
        mockeRLTemplateid = Long.valueOf(0);
        mockInstance1 = new ERLTemplate();
        mockInstance2 = new ERLTemplate();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockERLTemplateOid = new ERLTemplateOid(mockeRTemplateTemplateid, mockeRLTemplateid);
        mockERLTemplate = Optional.of(new ERLTemplate(new ERLTemplateOid(mockeRTemplateTemplateid,mockeRLTemplateid)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCTemplateLines();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getERLTemplateDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4buildRelatedInstance4RoleTemplateWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTemplateWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath();
        setUpMockData4test4getDSTemplateLines();
        setUpMockData4test4piuPIUTemplateLines();
        setUpMockData4test4getCount4PIUTemplateLines();
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
        setUpMockData4test4editUnitsDefault();
        setUpMockData4test4editUnitsInitializedArguments();
        setUpMockData4test4editUnitsTxnDefault();
        setUpMockData4test4editUnitsTxnInitializedArguments();
        setUpMockData4test4editUnitsImplementationDefault();
        setUpMockData4test4editUnitsImplementationInitializedArguments();
        setUpMockData4test4editPriceDefault();
        setUpMockData4test4editPriceInitializedArguments();
        setUpMockData4test4editPriceTxnDefault();
        setUpMockData4test4editPriceTxnInitializedArguments();
        setUpMockData4test4editPriceImplementationDefault();
        setUpMockData4test4editPriceImplementationInitializedArguments();
        setUpMockData4test4editDescriptionDefault();
        setUpMockData4test4editDescriptionInitializedArguments();
        setUpMockData4test4editDescriptionTxnDefault();
        setUpMockData4test4editDescriptionTxnInitializedArguments();
        setUpMockData4test4editDescriptionImplementationDefault();
        setUpMockData4test4editDescriptionImplementationInitializedArguments();
        setUpMockData4test4clearUnitsDefault();
        setUpMockData4test4clearUnitsInitializedArguments();
        setUpMockData4test4clearUnitsTxnDefault();
        setUpMockData4test4clearUnitsTxnInitializedArguments();
        setUpMockData4test4clearUnitsImplementationDefault();
        setUpMockData4test4clearUnitsImplementationInitializedArguments();
        setUpMockData4test4clearPriceDefault();
        setUpMockData4test4clearPriceInitializedArguments();
        setUpMockData4test4clearPriceTxnDefault();
        setUpMockData4test4clearPriceTxnInitializedArguments();
        setUpMockData4test4clearPriceImplementationDefault();
        setUpMockData4test4clearPriceImplementationInitializedArguments();
        setUpMockData4test4clearDescriptionDefault();
        setUpMockData4test4clearDescriptionInitializedArguments();
        setUpMockData4test4clearDescriptionTxnDefault();
        setUpMockData4test4clearDescriptionTxnInitializedArguments();
        setUpMockData4test4clearDescriptionImplementationDefault();
        setUpMockData4test4clearDescriptionImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("eRTemplateTemplateid");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCTemplateLines() {
        test4getDynamicPopulationByOrderCriteriaOCTemplateLinesArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCTemplateLinesArg1.setDisplaySetItems("eRTemplateTemplateid");
        test4getDynamicPopulationByOrderCriteriaOCTemplateLinesArg1.setOrderCriteriaName("OCTemplateLines");
        test4getDynamicPopulationByOrderCriteriaOCTemplateLinesResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("eRTemplateTemplateid");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)))))));
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
        test4getByIdArg2 = Long.valueOf(0);
        test4getByIdResult = mockERLTemplate.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ERLTemplate();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ERLTemplate();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getERLTemplateDynamic() {
        test4getERLTemplateDynamicArg1 = new ERLTemplateOid();
        test4getERLTemplateDynamicArg2 = "";
        test4getERLTemplateDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ERLTemplateOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateWithoutRemainingPath() {
        test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg1 = new ERTemplateOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg2 = ERLTemplateConstants.ROLE_NAME_TEMPLATE;
        test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateWithRemainingPath() {
        test4buildRelatedInstance4RoleTemplateWithRemainingPathArg1 = new ERTemplateOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateWithRemainingPathArg2 = ERLTemplateConstants.ROLE_NAME_TEMPLATE;
        test4buildRelatedInstance4RoleTemplateWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1 = new ExpenseTypeOid("").toJson();
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2 = ERLTemplateConstants.ROLE_NAME_EXPENSETYPE;
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1 = new ExpenseTypeOid("").toJson();
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2 = ERLTemplateConstants.ROLE_NAME_EXPENSETYPE;
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSTemplateLines() {
        test4getDSTemplateLinesArg1 = "";
        test4getDSTemplateLinesArg2 = "";
        test4getDSTemplateLinesArg3 = "";
        test4getDSTemplateLinesResult = new DSTemplateLines();
    }

    private static void setUpMockData4test4piuPIUTemplateLines() {
        test4piuPIUTemplateLinesArg1 = new QueryRequest();
        test4piuPIUTemplateLinesResult = mockPopulation.stream().map(i -> new DSTemplateLines(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUTemplateLines() {
        test4getCount4PIUTemplateLinesArg1 = new QueryRequest();
        test4getCount4PIUTemplateLinesResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplateInstance(new ERTemplate(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplate()));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseType(new ExpenseTypeOid(""));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseTypeInstance(new ExpenseType(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseType()));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepatrunits(Double.valueOf(0));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepatrprice(Double.valueOf(0));
        test4createinstanceInitializedArgumentsArg1.setERLTemplatecreateinstancepatrdescription("");
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplateInstance(new ERTemplate(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplate()));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseType(new ExpenseTypeOid(""));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseTypeInstance(new ExpenseType(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseType()));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepatrunits(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepatrprice(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsArg1.setERLTemplatecreateinstancepatrdescription("");
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepagrTemplateInstance(new ERTemplate(test4createinstanceImplementationInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplate()));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseType(new ExpenseTypeOid(""));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepagrExpenseTypeInstance(new ExpenseType(test4createinstanceImplementationInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseType()));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepatrunits(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepatrprice(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsArg1.setERLTemplatecreateinstancepatrdescription("");
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4deleteinstanceInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplateInstance(new ERLTemplate(test4deleteinstanceInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplate()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4deleteinstanceTxnInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplateInstance(new ERLTemplate(test4deleteinstanceTxnInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplate()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setERLTemplatedeleteinstancepthisERLTemplateInstance(new ERLTemplate(test4deleteinstanceImplementationInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplate()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplateInstance(new ERLTemplate(test4editinstanceInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplate()));
        test4editinstanceInitializedArgumentsArg1.setERLTemplateeditinstancepunits(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setERLTemplateeditinstancepprice(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setERLTemplateeditinstancepdescription("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplateInstance(new ERLTemplate(test4editinstanceTxnInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplate()));
        test4editinstanceTxnInitializedArgumentsArg1.setERLTemplateeditinstancepunits(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setERLTemplateeditinstancepprice(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setERLTemplateeditinstancepdescription("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setERLTemplateeditinstancepthisERLTemplateInstance(new ERLTemplate(test4editinstanceImplementationInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplate()));
        test4editinstanceImplementationInitializedArgumentsArg1.setERLTemplateeditinstancepunits(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setERLTemplateeditinstancepprice(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setERLTemplateeditinstancepdescription("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUnitsDefault() {
        test4editUnitsDefaultArg1 = new EditUnitsRequest();
    }

    private static void setUpMockData4test4editUnitsInitializedArguments() {
        test4editUnitsInitializedArgumentsArg1 = new EditUnitsRequest();
        test4editUnitsInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editUnitsInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplateInstance(new ERLTemplate(test4editUnitsInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplate()));
        test4editUnitsInitializedArgumentsArg1.setERLTemplateeditUnitspUnits(Double.valueOf(0));
    }

    private static void setUpMockData4test4editUnitsTxnDefault() {
        test4editUnitsTxnDefaultArg1 = new EditUnitsRequest();
        test4editUnitsTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUnitsTxnInitializedArguments() {
        test4editUnitsTxnInitializedArgumentsArg1 = new EditUnitsRequest();
        test4editUnitsTxnInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editUnitsTxnInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplateInstance(new ERLTemplate(test4editUnitsTxnInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplate()));
        test4editUnitsTxnInitializedArgumentsArg1.setERLTemplateeditUnitspUnits(Double.valueOf(0));
        test4editUnitsTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUnitsImplementationDefault() {
        test4editUnitsImplementationDefaultArg1 = new EditUnitsRequest();
        test4editUnitsImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUnitsImplementationInitializedArguments() {
        test4editUnitsImplementationInitializedArgumentsArg1 = new EditUnitsRequest();
        test4editUnitsImplementationInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editUnitsImplementationInitializedArgumentsArg1.setERLTemplateeditUnitspthisERLTemplateInstance(new ERLTemplate(test4editUnitsImplementationInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplate()));
        test4editUnitsImplementationInitializedArgumentsArg1.setERLTemplateeditUnitspUnits(Double.valueOf(0));
        test4editUnitsImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editPriceDefault() {
        test4editPriceDefaultArg1 = new EditPriceRequest();
    }

    private static void setUpMockData4test4editPriceInitializedArguments() {
        test4editPriceInitializedArgumentsArg1 = new EditPriceRequest();
        test4editPriceInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editPriceInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplateInstance(new ERLTemplate(test4editPriceInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplate()));
        test4editPriceInitializedArgumentsArg1.setERLTemplateeditPricepPrice(Double.valueOf(0));
    }

    private static void setUpMockData4test4editPriceTxnDefault() {
        test4editPriceTxnDefaultArg1 = new EditPriceRequest();
        test4editPriceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editPriceTxnInitializedArguments() {
        test4editPriceTxnInitializedArgumentsArg1 = new EditPriceRequest();
        test4editPriceTxnInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editPriceTxnInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplateInstance(new ERLTemplate(test4editPriceTxnInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplate()));
        test4editPriceTxnInitializedArgumentsArg1.setERLTemplateeditPricepPrice(Double.valueOf(0));
        test4editPriceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editPriceImplementationDefault() {
        test4editPriceImplementationDefaultArg1 = new EditPriceRequest();
        test4editPriceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editPriceImplementationInitializedArguments() {
        test4editPriceImplementationInitializedArgumentsArg1 = new EditPriceRequest();
        test4editPriceImplementationInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editPriceImplementationInitializedArgumentsArg1.setERLTemplateeditPricepthisERLTemplateInstance(new ERLTemplate(test4editPriceImplementationInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplate()));
        test4editPriceImplementationInitializedArgumentsArg1.setERLTemplateeditPricepPrice(Double.valueOf(0));
        test4editPriceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionDefault() {
        test4editDescriptionDefaultArg1 = new EditDescriptionRequest();
    }

    private static void setUpMockData4test4editDescriptionInitializedArguments() {
        test4editDescriptionInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editDescriptionInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplateInstance(new ERLTemplate(test4editDescriptionInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplate()));
        test4editDescriptionInitializedArgumentsArg1.setERLTemplateeditDescriptionpDescription("");
    }

    private static void setUpMockData4test4editDescriptionTxnDefault() {
        test4editDescriptionTxnDefaultArg1 = new EditDescriptionRequest();
        test4editDescriptionTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionTxnInitializedArguments() {
        test4editDescriptionTxnInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionTxnInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editDescriptionTxnInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplateInstance(new ERLTemplate(test4editDescriptionTxnInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplate()));
        test4editDescriptionTxnInitializedArgumentsArg1.setERLTemplateeditDescriptionpDescription("");
        test4editDescriptionTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionImplementationDefault() {
        test4editDescriptionImplementationDefaultArg1 = new EditDescriptionRequest();
        test4editDescriptionImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editDescriptionImplementationInitializedArguments() {
        test4editDescriptionImplementationInitializedArgumentsArg1 = new EditDescriptionRequest();
        test4editDescriptionImplementationInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4editDescriptionImplementationInitializedArgumentsArg1.setERLTemplateeditDescriptionpthisERLTemplateInstance(new ERLTemplate(test4editDescriptionImplementationInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplate()));
        test4editDescriptionImplementationInitializedArgumentsArg1.setERLTemplateeditDescriptionpDescription("");
        test4editDescriptionImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearUnitsDefault() {
        test4clearUnitsDefaultArg1 = new ClearUnitsRequest();
    }

    private static void setUpMockData4test4clearUnitsInitializedArguments() {
        test4clearUnitsInitializedArgumentsArg1 = new ClearUnitsRequest();
        test4clearUnitsInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearUnitsInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplateInstance(new ERLTemplate(test4clearUnitsInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplate()));
    }

    private static void setUpMockData4test4clearUnitsTxnDefault() {
        test4clearUnitsTxnDefaultArg1 = new ClearUnitsRequest();
        test4clearUnitsTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearUnitsTxnInitializedArguments() {
        test4clearUnitsTxnInitializedArgumentsArg1 = new ClearUnitsRequest();
        test4clearUnitsTxnInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearUnitsTxnInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplateInstance(new ERLTemplate(test4clearUnitsTxnInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplate()));
        test4clearUnitsTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearUnitsImplementationDefault() {
        test4clearUnitsImplementationDefaultArg1 = new ClearUnitsRequest();
        test4clearUnitsImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearUnitsImplementationInitializedArguments() {
        test4clearUnitsImplementationInitializedArgumentsArg1 = new ClearUnitsRequest();
        test4clearUnitsImplementationInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearUnitsImplementationInitializedArgumentsArg1.setERLTemplateclearUnitspthisERLTemplateInstance(new ERLTemplate(test4clearUnitsImplementationInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplate()));
        test4clearUnitsImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearPriceDefault() {
        test4clearPriceDefaultArg1 = new ClearPriceRequest();
    }

    private static void setUpMockData4test4clearPriceInitializedArguments() {
        test4clearPriceInitializedArgumentsArg1 = new ClearPriceRequest();
        test4clearPriceInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearPriceInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplateInstance(new ERLTemplate(test4clearPriceInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplate()));
    }

    private static void setUpMockData4test4clearPriceTxnDefault() {
        test4clearPriceTxnDefaultArg1 = new ClearPriceRequest();
        test4clearPriceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearPriceTxnInitializedArguments() {
        test4clearPriceTxnInitializedArgumentsArg1 = new ClearPriceRequest();
        test4clearPriceTxnInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearPriceTxnInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplateInstance(new ERLTemplate(test4clearPriceTxnInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplate()));
        test4clearPriceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearPriceImplementationDefault() {
        test4clearPriceImplementationDefaultArg1 = new ClearPriceRequest();
        test4clearPriceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearPriceImplementationInitializedArguments() {
        test4clearPriceImplementationInitializedArgumentsArg1 = new ClearPriceRequest();
        test4clearPriceImplementationInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearPriceImplementationInitializedArgumentsArg1.setERLTemplateclearPricepthisERLTemplateInstance(new ERLTemplate(test4clearPriceImplementationInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplate()));
        test4clearPriceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionDefault() {
        test4clearDescriptionDefaultArg1 = new ClearDescriptionRequest();
    }

    private static void setUpMockData4test4clearDescriptionInitializedArguments() {
        test4clearDescriptionInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearDescriptionInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplateInstance(new ERLTemplate(test4clearDescriptionInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplate()));
    }

    private static void setUpMockData4test4clearDescriptionTxnDefault() {
        test4clearDescriptionTxnDefaultArg1 = new ClearDescriptionRequest();
        test4clearDescriptionTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionTxnInitializedArguments() {
        test4clearDescriptionTxnInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionTxnInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearDescriptionTxnInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplateInstance(new ERLTemplate(test4clearDescriptionTxnInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplate()));
        test4clearDescriptionTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionImplementationDefault() {
        test4clearDescriptionImplementationDefaultArg1 = new ClearDescriptionRequest();
        test4clearDescriptionImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4clearDescriptionImplementationInitializedArguments() {
        test4clearDescriptionImplementationInitializedArgumentsArg1 = new ClearDescriptionRequest();
        test4clearDescriptionImplementationInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        test4clearDescriptionImplementationInitializedArgumentsArg1.setERLTemplateclearDescriptionpthisERLTemplateInstance(new ERLTemplate(test4clearDescriptionImplementationInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplate()));
        test4clearDescriptionImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceERLTemplateService, "eRLTemplateSrv", instanceERLTemplateService);

        when(mockERTemplateService.getByOIDWithHV(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplate())).thenReturn(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplateInstance());

        when(mockExpenseTypeService.getByOIDWithHV(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseType())).thenReturn(test4createinstanceInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseTypeInstance());

        when(mockERTemplateService.getByOIDWithHV(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplate())).thenReturn(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrTemplateInstance());

        when(mockExpenseTypeService.getByOIDWithHV(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseType())).thenReturn(test4createinstanceTxnInitializedArgumentsArg1.getERLTemplatecreateinstancepagrExpenseTypeInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplate())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplate())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getERLTemplatedeleteinstancepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplate())).thenReturn(test4editinstanceInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplate())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getERLTemplateeditinstancepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editUnitsInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplate())).thenReturn(test4editUnitsInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editUnitsTxnInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplate())).thenReturn(test4editUnitsTxnInitializedArgumentsArg1.getERLTemplateeditUnitspthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editPriceInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplate())).thenReturn(test4editPriceInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editPriceTxnInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplate())).thenReturn(test4editPriceTxnInitializedArgumentsArg1.getERLTemplateeditPricepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editDescriptionInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplate())).thenReturn(test4editDescriptionInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4editDescriptionTxnInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplate())).thenReturn(test4editDescriptionTxnInitializedArgumentsArg1.getERLTemplateeditDescriptionpthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearUnitsInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplate())).thenReturn(test4clearUnitsInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearUnitsTxnInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplate())).thenReturn(test4clearUnitsTxnInitializedArgumentsArg1.getERLTemplateclearUnitspthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearPriceInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplate())).thenReturn(test4clearPriceInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearPriceTxnInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplate())).thenReturn(test4clearPriceTxnInitializedArgumentsArg1.getERLTemplateclearPricepthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearDescriptionInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplate())).thenReturn(test4clearDescriptionInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplateInstance());

        when(mockERLTemplateService.getByOIDWithHV(test4clearDescriptionTxnInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplate())).thenReturn(test4clearDescriptionTxnInitializedArgumentsArg1.getERLTemplateclearDescriptionpthisERLTemplateInstance());

        when(mockRepository.findById(mockERLTemplateOid)).thenAnswer(new Answer<Optional<ERLTemplate>>(){
        	public Optional<ERLTemplate> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockERLTemplateOid)) {
        			return mockERLTemplate;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ERLTemplate.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceERLTemplateService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceERLTemplateService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceERLTemplateService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceERLTemplateService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceERLTemplateService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCTemplateLines() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCTemplateLinesResult), getResult(TOTALITEMS, instanceERLTemplateService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCTemplateLinesArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceERLTemplateService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceERLTemplateService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceERLTemplateService.getById(test4getByIdArg1, test4getByIdArg2));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceERLTemplateService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceERLTemplateService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getERLTemplateDynamic() {
        assertEquals(test4getERLTemplateDynamicResult.getResultCode(), instanceERLTemplateService.getERLTemplateDynamic(test4getERLTemplateDynamicArg1, test4getERLTemplateDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceERLTemplateService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceERLTemplateService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateWithoutRemainingPath() {
        instanceERLTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg1, test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg2, test4buildRelatedInstance4RoleTemplateWithoutRemainingPathArg3);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateWithRemainingPath() {
        instanceERLTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateWithRemainingPathArg1, test4buildRelatedInstance4RoleTemplateWithRemainingPathArg2, test4buildRelatedInstance4RoleTemplateWithRemainingPathArg3);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath() {
        instanceERLTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath() {
        instanceERLTemplateService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4getDSTemplateLines() {
        assertEquals(test4getDSTemplateLinesResult.getClass(), instanceERLTemplateService.getDSTemplateLines(test4getDSTemplateLinesArg1, test4getDSTemplateLinesArg2, test4getDSTemplateLinesArg3).getClass());
    }

    @Test
    public void test4piuPIUTemplateLines() {
        instanceERLTemplateService.piuPIUTemplateLines(test4piuPIUTemplateLinesArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4getCount4PIUTemplateLines() {
        instanceERLTemplateService.getCount4PIUTemplateLines(test4getCount4PIUTemplateLinesArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceERLTemplateService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceERLTemplateService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceERLTemplateService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceERLTemplateService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceERLTemplateService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceERLTemplateService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUnitsDefault() {
        instanceERLTemplateService.editUnits(test4editUnitsDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editUnitsInitializedArguments() {
        instanceERLTemplateService.editUnits(test4editUnitsInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editUnitsTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editUnitsTxn(test4editUnitsTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editUnitsTxnDefaultResult;
        }
        assertEquals(test4editUnitsTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUnitsTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editUnitsTxn(test4editUnitsTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editUnitsTxnInitializedArgumentsResult;
        }
        assertEquals(test4editUnitsTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUnitsImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editUnitsImplementation(test4editUnitsImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editUnitsImplementationDefaultResult;
        }
        assertEquals(test4editUnitsImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUnitsImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editUnitsImplementation(test4editUnitsImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editUnitsImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editUnitsImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editPriceDefault() {
        instanceERLTemplateService.editPrice(test4editPriceDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editPriceInitializedArguments() {
        instanceERLTemplateService.editPrice(test4editPriceInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editPriceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editPriceTxn(test4editPriceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editPriceTxnDefaultResult;
        }
        assertEquals(test4editPriceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editPriceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editPriceTxn(test4editPriceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editPriceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editPriceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editPriceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editPriceImplementation(test4editPriceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editPriceImplementationDefaultResult;
        }
        assertEquals(test4editPriceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editPriceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editPriceImplementation(test4editPriceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editPriceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editPriceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionDefault() {
        instanceERLTemplateService.editDescription(test4editDescriptionDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editDescriptionInitializedArguments() {
        instanceERLTemplateService.editDescription(test4editDescriptionInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4editDescriptionTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editDescriptionTxn(test4editDescriptionTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editDescriptionTxnDefaultResult;
        }
        assertEquals(test4editDescriptionTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editDescriptionTxn(test4editDescriptionTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editDescriptionTxnInitializedArgumentsResult;
        }
        assertEquals(test4editDescriptionTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editDescriptionImplementation(test4editDescriptionImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editDescriptionImplementationDefaultResult;
        }
        assertEquals(test4editDescriptionImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editDescriptionImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.editDescriptionImplementation(test4editDescriptionImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editDescriptionImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editDescriptionImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearUnitsDefault() {
        instanceERLTemplateService.clearUnits(test4clearUnitsDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearUnitsInitializedArguments() {
        instanceERLTemplateService.clearUnits(test4clearUnitsInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearUnitsTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearUnitsTxn(test4clearUnitsTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4clearUnitsTxnDefaultResult;
        }
        assertEquals(test4clearUnitsTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearUnitsTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearUnitsTxn(test4clearUnitsTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearUnitsTxnInitializedArgumentsResult;
        }
        assertEquals(test4clearUnitsTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearUnitsImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearUnitsImplementation(test4clearUnitsImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4clearUnitsImplementationDefaultResult;
        }
        assertEquals(test4clearUnitsImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearUnitsImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearUnitsImplementation(test4clearUnitsImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearUnitsImplementationInitializedArgumentsResult;
        }
        assertEquals(test4clearUnitsImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearPriceDefault() {
        instanceERLTemplateService.clearPrice(test4clearPriceDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearPriceInitializedArguments() {
        instanceERLTemplateService.clearPrice(test4clearPriceInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearPriceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearPriceTxn(test4clearPriceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4clearPriceTxnDefaultResult;
        }
        assertEquals(test4clearPriceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearPriceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearPriceTxn(test4clearPriceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearPriceTxnInitializedArgumentsResult;
        }
        assertEquals(test4clearPriceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearPriceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearPriceImplementation(test4clearPriceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4clearPriceImplementationDefaultResult;
        }
        assertEquals(test4clearPriceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearPriceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearPriceImplementation(test4clearPriceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearPriceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4clearPriceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionDefault() {
        instanceERLTemplateService.clearDescription(test4clearDescriptionDefaultArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearDescriptionInitializedArguments() {
        instanceERLTemplateService.clearDescription(test4clearDescriptionInitializedArgumentsArg1);
        assertNotNull(instanceERLTemplateService);
    }

    @Test
    public void test4clearDescriptionTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearDescriptionTxn(test4clearDescriptionTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4clearDescriptionTxnDefaultResult;
        }
        assertEquals(test4clearDescriptionTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearDescriptionTxn(test4clearDescriptionTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearDescriptionTxnInitializedArgumentsResult;
        }
        assertEquals(test4clearDescriptionTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearDescriptionImplementation(test4clearDescriptionImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4clearDescriptionImplementationDefaultResult;
        }
        assertEquals(test4clearDescriptionImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4clearDescriptionImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceERLTemplateService.clearDescriptionImplementation(test4clearDescriptionImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4clearDescriptionImplementationInitializedArgumentsResult;
        }
        assertEquals(test4clearDescriptionImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
