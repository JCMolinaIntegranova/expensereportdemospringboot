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
public class SQLAvgTest {

	@Mock
	private static SQLAvg mockSQLAvg;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	
    }
    
    @After
    public void tearDown() {
    	mockSQLAvg = null;
    }
    
    @Test
    public void test4Constructor1() {
    	try {
			mockSQLAvg = new SQLAvg(new SQLSelect(null), "Class", "role.attribute");
		} catch (SystemException e) {
			mockSQLAvg = null;
		}
    	assertNotNull(mockSQLAvg);
    }
    
    @Test
    public void test4Constructor2() {
    	try {
			mockSQLAvg = new SQLAvg("Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLAvg = null;
		}
    	assertNotNull(mockSQLAvg);
    }
    
    @Test
    public void test4Constructor3() {
    	try {
			mockSQLAvg = new SQLAvg(new SQLSelect(null), "Class", "role.attribute", null);
		} catch (SystemException e) {
			mockSQLAvg = null;
		}
    	assertNotNull(mockSQLAvg);
    }
    
    @Test
    public void test4Constructor4() {
    	try {
			mockSQLAvg = new SQLAvg("SourceClass", "role.attribute", "ParamClass", null, "ParamName");
		} catch (SystemException e) {
			mockSQLAvg = null;
		}
    	assertNotNull(mockSQLAvg);
    }
    
    @Test
    public void test4Constructor5() {
    	try {
    		mockSQLAvg = new SQLAvg(new SQLSelect(null), "SourceClass", "role.attribute", "ParamClass", null, "ParamName");
    	} catch (SystemException e) {
    		mockSQLAvg = null;
    	}
    	assertNotNull(mockSQLAvg);
    }
    
    @Test
    public void test4getSQLSentence() {
    	try {
			mockSQLAvg = new SQLAvg(new SQLSelect(null), "Customer", "invoices.amount");
		} catch (SystemException e) {
			mockSQLAvg = null;
		}
    	assertNotNull(mockSQLAvg.getSQLSentence());
    }
}

