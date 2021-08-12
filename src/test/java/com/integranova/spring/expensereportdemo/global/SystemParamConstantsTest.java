package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SystemParamConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(SystemParamConstants.getIdFields(null));
        assertNotNull(SystemParamConstants.getIdFields(""));
        assertNotNull(SystemParamConstants.getIdFields(SystemParamConstants.CLASS_NAME));
        assertNotNull(SystemParamConstants.getIdFields(SystemParamConstants.CLASS_NAME + SystemParamConstants.CLASS_NAME));
    }
}
