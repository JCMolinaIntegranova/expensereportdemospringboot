package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TNEWResponseTest {

    private TNEWResponse instanceTNEWResponse;

    // Default values
    private static ExpenseReportOid defValue4expenseReportTNEWnewExpenseReport = new ExpenseReportOid();


    // test4getExpenseReportTNEWnewExpenseReport

    // test4setExpenseReportTNEWnewExpenseReport
    private static ExpenseReportOid test4setExpenseReportTNEWnewExpenseReportArg1;

    // testBuildOutArgs

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTNEWnewExpenseReport();
        setUpMockData4test4setExpenseReportTNEWnewExpenseReport();
        setUpMockData4testBuildOutArgs();
    }

    private static void setUpMockData4test4getExpenseReportTNEWnewExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWnewExpenseReport() {
        test4setExpenseReportTNEWnewExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4testBuildOutArgs() {
    }

    @Before
    public void setUp() {
        instanceTNEWResponse = new TNEWResponse();
        instanceTNEWResponse.setExpenseReportTNEWnewExpenseReport(defValue4expenseReportTNEWnewExpenseReport);
    }

    @Test
    public void test4getExpenseReportTNEWnewExpenseReport() {
        assertEquals(defValue4expenseReportTNEWnewExpenseReport, instanceTNEWResponse.getExpenseReportTNEWnewExpenseReport());
    }

    @Test
    public void test4setExpenseReportTNEWnewExpenseReport() {
        instanceTNEWResponse.setExpenseReportTNEWnewExpenseReport(test4setExpenseReportTNEWnewExpenseReportArg1);
        assertNotNull(instanceTNEWResponse);
    }

    @Test
    public void testBuildOutArgs() {
        assertEquals(1, instanceTNEWResponse.buildOutArgs().size());
    }
}
