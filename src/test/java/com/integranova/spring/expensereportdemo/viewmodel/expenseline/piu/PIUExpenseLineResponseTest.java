package com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseLineResponseTest {

    private PIUExpenseLineResponse instancePIUExpenseLineResponse;

    // testPIUExpenseLineResponse

    // testPIUExpenseLineResponse2
    private static List<DSExpenseLine> testPIUExpenseLineResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseLine> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseLineResponse();
        setUpMockData4testPIUExpenseLineResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseLineResponse() {
    }

    private static void setUpMockData4testPIUExpenseLineResponse2() {
        testPIUExpenseLineResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseLineResponse = new PIUExpenseLineResponse();
    }

    @Test
    public void testPIUExpenseLineResponse() {
        instancePIUExpenseLineResponse = new PIUExpenseLineResponse();
        assertNotNull(instancePIUExpenseLineResponse);
    }

    @Test
    public void testPIUExpenseLineResponse2() {
        instancePIUExpenseLineResponse = new PIUExpenseLineResponse(testPIUExpenseLineResponse2Arg1);
        assertNotNull(instancePIUExpenseLineResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseLineResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseLineResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseLineResponse);
    }
}
