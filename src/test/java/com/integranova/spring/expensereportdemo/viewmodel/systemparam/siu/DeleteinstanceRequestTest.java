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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static SystemParamOid defValue4systemParamdeleteinstancepthisSystemParam = new SystemParamOid();
    private static SystemParam defValue4systemParamdeleteinstancepthisSystemParamInstance = new SystemParam(new SystemParamOid(""));


    // test4getSystemParamdeleteinstancepthisSystemParam

    // test4setSystemParamdeleteinstancepthisSystemParam
    private static SystemParamOid test4setSystemParamdeleteinstancepthisSystemParamArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getSystemParamdeleteinstancepthisSystemParam();
        setUpMockData4test4setSystemParamdeleteinstancepthisSystemParam();
    }

    private static void setUpMockData4test4getSystemParamdeleteinstancepthisSystemParam() {
    }

    private static void setUpMockData4test4setSystemParamdeleteinstancepthisSystemParam() {
        test4setSystemParamdeleteinstancepthisSystemParamArg1 = new SystemParamOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setSystemParamdeleteinstancepthisSystemParam(defValue4systemParamdeleteinstancepthisSystemParam);
        instanceDeleteinstanceRequest.setSystemParamdeleteinstancepthisSystemParamInstance(defValue4systemParamdeleteinstancepthisSystemParamInstance);
    }

    @Test
    public void test4getSystemParamdeleteinstancepthisSystemParam() {
        assertEquals(defValue4systemParamdeleteinstancepthisSystemParam, instanceDeleteinstanceRequest.getSystemParamdeleteinstancepthisSystemParam());
    }

    @Test
    public void test4setSystemParamdeleteinstancepthisSystemParam() {
        instanceDeleteinstanceRequest.setSystemParamdeleteinstancepthisSystemParam(test4setSystemParamdeleteinstancepthisSystemParamArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
