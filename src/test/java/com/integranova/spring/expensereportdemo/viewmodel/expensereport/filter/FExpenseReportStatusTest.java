package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FExpenseReportStatusTest {

    private FExpenseReportStatus instanceFExpenseReportStatus;

    // testgetVStatus

    // testsetVStatus
    private static Long testsetVStatusArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVStatus();
        setUpMockData4testsetVStatus();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVStatus() {
    }

    private static void setUpMockData4testsetVStatus() {
        testsetVStatusArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFExpenseReportStatus = new FExpenseReportStatus();
        instanceFExpenseReportStatus.setVStatus(Long.valueOf(0));
    }

    @Test
    public void testgetVStatus() {
        assertEquals(Long.valueOf(0), instanceFExpenseReportStatus.getVStatus());
    }

    @Test
    public void testsetVStatus() {
        instanceFExpenseReportStatus.setVStatus(testsetVStatusArg1);
        assertNotNull(instanceFExpenseReportStatus);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFExpenseReportStatus.buildFilterRequest();
        assertNotNull(instanceFExpenseReportStatus);
    }
}
