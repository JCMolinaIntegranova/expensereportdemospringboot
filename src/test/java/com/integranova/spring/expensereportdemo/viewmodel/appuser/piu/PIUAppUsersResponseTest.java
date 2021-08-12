package com.integranova.spring.expensereportdemo.viewmodel.appuser.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUAppUsersResponseTest {

    private PIUAppUsersResponse instancePIUAppUsersResponse;

    // testPIUAppUsersResponse

    // testPIUAppUsersResponse2
    private static List<DSAppUsers> testPIUAppUsersResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSAppUsers> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUAppUsersResponse();
        setUpMockData4testPIUAppUsersResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUAppUsersResponse() {
    }

    private static void setUpMockData4testPIUAppUsersResponse2() {
        testPIUAppUsersResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUAppUsersResponse = new PIUAppUsersResponse();
    }

    @Test
    public void testPIUAppUsersResponse() {
        instancePIUAppUsersResponse = new PIUAppUsersResponse();
        assertNotNull(instancePIUAppUsersResponse);
    }

    @Test
    public void testPIUAppUsersResponse2() {
        instancePIUAppUsersResponse = new PIUAppUsersResponse(testPIUAppUsersResponse2Arg1);
        assertNotNull(instancePIUAppUsersResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUAppUsersResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUAppUsersResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUAppUsersResponse);
    }
}
