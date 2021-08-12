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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static PaymentTypeOid defValue4paymentTypeeditinstancepthisPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4paymentTypeeditinstancepthisPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static String defValue4paymentTypeeditinstancepPayDescription = "";


    // test4getPaymentTypeeditinstancepthisPaymentType

    // test4setPaymentTypeeditinstancepthisPaymentType
    private static PaymentTypeOid test4setPaymentTypeeditinstancepthisPaymentTypeArg1;

    // test4getPaymentTypeeditinstancepPayDescription

    // test4setPaymentTypeeditinstancepPayDescription
    private static String test4setPaymentTypeeditinstancepPayDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPaymentTypeeditinstancepthisPaymentType();
        setUpMockData4test4setPaymentTypeeditinstancepthisPaymentType();
        setUpMockData4test4getPaymentTypeeditinstancepPayDescription();
        setUpMockData4test4setPaymentTypeeditinstancepPayDescription();
    }

    private static void setUpMockData4test4getPaymentTypeeditinstancepthisPaymentType() {
    }

    private static void setUpMockData4test4setPaymentTypeeditinstancepthisPaymentType() {
        test4setPaymentTypeeditinstancepthisPaymentTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getPaymentTypeeditinstancepPayDescription() {
    }

    private static void setUpMockData4test4setPaymentTypeeditinstancepPayDescription() {
        test4setPaymentTypeeditinstancepPayDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setPaymentTypeeditinstancepthisPaymentType(defValue4paymentTypeeditinstancepthisPaymentType);
        instanceEditinstanceRequest.setPaymentTypeeditinstancepthisPaymentTypeInstance(defValue4paymentTypeeditinstancepthisPaymentTypeInstance);
        instanceEditinstanceRequest.setPaymentTypeeditinstancepPayDescription(defValue4paymentTypeeditinstancepPayDescription);
    }

    @Test
    public void test4getPaymentTypeeditinstancepthisPaymentType() {
        assertEquals(defValue4paymentTypeeditinstancepthisPaymentType, instanceEditinstanceRequest.getPaymentTypeeditinstancepthisPaymentType());
    }

    @Test
    public void test4setPaymentTypeeditinstancepthisPaymentType() {
        instanceEditinstanceRequest.setPaymentTypeeditinstancepthisPaymentType(test4setPaymentTypeeditinstancepthisPaymentTypeArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getPaymentTypeeditinstancepPayDescription() {
        assertEquals(defValue4paymentTypeeditinstancepPayDescription, instanceEditinstanceRequest.getPaymentTypeeditinstancepPayDescription());
    }

    @Test
    public void test4setPaymentTypeeditinstancepPayDescription() {
        instanceEditinstanceRequest.setPaymentTypeeditinstancepPayDescription(test4setPaymentTypeeditinstancepPayDescriptionArg1);
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
