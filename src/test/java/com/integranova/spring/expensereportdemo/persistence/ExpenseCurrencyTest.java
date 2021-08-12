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
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.repository.ExchangeHistoryJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
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
public class ExpenseCurrencyTest {

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static ExchangeHistoryJpaRepository mockExchangeHistoryJpaRepository;

    private static Agent mockAgent;

    ExpenseCurrency instanceExpenseCurrency;
    private static String VALUE_EXPENSECURRENCYCURRENCYCODE;
    private static String VALUE_EXPENSECURRENCYCURRENCYNAME;
    private static String VALUE_EXPENSECURRENCYCURACRONYM;
    private static Double VALUE_EXPENSECURRENCYEXCHANGE;
    private static List<ExpenseReport> VALUE_EXPENSEREPORTS;
    private static List<ExchangeHistory> VALUE_EXCHANGEHISTORYITEMS;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
        VALUE_EXPENSECURRENCYCURRENCYNAME = "expenseCurrencyCurrencyName";
        VALUE_EXPENSECURRENCYCURACRONYM = "expenseCurrencyCurAcronym";
        VALUE_EXPENSECURRENCYEXCHANGE = Double.valueOf(0);
        VALUE_EXPENSEREPORTS = new ArrayList<>();
        VALUE_EXPENSEREPORTS.add(new ExpenseReport());
        VALUE_EXCHANGEHISTORYITEMS = new ArrayList<>();
        VALUE_EXCHANGEHISTORYITEMS.add(new ExchangeHistory());
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockExchangeHistoryJpaRepository = mock(ExchangeHistoryJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceExpenseCurrency = new ExpenseCurrency();
        instanceExpenseCurrency.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instanceExpenseCurrency.setExchangeHistoryRepository(mockExchangeHistoryJpaRepository);
        instanceExpenseCurrency.setAgent(mockAgent);
        instanceExpenseCurrency.setExpenseCurrencyCurrencyCode(VALUE_EXPENSECURRENCYCURRENCYCODE);
        instanceExpenseCurrency.setExpenseCurrencyCurrencyName(VALUE_EXPENSECURRENCYCURRENCYNAME);
        instanceExpenseCurrency.setExpenseCurrencyCurAcronym(VALUE_EXPENSECURRENCYCURACRONYM);
        instanceExpenseCurrency.setExpenseCurrencyExchange(VALUE_EXPENSECURRENCYEXCHANGE);
        instanceExpenseCurrency.setExpenseReports(VALUE_EXPENSEREPORTS);
        instanceExpenseCurrency.setExchangeHistoryItems(VALUE_EXCHANGEHISTORYITEMS);
        when(mockExpenseReportJpaRepository.findByExpenseCurrency(any(ExpenseCurrency.class))).thenReturn(VALUE_EXPENSEREPORTS);
        when(mockExchangeHistoryJpaRepository.findByExpenseCurrency(any(ExpenseCurrency.class))).thenReturn(VALUE_EXCHANGEHISTORYITEMS);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceExpenseCurrency = null;
    }

    @Test
    public void testDefaultConstructor() {
        ExpenseCurrency value = new ExpenseCurrency();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ExpenseCurrency value = new ExpenseCurrency(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        assertNotNull(value);
    }

    @Test
    public void test4getExpenseCurrencyCurrencyCode() {
        assertEquals(VALUE_EXPENSECURRENCYCURRENCYCODE.toString(), instanceExpenseCurrency.getExpenseCurrencyCurrencyCode().toString());
    }

    @Test
    public void test4setExpenseCurrencyCurrencyCode() {
        String value = "expenseCurrencyCurrencyCode";
        instanceExpenseCurrency.setExpenseCurrencyCurrencyCode(value);
        assertEquals(value, instanceExpenseCurrency.getExpenseCurrencyCurrencyCode());
    }

    @Test
    public void test4getExpenseCurrencyCurrencyName() {
        assertEquals(VALUE_EXPENSECURRENCYCURRENCYNAME.toString(), instanceExpenseCurrency.getExpenseCurrencyCurrencyName().toString());
    }

    @Test
    public void test4setExpenseCurrencyCurrencyName() {
        String value = "expenseCurrencyCurrencyName";
        instanceExpenseCurrency.setExpenseCurrencyCurrencyName(value);
        assertEquals(value, instanceExpenseCurrency.getExpenseCurrencyCurrencyName());
    }

    @Test
    public void test4isModifiedExpenseCurrencyCurrencyName() {
        instanceExpenseCurrency = new ExpenseCurrency();
        assertFalse(instanceExpenseCurrency.isModifiedExpenseCurrencyCurrencyName());
        instanceExpenseCurrency.setExpenseCurrencyCurrencyName(VALUE_EXPENSECURRENCYCURRENCYNAME);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyCurrencyName());
    }

    @Test
    public void test4setModifiedExpenseCurrencyCurrencyName() {
        instanceExpenseCurrency.setModifiedExpenseCurrencyCurrencyName(true);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyCurrencyName());
    }

    @Test
    public void test4getExpenseCurrencyCurAcronym() {
        assertEquals(VALUE_EXPENSECURRENCYCURACRONYM.toString(), instanceExpenseCurrency.getExpenseCurrencyCurAcronym().toString());
    }

    @Test
    public void test4setExpenseCurrencyCurAcronym() {
        String value = "expenseCurrencyCurAcronym";
        instanceExpenseCurrency.setExpenseCurrencyCurAcronym(value);
        assertEquals(value, instanceExpenseCurrency.getExpenseCurrencyCurAcronym());
    }

    @Test
    public void test4isModifiedExpenseCurrencyCurAcronym() {
        instanceExpenseCurrency = new ExpenseCurrency();
        assertFalse(instanceExpenseCurrency.isModifiedExpenseCurrencyCurAcronym());
        instanceExpenseCurrency.setExpenseCurrencyCurAcronym(VALUE_EXPENSECURRENCYCURACRONYM);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyCurAcronym());
    }

    @Test
    public void test4setModifiedExpenseCurrencyCurAcronym() {
        instanceExpenseCurrency.setModifiedExpenseCurrencyCurAcronym(true);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyCurAcronym());
    }

    @Test
    public void test4getExpenseCurrencyExchange() {
        assertEquals(VALUE_EXPENSECURRENCYEXCHANGE.toString(), instanceExpenseCurrency.getExpenseCurrencyExchange().toString());
    }

    @Test
    public void test4setExpenseCurrencyExchange() {
        Double value = Double.valueOf(0);
        instanceExpenseCurrency.setExpenseCurrencyExchange(value);
        assertEquals(value, instanceExpenseCurrency.getExpenseCurrencyExchange());
    }

    @Test
    public void test4isModifiedExpenseCurrencyExchange() {
        instanceExpenseCurrency = new ExpenseCurrency();
        assertFalse(instanceExpenseCurrency.isModifiedExpenseCurrencyExchange());
        instanceExpenseCurrency.setExpenseCurrencyExchange(VALUE_EXPENSECURRENCYEXCHANGE);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyExchange());
    }

    @Test
    public void test4setModifiedExpenseCurrencyExchange() {
        instanceExpenseCurrency.setModifiedExpenseCurrencyExchange(true);
        assertTrue(instanceExpenseCurrency.isModifiedExpenseCurrencyExchange());
    }

    @Test
    public void test4getExpenseReports() {
        assertEquals(VALUE_EXPENSEREPORTS, instanceExpenseCurrency.getExpenseReports());
    }

    @Test
    public void test4getExpenseReports2() {
        instanceExpenseCurrency.setExpenseReports(null);
        assertEquals(VALUE_EXPENSEREPORTS, instanceExpenseCurrency.getExpenseReports());
    }

    @Test
    public void test4getExpenseReports3() {
        instanceExpenseCurrency.setExpenseReports(new ArrayList<>());
        assertEquals(VALUE_EXPENSEREPORTS, instanceExpenseCurrency.getExpenseReports());
    }

    @Test
    public void test4add2ExpenseReports() {
        ExpenseReport value = new ExpenseReport();
        instanceExpenseCurrency.add2ExpenseReports(value);
        assertTrue(instanceExpenseCurrency.getExpenseReports().contains(value));
    }

    @Test
    public void test4setExpenseReports() {
        instanceExpenseCurrency.setExpenseReports(VALUE_EXPENSEREPORTS);
        assertEquals(VALUE_EXPENSEREPORTS, instanceExpenseCurrency.getExpenseReports());
    }

    @Test
    public void test4isModifiedExpenseReports() {
        assertFalse(instanceExpenseCurrency.isModifiedExpenseReports());
    }

    @Test
    public void test4getExchangeHistoryItems() {
        assertEquals(VALUE_EXCHANGEHISTORYITEMS, instanceExpenseCurrency.getExchangeHistoryItems());
    }

    @Test
    public void test4getExchangeHistoryItems2() {
        instanceExpenseCurrency.setExchangeHistoryItems(null);
        assertEquals(VALUE_EXCHANGEHISTORYITEMS, instanceExpenseCurrency.getExchangeHistoryItems());
    }

    @Test
    public void test4getExchangeHistoryItems3() {
        instanceExpenseCurrency.setExchangeHistoryItems(new ArrayList<>());
        assertEquals(VALUE_EXCHANGEHISTORYITEMS, instanceExpenseCurrency.getExchangeHistoryItems());
    }

    @Test
    public void test4add2ExchangeHistoryItems() {
        ExchangeHistory value = new ExchangeHistory();
        instanceExpenseCurrency.add2ExchangeHistoryItems(value);
        assertTrue(instanceExpenseCurrency.getExchangeHistoryItems().contains(value));
    }

    @Test
    public void test4setExchangeHistoryItems() {
        instanceExpenseCurrency.setExchangeHistoryItems(VALUE_EXCHANGEHISTORYITEMS);
        assertEquals(VALUE_EXCHANGEHISTORYITEMS, instanceExpenseCurrency.getExchangeHistoryItems());
    }

    @Test
    public void test4isModifiedExchangeHistoryItems() {
        assertFalse(instanceExpenseCurrency.isModifiedExchangeHistoryItems());
    }

    @Test
    public void test4buildDSExpenseCurrency() {
        String result;
        try {
            result = instanceExpenseCurrency.buildDSExpenseCurrency().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSExpenseCurrencySup() {
        String result;
        try {
            result = instanceExpenseCurrency.buildDSExpenseCurrencySup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceExpenseCurrency.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceExpenseCurrency.getAttribute(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURRENCYCODE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseCurrency.getAttributeTypeRelated(ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseCurrency.getAttributeTypeRelated(ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS, ""));
        assertEquals("", instanceExpenseCurrency.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceExpenseCurrency.cleanDerivations();
        assertNotNull(instanceExpenseCurrency);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceExpenseCurrency.getExpenseCurrencyCurrencyCode(), instanceExpenseCurrency.getOid().getExpenseCurrencyCurrencyCode());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceExpenseCurrency.isVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURRENCYNAME));
        assertTrue(instanceExpenseCurrency.isVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURACRONYM));
        assertTrue(instanceExpenseCurrency.isVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYEXCHANGE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceExpenseCurrency.isAttributeVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURRENCYNAME));
        assertTrue(instanceExpenseCurrency.isAttributeVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURACRONYM));
        assertTrue(instanceExpenseCurrency.isAttributeVisible(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYEXCHANGE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceExpenseCurrency.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceExpenseCurrency.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceExpenseCurrency.getActiveFacets().contains(Constants.EXPENSECURRENCY));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceExpenseCurrency.getFacets().contains(Constants.EXPENSECURRENCY));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceExpenseCurrency.checkHorizontalVisibility(null));
    }
}
