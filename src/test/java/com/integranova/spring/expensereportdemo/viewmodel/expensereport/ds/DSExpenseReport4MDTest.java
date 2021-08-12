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
public class DSExpenseReport4MDTest {

    private DSExpenseReport4MD instanceDSExpenseReport4MD;

    // testDSExpenseReport4MD
    private static ExpenseReport testDSExpenseReport4MDArg1;

    // testDSExpenseReport4MD2
    private static ExpenseReport testDSExpenseReport4MD2Arg1;

    // testgetDSExpenseReport4MDIdExpenseRepor

    // testsetDSExpenseReport4MDIdExpenseRepor
    private static Long testsetDSExpenseReport4MDIdExpenseReporArg1;

    // testgetDSExpenseReport4MDPresentDate

    // testsetDSExpenseReport4MDPresentDate
    private static Date testsetDSExpenseReport4MDPresentDateArg1;

    // testgetDSExpenseReport4MDProjectDotProjectName

    // testsetDSExpenseReport4MDProjectDotProjectName
    private static String testsetDSExpenseReport4MDProjectDotProjectNameArg1;

    // testgetDSExpenseReport4MDCause

    // testsetDSExpenseReport4MDCause
    private static String testsetDSExpenseReport4MDCauseArg1;

    // testgetDSExpenseReport4MDExpenseCurrencyDotCurrencyName

    // testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyName
    private static String testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyNameArg1;

    // testgetDSExpenseReport4MDExchange

    // testsetDSExpenseReport4MDExchange
    private static Double testsetDSExpenseReport4MDExchangeArg1;

    // testgetDSExpenseReport4MDBalanceCur

    // testsetDSExpenseReport4MDBalanceCur
    private static Double testsetDSExpenseReport4MDBalanceCurArg1;

    // testgetDSExpenseReport4MDStatus

    // testsetDSExpenseReport4MDStatus
    private static Long testsetDSExpenseReport4MDStatusArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseReport4MD();
        setUpMockData4testDSExpenseReport4MD2();
        setUpMockData4testgetDSExpenseReport4MDIdExpenseRepor();
        setUpMockData4testsetDSExpenseReport4MDIdExpenseRepor();
        setUpMockData4testgetDSExpenseReport4MDPresentDate();
        setUpMockData4testsetDSExpenseReport4MDPresentDate();
        setUpMockData4testgetDSExpenseReport4MDProjectDotProjectName();
        setUpMockData4testsetDSExpenseReport4MDProjectDotProjectName();
        setUpMockData4testgetDSExpenseReport4MDCause();
        setUpMockData4testsetDSExpenseReport4MDCause();
        setUpMockData4testgetDSExpenseReport4MDExpenseCurrencyDotCurrencyName();
        setUpMockData4testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyName();
        setUpMockData4testgetDSExpenseReport4MDExchange();
        setUpMockData4testsetDSExpenseReport4MDExchange();
        setUpMockData4testgetDSExpenseReport4MDBalanceCur();
        setUpMockData4testsetDSExpenseReport4MDBalanceCur();
        setUpMockData4testgetDSExpenseReport4MDStatus();
        setUpMockData4testsetDSExpenseReport4MDStatus();
    }

    private static void setUpMockData4testDSExpenseReport4MD() {
        testDSExpenseReport4MDArg1 = new ExpenseReport();
    }

    private static void setUpMockData4testDSExpenseReport4MD2() {
        testDSExpenseReport4MD2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseReport4MDIdExpenseRepor() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDIdExpenseRepor() {
        testsetDSExpenseReport4MDIdExpenseReporArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4MDPresentDate() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDPresentDate() {
        testsetDSExpenseReport4MDPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSExpenseReport4MDProjectDotProjectName() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDProjectDotProjectName() {
        testsetDSExpenseReport4MDProjectDotProjectNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4MDCause() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDCause() {
        testsetDSExpenseReport4MDCauseArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4MDExpenseCurrencyDotCurrencyName() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyName() {
        testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4MDExchange() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDExchange() {
        testsetDSExpenseReport4MDExchangeArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4MDBalanceCur() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDBalanceCur() {
        testsetDSExpenseReport4MDBalanceCurArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4MDStatus() {
    }

    private static void setUpMockData4testsetDSExpenseReport4MDStatus() {
        testsetDSExpenseReport4MDStatusArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseReport4MD = new DSExpenseReport4MD();
        instanceDSExpenseReport4MD.setDSExpenseReport4MDIdExpenseRepor(Long.valueOf(0));
        instanceDSExpenseReport4MD.setDSExpenseReport4MDPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSExpenseReport4MD.setDSExpenseReport4MDProjectDotProjectName("");
        instanceDSExpenseReport4MD.setDSExpenseReport4MDCause("");
        instanceDSExpenseReport4MD.setDSExpenseReport4MDExpenseCurrencyDotCurrencyName("");
        instanceDSExpenseReport4MD.setDSExpenseReport4MDExchange(Double.valueOf(0));
        instanceDSExpenseReport4MD.setDSExpenseReport4MDBalanceCur(Double.valueOf(0));
        instanceDSExpenseReport4MD.setDSExpenseReport4MDStatus(Long.valueOf(0));
    }

    @Test
    public void testDSExpenseReport4MD() {
        instanceDSExpenseReport4MD = new DSExpenseReport4MD(testDSExpenseReport4MDArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testDSExpenseReport4MD2() {
        instanceDSExpenseReport4MD = new DSExpenseReport4MD(testDSExpenseReport4MD2Arg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDIdExpenseRepor() {
        assertEquals(Long.valueOf(0), instanceDSExpenseReport4MD.getDSExpenseReport4MDIdExpenseRepor());
    }

    @Test
    public void testsetDSExpenseReport4MDIdExpenseRepor() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDIdExpenseRepor(testsetDSExpenseReport4MDIdExpenseReporArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDPresentDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSExpenseReport4MD.getDSExpenseReport4MDPresentDate());
    }

    @Test
    public void testsetDSExpenseReport4MDPresentDate() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDPresentDate(testsetDSExpenseReport4MDPresentDateArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDProjectDotProjectName() {
        assertEquals("", instanceDSExpenseReport4MD.getDSExpenseReport4MDProjectDotProjectName());
    }

    @Test
    public void testsetDSExpenseReport4MDProjectDotProjectName() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDProjectDotProjectName(testsetDSExpenseReport4MDProjectDotProjectNameArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDCause() {
        assertEquals("", instanceDSExpenseReport4MD.getDSExpenseReport4MDCause());
    }

    @Test
    public void testsetDSExpenseReport4MDCause() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDCause(testsetDSExpenseReport4MDCauseArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDExpenseCurrencyDotCurrencyName() {
        assertEquals("", instanceDSExpenseReport4MD.getDSExpenseReport4MDExpenseCurrencyDotCurrencyName());
    }

    @Test
    public void testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyName() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDExpenseCurrencyDotCurrencyName(testsetDSExpenseReport4MDExpenseCurrencyDotCurrencyNameArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDExchange() {
        assertEquals(Double.valueOf(0), instanceDSExpenseReport4MD.getDSExpenseReport4MDExchange());
    }

    @Test
    public void testsetDSExpenseReport4MDExchange() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDExchange(testsetDSExpenseReport4MDExchangeArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDBalanceCur() {
        assertEquals(Double.valueOf(0), instanceDSExpenseReport4MD.getDSExpenseReport4MDBalanceCur());
    }

    @Test
    public void testsetDSExpenseReport4MDBalanceCur() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDBalanceCur(testsetDSExpenseReport4MDBalanceCurArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }

    @Test
    public void testgetDSExpenseReport4MDStatus() {
        assertEquals(Long.valueOf(0), instanceDSExpenseReport4MD.getDSExpenseReport4MDStatus());
    }

    @Test
    public void testsetDSExpenseReport4MDStatus() {
        instanceDSExpenseReport4MD.setDSExpenseReport4MDStatus(testsetDSExpenseReport4MDStatusArg1);
        assertNotNull(instanceDSExpenseReport4MD);
    }
}
