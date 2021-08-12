package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseReportOidTest {

    private ExpenseReportOid instanceExpenseReportOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_EXPENSEREPORTIDEXPENSEREPOR;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EXPENSEREPORTIDEXPENSEREPOR = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
    }

    @Before
    public void setUp() {
        instanceExpenseReportOid = new ExpenseReportOid();
        instanceExpenseReportOid.setExpenseReportidExpenseRepor(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
    }

    @After
    public void tearDown() {
        instanceExpenseReportOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceExpenseReportOid = new ExpenseReportOid();
        assertNotNull(instanceExpenseReportOid);
    }

    @Test
    public void testConstructor() {
        instanceExpenseReportOid = new ExpenseReportOid(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        assertNotNull(instanceExpenseReportOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        instanceExpenseReportOid = new ExpenseReportOid(oidFields);
        assertNotNull(instanceExpenseReportOid);
    }

    @Test
    public void test4getExpenseReportidExpenseRepor() {
        assertEquals(VALUE_EXPENSEREPORTIDEXPENSEREPOR.toString(), instanceExpenseReportOid.getExpenseReportidExpenseRepor().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceExpenseReportOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceExpenseReportOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceExpenseReportOid.equals(instanceExpenseReportOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceExpenseReportOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceExpenseReportOid.setExpenseReportidExpenseRepor(null);
        assertTrue(instanceExpenseReportOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ExpenseReportConstants.CLASS_NAME, instanceExpenseReportOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceExpenseReportOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceExpenseReportOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR + "\" : " + instanceExpenseReportOid.getExpenseReportidExpenseRepor().toString();
        jsonString += "}";
        instanceExpenseReportOid.fromJsonString(jsonString);
        assertNotNull(instanceExpenseReportOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceExpenseReportOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR, instanceExpenseReportOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceExpenseReportOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceExpenseReportOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceExpenseReportOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceExpenseReportOid.compareToRS(values));
    }
}
