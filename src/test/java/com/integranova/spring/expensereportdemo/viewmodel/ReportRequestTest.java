package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReportRequestTest {

	private ReportRequest instanceReportRequest;
	
	@Before
	public void setUp() {
		instanceReportRequest = new ReportRequest();
	}
	
	@Test
	public void test4getDsItemSort() {
		assertEquals("", instanceReportRequest.getDsItemSort());
	}
	
	@Test
	public void test4setDsItemSort() {
		String dsItemSort = "dsItemSort";
		instanceReportRequest.setDsItemSort(dsItemSort);
		assertEquals(dsItemSort, instanceReportRequest.getDsItemSort());
	}
	
	@Test
	public void test4getDsItemSortAscending() {
		assertTrue(instanceReportRequest.isDsItemSortAscending());
	}
	
	@Test
	public void test4setDsItemSortAscending() {
		instanceReportRequest.setDsItemSortAscending(false);
		assertFalse(instanceReportRequest.isDsItemSortAscending());
	}
	
	@Test
	public void test4getPageNumber() {
		assertEquals(1, instanceReportRequest.getPageNumber());
	}
	
	@Test
	public void test4setPageNumber() {
		int pageNumber = 2;
		instanceReportRequest.setPageNumber(pageNumber);
		assertEquals(pageNumber, instanceReportRequest.getPageNumber());
	}
	
	@Test
	public void test4getPageSize() {
		assertEquals(40, instanceReportRequest.getPageSize());
	}
	
	@Test
	public void test4setPageSize() {
		int pageSize = 2;
		instanceReportRequest.setPageSize(pageSize);
		assertEquals(pageSize, instanceReportRequest.getPageSize());
	}
	
	@Test
	public void test4getOrderCriteriaName() {
		assertEquals("", instanceReportRequest.getOrderCriteriaName());
	}
	
	@Test
	public void test4setOrderCriteriaName() {
		String orderCriteriaName = "orderCriteriaName";
		instanceReportRequest.setOrderCriteriaName(orderCriteriaName);
		assertEquals(orderCriteriaName, instanceReportRequest.getOrderCriteriaName());
	}
	
	@Test
	public void test4getDisplaySetItems() {
		assertEquals("", instanceReportRequest.getDisplaySetItems());
	}
	
	@Test
	public void test4setDisplaySetItems() {
		String displaySetItems="display,Set,Items";
		instanceReportRequest.setDisplaySetItems(displaySetItems);
		assertEquals(displaySetItems, instanceReportRequest.getDisplaySetItems());
	}
	
	@Test
	public void test4getDisplayName() {
		assertEquals("", instanceReportRequest.getDisplaySetName());
	}
	
	@Test
	public void test4setDisplaySetName() {
		String displaySetName="displaySetName";
		instanceReportRequest.setDisplaySetName(displaySetName);
		assertEquals(displaySetName, instanceReportRequest.getDisplaySetName());
	}
	
	@Test
	public void test4getFilters() {
		assertEquals(0, instanceReportRequest.getFilters().size());
	}
	
	@Test
	public void test4setFilters() {
		List<FilterRequest> filters = new ArrayList<>();
		instanceReportRequest.setFilters(filters);
		assertEquals(filters, instanceReportRequest.getFilters());
	}

	@Test
	public void test4addFilterRequest() {
		FilterRequest filterRequest = new FilterRequest();
		instanceReportRequest.addFilterRequest(filterRequest);
		assertEquals(filterRequest, instanceReportRequest.getFilters().get(0));
	}
	

	@Test
	public void test4getQueryRequest() {
		assertNotNull(instanceReportRequest.getQueryRequest());
	}
	
	@Test
	public void test4getClassName() {
		assertEquals("", instanceReportRequest.getClassName());
	}
	
	@Test
	public void test4setClassName() {
		String className = "className";
		instanceReportRequest.setClassName(className);
		assertEquals(className, instanceReportRequest.getClassName());
	}
	
	@Test
	public void test4getReportName() {
		assertEquals("", instanceReportRequest.getReportName());
	}
	
	@Test
	public void test4setReportName() {
		String reportName = "reportName";
		instanceReportRequest.setReportName(reportName);
		assertEquals(reportName, instanceReportRequest.getReportName());
	}
	
	@Test
	public void test4getEffectiveReportParameters() {
		assertEquals(0, instanceReportRequest.getEffectiveReportParameters().size());
	}
	
	@Test
	public void test4getReportParameters() {
		assertEquals(0, instanceReportRequest.getReportParameters().size());
	}
	
	@Test
	public void test4setReportParameters() {
		Map<String, Object> reportParameters = new HashMap<>();
		reportParameters.put("reportParameter", 1);
		instanceReportRequest.setReportParameters(reportParameters);
		assertEquals(1, instanceReportRequest.getReportParameters().size());
	}
}
