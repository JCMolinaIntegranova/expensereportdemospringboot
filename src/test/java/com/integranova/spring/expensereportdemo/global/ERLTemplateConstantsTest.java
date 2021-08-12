package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERLTemplateConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ERLTemplateConstants.getIdFields(null));
        assertNotNull(ERLTemplateConstants.getIdFields(""));
        assertNotNull(ERLTemplateConstants.getIdFields(ERLTemplateConstants.CLASS_NAME));
        assertNotNull(ERLTemplateConstants.getIdFields(ERLTemplateConstants.CLASS_NAME + ERLTemplateConstants.CLASS_NAME));
    }
}
