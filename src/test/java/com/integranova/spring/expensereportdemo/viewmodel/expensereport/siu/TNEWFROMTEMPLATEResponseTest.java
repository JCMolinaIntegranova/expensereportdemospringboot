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
public class TNEWFROMTEMPLATEResponseTest {

    private TNEWFROMTEMPLATEResponse instanceTNEWFROMTEMPLATEResponse;

    // Default values
    private static ExpenseReportOid defValue4expenseReportTNEWFROMTEMPLATEnewExpenseReport = new ExpenseReportOid();
    private static Long defValue4expenseReportTNEWFROMTEMPLATEpsNumberOfLines = Long.valueOf(0);


    // test4getExpenseReportTNEWFROMTEMPLATEnewExpenseReport

    // test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReport
    private static ExpenseReportOid test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReportArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines

    // test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines
    private static Long test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLinesArg1;

    // testBuildOutArgs

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEnewExpenseReport();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReport();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines();
        setUpMockData4testBuildOutArgs();
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEnewExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReport() {
        test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines() {
        test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLinesArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testBuildOutArgs() {
    }

    @Before
    public void setUp() {
        instanceTNEWFROMTEMPLATEResponse = new TNEWFROMTEMPLATEResponse();
        instanceTNEWFROMTEMPLATEResponse.setExpenseReportTNEWFROMTEMPLATEnewExpenseReport(defValue4expenseReportTNEWFROMTEMPLATEnewExpenseReport);
        instanceTNEWFROMTEMPLATEResponse.setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines(defValue4expenseReportTNEWFROMTEMPLATEpsNumberOfLines);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEnewExpenseReport() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEnewExpenseReport, instanceTNEWFROMTEMPLATEResponse.getExpenseReportTNEWFROMTEMPLATEnewExpenseReport());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReport() {
        instanceTNEWFROMTEMPLATEResponse.setExpenseReportTNEWFROMTEMPLATEnewExpenseReport(test4setExpenseReportTNEWFROMTEMPLATEnewExpenseReportArg1);
        assertNotNull(instanceTNEWFROMTEMPLATEResponse);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEpsNumberOfLines, instanceTNEWFROMTEMPLATEResponse.getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines() {
        instanceTNEWFROMTEMPLATEResponse.setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines(test4setExpenseReportTNEWFROMTEMPLATEpsNumberOfLinesArg1);
        assertNotNull(instanceTNEWFROMTEMPLATEResponse);
    }

    @Test
    public void testBuildOutArgs() {
        assertEquals(2, instanceTNEWFROMTEMPLATEResponse.buildOutArgs().size());
    }
}
