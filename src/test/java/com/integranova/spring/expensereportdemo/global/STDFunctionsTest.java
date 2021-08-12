package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class STDFunctionsTest {
	
	@Test
	public void test4absIntFun() {
		Long expected = 1L;
		assertEquals(expected, STDFunctions.absIntFun(-1L));
		assertNull(STDFunctions.absIntFun(null));
	}
	
	@Test
	public void test4absRealFun() {
		Double expected = 1.0;
		assertEquals(expected, STDFunctions.absRealFun(-1.0));
		assertNull(STDFunctions.absRealFun(null));
	}
	
	@Test
	public void test4acosFun() {
		assertNull(STDFunctions.acosFun(null));
		assertEquals(Double.valueOf(Math.acos(0.5)), STDFunctions.acosFun(0.5));
	}
	
	@Test(expected = ArithmeticException.class)
    public void test4acosFunException() {
		STDFunctions.acosFun(-2.0);
    }
	
	@Test(expected = ArithmeticException.class)
    public void test4acosFunException2() {
		STDFunctions.acosFun(2.0);
    }
	
	@Test
	public void test4acoshFun() {
		double value = 0.5;
		assertEquals(Double.valueOf(Math.log(value + Math.sqrt(value * value - 1))), STDFunctions.acoshFun(value));
		assertNull(STDFunctions.acoshFun(null));
	}
	
	@Test
	public void test4acotFun() {
		double value = 0.5;
		assertEquals(Double.valueOf(Math.PI / 2 - Math.atan(value)), STDFunctions.acotFun(value));
		assertNull(STDFunctions.acotFun(null));
	}
	
	@Test
	public void test4acothFun() {
		double value = 0.5;
		assertEquals(Double.valueOf(Math.log((value + 1) / (value - 1)) / 2), STDFunctions.acothFun(value));		
		assertNull(STDFunctions.acothFun(null));
	}

	@Test
	public void test4acsecFun() {
		Double value = 0.5;
		Double expected = Double.valueOf(Math.atan(STDFunctions.signFun(value).intValue() / Math.sqrt(value * value - 1)));
		assertEquals(expected, STDFunctions.acsecFun(value));
		assertNull(STDFunctions.acsecFun(null));
	}
	
	@Test
	public void test4asechFun() {
		Double value = 0.5;
		Double expected = 1.3169578969248166;
		assertEquals(expected, STDFunctions.asechFun(value));
		assertNull(STDFunctions.asechFun(null));
	}
	
	@Test
	public void test4acsechFun() {
		double value = 0.5;
		Double expected = Double.valueOf(Math.log((STDFunctions.signFun(value).intValue() * Math.sqrt(value * value + 1) + 1) / value));
		assertEquals(expected, STDFunctions.acsechFun(value));
		assertNull(STDFunctions.acsechFun(null));
	}
	
	@Test
	public void test4asinFun() {
		double value = 0.5;
		Double expected = 0.5235987755982989;
		assertEquals(expected, STDFunctions.asinFun(value));
		assertNull(STDFunctions.asinFun(null));
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4asinFunException() {
		double value = -1.5;
		STDFunctions.asinFun(value);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4asinFunException2() {
		double value = 1.5;
		STDFunctions.asinFun(value);
	}
	
	@Test
	public void test4asinhFun() {
		double value = 0.5;
		Double expected = Double.valueOf(Math.log(value + Math.sqrt(value * value + 1)));
		assertEquals(expected, STDFunctions.asinhFun(value));
		assertNull(STDFunctions.asinhFun(null));
	}

	@Test
	public void test4atan2Fun() {
		double pX = 0.5;
		double pY = 0.5;
		Double expected = Double.valueOf(Math.atan2(pX, pY));
		assertEquals(expected, STDFunctions.atan2Fun(pX, pY));
		assertNull(STDFunctions.atan2Fun(pX, null));
		assertNull(STDFunctions.atan2Fun(null, pY));
	}

	@Test
	public void test4atanFun() {
		double value = 0.5;
		Double expected = Double.valueOf(Math.atan(value));
		assertEquals(expected, STDFunctions.atanFun(value));
		assertNull(STDFunctions.atanFun(null));
	}
	
	@Test
	public void test4atanhFun() {
		double value = 0.5;
		Double expected = Double.valueOf(Math.log((1 + value) / (1 - value)) / 2);
		assertEquals(expected, STDFunctions.atanhFun(value));
		assertNull(STDFunctions.atanhFun(null));
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4atahFunException() {
		STDFunctions.atanhFun(-2.0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4atahFunException2() {
		STDFunctions.atanhFun(2.0);
	}
	
	@Test
	public void test4ceilingFun() {
		Double value = 0.5;
		Long expected = 1L;
		assertEquals(expected, STDFunctions.ceilingFun(value));
		assertNull(STDFunctions.ceilingFun(null));
	}
	
	@Test
	public void test4concatFun() {
		String arg1 = "First";
		String arg2 = "Second";
		String expected = "FirstSecond";
		assertEquals(expected, STDFunctions.concatFun(arg1, arg2));
	}
	
	@Test
	public void test4cosFun() {
		double value = 0.5;
		Double expected = Double.valueOf(Math.cos(value));
		assertEquals(expected, STDFunctions.cosFun(value));
		assertNull(STDFunctions.cosFun(null));
	}
	
	@Test
	public void test4coshFun() {
		double value = 0.5;
		Double expected = Double.valueOf((Math.exp(value) + Math.exp(-value)) / 2);
		assertEquals(expected, STDFunctions.coshFun(value));
		assertNull(STDFunctions.coshFun(null));
	}
	
	@Test
	public void test4cotFun() {
		double value = 0.5;
		Double expected = Double.valueOf(1 / Math.tan(value));
		assertEquals(expected, STDFunctions.cotFun(value));
		assertNull(STDFunctions.cotFun(null));
	}
	
	@Test
	public void test4cothFun() {
		double value = 0.5;
		Double expected = Double.valueOf((Math.exp(value) + Math.exp(-value)) / (Math.exp(value) - Math.exp(-value)));
		assertEquals(expected, STDFunctions.cothFun(value));
		assertNull(STDFunctions.cothFun(null));
	}
	
	@Test
	public void test4csecFun() {
		double value = 0.5;
		Double expected = Double.valueOf(1 / STDFunctions.sinFun(value).doubleValue());
		assertEquals(expected, STDFunctions.csecFun(value));
		assertNull(STDFunctions.csecFun(null));
	}
	
	@Test
	public void test4csechFun() {
		double value = 0.5;
		Double expected = Double.valueOf(2 / (Math.exp(value) - Math.exp(-value)));
		assertEquals(expected, STDFunctions.csechFun(value));
		assertNull(STDFunctions.csechFun(null));
	}
	
	@Test
	public void test4dateAddFun() {
		Date date1 = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.dateAddFun("yyyy", 1L, date1));
		assertNotNull(STDFunctions.dateAddFun("m", 1L, date1));
		assertNotNull(STDFunctions.dateAddFun("d", 1L, date1));
		assertNotNull(STDFunctions.dateAddFun("X", 1L, date1));
		assertNull(STDFunctions.dateAddFun("d", null, null));
		assertNull(STDFunctions.dateAddFun(null, 1L, date1));
		assertNull(STDFunctions.dateAddFun("d", null, date1));
		assertNull(STDFunctions.dateAddFun("d", 1L, null));
		assertNull(STDFunctions.dateAddFun(null, null, null));
	}
	
	@Test
	public void test4dateAfter() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 5000);
		assertTrue(STDFunctions.dateAfter(date2, date1));
		assertFalse(STDFunctions.dateAfter(date1, null));
	}
	
	@Test
	public void test4dateAfterFun() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 5000);
		assertTrue(STDFunctions.dateAfterFun(date2, date1));
		assertNull(STDFunctions.dateAfterFun(date2, null));
		assertNull(STDFunctions.dateAfterFun(null, date1));
		assertNull(STDFunctions.dateAfterFun(null, null));
	}
	
	@Test
	public void test4dateBefore() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 5000);
		assertTrue(STDFunctions.dateBefore(date1, date2));
		assertFalse(STDFunctions.dateBefore(date1, null));
	}
	
	@Test
	public void test4dateBeforeFun() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 5000);
		assertTrue(STDFunctions.dateBeforeFun(date1, date2));
		assertNull(STDFunctions.dateBeforeFun(date1, null));
		assertNull(STDFunctions.dateBeforeFun(null, date2));
		assertNull(STDFunctions.dateBeforeFun(null, null));
	}
	
	
	@Test
	public void test4dateEqualsFun() {
		Date date1 = new Date(System.currentTimeMillis());
		assertTrue(STDFunctions.dateEqualsFun(date1, date1));
		assertNull(STDFunctions.dateEqualsFun(date1, null));
		assertNull(STDFunctions.dateEqualsFun(null, date1));
		assertNull(STDFunctions.dateEqualsFun(null, null));
	}
	
	@Test
	public void test4dateTimeAddFun() {
		Date date1 = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.dateTimeAddFun("yyyy", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("m", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("d", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("h", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("n", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("s", 1L, date1));
		assertNotNull(STDFunctions.dateTimeAddFun("X", 1L, date1));
		assertNull(STDFunctions.dateTimeAddFun(null, 1L, date1));
		assertNull(STDFunctions.dateTimeAddFun("d", null, date1));
		assertNull(STDFunctions.dateTimeAddFun("d", 1L, null));
	}
	
	@Test
	public void test4datetimeAfterFun() {
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = new Timestamp(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.datetimeAfterFun(ts2, ts1));
		assertNull(STDFunctions.datetimeAfterFun(ts1, null));
		assertNull(STDFunctions.datetimeAfterFun(null, ts2));
		assertNull(STDFunctions.datetimeAfterFun(ts1, null));
	}
	
	@Test
	public void test4datetimeBeforeFun() {
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = new Timestamp(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.datetimeBeforeFun(ts1, ts2));
		assertNull(STDFunctions.datetimeBeforeFun(ts1, null));
		assertNull(STDFunctions.datetimeBeforeFun(null, ts2));
		assertNull(STDFunctions.datetimeBeforeFun(ts1, null));
	}
	
	@Test
	public void test4datetimeEqualsFun() {
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		assertTrue(STDFunctions.datetimeEqualsFun(ts1, ts1));
		assertNull(STDFunctions.datetimeEqualsFun(ts1, null));
		assertNull(STDFunctions.datetimeEqualsFun(null, ts1));
		assertNull(STDFunctions.datetimeEqualsFun(ts1, null));
	}
	
	@Test
	public void test4dateTimeToStringFun() {
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		assertNotNull(STDFunctions.dateTimeToStringFun(ts1));
		assertNull(STDFunctions.dateTimeToStringFun(null));
	}
	
	@Test
	public void test4daysDifferenceFromDate() {
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 50000);
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDate(date2, date1));
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDate(date1, date1));
	}
	
	@Test
	public void test4daysDifferenceFromDateFun() {
		
		Date date1 = new Date(System.currentTimeMillis());
		Date date2 = new Date(System.currentTimeMillis() + 50000);
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDateFun(date2, date1));
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDateFun(date1, date1));
		assertNull(STDFunctions.daysDifferenceFromDateFun(date1, null));
		assertNull(STDFunctions.daysDifferenceFromDateFun(null, date1));
		assertNull(STDFunctions.daysDifferenceFromDateFun(null, null));
	}
	
	@Test
	public void test4daysDifferenceFromDateTimeFun() {
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = new Timestamp(System.currentTimeMillis() + 500000000);
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDateTimeFun(ts1, ts1));
		assertEquals(Long.valueOf(7), STDFunctions.daysDifferenceFromDateTimeFun(ts1, ts2));
		assertEquals(Long.valueOf(0), STDFunctions.daysDifferenceFromDateTimeFun(ts2, ts1));
		assertNull(STDFunctions.daysDifferenceFromDateTimeFun(ts1, null));
		assertNull(STDFunctions.daysDifferenceFromDateTimeFun(null, ts1));
		assertNull(STDFunctions.daysDifferenceFromDateTimeFun(null, null));
	}
	
	@Test
	public void test4daysInMonth() {
		Long year = 2019L;
		Long leapYear = 2020L;
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 1L));
		assertEquals(Long.valueOf(28), STDFunctions.daysInMonthFun(year, 2L));
		assertEquals(Long.valueOf(29), STDFunctions.daysInMonthFun(leapYear, 2L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 3L));
		assertEquals(Long.valueOf(30), STDFunctions.daysInMonthFun(year, 4L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 5L));
		assertEquals(Long.valueOf(30), STDFunctions.daysInMonthFun(year, 6L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 7L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 8L));
		assertEquals(Long.valueOf(30), STDFunctions.daysInMonthFun(year, 9L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 10L));
		assertEquals(Long.valueOf(30), STDFunctions.daysInMonthFun(year, 11L));
		assertEquals(Long.valueOf(31), STDFunctions.daysInMonthFun(year, 12L));
		assertNull(STDFunctions.daysInMonthFun(null, 1L));
		assertNull(STDFunctions.daysInMonthFun(year, null));
		assertNull(STDFunctions.daysInMonthFun(null, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4daysInMonthException() {
		STDFunctions.daysInMonthFun(-1L, 1L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4daysInMonthException2() {
		STDFunctions.daysInMonthFun(1970L, -1L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4daysInMonthException3() {
		STDFunctions.daysInMonthFun(1970L, 13L);
	}
	
	@Test
	public void test4EulerFun() {
		assertEquals(Double.valueOf(Math.E), STDFunctions.eulerFun());
	}
	
	@Test
	public void test4expFun() {
		double value = 0.5;
		Double expected = Math.exp(value);
		assertEquals(expected, STDFunctions.expFun(value));
		assertNull(STDFunctions.expFun(null));
	}
	
	@Test
	public void test4floorFun() {
		double value = 0.5;
		Long expected = Double.valueOf(Math.floor(value)).longValue();
		assertEquals(expected, STDFunctions.floorFun(value));
		assertNull(STDFunctions.floorFun(null));
	}
	
	@Test
	public void test4formatToDateFunInt() {
		int year = 1970;
		int month = 1;
		int day = 1;
		assertNotNull(STDFunctions.formatToDateFun(year, month, day));
	}
	
	@Test
	public void test4formatToDateFunLong() {
		Long year = 1970L;
		Long month = 1L;
		Long day = 1L;
		assertNotNull(STDFunctions.formatToDateFun(year, month, day));
		assertNull(STDFunctions.formatToDateFun(null, month, day));
		assertNull(STDFunctions.formatToDateFun(year, null, day));
		assertNull(STDFunctions.formatToDateFun(year, month, null));
	}
	
	@Test
	public void test4formatToDateTimeFunInt() {
		int year = 1970;
		int month = 1;
		int day = 1;
		int hour = 0;
		int minute = 0;
		int second = 0;
		assertNotNull(STDFunctions.formatToDateTimeFun(year, month, day, hour, minute, second));
	}
	
	@Test
	public void test4formatToDateTimeFunLong() {
		Long year = 1970L;
		Long month = 1L;
		Long day = 1L;
		Long hour = 0L;
		Long minute = 0L;
		Long second = 0L;
		assertNotNull(STDFunctions.formatToDateTimeFun(year, month, day, hour, minute, second));
		assertNull(STDFunctions.formatToDateTimeFun(null, month, day, hour, minute, second));
		assertNull(STDFunctions.formatToDateTimeFun(year, null, day, hour, minute, second));
		assertNull(STDFunctions.formatToDateTimeFun(year, month, null, hour, minute, second));
		assertNull(STDFunctions.formatToDateTimeFun(year, month, day, null, minute, second));
		assertNull(STDFunctions.formatToDateTimeFun(year, month, day, hour, null, second));
		assertNull(STDFunctions.formatToDateTimeFun(year, month, day, hour, minute, null));
		assertNull(STDFunctions.formatToDateTimeFun(null, null, null, null, null, null));
	}
	
	@Test
	public void test4formatToTimeFunInt() {
		int hour = 0;
		int minute = 0;
		int second = 0;
		assertNotNull(STDFunctions.formatToTimeFun(hour, minute, second));
	}
	
	@Test
	public void test4formatToTimeFunLong() {
		Long hour = 0L;
		Long minute = 0L;
		Long second = 0L;
		assertNotNull(STDFunctions.formatToTimeFun(hour, minute, second));
		assertNull(STDFunctions.formatToTimeFun(null, minute, second));
		assertNull(STDFunctions.formatToTimeFun(hour, null, second));
		assertNull(STDFunctions.formatToTimeFun(hour, minute, null));
		assertNull(STDFunctions.formatToTimeFun(null, null, null));
	}
	
	@Test
	public void test4gcdFun() {
		assertEquals(Long.valueOf(2), STDFunctions.gcdFun(4L, 2L));
		assertNull(STDFunctions.gcdFun(4L, null));
		assertNull(STDFunctions.gcdFun(null, 2L));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test4gcdFunException() {
		STDFunctions.gcdFun(0L, 0L);
	}
	
	@Test
	public void test4getDatePartFun() {
		Long currentTimeMillis = System.currentTimeMillis();
		java.sql.Date expected = new java.sql.Date(currentTimeMillis);
		Timestamp ts = new Timestamp(currentTimeMillis);
		assertEquals(expected.toString(), STDFunctions.getDatePartFun(ts).toString());
		assertNull(STDFunctions.getDatePartFun(null));
	}
	
	@Test
	public void test4getDayFun() {
		Date date1 = STDFunctions.formatToDateFun(1970, 1, 1);
		Long expected = Long.valueOf(1);
		assertEquals(expected, STDFunctions.getDayFun(date1));
		assertNull(STDFunctions.getDayFun(null));
	}
	
	@Test
	public void test4getDayOfWeekFun() {
		Date date1 = STDFunctions.formatToDateFun(1970, 1, 1);
		Long expected = Long.valueOf(5);
		assertEquals(expected, STDFunctions.getDayOfWeekFun(date1));
		assertNull(STDFunctions.getDayOfWeekFun(null));
	}
	
	@Test
	public void test4getDayOfYearFun() {
		Date date1 = STDFunctions.formatToDateFun(1970, 1, 1);
		Long expected = Long.valueOf(1);
		assertEquals(expected, STDFunctions.getDayOfYearFun(date1));
		assertNull(STDFunctions.getDayOfYearFun(null));
	}
	
	@Test
	public void test4getHourFun() {
		Time time1 = STDFunctions.formatToTimeFun(12, 0, 0);
		Long expected = Long.valueOf(12);
		assertEquals(expected, STDFunctions.getHourFun(time1));
		assertNull(STDFunctions.getHourFun(null));
	}
	
	@Test
	public void test4getMinuteFun() {
		Time time1 = STDFunctions.formatToTimeFun(12, 0, 0);
		Long expected = Long.valueOf(0);
		assertEquals(expected, STDFunctions.getMinuteFun(time1));
		assertNull(STDFunctions.getMinuteFun(null));
	}
	
	@Test
	public void test4getMonthFun() {
		Date date1 = STDFunctions.formatToDateFun(1970, 1, 1);
		Long expected = Long.valueOf(1);
		assertEquals(expected, STDFunctions.getMonthFun(date1));
		assertNull(STDFunctions.getMonthFun(null));
	}
	
	@Test
	public void test4getNumDayOfWeekBetweenDatesFun() {
		Long dayOfWeek = 1L;
		java.sql.Date iniDate = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
		Long expected = Long.valueOf(0);
		assertEquals(expected, STDFunctions.getNumDayOfWeekBetweenDatesFun(dayOfWeek, iniDate, endDate));
		assertNull(STDFunctions.getNumDayOfWeekBetweenDatesFun(null, iniDate, endDate));
		assertNull(STDFunctions.getNumDayOfWeekBetweenDatesFun(dayOfWeek, null, endDate));
		assertNull(STDFunctions.getNumDayOfWeekBetweenDatesFun(dayOfWeek, iniDate, null));
		assertNull(STDFunctions.getNumDayOfWeekBetweenDatesFun(null, null, null));
	}
	
	@Test
	public void test4getSecondFun() {
		Time time1 = STDFunctions.formatToTimeFun(12, 0, 0);
		Long expected = Long.valueOf(0);
		assertEquals(expected, STDFunctions.getSecondFun(time1));
		assertNull(STDFunctions.getSecondFun(null));
	}
	
	@Test
	public void test4getTimePart() {
		Timestamp ts1 = STDFunctions.formatToDateTimeFun(1970, 1, 1, 12, 0, 0);
		Time expected = STDFunctions.formatToTimeFun(12, 0, 0);
		assertEquals(expected, STDFunctions.getTimePartFun(ts1));
		assertNull(STDFunctions.getTimePartFun(null));
	}
	
	@Test
	public void test4getYearFun() {
		Date date1 = STDFunctions.formatToDateFun(1970, 1, 1);
		Long expected = Long.valueOf(1970);
		assertEquals(expected, STDFunctions.getYearFun(date1));
		assertNull(STDFunctions.getYearFun(null));
	}
	
	@Test
	public void test4indexOfFromFun() {
		String aString = "AString";
		String aSubstring = "A";
		Long from = 0L;
		Long expected = 1L;
		assertEquals(expected, STDFunctions.indexOfFromFun(aString, aSubstring, from));
		assertNull(STDFunctions.indexOfFromFun(null, aSubstring, from));
		assertNull(STDFunctions.indexOfFromFun(aString, null, from));
		assertNull(STDFunctions.indexOfFromFun(aString, aSubstring, null));
		assertNull(STDFunctions.indexOfFromFun(null, null, null));
	}
	
	@Test
	public void test4indexOfFun() {
		String aString = "AString";
		String aSubstring = "A";
		Long expected = 1L;
		assertEquals(expected, STDFunctions.indexOfFun(aString, aSubstring));
		assertNull(STDFunctions.indexOfFun(null, aSubstring));
		assertNull(STDFunctions.indexOfFun(aString, null));
		assertNull(STDFunctions.indexOfFun(null, null));
	}
	
	@Test
	public void test4intToStrFun() {
		Long number = 1L;
		String expected = "1";
		assertEquals(expected, STDFunctions.intToStrFun(number));
		assertNull(STDFunctions.intToStrFun(null));
	}
	
	@Test
	public void test4isLeapYearFun() {
		Long nonLeapYear = 2019L;
		Long leapYear = 2020L;
		assertFalse(STDFunctions.isLeapYearFun(nonLeapYear));
		assertTrue(STDFunctions.isLeapYearFun(leapYear));
		assertNull(STDFunctions.isLeapYearFun(null));
	}
	
	@Test
	public void test4lastIndexOfFromFun() {
		String aString = "AString";
		String aSubstring = "A";
		Long from = 0L;
		Long expected = 0L;
		assertEquals(expected, STDFunctions.lastIndexOfFromFun(aString, aSubstring, from));
		assertNull(STDFunctions.lastIndexOfFromFun(null, aSubstring, from));
		assertNull(STDFunctions.lastIndexOfFromFun(aString, null, from));
		assertNull(STDFunctions.lastIndexOfFromFun(aString, aSubstring, null));
		assertNull(STDFunctions.lastIndexOfFromFun(null, null, null));
	}
	
	@Test
	public void test4lastIndexOfFun() {
		String aString = "AString";
		String aSubstring = "A";
		Long expected = 1L;
		assertEquals(expected, STDFunctions.lastIndexOfFun(aString, aSubstring));
		assertNull(STDFunctions.lastIndexOfFun(null, aSubstring));
		assertNull(STDFunctions.lastIndexOfFun(aString, null));
		assertNull(STDFunctions.lastIndexOfFun(null, null));
	}
	
	@Test
	public void test4lcmFun() {
		Long arg1 = 6L;
		Long arg2 = 8L;
		Long expected = 24L;
		assertEquals(expected, STDFunctions.lcmFun(arg1, arg2));
		assertNull(STDFunctions.lcmFun(arg1, null));
		assertNull(STDFunctions.lcmFun(null, arg2));
		assertNull(STDFunctions.lcmFun(null, null));
	}
	
	@Test
	public void test4leftSubstringFun() {
		String aString = "AString";
		Long size = 2L;
		String expected = "AS";
		assertEquals(expected, STDFunctions.leftSubstringFun(aString, size));
		assertNull(STDFunctions.leftSubstringFun(null, size));
		assertNull(STDFunctions.leftSubstringFun(aString, null));
		assertNull(STDFunctions.leftSubstringFun(null, null));
	}
	
	@Test
	public void test4leftTrimFun() {
		String aString = "  AString";
		String expected = "AString";
		assertEquals(expected, STDFunctions.leftTrimFun(aString));
		assertNull(STDFunctions.leftTrimFun(null));
	}
	
	@Test
	public void test4lengthFun() {
		String aString = "AString";
		Long expected = 7L;
		assertEquals(expected, STDFunctions.lengthFun(aString));
		assertNull(STDFunctions.lengthFun(null));
	}
	
	@Test
	public void test4logBaseFun() {
		Double value = 10.0;
		Double base = 5.0;
		Double expected = 1.4306765580733933;
		assertEquals(expected, STDFunctions.logBaseFun(value, base));
		assertNull(STDFunctions.logBaseFun(value, null));
		assertNull(STDFunctions.logBaseFun(null, base));
		assertNull(STDFunctions.logBaseFun(null, null));
	}
	
	@Test
	public void test4logFun() {
		Double value = 10.0;
		Double expected = 2.302585092994046;
		assertEquals(expected, STDFunctions.logFun(value));
		assertNull(STDFunctions.logFun(null));
	}
	
	@Test
	public void test4lowerCaseFun() {
		String aString = "ASTRING";
		String expected = "astring";
		assertEquals(expected, STDFunctions.lowerCaseFun(aString));
		assertNull(STDFunctions.lowerCaseFun(null));
	}
	
	@Test
	public void test4maxFun() {
		Double value1 = 10.0;
		Double value2 = 5.0;
		assertEquals(value1, STDFunctions.maxFun(value1, value2));
		assertNull(STDFunctions.maxFun(value1, null));
		assertNull(STDFunctions.maxFun(null, value2));
		assertNull(STDFunctions.maxFun(null, null));
	}
	
	@Test
	public void test4maxIntFun() {
		Long value1 = 10L;
		Long value2 = 5L;
		assertEquals(value1, STDFunctions.maxIntFun(value1, value2));
		assertNull(STDFunctions.maxIntFun(value1, null));
		assertNull(STDFunctions.maxIntFun(null, value2));
		assertNull(STDFunctions.maxIntFun(null, null));
	}
	
	@Test
	public void test4minFun() {
		Double value1 = 10.0;
		Double value2 = 5.0;
		assertEquals(value2, STDFunctions.minFun(value1, value2));
		assertNull(STDFunctions.minFun(value1, null));
		assertNull(STDFunctions.minFun(null, value2));
		assertNull(STDFunctions.minFun(null, null));
	}
	
	@Test
	public void test4minIntFun() {
		Long value1 = 10L;
		Long value2 = 5L;
		assertEquals(value2, STDFunctions.minIntFun(value1, value2));
		assertNull(STDFunctions.minIntFun(value1, null));
		assertNull(STDFunctions.minIntFun(null, value2));
		assertNull(STDFunctions.minIntFun(null, null));
	}
	
	@Test
	public void test4piFun() {
		assertEquals(Double.valueOf(Math.PI), STDFunctions.pIFun());
	}
	
	@Test
	public void test4powFun() {
		Double base = 10.0;
		Double exponent = 2.0;
		Double expected = 100.0;
		assertEquals(expected, STDFunctions.powFun(base, exponent));
		assertNull(STDFunctions.powFun(base, null));
		assertNull(STDFunctions.powFun(null, exponent));
		assertNull(STDFunctions.powFun(null, null));
	}
	
	@Test
	public void test4realToStrFun() {
		Double value = 2.5;
		String expected = "2.5";
		assertEquals(expected, STDFunctions.realToStrFun(value));
		assertNull(STDFunctions.realToStrFun(null));
	}
	
	@Test
	public void test4replaceFromFun() {
		String aString = "Some text";
		String subStr = "Some";
		String other = "Another";
		Long pFrom = 1L;
		String expected = "Another text";
		assertEquals(expected, STDFunctions.replaceFromFun(aString, subStr, other, pFrom));
		assertNull(STDFunctions.replaceFromFun(null, subStr, other, pFrom));
		assertNull(STDFunctions.replaceFromFun(aString, null, other, pFrom));
		assertNull(STDFunctions.replaceFromFun(aString, subStr, null, pFrom));
		assertNull(STDFunctions.replaceFromFun(aString, subStr, other, null));
		assertNull(STDFunctions.replaceFromFun(null, null, null, null));
	}
	
	@Test
	public void test4replaceTimesFun() {
		String aString = "Some text. Some paragrah. Some sentence";
		String subStr = "Some";
		String other = "Another";
		Long pFrom = 1L;
		Long times = 2L;
		String expected = "Another text. Another paragrah. Some sentence";
		assertEquals(expected, STDFunctions.replaceTimesFun(aString, subStr, other, pFrom,times));
		assertNull(STDFunctions.replaceTimesFun(null, subStr, other, pFrom, times));
		assertNull(STDFunctions.replaceTimesFun(aString, null, other, pFrom, times));
		assertNull(STDFunctions.replaceTimesFun(aString, subStr, null, pFrom, times));
		assertNull(STDFunctions.replaceTimesFun(aString, subStr, other, null, times));
		assertNull(STDFunctions.replaceTimesFun(aString, subStr, other, pFrom, null));
		assertNull(STDFunctions.replaceTimesFun(null, null, null, null, null));
	}
	
	@Test
	public void test4reverseFun() {
		String aString = "reverse";
		String expected = "esrever";
		assertEquals(expected, STDFunctions.reverseFun(aString));
		assertNull(STDFunctions.reverseFun(null));
	}
	
	@Test
	public void test4rightSubstringFun() {
		String aString = "Some string";
		Long pSize = Long.valueOf("string".length());
		String expected = "string";
		assertEquals(expected, STDFunctions.rightSubstringFun(aString, pSize));
		assertNull(STDFunctions.rightSubstringFun(null, pSize));
		assertNull(STDFunctions.rightSubstringFun(aString, null));
		assertNull(STDFunctions.rightSubstringFun(null, null));
	}
	
	@Test
	public void test4rightTrimFun() {
		String aString = "  Some string  ";
		String expected = "  Some string";
		assertEquals(expected, STDFunctions.rightTrimFun(aString));
		assertNull(STDFunctions.rightTrimFun(null));
	}
	
	@Test
	public void test4rndFun() {
		assertNotNull(STDFunctions.rndFun());
	}

	@Test
	public void test4rndIntBoundFun() {
		Long pLowerBound = 1L;
		Long pUpperBound = 3L;
		assertNotNull(STDFunctions.rndIntBoundFun(pLowerBound, pUpperBound));
		assertNotNull(STDFunctions.rndIntBoundFun(pLowerBound, pUpperBound));
		assertNull(STDFunctions.rndIntBoundFun(null, pUpperBound));
		assertNull(STDFunctions.rndIntBoundFun(pLowerBound, null));
	}
	
	@Test
	public void test4rndIntegerFun() {
		Long upperBound = 2L;
		assertNotNull(STDFunctions.rndIntegerFun(upperBound));
		assertNull(STDFunctions.rndIntegerFun(null));
	}
	
	@Test
	public void test4rndRealBoundFun() {
		Double pLowerBound = 1.0;
		Double pUpperBound = 3.0;
		assertNotNull(STDFunctions.rndRealBoundFun(pLowerBound, pUpperBound));
		assertNotNull(STDFunctions.rndRealBoundFun(pLowerBound, pUpperBound));
		assertNull(STDFunctions.rndRealBoundFun(null, pUpperBound));
		assertNull(STDFunctions.rndRealBoundFun(pLowerBound, null));
	}
	
	@Test
	public void test4rndRealFun() {
		Double upperBound = 2.0;
		assertTrue(STDFunctions.rndRealFun(upperBound) <= upperBound);
		assertNull(STDFunctions.rndRealFun(null));
	}
	
	@Test
	public void test4roundExFun() {
		Double value = 3.567;
		Long digits = 2L;
		Double expected = 3.57;
		assertEquals(expected, STDFunctions.roundExFun(value, digits));
		assertNull(STDFunctions.roundExFun(null, digits));
		assertNull(STDFunctions.roundExFun(value, null));
		assertNull(STDFunctions.roundExFun(null, null));
	}
	
	@Test
	public void test4roundFun() {
		Double value = 3.567;
		Long expected = 4L;
		assertEquals(expected, STDFunctions.roundFun(value));
		assertNull(STDFunctions.roundFun(null));
	}
	
	@Test
	public void test4secFun() {
		double value = 0.5;
		Double expected = 1.139493927324549;
		assertEquals(expected, STDFunctions.secFun(value));
		assertNull(STDFunctions.secFun(null));
	}
	
	@Test
	public void test4sechFun() {
		double value = 0.5;
		Double expected = 0.886818883970074;
		assertEquals(expected, STDFunctions.sechFun(value));
		assertNull(STDFunctions.sechFun(null));
	}
	
	@Test
	public void test4signFun() {
		assertEquals(Long.valueOf(-1), STDFunctions.signFun(-2.5));
		assertEquals(Long.valueOf(0), STDFunctions.signFun(0.0));
		assertEquals(Long.valueOf(1), STDFunctions.signFun(2.5));
		assertNull(STDFunctions.signFun(null));
	}
	
	@Test
	public void test4sinFun() {
		double value = 0.5;
		Double expected = 0.479425538604203;
		assertEquals(expected, STDFunctions.sinFun(value));
		assertNull(STDFunctions.sinFun(null));
	}
	
	@Test
	public void test4sinhFun() {
		double value = 0.5;
		Double expected = 0.5210953054937474;
		assertEquals(expected, STDFunctions.sinhFun(value));
		assertNull(STDFunctions.sinhFun(null));
	}
	
	@Test
	public void test4sqrtFun() {
		Double value = 25.0;
		Double expected = 5.0;
		assertEquals(expected, STDFunctions.sqrtFun(value));
		assertNull(STDFunctions.sqrtFun(null));
	}
	
	@Test
	public void test4strCompareFun() {
		String firstStr = "ABC";
		String secondStr = "XYZ";
		Long expected = -23L;
		assertEquals(expected, STDFunctions.strCompareFun(firstStr, secondStr));
		assertNull(STDFunctions.strCompareFun(null, secondStr));
		assertNull(STDFunctions.strCompareFun(firstStr, null));
	}
	
	@Test
	public void test4strCompareIgnoreCaseFun() {
		String firstStr = "ABC";
		String secondStr = "aBc";
		Long expected = 0L;
		assertEquals(expected, STDFunctions.strCompareIgnoreCaseFun(firstStr, secondStr));
		assertNull(STDFunctions.strCompareIgnoreCaseFun(null, secondStr));
		assertNull(STDFunctions.strCompareIgnoreCaseFun(firstStr, null));
	}
	
	@Test
	public void test4strDeleteFun() {
		String aString = "Some random text";
		Long pStart = 5L;
		Long pLength = 7L;
		String expected = "Some text";
		assertEquals(expected, STDFunctions.strDeleteFun(aString, pStart, pLength));
		assertNull(STDFunctions.strDeleteFun(null, pStart, pLength));
		assertNull(STDFunctions.strDeleteFun(aString, null, pLength));
		assertNull(STDFunctions.strDeleteFun(aString, pStart, null));
		assertNull(STDFunctions.strDeleteFun(null, null, null));
	}
	
	@Test
	public void test4strEndsWithFun() {
		String aString = "Some string";
		String sufix = "string";
		assertTrue(STDFunctions.strEndsWithFun(aString, sufix));
		assertNull(STDFunctions.strEndsWithFun(null, sufix));
		assertNull(STDFunctions.strEndsWithFun(aString, null));
		assertNull(STDFunctions.strEndsWithFun(null, null));
	}
	
	@Test
	public void test4strGreaterThanFun() {
		String firstStr = "Some string";
		String secondStr = "Another string";
		assertTrue(STDFunctions.strGreaterThanFun(firstStr, secondStr));
		assertNull(STDFunctions.strGreaterThanFun(null, secondStr));
		assertNull(STDFunctions.strGreaterThanFun(firstStr, null));
		assertNull(STDFunctions.strGreaterThanFun(null, null));
	}
	
	@Test
	public void test4stringToDateFun() {
		String stringDate = "01/01/2019";
		assertNotNull(STDFunctions.stringToDateFun(stringDate));
		assertNull(STDFunctions.stringToDateFun(null));
	}
	
	@Test
	public void test4stringToDateTimeFun() {
		String stringDate = "01/01/2019 10:00:00";
		assertNotNull(STDFunctions.stringToDateTimeFun(stringDate));
		assertNull(STDFunctions.stringToDateTimeFun(null));
	}
	
	@Test
	public void test4stringToTimeFun() {
		String stringDate = "10:00:00";
		assertNotNull(STDFunctions.stringToTimeFun(stringDate));
		assertNull(STDFunctions.stringToTimeFun(null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4stringToTimeFunException() {
		String stringDate = "INVALID";
		STDFunctions.stringToTimeFun(stringDate);
	}
	
	@Test
	public void test4strInsertFun() {
		String aString = "Some string";
		Long index = 6L;
		String insertion = "random ";
		String expected = "Some random string";
		assertEquals(expected, STDFunctions.strInsertFun(aString, index, insertion));
		assertNull(STDFunctions.strInsertFun(null, index, insertion));
		assertNull(STDFunctions.strInsertFun(aString, null, insertion));
		assertNull(STDFunctions.strInsertFun(aString, index, null));
		assertNull(STDFunctions.strInsertFun(null, null, null));
	}
	
	@Test
	public void test4strLesserThanFun() {
		String firstStr = "Another string";
		String secondStr = "Some string";
		assertTrue(STDFunctions.strLesserThanFun(firstStr, secondStr));
		assertNull(STDFunctions.strLesserThanFun(null, secondStr));
		assertNull(STDFunctions.strLesserThanFun(firstStr, null));
		assertNull(STDFunctions.strLesserThanFun(null, null));
	}
	
	@Test
	public void test4strRegionMatchesFun() {
		String aString = "Some text";
		Boolean ignoreCase = true;
		Long from = 1L;
		String other = "some paragraph";
		Long otherFrom = 1L;
		Long length = 4L;
		assertTrue(STDFunctions.strRegionMatchesFun(aString, ignoreCase, from, other, otherFrom, length));
		assertNull(STDFunctions.strRegionMatchesFun(null, ignoreCase, from, other, otherFrom, length));
		assertNull(STDFunctions.strRegionMatchesFun(aString, null, from, other, otherFrom, length));
		assertNull(STDFunctions.strRegionMatchesFun(aString, ignoreCase, null, other, otherFrom, length));
		assertNull(STDFunctions.strRegionMatchesFun(aString, ignoreCase, from, null, otherFrom, length));
		assertNull(STDFunctions.strRegionMatchesFun(aString, ignoreCase, from, other, null, length));
		assertNull(STDFunctions.strRegionMatchesFun(aString, ignoreCase, from, other, otherFrom, null));
		assertNull(STDFunctions.strRegionMatchesFun(null, null, null, null, null, null));
	}
	
	@Test
	public void test4strReplaceFun() {
		String aString = "Some random text";
		String subStr = "random";
		String other = "miscelaneous";
		String expected = "Some miscelaneous text";
		assertEquals(expected, STDFunctions.strReplaceFun(aString, subStr, other));
		assertNull(STDFunctions.strReplaceFun(null, subStr, other));
		assertNull(STDFunctions.strReplaceFun(aString, null, other));
		assertNull(STDFunctions.strReplaceFun(aString, subStr, null));
		assertNull(STDFunctions.strReplaceFun(null, null, null));
	}
	
	@Test
	public void test4strSameAsFun() {
		String firstStr = "some";
		String secondStr = "some";
		assertTrue(STDFunctions.strSameAsFun(firstStr, secondStr));
		assertNull(STDFunctions.strSameAsFun(null, secondStr));
		assertNull(STDFunctions.strSameAsFun(firstStr, null));
		assertNull(STDFunctions.strSameAsFun(null, null));
	}
	
	@Test
	public void test4strStartsWithFromFun() {
		String aString = "AStringWithPrefix";
	    String prefix = "Prefix";
	    Long from = Long.valueOf("AStringWith".length());
	    assertTrue(STDFunctions.strStartsWithFromFun(aString, prefix, from));
	    assertNull(STDFunctions.strStartsWithFromFun(null, prefix, from));
	    assertNull(STDFunctions.strStartsWithFromFun(aString, null, from));
	    assertNull(STDFunctions.strStartsWithFromFun(aString, prefix, null));
	}
	
	@Test
	public void test4strStartsWithFun() {
		String aString = "AStringWithPrefix";
	    String prefix = "AString";
	    assertTrue(STDFunctions.strStartsWithFun(aString, prefix));
	    assertNull(STDFunctions.strStartsWithFun(null, prefix));
	    assertNull(STDFunctions.strStartsWithFun(aString, null));
	}
	
	@Test
	public void test4strToIntFun() {
		String value = "21";
		Long expected = 21L;
		assertEquals(expected, STDFunctions.strToIntFun(value));
		assertNull(STDFunctions.strToIntFun(null));
	}
	
	@Test
	public void test4strToRealFun() {
		String value = "21.7";
		Double expected = Double.valueOf(value);
		assertEquals(expected, STDFunctions.strToRealFun(value));
		assertNull(STDFunctions.strToRealFun(null));
	}
	
	@Test
	public void test4strTrimFun() {
		String aString = "  Some string  ";
		String expected = "Some string";
		assertEquals(expected, STDFunctions.strTrimFun(aString));
		assertNull(STDFunctions.strTrimFun(null));
	}
	
	@Test
	public void test4substringFun() {
		String aString = "Some random string";
		Long pFrom = 6L;
		Long pSize = 6L;
		String expected = "random";
		assertEquals(expected, STDFunctions.substringFun(aString, pFrom, pSize));
		assertNull(STDFunctions.substringFun(null, pFrom, pSize));
		assertNull(STDFunctions.substringFun(aString, null, pSize));
		assertNull(STDFunctions.substringFun(aString, pFrom, null));
	}
	
	@Test
	public void test4systemDateFun() {
		assertNotNull(STDFunctions.systemDateFun());
	}
	
	@Test
	public void test4systemDateTimeFun() {
		assertNotNull(STDFunctions.systemDateTimeFun());
	}
	
	@Test
	public void test4systemTimeFun() {
		assertNotNull(STDFunctions.systemTimeFun());
	}
	
	@Test
	public void test4tanFun() {
		double value = 0.5;
		Double expected = 0.5463024898437905;
		assertEquals(expected, STDFunctions.tanFun(value));
		assertNull(STDFunctions.tanFun(null));
	}
	
	@Test
	public void test4tanhFun() {
		double value = 0.5;
		Double expected = 0.4621171572600098;
		assertEquals(expected, STDFunctions.tanhFun(value));
		assertNull(STDFunctions.tanhFun(null));
	}
	
	@Test
	public void test4textToStrFun() {
		String text = "Some string";
		String expected = text;
		assertEquals(expected, STDFunctions.textToStrFun(text));
	}
	
	@Test
	public void test4timeAddFun() {
		Long pNumber = 1L;
		Time aTime = new Time(System.currentTimeMillis());
		assertNotNull(STDFunctions.timeAddFun("h", pNumber, aTime));
		assertNotNull(STDFunctions.timeAddFun("n", pNumber, aTime));
		assertNotNull(STDFunctions.timeAddFun("s", pNumber, aTime));
		assertNotNull(STDFunctions.timeAddFun("X", pNumber, aTime));
		assertNull(STDFunctions.timeAddFun(null, pNumber, aTime));
		assertNull(STDFunctions.timeAddFun("h", null, aTime));
		assertNull(STDFunctions.timeAddFun("h", pNumber, null));
	}
	
	@Test
	public void test4timeAfter() {
		Time atime1 = new Time(System.currentTimeMillis());
		Time atime2 = new Time(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.timeAfter(atime2, atime1));
		assertFalse(STDFunctions.timeAfter(null, atime1));
		assertFalse(STDFunctions.timeAfter(atime2, null));
	}
	
	@Test
	public void test4timeAfterFun() {
		Time atime1 = new Time(System.currentTimeMillis());
		Time atime2 = new Time(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.timeAfterFun(atime2, atime1));
		assertNull(STDFunctions.timeAfterFun(null, atime1));
		assertNull(STDFunctions.timeAfterFun(atime2, null));
	}
	
	@Test
	public void test4timeBefore() {
		Time atime1 = new Time(System.currentTimeMillis());
		Time atime2 = new Time(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.timeBefore(atime1, atime2));
		assertFalse(STDFunctions.timeBefore(null, atime2));
		assertFalse(STDFunctions.timeBefore(atime1, null));
	}
	
	@Test
	public void test4timeBeforeFun() {
		Time atime1 = new Time(System.currentTimeMillis());
		Time atime2 = new Time(System.currentTimeMillis() + 50000);
		assertTrue(STDFunctions.timeBeforeFun(atime1, atime2));
		assertNull(STDFunctions.timeBeforeFun(null, atime2));
		assertNull(STDFunctions.timeBeforeFun(atime1, null));
	}
	
	@Test
	public void test4timeEqualsFun() {
		Time atime1 = new Time(System.currentTimeMillis());
		Time atime2 = new Time(System.currentTimeMillis() + 5000000);
		assertTrue(STDFunctions.timeEqualsFun(atime1, atime1));
		assertFalse(STDFunctions.timeEqualsFun(atime1, atime2));
		assertNull(STDFunctions.timeEqualsFun(null, atime1));
		assertNull(STDFunctions.timeEqualsFun(atime1, null));
	}
	
	@Test
	public void test4timeToStringFun() {
		Time atime1 = new Time(System.currentTimeMillis());
		assertNotNull(STDFunctions.timeToStringFun(atime1));
		assertNull(STDFunctions.timeToStringFun(null));
	}
	
	@Test
	public void test4toDateTimeFun() {
		Date adate = new Date(System.currentTimeMillis());
		Time atime = new Time(System.currentTimeMillis());
		assertNotNull(STDFunctions.toDateTimeFun(adate, atime));
		assertNull(STDFunctions.toDateTimeFun(null, atime));
		assertNull(STDFunctions.toDateTimeFun(adate, null));
	}
	
	@Test
	public void test4toDegreesFun() {
		Double pValue = 0.5;
		Double expected = Math.toDegrees(pValue);
		assertEquals(expected, STDFunctions.toDegreesFun(pValue));
		assertNull(STDFunctions.toDegreesFun(null));
	}
	
	@Test
	public void test4toFullDateFormatFun() {
		Date adate = STDFunctions.stringToDateFun("1/1/1970");
		assertNotNull(STDFunctions.toFullDateFormatFun(adate));
		assertNull(STDFunctions.toFullDateFormatFun(null));
	}
	
	@Test
	public void test4toHexStringFun() {
		Long value = 21L;
		String expected = "15";
		assertEquals(expected, STDFunctions.toHexStringFun(value));
		assertNull(STDFunctions.toHexStringFun(null));
	}
	
	@Test
	public void test4toLongDateFormatFun() {
		Date adate = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.toLongDateFormatFun(adate));
		assertNull(STDFunctions.toLongDateFormatFun(null));
	}
	
	@Test
	public void test4toMediumDateFormatFun() {
		Date adate = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.toMediumDateFormatFun(adate));
		assertNull(STDFunctions.toMediumDateFormatFun(null));
	}
	
	@Test
	public void test4tomorrowFun() {
		Date adate = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.tomorrowFun(adate));
		assertNull(STDFunctions.tomorrowFun(null));
	}
	
	@Test
	public void test4toOctalStringFun() {
		Long value = 21L;
		String expected = "25";
		assertEquals(expected, STDFunctions.toOctalStringFun(value));
		assertNull(STDFunctions.toOctalStringFun(null));
	}
	
	@Test
	public void test4toRadians() {
		double value = 0.5;
		Double expected = 0.008726646259971648;
		assertEquals(expected, STDFunctions.toRadiansFun(value));
		assertNull(STDFunctions.toRadiansFun(null));
	}
	
	@Test
	public void test4toShortDateFormatFun() {
		Date adate = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.toShortDateFormatFun(adate));
		assertNull(STDFunctions.toShortDateFormatFun(null));
	}
	
	@Test
	public void test4truncFun() {
		double value = 1.5;
		Long expected = 1L;
		assertEquals(expected, STDFunctions.truncFun(value));
		assertNull(STDFunctions.truncFun(null));
	}
	
	@Test
	public void test4upperCaseFun() {
		String aString = "astring";
		String expected = "ASTRING";
		assertEquals(expected, STDFunctions.upperCaseFun(aString));
		assertNull(STDFunctions.upperCaseFun(null));
	}
	
	@Test
	public void test4yesterdayFun() {
		Date adate = new Date(System.currentTimeMillis());
		assertNotNull(STDFunctions.yesterdayFun(adate));
		assertNull(STDFunctions.yesterdayFun(null));
	}
}
