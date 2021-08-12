package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseReportConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ExpenseReportConstants.getIdFields(null));
        assertNotNull(ExpenseReportConstants.getIdFields(""));
        assertNotNull(ExpenseReportConstants.getIdFields(ExpenseReportConstants.CLASS_NAME));
        assertNotNull(ExpenseReportConstants.getIdFields(ExpenseReportConstants.CLASS_NAME + ExpenseReportConstants.CLASS_NAME));
    }
}
