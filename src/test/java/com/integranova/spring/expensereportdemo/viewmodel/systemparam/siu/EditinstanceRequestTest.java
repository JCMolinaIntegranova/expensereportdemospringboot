package com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static SystemParamOid defValue4systemParameditinstancepthisSystemParam = new SystemParamOid();
    private static SystemParam defValue4systemParameditinstancepthisSystemParamInstance = new SystemParam(new SystemParamOid(""));
    private static String defValue4systemParameditinstancepname = "";
    private static String defValue4systemParameditinstancepdescription = "";
    private static String defValue4systemParameditinstanceptypeName = "";
    private static String defValue4systemParameditinstancepparamValue = "";


    // test4getSystemParameditinstancepthisSystemParam

    // test4setSystemParameditinstancepthisSystemParam
    private static SystemParamOid test4setSystemParameditinstancepthisSystemParamArg1;

    // test4getSystemParameditinstancepname

    // test4setSystemParameditinstancepname
    private static String test4setSystemParameditinstancepnameArg1;

    // test4getSystemParameditinstancepdescription

    // test4setSystemParameditinstancepdescription
    private static String test4setSystemParameditinstancepdescriptionArg1;

    // test4getSystemParameditinstanceptypeName

    // test4setSystemParameditinstanceptypeName
    private static String test4setSystemParameditinstanceptypeNameArg1;

    // test4getSystemParameditinstancepparamValue

    // test4setSystemParameditinstancepparamValue
    private static String test4setSystemParameditinstancepparamValueArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getSystemParameditinstancepthisSystemParam();
        setUpMockData4test4setSystemParameditinstancepthisSystemParam();
        setUpMockData4test4getSystemParameditinstancepname();
        setUpMockData4test4setSystemParameditinstancepname();
        setUpMockData4test4getSystemParameditinstancepdescription();
        setUpMockData4test4setSystemParameditinstancepdescription();
        setUpMockData4test4getSystemParameditinstanceptypeName();
        setUpMockData4test4setSystemParameditinstanceptypeName();
        setUpMockData4test4getSystemParameditinstancepparamValue();
        setUpMockData4test4setSystemParameditinstancepparamValue();
    }

    private static void setUpMockData4test4getSystemParameditinstancepthisSystemParam() {
    }

    private static void setUpMockData4test4setSystemParameditinstancepthisSystemParam() {
        test4setSystemParameditinstancepthisSystemParamArg1 = new SystemParamOid();
    }

    private static void setUpMockData4test4getSystemParameditinstancepname() {
    }

    private static void setUpMockData4test4setSystemParameditinstancepname() {
        test4setSystemParameditinstancepnameArg1 = "";
    }

    private static void setUpMockData4test4getSystemParameditinstancepdescription() {
    }

    private static void setUpMockData4test4setSystemParameditinstancepdescription() {
        test4setSystemParameditinstancepdescriptionArg1 = "";
    }

    private static void setUpMockData4test4getSystemParameditinstanceptypeName() {
    }

    private static void setUpMockData4test4setSystemParameditinstanceptypeName() {
        test4setSystemParameditinstanceptypeNameArg1 = "";
    }

    private static void setUpMockData4test4getSystemParameditinstancepparamValue() {
    }

    private static void setUpMockData4test4setSystemParameditinstancepparamValue() {
        test4setSystemParameditinstancepparamValueArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setSystemParameditinstancepthisSystemParam(defValue4systemParameditinstancepthisSystemParam);
        instanceEditinstanceRequest.setSystemParameditinstancepthisSystemParamInstance(defValue4systemParameditinstancepthisSystemParamInstance);
        instanceEditinstanceRequest.setSystemParameditinstancepname(defValue4systemParameditinstancepname);
        instanceEditinstanceRequest.setSystemParameditinstancepdescription(defValue4systemParameditinstancepdescription);
        instanceEditinstanceRequest.setSystemParameditinstanceptypeName(defValue4systemParameditinstanceptypeName);
        instanceEditinstanceRequest.setSystemParameditinstancepparamValue(defValue4systemParameditinstancepparamValue);
    }

    @Test
    public void test4getSystemParameditinstancepthisSystemParam() {
        assertEquals(defValue4systemParameditinstancepthisSystemParam, instanceEditinstanceRequest.getSystemParameditinstancepthisSystemParam());
    }

    @Test
    public void test4setSystemParameditinstancepthisSystemParam() {
        instanceEditinstanceRequest.setSystemParameditinstancepthisSystemParam(test4setSystemParameditinstancepthisSystemParamArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getSystemParameditinstancepname() {
        assertEquals(defValue4systemParameditinstancepname, instanceEditinstanceRequest.getSystemParameditinstancepname());
    }

    @Test
    public void test4setSystemParameditinstancepname() {
        instanceEditinstanceRequest.setSystemParameditinstancepname(test4setSystemParameditinstancepnameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getSystemParameditinstancepdescription() {
        assertEquals(defValue4systemParameditinstancepdescription, instanceEditinstanceRequest.getSystemParameditinstancepdescription());
    }

    @Test
    public void test4setSystemParameditinstancepdescription() {
        instanceEditinstanceRequest.setSystemParameditinstancepdescription(test4setSystemParameditinstancepdescriptionArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getSystemParameditinstanceptypeName() {
        assertEquals(defValue4systemParameditinstanceptypeName, instanceEditinstanceRequest.getSystemParameditinstanceptypeName());
    }

    @Test
    public void test4setSystemParameditinstanceptypeName() {
        instanceEditinstanceRequest.setSystemParameditinstanceptypeName(test4setSystemParameditinstanceptypeNameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getSystemParameditinstancepparamValue() {
        assertEquals(defValue4systemParameditinstancepparamValue, instanceEditinstanceRequest.getSystemParameditinstancepparamValue());
    }

    @Test
    public void test4setSystemParameditinstancepparamValue() {
        instanceEditinstanceRequest.setSystemParameditinstancepparamValue(test4setSystemParameditinstancepparamValueArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
