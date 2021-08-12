package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu;

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
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4exchangeHistorycreateinstancepagrExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4exchangeHistorycreateinstancepagrExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static Double defValue4exchangeHistorycreateinstancepatroldValue = Double.valueOf(0);
    private static Double defValue4exchangeHistorycreateinstancepatrnewValue = Double.valueOf(0);


    // test4getExchangeHistorycreateinstancepagrExpenseCurrency

    // test4setExchangeHistorycreateinstancepagrExpenseCurrency
    private static ExpenseCurrencyOid test4setExchangeHistorycreateinstancepagrExpenseCurrencyArg1;

    // test4getExchangeHistorycreateinstancepatroldValue

    // test4setExchangeHistorycreateinstancepatroldValue
    private static Double test4setExchangeHistorycreateinstancepatroldValueArg1;

    // test4getExchangeHistorycreateinstancepatrnewValue

    // test4setExchangeHistorycreateinstancepatrnewValue
    private static Double test4setExchangeHistorycreateinstancepatrnewValueArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExchangeHistorycreateinstancepagrExpenseCurrency();
        setUpMockData4test4setExchangeHistorycreateinstancepagrExpenseCurrency();
        setUpMockData4test4getExchangeHistorycreateinstancepatroldValue();
        setUpMockData4test4setExchangeHistorycreateinstancepatroldValue();
        setUpMockData4test4getExchangeHistorycreateinstancepatrnewValue();
        setUpMockData4test4setExchangeHistorycreateinstancepatrnewValue();
    }

    private static void setUpMockData4test4getExchangeHistorycreateinstancepagrExpenseCurrency() {
    }

    private static void setUpMockData4test4setExchangeHistorycreateinstancepagrExpenseCurrency() {
        test4setExchangeHistorycreateinstancepagrExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    private static void setUpMockData4test4getExchangeHistorycreateinstancepatroldValue() {
    }

    private static void setUpMockData4test4setExchangeHistorycreateinstancepatroldValue() {
        test4setExchangeHistorycreateinstancepatroldValueArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExchangeHistorycreateinstancepatrnewValue() {
    }

    private static void setUpMockData4test4setExchangeHistorycreateinstancepatrnewValue() {
        test4setExchangeHistorycreateinstancepatrnewValueArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepagrExpenseCurrency(defValue4exchangeHistorycreateinstancepagrExpenseCurrency);
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(defValue4exchangeHistorycreateinstancepagrExpenseCurrencyInstance);
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepatroldValue(defValue4exchangeHistorycreateinstancepatroldValue);
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepatrnewValue(defValue4exchangeHistorycreateinstancepatrnewValue);
    }

    @Test
    public void test4getExchangeHistorycreateinstancepagrExpenseCurrency() {
        assertEquals(defValue4exchangeHistorycreateinstancepagrExpenseCurrency, instanceCreateinstanceRequest.getExchangeHistorycreateinstancepagrExpenseCurrency());
    }

    @Test
    public void test4setExchangeHistorycreateinstancepagrExpenseCurrency() {
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepagrExpenseCurrency(test4setExchangeHistorycreateinstancepagrExpenseCurrencyArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExchangeHistorycreateinstancepatroldValue() {
        assertEquals(defValue4exchangeHistorycreateinstancepatroldValue, instanceCreateinstanceRequest.getExchangeHistorycreateinstancepatroldValue());
    }

    @Test
    public void test4setExchangeHistorycreateinstancepatroldValue() {
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepatroldValue(test4setExchangeHistorycreateinstancepatroldValueArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getExchangeHistorycreateinstancepatrnewValue() {
        assertEquals(defValue4exchangeHistorycreateinstancepatrnewValue, instanceCreateinstanceRequest.getExchangeHistorycreateinstancepatrnewValue());
    }

    @Test
    public void test4setExchangeHistorycreateinstancepatrnewValue() {
        instanceCreateinstanceRequest.setExchangeHistorycreateinstancepatrnewValue(test4setExchangeHistorycreateinstancepatrnewValueArg1);
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
