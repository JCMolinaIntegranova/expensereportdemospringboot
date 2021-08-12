package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppUserConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(AppUserConstants.getIdFields(null));
        assertNotNull(AppUserConstants.getIdFields(""));
        assertNotNull(AppUserConstants.getIdFields(AppUserConstants.CLASS_NAME));
        assertNotNull(AppUserConstants.getIdFields(AdminUserConstants.CLASS_NAME));
        assertNotNull(AppUserConstants.getIdFields(OperatorUserConstants.CLASS_NAME));
        assertNotNull(AppUserConstants.getIdFields(AppUserConstants.CLASS_NAME + AppUserConstants.CLASS_NAME));
    }
}
