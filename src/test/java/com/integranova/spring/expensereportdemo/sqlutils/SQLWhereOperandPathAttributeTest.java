package com.integranova.spring.expensereportdemo.sqlutils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereOperandPathAttributeTest {

	SQLWhereOperandPathAttribute instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLWhereOperandPathAttribute("Role", "Attribute");
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
    public void test4setAlias() throws SystemException {
    	String alias = "Alias";
    	instance.setAlias(alias);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getAlias() throws SystemException {
    	String alias = "Alias";
    	instance.setAlias(alias);
    	assertEquals(alias, instance.getAlias());
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
