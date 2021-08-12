package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeHistoryConstantsTest {

    @Test
    public void test4getIdFields() {
        assertNotNull(ExchangeHistoryConstants.getIdFields(null));
        assertNotNull(ExchangeHistoryConstants.getIdFields(""));
        assertNotNull(ExchangeHistoryConstants.getIdFields(ExchangeHistoryConstants.CLASS_NAME));
        assertNotNull(ExchangeHistoryConstants.getIdFields(ExchangeHistoryConstants.CLASS_NAME + ExchangeHistoryConstants.CLASS_NAME));
    }
}
