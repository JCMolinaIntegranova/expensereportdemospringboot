package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLParamTest {

	SQLParam instance;
	String paramName = "paramName";
	String modifiedParamName = "modified";
	int paramValue = 1;
	int modifiedParamValue = 2;
	String paramType = "Nat";
	
    @Before
    public void setUp() {
    	instance = new SQLParam(paramName, paramValue);
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor1() {
    	instance = new SQLParam(paramName, paramValue);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4Constructor2() {
    	instance = new SQLParam(paramName, paramValue, paramType);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getParamName() {
    	assertEquals(paramName, instance.getParamName());
    }
    
    @Test
    public void test4setParamName() {
    	instance.setParamName(modifiedParamName);
    	assertEquals(modifiedParamName, instance.getParamName());
    }
    
    @Test
    public void test4getParamValue() {
    	assertEquals(paramValue, instance.getParamValue());
    }
    
    @Test
    public void test4setParamValue() {
    	instance.setParamValue(modifiedParamValue);
    	assertEquals(modifiedParamValue, instance.getParamValue());
    }
    
    @Test
    public void test4getParamType1() {
    	assertNull(instance.getParamType());
    }
    
    @Test
    public void test4getParamType2() {
    	instance = new SQLParam(paramName, paramValue, paramType);
    	assertEquals(paramType, instance.getParamType());
    }
}

