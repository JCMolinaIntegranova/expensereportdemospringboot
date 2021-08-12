package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FByIDTest {

    private FByID instanceFByID;

    // testgetVID

    // testsetVID
    private static Long testsetVIDArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVID();
        setUpMockData4testsetVID();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVID() {
    }

    private static void setUpMockData4testsetVID() {
        testsetVIDArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFByID = new FByID();
        instanceFByID.setVID(Long.valueOf(0));
    }

    @Test
    public void testgetVID() {
        assertEquals(Long.valueOf(0), instanceFByID.getVID());
    }

    @Test
    public void testsetVID() {
        instanceFByID.setVID(testsetVIDArg1);
        assertNotNull(instanceFByID);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFByID.buildFilterRequest();
        assertNotNull(instanceFByID);
    }
}
