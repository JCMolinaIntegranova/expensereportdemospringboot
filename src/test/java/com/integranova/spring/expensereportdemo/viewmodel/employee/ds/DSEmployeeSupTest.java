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
public class DSEmployeeSupTest {

    private DSEmployeeSup instanceDSEmployeeSup;

    // testDSEmployeeSup
    private static Employee testDSEmployeeSupArg1;

    // testDSEmployeeSup2
    private static Employee testDSEmployeeSup2Arg1;

    // testgetDSEmployeeSupEmpName

    // testsetDSEmployeeSupEmpName
    private static String testsetDSEmployeeSupEmpNameArg1;

    // testgetDSEmployeeSupEmpSurname

    // testsetDSEmployeeSupEmpSurname
    private static String testsetDSEmployeeSupEmpSurnameArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSEmployeeSup();
        setUpMockData4testDSEmployeeSup2();
        setUpMockData4testgetDSEmployeeSupEmpName();
        setUpMockData4testsetDSEmployeeSupEmpName();
        setUpMockData4testgetDSEmployeeSupEmpSurname();
        setUpMockData4testsetDSEmployeeSupEmpSurname();
    }

    private static void setUpMockData4testDSEmployeeSup() {
        testDSEmployeeSupArg1 = new Employee();
    }

    private static void setUpMockData4testDSEmployeeSup2() {
        testDSEmployeeSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSEmployeeSupEmpName() {
    }

    private static void setUpMockData4testsetDSEmployeeSupEmpName() {
        testsetDSEmployeeSupEmpNameArg1 = "";
    }

    private static void setUpMockData4testgetDSEmployeeSupEmpSurname() {
    }

    private static void setUpMockData4testsetDSEmployeeSupEmpSurname() {
        testsetDSEmployeeSupEmpSurnameArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSEmployeeSup = new DSEmployeeSup();
        instanceDSEmployeeSup.setDSEmployeeSupEmpName("");
        instanceDSEmployeeSup.setDSEmployeeSupEmpSurname("");
    }

    @Test
    public void testDSEmployeeSup() {
        instanceDSEmployeeSup = new DSEmployeeSup(testDSEmployeeSupArg1);
        assertNotNull(instanceDSEmployeeSup);
    }

    @Test
    public void testDSEmployeeSup2() {
        instanceDSEmployeeSup = new DSEmployeeSup(testDSEmployeeSup2Arg1);
        assertNotNull(instanceDSEmployeeSup);
    }

    @Test
    public void testgetDSEmployeeSupEmpName() {
        assertEquals("", instanceDSEmployeeSup.getDSEmployeeSupEmpName());
    }

    @Test
    public void testsetDSEmployeeSupEmpName() {
        instanceDSEmployeeSup.setDSEmployeeSupEmpName(testsetDSEmployeeSupEmpNameArg1);
        assertNotNull(instanceDSEmployeeSup);
    }

    @Test
    public void testgetDSEmployeeSupEmpSurname() {
        assertEquals("", instanceDSEmployeeSup.getDSEmployeeSupEmpSurname());
    }

    @Test
    public void testsetDSEmployeeSupEmpSurname() {
        instanceDSEmployeeSup.setDSEmployeeSupEmpSurname(testsetDSEmployeeSupEmpSurnameArg1);
        assertNotNull(instanceDSEmployeeSup);
    }
}
