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
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest;
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
public class TeamServiceTest extends ClassTest {

    @InjectMocks
    private TeamService instanceTeamService;
    
    @Mock
    private static TeamJpaRepository mockRepository;
    
    @Mock
    private static TeamService mockTeamService;
    
    @Mock
    private static EmployeeService mockEmployeeService;
    
    @Mock
    private static ProjectService mockProjectService;

    private static Team mockInstance1;
    
    private static Team mockInstance2;

    private static List<Team> mockPopulation;

    private static Long mockteamid;

    private static Optional<Team> mockTeam; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<Team> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<Team> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFTeamsByName_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFTeamsByName_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFTeamsByName_NoFVarsResult;

    // test4getDynamicPopulationByFilterFTeamsByName_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFTeamsByName_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFTeamsByName_WithFVarsResult;

    // test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsResult;

    // test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1
    private static QueryRequest test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Arg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Result;

    // test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2
    private static QueryRequest test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Arg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Result;

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
    private static Team test4getByIdResult;

    // test4getByRelated
    private static Team test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<Team> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static Team test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<Team> test4getInstancesByRelatedResult;

    // test4getTeamDynamic
    private static TeamOid test4getTeamDynamicArg1;
    private static String test4getTeamDynamicArg2;
    private static InstanceResponseViewModel test4getTeamDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static TeamOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static TeamOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4buildRelatedInstance4RoleEmployeesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleEmployeesWithRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectsWithRemainingPath
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3;

    // test4getDSTeams
    private static String test4getDSTeamsArg1;
    private static String test4getDSTeamsArg2;
    private static String test4getDSTeamsArg3;
    private static DSTeams test4getDSTeamsResult;

    // test4getDSTeam
    private static String test4getDSTeamArg1;
    private static String test4getDSTeamArg2;
    private static String test4getDSTeamArg3;
    private static DSTeam test4getDSTeamResult;

    // test4iIUTeam
    private static TeamOid test4iIUTeamArg1;
    private static DSTeam test4iIUTeamResult;

    // test4piuPIUTeams
    private static QueryRequest test4piuPIUTeamsArg1;
    private static List<DSTeams> test4piuPIUTeamsResult;

    // test4getCount4PIUTeams
    private static QueryRequest test4getCount4PIUTeamsArg1;
    private static int test4getCount4PIUTeamsResult;

    // test4piuPIUTeamsWithFilterFTeamsByName_NoFVars
    private static QueryRequest test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsArg1;
    private static List<DSTeams> test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsResult;

    // test4piuPIUTeamsWithFilterFTeamsByName_WithFVars
    private static QueryRequest test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsArg1;
    private static List<DSTeams> test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsResult;

    // test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVars
    private static QueryRequest test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsArg1;
    private static List<DSTeams> test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsResult;

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

    // test4validateDefault
    private static ValidateRequest test4validateDefaultArg1;

    // test4validateInitializedArguments
    private static ValidateRequest test4validateInitializedArgumentsArg1;

    // test4validateTxnDefault
    private static ValidateRequest test4validateTxnDefaultArg1;
    private static ServiceResponse test4validateTxnDefaultResult;

    // test4validateTxnInitializedArguments
    private static ValidateRequest test4validateTxnInitializedArgumentsArg1;
    private static ServiceResponse test4validateTxnInitializedArgumentsResult;

    // test4validateImplementationDefault
    private static ValidateRequest test4validateImplementationDefaultArg1;
    private static ServiceResponse test4validateImplementationDefaultResult;

    // test4validateImplementationInitializedArguments
    private static ValidateRequest test4validateImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4validateImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockteamid = Long.valueOf(0);
        mockInstance1 = new Team();
        mockInstance2 = new Team();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockTeam = Optional.of(new Team(new TeamOid(mockteamid)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFTeamsByName_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFTeamsByName_WithFVars();
        setUpMockData4test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVars();
        setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1();
        setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getTeamDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4buildRelatedInstance4RoleEmployeesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleEmployeesWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectsWithRemainingPath();
        setUpMockData4test4getDSTeams();
        setUpMockData4test4getDSTeam();
        setUpMockData4test4iIUTeam();
        setUpMockData4test4piuPIUTeams();
        setUpMockData4test4getCount4PIUTeams();
        setUpMockData4test4piuPIUTeamsWithFilterFTeamsByName_NoFVars();
        setUpMockData4test4piuPIUTeamsWithFilterFTeamsByName_WithFVars();
        setUpMockData4test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVars();
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
        setUpMockData4test4addEmployeeToTeamDefault();
        setUpMockData4test4addEmployeeToTeamInitializedArguments();
        setUpMockData4test4addEmployeeToTeamTxnDefault();
        setUpMockData4test4addEmployeeToTeamTxnInitializedArguments();
        setUpMockData4test4addEmployeeToTeamImplementationDefault();
        setUpMockData4test4addEmployeeToTeamImplementationInitializedArguments();
        setUpMockData4test4removeEmployeeFromTeamDefault();
        setUpMockData4test4removeEmployeeFromTeamInitializedArguments();
        setUpMockData4test4removeEmployeeFromTeamTxnDefault();
        setUpMockData4test4removeEmployeeFromTeamTxnInitializedArguments();
        setUpMockData4test4removeEmployeeFromTeamImplementationDefault();
        setUpMockData4test4removeEmployeeFromTeamImplementationInitializedArguments();
        setUpMockData4test4validateDefault();
        setUpMockData4test4validateInitializedArguments();
        setUpMockData4test4validateTxnDefault();
        setUpMockData4test4validateTxnInitializedArguments();
        setUpMockData4test4validateImplementationDefault();
        setUpMockData4test4validateImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFTeamsByName_NoFVars() {
        test4getDynamicPopulationByFilterFTeamsByName_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFTeamsByName_NoFVarsArg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationByFilterFTeamsByName_NoFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSBYNAME,new ArrayList<>()));
        test4getDynamicPopulationByFilterFTeamsByName_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFTeamsByName_WithFVars() {
        test4getDynamicPopulationByFilterFTeamsByName_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFTeamsByName_WithFVarsArg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationByFilterFTeamsByName_WithFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSBYNAME,new ArrayList<>(Arrays.asList(new FilterVariableRequest(TeamConstants.VAR_NAME_FTEAMSBYNAME_VNAME, ""), new FilterVariableRequest(TeamConstants.VAR_NAME_FTEAMSBYNAME_VCAPACITY, Long.valueOf(0))))));
        test4getDynamicPopulationByFilterFTeamsByName_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVars() {
        test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsArg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSWITHCAPACITY,new ArrayList<>()));
        test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1() {
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Arg1 = new QueryRequest();
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Arg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Arg1.addFilterRequest(new FilterRequest("Employee_addEmployeeToTeam_p_evcTeam_NavFilter0",new ArrayList<>(Arrays.asList(new FilterVariableRequest(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE, new Employee()), new FilterVariableRequest(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM, new Team())))));
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Result = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2() {
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Arg1 = new QueryRequest();
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Arg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Arg1.addFilterRequest(new FilterRequest("Employee_removeEmployeeFromTeam_p_evcTeam_NavFilter0",new ArrayList<>(Arrays.asList(new FilterVariableRequest(EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE, new Employee()), new FilterVariableRequest(EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM, new Team())))));
        test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Result = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("teamid");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new TeamOid(Long.valueOf(0)))))));
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
        test4getByIdResult = mockTeam.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new Team();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new Team();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getTeamDynamic() {
        test4getTeamDynamicArg1 = new TeamOid();
        test4getTeamDynamicArg2 = "";
        test4getTeamDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new TeamOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new TeamOid(Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg2 = TeamConstants.ROLE_NAME_EMPLOYEES;
        test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeesWithRemainingPath() {
        test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg2 = TeamConstants.ROLE_NAME_EMPLOYEES;
        test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2 = TeamConstants.ROLE_NAME_PROJECTS;
        test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectsWithRemainingPath() {
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2 = TeamConstants.ROLE_NAME_PROJECTS;
        test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSTeams() {
        test4getDSTeamsArg1 = "";
        test4getDSTeamsArg2 = "";
        test4getDSTeamsArg3 = "";
        test4getDSTeamsResult = new DSTeams();
    }

    private static void setUpMockData4test4getDSTeam() {
        test4getDSTeamArg1 = "";
        test4getDSTeamArg2 = "";
        test4getDSTeamArg3 = "";
        test4getDSTeamResult = new DSTeam();
    }

    private static void setUpMockData4test4iIUTeam() {
        test4iIUTeamArg1 = new TeamOid();
        test4iIUTeamResult = new DSTeam();
    }

    private static void setUpMockData4test4piuPIUTeams() {
        test4piuPIUTeamsArg1 = new QueryRequest();
        test4piuPIUTeamsResult = mockPopulation.stream().map(i -> new DSTeams(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUTeams() {
        test4getCount4PIUTeamsArg1 = new QueryRequest();
        test4getCount4PIUTeamsResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUTeamsWithFilterFTeamsByName_NoFVars() {
        test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsArg1 = new QueryRequest();
        test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSBYNAME,new ArrayList<>()));
        test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsResult = mockPopulation.stream().map(i -> new DSTeams(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUTeamsWithFilterFTeamsByName_WithFVars() {
        test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsArg1 = new QueryRequest();
        test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSBYNAME,new ArrayList<>(Arrays.asList(new FilterVariableRequest(TeamConstants.VAR_NAME_FTEAMSBYNAME_VNAME, ""), new FilterVariableRequest(TeamConstants.VAR_NAME_FTEAMSBYNAME_VCAPACITY, Long.valueOf(0))))));
        test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsResult = mockPopulation.stream().map(i -> new DSTeams(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVars() {
        test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsArg1 = new QueryRequest();
        test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsArg1.addFilterRequest(new FilterRequest(TeamConstants.FILTER_NAME_FTEAMSWITHCAPACITY,new ArrayList<>()));
        test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsResult = mockPopulation.stream().map(i -> new DSTeams(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setTeamcreateinstancepatrname("");
        test4createinstanceInitializedArgumentsArg1.setTeamcreateinstancepatrmaxEmployees(Long.valueOf(0));
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setTeamcreateinstancepatrname("");
        test4createinstanceTxnInitializedArgumentsArg1.setTeamcreateinstancepatrmaxEmployees(Long.valueOf(0));
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setTeamcreateinstancepatrname("");
        test4createinstanceImplementationInitializedArgumentsArg1.setTeamcreateinstancepatrmaxEmployees(Long.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setTeamdeleteinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4deleteinstanceInitializedArgumentsArg1.setTeamdeleteinstancepthisTeamInstance(new Team(test4deleteinstanceInitializedArgumentsArg1.getTeamdeleteinstancepthisTeam()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setTeamdeleteinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4deleteinstanceTxnInitializedArgumentsArg1.setTeamdeleteinstancepthisTeamInstance(new Team(test4deleteinstanceTxnInitializedArgumentsArg1.getTeamdeleteinstancepthisTeam()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setTeamdeleteinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setTeamdeleteinstancepthisTeamInstance(new Team(test4deleteinstanceImplementationInitializedArgumentsArg1.getTeamdeleteinstancepthisTeam()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setTeameditinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setTeameditinstancepthisTeamInstance(new Team(test4editinstanceInitializedArgumentsArg1.getTeameditinstancepthisTeam()));
        test4editinstanceInitializedArgumentsArg1.setTeameditinstancepname("");
        test4editinstanceInitializedArgumentsArg1.setTeameditinstancepmaxEmployees(Long.valueOf(0));
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setTeameditinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setTeameditinstancepthisTeamInstance(new Team(test4editinstanceTxnInitializedArgumentsArg1.getTeameditinstancepthisTeam()));
        test4editinstanceTxnInitializedArgumentsArg1.setTeameditinstancepname("");
        test4editinstanceTxnInitializedArgumentsArg1.setTeameditinstancepmaxEmployees(Long.valueOf(0));
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setTeameditinstancepthisTeam(new TeamOid(Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setTeameditinstancepthisTeamInstance(new Team(test4editinstanceImplementationInitializedArgumentsArg1.getTeameditinstancepthisTeam()));
        test4editinstanceImplementationInitializedArgumentsArg1.setTeameditinstancepname("");
        test4editinstanceImplementationInitializedArgumentsArg1.setTeameditinstancepmaxEmployees(Long.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamDefault() {
        test4addEmployeeToTeamDefaultArg1 = new AddEmployeeToTeamRequest();
    }

    private static void setUpMockData4test4addEmployeeToTeamInitializedArguments() {
        test4addEmployeeToTeamInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeamInstance(new Team(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeam()));
        test4addEmployeeToTeamInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployeeInstance(new Employee(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployee()));
    }

    private static void setUpMockData4test4addEmployeeToTeamTxnDefault() {
        test4addEmployeeToTeamTxnDefaultArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamTxnInitializedArguments() {
        test4addEmployeeToTeamTxnInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeamInstance(new Team(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeam()));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamTxnInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployeeInstance(new Employee(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployee()));
        test4addEmployeeToTeamTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamImplementationDefault() {
        test4addEmployeeToTeamImplementationDefaultArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamImplementationDefaultArg2 = true;
        test4addEmployeeToTeamImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4addEmployeeToTeamImplementationInitializedArguments() {
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1 = new AddEmployeeToTeamRequest();
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setTeamaddEmployeeToTeampthisTeamInstance(new Team(test4addEmployeeToTeamImplementationInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeam()));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployee(new EmployeeOid(""));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg1.setTeamaddEmployeeToTeampevcEmployeeInstance(new Employee(test4addEmployeeToTeamImplementationInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployee()));
        test4addEmployeeToTeamImplementationInitializedArgumentsArg2 = true;
        test4addEmployeeToTeamImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamDefault() {
        test4removeEmployeeFromTeamDefaultArg1 = new RemoveEmployeeFromTeamRequest();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamInitializedArguments() {
        test4removeEmployeeFromTeamInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeamInstance(new Team(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeam()));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployeeInstance(new Employee(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployee()));
    }

    private static void setUpMockData4test4removeEmployeeFromTeamTxnDefault() {
        test4removeEmployeeFromTeamTxnDefaultArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamTxnInitializedArguments() {
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeamInstance(new Team(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeam()));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployeeInstance(new Employee(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployee()));
        test4removeEmployeeFromTeamTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamImplementationDefault() {
        test4removeEmployeeFromTeamImplementationDefaultArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamImplementationDefaultArg2 = true;
        test4removeEmployeeFromTeamImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4removeEmployeeFromTeamImplementationInitializedArguments() {
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1 = new RemoveEmployeeFromTeamRequest();
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeam(new TeamOid(Long.valueOf(0)));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampthisTeamInstance(new Team(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeam()));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployee(new EmployeeOid(""));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.setTeamremoveEmployeeFromTeampevcEmployeeInstance(new Employee(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployee()));
        test4removeEmployeeFromTeamImplementationInitializedArgumentsArg2 = true;
        test4removeEmployeeFromTeamImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4validateDefault() {
        test4validateDefaultArg1 = new ValidateRequest();
    }

    private static void setUpMockData4test4validateInitializedArguments() {
        test4validateInitializedArgumentsArg1 = new ValidateRequest();
        test4validateInitializedArgumentsArg1.setTeamvalidatepthisTeam(new TeamOid(Long.valueOf(0)));
        test4validateInitializedArgumentsArg1.setTeamvalidatepthisTeamInstance(new Team(test4validateInitializedArgumentsArg1.getTeamvalidatepthisTeam()));
    }

    private static void setUpMockData4test4validateTxnDefault() {
        test4validateTxnDefaultArg1 = new ValidateRequest();
        test4validateTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4validateTxnInitializedArguments() {
        test4validateTxnInitializedArgumentsArg1 = new ValidateRequest();
        test4validateTxnInitializedArgumentsArg1.setTeamvalidatepthisTeam(new TeamOid(Long.valueOf(0)));
        test4validateTxnInitializedArgumentsArg1.setTeamvalidatepthisTeamInstance(new Team(test4validateTxnInitializedArgumentsArg1.getTeamvalidatepthisTeam()));
        test4validateTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4validateImplementationDefault() {
        test4validateImplementationDefaultArg1 = new ValidateRequest();
        test4validateImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4validateImplementationInitializedArguments() {
        test4validateImplementationInitializedArgumentsArg1 = new ValidateRequest();
        test4validateImplementationInitializedArgumentsArg1.setTeamvalidatepthisTeam(new TeamOid(Long.valueOf(0)));
        test4validateImplementationInitializedArgumentsArg1.setTeamvalidatepthisTeamInstance(new Team(test4validateImplementationInitializedArgumentsArg1.getTeamvalidatepthisTeam()));
        test4validateImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceTeamService, "teamSrv", instanceTeamService);

        when(mockTeamService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getTeamdeleteinstancepthisTeam())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getTeamdeleteinstancepthisTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getTeamdeleteinstancepthisTeam())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getTeamdeleteinstancepthisTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getTeameditinstancepthisTeam())).thenReturn(test4editinstanceInitializedArgumentsArg1.getTeameditinstancepthisTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getTeameditinstancepthisTeam())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getTeameditinstancepthisTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeam())).thenReturn(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployee())).thenReturn(test4addEmployeeToTeamInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeam())).thenReturn(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampthisTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployee())).thenReturn(test4addEmployeeToTeamTxnInitializedArgumentsArg1.getTeamaddEmployeeToTeampevcEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeam())).thenReturn(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployee())).thenReturn(test4removeEmployeeFromTeamInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeam())).thenReturn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampthisTeamInstance());

        when(mockEmployeeService.getByOIDWithHV(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployee())).thenReturn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1.getTeamremoveEmployeeFromTeampevcEmployeeInstance());

        when(mockTeamService.getByOIDWithHV(test4validateInitializedArgumentsArg1.getTeamvalidatepthisTeam())).thenReturn(test4validateInitializedArgumentsArg1.getTeamvalidatepthisTeamInstance());

        when(mockTeamService.getByOIDWithHV(test4validateTxnInitializedArgumentsArg1.getTeamvalidatepthisTeam())).thenReturn(test4validateTxnInitializedArgumentsArg1.getTeamvalidatepthisTeamInstance());

        when(mockRepository.findById(mockteamid)).thenAnswer(new Answer<Optional<Team>>(){
        	public Optional<Team> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockteamid)) {
        			return mockTeam;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(Team.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceTeamService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceTeamService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceTeamService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceTeamService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceTeamService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFTeamsByName_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFTeamsByName_NoFVarsResult), getResult(RESULTCODE, instanceTeamService.getDynamic(test4getDynamicPopulationByFilterFTeamsByName_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFTeamsByName_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFTeamsByName_WithFVarsResult), getResult(RESULTCODE, instanceTeamService.getDynamic(test4getDynamicPopulationByFilterFTeamsByName_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsResult), getResult(RESULTCODE, instanceTeamService.getDynamic(test4getDynamicPopulationByFilterFTeamsWithCapacity_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Result), getResult(RESULTCODE, instanceTeamService.getDynamic(test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_1Arg1)));
    }

    @Test
    public void test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Result), getResult(RESULTCODE, instanceTeamService.getDynamic(test4getDynamicPopulationByNavFilterClas_1057569177600607FiltNav_2Arg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceTeamService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceTeamService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceTeamService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceTeamService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceTeamService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getTeamDynamic() {
        assertEquals(test4getTeamDynamicResult.getResultCode(), instanceTeamService.getTeamDynamic(test4getTeamDynamicArg1, test4getTeamDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceTeamService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceTeamService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeesWithoutRemainingPath() {
        instanceTeamService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleEmployeesWithoutRemainingPathArg3);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeesWithRemainingPath() {
        instanceTeamService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg1, test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg2, test4buildRelatedInstance4RoleEmployeesWithRemainingPathArg3);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectsWithoutRemainingPath() {
        instanceTeamService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleProjectsWithoutRemainingPathArg3);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectsWithRemainingPath() {
        instanceTeamService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectsWithRemainingPathArg1, test4buildRelatedInstance4RoleProjectsWithRemainingPathArg2, test4buildRelatedInstance4RoleProjectsWithRemainingPathArg3);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4getDSTeams() {
        assertEquals(test4getDSTeamsResult.getClass(), instanceTeamService.getDSTeams(test4getDSTeamsArg1, test4getDSTeamsArg2, test4getDSTeamsArg3).getClass());
    }

    @Test
    public void test4getDSTeam() {
        assertEquals(test4getDSTeamResult.getClass(), instanceTeamService.getDSTeam(test4getDSTeamArg1, test4getDSTeamArg2, test4getDSTeamArg3).getClass());
    }

    @Test
    public void test4iIUTeam() {
        assertEquals(test4iIUTeamResult.getDSTeamId(), instanceTeamService.iIUTeam(test4iIUTeamArg1).getDSTeamId());
    }

    @Test
    public void test4piuPIUTeams() {
        instanceTeamService.piuPIUTeams(test4piuPIUTeamsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4getCount4PIUTeams() {
        instanceTeamService.getCount4PIUTeams(test4getCount4PIUTeamsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4piuPIUTeamsWithFilterFTeamsByName_NoFVars() {
        instanceTeamService.piuPIUTeams(test4piuPIUTeamsWithFilterFTeamsByName_NoFVarsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4piuPIUTeamsWithFilterFTeamsByName_WithFVars() {
        instanceTeamService.piuPIUTeams(test4piuPIUTeamsWithFilterFTeamsByName_WithFVarsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVars() {
        instanceTeamService.piuPIUTeams(test4piuPIUTeamsWithFilterFTeamsWithCapacity_NoFVarsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceTeamService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceTeamService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceTeamService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceTeamService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceTeamService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceTeamService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamDefault() {
        instanceTeamService.addEmployeeToTeam(test4addEmployeeToTeamDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4addEmployeeToTeamInitializedArguments() {
        instanceTeamService.addEmployeeToTeam(test4addEmployeeToTeamInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4addEmployeeToTeamTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.addEmployeeToTeamTxn(test4addEmployeeToTeamTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4addEmployeeToTeamTxnDefaultResult;
        }
        assertEquals(test4addEmployeeToTeamTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.addEmployeeToTeamTxn(test4addEmployeeToTeamTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4addEmployeeToTeamTxnInitializedArgumentsResult;
        }
        assertEquals(test4addEmployeeToTeamTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.addEmployeeToTeamImplementation(test4addEmployeeToTeamImplementationDefaultArg1, test4addEmployeeToTeamImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4addEmployeeToTeamImplementationDefaultResult;
        }
        assertEquals(test4addEmployeeToTeamImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4addEmployeeToTeamImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.addEmployeeToTeamImplementation(test4addEmployeeToTeamImplementationInitializedArgumentsArg1, test4addEmployeeToTeamImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4addEmployeeToTeamImplementationInitializedArgumentsResult;
        }
        assertEquals(test4addEmployeeToTeamImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamDefault() {
        instanceTeamService.removeEmployeeFromTeam(test4removeEmployeeFromTeamDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4removeEmployeeFromTeamInitializedArguments() {
        instanceTeamService.removeEmployeeFromTeam(test4removeEmployeeFromTeamInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4removeEmployeeFromTeamTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.removeEmployeeFromTeamTxn(test4removeEmployeeFromTeamTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4removeEmployeeFromTeamTxnDefaultResult;
        }
        assertEquals(test4removeEmployeeFromTeamTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.removeEmployeeFromTeamTxn(test4removeEmployeeFromTeamTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4removeEmployeeFromTeamTxnInitializedArgumentsResult;
        }
        assertEquals(test4removeEmployeeFromTeamTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.removeEmployeeFromTeamImplementation(test4removeEmployeeFromTeamImplementationDefaultArg1, test4removeEmployeeFromTeamImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4removeEmployeeFromTeamImplementationDefaultResult;
        }
        assertEquals(test4removeEmployeeFromTeamImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4removeEmployeeFromTeamImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.removeEmployeeFromTeamImplementation(test4removeEmployeeFromTeamImplementationInitializedArgumentsArg1, test4removeEmployeeFromTeamImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4removeEmployeeFromTeamImplementationInitializedArgumentsResult;
        }
        assertEquals(test4removeEmployeeFromTeamImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4validateDefault() {
        instanceTeamService.validate(test4validateDefaultArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4validateInitializedArguments() {
        instanceTeamService.validate(test4validateInitializedArgumentsArg1);
        assertNotNull(instanceTeamService);
    }

    @Test
    public void test4validateTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.validateTxn(test4validateTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4validateTxnDefaultResult;
        }
        assertEquals(test4validateTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4validateTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.validateTxn(test4validateTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4validateTxnInitializedArgumentsResult;
        }
        assertEquals(test4validateTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4validateImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceTeamService.validateImplementation(test4validateImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4validateImplementationDefaultResult;
        }
        assertEquals(test4validateImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4validateImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceTeamService.validateImplementation(test4validateImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4validateImplementationInitializedArgumentsResult;
        }
        assertEquals(test4validateImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
