package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FByProject;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportAmount;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseReportRequestTest {

    private PIUExpenseReportRequest instancePIUExpenseReportRequest;

    // testGetFByProject
    private static FByProject testGetFByProjectResult;

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
        setUpMockData4testGetFByProject();
        setUpMockData4testGetFExpenseReportAmount();
        setUpMockData4testGetFExpenseReportStatus();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFByProject() {
        testGetFByProjectResult = null;
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
        instancePIUExpenseReportRequest = new PIUExpenseReportRequest();
    }

    @Test
    public void testGetFByProject() {
        assertEquals(testGetFByProjectResult, instancePIUExpenseReportRequest.getFByProject());
    }

    @Test
    public void testGetFExpenseReportAmount() {
        assertEquals(testGetFExpenseReportAmountResult, instancePIUExpenseReportRequest.getFExpenseReportAmount());
    }

    @Test
    public void testGetFExpenseReportStatus() {
        assertEquals(testGetFExpenseReportStatusResult, instancePIUExpenseReportRequest.getFExpenseReportStatus());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUExpenseReportRequest.buildQueryRequest();
        assertNotNull(instancePIUExpenseReportRequest);
    }
}
