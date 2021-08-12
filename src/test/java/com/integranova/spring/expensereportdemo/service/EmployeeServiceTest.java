package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
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
public class EmployeeServiceTest extends ClassTest {

    @InjectMocks
    private EmployeeService instanceEmployeeService;
    
    @Mock
    private static EmployeeJpaRepository mockRepository;
    
    @Mock
    private static EmployeeService mockEmployeeService;
    
    @Mock
    private static TeamService mockTeamService;
    
    @Mock
    private static AssignmentService mockAssignmentService;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;

    private static Employee mockInstance1;
    
    private static Employee mockInstance2;

    private static List<Employee> mockPopulation;

    private static String mockemployeeidEmployee;

    private static Optional<Employee> mockEmployee; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<Employee> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<Employee> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFEmployeeName_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFEmployeeName_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFEmployeeName_NoFVarsResult;

    // test4getDynamicPopulationByFilterFEmployeeName_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFEmployeeName_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFEmployeeName_WithFVarsResult;

    // test4getDynamicPopulationByOrderCriteriaOCEmployee
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCEmployeeArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCEmployeeResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSEmployee
    private static QueryRequest test4getDynamicPreload4DSEmployeeArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSEmployeeResult;

    // test4getDynamicPreload4DSEmployeeSup
    private static QueryRequest test4getDynamicPreload4DSEmployeeSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSEmployeeSupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static String test4getByIdArg1;
    private static Employee test4getByIdResult;

    // test4getByRelated
    private static Employee test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<Employee> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static Employee test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<Employee> test4getInstancesByRelatedResult;

    // test4getEmployeeDynamic
    private static EmployeeOid test4getEmployeeDynamicArg1;
    private static String test4getEmployeeDynamicArg2;
    private static InstanceResponseViewModel test4getEmployeeDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static EmployeeOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static EmployeeOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSEmployeeSup
    private static EmployeeOid test4getSuppInfoWithDSDSEmployeeSupArg1;
    private static String test4getSuppInfoWithDSDSEmployeeSupArg2;

    // test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleAssignmentsWithRemainingPath
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleTeamsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleTeamsWithRemainingPath
    private static String test4buildRelatedInstance4RoleTeamsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTeamsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTeamsWithRemainingPathArg3;

    // test4getDSEmployee
    private static String test4getDSEmployeeArg1;
    private static String test4getDSEmployeeArg2;
    private static String test4getDSEmployeeArg3;
    private static DSEmployee test4getDSEmployeeResult;

    // test4getPreloadDSEmployee
    private static QueryRequest test4getPreloadDSEmployeeArg1;
    private static List<PreloadViewModel> test4getPreloadDSEmployeeResult;

    // test4getDSEmployeeSup
    private static String test4getDSEmployeeSupArg1;
    private static String test4getDSEmployeeSupArg2;
    private static String test4getDSEmployeeSupArg3;
    private static DSEmployeeSup test4getDSEmployeeSupResult;

    // test4getPreloadDSEmployeeSup
    private static QueryRequest test4getPreloadDSEmployeeSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSEmployeeSupResult;

    // test4iIUEmployee
    private static EmployeeOid test4iIUEmployeeArg1;
    private static DSEmployee test4iIUEmployeeResult;

    // test4iIUEmployeeReports
    private static EmployeeOid test4iIUEmployeeReportsArg1;
    private static DSEmployee test4iIUEmployeeReportsResult;

    // test4piuPIUEmployee
    private static QueryRequest test4piuPIUEmployeeArg1;
    private static List<DSEmployee> test4piuPIUEmployeeResult;

    // test4getCount4PIUEmployee
    private static QueryRequest test4getCount4PIUEmployeeArg1;
    private static int test4getCount4PIUEmployeeResult;

    // test4piuPIUEmployeeWithFilterFEmployeeName_NoFVars
    private static QueryRequest test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsArg1;
    private static List<DSEmployee> test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsResult;

    // test4piuPIUEmployeeWithFilterFEmployeeName_WithFVars
    private static QueryRequest test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsArg1;
    private static List<DSEmployee> test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsResult;

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

    // test4changePictureDefault
    private static ChangePictureRequest test4changePictureDefaultArg1;

    // test4changePictureInitializedArguments
    private static ChangePictureRequest test4changePictureInitializedArgumentsArg1;

    // test4changePictureTxnDefault
    private static ChangePictureRequest test4changePictureTxnDefaultArg1;
    private static ServiceResponse test4changePictureTxnDefaultResult;

    // test4changePictureTxnInitializedArguments
    private static ChangePictureRequest test4changePictureTxnInitializedArgumentsArg1;
    private static ServiceResponse test4changePictureTxnInitializedArgumentsResult;

    // test4changePictureImplementationDefault
    private static ChangePictureRequest test4changePictureImplementationDefaultArg1;
    private static ServiceResponse test4changePictureImplementationDefaultResult;

    // test4changePictureImplementationInitializedArguments
    private static ChangePictureRequest test4changePictureImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4changePictureImplementationInitializedArgumentsResult;

    // test4addEmployeeToTeamDefault
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamDefaultArg1;

    // test4addEmployeeToTeamInitializedArguments
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamInitializedArgumentsArg1;

    // test4addEmployeeToTeamTxnDefault
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamTxnDefaultArg1;
    private static ServiceResponse test4addEmployeeToTeamTxnDefaultResult;

    // test4addEmployeeToTeamTxnInitializedArguments
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamTxnInitializedArgumentsArg1;
    private static ServiceResponse test4addEmployeeToTeamTxnInitializedArgumentsResult;

    // test4addEmployeeToTeamImplementationDefault
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamImplementationDefaultArg1;
    private static boolean test4addEmployeeToTeamImplementationDefaultArg2;
    private static ServiceResponse test4addEmployeeToTeamImplementationDefaultResult;

    // test4addEmployeeToTeamImplementationInitializedArguments
    private static AddEmployeeToTeamRequest test4addEmployeeToTeamImplementationInitializedArgumentsArg1;
    private static boolean test4addEmployeeToTeamImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4addEmployeeToTeamImplementationInitializedArgumentsResult;

    // test4addEmployeeToTeamCheckPreconditions
    private static AddEmployeeToTeamRequest addEmployeeToTeamCheckPreconditionsArg1;
    private static ServiceResponse addEmployeeToTeamCheckPreconditionsResult;

    // test4removeEmployeeFromTeamDefault
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamDefaultArg1;

    // test4removeEmployeeFromTeamInitializedArguments
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamInitializedArgumentsArg1;

    // test4removeEmployeeFromTeamTxnDefault
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamTxnDefaultArg1;
    private static ServiceResponse test4removeEmployeeFromTeamTxnDefaultResult;

    // test4removeEmployeeFromTeamTxnInitializedArguments
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamTxnInitializedArgumentsArg1;
    private static ServiceResponse test4removeEmployeeFromTeamTxnInitializedArgumentsResult;

    // test4removeEmployeeFromTeamImplementationDefault
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamImplementationDefaultArg1;
    private static boolean test4removeEmployeeFromTeamImplementationDefaultArg2;
    private static ServiceResponse test4removeEmployeeFromTeamImplementationDefaultResult;

    // test4removeEmployeeFromTeamImplementationInitializedArguments
    private static RemoveEmployeeFromTeamRequest test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1;
    private static boolean test4removeEmployeeFromTeamImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4removeEmployeeFromTeamImplementationInitializedArgumentsResult;

    // test4tDELETEDefault
    private static TDELETERequest test4tDELETEDefaultArg1;

    // test4tDELETEInitializedArguments
    private static TDELETERequest test4tDELETEInitializedArgumentsArg1;

    // test4tDELETETxnDefault
    private static TDELETERequest test4tDELETETxnDefaultArg1;
    private static ServiceResponse test4tDELETETxnDefaultResult;

    // test4tDELETETxnInitializedArguments
    private static TDELETERequest test4tDELETETxnInitializedArgumentsArg1;
    private static ServiceResponse test4tDELETETxnInitializedArgumentsResult;

    // test4tDELETEImplementationDefault
    private static TDELETERequest test4tDELETEImplementationDefaultArg1;
    private static ServiceResponse test4tDELETEImplementationDefaultResult;

    // test4tDELETEImplementationInitializedArguments
    private static TDELETERequest test4tDELETEImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tDELETEImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockemployeeidEmployee = "";
        mockInstance1 = new Employee();
        mockInstance2 = new Employee();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockEmployee = Optional.of(new Employee(new EmployeeOid(mockemployeeidEmployee)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFEmployeeName_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFEmployeeName_WithFVars();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCEmployee();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSEmployee();
        setUpMockData4test4getDynamicPreload4DSEmployeeSup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getEmployeeDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSEmployeeSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTeamsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTeamsWithRemainingPath();
        setUpMockData4test4getDSEmployee();
        setUpMockData4test4getPreloadDSEmployee();
        setUpMockData4test4getDSEmployeeSup();
        setUpMockData4test4getPreloadDSEmployeeSup();
        setUpMockData4test4iIUEmployee();
        setUpMockData4test4iIUEmployeeReports();
        setUpMockData4test4piuPIUEmployee();
        setUpMockData4test4getCount4PIUEmployee();
        setUpMockData4test4piuPIUEmployeeWithFilterFEmployeeName_NoFVars();
        setUpMockData4test4piuPIUEmployeeWithFilterFEmployeeName_WithFVars();
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
        setUpMockData4test4changePictureDefault();
        setUpMockData4test4changePictureInitializedArguments();
        setUpMockData4test4changePictureTxnDefault();
        setUpMockData4test4changePictureTxnInitializedArguments();
        setUpMockData4test4changePictureImplementationDefault();
        setUpMockData4test4changePictureImplementationInitializedArguments();
        setUpMockData4test4addEmployeeToTeamDefault();
        setUpMockData4test4addEmployeeToTeamInitializedArguments();
        setUpMockData4test4addEmployeeToTeamTxnDefault();
        setUpMockData4test4addEmployeeToTeamTxnInitializedArguments();
        setUpMockData4test4addEmployeeToTeamImplementationDefault();
        setUpMockData4test4addEmployeeToTeamImplementationInitializedArguments();
        setUpMockData4test4addEmployeeToTeamCheckPreconditions();
        setUpMockData4test4removeEmployeeFromTeamDefault();
        setUpMockData4test4removeEmployeeFromTeamInitializedArguments();
        setUpMockData4test4removeEmployeeFromTeamTxnDefault();
        setUpMockData4test4removeEmployeeFromTeamTxnInitializedArguments();
        setUpMockData4test4removeEmployeeFromTeamImplementationDefault();
        setUpMockData4test4removeEmployeeFromTeamImplementationInitializedArguments();
        setUpMockData4test4tDELETEDefault();
        setUpMockData4test4tDELETEInitializedArguments();
        setUpMockData4test4tDELETETxnDefault();
        setUpMockData4test4tDELETETxnInitializedArguments();
        setUpMockData4test4tDELETEImplementationDefault();
        setUpMockData4test4tDELETEImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("employeeidEmployee");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFEmployeeName_NoFVars() {
        test4getDynamicPopulationByFilterFEmployeeName_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFEmployeeName_NoFVarsArg1.setDisplaySetItems("employeeidEmployee");
        test4getDynamicPopulationByFilterFEmployeeName_NoFVarsArg1.addFilterRequest(new FilterRequest(EmployeeConstants.FILTER_NAME_FEMPLOYEENAME,new ArrayList<>()));
        test4getDynamicPopulationByFilterFEmployeeName_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFEmployeeName_WithFVars() {
        test4getDynamicPopulationByFilterFEmployeeName_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFEmployeeName_WithFVarsArg1.setDisplaySetItems("employeeidEmployee");
        test4getDynamicPopulationByFilterFEmployeeName_WithFVarsArg1.addFilterRequest(new FilterRequest(EmployeeConstants.FILTER_NAME_FEMPLOYEENAME,new ArrayList<>(Arrays.asList(new FilterVariableRequest(EmployeeConstants.VAR_NAME_FEMPLOYEENAME_VFULLNAME, "")))));
        test4getDynamicPopulationByFilterFEmployeeName_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCEmployee() {
        test4getDynamicPopulationByOrderCriteriaOCEmployeeArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCEmployeeArg1.setDisplaySetItems("employeeidEmployee");
        test4getDynamicPopulationByOrderCriteriaOCEmployeeArg1.setOrderCriteriaName("OCEmployee");
        test4getDynamicPopulationByOrderCriteriaOCEmployeeResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("employeeidEmployee");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new EmployeeOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSEmployee() {
        test4getDynamicPreload4DSEmployeeArg1 = new QueryRequest();
        test4getDynamicPreload4DSEmployeeArg1.setDisplaySetName(EmployeeConstants.DSDSEMPLOYEE);
        test4getDynamicPreload4DSEmployeeResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> EmployeeService.buildPreloadViewModel(i, test4getDynamicPreload4DSEmployeeArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSEmployeeSup() {
        test4getDynamicPreload4DSEmployeeSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSEmployeeSupArg1.setDisplaySetName(EmployeeConstants.DSDSEMPLOYEESUP);
        test4getDynamicPreload4DSEmployeeSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> EmployeeService.buildPreloadViewModel(i, test4getDynamicPreload4DSEmployeeSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockEmployee.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new Employee();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new Employee();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getEmployeeDynamic() {
        test4getEmployeeDynamicArg1 = new EmployeeOid();
        test4getEmployeeDynamicArg2 = "";
        test4getEmployeeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new EmployeeOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new EmployeeOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSEmployeeSup() {
        test4getSuppInfoWithDSDSEmployeeSupArg1 = new EmployeeOid("");
        test4getSuppInfoWithDSDSEmployeeSupArg2 = EmployeeConstants.DSDSEMPLOYEESUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2 = EmployeeConstants.ROLE_NAME_EXPENSEREPORTS;
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2 = EmployeeConstants.ROLE_NAME_EXPENSEREPORTS;
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1 = new AssignmentOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2 = EmployeeConstants.ROLE_NAME_ASSIGNMENTS;
        test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleAssignmentsWithRemainingPath() {
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1 = new AssignmentOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2 = EmployeeConstants.ROLE_NAME_ASSIGNMENTS;
        test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTeamsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg1 = new TeamOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg2 = EmployeeConstants.ROLE_NAME_TEAMS;
        test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTeamsWithRemainingPath() {
        test4buildRelatedInstance4RoleTeamsWithRemainingPathArg1 = new TeamOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTeamsWithRemainingPathArg2 = EmployeeConstants.ROLE_NAME_TEAMS;
        test4buildRelatedInstance4RoleTeamsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSEmployee() {
        test4getDSEmployeeArg1 = "";
        test4getDSEmployeeArg2 = "";
        test4getDSEmployeeArg3 = "";
        test4getDSEmployeeResult = new DSEmployee();
    }

    private static void setUpMockData4test4getPreloadDSEmployee() {
        test4getPreloadDSEmployeeArg1 = new QueryRequest();
        test4getPreloadDSEmployeeArg1.setDisplaySetName(EmployeeConstants.DSDSEMPLOYEE);
        test4getPreloadDSEmployeeResult = mockPopulation.stream().map(i -> EmployeeService.buildPreloadViewModel(i, test4getPreloadDSEmployeeArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSEmployeeSup() {
        test4getDSEmployeeSupArg1 = "";
        test4getDSEmployeeSupArg2 = "";
        test4getDSEmployeeSupArg3 = "";
        test4getDSEmployeeSupResult = new DSEmployeeSup();
    }

    private static void setUpMockData4test4getPreloadDSEmployeeSup() {
        test4getPreloadDSEmployeeSupArg1 = new QueryRequest();
        test4getPreloadDSEmployeeSupArg1.setDisplaySetName(EmployeeConstants.DSDSEMPLOYEESUP);
        test4getPreloadDSEmployeeSupResult = mockPopulation.stream().map(i -> EmployeeService.buildPreloadViewModel(i, test4getPreloadDSEmployeeSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUEmployee() {
        test4iIUEmployeeArg1 = new EmployeeOid();
        test4iIUEmployeeResult = new DSEmployee();
    }

    private static void setUpMockData4test4iIUEmployeeReports() {
        test4iIUEmployeeReportsArg1 = new EmployeeOid();
        test4iIUEmployeeReportsResult = new DSEmployee();
    }

    private static void setUpMockData4test4piuPIUEmployee() {
        test4piuPIUEmployeeArg1 = new QueryRequest();
        test4piuPIUEmployeeResult = mockPopulation.stream().map(i -> new DSEmployee(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUEmployee() {
        test4getCount4PIUEmployeeArg1 = new QueryRequest();
        test4getCount4PIUEmployeeResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUEmployeeWithFilterFEmployeeName_NoFVars() {
        test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsArg1 = new QueryRequest();
        test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsArg1.addFilterRequest(new FilterRequest(EmployeeConstants.FILTER_NAME_FEMPLOYEENAME,new ArrayList<>()));
        test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsResult = mockPopulation.stream().map(i -> new DSEmployee(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUEmployeeWithFilterFEmployeeName_WithFVars() {
        test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsArg1 = new QueryRequest();
        test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsArg1.addFilterRequest(new FilterRequest(EmployeeConstants.FILTER_NAME_FEMPLOYEENAME,new ArrayList<>(Arrays.asList(new FilterVariableRequest(EmployeeConstants.VAR_NAME_FEMPLOYEENAME_VFULLNAME, "")))));
        test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsResult = mockPopulation.stream().map(i -> new DSEmployee(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatridEmployee("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpName("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpSurname("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatrSite("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatrPhoneNumbers("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatremail("");
        test4createinstanceInitializedArgumentsArg1.setEmployeecreateinstancepatrPicture(null);
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatridEmployee("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpName("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpSurname("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatrSite("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatrPhoneNumbers("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatremail("");
        test4createinstanceTxnInitializedArgumentsArg1.setEmployeecreateinstancepatrPicture(null);
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatridEmployee("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpName("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatrEmpSurname("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatrSite("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatrPhoneNumbers("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatremail("");
        test4createinstanceImplementationInitializedArgumentsArg1.setEmployeecreateinstancepatrPicture(null);
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployee(new EmployeeOid(""));
        test4deleteinstanceInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployeeInstance(new Employee(test4deleteinstanceInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployee()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployee(new EmployeeOid(""));
        test4deleteinstanceTxnInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployeeInstance(new Employee(test4deleteinstanceTxnInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployee()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployee(new EmployeeOid(""));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setEmployeedeleteinstancepthisEmployeeInstance(new Employee(test4deleteinstanceImplementationInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployee()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployee(new EmployeeOid(""));
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployeeInstance(new Employee(test4editinstanceInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployee()));
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepEmpName("");
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepEmpSurname("");
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepSite("");
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepPhoneNumbers("");
        test4editinstanceInitializedArgumentsArg1.setEmployeeeditinstancepemail("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployee(new EmployeeOid(""));
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployeeInstance(new Employee(test4editinstanceTxnInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployee()));
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepEmpName("");
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepEmpSurname("");
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepSite("");
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepPhoneNumbers("");
        test4editinstanceTxnInitializedArgumentsArg1.setEmployeeeditinstancepemail("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployee(new EmployeeOid(""));
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepthisEmployeeInstance(new Employee(test4editinstanceImplementationInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployee()));
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepEmpName("");
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepEmpSurname("");
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepSite("");
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepPhoneNumbers("");
        test4editinstanceImplementationInitializedArgumentsArg1.setEmployeeeditinstancepemail("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changePictureDefault() {
        test4changePictureDefaultArg1 = new ChangePictureRequest();
    }

    private static void setUpMockData4test4changePictureInitializedArguments() {
        test4changePictureInitializedArgumentsArg1 = new ChangePictureRequest();
        test4changePictureInitializedArgumentsArg1.setEmployeechangePicturepthisEmployee(new EmployeeOid(""));
        test4changePictureInitializedArgumentsArg1.setEmployeechangePicturepthisEmployeeInstance(new Employee(test4changePictureInitializedArgumentsArg1.getEmployeechangePicturepthisEmployee()));
        test4changePictureInitializedArgumentsArg1.setEmployeechangePicturepPicture(null);
    }

    private static void setUpMockData4test4changePictureTxnDefault() {
        test4changePictureTxnDefaultArg1 = new ChangePictureRequest();
        test4changePictureTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changePictureTxnInitializedArguments() {
        test4changePictureTxnInitializedArgumentsArg1 = new ChangePictureRequest();
        test4changePictureTxnInitializedArgumentsArg1.setEmployeechangePicturepthisEmployee(new EmployeeOid(""));
        test4changePictureTxnInitializedArgumentsArg1.setEmployeechangePicturepthisEmployeeInstance(new Employee(test4changePictureTxnInitializedArgumentsArg1.getEmployeechangePicturepthisEmployee()));
        test4changePictureTxnInitializedArgumentsArg1.setEmployeechangePicturepPicture(null);
        test4changePictureTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changePictureImplementationDefault() {
        test4changePictureImplementationDefaultArg1 = new ChangePictureRequest();
        test4changePictureImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changePictureImplementationInitializedArguments() {
        test4changePictureImplementationInitializedArgumentsArg1 = new ChangePictureRequest();
        test4changePictureImplementationInitializedArgumentsArg1.setEmployeechangePicturepthisEmployee(new EmployeeOid(""));
        test4changePictureImplementationInitializedArgumentsArg1.setEmployeechangePicturepthisEmployeeInstance(new Employee(test4changePictureImplementationInitializedArgumentsArg1.getEmployeechangePicturepthisEmployee()));
        test4changePictureImplementationInitializedArgumentsArg1.setEmployeechangePicturepPicture(null);
        test4changePictureImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamDefault() {
        test4addEmployeeToTeamDefaultArg1 = new AddEmployeeToTeamRequest();
    }

    private static void setUpMockData4test4addEmployeeToTeamInitializedArguments() {
        test4addEmployeeToTeamInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployeeInstance(new Employee(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployee()));
        test4addEmployeeToTeamInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeamInstance(new Team(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeam()));
    }

    private static void setUpMockData4test4addEmployeeToTeamTxnDefault() {
        test4addEmployeeToTeamTxnDefaultArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamTxnInitializedArguments() {
        test4addEmployeeToTeamTxnInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployeeInstance(new Employee(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployee()));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeamInstance(new Team(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeam()));
        test4addEmployeeToTeamTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamImplementationDefault() {
        test4addEmployeeToTeamImplementationDefaultArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamImplementationDefaultArg2 = true;
        test4addEmployeeToTeamImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamImplementationInitializedArguments() {
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampthisEmployeeInstance(new Employee(test4addEmployeeToTeamImplementationInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployee()));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setEmployeeaddEmployeeToTeampevcTeamInstance(new Team(test4addEmployeeToTeamImplementationInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeam()));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg2 = true;
        test4addEmployeeToTeamImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamCheckPreconditions() {
        addEmployeeToTeamCheckPreconditionsArg1 = new AddEmployeeToTeamRequest();
        addEmployeeToTeamCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamDefault() {
        test4removeEmployeeFromTeamDefaultArg1 = new RemoveEmployeeFromTeamRequest();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamInitializedArguments() {
        test4removeEmployeeFromTeamInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(new Employee(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployee()));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeamInstance(new Team(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeam()));
    }

    private static void setUpMockData4test4removeEmployeeFromTeamTxnDefault() {
        test4removeEmployeeFromTeamTxnDefaultArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamTxnInitializedArguments() {
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(new Employee(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployee()));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeamInstance(new Team(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeam()));
        test4removeEmployeeFromTeamTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamImplementationDefault() {
        test4removeEmployeeFromTeamImplementationDefaultArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamImplementationDefaultArg2 = true;
        test4removeEmployeeFromTeamImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamImplementationInitializedArguments() {
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(new Employee(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployee()));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setEmployeeremoveEmployeeFromTeampevcTeamInstance(new Team(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeam()));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg2 = true;
        test4removeEmployeeFromTeamImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEDefault() {
        test4tDELETEDefaultArg1 = new TDELETERequest();
    }

    private static void setUpMockData4test4tDELETEInitializedArguments() {
        test4tDELETEInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETEInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployee(new EmployeeOid(""));
        test4tDELETEInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployeeInstance(new Employee(test4tDELETEInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployee()));
    }

    private static void setUpMockData4test4tDELETETxnDefault() {
        test4tDELETETxnDefaultArg1 = new TDELETERequest();
        test4tDELETETxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETETxnInitializedArguments() {
        test4tDELETETxnInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETETxnInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployee(new EmployeeOid(""));
        test4tDELETETxnInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployeeInstance(new Employee(test4tDELETETxnInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployee()));
        test4tDELETETxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEImplementationDefault() {
        test4tDELETEImplementationDefaultArg1 = new TDELETERequest();
        test4tDELETEImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEImplementationInitializedArguments() {
        test4tDELETEImplementationInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETEImplementationInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployee(new EmployeeOid(""));
        test4tDELETEImplementationInitializedArgumentsArg1.setEmployeeTDELETEpthisEmployeeInstance(new Employee(test4tDELETEImplementationInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployee()));
        test4tDELETEImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceEmployeeService, "employeeSrv", instanceEmployeeService);

        when(mockEmployeeService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployee())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployee())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getEmployeedeleteinstancepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployee())).thenReturn(test4editinstanceInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployee())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getEmployeeeditinstancepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4changePictureInitializedArgumentsArg1.getEmployeechangePicturepthisEmployee())).thenReturn(test4changePictureInitializedArgumentsArg1.getEmployeechangePicturepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4changePictureTxnInitializedArgumentsArg1.getEmployeechangePicturepthisEmployee())).thenReturn(test4changePictureTxnInitializedArgumentsArg1.getEmployeechangePicturepthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployee())).thenReturn(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeam())).thenReturn(test4addEmployeeToTeamInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployee())).thenReturn(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampthisEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeam())).thenReturn(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getEmployeeaddEmployeeToTeampevcTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployee())).thenReturn(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeam())).thenReturn(test4removeEmployeeFromTeamInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployee())).thenReturn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampthisEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeam())).thenReturn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getEmployeeremoveEmployeeFromTeampevcTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tDELETEInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployee())).thenReturn(test4tDELETEInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployeeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tDELETETxnInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployee())).thenReturn(test4tDELETETxnInitializedArgumentsArg1.getEmployeeTDELETEpthisEmployeeInstance());

        when(mockRepository.findById(mockemployeeidEmployee)).thenAnswer(new Answer<Optional<Employee>>(){
        	public Optional<Employee> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockemployeeidEmployee)) {
        			return mockEmployee;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(Employee.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceEmployeeService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceEmployeeService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceEmployeeService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceEmployeeService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceEmployeeService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFEmployeeName_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFEmployeeName_NoFVarsResult), getResult(RESULTCODE, instanceEmployeeService.getDynamic(test4getDynamicPopulationByFilterFEmployeeName_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFEmployeeName_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFEmployeeName_WithFVarsResult), getResult(RESULTCODE, instanceEmployeeService.getDynamic(test4getDynamicPopulationByFilterFEmployeeName_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCEmployee() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCEmployeeResult), getResult(TOTALITEMS, instanceEmployeeService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCEmployeeArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceEmployeeService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSEmployee() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSEmployeeResult), getResult(TOTALITEMS, instanceEmployeeService.getDynamic(test4getDynamicPreload4DSEmployeeArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSEmployeeSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSEmployeeSupResult), getResult(TOTALITEMS, instanceEmployeeService.getDynamic(test4getDynamicPreload4DSEmployeeSupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceEmployeeService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceEmployeeService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceEmployeeService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceEmployeeService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getEmployeeDynamic() {
        assertEquals(test4getEmployeeDynamicResult.getResultCode(), instanceEmployeeService.getEmployeeDynamic(test4getEmployeeDynamicArg1, test4getEmployeeDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceEmployeeService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceEmployeeService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4getSuppInfoWithDSDSEmployeeSup() {
        instanceEmployeeService.getSuppInfo(test4getSuppInfoWithDSDSEmployeeSupArg1, test4getSuppInfoWithDSDSEmployeeSupArg2);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleAssignmentsWithoutRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleAssignmentsWithRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg1, test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg2, test4buildRelatedInstance4RoleAssignmentsWithRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTeamsWithoutRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleTeamsWithoutRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTeamsWithRemainingPath() {
        instanceEmployeeService.buildRelatedInstance(test4buildRelatedInstance4RoleTeamsWithRemainingPathArg1, test4buildRelatedInstance4RoleTeamsWithRemainingPathArg2, test4buildRelatedInstance4RoleTeamsWithRemainingPathArg3);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4getDSEmployee() {
        assertEquals(test4getDSEmployeeResult.getClass(), instanceEmployeeService.getDSEmployee(test4getDSEmployeeArg1, test4getDSEmployeeArg2, test4getDSEmployeeArg3).getClass());
    }

    @Test
    public void test4getPreloadDSEmployee() {
        instanceEmployeeService.getPreload(test4getPreloadDSEmployeeArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4getDSEmployeeSup() {
        assertEquals(test4getDSEmployeeSupResult.getClass(), instanceEmployeeService.getDSEmployeeSup(test4getDSEmployeeSupArg1, test4getDSEmployeeSupArg2, test4getDSEmployeeSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSEmployeeSup() {
        instanceEmployeeService.getPreload(test4getPreloadDSEmployeeSupArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4iIUEmployee() {
        assertEquals(test4iIUEmployeeResult.getDSEmployeeIdEmployee(), instanceEmployeeService.iIUEmployee(test4iIUEmployeeArg1).getDSEmployeeIdEmployee());
    }

    @Test
    public void test4iIUEmployeeReports() {
        assertEquals(test4iIUEmployeeReportsResult.getDSEmployeeIdEmployee(), instanceEmployeeService.iIUEmployeeReports(test4iIUEmployeeReportsArg1).getDSEmployeeIdEmployee());
    }

    @Test
    public void test4piuPIUEmployee() {
        instanceEmployeeService.piuPIUEmployee(test4piuPIUEmployeeArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4getCount4PIUEmployee() {
        instanceEmployeeService.getCount4PIUEmployee(test4getCount4PIUEmployeeArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4piuPIUEmployeeWithFilterFEmployeeName_NoFVars() {
        instanceEmployeeService.piuPIUEmployee(test4piuPIUEmployeeWithFilterFEmployeeName_NoFVarsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4piuPIUEmployeeWithFilterFEmployeeName_WithFVars() {
        instanceEmployeeService.piuPIUEmployee(test4piuPIUEmployeeWithFilterFEmployeeName_WithFVarsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceEmployeeService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceEmployeeService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceEmployeeService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceEmployeeService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceEmployeeService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceEmployeeService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changePictureDefault() {
        instanceEmployeeService.changePicture(test4changePictureDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4changePictureInitializedArguments() {
        instanceEmployeeService.changePicture(test4changePictureInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4changePictureTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.changePictureTxn(test4changePictureTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4changePictureTxnDefaultResult;
        }
        assertEquals(test4changePictureTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changePictureTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.changePictureTxn(test4changePictureTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4changePictureTxnInitializedArgumentsResult;
        }
        assertEquals(test4changePictureTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changePictureImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.changePictureImplementation(test4changePictureImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4changePictureImplementationDefaultResult;
        }
        assertEquals(test4changePictureImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changePictureImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.changePictureImplementation(test4changePictureImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4changePictureImplementationInitializedArgumentsResult;
        }
        assertEquals(test4changePictureImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamDefault() {
        instanceEmployeeService.addEmployeeToTeam(test4addEmployeeToTeamDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4addEmployeeToTeamInitializedArguments() {
        instanceEmployeeService.addEmployeeToTeam(test4addEmployeeToTeamInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4addEmployeeToTeamTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.addEmployeeToTeamTxn(test4addEmployeeToTeamTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4addEmployeeToTeamTxnDefaultResult;
        }
        assertEquals(test4addEmployeeToTeamTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.addEmployeeToTeamTxn(test4addEmployeeToTeamTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4addEmployeeToTeamTxnInitializedArgumentsResult;
        }
        assertEquals(test4addEmployeeToTeamTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.addEmployeeToTeamImplementation(test4addEmployeeToTeamImplementationDefaultArg1, test4addEmployeeToTeamImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4addEmployeeToTeamImplementationDefaultResult;
        }
        assertEquals(test4addEmployeeToTeamImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.addEmployeeToTeamImplementation(test4addEmployeeToTeamImplementationInitializedArgumentsArg1, test4addEmployeeToTeamImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4addEmployeeToTeamImplementationInitializedArgumentsResult;
        }
        assertEquals(test4addEmployeeToTeamImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamCheckPreconditions() {
        assertEquals(addEmployeeToTeamCheckPreconditionsResult.getResultCode(), instanceEmployeeService.addEmployeeToTeamCheckPreconditions(addEmployeeToTeamCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamDefault() {
        instanceEmployeeService.removeEmployeeFromTeam(test4removeEmployeeFromTeamDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4removeEmployeeFromTeamInitializedArguments() {
        instanceEmployeeService.removeEmployeeFromTeam(test4removeEmployeeFromTeamInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4removeEmployeeFromTeamTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.removeEmployeeFromTeamTxn(test4removeEmployeeFromTeamTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4removeEmployeeFromTeamTxnDefaultResult;
        }
        assertEquals(test4removeEmployeeFromTeamTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.removeEmployeeFromTeamTxn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4removeEmployeeFromTeamTxnInitializedArgumentsResult;
        }
        assertEquals(test4removeEmployeeFromTeamTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.removeEmployeeFromTeamImplementation(test4removeEmployeeFromTeamImplementationDefaultArg1, test4removeEmployeeFromTeamImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4removeEmployeeFromTeamImplementationDefaultResult;
        }
        assertEquals(test4removeEmployeeFromTeamImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.removeEmployeeFromTeamImplementation(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1, test4removeEmployeeFromTeamImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4removeEmployeeFromTeamImplementationInitializedArgumentsResult;
        }
        assertEquals(test4removeEmployeeFromTeamImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEDefault() {
        instanceEmployeeService.tDELETE(test4tDELETEDefaultArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4tDELETEInitializedArguments() {
        instanceEmployeeService.tDELETE(test4tDELETEInitializedArgumentsArg1);
        assertNotNull(instanceEmployeeService);
    }

    @Test
    public void test4tDELETETxnDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.tDELETETxn(test4tDELETETxnDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tDELETETxnDefaultResult;
        }
        assertEquals(test4tDELETETxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETETxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.tDELETETxn(test4tDELETETxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tDELETETxnInitializedArgumentsResult;
        }
        assertEquals(test4tDELETETxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.tDELETEImplementation(test4tDELETEImplementationDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tDELETEImplementationDefaultResult;
        }
        assertEquals(test4tDELETEImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceEmployeeService.tDELETEImplementation(test4tDELETEImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tDELETEImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tDELETEImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
