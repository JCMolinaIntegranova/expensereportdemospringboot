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
public class RejectauthoRequestTest {

    private RejectauthoRequest instanceRejectauthoRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportrejectauthopthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportrejectauthopthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static String defValue4expenseReportrejectauthopeComments = "";
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseReportrejectauthopthisExpenseReport

    // test4setExpenseReportrejectauthopthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportrejectauthopthisExpenseReportArg1;

    // test4getExpenseReportrejectauthopeComments

    // test4setExpenseReportrejectauthopeComments
    private static String test4setExpenseReportrejectauthopeCommentsArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportrejectauthopthisExpenseReport();
        setUpMockData4test4setExpenseReportrejectauthopthisExpenseReport();
        setUpMockData4test4getExpenseReportrejectauthopeComments();
        setUpMockData4test4setExpenseReportrejectauthopeComments();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseReportrejectauthopthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportrejectauthopthisExpenseReport() {
        test4setExpenseReportrejectauthopthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportrejectauthopeComments() {
    }

    private static void setUpMockData4test4setExpenseReportrejectauthopeComments() {
        test4setExpenseReportrejectauthopeCommentsArg1 = "";
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceRejectauthoRequest = new RejectauthoRequest();
        instanceRejectauthoRequest.setExpenseReportrejectauthopthisExpenseReport(defValue4expenseReportrejectauthopthisExpenseReport);
        instanceRejectauthoRequest.setExpenseReportrejectauthopthisExpenseReportInstance(defValue4expenseReportrejectauthopthisExpenseReportInstance);
        instanceRejectauthoRequest.setExpenseReportrejectauthopeComments(defValue4expenseReportrejectauthopeComments);
        instanceRejectauthoRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseReportrejectauthopthisExpenseReport() {
        assertEquals(defValue4expenseReportrejectauthopthisExpenseReport, instanceRejectauthoRequest.getExpenseReportrejectauthopthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportrejectauthopthisExpenseReport() {
        instanceRejectauthoRequest.setExpenseReportrejectauthopthisExpenseReport(test4setExpenseReportrejectauthopthisExpenseReportArg1);
        assertNotNull(instanceRejectauthoRequest);
    }

    @Test
    public void test4getExpenseReportrejectauthopeComments() {
        assertEquals(defValue4expenseReportrejectauthopeComments, instanceRejectauthoRequest.getExpenseReportrejectauthopeComments());
    }

    @Test
    public void test4setExpenseReportrejectauthopeComments() {
        instanceRejectauthoRequest.setExpenseReportrejectauthopeComments(test4setExpenseReportrejectauthopeCommentsArg1);
        assertNotNull(instanceRejectauthoRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceRejectauthoRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceRejectauthoRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceRejectauthoRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceRejectauthoRequest = new RejectauthoRequest();
    	instanceRejectauthoRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceRejectauthoRequest.checkArguments();
    }
}
