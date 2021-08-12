package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSExpenseCurrencyTest {

    private DSExpenseCurrency instanceDSExpenseCurrency;

    // testDSExpenseCurrency
    private static ExpenseCurrency testDSExpenseCurrencyArg1;

    // testDSExpenseCurrency2
    private static ExpenseCurrency testDSExpenseCurrency2Arg1;

    // testgetDSExpenseCurrencyCurrencyCode

    // testsetDSExpenseCurrencyCurrencyCode
    private static String testsetDSExpenseCurrencyCurrencyCodeArg1;

    // testgetDSExpenseCurrencyCurAcronym

    // testsetDSExpenseCurrencyCurAcronym
    private static String testsetDSExpenseCurrencyCurAcronymArg1;

    // testgetDSExpenseCurrencyCurrencyName

    // testsetDSExpenseCurrencyCurrencyName
    private static String testsetDSExpenseCurrencyCurrencyNameArg1;

    // testgetDSExpenseCurrencyExchange

    // testsetDSExpenseCurrencyExchange
    private static Double testsetDSExpenseCurrencyExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseCurrency();
        setUpMockData4testDSExpenseCurrency2();
        setUpMockData4testgetDSExpenseCurrencyCurrencyCode();
        setUpMockData4testsetDSExpenseCurrencyCurrencyCode();
        setUpMockData4testgetDSExpenseCurrencyCurAcronym();
        setUpMockData4testsetDSExpenseCurrencyCurAcronym();
        setUpMockData4testgetDSExpenseCurrencyCurrencyName();
        setUpMockData4testsetDSExpenseCurrencyCurrencyName();
        setUpMockData4testgetDSExpenseCurrencyExchange();
        setUpMockData4testsetDSExpenseCurrencyExchange();
    }

    private static void setUpMockData4testDSExpenseCurrency() {
        testDSExpenseCurrencyArg1 = new ExpenseCurrency();
    }

    private static void setUpMockData4testDSExpenseCurrency2() {
        testDSExpenseCurrency2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseCurrencyCurrencyCode() {
    }

    private static void setUpMockData4testsetDSExpenseCurrencyCurrencyCode() {
        testsetDSExpenseCurrencyCurrencyCodeArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseCurrencyCurAcronym() {
    }

    private static void setUpMockData4testsetDSExpenseCurrencyCurAcronym() {
        testsetDSExpenseCurrencyCurAcronymArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseCurrencyCurrencyName() {
    }

    private static void setUpMockData4testsetDSExpenseCurrencyCurrencyName() {
        testsetDSExpenseCurrencyCurrencyNameArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseCurrencyExchange() {
    }

    private static void setUpMockData4testsetDSExpenseCurrencyExchange() {
        testsetDSExpenseCurrencyExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSExpenseCurrency = new DSExpenseCurrency();
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurrencyCode("");
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurAcronym("");
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurrencyName("");
        instanceDSExpenseCurrency.setDSExpenseCurrencyExchange(Double.valueOf(0));
    }

    @Test
    public void testDSExpenseCurrency() {
        instanceDSExpenseCurrency = new DSExpenseCurrency(testDSExpenseCurrencyArg1);
        assertNotNull(instanceDSExpenseCurrency);
    }

    @Test
    public void testDSExpenseCurrency2() {
        instanceDSExpenseCurrency = new DSExpenseCurrency(testDSExpenseCurrency2Arg1);
        assertNotNull(instanceDSExpenseCurrency);
    }

    @Test
    public void testgetDSExpenseCurrencyCurrencyCode() {
        assertEquals("", instanceDSExpenseCurrency.getDSExpenseCurrencyCurrencyCode());
    }

    @Test
    public void testsetDSExpenseCurrencyCurrencyCode() {
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurrencyCode(testsetDSExpenseCurrencyCurrencyCodeArg1);
        assertNotNull(instanceDSExpenseCurrency);
    }

    @Test
    public void testgetDSExpenseCurrencyCurAcronym() {
        assertEquals("", instanceDSExpenseCurrency.getDSExpenseCurrencyCurAcronym());
    }

    @Test
    public void testsetDSExpenseCurrencyCurAcronym() {
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurAcronym(testsetDSExpenseCurrencyCurAcronymArg1);
        assertNotNull(instanceDSExpenseCurrency);
    }

    @Test
    public void testgetDSExpenseCurrencyCurrencyName() {
        assertEquals("", instanceDSExpenseCurrency.getDSExpenseCurrencyCurrencyName());
    }

    @Test
    public void testsetDSExpenseCurrencyCurrencyName() {
        instanceDSExpenseCurrency.setDSExpenseCurrencyCurrencyName(testsetDSExpenseCurrencyCurrencyNameArg1);
        assertNotNull(instanceDSExpenseCurrency);
    }

    @Test
    public void testgetDSExpenseCurrencyExchange() {
        assertEquals(Double.valueOf(0), instanceDSExpenseCurrency.getDSExpenseCurrencyExchange());
    }

    @Test
    public void testsetDSExpenseCurrencyExchange() {
        instanceDSExpenseCurrency.setDSExpenseCurrencyExchange(testsetDSExpenseCurrencyExchangeArg1);
        assertNotNull(instanceDSExpenseCurrency);
    }
}
