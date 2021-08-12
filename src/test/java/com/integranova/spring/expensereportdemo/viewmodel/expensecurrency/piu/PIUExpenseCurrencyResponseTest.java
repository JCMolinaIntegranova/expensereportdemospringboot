package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseCurrencyResponseTest {

    private PIUExpenseCurrencyResponse instancePIUExpenseCurrencyResponse;

    // testPIUExpenseCurrencyResponse

    // testPIUExpenseCurrencyResponse2
    private static List<DSExpenseCurrency> testPIUExpenseCurrencyResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseCurrency> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseCurrencyResponse();
        setUpMockData4testPIUExpenseCurrencyResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseCurrencyResponse() {
    }

    private static void setUpMockData4testPIUExpenseCurrencyResponse2() {
        testPIUExpenseCurrencyResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseCurrencyResponse = new PIUExpenseCurrencyResponse();
    }

    @Test
    public void testPIUExpenseCurrencyResponse() {
        instancePIUExpenseCurrencyResponse = new PIUExpenseCurrencyResponse();
        assertNotNull(instancePIUExpenseCurrencyResponse);
    }

    @Test
    public void testPIUExpenseCurrencyResponse2() {
        instancePIUExpenseCurrencyResponse = new PIUExpenseCurrencyResponse(testPIUExpenseCurrencyResponse2Arg1);
        assertNotNull(instancePIUExpenseCurrencyResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseCurrencyResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseCurrencyResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseCurrencyResponse);
    }
}
