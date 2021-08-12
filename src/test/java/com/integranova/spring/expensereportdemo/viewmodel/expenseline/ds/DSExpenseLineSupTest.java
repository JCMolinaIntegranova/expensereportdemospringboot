package com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSExpenseLineSupTest {

    private DSExpenseLineSup instanceDSExpenseLineSup;

    // testDSExpenseLineSup
    private static ExpenseLine testDSExpenseLineSupArg1;

    // testDSExpenseLineSup2
    private static ExpenseLine testDSExpenseLineSup2Arg1;

    // testgetDSExpenseLineSupExpenseDate

    // testsetDSExpenseLineSupExpenseDate
    private static Date testsetDSExpenseLineSupExpenseDateArg1;

    // testgetDSExpenseLineSupTotalLine

    // testsetDSExpenseLineSupTotalLine
    private static Double testsetDSExpenseLineSupTotalLineArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseLineSup();
        setUpMockData4testDSExpenseLineSup2();
        setUpMockData4testgetDSExpenseLineSupExpenseDate();
        setUpMockData4testsetDSExpenseLineSupExpenseDate();
        setUpMockData4testgetDSExpenseLineSupTotalLine();
        setUpMockData4testsetDSExpenseLineSupTotalLine();
    }

    private static void setUpMockData4testDSExpenseLineSup() {
        testDSExpenseLineSupArg1 = new ExpenseLine();
    }

    private static void setUpMockData4testDSExpenseLineSup2() {
        testDSExpenseLineSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseLineSupExpenseDate() {
    }

    private static void setUpMockData4testsetDSExpenseLineSupExpenseDate() {
        testsetDSExpenseLineSupExpenseDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSExpenseLineSupTotalLine() {
    }

    private static void setUpMockData4testsetDSExpenseLineSupTotalLine() {
        testsetDSExpenseLineSupTotalLineArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseLineSup = new DSExpenseLineSup();
        instanceDSExpenseLineSup.setDSExpenseLineSupExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSExpenseLineSup.setDSExpenseLineSupTotalLine(Double.valueOf(0));
    }

    @Test
    public void testDSExpenseLineSup() {
        instanceDSExpenseLineSup = new DSExpenseLineSup(testDSExpenseLineSupArg1);
        assertNotNull(instanceDSExpenseLineSup);
    }

    @Test
    public void testDSExpenseLineSup2() {
        instanceDSExpenseLineSup = new DSExpenseLineSup(testDSExpenseLineSup2Arg1);
        assertNotNull(instanceDSExpenseLineSup);
    }

    @Test
    public void testgetDSExpenseLineSupExpenseDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSExpenseLineSup.getDSExpenseLineSupExpenseDate());
    }

    @Test
    public void testsetDSExpenseLineSupExpenseDate() {
        instanceDSExpenseLineSup.setDSExpenseLineSupExpenseDate(testsetDSExpenseLineSupExpenseDateArg1);
        assertNotNull(instanceDSExpenseLineSup);
    }

    @Test
    public void testgetDSExpenseLineSupTotalLine() {
        assertEquals(Double.valueOf(0), instanceDSExpenseLineSup.getDSExpenseLineSupTotalLine());
    }

    @Test
    public void testsetDSExpenseLineSupTotalLine() {
        instanceDSExpenseLineSup.setDSExpenseLineSupTotalLine(testsetDSExpenseLineSupTotalLineArg1);
        assertNotNull(instanceDSExpenseLineSup);
    }
}
