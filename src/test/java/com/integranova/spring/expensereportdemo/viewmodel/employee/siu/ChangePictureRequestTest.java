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
public class ChangePictureRequestTest {

    private ChangePictureRequest instanceChangePictureRequest;

    // Default values
    private static EmployeeOid defValue4employeechangePicturepthisEmployee = new EmployeeOid();
    private static Employee defValue4employeechangePicturepthisEmployeeInstance = new Employee(new EmployeeOid(""));
    private static byte[] defValue4employeechangePicturepPicture = "".getBytes();


    // test4getEmployeechangePicturepthisEmployee

    // test4setEmployeechangePicturepthisEmployee
    private static EmployeeOid test4setEmployeechangePicturepthisEmployeeArg1;

    // test4getEmployeechangePicturepPicture

    // test4setEmployeechangePicturepPicture
    private static byte[] test4setEmployeechangePicturepPictureArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeechangePicturepthisEmployee();
        setUpMockData4test4setEmployeechangePicturepthisEmployee();
        setUpMockData4test4getEmployeechangePicturepPicture();
        setUpMockData4test4setEmployeechangePicturepPicture();
    }

    private static void setUpMockData4test4getEmployeechangePicturepthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeechangePicturepthisEmployee() {
        test4setEmployeechangePicturepthisEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getEmployeechangePicturepPicture() {
    }

    private static void setUpMockData4test4setEmployeechangePicturepPicture() {
        test4setEmployeechangePicturepPictureArg1 = "".getBytes();
    }

    @Before
    public void setUp() {
        instanceChangePictureRequest = new ChangePictureRequest();
        instanceChangePictureRequest.setEmployeechangePicturepthisEmployee(defValue4employeechangePicturepthisEmployee);
        instanceChangePictureRequest.setEmployeechangePicturepthisEmployeeInstance(defValue4employeechangePicturepthisEmployeeInstance);
        instanceChangePictureRequest.setEmployeechangePicturepPicture(defValue4employeechangePicturepPicture);
    }

    @Test
    public void test4getEmployeechangePicturepthisEmployee() {
        assertEquals(defValue4employeechangePicturepthisEmployee, instanceChangePictureRequest.getEmployeechangePicturepthisEmployee());
    }

    @Test
    public void test4setEmployeechangePicturepthisEmployee() {
        instanceChangePictureRequest.setEmployeechangePicturepthisEmployee(test4setEmployeechangePicturepthisEmployeeArg1);
        assertNotNull(instanceChangePictureRequest);
    }

    @Test
    public void test4getEmployeechangePicturepPicture() {
        assertEquals(defValue4employeechangePicturepPicture, instanceChangePictureRequest.getEmployeechangePicturepPicture());
    }

    @Test
    public void test4setEmployeechangePicturepPicture() {
        instanceChangePictureRequest.setEmployeechangePicturepPicture(test4setEmployeechangePicturepPictureArg1);
        assertNotNull(instanceChangePictureRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceChangePictureRequest = new ChangePictureRequest();
    	instanceChangePictureRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceChangePictureRequest.checkArguments();
    }
}
