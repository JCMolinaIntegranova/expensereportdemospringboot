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
public class SQLForAllConditionTest {

	@Mock
	private static SQLForAllCondition mockSQLForAllCondition;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLForAllCondition = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName");
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
    	assertNotNull(mockSQLForAllCondition);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition("sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
    	assertNotNull(mockSQLForAllCondition);
    }
   
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition("sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
    	assertNotNull(mockSQLForAllCondition);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
    	assertNotNull(mockSQLForAllCondition);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition("sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLForAllCondition.getSQLSentence();
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
		assertNotNull(mockSQLForAllCondition);
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLForAllCondition = new SQLForAllCondition(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLForAllCondition.getSQLSentence();
		} catch (SystemException e) {
			mockSQLForAllCondition = null;
		}
		assertNotNull(mockSQLForAllCondition);
    }
    

}

