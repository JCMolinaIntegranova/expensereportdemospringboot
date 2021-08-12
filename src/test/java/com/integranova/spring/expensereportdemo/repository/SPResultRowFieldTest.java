package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SPResultRowFieldTest {

	private static String name;
	private static Object value;
	private SPResultRowField instanceSPResultRowField;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }

    private static void setUpMockData() {
    	name = "name";
    	value = null;
    }
    
    @Before
    public void setUp() {
    	instanceSPResultRowField = new SPResultRowField(name, value);
    }
    
    @After
    public void tearDown() {
    	instanceSPResultRowField = null;
    }
    
    @Test
    public void test4getName() {
    	assertEquals(name, instanceSPResultRowField.getName());
    }
    
    @Test
    public void test4getValue() {
    	assertEquals(value, instanceSPResultRowField.getValue());
    }
}
