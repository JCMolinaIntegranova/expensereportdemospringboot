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
public class InsPaymentTypeRequestTest {

    private InsPaymentTypeRequest instanceInsPaymentTypeRequest;

    // Default values
    private static PaymentTypeOid defValue4paymentTypeInsPaymentTypepthisPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4paymentTypeInsPaymentTypepthisPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static ExpenseReportOid defValue4paymentTypeInsPaymentTypepevcExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4paymentTypeInsPaymentTypepevcExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));


    // test4getPaymentTypeInsPaymentTypepthisPaymentType

    // test4setPaymentTypeInsPaymentTypepthisPaymentType
    private static PaymentTypeOid test4setPaymentTypeInsPaymentTypepthisPaymentTypeArg1;

    // test4getPaymentTypeInsPaymentTypepevcExpenseReport

    // test4setPaymentTypeInsPaymentTypepevcExpenseReport
    private static ExpenseReportOid test4setPaymentTypeInsPaymentTypepevcExpenseReportArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPaymentTypeInsPaymentTypepthisPaymentType();
        setUpMockData4test4setPaymentTypeInsPaymentTypepthisPaymentType();
        setUpMockData4test4getPaymentTypeInsPaymentTypepevcExpenseReport();
        setUpMockData4test4setPaymentTypeInsPaymentTypepevcExpenseReport();
    }

    private static void setUpMockData4test4getPaymentTypeInsPaymentTypepthisPaymentType() {
    }

    private static void setUpMockData4test4setPaymentTypeInsPaymentTypepthisPaymentType() {
        test4setPaymentTypeInsPaymentTypepthisPaymentTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getPaymentTypeInsPaymentTypepevcExpenseReport() {
    }

    private static void setUpMockData4test4setPaymentTypeInsPaymentTypepevcExpenseReport() {
        test4setPaymentTypeInsPaymentTypepevcExpenseReportArg1 = new ExpenseReportOid();
    }

    @Before
    public void setUp() {
        instanceInsPaymentTypeRequest = new InsPaymentTypeRequest();
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepthisPaymentType(defValue4paymentTypeInsPaymentTypepthisPaymentType);
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(defValue4paymentTypeInsPaymentTypepthisPaymentTypeInstance);
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepevcExpenseReport(defValue4paymentTypeInsPaymentTypepevcExpenseReport);
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(defValue4paymentTypeInsPaymentTypepevcExpenseReportInstance);
    }

    @Test
    public void test4getPaymentTypeInsPaymentTypepthisPaymentType() {
        assertEquals(defValue4paymentTypeInsPaymentTypepthisPaymentType, instanceInsPaymentTypeRequest.getPaymentTypeInsPaymentTypepthisPaymentType());
    }

    @Test
    public void test4setPaymentTypeInsPaymentTypepthisPaymentType() {
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepthisPaymentType(test4setPaymentTypeInsPaymentTypepthisPaymentTypeArg1);
        assertNotNull(instanceInsPaymentTypeRequest);
    }

    @Test
    public void test4getPaymentTypeInsPaymentTypepevcExpenseReport() {
        assertEquals(defValue4paymentTypeInsPaymentTypepevcExpenseReport, instanceInsPaymentTypeRequest.getPaymentTypeInsPaymentTypepevcExpenseReport());
    }

    @Test
    public void test4setPaymentTypeInsPaymentTypepevcExpenseReport() {
        instanceInsPaymentTypeRequest.setPaymentTypeInsPaymentTypepevcExpenseReport(test4setPaymentTypeInsPaymentTypepevcExpenseReportArg1);
        assertNotNull(instanceInsPaymentTypeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceInsPaymentTypeRequest = new InsPaymentTypeRequest();
    	instanceInsPaymentTypeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceInsPaymentTypeRequest.checkArguments();
    }
}
