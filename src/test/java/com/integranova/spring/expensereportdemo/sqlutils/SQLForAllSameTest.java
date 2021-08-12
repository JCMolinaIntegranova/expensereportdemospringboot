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
public class SQLForAllSameTest {

	@Mock
	private static SQLForAllSame mockSQLForAllSame;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLForAllSame = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLForAllSame = new SQLForAllSame(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLForAllSame = null;
		}
    	assertNotNull(mockSQLForAllSame);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLForAllSame = new SQLForAllSame("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLForAllSame = null;
		}
    	assertNotNull(mockSQLForAllSame);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLForAllSame = new SQLForAllSame("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLForAllSame = null;
		}
    	assertNotNull(mockSQLForAllSame);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
    		mockSQLForAllSame = new SQLForAllSame(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLForAllSame = null;
    	}
    	assertNotNull(mockSQLForAllSame);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLForAllSame = new SQLForAllSame(null, "SourceClass", "invoices.amount");
		} catch (SystemException e) {
			mockSQLForAllSame = null;
		}
    	assertNotNull(mockSQLForAllSame.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLForAllSame = new SQLForAllSame(new SQLSelect(null), "SourceClass", "invoices.amount");
		} catch (SystemException e) {
			mockSQLForAllSame = null;
		}
    	assertNotNull(mockSQLForAllSame.getSQLSentence());
    }
}

