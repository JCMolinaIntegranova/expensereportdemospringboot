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
public class ClearDescriptionRequestTest {

    private ClearDescriptionRequest instanceClearDescriptionRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateclearDescriptionpthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateclearDescriptionpthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));


    // test4getERLTemplateclearDescriptionpthisERLTemplate

    // test4setERLTemplateclearDescriptionpthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateclearDescriptionpthisERLTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateclearDescriptionpthisERLTemplate();
        setUpMockData4test4setERLTemplateclearDescriptionpthisERLTemplate();
    }

    private static void setUpMockData4test4getERLTemplateclearDescriptionpthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateclearDescriptionpthisERLTemplate() {
        test4setERLTemplateclearDescriptionpthisERLTemplateArg1 = new ERLTemplateOid();
    }

    @Before
    public void setUp() {
        instanceClearDescriptionRequest = new ClearDescriptionRequest();
        instanceClearDescriptionRequest.setERLTemplateclearDescriptionpthisERLTemplate(defValue4eRLTemplateclearDescriptionpthisERLTemplate);
        instanceClearDescriptionRequest.setERLTemplateclearDescriptionpthisERLTemplateInstance(defValue4eRLTemplateclearDescriptionpthisERLTemplateInstance);
    }

    @Test
    public void test4getERLTemplateclearDescriptionpthisERLTemplate() {
        assertEquals(defValue4eRLTemplateclearDescriptionpthisERLTemplate, instanceClearDescriptionRequest.getERLTemplateclearDescriptionpthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateclearDescriptionpthisERLTemplate() {
        instanceClearDescriptionRequest.setERLTemplateclearDescriptionpthisERLTemplate(test4setERLTemplateclearDescriptionpthisERLTemplateArg1);
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
