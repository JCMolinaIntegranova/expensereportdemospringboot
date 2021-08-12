package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SPParameterTest {

	private static String name;
	private static Object value;
	private static String mode;
	private SPParameter instanceSPParameter;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }

    private static void setUpMockData() {
    	name = "name";
    	value = null;
    	mode = "mode";
    }
    
    @Before
    public void setUp() {
    	instanceSPParameter = new SPParameter(name, value, mode);
    }
    
    @After
    public void tearDown() {
    	instanceSPParameter = null;
    }
    
    @Test
    public void test4getName() {
    	assertEquals(name, instanceSPParameter.getName());
    }
    
    @Test
    public void test4getValue() {
    	assertEquals(value, instanceSPParameter.getValue());
    }
    
    @Test
    public void test4getMode() {
    	assertFalse(instanceSPParameter.isInput());
    }
    
    @Test
    public void test4isInput() {
    	instanceSPParameter = new SPParameter(name, value, SPParameter.INPUT);
    	assertTrue(instanceSPParameter.isInput());
    }
    
    @Test
    public void test4isOutput() {
    	instanceSPParameter = new SPParameter(name, value, SPParameter.OUTPUT);
    	assertTrue(instanceSPParameter.isOutput());
    }
    
    @Test
    public void test4isInOut() {
    	assertFalse(instanceSPParameter.isInOut());
    	instanceSPParameter = new SPParameter(name, value, SPParameter.INOUT);
    	assertTrue(instanceSPParameter.isInOut());
    	instanceSPParameter = new SPParameter(name, value, SPParameter.INPUT);
    	assertFalse(instanceSPParameter.isInOut());
    	instanceSPParameter = new SPParameter(name, value, SPParameter.OUTPUT);
    	assertFalse(instanceSPParameter.isInOut());
    }
}
