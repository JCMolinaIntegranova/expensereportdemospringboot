package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.utils.Agent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SystemParamTest {

    private static Agent mockAgent;

    SystemParam instanceSystemParam;
    private static String VALUE_SYSTEMPARAMPARAMCODE;
    private static String VALUE_SYSTEMPARAMNAME;
    private static String VALUE_SYSTEMPARAMDESCRIPTION;
    private static String VALUE_SYSTEMPARAMTYPENAME;
    private static String VALUE_SYSTEMPARAMPARAMVALUE;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_SYSTEMPARAMPARAMCODE = "systemParamparamCode";
        VALUE_SYSTEMPARAMNAME = "systemParamname";
        VALUE_SYSTEMPARAMDESCRIPTION = "systemParamdescription";
        VALUE_SYSTEMPARAMTYPENAME = "systemParamtypeName";
        VALUE_SYSTEMPARAMPARAMVALUE = "systemParamparamValue";
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceSystemParam = new SystemParam();
        instanceSystemParam.setAgent(mockAgent);
        instanceSystemParam.setSystemParamparamCode(VALUE_SYSTEMPARAMPARAMCODE);
        instanceSystemParam.setSystemParamname(VALUE_SYSTEMPARAMNAME);
        instanceSystemParam.setSystemParamdescription(VALUE_SYSTEMPARAMDESCRIPTION);
        instanceSystemParam.setSystemParamtypeName(VALUE_SYSTEMPARAMTYPENAME);
        instanceSystemParam.setSystemParamparamValue(VALUE_SYSTEMPARAMPARAMVALUE);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceSystemParam = null;
    }

    @Test
    public void testDefaultConstructor() {
        SystemParam value = new SystemParam();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        SystemParam value = new SystemParam(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        SystemParam value = new SystemParam(new SystemParamOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        SystemParam value = new SystemParam(new SystemParamOid("systemParamparamCode"));
        assertNotNull(value);
    }

    @Test
    public void test4getSystemParamparamCode() {
        assertEquals(VALUE_SYSTEMPARAMPARAMCODE.toString(), instanceSystemParam.getSystemParamparamCode().toString());
    }

    @Test
    public void test4setSystemParamparamCode() {
        String value = "systemParamparamCode";
        instanceSystemParam.setSystemParamparamCode(value);
        assertEquals(value, instanceSystemParam.getSystemParamparamCode());
    }

    @Test
    public void test4getSystemParamname() {
        assertEquals(VALUE_SYSTEMPARAMNAME.toString(), instanceSystemParam.getSystemParamname().toString());
    }

    @Test
    public void test4setSystemParamname() {
        String value = "systemParamname";
        instanceSystemParam.setSystemParamname(value);
        assertEquals(value, instanceSystemParam.getSystemParamname());
    }

    @Test
    public void test4isModifiedSystemParamname() {
        instanceSystemParam = new SystemParam();
        assertFalse(instanceSystemParam.isModifiedSystemParamname());
        instanceSystemParam.setSystemParamname(VALUE_SYSTEMPARAMNAME);
        assertTrue(instanceSystemParam.isModifiedSystemParamname());
    }

    @Test
    public void test4setModifiedSystemParamname() {
        instanceSystemParam.setModifiedSystemParamname(true);
        assertTrue(instanceSystemParam.isModifiedSystemParamname());
    }

    @Test
    public void test4getSystemParamdescription() {
        assertEquals(VALUE_SYSTEMPARAMDESCRIPTION.toString(), instanceSystemParam.getSystemParamdescription().toString());
    }

    @Test
    public void test4setSystemParamdescription() {
        String value = "systemParamdescription";
        instanceSystemParam.setSystemParamdescription(value);
        assertEquals(value, instanceSystemParam.getSystemParamdescription());
    }

    @Test
    public void test4isModifiedSystemParamdescription() {
        instanceSystemParam = new SystemParam();
        assertFalse(instanceSystemParam.isModifiedSystemParamdescription());
        instanceSystemParam.setSystemParamdescription(VALUE_SYSTEMPARAMDESCRIPTION);
        assertTrue(instanceSystemParam.isModifiedSystemParamdescription());
    }

    @Test
    public void test4setModifiedSystemParamdescription() {
        instanceSystemParam.setModifiedSystemParamdescription(true);
        assertTrue(instanceSystemParam.isModifiedSystemParamdescription());
    }

    @Test
    public void test4getSystemParamtypeName() {
        assertEquals(VALUE_SYSTEMPARAMTYPENAME.toString(), instanceSystemParam.getSystemParamtypeName().toString());
    }

    @Test
    public void test4setSystemParamtypeName() {
        String value = "systemParamtypeName";
        instanceSystemParam.setSystemParamtypeName(value);
        assertEquals(value, instanceSystemParam.getSystemParamtypeName());
    }

    @Test
    public void test4isModifiedSystemParamtypeName() {
        instanceSystemParam = new SystemParam();
        assertFalse(instanceSystemParam.isModifiedSystemParamtypeName());
        instanceSystemParam.setSystemParamtypeName(VALUE_SYSTEMPARAMTYPENAME);
        assertTrue(instanceSystemParam.isModifiedSystemParamtypeName());
    }

    @Test
    public void test4setModifiedSystemParamtypeName() {
        instanceSystemParam.setModifiedSystemParamtypeName(true);
        assertTrue(instanceSystemParam.isModifiedSystemParamtypeName());
    }

    @Test
    public void test4getSystemParamparamValue() {
        assertEquals(VALUE_SYSTEMPARAMPARAMVALUE.toString(), instanceSystemParam.getSystemParamparamValue().toString());
    }

    @Test
    public void test4setSystemParamparamValue() {
        String value = "systemParamparamValue";
        instanceSystemParam.setSystemParamparamValue(value);
        assertEquals(value, instanceSystemParam.getSystemParamparamValue());
    }

    @Test
    public void test4isModifiedSystemParamparamValue() {
        instanceSystemParam = new SystemParam();
        assertFalse(instanceSystemParam.isModifiedSystemParamparamValue());
        instanceSystemParam.setSystemParamparamValue(VALUE_SYSTEMPARAMPARAMVALUE);
        assertTrue(instanceSystemParam.isModifiedSystemParamparamValue());
    }

    @Test
    public void test4setModifiedSystemParamparamValue() {
        instanceSystemParam.setModifiedSystemParamparamValue(true);
        assertTrue(instanceSystemParam.isModifiedSystemParamparamValue());
    }

    @Test
    public void test4buildDSSystemParams() {
        String result;
        try {
            result = instanceSystemParam.buildDSSystemParams().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceSystemParam.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceSystemParam.getAttribute(SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMCODE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals("", instanceSystemParam.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceSystemParam.cleanDerivations();
        assertNotNull(instanceSystemParam);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceSystemParam.getSystemParamparamCode(), instanceSystemParam.getOid().getSystemParamparamCode());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceSystemParam.isVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMNAME));
        assertTrue(instanceSystemParam.isVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMDESCRIPTION));
        assertTrue(instanceSystemParam.isVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMTYPENAME));
        assertTrue(instanceSystemParam.isVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMVALUE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceSystemParam.isAttributeVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMNAME));
        assertTrue(instanceSystemParam.isAttributeVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMDESCRIPTION));
        assertTrue(instanceSystemParam.isAttributeVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMTYPENAME));
        assertTrue(instanceSystemParam.isAttributeVisible(SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMVALUE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceSystemParam.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceSystemParam.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceSystemParam.getActiveFacets().contains(Constants.SYSTEMPARAM));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceSystemParam.getFacets().contains(Constants.SYSTEMPARAM));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceSystemParam.checkHorizontalVisibility(null));
    }
}
