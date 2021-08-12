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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplateeditinstancepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateeditinstancepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static String defValue4eRTemplateeditinstancepname = "";
    private static String defValue4eRTemplateeditinstancepdescription = "";


    // test4getERTemplateeditinstancepthisERTemplate

    // test4setERTemplateeditinstancepthisERTemplate
    private static ERTemplateOid test4setERTemplateeditinstancepthisERTemplateArg1;

    // test4getERTemplateeditinstancepname

    // test4setERTemplateeditinstancepname
    private static String test4setERTemplateeditinstancepnameArg1;

    // test4getERTemplateeditinstancepdescription

    // test4setERTemplateeditinstancepdescription
    private static String test4setERTemplateeditinstancepdescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateeditinstancepthisERTemplate();
        setUpMockData4test4setERTemplateeditinstancepthisERTemplate();
        setUpMockData4test4getERTemplateeditinstancepname();
        setUpMockData4test4setERTemplateeditinstancepname();
        setUpMockData4test4getERTemplateeditinstancepdescription();
        setUpMockData4test4setERTemplateeditinstancepdescription();
    }

    private static void setUpMockData4test4getERTemplateeditinstancepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateeditinstancepthisERTemplate() {
        test4setERTemplateeditinstancepthisERTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERTemplateeditinstancepname() {
    }

    private static void setUpMockData4test4setERTemplateeditinstancepname() {
        test4setERTemplateeditinstancepnameArg1 = "";
    }

    private static void setUpMockData4test4getERTemplateeditinstancepdescription() {
    }

    private static void setUpMockData4test4setERTemplateeditinstancepdescription() {
        test4setERTemplateeditinstancepdescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setERTemplateeditinstancepthisERTemplate(defValue4eRTemplateeditinstancepthisERTemplate);
        instanceEditinstanceRequest.setERTemplateeditinstancepthisERTemplateInstance(defValue4eRTemplateeditinstancepthisERTemplateInstance);
        instanceEditinstanceRequest.setERTemplateeditinstancepname(defValue4eRTemplateeditinstancepname);
        instanceEditinstanceRequest.setERTemplateeditinstancepdescription(defValue4eRTemplateeditinstancepdescription);
    }

    @Test
    public void test4getERTemplateeditinstancepthisERTemplate() {
        assertEquals(defValue4eRTemplateeditinstancepthisERTemplate, instanceEditinstanceRequest.getERTemplateeditinstancepthisERTemplate());
    }

    @Test
    public void test4setERTemplateeditinstancepthisERTemplate() {
        instanceEditinstanceRequest.setERTemplateeditinstancepthisERTemplate(test4setERTemplateeditinstancepthisERTemplateArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getERTemplateeditinstancepname() {
        assertEquals(defValue4eRTemplateeditinstancepname, instanceEditinstanceRequest.getERTemplateeditinstancepname());
    }

    @Test
    public void test4setERTemplateeditinstancepname() {
        instanceEditinstanceRequest.setERTemplateeditinstancepname(test4setERTemplateeditinstancepnameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getERTemplateeditinstancepdescription() {
        assertEquals(defValue4eRTemplateeditinstancepdescription, instanceEditinstanceRequest.getERTemplateeditinstancepdescription());
    }

    @Test
    public void test4setERTemplateeditinstancepdescription() {
        instanceEditinstanceRequest.setERTemplateeditinstancepdescription(test4setERTemplateeditinstancepdescriptionArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
