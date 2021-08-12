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
public class SQLWhereOperandLiteralTest {

	SQLWhereOperandLiteral instance;
	
    @Before
    public void setUp() {
    	instance = new SQLWhereOperandLiteral("Literal", "String");
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
	
    @Test
    public void test4Constructor() {
    	assertNotNull(new SQLWhereOperandLiteral("Literal", "String"));
    }
    
    @Test
    public void test4Constructor2() {
    	assertNotNull(new SQLWhereOperandLiteral(Double.valueOf("1"), "Real"));
    }
    
    @Test
    public void test4setLiteral() {
    	String literal = "Literal";
    	instance.setLiteral(literal);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getLiteral() {
    	String literal = "Literal";
    	instance.setLiteral(literal);
    	assertEquals(literal, instance.getLiteral());
    }
    
    @Test
    public void test4processOperand() {
    	try {
			instance.processOperand(new SQLPopulation("ClassName"));
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			instance = null;
		}
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull() {
    	instance.setComparisonWithNull("=");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull2() {
    	instance.setComparisonWithNull("<>");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setComparisonWithNull3() {
    	instance.setComparisonWithNull("LIKE");
    	assertNotNull(instance);
    }
    
    @Test
    public void test4setProcessForLike() {
    	instance.setProcessForLike(false);
    }
    
    @Test
    public void test4setProcessForContains() {
    	instance.setProcessForContains(false);
    }
    
    @Test
    public void test4getProcessForLike() {
    	instance.setProcessForLike(true);
    	assertEquals(true, instance.getProcessForLike());
    }
    
    @Test
    public void test4getProcessForContains() {
    	instance.setProcessForContains(true);
    	assertEquals(true, instance.getProcessForContains());
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
    	instance.processForContainsOperator();
    	assertNotNull(instance);
    }
}

