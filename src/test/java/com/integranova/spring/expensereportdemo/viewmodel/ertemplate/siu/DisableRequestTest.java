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
public class DisableRequestTest {

    private DisableRequest instanceDisableRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplatedisablepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplatedisablepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getERTemplatedisablepthisERTemplate

    // test4setERTemplatedisablepthisERTemplate
    private static ERTemplateOid test4setERTemplatedisablepthisERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplatedisablepthisERTemplate();
        setUpMockData4test4setERTemplatedisablepthisERTemplate();
    }

    private static void setUpMockData4test4getERTemplatedisablepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplatedisablepthisERTemplate() {
        test4setERTemplatedisablepthisERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceDisableRequest = new DisableRequest();
        instanceDisableRequest.setERTemplatedisablepthisERTemplate(defValue4eRTemplatedisablepthisERTemplate);
        instanceDisableRequest.setERTemplatedisablepthisERTemplateInstance(defValue4eRTemplatedisablepthisERTemplateInstance);
    }

    @Test
    public void test4getERTemplatedisablepthisERTemplate() {
        assertEquals(defValue4eRTemplatedisablepthisERTemplate, instanceDisableRequest.getERTemplatedisablepthisERTemplate());
    }

    @Test
    public void test4setERTemplatedisablepthisERTemplate() {
        instanceDisableRequest.setERTemplatedisablepthisERTemplate(test4setERTemplatedisablepthisERTemplateArg1);
        assertNotNull(instanceDisableRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDisableRequest = new DisableRequest();
    	instanceDisableRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDisableRequest.checkArguments();
    }
}
