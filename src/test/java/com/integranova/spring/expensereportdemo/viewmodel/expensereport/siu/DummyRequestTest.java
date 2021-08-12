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
public class DummyRequestTest {

    private DummyRequest instanceDummyRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportdummypthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportdummypthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReportdummypthisExpenseReport

    // test4setExpenseReportdummypthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportdummypthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportdummypthisExpenseReport();
        setUpMockData4test4setExpenseReportdummypthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReportdummypthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportdummypthisExpenseReport() {
        test4setExpenseReportdummypthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceDummyRequest = new DummyRequest();
        instanceDummyRequest.setExpenseReportdummypthisExpenseReport(defValue4expenseReportdummypthisExpenseReport);
        instanceDummyRequest.setExpenseReportdummypthisExpenseReportInstance(defValue4expenseReportdummypthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReportdummypthisExpenseReport() {
        assertEquals(defValue4expenseReportdummypthisExpenseReport, instanceDummyRequest.getExpenseReportdummypthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportdummypthisExpenseReport() {
        instanceDummyRequest.setExpenseReportdummypthisExpenseReport(test4setExpenseReportdummypthisExpenseReportArg1);
        assertNotNull(instanceDummyRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDummyRequest = new DummyRequest();
    	instanceDummyRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDummyRequest.checkArguments();
    }
}
