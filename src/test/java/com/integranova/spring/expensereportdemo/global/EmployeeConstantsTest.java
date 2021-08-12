package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(EmployeeConstants.getIdFields(null));
        assertNotNull(EmployeeConstants.getIdFields(""));
        assertNotNull(EmployeeConstants.getIdFields(EmployeeConstants.CLASS_NAME));
        assertNotNull(EmployeeConstants.getIdFields(EmployeeConstants.CLASS_NAME + EmployeeConstants.CLASS_NAME));
    }
}
