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
public class SELProjectResponseTest {

    private SELProjectResponse instanceSELProjectResponse;

    // testSELProjectResponse

    // testSELProjectResponse2
    private static List<DSProject> testSELProjectResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSProject> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testSELProjectResponse();
        setUpMockData4testSELProjectResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testSELProjectResponse() {
    }

    private static void setUpMockData4testSELProjectResponse2() {
        testSELProjectResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instanceSELProjectResponse = new SELProjectResponse();
    }

    @Test
    public void testSELProjectResponse() {
        instanceSELProjectResponse = new SELProjectResponse();
        assertNotNull(instanceSELProjectResponse);
    }

    @Test
    public void testSELProjectResponse2() {
        instanceSELProjectResponse = new SELProjectResponse(testSELProjectResponse2Arg1);
        assertNotNull(instanceSELProjectResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instanceSELProjectResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instanceSELProjectResponse.setResults(testSetResultsArg1);
        assertNotNull(instanceSELProjectResponse);
    }
}
