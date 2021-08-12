package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static String defValue4expenseTypecreateinstancepatrTypeCode = "";
    private static String defValue4expenseTypecreateinstancepatrTyDescription = "";
    private static Double defValue4expenseTypecreateinstancepatrPrice = Double.valueOf(0);
    private static Boolean defValue4expenseTypecreateinstancepatrFixedPrice = false;


    // test4getExpenseTypecreateinstancepatrTypeCode

    // test4setExpenseTypecreateinstancepatrTypeCode
    private static String test4setExpenseTypecreateinstancepatrTypeCodeArg1;

    // test4getExpenseTypecreateinstancepatrTyDescription

    // test4setExpenseTypecreateinstancepatrTyDescription
    private static String test4setExpenseTypecreateinstancepatrTyDescriptionArg1;

    // test4getExpenseTypecreateinstancepatrPrice

    // test4setExpenseTypecreateinstancepatrPrice
    private static Double test4setExpenseTypecreateinstancepatrPriceArg1;

    // test4getExpenseTypecreateinstancepatrFixedPrice

    // test4setExpenseTypecreateinstancepatrFixedPrice
    private static Boolean test4setExpenseTypecreateinstancepatrFixedPriceArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseTypecreateinstancepatrTypeCode();
        setUpMockData4test4setExpenseTypecreateinstancepatrTypeCode();
        setUpMockData4test4getExpenseTypecreateinstancepatrTyDescription();
        setUpMockData4test4setExpenseTypecreateinstancepatrTyDescription();
        setUpMockData4test4getExpenseTypecreateinstancepatrPrice();
        setUpMockData4test4setExpenseTypecreateinstancepatrPrice();
        setUpMockData4test4getExpenseTypecreateinstancepatrFixedPrice();
        setUpMockData4test4setExpenseTypecreateinstancepatrFixedPrice();
    }

    private static void setUpMockData4test4getExpenseTypecreateinstancepatrTypeCode() {
    }

    private static void setUpMockData4test4setExpenseTypecreateinstancepatrTypeCode() {
        test4setExpenseTypecreateinstancepatrTypeCodeArg1 = "";
    }

    private static void setUpMockData4test4getExpenseTypecreateinstancepatrTyDescription() {
    }

    private static void setUpMockData4test4setExpenseTypecreateinstancepatrTyDescription() {
        test4setExpenseTypecreateinstancepatrTyDescriptionArg1 = "";
    }

    private static void setUpMockData4test4getExpenseTypecreateinstancepatrPrice() {
    }

    private static void setUpMockData4test4setExpenseTypecreateinstancepatrPrice() {
        test4setExpenseTypecreateinstancepatrPriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseTypecreateinstancepatrFixedPrice() {
    }

    private static void setUpMockData4test4setExpenseTypecreateinstancepatrFixedPrice() {
        test4setExpenseTypecreateinstancepatrFixedPriceArg1 = false;
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrTypeCode(defValue4expenseTypecreateinstancepatrTypeCode);
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrTyDescription(defValue4expenseTypecreateinstancepatrTyDescription);
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrPrice(defValue4expenseTypecreateinstancepatrPrice);
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrFixedPrice(defValue4expenseTypecreateinstancepatrFixedPrice);
    }

    @Test
    public void test4getExpenseTypecreateinstancepatrTypeCode() {
        assertEquals(defValue4expenseTypecreateinstancepatrTypeCode, instanceCreateinstanceRequest.getExpenseTypecreateinstancepatrTypeCode());
    }

    @Test
    public void test4setExpenseTypecreateinstancepatrTypeCode() {
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrTypeCode(test4setExpenseTypecreateinstancepatrTypeCodeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseTypecreateinstancepatrTyDescription() {
        assertEquals(defValue4expenseTypecreateinstancepatrTyDescription, instanceCreateinstanceRequest.getExpenseTypecreateinstancepatrTyDescription());
    }

    @Test
    public void test4setExpenseTypecreateinstancepatrTyDescription() {
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrTyDescription(test4setExpenseTypecreateinstancepatrTyDescriptionArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseTypecreateinstancepatrPrice() {
        assertEquals(defValue4expenseTypecreateinstancepatrPrice, instanceCreateinstanceRequest.getExpenseTypecreateinstancepatrPrice());
    }

    @Test
    public void test4setExpenseTypecreateinstancepatrPrice() {
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrPrice(test4setExpenseTypecreateinstancepatrPriceArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseTypecreateinstancepatrFixedPrice() {
        assertEquals(defValue4expenseTypecreateinstancepatrFixedPrice, instanceCreateinstanceRequest.getExpenseTypecreateinstancepatrFixedPrice());
    }

    @Test
    public void test4setExpenseTypecreateinstancepatrFixedPrice() {
        instanceCreateinstanceRequest.setExpenseTypecreateinstancepatrFixedPrice(test4setExpenseTypecreateinstancepatrFixedPriceArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
    	instanceCreateinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCreateinstanceRequest.checkArguments();
    }
}
