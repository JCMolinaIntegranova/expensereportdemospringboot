package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.global.Constants;

@RunWith(MockitoJUnitRunner.class)
public class FilterVariableRequestTest {
	
	private FilterVariableRequest instanceFilterVariableRequest;

	private static String mock4Name;
	private static Object mock4Value;
	
	@Before
	public void setUp() {
		mock4Name = "name";
		mock4Value = Long.valueOf(1);
		instanceFilterVariableRequest = new FilterVariableRequest(mock4Name, mock4Value);
	}
	
	@Test
	public void test4getName() {
		assertEquals(mock4Name, instanceFilterVariableRequest.getName());
	}
	
	@Test
	public void test4setName() {
		String name = "newName";
		instanceFilterVariableRequest.setName(name);
		assertEquals(name, instanceFilterVariableRequest.getName());
	}
	
	@Test
	public void test4getValue() {
		assertEquals(mock4Value, instanceFilterVariableRequest.getValue());
	}
	
	@Test
	public void test4setValue() {
		Object value = Long.valueOf(2);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getValue());
	}
	
	@Test
	public void test4getTypedValueInt() {
		Long value = Long.valueOf(2);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.INT));
	}
	
	@Test
	public void test4getTypedValueReal() {
		Double value = Double.valueOf(2);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.REAL));
	}
	
	@Test
	public void test4getTypedValueBool() {
		Boolean value = true;
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.BOOL));
	}
	
	@Test
	public void test4getTypedValueBlob() {
		byte[] value = "blob".getBytes();
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.BLOB));
	}
	
	@Test
	public void test4getTypedValueString() {
		String value = "String";
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.STRING));
	}
	
	@Test
	public void test4getTypedValueDate() {
		Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.DATE));
	}
	
	@Test
	public void test4getTypedValueDateTime() {
		Timestamp value = Timestamp.valueOf(Constants.DATETIME_DEFAULTVALUE);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.DATETIME));
	}
	
	@Test
	public void test4getTypedValueTime() {
		Time value = Time.valueOf(Constants.TIME_DEFAULTVALUE);
		instanceFilterVariableRequest.setValue(value);
		assertEquals(value, instanceFilterVariableRequest.getTypedValue(FilterVariableRequest.TIME));
	}
}
