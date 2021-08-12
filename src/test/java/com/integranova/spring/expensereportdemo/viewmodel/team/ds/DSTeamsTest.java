package com.integranova.spring.expensereportdemo.viewmodel.team.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.Team;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSTeamsTest {

    private DSTeams instanceDSTeams;

    // testDSTeams
    private static Team testDSTeamsArg1;

    // testDSTeams2
    private static Team testDSTeams2Arg1;

    // testgetDSTeamsId

    // testsetDSTeamsId
    private static Long testsetDSTeamsIdArg1;

    // testgetDSTeamsName

    // testsetDSTeamsName
    private static String testsetDSTeamsNameArg1;

    // testgetDSTeamsMaxEmployees

    // testsetDSTeamsMaxEmployees
    private static Long testsetDSTeamsMaxEmployeesArg1;

    // testgetDSTeamsCountEmployees

    // testsetDSTeamsCountEmployees
    private static Long testsetDSTeamsCountEmployeesArg1;

    // testgetDSTeamsTotalExpenses

    // testsetDSTeamsTotalExpenses
    private static Double testsetDSTeamsTotalExpensesArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSTeams();
        setUpMockData4testDSTeams2();
        setUpMockData4testgetDSTeamsId();
        setUpMockData4testsetDSTeamsId();
        setUpMockData4testgetDSTeamsName();
        setUpMockData4testsetDSTeamsName();
        setUpMockData4testgetDSTeamsMaxEmployees();
        setUpMockData4testsetDSTeamsMaxEmployees();
        setUpMockData4testgetDSTeamsCountEmployees();
        setUpMockData4testsetDSTeamsCountEmployees();
        setUpMockData4testgetDSTeamsTotalExpenses();
        setUpMockData4testsetDSTeamsTotalExpenses();
    }

    private static void setUpMockData4testDSTeams() {
        testDSTeamsArg1 = new Team();
    }

    private static void setUpMockData4testDSTeams2() {
        testDSTeams2Arg1 = null;
    }

    private static void setUpMockData4testgetDSTeamsId() {
    }

    private static void setUpMockData4testsetDSTeamsId() {
        testsetDSTeamsIdArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamsName() {
    }

    private static void setUpMockData4testsetDSTeamsName() {
        testsetDSTeamsNameArg1 = "";
    }

    private static void setUpMockData4testgetDSTeamsMaxEmployees() {
    }

    private static void setUpMockData4testsetDSTeamsMaxEmployees() {
        testsetDSTeamsMaxEmployeesArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamsCountEmployees() {
    }

    private static void setUpMockData4testsetDSTeamsCountEmployees() {
        testsetDSTeamsCountEmployeesArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamsTotalExpenses() {
    }

    private static void setUpMockData4testsetDSTeamsTotalExpenses() {
        testsetDSTeamsTotalExpensesArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSTeams = new DSTeams();
        instanceDSTeams.setDSTeamsId(Long.valueOf(0));
        instanceDSTeams.setDSTeamsName("");
        instanceDSTeams.setDSTeamsMaxEmployees(Long.valueOf(0));
        instanceDSTeams.setDSTeamsCountEmployees(Long.valueOf(0));
        instanceDSTeams.setDSTeamsTotalExpenses(Double.valueOf(0));
    }

    @Test
    public void testDSTeams() {
        instanceDSTeams = new DSTeams(testDSTeamsArg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testDSTeams2() {
        instanceDSTeams = new DSTeams(testDSTeams2Arg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testgetDSTeamsId() {
        assertEquals(Long.valueOf(0), instanceDSTeams.getDSTeamsId());
    }

    @Test
    public void testsetDSTeamsId() {
        instanceDSTeams.setDSTeamsId(testsetDSTeamsIdArg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testgetDSTeamsName() {
        assertEquals("", instanceDSTeams.getDSTeamsName());
    }

    @Test
    public void testsetDSTeamsName() {
        instanceDSTeams.setDSTeamsName(testsetDSTeamsNameArg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testgetDSTeamsMaxEmployees() {
        assertEquals(Long.valueOf(0), instanceDSTeams.getDSTeamsMaxEmployees());
    }

    @Test
    public void testsetDSTeamsMaxEmployees() {
        instanceDSTeams.setDSTeamsMaxEmployees(testsetDSTeamsMaxEmployeesArg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testgetDSTeamsCountEmployees() {
        assertEquals(Long.valueOf(0), instanceDSTeams.getDSTeamsCountEmployees());
    }

    @Test
    public void testsetDSTeamsCountEmployees() {
        instanceDSTeams.setDSTeamsCountEmployees(testsetDSTeamsCountEmployeesArg1);
        assertNotNull(instanceDSTeams);
    }

    @Test
    public void testgetDSTeamsTotalExpenses() {
        assertEquals(Double.valueOf(0), instanceDSTeams.getDSTeamsTotalExpenses());
    }

    @Test
    public void testsetDSTeamsTotalExpenses() {
        instanceDSTeams.setDSTeamsTotalExpenses(testsetDSTeamsTotalExpensesArg1);
        assertNotNull(instanceDSTeams);
    }
}
