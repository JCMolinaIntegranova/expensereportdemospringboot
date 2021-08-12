package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereOperandOVParameterAttributeTest {

	SQLWhereOperandOVParameterAttribute instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLWhereOperandOVParameterAttribute("ParameterName.Role", "ParameterClassName", null, "ParameterName", "ParameterClassName");
    	instance.setSql(new SQLPopulation("ClassName"));
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4getParameterValue() {
    	assertNull(instance.getParameterValue());
    }
    
    @Test
    public void test4processOperand() throws SystemException {
    	SQLPopulation sql = new SQLPopulation("ClassName");
    	instance.processOperand(sql);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setCompareWithNull() {
    	instance.setCompareWithNull(true);
    	assertTrue(instance.getCompareWithNull());
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
    
    @Test
    public void test4processForLikeOperator() {
    	instance.setProcessForLike(true);
    	instance.processForLikeOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForLikeOperator2() {
    	instance.setProcessForLike(false);
    	instance.setType("String");
    	instance.processForLikeOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForLikeOperator3() {
    	instance.setProcessForLike(false);
    	instance.setType("Text");
    	instance.processForLikeOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForLikeOperator4() {
    	instance.setProcessForLike(false);
    	instance.setType("Date");
    	instance.processForLikeOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForContainsOperator() {
    	instance.setProcessForContains(true);
    	instance.processForContainsOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForContainsOperator2() {
    	instance.setProcessForContains(false);
    	instance.setType("String");
    	instance.processForContainsOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForContainsOperator3() {
    	instance.setProcessForContains(false);
    	instance.setType("Text");
    	instance.processForContainsOperator();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4processForContainsOperator4() {
    	instance.setProcessForContains(false);
    	instance.setType("Date");
    	instance.processForContainsOperator();
    	assertNotNull(instance);
    }

}
