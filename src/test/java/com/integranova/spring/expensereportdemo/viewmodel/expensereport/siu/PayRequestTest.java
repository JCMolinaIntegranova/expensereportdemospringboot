package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PayRequestTest {

    private PayRequest instancePayRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportpaypthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportpaypthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static Date defValue4expenseReportpaypeDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseReportpaypsComments = "";


    // test4getExpenseReportpaypthisExpenseReport

    // test4setExpenseReportpaypthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportpaypthisExpenseReportArg1;

    // test4getExpenseReportpaypeDate

    // test4setExpenseReportpaypeDate
    private static Date test4setExpenseReportpaypeDateArg1;

    // test4getExpenseReportpaypsComments

    // test4setExpenseReportpaypsComments
    private static String test4setExpenseReportpaypsCommentsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportpaypthisExpenseReport();
        setUpMockData4test4setExpenseReportpaypthisExpenseReport();
        setUpMockData4test4getExpenseReportpaypeDate();
        setUpMockData4test4setExpenseReportpaypeDate();
        setUpMockData4test4getExpenseReportpaypsComments();
        setUpMockData4test4setExpenseReportpaypsComments();
    }

    private static void setUpMockData4test4getExpenseReportpaypthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportpaypthisExpenseReport() {
        test4setExpenseReportpaypthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportpaypeDate() {
    }

    private static void setUpMockData4test4setExpenseReportpaypeDate() {
        test4setExpenseReportpaypeDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportpaypsComments() {
    }

    private static void setUpMockData4test4setExpenseReportpaypsComments() {
        test4setExpenseReportpaypsCommentsArg1 = "";
    }

    @Before
    public void setUp() {
        instancePayRequest = new PayRequest();
        instancePayRequest.setExpenseReportpaypthisExpenseReport(defValue4expenseReportpaypthisExpenseReport);
        instancePayRequest.setExpenseReportpaypthisExpenseReportInstance(defValue4expenseReportpaypthisExpenseReportInstance);
        instancePayRequest.setExpenseReportpaypeDate(defValue4expenseReportpaypeDate);
        instancePayRequest.setExpenseReportpaypsComments(defValue4expenseReportpaypsComments);
    }

    @Test
    public void test4getExpenseReportpaypthisExpenseReport() {
        assertEquals(defValue4expenseReportpaypthisExpenseReport, instancePayRequest.getExpenseReportpaypthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportpaypthisExpenseReport() {
        instancePayRequest.setExpenseReportpaypthisExpenseReport(test4setExpenseReportpaypthisExpenseReportArg1);
        assertNotNull(instancePayRequest);
    }

    @Test
    public void test4getExpenseReportpaypeDate() {
        assertEquals(defValue4expenseReportpaypeDate, instancePayRequest.getExpenseReportpaypeDate());
    }

    @Test
    public void test4setExpenseReportpaypeDate() {
        instancePayRequest.setExpenseReportpaypeDate(test4setExpenseReportpaypeDateArg1);
        assertNotNull(instancePayRequest);
    }

    @Test
    public void test4getExpenseReportpaypsComments() {
        assertEquals(defValue4expenseReportpaypsComments, instancePayRequest.getExpenseReportpaypsComments());
    }

    @Test
    public void test4setExpenseReportpaypsComments() {
        instancePayRequest.setExpenseReportpaypsComments(test4setExpenseReportpaypsCommentsArg1);
        assertNotNull(instancePayRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instancePayRequest = new PayRequest();
    	instancePayRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instancePayRequest.checkArguments();
    }
}
