package com.integranova.spring.expensereportdemo.viewmodel.employee.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FEmployeeNameTest {

    private FEmployeeName instanceFEmployeeName;

    // testgetVFullName

    // testsetVFullName
    private static String testsetVFullNameArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVFullName();
        setUpMockData4testsetVFullName();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVFullName() {
    }

    private static void setUpMockData4testsetVFullName() {
        testsetVFullNameArg1 = "";
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFEmployeeName = new FEmployeeName();
        instanceFEmployeeName.setVFullName("");
    }

    @Test
    public void testgetVFullName() {
        assertEquals("", instanceFEmployeeName.getVFullName());
    }

    @Test
    public void testsetVFullName() {
        instanceFEmployeeName.setVFullName(testsetVFullNameArg1);
        assertNotNull(instanceFEmployeeName);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFEmployeeName.buildFilterRequest();
        assertNotNull(instanceFEmployeeName);
    }
}
