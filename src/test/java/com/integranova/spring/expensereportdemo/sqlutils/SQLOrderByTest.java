package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLOrderByTest {

	@Mock
	private static SQLOrderBy mockSQLOrderBy;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLOrderBy = null;
    }
    
    @Test
    public void test4Constructor1() {
    	mockSQLOrderBy = new SQLOrderBy();
    	assertNotNull(mockSQLOrderBy);
    }
	
    @Test
    public void test4Constructor2() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4addItem1() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	mockSQLOrderBy.addItem("item", true);
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4addItem2() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	mockSQLOrderBy.addItem("2", false);
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4addItem3() {
    	try {
    		mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
			mockSQLOrderBy.addItem("itemName", "className", null, "parameterName", true);
		} catch (SystemException e) {
			mockSQLOrderBy = null;
		}
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4addItem4() {
    	try {
    		mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
			mockSQLOrderBy.addItem("itemName", "className", null, "parameterName", false);
		} catch (SystemException e) {
			mockSQLOrderBy = null;
		}
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4fixInstance() {
    	try {
    		mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
			mockSQLOrderBy.fixInstance(null, null);
		} catch (SystemException e) {
			mockSQLOrderBy = null;
		}
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4getItems() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	mockSQLOrderBy.getItems();
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4getSelect() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	mockSQLOrderBy.getSelect();
    	assertNotNull(mockSQLOrderBy);
    }
    
    @Test
    public void test4getText() {
    	mockSQLOrderBy = new SQLOrderBy(new SQLSelect(null));
    	mockSQLOrderBy.getText();
    	assertNotNull(mockSQLOrderBy);
    }
}


