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
public class EditExchangeRequestTest {

    private EditExchangeRequest instanceEditExchangeRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseCurrencyeditExchangepthisExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseCurrencyeditExchangepthisExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static Double defValue4expenseCurrencyeditExchangepExchange = Double.valueOf(0);


    // test4getExpenseCurrencyeditExchangepthisExpenseCurrency

    // test4setExpenseCurrencyeditExchangepthisExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseCurrencyeditExchangepthisExpenseCurrencyArg1;

    // test4getExpenseCurrencyeditExchangepExchange

    // test4setExpenseCurrencyeditExchangepExchange
    private static Double test4setExpenseCurrencyeditExchangepExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencyeditExchangepthisExpenseCurrency();
        setUpMockData4test4setExpenseCurrencyeditExchangepthisExpenseCurrency();
        setUpMockData4test4getExpenseCurrencyeditExchangepExchange();
        setUpMockData4test4setExpenseCurrencyeditExchangepExchange();
    }

    private static void setUpMockData4test4getExpenseCurrencyeditExchangepthisExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditExchangepthisExpenseCurrency() {
        test4setExpenseCurrencyeditExchangepthisExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    private static void setUpMockData4test4getExpenseCurrencyeditExchangepExchange() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditExchangepExchange() {
        test4setExpenseCurrencyeditExchangepExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditExchangeRequest = new EditExchangeRequest();
        instanceEditExchangeRequest.setExpenseCurrencyeditExchangepthisExpenseCurrency(defValue4expenseCurrencyeditExchangepthisExpenseCurrency);
        instanceEditExchangeRequest.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(defValue4expenseCurrencyeditExchangepthisExpenseCurrencyInstance);
        instanceEditExchangeRequest.setExpenseCurrencyeditExchangepExchange(defValue4expenseCurrencyeditExchangepExchange);
    }

    @Test
    public void test4getExpenseCurrencyeditExchangepthisExpenseCurrency() {
        assertEquals(defValue4expenseCurrencyeditExchangepthisExpenseCurrency, instanceEditExchangeRequest.getExpenseCurrencyeditExchangepthisExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrencyeditExchangepthisExpenseCurrency() {
        instanceEditExchangeRequest.setExpenseCurrencyeditExchangepthisExpenseCurrency(test4setExpenseCurrencyeditExchangepthisExpenseCurrencyArg1);
        assertNotNull(instanceEditExchangeRequest);
    }

    @Test
    public void test4getExpenseCurrencyeditExchangepExchange() {
        assertEquals(defValue4expenseCurrencyeditExchangepExchange, instanceEditExchangeRequest.getExpenseCurrencyeditExchangepExchange());
    }

    @Test
    public void test4setExpenseCurrencyeditExchangepExchange() {
        instanceEditExchangeRequest.setExpenseCurrencyeditExchangepExchange(test4setExpenseCurrencyeditExchangepExchangeArg1);
        assertNotNull(instanceEditExchangeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditExchangeRequest = new EditExchangeRequest();
    	instanceEditExchangeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditExchangeRequest.checkArguments();
    }
}
