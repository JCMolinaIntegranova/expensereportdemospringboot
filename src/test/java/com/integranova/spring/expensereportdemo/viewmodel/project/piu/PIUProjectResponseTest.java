package com.integranova.spring.expensereportdemo.viewmodel.project.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUProjectResponseTest {

    private PIUProjectResponse instancePIUProjectResponse;

    // testPIUProjectResponse

    // testPIUProjectResponse2
    private static List<DSProject> testPIUProjectResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSProject> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUProjectResponse();
        setUpMockData4testPIUProjectResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUProjectResponse() {
    }

    private static void setUpMockData4testPIUProjectResponse2() {
        testPIUProjectResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUProjectResponse = new PIUProjectResponse();
    }

    @Test
    public void testPIUProjectResponse() {
        instancePIUProjectResponse = new PIUProjectResponse();
        assertNotNull(instancePIUProjectResponse);
    }

    @Test
    public void testPIUProjectResponse2() {
        instancePIUProjectResponse = new PIUProjectResponse(testPIUProjectResponse2Arg1);
        assertNotNull(instancePIUProjectResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUProjectResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUProjectResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUProjectResponse);
    }
}
