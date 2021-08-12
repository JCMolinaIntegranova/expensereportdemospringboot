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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static EmployeeOid defValue4employeedeleteinstancepthisEmployee = new EmployeeOid();
    private static Employee defValue4employeedeleteinstancepthisEmployeeInstance = new Employee(new EmployeeOid(""));


    // test4getEmployeedeleteinstancepthisEmployee

    // test4setEmployeedeleteinstancepthisEmployee
    private static EmployeeOid test4setEmployeedeleteinstancepthisEmployeeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getEmployeedeleteinstancepthisEmployee();
        setUpMockData4test4setEmployeedeleteinstancepthisEmployee();
    }

    private static void setUpMockData4test4getEmployeedeleteinstancepthisEmployee() {
    }

    private static void setUpMockData4test4setEmployeedeleteinstancepthisEmployee() {
        test4setEmployeedeleteinstancepthisEmployeeArg1 = new EmployeeOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setEmployeedeleteinstancepthisEmployee(defValue4employeedeleteinstancepthisEmployee);
        instanceDeleteinstanceRequest.setEmployeedeleteinstancepthisEmployeeInstance(defValue4employeedeleteinstancepthisEmployeeInstance);
    }

    @Test
    public void test4getEmployeedeleteinstancepthisEmployee() {
        assertEquals(defValue4employeedeleteinstancepthisEmployee, instanceDeleteinstanceRequest.getEmployeedeleteinstancepthisEmployee());
    }

    @Test
    public void test4setEmployeedeleteinstancepthisEmployee() {
        instanceDeleteinstanceRequest.setEmployeedeleteinstancepthisEmployee(test4setEmployeedeleteinstancepthisEmployeeArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
