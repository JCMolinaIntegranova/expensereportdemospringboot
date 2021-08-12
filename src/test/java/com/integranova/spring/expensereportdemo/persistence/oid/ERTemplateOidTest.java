package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERTemplateOidTest {

    private ERTemplateOid instanceERTemplateOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_ERTEMPLATEID;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_ERTEMPLATEID = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_ERTEMPLATEID);
    }

    @Before
    public void setUp() {
        instanceERTemplateOid = new ERTemplateOid();
        instanceERTemplateOid.setERTemplateid(VALUE_ERTEMPLATEID);
    }

    @After
    public void tearDown() {
        instanceERTemplateOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceERTemplateOid = new ERTemplateOid();
        assertNotNull(instanceERTemplateOid);
    }

    @Test
    public void testConstructor() {
        instanceERTemplateOid = new ERTemplateOid(VALUE_ERTEMPLATEID);
        assertNotNull(instanceERTemplateOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_ERTEMPLATEID);
        instanceERTemplateOid = new ERTemplateOid(oidFields);
        assertNotNull(instanceERTemplateOid);
    }

    @Test
    public void test4getERTemplateid() {
        assertEquals(VALUE_ERTEMPLATEID.toString(), instanceERTemplateOid.getERTemplateid().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceERTemplateOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceERTemplateOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceERTemplateOid.equals(instanceERTemplateOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceERTemplateOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceERTemplateOid.setERTemplateid(null);
        assertTrue(instanceERTemplateOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ERTemplateConstants.CLASS_NAME, instanceERTemplateOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceERTemplateOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceERTemplateOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ERTemplateConstants.ATTR_NAME_ERTEMPLATEID + "\" : " + instanceERTemplateOid.getERTemplateid().toString();
        jsonString += "}";
        instanceERTemplateOid.fromJsonString(jsonString);
        assertNotNull(instanceERTemplateOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceERTemplateOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ERTemplateConstants.ATTR_NAME_ERTEMPLATEID, instanceERTemplateOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceERTemplateOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceERTemplateOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceERTemplateOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceERTemplateOid.compareToRS(values));
    }
}
