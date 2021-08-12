package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseCurrencyConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ExpenseCurrencyConstants.getIdFields(null));
        assertNotNull(ExpenseCurrencyConstants.getIdFields(""));
        assertNotNull(ExpenseCurrencyConstants.getIdFields(ExpenseCurrencyConstants.CLASS_NAME));
        assertNotNull(ExpenseCurrencyConstants.getIdFields(ExpenseCurrencyConstants.CLASS_NAME + ExpenseCurrencyConstants.CLASS_NAME));
    }
}
