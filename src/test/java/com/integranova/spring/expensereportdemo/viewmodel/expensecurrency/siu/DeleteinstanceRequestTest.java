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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseCurrencydeleteinstancepthisExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseCurrencydeleteinstancepthisExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));


    // test4getExpenseCurrencydeleteinstancepthisExpenseCurrency

    // test4setExpenseCurrencydeleteinstancepthisExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseCurrencydeleteinstancepthisExpenseCurrencyArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencydeleteinstancepthisExpenseCurrency();
        setUpMockData4test4setExpenseCurrencydeleteinstancepthisExpenseCurrency();
    }

    private static void setUpMockData4test4getExpenseCurrencydeleteinstancepthisExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseCurrencydeleteinstancepthisExpenseCurrency() {
        test4setExpenseCurrencydeleteinstancepthisExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setExpenseCurrencydeleteinstancepthisExpenseCurrency(defValue4expenseCurrencydeleteinstancepthisExpenseCurrency);
        instanceDeleteinstanceRequest.setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(defValue4expenseCurrencydeleteinstancepthisExpenseCurrencyInstance);
    }

    @Test
    public void test4getExpenseCurrencydeleteinstancepthisExpenseCurrency() {
        assertEquals(defValue4expenseCurrencydeleteinstancepthisExpenseCurrency, instanceDeleteinstanceRequest.getExpenseCurrencydeleteinstancepthisExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrencydeleteinstancepthisExpenseCurrency() {
        instanceDeleteinstanceRequest.setExpenseCurrencydeleteinstancepthisExpenseCurrency(test4setExpenseCurrencydeleteinstancepthisExpenseCurrencyArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
