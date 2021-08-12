package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ExpenseLineOid defValue4expenseLineeditinstancepthisExpenseLine = new ExpenseLineOid();
    private static ExpenseLine defValue4expenseLineeditinstancepthisExpenseLineInstance = new ExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
    private static Date defValue4expenseLineeditinstancepExpenseDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static Double defValue4expenseLineeditinstancepUnits = Double.valueOf(0);
    private static Double defValue4expenseLineeditinstancepPrice = Double.valueOf(0);
    private static String defValue4expenseLineeditinstancepLnDescription = "";
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseLineeditinstancepthisExpenseLine

    // test4setExpenseLineeditinstancepthisExpenseLine
    private static ExpenseLineOid test4setExpenseLineeditinstancepthisExpenseLineArg1;

    // test4getExpenseLineeditinstancepExpenseDate

    // test4setExpenseLineeditinstancepExpenseDate
    private static Date test4setExpenseLineeditinstancepExpenseDateArg1;

    // test4getExpenseLineeditinstancepUnits

    // test4setExpenseLineeditinstancepUnits
    private static Double test4setExpenseLineeditinstancepUnitsArg1;

    // test4getExpenseLineeditinstancepPrice

    // test4setExpenseLineeditinstancepPrice
    private static Double test4setExpenseLineeditinstancepPriceArg1;

    // test4getExpenseLineeditinstancepLnDescription

    // test4setExpenseLineeditinstancepLnDescription
    private static String test4setExpenseLineeditinstancepLnDescriptionArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseLineeditinstancepthisExpenseLine();
        setUpMockData4test4setExpenseLineeditinstancepthisExpenseLine();
        setUpMockData4test4getExpenseLineeditinstancepExpenseDate();
        setUpMockData4test4setExpenseLineeditinstancepExpenseDate();
        setUpMockData4test4getExpenseLineeditinstancepUnits();
        setUpMockData4test4setExpenseLineeditinstancepUnits();
        setUpMockData4test4getExpenseLineeditinstancepPrice();
        setUpMockData4test4setExpenseLineeditinstancepPrice();
        setUpMockData4test4getExpenseLineeditinstancepLnDescription();
        setUpMockData4test4setExpenseLineeditinstancepLnDescription();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseLineeditinstancepthisExpenseLine() {
    }

    private static void setUpMockData4test4setExpenseLineeditinstancepthisExpenseLine() {
        test4setExpenseLineeditinstancepthisExpenseLineArg1 = new ExpenseLineOid();
    }

    private static void setUpMockData4test4getExpenseLineeditinstancepExpenseDate() {
    }

    private static void setUpMockData4test4setExpenseLineeditinstancepExpenseDate() {
        test4setExpenseLineeditinstancepExpenseDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseLineeditinstancepUnits() {
    }

    private static void setUpMockData4test4setExpenseLineeditinstancepUnits() {
        test4setExpenseLineeditinstancepUnitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseLineeditinstancepPrice() {
    }

    private static void setUpMockData4test4setExpenseLineeditinstancepPrice() {
        test4setExpenseLineeditinstancepPriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseLineeditinstancepLnDescription() {
    }

    private static void setUpMockData4test4setExpenseLineeditinstancepLnDescription() {
        test4setExpenseLineeditinstancepLnDescriptionArg1 = "";
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setExpenseLineeditinstancepthisExpenseLine(defValue4expenseLineeditinstancepthisExpenseLine);
        instanceEditinstanceRequest.setExpenseLineeditinstancepthisExpenseLineInstance(defValue4expenseLineeditinstancepthisExpenseLineInstance);
        instanceEditinstanceRequest.setExpenseLineeditinstancepExpenseDate(defValue4expenseLineeditinstancepExpenseDate);
        instanceEditinstanceRequest.setExpenseLineeditinstancepUnits(defValue4expenseLineeditinstancepUnits);
        instanceEditinstanceRequest.setExpenseLineeditinstancepPrice(defValue4expenseLineeditinstancepPrice);
        instanceEditinstanceRequest.setExpenseLineeditinstancepLnDescription(defValue4expenseLineeditinstancepLnDescription);
        instanceEditinstanceRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseLineeditinstancepthisExpenseLine() {
        assertEquals(defValue4expenseLineeditinstancepthisExpenseLine, instanceEditinstanceRequest.getExpenseLineeditinstancepthisExpenseLine());
    }

    @Test
    public void test4setExpenseLineeditinstancepthisExpenseLine() {
        instanceEditinstanceRequest.setExpenseLineeditinstancepthisExpenseLine(test4setExpenseLineeditinstancepthisExpenseLineArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseLineeditinstancepExpenseDate() {
        assertEquals(defValue4expenseLineeditinstancepExpenseDate, instanceEditinstanceRequest.getExpenseLineeditinstancepExpenseDate());
    }

    @Test
    public void test4setExpenseLineeditinstancepExpenseDate() {
        instanceEditinstanceRequest.setExpenseLineeditinstancepExpenseDate(test4setExpenseLineeditinstancepExpenseDateArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseLineeditinstancepUnits() {
        assertEquals(defValue4expenseLineeditinstancepUnits, instanceEditinstanceRequest.getExpenseLineeditinstancepUnits());
    }

    @Test
    public void test4setExpenseLineeditinstancepUnits() {
        instanceEditinstanceRequest.setExpenseLineeditinstancepUnits(test4setExpenseLineeditinstancepUnitsArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseLineeditinstancepPrice() {
        assertEquals(defValue4expenseLineeditinstancepPrice, instanceEditinstanceRequest.getExpenseLineeditinstancepPrice());
    }

    @Test
    public void test4setExpenseLineeditinstancepPrice() {
        instanceEditinstanceRequest.setExpenseLineeditinstancepPrice(test4setExpenseLineeditinstancepPriceArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseLineeditinstancepLnDescription() {
        assertEquals(defValue4expenseLineeditinstancepLnDescription, instanceEditinstanceRequest.getExpenseLineeditinstancepLnDescription());
    }

    @Test
    public void test4setExpenseLineeditinstancepLnDescription() {
        instanceEditinstanceRequest.setExpenseLineeditinstancepLnDescription(test4setExpenseLineeditinstancepLnDescriptionArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceEditinstanceRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceEditinstanceRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
