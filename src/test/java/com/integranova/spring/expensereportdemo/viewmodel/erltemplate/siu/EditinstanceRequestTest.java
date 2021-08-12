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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateeditinstancepthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateeditinstancepthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
    private static Double defValue4eRLTemplateeditinstancepunits = Double.valueOf(0);
    private static Double defValue4eRLTemplateeditinstancepprice = Double.valueOf(0);
    private static String defValue4eRLTemplateeditinstancepdescription = "";


    // test4getERLTemplateeditinstancepthisERLTemplate

    // test4setERLTemplateeditinstancepthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateeditinstancepthisERLTemplateArg1;

    // test4getERLTemplateeditinstancepunits

    // test4setERLTemplateeditinstancepunits
    private static Double test4setERLTemplateeditinstancepunitsArg1;

    // test4getERLTemplateeditinstancepprice

    // test4setERLTemplateeditinstancepprice
    private static Double test4setERLTemplateeditinstanceppriceArg1;

    // test4getERLTemplateeditinstancepdescription

    // test4setERLTemplateeditinstancepdescription
    private static String test4setERLTemplateeditinstancepdescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateeditinstancepthisERLTemplate();
        setUpMockData4test4setERLTemplateeditinstancepthisERLTemplate();
        setUpMockData4test4getERLTemplateeditinstancepunits();
        setUpMockData4test4setERLTemplateeditinstancepunits();
        setUpMockData4test4getERLTemplateeditinstancepprice();
        setUpMockData4test4setERLTemplateeditinstancepprice();
        setUpMockData4test4getERLTemplateeditinstancepdescription();
        setUpMockData4test4setERLTemplateeditinstancepdescription();
    }

    private static void setUpMockData4test4getERLTemplateeditinstancepthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateeditinstancepthisERLTemplate() {
        test4setERLTemplateeditinstancepthisERLTemplateArg1 = new ERLTemplateOid();
    }

    private static void setUpMockData4test4getERLTemplateeditinstancepunits() {
    }

    private static void setUpMockData4test4setERLTemplateeditinstancepunits() {
        test4setERLTemplateeditinstancepunitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getERLTemplateeditinstancepprice() {
    }

    private static void setUpMockData4test4setERLTemplateeditinstancepprice() {
        test4setERLTemplateeditinstanceppriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getERLTemplateeditinstancepdescription() {
    }

    private static void setUpMockData4test4setERLTemplateeditinstancepdescription() {
        test4setERLTemplateeditinstancepdescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setERLTemplateeditinstancepthisERLTemplate(defValue4eRLTemplateeditinstancepthisERLTemplate);
        instanceEditinstanceRequest.setERLTemplateeditinstancepthisERLTemplateInstance(defValue4eRLTemplateeditinstancepthisERLTemplateInstance);
        instanceEditinstanceRequest.setERLTemplateeditinstancepunits(defValue4eRLTemplateeditinstancepunits);
        instanceEditinstanceRequest.setERLTemplateeditinstancepprice(defValue4eRLTemplateeditinstancepprice);
        instanceEditinstanceRequest.setERLTemplateeditinstancepdescription(defValue4eRLTemplateeditinstancepdescription);
    }

    @Test
    public void test4getERLTemplateeditinstancepthisERLTemplate() {
        assertEquals(defValue4eRLTemplateeditinstancepthisERLTemplate, instanceEditinstanceRequest.getERLTemplateeditinstancepthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateeditinstancepthisERLTemplate() {
        instanceEditinstanceRequest.setERLTemplateeditinstancepthisERLTemplate(test4setERLTemplateeditinstancepthisERLTemplateArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getERLTemplateeditinstancepunits() {
        assertEquals(defValue4eRLTemplateeditinstancepunits, instanceEditinstanceRequest.getERLTemplateeditinstancepunits());
    }

    @Test
    public void test4setERLTemplateeditinstancepunits() {
        instanceEditinstanceRequest.setERLTemplateeditinstancepunits(test4setERLTemplateeditinstancepunitsArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getERLTemplateeditinstancepprice() {
        assertEquals(defValue4eRLTemplateeditinstancepprice, instanceEditinstanceRequest.getERLTemplateeditinstancepprice());
    }

    @Test
    public void test4setERLTemplateeditinstancepprice() {
        instanceEditinstanceRequest.setERLTemplateeditinstancepprice(test4setERLTemplateeditinstanceppriceArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getERLTemplateeditinstancepdescription() {
        assertEquals(defValue4eRLTemplateeditinstancepdescription, instanceEditinstanceRequest.getERLTemplateeditinstancepdescription());
    }

    @Test
    public void test4setERLTemplateeditinstancepdescription() {
        instanceEditinstanceRequest.setERLTemplateeditinstancepdescription(test4setERLTemplateeditinstancepdescriptionArg1);
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
