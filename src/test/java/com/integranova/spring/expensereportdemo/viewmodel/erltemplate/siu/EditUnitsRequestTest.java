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
public class EditUnitsRequestTest {

    private EditUnitsRequest instanceEditUnitsRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateeditUnitspthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateeditUnitspthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
    private static Double defValue4eRLTemplateeditUnitspUnits = Double.valueOf(0);


    // test4getERLTemplateeditUnitspthisERLTemplate

    // test4setERLTemplateeditUnitspthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateeditUnitspthisERLTemplateArg1;

    // test4getERLTemplateeditUnitspUnits

    // test4setERLTemplateeditUnitspUnits
    private static Double test4setERLTemplateeditUnitspUnitsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateeditUnitspthisERLTemplate();
        setUpMockData4test4setERLTemplateeditUnitspthisERLTemplate();
        setUpMockData4test4getERLTemplateeditUnitspUnits();
        setUpMockData4test4setERLTemplateeditUnitspUnits();
    }

    private static void setUpMockData4test4getERLTemplateeditUnitspthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateeditUnitspthisERLTemplate() {
        test4setERLTemplateeditUnitspthisERLTemplateArg1 = new ERLTemplateOid();
    }

    private static void setUpMockData4test4getERLTemplateeditUnitspUnits() {
    }

    private static void setUpMockData4test4setERLTemplateeditUnitspUnits() {
        test4setERLTemplateeditUnitspUnitsArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditUnitsRequest = new EditUnitsRequest();
        instanceEditUnitsRequest.setERLTemplateeditUnitspthisERLTemplate(defValue4eRLTemplateeditUnitspthisERLTemplate);
        instanceEditUnitsRequest.setERLTemplateeditUnitspthisERLTemplateInstance(defValue4eRLTemplateeditUnitspthisERLTemplateInstance);
        instanceEditUnitsRequest.setERLTemplateeditUnitspUnits(defValue4eRLTemplateeditUnitspUnits);
    }

    @Test
    public void test4getERLTemplateeditUnitspthisERLTemplate() {
        assertEquals(defValue4eRLTemplateeditUnitspthisERLTemplate, instanceEditUnitsRequest.getERLTemplateeditUnitspthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateeditUnitspthisERLTemplate() {
        instanceEditUnitsRequest.setERLTemplateeditUnitspthisERLTemplate(test4setERLTemplateeditUnitspthisERLTemplateArg1);
        assertNotNull(instanceEditUnitsRequest);
    }

    @Test
    public void test4getERLTemplateeditUnitspUnits() {
        assertEquals(defValue4eRLTemplateeditUnitspUnits, instanceEditUnitsRequest.getERLTemplateeditUnitspUnits());
    }

    @Test
    public void test4setERLTemplateeditUnitspUnits() {
        instanceEditUnitsRequest.setERLTemplateeditUnitspUnits(test4setERLTemplateeditUnitspUnitsArg1);
        assertNotNull(instanceEditUnitsRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditUnitsRequest = new EditUnitsRequest();
    	instanceEditUnitsRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditUnitsRequest.checkArguments();
    }
}
