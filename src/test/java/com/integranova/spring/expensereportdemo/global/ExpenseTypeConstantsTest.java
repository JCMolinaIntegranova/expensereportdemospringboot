package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseTypeConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ExpenseTypeConstants.getIdFields(null));
        assertNotNull(ExpenseTypeConstants.getIdFields(""));
        assertNotNull(ExpenseTypeConstants.getIdFields(ExpenseTypeConstants.CLASS_NAME));
        assertNotNull(ExpenseTypeConstants.getIdFields(ExpenseTypeConstants.CLASS_NAME + ExpenseTypeConstants.CLASS_NAME));
    }
}
