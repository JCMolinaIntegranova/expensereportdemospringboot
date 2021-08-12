package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static PaymentTypeOid defValue4paymentTypedeleteinstancepthisPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4paymentTypedeleteinstancepthisPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));


    // test4getPaymentTypedeleteinstancepthisPaymentType

    // test4setPaymentTypedeleteinstancepthisPaymentType
    private static PaymentTypeOid test4setPaymentTypedeleteinstancepthisPaymentTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPaymentTypedeleteinstancepthisPaymentType();
        setUpMockData4test4setPaymentTypedeleteinstancepthisPaymentType();
    }

    private static void setUpMockData4test4getPaymentTypedeleteinstancepthisPaymentType() {
    }

    private static void setUpMockData4test4setPaymentTypedeleteinstancepthisPaymentType() {
        test4setPaymentTypedeleteinstancepthisPaymentTypeArg1 = new PaymentTypeOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setPaymentTypedeleteinstancepthisPaymentType(defValue4paymentTypedeleteinstancepthisPaymentType);
        instanceDeleteinstanceRequest.setPaymentTypedeleteinstancepthisPaymentTypeInstance(defValue4paymentTypedeleteinstancepthisPaymentTypeInstance);
    }

    @Test
    public void test4getPaymentTypedeleteinstancepthisPaymentType() {
        assertEquals(defValue4paymentTypedeleteinstancepthisPaymentType, instanceDeleteinstanceRequest.getPaymentTypedeleteinstancepthisPaymentType());
    }

    @Test
    public void test4setPaymentTypedeleteinstancepthisPaymentType() {
        instanceDeleteinstanceRequest.setPaymentTypedeleteinstancepthisPaymentType(test4setPaymentTypedeleteinstancepthisPaymentTypeArg1);
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
