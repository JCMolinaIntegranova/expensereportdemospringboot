package com.integranova.spring.expensereportdemo.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UtilitiesTest {

	@Test
	public void test4like1() {
		assertFalse(Utilities.like(null, null));
	}
	
	@Test
	public void test4like2() {
		assertFalse(Utilities.like("Text", null));
	}
	
	@Test
	public void test4like3() {
		assertTrue(Utilities.like("Text", "Te"));
	}
	
	@Test
	public void test4like4() {
		assertFalse(Utilities.like("True", "False"));
	}
	
	@Test
	public void test4contains1() {
		assertFalse(Utilities.contains(null, null));
	}
	
	@Test
	public void test4contains2() {
		assertFalse(Utilities.contains("Text", null));
	}
	
	@Test
	public void test4contains3() {
		assertTrue(Utilities.contains("Text", "Te"));
	}
	
	@Test
	public void test4contains4() {
		assertFalse(Utilities.contains("True", "False"));
	}
	
	@Test
	public void test4isBlobEqual1() {
		Object obj1 = "String".getBytes();
		Object obj2 = "String".getBytes();
		assertTrue(Utilities.isBlobEqual(obj1, obj2));
	}
	
	@Test
	public void test4isBlobEqual2() {
		Object obj1 = "String".getBytes();
		Object obj2 = "Xtring".getBytes();
		assertFalse(Utilities.isBlobEqual(obj1, obj2));
	}
	
	@Test
	public void test4toCollection() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals(collection, Utilities.toCollection("1,2,3", ","));		
	}
	
	@Test
	public void test4toArray() {
		String[] collection = new String[3];
		collection[0]="1";
		collection[1]="2";
		collection[2]="3";
		assertEquals(collection[0], Utilities.toArray("1,2,3", ",")[0]);		
	}
	
	@Test
	public void test4concat() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals("1,2,3", Utilities.concat(collection, ","));
	}
	
	@Test
	public void test4buildSQLFrom() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals("1,2,3", Utilities.buildSQLFrom(collection));
	}
	
	@Test
	public void test4buildSQLWhere() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals("(1) AND (2) AND (3)", Utilities.buildSQLWhere(collection));
	}
	
	@Test
	public void test4giveUnique1() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals("4", Utilities.giveUnique("4", collection));
	}
	
	@Test
	public void test4giveUnique2() {
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		assertEquals("", Utilities.giveUnique("1", collection));
	}
	
	@Test
	public void test4isEqualByteArr1() {
		byte[] obj1 = "String".getBytes();
		byte[] obj2 = "String".getBytes();
		assertTrue(Utilities.isEqual(obj1, obj2));
	}
	
	@Test
	public void test4isEqualByteArr2() {
		byte[] obj1 = "String".getBytes();
		byte[] obj2 = "Xtring".getBytes();
		assertFalse(Utilities.isEqual(obj1, obj2));
	}
	
	@Test
	public void test4isEqualByteArr3() {
		byte[] obj1 = null;
		byte[] obj2 = "Xtring".getBytes();
		assertFalse(Utilities.isEqual(obj1, obj2));
	}
	
	@Test
	public void test4isEqualByteArr4() {
		byte[] obj1 = null;
		byte[] obj2 = null;
		assertTrue(Utilities.isEqual(obj1, obj2));
	}
	
	@Test
	public void test4isEqualInteger1() {
		assertTrue(Utilities.isEqual(Integer.valueOf(1), Integer.valueOf(1)));
	}
	
	@Test
	public void test4isEqualInteger2() {
		assertFalse(Utilities.isEqual(Integer.valueOf(1), Integer.valueOf(2)));
	}
	
	@Test
	public void test4isEqualInteger3() {
		assertFalse(Utilities.isEqual(Integer.valueOf(1), null));
	}
	
	@Test
	public void test4isEqualInteger4() {
		Integer nullInt = null;
		assertTrue(Utilities.isEqual(nullInt, null));
	}
	
	@Test
	public void test4isEqualLong1() {
		assertTrue(Utilities.isEqual(Long.valueOf(1), Long.valueOf(1)));
	}
	
	@Test
	public void test4isEqualLong2() {
		assertFalse(Utilities.isEqual(Long.valueOf(1), Long.valueOf(2)));
	}
	
	@Test
	public void test4isEqualLong3() {
		assertFalse(Utilities.isEqual(Long.valueOf(1), null));
	}
	
	@Test
	public void test4isEqualLong4() {
		Long nullLong = null;
		assertTrue(Utilities.isEqual(nullLong, null));
	}
	
	@Test
	public void test4isEqualDouble1() {
		assertTrue(Utilities.isEqual(Double.valueOf(1), Double.valueOf(1)));
	}
	
	@Test
	public void test4isEqualDouble2() {
		assertFalse(Utilities.isEqual(Double.valueOf(1), Double.valueOf(2)));
	}
	
	@Test
	public void test4isEqualDouble3() {
		assertFalse(Utilities.isEqual(Double.valueOf(1), null));
	}
	
	@Test
	public void test4isEqualDouble4() {
		Double nullDouble = null;
		assertTrue(Utilities.isEqual(nullDouble, null));
	}
	
	@Test
	public void test4isEqualBoolean1() {
		assertTrue(Utilities.isEqual(true, true));
	}
	
	@Test
	public void test4isEqualBoolean2() {
		assertFalse(Utilities.isEqual(true, false));
	}
	
	@Test
	public void test4isEqualBoolean3() {
		assertFalse(Utilities.isEqual(true, null));
	}
	
	@Test
	public void test4isEqualString1() {
		assertTrue(Utilities.isEqual("1", "1"));
	}
	
	@Test
	public void test4isEqualString2() {
		assertFalse(Utilities.isEqual("1", "2"));
	}
	
	@Test
	public void test4isEqualString3() {
		assertFalse(Utilities.isEqual("1", null));
	}
	
	@Test
	public void test4isEqualDate1() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertTrue(Utilities.isEqual(date1, date2));
	}
	
	@Test
	public void test4isEqualDate2() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(2000);
		assertFalse(Utilities.isEqual(date1, date2));
	}
	
	@Test
	public void test4isEqualDate3() {
		java.sql.Date date1 = null;
		java.sql.Date date2 = new java.sql.Date(1000);
		assertFalse(Utilities.isEqual(date1, date2));
	}
	
	@Test
	public void test4isEqualTime1() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertTrue(Utilities.isEqual(time1, time2));
	}
	
	@Test
	public void test4isEqualTime2() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(2000);
		assertFalse(Utilities.isEqual(time1, time2));
	}
	
	@Test
	public void test4isEqualTime3() {
		java.sql.Time time1 = null;
		java.sql.Time time2 = new java.sql.Time(1000);
		assertFalse(Utilities.isEqual(time1, time2));
	}
	
	@Test
	public void test4isEqualDateTime1() {
		java.sql.Timestamp datetime1 = new java.sql.Timestamp(1000); 
		java.sql.Timestamp datetime2 = new java.sql.Timestamp(1000);
		assertTrue(Utilities.isEqual(datetime1, datetime2));
	}
	
	@Test
	public void test4isEqualDateTime2() {
		java.sql.Timestamp datetime1 = new java.sql.Timestamp(1000); 
		java.sql.Timestamp datetime2 = new java.sql.Timestamp(2000);
		assertFalse(Utilities.isEqual(datetime1, datetime2));
	}
	
	@Test
	public void test4isEqualDateTime3() {
		java.sql.Timestamp datetime1 = null; 
		java.sql.Timestamp datetime2 = new java.sql.Timestamp(1000);
		assertFalse(Utilities.isEqual(datetime1, datetime2));
	}
	
	@Test
	public void test4isLesserInteger1() {
		assertTrue(Utilities.isLesser(Integer.valueOf(1), Integer.valueOf(2)));
	}
	
	@Test
	public void test4isLesserInteger2() {
		assertFalse(Utilities.isLesser(Integer.valueOf(2), Integer.valueOf(1)));
		Integer nullVal = null;
		Integer val = Integer.valueOf(1);
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterInteger1() {
		assertTrue(Utilities.isGreater(Integer.valueOf(2), Integer.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterInteger2() {
		assertFalse(Utilities.isGreater(Integer.valueOf(1), Integer.valueOf(2)));
		Integer nullVal = null;
		Integer val = Integer.valueOf(1);
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualInteger1() {
		assertTrue(Utilities.isLesserOrEqual(Integer.valueOf(1), Integer.valueOf(1)));
	}
	
	@Test
	public void test4isLesserOrEqualInteger2() {
		assertTrue(Utilities.isLesserOrEqual(Integer.valueOf(1), Integer.valueOf(2)));
	}
	
	@Test
	public void test4isLesserOrEqualInteger3() {
		assertFalse(Utilities.isLesserOrEqual(Integer.valueOf(2), Integer.valueOf(1)));
		Integer nullVal = null;
		Integer val = Integer.valueOf(1);
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualInteger1() {
		assertTrue(Utilities.isGreaterOrEqual(Integer.valueOf(1), Integer.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterOrEqualInteger2() {
		assertTrue(Utilities.isGreaterOrEqual(Integer.valueOf(2), Integer.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterOrEqualInteger3() {
		assertFalse(Utilities.isGreaterOrEqual(Integer.valueOf(1), Integer.valueOf(2)));
		Integer nullVal = null;
		Integer val = Integer.valueOf(1);
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	
	@Test
	public void test4isLesserDouble1() {
		assertTrue(Utilities.isLesser(Double.valueOf(1), Double.valueOf(2)));
	}
	
	@Test
	public void test4isLesserDouble2() {
		assertFalse(Utilities.isLesser(Double.valueOf(2), Double.valueOf(1)));
		Double nullVal = null;
		Double val = Double.valueOf(1);
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterDouble1() {
		assertTrue(Utilities.isGreater(Double.valueOf(2), Double.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterDouble2() {
		assertFalse(Utilities.isGreater(Double.valueOf(1), Double.valueOf(2)));
		Double nullVal = null;
		Double val = Double.valueOf(1);
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualDouble1() {
		assertTrue(Utilities.isLesserOrEqual(Double.valueOf(1), Double.valueOf(1)));
	}
	
	@Test
	public void test4isLesserOrEqualDouble2() {
		assertTrue(Utilities.isLesserOrEqual(Double.valueOf(1), Double.valueOf(2)));
	}
	
	@Test
	public void test4isLesserOrEqualDouble3() {
		assertFalse(Utilities.isLesserOrEqual(Double.valueOf(2), Double.valueOf(1)));
		Double nullVal = null;
		Double val = Double.valueOf(1);
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualDouble1() {
		assertTrue(Utilities.isGreaterOrEqual(Double.valueOf(1), Double.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterOrEqualDouble2() {
		assertTrue(Utilities.isGreaterOrEqual(Double.valueOf(2), Double.valueOf(1)));
	}
	
	@Test
	public void test4isGreaterOrEqualDouble3() {
		assertFalse(Utilities.isGreaterOrEqual(Double.valueOf(1), Double.valueOf(2)));
		Double nullVal = null;
		Double val = Double.valueOf(1);
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserString1() {
		assertTrue(Utilities.isLesser("1", "2"));
	}
	
	@Test
	public void test4isLesserString2() {
		assertFalse(Utilities.isLesser("2", "1"));
		String nullVal = null;
		String val = "1";
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterString1() {
		assertTrue(Utilities.isGreater("2", "1"));
	}
	
	@Test
	public void test4isGreaterString2() {
		assertFalse(Utilities.isGreater("1", "2"));
		String nullVal = null;
		String val = "1";
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualString1() {
		assertTrue(Utilities.isLesserOrEqual("1", "1"));
	}
	
	@Test
	public void test4isLesserOrEqualString2() {
		assertTrue(Utilities.isLesserOrEqual("1", "2"));
	}
	
	@Test
	public void test4isLesserOrEqualString3() {
		assertFalse(Utilities.isLesserOrEqual("2", "1"));
		String nullVal = null;
		String val = "1";
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualString1() {
		assertTrue(Utilities.isGreaterOrEqual("1", "1"));
	}
	
	@Test
	public void test4isGreaterOrEqualString2() {
		assertTrue(Utilities.isGreaterOrEqual("2","1"));
	}
	
	@Test
	public void test4isGreaterOrEqualString3() {
		assertFalse(Utilities.isGreaterOrEqual("1", "2"));
		String nullVal = null;
		String val = "1";
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserDate1() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(2000);
		assertTrue(Utilities.isLesser(date1, date2));
	}
	
	@Test
	public void test4isLesserDate2() {
		java.sql.Date date1 = new java.sql.Date(2000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertFalse(Utilities.isLesser(date1, date2));
		java.sql.Date nullVal = null;
		java.sql.Date val = date1;
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterDate1() {
		java.sql.Date date1 = new java.sql.Date(2000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertTrue(Utilities.isGreater(date1, date2));
	}
	
	@Test
	public void test4isGreaterDate2() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(2000);
		assertFalse(Utilities.isGreater(date1, date2));
		java.sql.Date nullVal = null;
		java.sql.Date val = date1;
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualDate1() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertTrue(Utilities.isLesserOrEqual(date1, date2));
	}
	
	@Test
	public void test4isLesserOrEqualDate2() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(2000);
		assertTrue(Utilities.isLesserOrEqual(date1, date2));
	}
	
	@Test
	public void test4isLesserOrEqualDate3() {
		java.sql.Date date1 = new java.sql.Date(2000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertFalse(Utilities.isLesserOrEqual(date1, date2));
		java.sql.Date nullVal = null;
		java.sql.Date val = date1;
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualDate1() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertTrue(Utilities.isGreaterOrEqual(date1, date2));
	}
	
	@Test
	public void test4isGreaterOrEqualDate2() {
		java.sql.Date date1 = new java.sql.Date(2000);
		java.sql.Date date2 = new java.sql.Date(1000);
		assertTrue(Utilities.isGreaterOrEqual(date1, date2));
	}
	
	@Test
	public void test4isGreaterOrEqualDate3() {
		java.sql.Date date1 = new java.sql.Date(1000);
		java.sql.Date date2 = new java.sql.Date(2000);
		assertFalse(Utilities.isGreaterOrEqual(date1, date2));
		java.sql.Date nullVal = null;
		java.sql.Date val = date1;
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserTime1() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(2000);
		assertTrue(Utilities.isLesser(time1, time2));
	}
	
	@Test
	public void test4isLesserTime2() {
		java.sql.Time time1 = new java.sql.Time(2000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertFalse(Utilities.isLesser(time1, time2));
		java.sql.Time nullVal = null;
		java.sql.Time val = time1;
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterTime1() {
		java.sql.Time time1 = new java.sql.Time(2000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertTrue(Utilities.isGreater(time1, time2));
	}
	
	@Test
	public void test4isGreaterTime2() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(2000);
		assertFalse(Utilities.isGreater(time1, time2));
		java.sql.Time nullVal = null;
		java.sql.Time val = time1;
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualTime1() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertTrue(Utilities.isLesserOrEqual(time1, time2));
	}
	
	@Test
	public void test4isLesserOrEqualTime2() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(2000);
		assertTrue(Utilities.isLesserOrEqual(time1, time2));
	}
	
	@Test
	public void test4isLesserOrEqualTime3() {
		java.sql.Time time1 = new java.sql.Time(2000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertFalse(Utilities.isLesserOrEqual(time1, time2));
		java.sql.Time nullVal = null;
		java.sql.Time val = time1;
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualTime1() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertTrue(Utilities.isGreaterOrEqual(time1, time2));
	}
	
	@Test
	public void test4isGreaterOrEqualTime2() {
		java.sql.Time time1 = new java.sql.Time(2000);
		java.sql.Time time2 = new java.sql.Time(1000);
		assertTrue(Utilities.isGreaterOrEqual(time1, time2));
	}
	
	@Test
	public void test4isGreaterOrEqualTime3() {
		java.sql.Time time1 = new java.sql.Time(1000);
		java.sql.Time time2 = new java.sql.Time(2000);
		assertFalse(Utilities.isGreaterOrEqual(time1, time2));
		java.sql.Time nullVal = null;
		java.sql.Time val = time1;
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserTimestamp1() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(2000);
		assertTrue(Utilities.isLesser(ts1, ts2));
	}
	
	@Test
	public void test4isLesserTimestamp2() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(2000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertFalse(Utilities.isLesser(ts1, ts2));
		java.sql.Timestamp nullVal = null;
		java.sql.Timestamp val = ts1;
		assertFalse(Utilities.isLesser(nullVal, val));
		assertFalse(Utilities.isLesser(val, nullVal));
		assertFalse(Utilities.isLesser(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterTimestamp1() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(2000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertTrue(Utilities.isGreater(ts1, ts2));
	}
	
	@Test
	public void test4isGreaterTimestamp2() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(2000);
		assertFalse(Utilities.isGreater(ts1, ts2));
		java.sql.Timestamp nullVal = null;
		java.sql.Timestamp val = ts1;
		assertFalse(Utilities.isGreater(nullVal, val));
		assertFalse(Utilities.isGreater(val, nullVal));
		assertFalse(Utilities.isGreater(nullVal, nullVal));
	}
	
	@Test
	public void test4isLesserOrEqualTimestamp1() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertTrue(Utilities.isLesserOrEqual(ts1, ts2));
	}
	
	@Test
	public void test4isLesserOrEqualTimestamp2() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(2000);
		assertTrue(Utilities.isLesserOrEqual(ts1, ts2));
	}
	
	@Test
	public void test4isLesserOrEqualTimestamp3() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(2000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertFalse(Utilities.isLesserOrEqual(ts1, ts2));
		java.sql.Timestamp nullVal = null;
		java.sql.Timestamp val = ts1;
		assertFalse(Utilities.isLesserOrEqual(nullVal, val));
		assertFalse(Utilities.isLesserOrEqual(val, nullVal));
		assertTrue(Utilities.isLesserOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4isGreaterOrEqualTimestamp1() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertTrue(Utilities.isGreaterOrEqual(ts1, ts2));
	}
	
	@Test
	public void test4isGreaterOrEqualTimestamp2() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(2000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(1000);
		assertTrue(Utilities.isGreaterOrEqual(ts1, ts2));
	}
	
	@Test
	public void test4isGreaterOrEqualTimestamp3() {
		java.sql.Timestamp ts1 = new java.sql.Timestamp(1000);
		java.sql.Timestamp ts2 = new java.sql.Timestamp(2000);
		assertFalse(Utilities.isGreaterOrEqual(ts1, ts2));
		java.sql.Timestamp nullVal = null;
		java.sql.Timestamp val = ts1;
		assertFalse(Utilities.isGreaterOrEqual(nullVal, val));
		assertFalse(Utilities.isGreaterOrEqual(val, nullVal));
		assertTrue(Utilities.isGreaterOrEqual(nullVal, nullVal));
	}
	
	@Test
	public void test4convertToDouble() {
		assertEquals(Double.valueOf(7), Utilities.convertToDouble(Integer.valueOf(7)));
		Integer nullInteger = null;
		assertNull(Utilities.convertToDouble(nullInteger));
		assertEquals(Double.valueOf(7), Utilities.convertToDouble(Long.valueOf(7)));
		Long nullLong = null;
		assertNull(Utilities.convertToDouble(nullLong));
		assertEquals(Double.valueOf(7), Utilities.convertToDouble(Double.valueOf(7)));
	}
	
	@Test
	public void test4concatStrings() {
		assertEquals("12", Utilities.concat("1", "2"));
		assertNull(Utilities.concat("1", null));
		String nullString = null;
		assertNull(Utilities.concat(nullString, "2"));
		assertNull(Utilities.concat("1", nullString));
		assertNull(Utilities.concat(nullString, nullString));
	}
	
	@Test
	public void test4mod() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer int2 = Integer.valueOf(2);
		Integer int4 = Integer.valueOf(4);
		Double double2 = Double.valueOf(2);
		Double double4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(int4 % int2), Utilities.mod(int4, int2));
		assertEquals(Double.valueOf(double4 % double2), Utilities.mod(double4, double2));
		assertEquals(Double.valueOf(int4 % double2), Utilities.mod(int4, double2));
		assertEquals(Double.valueOf(double4 % int2), Utilities.mod(double4, int2));
		assertNull(Utilities.mod(int4, nullInt));
		assertNull(Utilities.mod(nullInt, int2));
		assertNull(Utilities.mod(double4,  nullDouble));
		assertNull(Utilities.mod(nullDouble,  double2));
	}
	
	@Test
	public void test4add() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer i2 = Integer.valueOf(2);
		Integer i4 = Integer.valueOf(4);
		Double d2 = Double.valueOf(2);
		Double d4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(4+2), Utilities.add(i4,  i2));
		assertEquals(Double.valueOf(4+2), Utilities.add(d4,  d2));
		assertEquals(Double.valueOf(4+2), Utilities.add(i4,  d2));
		assertEquals(Double.valueOf(4+2), Utilities.add(d4,  i2));
		assertNull(Utilities.add(i2, nullInt));
		assertNull(Utilities.add(nullInt, i4));
		assertNull(Utilities.add(nullInt, nullInt));
		assertNull(Utilities.add(d2, nullDouble));
		assertNull(Utilities.add(nullDouble, d4));
		assertNull(Utilities.add(nullDouble, nullDouble));
	}
	
	@Test
	public void test4sub() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer i2 = Integer.valueOf(2);
		Integer i4 = Integer.valueOf(4);
		Double d2 = Double.valueOf(2);
		Double d4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(4-2), Utilities.sub(i4,  i2));
		assertEquals(Double.valueOf(4-2), Utilities.sub(d4,  d2));
		assertEquals(Double.valueOf(4-2), Utilities.sub(i4,  d2));
		assertEquals(Double.valueOf(4-2), Utilities.sub(d4,  i2));
		assertNull(Utilities.sub(i2, nullInt));
		assertNull(Utilities.sub(nullInt, i4));
		assertNull(Utilities.sub(nullInt, nullInt));
		assertNull(Utilities.sub(d2, nullDouble));
		assertNull(Utilities.sub(nullDouble, d4));
		assertNull(Utilities.sub(nullDouble, nullDouble));
	}
	
	@Test
	public void test4mult() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer i2 = Integer.valueOf(2);
		Integer i4 = Integer.valueOf(4);
		Double d2 = Double.valueOf(2);
		Double d4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(4*2), Utilities.mult(i4,  i2));
		assertEquals(Double.valueOf(4*2), Utilities.mult(d4,  d2));
		assertEquals(Double.valueOf(4*2), Utilities.mult(i4,  d2));
		assertEquals(Double.valueOf(4*2), Utilities.mult(d4,  i2));
		assertNull(Utilities.mult(i2, nullInt));
		assertNull(Utilities.mult(nullInt, i4));
		assertNull(Utilities.mult(nullInt, nullInt));
		assertNull(Utilities.mult(d2, nullDouble));
		assertNull(Utilities.mult(nullDouble, d4));
		assertNull(Utilities.mult(nullDouble, nullDouble));
	}
	
	@Test
	public void test4div() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer i2 = Integer.valueOf(2);
		Integer i4 = Integer.valueOf(4);
		Double d2 = Double.valueOf(2);
		Double d4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(4 / 2), Utilities.div(i4,  i2));
		assertEquals(Double.valueOf(4 / 2), Utilities.div(d4,  d2));
		assertEquals(Double.valueOf(4 / 2), Utilities.div(i4,  d2));
		assertEquals(Double.valueOf(4 / 2), Utilities.div(d4,  i2));
		assertNull(Utilities.div(i2, nullInt));
		assertNull(Utilities.div(nullInt, i4));
		assertNull(Utilities.div(nullInt, nullInt));
		assertNull(Utilities.div(d2, nullDouble));
		assertNull(Utilities.div(nullDouble, d4));
		assertNull(Utilities.div(nullDouble, nullDouble));
	}
	
	@Test
	public void test4divint() {
		Integer nullInt = null;
		Double nullDouble = null;
		Integer i2 = Integer.valueOf(2);
		Integer i4 = Integer.valueOf(4);
		Double d2 = Double.valueOf(2);
		Double d4 = Double.valueOf(4);
		assertEquals(Integer.valueOf(4 / 2), Utilities.divint(i4,  i2));
		assertEquals(Integer.valueOf(4 / 2), Utilities.divint(d4,  d2));
		assertEquals(Integer.valueOf(4 / 2), Utilities.divint(i4,  d2));
		assertEquals(Integer.valueOf(4 / 2), Utilities.divint(d4,  i2));
		assertNull(Utilities.div(i2, nullInt));
		assertNull(Utilities.div(nullInt, i4));
		assertNull(Utilities.div(nullInt, nullInt));
		assertNull(Utilities.div(d2, nullDouble));
		assertNull(Utilities.div(nullDouble, d4));
		assertNull(Utilities.div(nullDouble, nullDouble));
	}
	
	@Test
	public void test4pathToCamelCase() {
		assertEquals("firstRole.secondRole", Utilities.pathToCamelCase("FirstRole.SecondRole"));
	}
}

