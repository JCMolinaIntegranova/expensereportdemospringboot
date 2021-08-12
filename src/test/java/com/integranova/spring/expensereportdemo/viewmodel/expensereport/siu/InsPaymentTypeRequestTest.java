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
public class InsPaymentTypeRequestTest {

    private InsPaymentTypeRequest instanceInsPaymentTypeRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportInsPaymentTypepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportInsPaymentTypepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static PaymentTypeOid defValue4expenseReportInsPaymentTypepevcPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4expenseReportInsPaymentTypepevcPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));


    // test4getExpenseReportInsPaymentTypepthisExpenseReport

    // test4setExpenseReportInsPaymentTypepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportInsPaymentTypepthisExpenseReportArg1;

    // test4getExpenseReportInsPaymentTypepevcPaymentType

    // test4setExpenseReportInsPaymentTypepevcPaymentType
    private static PaymentTypeOid test4setExpenseReportInsPaymentTypepevcPaymentTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportInsPaymentTypepthisExpenseReport();
        setUpMockData4test4setExpenseReportInsPaymentTypepthisExpenseReport();
        setUpMockData4test4getExpenseReportInsPaymentTypepevcPaymentType();
        setUpMockData4test4setExpenseReportInsPaymentTypepevcPaymentType();
    }

    private static void setUpMockData4test4getExpenseReportInsPaymentTypepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportInsPaymentTypepthisExpenseReport() {
        test4setExpenseReportInsPaymentTypepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportInsPaymentTypepevcPaymentType() {
    }

    private static void setUpMockData4test4setExpenseReportInsPaymentTypepevcPaymentType() {
        test4setExpenseReportInsPaymentTypepevcPaymentTypeArg1 = new PaymentTypeOid();
    }

    @Before
    public void setUp() {
        instanceInsPaymentTypeRequest = new InsPaymentTypeRequest();
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepthisExpenseReport(defValue4expenseReportInsPaymentTypepthisExpenseReport);
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepthisExpenseReportInstance(defValue4expenseReportInsPaymentTypepthisExpenseReportInstance);
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepevcPaymentType(defValue4expenseReportInsPaymentTypepevcPaymentType);
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(defValue4expenseReportInsPaymentTypepevcPaymentTypeInstance);
    }

    @Test
    public void test4getExpenseReportInsPaymentTypepthisExpenseReport() {
        assertEquals(defValue4expenseReportInsPaymentTypepthisExpenseReport, instanceInsPaymentTypeRequest.getExpenseReportInsPaymentTypepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportInsPaymentTypepthisExpenseReport() {
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepthisExpenseReport(test4setExpenseReportInsPaymentTypepthisExpenseReportArg1);
        assertNotNull(instanceInsPaymentTypeRequest);
    }

    @Test
    public void test4getExpenseReportInsPaymentTypepevcPaymentType() {
        assertEquals(defValue4expenseReportInsPaymentTypepevcPaymentType, instanceInsPaymentTypeRequest.getExpenseReportInsPaymentTypepevcPaymentType());
    }

    @Test
    public void test4setExpenseReportInsPaymentTypepevcPaymentType() {
        instanceInsPaymentTypeRequest.setExpenseReportInsPaymentTypepevcPaymentType(test4setExpenseReportInsPaymentTypepevcPaymentTypeArg1);
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
