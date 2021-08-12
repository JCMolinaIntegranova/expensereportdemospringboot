package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ProjectConstants.getIdFields(null));
        assertNotNull(ProjectConstants.getIdFields(""));
        assertNotNull(ProjectConstants.getIdFields(ProjectConstants.CLASS_NAME));
        assertNotNull(ProjectConstants.getIdFields(ProjectConstants.CLASS_NAME + ProjectConstants.CLASS_NAME));
    }
}
