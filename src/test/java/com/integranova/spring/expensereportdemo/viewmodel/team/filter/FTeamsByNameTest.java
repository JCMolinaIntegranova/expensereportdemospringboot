package com.integranova.spring.expensereportdemo.viewmodel.team.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FTeamsByNameTest {

    private FTeamsByName instanceFTeamsByName;

    // testgetVName

    // testsetVName
    private static String testsetVNameArg1;

    // testgetVCapacity

    // testsetVCapacity
    private static Long testsetVCapacityArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVName();
        setUpMockData4testsetVName();
        setUpMockData4testgetVCapacity();
        setUpMockData4testsetVCapacity();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVName() {
    }

    private static void setUpMockData4testsetVName() {
        testsetVNameArg1 = "";
    }

    private static void setUpMockData4testgetVCapacity() {
    }

    private static void setUpMockData4testsetVCapacity() {
        testsetVCapacityArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFTeamsByName = new FTeamsByName();
        instanceFTeamsByName.setVName("");
        instanceFTeamsByName.setVCapacity(Long.valueOf(0));
    }

    @Test
    public void testgetVName() {
        assertEquals("", instanceFTeamsByName.getVName());
    }

    @Test
    public void testsetVName() {
        instanceFTeamsByName.setVName(testsetVNameArg1);
        assertNotNull(instanceFTeamsByName);
    }

    @Test
    public void testgetVCapacity() {
        assertEquals(Long.valueOf(0), instanceFTeamsByName.getVCapacity());
    }

    @Test
    public void testsetVCapacity() {
        instanceFTeamsByName.setVCapacity(testsetVCapacityArg1);
        assertNotNull(instanceFTeamsByName);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFTeamsByName.buildFilterRequest();
        assertNotNull(instanceFTeamsByName);
    }
}
