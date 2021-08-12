package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static String defValue4eRTemplatecreateinstancepatrname = "";
    private static String defValue4eRTemplatecreateinstancepatrdescription = "";


    // test4getERTemplatecreateinstancepatrname

    // test4setERTemplatecreateinstancepatrname
    private static String test4setERTemplatecreateinstancepatrnameArg1;

    // test4getERTemplatecreateinstancepatrdescription

    // test4setERTemplatecreateinstancepatrdescription
    private static String test4setERTemplatecreateinstancepatrdescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplatecreateinstancepatrname();
        setUpMockData4test4setERTemplatecreateinstancepatrname();
        setUpMockData4test4getERTemplatecreateinstancepatrdescription();
        setUpMockData4test4setERTemplatecreateinstancepatrdescription();
    }

    private static void setUpMockData4test4getERTemplatecreateinstancepatrname() {
    }

    private static void setUpMockData4test4setERTemplatecreateinstancepatrname() {
        test4setERTemplatecreateinstancepatrnameArg1 = "";
    }

    private static void setUpMockData4test4getERTemplatecreateinstancepatrdescription() {
    }

    private static void setUpMockData4test4setERTemplatecreateinstancepatrdescription() {
        test4setERTemplatecreateinstancepatrdescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setERTemplatecreateinstancepatrname(defValue4eRTemplatecreateinstancepatrname);
        instanceCreateinstanceRequest.setERTemplatecreateinstancepatrdescription(defValue4eRTemplatecreateinstancepatrdescription);
    }

    @Test
    public void test4getERTemplatecreateinstancepatrname() {
        assertEquals(defValue4eRTemplatecreateinstancepatrname, instanceCreateinstanceRequest.getERTemplatecreateinstancepatrname());
    }

    @Test
    public void test4setERTemplatecreateinstancepatrname() {
        instanceCreateinstanceRequest.setERTemplatecreateinstancepatrname(test4setERTemplatecreateinstancepatrnameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getERTemplatecreateinstancepatrdescription() {
        assertEquals(defValue4eRTemplatecreateinstancepatrdescription, instanceCreateinstanceRequest.getERTemplatecreateinstancepatrdescription());
    }

    @Test
    public void test4setERTemplatecreateinstancepatrdescription() {
        instanceCreateinstanceRequest.setERTemplatecreateinstancepatrdescription(test4setERTemplatecreateinstancepatrdescriptionArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
    	instanceCreateinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCreateinstanceRequest.checkArguments();
    }
}
