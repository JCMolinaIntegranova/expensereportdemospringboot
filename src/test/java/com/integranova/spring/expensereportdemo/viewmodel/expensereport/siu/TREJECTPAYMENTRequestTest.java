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
public class TREJECTPAYMENTRequestTest {

    private TREJECTPAYMENTRequest instanceTREJECTPAYMENTRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportTREJECTPAYMENTptthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportTREJECTPAYMENTptthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static PaymentTypeOid defValue4expenseReportTREJECTPAYMENTptPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4expenseReportTREJECTPAYMENTptPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static String defValue4expenseReportTREJECTPAYMENTptComments = "";


    // test4getExpenseReportTREJECTPAYMENTptthisExpenseReport

    // test4setExpenseReportTREJECTPAYMENTptthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportTREJECTPAYMENTptthisExpenseReportArg1;

    // test4getExpenseReportTREJECTPAYMENTptPaymentType

    // test4setExpenseReportTREJECTPAYMENTptPaymentType
    private static PaymentTypeOid test4setExpenseReportTREJECTPAYMENTptPaymentTypeArg1;

    // test4getExpenseReportTREJECTPAYMENTptComments

    // test4setExpenseReportTREJECTPAYMENTptComments
    private static String test4setExpenseReportTREJECTPAYMENTptCommentsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTREJECTPAYMENTptthisExpenseReport();
        setUpMockData4test4setExpenseReportTREJECTPAYMENTptthisExpenseReport();
        setUpMockData4test4getExpenseReportTREJECTPAYMENTptPaymentType();
        setUpMockData4test4setExpenseReportTREJECTPAYMENTptPaymentType();
        setUpMockData4test4getExpenseReportTREJECTPAYMENTptComments();
        setUpMockData4test4setExpenseReportTREJECTPAYMENTptComments();
    }

    private static void setUpMockData4test4getExpenseReportTREJECTPAYMENTptthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportTREJECTPAYMENTptthisExpenseReport() {
        test4setExpenseReportTREJECTPAYMENTptthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportTREJECTPAYMENTptPaymentType() {
    }

    private static void setUpMockData4test4setExpenseReportTREJECTPAYMENTptPaymentType() {
        test4setExpenseReportTREJECTPAYMENTptPaymentTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getExpenseReportTREJECTPAYMENTptComments() {
    }

    private static void setUpMockData4test4setExpenseReportTREJECTPAYMENTptComments() {
        test4setExpenseReportTREJECTPAYMENTptCommentsArg1 = "";
    }

    @Before
    public void setUp() {
        instanceTREJECTPAYMENTRequest = new TREJECTPAYMENTRequest();
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptthisExpenseReport(defValue4expenseReportTREJECTPAYMENTptthisExpenseReport);
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(defValue4expenseReportTREJECTPAYMENTptthisExpenseReportInstance);
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptPaymentType(defValue4expenseReportTREJECTPAYMENTptPaymentType);
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(defValue4expenseReportTREJECTPAYMENTptPaymentTypeInstance);
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptComments(defValue4expenseReportTREJECTPAYMENTptComments);
    }

    @Test
    public void test4getExpenseReportTREJECTPAYMENTptthisExpenseReport() {
        assertEquals(defValue4expenseReportTREJECTPAYMENTptthisExpenseReport, instanceTREJECTPAYMENTRequest.getExpenseReportTREJECTPAYMENTptthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportTREJECTPAYMENTptthisExpenseReport() {
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptthisExpenseReport(test4setExpenseReportTREJECTPAYMENTptthisExpenseReportArg1);
        assertNotNull(instanceTREJECTPAYMENTRequest);
    }

    @Test
    public void test4getExpenseReportTREJECTPAYMENTptPaymentType() {
        assertEquals(defValue4expenseReportTREJECTPAYMENTptPaymentType, instanceTREJECTPAYMENTRequest.getExpenseReportTREJECTPAYMENTptPaymentType());
    }

    @Test
    public void test4setExpenseReportTREJECTPAYMENTptPaymentType() {
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptPaymentType(test4setExpenseReportTREJECTPAYMENTptPaymentTypeArg1);
        assertNotNull(instanceTREJECTPAYMENTRequest);
    }

    @Test
    public void test4getExpenseReportTREJECTPAYMENTptComments() {
        assertEquals(defValue4expenseReportTREJECTPAYMENTptComments, instanceTREJECTPAYMENTRequest.getExpenseReportTREJECTPAYMENTptComments());
    }

    @Test
    public void test4setExpenseReportTREJECTPAYMENTptComments() {
        instanceTREJECTPAYMENTRequest.setExpenseReportTREJECTPAYMENTptComments(test4setExpenseReportTREJECTPAYMENTptCommentsArg1);
        assertNotNull(instanceTREJECTPAYMENTRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTREJECTPAYMENTRequest = new TREJECTPAYMENTRequest();
    	instanceTREJECTPAYMENTRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTREJECTPAYMENTRequest.checkArguments();
    }
}
