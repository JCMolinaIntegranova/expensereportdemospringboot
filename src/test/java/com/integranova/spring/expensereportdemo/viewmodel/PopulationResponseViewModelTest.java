package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PopulationResponseViewModelTest {

	private PopulationResponseViewModel instancePopulationResponseViewModel;
	

	@Before
	public void setUp() {
		instancePopulationResponseViewModel = new PopulationResponseViewModel();
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instancePopulationResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instancePopulationResponseViewModel.setResultCode(resultCode);
		assertEquals(resultCode, instancePopulationResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instancePopulationResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instancePopulationResponseViewModel.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instancePopulationResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instancePopulationResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instancePopulationResponseViewModel.setResultDescription(resultDescription);
		assertEquals(resultDescription, instancePopulationResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4getTotalItems() {
		assertEquals(0, instancePopulationResponseViewModel.getTotalItems());
	}
	
	@Test
	public void test4setTotalItems() {
		int totalItems = 1;
		instancePopulationResponseViewModel.setTotalItems(totalItems);
		assertEquals(totalItems, instancePopulationResponseViewModel.getTotalItems());
	}

	@Test
	public void test4isOk() {
		assertTrue(instancePopulationResponseViewModel.isOk());
	}
	
	@Test
	public void test4Constructor() {
		instancePopulationResponseViewModel = new PopulationResponseViewModel(new ArrayList<>());
		assertNotNull(instancePopulationResponseViewModel);
	}
	
	@Test 
	public void test4getResults() {
		instancePopulationResponseViewModel = new PopulationResponseViewModel(new ArrayList<>());
		assertNotNull(instancePopulationResponseViewModel.getResults());		
	}
}
