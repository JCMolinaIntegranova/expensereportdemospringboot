package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUPaymentTypeResponseTest {

    private PIUPaymentTypeResponse instancePIUPaymentTypeResponse;

    // testPIUPaymentTypeResponse

    // testPIUPaymentTypeResponse2
    private static List<DSPaymentType> testPIUPaymentTypeResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSPaymentType> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUPaymentTypeResponse();
        setUpMockData4testPIUPaymentTypeResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUPaymentTypeResponse() {
    }

    private static void setUpMockData4testPIUPaymentTypeResponse2() {
        testPIUPaymentTypeResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUPaymentTypeResponse = new PIUPaymentTypeResponse();
    }

    @Test
    public void testPIUPaymentTypeResponse() {
        instancePIUPaymentTypeResponse = new PIUPaymentTypeResponse();
        assertNotNull(instancePIUPaymentTypeResponse);
    }

    @Test
    public void testPIUPaymentTypeResponse2() {
        instancePIUPaymentTypeResponse = new PIUPaymentTypeResponse(testPIUPaymentTypeResponse2Arg1);
        assertNotNull(instancePIUPaymentTypeResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUPaymentTypeResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUPaymentTypeResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUPaymentTypeResponse);
    }
}
