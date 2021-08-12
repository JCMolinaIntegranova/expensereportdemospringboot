package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUERTemplatesResponseTest {

    private PIUERTemplatesResponse instancePIUERTemplatesResponse;

    // testPIUERTemplatesResponse

    // testPIUERTemplatesResponse2
    private static List<DSERTemplates> testPIUERTemplatesResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSERTemplates> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUERTemplatesResponse();
        setUpMockData4testPIUERTemplatesResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUERTemplatesResponse() {
    }

    private static void setUpMockData4testPIUERTemplatesResponse2() {
        testPIUERTemplatesResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUERTemplatesResponse = new PIUERTemplatesResponse();
    }

    @Test
    public void testPIUERTemplatesResponse() {
        instancePIUERTemplatesResponse = new PIUERTemplatesResponse();
        assertNotNull(instancePIUERTemplatesResponse);
    }

    @Test
    public void testPIUERTemplatesResponse2() {
        instancePIUERTemplatesResponse = new PIUERTemplatesResponse(testPIUERTemplatesResponse2Arg1);
        assertNotNull(instancePIUERTemplatesResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUERTemplatesResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUERTemplatesResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUERTemplatesResponse);
    }
}
