package com.integranova.spring.expensereportdemo.sqlutils;
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
public class SQLWhereNegationTest {

	SQLWhereNegation instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLWhereNegation(new SQLPopulation("ClassName"));
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor() throws SystemException {
    	assertNotNull(new SQLWhereNegation(new SQLPopulation("ClassName")));
    }
    
    @Test
    public void test4addOperand() {
    	instance.addOperand(new SQLWhereOperandLiteral(true, "Bool"));
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getText() {
    	instance.addOperand(new SQLWhereOperandLiteral(true, "Bool"));
    	assertNotNull(instance.getText());
    }
    
    @Test
    public void test4gatherParameters() {
    	List<SQLParam> parametersList = new ArrayList<>();
    	instance.gatherParameters(parametersList);
    	assertNotNull(instance);
    }
}
