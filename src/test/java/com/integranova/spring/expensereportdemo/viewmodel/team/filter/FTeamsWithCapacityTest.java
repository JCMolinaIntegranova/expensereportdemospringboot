package com.integranova.spring.expensereportdemo.viewmodel.team.filter;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FTeamsWithCapacityTest {

    private FTeamsWithCapacity instanceFTeamsWithCapacity;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFTeamsWithCapacity = new FTeamsWithCapacity();
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFTeamsWithCapacity.buildFilterRequest();
        assertNotNull(instanceFTeamsWithCapacity);
    }
}
