package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.PreconditionException;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTest {

	private Response instanceResponse;
	
	@Before
	public void setUp() {
		instanceResponse = new Response();
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instanceResponse.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instanceResponse.setResultCode(resultCode);
		assertEquals(resultCode, instanceResponse.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instanceResponse.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instanceResponse.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instanceResponse.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instanceResponse.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instanceResponse.setResultDescription(resultDescription);
		assertEquals(resultDescription, instanceResponse.getResultDescription());
	}

	@Test
	public void test4isOk() {
		assertTrue(instanceResponse.isOk());
	}
	
	@Test
	public void test4setGenericException() {
		instanceResponse.setException(new Exception());
		assertNotEquals("000", instanceResponse.getResultCode());
	}
	
	@Test
	public void test4setModelException() {
		instanceResponse.setException(new PreconditionException("preconditionException"));
		assertNotEquals("000", instanceResponse.getResultCode());
	}
}
