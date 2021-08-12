package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

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
    private static PaymentTypeOid defValue4paymentTypeDelPaymentTypepthisPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4paymentTypeDelPaymentTypepthisPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static ExpenseReportOid defValue4paymentTypeDelPaymentTypepevcExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4paymentTypeDelPaymentTypepevcExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getPaymentTypeDelPaymentTypepthisPaymentType

    // test4setPaymentTypeDelPaymentTypepthisPaymentType
    private static PaymentTypeOid test4setPaymentTypeDelPaymentTypepthisPaymentTypeArg1;

    // test4getPaymentTypeDelPaymentTypepevcExpenseReport

    // test4setPaymentTypeDelPaymentTypepevcExpenseReport
    private static ExpenseReportOid test4setPaymentTypeDelPaymentTypepevcExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPaymentTypeDelPaymentTypepthisPaymentType();
        setUpMockData4test4setPaymentTypeDelPaymentTypepthisPaymentType();
        setUpMockData4test4getPaymentTypeDelPaymentTypepevcExpenseReport();
        setUpMockData4test4setPaymentTypeDelPaymentTypepevcExpenseReport();
    }

    private static void setUpMockData4test4getPaymentTypeDelPaymentTypepthisPaymentType() {
    }

    private static void setUpMockData4test4setPaymentTypeDelPaymentTypepthisPaymentType() {
        test4setPaymentTypeDelPaymentTypepthisPaymentTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getPaymentTypeDelPaymentTypepevcExpenseReport() {
    }

    private static void setUpMockData4test4setPaymentTypeDelPaymentTypepevcExpenseReport() {
        test4setPaymentTypeDelPaymentTypepevcExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceDelPaymentTypeRequest = new DelPaymentTypeRequest();
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepthisPaymentType(defValue4paymentTypeDelPaymentTypepthisPaymentType);
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(defValue4paymentTypeDelPaymentTypepthisPaymentTypeInstance);
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepevcExpenseReport(defValue4paymentTypeDelPaymentTypepevcExpenseReport);
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(defValue4paymentTypeDelPaymentTypepevcExpenseReportInstance);
    }

    @Test
    public void test4getPaymentTypeDelPaymentTypepthisPaymentType() {
        assertEquals(defValue4paymentTypeDelPaymentTypepthisPaymentType, instanceDelPaymentTypeRequest.getPaymentTypeDelPaymentTypepthisPaymentType());
    }

    @Test
    public void test4setPaymentTypeDelPaymentTypepthisPaymentType() {
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepthisPaymentType(test4setPaymentTypeDelPaymentTypepthisPaymentTypeArg1);
        assertNotNull(instanceDelPaymentTypeRequest);
    }

    @Test
    public void test4getPaymentTypeDelPaymentTypepevcExpenseReport() {
        assertEquals(defValue4paymentTypeDelPaymentTypepevcExpenseReport, instanceDelPaymentTypeRequest.getPaymentTypeDelPaymentTypepevcExpenseReport());
    }

    @Test
    public void test4setPaymentTypeDelPaymentTypepevcExpenseReport() {
        instanceDelPaymentTypeRequest.setPaymentTypeDelPaymentTypepevcExpenseReport(test4setPaymentTypeDelPaymentTypepevcExpenseReportArg1);
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
