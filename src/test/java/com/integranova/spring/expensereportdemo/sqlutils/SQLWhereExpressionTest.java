package com.integranova.spring.expensereportdemo.sqlutils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereExpressionTest {

	SQLWhereExpression instance;
	
    @Before
    public void setUp() {
    	SQLPopulation sql;
		try {
			sql = new SQLPopulation("ClassName");
			instance = new SQLWhereExpression(sql);
		} catch (SystemException e) {
			sql = null;
			e.printStackTrace();
		}
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor() {
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setOperator() {
    	instance.setOperator("=");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setOperator2() {
    	instance.setOperator("mod");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getOperator() {
    	String operator = "=";
    	instance.setOperator(operator);
    	assertEquals(operator, instance.getOperator());
    }
    
    @Test
    public void test4setFirstOperand() throws SystemException {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("FirstOperand", "String");
    	instance.setFirstOperand(operand);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setFirstOperand2() throws SystemException {
    	instance.setFirstOperand(null);
    	assertNotNull(instance);
    }
	
    @Test
    public void test4getFirstOperand() throws SystemException {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("FirstOperand", "String");
    	instance.setFirstOperand(operand);
    	assertEquals(operand, instance.getFirstOperand());
    }
    
    @Test
    public void test4setSecondOperand() throws SystemException {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("SecondOperand", "String");
    	instance.setSecondOperand(operand);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setSecondOperand2() throws SystemException {
    	instance.setSecondOperand(null);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getSecondOperand() throws SystemException {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("SecondOperand", "String");
    	instance.setSecondOperand(operand);
    	assertEquals(operand, instance.getSecondOperand());
    }
    
    @Test
    public void test4gatherParameters() {
    	List<SQLParam> parametersList = new ArrayList<>();
    	instance.gatherParameters(parametersList);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4gatherParameters2() throws SystemException {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("FirstOperand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("SecondOperand", "String"));
    	instance.setOperator("<>");
    	List<SQLParam> parametersList = new ArrayList<>();
    	instance.gatherParameters(parametersList);
    	assertNotNull(instance);
    }
}

