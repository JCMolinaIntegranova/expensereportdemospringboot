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
public class DELETEALLRequestTest {

    private DELETEALLRequest instanceDELETEALLRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportDELETEALLptpthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportDELETEALLptpthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReportDELETEALLptpthisExpenseReport

    // test4setExpenseReportDELETEALLptpthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportDELETEALLptpthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportDELETEALLptpthisExpenseReport();
        setUpMockData4test4setExpenseReportDELETEALLptpthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReportDELETEALLptpthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportDELETEALLptpthisExpenseReport() {
        test4setExpenseReportDELETEALLptpthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceDELETEALLRequest = new DELETEALLRequest();
        instanceDELETEALLRequest.setExpenseReportDELETEALLptpthisExpenseReport(defValue4expenseReportDELETEALLptpthisExpenseReport);
        instanceDELETEALLRequest.setExpenseReportDELETEALLptpthisExpenseReportInstance(defValue4expenseReportDELETEALLptpthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReportDELETEALLptpthisExpenseReport() {
        assertEquals(defValue4expenseReportDELETEALLptpthisExpenseReport, instanceDELETEALLRequest.getExpenseReportDELETEALLptpthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportDELETEALLptpthisExpenseReport() {
        instanceDELETEALLRequest.setExpenseReportDELETEALLptpthisExpenseReport(test4setExpenseReportDELETEALLptpthisExpenseReportArg1);
        assertNotNull(instanceDELETEALLRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDELETEALLRequest = new DELETEALLRequest();
    	instanceDELETEALLRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDELETEALLRequest.checkArguments();
    }
}
