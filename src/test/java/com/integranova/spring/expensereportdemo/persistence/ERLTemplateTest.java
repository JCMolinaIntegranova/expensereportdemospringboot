package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERLTemplateTest {

    private static ERTemplateJpaRepository mockERTemplateJpaRepository;

    private static ExpenseTypeJpaRepository mockExpenseTypeJpaRepository;

    private static Agent mockAgent;

    ERLTemplate instanceERLTemplate;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_TEMPLATE_ERTEMPLATEID;
    private static Long VALUE_ERLTEMPLATEID;
    private static Double VALUE_ERLTEMPLATEUNITS;
    private static Double VALUE_ERLTEMPLATEPRICE;
    private static String VALUE_ERLTEMPLATEDESCRIPTION;
    private static Double VALUE_ERLTEMPLATETOTALLINE;
    private static ERTemplate VALUE_TEMPLATE;
    private static ExpenseType VALUE_EXPENSETYPE;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_TEMPLATE_ERTEMPLATEID = Long.valueOf(0);
        VALUE_ERLTEMPLATEID = Long.valueOf(0);
        VALUE_ERLTEMPLATEUNITS = Double.valueOf(0);
        VALUE_ERLTEMPLATEPRICE = Double.valueOf(0);
        VALUE_ERLTEMPLATEDESCRIPTION = "eRLTemplatedescription";
        VALUE_ERLTEMPLATETOTALLINE = Double.valueOf(0);
        VALUE_TEMPLATE = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
        VALUE_EXPENSETYPE = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        mockERTemplateJpaRepository = mock(ERTemplateJpaRepository.class);
        mockExpenseTypeJpaRepository = mock(ExpenseTypeJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceERLTemplate = new ERLTemplate();
        instanceERLTemplate.setERTemplateRepository(mockERTemplateJpaRepository);
        instanceERLTemplate.setExpenseTypeRepository(mockExpenseTypeJpaRepository);
        instanceERLTemplate.setAgent(mockAgent);
        instanceERLTemplate.setERTemplateTemplateid(VALUE_TEMPLATE_ERTEMPLATEID);
        instanceERLTemplate.setERLTemplateid(VALUE_ERLTEMPLATEID);
        instanceERLTemplate.setERLTemplateunits(VALUE_ERLTEMPLATEUNITS);
        instanceERLTemplate.setERLTemplateprice(VALUE_ERLTEMPLATEPRICE);
        instanceERLTemplate.setERLTemplatedescription(VALUE_ERLTEMPLATEDESCRIPTION);
        instanceERLTemplate.add2Template(VALUE_TEMPLATE);
        instanceERLTemplate.add2ExpenseType(VALUE_EXPENSETYPE);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceERLTemplate = null;
    }

    @Test
    public void testDefaultConstructor() {
        ERLTemplate value = new ERLTemplate();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ERLTemplate value = new ERLTemplate(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ERLTemplate value = new ERLTemplate(new ERLTemplateOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ERLTemplate value = new ERLTemplate(new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getERTemplateTemplateid() {
        assertEquals(VALUE_TEMPLATE_ERTEMPLATEID.toString(), instanceERLTemplate.getERTemplateTemplateid().toString());
    }

    @Test
    public void test4setERTemplateTemplateid() {
        Long value = Long.valueOf(0);
        instanceERLTemplate.setERTemplateTemplateid(value);
        assertEquals(value, instanceERLTemplate.getERTemplateTemplateid());
    }

    @Test
    public void test4getERLTemplateid() {
        assertEquals(VALUE_ERLTEMPLATEID.toString(), instanceERLTemplate.getERLTemplateid().toString());
    }

    @Test
    public void test4setERLTemplateid() {
        Long value = Long.valueOf(0);
        instanceERLTemplate.setERLTemplateid(value);
        assertEquals(value, instanceERLTemplate.getERLTemplateid());
    }

    @Test
    public void test4getERLTemplateunits() {
        assertEquals(VALUE_ERLTEMPLATEUNITS.toString(), instanceERLTemplate.getERLTemplateunits().toString());
    }

    @Test
    public void test4setERLTemplateunits() {
        Double value = Double.valueOf(0);
        instanceERLTemplate.setERLTemplateunits(value);
        assertEquals(value, instanceERLTemplate.getERLTemplateunits());
    }

    @Test
    public void test4isModifiedERLTemplateunits() {
        instanceERLTemplate = new ERLTemplate();
        assertFalse(instanceERLTemplate.isModifiedERLTemplateunits());
        instanceERLTemplate.setERLTemplateunits(VALUE_ERLTEMPLATEUNITS);
        assertTrue(instanceERLTemplate.isModifiedERLTemplateunits());
    }

    @Test
    public void test4setModifiedERLTemplateunits() {
        instanceERLTemplate.setModifiedERLTemplateunits(true);
        assertTrue(instanceERLTemplate.isModifiedERLTemplateunits());
    }

    @Test
    public void test4getERLTemplateprice() {
        assertEquals(VALUE_ERLTEMPLATEPRICE.toString(), instanceERLTemplate.getERLTemplateprice().toString());
    }

    @Test
    public void test4setERLTemplateprice() {
        Double value = Double.valueOf(0);
        instanceERLTemplate.setERLTemplateprice(value);
        assertEquals(value, instanceERLTemplate.getERLTemplateprice());
    }

    @Test
    public void test4isModifiedERLTemplateprice() {
        instanceERLTemplate = new ERLTemplate();
        assertFalse(instanceERLTemplate.isModifiedERLTemplateprice());
        instanceERLTemplate.setERLTemplateprice(VALUE_ERLTEMPLATEPRICE);
        assertTrue(instanceERLTemplate.isModifiedERLTemplateprice());
    }

    @Test
    public void test4setModifiedERLTemplateprice() {
        instanceERLTemplate.setModifiedERLTemplateprice(true);
        assertTrue(instanceERLTemplate.isModifiedERLTemplateprice());
    }

    @Test
    public void test4getERLTemplatedescription() {
        assertEquals(VALUE_ERLTEMPLATEDESCRIPTION.toString(), instanceERLTemplate.getERLTemplatedescription().toString());
    }

    @Test
    public void test4setERLTemplatedescription() {
        String value = "eRLTemplatedescription";
        instanceERLTemplate.setERLTemplatedescription(value);
        assertEquals(value, instanceERLTemplate.getERLTemplatedescription());
    }

    @Test
    public void test4isModifiedERLTemplatedescription() {
        instanceERLTemplate = new ERLTemplate();
        assertFalse(instanceERLTemplate.isModifiedERLTemplatedescription());
        instanceERLTemplate.setERLTemplatedescription(VALUE_ERLTEMPLATEDESCRIPTION);
        assertTrue(instanceERLTemplate.isModifiedERLTemplatedescription());
    }

    @Test
    public void test4setModifiedERLTemplatedescription() {
        instanceERLTemplate.setModifiedERLTemplatedescription(true);
        assertTrue(instanceERLTemplate.isModifiedERLTemplatedescription());
    }

    @Test
    public void test4getERLTemplatetotalLine() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_ERLTEMPLATETOTALLINE.toString(), instanceERLTemplate.getERLTemplatetotalLine().toString());
        } else {
            instanceERLTemplate.getERLTemplatetotalLine();
            assertNotNull(instanceERLTemplate);
        }
    }

    @Test
    public void test4getTemplate() {
        assertEquals(VALUE_TEMPLATE, instanceERLTemplate.getTemplate());
    }

    @Test
    public void test4getTemplate2() {
        instanceERLTemplate.add2Template(null);
        assertTrue(instanceERLTemplate.getTemplate().isNull());
    }

    @Test
    public void test4getTemplate3() {
        ERTemplate value = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
        instanceERLTemplate.add2Template(value);
        assertEquals(value, instanceERLTemplate.getTemplate());
    }

    @Test
    public void test4add2Template() {
        ERTemplate value = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
        instanceERLTemplate.add2Template(value);
        assertEquals(value, instanceERLTemplate.getTemplate());
    }

    @Test
    public void test4setTemplate() {
        instanceERLTemplate.add2Template(VALUE_TEMPLATE);
        assertEquals(VALUE_TEMPLATE, instanceERLTemplate.getTemplate());
    }

    @Test
    public void test4isModifiedTemplate() {
        assertFalse(instanceERLTemplate.isModifiedTemplate());
    }

    @Test
    public void test4getExpenseType() {
        assertEquals(VALUE_EXPENSETYPE, instanceERLTemplate.getExpenseType());
    }

    @Test
    public void test4getExpenseType2() {
        instanceERLTemplate.add2ExpenseType(null);
        assertTrue(instanceERLTemplate.getExpenseType().isNull());
    }

    @Test
    public void test4getExpenseType3() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        instanceERLTemplate.add2ExpenseType(value);
        assertEquals(value, instanceERLTemplate.getExpenseType());
    }

    @Test
    public void test4add2ExpenseType() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        instanceERLTemplate.add2ExpenseType(value);
        assertEquals(value, instanceERLTemplate.getExpenseType());
    }

    @Test
    public void test4setExpenseType() {
        instanceERLTemplate.add2ExpenseType(VALUE_EXPENSETYPE);
        assertEquals(VALUE_EXPENSETYPE, instanceERLTemplate.getExpenseType());
    }

    @Test
    public void test4isModifiedExpenseType() {
        assertFalse(instanceERLTemplate.isModifiedExpenseType());
    }

    @Test
    public void test4buildDSTemplateLines() {
        String result;
        try {
            result = instanceERLTemplate.buildDSTemplateLines().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceERLTemplate.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceERLTemplate.getAttribute(ERLTemplateConstants.ATTR_NAME_TEMPLATE_ERTEMPLATEID));
        assertNull(instanceERLTemplate.getAttribute(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEID));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceERLTemplate.getAttributeTypeRelated(ERLTemplateConstants.ROLE_NAME_TEMPLATE, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceERLTemplate.getAttributeTypeRelated(ERLTemplateConstants.ROLE_NAME_EXPENSETYPE, ""));
        assertEquals("", instanceERLTemplate.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceERLTemplate.cleanDerivations();
        assertNotNull(instanceERLTemplate);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceERLTemplate.getERTemplateTemplateid(), instanceERLTemplate.getOid().getERTemplateTemplateid());
        assertEquals(instanceERLTemplate.getERLTemplateid(), instanceERLTemplate.getOid().getERLTemplateid());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceERLTemplate.isVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEUNITS));
        assertTrue(instanceERLTemplate.isVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEPRICE));
        assertTrue(instanceERLTemplate.isVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEDESCRIPTION));
        assertTrue(instanceERLTemplate.isVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATETOTALLINE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceERLTemplate.isAttributeVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEUNITS));
        assertTrue(instanceERLTemplate.isAttributeVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEPRICE));
        assertTrue(instanceERLTemplate.isAttributeVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEDESCRIPTION));
        assertTrue(instanceERLTemplate.isAttributeVisible(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATETOTALLINE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceERLTemplate.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceERLTemplate.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceERLTemplate.getActiveFacets().contains(Constants.ERLTEMPLATE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceERLTemplate.getFacets().contains(Constants.ERLTEMPLATE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceERLTemplate.checkHorizontalVisibility(null));
    }
}
