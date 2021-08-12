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
public class EditDescriptionRequestTest {

    private EditDescriptionRequest instanceEditDescriptionRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateeditDescriptionpthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateeditDescriptionpthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static String defValue4eRTemplateeditDescriptionpDescription = "";


    // test4getERTemplateeditDescriptionpthisERTemplate

    // test4setERTemplateeditDescriptionpthisERTemplate
    private static ERTemplateOid test4setERTemplateeditDescriptionpthisERTemplateArg1;

    // test4getERTemplateeditDescriptionpDescription

    // test4setERTemplateeditDescriptionpDescription
    private static String test4setERTemplateeditDescriptionpDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateeditDescriptionpthisERTemplate();
        setUpMockData4test4setERTemplateeditDescriptionpthisERTemplate();
        setUpMockData4test4getERTemplateeditDescriptionpDescription();
        setUpMockData4test4setERTemplateeditDescriptionpDescription();
    }

    private static void setUpMockData4test4getERTemplateeditDescriptionpthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateeditDescriptionpthisERTemplate() {
        test4setERTemplateeditDescriptionpthisERTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERTemplateeditDescriptionpDescription() {
    }

    private static void setUpMockData4test4setERTemplateeditDescriptionpDescription() {
        test4setERTemplateeditDescriptionpDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditDescriptionRequest = new EditDescriptionRequest();
        instanceEditDescriptionRequest.setERTemplateeditDescriptionpthisERTemplate(defValue4eRTemplateeditDescriptionpthisERTemplate);
        instanceEditDescriptionRequest.setERTemplateeditDescriptionpthisERTemplateInstance(defValue4eRTemplateeditDescriptionpthisERTemplateInstance);
        instanceEditDescriptionRequest.setERTemplateeditDescriptionpDescription(defValue4eRTemplateeditDescriptionpDescription);
    }

    @Test
    public void test4getERTemplateeditDescriptionpthisERTemplate() {
        assertEquals(defValue4eRTemplateeditDescriptionpthisERTemplate, instanceEditDescriptionRequest.getERTemplateeditDescriptionpthisERTemplate());
    }

    @Test
    public void test4setERTemplateeditDescriptionpthisERTemplate() {
        instanceEditDescriptionRequest.setERTemplateeditDescriptionpthisERTemplate(test4setERTemplateeditDescriptionpthisERTemplateArg1);
        assertNotNull(instanceEditDescriptionRequest);
    }

    @Test
    public void test4getERTemplateeditDescriptionpDescription() {
        assertEquals(defValue4eRTemplateeditDescriptionpDescription, instanceEditDescriptionRequest.getERTemplateeditDescriptionpDescription());
    }

    @Test
    public void test4setERTemplateeditDescriptionpDescription() {
        instanceEditDescriptionRequest.setERTemplateeditDescriptionpDescription(test4setERTemplateeditDescriptionpDescriptionArg1);
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
