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
public class ResetExchangeRequestTest {

    private ResetExchangeRequest instanceResetExchangeRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseCurrencyresetExchangepthisExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseCurrencyresetExchangepthisExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));


    // test4getExpenseCurrencyresetExchangepthisExpenseCurrency

    // test4setExpenseCurrencyresetExchangepthisExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseCurrencyresetExchangepthisExpenseCurrencyArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencyresetExchangepthisExpenseCurrency();
        setUpMockData4test4setExpenseCurrencyresetExchangepthisExpenseCurrency();
    }

    private static void setUpMockData4test4getExpenseCurrencyresetExchangepthisExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseCurrencyresetExchangepthisExpenseCurrency() {
        test4setExpenseCurrencyresetExchangepthisExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    @Before
    public void setUp() {
        instanceResetExchangeRequest = new ResetExchangeRequest();
        instanceResetExchangeRequest.setExpenseCurrencyresetExchangepthisExpenseCurrency(defValue4expenseCurrencyresetExchangepthisExpenseCurrency);
        instanceResetExchangeRequest.setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(defValue4expenseCurrencyresetExchangepthisExpenseCurrencyInstance);
    }

    @Test
    public void test4getExpenseCurrencyresetExchangepthisExpenseCurrency() {
        assertEquals(defValue4expenseCurrencyresetExchangepthisExpenseCurrency, instanceResetExchangeRequest.getExpenseCurrencyresetExchangepthisExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrencyresetExchangepthisExpenseCurrency() {
        instanceResetExchangeRequest.setExpenseCurrencyresetExchangepthisExpenseCurrency(test4setExpenseCurrencyresetExchangepthisExpenseCurrencyArg1);
        assertNotNull(instanceResetExchangeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceResetExchangeRequest = new ResetExchangeRequest();
    	instanceResetExchangeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceResetExchangeRequest.checkArguments();
    }
}
