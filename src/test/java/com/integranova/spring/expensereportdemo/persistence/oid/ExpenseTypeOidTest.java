package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseTypeOidTest {

    private ExpenseTypeOid instanceExpenseTypeOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_EXPENSETYPETYPECODE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EXPENSETYPETYPECODE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_EXPENSETYPETYPECODE);
    }

    @Before
    public void setUp() {
        instanceExpenseTypeOid = new ExpenseTypeOid();
        instanceExpenseTypeOid.setExpenseTypeTypeCode(VALUE_EXPENSETYPETYPECODE);
    }

    @After
    public void tearDown() {
        instanceExpenseTypeOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceExpenseTypeOid = new ExpenseTypeOid();
        assertNotNull(instanceExpenseTypeOid);
    }

    @Test
    public void testConstructor() {
        instanceExpenseTypeOid = new ExpenseTypeOid(VALUE_EXPENSETYPETYPECODE);
        assertNotNull(instanceExpenseTypeOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EXPENSETYPETYPECODE);
        instanceExpenseTypeOid = new ExpenseTypeOid(oidFields);
        assertNotNull(instanceExpenseTypeOid);
    }

    @Test
    public void test4getExpenseTypeTypeCode() {
        assertEquals(VALUE_EXPENSETYPETYPECODE.toString(), instanceExpenseTypeOid.getExpenseTypeTypeCode().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceExpenseTypeOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceExpenseTypeOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceExpenseTypeOid.equals(instanceExpenseTypeOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceExpenseTypeOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceExpenseTypeOid.setExpenseTypeTypeCode(null);
        assertTrue(instanceExpenseTypeOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ExpenseTypeConstants.CLASS_NAME, instanceExpenseTypeOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceExpenseTypeOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceExpenseTypeOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYPECODE + "\" : " + "'" + instanceExpenseTypeOid.getExpenseTypeTypeCode() + "'";
        jsonString += "}";
        instanceExpenseTypeOid.fromJsonString(jsonString);
        assertNotNull(instanceExpenseTypeOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceExpenseTypeOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYPECODE, instanceExpenseTypeOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseTypeOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceExpenseTypeOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceExpenseTypeOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceExpenseTypeOid.compareToRS(values));
    }
}
