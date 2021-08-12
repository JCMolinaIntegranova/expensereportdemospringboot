package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QueryResponseTest {
	
	private QueryResponse instanceQueryResponse; 
	
	@Before
	public void setUp() {
		instanceQueryResponse = new PopulationResponseViewModel();
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instanceQueryResponse.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instanceQueryResponse.setResultCode(resultCode);
		assertEquals(resultCode, instanceQueryResponse.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instanceQueryResponse.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instanceQueryResponse.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instanceQueryResponse.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instanceQueryResponse.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instanceQueryResponse.setResultDescription(resultDescription);
		assertEquals(resultDescription, instanceQueryResponse.getResultDescription());
	}
	
	@Test
	public void test4getTotalItems() {
		assertEquals(0, instanceQueryResponse.getTotalItems());
	}
	
	@Test
	public void test4setTotalItems() {
		int totalItems = 1;
		instanceQueryResponse.setTotalItems(totalItems);
		assertEquals(totalItems, instanceQueryResponse.getTotalItems());
	}

	@Test
	public void test4isOk() {
		assertTrue(instanceQueryResponse.isOk());
	}
}
