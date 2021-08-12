package com.integranova.spring.expensereportdemo.sqlutils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SQLWhereOperandTest {

	SQLWhereOperand instance;
	
    @Before
    public void setUp() throws SystemException {
    	instance = new SQLWhereOperand("String");
    	instance.setSql(new SQLPopulation("ClassName"));
    }
	
    @After
    public void tearDown() {
    	instance = null;
    }
	
	@Test
	public void test4Constructor() {
		instance = new SQLWhereOperand();
		assertNotNull(instance);
	}
	
	@Test
	public void test4Constructor2() {
		instance = new SQLWhereOperand("String");
		assertNotNull(instance);
	}
	
	@Test
	public void test4setComparatorForNull() {
		String comparator = "=";
		instance.setComparatorForNull(comparator);
		assertNotNull(instance);
	}
	
	@Test
	public void test4getComparatorForNull() {
		String comparator = "=";
		instance.setComparatorForNull(comparator);
		assertEquals(comparator, instance.getComparatorForNull());
	}
	
	@Test
	public void test4setCompareWithNull() {
		instance.setCompareWithNull(true);
		assertNotNull(instance);
	}
	
	@Test
	public void test4getCompareWithNull() {
		instance.setCompareWithNull(true);
		assertEquals(true, instance.getCompareWithNull());
	}
	
	@Test
	public void test4getText() {
		assertNotNull(instance.getText());
	}
	
	@Test
	public void test4fixInstance() {
		instance.fixInstance(new SQLAlias("Path", "Facet", false, "Alias"), null);
		assertNotNull(instance.getText());
	}
}
