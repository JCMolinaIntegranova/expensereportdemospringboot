package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TEDITEXCHANGERequestTest {

    private TEDITEXCHANGERequest instanceTEDITEXCHANGERequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static Double defValue4expenseCurrencyTEDITEXCHANGEpExchange = Double.valueOf(0);


    // test4getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency

    // test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyArg1;

    // test4getExpenseCurrencyTEDITEXCHANGEpExchange

    // test4setExpenseCurrencyTEDITEXCHANGEpExchange
    private static Double test4setExpenseCurrencyTEDITEXCHANGEpExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency();
        setUpMockData4test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency();
        setUpMockData4test4getExpenseCurrencyTEDITEXCHANGEpExchange();
        setUpMockData4test4setExpenseCurrencyTEDITEXCHANGEpExchange();
    }

    private static void setUpMockData4test4getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() {
        test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    private static void setUpMockData4test4getExpenseCurrencyTEDITEXCHANGEpExchange() {
    }

    private static void setUpMockData4test4setExpenseCurrencyTEDITEXCHANGEpExchange() {
        test4setExpenseCurrencyTEDITEXCHANGEpExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceTEDITEXCHANGERequest = new TEDITEXCHANGERequest();
        instanceTEDITEXCHANGERequest.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(defValue4expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency);
        instanceTEDITEXCHANGERequest.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(defValue4expenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance);
        instanceTEDITEXCHANGERequest.setExpenseCurrencyTEDITEXCHANGEpExchange(defValue4expenseCurrencyTEDITEXCHANGEpExchange);
    }

    @Test
    public void test4getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() {
        assertEquals(defValue4expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency, instanceTEDITEXCHANGERequest.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() {
        instanceTEDITEXCHANGERequest.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(test4setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyArg1);
        assertNotNull(instanceTEDITEXCHANGERequest);
    }

    @Test
    public void test4getExpenseCurrencyTEDITEXCHANGEpExchange() {
        assertEquals(defValue4expenseCurrencyTEDITEXCHANGEpExchange, instanceTEDITEXCHANGERequest.getExpenseCurrencyTEDITEXCHANGEpExchange());
    }

    @Test
    public void test4setExpenseCurrencyTEDITEXCHANGEpExchange() {
        instanceTEDITEXCHANGERequest.setExpenseCurrencyTEDITEXCHANGEpExchange(test4setExpenseCurrencyTEDITEXCHANGEpExchangeArg1);
        assertNotNull(instanceTEDITEXCHANGERequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTEDITEXCHANGERequest = new TEDITEXCHANGERequest();
    	instanceTEDITEXCHANGERequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTEDITEXCHANGERequest.checkArguments();
    }
}
