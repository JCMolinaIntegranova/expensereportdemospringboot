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
public class DelexpenseRequestTest {

    private DelexpenseRequest instanceDelexpenseRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportdelexpensepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportdelexpensepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getExpenseReportdelexpensepthisExpenseReport

    // test4setExpenseReportdelexpensepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportdelexpensepthisExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportdelexpensepthisExpenseReport();
        setUpMockData4test4setExpenseReportdelexpensepthisExpenseReport();
    }

    private static void setUpMockData4test4getExpenseReportdelexpensepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportdelexpensepthisExpenseReport() {
        test4setExpenseReportdelexpensepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceDelexpenseRequest = new DelexpenseRequest();
        instanceDelexpenseRequest.setExpenseReportdelexpensepthisExpenseReport(defValue4expenseReportdelexpensepthisExpenseReport);
        instanceDelexpenseRequest.setExpenseReportdelexpensepthisExpenseReportInstance(defValue4expenseReportdelexpensepthisExpenseReportInstance);
    }

    @Test
    public void test4getExpenseReportdelexpensepthisExpenseReport() {
        assertEquals(defValue4expenseReportdelexpensepthisExpenseReport, instanceDelexpenseRequest.getExpenseReportdelexpensepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportdelexpensepthisExpenseReport() {
        instanceDelexpenseRequest.setExpenseReportdelexpensepthisExpenseReport(test4setExpenseReportdelexpensepthisExpenseReportArg1);
        assertNotNull(instanceDelexpenseRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDelexpenseRequest = new DelexpenseRequest();
    	instanceDelexpenseRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDelexpenseRequest.checkArguments();
    }
}
