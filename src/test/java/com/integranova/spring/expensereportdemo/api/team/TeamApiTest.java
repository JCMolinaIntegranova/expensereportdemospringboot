package com.integranova.spring.expensereportdemo.api.team;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.team.TeamApi;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.service.TeamService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams;
import com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class TeamApiTest {

    @Mock
    private TeamService mockTeamService;

    @InjectMocks
    private TeamApi instanceTeamApi;

    // testGetDSTeams
    private static String testGetDSTeamsArg1;
    private static String testGetDSTeamsArg2;
    private static String testGetDSTeamsArg3;
    private static DSTeams testGetDSTeamsResult;

    // testGetDSTeams2
    private static String testGetDSTeams2Arg1;
    private static String testGetDSTeams2Arg2;
    private static String testGetDSTeams2Arg3;
    private static DSTeams testGetDSTeams2Result;

    // testGetDSTeams3
    private static String testGetDSTeams3Arg1;
    private static String testGetDSTeams3Arg2;
    private static String testGetDSTeams3Arg3;
    private static DSTeams testGetDSTeams3Result;

    // testGetDSTeams4
    private static String testGetDSTeams4Arg1;
    private static String testGetDSTeams4Arg2;
    private static String testGetDSTeams4Arg3;
    private static DSTeams testGetDSTeams4Result;

    // testGetDSTeam
    private static String testGetDSTeamArg1;
    private static String testGetDSTeamArg2;
    private static String testGetDSTeamArg3;
    private static DSTeam testGetDSTeamResult;

    // testGetDSTeam2
    private static String testGetDSTeam2Arg1;
    private static String testGetDSTeam2Arg2;
    private static String testGetDSTeam2Arg3;
    private static DSTeam testGetDSTeam2Result;

    // testGetDSTeam3
    private static String testGetDSTeam3Arg1;
    private static String testGetDSTeam3Arg2;
    private static String testGetDSTeam3Arg3;
    private static DSTeam testGetDSTeam3Result;

    // testGetDSTeam4
    private static String testGetDSTeam4Arg1;
    private static String testGetDSTeam4Arg2;
    private static String testGetDSTeam4Arg3;
    private static DSTeam testGetDSTeam4Result;

    // testGetTeam
    private static Long testGetTeamArg1;
    private static Team testGetTeamResult;

    // testGetTeamDynamic
    private static QueryRequest testGetTeamDynamicArg1;
    private static TeamOid mockGetTeamDynamicArg1;
    private static String mockGetTeamDynamicArg2;
    private static InstanceResponseViewModel testGetTeamDynamicResult;

    // testGetTeamWithDisplaySetDynamic
    private static QueryRequest testGetTeamWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetTeamWithDisplaySetDynamicResult;

    // testGetTeamPopulationDynamic
    private static QueryRequest testGetTeamPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetTeamPopulationDynamicResult;

    // testTeamCreateinstance
    private static CreateinstanceRequest testTeamCreateinstanceArg1;
    private static ServiceResponse testTeamCreateinstanceResult;

    // testTeamDeleteinstance
    private static DeleteinstanceRequest testTeamDeleteinstanceArg1;
    private static ServiceResponse testTeamDeleteinstanceResult;

    // testTeamEditinstance
    private static EditinstanceRequest testTeamEditinstanceArg1;
    private static ServiceResponse testTeamEditinstanceResult;

    // testTeamAddEmployeeToTeam
    private static AddEmployeeToTeamRequest testTeamAddEmployeeToTeamArg1;
    private static ServiceResponse testTeamAddEmployeeToTeamResult;

    // testTeamRemoveEmployeeFromTeam
    private static RemoveEmployeeFromTeamRequest testTeamRemoveEmployeeFromTeamArg1;
    private static ServiceResponse testTeamRemoveEmployeeFromTeamResult;

    // testiiuIIUTeam
    private static TeamOid testiiuIIUTeamArg1;
    private static DSTeam testiiuIIUTeamResult;

    // testpiuPIUTeams
    private static PIUTeamsRequest testpiuPIUTeamsArg1;
    private static QueryRequest testpiuPIUTeamsMockArg1;
    private static List<DSTeams> testpiuPIUTeamsMockResult;
    private static PIUTeamsResponse testpiuPIUTeamsResult;

    // testpiuPIUTeams2
    private static PIUTeamsRequest testpiuPIUTeams2Arg1;
    private static QueryRequest testpiuPIUTeams2MockArg1;
    private static List<DSTeams> testpiuPIUTeams2MockResult;
    private static PIUTeamsResponse testpiuPIUTeams2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSTeams();
        setUpMockData4testGetDSTeams2();
        setUpMockData4testGetDSTeams3();
        setUpMockData4testGetDSTeams4();
        setUpMockData4testGetDSTeam();
        setUpMockData4testGetDSTeam2();
        setUpMockData4testGetDSTeam3();
        setUpMockData4testGetDSTeam4();
        setUpMockData4testGetTeam();
        setUpMockData4testGetTeamDynamic();
        setUpMockData4testGetTeamWithDisplaySetDynamic();
        setUpMockData4testGetTeamPopulationDynamic();
        setUpMockData4testTeamCreateinstance();
        setUpMockData4testTeamDeleteinstance();
        setUpMockData4testTeamEditinstance();
        setUpMockData4testTeamAddEmployeeToTeam();
        setUpMockData4testTeamRemoveEmployeeFromTeam();
        setUpMockData4testiiuIIUTeam();
        setUpMockData4testpiuPIUTeams();
        setUpMockData4testpiuPIUTeams2();
    }

    private static void setUpMockData4testGetDSTeams() {
        testGetDSTeamsArg1 = "";
        testGetDSTeamsArg2 = "";
        testGetDSTeamsArg3 = "";
        testGetDSTeamsResult = new DSTeams();
    }

    private static void setUpMockData4testGetDSTeams2() {
        testGetDSTeams2Arg1 = "";
        testGetDSTeams2Arg2 = null;
        testGetDSTeams2Arg3 = null;
        testGetDSTeams2Result = testGetDSTeamsResult;
    }

    private static void setUpMockData4testGetDSTeams3() {
        testGetDSTeams3Arg1 = "";
        testGetDSTeams3Arg2 = null;
        testGetDSTeams3Arg3 = "";
        testGetDSTeams3Result = testGetDSTeamsResult;
    }

    private static void setUpMockData4testGetDSTeams4() {
        testGetDSTeams4Arg1 = "";
        testGetDSTeams4Arg2 = "";
        testGetDSTeams4Arg3 = null;
        testGetDSTeams4Result = testGetDSTeamsResult;
    }

    private static void setUpMockData4testGetDSTeam() {
        testGetDSTeamArg1 = "";
        testGetDSTeamArg2 = "";
        testGetDSTeamArg3 = "";
        testGetDSTeamResult = new DSTeam();
    }

    private static void setUpMockData4testGetDSTeam2() {
        testGetDSTeam2Arg1 = "";
        testGetDSTeam2Arg2 = null;
        testGetDSTeam2Arg3 = null;
        testGetDSTeam2Result = testGetDSTeamResult;
    }

    private static void setUpMockData4testGetDSTeam3() {
        testGetDSTeam3Arg1 = "";
        testGetDSTeam3Arg2 = null;
        testGetDSTeam3Arg3 = "";
        testGetDSTeam3Result = testGetDSTeamResult;
    }

    private static void setUpMockData4testGetDSTeam4() {
        testGetDSTeam4Arg1 = "";
        testGetDSTeam4Arg2 = "";
        testGetDSTeam4Arg3 = null;
        testGetDSTeam4Result = testGetDSTeamResult;
    }

    private static void setUpMockData4testGetTeam() {
        testGetTeamArg1 = Long.valueOf(0);
        testGetTeamResult = new Team();
    }

    private static void setUpMockData4testGetTeamDynamic() {
        mockGetTeamDynamicArg1 = new TeamOid();
        mockGetTeamDynamicArg2 = "";
        testGetTeamDynamicArg1 = new QueryRequest();
        testGetTeamDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetTeamWithDisplaySetDynamic() {
        testGetTeamWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetTeamWithDisplaySetDynamicArg1.setDisplaySetName("testGetTeamWithDisplaySetDynamicArg1");
        testGetTeamWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetTeamPopulationDynamic() {
        testGetTeamPopulationDynamicArg1 = new QueryRequest();
        testGetTeamPopulationDynamicArg1.setDisplaySetName("testGetTeamPopulationDynamicArg1");
        testGetTeamPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testTeamCreateinstance() {
        testTeamCreateinstanceArg1 = new CreateinstanceRequest();
        testTeamCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testTeamDeleteinstance() {
        testTeamDeleteinstanceArg1 = new DeleteinstanceRequest();
        testTeamDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testTeamEditinstance() {
        testTeamEditinstanceArg1 = new EditinstanceRequest();
        testTeamEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testTeamAddEmployeeToTeam() {
        testTeamAddEmployeeToTeamArg1 = new AddEmployeeToTeamRequest();
        testTeamAddEmployeeToTeamResult = new ServiceResponse();
    }

    private static void setUpMockData4testTeamRemoveEmployeeFromTeam() {
        testTeamRemoveEmployeeFromTeamArg1 = new RemoveEmployeeFromTeamRequest();
        testTeamRemoveEmployeeFromTeamResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUTeam() {
        testiiuIIUTeamArg1 = new TeamOid();
        testiiuIIUTeamResult = new DSTeam();
    }

    private static void setUpMockData4testpiuPIUTeams() {
        testpiuPIUTeamsMockArg1 = new QueryRequest();
        testpiuPIUTeamsMockArg1.setPageSize(0);
        testpiuPIUTeamsMockResult = new ArrayList<>();
        testpiuPIUTeamsArg1 = mock(PIUTeamsRequest.class);
        testpiuPIUTeamsResult = new PIUTeamsResponse();
    }

    private static void setUpMockData4testpiuPIUTeams2() {
        testpiuPIUTeams2MockArg1 = new QueryRequest();
        testpiuPIUTeams2MockArg1.setPageSize(1);
        testpiuPIUTeams2MockResult = new ArrayList<>();
        testpiuPIUTeams2MockResult.add(new DSTeams());
        testpiuPIUTeams2Arg1 = mock(PIUTeamsRequest.class);
        testpiuPIUTeams2Arg1.setPageSize(1);
        testpiuPIUTeams2Result = new PIUTeamsResponse();
        testpiuPIUTeams2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockTeamService.getDSTeams(testGetDSTeamsArg1, testGetDSTeamsArg2, testGetDSTeamsArg3)).thenReturn(testGetDSTeamsResult);

        when(mockTeamService.getDSTeam(testGetDSTeamArg1, testGetDSTeamArg2, testGetDSTeamArg3)).thenReturn(testGetDSTeamResult);

        when(mockTeamService.getById(testGetTeamArg1)).thenReturn(testGetTeamResult);

        when(mockTeamService.getTeamDynamic(mockGetTeamDynamicArg1, mockGetTeamDynamicArg2)).thenReturn(testGetTeamDynamicResult);

        when(mockTeamService.getDynamic(testGetTeamWithDisplaySetDynamicArg1)).thenReturn(testGetTeamWithDisplaySetDynamicResult);

        when(mockTeamService.getDynamic(testGetTeamPopulationDynamicArg1)).thenReturn(testGetTeamPopulationDynamicResult);

        when(mockTeamService.createinstance(testTeamCreateinstanceArg1)).thenReturn(testTeamCreateinstanceResult);

        when(mockTeamService.deleteinstance(testTeamDeleteinstanceArg1)).thenReturn(testTeamDeleteinstanceResult);

        when(mockTeamService.editinstance(testTeamEditinstanceArg1)).thenReturn(testTeamEditinstanceResult);

        when(mockTeamService.addEmployeeToTeam(testTeamAddEmployeeToTeamArg1)).thenReturn(testTeamAddEmployeeToTeamResult);

        when(mockTeamService.removeEmployeeFromTeam(testTeamRemoveEmployeeFromTeamArg1)).thenReturn(testTeamRemoveEmployeeFromTeamResult);

        when(mockTeamService.iIUTeam(testiiuIIUTeamArg1)).thenReturn(testiiuIIUTeamResult);

        when(testpiuPIUTeamsArg1.buildQueryRequest()).thenReturn(testpiuPIUTeamsMockArg1);

        when(mockTeamService.piuPIUTeams(testpiuPIUTeamsMockArg1)).thenReturn(testpiuPIUTeamsMockResult);

        when(testpiuPIUTeams2Arg1.buildQueryRequest()).thenReturn(testpiuPIUTeams2MockArg1);

        when(mockTeamService.piuPIUTeams(testpiuPIUTeams2MockArg1)).thenReturn(testpiuPIUTeams2MockResult);

        when(mockTeamService.getCount4PIUTeams(testpiuPIUTeams2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSTeams() {
        assertEquals(testGetDSTeamsResult, instanceTeamApi.getDSTeams(testGetDSTeamsArg1, testGetDSTeamsArg2, testGetDSTeamsArg3));
    }

    @Test
    public void testGetDSTeams2() {
        assertEquals(testGetDSTeams2Result, instanceTeamApi.getDSTeams(testGetDSTeams2Arg1, testGetDSTeams2Arg2, testGetDSTeams2Arg3));
    }

    @Test
    public void testGetDSTeams3() {
        assertEquals(testGetDSTeams3Result, instanceTeamApi.getDSTeams(testGetDSTeams3Arg1, testGetDSTeams3Arg2, testGetDSTeams3Arg3));
    }

    @Test
    public void testGetDSTeams4() {
        assertEquals(testGetDSTeams4Result, instanceTeamApi.getDSTeams(testGetDSTeams4Arg1, testGetDSTeams4Arg2, testGetDSTeams4Arg3));
    }

    @Test
    public void testGetDSTeam() {
        assertEquals(testGetDSTeamResult, instanceTeamApi.getDSTeam(testGetDSTeamArg1, testGetDSTeamArg2, testGetDSTeamArg3));
    }

    @Test
    public void testGetDSTeam2() {
        assertEquals(testGetDSTeam2Result, instanceTeamApi.getDSTeam(testGetDSTeam2Arg1, testGetDSTeam2Arg2, testGetDSTeam2Arg3));
    }

    @Test
    public void testGetDSTeam3() {
        assertEquals(testGetDSTeam3Result, instanceTeamApi.getDSTeam(testGetDSTeam3Arg1, testGetDSTeam3Arg2, testGetDSTeam3Arg3));
    }

    @Test
    public void testGetDSTeam4() {
        assertEquals(testGetDSTeam4Result, instanceTeamApi.getDSTeam(testGetDSTeam4Arg1, testGetDSTeam4Arg2, testGetDSTeam4Arg3));
    }

    @Test
    public void testGetTeam() {
        assertEquals(testGetTeamResult, instanceTeamApi.getTeam(testGetTeamArg1));
    }

    @Test
    public void testGetTeamDynamic() {
        assertEquals(testGetTeamDynamicResult, instanceTeamApi.getTeamDynamic(testGetTeamDynamicArg1));
    }

    @Test
    public void testGetTeamWithDisplaySetDynamic() {
        assertEquals(testGetTeamWithDisplaySetDynamicResult, instanceTeamApi.getTeamWithDisplaySetDynamic(testGetTeamWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetTeamPopulationDynamic() {
        assertEquals(testGetTeamPopulationDynamicResult, instanceTeamApi.getTeamPopulationDynamic(testGetTeamPopulationDynamicArg1));
    }

    @Test
    public void testTeamCreateinstance() {
        assertEquals(testTeamCreateinstanceResult, instanceTeamApi.teamCreateinstance(testTeamCreateinstanceArg1));
    }

    @Test
    public void testTeamDeleteinstance() {
        assertEquals(testTeamDeleteinstanceResult, instanceTeamApi.teamDeleteinstance(testTeamDeleteinstanceArg1));
    }

    @Test
    public void testTeamEditinstance() {
        assertEquals(testTeamEditinstanceResult, instanceTeamApi.teamEditinstance(testTeamEditinstanceArg1));
    }

    @Test
    public void testTeamAddEmployeeToTeam() {
        assertEquals(testTeamAddEmployeeToTeamResult, instanceTeamApi.teamAddEmployeeToTeam(testTeamAddEmployeeToTeamArg1));
    }

    @Test
    public void testTeamRemoveEmployeeFromTeam() {
        assertEquals(testTeamRemoveEmployeeFromTeamResult, instanceTeamApi.teamRemoveEmployeeFromTeam(testTeamRemoveEmployeeFromTeamArg1));
    }

    @Test
    public void testiiuIIUTeam() {
        assertEquals(testiiuIIUTeamResult, instanceTeamApi.iiuIIUTeam(testiiuIIUTeamArg1));
    }

    @Test
    public void testpiuPIUTeams() {
        assertEquals(testpiuPIUTeamsResult.getTotalItems(), instanceTeamApi.piuPIUTeams(testpiuPIUTeamsArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUTeams2() {
        assertEquals(testpiuPIUTeams2Result.getTotalItems(), instanceTeamApi.piuPIUTeams(testpiuPIUTeams2Arg1).getTotalItems());
    }
}
