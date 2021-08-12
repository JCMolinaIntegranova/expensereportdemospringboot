package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QueryRequestTest {

	private QueryRequest instanceQueryRequest;
	
	@Before
	public void setUp() {
		instanceQueryRequest = new QueryRequest();
	}
	
	@Test
	public void test4getDsItemSort() {
		assertEquals("", instanceQueryRequest.getDsItemSort());
	}
	
	@Test
	public void test4setDsItemSort() {
		String dsItemSort = "dsItemSort";
		instanceQueryRequest.setDsItemSort(dsItemSort);
		assertEquals(dsItemSort, instanceQueryRequest.getDsItemSort());
	}
	
	@Test
	public void test4getDsItemSortAscending() {
		assertTrue(instanceQueryRequest.isDsItemSortAscending());
	}
	
	@Test
	public void test4setDsItemSortAscending() {
		instanceQueryRequest.setDsItemSortAscending(false);
		assertFalse(instanceQueryRequest.isDsItemSortAscending());
	}
	
	@Test
	public void test4getPageNumber() {
		assertEquals(1, instanceQueryRequest.getPageNumber());
	}
	
	@Test
	public void test4setPageNumber() {
		int pageNumber = 2;
		instanceQueryRequest.setPageNumber(pageNumber);
		assertEquals(pageNumber, instanceQueryRequest.getPageNumber());
	}
	
	@Test
	public void test4getPageSize() {
		assertEquals(40, instanceQueryRequest.getPageSize());
	}
	
	@Test
	public void test4setPageSize() {
		int pageSize = 2;
		instanceQueryRequest.setPageSize(pageSize);
		assertEquals(pageSize, instanceQueryRequest.getPageSize());
	}
	
	@Test
	public void test4getOrderCriteriaName() {
		assertEquals("", instanceQueryRequest.getOrderCriteriaName());
	}
	
	@Test
	public void test4setOrderCriteriaName() {
		String orderCriteriaName = "orderCriteriaName";
		instanceQueryRequest.setOrderCriteriaName(orderCriteriaName);
		assertEquals(orderCriteriaName, instanceQueryRequest.getOrderCriteriaName());
	}
	
	@Test
	public void test4getDisplaySetItems() {
		assertEquals("", instanceQueryRequest.getDisplaySetItems());
	}
	
	@Test
	public void test4setDisplaySetItems() {
		String displaySetItems="display,Set,Items";
		instanceQueryRequest.setDisplaySetItems(displaySetItems);
		assertEquals(displaySetItems, instanceQueryRequest.getDisplaySetItems());
	}
	
	@Test
	public void test4getDisplayName() {
		assertEquals("", instanceQueryRequest.getDisplaySetName());
	}
	
	@Test
	public void test4setDisplaySetName() {
		String displaySetName="displaySetName";
		instanceQueryRequest.setDisplaySetName(displaySetName);
		assertEquals(displaySetName, instanceQueryRequest.getDisplaySetName());
	}
	
	@Test
	public void test4getFilters() {
		assertEquals(0, instanceQueryRequest.getFilters().size());
	}
	
	@Test
	public void test4setFilters() {
		List<FilterRequest> filters = new ArrayList<>();
		instanceQueryRequest.setFilters(filters);
		assertEquals(filters, instanceQueryRequest.getFilters());
	}

	@Test
	public void test4addFilterRequest() {
		FilterRequest filterRequest = new FilterRequest();
		instanceQueryRequest.addFilterRequest(filterRequest);
		assertEquals(filterRequest, instanceQueryRequest.getFilters().get(0));
	}
}
