package com.integranova.spring.expensereportdemo.viewmodel.userfunctions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetEmployeeByNameRequestTest {

    private GetEmployeeByNameRequest instanceGetEmployeeByNameRequest;

    // Default values
    private static String defValue4pfName = "";


    // test4getPfName

    // test4setPfName
    private static String test4setPfNameArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPfName();
        setUpMockData4test4setPfName();
    }

    private static void setUpMockData4test4getPfName() {
    }

    private static void setUpMockData4test4setPfName() {
        test4setPfNameArg1 = "";
    }

    @Before
    public void setUp() {
        instanceGetEmployeeByNameRequest = new GetEmployeeByNameRequest();
        instanceGetEmployeeByNameRequest.setPfName(defValue4pfName);
    }

    @Test
    public void test4getPfName() {
        assertEquals(defValue4pfName, instanceGetEmployeeByNameRequest.getPfName());
    }

    @Test
    public void test4setPfName() {
        instanceGetEmployeeByNameRequest.setPfName(test4setPfNameArg1);
        assertNotNull(instanceGetEmployeeByNameRequest);
    }
}
