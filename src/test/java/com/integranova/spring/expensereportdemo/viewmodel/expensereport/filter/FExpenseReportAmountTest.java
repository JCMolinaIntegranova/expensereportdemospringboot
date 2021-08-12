package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FExpenseReportAmountTest {

    private FExpenseReportAmount instanceFExpenseReportAmount;

    // testgetVAmount

    // testsetVAmount
    private static Double testsetVAmountArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVAmount();
        setUpMockData4testsetVAmount();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVAmount() {
    }

    private static void setUpMockData4testsetVAmount() {
        testsetVAmountArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFExpenseReportAmount = new FExpenseReportAmount();
        instanceFExpenseReportAmount.setVAmount(Double.valueOf(0));
    }

    @Test
    public void testgetVAmount() {
        assertEquals(Double.valueOf(0), instanceFExpenseReportAmount.getVAmount());
    }

    @Test
    public void testsetVAmount() {
        instanceFExpenseReportAmount.setVAmount(testsetVAmountArg1);
        assertNotNull(instanceFExpenseReportAmount);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFExpenseReportAmount.buildFilterRequest();
        assertNotNull(instanceFExpenseReportAmount);
    }
}
