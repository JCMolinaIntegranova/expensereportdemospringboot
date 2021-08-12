package com.integranova.spring.expensereportdemo.viewmodel.team.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsByName;
import com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsWithCapacity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUTeamsRequestTest {

    private PIUTeamsRequest instancePIUTeamsRequest;

    // testGetFTeamsByName
    private static FTeamsByName testGetFTeamsByNameResult;

    // testGetFTeamsWithCapacity
    private static FTeamsWithCapacity testGetFTeamsWithCapacityResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFTeamsByName();
        setUpMockData4testGetFTeamsWithCapacity();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFTeamsByName() {
        testGetFTeamsByNameResult = null;
    }

    private static void setUpMockData4testGetFTeamsWithCapacity() {
        testGetFTeamsWithCapacityResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUTeamsRequest = new PIUTeamsRequest();
    }

    @Test
    public void testGetFTeamsByName() {
        assertEquals(testGetFTeamsByNameResult, instancePIUTeamsRequest.getFTeamsByName());
    }

    @Test
    public void testGetFTeamsWithCapacity() {
        assertEquals(testGetFTeamsWithCapacityResult, instancePIUTeamsRequest.getFTeamsWithCapacity());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUTeamsRequest.buildQueryRequest();
        assertNotNull(instancePIUTeamsRequest);
    }
}
