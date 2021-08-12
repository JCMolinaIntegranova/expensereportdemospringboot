package com.integranova.spring.expensereportdemo.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceResponseTest {

	private ServiceResponse instanceServiceResponse;
	
	@Before
	public void setUp() {
		instanceServiceResponse = new ServiceResponse();
	}
	
	@Test
	public void test4Constructor() {
		instanceServiceResponse = new ServiceResponse("000", "OK");
		assertNotNull(instanceServiceResponse);
	}
	
	@Test
	public void test4Constructor2() {
		instanceServiceResponse = new ServiceResponse("000", "OK", 0L);
		assertNotNull(instanceServiceResponse);
	}
	
	@Test
	public void test4getResultCode() {
		assertEquals("000", instanceServiceResponse.getResultCode());
	}
	
	@Test
	public void test4setResultCode() {
		String resultCode = "999";
		instanceServiceResponse.setResultCode(resultCode);
		assertEquals(resultCode, instanceServiceResponse.getResultCode());
	}
	
	@Test
	public void test4getElapsedMillis() {
		assertEquals(Long.valueOf(0), instanceServiceResponse.getElapsedMillis());
	}
	
	@Test
	public void test4setElapsedMillis() {
		Long elapsedMillis = Long.valueOf(10);
		instanceServiceResponse.setElapsedMillis(elapsedMillis);
		assertEquals(elapsedMillis,instanceServiceResponse.getElapsedMillis());
	}
	
	@Test
	public void test4getResultDescription() {
		assertEquals("OK", instanceServiceResponse.getResultDescription());
	}
	
	@Test
	public void test4setResultDescription() {
		String resultDescription = "ERROR";
		instanceServiceResponse.setResultDescription(resultDescription);
		assertEquals(resultDescription, instanceServiceResponse.getResultDescription());
	}

	@Test
	public void test4getInstance() {
		assertEquals(null, instanceServiceResponse.getInstance());
	}
	
	@Test
	public void test4getInstanceSuppInfo() {
		assertEquals("", instanceServiceResponse.getInstanceSuppInfo());
	}

	@Test
	public void test4setInstanceSuppInfo() {
		String instanceSuppInfo = "instanceSuppInfo";
		instanceServiceResponse.setInstanceSuppInfo(instanceSuppInfo);
		assertEquals(instanceSuppInfo, instanceServiceResponse.getInstanceSuppInfo());
	}
	
	@Test
	public void test4getResultMessageId() {
		assertEquals("", instanceServiceResponse.getResultMessageId());
	}
	
	@Test
	public void test4setResultMessageId() {
		String resultMessageId = "";
		instanceServiceResponse.setResultMessageId(resultMessageId);
		assertEquals(resultMessageId, instanceServiceResponse.getResultMessageId());
	}
	
	@Test
	public void test4getResultMessageParts() {
		assertEquals(0, instanceServiceResponse.getResultMessageParts().size());
	}
	
	@Test
	public void test4setResultMessageParts() {
		List<String> resultMessageParts = new ArrayList<>();
		instanceServiceResponse.setResultMessageParts(resultMessageParts);
		assertEquals(resultMessageParts, instanceServiceResponse.getResultMessageParts());
	}
	
	@Test
	public void test4isOk() {
		assertTrue(instanceServiceResponse.isOk());
	}
	
	@Test
	public void test4setInstance() {
		instanceServiceResponse.setInstance(null);
		assertNull(instanceServiceResponse.getInstance());
	}
	
	@Test
	public void test4buildOutArgs() {
		assertEquals(0, instanceServiceResponse.buildOutArgs().size());
	}
}
