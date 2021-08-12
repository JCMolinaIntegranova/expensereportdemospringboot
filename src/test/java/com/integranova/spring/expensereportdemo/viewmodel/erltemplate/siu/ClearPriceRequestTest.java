package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClearPriceRequestTest {

    private ClearPriceRequest instanceClearPriceRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateclearPricepthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateclearPricepthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));


    // test4getERLTemplateclearPricepthisERLTemplate

    // test4setERLTemplateclearPricepthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateclearPricepthisERLTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateclearPricepthisERLTemplate();
        setUpMockData4test4setERLTemplateclearPricepthisERLTemplate();
    }

    private static void setUpMockData4test4getERLTemplateclearPricepthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateclearPricepthisERLTemplate() {
        test4setERLTemplateclearPricepthisERLTemplateArg1 = new ERLTemplateOid();
    }

    @Before
    public void setUp() {
        instanceClearPriceRequest = new ClearPriceRequest();
        instanceClearPriceRequest.setERLTemplateclearPricepthisERLTemplate(defValue4eRLTemplateclearPricepthisERLTemplate);
        instanceClearPriceRequest.setERLTemplateclearPricepthisERLTemplateInstance(defValue4eRLTemplateclearPricepthisERLTemplateInstance);
    }

    @Test
    public void test4getERLTemplateclearPricepthisERLTemplate() {
        assertEquals(defValue4eRLTemplateclearPricepthisERLTemplate, instanceClearPriceRequest.getERLTemplateclearPricepthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateclearPricepthisERLTemplate() {
        instanceClearPriceRequest.setERLTemplateclearPricepthisERLTemplate(test4setERLTemplateclearPricepthisERLTemplateArg1);
        assertNotNull(instanceClearPriceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceClearPriceRequest = new ClearPriceRequest();
    	instanceClearPriceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceClearPriceRequest.checkArguments();
    }
}
