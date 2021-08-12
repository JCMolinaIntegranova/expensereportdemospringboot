package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUTemplateLinesResponseTest {

    private PIUTemplateLinesResponse instancePIUTemplateLinesResponse;

    // testPIUTemplateLinesResponse

    // testPIUTemplateLinesResponse2
    private static List<DSTemplateLines> testPIUTemplateLinesResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSTemplateLines> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUTemplateLinesResponse();
        setUpMockData4testPIUTemplateLinesResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUTemplateLinesResponse() {
    }

    private static void setUpMockData4testPIUTemplateLinesResponse2() {
        testPIUTemplateLinesResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUTemplateLinesResponse = new PIUTemplateLinesResponse();
    }

    @Test
    public void testPIUTemplateLinesResponse() {
        instancePIUTemplateLinesResponse = new PIUTemplateLinesResponse();
        assertNotNull(instancePIUTemplateLinesResponse);
    }

    @Test
    public void testPIUTemplateLinesResponse2() {
        instancePIUTemplateLinesResponse = new PIUTemplateLinesResponse(testPIUTemplateLinesResponse2Arg1);
        assertNotNull(instancePIUTemplateLinesResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUTemplateLinesResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUTemplateLinesResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUTemplateLinesResponse);
    }
}
