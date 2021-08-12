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
public class DSExpenseLineTest {

    private DSExpenseLine instanceDSExpenseLine;

    // testDSExpenseLine
    private static ExpenseLine testDSExpenseLineArg1;

    // testDSExpenseLine2
    private static ExpenseLine testDSExpenseLine2Arg1;

    // testgetDSExpenseLineIdExpenseLine

    // testsetDSExpenseLineIdExpenseLine
    private static Long testsetDSExpenseLineIdExpenseLineArg1;

    // testgetDSExpenseLineExpenseDate

    // testsetDSExpenseLineExpenseDate
    private static Date testsetDSExpenseLineExpenseDateArg1;

    // testgetDSExpenseLineLnDescription

    // testsetDSExpenseLineLnDescription
    private static String testsetDSExpenseLineLnDescriptionArg1;

    // testgetDSExpenseLinePrice

    // testsetDSExpenseLinePrice
    private static Double testsetDSExpenseLinePriceArg1;

    // testgetDSExpenseLineUnits

    // testsetDSExpenseLineUnits
    private static Double testsetDSExpenseLineUnitsArg1;

    // testgetDSExpenseLineTotalLine

    // testsetDSExpenseLineTotalLine
    private static Double testsetDSExpenseLineTotalLineArg1;

    // testgetDSExpenseLineTotalLineCurr

    // testsetDSExpenseLineTotalLineCurr
    private static Double testsetDSExpenseLineTotalLineCurrArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseLine();
        setUpMockData4testDSExpenseLine2();
        setUpMockData4testgetDSExpenseLineIdExpenseLine();
        setUpMockData4testsetDSExpenseLineIdExpenseLine();
        setUpMockData4testgetDSExpenseLineExpenseDate();
        setUpMockData4testsetDSExpenseLineExpenseDate();
        setUpMockData4testgetDSExpenseLineLnDescription();
        setUpMockData4testsetDSExpenseLineLnDescription();
        setUpMockData4testgetDSExpenseLinePrice();
        setUpMockData4testsetDSExpenseLinePrice();
        setUpMockData4testgetDSExpenseLineUnits();
        setUpMockData4testsetDSExpenseLineUnits();
        setUpMockData4testgetDSExpenseLineTotalLine();
        setUpMockData4testsetDSExpenseLineTotalLine();
        setUpMockData4testgetDSExpenseLineTotalLineCurr();
        setUpMockData4testsetDSExpenseLineTotalLineCurr();
    }

    private static void setUpMockData4testDSExpenseLine() {
        testDSExpenseLineArg1 = new ExpenseLine();
    }

    private static void setUpMockData4testDSExpenseLine2() {
        testDSExpenseLine2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseLineIdExpenseLine() {
    }

    private static void setUpMockData4testsetDSExpenseLineIdExpenseLine() {
        testsetDSExpenseLineIdExpenseLineArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseLineExpenseDate() {
    }

    private static void setUpMockData4testsetDSExpenseLineExpenseDate() {
        testsetDSExpenseLineExpenseDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSExpenseLineLnDescription() {
    }

    private static void setUpMockData4testsetDSExpenseLineLnDescription() {
        testsetDSExpenseLineLnDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseLinePrice() {
    }

    private static void setUpMockData4testsetDSExpenseLinePrice() {
        testsetDSExpenseLinePriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseLineUnits() {
    }

    private static void setUpMockData4testsetDSExpenseLineUnits() {
        testsetDSExpenseLineUnitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseLineTotalLine() {
    }

    private static void setUpMockData4testsetDSExpenseLineTotalLine() {
        testsetDSExpenseLineTotalLineArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseLineTotalLineCurr() {
    }

    private static void setUpMockData4testsetDSExpenseLineTotalLineCurr() {
        testsetDSExpenseLineTotalLineCurrArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseLine = new DSExpenseLine();
        instanceDSExpenseLine.setDSExpenseLineIdExpenseLine(Long.valueOf(0));
        instanceDSExpenseLine.setDSExpenseLineExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSExpenseLine.setDSExpenseLineLnDescription("");
        instanceDSExpenseLine.setDSExpenseLinePrice(Double.valueOf(0));
        instanceDSExpenseLine.setDSExpenseLineUnits(Double.valueOf(0));
        instanceDSExpenseLine.setDSExpenseLineTotalLine(Double.valueOf(0));
        instanceDSExpenseLine.setDSExpenseLineTotalLineCurr(Double.valueOf(0));
    }

    @Test
    public void testDSExpenseLine() {
        instanceDSExpenseLine = new DSExpenseLine(testDSExpenseLineArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testDSExpenseLine2() {
        instanceDSExpenseLine = new DSExpenseLine(testDSExpenseLine2Arg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineIdExpenseLine() {
        assertEquals(Long.valueOf(0), instanceDSExpenseLine.getDSExpenseLineIdExpenseLine());
    }

    @Test
    public void testsetDSExpenseLineIdExpenseLine() {
        instanceDSExpenseLine.setDSExpenseLineIdExpenseLine(testsetDSExpenseLineIdExpenseLineArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineExpenseDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSExpenseLine.getDSExpenseLineExpenseDate());
    }

    @Test
    public void testsetDSExpenseLineExpenseDate() {
        instanceDSExpenseLine.setDSExpenseLineExpenseDate(testsetDSExpenseLineExpenseDateArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineLnDescription() {
        assertEquals("", instanceDSExpenseLine.getDSExpenseLineLnDescription());
    }

    @Test
    public void testsetDSExpenseLineLnDescription() {
        instanceDSExpenseLine.setDSExpenseLineLnDescription(testsetDSExpenseLineLnDescriptionArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLinePrice() {
        assertEquals(Double.valueOf(0), instanceDSExpenseLine.getDSExpenseLinePrice());
    }

    @Test
    public void testsetDSExpenseLinePrice() {
        instanceDSExpenseLine.setDSExpenseLinePrice(testsetDSExpenseLinePriceArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineUnits() {
        assertEquals(Double.valueOf(0), instanceDSExpenseLine.getDSExpenseLineUnits());
    }

    @Test
    public void testsetDSExpenseLineUnits() {
        instanceDSExpenseLine.setDSExpenseLineUnits(testsetDSExpenseLineUnitsArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineTotalLine() {
        assertEquals(Double.valueOf(0), instanceDSExpenseLine.getDSExpenseLineTotalLine());
    }

    @Test
    public void testsetDSExpenseLineTotalLine() {
        instanceDSExpenseLine.setDSExpenseLineTotalLine(testsetDSExpenseLineTotalLineArg1);
        assertNotNull(instanceDSExpenseLine);
    }

    @Test
    public void testgetDSExpenseLineTotalLineCurr() {
        assertEquals(Double.valueOf(0), instanceDSExpenseLine.getDSExpenseLineTotalLineCurr());
    }

    @Test
    public void testsetDSExpenseLineTotalLineCurr() {
        instanceDSExpenseLine.setDSExpenseLineTotalLineCurr(testsetDSExpenseLineTotalLineCurrArg1);
        assertNotNull(instanceDSExpenseLine);
    }
}
