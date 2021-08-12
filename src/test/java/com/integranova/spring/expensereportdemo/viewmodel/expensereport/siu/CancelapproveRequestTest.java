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
public class CancelapproveRequestTest {

    private CancelapproveRequest instanceCancelapproveRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportcancelapprovepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportcancelapprovepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReportcancelapprovepthisExpenseReport

    // test4setExpenseReportcancelapprovepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportcancelapprovepthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportcancelapprovepthisExpenseReport();
        setUpMockData4test4setExpenseReportcancelapprovepthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReportcancelapprovepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportcancelapprovepthisExpenseReport() {
        test4setExpenseReportcancelapprovepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceCancelapproveRequest = new CancelapproveRequest();
        instanceCancelapproveRequest.setExpenseReportcancelapprovepthisExpenseReport(defValue4expenseReportcancelapprovepthisExpenseReport);
        instanceCancelapproveRequest.setExpenseReportcancelapprovepthisExpenseReportInstance(defValue4expenseReportcancelapprovepthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReportcancelapprovepthisExpenseReport() {
        assertEquals(defValue4expenseReportcancelapprovepthisExpenseReport, instanceCancelapproveRequest.getExpenseReportcancelapprovepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportcancelapprovepthisExpenseReport() {
        instanceCancelapproveRequest.setExpenseReportcancelapprovepthisExpenseReport(test4setExpenseReportcancelapprovepthisExpenseReportArg1);
        assertNotNull(instanceCancelapproveRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCancelapproveRequest = new CancelapproveRequest();
    	instanceCancelapproveRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCancelapproveRequest.checkArguments();
    }
}
