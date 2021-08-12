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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplatedeleteinstancepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplatedeleteinstancepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getERTemplatedeleteinstancepthisERTemplate

    // test4setERTemplatedeleteinstancepthisERTemplate
    private static ERTemplateOid test4setERTemplatedeleteinstancepthisERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplatedeleteinstancepthisERTemplate();
        setUpMockData4test4setERTemplatedeleteinstancepthisERTemplate();
    }

    private static void setUpMockData4test4getERTemplatedeleteinstancepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplatedeleteinstancepthisERTemplate() {
        test4setERTemplatedeleteinstancepthisERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setERTemplatedeleteinstancepthisERTemplate(defValue4eRTemplatedeleteinstancepthisERTemplate);
        instanceDeleteinstanceRequest.setERTemplatedeleteinstancepthisERTemplateInstance(defValue4eRTemplatedeleteinstancepthisERTemplateInstance);
    }

    @Test
    public void test4getERTemplatedeleteinstancepthisERTemplate() {
        assertEquals(defValue4eRTemplatedeleteinstancepthisERTemplate, instanceDeleteinstanceRequest.getERTemplatedeleteinstancepthisERTemplate());
    }

    @Test
    public void test4setERTemplatedeleteinstancepthisERTemplate() {
        instanceDeleteinstanceRequest.setERTemplatedeleteinstancepthisERTemplate(test4setERTemplatedeleteinstancepthisERTemplateArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
