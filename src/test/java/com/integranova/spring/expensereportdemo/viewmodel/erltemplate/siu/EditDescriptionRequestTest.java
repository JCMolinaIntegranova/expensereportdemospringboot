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
public class EditDescriptionRequestTest {

    private EditDescriptionRequest instanceEditDescriptionRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateeditDescriptionpthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateeditDescriptionpthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
    private static String defValue4eRLTemplateeditDescriptionpDescription = "";


    // test4getERLTemplateeditDescriptionpthisERLTemplate

    // test4setERLTemplateeditDescriptionpthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateeditDescriptionpthisERLTemplateArg1;

    // test4getERLTemplateeditDescriptionpDescription

    // test4setERLTemplateeditDescriptionpDescription
    private static String test4setERLTemplateeditDescriptionpDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateeditDescriptionpthisERLTemplate();
        setUpMockData4test4setERLTemplateeditDescriptionpthisERLTemplate();
        setUpMockData4test4getERLTemplateeditDescriptionpDescription();
        setUpMockData4test4setERLTemplateeditDescriptionpDescription();
    }

    private static void setUpMockData4test4getERLTemplateeditDescriptionpthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateeditDescriptionpthisERLTemplate() {
        test4setERLTemplateeditDescriptionpthisERLTemplateArg1 = new ERLTemplateOid();
    }

    private static void setUpMockData4test4getERLTemplateeditDescriptionpDescription() {
    }

    private static void setUpMockData4test4setERLTemplateeditDescriptionpDescription() {
        test4setERLTemplateeditDescriptionpDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditDescriptionRequest = new EditDescriptionRequest();
        instanceEditDescriptionRequest.setERLTemplateeditDescriptionpthisERLTemplate(defValue4eRLTemplateeditDescriptionpthisERLTemplate);
        instanceEditDescriptionRequest.setERLTemplateeditDescriptionpthisERLTemplateInstance(defValue4eRLTemplateeditDescriptionpthisERLTemplateInstance);
        instanceEditDescriptionRequest.setERLTemplateeditDescriptionpDescription(defValue4eRLTemplateeditDescriptionpDescription);
    }

    @Test
    public void test4getERLTemplateeditDescriptionpthisERLTemplate() {
        assertEquals(defValue4eRLTemplateeditDescriptionpthisERLTemplate, instanceEditDescriptionRequest.getERLTemplateeditDescriptionpthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateeditDescriptionpthisERLTemplate() {
        instanceEditDescriptionRequest.setERLTemplateeditDescriptionpthisERLTemplate(test4setERLTemplateeditDescriptionpthisERLTemplateArg1);
        assertNotNull(instanceEditDescriptionRequest);
    }

    @Test
    public void test4getERLTemplateeditDescriptionpDescription() {
        assertEquals(defValue4eRLTemplateeditDescriptionpDescription, instanceEditDescriptionRequest.getERLTemplateeditDescriptionpDescription());
    }

    @Test
    public void test4setERLTemplateeditDescriptionpDescription() {
        instanceEditDescriptionRequest.setERLTemplateeditDescriptionpDescription(test4setERLTemplateeditDescriptionpDescriptionArg1);
        assertNotNull(instanceEditDescriptionRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditDescriptionRequest = new EditDescriptionRequest();
    	instanceEditDescriptionRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditDescriptionRequest.checkArguments();
    }
}
