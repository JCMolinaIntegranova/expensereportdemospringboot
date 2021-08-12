package com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static String defValue4systemParamcreateinstancepatrparamCode = "";
    private static String defValue4systemParamcreateinstancepatrname = "";
    private static String defValue4systemParamcreateinstancepatrdescription = "";
    private static String defValue4systemParamcreateinstancepatrtypeName = "";
    private static String defValue4systemParamcreateinstancepatrparamValue = "";


    // test4getSystemParamcreateinstancepatrparamCode

    // test4setSystemParamcreateinstancepatrparamCode
    private static String test4setSystemParamcreateinstancepatrparamCodeArg1;

    // test4getSystemParamcreateinstancepatrname

    // test4setSystemParamcreateinstancepatrname
    private static String test4setSystemParamcreateinstancepatrnameArg1;

    // test4getSystemParamcreateinstancepatrdescription

    // test4setSystemParamcreateinstancepatrdescription
    private static String test4setSystemParamcreateinstancepatrdescriptionArg1;

    // test4getSystemParamcreateinstancepatrtypeName

    // test4setSystemParamcreateinstancepatrtypeName
    private static String test4setSystemParamcreateinstancepatrtypeNameArg1;

    // test4getSystemParamcreateinstancepatrparamValue

    // test4setSystemParamcreateinstancepatrparamValue
    private static String test4setSystemParamcreateinstancepatrparamValueArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getSystemParamcreateinstancepatrparamCode();
        setUpMockData4test4setSystemParamcreateinstancepatrparamCode();
        setUpMockData4test4getSystemParamcreateinstancepatrname();
        setUpMockData4test4setSystemParamcreateinstancepatrname();
        setUpMockData4test4getSystemParamcreateinstancepatrdescription();
        setUpMockData4test4setSystemParamcreateinstancepatrdescription();
        setUpMockData4test4getSystemParamcreateinstancepatrtypeName();
        setUpMockData4test4setSystemParamcreateinstancepatrtypeName();
        setUpMockData4test4getSystemParamcreateinstancepatrparamValue();
        setUpMockData4test4setSystemParamcreateinstancepatrparamValue();
    }

    private static void setUpMockData4test4getSystemParamcreateinstancepatrparamCode() {
    }

    private static void setUpMockData4test4setSystemParamcreateinstancepatrparamCode() {
        test4setSystemParamcreateinstancepatrparamCodeArg1 = "";
    }

    private static void setUpMockData4test4getSystemParamcreateinstancepatrname() {
    }

    private static void setUpMockData4test4setSystemParamcreateinstancepatrname() {
        test4setSystemParamcreateinstancepatrnameArg1 = "";
    }

    private static void setUpMockData4test4getSystemParamcreateinstancepatrdescription() {
    }

    private static void setUpMockData4test4setSystemParamcreateinstancepatrdescription() {
        test4setSystemParamcreateinstancepatrdescriptionArg1 = "";
    }

    private static void setUpMockData4test4getSystemParamcreateinstancepatrtypeName() {
    }

    private static void setUpMockData4test4setSystemParamcreateinstancepatrtypeName() {
        test4setSystemParamcreateinstancepatrtypeNameArg1 = "";
    }

    private static void setUpMockData4test4getSystemParamcreateinstancepatrparamValue() {
    }

    private static void setUpMockData4test4setSystemParamcreateinstancepatrparamValue() {
        test4setSystemParamcreateinstancepatrparamValueArg1 = "";
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrparamCode(defValue4systemParamcreateinstancepatrparamCode);
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrname(defValue4systemParamcreateinstancepatrname);
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrdescription(defValue4systemParamcreateinstancepatrdescription);
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrtypeName(defValue4systemParamcreateinstancepatrtypeName);
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrparamValue(defValue4systemParamcreateinstancepatrparamValue);
    }

    @Test
    public void test4getSystemParamcreateinstancepatrparamCode() {
        assertEquals(defValue4systemParamcreateinstancepatrparamCode, instanceCreateinstanceRequest.getSystemParamcreateinstancepatrparamCode());
    }

    @Test
    public void test4setSystemParamcreateinstancepatrparamCode() {
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrparamCode(test4setSystemParamcreateinstancepatrparamCodeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getSystemParamcreateinstancepatrname() {
        assertEquals(defValue4systemParamcreateinstancepatrname, instanceCreateinstanceRequest.getSystemParamcreateinstancepatrname());
    }

    @Test
    public void test4setSystemParamcreateinstancepatrname() {
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrname(test4setSystemParamcreateinstancepatrnameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getSystemParamcreateinstancepatrdescription() {
        assertEquals(defValue4systemParamcreateinstancepatrdescription, instanceCreateinstanceRequest.getSystemParamcreateinstancepatrdescription());
    }

    @Test
    public void test4setSystemParamcreateinstancepatrdescription() {
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrdescription(test4setSystemParamcreateinstancepatrdescriptionArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getSystemParamcreateinstancepatrtypeName() {
        assertEquals(defValue4systemParamcreateinstancepatrtypeName, instanceCreateinstanceRequest.getSystemParamcreateinstancepatrtypeName());
    }

    @Test
    public void test4setSystemParamcreateinstancepatrtypeName() {
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrtypeName(test4setSystemParamcreateinstancepatrtypeNameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getSystemParamcreateinstancepatrparamValue() {
        assertEquals(defValue4systemParamcreateinstancepatrparamValue, instanceCreateinstanceRequest.getSystemParamcreateinstancepatrparamValue());
    }

    @Test
    public void test4setSystemParamcreateinstancepatrparamValue() {
        instanceCreateinstanceRequest.setSystemParamcreateinstancepatrparamValue(test4setSystemParamcreateinstancepatrparamValueArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
    	instanceCreateinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCreateinstanceRequest.checkArguments();
    }
}
