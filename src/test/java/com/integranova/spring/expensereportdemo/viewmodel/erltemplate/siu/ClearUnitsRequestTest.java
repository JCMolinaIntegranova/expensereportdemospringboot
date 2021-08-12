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
public class ClearUnitsRequestTest {

    private ClearUnitsRequest instanceClearUnitsRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateclearUnitspthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateclearUnitspthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));


    // test4getERLTemplateclearUnitspthisERLTemplate

    // test4setERLTemplateclearUnitspthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateclearUnitspthisERLTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateclearUnitspthisERLTemplate();
        setUpMockData4test4setERLTemplateclearUnitspthisERLTemplate();
    }

    private static void setUpMockData4test4getERLTemplateclearUnitspthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateclearUnitspthisERLTemplate() {
        test4setERLTemplateclearUnitspthisERLTemplateArg1 = new ERLTemplateOid();
    }

    @Before
    public void setUp() {
        instanceClearUnitsRequest = new ClearUnitsRequest();
        instanceClearUnitsRequest.setERLTemplateclearUnitspthisERLTemplate(defValue4eRLTemplateclearUnitspthisERLTemplate);
        instanceClearUnitsRequest.setERLTemplateclearUnitspthisERLTemplateInstance(defValue4eRLTemplateclearUnitspthisERLTemplateInstance);
    }

    @Test
    public void test4getERLTemplateclearUnitspthisERLTemplate() {
        assertEquals(defValue4eRLTemplateclearUnitspthisERLTemplate, instanceClearUnitsRequest.getERLTemplateclearUnitspthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateclearUnitspthisERLTemplate() {
        instanceClearUnitsRequest.setERLTemplateclearUnitspthisERLTemplate(test4setERLTemplateclearUnitspthisERLTemplateArg1);
        assertNotNull(instanceClearUnitsRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceClearUnitsRequest = new ClearUnitsRequest();
    	instanceClearUnitsRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceClearUnitsRequest.checkArguments();
    }
}
