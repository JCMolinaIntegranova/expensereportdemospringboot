package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseCurrencyOidTest {

    private ExpenseCurrencyOid instanceExpenseCurrencyOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_EXPENSECURRENCYCURRENCYCODE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EXPENSECURRENCYCURRENCYCODE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSECURRENCYCURRENCYCODE);
    }

    @Before
    public void setUp() {
        instanceExpenseCurrencyOid = new ExpenseCurrencyOid();
        instanceExpenseCurrencyOid.setExpenseCurrencyCurrencyCode(VALUE_EXPENSECURRENCYCURRENCYCODE);
    }

    @After
    public void tearDown() {
        instanceExpenseCurrencyOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceExpenseCurrencyOid = new ExpenseCurrencyOid();
        assertNotNull(instanceExpenseCurrencyOid);
    }

    @Test
    public void testConstructor() {
        instanceExpenseCurrencyOid = new ExpenseCurrencyOid(VALUE_EXPENSECURRENCYCURRENCYCODE);
        assertNotNull(instanceExpenseCurrencyOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EXPENSECURRENCYCURRENCYCODE);
        instanceExpenseCurrencyOid = new ExpenseCurrencyOid(oidFields);
        assertNotNull(instanceExpenseCurrencyOid);
    }

    @Test
    public void test4getExpenseCurrencyCurrencyCode() {
        assertEquals(VALUE_EXPENSECURRENCYCURRENCYCODE.toString(), instanceExpenseCurrencyOid.getExpenseCurrencyCurrencyCode().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceExpenseCurrencyOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceExpenseCurrencyOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceExpenseCurrencyOid.equals(instanceExpenseCurrencyOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceExpenseCurrencyOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceExpenseCurrencyOid.setExpenseCurrencyCurrencyCode(null);
        assertTrue(instanceExpenseCurrencyOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ExpenseCurrencyConstants.CLASS_NAME, instanceExpenseCurrencyOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceExpenseCurrencyOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceExpenseCurrencyOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURRENCYCODE + "\" : " + "'" + instanceExpenseCurrencyOid.getExpenseCurrencyCurrencyCode() + "'";
        jsonString += "}";
        instanceExpenseCurrencyOid.fromJsonString(jsonString);
        assertNotNull(instanceExpenseCurrencyOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceExpenseCurrencyOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURRENCYCODE, instanceExpenseCurrencyOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseCurrencyOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceExpenseCurrencyOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceExpenseCurrencyOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceExpenseCurrencyOid.compareToRS(values));
    }
}
