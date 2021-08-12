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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplatedeleteinstancepthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplatedeleteinstancepthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));


    // test4getERLTemplatedeleteinstancepthisERLTemplate

    // test4setERLTemplatedeleteinstancepthisERLTemplate
    private static ERLTemplateOid test4setERLTemplatedeleteinstancepthisERLTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplatedeleteinstancepthisERLTemplate();
        setUpMockData4test4setERLTemplatedeleteinstancepthisERLTemplate();
    }

    private static void setUpMockData4test4getERLTemplatedeleteinstancepthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplatedeleteinstancepthisERLTemplate() {
        test4setERLTemplatedeleteinstancepthisERLTemplateArg1 = new ERLTemplateOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setERLTemplatedeleteinstancepthisERLTemplate(defValue4eRLTemplatedeleteinstancepthisERLTemplate);
        instanceDeleteinstanceRequest.setERLTemplatedeleteinstancepthisERLTemplateInstance(defValue4eRLTemplatedeleteinstancepthisERLTemplateInstance);
    }

    @Test
    public void test4getERLTemplatedeleteinstancepthisERLTemplate() {
        assertEquals(defValue4eRLTemplatedeleteinstancepthisERLTemplate, instanceDeleteinstanceRequest.getERLTemplatedeleteinstancepthisERLTemplate());
    }

    @Test
    public void test4setERLTemplatedeleteinstancepthisERLTemplate() {
        instanceDeleteinstanceRequest.setERLTemplatedeleteinstancepthisERLTemplate(test4setERLTemplatedeleteinstancepthisERLTemplateArg1);
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
