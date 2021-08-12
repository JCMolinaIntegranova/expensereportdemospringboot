package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;

public class ClassTest {
	
	protected static final String RESULTCODE = "RESULTCODE";
	protected static final String RESULTS = "RESULTS";
	protected static final String RESULTS_SIZE = "RESULTS_SIZE";
    protected static final String TOTALITEMS = "TOTALITEMS";
    
    protected static Object getResult(String resultType, QueryResponse qr) {
    	if (resultType.equals(RESULTCODE))
    		return qr.getResultCode();
    	if (resultType.equals(RESULTS_SIZE))
    		return qr.getTotalItems();
    	if (resultType.equals(TOTALITEMS))
    		return qr.getTotalItems();
    	return qr;
    }
    
    protected static Object getResult(String resultType, PopulationResponseViewModel prvm) {
    	if (resultType.equals(RESULTCODE))
    		return prvm.getResultCode();
    	if (resultType.equals(RESULTS))
    		return prvm.getResults();
    	if (resultType.equals(RESULTS_SIZE))
    		return prvm.getResults().size();
    	if (resultType.equals(TOTALITEMS))
    		return prvm.getTotalItems();
    	return prvm;
    }
    
    @Test
    public void genericTest() {
        assertNotNull(this);
    }
}
