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
public class SQLForAllDistinctTest {

	@Mock
	private static SQLForAllDistinct mockSQLForAllDistinct;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLForAllDistinct = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLForAllDistinct = new SQLForAllDistinct(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLForAllDistinct = null;
		}
    	assertNotNull(mockSQLForAllDistinct);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLForAllDistinct = new SQLForAllDistinct("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLForAllDistinct = null;
		}
    	assertNotNull(mockSQLForAllDistinct);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLForAllDistinct = new SQLForAllDistinct("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLForAllDistinct = null;
		}
    	assertNotNull(mockSQLForAllDistinct);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
    		mockSQLForAllDistinct = new SQLForAllDistinct(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLForAllDistinct = null;
    	}
    	assertNotNull(mockSQLForAllDistinct);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLForAllDistinct = new SQLForAllDistinct(new SQLSelect(null), "SourceClass", "invoices.amount");
		} catch (SystemException e) {
			mockSQLForAllDistinct = null;
		}
    	assertNotNull(mockSQLForAllDistinct.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLForAllDistinct = new SQLForAllDistinct(new SQLSelect(null), "SourceClass", "invoices.amount");
			mockSQLForAllDistinct.setIsDistinct(true);
		} catch (SystemException e) {
			mockSQLForAllDistinct = null;
		}
    	assertNotNull(mockSQLForAllDistinct.getSQLSentence());
    }
}

