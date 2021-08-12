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
public class TNEWRequestTest {

    private TNEWRequest instanceTNEWRequest;

    // Default values
    private static String defValue4expenseCurrencyTNEWpCurrencyName = "";
    private static String defValue4expenseCurrencyTNEWpCurrencyCode = "";
    private static String defValue4expenseCurrencyTNEWpCurAcronym = "";
    private static Double defValue4expenseCurrencyTNEWpExchange = Double.valueOf(0);


    // test4getExpenseCurrencyTNEWpCurrencyName

    // test4setExpenseCurrencyTNEWpCurrencyName
    private static String test4setExpenseCurrencyTNEWpCurrencyNameArg1;

    // test4getExpenseCurrencyTNEWpCurrencyCode

    // test4setExpenseCurrencyTNEWpCurrencyCode
    private static String test4setExpenseCurrencyTNEWpCurrencyCodeArg1;

    // test4getExpenseCurrencyTNEWpCurAcronym

    // test4setExpenseCurrencyTNEWpCurAcronym
    private static String test4setExpenseCurrencyTNEWpCurAcronymArg1;

    // test4getExpenseCurrencyTNEWpExchange

    // test4setExpenseCurrencyTNEWpExchange
    private static Double test4setExpenseCurrencyTNEWpExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencyTNEWpCurrencyName();
        setUpMockData4test4setExpenseCurrencyTNEWpCurrencyName();
        setUpMockData4test4getExpenseCurrencyTNEWpCurrencyCode();
        setUpMockData4test4setExpenseCurrencyTNEWpCurrencyCode();
        setUpMockData4test4getExpenseCurrencyTNEWpCurAcronym();
        setUpMockData4test4setExpenseCurrencyTNEWpCurAcronym();
        setUpMockData4test4getExpenseCurrencyTNEWpExchange();
        setUpMockData4test4setExpenseCurrencyTNEWpExchange();
    }

    private static void setUpMockData4test4getExpenseCurrencyTNEWpCurrencyName() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTNEWpCurrencyName() {
        test4setExpenseCurrencyTNEWpCurrencyNameArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencyTNEWpCurrencyCode() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTNEWpCurrencyCode() {
        test4setExpenseCurrencyTNEWpCurrencyCodeArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencyTNEWpCurAcronym() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTNEWpCurAcronym() {
        test4setExpenseCurrencyTNEWpCurAcronymArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencyTNEWpExchange() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTNEWpExchange() {
        test4setExpenseCurrencyTNEWpExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceTNEWRequest = new TNEWRequest();
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurrencyName(defValue4expenseCurrencyTNEWpCurrencyName);
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurrencyCode(defValue4expenseCurrencyTNEWpCurrencyCode);
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurAcronym(defValue4expenseCurrencyTNEWpCurAcronym);
        instanceTNEWRequest.setExpenseCurrencyTNEWpExchange(defValue4expenseCurrencyTNEWpExchange);
    }

    @Test
    public void test4getExpenseCurrencyTNEWpCurrencyName() {
        assertEquals(defValue4expenseCurrencyTNEWpCurrencyName, instanceTNEWRequest.getExpenseCurrencyTNEWpCurrencyName());
    }

    @Test
    public void test4setExpenseCurrencyTNEWpCurrencyName() {
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurrencyName(test4setExpenseCurrencyTNEWpCurrencyNameArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseCurrencyTNEWpCurrencyCode() {
        assertEquals(defValue4expenseCurrencyTNEWpCurrencyCode, instanceTNEWRequest.getExpenseCurrencyTNEWpCurrencyCode());
    }

    @Test
    public void test4setExpenseCurrencyTNEWpCurrencyCode() {
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurrencyCode(test4setExpenseCurrencyTNEWpCurrencyCodeArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseCurrencyTNEWpCurAcronym() {
        assertEquals(defValue4expenseCurrencyTNEWpCurAcronym, instanceTNEWRequest.getExpenseCurrencyTNEWpCurAcronym());
    }

    @Test
    public void test4setExpenseCurrencyTNEWpCurAcronym() {
        instanceTNEWRequest.setExpenseCurrencyTNEWpCurAcronym(test4setExpenseCurrencyTNEWpCurAcronymArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseCurrencyTNEWpExchange() {
        assertEquals(defValue4expenseCurrencyTNEWpExchange, instanceTNEWRequest.getExpenseCurrencyTNEWpExchange());
    }

    @Test
    public void test4setExpenseCurrencyTNEWpExchange() {
        instanceTNEWRequest.setExpenseCurrencyTNEWpExchange(test4setExpenseCurrencyTNEWpExchangeArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTNEWRequest = new TNEWRequest();
    	instanceTNEWRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTNEWRequest.checkArguments();
    }
}
