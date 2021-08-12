package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static EmployeeOid defValue4employeeeditinstancepthisEmployee = new EmployeeOid();
    private static Employee defValue4employeeeditinstancepthisEmployeeInstance = new Employee(new EmployeeOid(""));
    private static String defValue4employeeeditinstancepEmpName = "";
    private static String defValue4employeeeditinstancepEmpSurname = "";
    private static String defValue4employeeeditinstancepSite = "";
    private static String defValue4employeeeditinstancepPhoneNumbers = "";
    private static String defValue4employeeeditinstancepemail = "";


    // test4getEmployeeeditinstancepthisEmployee

    // test4setEmployeeeditinstancepthisEmployee
    private static EmployeeOid test4setEmployeeeditinstancepthisEmployeeArg1;

    // test4getEmployeeeditinstancepEmpName

    // test4setEmployeeeditinstancepEmpName
    private static String test4setEmployeeeditinstancepEmpNameArg1;

    // test4getEmployeeeditinstancepEmpSurname

    // test4setEmployeeeditinstancepEmpSurname
    private static String test4setEmployeeeditinstancepEmpSurnameArg1;

    // test4getEmployeeeditinstancepSite

    // test4setEmployeeeditinstancepSite
    private static String test4setEmployeeeditinstancepSiteArg1;

    // test4getEmployeeeditinstancepPhoneNumbers

    // test4setEmployeeeditinstancepPhoneNumbers
    private static String test4setEmployeeeditinstancepPhoneNumbersArg1;

    // test4getEmployeeeditinstancepemail

    // test4setEmployeeeditinstancepemail
    private static String test4setEmployeeeditinstancepemailArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeeeditinstancepthisEmployee();
        setUpMockData4test4setEmployeeeditinstancepthisEmployee();
        setUpMockData4test4getEmployeeeditinstancepEmpName();
        setUpMockData4test4setEmployeeeditinstancepEmpName();
        setUpMockData4test4getEmployeeeditinstancepEmpSurname();
        setUpMockData4test4setEmployeeeditinstancepEmpSurname();
        setUpMockData4test4getEmployeeeditinstancepSite();
        setUpMockData4test4setEmployeeeditinstancepSite();
        setUpMockData4test4getEmployeeeditinstancepPhoneNumbers();
        setUpMockData4test4setEmployeeeditinstancepPhoneNumbers();
        setUpMockData4test4getEmployeeeditinstancepemail();
        setUpMockData4test4setEmployeeeditinstancepemail();
    }

    private static void setUpMockData4test4getEmployeeeditinstancepthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepthisEmployee() {
        test4setEmployeeeditinstancepthisEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getEmployeeeditinstancepEmpName() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepEmpName() {
        test4setEmployeeeditinstancepEmpNameArg1 = "";
    }

    private static void setUpMockData4test4getEmployeeeditinstancepEmpSurname() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepEmpSurname() {
        test4setEmployeeeditinstancepEmpSurnameArg1 = "";
    }

    private static void setUpMockData4test4getEmployeeeditinstancepSite() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepSite() {
        test4setEmployeeeditinstancepSiteArg1 = "";
    }

    private static void setUpMockData4test4getEmployeeeditinstancepPhoneNumbers() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepPhoneNumbers() {
        test4setEmployeeeditinstancepPhoneNumbersArg1 = "";
    }

    private static void setUpMockData4test4getEmployeeeditinstancepemail() {
    }

    private static void setUpMockData4test4setEmployeeeditinstancepemail() {
        test4setEmployeeeditinstancepemailArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setEmployeeeditinstancepthisEmployee(defValue4employeeeditinstancepthisEmployee);
        instanceEditinstanceRequest.setEmployeeeditinstancepthisEmployeeInstance(defValue4employeeeditinstancepthisEmployeeInstance);
        instanceEditinstanceRequest.setEmployeeeditinstancepEmpName(defValue4employeeeditinstancepEmpName);
        instanceEditinstanceRequest.setEmployeeeditinstancepEmpSurname(defValue4employeeeditinstancepEmpSurname);
        instanceEditinstanceRequest.setEmployeeeditinstancepSite(defValue4employeeeditinstancepSite);
        instanceEditinstanceRequest.setEmployeeeditinstancepPhoneNumbers(defValue4employeeeditinstancepPhoneNumbers);
        instanceEditinstanceRequest.setEmployeeeditinstancepemail(defValue4employeeeditinstancepemail);
    }

    @Test
    public void test4getEmployeeeditinstancepthisEmployee() {
        assertEquals(defValue4employeeeditinstancepthisEmployee, instanceEditinstanceRequest.getEmployeeeditinstancepthisEmployee());
    }

    @Test
    public void test4setEmployeeeditinstancepthisEmployee() {
        instanceEditinstanceRequest.setEmployeeeditinstancepthisEmployee(test4setEmployeeeditinstancepthisEmployeeArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getEmployeeeditinstancepEmpName() {
        assertEquals(defValue4employeeeditinstancepEmpName, instanceEditinstanceRequest.getEmployeeeditinstancepEmpName());
    }

    @Test
    public void test4setEmployeeeditinstancepEmpName() {
        instanceEditinstanceRequest.setEmployeeeditinstancepEmpName(test4setEmployeeeditinstancepEmpNameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getEmployeeeditinstancepEmpSurname() {
        assertEquals(defValue4employeeeditinstancepEmpSurname, instanceEditinstanceRequest.getEmployeeeditinstancepEmpSurname());
    }

    @Test
    public void test4setEmployeeeditinstancepEmpSurname() {
        instanceEditinstanceRequest.setEmployeeeditinstancepEmpSurname(test4setEmployeeeditinstancepEmpSurnameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getEmployeeeditinstancepSite() {
        assertEquals(defValue4employeeeditinstancepSite, instanceEditinstanceRequest.getEmployeeeditinstancepSite());
    }

    @Test
    public void test4setEmployeeeditinstancepSite() {
        instanceEditinstanceRequest.setEmployeeeditinstancepSite(test4setEmployeeeditinstancepSiteArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getEmployeeeditinstancepPhoneNumbers() {
        assertEquals(defValue4employeeeditinstancepPhoneNumbers, instanceEditinstanceRequest.getEmployeeeditinstancepPhoneNumbers());
    }

    @Test
    public void test4setEmployeeeditinstancepPhoneNumbers() {
        instanceEditinstanceRequest.setEmployeeeditinstancepPhoneNumbers(test4setEmployeeeditinstancepPhoneNumbersArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getEmployeeeditinstancepemail() {
        assertEquals(defValue4employeeeditinstancepemail, instanceEditinstanceRequest.getEmployeeeditinstancepemail());
    }

    @Test
    public void test4setEmployeeeditinstancepemail() {
        instanceEditinstanceRequest.setEmployeeeditinstancepemail(test4setEmployeeeditinstancepemailArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
