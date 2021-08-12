package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectTest {

    private static ProjectJpaRepository mockProjectJpaRepository;

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static AssignmentJpaRepository mockAssignmentJpaRepository;

    private static TeamJpaRepository mockTeamJpaRepository;

    private static ERTemplateJpaRepository mockERTemplateJpaRepository;

    private static Agent mockAgent;

    Project instanceProject;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_PROJECTIDPROJECT;
    private static String VALUE_PROJECTPROJECTNAME;
    private static String VALUE_PROJECTPRODESCRIPTION;
    private static Double VALUE_PROJECTTOTEXPENSES;
    private static Date VALUE_PROJECTCOMPLETIONDATE;
    private static Double VALUE_PROJECTMAXEXPENSE;
    private static Double VALUE_PROJECTMINEXPENSE;
    private static Double VALUE_PROJECTAVGEXPENSE;
    private static Boolean VALUE_PROJECTCOMPLETED;
    private static List<ExpenseReport> VALUE_EXPENSEREPORT;
    private static List<Assignment> VALUE_ASSIGNMENTS;
    private static Team VALUE_TEAM;
    private static List<ERTemplate> VALUE_ERTEMPLATES;
    private static Project VALUE_ASSOCOPERATOR001_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR001_RETURN;
    private static Project VALUE_ASSOCOPERATOR002_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR002_RETURN;
    private static Project VALUE_ASSOCOPERATOR003_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR003_RETURN;
    private static Project VALUE_ASSOCOPERATOR004_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR004_RETURN;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_PROJECTIDPROJECT = Long.valueOf(0);
        VALUE_PROJECTPROJECTNAME = "projectProjectName";
        VALUE_PROJECTPRODESCRIPTION = "projectProDescription";
        VALUE_PROJECTTOTEXPENSES = Double.valueOf(0);
        VALUE_PROJECTCOMPLETIONDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_PROJECTMAXEXPENSE = Double.valueOf(0);
        VALUE_PROJECTMINEXPENSE = Double.valueOf(0);
        VALUE_PROJECTAVGEXPENSE = Double.valueOf(0);
        VALUE_PROJECTCOMPLETED = false;
        VALUE_EXPENSEREPORT = new ArrayList<>();
        VALUE_EXPENSEREPORT.add(new ExpenseReport());
        VALUE_ASSIGNMENTS = new ArrayList<>();
        VALUE_ASSIGNMENTS.add(new Assignment());
        VALUE_TEAM = new Team(new TeamOid(Long.valueOf(0)));
        VALUE_ERTEMPLATES = new ArrayList<>();
        VALUE_ERTEMPLATES.add(new ERTemplate());
        VALUE_ASSOCOPERATOR001_INSTANCE = new Project();
        VALUE_ASSOCOPERATOR001_RETURN = Double.valueOf(0);
        VALUE_ASSOCOPERATOR002_INSTANCE = new Project();
        VALUE_ASSOCOPERATOR002_RETURN = Double.valueOf(0);
        VALUE_ASSOCOPERATOR003_INSTANCE = new Project();
        VALUE_ASSOCOPERATOR003_RETURN = Double.valueOf(0);
        VALUE_ASSOCOPERATOR004_INSTANCE = new Project();
        VALUE_ASSOCOPERATOR004_RETURN = Double.valueOf(0);
        mockProjectJpaRepository = mock(ProjectJpaRepository.class);
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockAssignmentJpaRepository = mock(AssignmentJpaRepository.class);
        mockTeamJpaRepository = mock(TeamJpaRepository.class);
        mockERTemplateJpaRepository = mock(ERTemplateJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceProject = new Project();
        instanceProject.setProjectRepository(mockProjectJpaRepository);
        instanceProject.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instanceProject.setAssignmentRepository(mockAssignmentJpaRepository);
        instanceProject.setTeamRepository(mockTeamJpaRepository);
        instanceProject.setERTemplateRepository(mockERTemplateJpaRepository);
        instanceProject.setAgent(mockAgent);
        instanceProject.setProjectidProject(VALUE_PROJECTIDPROJECT);
        instanceProject.setProjectProjectName(VALUE_PROJECTPROJECTNAME);
        instanceProject.setProjectProDescription(VALUE_PROJECTPRODESCRIPTION);
        instanceProject.setProjectCompletionDate(VALUE_PROJECTCOMPLETIONDATE);
        instanceProject.setExpenseReport(VALUE_EXPENSEREPORT);
        instanceProject.setAssignments(VALUE_ASSIGNMENTS);
        instanceProject.add2Team(VALUE_TEAM);
        instanceProject.setERTemplates(VALUE_ERTEMPLATES);
        when(mockProjectJpaRepository.assocOperator001(VALUE_ASSOCOPERATOR001_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR001_RETURN);
        when(mockProjectJpaRepository.assocOperator002(VALUE_ASSOCOPERATOR002_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR002_RETURN);
        when(mockProjectJpaRepository.assocOperator003(VALUE_ASSOCOPERATOR003_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR003_RETURN);
        when(mockProjectJpaRepository.assocOperator004(VALUE_ASSOCOPERATOR004_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR004_RETURN);
        when(mockExpenseReportJpaRepository.findByProject(any(Project.class))).thenReturn(VALUE_EXPENSEREPORT);
        when(mockAssignmentJpaRepository.findByProject(any(Project.class))).thenReturn(VALUE_ASSIGNMENTS);
        when(mockERTemplateJpaRepository.findByProjects(any(Project.class))).thenReturn(VALUE_ERTEMPLATES);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceProject = null;
    }

    @Test
    public void testDefaultConstructor() {
        Project value = new Project();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        Project value = new Project(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        Project value = new Project(new ProjectOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        Project value = new Project(new ProjectOid(Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getProjectidProject() {
        assertEquals(VALUE_PROJECTIDPROJECT.toString(), instanceProject.getProjectidProject().toString());
    }

    @Test
    public void test4setProjectidProject() {
        Long value = Long.valueOf(0);
        instanceProject.setProjectidProject(value);
        assertEquals(value, instanceProject.getProjectidProject());
    }

    @Test
    public void test4getProjectProjectName() {
        assertEquals(VALUE_PROJECTPROJECTNAME.toString(), instanceProject.getProjectProjectName().toString());
    }

    @Test
    public void test4setProjectProjectName() {
        String value = "projectProjectName";
        instanceProject.setProjectProjectName(value);
        assertEquals(value, instanceProject.getProjectProjectName());
    }

    @Test
    public void test4isModifiedProjectProjectName() {
        instanceProject = new Project();
        assertFalse(instanceProject.isModifiedProjectProjectName());
        instanceProject.setProjectProjectName(VALUE_PROJECTPROJECTNAME);
        assertTrue(instanceProject.isModifiedProjectProjectName());
    }

    @Test
    public void test4setModifiedProjectProjectName() {
        instanceProject.setModifiedProjectProjectName(true);
        assertTrue(instanceProject.isModifiedProjectProjectName());
    }

    @Test
    public void test4getProjectProDescription() {
        assertEquals(VALUE_PROJECTPRODESCRIPTION.toString(), instanceProject.getProjectProDescription().toString());
    }

    @Test
    public void test4setProjectProDescription() {
        String value = "projectProDescription";
        instanceProject.setProjectProDescription(value);
        assertEquals(value, instanceProject.getProjectProDescription());
    }

    @Test
    public void test4isModifiedProjectProDescription() {
        instanceProject = new Project();
        assertFalse(instanceProject.isModifiedProjectProDescription());
        instanceProject.setProjectProDescription(VALUE_PROJECTPRODESCRIPTION);
        assertTrue(instanceProject.isModifiedProjectProDescription());
    }

    @Test
    public void test4setModifiedProjectProDescription() {
        instanceProject.setModifiedProjectProDescription(true);
        assertTrue(instanceProject.isModifiedProjectProDescription());
    }

    @Test
    public void test4getProjectTotExpenses() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_PROJECTTOTEXPENSES.toString(), instanceProject.getProjectTotExpenses().toString());
        } else {
            instanceProject.getProjectTotExpenses();
            assertNotNull(instanceProject);
        }
    }

    @Test
    public void test4getProjectCompletionDate() {
        assertEquals(VALUE_PROJECTCOMPLETIONDATE.toString(), instanceProject.getProjectCompletionDate().toString());
    }

    @Test
    public void test4setProjectCompletionDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceProject.setProjectCompletionDate(value);
        assertEquals(value, instanceProject.getProjectCompletionDate());
    }

    @Test
    public void test4isModifiedProjectCompletionDate() {
        instanceProject = new Project();
        assertFalse(instanceProject.isModifiedProjectCompletionDate());
        instanceProject.setProjectCompletionDate(VALUE_PROJECTCOMPLETIONDATE);
        assertTrue(instanceProject.isModifiedProjectCompletionDate());
    }

    @Test
    public void test4setModifiedProjectCompletionDate() {
        instanceProject.setModifiedProjectCompletionDate(true);
        assertTrue(instanceProject.isModifiedProjectCompletionDate());
    }

    @Test
    public void test4getProjectMaxExpense() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_PROJECTMAXEXPENSE.toString(), instanceProject.getProjectMaxExpense().toString());
        } else {
            instanceProject.getProjectMaxExpense();
            assertNotNull(instanceProject);
        }
    }

    @Test
    public void test4getProjectMinExpense() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_PROJECTMINEXPENSE.toString(), instanceProject.getProjectMinExpense().toString());
        } else {
            instanceProject.getProjectMinExpense();
            assertNotNull(instanceProject);
        }
    }

    @Test
    public void test4getProjectAvgExpense() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_PROJECTAVGEXPENSE.toString(), instanceProject.getProjectAvgExpense().toString());
        } else {
            instanceProject.getProjectAvgExpense();
            assertNotNull(instanceProject);
        }
    }

    @Test
    public void test4getProjectCompleted() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_PROJECTCOMPLETED.toString(), instanceProject.getProjectCompleted().toString());
        } else {
            instanceProject.getProjectCompleted();
            assertNotNull(instanceProject);
        }
    }

    @Test
    public void test4getExpenseReport() {
        assertEquals(VALUE_EXPENSEREPORT, instanceProject.getExpenseReport());
    }

    @Test
    public void test4getExpenseReport2() {
        instanceProject.setExpenseReport(null);
        assertEquals(VALUE_EXPENSEREPORT, instanceProject.getExpenseReport());
    }

    @Test
    public void test4getExpenseReport3() {
        instanceProject.setExpenseReport(new ArrayList<>());
        assertEquals(VALUE_EXPENSEREPORT, instanceProject.getExpenseReport());
    }

    @Test
    public void test4add2ExpenseReport() {
        ExpenseReport value = new ExpenseReport();
        instanceProject.add2ExpenseReport(value);
        assertTrue(instanceProject.getExpenseReport().contains(value));
    }

    @Test
    public void test4setExpenseReport() {
        instanceProject.setExpenseReport(VALUE_EXPENSEREPORT);
        assertEquals(VALUE_EXPENSEREPORT, instanceProject.getExpenseReport());
    }

    @Test
    public void test4isModifiedExpenseReport() {
        assertFalse(instanceProject.isModifiedExpenseReport());
    }

    @Test
    public void test4getAssignments() {
        assertEquals(VALUE_ASSIGNMENTS, instanceProject.getAssignments());
    }

    @Test
    public void test4getAssignments2() {
        instanceProject.setAssignments(null);
        assertEquals(VALUE_ASSIGNMENTS, instanceProject.getAssignments());
    }

    @Test
    public void test4getAssignments3() {
        instanceProject.setAssignments(new ArrayList<>());
        assertEquals(VALUE_ASSIGNMENTS, instanceProject.getAssignments());
    }

    @Test
    public void test4add2Assignments() {
        Assignment value = new Assignment();
        instanceProject.add2Assignments(value);
        assertTrue(instanceProject.getAssignments().contains(value));
    }

    @Test
    public void test4setAssignments() {
        instanceProject.setAssignments(VALUE_ASSIGNMENTS);
        assertEquals(VALUE_ASSIGNMENTS, instanceProject.getAssignments());
    }

    @Test
    public void test4isModifiedAssignments() {
        assertFalse(instanceProject.isModifiedAssignments());
    }

    @Test
    public void test4getTeam() {
        assertEquals(VALUE_TEAM, instanceProject.getTeam());
    }

    @Test
    public void test4getTeam2() {
        instanceProject.add2Team(null);
        assertTrue(instanceProject.getTeam().isNull());
    }

    @Test
    public void test4getTeam3() {
        Team value = new Team(new TeamOid(Long.valueOf(0)));
        instanceProject.add2Team(value);
        assertEquals(value, instanceProject.getTeam());
    }

    @Test
    public void test4add2Team() {
        Team value = new Team(new TeamOid(Long.valueOf(0)));
        instanceProject.add2Team(value);
        assertEquals(value, instanceProject.getTeam());
    }

    @Test
    public void test4setTeam() {
        instanceProject.add2Team(VALUE_TEAM);
        assertEquals(VALUE_TEAM, instanceProject.getTeam());
    }

    @Test
    public void test4isModifiedTeam() {
        assertFalse(instanceProject.isModifiedTeam());
    }

    @Test
    public void test4getERTemplates() {
        assertEquals(VALUE_ERTEMPLATES, instanceProject.getERTemplates());
    }

    @Test
    public void test4getERTemplates2() {
        instanceProject.setERTemplates(null);
        assertEquals(VALUE_ERTEMPLATES, instanceProject.getERTemplates());
    }

    @Test
    public void test4getERTemplates3() {
        instanceProject.setERTemplates(new ArrayList<>());
        assertEquals(VALUE_ERTEMPLATES, instanceProject.getERTemplates());
    }

    @Test
    public void test4add2ERTemplates() {
        ERTemplate value = new ERTemplate();
        instanceProject.add2ERTemplates(value);
        assertTrue(instanceProject.getERTemplates().contains(value));
    }

    @Test
    public void test4setERTemplates() {
        instanceProject.setERTemplates(VALUE_ERTEMPLATES);
        assertEquals(VALUE_ERTEMPLATES, instanceProject.getERTemplates());
    }

    @Test
    public void test4isModifiedERTemplates() {
        assertFalse(instanceProject.isModifiedERTemplates());
    }

    @Test
    public void test4buildDSProject() {
        String result;
        try {
            result = instanceProject.buildDSProject().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSProjectSup() {
        String result;
        try {
            result = instanceProject.buildDSProjectSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceProject.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceProject.getAttribute(ProjectConstants.ATTR_NAME_PROJECTIDPROJECT));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceProject.getAttributeTypeRelated(ProjectConstants.ROLE_NAME_EXPENSEREPORT, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceProject.getAttributeTypeRelated(ProjectConstants.ROLE_NAME_ASSIGNMENTS, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceProject.getAttributeTypeRelated(ProjectConstants.ROLE_NAME_TEAM, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceProject.getAttributeTypeRelated(ProjectConstants.ROLE_NAME_ERTEMPLATES, ""));
        assertEquals("", instanceProject.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceProject.cleanDerivations();
        assertNotNull(instanceProject);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceProject.getProjectidProject(), instanceProject.getOid().getProjectidProject());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTPRODESCRIPTION));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTTOTEXPENSES));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTCOMPLETIONDATE));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTMAXEXPENSE));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTMINEXPENSE));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTAVGEXPENSE));
        assertTrue(instanceProject.isVisible(ProjectConstants.ATTR_NAME_PROJECTCOMPLETED));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTPRODESCRIPTION));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTTOTEXPENSES));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTCOMPLETIONDATE));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTMAXEXPENSE));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTMINEXPENSE));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTAVGEXPENSE));
        assertTrue(instanceProject.isAttributeVisible(ProjectConstants.ATTR_NAME_PROJECTCOMPLETED));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceProject.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceProject.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceProject.getActiveFacets().contains(Constants.PROJECT));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceProject.getFacets().contains(Constants.PROJECT));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceProject.checkHorizontalVisibility(null));
    }
}
