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
public class ApproveRequestTest {

    private ApproveRequest instanceApproveRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportapprovepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportapprovepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReportapprovepthisExpenseReport

    // test4setExpenseReportapprovepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportapprovepthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportapprovepthisExpenseReport();
        setUpMockData4test4setExpenseReportapprovepthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReportapprovepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportapprovepthisExpenseReport() {
        test4setExpenseReportapprovepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceApproveRequest = new ApproveRequest();
        instanceApproveRequest.setExpenseReportapprovepthisExpenseReport(defValue4expenseReportapprovepthisExpenseReport);
        instanceApproveRequest.setExpenseReportapprovepthisExpenseReportInstance(defValue4expenseReportapprovepthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReportapprovepthisExpenseReport() {
        assertEquals(defValue4expenseReportapprovepthisExpenseReport, instanceApproveRequest.getExpenseReportapprovepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportapprovepthisExpenseReport() {
        instanceApproveRequest.setExpenseReportapprovepthisExpenseReport(test4setExpenseReportapprovepthisExpenseReportArg1);
        assertNotNull(instanceApproveRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceApproveRequest = new ApproveRequest();
    	instanceApproveRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceApproveRequest.checkArguments();
    }
}
