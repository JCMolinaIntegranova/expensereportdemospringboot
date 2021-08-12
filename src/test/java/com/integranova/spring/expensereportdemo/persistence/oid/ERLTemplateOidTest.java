package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERLTemplateOidTest {

    private ERLTemplateOid instanceERLTemplateOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_ERTEMPLATETEMPLATEID;
    private static Long VALUE_ERLTEMPLATEID;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_ERTEMPLATETEMPLATEID = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_ERTEMPLATETEMPLATEID);
        VALUE_ERLTEMPLATEID = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_ERLTEMPLATEID);
    }

    @Before
    public void setUp() {
        instanceERLTemplateOid = new ERLTemplateOid();
        instanceERLTemplateOid.setERTemplateTemplateid(VALUE_ERTEMPLATETEMPLATEID);
        instanceERLTemplateOid.setERLTemplateid(VALUE_ERLTEMPLATEID);
    }

    @After
    public void tearDown() {
        instanceERLTemplateOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceERLTemplateOid = new ERLTemplateOid();
        assertNotNull(instanceERLTemplateOid);
    }

    @Test
    public void testConstructor() {
        instanceERLTemplateOid = new ERLTemplateOid(VALUE_ERTEMPLATETEMPLATEID, VALUE_ERLTEMPLATEID);
        assertNotNull(instanceERLTemplateOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_ERTEMPLATETEMPLATEID);
        oidFields.add(VALUE_ERLTEMPLATEID);
        instanceERLTemplateOid = new ERLTemplateOid(oidFields);
        assertNotNull(instanceERLTemplateOid);
    }

    @Test
    public void test4getERTemplateTemplateid() {
        assertEquals(VALUE_ERTEMPLATETEMPLATEID.toString(), instanceERLTemplateOid.getERTemplateTemplateid().toString());
    }

    @Test
    public void test4getERLTemplateid() {
        assertEquals(VALUE_ERLTEMPLATEID.toString(), instanceERLTemplateOid.getERLTemplateid().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceERLTemplateOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceERLTemplateOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceERLTemplateOid.equals(instanceERLTemplateOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceERLTemplateOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceERLTemplateOid.setERTemplateTemplateid(null);
        instanceERLTemplateOid.setERLTemplateid(null);
        assertTrue(instanceERLTemplateOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(ERLTemplateConstants.CLASS_NAME, instanceERLTemplateOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceERLTemplateOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceERLTemplateOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + ERLTemplateConstants.ATTR_NAME_TEMPLATE_ERTEMPLATEID + "\" : " + instanceERLTemplateOid.getERTemplateTemplateid().toString();
        jsonString += ", ";
        jsonString += "\"" + ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEID + "\" : " + instanceERLTemplateOid.getERLTemplateid().toString();
        jsonString += "}";
        instanceERLTemplateOid.fromJsonString(jsonString);
        assertNotNull(instanceERLTemplateOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceERLTemplateOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(ERLTemplateConstants.ATTR_NAME_TEMPLATE_ERTEMPLATEID, instanceERLTemplateOid.getKeys()[0]);
        assertEquals(ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEID, instanceERLTemplateOid.getKeys()[1]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceERLTemplateOid.getDataTypes()[0]);
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceERLTemplateOid.getDataTypes()[1]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceERLTemplateOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceERLTemplateOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        values[1] = null;
        assertTrue(instanceERLTemplateOid.compareToRS(values));
    }
}
