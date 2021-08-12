package com.integranova.spring.expensereportdemo.viewmodel.expensetype.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseTypeResponseTest {

    private PIUExpenseTypeResponse instancePIUExpenseTypeResponse;

    // testPIUExpenseTypeResponse

    // testPIUExpenseTypeResponse2
    private static List<DSExpenseType> testPIUExpenseTypeResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseType> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseTypeResponse();
        setUpMockData4testPIUExpenseTypeResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseTypeResponse() {
    }

    private static void setUpMockData4testPIUExpenseTypeResponse2() {
        testPIUExpenseTypeResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseTypeResponse = new PIUExpenseTypeResponse();
    }

    @Test
    public void testPIUExpenseTypeResponse() {
        instancePIUExpenseTypeResponse = new PIUExpenseTypeResponse();
        assertNotNull(instancePIUExpenseTypeResponse);
    }

    @Test
    public void testPIUExpenseTypeResponse2() {
        instancePIUExpenseTypeResponse = new PIUExpenseTypeResponse(testPIUExpenseTypeResponse2Arg1);
        assertNotNull(instancePIUExpenseTypeResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseTypeResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseTypeResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseTypeResponse);
    }
}
