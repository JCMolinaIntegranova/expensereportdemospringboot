package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.utils.Agent;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLSelectTest {

	SQLSelect instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLPopulation("ClassName");
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4setIsTextBlob() {
    	instance.setIsTextBlob(true);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getIsTextBlob() {
    	instance.setIsTextBlob(true);
    	assertTrue(instance.getIsTextBlob());
    }
    
    @Test
    public void test4setIsDistinct() {
    	instance.setIsDistinct(true);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getIsDistinct() {
    	instance.setIsDistinct(true);
    	assertTrue(instance.getIsDistinct());
    }
    
    @Test
    public void test4getArrayParameters() {
    	assertEquals(0, instance.getArrayParameters().size());
    }
    
    @Test
    public void test4setArrayParameters() {
    	List<SQLParam> params = new ArrayList<>();
    	instance.setArrayParameters(params);
    	assertEquals(params, instance.getArrayParameters());
    }
    
    @Test
    public void test4getSQLSentence() {
    	assertNotNull(instance.getSQLSentence());
    }
    
    @Test
    public void test4setSQLSentence() {
    	String sqlSentence = "SQLSentence";
    	instance.setSQLSentence(sqlSentence);
    	assertEquals(sqlSentence, instance.getSQLSentence());
    }
    
    @Test
    public void test4getSQLCountSentence() throws SystemException {
    	assertNotNull(instance.getSQLCountSentence());
    }
    
    @Test
    public void test4getJPQLSentence() throws SystemException {
    	assertNotNull(instance.getJPQLSentence());
    }
    
    @Test
    public void test4setConnectedAgent() {
    	Agent agent = new Agent();
    	instance.setConnectedAgent(agent);
    	assertEquals(agent, instance.getConnectedAgent());
    }
    
    @Test
    public void test4setSelectedObjectOID() {
    	instance.setSelectedObjectOID(null);
    	assertNull(instance.getSelectedObjectOID());
    }
    
    @Test
    public void test4setObjectValuedParameterName() {
    	String parameterName = "ParameterName";
    	instance.setObjectValuedParameterName(parameterName);
    	assertEquals(parameterName, instance.getObjectValuedParameterName());
    }
    
    @Test
    public void test4setClassNameInGlobalService() {
    	String className = "ClassName";
    	instance.setClassNameInGlobalService(className);
    	instance.setClassNameInGlobalService(null);
    	assertNull(instance.getClassNameInGlobalService());
    }
    
    @Test
    public void test4setFilterVariables() {
    	Map<String, Object> variables = new HashMap<>();
    	variables.put("var1", "value1");
    	variables.put("var2", "value2");
    	instance.setFilterVariables(variables);
    	assertEquals(variables, instance.getFilterVariables());
    	assertEquals(0, instance.getFilterVariablesTypes().size());
    }
    
    @Test
    public void test4setFilterVariablesTypes() {
    	Map<String, String> variables = new HashMap<>();
    	variables.put("var1", "String");
    	variables.put("var2", "String");
    	instance.setFilterVariablesTypes(variables);
    	assertEquals(variables.size(), instance.getFilterVariablesTypes().size());
    }
    
    @Test
    public void test4addFilterVariable() {
    	instance.addFilterVariable("variable", "String", "value");
    	assertEquals(1, instance.getFilterVariables().size());
    	assertFalse(instance.hasOVFilterVariable("variable"));
    }
    
    @Test
    public void test4addServiceArgument() {
    	instance.addServiceArgument("argument", "String", "value");
    	assertEquals(1, instance.getServiceArguments().size());
    	assertFalse(instance.hasOVServiceArgument("argument"));
    }
    
    @Test
    public void test4setServiceArguments() {
    	Map<String, Object> args = new HashMap<>();
    	args.put("arg1", "value1");
    	args.put("arg2", "value2");
    	instance.setServiceArguments(args);
    	assertEquals(args, instance.getServiceArguments());
    	assertEquals(0, instance.getServiceArgumentsTypes().size());
    }
    
    @Test
    public void test4setServiceArgumentsTypes() {
    	Map<String, String> args = new HashMap<>();
    	args.put("arg1", "value1");
    	args.put("arg2", "value2");
    	instance.setServiceArgumentsTypes(args);
    	assertEquals(args.size(), instance.getServiceArgumentsTypes().size());
    }
 
    @Test
    public void test4setSelectPart() {
    	List<String> selectPart = new ArrayList<>();
    	instance.setSelectPart(selectPart);
    	assertEquals(selectPart, instance.getSelectPart());
    }
    
    @Test
    public void test4IsObjectValued() {
    	assertFalse(instance.isObjectValued("String"));
    	assertFalse(instance.isObjectValued("Nat"));
    	assertFalse(instance.isObjectValued("Int"));
    	assertFalse(instance.isObjectValued("Integer"));
    	assertFalse(instance.isObjectValued("Real"));
    	assertFalse(instance.isObjectValued("Double"));
    	assertFalse(instance.isObjectValued("Bool"));
    	assertFalse(instance.isObjectValued("Boolean"));
    	assertFalse(instance.isObjectValued("Date"));
    	assertFalse(instance.isObjectValued("Time"));
    	assertFalse(instance.isObjectValued("DateTime"));
    	assertFalse(instance.isObjectValued("Timestamp"));
    	assertFalse(instance.isObjectValued("Text"));
    	assertFalse(instance.isObjectValued(""));
    	assertTrue(instance.isObjectValued("ClassName"));
    }
}
