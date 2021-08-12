package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReporteditinstancepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReporteditinstancepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static String defValue4expenseReporteditinstancepCause = "";
    private static Double defValue4expenseReporteditinstancepAdvances = Double.valueOf(0);
    private static Double defValue4expenseReporteditinstancepExchange = Double.valueOf(0);


    // test4getExpenseReporteditinstancepthisExpenseReport

    // test4setExpenseReporteditinstancepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReporteditinstancepthisExpenseReportArg1;

    // test4getExpenseReporteditinstancepCause

    // test4setExpenseReporteditinstancepCause
    private static String test4setExpenseReporteditinstancepCauseArg1;

    // test4getExpenseReporteditinstancepAdvances

    // test4setExpenseReporteditinstancepAdvances
    private static Double test4setExpenseReporteditinstancepAdvancesArg1;

    // test4getExpenseReporteditinstancepExchange

    // test4setExpenseReporteditinstancepExchange
    private static Double test4setExpenseReporteditinstancepExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReporteditinstancepthisExpenseReport();
        setUpMockData4test4setExpenseReporteditinstancepthisExpenseReport();
        setUpMockData4test4getExpenseReporteditinstancepCause();
        setUpMockData4test4setExpenseReporteditinstancepCause();
        setUpMockData4test4getExpenseReporteditinstancepAdvances();
        setUpMockData4test4setExpenseReporteditinstancepAdvances();
        setUpMockData4test4getExpenseReporteditinstancepExchange();
        setUpMockData4test4setExpenseReporteditinstancepExchange();
    }

    private static void setUpMockData4test4getExpenseReporteditinstancepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReporteditinstancepthisExpenseReport() {
        test4setExpenseReporteditinstancepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReporteditinstancepCause() {
    }

    private static void setUpMockData4test4setExpenseReporteditinstancepCause() {
        test4setExpenseReporteditinstancepCauseArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReporteditinstancepAdvances() {
    }

    private static void setUpMockData4test4setExpenseReporteditinstancepAdvances() {
        test4setExpenseReporteditinstancepAdvancesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseReporteditinstancepExchange() {
    }

    private static void setUpMockData4test4setExpenseReporteditinstancepExchange() {
        test4setExpenseReporteditinstancepExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setExpenseReporteditinstancepthisExpenseReport(defValue4expenseReporteditinstancepthisExpenseReport);
        instanceEditinstanceRequest.setExpenseReporteditinstancepthisExpenseReportInstance(defValue4expenseReporteditinstancepthisExpenseReportInstance);
        instanceEditinstanceRequest.setExpenseReporteditinstancepCause(defValue4expenseReporteditinstancepCause);
        instanceEditinstanceRequest.setExpenseReporteditinstancepAdvances(defValue4expenseReporteditinstancepAdvances);
        instanceEditinstanceRequest.setExpenseReporteditinstancepExchange(defValue4expenseReporteditinstancepExchange);
    }

    @Test
    public void test4getExpenseReporteditinstancepthisExpenseReport() {
        assertEquals(defValue4expenseReporteditinstancepthisExpenseReport, instanceEditinstanceRequest.getExpenseReporteditinstancepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReporteditinstancepthisExpenseReport() {
        instanceEditinstanceRequest.setExpenseReporteditinstancepthisExpenseReport(test4setExpenseReporteditinstancepthisExpenseReportArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseReporteditinstancepCause() {
        assertEquals(defValue4expenseReporteditinstancepCause, instanceEditinstanceRequest.getExpenseReporteditinstancepCause());
    }

    @Test
    public void test4setExpenseReporteditinstancepCause() {
        instanceEditinstanceRequest.setExpenseReporteditinstancepCause(test4setExpenseReporteditinstancepCauseArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseReporteditinstancepAdvances() {
        assertEquals(defValue4expenseReporteditinstancepAdvances, instanceEditinstanceRequest.getExpenseReporteditinstancepAdvances());
    }

    @Test
    public void test4setExpenseReporteditinstancepAdvances() {
        instanceEditinstanceRequest.setExpenseReporteditinstancepAdvances(test4setExpenseReporteditinstancepAdvancesArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseReporteditinstancepExchange() {
        assertEquals(defValue4expenseReporteditinstancepExchange, instanceEditinstanceRequest.getExpenseReporteditinstancepExchange());
    }

    @Test
    public void test4setExpenseReporteditinstancepExchange() {
        instanceEditinstanceRequest.setExpenseReporteditinstancepExchange(test4setExpenseReporteditinstancepExchangeArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
