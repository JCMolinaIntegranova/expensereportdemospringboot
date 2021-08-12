package com.integranova.spring.expensereportdemo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.api.AccountApiController;

@RunWith(MockitoJUnitRunner.class)
public class ExpensereportdemoApplicationTests {

    @Mock
    AccountApiController accountApiController;

    @Test
    public void contextLoads() {
        assertNotNull(accountApiController);
    }
}
