package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.filter.FERTemplates;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUERTemplatesRequestTest {

    private PIUERTemplatesRequest instancePIUERTemplatesRequest;

    // testGetFERTemplates
    private static FERTemplates testGetFERTemplatesResult;

    // testBuildQueryRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetFERTemplates();
        setUpMockData4testBuildQueryRequest();
    }

    private static void setUpMockData4testGetFERTemplates() {
        testGetFERTemplatesResult = null;
    }

    private static void setUpMockData4testBuildQueryRequest() {
    }

    @Before
    public void setUp() {
        instancePIUERTemplatesRequest = new PIUERTemplatesRequest();
    }

    @Test
    public void testGetFERTemplates() {
        assertEquals(testGetFERTemplatesResult, instancePIUERTemplatesRequest.getFERTemplates());
    }

    @Test
    public void testBuildQueryRequest() {
        instancePIUERTemplatesRequest.buildQueryRequest();
        assertNotNull(instancePIUERTemplatesRequest);
    }
}
