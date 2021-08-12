package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DelPaymentTypeRequestTest {

    private DelPaymentTypeRequest instanceDelPaymentTypeRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportDelPaymentTypepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportDelPaymentTypepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static PaymentTypeOid defValue4expenseReportDelPaymentTypepevcPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4expenseReportDelPaymentTypepevcPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));


    // test4getExpenseReportDelPaymentTypepthisExpenseReport

    // test4setExpenseReportDelPaymentTypepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportDelPaymentTypepthisExpenseReportArg1;

    // test4getExpenseReportDelPaymentTypepevcPaymentType

    // test4setExpenseReportDelPaymentTypepevcPaymentType
    private static PaymentTypeOid test4setExpenseReportDelPaymentTypepevcPaymentTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportDelPaymentTypepthisExpenseReport();
        setUpMockData4test4setExpenseReportDelPaymentTypepthisExpenseReport();
        setUpMockData4test4getExpenseReportDelPaymentTypepevcPaymentType();
        setUpMockData4test4setExpenseReportDelPaymentTypepevcPaymentType();
    }

    private static void setUpMockData4test4getExpenseReportDelPaymentTypepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportDelPaymentTypepthisExpenseReport() {
        test4setExpenseReportDelPaymentTypepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportDelPaymentTypepevcPaymentType() {
    }

    private static void setUpMockData4test4setExpenseReportDelPaymentTypepevcPaymentType() {
        test4setExpenseReportDelPaymentTypepevcPaymentTypeArg1 = new PaymentTypeOid();
    }

    @Before
    public void setUp() {
        instanceDelPaymentTypeRequest = new DelPaymentTypeRequest();
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepthisExpenseReport(defValue4expenseReportDelPaymentTypepthisExpenseReport);
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepthisExpenseReportInstance(defValue4expenseReportDelPaymentTypepthisExpenseReportInstance);
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepevcPaymentType(defValue4expenseReportDelPaymentTypepevcPaymentType);
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(defValue4expenseReportDelPaymentTypepevcPaymentTypeInstance);
    }

    @Test
    public void test4getExpenseReportDelPaymentTypepthisExpenseReport() {
        assertEquals(defValue4expenseReportDelPaymentTypepthisExpenseReport, instanceDelPaymentTypeRequest.getExpenseReportDelPaymentTypepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportDelPaymentTypepthisExpenseReport() {
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepthisExpenseReport(test4setExpenseReportDelPaymentTypepthisExpenseReportArg1);
        assertNotNull(instanceDelPaymentTypeRequest);
    }

    @Test
    public void test4getExpenseReportDelPaymentTypepevcPaymentType() {
        assertEquals(defValue4expenseReportDelPaymentTypepevcPaymentType, instanceDelPaymentTypeRequest.getExpenseReportDelPaymentTypepevcPaymentType());
    }

    @Test
    public void test4setExpenseReportDelPaymentTypepevcPaymentType() {
        instanceDelPaymentTypeRequest.setExpenseReportDelPaymentTypepevcPaymentType(test4setExpenseReportDelPaymentTypepevcPaymentTypeArg1);
        assertNotNull(instanceDelPaymentTypeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDelPaymentTypeRequest = new DelPaymentTypeRequest();
    	instanceDelPaymentTypeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDelPaymentTypeRequest.checkArguments();
    }
}
