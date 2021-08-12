package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PopulationRequestViewModelTest {

	private PopulationRequestViewModel instancePopulationRequestViewModel;
	
	@Before
	public void setUp() {
		instancePopulationRequestViewModel = new PopulationRequestViewModel();
	}
	
	@Test
	public void test4getDsItemSort() {
		assertEquals("", instancePopulationRequestViewModel.getDsItemSort());
	}
	
	@Test
	public void test4setDsItemSort() {
		String dsItemSort = "dsItemSort";
		instancePopulationRequestViewModel.setDsItemSort(dsItemSort);
		assertEquals(dsItemSort, instancePopulationRequestViewModel.getDsItemSort());
	}
	
	@Test
	public void test4getDsItemSortAscending() {
		assertTrue(instancePopulationRequestViewModel.getDsItemSortAscending());
	}
	
	@Test
	public void test4setDsItemSortAscending() {
		instancePopulationRequestViewModel.setDsItemSortAscending(false);
		assertFalse(instancePopulationRequestViewModel.getDsItemSortAscending());
	}
	
	@Test
	public void test4getPageNumber() {
		assertEquals(1, instancePopulationRequestViewModel.getPageNumber());
	}
	
	@Test
	public void test4setPageNumber() {
		int pageNumber = 2;
		instancePopulationRequestViewModel.setPageNumber(pageNumber);
		assertEquals(pageNumber, instancePopulationRequestViewModel.getPageNumber());
	}
	
	@Test
	public void test4getPageSize() {
		assertEquals(0, instancePopulationRequestViewModel.getPageSize());
	}
	
	@Test
	public void test4setPageSize() {
		int pageSize = 2;
		instancePopulationRequestViewModel.setPageSize(pageSize);
		assertEquals(pageSize, instancePopulationRequestViewModel.getPageSize());
	}
	
	@Test
	public void test4getRelatedInstanceJsonOid() {
		assertEquals("", instancePopulationRequestViewModel.getRelatedInstanceJsonOid());
	}
	
	@Test
	public void test4setRelatedInstanceJsonOid() {
		String relatedInstanceJsonOid = "relatedInstanceJsonOid";
		instancePopulationRequestViewModel.setRelatedInstanceJsonOid(relatedInstanceJsonOid);
		assertEquals(relatedInstanceJsonOid, instancePopulationRequestViewModel.getRelatedInstanceJsonOid());
	}
	
	@Test
	public void test4getRelatedInstancePath() {
		assertEquals("", instancePopulationRequestViewModel.getRelatedInstancePath());
	}
	
	@Test
	public void test4setRelatedInstancePath() {
		String relatedInstancePath = "relatedInstancePath";
		instancePopulationRequestViewModel.setRelatedInstancePath(relatedInstancePath);
		assertEquals(relatedInstancePath, instancePopulationRequestViewModel.getRelatedInstancePath());
	}
}
