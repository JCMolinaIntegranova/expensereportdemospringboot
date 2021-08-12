package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERTemplateConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ERTemplateConstants.getIdFields(null));
        assertNotNull(ERTemplateConstants.getIdFields(""));
        assertNotNull(ERTemplateConstants.getIdFields(ERTemplateConstants.CLASS_NAME));
        assertNotNull(ERTemplateConstants.getIdFields(ERTemplateConstants.CLASS_NAME + ERTemplateConstants.CLASS_NAME));
    }
}
