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
public class TDELETERequestTest {

    private TDELETERequest instanceTDELETERequest;

    // Default values
    private static EmployeeOid defValue4employeeTDELETEpthisEmployee = new EmployeeOid();
    private static Employee defValue4employeeTDELETEpthisEmployeeInstance = new Employee(new EmployeeOid(""));


    // test4getEmployeeTDELETEpthisEmployee

    // test4setEmployeeTDELETEpthisEmployee
    private static EmployeeOid test4setEmployeeTDELETEpthisEmployeeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeeTDELETEpthisEmployee();
        setUpMockData4test4setEmployeeTDELETEpthisEmployee();
    }

    private static void setUpMockData4test4getEmployeeTDELETEpthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeeTDELETEpthisEmployee() {
        test4setEmployeeTDELETEpthisEmployeeArg1 = new EmployeeOid();
    }

    @Before
    public void setUp() {
        instanceTDELETERequest = new TDELETERequest();
        instanceTDELETERequest.setEmployeeTDELETEpthisEmployee(defValue4employeeTDELETEpthisEmployee);
        instanceTDELETERequest.setEmployeeTDELETEpthisEmployeeInstance(defValue4employeeTDELETEpthisEmployeeInstance);
    }

    @Test
    public void test4getEmployeeTDELETEpthisEmployee() {
        assertEquals(defValue4employeeTDELETEpthisEmployee, instanceTDELETERequest.getEmployeeTDELETEpthisEmployee());
    }

    @Test
    public void test4setEmployeeTDELETEpthisEmployee() {
        instanceTDELETERequest.setEmployeeTDELETEpthisEmployee(test4setEmployeeTDELETEpthisEmployeeArg1);
        assertNotNull(instanceTDELETERequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTDELETERequest = new TDELETERequest();
    	instanceTDELETERequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTDELETERequest.checkArguments();
    }
}
