package com.integranova.spring.expensereportdemo.viewmodel.project.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.Project;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSProjectTest {

    private DSProject instanceDSProject;

    // testDSProject
    private static Project testDSProjectArg1;

    // testDSProject2
    private static Project testDSProject2Arg1;

    // testgetDSProjectIdProject

    // testsetDSProjectIdProject
    private static Long testsetDSProjectIdProjectArg1;

    // testgetDSProjectProjectName

    // testsetDSProjectProjectName
    private static String testsetDSProjectProjectNameArg1;

    // testgetDSProjectTeamDotName

    // testsetDSProjectTeamDotName
    private static String testsetDSProjectTeamDotNameArg1;

    // testgetDSProjectProDescription

    // testsetDSProjectProDescription
    private static String testsetDSProjectProDescriptionArg1;

    // testgetDSProjectTotExpenses

    // testsetDSProjectTotExpenses
    private static Double testsetDSProjectTotExpensesArg1;

    // testgetDSProjectMaxExpense

    // testsetDSProjectMaxExpense
    private static Double testsetDSProjectMaxExpenseArg1;

    // testgetDSProjectMinExpense

    // testsetDSProjectMinExpense
    private static Double testsetDSProjectMinExpenseArg1;

    // testgetDSProjectAvgExpense

    // testsetDSProjectAvgExpense
    private static Double testsetDSProjectAvgExpenseArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSProject();
        setUpMockData4testDSProject2();
        setUpMockData4testgetDSProjectIdProject();
        setUpMockData4testsetDSProjectIdProject();
        setUpMockData4testgetDSProjectProjectName();
        setUpMockData4testsetDSProjectProjectName();
        setUpMockData4testgetDSProjectTeamDotName();
        setUpMockData4testsetDSProjectTeamDotName();
        setUpMockData4testgetDSProjectProDescription();
        setUpMockData4testsetDSProjectProDescription();
        setUpMockData4testgetDSProjectTotExpenses();
        setUpMockData4testsetDSProjectTotExpenses();
        setUpMockData4testgetDSProjectMaxExpense();
        setUpMockData4testsetDSProjectMaxExpense();
        setUpMockData4testgetDSProjectMinExpense();
        setUpMockData4testsetDSProjectMinExpense();
        setUpMockData4testgetDSProjectAvgExpense();
        setUpMockData4testsetDSProjectAvgExpense();
    }

    private static void setUpMockData4testDSProject() {
        testDSProjectArg1 = new Project();
    }

    private static void setUpMockData4testDSProject2() {
        testDSProject2Arg1 = null;
    }

    private static void setUpMockData4testgetDSProjectIdProject() {
    }

    private static void setUpMockData4testsetDSProjectIdProject() {
        testsetDSProjectIdProjectArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSProjectProjectName() {
    }

    private static void setUpMockData4testsetDSProjectProjectName() {
        testsetDSProjectProjectNameArg1 = "";
    }

    private static void setUpMockData4testgetDSProjectTeamDotName() {
    }

    private static void setUpMockData4testsetDSProjectTeamDotName() {
        testsetDSProjectTeamDotNameArg1 = "";
    }

    private static void setUpMockData4testgetDSProjectProDescription() {
    }

    private static void setUpMockData4testsetDSProjectProDescription() {
        testsetDSProjectProDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetDSProjectTotExpenses() {
    }

    private static void setUpMockData4testsetDSProjectTotExpenses() {
        testsetDSProjectTotExpensesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSProjectMaxExpense() {
    }

    private static void setUpMockData4testsetDSProjectMaxExpense() {
        testsetDSProjectMaxExpenseArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSProjectMinExpense() {
    }

    private static void setUpMockData4testsetDSProjectMinExpense() {
        testsetDSProjectMinExpenseArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSProjectAvgExpense() {
    }

    private static void setUpMockData4testsetDSProjectAvgExpense() {
        testsetDSProjectAvgExpenseArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSProject = new DSProject();
        instanceDSProject.setDSProjectIdProject(Long.valueOf(0));
        instanceDSProject.setDSProjectProjectName("");
        instanceDSProject.setDSProjectTeamDotName("");
        instanceDSProject.setDSProjectProDescription("");
        instanceDSProject.setDSProjectTotExpenses(Double.valueOf(0));
        instanceDSProject.setDSProjectMaxExpense(Double.valueOf(0));
        instanceDSProject.setDSProjectMinExpense(Double.valueOf(0));
        instanceDSProject.setDSProjectAvgExpense(Double.valueOf(0));
    }

    @Test
    public void testDSProject() {
        instanceDSProject = new DSProject(testDSProjectArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testDSProject2() {
        instanceDSProject = new DSProject(testDSProject2Arg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectIdProject() {
        assertEquals(Long.valueOf(0), instanceDSProject.getDSProjectIdProject());
    }

    @Test
    public void testsetDSProjectIdProject() {
        instanceDSProject.setDSProjectIdProject(testsetDSProjectIdProjectArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectProjectName() {
        assertEquals("", instanceDSProject.getDSProjectProjectName());
    }

    @Test
    public void testsetDSProjectProjectName() {
        instanceDSProject.setDSProjectProjectName(testsetDSProjectProjectNameArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectTeamDotName() {
        assertEquals("", instanceDSProject.getDSProjectTeamDotName());
    }

    @Test
    public void testsetDSProjectTeamDotName() {
        instanceDSProject.setDSProjectTeamDotName(testsetDSProjectTeamDotNameArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectProDescription() {
        assertEquals("", instanceDSProject.getDSProjectProDescription());
    }

    @Test
    public void testsetDSProjectProDescription() {
        instanceDSProject.setDSProjectProDescription(testsetDSProjectProDescriptionArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectTotExpenses() {
        assertEquals(Double.valueOf(0), instanceDSProject.getDSProjectTotExpenses());
    }

    @Test
    public void testsetDSProjectTotExpenses() {
        instanceDSProject.setDSProjectTotExpenses(testsetDSProjectTotExpensesArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectMaxExpense() {
        assertEquals(Double.valueOf(0), instanceDSProject.getDSProjectMaxExpense());
    }

    @Test
    public void testsetDSProjectMaxExpense() {
        instanceDSProject.setDSProjectMaxExpense(testsetDSProjectMaxExpenseArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectMinExpense() {
        assertEquals(Double.valueOf(0), instanceDSProject.getDSProjectMinExpense());
    }

    @Test
    public void testsetDSProjectMinExpense() {
        instanceDSProject.setDSProjectMinExpense(testsetDSProjectMinExpenseArg1);
        assertNotNull(instanceDSProject);
    }

    @Test
    public void testgetDSProjectAvgExpense() {
        assertEquals(Double.valueOf(0), instanceDSProject.getDSProjectAvgExpense());
    }

    @Test
    public void testsetDSProjectAvgExpense() {
        instanceDSProject.setDSProjectAvgExpense(testsetDSProjectAvgExpenseArg1);
        assertNotNull(instanceDSProject);
    }
}
