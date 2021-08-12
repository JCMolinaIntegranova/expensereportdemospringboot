package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest;
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
public class ProjectServiceTest extends ClassTest {

    @InjectMocks
    private ProjectService instanceProjectService;
    
    @Mock
    private static ProjectJpaRepository mockRepository;
    
    @Mock
    private static ProjectService mockProjectService;
    
    @Mock
    private static TeamService mockTeamService;
    
    @Mock
    private static ERTemplateService mockERTemplateService;
    
    @Mock
    private static AssignmentService mockAssignmentService;
    
    @Mock
    private static EmployeeService mockEmployeeService;
    
    @Mock
    private static ExpenseCurrencyService mockExpenseCurrencyService;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;

    private static Project mockInstance1;
    
    private static Project mockInstance2;

    private static List<Project> mockPopulation;

    private static Long mockprojectidProject;

    private static Optional<Project> mockProject; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<Project> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<Project> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFProjects_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFProjects_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFProjects_NoFVarsResult;

    // test4getDynamicPopulationByFilterFProjects_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFProjects_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFProjects_WithFVarsResult;

    // test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2
    private static QueryRequest test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Arg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Result;

    // test4getDynamicPopulationByOrderCriteriaOCProject
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCProjectArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCProjectResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSProject
    private static QueryRequest test4getDynamicPreload4DSProjectArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSProjectResult;

    // test4getDynamicPreload4DSProjectSup
    private static QueryRequest test4getDynamicPreload4DSProjectSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSProjectSupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static Long test4getByIdArg1;
    private static Project test4getByIdResult;

    // test4getByRelated
    private static Project test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<Project> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static Project test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<Project> test4getInstancesByRelatedResult;

    // test4getProjectDynamic
    private static ProjectOid test4getProjectDynamicArg1;
    private static String test4getProjectDynamicArg2;
    private static InstanceResponseViewModel test4getProjectDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ProjectOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ProjectOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSProjectSup
    private static ProjectOid test4getSuppInfoWithDSDSProjectSupArg1;
    private static String test4getSuppInfoWithDSDSProjectSupArg2;

    // test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleAssignmentsWithRemainingPath
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleTeamWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleTeamWithRemainingPath
    private static String test4buildRelatedInstance4RoleTeamWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTeamWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTeamWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleERTemplatesWithRemainingPath
    private static String test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg3;

    // test4getDSProject
    private static String test4getDSProjectArg1;
    private static String test4getDSProjectArg2;
    private static String test4getDSProjectArg3;
    private static DSProject test4getDSProjectResult;

    // test4getPreloadDSProject
    private static QueryRequest test4getPreloadDSProjectArg1;
    private static List<PreloadViewModel> test4getPreloadDSProjectResult;

    // test4getDSProjectSup
    private static String test4getDSProjectSupArg1;
    private static String test4getDSProjectSupArg2;
    private static String test4getDSProjectSupArg3;
    private static DSProjectSup test4getDSProjectSupResult;

    // test4getPreloadDSProjectSup
    private static QueryRequest test4getPreloadDSProjectSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSProjectSupResult;

    // test4iIUProject
    private static ProjectOid test4iIUProjectArg1;
    private static DSProject test4iIUProjectResult;

    // test4iIUProjectReports
    private static ProjectOid test4iIUProjectReportsArg1;
    private static DSProject test4iIUProjectReportsResult;

    // test4piuPIUProject
    private static QueryRequest test4piuPIUProjectArg1;
    private static List<DSProject> test4piuPIUProjectResult;

    // test4getCount4PIUProject
    private static QueryRequest test4getCount4PIUProjectArg1;
    private static int test4getCount4PIUProjectResult;

    // test4piuPIUProjectWithFilterFProjects_NoFVars
    private static QueryRequest test4piuPIUProjectWithFilterFProjects_NoFVarsArg1;
    private static List<DSProject> test4piuPIUProjectWithFilterFProjects_NoFVarsResult;

    // test4piuPIUProjectWithFilterFProjects_WithFVars
    private static QueryRequest test4piuPIUProjectWithFilterFProjects_WithFVarsArg1;
    private static List<DSProject> test4piuPIUProjectWithFilterFProjects_WithFVarsResult;

    // test4piuSELProject
    private static QueryRequest test4piuSELProjectArg1;
    private static List<DSProject> test4piuSELProjectResult;

    // test4getCount4SELProject
    private static QueryRequest test4getCount4SELProjectArg1;
    private static int test4getCount4SELProjectResult;

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

    // test4markAsCompletedDefault
    private static MarkAsCompletedRequest test4markAsCompletedDefaultArg1;

    // test4markAsCompletedInitializedArguments
    private static MarkAsCompletedRequest test4markAsCompletedInitializedArgumentsArg1;

    // test4markAsCompletedTxnDefault
    private static MarkAsCompletedRequest test4markAsCompletedTxnDefaultArg1;
    private static ServiceResponse test4markAsCompletedTxnDefaultResult;

    // test4markAsCompletedTxnInitializedArguments
    private static MarkAsCompletedRequest test4markAsCompletedTxnInitializedArgumentsArg1;
    private static ServiceResponse test4markAsCompletedTxnInitializedArgumentsResult;

    // test4markAsCompletedImplementationDefault
    private static MarkAsCompletedRequest test4markAsCompletedImplementationDefaultArg1;
    private static ServiceResponse test4markAsCompletedImplementationDefaultResult;

    // test4markAsCompletedImplementationInitializedArguments
    private static MarkAsCompletedRequest test4markAsCompletedImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4markAsCompletedImplementationInitializedArgumentsResult;

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

    // test4tCOMPLETEDefault
    private static TCOMPLETERequest test4tCOMPLETEDefaultArg1;

    // test4tCOMPLETEInitializedArguments
    private static TCOMPLETERequest test4tCOMPLETEInitializedArgumentsArg1;

    // test4tCOMPLETETxnDefault
    private static TCOMPLETERequest test4tCOMPLETETxnDefaultArg1;
    private static ServiceResponse test4tCOMPLETETxnDefaultResult;

    // test4tCOMPLETETxnInitializedArguments
    private static TCOMPLETERequest test4tCOMPLETETxnInitializedArgumentsArg1;
    private static ServiceResponse test4tCOMPLETETxnInitializedArgumentsResult;

    // test4tCOMPLETEImplementationDefault
    private static TCOMPLETERequest test4tCOMPLETEImplementationDefaultArg1;
    private static ServiceResponse test4tCOMPLETEImplementationDefaultResult;

    // test4tCOMPLETEImplementationInitializedArguments
    private static TCOMPLETERequest test4tCOMPLETEImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tCOMPLETEImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockprojectidProject = Long.valueOf(0);
        mockInstance1 = new Project();
        mockInstance2 = new Project();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockProject = Optional.of(new Project(new ProjectOid(mockprojectidProject)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFProjects_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFProjects_WithFVars();
        setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCProject();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSProject();
        setUpMockData4test4getDynamicPreload4DSProjectSup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getProjectDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSProjectSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTeamWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTeamWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleERTemplatesWithRemainingPath();
        setUpMockData4test4getDSProject();
        setUpMockData4test4getPreloadDSProject();
        setUpMockData4test4getDSProjectSup();
        setUpMockData4test4getPreloadDSProjectSup();
        setUpMockData4test4iIUProject();
        setUpMockData4test4iIUProjectReports();
        setUpMockData4test4piuPIUProject();
        setUpMockData4test4getCount4PIUProject();
        setUpMockData4test4piuPIUProjectWithFilterFProjects_NoFVars();
        setUpMockData4test4piuPIUProjectWithFilterFProjects_WithFVars();
        setUpMockData4test4piuSELProject();
        setUpMockData4test4getCount4SELProject();
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
        setUpMockData4test4markAsCompletedDefault();
        setUpMockData4test4markAsCompletedInitializedArguments();
        setUpMockData4test4markAsCompletedTxnDefault();
        setUpMockData4test4markAsCompletedTxnInitializedArguments();
        setUpMockData4test4markAsCompletedImplementationDefault();
        setUpMockData4test4markAsCompletedImplementationInitializedArguments();
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
        setUpMockData4test4tCOMPLETEDefault();
        setUpMockData4test4tCOMPLETEInitializedArguments();
        setUpMockData4test4tCOMPLETETxnDefault();
        setUpMockData4test4tCOMPLETETxnInitializedArguments();
        setUpMockData4test4tCOMPLETEImplementationDefault();
        setUpMockData4test4tCOMPLETEImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFProjects_NoFVars() {
        test4getDynamicPopulationByFilterFProjects_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFProjects_NoFVarsArg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationByFilterFProjects_NoFVarsArg1.addFilterRequest(new FilterRequest(ProjectConstants.FILTER_NAME_FPROJECTS,new ArrayList<>()));
        test4getDynamicPopulationByFilterFProjects_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFProjects_WithFVars() {
        test4getDynamicPopulationByFilterFProjects_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFProjects_WithFVarsArg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationByFilterFProjects_WithFVarsArg1.addFilterRequest(new FilterRequest(ProjectConstants.FILTER_NAME_FPROJECTS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ProjectConstants.VAR_NAME_FPROJECTS_VNAME, ""), new FilterVariableRequest(ProjectConstants.VAR_NAME_FPROJECTS_VCOMPLETED, false)))));
        test4getDynamicPopulationByFilterFProjects_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2() {
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Arg1 = new QueryRequest();
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Arg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Arg1.addFilterRequest(new FilterRequest("ExpenseReport_TNEW_pt_p_agrProject_NavFilter0",new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE, new Employee()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY, new ExpenseCurrency()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT, new Project()), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE)), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE, ""), new FilterVariableRequest(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES, Double.valueOf(0))))));
        test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Result = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCProject() {
        test4getDynamicPopulationByOrderCriteriaOCProjectArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCProjectArg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationByOrderCriteriaOCProjectArg1.setOrderCriteriaName("OCProject");
        test4getDynamicPopulationByOrderCriteriaOCProjectResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("projectidProject");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ProjectOid(Long.valueOf(0)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSProject() {
        test4getDynamicPreload4DSProjectArg1 = new QueryRequest();
        test4getDynamicPreload4DSProjectArg1.setDisplaySetName(ProjectConstants.DSDSPROJECT);
        test4getDynamicPreload4DSProjectResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ProjectService.buildPreloadViewModel(i, test4getDynamicPreload4DSProjectArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSProjectSup() {
        test4getDynamicPreload4DSProjectSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSProjectSupArg1.setDisplaySetName(ProjectConstants.DSDSPROJECTSUP);
        test4getDynamicPreload4DSProjectSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ProjectService.buildPreloadViewModel(i, test4getDynamicPreload4DSProjectSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = Long.valueOf(0);
        test4getByIdResult = mockProject.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new Project();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new Project();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getProjectDynamic() {
        test4getProjectDynamicArg1 = new ProjectOid();
        test4getProjectDynamicArg2 = "";
        test4getProjectDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ProjectOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ProjectOid(Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSProjectSup() {
        test4getSuppInfoWithDSDSProjectSupArg1 = new ProjectOid(Long.valueOf(0));
        test4getSuppInfoWithDSDSProjectSupArg2 = ProjectConstants.DSDSPROJECTSUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2 = ProjectConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2 = ProjectConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1 = new AssignmentOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2 = ProjectConstants.ROLE_NAME_ASSIGNMENTS;
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithRemainingPath() {
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1 = new AssignmentOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2 = ProjectConstants.ROLE_NAME_ASSIGNMENTS;
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTeamWithoutRemainingPath() {
        test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg1 = new TeamOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg2 = ProjectConstants.ROLE_NAME_TEAM;
        test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTeamWithRemainingPath() {
        test4buildRelatedInstance4RoleTeamWithRemainingPathArg1 = new TeamOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTeamWithRemainingPathArg2 = ProjectConstants.ROLE_NAME_TEAM;
        test4buildRelatedInstance4RoleTeamWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg1 = new ERTemplateOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg2 = ProjectConstants.ROLE_NAME_ERTEMPLATES;
        test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleERTemplatesWithRemainingPath() {
        test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg1 = new ERTemplateOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg2 = ProjectConstants.ROLE_NAME_ERTEMPLATES;
        test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSProject() {
        test4getDSProjectArg1 = "";
        test4getDSProjectArg2 = "";
        test4getDSProjectArg3 = "";
        test4getDSProjectResult = new DSProject();
    }

    private static void setUpMockData4test4getPreloadDSProject() {
        test4getPreloadDSProjectArg1 = new QueryRequest();
        test4getPreloadDSProjectArg1.setDisplaySetName(ProjectConstants.DSDSPROJECT);
        test4getPreloadDSProjectResult = mockPopulation.stream().map(i -> ProjectService.buildPreloadViewModel(i, test4getPreloadDSProjectArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSProjectSup() {
        test4getDSProjectSupArg1 = "";
        test4getDSProjectSupArg2 = "";
        test4getDSProjectSupArg3 = "";
        test4getDSProjectSupResult = new DSProjectSup();
    }

    private static void setUpMockData4test4getPreloadDSProjectSup() {
        test4getPreloadDSProjectSupArg1 = new QueryRequest();
        test4getPreloadDSProjectSupArg1.setDisplaySetName(ProjectConstants.DSDSPROJECTSUP);
        test4getPreloadDSProjectSupResult = mockPopulation.stream().map(i -> ProjectService.buildPreloadViewModel(i, test4getPreloadDSProjectSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUProject() {
        test4iIUProjectArg1 = new ProjectOid();
        test4iIUProjectResult = new DSProject();
    }

    private static void setUpMockData4test4iIUProjectReports() {
        test4iIUProjectReportsArg1 = new ProjectOid();
        test4iIUProjectReportsResult = new DSProject();
    }

    private static void setUpMockData4test4piuPIUProject() {
        test4piuPIUProjectArg1 = new QueryRequest();
        test4piuPIUProjectResult = mockPopulation.stream().map(i -> new DSProject(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUProject() {
        test4getCount4PIUProjectArg1 = new QueryRequest();
        test4getCount4PIUProjectResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUProjectWithFilterFProjects_NoFVars() {
        test4piuPIUProjectWithFilterFProjects_NoFVarsArg1 = new QueryRequest();
        test4piuPIUProjectWithFilterFProjects_NoFVarsArg1.addFilterRequest(new FilterRequest(ProjectConstants.FILTER_NAME_FPROJECTS,new ArrayList<>()));
        test4piuPIUProjectWithFilterFProjects_NoFVarsResult = mockPopulation.stream().map(i -> new DSProject(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUProjectWithFilterFProjects_WithFVars() {
        test4piuPIUProjectWithFilterFProjects_WithFVarsArg1 = new QueryRequest();
        test4piuPIUProjectWithFilterFProjects_WithFVarsArg1.addFilterRequest(new FilterRequest(ProjectConstants.FILTER_NAME_FPROJECTS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ProjectConstants.VAR_NAME_FPROJECTS_VNAME, ""), new FilterVariableRequest(ProjectConstants.VAR_NAME_FPROJECTS_VCOMPLETED, false)))));
        test4piuPIUProjectWithFilterFProjects_WithFVarsResult = mockPopulation.stream().map(i -> new DSProject(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuSELProject() {
        test4piuSELProjectArg1 = new QueryRequest();
        test4piuSELProjectResult = mockPopulation.stream().map(i -> new DSProject(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4SELProject() {
        test4getCount4SELProjectArg1 = new QueryRequest();
        test4getCount4SELProjectResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setProjectcreateinstancepagrTeam(new TeamOid(Long.valueOf(0)));
        test4createinstanceInitializedArgumentsArg1.setProjectcreateinstancepagrTeamInstance(new Team(test4createinstanceInitializedArgumentsArg1.getProjectcreateinstancepagrTeam()));
        test4createinstanceInitializedArgumentsArg1.setProjectcreateinstancepatrProjectName("");
        test4createinstanceInitializedArgumentsArg1.setProjectcreateinstancepatrProDescription("");
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setProjectcreateinstancepagrTeam(new TeamOid(Long.valueOf(0)));
        test4createinstanceTxnInitializedArgumentsArg1.setProjectcreateinstancepagrTeamInstance(new Team(test4createinstanceTxnInitializedArgumentsArg1.getProjectcreateinstancepagrTeam()));
        test4createinstanceTxnInitializedArgumentsArg1.setProjectcreateinstancepatrProjectName("");
        test4createinstanceTxnInitializedArgumentsArg1.setProjectcreateinstancepatrProDescription("");
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setProjectcreateinstancepagrTeam(new TeamOid(Long.valueOf(0)));
        test4createinstanceImplementationInitializedArgumentsArg1.setProjectcreateinstancepagrTeamInstance(new Team(test4createinstanceImplementationInitializedArgumentsArg1.getProjectcreateinstancepagrTeam()));
        test4createinstanceImplementationInitializedArgumentsArg1.setProjectcreateinstancepatrProjectName("");
        test4createinstanceImplementationInitializedArgumentsArg1.setProjectcreateinstancepatrProDescription("");
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setProjectdeleteinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deleteinstanceInitializedArgumentsArg1.setProjectdeleteinstancepthisProjectInstance(new Project(test4deleteinstanceInitializedArgumentsArg1.getProjectdeleteinstancepthisProject()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setProjectdeleteinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deleteinstanceTxnInitializedArgumentsArg1.setProjectdeleteinstancepthisProjectInstance(new Project(test4deleteinstanceTxnInitializedArgumentsArg1.getProjectdeleteinstancepthisProject()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setProjectdeleteinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setProjectdeleteinstancepthisProjectInstance(new Project(test4deleteinstanceImplementationInitializedArgumentsArg1.getProjectdeleteinstancepthisProject()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setProjecteditinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setProjecteditinstancepthisProjectInstance(new Project(test4editinstanceInitializedArgumentsArg1.getProjecteditinstancepthisProject()));
        test4editinstanceInitializedArgumentsArg1.setProjecteditinstancepProjectName("");
        test4editinstanceInitializedArgumentsArg1.setProjecteditinstancepProDescription("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setProjecteditinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setProjecteditinstancepthisProjectInstance(new Project(test4editinstanceTxnInitializedArgumentsArg1.getProjecteditinstancepthisProject()));
        test4editinstanceTxnInitializedArgumentsArg1.setProjecteditinstancepProjectName("");
        test4editinstanceTxnInitializedArgumentsArg1.setProjecteditinstancepProDescription("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setProjecteditinstancepthisProject(new ProjectOid(Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setProjecteditinstancepthisProjectInstance(new Project(test4editinstanceImplementationInitializedArgumentsArg1.getProjecteditinstancepthisProject()));
        test4editinstanceImplementationInitializedArgumentsArg1.setProjecteditinstancepProjectName("");
        test4editinstanceImplementationInitializedArgumentsArg1.setProjecteditinstancepProDescription("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4markAsCompletedDefault() {
        test4markAsCompletedDefaultArg1 = new MarkAsCompletedRequest();
    }

    private static void setUpMockData4test4markAsCompletedInitializedArguments() {
        test4markAsCompletedInitializedArgumentsArg1 = new MarkAsCompletedRequest();
        test4markAsCompletedInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProject(new ProjectOid(Long.valueOf(0)));
        test4markAsCompletedInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProjectInstance(new Project(test4markAsCompletedInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProject()));
        test4markAsCompletedInitializedArgumentsArg1.setProjectmarkAsCompletedpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    private static void setUpMockData4test4markAsCompletedTxnDefault() {
        test4markAsCompletedTxnDefaultArg1 = new MarkAsCompletedRequest();
        test4markAsCompletedTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4markAsCompletedTxnInitializedArguments() {
        test4markAsCompletedTxnInitializedArgumentsArg1 = new MarkAsCompletedRequest();
        test4markAsCompletedTxnInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProject(new ProjectOid(Long.valueOf(0)));
        test4markAsCompletedTxnInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProjectInstance(new Project(test4markAsCompletedTxnInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProject()));
        test4markAsCompletedTxnInitializedArgumentsArg1.setProjectmarkAsCompletedpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4markAsCompletedTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4markAsCompletedImplementationDefault() {
        test4markAsCompletedImplementationDefaultArg1 = new MarkAsCompletedRequest();
        test4markAsCompletedImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4markAsCompletedImplementationInitializedArguments() {
        test4markAsCompletedImplementationInitializedArgumentsArg1 = new MarkAsCompletedRequest();
        test4markAsCompletedImplementationInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProject(new ProjectOid(Long.valueOf(0)));
        test4markAsCompletedImplementationInitializedArgumentsArg1.setProjectmarkAsCompletedpthisProjectInstance(new Project(test4markAsCompletedImplementationInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProject()));
        test4markAsCompletedImplementationInitializedArgumentsArg1.setProjectmarkAsCompletedpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4markAsCompletedImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectDefault() {
        test4assignTemplateToProjectDefaultArg1 = new AssignTemplateToProjectRequest();
    }

    private static void setUpMockData4test4assignTemplateToProjectInitializedArguments() {
        test4assignTemplateToProjectInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProjectInstance(new Project(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProject()));
        test4assignTemplateToProjectInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplateInstance(new ERTemplate(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplate()));
    }

    private static void setUpMockData4test4assignTemplateToProjectTxnDefault() {
        test4assignTemplateToProjectTxnDefaultArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectTxnInitializedArguments() {
        test4assignTemplateToProjectTxnInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProjectInstance(new Project(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProject()));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectTxnInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplateInstance(new ERTemplate(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplate()));
        test4assignTemplateToProjectTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectImplementationDefault() {
        test4assignTemplateToProjectImplementationDefaultArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectImplementationDefaultArg2 = true;
        test4assignTemplateToProjectImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4assignTemplateToProjectImplementationInitializedArguments() {
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1 = new AssignTemplateToProjectRequest();
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProject(new ProjectOid(Long.valueOf(0)));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setProjectassignTemplateToProjectpthisProjectInstance(new Project(test4assignTemplateToProjectImplementationInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProject()));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg1.setProjectassignTemplateToProjectpevcERTemplateInstance(new ERTemplate(test4assignTemplateToProjectImplementationInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplate()));
        test4assignTemplateToProjectImplementationInitializedArgumentsArg2 = true;
        test4assignTemplateToProjectImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateDefault() {
        test4deassignTemplateDefaultArg1 = new DeassignTemplateRequest();
    }

    private static void setUpMockData4test4deassignTemplateInitializedArguments() {
        test4deassignTemplateInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateInitializedArgumentsArg1.setProjectdeassignTemplatepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateInitializedArgumentsArg1.setProjectdeassignTemplatepthisProjectInstance(new Project(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepthisProject()));
        test4deassignTemplateInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplateInstance(new ERTemplate(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplate()));
    }

    private static void setUpMockData4test4deassignTemplateTxnDefault() {
        test4deassignTemplateTxnDefaultArg1 = new DeassignTemplateRequest();
        test4deassignTemplateTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateTxnInitializedArguments() {
        test4deassignTemplateTxnInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateTxnInitializedArgumentsArg1.setProjectdeassignTemplatepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateTxnInitializedArgumentsArg1.setProjectdeassignTemplatepthisProjectInstance(new Project(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepthisProject()));
        test4deassignTemplateTxnInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateTxnInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplateInstance(new ERTemplate(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplate()));
        test4deassignTemplateTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateImplementationDefault() {
        test4deassignTemplateImplementationDefaultArg1 = new DeassignTemplateRequest();
        test4deassignTemplateImplementationDefaultArg2 = true;
        test4deassignTemplateImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deassignTemplateImplementationInitializedArguments() {
        test4deassignTemplateImplementationInitializedArgumentsArg1 = new DeassignTemplateRequest();
        test4deassignTemplateImplementationInitializedArgumentsArg1.setProjectdeassignTemplatepthisProject(new ProjectOid(Long.valueOf(0)));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setProjectdeassignTemplatepthisProjectInstance(new Project(test4deassignTemplateImplementationInitializedArgumentsArg1.getProjectdeassignTemplatepthisProject()));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4deassignTemplateImplementationInitializedArgumentsArg1.setProjectdeassignTemplatepevcERTemplateInstance(new ERTemplate(test4deassignTemplateImplementationInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplate()));
        test4deassignTemplateImplementationInitializedArgumentsArg2 = true;
        test4deassignTemplateImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tCOMPLETEDefault() {
        test4tCOMPLETEDefaultArg1 = new TCOMPLETERequest();
    }

    private static void setUpMockData4test4tCOMPLETEInitializedArguments() {
        test4tCOMPLETEInitializedArgumentsArg1 = new TCOMPLETERequest();
        test4tCOMPLETEInitializedArgumentsArg1.setProjectTCOMPLETEpthisProject(new ProjectOid(Long.valueOf(0)));
        test4tCOMPLETEInitializedArgumentsArg1.setProjectTCOMPLETEpthisProjectInstance(new Project(test4tCOMPLETEInitializedArgumentsArg1.getProjectTCOMPLETEpthisProject()));
        test4tCOMPLETEInitializedArgumentsArg1.setProjectTCOMPLETEpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    private static void setUpMockData4test4tCOMPLETETxnDefault() {
        test4tCOMPLETETxnDefaultArg1 = new TCOMPLETERequest();
        test4tCOMPLETETxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tCOMPLETETxnInitializedArguments() {
        test4tCOMPLETETxnInitializedArgumentsArg1 = new TCOMPLETERequest();
        test4tCOMPLETETxnInitializedArgumentsArg1.setProjectTCOMPLETEpthisProject(new ProjectOid(Long.valueOf(0)));
        test4tCOMPLETETxnInitializedArgumentsArg1.setProjectTCOMPLETEpthisProjectInstance(new Project(test4tCOMPLETETxnInitializedArgumentsArg1.getProjectTCOMPLETEpthisProject()));
        test4tCOMPLETETxnInitializedArgumentsArg1.setProjectTCOMPLETEpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tCOMPLETETxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tCOMPLETEImplementationDefault() {
        test4tCOMPLETEImplementationDefaultArg1 = new TCOMPLETERequest();
        test4tCOMPLETEImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tCOMPLETEImplementationInitializedArguments() {
        test4tCOMPLETEImplementationInitializedArgumentsArg1 = new TCOMPLETERequest();
        test4tCOMPLETEImplementationInitializedArgumentsArg1.setProjectTCOMPLETEpthisProject(new ProjectOid(Long.valueOf(0)));
        test4tCOMPLETEImplementationInitializedArgumentsArg1.setProjectTCOMPLETEpthisProjectInstance(new Project(test4tCOMPLETEImplementationInitializedArgumentsArg1.getProjectTCOMPLETEpthisProject()));
        test4tCOMPLETEImplementationInitializedArgumentsArg1.setProjectTCOMPLETEpCompletionDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tCOMPLETEImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceProjectService, "projectSrv", instanceProjectService);

        when(mockTeamService.getByOIDWithHV(test4createinstanceInitializedArgumentsArg1.getProjectcreateinstancepagrTeam())).thenReturn(test4createinstanceInitializedArgumentsArg1.getProjectcreateinstancepagrTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4createinstanceTxnInitializedArgumentsArg1.getProjectcreateinstancepagrTeam())).thenReturn(test4createinstanceTxnInitializedArgumentsArg1.getProjectcreateinstancepagrTeamInstance());

        when(mockProjectService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getProjectdeleteinstancepthisProject())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getProjectdeleteinstancepthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getProjectdeleteinstancepthisProject())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getProjectdeleteinstancepthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getProjecteditinstancepthisProject())).thenReturn(test4editinstanceInitializedArgumentsArg1.getProjecteditinstancepthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getProjecteditinstancepthisProject())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getProjecteditinstancepthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4markAsCompletedInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProject())).thenReturn(test4markAsCompletedInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4markAsCompletedTxnInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProject())).thenReturn(test4markAsCompletedTxnInitializedArgumentsArg1.getProjectmarkAsCompletedpthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProject())).thenReturn(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplate())).thenReturn(test4assignTemplateToProjectInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProject())).thenReturn(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpthisProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplate())).thenReturn(test4assignTemplateToProjectTxnInitializedArgumentsArg1.getProjectassignTemplateToProjectpevcERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepthisProject())).thenReturn(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepthisProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplate())).thenReturn(test4deassignTemplateInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepthisProject())).thenReturn(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepthisProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplate())).thenReturn(test4deassignTemplateTxnInitializedArgumentsArg1.getProjectdeassignTemplatepevcERTemplateInstance());

        when(mockProjectService.getByOIDWithHV(test4tCOMPLETEInitializedArgumentsArg1.getProjectTCOMPLETEpthisProject())).thenReturn(test4tCOMPLETEInitializedArgumentsArg1.getProjectTCOMPLETEpthisProjectInstance());

        when(mockProjectService.getByOIDWithHV(test4tCOMPLETETxnInitializedArgumentsArg1.getProjectTCOMPLETEpthisProject())).thenReturn(test4tCOMPLETETxnInitializedArgumentsArg1.getProjectTCOMPLETEpthisProjectInstance());

        when(mockRepository.findById(mockprojectidProject)).thenAnswer(new Answer<Optional<Project>>(){
        	public Optional<Project> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockprojectidProject)) {
        			return mockProject;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(Project.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceProjectService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceProjectService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceProjectService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceProjectService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceProjectService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFProjects_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFProjects_NoFVarsResult), getResult(RESULTCODE, instanceProjectService.getDynamic(test4getDynamicPopulationByFilterFProjects_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFProjects_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFProjects_WithFVarsResult), getResult(RESULTCODE, instanceProjectService.getDynamic(test4getDynamicPopulationByFilterFProjects_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Result), getResult(RESULTCODE, instanceProjectService.getDynamic(test4getDynamicPopulationByNavFilterClas_1057569177600553FiltNav_2Arg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCProject() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCProjectResult), getResult(TOTALITEMS, instanceProjectService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCProjectArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceProjectService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSProject() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSProjectResult), getResult(TOTALITEMS, instanceProjectService.getDynamic(test4getDynamicPreload4DSProjectArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSProjectSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSProjectSupResult), getResult(TOTALITEMS, instanceProjectService.getDynamic(test4getDynamicPreload4DSProjectSupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceProjectService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceProjectService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceProjectService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceProjectService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getProjectDynamic() {
        assertEquals(test4getProjectDynamicResult.getResultCode(), instanceProjectService.getProjectDynamic(test4getProjectDynamicArg1, test4getProjectDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceProjectService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceProjectService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4getSuppInfoWithDSDSProjectSup() {
        instanceProjectService.getSuppInfo(test4getSuppInfoWithDSDSProjectSupArg1, test4getSuppInfoWithDSDSProjectSupArg2);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleAssignmentsWithRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1, test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2, test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTeamWithoutRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg1, test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg2, test4buildRelatedInstance4RoleTeamWithoutRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTeamWithRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleTeamWithRemainingPathArg1, test4buildRelatedInstance4RoleTeamWithRemainingPathArg2, test4buildRelatedInstance4RoleTeamWithRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleERTemplatesWithoutRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4buildRelatedInstance4RoleERTemplatesWithRemainingPath() {
        instanceProjectService.buildRelatedInstance(test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg1, test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg2, test4buildRelatedInstance4RoleERTemplatesWithRemainingPathArg3);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4getDSProject() {
        assertEquals(test4getDSProjectResult.getClass(), instanceProjectService.getDSProject(test4getDSProjectArg1, test4getDSProjectArg2, test4getDSProjectArg3).getClass());
    }

    @Test
    public void test4getPreloadDSProject() {
        instanceProjectService.getPreload(test4getPreloadDSProjectArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4getDSProjectSup() {
        assertEquals(test4getDSProjectSupResult.getClass(), instanceProjectService.getDSProjectSup(test4getDSProjectSupArg1, test4getDSProjectSupArg2, test4getDSProjectSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSProjectSup() {
        instanceProjectService.getPreload(test4getPreloadDSProjectSupArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4iIUProject() {
        assertEquals(test4iIUProjectResult.getDSProjectIdProject(), instanceProjectService.iIUProject(test4iIUProjectArg1).getDSProjectIdProject());
    }

    @Test
    public void test4iIUProjectReports() {
        assertEquals(test4iIUProjectReportsResult.getDSProjectIdProject(), instanceProjectService.iIUProjectReports(test4iIUProjectReportsArg1).getDSProjectIdProject());
    }

    @Test
    public void test4piuPIUProject() {
        instanceProjectService.piuPIUProject(test4piuPIUProjectArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4getCount4PIUProject() {
        instanceProjectService.getCount4PIUProject(test4getCount4PIUProjectArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4piuPIUProjectWithFilterFProjects_NoFVars() {
        instanceProjectService.piuPIUProject(test4piuPIUProjectWithFilterFProjects_NoFVarsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4piuPIUProjectWithFilterFProjects_WithFVars() {
        instanceProjectService.piuPIUProject(test4piuPIUProjectWithFilterFProjects_WithFVarsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4piuSELProject() {
        instanceProjectService.piuSELProject(test4piuSELProjectArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4getCount4SELProject() {
        instanceProjectService.getCount4SELProject(test4getCount4SELProjectArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceProjectService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceProjectService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceProjectService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceProjectService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceProjectService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceProjectService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4markAsCompletedDefault() {
        instanceProjectService.markAsCompleted(test4markAsCompletedDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4markAsCompletedInitializedArguments() {
        instanceProjectService.markAsCompleted(test4markAsCompletedInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4markAsCompletedTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.markAsCompletedTxn(test4markAsCompletedTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4markAsCompletedTxnDefaultResult;
        }
        assertEquals(test4markAsCompletedTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4markAsCompletedTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.markAsCompletedTxn(test4markAsCompletedTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4markAsCompletedTxnInitializedArgumentsResult;
        }
        assertEquals(test4markAsCompletedTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4markAsCompletedImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.markAsCompletedImplementation(test4markAsCompletedImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4markAsCompletedImplementationDefaultResult;
        }
        assertEquals(test4markAsCompletedImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4markAsCompletedImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.markAsCompletedImplementation(test4markAsCompletedImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4markAsCompletedImplementationInitializedArgumentsResult;
        }
        assertEquals(test4markAsCompletedImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectDefault() {
        instanceProjectService.assignTemplateToProject(test4assignTemplateToProjectDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4assignTemplateToProjectInitializedArguments() {
        instanceProjectService.assignTemplateToProject(test4assignTemplateToProjectInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4assignTemplateToProjectTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.assignTemplateToProjectTxn(test4assignTemplateToProjectTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4assignTemplateToProjectTxnDefaultResult;
        }
        assertEquals(test4assignTemplateToProjectTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.assignTemplateToProjectTxn(test4assignTemplateToProjectTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4assignTemplateToProjectTxnInitializedArgumentsResult;
        }
        assertEquals(test4assignTemplateToProjectTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.assignTemplateToProjectImplementation(test4assignTemplateToProjectImplementationDefaultArg1, test4assignTemplateToProjectImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4assignTemplateToProjectImplementationDefaultResult;
        }
        assertEquals(test4assignTemplateToProjectImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4assignTemplateToProjectImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.assignTemplateToProjectImplementation(test4assignTemplateToProjectImplementationInitializedArgumentsArg1, test4assignTemplateToProjectImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4assignTemplateToProjectImplementationInitializedArgumentsResult;
        }
        assertEquals(test4assignTemplateToProjectImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateDefault() {
        instanceProjectService.deassignTemplate(test4deassignTemplateDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4deassignTemplateInitializedArguments() {
        instanceProjectService.deassignTemplate(test4deassignTemplateInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4deassignTemplateTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deassignTemplateTxn(test4deassignTemplateTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deassignTemplateTxnDefaultResult;
        }
        assertEquals(test4deassignTemplateTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deassignTemplateTxn(test4deassignTemplateTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deassignTemplateTxnInitializedArgumentsResult;
        }
        assertEquals(test4deassignTemplateTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deassignTemplateImplementation(test4deassignTemplateImplementationDefaultArg1, test4deassignTemplateImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4deassignTemplateImplementationDefaultResult;
        }
        assertEquals(test4deassignTemplateImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deassignTemplateImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.deassignTemplateImplementation(test4deassignTemplateImplementationInitializedArgumentsArg1, test4deassignTemplateImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4deassignTemplateImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deassignTemplateImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tCOMPLETEDefault() {
        instanceProjectService.tCOMPLETE(test4tCOMPLETEDefaultArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4tCOMPLETEInitializedArguments() {
        instanceProjectService.tCOMPLETE(test4tCOMPLETEInitializedArgumentsArg1);
        assertNotNull(instanceProjectService);
    }

    @Test
    public void test4tCOMPLETETxnDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.tCOMPLETETxn(test4tCOMPLETETxnDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tCOMPLETETxnDefaultResult;
        }
        assertEquals(test4tCOMPLETETxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tCOMPLETETxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.tCOMPLETETxn(test4tCOMPLETETxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tCOMPLETETxnInitializedArgumentsResult;
        }
        assertEquals(test4tCOMPLETETxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tCOMPLETEImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceProjectService.tCOMPLETEImplementation(test4tCOMPLETEImplementationDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tCOMPLETEImplementationDefaultResult;
        }
        assertEquals(test4tCOMPLETEImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tCOMPLETEImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceProjectService.tCOMPLETEImplementation(test4tCOMPLETEImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tCOMPLETEImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tCOMPLETEImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
