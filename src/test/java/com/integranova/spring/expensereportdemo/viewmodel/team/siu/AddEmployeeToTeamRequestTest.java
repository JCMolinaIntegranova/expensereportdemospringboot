package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

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
    private static TeamOid defValue4teamaddEmployeeToTeampthisTeam = new TeamOid();
    private static Team defValue4teamaddEmployeeToTeampthisTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static EmployeeOid defValue4teamaddEmployeeToTeampevcEmployee = new EmployeeOid();
    private static Employee defValue4teamaddEmployeeToTeampevcEmployeeInstance = new Employee(new EmployeeOid(""));


    // test4getTeamaddEmployeeToTeampthisTeam

    // test4setTeamaddEmployeeToTeampthisTeam
    private static TeamOid test4setTeamaddEmployeeToTeampthisTeamArg1;

    // test4getTeamaddEmployeeToTeampevcEmployee

    // test4setTeamaddEmployeeToTeampevcEmployee
    private static EmployeeOid test4setTeamaddEmployeeToTeampevcEmployeeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeamaddEmployeeToTeampthisTeam();
        setUpMockData4test4setTeamaddEmployeeToTeampthisTeam();
        setUpMockData4test4getTeamaddEmployeeToTeampevcEmployee();
        setUpMockData4test4setTeamaddEmployeeToTeampevcEmployee();
    }

    private static void setUpMockData4test4getTeamaddEmployeeToTeampthisTeam() {
    }

    private static void setUpMockData4test4setTeamaddEmployeeToTeampthisTeam() {
        test4setTeamaddEmployeeToTeampthisTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4test4getTeamaddEmployeeToTeampevcEmployee() {
    }

    private static void setUpMockData4test4setTeamaddEmployeeToTeampevcEmployee() {
        test4setTeamaddEmployeeToTeampevcEmployeeArg1 = new EmployeeOid();
    }

    @Before
    public void setUp() {
        instanceAddEmployeeToTeamRequest = new AddEmployeeToTeamRequest();
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampthisTeam(defValue4teamaddEmployeeToTeampthisTeam);
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampthisTeamInstance(defValue4teamaddEmployeeToTeampthisTeamInstance);
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampevcEmployee(defValue4teamaddEmployeeToTeampevcEmployee);
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampevcEmployeeInstance(defValue4teamaddEmployeeToTeampevcEmployeeInstance);
    }

    @Test
    public void test4getTeamaddEmployeeToTeampthisTeam() {
        assertEquals(defValue4teamaddEmployeeToTeampthisTeam, instanceAddEmployeeToTeamRequest.getTeamaddEmployeeToTeampthisTeam());
    }

    @Test
    public void test4setTeamaddEmployeeToTeampthisTeam() {
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampthisTeam(test4setTeamaddEmployeeToTeampthisTeamArg1);
        assertNotNull(instanceAddEmployeeToTeamRequest);
    }

    @Test
    public void test4getTeamaddEmployeeToTeampevcEmployee() {
        assertEquals(defValue4teamaddEmployeeToTeampevcEmployee, instanceAddEmployeeToTeamRequest.getTeamaddEmployeeToTeampevcEmployee());
    }

    @Test
    public void test4setTeamaddEmployeeToTeampevcEmployee() {
        instanceAddEmployeeToTeamRequest.setTeamaddEmployeeToTeampevcEmployee(test4setTeamaddEmployeeToTeampevcEmployeeArg1);
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
