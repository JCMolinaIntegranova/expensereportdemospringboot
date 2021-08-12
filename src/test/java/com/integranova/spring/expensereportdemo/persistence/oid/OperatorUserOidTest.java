package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OperatorUserOidTest {

    private OperatorUserOid instanceOperatorUserOid;

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
        instanceOperatorUserOid = new OperatorUserOid();
        instanceOperatorUserOid.setAppUserLogin(VALUE_APPUSERLOGIN);
    }

    @After
    public void tearDown() {
        instanceOperatorUserOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceOperatorUserOid = new OperatorUserOid();
        assertNotNull(instanceOperatorUserOid);
    }

    @Test
    public void testConstructor() {
        instanceOperatorUserOid = new OperatorUserOid(VALUE_APPUSERLOGIN);
        assertNotNull(instanceOperatorUserOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_APPUSERLOGIN);
        instanceOperatorUserOid = new OperatorUserOid(oidFields);
        assertNotNull(instanceOperatorUserOid);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceOperatorUserOid.getAppUserLogin().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceOperatorUserOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceOperatorUserOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceOperatorUserOid.equals(instanceOperatorUserOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceOperatorUserOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceOperatorUserOid.setAppUserLogin(null);
        assertTrue(instanceOperatorUserOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(OperatorUserConstants.CLASS_NAME, instanceOperatorUserOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceOperatorUserOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceOperatorUserOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + AppUserConstants.ATTR_NAME_APPUSERLOGIN + "\" : " + "'" + instanceOperatorUserOid.getAppUserLogin() + "'";
        jsonString += "}";
        instanceOperatorUserOid.fromJsonString(jsonString);
        assertNotNull(instanceOperatorUserOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceOperatorUserOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(AppUserConstants.ATTR_NAME_APPUSERLOGIN, instanceOperatorUserOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceOperatorUserOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceOperatorUserOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceOperatorUserOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceOperatorUserOid.compareToRS(values));
    }
}
