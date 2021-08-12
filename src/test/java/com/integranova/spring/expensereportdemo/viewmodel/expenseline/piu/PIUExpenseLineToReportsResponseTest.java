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
public class PIUExpenseLineToReportsResponseTest {

    private PIUExpenseLineToReportsResponse instancePIUExpenseLineToReportsResponse;

    // testPIUExpenseLineToReportsResponse

    // testPIUExpenseLineToReportsResponse2
    private static List<DSExpenseLine> testPIUExpenseLineToReportsResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseLine> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseLineToReportsResponse();
        setUpMockData4testPIUExpenseLineToReportsResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseLineToReportsResponse() {
    }

    private static void setUpMockData4testPIUExpenseLineToReportsResponse2() {
        testPIUExpenseLineToReportsResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseLineToReportsResponse = new PIUExpenseLineToReportsResponse();
    }

    @Test
    public void testPIUExpenseLineToReportsResponse() {
        instancePIUExpenseLineToReportsResponse = new PIUExpenseLineToReportsResponse();
        assertNotNull(instancePIUExpenseLineToReportsResponse);
    }

    @Test
    public void testPIUExpenseLineToReportsResponse2() {
        instancePIUExpenseLineToReportsResponse = new PIUExpenseLineToReportsResponse(testPIUExpenseLineToReportsResponse2Arg1);
        assertNotNull(instancePIUExpenseLineToReportsResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseLineToReportsResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseLineToReportsResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseLineToReportsResponse);
    }
}
