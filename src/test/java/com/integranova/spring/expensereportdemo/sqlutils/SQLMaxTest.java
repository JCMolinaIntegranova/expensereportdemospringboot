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
public class SQLMaxTest {

	@Mock
	private static SQLMax mockSQLMax;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLMax = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLMax = new SQLMax(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLMax = new SQLMax("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLMax = new SQLMax(new SQLSelect(null), "Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLMax = new SQLMax("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
    		mockSQLMax = new SQLMax(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLMax = null;
    	}
    	assertNotNull(mockSQLMax);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLMax = new SQLMax(new SQLSelect(null), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLMax = new SQLMax(new SQLSelect(new SQLPopulation("SourceClass")), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLMax = null;
		}
    	assertNotNull(mockSQLMax.getSQLSentence());
    }
}


