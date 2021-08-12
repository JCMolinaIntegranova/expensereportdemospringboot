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
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeHistoryTest {

    private static ExpenseCurrencyJpaRepository mockExpenseCurrencyJpaRepository;

    private static Agent mockAgent;

    ExchangeHistory instanceExchangeHistory;
    private static String VALUE_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE;
    private static Date VALUE_EXCHANGEHISTORYENTRYDATE;
    private static Double VALUE_EXCHANGEHISTORYOLDVALUE;
    private static Double VALUE_EXCHANGEHISTORYNEWVALUE;
    private static ExpenseCurrency VALUE_EXPENSECURRENCY;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
        VALUE_EXCHANGEHISTORYENTRYDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_EXCHANGEHISTORYOLDVALUE = Double.valueOf(0);
        VALUE_EXCHANGEHISTORYNEWVALUE = Double.valueOf(0);
        VALUE_EXPENSECURRENCY = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        mockExpenseCurrencyJpaRepository = mock(ExpenseCurrencyJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceExchangeHistory = new ExchangeHistory();
        instanceExchangeHistory.setExpenseCurrencyRepository(mockExpenseCurrencyJpaRepository);
        instanceExchangeHistory.setAgent(mockAgent);
        instanceExchangeHistory.setExpenseCurrencyCurrencyCode(VALUE_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE);
        instanceExchangeHistory.setExchangeHistoryentryDate(VALUE_EXCHANGEHISTORYENTRYDATE);
        instanceExchangeHistory.setExchangeHistoryoldValue(VALUE_EXCHANGEHISTORYOLDVALUE);
        instanceExchangeHistory.setExchangeHistorynewValue(VALUE_EXCHANGEHISTORYNEWVALUE);
        instanceExchangeHistory.add2ExpenseCurrency(VALUE_EXPENSECURRENCY);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceExchangeHistory = null;
    }

    @Test
    public void testDefaultConstructor() {
        ExchangeHistory value = new ExchangeHistory();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ExchangeHistory value = new ExchangeHistory(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ExchangeHistory value = new ExchangeHistory(new ExchangeHistoryOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ExchangeHistory value = new ExchangeHistory(new ExchangeHistoryOid("expenseCurrencyCurrencyCode", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        assertNotNull(value);
    }

    @Test
    public void test4getExpenseCurrencyCurrencyCode() {
        assertEquals(VALUE_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE.toString(), instanceExchangeHistory.getExpenseCurrencyCurrencyCode().toString());
    }

    @Test
    public void test4setExpenseCurrencyCurrencyCode() {
        String value = "expenseCurrencyCurrencyCode";
        instanceExchangeHistory.setExpenseCurrencyCurrencyCode(value);
        assertEquals(value, instanceExchangeHistory.getExpenseCurrencyCurrencyCode());
    }

    @Test
    public void test4getExchangeHistoryentryDate() {
        assertEquals(VALUE_EXCHANGEHISTORYENTRYDATE.toString(), instanceExchangeHistory.getExchangeHistoryentryDate().toString());
    }

    @Test
    public void test4setExchangeHistoryentryDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceExchangeHistory.setExchangeHistoryentryDate(value);
        assertEquals(value, instanceExchangeHistory.getExchangeHistoryentryDate());
    }

    @Test
    public void test4getExchangeHistoryoldValue() {
        assertEquals(VALUE_EXCHANGEHISTORYOLDVALUE.toString(), instanceExchangeHistory.getExchangeHistoryoldValue().toString());
    }

    @Test
    public void test4setExchangeHistoryoldValue() {
        Double value = Double.valueOf(0);
        instanceExchangeHistory.setExchangeHistoryoldValue(value);
        assertEquals(value, instanceExchangeHistory.getExchangeHistoryoldValue());
    }

    @Test
    public void test4isModifiedExchangeHistoryoldValue() {
        instanceExchangeHistory = new ExchangeHistory();
        assertFalse(instanceExchangeHistory.isModifiedExchangeHistoryoldValue());
        instanceExchangeHistory.setExchangeHistoryoldValue(VALUE_EXCHANGEHISTORYOLDVALUE);
        assertTrue(instanceExchangeHistory.isModifiedExchangeHistoryoldValue());
    }

    @Test
    public void test4setModifiedExchangeHistoryoldValue() {
        instanceExchangeHistory.setModifiedExchangeHistoryoldValue(true);
        assertTrue(instanceExchangeHistory.isModifiedExchangeHistoryoldValue());
    }

    @Test
    public void test4getExchangeHistorynewValue() {
        assertEquals(VALUE_EXCHANGEHISTORYNEWVALUE.toString(), instanceExchangeHistory.getExchangeHistorynewValue().toString());
    }

    @Test
    public void test4setExchangeHistorynewValue() {
        Double value = Double.valueOf(0);
        instanceExchangeHistory.setExchangeHistorynewValue(value);
        assertEquals(value, instanceExchangeHistory.getExchangeHistorynewValue());
    }

    @Test
    public void test4isModifiedExchangeHistorynewValue() {
        instanceExchangeHistory = new ExchangeHistory();
        assertFalse(instanceExchangeHistory.isModifiedExchangeHistorynewValue());
        instanceExchangeHistory.setExchangeHistorynewValue(VALUE_EXCHANGEHISTORYNEWVALUE);
        assertTrue(instanceExchangeHistory.isModifiedExchangeHistorynewValue());
    }

    @Test
    public void test4setModifiedExchangeHistorynewValue() {
        instanceExchangeHistory.setModifiedExchangeHistorynewValue(true);
        assertTrue(instanceExchangeHistory.isModifiedExchangeHistorynewValue());
    }

    @Test
    public void test4getExpenseCurrency() {
        assertEquals(VALUE_EXPENSECURRENCY, instanceExchangeHistory.getExpenseCurrency());
    }

    @Test
    public void test4getExpenseCurrency2() {
        instanceExchangeHistory.add2ExpenseCurrency(null);
        assertTrue(instanceExchangeHistory.getExpenseCurrency().isNull());
    }

    @Test
    public void test4getExpenseCurrency3() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        instanceExchangeHistory.add2ExpenseCurrency(value);
        assertEquals(value, instanceExchangeHistory.getExpenseCurrency());
    }

    @Test
    public void test4add2ExpenseCurrency() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        instanceExchangeHistory.add2ExpenseCurrency(value);
        assertEquals(value, instanceExchangeHistory.getExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrency() {
        instanceExchangeHistory.add2ExpenseCurrency(VALUE_EXPENSECURRENCY);
        assertEquals(VALUE_EXPENSECURRENCY, instanceExchangeHistory.getExpenseCurrency());
    }

    @Test
    public void test4isModifiedExpenseCurrency() {
        assertFalse(instanceExchangeHistory.isModifiedExpenseCurrency());
    }

    @Test
    public void test4getValues() {
        assertNotNull(instanceExchangeHistory.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceExchangeHistory.getAttribute(ExchangeHistoryConstants.ATTR_NAME_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE));
        assertNull(instanceExchangeHistory.getAttribute(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYENTRYDATE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExchangeHistory.getAttributeTypeRelated(ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY, ""));
        assertEquals("", instanceExchangeHistory.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceExchangeHistory.cleanDerivations();
        assertNotNull(instanceExchangeHistory);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceExchangeHistory.getExpenseCurrencyCurrencyCode(), instanceExchangeHistory.getOid().getExpenseCurrencyCurrencyCode());
        assertEquals(instanceExchangeHistory.getExchangeHistoryentryDate(), instanceExchangeHistory.getOid().getExchangeHistoryentryDate());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceExchangeHistory.isVisible(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYOLDVALUE));
        assertTrue(instanceExchangeHistory.isVisible(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYNEWVALUE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceExchangeHistory.isAttributeVisible(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYOLDVALUE));
        assertTrue(instanceExchangeHistory.isAttributeVisible(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYNEWVALUE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceExchangeHistory.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceExchangeHistory.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceExchangeHistory.getActiveFacets().contains(Constants.EXCHANGEHISTORY));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceExchangeHistory.getFacets().contains(Constants.EXCHANGEHISTORY));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceExchangeHistory.checkHorizontalVisibility(null));
    }
}
