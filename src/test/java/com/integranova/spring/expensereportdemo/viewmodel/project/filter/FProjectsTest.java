package com.integranova.spring.expensereportdemo.viewmodel.project.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FProjectsTest {

    private FProjects instanceFProjects;

    // testgetVName

    // testsetVName
    private static String testsetVNameArg1;

    // testgetVCompleted

    // testsetVCompleted
    private static Boolean testsetVCompletedArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVName();
        setUpMockData4testsetVName();
        setUpMockData4testgetVCompleted();
        setUpMockData4testsetVCompleted();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVName() {
    }

    private static void setUpMockData4testsetVName() {
        testsetVNameArg1 = "";
    }

    private static void setUpMockData4testgetVCompleted() {
    }

    private static void setUpMockData4testsetVCompleted() {
        testsetVCompletedArg1 = false;
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFProjects = new FProjects();
        instanceFProjects.setVName("");
        instanceFProjects.setVCompleted(false);
    }

    @Test
    public void testgetVName() {
        assertEquals("", instanceFProjects.getVName());
    }

    @Test
    public void testsetVName() {
        instanceFProjects.setVName(testsetVNameArg1);
        assertNotNull(instanceFProjects);
    }

    @Test
    public void testgetVCompleted() {
        assertEquals(false, instanceFProjects.getVCompleted());
    }

    @Test
    public void testsetVCompleted() {
        instanceFProjects.setVCompleted(testsetVCompletedArg1);
        assertNotNull(instanceFProjects);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFProjects.buildFilterRequest();
        assertNotNull(instanceFProjects);
    }
}
