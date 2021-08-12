package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static ERTemplateOid defValue4eRLTemplatecreateinstancepagrTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRLTemplatecreateinstancepagrTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static ExpenseTypeOid defValue4eRLTemplatecreateinstancepagrExpenseType = new ExpenseTypeOid();
    private static ExpenseType defValue4eRLTemplatecreateinstancepagrExpenseTypeInstance = new ExpenseType(new ExpenseTypeOid(""));
    private static Double defValue4eRLTemplatecreateinstancepatrunits = Double.valueOf(0);
    private static Double defValue4eRLTemplatecreateinstancepatrprice = Double.valueOf(0);
    private static String defValue4eRLTemplatecreateinstancepatrdescription = "";


    // test4getERLTemplatecreateinstancepagrTemplate

    // test4setERLTemplatecreateinstancepagrTemplate
    private static ERTemplateOid test4setERLTemplatecreateinstancepagrTemplateArg1;

    // test4getERLTemplatecreateinstancepagrExpenseType

    // test4setERLTemplatecreateinstancepagrExpenseType
    private static ExpenseTypeOid test4setERLTemplatecreateinstancepagrExpenseTypeArg1;

    // test4getERLTemplatecreateinstancepatrunits

    // test4setERLTemplatecreateinstancepatrunits
    private static Double test4setERLTemplatecreateinstancepatrunitsArg1;

    // test4getERLTemplatecreateinstancepatrprice

    // test4setERLTemplatecreateinstancepatrprice
    private static Double test4setERLTemplatecreateinstancepatrpriceArg1;

    // test4getERLTemplatecreateinstancepatrdescription

    // test4setERLTemplatecreateinstancepatrdescription
    private static String test4setERLTemplatecreateinstancepatrdescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERLTemplatecreateinstancepagrTemplate();
        setUpMockData4test4setERLTemplatecreateinstancepagrTemplate();
        setUpMockData4test4getERLTemplatecreateinstancepagrExpenseType();
        setUpMockData4test4setERLTemplatecreateinstancepagrExpenseType();
        setUpMockData4test4getERLTemplatecreateinstancepatrunits();
        setUpMockData4test4setERLTemplatecreateinstancepatrunits();
        setUpMockData4test4getERLTemplatecreateinstancepatrprice();
        setUpMockData4test4setERLTemplatecreateinstancepatrprice();
        setUpMockData4test4getERLTemplatecreateinstancepatrdescription();
        setUpMockData4test4setERLTemplatecreateinstancepatrdescription();
    }

    private static void setUpMockData4test4getERLTemplatecreateinstancepagrTemplate() {
    }

    private static void setUpMockData4test4setERLTemplatecreateinstancepagrTemplate() {
        test4setERLTemplatecreateinstancepagrTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERLTemplatecreateinstancepagrExpenseType() {
    }

    private static void setUpMockData4test4setERLTemplatecreateinstancepagrExpenseType() {
        test4setERLTemplatecreateinstancepagrExpenseTypeArg1 = new ExpenseTypeOid();
    }

    private static void setUpMockData4test4getERLTemplatecreateinstancepatrunits() {
    }

    private static void setUpMockData4test4setERLTemplatecreateinstancepatrunits() {
        test4setERLTemplatecreateinstancepatrunitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getERLTemplatecreateinstancepatrprice() {
    }

    private static void setUpMockData4test4setERLTemplatecreateinstancepatrprice() {
        test4setERLTemplatecreateinstancepatrpriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getERLTemplatecreateinstancepatrdescription() {
    }

    private static void setUpMockData4test4setERLTemplatecreateinstancepatrdescription() {
        test4setERLTemplatecreateinstancepatrdescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrTemplate(defValue4eRLTemplatecreateinstancepagrTemplate);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrTemplateInstance(defValue4eRLTemplatecreateinstancepagrTemplateInstance);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrExpenseType(defValue4eRLTemplatecreateinstancepagrExpenseType);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrExpenseTypeInstance(defValue4eRLTemplatecreateinstancepagrExpenseTypeInstance);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrunits(defValue4eRLTemplatecreateinstancepatrunits);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrprice(defValue4eRLTemplatecreateinstancepatrprice);
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrdescription(defValue4eRLTemplatecreateinstancepatrdescription);
    }

    @Test
    public void test4getERLTemplatecreateinstancepagrTemplate() {
        assertEquals(defValue4eRLTemplatecreateinstancepagrTemplate, instanceCreateinstanceRequest.getERLTemplatecreateinstancepagrTemplate());
    }

    @Test
    public void test4setERLTemplatecreateinstancepagrTemplate() {
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrTemplate(test4setERLTemplatecreateinstancepagrTemplateArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getERLTemplatecreateinstancepagrExpenseType() {
        assertEquals(defValue4eRLTemplatecreateinstancepagrExpenseType, instanceCreateinstanceRequest.getERLTemplatecreateinstancepagrExpenseType());
    }

    @Test
    public void test4setERLTemplatecreateinstancepagrExpenseType() {
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepagrExpenseType(test4setERLTemplatecreateinstancepagrExpenseTypeArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getERLTemplatecreateinstancepatrunits() {
        assertEquals(defValue4eRLTemplatecreateinstancepatrunits, instanceCreateinstanceRequest.getERLTemplatecreateinstancepatrunits());
    }

    @Test
    public void test4setERLTemplatecreateinstancepatrunits() {
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrunits(test4setERLTemplatecreateinstancepatrunitsArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getERLTemplatecreateinstancepatrprice() {
        assertEquals(defValue4eRLTemplatecreateinstancepatrprice, instanceCreateinstanceRequest.getERLTemplatecreateinstancepatrprice());
    }

    @Test
    public void test4setERLTemplatecreateinstancepatrprice() {
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrprice(test4setERLTemplatecreateinstancepatrpriceArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getERLTemplatecreateinstancepatrdescription() {
        assertEquals(defValue4eRLTemplatecreateinstancepatrdescription, instanceCreateinstanceRequest.getERLTemplatecreateinstancepatrdescription());
    }

    @Test
    public void test4setERLTemplatecreateinstancepatrdescription() {
        instanceCreateinstanceRequest.setERLTemplatecreateinstancepatrdescription(test4setERLTemplatecreateinstancepatrdescriptionArg1);
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
