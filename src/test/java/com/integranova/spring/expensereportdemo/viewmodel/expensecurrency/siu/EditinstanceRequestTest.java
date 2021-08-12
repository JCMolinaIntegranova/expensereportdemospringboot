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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseCurrencyeditinstancepthisExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseCurrencyeditinstancepthisExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static String defValue4expenseCurrencyeditinstancepCurrencyName = "";
    private static String defValue4expenseCurrencyeditinstancepCurAcronym = "";
    private static Double defValue4expenseCurrencyeditinstancepExchange = Double.valueOf(0);


    // test4getExpenseCurrencyeditinstancepthisExpenseCurrency

    // test4setExpenseCurrencyeditinstancepthisExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseCurrencyeditinstancepthisExpenseCurrencyArg1;

    // test4getExpenseCurrencyeditinstancepCurrencyName

    // test4setExpenseCurrencyeditinstancepCurrencyName
    private static String test4setExpenseCurrencyeditinstancepCurrencyNameArg1;

    // test4getExpenseCurrencyeditinstancepCurAcronym

    // test4setExpenseCurrencyeditinstancepCurAcronym
    private static String test4setExpenseCurrencyeditinstancepCurAcronymArg1;

    // test4getExpenseCurrencyeditinstancepExchange

    // test4setExpenseCurrencyeditinstancepExchange
    private static Double test4setExpenseCurrencyeditinstancepExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseCurrencyeditinstancepthisExpenseCurrency();
        setUpMockData4test4setExpenseCurrencyeditinstancepthisExpenseCurrency();
        setUpMockData4test4getExpenseCurrencyeditinstancepCurrencyName();
        setUpMockData4test4setExpenseCurrencyeditinstancepCurrencyName();
        setUpMockData4test4getExpenseCurrencyeditinstancepCurAcronym();
        setUpMockData4test4setExpenseCurrencyeditinstancepCurAcronym();
        setUpMockData4test4getExpenseCurrencyeditinstancepExchange();
        setUpMockData4test4setExpenseCurrencyeditinstancepExchange();
    }

    private static void setUpMockData4test4getExpenseCurrencyeditinstancepthisExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditinstancepthisExpenseCurrency() {
        test4setExpenseCurrencyeditinstancepthisExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    private static void setUpMockData4test4getExpenseCurrencyeditinstancepCurrencyName() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditinstancepCurrencyName() {
        test4setExpenseCurrencyeditinstancepCurrencyNameArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencyeditinstancepCurAcronym() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditinstancepCurAcronym() {
        test4setExpenseCurrencyeditinstancepCurAcronymArg1 = "";
    }

    private static void setUpMockData4test4getExpenseCurrencyeditinstancepExchange() {
    }

    private static void setUpMockData4test4setExpenseCurrencyeditinstancepExchange() {
        test4setExpenseCurrencyeditinstancepExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepthisExpenseCurrency(defValue4expenseCurrencyeditinstancepthisExpenseCurrency);
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(defValue4expenseCurrencyeditinstancepthisExpenseCurrencyInstance);
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepCurrencyName(defValue4expenseCurrencyeditinstancepCurrencyName);
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepCurAcronym(defValue4expenseCurrencyeditinstancepCurAcronym);
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepExchange(defValue4expenseCurrencyeditinstancepExchange);
    }

    @Test
    public void test4getExpenseCurrencyeditinstancepthisExpenseCurrency() {
        assertEquals(defValue4expenseCurrencyeditinstancepthisExpenseCurrency, instanceEditinstanceRequest.getExpenseCurrencyeditinstancepthisExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrencyeditinstancepthisExpenseCurrency() {
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepthisExpenseCurrency(test4setExpenseCurrencyeditinstancepthisExpenseCurrencyArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencyeditinstancepCurrencyName() {
        assertEquals(defValue4expenseCurrencyeditinstancepCurrencyName, instanceEditinstanceRequest.getExpenseCurrencyeditinstancepCurrencyName());
    }

    @Test
    public void test4setExpenseCurrencyeditinstancepCurrencyName() {
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepCurrencyName(test4setExpenseCurrencyeditinstancepCurrencyNameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencyeditinstancepCurAcronym() {
        assertEquals(defValue4expenseCurrencyeditinstancepCurAcronym, instanceEditinstanceRequest.getExpenseCurrencyeditinstancepCurAcronym());
    }

    @Test
    public void test4setExpenseCurrencyeditinstancepCurAcronym() {
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepCurAcronym(test4setExpenseCurrencyeditinstancepCurAcronymArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExpenseCurrencyeditinstancepExchange() {
        assertEquals(defValue4expenseCurrencyeditinstancepExchange, instanceEditinstanceRequest.getExpenseCurrencyeditinstancepExchange());
    }

    @Test
    public void test4setExpenseCurrencyeditinstancepExchange() {
        instanceEditinstanceRequest.setExpenseCurrencyeditinstancepExchange(test4setExpenseCurrencyeditinstancepExchangeArg1);
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
