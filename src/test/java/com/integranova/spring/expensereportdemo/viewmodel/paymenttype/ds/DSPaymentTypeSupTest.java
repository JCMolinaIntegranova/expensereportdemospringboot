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
public class DSPaymentTypeSupTest {

    private DSPaymentTypeSup instanceDSPaymentTypeSup;

    // testDSPaymentTypeSup
    private static PaymentType testDSPaymentTypeSupArg1;

    // testDSPaymentTypeSup2
    private static PaymentType testDSPaymentTypeSup2Arg1;

    // testgetDSPaymentTypeSupPayDescription

    // testsetDSPaymentTypeSupPayDescription
    private static String testsetDSPaymentTypeSupPayDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSPaymentTypeSup();
        setUpMockData4testDSPaymentTypeSup2();
        setUpMockData4testgetDSPaymentTypeSupPayDescription();
        setUpMockData4testsetDSPaymentTypeSupPayDescription();
    }

    private static void setUpMockData4testDSPaymentTypeSup() {
        testDSPaymentTypeSupArg1 = new PaymentType();
    }

    private static void setUpMockData4testDSPaymentTypeSup2() {
        testDSPaymentTypeSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSPaymentTypeSupPayDescription() {
    }

    private static void setUpMockData4testsetDSPaymentTypeSupPayDescription() {
        testsetDSPaymentTypeSupPayDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSPaymentTypeSup = new DSPaymentTypeSup();
        instanceDSPaymentTypeSup.setDSPaymentTypeSupPayDescription("");
    }

    @Test
    public void testDSPaymentTypeSup() {
        instanceDSPaymentTypeSup = new DSPaymentTypeSup(testDSPaymentTypeSupArg1);
        assertNotNull(instanceDSPaymentTypeSup);
    }

    @Test
    public void testDSPaymentTypeSup2() {
        instanceDSPaymentTypeSup = new DSPaymentTypeSup(testDSPaymentTypeSup2Arg1);
        assertNotNull(instanceDSPaymentTypeSup);
    }

    @Test
    public void testgetDSPaymentTypeSupPayDescription() {
        assertEquals("", instanceDSPaymentTypeSup.getDSPaymentTypeSupPayDescription());
    }

    @Test
    public void testsetDSPaymentTypeSupPayDescription() {
        instanceDSPaymentTypeSup.setDSPaymentTypeSupPayDescription(testsetDSPaymentTypeSupPayDescriptionArg1);
        assertNotNull(instanceDSPaymentTypeSup);
    }
}
