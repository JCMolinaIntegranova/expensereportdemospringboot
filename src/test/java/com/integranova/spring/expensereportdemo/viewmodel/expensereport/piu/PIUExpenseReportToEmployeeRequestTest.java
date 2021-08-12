package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportDates;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseReportToEmployeeRequestTest {

    private PIUExpenseReportToEmployeeRequest instancePIUExpenseReportToEmployeeRequest;

    // testGetFExpenseReportDates
    private static FExpenseReportDates testGetFExpenseReportDatesResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFExpenseReportDates();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFExpenseReportDates() {
        testGetFExpenseReportDatesResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUExpenseReportToEmployeeRequest = new PIUExpenseReportToEmployeeRequest();
    }

    @Test
    public void testGetFExpenseReportDates() {
        assertEquals(testGetFExpenseReportDatesResult, instancePIUExpenseReportToEmployeeRequest.getFExpenseReportDates());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUExpenseReportToEmployeeRequest.buildQueryRequest();
        assertNotNull(instancePIUExpenseReportToEmployeeRequest);
    }
}
