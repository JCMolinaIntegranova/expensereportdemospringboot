package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeToTeamRequestTest {

    private AddEmployeeToTeamRequest instanceAddEmployeeToTeamRequest;

    // Default values
    private static EmployeeOid defValue4employeeaddEmployeeToTeampthisEmployee = new EmployeeOid();
    private static Employee defValue4employeeaddEmployeeToTeampthisEmployeeInstance = new Employee(new EmployeeOid(""));
    private static TeamOid defValue4employeeaddEmployeeToTeampevcTeam = new TeamOid();
    private static Team defValue4employeeaddEmployeeToTeampevcTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getEmployeeaddEmployeeToTeampthisEmployee

    // test4setEmployeeaddEmployeeToTeampthisEmployee
    private static EmployeeOid test4setEmployeeaddEmployeeToTeampthisEmployeeArg1;

    // test4getEmployeeaddEmployeeToTeampevcTeam

    // test4setEmployeeaddEmployeeToTeampevcTeam
    private static TeamOid test4setEmployeeaddEmployeeToTeampevcTeamArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeeaddEmployeeToTeampthisEmployee();
        setUpMockData4test4setEmployeeaddEmployeeToTeampthisEmployee();
        setUpMockData4test4getEmployeeaddEmployeeToTeampevcTeam();
        setUpMockData4test4setEmployeeaddEmployeeToTeampevcTeam();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getEmployeeaddEmployeeToTeampthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeeaddEmployeeToTeampthisEmployee() {
        test4setEmployeeaddEmployeeToTeampthisEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getEmployeeaddEmployeeToTeampevcTeam() {
    }

    private static void setUpMockData4test4setEmployeeaddEmployeeToTeampevcTeam() {
        test4setEmployeeaddEmployeeToTeampevcTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceAddEmployeeToTeamRequest = new AddEmployeeToTeamRequest();
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampthisEmployee(defValue4employeeaddEmployeeToTeampthisEmployee);
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampthisEmployeeInstance(defValue4employeeaddEmployeeToTeampthisEmployeeInstance);
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampevcTeam(defValue4employeeaddEmployeeToTeampevcTeam);
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampevcTeamInstance(defValue4employeeaddEmployeeToTeampevcTeamInstance);
        instanceAddEmployeeToTeamRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getEmployeeaddEmployeeToTeampthisEmployee() {
        assertEquals(defValue4employeeaddEmployeeToTeampthisEmployee, instanceAddEmployeeToTeamRequest.getEmployeeaddEmployeeToTeampthisEmployee());
    }

    @Test
    public void test4setEmployeeaddEmployeeToTeampthisEmployee() {
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampthisEmployee(test4setEmployeeaddEmployeeToTeampthisEmployeeArg1);
        assertNotNull(instanceAddEmployeeToTeamRequest);
    }

    @Test
    public void test4getEmployeeaddEmployeeToTeampevcTeam() {
        assertEquals(defValue4employeeaddEmployeeToTeampevcTeam, instanceAddEmployeeToTeamRequest.getEmployeeaddEmployeeToTeampevcTeam());
    }

    @Test
    public void test4setEmployeeaddEmployeeToTeampevcTeam() {
        instanceAddEmployeeToTeamRequest.setEmployeeaddEmployeeToTeampevcTeam(test4setEmployeeaddEmployeeToTeampevcTeamArg1);
        assertNotNull(instanceAddEmployeeToTeamRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceAddEmployeeToTeamRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceAddEmployeeToTeamRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceAddEmployeeToTeamRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceAddEmployeeToTeamRequest = new AddEmployeeToTeamRequest();
    	instanceAddEmployeeToTeamRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceAddEmployeeToTeamRequest.checkArguments();
    }
}
