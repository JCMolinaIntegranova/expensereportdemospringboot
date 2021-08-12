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
public class RemoveEmployeeFromTeamRequestTest {

    private RemoveEmployeeFromTeamRequest instanceRemoveEmployeeFromTeamRequest;

    // Default values
    private static TeamOid defValue4teamremoveEmployeeFromTeampthisTeam = new TeamOid();
    private static Team defValue4teamremoveEmployeeFromTeampthisTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static EmployeeOid defValue4teamremoveEmployeeFromTeampevcEmployee = new EmployeeOid();
    private static Employee defValue4teamremoveEmployeeFromTeampevcEmployeeInstance = new Employee(new EmployeeOid(""));


    // test4getTeamremoveEmployeeFromTeampthisTeam

    // test4setTeamremoveEmployeeFromTeampthisTeam
    private static TeamOid test4setTeamremoveEmployeeFromTeampthisTeamArg1;

    // test4getTeamremoveEmployeeFromTeampevcEmployee

    // test4setTeamremoveEmployeeFromTeampevcEmployee
    private static EmployeeOid test4setTeamremoveEmployeeFromTeampevcEmployeeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeamremoveEmployeeFromTeampthisTeam();
        setUpMockData4test4setTeamremoveEmployeeFromTeampthisTeam();
        setUpMockData4test4getTeamremoveEmployeeFromTeampevcEmployee();
        setUpMockData4test4setTeamremoveEmployeeFromTeampevcEmployee();
    }

    private static void setUpMockData4test4getTeamremoveEmployeeFromTeampthisTeam() {
    }

    private static void setUpMockData4test4setTeamremoveEmployeeFromTeampthisTeam() {
        test4setTeamremoveEmployeeFromTeampthisTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4test4getTeamremoveEmployeeFromTeampevcEmployee() {
    }

    private static void setUpMockData4test4setTeamremoveEmployeeFromTeampevcEmployee() {
        test4setTeamremoveEmployeeFromTeampevcEmployeeArg1 = new EmployeeOid();
    }

    @Before
    public void setUp() {
        instanceRemoveEmployeeFromTeamRequest = new RemoveEmployeeFromTeamRequest();
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampthisTeam(defValue4teamremoveEmployeeFromTeampthisTeam);
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampthisTeamInstance(defValue4teamremoveEmployeeFromTeampthisTeamInstance);
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampevcEmployee(defValue4teamremoveEmployeeFromTeampevcEmployee);
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampevcEmployeeInstance(defValue4teamremoveEmployeeFromTeampevcEmployeeInstance);
    }

    @Test
    public void test4getTeamremoveEmployeeFromTeampthisTeam() {
        assertEquals(defValue4teamremoveEmployeeFromTeampthisTeam, instanceRemoveEmployeeFromTeamRequest.getTeamremoveEmployeeFromTeampthisTeam());
    }

    @Test
    public void test4setTeamremoveEmployeeFromTeampthisTeam() {
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampthisTeam(test4setTeamremoveEmployeeFromTeampthisTeamArg1);
        assertNotNull(instanceRemoveEmployeeFromTeamRequest);
    }

    @Test
    public void test4getTeamremoveEmployeeFromTeampevcEmployee() {
        assertEquals(defValue4teamremoveEmployeeFromTeampevcEmployee, instanceRemoveEmployeeFromTeamRequest.getTeamremoveEmployeeFromTeampevcEmployee());
    }

    @Test
    public void test4setTeamremoveEmployeeFromTeampevcEmployee() {
        instanceRemoveEmployeeFromTeamRequest.setTeamremoveEmployeeFromTeampevcEmployee(test4setTeamremoveEmployeeFromTeampevcEmployeeArg1);
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
