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
public class RemoveEmployeeFromTeamRequestTest {

    private RemoveEmployeeFromTeamRequest instanceRemoveEmployeeFromTeamRequest;

    // Default values
    private static EmployeeOid defValue4employeeremoveEmployeeFromTeampthisEmployee = new EmployeeOid();
    private static Employee defValue4employeeremoveEmployeeFromTeampthisEmployeeInstance = new Employee(new EmployeeOid(""));
    private static TeamOid defValue4employeeremoveEmployeeFromTeampevcTeam = new TeamOid();
    private static Team defValue4employeeremoveEmployeeFromTeampevcTeamInstance = new Team(new TeamOid(Long.valueOf(0)));


    // test4getEmployeeremoveEmployeeFromTeampthisEmployee

    // test4setEmployeeremoveEmployeeFromTeampthisEmployee
    private static EmployeeOid test4setEmployeeremoveEmployeeFromTeampthisEmployeeArg1;

    // test4getEmployeeremoveEmployeeFromTeampevcTeam

    // test4setEmployeeremoveEmployeeFromTeampevcTeam
    private static TeamOid test4setEmployeeremoveEmployeeFromTeampevcTeamArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeeremoveEmployeeFromTeampthisEmployee();
        setUpMockData4test4setEmployeeremoveEmployeeFromTeampthisEmployee();
        setUpMockData4test4getEmployeeremoveEmployeeFromTeampevcTeam();
        setUpMockData4test4setEmployeeremoveEmployeeFromTeampevcTeam();
    }

    private static void setUpMockData4test4getEmployeeremoveEmployeeFromTeampthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeeremoveEmployeeFromTeampthisEmployee() {
        test4setEmployeeremoveEmployeeFromTeampthisEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getEmployeeremoveEmployeeFromTeampevcTeam() {
    }

    private static void setUpMockData4test4setEmployeeremoveEmployeeFromTeampevcTeam() {
        test4setEmployeeremoveEmployeeFromTeampevcTeamArg1 = new TeamOid();
    }

    @Before
    public void setUp() {
        instanceRemoveEmployeeFromTeamRequest = new RemoveEmployeeFromTeamRequest();
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampthisEmployee(defValue4employeeremoveEmployeeFromTeampthisEmployee);
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(defValue4employeeremoveEmployeeFromTeampthisEmployeeInstance);
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampevcTeam(defValue4employeeremoveEmployeeFromTeampevcTeam);
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampevcTeamInstance(defValue4employeeremoveEmployeeFromTeampevcTeamInstance);
    }

    @Test
    public void test4getEmployeeremoveEmployeeFromTeampthisEmployee() {
        assertEquals(defValue4employeeremoveEmployeeFromTeampthisEmployee, instanceRemoveEmployeeFromTeamRequest.getEmployeeremoveEmployeeFromTeampthisEmployee());
    }

    @Test
    public void test4setEmployeeremoveEmployeeFromTeampthisEmployee() {
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampthisEmployee(test4setEmployeeremoveEmployeeFromTeampthisEmployeeArg1);
        assertNotNull(instanceRemoveEmployeeFromTeamRequest);
    }

    @Test
    public void test4getEmployeeremoveEmployeeFromTeampevcTeam() {
        assertEquals(defValue4employeeremoveEmployeeFromTeampevcTeam, instanceRemoveEmployeeFromTeamRequest.getEmployeeremoveEmployeeFromTeampevcTeam());
    }

    @Test
    public void test4setEmployeeremoveEmployeeFromTeampevcTeam() {
        instanceRemoveEmployeeFromTeamRequest.setEmployeeremoveEmployeeFromTeampevcTeam(test4setEmployeeremoveEmployeeFromTeampevcTeamArg1);
        assertNotNull(instanceRemoveEmployeeFromTeamRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceRemoveEmployeeFromTeamRequest = new RemoveEmployeeFromTeamRequest();
    	instanceRemoveEmployeeFromTeamRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceRemoveEmployeeFromTeamRequest.checkArguments();
    }
}
