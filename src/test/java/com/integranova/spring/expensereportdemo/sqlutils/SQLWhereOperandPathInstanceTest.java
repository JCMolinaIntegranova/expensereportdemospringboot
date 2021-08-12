package com.integranova.spring.expensereportdemo.sqlutils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereOperandPathInstanceTest {

	SQLWhereOperandPathInstance instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLWhereOperandPathInstance("Role", "ClassName");
    	instance.setSql(new SQLPopulation("ClassName"));
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4setPath() throws SystemException {
    	String path = "Path";
    	instance.setPath(path);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getPath() throws SystemException {
    	String path = "Path";
    	instance.setPath(path);
    	assertEquals(path, instance.getPath());
    }
    
    @Test
    public void test4processOperand() throws SystemException {
    	SQLPopulation sql = new SQLPopulation("ClassName");
    	instance.processOperand(sql);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull() {
    	instance.setCompareWithNull(false);
    	instance.setComparisonWithNull("=");
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
    	instance.setComparisonWithNull(">");
    	assertNotNull(instance);
    }
}
