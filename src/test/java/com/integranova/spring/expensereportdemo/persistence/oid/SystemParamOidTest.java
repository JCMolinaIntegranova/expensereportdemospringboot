package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SystemParamOidTest {

    private SystemParamOid instanceSystemParamOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_SYSTEMPARAMPARAMCODE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_SYSTEMPARAMPARAMCODE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_SYSTEMPARAMPARAMCODE);
    }

    @Before
    public void setUp() {
        instanceSystemParamOid = new SystemParamOid();
        instanceSystemParamOid.setSystemParamparamCode(VALUE_SYSTEMPARAMPARAMCODE);
    }

    @After
    public void tearDown() {
        instanceSystemParamOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceSystemParamOid = new SystemParamOid();
        assertNotNull(instanceSystemParamOid);
    }

    @Test
    public void testConstructor() {
        instanceSystemParamOid = new SystemParamOid(VALUE_SYSTEMPARAMPARAMCODE);
        assertNotNull(instanceSystemParamOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_SYSTEMPARAMPARAMCODE);
        instanceSystemParamOid = new SystemParamOid(oidFields);
        assertNotNull(instanceSystemParamOid);
    }

    @Test
    public void test4getSystemParamparamCode() {
        assertEquals(VALUE_SYSTEMPARAMPARAMCODE.toString(), instanceSystemParamOid.getSystemParamparamCode().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceSystemParamOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceSystemParamOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceSystemParamOid.equals(instanceSystemParamOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceSystemParamOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceSystemParamOid.setSystemParamparamCode(null);
        assertTrue(instanceSystemParamOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(SystemParamConstants.CLASS_NAME, instanceSystemParamOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceSystemParamOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceSystemParamOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMCODE + "\" : " + "'" + instanceSystemParamOid.getSystemParamparamCode() + "'";
        jsonString += "}";
        instanceSystemParamOid.fromJsonString(jsonString);
        assertNotNull(instanceSystemParamOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceSystemParamOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMCODE, instanceSystemParamOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceSystemParamOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceSystemParamOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceSystemParamOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceSystemParamOid.compareToRS(values));
    }
}
