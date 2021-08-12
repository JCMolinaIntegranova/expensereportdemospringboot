package com.integranova.spring.expensereportdemo.viewmodel.team.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUTeamsResponseTest {

    private PIUTeamsResponse instancePIUTeamsResponse;

    // testPIUTeamsResponse

    // testPIUTeamsResponse2
    private static List<DSTeams> testPIUTeamsResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSTeams> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUTeamsResponse();
        setUpMockData4testPIUTeamsResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUTeamsResponse() {
    }

    private static void setUpMockData4testPIUTeamsResponse2() {
        testPIUTeamsResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUTeamsResponse = new PIUTeamsResponse();
    }

    @Test
    public void testPIUTeamsResponse() {
        instancePIUTeamsResponse = new PIUTeamsResponse();
        assertNotNull(instancePIUTeamsResponse);
    }

    @Test
    public void testPIUTeamsResponse2() {
        instancePIUTeamsResponse = new PIUTeamsResponse(testPIUTeamsResponse2Arg1);
        assertNotNull(instancePIUTeamsResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUTeamsResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUTeamsResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUTeamsResponse);
    }
}
