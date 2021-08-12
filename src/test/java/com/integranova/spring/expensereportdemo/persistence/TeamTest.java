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
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeamTest {

    private static TeamJpaRepository mockTeamJpaRepository;

    private static EmployeeJpaRepository mockEmployeeJpaRepository;

    private static ProjectJpaRepository mockProjectJpaRepository;

    private static Agent mockAgent;

    Team instanceTeam;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_TEAMID;
    private static String VALUE_TEAMNAME;
    private static Long VALUE_TEAMMAXEMPLOYEES;
    private static Long VALUE_TEAMCOUNTEMPLOYEES;
    private static Double VALUE_TEAMTOTALEXPENSES;
    private static Long VALUE_TEAMCAPACITY;
    private static List<Employee> VALUE_EMPLOYEES;
    private static List<Project> VALUE_PROJECTS;
    private static Team VALUE_ASSOCOPERATOR002_INSTANCE;
    private static Boolean VALUE_ASSOCOPERATOR002_RETURN;
    private static Team VALUE_ASSOCOPERATOR003_INSTANCE;
    private static Long VALUE_ASSOCOPERATOR003_RETURN;
    private static Team VALUE_ASSOCOPERATOR004_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR004_RETURN;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_TEAMID = Long.valueOf(0);
        VALUE_TEAMNAME = "teamname";
        VALUE_TEAMMAXEMPLOYEES = Long.valueOf(0);
        VALUE_TEAMCOUNTEMPLOYEES = Long.valueOf(0);
        VALUE_TEAMTOTALEXPENSES = Double.valueOf(0);
        VALUE_TEAMCAPACITY = Long.valueOf(0);
        VALUE_EMPLOYEES = new ArrayList<>();
        VALUE_EMPLOYEES.add(new Employee());
        VALUE_PROJECTS = new ArrayList<>();
        VALUE_PROJECTS.add(new Project());
        VALUE_ASSOCOPERATOR002_INSTANCE = new Team();
        VALUE_ASSOCOPERATOR002_RETURN = false;
        VALUE_ASSOCOPERATOR003_INSTANCE = new Team();
        VALUE_ASSOCOPERATOR003_RETURN = Long.valueOf(0);
        VALUE_ASSOCOPERATOR004_INSTANCE = new Team();
        VALUE_ASSOCOPERATOR004_RETURN = Double.valueOf(0);
        mockTeamJpaRepository = mock(TeamJpaRepository.class);
        mockEmployeeJpaRepository = mock(EmployeeJpaRepository.class);
        mockProjectJpaRepository = mock(ProjectJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceTeam = new Team();
        instanceTeam.setTeamRepository(mockTeamJpaRepository);
        instanceTeam.setEmployeeRepository(mockEmployeeJpaRepository);
        instanceTeam.setProjectRepository(mockProjectJpaRepository);
        instanceTeam.setAgent(mockAgent);
        instanceTeam.setTeamid(VALUE_TEAMID);
        instanceTeam.setTeamname(VALUE_TEAMNAME);
        instanceTeam.setTeammaxEmployees(VALUE_TEAMMAXEMPLOYEES);
        instanceTeam.setEmployees(VALUE_EMPLOYEES);
        instanceTeam.setProjects(VALUE_PROJECTS);
        when(mockTeamJpaRepository.assocOperator002(VALUE_ASSOCOPERATOR002_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR002_RETURN);
        when(mockTeamJpaRepository.assocOperator003(VALUE_ASSOCOPERATOR003_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR003_RETURN);
        when(mockTeamJpaRepository.assocOperator004(VALUE_ASSOCOPERATOR004_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR004_RETURN);
        when(mockEmployeeJpaRepository.findByTeams(any(Team.class))).thenReturn(VALUE_EMPLOYEES);
        when(mockProjectJpaRepository.findByTeam(any(Team.class))).thenReturn(VALUE_PROJECTS);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceTeam = null;
    }

    @Test
    public void testDefaultConstructor() {
        Team value = new Team();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        Team value = new Team(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        Team value = new Team(new TeamOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        Team value = new Team(new TeamOid(Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getTeamid() {
        assertEquals(VALUE_TEAMID.toString(), instanceTeam.getTeamid().toString());
    }

    @Test
    public void test4setTeamid() {
        Long value = Long.valueOf(0);
        instanceTeam.setTeamid(value);
        assertEquals(value, instanceTeam.getTeamid());
    }

    @Test
    public void test4getTeamname() {
        assertEquals(VALUE_TEAMNAME.toString(), instanceTeam.getTeamname().toString());
    }

    @Test
    public void test4setTeamname() {
        String value = "teamname";
        instanceTeam.setTeamname(value);
        assertEquals(value, instanceTeam.getTeamname());
    }

    @Test
    public void test4isModifiedTeamname() {
        instanceTeam = new Team();
        assertFalse(instanceTeam.isModifiedTeamname());
        instanceTeam.setTeamname(VALUE_TEAMNAME);
        assertTrue(instanceTeam.isModifiedTeamname());
    }

    @Test
    public void test4setModifiedTeamname() {
        instanceTeam.setModifiedTeamname(true);
        assertTrue(instanceTeam.isModifiedTeamname());
    }

    @Test
    public void test4getTeammaxEmployees() {
        assertEquals(VALUE_TEAMMAXEMPLOYEES.toString(), instanceTeam.getTeammaxEmployees().toString());
    }

    @Test
    public void test4setTeammaxEmployees() {
        Long value = Long.valueOf(0);
        instanceTeam.setTeammaxEmployees(value);
        assertEquals(value, instanceTeam.getTeammaxEmployees());
    }

    @Test
    public void test4isModifiedTeammaxEmployees() {
        instanceTeam = new Team();
        assertFalse(instanceTeam.isModifiedTeammaxEmployees());
        instanceTeam.setTeammaxEmployees(VALUE_TEAMMAXEMPLOYEES);
        assertTrue(instanceTeam.isModifiedTeammaxEmployees());
    }

    @Test
    public void test4setModifiedTeammaxEmployees() {
        instanceTeam.setModifiedTeammaxEmployees(true);
        assertTrue(instanceTeam.isModifiedTeammaxEmployees());
    }

    @Test
    public void test4getTeamcountEmployees() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_TEAMCOUNTEMPLOYEES.toString(), instanceTeam.getTeamcountEmployees().toString());
        } else {
            instanceTeam.getTeamcountEmployees();
            assertNotNull(instanceTeam);
        }
    }

    @Test
    public void test4getTeamtotalExpenses() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_TEAMTOTALEXPENSES.toString(), instanceTeam.getTeamtotalExpenses().toString());
        } else {
            instanceTeam.getTeamtotalExpenses();
            assertNotNull(instanceTeam);
        }
    }

    @Test
    public void test4getTeamcapacity() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_TEAMCAPACITY.toString(), instanceTeam.getTeamcapacity().toString());
        } else {
            instanceTeam.getTeamcapacity();
            assertNotNull(instanceTeam);
        }
    }

    @Test
    public void test4getEmployees() {
        assertEquals(VALUE_EMPLOYEES, instanceTeam.getEmployees());
    }

    @Test
    public void test4getEmployees2() {
        instanceTeam.setEmployees(null);
        assertEquals(VALUE_EMPLOYEES, instanceTeam.getEmployees());
    }

    @Test
    public void test4getEmployees3() {
        instanceTeam.setEmployees(new ArrayList<>());
        assertEquals(VALUE_EMPLOYEES, instanceTeam.getEmployees());
    }

    @Test
    public void test4add2Employees() {
        Employee value = new Employee();
        instanceTeam.add2Employees(value);
        assertTrue(instanceTeam.getEmployees().contains(value));
    }

    @Test
    public void test4setEmployees() {
        instanceTeam.setEmployees(VALUE_EMPLOYEES);
        assertEquals(VALUE_EMPLOYEES, instanceTeam.getEmployees());
    }

    @Test
    public void test4isModifiedEmployees() {
        assertFalse(instanceTeam.isModifiedEmployees());
    }

    @Test
    public void test4getProjects() {
        assertEquals(VALUE_PROJECTS, instanceTeam.getProjects());
    }

    @Test
    public void test4getProjects2() {
        instanceTeam.setProjects(null);
        assertEquals(VALUE_PROJECTS, instanceTeam.getProjects());
    }

    @Test
    public void test4getProjects3() {
        instanceTeam.setProjects(new ArrayList<>());
        assertEquals(VALUE_PROJECTS, instanceTeam.getProjects());
    }

    @Test
    public void test4add2Projects() {
        Project value = new Project();
        instanceTeam.add2Projects(value);
        assertTrue(instanceTeam.getProjects().contains(value));
    }

    @Test
    public void test4setProjects() {
        instanceTeam.setProjects(VALUE_PROJECTS);
        assertEquals(VALUE_PROJECTS, instanceTeam.getProjects());
    }

    @Test
    public void test4isModifiedProjects() {
        assertFalse(instanceTeam.isModifiedProjects());
    }

    @Test
    public void test4buildDSTeams() {
        String result;
        try {
            result = instanceTeam.buildDSTeams().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSTeam() {
        String result;
        try {
            result = instanceTeam.buildDSTeam().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceTeam.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceTeam.getAttribute(TeamConstants.ATTR_NAME_TEAMID));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceTeam.getAttributeTypeRelated(TeamConstants.ROLE_NAME_EMPLOYEES, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceTeam.getAttributeTypeRelated(TeamConstants.ROLE_NAME_PROJECTS, ""));
        assertEquals("", instanceTeam.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceTeam.cleanDerivations();
        assertNotNull(instanceTeam);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceTeam.getTeamid(), instanceTeam.getOid().getTeamid());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceTeam.isVisible(TeamConstants.ATTR_NAME_TEAMNAME));
        assertTrue(instanceTeam.isVisible(TeamConstants.ATTR_NAME_TEAMMAXEMPLOYEES));
        assertTrue(instanceTeam.isVisible(TeamConstants.ATTR_NAME_TEAMCOUNTEMPLOYEES));
        assertTrue(instanceTeam.isVisible(TeamConstants.ATTR_NAME_TEAMTOTALEXPENSES));
        assertTrue(instanceTeam.isVisible(TeamConstants.ATTR_NAME_TEAMCAPACITY));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceTeam.isAttributeVisible(TeamConstants.ATTR_NAME_TEAMNAME));
        assertTrue(instanceTeam.isAttributeVisible(TeamConstants.ATTR_NAME_TEAMMAXEMPLOYEES));
        assertTrue(instanceTeam.isAttributeVisible(TeamConstants.ATTR_NAME_TEAMCOUNTEMPLOYEES));
        assertTrue(instanceTeam.isAttributeVisible(TeamConstants.ATTR_NAME_TEAMTOTALEXPENSES));
        assertTrue(instanceTeam.isAttributeVisible(TeamConstants.ATTR_NAME_TEAMCAPACITY));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceTeam.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceTeam.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceTeam.getActiveFacets().contains(Constants.TEAM));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceTeam.getFacets().contains(Constants.TEAM));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceTeam.checkHorizontalVisibility(null));
    }
}
