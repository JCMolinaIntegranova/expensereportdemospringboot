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
public class EditPriceRequestTest {

    private EditPriceRequest instanceEditPriceRequest;

    // Default values
    private static ERLTemplateOid defValue4eRLTemplateeditPricepthisERLTemplate = new ERLTemplateOid();
    private static ERLTemplate defValue4eRLTemplateeditPricepthisERLTemplateInstance = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
    private static Double defValue4eRLTemplateeditPricepPrice = Double.valueOf(0);


    // test4getERLTemplateeditPricepthisERLTemplate

    // test4setERLTemplateeditPricepthisERLTemplate
    private static ERLTemplateOid test4setERLTemplateeditPricepthisERLTemplateArg1;

    // test4getERLTemplateeditPricepPrice

    // test4setERLTemplateeditPricepPrice
    private static Double test4setERLTemplateeditPricepPriceArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplateeditPricepthisERLTemplate();
        setUpMockData4test4setERLTemplateeditPricepthisERLTemplate();
        setUpMockData4test4getERLTemplateeditPricepPrice();
        setUpMockData4test4setERLTemplateeditPricepPrice();
    }

    private static void setUpMockData4test4getERLTemplateeditPricepthisERLTemplate() {
    }

    private static void setUpMockData4test4setERLTemplateeditPricepthisERLTemplate() {
        test4setERLTemplateeditPricepthisERLTemplateArg1 = new ERLTemplateOid();
    }

    private static void setUpMockData4test4getERLTemplateeditPricepPrice() {
    }

    private static void setUpMockData4test4setERLTemplateeditPricepPrice() {
        test4setERLTemplateeditPricepPriceArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditPriceRequest = new EditPriceRequest();
        instanceEditPriceRequest.setERLTemplateeditPricepthisERLTemplate(defValue4eRLTemplateeditPricepthisERLTemplate);
        instanceEditPriceRequest.setERLTemplateeditPricepthisERLTemplateInstance(defValue4eRLTemplateeditPricepthisERLTemplateInstance);
        instanceEditPriceRequest.setERLTemplateeditPricepPrice(defValue4eRLTemplateeditPricepPrice);
    }

    @Test
    public void test4getERLTemplateeditPricepthisERLTemplate() {
        assertEquals(defValue4eRLTemplateeditPricepthisERLTemplate, instanceEditPriceRequest.getERLTemplateeditPricepthisERLTemplate());
    }

    @Test
    public void test4setERLTemplateeditPricepthisERLTemplate() {
        instanceEditPriceRequest.setERLTemplateeditPricepthisERLTemplate(test4setERLTemplateeditPricepthisERLTemplateArg1);
        assertNotNull(instanceEditPriceRequest);
    }

    @Test
    public void test4getERLTemplateeditPricepPrice() {
        assertEquals(defValue4eRLTemplateeditPricepPrice, instanceEditPriceRequest.getERLTemplateeditPricepPrice());
    }

    @Test
    public void test4setERLTemplateeditPricepPrice() {
        instanceEditPriceRequest.setERLTemplateeditPricepPrice(test4setERLTemplateeditPricepPriceArg1);
        assertNotNull(instanceEditPriceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditPriceRequest = new EditPriceRequest();
    	instanceEditPriceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditPriceRequest.checkArguments();
    }
}
