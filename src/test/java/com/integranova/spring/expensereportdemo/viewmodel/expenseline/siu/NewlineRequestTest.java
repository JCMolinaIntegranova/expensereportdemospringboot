package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewlineRequestTest {

    private NewlineRequest instanceNewlineRequest;

    // Default values
    private static String defValue4expenseLinenewlinepagrExpenseType = "";
    private static ExpenseType defValue4expenseLinenewlinepagrExpenseTypeInstance = new ExpenseType(new ExpenseTypeOid(""));
    private static ExpenseReportOid defValue4expenseLinenewlinepagrExpenseReport = new ExpenseReportOid();
    private static ExpenseReport defValue4expenseLinenewlinepagrExpenseReportInstance = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
    private static Double defValue4expenseLinenewlinepatrUnits = Double.valueOf(0);
    private static Double defValue4expenseLinenewlinepatrPrice = Double.valueOf(0);
    private static Date defValue4expenseLinenewlinepatrExpenseDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseLinenewlinepatrLnDescription = "";
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseLinenewlinepagrExpenseType

    // test4setExpenseLinenewlinepagrExpenseType
    private static String test4setExpenseLinenewlinepagrExpenseTypeArg1;

    // test4getExpenseLinenewlinepagrExpenseReport

    // test4setExpenseLinenewlinepagrExpenseReport
    private static ExpenseReportOid test4setExpenseLinenewlinepagrExpenseReportArg1;

    // test4getExpenseLinenewlinepatrUnits

    // test4setExpenseLinenewlinepatrUnits
    private static Double test4setExpenseLinenewlinepatrUnitsArg1;

    // test4getExpenseLinenewlinepatrPrice

    // test4setExpenseLinenewlinepatrPrice
    private static Double test4setExpenseLinenewlinepatrPriceArg1;

    // test4getExpenseLinenewlinepatrExpenseDate

    // test4setExpenseLinenewlinepatrExpenseDate
    private static Date test4setExpenseLinenewlinepatrExpenseDateArg1;

    // test4getExpenseLinenewlinepatrLnDescription

    // test4setExpenseLinenewlinepatrLnDescription
    private static String test4setExpenseLinenewlinepatrLnDescriptionArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseLinenewlinepagrExpenseType();
        setUpMockData4test4setExpenseLinenewlinepagrExpenseType();
        setUpMockData4test4getExpenseLinenewlinepagrExpenseReport();
        setUpMockData4test4setExpenseLinenewlinepagrExpenseReport();
        setUpMockData4test4getExpenseLinenewlinepatrUnits();
        setUpMockData4test4setExpenseLinenewlinepatrUnits();
        setUpMockData4test4getExpenseLinenewlinepatrPrice();
        setUpMockData4test4setExpenseLinenewlinepatrPrice();
        setUpMockData4test4getExpenseLinenewlinepatrExpenseDate();
        setUpMockData4test4setExpenseLinenewlinepatrExpenseDate();
        setUpMockData4test4getExpenseLinenewlinepatrLnDescription();
        setUpMockData4test4setExpenseLinenewlinepatrLnDescription();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseLinenewlinepagrExpenseType() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepagrExpenseType() {
        test4setExpenseLinenewlinepagrExpenseTypeArg1 = "";
    }

    private static void setUpMockData4test4getExpenseLinenewlinepagrExpenseReport() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepagrExpenseReport() {
        test4setExpenseLinenewlinepagrExpenseReportArg1 = new ExpenseReportOid();
    }

    private static void setUpMockData4test4getExpenseLinenewlinepatrUnits() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepatrUnits() {
        test4setExpenseLinenewlinepatrUnitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseLinenewlinepatrPrice() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepatrPrice() {
        test4setExpenseLinenewlinepatrPriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseLinenewlinepatrExpenseDate() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepatrExpenseDate() {
        test4setExpenseLinenewlinepatrExpenseDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseLinenewlinepatrLnDescription() {
    }

    private static void setUpMockData4test4setExpenseLinenewlinepatrLnDescription() {
        test4setExpenseLinenewlinepatrLnDescriptionArg1 = "";
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceNewlineRequest = new NewlineRequest();
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseType(defValue4expenseLinenewlinepagrExpenseType);
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseTypeInstance(defValue4expenseLinenewlinepagrExpenseTypeInstance);
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseReport(defValue4expenseLinenewlinepagrExpenseReport);
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseReportInstance(defValue4expenseLinenewlinepagrExpenseReportInstance);
        instanceNewlineRequest.setExpenseLinenewlinepatrUnits(defValue4expenseLinenewlinepatrUnits);
        instanceNewlineRequest.setExpenseLinenewlinepatrPrice(defValue4expenseLinenewlinepatrPrice);
        instanceNewlineRequest.setExpenseLinenewlinepatrExpenseDate(defValue4expenseLinenewlinepatrExpenseDate);
        instanceNewlineRequest.setExpenseLinenewlinepatrLnDescription(defValue4expenseLinenewlinepatrLnDescription);
        instanceNewlineRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseLinenewlinepagrExpenseType() {
        assertEquals(defValue4expenseLinenewlinepagrExpenseType, instanceNewlineRequest.getExpenseLinenewlinepagrExpenseType());
    }

    @Test
    public void test4setExpenseLinenewlinepagrExpenseType() {
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseType(test4setExpenseLinenewlinepagrExpenseTypeArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void test4getExpenseLinenewlinepagrExpenseReport() {
        assertEquals(defValue4expenseLinenewlinepagrExpenseReport, instanceNewlineRequest.getExpenseLinenewlinepagrExpenseReport());
    }

    @Test
    public void test4setExpenseLinenewlinepagrExpenseReport() {
        instanceNewlineRequest.setExpenseLinenewlinepagrExpenseReport(test4setExpenseLinenewlinepagrExpenseReportArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void test4getExpenseLinenewlinepatrUnits() {
        assertEquals(defValue4expenseLinenewlinepatrUnits, instanceNewlineRequest.getExpenseLinenewlinepatrUnits());
    }

    @Test
    public void test4setExpenseLinenewlinepatrUnits() {
        instanceNewlineRequest.setExpenseLinenewlinepatrUnits(test4setExpenseLinenewlinepatrUnitsArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void test4getExpenseLinenewlinepatrPrice() {
        assertEquals(defValue4expenseLinenewlinepatrPrice, instanceNewlineRequest.getExpenseLinenewlinepatrPrice());
    }

    @Test
    public void test4setExpenseLinenewlinepatrPrice() {
        instanceNewlineRequest.setExpenseLinenewlinepatrPrice(test4setExpenseLinenewlinepatrPriceArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void test4getExpenseLinenewlinepatrExpenseDate() {
        assertEquals(defValue4expenseLinenewlinepatrExpenseDate, instanceNewlineRequest.getExpenseLinenewlinepatrExpenseDate());
    }

    @Test
    public void test4setExpenseLinenewlinepatrExpenseDate() {
        instanceNewlineRequest.setExpenseLinenewlinepatrExpenseDate(test4setExpenseLinenewlinepatrExpenseDateArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void test4getExpenseLinenewlinepatrLnDescription() {
        assertEquals(defValue4expenseLinenewlinepatrLnDescription, instanceNewlineRequest.getExpenseLinenewlinepatrLnDescription());
    }

    @Test
    public void test4setExpenseLinenewlinepatrLnDescription() {
        instanceNewlineRequest.setExpenseLinenewlinepatrLnDescription(test4setExpenseLinenewlinepatrLnDescriptionArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceNewlineRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceNewlineRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceNewlineRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceNewlineRequest = new NewlineRequest();
    	instanceNewlineRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceNewlineRequest.checkArguments();
    }
}
