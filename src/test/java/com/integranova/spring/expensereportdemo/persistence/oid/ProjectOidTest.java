package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectOidTest {

    private ProjectOid instanceProjectOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_PROJECTIDPROJECT;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_PROJECTIDPROJECT = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_PROJECTIDPROJECT);
    }

    @Before
    public void setUp() {
        instanceProjectOid = new ProjectOid();
        instanceProjectOid.setProjectidProject(VALUE_PROJECTIDPROJECT);
    }

    @After
    public void tearDown() {
        instanceProjectOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceProjectOid = new ProjectOid();
        assertNotNull(instanceProjectOid);
    }

    @Test
    public void testConstructor() {
        instanceProjectOid = new ProjectOid(VALUE_PROJECTIDPROJECT);
        assertNotNull(instanceProjectOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_PROJECTIDPROJECT);
        instanceProjectOid = new ProjectOid(oidFields);
        assertNotNull(instanceProjectOid);
    }

    @Test
    public void test4getProjectidProject() {
        assertEquals(VALUE_PROJECTIDPROJECT.toString(), instanceProjectOid.getProjectidProject().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceProjectOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceProjectOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceProjectOid.equals(instanceProjectOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceProjectOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceProjectOid.setProjectidProject(null);
        assertTrue(instanceProjectOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ProjectConstants.CLASS_NAME, instanceProjectOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceProjectOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceProjectOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ProjectConstants.ATTR_NAME_PROJECTIDPROJECT + "\" : " + instanceProjectOid.getProjectidProject().toString();
        jsonString += "}";
        instanceProjectOid.fromJsonString(jsonString);
        assertNotNull(instanceProjectOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceProjectOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ProjectConstants.ATTR_NAME_PROJECTIDPROJECT, instanceProjectOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceProjectOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceProjectOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceProjectOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceProjectOid.compareToRS(values));
    }
}
