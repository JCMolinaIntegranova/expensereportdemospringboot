package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DummyResponseTest {

    private DummyResponse instanceDummyResponse;

    // Default values
    private static String defValue4expenseReportdummypsResultCode = "";


    // test4getExpenseReportdummypsResultCode

    // test4setExpenseReportdummypsResultCode
    private static String test4setExpenseReportdummypsResultCodeArg1;

    // testBuildOutArgs

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportdummypsResultCode();
        setUpMockData4test4setExpenseReportdummypsResultCode();
        setUpMockData4testBuildOutArgs();
    }

    private static void setUpMockData4test4getExpenseReportdummypsResultCode() {
    }

    private static void setUpMockData4test4setExpenseReportdummypsResultCode() {
        test4setExpenseReportdummypsResultCodeArg1 = "";
    }

    private static void setUpMockData4testBuildOutArgs() {
    }

    @Before
    public void setUp() {
        instanceDummyResponse = new DummyResponse();
        instanceDummyResponse.setExpenseReportdummypsResultCode(defValue4expenseReportdummypsResultCode);
    }

    @Test
    public void test4getExpenseReportdummypsResultCode() {
        assertEquals(defValue4expenseReportdummypsResultCode, instanceDummyResponse.getExpenseReportdummypsResultCode());
    }

    @Test
    public void test4setExpenseReportdummypsResultCode() {
        instanceDummyResponse.setExpenseReportdummypsResultCode(test4setExpenseReportdummypsResultCodeArg1);
        assertNotNull(instanceDummyResponse);
    }

    @Test
    public void testBuildOutArgs() {
        assertEquals(1, instanceDummyResponse.buildOutArgs().size());
    }
}
