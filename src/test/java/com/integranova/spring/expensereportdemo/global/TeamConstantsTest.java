package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeamConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(TeamConstants.getIdFields(null));
        assertNotNull(TeamConstants.getIdFields(""));
        assertNotNull(TeamConstants.getIdFields(TeamConstants.CLASS_NAME));
        assertNotNull(TeamConstants.getIdFields(TeamConstants.CLASS_NAME + TeamConstants.CLASS_NAME));
    }
}
