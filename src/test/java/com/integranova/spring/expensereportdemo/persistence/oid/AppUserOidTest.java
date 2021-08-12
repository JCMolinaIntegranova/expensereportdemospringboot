package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.AppUserConstants;
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
public class AppUserOidTest {

    private AppUserOid instanceAppUserOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_APPUSERLOGIN;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_APPUSERLOGIN = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_APPUSERLOGIN);
    }

    @Before
    public void setUp() {
        instanceAppUserOid = new AppUserOid();
        instanceAppUserOid.setAppUserLogin(VALUE_APPUSERLOGIN);
    }

    @After
    public void tearDown() {
        instanceAppUserOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceAppUserOid = new AppUserOid();
        assertNotNull(instanceAppUserOid);
    }

    @Test
    public void testConstructor() {
        instanceAppUserOid = new AppUserOid(VALUE_APPUSERLOGIN);
        assertNotNull(instanceAppUserOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_APPUSERLOGIN);
        instanceAppUserOid = new AppUserOid(oidFields);
        assertNotNull(instanceAppUserOid);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceAppUserOid.getAppUserLogin().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceAppUserOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceAppUserOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceAppUserOid.equals(instanceAppUserOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceAppUserOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceAppUserOid.setAppUserLogin(null);
        assertTrue(instanceAppUserOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(AppUserConstants.CLASS_NAME, instanceAppUserOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceAppUserOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceAppUserOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + AppUserConstants.ATTR_NAME_APPUSERLOGIN + "\" : " + "'" + instanceAppUserOid.getAppUserLogin() + "'";
        jsonString += "}";
        instanceAppUserOid.fromJsonString(jsonString);
        assertNotNull(instanceAppUserOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceAppUserOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(AppUserConstants.ATTR_NAME_APPUSERLOGIN, instanceAppUserOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceAppUserOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceAppUserOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceAppUserOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceAppUserOid.compareToRS(values));
    }
}
