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
public class DSTeamTest {

    private DSTeam instanceDSTeam;

    // testDSTeam
    private static Team testDSTeamArg1;

    // testDSTeam2
    private static Team testDSTeam2Arg1;

    // testgetDSTeamId

    // testsetDSTeamId
    private static Long testsetDSTeamIdArg1;

    // testgetDSTeamName

    // testsetDSTeamName
    private static String testsetDSTeamNameArg1;

    // testgetDSTeamMaxEmployees

    // testsetDSTeamMaxEmployees
    private static Long testsetDSTeamMaxEmployeesArg1;

    // testgetDSTeamCountEmployees

    // testsetDSTeamCountEmployees
    private static Long testsetDSTeamCountEmployeesArg1;

    // testgetDSTeamTotalExpenses

    // testsetDSTeamTotalExpenses
    private static Double testsetDSTeamTotalExpensesArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSTeam();
        setUpMockData4testDSTeam2();
        setUpMockData4testgetDSTeamId();
        setUpMockData4testsetDSTeamId();
        setUpMockData4testgetDSTeamName();
        setUpMockData4testsetDSTeamName();
        setUpMockData4testgetDSTeamMaxEmployees();
        setUpMockData4testsetDSTeamMaxEmployees();
        setUpMockData4testgetDSTeamCountEmployees();
        setUpMockData4testsetDSTeamCountEmployees();
        setUpMockData4testgetDSTeamTotalExpenses();
        setUpMockData4testsetDSTeamTotalExpenses();
    }

    private static void setUpMockData4testDSTeam() {
        testDSTeamArg1 = new Team();
    }

    private static void setUpMockData4testDSTeam2() {
        testDSTeam2Arg1 = null;
    }

    private static void setUpMockData4testgetDSTeamId() {
    }

    private static void setUpMockData4testsetDSTeamId() {
        testsetDSTeamIdArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamName() {
    }

    private static void setUpMockData4testsetDSTeamName() {
        testsetDSTeamNameArg1 = "";
    }

    private static void setUpMockData4testgetDSTeamMaxEmployees() {
    }

    private static void setUpMockData4testsetDSTeamMaxEmployees() {
        testsetDSTeamMaxEmployeesArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamCountEmployees() {
    }

    private static void setUpMockData4testsetDSTeamCountEmployees() {
        testsetDSTeamCountEmployeesArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTeamTotalExpenses() {
    }

    private static void setUpMockData4testsetDSTeamTotalExpenses() {
        testsetDSTeamTotalExpensesArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSTeam = new DSTeam();
        instanceDSTeam.setDSTeamId(Long.valueOf(0));
        instanceDSTeam.setDSTeamName("");
        instanceDSTeam.setDSTeamMaxEmployees(Long.valueOf(0));
        instanceDSTeam.setDSTeamCountEmployees(Long.valueOf(0));
        instanceDSTeam.setDSTeamTotalExpenses(Double.valueOf(0));
    }

    @Test
    public void testDSTeam() {
        instanceDSTeam = new DSTeam(testDSTeamArg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testDSTeam2() {
        instanceDSTeam = new DSTeam(testDSTeam2Arg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testgetDSTeamId() {
        assertEquals(Long.valueOf(0), instanceDSTeam.getDSTeamId());
    }

    @Test
    public void testsetDSTeamId() {
        instanceDSTeam.setDSTeamId(testsetDSTeamIdArg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testgetDSTeamName() {
        assertEquals("", instanceDSTeam.getDSTeamName());
    }

    @Test
    public void testsetDSTeamName() {
        instanceDSTeam.setDSTeamName(testsetDSTeamNameArg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testgetDSTeamMaxEmployees() {
        assertEquals(Long.valueOf(0), instanceDSTeam.getDSTeamMaxEmployees());
    }

    @Test
    public void testsetDSTeamMaxEmployees() {
        instanceDSTeam.setDSTeamMaxEmployees(testsetDSTeamMaxEmployeesArg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testgetDSTeamCountEmployees() {
        assertEquals(Long.valueOf(0), instanceDSTeam.getDSTeamCountEmployees());
    }

    @Test
    public void testsetDSTeamCountEmployees() {
        instanceDSTeam.setDSTeamCountEmployees(testsetDSTeamCountEmployeesArg1);
        assertNotNull(instanceDSTeam);
    }

    @Test
    public void testgetDSTeamTotalExpenses() {
        assertEquals(Double.valueOf(0), instanceDSTeam.getDSTeamTotalExpenses());
    }

    @Test
    public void testsetDSTeamTotalExpenses() {
        instanceDSTeam.setDSTeamTotalExpenses(testsetDSTeamTotalExpensesArg1);
        assertNotNull(instanceDSTeam);
    }
}
