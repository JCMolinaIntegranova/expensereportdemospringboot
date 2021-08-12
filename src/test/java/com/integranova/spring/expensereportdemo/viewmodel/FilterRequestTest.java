package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FilterRequestTest {

	private FilterRequest instanceFilterRequest;

	private static String mock4Name;
	private static List<FilterVariableRequest> mock4Variables;
	
    @Before
    public void setUp() {
    	mock4Name = "name";
    	mock4Variables = new ArrayList<>();
    	instanceFilterRequest = new FilterRequest(mock4Name, mock4Variables);
    }
   
    @Test
    public void test4DefaultConstructor() {
    	instanceFilterRequest = new FilterRequest();
    	assertNotNull(instanceFilterRequest);
    }
    
    @Test
    public void test4Constructor() {
    	instanceFilterRequest = new FilterRequest(mock4Name, mock4Variables);
    	assertNotNull(instanceFilterRequest);
    }
    
    @Test
    public void test4getName() {
    	assertEquals(mock4Name, instanceFilterRequest.getName());
    }
    
    @Test
    public void test4setName() {
    	String name = "name";
    	instanceFilterRequest.setName(name);
    	assertEquals(name, instanceFilterRequest.getName());
    }
    
    @Test
    public void test4getVariables() {
    	assertEquals(mock4Variables, instanceFilterRequest.getVariables());
    }
    
    @Test
    public void test4addFilterVariable() {
    	String fvarName = "filterVariable";
    	Long fvarValue = Long.valueOf(1);
    	FilterVariableRequest filterVariableRequest = new FilterVariableRequest(fvarName, fvarValue);
    	instanceFilterRequest.addFilterVariable(filterVariableRequest);
    	assertEquals(fvarValue, instanceFilterRequest.getFilterVariable(fvarName));
    }
    
    @Test
    public void test4addFilterVariable2() {
    	String fvarName = "filterVariable";
    	Long fvarValue = Long.valueOf(1);
    	instanceFilterRequest.addFilterVariable(fvarName, fvarValue);
    	assertEquals(fvarValue, instanceFilterRequest.getFilterVariable(fvarName));
    }
    
    @Test
    public void test4getFilterVariable() {
    	String fvarName = "filterVariable";
    	Long fvarValue = Long.valueOf(1);
    	FilterVariableRequest filterVariableRequest = new FilterVariableRequest(fvarName, fvarValue);
    	instanceFilterRequest.addFilterVariable(filterVariableRequest);
    	assertEquals(fvarValue, instanceFilterRequest.getFilterVariable(fvarName));
    }
    
    @Test
    public void test4getFilterVariable2() {
    	String fvarName = "filterVariable";
    	Long fvarValue = Long.valueOf(1);
    	FilterVariableRequest filterVariableRequest = new FilterVariableRequest(fvarName, fvarValue);
    	instanceFilterRequest.addFilterVariable(filterVariableRequest);
    	assertEquals(fvarValue, instanceFilterRequest.getFilterVariable(fvarName, FilterVariableRequest.INT));
    }
    
    @Test
    public void test4hasFilterVariable() {
    	String fvarName = "filterVariable";
    	Long fvarValue = Long.valueOf(1);
    	FilterVariableRequest filterVariableRequest = new FilterVariableRequest(fvarName, fvarValue);
    	instanceFilterRequest.addFilterVariable(filterVariableRequest);
    	assertTrue(instanceFilterRequest.hasFilterVariable(fvarName));
    }
    
    @Test
    public void test4hasFilterVariable2() {
    	String fvarName = "filterVariable";
    	assertFalse(instanceFilterRequest.hasFilterVariable(fvarName));
    }
}
