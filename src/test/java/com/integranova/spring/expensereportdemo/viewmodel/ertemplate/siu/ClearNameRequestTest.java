package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClearNameRequestTest {

    private ClearNameRequest instanceClearNameRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateclearNamepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateclearNamepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getERTemplateclearNamepthisERTemplate

    // test4setERTemplateclearNamepthisERTemplate
    private static ERTemplateOid test4setERTemplateclearNamepthisERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateclearNamepthisERTemplate();
        setUpMockData4test4setERTemplateclearNamepthisERTemplate();
    }

    private static void setUpMockData4test4getERTemplateclearNamepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateclearNamepthisERTemplate() {
        test4setERTemplateclearNamepthisERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceClearNameRequest = new ClearNameRequest();
        instanceClearNameRequest.setERTemplateclearNamepthisERTemplate(defValue4eRTemplateclearNamepthisERTemplate);
        instanceClearNameRequest.setERTemplateclearNamepthisERTemplateInstance(defValue4eRTemplateclearNamepthisERTemplateInstance);
    }

    @Test
    public void test4getERTemplateclearNamepthisERTemplate() {
        assertEquals(defValue4eRTemplateclearNamepthisERTemplate, instanceClearNameRequest.getERTemplateclearNamepthisERTemplate());
    }

    @Test
    public void test4setERTemplateclearNamepthisERTemplate() {
        instanceClearNameRequest.setERTemplateclearNamepthisERTemplate(test4setERTemplateclearNamepthisERTemplateArg1);
        assertNotNull(instanceClearNameRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceClearNameRequest = new ClearNameRequest();
    	instanceClearNameRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceClearNameRequest.checkArguments();
    }
}
