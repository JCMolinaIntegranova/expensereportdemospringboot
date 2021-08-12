package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(AssignmentConstants.getIdFields(null));
        assertNotNull(AssignmentConstants.getIdFields(""));
        assertNotNull(AssignmentConstants.getIdFields(AssignmentConstants.CLASS_NAME));
        assertNotNull(AssignmentConstants.getIdFields(AssignmentConstants.CLASS_NAME + AssignmentConstants.CLASS_NAME));
    }
}
