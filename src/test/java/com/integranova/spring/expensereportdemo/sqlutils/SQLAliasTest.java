package com.integranova.spring.expensereportdemo.sqlutils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLAliasTest {

	SQLAlias instance;
	
    @Before
    public void setUp() {
    	instance = new SQLAlias("Path", "Facet", true, "Alias");
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor() {
    	assertNotNull(new SQLAlias("Path", "Facet", true, "Alias"));
    }
    
    @Test
    public void test4getIntermediate() {
    	assertTrue(instance.getIntermediate());
    }
    
    @Test
    public void test4setPath() {
    	String path = "Path";
    	instance.setPath(path);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getPath() {
    	String path = "Path";
    	instance.setPath(path);
    	assertEquals(path, instance.getPath());
    }
    
    @Test
    public void test4getFacet() {
    	assertEquals("Facet", instance.getFacet());
    }
    
    @Test
    public void test4getAlias() {
    	assertEquals("Alias", instance.getAlias());
    }
    
    @Test
    public void test4setSQLFrom() {
    	SQLFrom sqlFrom = new SQLFrom();
    	instance.setSqlFrom(sqlFrom);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getSQLFrom() {
    	SQLFrom sqlFrom = new SQLFrom();
    	instance.setSqlFrom(sqlFrom);
    	assertEquals(sqlFrom, instance.getSqlFrom());
    }
    
    @Test
    public void test4setAssignedParameterName() {
    	instance.setAssignedParameterName("assignedParameterName");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getRightMultiCounter() {
    	Integer expected = 0;
    	assertEquals(expected, instance.getRightMultiCounter());
    }
    
    @Test
    public void test4getLeftMultiCounter() {
    	Integer expected = 0;
    	assertEquals(expected, instance.getLeftMultiCounter());
    }
    
    @Test
    public void test4copyCounters() {
    	instance.copyCounters(null);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4copyCounters2() {
    	instance.copyCounters(new SQLAlias("Path", "Facet", true, "Alias"));
    	assertNotNull(instance);
    }
    
    @Test
    public void test4increaseCounters() {
    	assertFalse(instance.increaseCounters(new SQLJoin("INNER","Table", instance, instance)));
    }
    
    @Test
    public void test4setJoinsToInnerType() {
    	instance.setJoinsToInnerType();
    	assertNotNull(instance);
    }
}
