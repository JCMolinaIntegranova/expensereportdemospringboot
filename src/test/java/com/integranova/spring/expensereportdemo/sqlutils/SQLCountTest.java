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
public class SQLCountTest {

	@Mock
	private static SQLCount mockSQLCount;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLCount = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLCount = new SQLCount(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName");
		} catch (SystemException e) {
			mockSQLCount = null;
		}
    	assertNotNull(mockSQLCount);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLCount = new SQLCount("sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLCount = null;
		}
    	assertNotNull(mockSQLCount);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLCount = new SQLCount(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLCount = null;
		}
    	assertNotNull(mockSQLCount);	
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLCount = new SQLCount("sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLCount = null;
		}
    	assertNotNull(mockSQLCount);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
			mockSQLCount = new SQLCount(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLCount = null;
		}
    	assertNotNull(mockSQLCount);
    }
    
    @Test
    public void test4getSQLSentence() {
    	try {
			mockSQLCount = new SQLCount(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLCount.getSQLSentence();
		} catch (SystemException e) {
			mockSQLCount = null;
		}
		assertNotNull(mockSQLCount);
    }
}

