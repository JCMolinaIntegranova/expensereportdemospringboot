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
public class SQLUniqueTest {

	@Mock
	private static SQLUnique mockSQLUnique;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLUnique = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLUnique = new SQLUnique(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName");
		} catch (SystemException e) {
			mockSQLUnique = null;
		}
    	assertNotNull(mockSQLUnique);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLUnique = new SQLUnique("sourceEntityName", "roleName", null);
		} catch (SystemException e) {
			mockSQLUnique = null;
		}
    	assertNotNull(mockSQLUnique);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLUnique = new SQLUnique("sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLUnique = null;
		}
    	assertNotNull(mockSQLUnique);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLUnique = new SQLUnique(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
		} catch (SystemException e) {
			mockSQLUnique = null;
		}
    	assertNotNull(mockSQLUnique);
    }
    
    @Test
    public void test4getSQLSentence1() {
    	try {
			mockSQLUnique = new SQLUnique(null, "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLUnique.getSQLSentence();
		} catch (SystemException e) {
			mockSQLUnique = null;
			
		}
    	assertNotNull(mockSQLUnique);
    }
    
    @Test
    public void test4getSQLSentence2() {
    	try {
			mockSQLUnique = new SQLUnique(new SQLPopulation("sourceEntityName"), "sourceEntityName", "roleName", "parameterDefClassName", null, "parameterName");
			mockSQLUnique.getSQLSentence();
		} catch (SystemException e) {
			mockSQLUnique = null;
			
		}
    	assertNotNull(mockSQLUnique);
    }
}


