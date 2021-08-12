package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSPaymentTypeTest {

    private DSPaymentType instanceDSPaymentType;

    // testDSPaymentType
    private static PaymentType testDSPaymentTypeArg1;

    // testDSPaymentType2
    private static PaymentType testDSPaymentType2Arg1;

    // testgetDSPaymentTypeIdPaymentType

    // testsetDSPaymentTypeIdPaymentType
    private static String testsetDSPaymentTypeIdPaymentTypeArg1;

    // testgetDSPaymentTypePayDescription

    // testsetDSPaymentTypePayDescription
    private static String testsetDSPaymentTypePayDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSPaymentType();
        setUpMockData4testDSPaymentType2();
        setUpMockData4testgetDSPaymentTypeIdPaymentType();
        setUpMockData4testsetDSPaymentTypeIdPaymentType();
        setUpMockData4testgetDSPaymentTypePayDescription();
        setUpMockData4testsetDSPaymentTypePayDescription();
    }

    private static void setUpMockData4testDSPaymentType() {
        testDSPaymentTypeArg1 = new PaymentType();
    }

    private static void setUpMockData4testDSPaymentType2() {
        testDSPaymentType2Arg1 = null;
    }

    private static void setUpMockData4testgetDSPaymentTypeIdPaymentType() {
    }

    private static void setUpMockData4testsetDSPaymentTypeIdPaymentType() {
        testsetDSPaymentTypeIdPaymentTypeArg1 = "";
    }

    private static void setUpMockData4testgetDSPaymentTypePayDescription() {
    }

    private static void setUpMockData4testsetDSPaymentTypePayDescription() {
        testsetDSPaymentTypePayDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSPaymentType = new DSPaymentType();
        instanceDSPaymentType.setDSPaymentTypeIdPaymentType("");
        instanceDSPaymentType.setDSPaymentTypePayDescription("");
    }

    @Test
    public void testDSPaymentType() {
        instanceDSPaymentType = new DSPaymentType(testDSPaymentTypeArg1);
        assertNotNull(instanceDSPaymentType);
    }

    @Test
    public void testDSPaymentType2() {
        instanceDSPaymentType = new DSPaymentType(testDSPaymentType2Arg1);
        assertNotNull(instanceDSPaymentType);
    }

    @Test
    public void testgetDSPaymentTypeIdPaymentType() {
        assertEquals("", instanceDSPaymentType.getDSPaymentTypeIdPaymentType());
    }

    @Test
    public void testsetDSPaymentTypeIdPaymentType() {
        instanceDSPaymentType.setDSPaymentTypeIdPaymentType(testsetDSPaymentTypeIdPaymentTypeArg1);
        assertNotNull(instanceDSPaymentType);
    }

    @Test
    public void testgetDSPaymentTypePayDescription() {
        assertEquals("", instanceDSPaymentType.getDSPaymentTypePayDescription());
    }

    @Test
    public void testsetDSPaymentTypePayDescription() {
        instanceDSPaymentType.setDSPaymentTypePayDescription(testsetDSPaymentTypePayDescriptionArg1);
        assertNotNull(instanceDSPaymentType);
    }
}
