package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLOrderByItemTest {
	@Mock
	private static SQLOrderByItem mockSQLOrderByItem;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", true);
		} catch (SystemException e) {
			e.printStackTrace();
		}
    }
    
    @After
    public void tearDown() {
    	mockSQLOrderByItem = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", true);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", false);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem);
    }
    
    @Test
    public void test4getOrderByClause() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", false);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem.getOrderByClause());
    }
    
    @Test
    public void test4getItemName() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", false);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem.getItemName());
    }
    
    @Test
    public void test4getItemAlias() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", false);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem.getItemAlias());
    }
    
    @Test
    public void test4getIsAscending() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", true);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertTrue(mockSQLOrderByItem.getIsAscending());
    }
    
    @Test
    public void test4getText1() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", true);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem.getText());	
    }
    
    @Test
    public void test4getText2() {
    	try {
			mockSQLOrderByItem = new SQLOrderByItem(new SQLOrderBy(new SQLPopulation("className")), "itemName", true);
		} catch (SystemException e) {
			mockSQLOrderByItem = null;
		}
    	assertNotNull(mockSQLOrderByItem.getText());	
    }
}

