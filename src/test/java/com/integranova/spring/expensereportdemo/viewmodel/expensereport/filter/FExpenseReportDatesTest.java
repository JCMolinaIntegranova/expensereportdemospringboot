package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.global.Constants;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FExpenseReportDatesTest {

    private FExpenseReportDates instanceFExpenseReportDates;

    // testgetVIniDate

    // testsetVIniDate
    private static Date testsetVIniDateArg1;

    // testgetVFinalDate

    // testsetVFinalDate
    private static Date testsetVFinalDateArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVIniDate();
        setUpMockData4testsetVIniDate();
        setUpMockData4testgetVFinalDate();
        setUpMockData4testsetVFinalDate();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVIniDate() {
    }

    private static void setUpMockData4testsetVIniDate() {
        testsetVIniDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetVFinalDate() {
    }

    private static void setUpMockData4testsetVFinalDate() {
        testsetVFinalDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFExpenseReportDates = new FExpenseReportDates();
        instanceFExpenseReportDates.setVIniDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceFExpenseReportDates.setVFinalDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    @Test
    public void testgetVIniDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceFExpenseReportDates.getVIniDate());
    }

    @Test
    public void testsetVIniDate() {
        instanceFExpenseReportDates.setVIniDate(testsetVIniDateArg1);
        assertNotNull(instanceFExpenseReportDates);
    }

    @Test
    public void testgetVFinalDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceFExpenseReportDates.getVFinalDate());
    }

    @Test
    public void testsetVFinalDate() {
        instanceFExpenseReportDates.setVFinalDate(testsetVFinalDateArg1);
        assertNotNull(instanceFExpenseReportDates);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFExpenseReportDates.buildFilterRequest();
        assertNotNull(instanceFExpenseReportDates);
    }
}
