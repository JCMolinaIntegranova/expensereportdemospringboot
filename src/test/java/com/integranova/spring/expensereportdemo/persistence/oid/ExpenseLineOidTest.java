package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseLineOidTest {

    private ExpenseLineOid instanceExpenseLineOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_EXPENSEREPORTIDEXPENSEREPOR;
    private static Long VALUE_EXPENSELINEIDEXPENSELINE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EXPENSEREPORTIDEXPENSEREPOR = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        VALUE_EXPENSELINEIDEXPENSELINE = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSELINEIDEXPENSELINE);
    }

    @Before
    public void setUp() {
        instanceExpenseLineOid = new ExpenseLineOid();
        instanceExpenseLineOid.setExpenseReportidExpenseRepor(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        instanceExpenseLineOid.setExpenseLineidExpenseLine(VALUE_EXPENSELINEIDEXPENSELINE);
    }

    @After
    public void tearDown() {
        instanceExpenseLineOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceExpenseLineOid = new ExpenseLineOid();
        assertNotNull(instanceExpenseLineOid);
    }

    @Test
    public void testConstructor() {
        instanceExpenseLineOid = new ExpenseLineOid(VALUE_EXPENSEREPORTIDEXPENSEREPOR, VALUE_EXPENSELINEIDEXPENSELINE);
        assertNotNull(instanceExpenseLineOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        oidFields.add(VALUE_EXPENSELINEIDEXPENSELINE);
        instanceExpenseLineOid = new ExpenseLineOid(oidFields);
        assertNotNull(instanceExpenseLineOid);
    }

    @Test
    public void test4getExpenseReportidExpenseRepor() {
        assertEquals(VALUE_EXPENSEREPORTIDEXPENSEREPOR.toString(), instanceExpenseLineOid.getExpenseReportidExpenseRepor().toString());
    }

    @Test
    public void test4getExpenseLineidExpenseLine() {
        assertEquals(VALUE_EXPENSELINEIDEXPENSELINE.toString(), instanceExpenseLineOid.getExpenseLineidExpenseLine().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceExpenseLineOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceExpenseLineOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceExpenseLineOid.equals(instanceExpenseLineOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceExpenseLineOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceExpenseLineOid.setExpenseReportidExpenseRepor(null);
        instanceExpenseLineOid.setExpenseLineidExpenseLine(null);
        assertTrue(instanceExpenseLineOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ExpenseLineConstants.CLASS_NAME, instanceExpenseLineOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceExpenseLineOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceExpenseLineOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ExpenseLineConstants.ATTR_NAME_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR + "\" : " + instanceExpenseLineOid.getExpenseReportidExpenseRepor().toString();
        jsonString += ", ";
        jsonString += "\"" + ExpenseLineConstants.ATTR_NAME_EXPENSELINEIDEXPENSELINE + "\" : " + instanceExpenseLineOid.getExpenseLineidExpenseLine().toString();
        jsonString += "}";
        instanceExpenseLineOid.fromJsonString(jsonString);
        assertNotNull(instanceExpenseLineOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceExpenseLineOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ExpenseLineConstants.ATTR_NAME_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR, instanceExpenseLineOid.getKeys()[0]);
        assertEquals(ExpenseLineConstants.ATTR_NAME_EXPENSELINEIDEXPENSELINE, instanceExpenseLineOid.getKeys()[1]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceExpenseLineOid.getDataTypes()[0]);
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceExpenseLineOid.getDataTypes()[1]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceExpenseLineOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceExpenseLineOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        values[1] = null;
        assertTrue(instanceExpenseLineOid.compareToRS(values));
    }
}
