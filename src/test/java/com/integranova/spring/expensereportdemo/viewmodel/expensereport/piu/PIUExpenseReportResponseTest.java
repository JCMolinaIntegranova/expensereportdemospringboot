package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseReportResponseTest {

    private PIUExpenseReportResponse instancePIUExpenseReportResponse;

    // testPIUExpenseReportResponse

    // testPIUExpenseReportResponse2
    private static List<DSExpenseReport4HAT> testPIUExpenseReportResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseReport4HAT> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseReportResponse();
        setUpMockData4testPIUExpenseReportResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseReportResponse() {
    }

    private static void setUpMockData4testPIUExpenseReportResponse2() {
        testPIUExpenseReportResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseReportResponse = new PIUExpenseReportResponse();
    }

    @Test
    public void testPIUExpenseReportResponse() {
        instancePIUExpenseReportResponse = new PIUExpenseReportResponse();
        assertNotNull(instancePIUExpenseReportResponse);
    }

    @Test
    public void testPIUExpenseReportResponse2() {
        instancePIUExpenseReportResponse = new PIUExpenseReportResponse(testPIUExpenseReportResponse2Arg1);
        assertNotNull(instancePIUExpenseReportResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseReportResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseReportResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseReportResponse);
    }
}
