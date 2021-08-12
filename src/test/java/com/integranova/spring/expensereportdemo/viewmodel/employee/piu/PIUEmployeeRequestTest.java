package com.integranova.spring.expensereportdemo.viewmodel.employee.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.employee.filter.FEmployeeName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUEmployeeRequestTest {

    private PIUEmployeeRequest instancePIUEmployeeRequest;

    // testGetFEmployeeName
    private static FEmployeeName testGetFEmployeeNameResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFEmployeeName();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFEmployeeName() {
        testGetFEmployeeNameResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUEmployeeRequest = new PIUEmployeeRequest();
    }

    @Test
    public void testGetFEmployeeName() {
        assertEquals(testGetFEmployeeNameResult, instancePIUEmployeeRequest.getFEmployeeName());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUEmployeeRequest.buildQueryRequest();
        assertNotNull(instancePIUEmployeeRequest);
    }
}
