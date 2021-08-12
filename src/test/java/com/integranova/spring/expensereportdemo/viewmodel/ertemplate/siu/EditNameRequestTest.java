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
public class EditNameRequestTest {

    private EditNameRequest instanceEditNameRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateeditNamepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateeditNamepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static String defValue4eRTemplateeditNamepName = "";


    // test4getERTemplateeditNamepthisERTemplate

    // test4setERTemplateeditNamepthisERTemplate
    private static ERTemplateOid test4setERTemplateeditNamepthisERTemplateArg1;

    // test4getERTemplateeditNamepName

    // test4setERTemplateeditNamepName
    private static String test4setERTemplateeditNamepNameArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateeditNamepthisERTemplate();
        setUpMockData4test4setERTemplateeditNamepthisERTemplate();
        setUpMockData4test4getERTemplateeditNamepName();
        setUpMockData4test4setERTemplateeditNamepName();
    }

    private static void setUpMockData4test4getERTemplateeditNamepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateeditNamepthisERTemplate() {
        test4setERTemplateeditNamepthisERTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERTemplateeditNamepName() {
    }

    private static void setUpMockData4test4setERTemplateeditNamepName() {
        test4setERTemplateeditNamepNameArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditNameRequest = new EditNameRequest();
        instanceEditNameRequest.setERTemplateeditNamepthisERTemplate(defValue4eRTemplateeditNamepthisERTemplate);
        instanceEditNameRequest.setERTemplateeditNamepthisERTemplateInstance(defValue4eRTemplateeditNamepthisERTemplateInstance);
        instanceEditNameRequest.setERTemplateeditNamepName(defValue4eRTemplateeditNamepName);
    }

    @Test
    public void test4getERTemplateeditNamepthisERTemplate() {
        assertEquals(defValue4eRTemplateeditNamepthisERTemplate, instanceEditNameRequest.getERTemplateeditNamepthisERTemplate());
    }

    @Test
    public void test4setERTemplateeditNamepthisERTemplate() {
        instanceEditNameRequest.setERTemplateeditNamepthisERTemplate(test4setERTemplateeditNamepthisERTemplateArg1);
        assertNotNull(instanceEditNameRequest);
    }

    @Test
    public void test4getERTemplateeditNamepName() {
        assertEquals(defValue4eRTemplateeditNamepName, instanceEditNameRequest.getERTemplateeditNamepName());
    }

    @Test
    public void test4setERTemplateeditNamepName() {
        instanceEditNameRequest.setERTemplateeditNamepName(test4setERTemplateeditNamepNameArg1);
        assertNotNull(instanceEditNameRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditNameRequest = new EditNameRequest();
    	instanceEditNameRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditNameRequest.checkArguments();
    }
}
