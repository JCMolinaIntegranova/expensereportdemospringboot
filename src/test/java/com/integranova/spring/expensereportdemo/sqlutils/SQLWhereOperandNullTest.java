package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereOperandNullTest {

	SQLWhereOperandNull instance;
	
    @Before
    public void setUp() {
    	instance = new SQLWhereOperandNull();
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4setComparisonWithNull1() {
    	instance.setCompareWithNull(true);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull2() {
    	instance.setCompareWithNull(false);
    	instance.setComparisonWithNull("<>");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull3() {
    	instance.setCompareWithNull(false);
    	instance.setComparisonWithNull("=");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull4() {
    	instance.setCompareWithNull(false);
    	instance.setComparisonWithNull("*");
    	assertNotNull(instance);
    }
}

