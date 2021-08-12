package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewAssignmentRequestTest {

    private NewAssignmentRequest instanceNewAssignmentRequest;

    // Default values
    private static ProjectOid defValue4assignmentnewAssignmentpagrProject = new ProjectOid();
    private static Project defValue4assignmentnewAssignmentpagrProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static EmployeeOid defValue4assignmentnewAssignmentpagrEmployee = new EmployeeOid();
    private static Employee defValue4assignmentnewAssignmentpagrEmployeeInstance = new Employee(new EmployeeOid(""));
    private static Date defValue4assignmentnewAssignmentpatrFromDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getAssignmentnewAssignmentpagrProject

    // test4setAssignmentnewAssignmentpagrProject
    private static ProjectOid test4setAssignmentnewAssignmentpagrProjectArg1;

    // test4getAssignmentnewAssignmentpagrEmployee

    // test4setAssignmentnewAssignmentpagrEmployee
    private static EmployeeOid test4setAssignmentnewAssignmentpagrEmployeeArg1;

    // test4getAssignmentnewAssignmentpatrFromDate

    // test4setAssignmentnewAssignmentpatrFromDate
    private static Date test4setAssignmentnewAssignmentpatrFromDateArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAssignmentnewAssignmentpagrProject();
        setUpMockData4test4setAssignmentnewAssignmentpagrProject();
        setUpMockData4test4getAssignmentnewAssignmentpagrEmployee();
        setUpMockData4test4setAssignmentnewAssignmentpagrEmployee();
        setUpMockData4test4getAssignmentnewAssignmentpatrFromDate();
        setUpMockData4test4setAssignmentnewAssignmentpatrFromDate();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getAssignmentnewAssignmentpagrProject() {
    }

    private static void setUpMockData4test4setAssignmentnewAssignmentpagrProject() {
        test4setAssignmentnewAssignmentpagrProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getAssignmentnewAssignmentpagrEmployee() {
    }

    private static void setUpMockData4test4setAssignmentnewAssignmentpagrEmployee() {
        test4setAssignmentnewAssignmentpagrEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getAssignmentnewAssignmentpatrFromDate() {
    }

    private static void setUpMockData4test4setAssignmentnewAssignmentpatrFromDate() {
        test4setAssignmentnewAssignmentpatrFromDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceNewAssignmentRequest = new NewAssignmentRequest();
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrProject(defValue4assignmentnewAssignmentpagrProject);
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrProjectInstance(defValue4assignmentnewAssignmentpagrProjectInstance);
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrEmployee(defValue4assignmentnewAssignmentpagrEmployee);
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrEmployeeInstance(defValue4assignmentnewAssignmentpagrEmployeeInstance);
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpatrFromDate(defValue4assignmentnewAssignmentpatrFromDate);
        instanceNewAssignmentRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getAssignmentnewAssignmentpagrProject() {
        assertEquals(defValue4assignmentnewAssignmentpagrProject, instanceNewAssignmentRequest.getAssignmentnewAssignmentpagrProject());
    }

    @Test
    public void test4setAssignmentnewAssignmentpagrProject() {
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrProject(test4setAssignmentnewAssignmentpagrProjectArg1);
        assertNotNull(instanceNewAssignmentRequest);
    }

    @Test
    public void test4getAssignmentnewAssignmentpagrEmployee() {
        assertEquals(defValue4assignmentnewAssignmentpagrEmployee, instanceNewAssignmentRequest.getAssignmentnewAssignmentpagrEmployee());
    }

    @Test
    public void test4setAssignmentnewAssignmentpagrEmployee() {
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpagrEmployee(test4setAssignmentnewAssignmentpagrEmployeeArg1);
        assertNotNull(instanceNewAssignmentRequest);
    }

    @Test
    public void test4getAssignmentnewAssignmentpatrFromDate() {
        assertEquals(defValue4assignmentnewAssignmentpatrFromDate, instanceNewAssignmentRequest.getAssignmentnewAssignmentpatrFromDate());
    }

    @Test
    public void test4setAssignmentnewAssignmentpatrFromDate() {
        instanceNewAssignmentRequest.setAssignmentnewAssignmentpatrFromDate(test4setAssignmentnewAssignmentpatrFromDateArg1);
        assertNotNull(instanceNewAssignmentRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceNewAssignmentRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceNewAssignmentRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceNewAssignmentRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceNewAssignmentRequest = new NewAssignmentRequest();
    	instanceNewAssignmentRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceNewAssignmentRequest.checkArguments();
    }
}
