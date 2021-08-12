package com.integranova.spring.expensereportdemo.api.project;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.project.ProjectApi;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.service.ProjectService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.SELProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
public class ProjectApiTest {

    @Mock
    private ProjectService mockProjectService;

    @InjectMocks
    private ProjectApi instanceProjectApi;

    // testGetDSProject
    private static String testGetDSProjectArg1;
    private static String testGetDSProjectArg2;
    private static String testGetDSProjectArg3;
    private static DSProject testGetDSProjectResult;

    // testGetDSProject2
    private static String testGetDSProject2Arg1;
    private static String testGetDSProject2Arg2;
    private static String testGetDSProject2Arg3;
    private static DSProject testGetDSProject2Result;

    // testGetDSProject3
    private static String testGetDSProject3Arg1;
    private static String testGetDSProject3Arg2;
    private static String testGetDSProject3Arg3;
    private static DSProject testGetDSProject3Result;

    // testGetDSProject4
    private static String testGetDSProject4Arg1;
    private static String testGetDSProject4Arg2;
    private static String testGetDSProject4Arg3;
    private static DSProject testGetDSProject4Result;

    // testGetDSProjectSup
    private static String testGetDSProjectSupArg1;
    private static String testGetDSProjectSupArg2;
    private static String testGetDSProjectSupArg3;
    private static DSProjectSup testGetDSProjectSupResult;

    // testGetDSProjectSup2
    private static String testGetDSProjectSup2Arg1;
    private static String testGetDSProjectSup2Arg2;
    private static String testGetDSProjectSup2Arg3;
    private static DSProjectSup testGetDSProjectSup2Result;

    // testGetDSProjectSup3
    private static String testGetDSProjectSup3Arg1;
    private static String testGetDSProjectSup3Arg2;
    private static String testGetDSProjectSup3Arg3;
    private static DSProjectSup testGetDSProjectSup3Result;

    // testGetDSProjectSup4
    private static String testGetDSProjectSup4Arg1;
    private static String testGetDSProjectSup4Arg2;
    private static String testGetDSProjectSup4Arg3;
    private static DSProjectSup testGetDSProjectSup4Result;

    // testGetProject
    private static Long testGetProjectArg1;
    private static Project testGetProjectResult;

    // testGetProjectDynamic
    private static QueryRequest testGetProjectDynamicArg1;
    private static ProjectOid mockGetProjectDynamicArg1;
    private static String mockGetProjectDynamicArg2;
    private static InstanceResponseViewModel testGetProjectDynamicResult;

    // testGetProjectPreload
    private static QueryRequest testGetProjectPreloadArg1;
    private static List<PreloadViewModel> testGetProjectPreloadResult;

    // testGetProjectWithDisplaySetDynamic
    private static QueryRequest testGetProjectWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetProjectWithDisplaySetDynamicResult;

    // testGetProjectPopulationDynamic
    private static QueryRequest testGetProjectPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetProjectPopulationDynamicResult;

    // testGetProjectByTeam
    private static TeamOid testGetProjectByTeamArg1;
    private static List<Project> testGetProjectByTeamResult;

    // testProjectCreateinstance
    private static CreateinstanceRequest testProjectCreateinstanceArg1;
    private static ServiceResponse testProjectCreateinstanceResult;

    // testProjectDeleteinstance
    private static DeleteinstanceRequest testProjectDeleteinstanceArg1;
    private static ServiceResponse testProjectDeleteinstanceResult;

    // testProjectEditinstance
    private static EditinstanceRequest testProjectEditinstanceArg1;
    private static ServiceResponse testProjectEditinstanceResult;

    // testProjectAssignTemplateToProject
    private static AssignTemplateToProjectRequest testProjectAssignTemplateToProjectArg1;
    private static ServiceResponse testProjectAssignTemplateToProjectResult;

    // testProjectDeassignTemplate
    private static DeassignTemplateRequest testProjectDeassignTemplateArg1;
    private static ServiceResponse testProjectDeassignTemplateResult;

    // testProjectTCOMPLETE
    private static TCOMPLETERequest testProjectTCOMPLETEArg1;
    private static ServiceResponse testProjectTCOMPLETEResult;

    // testiiuIIUProject
    private static ProjectOid testiiuIIUProjectArg1;
    private static DSProject testiiuIIUProjectResult;

    // testiiuIIUProjectReports
    private static ProjectOid testiiuIIUProjectReportsArg1;
    private static DSProject testiiuIIUProjectReportsResult;

    // testpiuPIUProject
    private static PIUProjectRequest testpiuPIUProjectArg1;
    private static QueryRequest testpiuPIUProjectMockArg1;
    private static List<DSProject> testpiuPIUProjectMockResult;
    private static PIUProjectResponse testpiuPIUProjectResult;

    // testpiuPIUProject2
    private static PIUProjectRequest testpiuPIUProject2Arg1;
    private static QueryRequest testpiuPIUProject2MockArg1;
    private static List<DSProject> testpiuPIUProject2MockResult;
    private static PIUProjectResponse testpiuPIUProject2Result;

    // testpiuSELProject
    private static PopulationRequestViewModel testpiuSELProjectArg1;
    private static QueryRequest testpiuSELProjectMockArg1;
    private static List<DSProject> testpiuSELProjectMockResult;
    private static SELProjectResponse testpiuSELProjectResult;

    // testpiuSELProject2
    private static PopulationRequestViewModel testpiuSELProject2Arg1;
    private static QueryRequest testpiuSELProject2MockArg1;
    private static List<DSProject> testpiuSELProject2MockResult;
    private static SELProjectResponse testpiuSELProject2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSProject();
        setUpMockData4testGetDSProject2();
        setUpMockData4testGetDSProject3();
        setUpMockData4testGetDSProject4();
        setUpMockData4testGetDSProjectSup();
        setUpMockData4testGetDSProjectSup2();
        setUpMockData4testGetDSProjectSup3();
        setUpMockData4testGetDSProjectSup4();
        setUpMockData4testGetProject();
        setUpMockData4testGetProjectDynamic();
        setUpMockData4testGetProjectPreload();
        setUpMockData4testGetProjectWithDisplaySetDynamic();
        setUpMockData4testGetProjectPopulationDynamic();
        setUpMockData4testGetProjectByTeam();
        setUpMockData4testProjectCreateinstance();
        setUpMockData4testProjectDeleteinstance();
        setUpMockData4testProjectEditinstance();
        setUpMockData4testProjectAssignTemplateToProject();
        setUpMockData4testProjectDeassignTemplate();
        setUpMockData4testProjectTCOMPLETE();
        setUpMockData4testiiuIIUProject();
        setUpMockData4testiiuIIUProjectReports();
        setUpMockData4testpiuPIUProject();
        setUpMockData4testpiuPIUProject2();
        setUpMockData4testpiuSELProject();
        setUpMockData4testpiuSELProject2();
    }

    private static void setUpMockData4testGetDSProject() {
        testGetDSProjectArg1 = "";
        testGetDSProjectArg2 = "";
        testGetDSProjectArg3 = "";
        testGetDSProjectResult = new DSProject();
    }

    private static void setUpMockData4testGetDSProject2() {
        testGetDSProject2Arg1 = "";
        testGetDSProject2Arg2 = null;
        testGetDSProject2Arg3 = null;
        testGetDSProject2Result = testGetDSProjectResult;
    }

    private static void setUpMockData4testGetDSProject3() {
        testGetDSProject3Arg1 = "";
        testGetDSProject3Arg2 = null;
        testGetDSProject3Arg3 = "";
        testGetDSProject3Result = testGetDSProjectResult;
    }

    private static void setUpMockData4testGetDSProject4() {
        testGetDSProject4Arg1 = "";
        testGetDSProject4Arg2 = "";
        testGetDSProject4Arg3 = null;
        testGetDSProject4Result = testGetDSProjectResult;
    }

    private static void setUpMockData4testGetDSProjectSup() {
        testGetDSProjectSupArg1 = "";
        testGetDSProjectSupArg2 = "";
        testGetDSProjectSupArg3 = "";
        testGetDSProjectSupResult = new DSProjectSup();
    }

    private static void setUpMockData4testGetDSProjectSup2() {
        testGetDSProjectSup2Arg1 = "";
        testGetDSProjectSup2Arg2 = null;
        testGetDSProjectSup2Arg3 = null;
        testGetDSProjectSup2Result = testGetDSProjectSupResult;
    }

    private static void setUpMockData4testGetDSProjectSup3() {
        testGetDSProjectSup3Arg1 = "";
        testGetDSProjectSup3Arg2 = null;
        testGetDSProjectSup3Arg3 = "";
        testGetDSProjectSup3Result = testGetDSProjectSupResult;
    }

    private static void setUpMockData4testGetDSProjectSup4() {
        testGetDSProjectSup4Arg1 = "";
        testGetDSProjectSup4Arg2 = "";
        testGetDSProjectSup4Arg3 = null;
        testGetDSProjectSup4Result = testGetDSProjectSupResult;
    }

    private static void setUpMockData4testGetProject() {
        testGetProjectArg1 = Long.valueOf(0);
        testGetProjectResult = new Project();
    }

    private static void setUpMockData4testGetProjectDynamic() {
        mockGetProjectDynamicArg1 = new ProjectOid();
        mockGetProjectDynamicArg2 = "";
        testGetProjectDynamicArg1 = new QueryRequest();
        testGetProjectDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetProjectPreload() {
        testGetProjectPreloadArg1 = new QueryRequest();
        testGetProjectPreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetProjectWithDisplaySetDynamic() {
        testGetProjectWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetProjectWithDisplaySetDynamicArg1.setDisplaySetName("testGetProjectWithDisplaySetDynamicArg1");
        testGetProjectWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetProjectPopulationDynamic() {
        testGetProjectPopulationDynamicArg1 = new QueryRequest();
        testGetProjectPopulationDynamicArg1.setDisplaySetName("testGetProjectPopulationDynamicArg1");
        testGetProjectPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetProjectByTeam() {
        testGetProjectByTeamArg1 = new TeamOid();
        testGetProjectByTeamResult = new ArrayList<>();
    }

    private static void setUpMockData4testProjectCreateinstance() {
        testProjectCreateinstanceArg1 = new CreateinstanceRequest();
        testProjectCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testProjectDeleteinstance() {
        testProjectDeleteinstanceArg1 = new DeleteinstanceRequest();
        testProjectDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testProjectEditinstance() {
        testProjectEditinstanceArg1 = new EditinstanceRequest();
        testProjectEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testProjectAssignTemplateToProject() {
        testProjectAssignTemplateToProjectArg1 = new AssignTemplateToProjectRequest();
        testProjectAssignTemplateToProjectResult = new ServiceResponse();
    }

    private static void setUpMockData4testProjectDeassignTemplate() {
        testProjectDeassignTemplateArg1 = new DeassignTemplateRequest();
        testProjectDeassignTemplateResult = new ServiceResponse();
    }

    private static void setUpMockData4testProjectTCOMPLETE() {
        testProjectTCOMPLETEArg1 = new TCOMPLETERequest();
        testProjectTCOMPLETEResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUProject() {
        testiiuIIUProjectArg1 = new ProjectOid();
        testiiuIIUProjectResult = new DSProject();
    }

    private static void setUpMockData4testiiuIIUProjectReports() {
        testiiuIIUProjectReportsArg1 = new ProjectOid();
        testiiuIIUProjectReportsResult = new DSProject();
    }

    private static void setUpMockData4testpiuPIUProject() {
        testpiuPIUProjectMockArg1 = new QueryRequest();
        testpiuPIUProjectMockArg1.setPageSize(0);
        testpiuPIUProjectMockResult = new ArrayList<>();
        testpiuPIUProjectArg1 = mock(PIUProjectRequest.class);
        testpiuPIUProjectResult = new PIUProjectResponse();
    }

    private static void setUpMockData4testpiuPIUProject2() {
        testpiuPIUProject2MockArg1 = new QueryRequest();
        testpiuPIUProject2MockArg1.setPageSize(1);
        testpiuPIUProject2MockResult = new ArrayList<>();
        testpiuPIUProject2MockResult.add(new DSProject());
        testpiuPIUProject2Arg1 = mock(PIUProjectRequest.class);
        testpiuPIUProject2Arg1.setPageSize(1);
        testpiuPIUProject2Result = new PIUProjectResponse();
        testpiuPIUProject2Result.setTotalItems(1);
    }

    private static void setUpMockData4testpiuSELProject() {
        testpiuSELProjectMockArg1 = new QueryRequest();
        testpiuSELProjectMockArg1.setPageSize(0);
        testpiuSELProjectMockResult = new ArrayList<>();
        testpiuSELProjectArg1 = mock(PopulationRequestViewModel.class);
        testpiuSELProjectResult = new SELProjectResponse();
    }

    private static void setUpMockData4testpiuSELProject2() {
        testpiuSELProject2MockArg1 = new QueryRequest();
        testpiuSELProject2MockArg1.setPageSize(1);
        testpiuSELProject2MockResult = new ArrayList<>();
        testpiuSELProject2MockResult.add(new DSProject());
        testpiuSELProject2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuSELProject2Arg1.setPageSize(1);
        testpiuSELProject2Result = new SELProjectResponse();
        testpiuSELProject2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockProjectService.getDSProject(testGetDSProjectArg1, testGetDSProjectArg2, testGetDSProjectArg3)).thenReturn(testGetDSProjectResult);

        when(mockProjectService.getDSProjectSup(testGetDSProjectSupArg1, testGetDSProjectSupArg2, testGetDSProjectSupArg3)).thenReturn(testGetDSProjectSupResult);

        when(mockProjectService.getById(testGetProjectArg1)).thenReturn(testGetProjectResult);

        when(mockProjectService.getProjectDynamic(mockGetProjectDynamicArg1, mockGetProjectDynamicArg2)).thenReturn(testGetProjectDynamicResult);

        when(mockProjectService.getPreload(testGetProjectPreloadArg1)).thenReturn(testGetProjectPreloadResult);

        when(mockProjectService.getDynamic(testGetProjectWithDisplaySetDynamicArg1)).thenReturn(testGetProjectWithDisplaySetDynamicResult);

        when(mockProjectService.getDynamic(testGetProjectPopulationDynamicArg1)).thenReturn(testGetProjectPopulationDynamicResult);

        when(mockProjectService.getInstancesByRelated(any(Team.class), eq("Team"))).thenReturn(testGetProjectByTeamResult);

        when(mockProjectService.createinstance(testProjectCreateinstanceArg1)).thenReturn(testProjectCreateinstanceResult);

        when(mockProjectService.deleteinstance(testProjectDeleteinstanceArg1)).thenReturn(testProjectDeleteinstanceResult);

        when(mockProjectService.editinstance(testProjectEditinstanceArg1)).thenReturn(testProjectEditinstanceResult);

        when(mockProjectService.assignTemplateToProject(testProjectAssignTemplateToProjectArg1)).thenReturn(testProjectAssignTemplateToProjectResult);

        when(mockProjectService.deassignTemplate(testProjectDeassignTemplateArg1)).thenReturn(testProjectDeassignTemplateResult);

        when(mockProjectService.tCOMPLETE(testProjectTCOMPLETEArg1)).thenReturn(testProjectTCOMPLETEResult);

        when(mockProjectService.iIUProject(testiiuIIUProjectArg1)).thenReturn(testiiuIIUProjectResult);

        when(mockProjectService.iIUProjectReports(testiiuIIUProjectReportsArg1)).thenReturn(testiiuIIUProjectReportsResult);

        when(testpiuPIUProjectArg1.buildQueryRequest()).thenReturn(testpiuPIUProjectMockArg1);

        when(mockProjectService.piuPIUProject(testpiuPIUProjectMockArg1)).thenReturn(testpiuPIUProjectMockResult);

        when(testpiuPIUProject2Arg1.buildQueryRequest()).thenReturn(testpiuPIUProject2MockArg1);

        when(mockProjectService.piuPIUProject(testpiuPIUProject2MockArg1)).thenReturn(testpiuPIUProject2MockResult);

        when(mockProjectService.getCount4PIUProject(testpiuPIUProject2MockArg1)).thenReturn(1);

        when(testpiuSELProjectArg1.buildQueryRequest()).thenReturn(testpiuSELProjectMockArg1);

        when(mockProjectService.piuSELProject(testpiuSELProjectMockArg1)).thenReturn(testpiuSELProjectMockResult);

        when(testpiuSELProject2Arg1.buildQueryRequest()).thenReturn(testpiuSELProject2MockArg1);

        when(mockProjectService.piuSELProject(testpiuSELProject2MockArg1)).thenReturn(testpiuSELProject2MockResult);

        when(mockProjectService.getCount4SELProject(testpiuSELProject2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSProject() {
        assertEquals(testGetDSProjectResult, instanceProjectApi.getDSProject(testGetDSProjectArg1, testGetDSProjectArg2, testGetDSProjectArg3));
    }

    @Test
    public void testGetDSProject2() {
        assertEquals(testGetDSProject2Result, instanceProjectApi.getDSProject(testGetDSProject2Arg1, testGetDSProject2Arg2, testGetDSProject2Arg3));
    }

    @Test
    public void testGetDSProject3() {
        assertEquals(testGetDSProject3Result, instanceProjectApi.getDSProject(testGetDSProject3Arg1, testGetDSProject3Arg2, testGetDSProject3Arg3));
    }

    @Test
    public void testGetDSProject4() {
        assertEquals(testGetDSProject4Result, instanceProjectApi.getDSProject(testGetDSProject4Arg1, testGetDSProject4Arg2, testGetDSProject4Arg3));
    }

    @Test
    public void testGetDSProjectSup() {
        assertEquals(testGetDSProjectSupResult, instanceProjectApi.getDSProjectSup(testGetDSProjectSupArg1, testGetDSProjectSupArg2, testGetDSProjectSupArg3));
    }

    @Test
    public void testGetDSProjectSup2() {
        assertEquals(testGetDSProjectSup2Result, instanceProjectApi.getDSProjectSup(testGetDSProjectSup2Arg1, testGetDSProjectSup2Arg2, testGetDSProjectSup2Arg3));
    }

    @Test
    public void testGetDSProjectSup3() {
        assertEquals(testGetDSProjectSup3Result, instanceProjectApi.getDSProjectSup(testGetDSProjectSup3Arg1, testGetDSProjectSup3Arg2, testGetDSProjectSup3Arg3));
    }

    @Test
    public void testGetDSProjectSup4() {
        assertEquals(testGetDSProjectSup4Result, instanceProjectApi.getDSProjectSup(testGetDSProjectSup4Arg1, testGetDSProjectSup4Arg2, testGetDSProjectSup4Arg3));
    }

    @Test
    public void testGetProject() {
        assertEquals(testGetProjectResult, instanceProjectApi.getProject(testGetProjectArg1));
    }

    @Test
    public void testGetProjectDynamic() {
        assertEquals(testGetProjectDynamicResult, instanceProjectApi.getProjectDynamic(testGetProjectDynamicArg1));
    }

    @Test
    public void testGetProjectPreload() {
        assertEquals(testGetProjectPreloadResult, instanceProjectApi.getProjectPreload(testGetProjectPreloadArg1));
    }

    @Test
    public void testGetProjectWithDisplaySetDynamic() {
        assertEquals(testGetProjectWithDisplaySetDynamicResult, instanceProjectApi.getProjectWithDisplaySetDynamic(testGetProjectWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetProjectPopulationDynamic() {
        assertEquals(testGetProjectPopulationDynamicResult, instanceProjectApi.getProjectPopulationDynamic(testGetProjectPopulationDynamicArg1));
    }

    @Test
    public void testGetProjectByTeam() {
        assertEquals(testGetProjectByTeamResult, instanceProjectApi.getProjectByTeam(testGetProjectByTeamArg1));
    }

    @Test
    public void testProjectCreateinstance() {
        assertEquals(testProjectCreateinstanceResult, instanceProjectApi.projectCreateinstance(testProjectCreateinstanceArg1));
    }

    @Test
    public void testProjectDeleteinstance() {
        assertEquals(testProjectDeleteinstanceResult, instanceProjectApi.projectDeleteinstance(testProjectDeleteinstanceArg1));
    }

    @Test
    public void testProjectEditinstance() {
        assertEquals(testProjectEditinstanceResult, instanceProjectApi.projectEditinstance(testProjectEditinstanceArg1));
    }

    @Test
    public void testProjectAssignTemplateToProject() {
        assertEquals(testProjectAssignTemplateToProjectResult, instanceProjectApi.projectAssignTemplateToProject(testProjectAssignTemplateToProjectArg1));
    }

    @Test
    public void testProjectDeassignTemplate() {
        assertEquals(testProjectDeassignTemplateResult, instanceProjectApi.projectDeassignTemplate(testProjectDeassignTemplateArg1));
    }

    @Test
    public void testProjectTCOMPLETE() {
        assertEquals(testProjectTCOMPLETEResult, instanceProjectApi.projectTCOMPLETE(testProjectTCOMPLETEArg1));
    }

    @Test
    public void testiiuIIUProject() {
        assertEquals(testiiuIIUProjectResult, instanceProjectApi.iiuIIUProject(testiiuIIUProjectArg1));
    }

    @Test
    public void testiiuIIUProjectReports() {
        assertEquals(testiiuIIUProjectReportsResult, instanceProjectApi.iiuIIUProjectReports(testiiuIIUProjectReportsArg1));
    }

    @Test
    public void testpiuPIUProject() {
        assertEquals(testpiuPIUProjectResult.getTotalItems(), instanceProjectApi.piuPIUProject(testpiuPIUProjectArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUProject2() {
        assertEquals(testpiuPIUProject2Result.getTotalItems(), instanceProjectApi.piuPIUProject(testpiuPIUProject2Arg1).getTotalItems());
    }

    @Test
    public void testpiuSELProject() {
        assertEquals(testpiuSELProjectResult.getTotalItems(), instanceProjectApi.piuSELProject(testpiuSELProjectArg1).getTotalItems());
    }

    @Test
    public void testpiuSELProject2() {
        assertEquals(testpiuSELProject2Result.getTotalItems(), instanceProjectApi.piuSELProject(testpiuSELProject2Arg1).getTotalItems());
    }
}
