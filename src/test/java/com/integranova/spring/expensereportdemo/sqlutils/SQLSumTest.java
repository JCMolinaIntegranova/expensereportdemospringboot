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
public class SQLSumTest {

	@Mock
	private static SQLSum mockSQLSum;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLSum = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLSum = new SQLSum(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLSum = new SQLSum("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLSum = new SQLSum(new SQLSelect(null), "Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLSum = new SQLSum("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
    		mockSQLSum = new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLSum = null;
    	}
    	assertNotNull(mockSQLSum);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLSum = new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLSum = new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute");
			mockSQLSum.setIsDistinct(true);
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence3() {
    	try {
			mockSQLSum = new SQLSum(new SQLSelect(new SQLPopulation("SourceClass")), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLSum = null;
		}
    	assertNotNull(mockSQLSum.getSQLSentence());
    }
}


