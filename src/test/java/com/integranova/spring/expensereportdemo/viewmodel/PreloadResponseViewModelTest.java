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
public class PreloadResponseViewModelTest {

	private PreloadResponseViewModel instancePreloadResponseViewModel;
	
	@Before
	public void setUp() {
		instancePreloadResponseViewModel = new PreloadResponseViewModel();
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instancePreloadResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instancePreloadResponseViewModel.setResultCode(resultCode);
		assertEquals(resultCode, instancePreloadResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instancePreloadResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instancePreloadResponseViewModel.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instancePreloadResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instancePreloadResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instancePreloadResponseViewModel.setResultDescription(resultDescription);
		assertEquals(resultDescription, instancePreloadResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4getTotalItems() {
		assertEquals(0, instancePreloadResponseViewModel.getTotalItems());
	}
	
	@Test
	public void test4setTotalItems() {
		int totalItems = 1;
		instancePreloadResponseViewModel.setTotalItems(totalItems);
		assertEquals(totalItems, instancePreloadResponseViewModel.getTotalItems());
	}

	@Test
	public void test4isOk() {
		assertTrue(instancePreloadResponseViewModel.isOk());
	}
    
	@Test
	public void test4Constructor() {
		instancePreloadResponseViewModel = new PreloadResponseViewModel(new ArrayList<>());
		assertNotNull(instancePreloadResponseViewModel);
	}
	
	@Test 
	public void test4getResults() {
		instancePreloadResponseViewModel = new PreloadResponseViewModel(new ArrayList<>());
		assertNotNull(instancePreloadResponseViewModel.getResults());		
	}
}
