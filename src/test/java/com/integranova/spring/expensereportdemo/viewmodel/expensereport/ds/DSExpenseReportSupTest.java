package com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSExpenseReportSupTest {

    private DSExpenseReportSup instanceDSExpenseReportSup;

    // testDSExpenseReportSup
    private static ExpenseReport testDSExpenseReportSupArg1;

    // testDSExpenseReportSup2
    private static ExpenseReport testDSExpenseReportSup2Arg1;

    // testgetDSExpenseReportSupPresentDate

    // testsetDSExpenseReportSupPresentDate
    private static Date testsetDSExpenseReportSupPresentDateArg1;

    // testgetDSExpenseReportSupStatus

    // testsetDSExpenseReportSupStatus
    private static Long testsetDSExpenseReportSupStatusArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseReportSup();
        setUpMockData4testDSExpenseReportSup2();
        setUpMockData4testgetDSExpenseReportSupPresentDate();
        setUpMockData4testsetDSExpenseReportSupPresentDate();
        setUpMockData4testgetDSExpenseReportSupStatus();
        setUpMockData4testsetDSExpenseReportSupStatus();
    }

    private static void setUpMockData4testDSExpenseReportSup() {
        testDSExpenseReportSupArg1 = new ExpenseReport();
    }

    private static void setUpMockData4testDSExpenseReportSup2() {
        testDSExpenseReportSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseReportSupPresentDate() {
    }

    private static void setUpMockData4testsetDSExpenseReportSupPresentDate() {
        testsetDSExpenseReportSupPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSExpenseReportSupStatus() {
    }

    private static void setUpMockData4testsetDSExpenseReportSupStatus() {
        testsetDSExpenseReportSupStatusArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseReportSup = new DSExpenseReportSup();
        instanceDSExpenseReportSup.setDSExpenseReportSupPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSExpenseReportSup.setDSExpenseReportSupStatus(Long.valueOf(0));
    }

    @Test
    public void testDSExpenseReportSup() {
        instanceDSExpenseReportSup = new DSExpenseReportSup(testDSExpenseReportSupArg1);
        assertNotNull(instanceDSExpenseReportSup);
    }

    @Test
    public void testDSExpenseReportSup2() {
        instanceDSExpenseReportSup = new DSExpenseReportSup(testDSExpenseReportSup2Arg1);
        assertNotNull(instanceDSExpenseReportSup);
    }

    @Test
    public void testgetDSExpenseReportSupPresentDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSExpenseReportSup.getDSExpenseReportSupPresentDate());
    }

    @Test
    public void testsetDSExpenseReportSupPresentDate() {
        instanceDSExpenseReportSup.setDSExpenseReportSupPresentDate(testsetDSExpenseReportSupPresentDateArg1);
        assertNotNull(instanceDSExpenseReportSup);
    }

    @Test
    public void testgetDSExpenseReportSupStatus() {
        assertEquals(Long.valueOf(0), instanceDSExpenseReportSup.getDSExpenseReportSupStatus());
    }

    @Test
    public void testsetDSExpenseReportSupStatus() {
        instanceDSExpenseReportSup.setDSExpenseReportSupStatus(testsetDSExpenseReportSupStatusArg1);
        assertNotNull(instanceDSExpenseReportSup);
    }
}
