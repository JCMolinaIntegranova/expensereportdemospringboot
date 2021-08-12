package com.integranova.spring.expensereportdemo.viewmodel.systemparam.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUSystemParamsResponseTest {

    private PIUSystemParamsResponse instancePIUSystemParamsResponse;

    // testPIUSystemParamsResponse

    // testPIUSystemParamsResponse2
    private static List<DSSystemParams> testPIUSystemParamsResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSSystemParams> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUSystemParamsResponse();
        setUpMockData4testPIUSystemParamsResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUSystemParamsResponse() {
    }

    private static void setUpMockData4testPIUSystemParamsResponse2() {
        testPIUSystemParamsResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUSystemParamsResponse = new PIUSystemParamsResponse();
    }

    @Test
    public void testPIUSystemParamsResponse() {
        instancePIUSystemParamsResponse = new PIUSystemParamsResponse();
        assertNotNull(instancePIUSystemParamsResponse);
    }

    @Test
    public void testPIUSystemParamsResponse2() {
        instancePIUSystemParamsResponse = new PIUSystemParamsResponse(testPIUSystemParamsResponse2Arg1);
        assertNotNull(instancePIUSystemParamsResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUSystemParamsResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUSystemParamsResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUSystemParamsResponse);
    }
}
