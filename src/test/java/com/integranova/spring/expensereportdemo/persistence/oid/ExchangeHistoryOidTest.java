package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeHistoryOidTest {

    private ExchangeHistoryOid instanceExchangeHistoryOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_EXPENSECURRENCYCURRENCYCODE;
    private static Date VALUE_EXCHANGEHISTORYENTRYDATE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EXPENSECURRENCYCURRENCYCODE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSECURRENCYCURRENCYCODE);
        VALUE_EXCHANGEHISTORYENTRYDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_ARRAYLISTVALUES.add(VALUE_EXCHANGEHISTORYENTRYDATE);
    }

    @Before
    public void setUp() {
        instanceExchangeHistoryOid = new ExchangeHistoryOid();
        instanceExchangeHistoryOid.setExpenseCurrencyCurrencyCode(VALUE_EXPENSECURRENCYCURRENCYCODE);
        instanceExchangeHistoryOid.setExchangeHistoryentryDate(VALUE_EXCHANGEHISTORYENTRYDATE);
    }

    @After
    public void tearDown() {
        instanceExchangeHistoryOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceExchangeHistoryOid = new ExchangeHistoryOid();
        assertNotNull(instanceExchangeHistoryOid);
    }

    @Test
    public void testConstructor() {
        instanceExchangeHistoryOid = new ExchangeHistoryOid(VALUE_EXPENSECURRENCYCURRENCYCODE, VALUE_EXCHANGEHISTORYENTRYDATE);
        assertNotNull(instanceExchangeHistoryOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EXPENSECURRENCYCURRENCYCODE);
        oidFields.add(VALUE_EXCHANGEHISTORYENTRYDATE);
        instanceExchangeHistoryOid = new ExchangeHistoryOid(oidFields);
        assertNotNull(instanceExchangeHistoryOid);
    }

    @Test
    public void test4getExpenseCurrencyCurrencyCode() {
        assertEquals(VALUE_EXPENSECURRENCYCURRENCYCODE.toString(), instanceExchangeHistoryOid.getExpenseCurrencyCurrencyCode().toString());
    }

    @Test
    public void test4getExchangeHistoryentryDate() {
        assertEquals(VALUE_EXCHANGEHISTORYENTRYDATE.toString(), instanceExchangeHistoryOid.getExchangeHistoryentryDate().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceExchangeHistoryOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceExchangeHistoryOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceExchangeHistoryOid.equals(instanceExchangeHistoryOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceExchangeHistoryOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceExchangeHistoryOid.setExpenseCurrencyCurrencyCode(null);
        instanceExchangeHistoryOid.setExchangeHistoryentryDate(null);
        assertTrue(instanceExchangeHistoryOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ExchangeHistoryConstants.CLASS_NAME, instanceExchangeHistoryOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceExchangeHistoryOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceExchangeHistoryOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ExchangeHistoryConstants.ATTR_NAME_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE + "\" : " + "'" + instanceExchangeHistoryOid.getExpenseCurrencyCurrencyCode() + "'";
        jsonString += ", ";
        jsonString += "\"" + ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYENTRYDATE + "\" : " + instanceExchangeHistoryOid.getExchangeHistoryentryDate().toString();
        jsonString += "}";
        instanceExchangeHistoryOid.fromJsonString(jsonString);
        assertNotNull(instanceExchangeHistoryOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceExchangeHistoryOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ExchangeHistoryConstants.ATTR_NAME_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE, instanceExchangeHistoryOid.getKeys()[0]);
        assertEquals(ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYENTRYDATE, instanceExchangeHistoryOid.getKeys()[1]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExchangeHistoryOid.getDataTypes()[0]);
        assertEquals(Constants.Type.DATE.getTypeName(), instanceExchangeHistoryOid.getDataTypes()[1]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceExchangeHistoryOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceExchangeHistoryOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        values[1] = null;
        assertTrue(instanceExchangeHistoryOid.compareToRS(values));
    }
}
