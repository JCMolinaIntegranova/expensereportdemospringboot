package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

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
    private static String defValue4expenseCurrencycreateinstancepatrCurrencyName = "";
    private static String defValue4expenseCurrencycreateinstancepatrCurrencyCode = "";
    private static String defValue4expenseCurrencycreateinstancepatrCurAcronym = "";
    private static Double defValue4expenseCurrencycreateinstancepatrExchange = Double.valueOf(0);


    // test4getExpenseCurrencycreateinstancepatrCurrencyName

    // test4setExpenseCurrencycreateinstancepatrCurrencyName
    private static String test4setExpenseCurrencycreateinstancepatrCurrencyNameArg1;

    // test4getExpenseCurrencycreateinstancepatrCurrencyCode

    // test4setExpenseCurrencycreateinstancepatrCurrencyCode
    private static String test4setExpenseCurrencycreateinstancepatrCurrencyCodeArg1;

    // test4getExpenseCurrencycreateinstancepatrCurAcronym

    // test4setExpenseCurrencycreateinstancepatrCurAcronym
    private static String test4setExpenseCurrencycreateinstancepatrCurAcronymArg1;

    // test4getExpenseCurrencycreateinstancepatrExchange

    // test4setExpenseCurrencycreateinstancepatrExchange
    private static Double test4setExpenseCurrencycreateinstancepatrExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencycreateinstancepatrCurrencyName();
        setUpMockData4test4setExpenseCurrencycreateinstancepatrCurrencyName();
        setUpMockData4test4getExpenseCurrencycreateinstancepatrCurrencyCode();
        setUpMockData4test4setExpenseCurrencycreateinstancepatrCurrencyCode();
        setUpMockData4test4getExpenseCurrencycreateinstancepatrCurAcronym();
        setUpMockData4test4setExpenseCurrencycreateinstancepatrCurAcronym();
        setUpMockData4test4getExpenseCurrencycreateinstancepatrExchange();
        setUpMockData4test4setExpenseCurrencycreateinstancepatrExchange();
    }

    private static void setUpMockData4test4getExpenseCurrencycreateinstancepatrCurrencyName() {
    }

    private static void setUpMockData4test4setExpenseCurrencycreateinstancepatrCurrencyName() {
        test4setExpenseCurrencycreateinstancepatrCurrencyNameArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencycreateinstancepatrCurrencyCode() {
    }

    private static void setUpMockData4test4setExpenseCurrencycreateinstancepatrCurrencyCode() {
        test4setExpenseCurrencycreateinstancepatrCurrencyCodeArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencycreateinstancepatrCurAcronym() {
    }

    private static void setUpMockData4test4setExpenseCurrencycreateinstancepatrCurAcronym() {
        test4setExpenseCurrencycreateinstancepatrCurAcronymArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencycreateinstancepatrExchange() {
    }

    private static void setUpMockData4test4setExpenseCurrencycreateinstancepatrExchange() {
        test4setExpenseCurrencycreateinstancepatrExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurrencyName(defValue4expenseCurrencycreateinstancepatrCurrencyName);
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurrencyCode(defValue4expenseCurrencycreateinstancepatrCurrencyCode);
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurAcronym(defValue4expenseCurrencycreateinstancepatrCurAcronym);
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrExchange(defValue4expenseCurrencycreateinstancepatrExchange);
    }

    @Test
    public void test4getExpenseCurrencycreateinstancepatrCurrencyName() {
        assertEquals(defValue4expenseCurrencycreateinstancepatrCurrencyName, instanceCreateinstanceRequest.getExpenseCurrencycreateinstancepatrCurrencyName());
    }

    @Test
    public void test4setExpenseCurrencycreateinstancepatrCurrencyName() {
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurrencyName(test4setExpenseCurrencycreateinstancepatrCurrencyNameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencycreateinstancepatrCurrencyCode() {
        assertEquals(defValue4expenseCurrencycreateinstancepatrCurrencyCode, instanceCreateinstanceRequest.getExpenseCurrencycreateinstancepatrCurrencyCode());
    }

    @Test
    public void test4setExpenseCurrencycreateinstancepatrCurrencyCode() {
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurrencyCode(test4setExpenseCurrencycreateinstancepatrCurrencyCodeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencycreateinstancepatrCurAcronym() {
        assertEquals(defValue4expenseCurrencycreateinstancepatrCurAcronym, instanceCreateinstanceRequest.getExpenseCurrencycreateinstancepatrCurAcronym());
    }

    @Test
    public void test4setExpenseCurrencycreateinstancepatrCurAcronym() {
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrCurAcronym(test4setExpenseCurrencycreateinstancepatrCurAcronymArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencycreateinstancepatrExchange() {
        assertEquals(defValue4expenseCurrencycreateinstancepatrExchange, instanceCreateinstanceRequest.getExpenseCurrencycreateinstancepatrExchange());
    }

    @Test
    public void test4setExpenseCurrencycreateinstancepatrExchange() {
        instanceCreateinstanceRequest.setExpenseCurrencycreateinstancepatrExchange(test4setExpenseCurrencycreateinstancepatrExchangeArg1);
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
