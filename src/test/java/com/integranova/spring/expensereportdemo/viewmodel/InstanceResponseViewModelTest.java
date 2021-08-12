package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InstanceResponseViewModelTest {

	private InstanceResponseViewModel instanceInstanceResponseViewModel;
	
	@Before
	public void setUp() {
		instanceInstanceResponseViewModel = new InstanceResponseViewModel();
	}

	@Test
	public void test4ConstructorWithNullEntity() {
		instanceInstanceResponseViewModel = new InstanceResponseViewModel(null, "");
		assertNotNull(instanceInstanceResponseViewModel);
	}

	@Test
	public void test4getResultCode() {
		assertEquals("000", instanceInstanceResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instanceInstanceResponseViewModel.setResultCode(resultCode);
		assertEquals(resultCode, instanceInstanceResponseViewModel.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instanceInstanceResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instanceInstanceResponseViewModel.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis, instanceInstanceResponseViewModel.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instanceInstanceResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instanceInstanceResponseViewModel.setResultDescription(resultDescription);
		assertEquals(resultDescription, instanceInstanceResponseViewModel.getResultDescription());
	}
	
	@Test
	public void test4getTotalItems() {
		assertEquals(0, instanceInstanceResponseViewModel.getTotalItems());
	}
	
	@Test
	public void test4setTotalItems() {
		int totalItems = 1;
		instanceInstanceResponseViewModel.setTotalItems(totalItems);
		assertEquals(totalItems, instanceInstanceResponseViewModel.getTotalItems());
	}
	
	@Test
	public void test4getJsonOid() {
		assertEquals("", instanceInstanceResponseViewModel.getJsonOid());
	}
	
	@Test
	public void test4getProperties() {
		assertTrue(instanceInstanceResponseViewModel.getProperties().isEmpty());
	}

	@Test
	public void test4isOk() {
		assertTrue(instanceInstanceResponseViewModel.isOk());
	}
}
