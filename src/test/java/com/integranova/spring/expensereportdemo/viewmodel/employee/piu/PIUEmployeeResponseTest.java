package com.integranova.spring.expensereportdemo.viewmodel.employee.piu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PIUEmployeeResponseTest {

    private PIUEmployeeResponse instancePIUEmployeeResponse;

    // testPIUEmployeeResponse

    // testPIUEmployeeResponse2
    private static List<DSEmployee> testPIUEmployeeResponse2Arg1;

    // testGetResults

    // testSetResults
    private static List<DSEmployee> testSetResultsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testPIUEmployeeResponse();
        setUpMockData4testPIUEmployeeResponse2();
        setUpMockData4testGetResults();
        setUpMockData4testSetResults();
    }

    private static void setUpMockData4testPIUEmployeeResponse() {
    }

    private static void setUpMockData4testPIUEmployeeResponse2() {
        testPIUEmployeeResponse2Arg1 = new ArrayList<>();
    }

    private static void setUpMockData4testGetResults() {
    }

    private static void setUpMockData4testSetResults() {
        testSetResultsArg1 = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instancePIUEmployeeResponse = new PIUEmployeeResponse();
    }

    @Test
    public void testPIUEmployeeResponse() {
        instancePIUEmployeeResponse = new PIUEmployeeResponse();
        assertNotNull(instancePIUEmployeeResponse);
    }

    @Test
    public void testPIUEmployeeResponse2() {
        instancePIUEmployeeResponse = new PIUEmployeeResponse(testPIUEmployeeResponse2Arg1);
        assertNotNull(instancePIUEmployeeResponse);
    }

    @Test
    public void testGetResults() {
        assertEquals(new ArrayList<>(), instancePIUEmployeeResponse.getResults());
    }

    @Test
    public void testSetResults() {
        instancePIUEmployeeResponse.setResults(testSetResultsArg1);
        assertNotNull(instancePIUEmployeeResponse);
    }
}
