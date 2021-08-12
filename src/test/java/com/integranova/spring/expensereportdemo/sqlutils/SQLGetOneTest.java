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
public class SQLGetOneTest {

	@Mock
	private static SQLGetOne mockSQLGetOne;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLGetOne = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLGetOne = new SQLGetOne(new SQLSelect(null), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLGetOne = new SQLGetOne("SourceClass", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLGetOne = new SQLGetOne(new SQLSelect(null), "SourceClass", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLGetOne = new SQLGetOne("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
    		mockSQLGetOne = new SQLGetOne(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLGetOne = null;
    	}
    	assertNotNull(mockSQLGetOne);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLGetOne = new SQLGetOne(new SQLSelect(null), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne.getSQLSentence());
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLGetOne = new SQLGetOne(new SQLSelect(new SQLPopulation("SourceClass")), "SourceClass", "role.attribute");
		} catch (SystemException e) {
			mockSQLGetOne = null;
		}
    	assertNotNull(mockSQLGetOne.getSQLSentence());
    }
}


