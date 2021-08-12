package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FERTemplatesTest {

    private FERTemplates instanceFERTemplates;

    // testgetVName

    // testsetVName
    private static String testsetVNameArg1;

    // testgetVDescription

    // testsetVDescription
    private static String testsetVDescriptionArg1;

    // testgetVEnabled

    // testsetVEnabled
    private static Boolean testsetVEnabledArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVName();
        setUpMockData4testsetVName();
        setUpMockData4testgetVDescription();
        setUpMockData4testsetVDescription();
        setUpMockData4testgetVEnabled();
        setUpMockData4testsetVEnabled();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVName() {
    }

    private static void setUpMockData4testsetVName() {
        testsetVNameArg1 = "";
    }

    private static void setUpMockData4testgetVDescription() {
    }

    private static void setUpMockData4testsetVDescription() {
        testsetVDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetVEnabled() {
    }

    private static void setUpMockData4testsetVEnabled() {
        testsetVEnabledArg1 = false;
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFERTemplates = new FERTemplates();
        instanceFERTemplates.setVName("");
        instanceFERTemplates.setVDescription("");
        instanceFERTemplates.setVEnabled(false);
    }

    @Test
    public void testgetVName() {
        assertEquals("", instanceFERTemplates.getVName());
    }

    @Test
    public void testsetVName() {
        instanceFERTemplates.setVName(testsetVNameArg1);
        assertNotNull(instanceFERTemplates);
    }

    @Test
    public void testgetVDescription() {
        assertEquals("", instanceFERTemplates.getVDescription());
    }

    @Test
    public void testsetVDescription() {
        instanceFERTemplates.setVDescription(testsetVDescriptionArg1);
        assertNotNull(instanceFERTemplates);
    }

    @Test
    public void testgetVEnabled() {
        assertEquals(false, instanceFERTemplates.getVEnabled());
    }

    @Test
    public void testsetVEnabled() {
        instanceFERTemplates.setVEnabled(testsetVEnabledArg1);
        assertNotNull(instanceFERTemplates);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFERTemplates.buildFilterRequest();
        assertNotNull(instanceFERTemplates);
    }
}
