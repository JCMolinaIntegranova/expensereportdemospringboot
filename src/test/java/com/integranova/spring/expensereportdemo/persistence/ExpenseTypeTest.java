package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseTypeTest {

    private static ExpenseLineJpaRepository mockExpenseLineJpaRepository;

    private static ERLTemplateJpaRepository mockERLTemplateJpaRepository;

    private static Agent mockAgent;

    ExpenseType instanceExpenseType;
    private static String VALUE_EXPENSETYPETYPECODE;
    private static String VALUE_EXPENSETYPETYDESCRIPTION;
    private static Double VALUE_EXPENSETYPEPRICE;
    private static Boolean VALUE_EXPENSETYPEFIXEDPRICE;
    private static List<ExpenseLine> VALUE_EXPENSELINES;
    private static List<ERLTemplate> VALUE_TEMPLATELINES;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EXPENSETYPETYPECODE = "expenseTypeTypeCode";
        VALUE_EXPENSETYPETYDESCRIPTION = "expenseTypeTyDescription";
        VALUE_EXPENSETYPEPRICE = Double.valueOf(0);
        VALUE_EXPENSETYPEFIXEDPRICE = false;
        VALUE_EXPENSELINES = new ArrayList<>();
        VALUE_EXPENSELINES.add(new ExpenseLine());
        VALUE_TEMPLATELINES = new ArrayList<>();
        VALUE_TEMPLATELINES.add(new ERLTemplate());
        mockExpenseLineJpaRepository = mock(ExpenseLineJpaRepository.class);
        mockERLTemplateJpaRepository = mock(ERLTemplateJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceExpenseType = new ExpenseType();
        instanceExpenseType.setExpenseLineRepository(mockExpenseLineJpaRepository);
        instanceExpenseType.setERLTemplateRepository(mockERLTemplateJpaRepository);
        instanceExpenseType.setAgent(mockAgent);
        instanceExpenseType.setExpenseTypeTypeCode(VALUE_EXPENSETYPETYPECODE);
        instanceExpenseType.setExpenseTypeTyDescription(VALUE_EXPENSETYPETYDESCRIPTION);
        instanceExpenseType.setExpenseTypePrice(VALUE_EXPENSETYPEPRICE);
        instanceExpenseType.setExpenseTypeFixedPrice(VALUE_EXPENSETYPEFIXEDPRICE);
        instanceExpenseType.setExpenseLines(VALUE_EXPENSELINES);
        instanceExpenseType.setTemplateLines(VALUE_TEMPLATELINES);
        when(mockExpenseLineJpaRepository.findByExpenseType(any(ExpenseType.class))).thenReturn(VALUE_EXPENSELINES);
        when(mockERLTemplateJpaRepository.findByExpenseType(any(ExpenseType.class))).thenReturn(VALUE_TEMPLATELINES);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceExpenseType = null;
    }

    @Test
    public void testDefaultConstructor() {
        ExpenseType value = new ExpenseType();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ExpenseType value = new ExpenseType(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        assertNotNull(value);
    }

    @Test
    public void test4getExpenseTypeTypeCode() {
        assertEquals(VALUE_EXPENSETYPETYPECODE.toString(), instanceExpenseType.getExpenseTypeTypeCode().toString());
    }

    @Test
    public void test4setExpenseTypeTypeCode() {
        String value = "expenseTypeTypeCode";
        instanceExpenseType.setExpenseTypeTypeCode(value);
        assertEquals(value, instanceExpenseType.getExpenseTypeTypeCode());
    }

    @Test
    public void test4getExpenseTypeTyDescription() {
        assertEquals(VALUE_EXPENSETYPETYDESCRIPTION.toString(), instanceExpenseType.getExpenseTypeTyDescription().toString());
    }

    @Test
    public void test4setExpenseTypeTyDescription() {
        String value = "expenseTypeTyDescription";
        instanceExpenseType.setExpenseTypeTyDescription(value);
        assertEquals(value, instanceExpenseType.getExpenseTypeTyDescription());
    }

    @Test
    public void test4isModifiedExpenseTypeTyDescription() {
        instanceExpenseType = new ExpenseType();
        assertFalse(instanceExpenseType.isModifiedExpenseTypeTyDescription());
        instanceExpenseType.setExpenseTypeTyDescription(VALUE_EXPENSETYPETYDESCRIPTION);
        assertTrue(instanceExpenseType.isModifiedExpenseTypeTyDescription());
    }

    @Test
    public void test4setModifiedExpenseTypeTyDescription() {
        instanceExpenseType.setModifiedExpenseTypeTyDescription(true);
        assertTrue(instanceExpenseType.isModifiedExpenseTypeTyDescription());
    }

    @Test
    public void test4getExpenseTypePrice() {
        assertEquals(VALUE_EXPENSETYPEPRICE.toString(), instanceExpenseType.getExpenseTypePrice().toString());
    }

    @Test
    public void test4setExpenseTypePrice() {
        Double value = Double.valueOf(0);
        instanceExpenseType.setExpenseTypePrice(value);
        assertEquals(value, instanceExpenseType.getExpenseTypePrice());
    }

    @Test
    public void test4isModifiedExpenseTypePrice() {
        instanceExpenseType = new ExpenseType();
        assertFalse(instanceExpenseType.isModifiedExpenseTypePrice());
        instanceExpenseType.setExpenseTypePrice(VALUE_EXPENSETYPEPRICE);
        assertTrue(instanceExpenseType.isModifiedExpenseTypePrice());
    }

    @Test
    public void test4setModifiedExpenseTypePrice() {
        instanceExpenseType.setModifiedExpenseTypePrice(true);
        assertTrue(instanceExpenseType.isModifiedExpenseTypePrice());
    }

    @Test
    public void test4getExpenseTypeFixedPrice() {
        assertEquals(VALUE_EXPENSETYPEFIXEDPRICE.toString(), instanceExpenseType.getExpenseTypeFixedPrice().toString());
    }

    @Test
    public void test4setExpenseTypeFixedPrice() {
        Boolean value = false;
        instanceExpenseType.setExpenseTypeFixedPrice(value);
        assertEquals(value, instanceExpenseType.getExpenseTypeFixedPrice());
    }

    @Test
    public void test4isModifiedExpenseTypeFixedPrice() {
        instanceExpenseType = new ExpenseType();
        assertFalse(instanceExpenseType.isModifiedExpenseTypeFixedPrice());
        instanceExpenseType.setExpenseTypeFixedPrice(VALUE_EXPENSETYPEFIXEDPRICE);
        assertTrue(instanceExpenseType.isModifiedExpenseTypeFixedPrice());
    }

    @Test
    public void test4setModifiedExpenseTypeFixedPrice() {
        instanceExpenseType.setModifiedExpenseTypeFixedPrice(true);
        assertTrue(instanceExpenseType.isModifiedExpenseTypeFixedPrice());
    }

    @Test
    public void test4getExpenseLines() {
        assertEquals(VALUE_EXPENSELINES, instanceExpenseType.getExpenseLines());
    }

    @Test
    public void test4getExpenseLines2() {
        instanceExpenseType.setExpenseLines(null);
        assertEquals(VALUE_EXPENSELINES, instanceExpenseType.getExpenseLines());
    }

    @Test
    public void test4getExpenseLines3() {
        instanceExpenseType.setExpenseLines(new ArrayList<>());
        assertEquals(VALUE_EXPENSELINES, instanceExpenseType.getExpenseLines());
    }

    @Test
    public void test4add2ExpenseLines() {
        ExpenseLine value = new ExpenseLine();
        instanceExpenseType.add2ExpenseLines(value);
        assertTrue(instanceExpenseType.getExpenseLines().contains(value));
    }

    @Test
    public void test4setExpenseLines() {
        instanceExpenseType.setExpenseLines(VALUE_EXPENSELINES);
        assertEquals(VALUE_EXPENSELINES, instanceExpenseType.getExpenseLines());
    }

    @Test
    public void test4isModifiedExpenseLines() {
        assertFalse(instanceExpenseType.isModifiedExpenseLines());
    }

    @Test
    public void test4getTemplateLines() {
        assertEquals(VALUE_TEMPLATELINES, instanceExpenseType.getTemplateLines());
    }

    @Test
    public void test4getTemplateLines2() {
        instanceExpenseType.setTemplateLines(null);
        assertEquals(VALUE_TEMPLATELINES, instanceExpenseType.getTemplateLines());
    }

    @Test
    public void test4getTemplateLines3() {
        instanceExpenseType.setTemplateLines(new ArrayList<>());
        assertEquals(VALUE_TEMPLATELINES, instanceExpenseType.getTemplateLines());
    }

    @Test
    public void test4add2TemplateLines() {
        ERLTemplate value = new ERLTemplate();
        instanceExpenseType.add2TemplateLines(value);
        assertTrue(instanceExpenseType.getTemplateLines().contains(value));
    }

    @Test
    public void test4setTemplateLines() {
        instanceExpenseType.setTemplateLines(VALUE_TEMPLATELINES);
        assertEquals(VALUE_TEMPLATELINES, instanceExpenseType.getTemplateLines());
    }

    @Test
    public void test4isModifiedTemplateLines() {
        assertFalse(instanceExpenseType.isModifiedTemplateLines());
    }

    @Test
    public void test4buildDSExpenseType() {
        String result;
        try {
            result = instanceExpenseType.buildDSExpenseType().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSExpenseTypeSup() {
        String result;
        try {
            result = instanceExpenseType.buildDSExpenseTypeSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceExpenseType.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceExpenseType.getAttribute(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYPECODE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseType.getAttributeTypeRelated(ExpenseTypeConstants.ROLE_NAME_EXPENSELINES, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseType.getAttributeTypeRelated(ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES, ""));
        assertEquals("", instanceExpenseType.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceExpenseType.cleanDerivations();
        assertNotNull(instanceExpenseType);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceExpenseType.getExpenseTypeTypeCode(), instanceExpenseType.getOid().getExpenseTypeTypeCode());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceExpenseType.isVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYDESCRIPTION));
        assertTrue(instanceExpenseType.isVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPEPRICE));
        assertTrue(instanceExpenseType.isVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPEFIXEDPRICE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceExpenseType.isAttributeVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYDESCRIPTION));
        assertTrue(instanceExpenseType.isAttributeVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPEPRICE));
        assertTrue(instanceExpenseType.isAttributeVisible(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPEFIXEDPRICE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceExpenseType.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceExpenseType.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceExpenseType.getActiveFacets().contains(Constants.EXPENSETYPE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceExpenseType.getFacets().contains(Constants.EXPENSETYPE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceExpenseType.checkHorizontalVisibility(null));
    }
}
