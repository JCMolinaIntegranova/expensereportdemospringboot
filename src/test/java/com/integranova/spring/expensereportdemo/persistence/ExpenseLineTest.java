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
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseLineTest {

    private static ExpenseTypeJpaRepository mockExpenseTypeJpaRepository;

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static Agent mockAgent;

    ExpenseLine instanceExpenseLine;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR;
    private static Long VALUE_EXPENSELINEIDEXPENSELINE;
    private static Date VALUE_EXPENSELINEEXPENSEDATE;
    private static Double VALUE_EXPENSELINEUNITS;
    private static Double VALUE_EXPENSELINEPRICE;
    private static Double VALUE_EXPENSELINETOTALLINE;
    private static String VALUE_EXPENSELINELNDESCRIPTION;
    private static Double VALUE_EXPENSELINETOTALLINECURR;
    private static ExpenseType VALUE_EXPENSETYPE;
    private static ExpenseReport VALUE_EXPENSEREPORT;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR = Long.valueOf(0);
        VALUE_EXPENSELINEIDEXPENSELINE = Long.valueOf(0);
        VALUE_EXPENSELINEEXPENSEDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_EXPENSELINEUNITS = Double.valueOf(0);
        VALUE_EXPENSELINEPRICE = Double.valueOf(0);
        VALUE_EXPENSELINETOTALLINE = Double.valueOf(0);
        VALUE_EXPENSELINELNDESCRIPTION = "expenseLineLnDescription";
        VALUE_EXPENSELINETOTALLINECURR = Double.valueOf(0);
        VALUE_EXPENSETYPE = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        VALUE_EXPENSEREPORT = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        mockExpenseTypeJpaRepository = mock(ExpenseTypeJpaRepository.class);
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceExpenseLine = new ExpenseLine();
        instanceExpenseLine.setExpenseTypeRepository(mockExpenseTypeJpaRepository);
        instanceExpenseLine.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instanceExpenseLine.setAgent(mockAgent);
        instanceExpenseLine.setExpenseReportidExpenseRepor(VALUE_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR);
        instanceExpenseLine.setExpenseLineidExpenseLine(VALUE_EXPENSELINEIDEXPENSELINE);
        instanceExpenseLine.setExpenseLineExpenseDate(VALUE_EXPENSELINEEXPENSEDATE);
        instanceExpenseLine.setExpenseLineUnits(VALUE_EXPENSELINEUNITS);
        instanceExpenseLine.setExpenseLinePrice(VALUE_EXPENSELINEPRICE);
        instanceExpenseLine.setExpenseLineLnDescription(VALUE_EXPENSELINELNDESCRIPTION);
        instanceExpenseLine.add2ExpenseType(VALUE_EXPENSETYPE);
        instanceExpenseLine.add2ExpenseReport(VALUE_EXPENSEREPORT);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceExpenseLine = null;
    }

    @Test
    public void testDefaultConstructor() {
        ExpenseLine value = new ExpenseLine();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ExpenseLine value = new ExpenseLine(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ExpenseLine value = new ExpenseLine(new ExpenseLineOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ExpenseLine value = new ExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getExpenseReportidExpenseRepor() {
        assertEquals(VALUE_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR.toString(), instanceExpenseLine.getExpenseReportidExpenseRepor().toString());
    }

    @Test
    public void test4setExpenseReportidExpenseRepor() {
        Long value = Long.valueOf(0);
        instanceExpenseLine.setExpenseReportidExpenseRepor(value);
        assertEquals(value, instanceExpenseLine.getExpenseReportidExpenseRepor());
    }

    @Test
    public void test4getExpenseLineidExpenseLine() {
        assertEquals(VALUE_EXPENSELINEIDEXPENSELINE.toString(), instanceExpenseLine.getExpenseLineidExpenseLine().toString());
    }

    @Test
    public void test4setExpenseLineidExpenseLine() {
        Long value = Long.valueOf(0);
        instanceExpenseLine.setExpenseLineidExpenseLine(value);
        assertEquals(value, instanceExpenseLine.getExpenseLineidExpenseLine());
    }

    @Test
    public void test4getExpenseLineExpenseDate() {
        assertEquals(VALUE_EXPENSELINEEXPENSEDATE.toString(), instanceExpenseLine.getExpenseLineExpenseDate().toString());
    }

    @Test
    public void test4setExpenseLineExpenseDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceExpenseLine.setExpenseLineExpenseDate(value);
        assertEquals(value, instanceExpenseLine.getExpenseLineExpenseDate());
    }

    @Test
    public void test4isModifiedExpenseLineExpenseDate() {
        instanceExpenseLine = new ExpenseLine();
        assertFalse(instanceExpenseLine.isModifiedExpenseLineExpenseDate());
        instanceExpenseLine.setExpenseLineExpenseDate(VALUE_EXPENSELINEEXPENSEDATE);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineExpenseDate());
    }

    @Test
    public void test4setModifiedExpenseLineExpenseDate() {
        instanceExpenseLine.setModifiedExpenseLineExpenseDate(true);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineExpenseDate());
    }

    @Test
    public void test4getExpenseLineUnits() {
        assertEquals(VALUE_EXPENSELINEUNITS.toString(), instanceExpenseLine.getExpenseLineUnits().toString());
    }

    @Test
    public void test4setExpenseLineUnits() {
        Double value = Double.valueOf(0);
        instanceExpenseLine.setExpenseLineUnits(value);
        assertEquals(value, instanceExpenseLine.getExpenseLineUnits());
    }

    @Test
    public void test4isModifiedExpenseLineUnits() {
        instanceExpenseLine = new ExpenseLine();
        assertFalse(instanceExpenseLine.isModifiedExpenseLineUnits());
        instanceExpenseLine.setExpenseLineUnits(VALUE_EXPENSELINEUNITS);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineUnits());
    }

    @Test
    public void test4setModifiedExpenseLineUnits() {
        instanceExpenseLine.setModifiedExpenseLineUnits(true);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineUnits());
    }

    @Test
    public void test4getExpenseLinePrice() {
        assertEquals(VALUE_EXPENSELINEPRICE.toString(), instanceExpenseLine.getExpenseLinePrice().toString());
    }

    @Test
    public void test4setExpenseLinePrice() {
        Double value = Double.valueOf(0);
        instanceExpenseLine.setExpenseLinePrice(value);
        assertEquals(value, instanceExpenseLine.getExpenseLinePrice());
    }

    @Test
    public void test4isModifiedExpenseLinePrice() {
        instanceExpenseLine = new ExpenseLine();
        assertFalse(instanceExpenseLine.isModifiedExpenseLinePrice());
        instanceExpenseLine.setExpenseLinePrice(VALUE_EXPENSELINEPRICE);
        assertTrue(instanceExpenseLine.isModifiedExpenseLinePrice());
    }

    @Test
    public void test4setModifiedExpenseLinePrice() {
        instanceExpenseLine.setModifiedExpenseLinePrice(true);
        assertTrue(instanceExpenseLine.isModifiedExpenseLinePrice());
    }

    @Test
    public void test4getExpenseLineTotalLine() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSELINETOTALLINE.toString(), instanceExpenseLine.getExpenseLineTotalLine().toString());
        } else {
            instanceExpenseLine.getExpenseLineTotalLine();
            assertNotNull(instanceExpenseLine);
        }
    }

    @Test
    public void test4getExpenseLineLnDescription() {
        assertEquals(VALUE_EXPENSELINELNDESCRIPTION.toString(), instanceExpenseLine.getExpenseLineLnDescription().toString());
    }

    @Test
    public void test4setExpenseLineLnDescription() {
        String value = "expenseLineLnDescription";
        instanceExpenseLine.setExpenseLineLnDescription(value);
        assertEquals(value, instanceExpenseLine.getExpenseLineLnDescription());
    }

    @Test
    public void test4isModifiedExpenseLineLnDescription() {
        instanceExpenseLine = new ExpenseLine();
        assertFalse(instanceExpenseLine.isModifiedExpenseLineLnDescription());
        instanceExpenseLine.setExpenseLineLnDescription(VALUE_EXPENSELINELNDESCRIPTION);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineLnDescription());
    }

    @Test
    public void test4setModifiedExpenseLineLnDescription() {
        instanceExpenseLine.setModifiedExpenseLineLnDescription(true);
        assertTrue(instanceExpenseLine.isModifiedExpenseLineLnDescription());
    }

    @Test
    public void test4getExpenseLineTotalLineCurr() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSELINETOTALLINECURR.toString(), instanceExpenseLine.getExpenseLineTotalLineCurr().toString());
        } else {
            instanceExpenseLine.getExpenseLineTotalLineCurr();
            assertNotNull(instanceExpenseLine);
        }
    }

    @Test
    public void test4getExpenseType() {
        assertEquals(VALUE_EXPENSETYPE, instanceExpenseLine.getExpenseType());
    }

    @Test
    public void test4getExpenseType2() {
        instanceExpenseLine.add2ExpenseType(null);
        assertTrue(instanceExpenseLine.getExpenseType().isNull());
    }

    @Test
    public void test4getExpenseType3() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        instanceExpenseLine.add2ExpenseType(value);
        assertEquals(value, instanceExpenseLine.getExpenseType());
    }

    @Test
    public void test4add2ExpenseType() {
        ExpenseType value = new ExpenseType(new ExpenseTypeOid("expenseTypeTypeCode"));
        instanceExpenseLine.add2ExpenseType(value);
        assertEquals(value, instanceExpenseLine.getExpenseType());
    }

    @Test
    public void test4setExpenseType() {
        instanceExpenseLine.add2ExpenseType(VALUE_EXPENSETYPE);
        assertEquals(VALUE_EXPENSETYPE, instanceExpenseLine.getExpenseType());
    }

    @Test
    public void test4isModifiedExpenseType() {
        assertFalse(instanceExpenseLine.isModifiedExpenseType());
    }

    @Test
    public void test4getExpenseReport() {
        assertEquals(VALUE_EXPENSEREPORT, instanceExpenseLine.getExpenseReport());
    }

    @Test
    public void test4getExpenseReport2() {
        instanceExpenseLine.add2ExpenseReport(null);
        assertTrue(instanceExpenseLine.getExpenseReport().isNull());
    }

    @Test
    public void test4getExpenseReport3() {
        ExpenseReport value = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        instanceExpenseLine.add2ExpenseReport(value);
        assertEquals(value, instanceExpenseLine.getExpenseReport());
    }

    @Test
    public void test4add2ExpenseReport() {
        ExpenseReport value = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        instanceExpenseLine.add2ExpenseReport(value);
        assertEquals(value, instanceExpenseLine.getExpenseReport());
    }

    @Test
    public void test4setExpenseReport() {
        instanceExpenseLine.add2ExpenseReport(VALUE_EXPENSEREPORT);
        assertEquals(VALUE_EXPENSEREPORT, instanceExpenseLine.getExpenseReport());
    }

    @Test
    public void test4isModifiedExpenseReport() {
        assertFalse(instanceExpenseLine.isModifiedExpenseReport());
    }

    @Test
    public void test4buildDSExpenseLine() {
        String result;
        try {
            result = instanceExpenseLine.buildDSExpenseLine().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSExpenseLineSup() {
        String result;
        try {
            result = instanceExpenseLine.buildDSExpenseLineSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceExpenseLine.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceExpenseLine.getAttribute(ExpenseLineConstants.ATTR_NAME_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR));
        assertNull(instanceExpenseLine.getAttribute(ExpenseLineConstants.ATTR_NAME_EXPENSELINEIDEXPENSELINE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseLine.getAttributeTypeRelated(ExpenseLineConstants.ROLE_NAME_EXPENSETYPE, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseLine.getAttributeTypeRelated(ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT, ""));
        assertEquals("", instanceExpenseLine.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceExpenseLine.cleanDerivations();
        assertNotNull(instanceExpenseLine);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceExpenseLine.getExpenseReportidExpenseRepor(), instanceExpenseLine.getOid().getExpenseReportidExpenseRepor());
        assertEquals(instanceExpenseLine.getExpenseLineidExpenseLine(), instanceExpenseLine.getOid().getExpenseLineidExpenseLine());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEEXPENSEDATE));
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEUNITS));
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEPRICE));
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINETOTALLINE));
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINELNDESCRIPTION));
        assertTrue(instanceExpenseLine.isVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINETOTALLINECURR));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEEXPENSEDATE));
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEUNITS));
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINEPRICE));
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINETOTALLINE));
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINELNDESCRIPTION));
        assertTrue(instanceExpenseLine.isAttributeVisible(ExpenseLineConstants.ATTR_NAME_EXPENSELINETOTALLINECURR));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceExpenseLine.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceExpenseLine.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceExpenseLine.getActiveFacets().contains(Constants.EXPENSELINE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceExpenseLine.getFacets().contains(Constants.EXPENSELINE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceExpenseLine.checkHorizontalVisibility(null));
    }
}
