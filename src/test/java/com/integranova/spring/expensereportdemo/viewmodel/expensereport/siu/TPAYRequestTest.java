package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TPAYRequestTest {

    private TPAYRequest instanceTPAYRequest;

    // Default values
    private static Date defValue4expenseReportTPAYptpeDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static PaymentTypeOid defValue4expenseReportTPAYpsPayType = new PaymentTypeOid();
    private static PaymentType defValue4expenseReportTPAYpsPayTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static ExpenseReportOid defValue4expenseReportTPAYptpthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportTPAYptpthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static String defValue4expenseReportTPAYpsComments = "";


    // test4getExpenseReportTPAYptpeDate

    // test4setExpenseReportTPAYptpeDate
    private static Date test4setExpenseReportTPAYptpeDateArg1;

    // test4getExpenseReportTPAYpsPayType

    // test4setExpenseReportTPAYpsPayType
    private static PaymentTypeOid test4setExpenseReportTPAYpsPayTypeArg1;

    // test4getExpenseReportTPAYptpthisExpenseReport

    // test4setExpenseReportTPAYptpthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportTPAYptpthisExpenseReportArg1;

    // test4getExpenseReportTPAYpsComments

    // test4setExpenseReportTPAYpsComments
    private static String test4setExpenseReportTPAYpsCommentsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTPAYptpeDate();
        setUpMockData4test4setExpenseReportTPAYptpeDate();
        setUpMockData4test4getExpenseReportTPAYpsPayType();
        setUpMockData4test4setExpenseReportTPAYpsPayType();
        setUpMockData4test4getExpenseReportTPAYptpthisExpenseReport();
        setUpMockData4test4setExpenseReportTPAYptpthisExpenseReport();
        setUpMockData4test4getExpenseReportTPAYpsComments();
        setUpMockData4test4setExpenseReportTPAYpsComments();
    }

    private static void setUpMockData4test4getExpenseReportTPAYptpeDate() {
    }

    private static void setUpMockData4test4setExpenseReportTPAYptpeDate() {
        test4setExpenseReportTPAYptpeDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportTPAYpsPayType() {
    }

    private static void setUpMockData4test4setExpenseReportTPAYpsPayType() {
        test4setExpenseReportTPAYpsPayTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getExpenseReportTPAYptpthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportTPAYptpthisExpenseReport() {
        test4setExpenseReportTPAYptpthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportTPAYpsComments() {
    }

    private static void setUpMockData4test4setExpenseReportTPAYpsComments() {
        test4setExpenseReportTPAYpsCommentsArg1 = "";
    }

    @Before
    public void setUp() {
        instanceTPAYRequest = new TPAYRequest();
        instanceTPAYRequest.setExpenseReportTPAYptpeDate(defValue4expenseReportTPAYptpeDate);
        instanceTPAYRequest.setExpenseReportTPAYpsPayType(defValue4expenseReportTPAYpsPayType);
        instanceTPAYRequest.setExpenseReportTPAYpsPayTypeInstance(defValue4expenseReportTPAYpsPayTypeInstance);
        instanceTPAYRequest.setExpenseReportTPAYptpthisExpenseReport(defValue4expenseReportTPAYptpthisExpenseReport);
        instanceTPAYRequest.setExpenseReportTPAYptpthisExpenseReportInstance(defValue4expenseReportTPAYptpthisExpenseReportInstance);
        instanceTPAYRequest.setExpenseReportTPAYpsComments(defValue4expenseReportTPAYpsComments);
    }

    @Test
    public void test4getExpenseReportTPAYptpeDate() {
        assertEquals(defValue4expenseReportTPAYptpeDate, instanceTPAYRequest.getExpenseReportTPAYptpeDate());
    }

    @Test
    public void test4setExpenseReportTPAYptpeDate() {
        instanceTPAYRequest.setExpenseReportTPAYptpeDate(test4setExpenseReportTPAYptpeDateArg1);
        assertNotNull(instanceTPAYRequest);
    }

    @Test
    public void test4getExpenseReportTPAYpsPayType() {
        assertEquals(defValue4expenseReportTPAYpsPayType, instanceTPAYRequest.getExpenseReportTPAYpsPayType());
    }

    @Test
    public void test4setExpenseReportTPAYpsPayType() {
        instanceTPAYRequest.setExpenseReportTPAYpsPayType(test4setExpenseReportTPAYpsPayTypeArg1);
        assertNotNull(instanceTPAYRequest);
    }

    @Test
    public void test4getExpenseReportTPAYptpthisExpenseReport() {
        assertEquals(defValue4expenseReportTPAYptpthisExpenseReport, instanceTPAYRequest.getExpenseReportTPAYptpthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportTPAYptpthisExpenseReport() {
        instanceTPAYRequest.setExpenseReportTPAYptpthisExpenseReport(test4setExpenseReportTPAYptpthisExpenseReportArg1);
        assertNotNull(instanceTPAYRequest);
    }

    @Test
    public void test4getExpenseReportTPAYpsComments() {
        assertEquals(defValue4expenseReportTPAYpsComments, instanceTPAYRequest.getExpenseReportTPAYpsComments());
    }

    @Test
    public void test4setExpenseReportTPAYpsComments() {
        instanceTPAYRequest.setExpenseReportTPAYpsComments(test4setExpenseReportTPAYpsCommentsArg1);
        assertNotNull(instanceTPAYRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTPAYRequest = new TPAYRequest();
    	instanceTPAYRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTPAYRequest.checkArguments();
    }
}
