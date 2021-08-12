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
public class DSExpenseReport4HATTest {

    private DSExpenseReport4HAT instanceDSExpenseReport4HAT;

    // testDSExpenseReport4HAT
    private static ExpenseReport testDSExpenseReport4HATArg1;

    // testDSExpenseReport4HAT2
    private static ExpenseReport testDSExpenseReport4HAT2Arg1;

    // testgetDSExpenseReport4HATIdExpenseRepor

    // testsetDSExpenseReport4HATIdExpenseRepor
    private static Long testsetDSExpenseReport4HATIdExpenseReporArg1;

    // testgetDSExpenseReport4HATPresentDate

    // testsetDSExpenseReport4HATPresentDate
    private static Date testsetDSExpenseReport4HATPresentDateArg1;

    // testgetDSExpenseReport4HATProjectDotProjectName

    // testsetDSExpenseReport4HATProjectDotProjectName
    private static String testsetDSExpenseReport4HATProjectDotProjectNameArg1;

    // testgetDSExpenseReport4HATEmployeeDotEmpName

    // testsetDSExpenseReport4HATEmployeeDotEmpName
    private static String testsetDSExpenseReport4HATEmployeeDotEmpNameArg1;

    // testgetDSExpenseReport4HATCause

    // testsetDSExpenseReport4HATCause
    private static String testsetDSExpenseReport4HATCauseArg1;

    // testgetDSExpenseReport4HATExpenseCurrencyDotCurrencyName

    // testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyName
    private static String testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyNameArg1;

    // testgetDSExpenseReport4HATExchange

    // testsetDSExpenseReport4HATExchange
    private static Double testsetDSExpenseReport4HATExchangeArg1;

    // testgetDSExpenseReport4HATBalanceCur

    // testsetDSExpenseReport4HATBalanceCur
    private static Double testsetDSExpenseReport4HATBalanceCurArg1;

    // testgetDSExpenseReport4HATStatus

    // testsetDSExpenseReport4HATStatus
    private static Long testsetDSExpenseReport4HATStatusArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseReport4HAT();
        setUpMockData4testDSExpenseReport4HAT2();
        setUpMockData4testgetDSExpenseReport4HATIdExpenseRepor();
        setUpMockData4testsetDSExpenseReport4HATIdExpenseRepor();
        setUpMockData4testgetDSExpenseReport4HATPresentDate();
        setUpMockData4testsetDSExpenseReport4HATPresentDate();
        setUpMockData4testgetDSExpenseReport4HATProjectDotProjectName();
        setUpMockData4testsetDSExpenseReport4HATProjectDotProjectName();
        setUpMockData4testgetDSExpenseReport4HATEmployeeDotEmpName();
        setUpMockData4testsetDSExpenseReport4HATEmployeeDotEmpName();
        setUpMockData4testgetDSExpenseReport4HATCause();
        setUpMockData4testsetDSExpenseReport4HATCause();
        setUpMockData4testgetDSExpenseReport4HATExpenseCurrencyDotCurrencyName();
        setUpMockData4testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyName();
        setUpMockData4testgetDSExpenseReport4HATExchange();
        setUpMockData4testsetDSExpenseReport4HATExchange();
        setUpMockData4testgetDSExpenseReport4HATBalanceCur();
        setUpMockData4testsetDSExpenseReport4HATBalanceCur();
        setUpMockData4testgetDSExpenseReport4HATStatus();
        setUpMockData4testsetDSExpenseReport4HATStatus();
    }

    private static void setUpMockData4testDSExpenseReport4HAT() {
        testDSExpenseReport4HATArg1 = new ExpenseReport();
    }

    private static void setUpMockData4testDSExpenseReport4HAT2() {
        testDSExpenseReport4HAT2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseReport4HATIdExpenseRepor() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATIdExpenseRepor() {
        testsetDSExpenseReport4HATIdExpenseReporArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4HATPresentDate() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATPresentDate() {
        testsetDSExpenseReport4HATPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSExpenseReport4HATProjectDotProjectName() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATProjectDotProjectName() {
        testsetDSExpenseReport4HATProjectDotProjectNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4HATEmployeeDotEmpName() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATEmployeeDotEmpName() {
        testsetDSExpenseReport4HATEmployeeDotEmpNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4HATCause() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATCause() {
        testsetDSExpenseReport4HATCauseArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4HATExpenseCurrencyDotCurrencyName() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyName() {
        testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseReport4HATExchange() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATExchange() {
        testsetDSExpenseReport4HATExchangeArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4HATBalanceCur() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATBalanceCur() {
        testsetDSExpenseReport4HATBalanceCurArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseReport4HATStatus() {
    }

    private static void setUpMockData4testsetDSExpenseReport4HATStatus() {
        testsetDSExpenseReport4HATStatusArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseReport4HAT = new DSExpenseReport4HAT();
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATIdExpenseRepor(Long.valueOf(0));
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATProjectDotProjectName("");
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATEmployeeDotEmpName("");
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATCause("");
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATExpenseCurrencyDotCurrencyName("");
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATExchange(Double.valueOf(0));
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATBalanceCur(Double.valueOf(0));
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATStatus(Long.valueOf(0));
    }

    @Test
    public void testDSExpenseReport4HAT() {
        instanceDSExpenseReport4HAT = new DSExpenseReport4HAT(testDSExpenseReport4HATArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testDSExpenseReport4HAT2() {
        instanceDSExpenseReport4HAT = new DSExpenseReport4HAT(testDSExpenseReport4HAT2Arg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATIdExpenseRepor() {
        assertEquals(Long.valueOf(0), instanceDSExpenseReport4HAT.getDSExpenseReport4HATIdExpenseRepor());
    }

    @Test
    public void testsetDSExpenseReport4HATIdExpenseRepor() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATIdExpenseRepor(testsetDSExpenseReport4HATIdExpenseReporArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATPresentDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSExpenseReport4HAT.getDSExpenseReport4HATPresentDate());
    }

    @Test
    public void testsetDSExpenseReport4HATPresentDate() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATPresentDate(testsetDSExpenseReport4HATPresentDateArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATProjectDotProjectName() {
        assertEquals("", instanceDSExpenseReport4HAT.getDSExpenseReport4HATProjectDotProjectName());
    }

    @Test
    public void testsetDSExpenseReport4HATProjectDotProjectName() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATProjectDotProjectName(testsetDSExpenseReport4HATProjectDotProjectNameArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATEmployeeDotEmpName() {
        assertEquals("", instanceDSExpenseReport4HAT.getDSExpenseReport4HATEmployeeDotEmpName());
    }

    @Test
    public void testsetDSExpenseReport4HATEmployeeDotEmpName() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATEmployeeDotEmpName(testsetDSExpenseReport4HATEmployeeDotEmpNameArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATCause() {
        assertEquals("", instanceDSExpenseReport4HAT.getDSExpenseReport4HATCause());
    }

    @Test
    public void testsetDSExpenseReport4HATCause() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATCause(testsetDSExpenseReport4HATCauseArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATExpenseCurrencyDotCurrencyName() {
        assertEquals("", instanceDSExpenseReport4HAT.getDSExpenseReport4HATExpenseCurrencyDotCurrencyName());
    }

    @Test
    public void testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyName() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATExpenseCurrencyDotCurrencyName(testsetDSExpenseReport4HATExpenseCurrencyDotCurrencyNameArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATExchange() {
        assertEquals(Double.valueOf(0), instanceDSExpenseReport4HAT.getDSExpenseReport4HATExchange());
    }

    @Test
    public void testsetDSExpenseReport4HATExchange() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATExchange(testsetDSExpenseReport4HATExchangeArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATBalanceCur() {
        assertEquals(Double.valueOf(0), instanceDSExpenseReport4HAT.getDSExpenseReport4HATBalanceCur());
    }

    @Test
    public void testsetDSExpenseReport4HATBalanceCur() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATBalanceCur(testsetDSExpenseReport4HATBalanceCurArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }

    @Test
    public void testgetDSExpenseReport4HATStatus() {
        assertEquals(Long.valueOf(0), instanceDSExpenseReport4HAT.getDSExpenseReport4HATStatus());
    }

    @Test
    public void testsetDSExpenseReport4HATStatus() {
        instanceDSExpenseReport4HAT.setDSExpenseReport4HATStatus(testsetDSExpenseReport4HATStatusArg1);
        assertNotNull(instanceDSExpenseReport4HAT);
    }
}
