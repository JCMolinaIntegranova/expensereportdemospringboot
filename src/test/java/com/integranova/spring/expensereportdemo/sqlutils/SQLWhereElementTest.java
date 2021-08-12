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
public class SQLWhereElementTest {

	SQLWhereElement instance;
	
    @Before
    public void setUp() {
    	instance = new SQLWhereElement();
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
	
    @Test
    public void test4Constructor() {
    	instance = new SQLWhereElement();
    	assertNotNull(instance);
    }
    
    @Test
    public void test4Constructor2() {
    	SQLWhere whereClause = new SQLWhere();
    	instance = new SQLWhereElement(whereClause);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4Constructor3() {
    	SQLWhereElement owningElement = new SQLWhereElement();
    	instance = new SQLWhereElement(owningElement);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getOwningElement() {
    	SQLWhereElement owningElement = new SQLWhereElement();
    	instance = new SQLWhereElement(owningElement);
    	assertNotNull(instance.getOwningElement());
    }
    
    @Test
    public void test4getOwnedElements() {
    	assertEquals(0, instance.getOwnedElements().size());
    }
    
    @Test
    public void test4setOwnedElements() {
    	List<SQLWhereElement> ownedElements = new ArrayList<>();
    	instance.setOwnedElements(ownedElements);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4getWhereClause() {
    	instance = new SQLWhereElement(new SQLWhere());
    	assertNotNull(instance.getWhereClause());
    }
    
    @Test
    public void test4getWhereClause2() {
    	SQLWhereElement owningElement = new SQLWhereElement(new SQLWhere());
    	instance = new SQLWhereElement(owningElement);
    	assertNotNull(instance.getWhereClause());
    }
    
    @Test
    public void test4getText() throws SystemException {
    	assertEquals("", instance.getText());
    }
}

