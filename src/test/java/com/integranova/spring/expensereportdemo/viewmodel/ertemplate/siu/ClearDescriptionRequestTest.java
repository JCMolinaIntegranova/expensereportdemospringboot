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
public class ClearDescriptionRequestTest {

    private ClearDescriptionRequest instanceClearDescriptionRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateclearDescriptionpthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateclearDescriptionpthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getERTemplateclearDescriptionpthisERTemplate

    // test4setERTemplateclearDescriptionpthisERTemplate
    private static ERTemplateOid test4setERTemplateclearDescriptionpthisERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateclearDescriptionpthisERTemplate();
        setUpMockData4test4setERTemplateclearDescriptionpthisERTemplate();
    }

    private static void setUpMockData4test4getERTemplateclearDescriptionpthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateclearDescriptionpthisERTemplate() {
        test4setERTemplateclearDescriptionpthisERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceClearDescriptionRequest = new ClearDescriptionRequest();
        instanceClearDescriptionRequest.setERTemplateclearDescriptionpthisERTemplate(defValue4eRTemplateclearDescriptionpthisERTemplate);
        instanceClearDescriptionRequest.setERTemplateclearDescriptionpthisERTemplateInstance(defValue4eRTemplateclearDescriptionpthisERTemplateInstance);
    }

    @Test
    public void test4getERTemplateclearDescriptionpthisERTemplate() {
        assertEquals(defValue4eRTemplateclearDescriptionpthisERTemplate, instanceClearDescriptionRequest.getERTemplateclearDescriptionpthisERTemplate());
    }

    @Test
    public void test4setERTemplateclearDescriptionpthisERTemplate() {
        instanceClearDescriptionRequest.setERTemplateclearDescriptionpthisERTemplate(test4setERTemplateclearDescriptionpthisERTemplateArg1);
        assertNotNull(instanceClearDescriptionRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceClearDescriptionRequest = new ClearDescriptionRequest();
    	instanceClearDescriptionRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceClearDescriptionRequest.checkArguments();
    }
}
