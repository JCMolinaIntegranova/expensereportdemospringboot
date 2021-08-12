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
public class DSExpenseCurrencySupTest {

    private DSExpenseCurrencySup instanceDSExpenseCurrencySup;

    // testDSExpenseCurrencySup
    private static ExpenseCurrency testDSExpenseCurrencySupArg1;

    // testDSExpenseCurrencySup2
    private static ExpenseCurrency testDSExpenseCurrencySup2Arg1;

    // testgetDSExpenseCurrencySupCurAcronym

    // testsetDSExpenseCurrencySupCurAcronym
    private static String testsetDSExpenseCurrencySupCurAcronymArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseCurrencySup();
        setUpMockData4testDSExpenseCurrencySup2();
        setUpMockData4testgetDSExpenseCurrencySupCurAcronym();
        setUpMockData4testsetDSExpenseCurrencySupCurAcronym();
    }

    private static void setUpMockData4testDSExpenseCurrencySup() {
        testDSExpenseCurrencySupArg1 = new ExpenseCurrency();
    }

    private static void setUpMockData4testDSExpenseCurrencySup2() {
        testDSExpenseCurrencySup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseCurrencySupCurAcronym() {
    }

    private static void setUpMockData4testsetDSExpenseCurrencySupCurAcronym() {
        testsetDSExpenseCurrencySupCurAcronymArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSExpenseCurrencySup = new DSExpenseCurrencySup();
        instanceDSExpenseCurrencySup.setDSExpenseCurrencySupCurAcronym("");
    }

    @Test
    public void testDSExpenseCurrencySup() {
        instanceDSExpenseCurrencySup = new DSExpenseCurrencySup(testDSExpenseCurrencySupArg1);
        assertNotNull(instanceDSExpenseCurrencySup);
    }

    @Test
    public void testDSExpenseCurrencySup2() {
        instanceDSExpenseCurrencySup = new DSExpenseCurrencySup(testDSExpenseCurrencySup2Arg1);
        assertNotNull(instanceDSExpenseCurrencySup);
    }

    @Test
    public void testgetDSExpenseCurrencySupCurAcronym() {
        assertEquals("", instanceDSExpenseCurrencySup.getDSExpenseCurrencySupCurAcronym());
    }

    @Test
    public void testsetDSExpenseCurrencySupCurAcronym() {
        instanceDSExpenseCurrencySup.setDSExpenseCurrencySupCurAcronym(testsetDSExpenseCurrencySupCurAcronymArg1);
        assertNotNull(instanceDSExpenseCurrencySup);
    }
}
