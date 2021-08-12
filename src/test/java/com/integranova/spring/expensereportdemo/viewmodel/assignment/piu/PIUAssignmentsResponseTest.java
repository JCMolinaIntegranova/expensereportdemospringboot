package com.integranova.spring.expensereportdemo.viewmodel.assignment.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUAssignmentsResponseTest {

    private PIUAssignmentsResponse instancePIUAssignmentsResponse;

    // testPIUAssignmentsResponse

    // testPIUAssignmentsResponse2
    private static List<DSAssignments> testPIUAssignmentsResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSAssignments> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUAssignmentsResponse();
        setUpMockData4testPIUAssignmentsResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUAssignmentsResponse() {
    }

    private static void setUpMockData4testPIUAssignmentsResponse2() {
        testPIUAssignmentsResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUAssignmentsResponse = new PIUAssignmentsResponse();
    }

    @Test
    public void testPIUAssignmentsResponse() {
        instancePIUAssignmentsResponse = new PIUAssignmentsResponse();
        assertNotNull(instancePIUAssignmentsResponse);
    }

    @Test
    public void testPIUAssignmentsResponse2() {
        instancePIUAssignmentsResponse = new PIUAssignmentsResponse(testPIUAssignmentsResponse2Arg1);
        assertNotNull(instancePIUAssignmentsResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUAssignmentsResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUAssignmentsResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUAssignmentsResponse);
    }
}
