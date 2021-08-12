package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
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
public class AdminUserOidTest {

    private AdminUserOid instanceAdminUserOid;

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
        instanceAdminUserOid = new AdminUserOid();
        instanceAdminUserOid.setAppUserLogin(VALUE_APPUSERLOGIN);
    }

    @After
    public void tearDown() {
        instanceAdminUserOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceAdminUserOid = new AdminUserOid();
        assertNotNull(instanceAdminUserOid);
    }

    @Test
    public void testConstructor() {
        instanceAdminUserOid = new AdminUserOid(VALUE_APPUSERLOGIN);
        assertNotNull(instanceAdminUserOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_APPUSERLOGIN);
        instanceAdminUserOid = new AdminUserOid(oidFields);
        assertNotNull(instanceAdminUserOid);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceAdminUserOid.getAppUserLogin().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceAdminUserOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceAdminUserOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceAdminUserOid.equals(instanceAdminUserOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceAdminUserOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceAdminUserOid.setAppUserLogin(null);
        assertTrue(instanceAdminUserOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(AdminUserConstants.CLASS_NAME, instanceAdminUserOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceAdminUserOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceAdminUserOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + AppUserConstants.ATTR_NAME_APPUSERLOGIN + "\" : " + "'" + instanceAdminUserOid.getAppUserLogin() + "'";
        jsonString += "}";
        instanceAdminUserOid.fromJsonString(jsonString);
        assertNotNull(instanceAdminUserOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceAdminUserOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(AppUserConstants.ATTR_NAME_APPUSERLOGIN, instanceAdminUserOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceAdminUserOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceAdminUserOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceAdminUserOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceAdminUserOid.compareToRS(values));
    }
}
