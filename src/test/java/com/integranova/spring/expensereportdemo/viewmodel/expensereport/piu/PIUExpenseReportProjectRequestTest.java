package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportAmount;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportDates;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseReportProjectRequestTest {

    private PIUExpenseReportProjectRequest instancePIUExpenseReportProjectRequest;

    // testGetFExpenseReportDates
    private static FExpenseReportDates testGetFExpenseReportDatesResult;

    // testGetFExpenseReportAmount
    private static FExpenseReportAmount testGetFExpenseReportAmountResult;

    // testGetFExpenseReportStatus
    private static FExpenseReportStatus testGetFExpenseReportStatusResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFExpenseReportDates();
        setUpMockData4testGetFExpenseReportAmount();
        setUpMockData4testGetFExpenseReportStatus();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFExpenseReportDates() {
        testGetFExpenseReportDatesResult = null;
    }

    private static void setUpMockData4testGetFExpenseReportAmount() {
        testGetFExpenseReportAmountResult = null;
    }

    private static void setUpMockData4testGetFExpenseReportStatus() {
        testGetFExpenseReportStatusResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUExpenseReportProjectRequest = new PIUExpenseReportProjectRequest();
    }

    @Test
    public void testGetFExpenseReportDates() {
        assertEquals(testGetFExpenseReportDatesResult, instancePIUExpenseReportProjectRequest.getFExpenseReportDates());
    }

    @Test
    public void testGetFExpenseReportAmount() {
        assertEquals(testGetFExpenseReportAmountResult, instancePIUExpenseReportProjectRequest.getFExpenseReportAmount());
    }

    @Test
    public void testGetFExpenseReportStatus() {
        assertEquals(testGetFExpenseReportStatusResult, instancePIUExpenseReportProjectRequest.getFExpenseReportStatus());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUExpenseReportProjectRequest.buildQueryRequest();
        assertNotNull(instancePIUExpenseReportProjectRequest);
    }
}
