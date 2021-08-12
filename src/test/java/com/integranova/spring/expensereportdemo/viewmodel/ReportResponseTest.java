package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReportResponseTest {

	private ReportResponseViewModel instanceReportResponse;
	
	@Before
	public void setUp() {
		instanceReportResponse = new ReportResponseViewModel();
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instanceReportResponse.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instanceReportResponse.setResultCode(resultCode);
		assertEquals(resultCode, instanceReportResponse.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instanceReportResponse.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instanceReportResponse.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instanceReportResponse.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instanceReportResponse.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instanceReportResponse.setResultDescription(resultDescription);
		assertEquals(resultDescription, instanceReportResponse.getResultDescription());
	}
	
	@Test
	public void test4getReportName() {
		assertNull(instanceReportResponse.getReportName());
	}
	
	@Test
	public void test4setReportName() {
		String reportName = "reportName";
		instanceReportResponse.setReportName(reportName);
		assertEquals(reportName, instanceReportResponse.getReportName());
	}
	
	@Test
	public void test4getReportData() {
		assertNull(instanceReportResponse.getReportData());
	}
	
	@Test
	public void test4setReportData() {
		byte[] reportData = "reportData".getBytes();
		instanceReportResponse.setReportData(reportData);
		assertEquals(reportData, instanceReportResponse.getReportData());
	}

	@Test
	public void test4isOk() {
		assertTrue(instanceReportResponse.isOk());
	}
}
