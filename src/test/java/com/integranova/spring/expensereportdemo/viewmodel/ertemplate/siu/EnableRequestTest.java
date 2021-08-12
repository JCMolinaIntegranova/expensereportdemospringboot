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
public class EnableRequestTest {

    private EnableRequest instanceEnableRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateenablepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateenablepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getERTemplateenablepthisERTemplate

    // test4setERTemplateenablepthisERTemplate
    private static ERTemplateOid test4setERTemplateenablepthisERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateenablepthisERTemplate();
        setUpMockData4test4setERTemplateenablepthisERTemplate();
    }

    private static void setUpMockData4test4getERTemplateenablepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateenablepthisERTemplate() {
        test4setERTemplateenablepthisERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceEnableRequest = new EnableRequest();
        instanceEnableRequest.setERTemplateenablepthisERTemplate(defValue4eRTemplateenablepthisERTemplate);
        instanceEnableRequest.setERTemplateenablepthisERTemplateInstance(defValue4eRTemplateenablepthisERTemplateInstance);
    }

    @Test
    public void test4getERTemplateenablepthisERTemplate() {
        assertEquals(defValue4eRTemplateenablepthisERTemplate, instanceEnableRequest.getERTemplateenablepthisERTemplate());
    }

    @Test
    public void test4setERTemplateenablepthisERTemplate() {
        instanceEnableRequest.setERTemplateenablepthisERTemplate(test4setERTemplateenablepthisERTemplateArg1);
        assertNotNull(instanceEnableRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEnableRequest = new EnableRequest();
    	instanceEnableRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEnableRequest.checkArguments();
    }
}
