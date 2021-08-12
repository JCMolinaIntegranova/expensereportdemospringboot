package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static String defValue4employeecreateinstancepatridEmployee = "";
    private static String defValue4employeecreateinstancepatrEmpName = "";
    private static String defValue4employeecreateinstancepatrEmpSurname = "";
    private static String defValue4employeecreateinstancepatrSite = "";
    private static String defValue4employeecreateinstancepatrPhoneNumbers = "";
    private static String defValue4employeecreateinstancepatremail = "";
    private static byte[] defValue4employeecreateinstancepatrPicture = "".getBytes();


    // test4getEmployeecreateinstancepatridEmployee

    // test4setEmployeecreateinstancepatridEmployee
    private static String test4setEmployeecreateinstancepatridEmployeeArg1;

    // test4getEmployeecreateinstancepatrEmpName

    // test4setEmployeecreateinstancepatrEmpName
    private static String test4setEmployeecreateinstancepatrEmpNameArg1;

    // test4getEmployeecreateinstancepatrEmpSurname

    // test4setEmployeecreateinstancepatrEmpSurname
    private static String test4setEmployeecreateinstancepatrEmpSurnameArg1;

    // test4getEmployeecreateinstancepatrSite

    // test4setEmployeecreateinstancepatrSite
    private static String test4setEmployeecreateinstancepatrSiteArg1;

    // test4getEmployeecreateinstancepatrPhoneNumbers

    // test4setEmployeecreateinstancepatrPhoneNumbers
    private static String test4setEmployeecreateinstancepatrPhoneNumbersArg1;

    // test4getEmployeecreateinstancepatremail

    // test4setEmployeecreateinstancepatremail
    private static String test4setEmployeecreateinstancepatremailArg1;

    // test4getEmployeecreateinstancepatrPicture

    // test4setEmployeecreateinstancepatrPicture
    private static byte[] test4setEmployeecreateinstancepatrPictureArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeecreateinstancepatridEmployee();
        setUpMockData4test4setEmployeecreateinstancepatridEmployee();
        setUpMockData4test4getEmployeecreateinstancepatrEmpName();
        setUpMockData4test4setEmployeecreateinstancepatrEmpName();
        setUpMockData4test4getEmployeecreateinstancepatrEmpSurname();
        setUpMockData4test4setEmployeecreateinstancepatrEmpSurname();
        setUpMockData4test4getEmployeecreateinstancepatrSite();
        setUpMockData4test4setEmployeecreateinstancepatrSite();
        setUpMockData4test4getEmployeecreateinstancepatrPhoneNumbers();
        setUpMockData4test4setEmployeecreateinstancepatrPhoneNumbers();
        setUpMockData4test4getEmployeecreateinstancepatremail();
        setUpMockData4test4setEmployeecreateinstancepatremail();
        setUpMockData4test4getEmployeecreateinstancepatrPicture();
        setUpMockData4test4setEmployeecreateinstancepatrPicture();
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatridEmployee() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatridEmployee() {
        test4setEmployeecreateinstancepatridEmployeeArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatrEmpName() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatrEmpName() {
        test4setEmployeecreateinstancepatrEmpNameArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatrEmpSurname() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatrEmpSurname() {
        test4setEmployeecreateinstancepatrEmpSurnameArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatrSite() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatrSite() {
        test4setEmployeecreateinstancepatrSiteArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatrPhoneNumbers() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatrPhoneNumbers() {
        test4setEmployeecreateinstancepatrPhoneNumbersArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatremail() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatremail() {
        test4setEmployeecreateinstancepatremailArg1 = "";
    }

    private static void setUpMockData4test4getEmployeecreateinstancepatrPicture() {
    }

    private static void setUpMockData4test4setEmployeecreateinstancepatrPicture() {
        test4setEmployeecreateinstancepatrPictureArg1 = "".getBytes();
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setEmployeecreateinstancepatridEmployee(defValue4employeecreateinstancepatridEmployee);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrEmpName(defValue4employeecreateinstancepatrEmpName);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrEmpSurname(defValue4employeecreateinstancepatrEmpSurname);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrSite(defValue4employeecreateinstancepatrSite);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrPhoneNumbers(defValue4employeecreateinstancepatrPhoneNumbers);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatremail(defValue4employeecreateinstancepatremail);
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrPicture(defValue4employeecreateinstancepatrPicture);
    }

    @Test
    public void test4getEmployeecreateinstancepatridEmployee() {
        assertEquals(defValue4employeecreateinstancepatridEmployee, instanceCreateinstanceRequest.getEmployeecreateinstancepatridEmployee());
    }

    @Test
    public void test4setEmployeecreateinstancepatridEmployee() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatridEmployee(test4setEmployeecreateinstancepatridEmployeeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatrEmpName() {
        assertEquals(defValue4employeecreateinstancepatrEmpName, instanceCreateinstanceRequest.getEmployeecreateinstancepatrEmpName());
    }

    @Test
    public void test4setEmployeecreateinstancepatrEmpName() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrEmpName(test4setEmployeecreateinstancepatrEmpNameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatrEmpSurname() {
        assertEquals(defValue4employeecreateinstancepatrEmpSurname, instanceCreateinstanceRequest.getEmployeecreateinstancepatrEmpSurname());
    }

    @Test
    public void test4setEmployeecreateinstancepatrEmpSurname() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrEmpSurname(test4setEmployeecreateinstancepatrEmpSurnameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatrSite() {
        assertEquals(defValue4employeecreateinstancepatrSite, instanceCreateinstanceRequest.getEmployeecreateinstancepatrSite());
    }

    @Test
    public void test4setEmployeecreateinstancepatrSite() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrSite(test4setEmployeecreateinstancepatrSiteArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatrPhoneNumbers() {
        assertEquals(defValue4employeecreateinstancepatrPhoneNumbers, instanceCreateinstanceRequest.getEmployeecreateinstancepatrPhoneNumbers());
    }

    @Test
    public void test4setEmployeecreateinstancepatrPhoneNumbers() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrPhoneNumbers(test4setEmployeecreateinstancepatrPhoneNumbersArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatremail() {
        assertEquals(defValue4employeecreateinstancepatremail, instanceCreateinstanceRequest.getEmployeecreateinstancepatremail());
    }

    @Test
    public void test4setEmployeecreateinstancepatremail() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatremail(test4setEmployeecreateinstancepatremailArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getEmployeecreateinstancepatrPicture() {
        assertEquals(defValue4employeecreateinstancepatrPicture, instanceCreateinstanceRequest.getEmployeecreateinstancepatrPicture());
    }

    @Test
    public void test4setEmployeecreateinstancepatrPicture() {
        instanceCreateinstanceRequest.setEmployeecreateinstancepatrPicture(test4setEmployeecreateinstancepatrPictureArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
    	instanceCreateinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCreateinstanceRequest.checkArguments();
    }
}
