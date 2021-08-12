package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTypeOidTest {

    private PaymentTypeOid instancePaymentTypeOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static String VALUE_PAYMENTTYPEIDPAYMENTTYPE;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_PAYMENTTYPEIDPAYMENTTYPE = "";
        VALUE_ARRAYLISTVALUES.add(VALUE_PAYMENTTYPEIDPAYMENTTYPE);
    }

    @Before
    public void setUp() {
        instancePaymentTypeOid = new PaymentTypeOid();
        instancePaymentTypeOid.setPaymentTypeidPaymentType(VALUE_PAYMENTTYPEIDPAYMENTTYPE);
    }

    @After
    public void tearDown() {
        instancePaymentTypeOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instancePaymentTypeOid = new PaymentTypeOid();
        assertNotNull(instancePaymentTypeOid);
    }

    @Test
    public void testConstructor() {
        instancePaymentTypeOid = new PaymentTypeOid(VALUE_PAYMENTTYPEIDPAYMENTTYPE);
        assertNotNull(instancePaymentTypeOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_PAYMENTTYPEIDPAYMENTTYPE);
        instancePaymentTypeOid = new PaymentTypeOid(oidFields);
        assertNotNull(instancePaymentTypeOid);
    }

    @Test
    public void test4getPaymentTypeidPaymentType() {
        assertEquals(VALUE_PAYMENTTYPEIDPAYMENTTYPE.toString(), instancePaymentTypeOid.getPaymentTypeidPaymentType().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instancePaymentTypeOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instancePaymentTypeOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instancePaymentTypeOid.equals(instancePaymentTypeOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instancePaymentTypeOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instancePaymentTypeOid.setPaymentTypeidPaymentType(null);
        assertTrue(instancePaymentTypeOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(PaymentTypeConstants.CLASS_NAME, instancePaymentTypeOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instancePaymentTypeOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instancePaymentTypeOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEIDPAYMENTTYPE + "\" : " + "'" + instancePaymentTypeOid.getPaymentTypeidPaymentType() + "'";
        jsonString += "}";
        instancePaymentTypeOid.fromJsonString(jsonString);
        assertNotNull(instancePaymentTypeOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instancePaymentTypeOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEIDPAYMENTTYPE, instancePaymentTypeOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.STRING.getTypeName(), instancePaymentTypeOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instancePaymentTypeOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instancePaymentTypeOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instancePaymentTypeOid.compareToRS(values));
    }
}
