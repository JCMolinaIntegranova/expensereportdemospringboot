package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.integranova.spring.expensereportdemo.exception.SystemException;

public class SQLWhereOperandThisTest {

	SQLWhereOperandThis instance;
	
    @Before
    public void setUp() {
    	instance = new SQLWhereOperandThis();
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4processOperand1() {
    	try {
			instance.processOperand(new SQLPopulation("className"));
		} catch (SystemException e) {
			instance = null;
		}
    	assertNotNull(instance);
    }

    @Test
    public void test4processOperand2() {
    	try {
			instance.processOperand(new SQLSelect(new SQLPopulation("className")));
		} catch (SystemException e) {
			instance = null;
		}
    	assertNotNull(instance);
    }
    
}

