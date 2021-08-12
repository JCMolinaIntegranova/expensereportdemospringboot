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
public class PIUExpenseReportToEmployeeResponseTest {

    private PIUExpenseReportToEmployeeResponse instancePIUExpenseReportToEmployeeResponse;

    // testPIUExpenseReportToEmployeeResponse

    // testPIUExpenseReportToEmployeeResponse2
    private static List<DSExpenseReport4MD> testPIUExpenseReportToEmployeeResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSExpenseReport4MD> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUExpenseReportToEmployeeResponse();
        setUpMockData4testPIUExpenseReportToEmployeeResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUExpenseReportToEmployeeResponse() {
    }

    private static void setUpMockData4testPIUExpenseReportToEmployeeResponse2() {
        testPIUExpenseReportToEmployeeResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUExpenseReportToEmployeeResponse = new PIUExpenseReportToEmployeeResponse();
    }

    @Test
    public void testPIUExpenseReportToEmployeeResponse() {
        instancePIUExpenseReportToEmployeeResponse = new PIUExpenseReportToEmployeeResponse();
        assertNotNull(instancePIUExpenseReportToEmployeeResponse);
    }

    @Test
    public void testPIUExpenseReportToEmployeeResponse2() {
        instancePIUExpenseReportToEmployeeResponse = new PIUExpenseReportToEmployeeResponse(testPIUExpenseReportToEmployeeResponse2Arg1);
        assertNotNull(instancePIUExpenseReportToEmployeeResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUExpenseReportToEmployeeResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUExpenseReportToEmployeeResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUExpenseReportToEmployeeResponse);
    }
}
