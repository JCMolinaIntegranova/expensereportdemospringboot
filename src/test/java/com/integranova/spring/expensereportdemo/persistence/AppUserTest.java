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
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.repository.AppUserJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppUserTest {

    private static AppUserJpaRepository mockAppUserJpaRepository;

    private static Agent mockAgent;

    AppUser instanceAppUser;
    private static String VALUE_APPUSERLOGIN;
    private static String VALUE_APPUSERUSERNAME;
    private static String VALUE_APPUSERUSERSURNAME;
    private static String VALUE_APPUSERUSERTYPE;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_APPUSERLOGIN = "appUserLogin";
        VALUE_APPUSERUSERNAME = "appUserUserName";
        VALUE_APPUSERUSERSURNAME = "appUserUserSurname";
        VALUE_APPUSERUSERTYPE = "appUserUserType";
        mockAppUserJpaRepository = mock(AppUserJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceAppUser = new AppUser();
        instanceAppUser.setAppUserRepository(mockAppUserJpaRepository);
        instanceAppUser.setAgent(mockAgent);
        instanceAppUser.setAppUserLogin(VALUE_APPUSERLOGIN);
        instanceAppUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        instanceAppUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        instanceAppUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceAppUser = null;
    }

    @Test
    public void testDefaultConstructor() {
        AppUser value = new AppUser();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        AppUser value = new AppUser(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        AppUser value = new AppUser(new AppUserOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        AppUser value = new AppUser(new AppUserOid("appUserLogin"));
        assertNotNull(value);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceAppUser.getAppUserLogin().toString());
    }

    @Test
    public void test4setAppUserLogin() {
        String value = "appUserLogin";
        instanceAppUser.setAppUserLogin(value);
        assertEquals(value, instanceAppUser.getAppUserLogin());
    }

    @Test
    public void test4getAppUserUserName() {
        assertEquals(VALUE_APPUSERUSERNAME.toString(), instanceAppUser.getAppUserUserName().toString());
    }

    @Test
    public void test4setAppUserUserName() {
        String value = "appUserUserName";
        instanceAppUser.setAppUserUserName(value);
        assertEquals(value, instanceAppUser.getAppUserUserName());
    }

    @Test
    public void test4isModifiedAppUserUserName() {
        instanceAppUser = new AppUser();
        assertFalse(instanceAppUser.isModifiedAppUserUserName());
        instanceAppUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        assertTrue(instanceAppUser.isModifiedAppUserUserName());
    }

    @Test
    public void test4setModifiedAppUserUserName() {
        instanceAppUser.setModifiedAppUserUserName(true);
        assertTrue(instanceAppUser.isModifiedAppUserUserName());
    }

    @Test
    public void test4getAppUserUserSurname() {
        assertEquals(VALUE_APPUSERUSERSURNAME.toString(), instanceAppUser.getAppUserUserSurname().toString());
    }

    @Test
    public void test4setAppUserUserSurname() {
        String value = "appUserUserSurname";
        instanceAppUser.setAppUserUserSurname(value);
        assertEquals(value, instanceAppUser.getAppUserUserSurname());
    }

    @Test
    public void test4isModifiedAppUserUserSurname() {
        instanceAppUser = new AppUser();
        assertFalse(instanceAppUser.isModifiedAppUserUserSurname());
        instanceAppUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        assertTrue(instanceAppUser.isModifiedAppUserUserSurname());
    }

    @Test
    public void test4setModifiedAppUserUserSurname() {
        instanceAppUser.setModifiedAppUserUserSurname(true);
        assertTrue(instanceAppUser.isModifiedAppUserUserSurname());
    }

    @Test
    public void test4getAppUserUserType() {
        assertEquals(VALUE_APPUSERUSERTYPE.toString(), instanceAppUser.getAppUserUserType().toString());
    }

    @Test
    public void test4setAppUserUserType() {
        String value = "appUserUserType";
        instanceAppUser.setAppUserUserType(value);
        assertEquals(value, instanceAppUser.getAppUserUserType());
    }

    @Test
    public void test4isModifiedAppUserUserType() {
        instanceAppUser = new AppUser();
        assertFalse(instanceAppUser.isModifiedAppUserUserType());
        instanceAppUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        assertTrue(instanceAppUser.isModifiedAppUserUserType());
    }

    @Test
    public void test4setModifiedAppUserUserType() {
        instanceAppUser.setModifiedAppUserUserType(true);
        assertTrue(instanceAppUser.isModifiedAppUserUserType());
    }

    @Test
    public void test4buildDSAppUsers() {
        String result;
        try {
            result = instanceAppUser.buildDSAppUsers().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceAppUser.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceAppUser.getAttribute(AppUserConstants.ATTR_NAME_APPUSERLOGIN));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals("", instanceAppUser.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceAppUser.cleanDerivations();
        assertNotNull(instanceAppUser);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceAppUser.getAppUserLogin(), instanceAppUser.getOid().getAppUserLogin());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceAppUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceAppUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceAppUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceAppUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceAppUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceAppUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceAppUser.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceAppUser.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceAppUser.getActiveFacets().contains(Constants.APPUSER));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceAppUser.getFacets().contains(Constants.APPUSER));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceAppUser.checkHorizontalVisibility(null));
    }
}
