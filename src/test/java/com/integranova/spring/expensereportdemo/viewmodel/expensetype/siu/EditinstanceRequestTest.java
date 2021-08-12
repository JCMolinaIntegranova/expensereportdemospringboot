package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ExpenseTypeOid defValue4expenseTypeeditinstancepthisExpenseType = new ExpenseTypeOid();
    private static ExpenseType defValue4expenseTypeeditinstancepthisExpenseTypeInstance = new ExpenseType(new ExpenseTypeOid(""));
    private static Double defValue4expenseTypeeditinstancepPrice = Double.valueOf(0);
    private static String defValue4expenseTypeeditinstancepTyDescription = "";
    private static Boolean defValue4expenseTypeeditinstancepFixedPrice = false;


    // test4getExpenseTypeeditinstancepthisExpenseType

    // test4setExpenseTypeeditinstancepthisExpenseType
    private static ExpenseTypeOid test4setExpenseTypeeditinstancepthisExpenseTypeArg1;

    // test4getExpenseTypeeditinstancepPrice

    // test4setExpenseTypeeditinstancepPrice
    private static Double test4setExpenseTypeeditinstancepPriceArg1;

    // test4getExpenseTypeeditinstancepTyDescription

    // test4setExpenseTypeeditinstancepTyDescription
    private static String test4setExpenseTypeeditinstancepTyDescriptionArg1;

    // test4getExpenseTypeeditinstancepFixedPrice

    // test4setExpenseTypeeditinstancepFixedPrice
    private static Boolean test4setExpenseTypeeditinstancepFixedPriceArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseTypeeditinstancepthisExpenseType();
        setUpMockData4test4setExpenseTypeeditinstancepthisExpenseType();
        setUpMockData4test4getExpenseTypeeditinstancepPrice();
        setUpMockData4test4setExpenseTypeeditinstancepPrice();
        setUpMockData4test4getExpenseTypeeditinstancepTyDescription();
        setUpMockData4test4setExpenseTypeeditinstancepTyDescription();
        setUpMockData4test4getExpenseTypeeditinstancepFixedPrice();
        setUpMockData4test4setExpenseTypeeditinstancepFixedPrice();
    }

    private static void setUpMockData4test4getExpenseTypeeditinstancepthisExpenseType() {
    }

    private static void setUpMockData4test4setExpenseTypeeditinstancepthisExpenseType() {
        test4setExpenseTypeeditinstancepthisExpenseTypeArg1 = new ExpenseTypeOid();
    }

    private static void setUpMockData4test4getExpenseTypeeditinstancepPrice() {
    }

    private static void setUpMockData4test4setExpenseTypeeditinstancepPrice() {
        test4setExpenseTypeeditinstancepPriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseTypeeditinstancepTyDescription() {
    }

    private static void setUpMockData4test4setExpenseTypeeditinstancepTyDescription() {
        test4setExpenseTypeeditinstancepTyDescriptionArg1 = "";
    }

    private static void setUpMockData4test4getExpenseTypeeditinstancepFixedPrice() {
    }

    private static void setUpMockData4test4setExpenseTypeeditinstancepFixedPrice() {
        test4setExpenseTypeeditinstancepFixedPriceArg1 = false;
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setExpenseTypeeditinstancepthisExpenseType(defValue4expenseTypeeditinstancepthisExpenseType);
        instanceEditinstanceRequest.setExpenseTypeeditinstancepthisExpenseTypeInstance(defValue4expenseTypeeditinstancepthisExpenseTypeInstance);
        instanceEditinstanceRequest.setExpenseTypeeditinstancepPrice(defValue4expenseTypeeditinstancepPrice);
        instanceEditinstanceRequest.setExpenseTypeeditinstancepTyDescription(defValue4expenseTypeeditinstancepTyDescription);
        instanceEditinstanceRequest.setExpenseTypeeditinstancepFixedPrice(defValue4expenseTypeeditinstancepFixedPrice);
    }

    @Test
    public void test4getExpenseTypeeditinstancepthisExpenseType() {
        assertEquals(defValue4expenseTypeeditinstancepthisExpenseType, instanceEditinstanceRequest.getExpenseTypeeditinstancepthisExpenseType());
    }

    @Test
    public void test4setExpenseTypeeditinstancepthisExpenseType() {
        instanceEditinstanceRequest.setExpenseTypeeditinstancepthisExpenseType(test4setExpenseTypeeditinstancepthisExpenseTypeArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseTypeeditinstancepPrice() {
        assertEquals(defValue4expenseTypeeditinstancepPrice, instanceEditinstanceRequest.getExpenseTypeeditinstancepPrice());
    }

    @Test
    public void test4setExpenseTypeeditinstancepPrice() {
        instanceEditinstanceRequest.setExpenseTypeeditinstancepPrice(test4setExpenseTypeeditinstancepPriceArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseTypeeditinstancepTyDescription() {
        assertEquals(defValue4expenseTypeeditinstancepTyDescription, instanceEditinstanceRequest.getExpenseTypeeditinstancepTyDescription());
    }

    @Test
    public void test4setExpenseTypeeditinstancepTyDescription() {
        instanceEditinstanceRequest.setExpenseTypeeditinstancepTyDescription(test4setExpenseTypeeditinstancepTyDescriptionArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseTypeeditinstancepFixedPrice() {
        assertEquals(defValue4expenseTypeeditinstancepFixedPrice, instanceEditinstanceRequest.getExpenseTypeeditinstancepFixedPrice());
    }

    @Test
    public void test4setExpenseTypeeditinstancepFixedPrice() {
        instanceEditinstanceRequest.setExpenseTypeeditinstancepFixedPrice(test4setExpenseTypeeditinstancepFixedPriceArg1);
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
