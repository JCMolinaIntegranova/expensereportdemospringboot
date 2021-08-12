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
public class SQLWhereComparisonTest {

	SQLWhereComparison instance;
	
    @Before
    public void setUp() {
    	SQLPopulation sql;
		try {
			sql = new SQLPopulation("ClassName");
		} catch (SystemException e) {
			sql = null;
			e.printStackTrace();
		}
    	instance = new SQLWhereComparison(sql);
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor() {
    	try {
    		instance = new SQLWhereComparison(new SQLPopulation("ClassName"));
    	} catch (Exception e) {
    		instance = new SQLWhereComparison(null);
    	}
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setFirstOperand() {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("FirstOperand", "String");
    	instance.setFirstOperand(operand);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setFirstOperand2() {
    	instance.setFirstOperand(null);
    	assertNotNull(instance);
    }
	
    @Test
    public void test4getFirstOperand() {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("FirstOperand", "String");
    	instance.setFirstOperand(operand);
    	assertEquals(operand, instance.getFirstOperand());
    }
    
    @Test
    public void test4setSecondOperand() {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("SecondOperand", "String");
    	instance.setSecondOperand(operand);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setSecondOperand2() {
    	instance.setSecondOperand(null);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getSecondOperand() {
    	SQLWhereOperand operand = new SQLWhereOperandLiteral("SecondOperand", "String");
    	instance.setSecondOperand(operand);
    	assertEquals(operand, instance.getSecondOperand());
    }
    
    @Test
    public void test4setOperator() {
    	instance.setOperator("LIKE");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getOperator() {
    	String operator = "LIKE";
    	instance.setOperator(operator);
    	assertEquals(operator, instance.getOperator());
    }
    
    @Test
    public void test4getOperandText() {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("FirstOperand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("SecondOperand", "String"));
    	instance.setOperator("LIKE");
    	assertNotNull(instance.getOperandText());
    }
    
    @Test
    public void test4getSelect() {
    	assertNotNull(instance.getSelect());
    }
    
    @Test
    public void test4getText() {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("FirstOperand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("SecondOperand", "String"));
    	instance.setOperator("<>");
    	assertNotNull(instance.getText());
    }
    
    @Test
    public void test4getText2() {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("Operand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("Operand", "String"));
    	instance.setOperator("LIKE");
    	assertNotNull(instance.getText());
    }
    
    @Test
    public void test4getText3() {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("FirstOperand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("First", "String"));
    	instance.setOperator("CONTAINS");
    	assertNotNull(instance.getText());
    }
    
    @Test
    public void test4gatherParameters() {
    	List<SQLParam> parametersList = new ArrayList<>();
    	instance.gatherParameters(parametersList);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4gatherParameters2() {
    	instance.setFirstOperand(new SQLWhereOperandLiteral("FirstOperand", "String"));
    	instance.setSecondOperand(new SQLWhereOperandLiteral("SecondOperand", "String"));
    	instance.setOperator("<>");
    	List<SQLParam> parametersList = new ArrayList<>();
    	instance.gatherParameters(parametersList);
    	assertNotNull(instance);
    }
}

