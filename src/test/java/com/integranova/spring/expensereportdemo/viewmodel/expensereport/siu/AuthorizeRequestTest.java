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
public class AuthorizeRequestTest {

    private AuthorizeRequest instanceAuthorizeRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportauthorizepthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportauthorizepthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static Date defValue4expenseReportauthorizepsDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseReportauthorizepsComments = "";


    // test4getExpenseReportauthorizepthisExpenseReport

    // test4setExpenseReportauthorizepthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportauthorizepthisExpenseReportArg1;

    // test4getExpenseReportauthorizepsDate

    // test4setExpenseReportauthorizepsDate
    private static Date test4setExpenseReportauthorizepsDateArg1;

    // test4getExpenseReportauthorizepsComments

    // test4setExpenseReportauthorizepsComments
    private static String test4setExpenseReportauthorizepsCommentsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportauthorizepthisExpenseReport();
        setUpMockData4test4setExpenseReportauthorizepthisExpenseReport();
        setUpMockData4test4getExpenseReportauthorizepsDate();
        setUpMockData4test4setExpenseReportauthorizepsDate();
        setUpMockData4test4getExpenseReportauthorizepsComments();
        setUpMockData4test4setExpenseReportauthorizepsComments();
    }

    private static void setUpMockData4test4getExpenseReportauthorizepthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportauthorizepthisExpenseReport() {
        test4setExpenseReportauthorizepthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportauthorizepsDate() {
    }

    private static void setUpMockData4test4setExpenseReportauthorizepsDate() {
        test4setExpenseReportauthorizepsDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportauthorizepsComments() {
    }

    private static void setUpMockData4test4setExpenseReportauthorizepsComments() {
        test4setExpenseReportauthorizepsCommentsArg1 = "";
    }

    @Before
    public void setUp() {
        instanceAuthorizeRequest = new AuthorizeRequest();
        instanceAuthorizeRequest.setExpenseReportauthorizepthisExpenseReport(defValue4expenseReportauthorizepthisExpenseReport);
        instanceAuthorizeRequest.setExpenseReportauthorizepthisExpenseReportInstance(defValue4expenseReportauthorizepthisExpenseReportInstance);
        instanceAuthorizeRequest.setExpenseReportauthorizepsDate(defValue4expenseReportauthorizepsDate);
        instanceAuthorizeRequest.setExpenseReportauthorizepsComments(defValue4expenseReportauthorizepsComments);
    }

    @Test
    public void test4getExpenseReportauthorizepthisExpenseReport() {
        assertEquals(defValue4expenseReportauthorizepthisExpenseReport, instanceAuthorizeRequest.getExpenseReportauthorizepthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportauthorizepthisExpenseReport() {
        instanceAuthorizeRequest.setExpenseReportauthorizepthisExpenseReport(test4setExpenseReportauthorizepthisExpenseReportArg1);
        assertNotNull(instanceAuthorizeRequest);
    }

    @Test
    public void test4getExpenseReportauthorizepsDate() {
        assertEquals(defValue4expenseReportauthorizepsDate, instanceAuthorizeRequest.getExpenseReportauthorizepsDate());
    }

    @Test
    public void test4setExpenseReportauthorizepsDate() {
        instanceAuthorizeRequest.setExpenseReportauthorizepsDate(test4setExpenseReportauthorizepsDateArg1);
        assertNotNull(instanceAuthorizeRequest);
    }

    @Test
    public void test4getExpenseReportauthorizepsComments() {
        assertEquals(defValue4expenseReportauthorizepsComments, instanceAuthorizeRequest.getExpenseReportauthorizepsComments());
    }

    @Test
    public void test4setExpenseReportauthorizepsComments() {
        instanceAuthorizeRequest.setExpenseReportauthorizepsComments(test4setExpenseReportauthorizepsCommentsArg1);
        assertNotNull(instanceAuthorizeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceAuthorizeRequest = new AuthorizeRequest();
    	instanceAuthorizeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceAuthorizeRequest.checkArguments();
    }
}
