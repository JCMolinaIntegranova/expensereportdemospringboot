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
public class SQLMinTest {

	@Mock
	private static SQLMin mockSQLMin;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLMin = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLMin = new SQLMin(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLMin = new SQLMin("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLMin = new SQLMin(new SQLSelect(null), "Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLMin = new SQLMin("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
    		mockSQLMin = new SQLMin(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLMin = null;
    	}
    	assertNotNull(mockSQLMin);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLMin = new SQLMin(new SQLSelect(null), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLMin = new SQLMin(new SQLSelect(new SQLPopulation("SourceClass")), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLMin = null;
		}
    	assertNotNull(mockSQLMin.getSQLSentence());
    }
}


