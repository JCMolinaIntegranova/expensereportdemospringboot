package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUExpenseReportProjectResponseTest {

    private PIUExpenseReportProjectResponse instancePIUExpenseReportProjectResponse;

    // testPIUExpenseReportProjectResponse

    // testPIUExpenseReportProjectResponse2
    private static List<DSExpenseReport4MD> testPIUExpenseReportProjectResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseReport4MD> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseReportProjectResponse();
        setUpMockData4testPIUExpenseReportProjectResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseReportProjectResponse() {
    }

    private static void setUpMockData4testPIUExpenseReportProjectResponse2() {
        testPIUExpenseReportProjectResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseReportProjectResponse = new PIUExpenseReportProjectResponse();
    }

    @Test
    public void testPIUExpenseReportProjectResponse() {
        instancePIUExpenseReportProjectResponse = new PIUExpenseReportProjectResponse();
        assertNotNull(instancePIUExpenseReportProjectResponse);
    }

    @Test
    public void testPIUExpenseReportProjectResponse2() {
        instancePIUExpenseReportProjectResponse = new PIUExpenseReportProjectResponse(testPIUExpenseReportProjectResponse2Arg1);
        assertNotNull(instancePIUExpenseReportProjectResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseReportProjectResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseReportProjectResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseReportProjectResponse);
    }
}
