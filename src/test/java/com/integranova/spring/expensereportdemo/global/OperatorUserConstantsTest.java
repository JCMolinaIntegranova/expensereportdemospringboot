package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OperatorUserConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(OperatorUserConstants.getIdFields(null));
        assertNotNull(OperatorUserConstants.getIdFields(""));
        assertNotNull(OperatorUserConstants.getIdFields(AppUserConstants.CLASS_NAME));
        assertNotNull(OperatorUserConstants.getIdFields(AdminUserConstants.CLASS_NAME));
        assertNotNull(OperatorUserConstants.getIdFields(OperatorUserConstants.CLASS_NAME));
        assertNotNull(OperatorUserConstants.getIdFields(OperatorUserConstants.CLASS_NAME + OperatorUserConstants.CLASS_NAME));
    }
}
