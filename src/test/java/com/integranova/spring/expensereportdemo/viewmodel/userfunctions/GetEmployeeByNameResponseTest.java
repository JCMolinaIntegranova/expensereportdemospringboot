package com.integranova.spring.expensereportdemo.viewmodel.userfunctions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetEmployeeByNameResponseTest {

    private GetEmployeeByNameResponse instanceGetEmployeeByNameResponse;

    // Default values
    private static Boolean defValue4outFound = false;


    // test4getOutFound

    // test4setOutFound
    private static Boolean test4setOutFoundArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getOutFound();
        setUpMockData4test4setOutFound();
    }

    private static void setUpMockData4test4getOutFound() {
    }

    private static void setUpMockData4test4setOutFound() {
        test4setOutFoundArg1 = false;
    }

    @Before
    public void setUp() {
        instanceGetEmployeeByNameResponse = new GetEmployeeByNameResponse();
        instanceGetEmployeeByNameResponse.setOutFound(defValue4outFound);
    }

    @Test
    public void test4getOutFound() {
        assertEquals(defValue4outFound, instanceGetEmployeeByNameResponse.getOutFound());
    }

    @Test
    public void test4setOutFound() {
        instanceGetEmployeeByNameResponse.setOutFound(test4setOutFoundArg1);
        assertNotNull(instanceGetEmployeeByNameResponse);
    }
}
