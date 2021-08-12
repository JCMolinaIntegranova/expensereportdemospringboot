package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(AdminUserConstants.getIdFields(null));
        assertNotNull(AdminUserConstants.getIdFields(""));
        assertNotNull(AdminUserConstants.getIdFields(AppUserConstants.CLASS_NAME));
        assertNotNull(AdminUserConstants.getIdFields(AdminUserConstants.CLASS_NAME));
        assertNotNull(AdminUserConstants.getIdFields(OperatorUserConstants.CLASS_NAME));
        assertNotNull(AdminUserConstants.getIdFields(AdminUserConstants.CLASS_NAME + AdminUserConstants.CLASS_NAME));
    }
}
