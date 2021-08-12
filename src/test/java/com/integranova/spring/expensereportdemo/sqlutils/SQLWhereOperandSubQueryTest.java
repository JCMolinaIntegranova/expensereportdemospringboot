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
public class SQLWhereOperandSubQueryTest {

	SQLWhereOperandSubQuery instance;
	
    @Before
    public void setUp() throws SystemException {
    	SQLScalar sqlScalar = new SQLScalar(null, "ClassName", "RoleName", "AttributName", null, "", "");
    	instance = new SQLWhereOperandSubQuery(sqlScalar);
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
    public void test4processOperand() throws SystemException {
    	SQLPopulation sql = new SQLPopulation("ClassName");
    	instance.processOperand(sql);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getText() {
    	assertNotNull(instance.getText());
    }
    
    @Test
    public void test4getParameters() {
    	assertEquals(0, instance.getParameters().size());
    }
    
}
