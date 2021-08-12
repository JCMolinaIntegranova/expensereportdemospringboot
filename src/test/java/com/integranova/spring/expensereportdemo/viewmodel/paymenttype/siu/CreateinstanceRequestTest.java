package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

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
    private static String defValue4paymentTypecreateinstancepatridPaymentType = "";
    private static String defValue4paymentTypecreateinstancepatrPayDescription = "";


    // test4getPaymentTypecreateinstancepatridPaymentType

    // test4setPaymentTypecreateinstancepatridPaymentType
    private static String test4setPaymentTypecreateinstancepatridPaymentTypeArg1;

    // test4getPaymentTypecreateinstancepatrPayDescription

    // test4setPaymentTypecreateinstancepatrPayDescription
    private static String test4setPaymentTypecreateinstancepatrPayDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getPaymentTypecreateinstancepatridPaymentType();
        setUpMockData4test4setPaymentTypecreateinstancepatridPaymentType();
        setUpMockData4test4getPaymentTypecreateinstancepatrPayDescription();
        setUpMockData4test4setPaymentTypecreateinstancepatrPayDescription();
    }

    private static void setUpMockData4test4getPaymentTypecreateinstancepatridPaymentType() {
    }

    private static void setUpMockData4test4setPaymentTypecreateinstancepatridPaymentType() {
        test4setPaymentTypecreateinstancepatridPaymentTypeArg1 = "";
    }

    private static void setUpMockData4test4getPaymentTypecreateinstancepatrPayDescription() {
    }

    private static void setUpMockData4test4setPaymentTypecreateinstancepatrPayDescription() {
        test4setPaymentTypecreateinstancepatrPayDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setPaymentTypecreateinstancepatridPaymentType(defValue4paymentTypecreateinstancepatridPaymentType);
        instanceCreateinstanceRequest.setPaymentTypecreateinstancepatrPayDescription(defValue4paymentTypecreateinstancepatrPayDescription);
    }

    @Test
    public void test4getPaymentTypecreateinstancepatridPaymentType() {
        assertEquals(defValue4paymentTypecreateinstancepatridPaymentType, instanceCreateinstanceRequest.getPaymentTypecreateinstancepatridPaymentType());
    }

    @Test
    public void test4setPaymentTypecreateinstancepatridPaymentType() {
        instanceCreateinstanceRequest.setPaymentTypecreateinstancepatridPaymentType(test4setPaymentTypecreateinstancepatridPaymentTypeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getPaymentTypecreateinstancepatrPayDescription() {
        assertEquals(defValue4paymentTypecreateinstancepatrPayDescription, instanceCreateinstanceRequest.getPaymentTypecreateinstancepatrPayDescription());
    }

    @Test
    public void test4setPaymentTypecreateinstancepatrPayDescription() {
        instanceCreateinstanceRequest.setPaymentTypecreateinstancepatrPayDescription(test4setPaymentTypecreateinstancepatrPayDescriptionArg1);
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
