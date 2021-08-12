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
public class SQLExistsTest {

	@Mock
	private static SQLExists mockSQLExists;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLExists = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLExists = new SQLExists(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName");
		} catch (SystemException e) {
			mockSQLExists = null;
		}
    	assertNotNull(mockSQLExists);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLExists = new SQLExists("sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLExists = null;
		}
    	assertNotNull(mockSQLExists);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLExists = new SQLExists(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLExists = null;
		}
    	assertNotNull(mockSQLExists);	
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLExists = new SQLExists("sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLExists = null;
		}
    	assertNotNull(mockSQLExists);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
			mockSQLExists = new SQLExists(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLExists = null;
		}
    	assertNotNull(mockSQLExists);
    }
    
    @Test
    public void test4getSQLSentence() {
    	try {
			mockSQLExists = new SQLExists(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLExists.getSQLSentence();
		} catch (SystemException e) {
			mockSQLExists = null;
		}
		assertNotNull(mockSQLExists);
    }
}

