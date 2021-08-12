package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeOidTest {

    private EmployeeOid instanceEmployeeOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_EMPLOYEEIDEMPLOYEE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_EMPLOYEEIDEMPLOYEE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_EMPLOYEEIDEMPLOYEE);
    }

    @Before
    public void setUp() {
        instanceEmployeeOid = new EmployeeOid();
        instanceEmployeeOid.setEmployeeidEmployee(VALUE_EMPLOYEEIDEMPLOYEE);
    }

    @After
    public void tearDown() {
        instanceEmployeeOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceEmployeeOid = new EmployeeOid();
        assertNotNull(instanceEmployeeOid);
    }

    @Test
    public void testConstructor() {
        instanceEmployeeOid = new EmployeeOid(VALUE_EMPLOYEEIDEMPLOYEE);
        assertNotNull(instanceEmployeeOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_EMPLOYEEIDEMPLOYEE);
        instanceEmployeeOid = new EmployeeOid(oidFields);
        assertNotNull(instanceEmployeeOid);
    }

    @Test
    public void test4getEmployeeidEmployee() {
        assertEquals(VALUE_EMPLOYEEIDEMPLOYEE.toString(), instanceEmployeeOid.getEmployeeidEmployee().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceEmployeeOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceEmployeeOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceEmployeeOid.equals(instanceEmployeeOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceEmployeeOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceEmployeeOid.setEmployeeidEmployee(null);
        assertTrue(instanceEmployeeOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(EmployeeConstants.CLASS_NAME, instanceEmployeeOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceEmployeeOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceEmployeeOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + EmployeeConstants.ATTR_NAME_EMPLOYEEIDEMPLOYEE + "\" : " + "'" + instanceEmployeeOid.getEmployeeidEmployee() + "'";
        jsonString += "}";
        instanceEmployeeOid.fromJsonString(jsonString);
        assertNotNull(instanceEmployeeOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceEmployeeOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(EmployeeConstants.ATTR_NAME_EMPLOYEEIDEMPLOYEE, instanceEmployeeOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceEmployeeOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceEmployeeOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceEmployeeOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceEmployeeOid.compareToRS(values));
    }
}
