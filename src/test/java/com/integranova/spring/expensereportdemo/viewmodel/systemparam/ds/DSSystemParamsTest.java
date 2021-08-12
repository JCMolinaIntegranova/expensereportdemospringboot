package com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSSystemParamsTest {

    private DSSystemParams instanceDSSystemParams;

    // testDSSystemParams
    private static SystemParam testDSSystemParamsArg1;

    // testDSSystemParams2
    private static SystemParam testDSSystemParams2Arg1;

    // testgetDSSystemParamsParamCode

    // testsetDSSystemParamsParamCode
    private static String testsetDSSystemParamsParamCodeArg1;

    // testgetDSSystemParamsName

    // testsetDSSystemParamsName
    private static String testsetDSSystemParamsNameArg1;

    // testgetDSSystemParamsTypeName

    // testsetDSSystemParamsTypeName
    private static String testsetDSSystemParamsTypeNameArg1;

    // testgetDSSystemParamsParamValue

    // testsetDSSystemParamsParamValue
    private static String testsetDSSystemParamsParamValueArg1;

    // testgetDSSystemParamsDescription

    // testsetDSSystemParamsDescription
    private static String testsetDSSystemParamsDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSSystemParams();
        setUpMockData4testDSSystemParams2();
        setUpMockData4testgetDSSystemParamsParamCode();
        setUpMockData4testsetDSSystemParamsParamCode();
        setUpMockData4testgetDSSystemParamsName();
        setUpMockData4testsetDSSystemParamsName();
        setUpMockData4testgetDSSystemParamsTypeName();
        setUpMockData4testsetDSSystemParamsTypeName();
        setUpMockData4testgetDSSystemParamsParamValue();
        setUpMockData4testsetDSSystemParamsParamValue();
        setUpMockData4testgetDSSystemParamsDescription();
        setUpMockData4testsetDSSystemParamsDescription();
    }

    private static void setUpMockData4testDSSystemParams() {
        testDSSystemParamsArg1 = new SystemParam();
    }

    private static void setUpMockData4testDSSystemParams2() {
        testDSSystemParams2Arg1 = null;
    }

    private static void setUpMockData4testgetDSSystemParamsParamCode() {
    }

    private static void setUpMockData4testsetDSSystemParamsParamCode() {
        testsetDSSystemParamsParamCodeArg1 = "";
    }

    private static void setUpMockData4testgetDSSystemParamsName() {
    }

    private static void setUpMockData4testsetDSSystemParamsName() {
        testsetDSSystemParamsNameArg1 = "";
    }

    private static void setUpMockData4testgetDSSystemParamsTypeName() {
    }

    private static void setUpMockData4testsetDSSystemParamsTypeName() {
        testsetDSSystemParamsTypeNameArg1 = "";
    }

    private static void setUpMockData4testgetDSSystemParamsParamValue() {
    }

    private static void setUpMockData4testsetDSSystemParamsParamValue() {
        testsetDSSystemParamsParamValueArg1 = "";
    }

    private static void setUpMockData4testgetDSSystemParamsDescription() {
    }

    private static void setUpMockData4testsetDSSystemParamsDescription() {
        testsetDSSystemParamsDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSSystemParams = new DSSystemParams();
        instanceDSSystemParams.setDSSystemParamsParamCode("");
        instanceDSSystemParams.setDSSystemParamsName("");
        instanceDSSystemParams.setDSSystemParamsTypeName("");
        instanceDSSystemParams.setDSSystemParamsParamValue("");
        instanceDSSystemParams.setDSSystemParamsDescription("");
    }

    @Test
    public void testDSSystemParams() {
        instanceDSSystemParams = new DSSystemParams(testDSSystemParamsArg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testDSSystemParams2() {
        instanceDSSystemParams = new DSSystemParams(testDSSystemParams2Arg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testgetDSSystemParamsParamCode() {
        assertEquals("", instanceDSSystemParams.getDSSystemParamsParamCode());
    }

    @Test
    public void testsetDSSystemParamsParamCode() {
        instanceDSSystemParams.setDSSystemParamsParamCode(testsetDSSystemParamsParamCodeArg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testgetDSSystemParamsName() {
        assertEquals("", instanceDSSystemParams.getDSSystemParamsName());
    }

    @Test
    public void testsetDSSystemParamsName() {
        instanceDSSystemParams.setDSSystemParamsName(testsetDSSystemParamsNameArg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testgetDSSystemParamsTypeName() {
        assertEquals("", instanceDSSystemParams.getDSSystemParamsTypeName());
    }

    @Test
    public void testsetDSSystemParamsTypeName() {
        instanceDSSystemParams.setDSSystemParamsTypeName(testsetDSSystemParamsTypeNameArg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testgetDSSystemParamsParamValue() {
        assertEquals("", instanceDSSystemParams.getDSSystemParamsParamValue());
    }

    @Test
    public void testsetDSSystemParamsParamValue() {
        instanceDSSystemParams.setDSSystemParamsParamValue(testsetDSSystemParamsParamValueArg1);
        assertNotNull(instanceDSSystemParams);
    }

    @Test
    public void testgetDSSystemParamsDescription() {
        assertEquals("", instanceDSSystemParams.getDSSystemParamsDescription());
    }

    @Test
    public void testsetDSSystemParamsDescription() {
        instanceDSSystemParams.setDSSystemParamsDescription(testsetDSSystemParamsDescriptionArg1);
        assertNotNull(instanceDSSystemParams);
    }
}
