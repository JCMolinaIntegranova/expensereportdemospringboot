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
public class RejectpaymentRequestTest {

    private RejectpaymentRequest instanceRejectpaymentRequest;

    // Default values
    private static ExpenseReportOid defValue4expenseReportrejectpaymentpthisExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseReportrejectpaymentpthisExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static String defValue4expenseReportrejectpaymentpeComments = "";
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseReportrejectpaymentpthisExpenseReport

    // test4setExpenseReportrejectpaymentpthisExpenseReport
    private static ExpenseReportOid test4setExpenseReportrejectpaymentpthisExpenseReportArg1;

    // test4getExpenseReportrejectpaymentpeComments

    // test4setExpenseReportrejectpaymentpeComments
    private static String test4setExpenseReportrejectpaymentpeCommentsArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportrejectpaymentpthisExpenseReport();
        setUpMockData4test4setExpenseReportrejectpaymentpthisExpenseReport();
        setUpMockData4test4getExpenseReportrejectpaymentpeComments();
        setUpMockData4test4setExpenseReportrejectpaymentpeComments();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseReportrejectpaymentpthisExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseReportrejectpaymentpthisExpenseReport() {
        test4setExpenseReportrejectpaymentpthisExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseReportrejectpaymentpeComments() {
    }

    private static void setUpMockData4test4setExpenseReportrejectpaymentpeComments() {
        test4setExpenseReportrejectpaymentpeCommentsArg1 = "";
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceRejectpaymentRequest = new RejectpaymentRequest();
        instanceRejectpaymentRequest.setExpenseReportrejectpaymentpthisExpenseReport(defValue4expenseReportrejectpaymentpthisExpenseReport);
        instanceRejectpaymentRequest.setExpenseReportrejectpaymentpthisExpenseReportInstance(defValue4expenseReportrejectpaymentpthisExpenseReportInstance);
        instanceRejectpaymentRequest.setExpenseReportrejectpaymentpeComments(defValue4expenseReportrejectpaymentpeComments);
        instanceRejectpaymentRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseReportrejectpaymentpthisExpenseReport() {
        assertEquals(defValue4expenseReportrejectpaymentpthisExpenseReport, instanceRejectpaymentRequest.getExpenseReportrejectpaymentpthisExpenseReport());
    }

    @Test
    public void test4setExpenseReportrejectpaymentpthisExpenseReport() {
        instanceRejectpaymentRequest.setExpenseReportrejectpaymentpthisExpenseReport(test4setExpenseReportrejectpaymentpthisExpenseReportArg1);
        assertNotNull(instanceRejectpaymentRequest);
    }

    @Test
    public void test4getExpenseReportrejectpaymentpeComments() {
        assertEquals(defValue4expenseReportrejectpaymentpeComments, instanceRejectpaymentRequest.getExpenseReportrejectpaymentpeComments());
    }

    @Test
    public void test4setExpenseReportrejectpaymentpeComments() {
        instanceRejectpaymentRequest.setExpenseReportrejectpaymentpeComments(test4setExpenseReportrejectpaymentpeCommentsArg1);
        assertNotNull(instanceRejectpaymentRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceRejectpaymentRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceRejectpaymentRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceRejectpaymentRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceRejectpaymentRequest = new RejectpaymentRequest();
    	instanceRejectpaymentRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceRejectpaymentRequest.checkArguments();
    }
}
