package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.query.spi.NativeQueryImplementor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SPBuilderTest {

    private static EntityManager em;
    
    // test4createSP
    private static String test4createSPArg1;
    private static StoredProcedureQuery mock4test4createSP;
    
    // test4createSPClass
    private static String test4createSPClassArg1;
    private static Class<?> test4createSPClassArg2;
    private static StoredProcedureQuery mock4test4createSPClass;
    
    // test4addInputParameter
    private static String test4addInputParameterArg1;
    private static Class<?> test4addInputParameterArg2;
    private static Object test4addInputParameterArg3;

    // test4addOutputParameter
    private static String test4addOutputParameterArg1;
    private static Class<?> test4addOutputParameterArg2;
    
    // test4addInputOutputParameter
    private static String test4addInputOutputParameterArg1;
    private static Class<?> test4addInputOutputParameterArg2;
    private static Object test4addInputOutputParameterArg3;
    
    // test4isOutputParameterValueNull
    private static String test4isOutputParameterValueNullArg1;
    private static Class<?> test4isOutputParameterValueNullArg2;
    
    // test4executeQuery
    private static List<String> test4executeQueryArg1;
    private static List<SPResultRow> test4executeQueryResult;
    
    // test4executeQueryFunction
    private static List<String> test4executeQueryFunctionArg1;
    private static List<SPResultRow> test4executeQueryFunctionResult;
    
	private SPBuilder instanceSPBuilder;
	
    @BeforeClass
    public static void setUpClass() {
    	setUpMockData();
    }
    
    private static void setUpMockData() {
    	em = mock(EntityManager.class);

    	setUpMockData4test4createSP();
    	setUpMockData4test4createSPClass();
    	setUpMockData4test4addInputParameter();
    	setUpMockData4test4addOutputParameter();
    	setUpMockData4test4addInputOutputParameter();
    	setUpMockData4test4isOutputParameterValueNull();
    	setUpMockData4test4executeQuery();
    	setUpMockData4test4executeQueryFunction();
    	
    	when(em.createStoredProcedureQuery(test4createSPArg1)).thenReturn(mock4test4createSP);
    	when(em.createStoredProcedureQuery(test4createSPClassArg1, test4createSPClassArg2)).thenReturn(mock4test4createSPClass);
    	when(em.createNativeQuery(anyString())).thenReturn(mock(NativeQueryImplementor.class));
    }
	
    private static void setUpMockData4test4createSP() {
    	test4createSPArg1 = "test4createSPArg1";
    	mock4test4createSP = mock(StoredProcedureQuery.class);
    }
    
    private static void setUpMockData4test4createSPClass() {
    	test4createSPClassArg1 = "test4createSPClassArg1";
    	test4createSPClassArg2 = String.class;
    	mock4test4createSP = mock(StoredProcedureQuery.class);
    }
    
    private static void setUpMockData4test4addInputParameter() {
    	test4addInputParameterArg1 = "test4AddInputParameterArg1";
    	test4addInputParameterArg2 = String.class;
    	test4addInputParameterArg3 = "test4addInputParameterArg3";
    }
    
    private static void setUpMockData4test4addOutputParameter() {
    	test4addOutputParameterArg1 = "test4AddOutputParameterArg1";
    	test4addOutputParameterArg2 = String.class;
    }
    
    private static void setUpMockData4test4addInputOutputParameter() {
    	test4addInputOutputParameterArg1 = "test4AddInputOutputParameterArg1";
    	test4addInputOutputParameterArg2 = String.class;
    	test4addInputOutputParameterArg3 = "test4addInputOutputParameterArg3";
    }
    
    private static void setUpMockData4test4isOutputParameterValueNull() {
    	test4isOutputParameterValueNullArg1 = "test4isOutputParameterValueNullArg1";
    	test4isOutputParameterValueNullArg2 = String.class;
    }
    
    private static void setUpMockData4test4executeQuery() {
    	test4executeQueryArg1 = new ArrayList<>();
    	test4executeQueryArg1.add("field1");
    	test4executeQueryArg1.add("field2");
    	test4executeQueryResult = new ArrayList<>();
    }
    
    private static void setUpMockData4test4executeQueryFunction() {
    	test4executeQueryFunctionArg1 = new ArrayList<>();
    	test4executeQueryFunctionArg1.add("field1");
    	test4executeQueryFunctionArg1.add("field2");
    	test4executeQueryFunctionResult = new ArrayList<>();
    }
    
    @Before
    public void setUp() {
    	instanceSPBuilder = new SPBuilder(em);
    }
    
	@Test
	public void test4createSP() {
		instanceSPBuilder.createSP(test4createSPArg1);
		assertNotNull(instanceSPBuilder);
	}

	@Test
	public void test4createSPClass() {
		instanceSPBuilder.createSP(test4createSPClassArg1, test4createSPClassArg2);
		assertNotNull(instanceSPBuilder);
	}
	
	@Test
	public void test4addInputParameter() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputParameter(test4addInputParameterArg1, test4addInputParameterArg2, test4addInputParameterArg3);
		assertNotNull(instanceSPBuilder);
	}
	
	@Test
	public void test4addOutputParameter() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addOutputParameter(test4addOutputParameterArg1, test4addOutputParameterArg2);
		assertNotNull(instanceSPBuilder);
	}
	
	@Test
	public void test4addInputOutputParameter() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputOutputParameter(test4addInputOutputParameterArg1, test4addInputOutputParameterArg2, test4addInputOutputParameterArg3);
		assertNotNull(instanceSPBuilder);
	}
	
	@Test
	public void test4isOutputParameterValueNull() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addOutputParameter(test4isOutputParameterValueNullArg1, test4isOutputParameterValueNullArg2);
		assertTrue(instanceSPBuilder.isOutputParameterValueNull(test4isOutputParameterValueNullArg1));
		assertNull(instanceSPBuilder.getOutputParameterValue(test4isOutputParameterValueNullArg1));
	}
	
	@Test
	public void test4getParameterValue() {
		instanceSPBuilder.createSP(test4createSPArg1);
		assertNull(instanceSPBuilder.getParameterValue(""));
	}
	
	
	@Test
	public void test4executeQuery() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputParameter(test4addInputParameterArg1, test4addInputParameterArg2, test4addInputParameterArg3);
		assertEquals(test4executeQueryResult, instanceSPBuilder.executeQuery(test4executeQueryArg1));
	}
	
	@Test
	public void test4executeQueryFunction() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputParameter(test4addInputParameterArg1, test4addInputParameterArg2, test4addInputParameterArg3);
		assertEquals(test4executeQueryFunctionResult, instanceSPBuilder.executeQueryFunction(test4executeQueryFunctionArg1));
	}
	
	@Test
	public void test4ExecuteNonQuery() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputParameter(test4addInputParameterArg1, test4addInputParameterArg2, test4addInputParameterArg3);
		assertNotNull(instanceSPBuilder.executeNonQuery());
	}
	
	@Test
	public void test4ExecuteFunction() {
		instanceSPBuilder.createSP(test4createSPArg1);
		instanceSPBuilder.addInputParameter(test4addInputParameterArg1, test4addInputParameterArg2, test4addInputParameterArg3);
		assertNull(instanceSPBuilder.executeFunction());
	}
	
}
