package com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GLOBALTESTResponseTest {

    private GLOBALTESTResponse instanceGLOBALTESTResponse;

    // Default values
    private static String defValue4gLOBALTESTpsResultCode = "";


    // test4getGLOBALTESTpsResultCode

    // test4setGLOBALTESTpsResultCode
    private static String test4setGLOBALTESTpsResultCodeArg1;

    // testBuildOutArgs

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getGLOBALTESTpsResultCode();
        setUpMockData4test4setGLOBALTESTpsResultCode();
        setUpMockData4testBuildOutArgs();
    }

    private static void setUpMockData4test4getGLOBALTESTpsResultCode() {
    }

    private static void setUpMockData4test4setGLOBALTESTpsResultCode() {
        test4setGLOBALTESTpsResultCodeArg1 = "";
    }

    private static void setUpMockData4testBuildOutArgs() {
    }

    @Before
    public void setUp() {
        instanceGLOBALTESTResponse = new GLOBALTESTResponse();
        instanceGLOBALTESTResponse.setGLOBALTESTpsResultCode(defValue4gLOBALTESTpsResultCode);
    }

    @Test
    public void test4getGLOBALTESTpsResultCode() {
        assertEquals(defValue4gLOBALTESTpsResultCode, instanceGLOBALTESTResponse.getGLOBALTESTpsResultCode());
    }

    @Test
    public void test4setGLOBALTESTpsResultCode() {
        instanceGLOBALTESTResponse.setGLOBALTESTpsResultCode(test4setGLOBALTESTpsResultCodeArg1);
        assertNotNull(instanceGLOBALTESTResponse);
    }

    @Test
    public void testBuildOutArgs() {
        assertEquals(1, instanceGLOBALTESTResponse.buildOutArgs().size());
    }
}
