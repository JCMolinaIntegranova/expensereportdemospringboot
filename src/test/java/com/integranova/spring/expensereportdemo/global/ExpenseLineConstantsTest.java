package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseLineConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ExpenseLineConstants.getIdFields(null));
        assertNotNull(ExpenseLineConstants.getIdFields(""));
        assertNotNull(ExpenseLineConstants.getIdFields(ExpenseLineConstants.CLASS_NAME));
        assertNotNull(ExpenseLineConstants.getIdFields(ExpenseLineConstants.CLASS_NAME + ExpenseLineConstants.CLASS_NAME));
    }
}
