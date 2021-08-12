package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTypeConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(PaymentTypeConstants.getIdFields(null));
        assertNotNull(PaymentTypeConstants.getIdFields(""));
        assertNotNull(PaymentTypeConstants.getIdFields(PaymentTypeConstants.CLASS_NAME));
        assertNotNull(PaymentTypeConstants.getIdFields(PaymentTypeConstants.CLASS_NAME + PaymentTypeConstants.CLASS_NAME));
    }
}
