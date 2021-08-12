package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentOidTest {

    private AssignmentOid instanceAssignmentOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_ASSIGNMENTASSIGNMENTID;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_ASSIGNMENTASSIGNMENTID = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_ASSIGNMENTASSIGNMENTID);
    }

    @Before
    public void setUp() {
        instanceAssignmentOid = new AssignmentOid();
        instanceAssignmentOid.setAssignmentAssignmentID(VALUE_ASSIGNMENTASSIGNMENTID);
    }

    @After
    public void tearDown() {
        instanceAssignmentOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceAssignmentOid = new AssignmentOid();
        assertNotNull(instanceAssignmentOid);
    }

    @Test
    public void testConstructor() {
        instanceAssignmentOid = new AssignmentOid(VALUE_ASSIGNMENTASSIGNMENTID);
        assertNotNull(instanceAssignmentOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_ASSIGNMENTASSIGNMENTID);
        instanceAssignmentOid = new AssignmentOid(oidFields);
        assertNotNull(instanceAssignmentOid);
    }

    @Test
    public void test4getAssignmentAssignmentID() {
        assertEquals(VALUE_ASSIGNMENTASSIGNMENTID.toString(), instanceAssignmentOid.getAssignmentAssignmentID().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceAssignmentOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceAssignmentOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceAssignmentOid.equals(instanceAssignmentOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceAssignmentOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceAssignmentOid.setAssignmentAssignmentID(null);
        assertTrue(instanceAssignmentOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(AssignmentConstants.CLASS_NAME, instanceAssignmentOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceAssignmentOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceAssignmentOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + AssignmentConstants.ATTR_NAME_ASSIGNMENTASSIGNMENTID + "\" : " + instanceAssignmentOid.getAssignmentAssignmentID().toString();
        jsonString += "}";
        instanceAssignmentOid.fromJsonString(jsonString);
        assertNotNull(instanceAssignmentOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceAssignmentOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(AssignmentConstants.ATTR_NAME_ASSIGNMENTASSIGNMENTID, instanceAssignmentOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceAssignmentOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceAssignmentOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceAssignmentOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceAssignmentOid.compareToRS(values));
    }
}
