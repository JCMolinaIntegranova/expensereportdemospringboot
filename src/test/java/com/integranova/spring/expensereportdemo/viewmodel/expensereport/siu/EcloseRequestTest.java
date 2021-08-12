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
public class EcloseRequestTest {

    private EcloseRequest instanceEcloseRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReporteclosepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReporteclosepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReporteclosepthisExpenseReport

    // test4setExpenseReporteclosepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReporteclosepthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReporteclosepthisExpenseReport();
        setUpMockData4test4setExpenseReporteclosepthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReporteclosepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReporteclosepthisExpenseReport() {
        test4setExpenseReporteclosepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceEcloseRequest = new EcloseRequest();
        instanceEcloseRequest.setExpenseReporteclosepthisExpenseReport(defValue4expenseReporteclosepthisExpenseReport);
        instanceEcloseRequest.setExpenseReporteclosepthisExpenseReportInstance(defValue4expenseReporteclosepthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReporteclosepthisExpenseReport() {
        assertEquals(defValue4expenseReporteclosepthisExpenseReport, instanceEcloseRequest.getExpenseReporteclosepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReporteclosepthisExpenseReport() {
        instanceEcloseRequest.setExpenseReporteclosepthisExpenseReport(test4setExpenseReporteclosepthisExpenseReportArg1);
        assertNotNull(instanceEcloseRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEcloseRequest = new EcloseRequest();
    	instanceEcloseRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEcloseRequest.checkArguments();
    }
}
