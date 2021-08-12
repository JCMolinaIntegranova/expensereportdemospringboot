package com.integranova.spring.expensereportdemo.viewmodel.project.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.project.filter.FProjects;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUProjectRequestTest {

    private PIUProjectRequest instancePIUProjectRequest;

    // testGetFProjects
    private static FProjects testGetFProjectsResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFProjects();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFProjects() {
        testGetFProjectsResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUProjectRequest = new PIUProjectRequest();
    }

    @Test
    public void testGetFProjects() {
        assertEquals(testGetFProjectsResult, instancePIUProjectRequest.getFProjects());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUProjectRequest.buildQueryRequest();
        assertNotNull(instancePIUProjectRequest);
    }
}
