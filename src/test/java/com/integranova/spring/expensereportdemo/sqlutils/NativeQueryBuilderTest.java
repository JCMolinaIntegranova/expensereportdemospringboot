package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NativeQueryBuilderTest {
	private static EntityManager em;
	
	NativeQueryBuilder instance;
	
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	em = mock(EntityManager.class);
    	
    	when(em.createNativeQuery(anyString())).thenReturn(mock(Query.class));
    }
    
    @Before
    public void setUp() {
        instance = new NativeQueryBuilder(em);
    }
    
    @After
    public void tearDown() {
    	instance = null;
    }
    
    @Test
    public void test4Constructor() {
    	instance = new NativeQueryBuilder(em);
    	assertNotNull(instance);
    }
    
    @Test
    public void test4build() throws SystemException {
    	assertNotNull(instance.build(new SQLPopulation("ClassName")));
    }
    
    @Test
    public void test4build2() {
    	assertNotNull(instance.build(""));
    }
    
    @Test
    public void test4setParameters() {
    	List<SQLParam> params = new ArrayList<>();
    	params.add(new SQLParam("String", "Param", "String"));
    	params.add(new SQLParam("Nat", 1, "Nat"));
    	params.add(new SQLParam("Int", 2, "Int"));
    	params.add(new SQLParam("Autonumeric", 3, "Autonumeric"));
    	params.add(new SQLParam("Real", 4, "Real"));
    	params.add(new SQLParam("Real2", 5.5, "Real"));
    	instance.build("");
    	assertNotNull(instance.setParameters(params));
    }
    
    @Test
    public void test4Execute() {
    	instance.build("");
    	assertEquals(0, instance.execute().size());
    }
    
    @Test
    public void test4getSingleResult() {
    	instance.build("");
    	assertNull(instance.getSingleResult());
    }
}
