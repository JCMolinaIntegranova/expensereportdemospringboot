package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SPResultRowTest {

	private static Object value1;
	private static Object value2;
	private static Object value3;
	private static String name1;
	private static String name2;
	private static String name3;
	private static String unexisting;
	
	private static Object[] row;
	private static List<String> fieldNames;
	private static List<SPResultRowField> fields;
	
	private SPResultRow instanceSPResultRow;
	
    @BeforeClass
    public static void setUpClass() {
    	setUpMockData();
    }
    
    private static void setUpMockData() {
    	value1 = "value1";
    	value2 = "value2";
    	value3 = null;
    	name1 = "name1";
    	name2 = "name2";
    	name3 = "name3";
    	unexisting = "unexisting";
    	row = new Object[]{value1, value2, value3};
    	fieldNames = new ArrayList<>();
    	fieldNames.add(name1);
    	fieldNames.add(name2);
    	fieldNames.add(name3);
    	fields = new ArrayList<>();
    	fields.add(new SPResultRowField(name1, value1));
    	fields.add(new SPResultRowField(name2, value2));
    	fields.add(new SPResultRowField(name3, value3));
    }
    
    @Before
    public void setUp() {
    	instanceSPResultRow = new SPResultRow(row, fieldNames);
    }
    
    @After
    public void tearDown() {
    	instanceSPResultRow = null;
    }
    
    @Test
    public void test4getExistingField() {
    	assertEquals(value1, instanceSPResultRow.getField(name1));
    }
    
    @Test
    public void test4getUnexistingField() {
    	assertNull(instanceSPResultRow.getField(unexisting));
    }
    
    @Test
    public void test4hasExistingField() {
    	assertTrue(instanceSPResultRow.hasField(name1));
    }
    
    @Test
    public void test4hasUnexistingField() {
    	assertFalse(instanceSPResultRow.hasField(unexisting));
    }
    
    @Test
    public void test4hasExistingNullField() {
    	assertFalse(instanceSPResultRow.hasField(name3));
    }
}

