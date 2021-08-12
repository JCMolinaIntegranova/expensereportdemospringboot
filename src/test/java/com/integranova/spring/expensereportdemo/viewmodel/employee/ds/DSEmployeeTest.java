package com.integranova.spring.expensereportdemo.viewmodel.employee.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.Employee;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSEmployeeTest {

    private DSEmployee instanceDSEmployee;

    // testDSEmployee
    private static Employee testDSEmployeeArg1;

    // testDSEmployee2
    private static Employee testDSEmployee2Arg1;

    // testgetDSEmployeeIdEmployee

    // testsetDSEmployeeIdEmployee
    private static String testsetDSEmployeeIdEmployeeArg1;

    // testgetDSEmployeePicture

    // testsetDSEmployeePicture
    private static byte[] testsetDSEmployeePictureArg1;

    // testgetDSEmployeeEmpName

    // testsetDSEmployeeEmpName
    private static String testsetDSEmployeeEmpNameArg1;

    // testgetDSEmployeeEmpSurname

    // testsetDSEmployeeEmpSurname
    private static String testsetDSEmployeeEmpSurnameArg1;

    // testgetDSEmployeePhoneNumbers

    // testsetDSEmployeePhoneNumbers
    private static String testsetDSEmployeePhoneNumbersArg1;

    // testgetDSEmployeeSite

    // testsetDSEmployeeSite
    private static String testsetDSEmployeeSiteArg1;

    // testgetDSEmployeeEmail

    // testsetDSEmployeeEmail
    private static String testsetDSEmployeeEmailArg1;

    // testgetDSEmployeeNumOfExpReports

    // testsetDSEmployeeNumOfExpReports
    private static Long testsetDSEmployeeNumOfExpReportsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSEmployee();
        setUpMockData4testDSEmployee2();
        setUpMockData4testgetDSEmployeeIdEmployee();
        setUpMockData4testsetDSEmployeeIdEmployee();
        setUpMockData4testgetDSEmployeePicture();
        setUpMockData4testsetDSEmployeePicture();
        setUpMockData4testgetDSEmployeeEmpName();
        setUpMockData4testsetDSEmployeeEmpName();
        setUpMockData4testgetDSEmployeeEmpSurname();
        setUpMockData4testsetDSEmployeeEmpSurname();
        setUpMockData4testgetDSEmployeePhoneNumbers();
        setUpMockData4testsetDSEmployeePhoneNumbers();
        setUpMockData4testgetDSEmployeeSite();
        setUpMockData4testsetDSEmployeeSite();
        setUpMockData4testgetDSEmployeeEmail();
        setUpMockData4testsetDSEmployeeEmail();
        setUpMockData4testgetDSEmployeeNumOfExpReports();
        setUpMockData4testsetDSEmployeeNumOfExpReports();
    }

    private static void setUpMockData4testDSEmployee() {
        testDSEmployeeArg1 = new Employee();
    }

    private static void setUpMockData4testDSEmployee2() {
        testDSEmployee2Arg1 = null;
    }

    private static void setUpMockData4testgetDSEmployeeIdEmployee() {
    }

    private static void setUpMockData4testsetDSEmployeeIdEmployee() {
        testsetDSEmployeeIdEmployeeArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeePicture() {
    }

    private static void setUpMockData4testsetDSEmployeePicture() {
        testsetDSEmployeePictureArg1 = null;
    }

    private static void setUpMockData4testgetDSEmployeeEmpName() {
    }

    private static void setUpMockData4testsetDSEmployeeEmpName() {
        testsetDSEmployeeEmpNameArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeeEmpSurname() {
    }

    private static void setUpMockData4testsetDSEmployeeEmpSurname() {
        testsetDSEmployeeEmpSurnameArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeePhoneNumbers() {
    }

    private static void setUpMockData4testsetDSEmployeePhoneNumbers() {
        testsetDSEmployeePhoneNumbersArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeeSite() {
    }

    private static void setUpMockData4testsetDSEmployeeSite() {
        testsetDSEmployeeSiteArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeeEmail() {
    }

    private static void setUpMockData4testsetDSEmployeeEmail() {
        testsetDSEmployeeEmailArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeeNumOfExpReports() {
    }

    private static void setUpMockData4testsetDSEmployeeNumOfExpReports() {
        testsetDSEmployeeNumOfExpReportsArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSEmployee = new DSEmployee();
        instanceDSEmployee.setDSEmployeeIdEmployee("");
        instanceDSEmployee.setDSEmployeePicture(null);
        instanceDSEmployee.setDSEmployeeEmpName("");
        instanceDSEmployee.setDSEmployeeEmpSurname("");
        instanceDSEmployee.setDSEmployeePhoneNumbers("");
        instanceDSEmployee.setDSEmployeeSite("");
        instanceDSEmployee.setDSEmployeeEmail("");
        instanceDSEmployee.setDSEmployeeNumOfExpReports(Long.valueOf(0));
    }

    @Test
    public void testDSEmployee() {
        instanceDSEmployee = new DSEmployee(testDSEmployeeArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testDSEmployee2() {
        instanceDSEmployee = new DSEmployee(testDSEmployee2Arg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeIdEmployee() {
        assertEquals("", instanceDSEmployee.getDSEmployeeIdEmployee());
    }

    @Test
    public void testsetDSEmployeeIdEmployee() {
        instanceDSEmployee.setDSEmployeeIdEmployee(testsetDSEmployeeIdEmployeeArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeePicture() {
        assertEquals(null, instanceDSEmployee.getDSEmployeePicture());
    }

    @Test
    public void testsetDSEmployeePicture() {
        instanceDSEmployee.setDSEmployeePicture(testsetDSEmployeePictureArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeEmpName() {
        assertEquals("", instanceDSEmployee.getDSEmployeeEmpName());
    }

    @Test
    public void testsetDSEmployeeEmpName() {
        instanceDSEmployee.setDSEmployeeEmpName(testsetDSEmployeeEmpNameArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeEmpSurname() {
        assertEquals("", instanceDSEmployee.getDSEmployeeEmpSurname());
    }

    @Test
    public void testsetDSEmployeeEmpSurname() {
        instanceDSEmployee.setDSEmployeeEmpSurname(testsetDSEmployeeEmpSurnameArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeePhoneNumbers() {
        assertEquals("", instanceDSEmployee.getDSEmployeePhoneNumbers());
    }

    @Test
    public void testsetDSEmployeePhoneNumbers() {
        instanceDSEmployee.setDSEmployeePhoneNumbers(testsetDSEmployeePhoneNumbersArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeSite() {
        assertEquals("", instanceDSEmployee.getDSEmployeeSite());
    }

    @Test
    public void testsetDSEmployeeSite() {
        instanceDSEmployee.setDSEmployeeSite(testsetDSEmployeeSiteArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeEmail() {
        assertEquals("", instanceDSEmployee.getDSEmployeeEmail());
    }

    @Test
    public void testsetDSEmployeeEmail() {
        instanceDSEmployee.setDSEmployeeEmail(testsetDSEmployeeEmailArg1);
        assertNotNull(instanceDSEmployee);
    }

    @Test
    public void testgetDSEmployeeNumOfExpReports() {
        assertEquals(Long.valueOf(0), instanceDSEmployee.getDSEmployeeNumOfExpReports());
    }

    @Test
    public void testsetDSEmployeeNumOfExpReports() {
        instanceDSEmployee.setDSEmployeeNumOfExpReports(testsetDSEmployeeNumOfExpReportsArg1);
        assertNotNull(instanceDSEmployee);
    }
}
