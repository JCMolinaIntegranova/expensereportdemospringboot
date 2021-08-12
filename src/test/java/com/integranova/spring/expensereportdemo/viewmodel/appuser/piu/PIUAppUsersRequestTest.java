package com.integranova.spring.expensereportdemo.viewmodel.appuser.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.appuser.filter.FAppUsers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUAppUsersRequestTest {

    private PIUAppUsersRequest instancePIUAppUsersRequest;

    // testGetFAppUsers
    private static FAppUsers testGetFAppUsersResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFAppUsers();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFAppUsers() {
        testGetFAppUsersResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUAppUsersRequest = new PIUAppUsersRequest();
    }

    @Test
    public void testGetFAppUsers() {
        assertEquals(testGetFAppUsersResult, instancePIUAppUsersRequest.getFAppUsers());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUAppUsersRequest.buildQueryRequest();
        assertNotNull(instancePIUAppUsersRequest);
    }
}
