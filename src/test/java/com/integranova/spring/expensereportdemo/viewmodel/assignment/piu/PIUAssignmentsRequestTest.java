package com.integranova.spring.expensereportdemo.viewmodel.assignment.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.assignment.filter.FAssignments;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUAssignmentsRequestTest {

    private PIUAssignmentsRequest instancePIUAssignmentsRequest;

    // testGetFAssignments
    private static FAssignments testGetFAssignmentsResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFAssignments();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFAssignments() {
        testGetFAssignmentsResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUAssignmentsRequest = new PIUAssignmentsRequest();
    }

    @Test
    public void testGetFAssignments() {
        assertEquals(testGetFAssignmentsResult, instancePIUAssignmentsRequest.getFAssignments());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUAssignmentsRequest.buildQueryRequest();
        assertNotNull(instancePIUAssignmentsRequest);
    }
}
