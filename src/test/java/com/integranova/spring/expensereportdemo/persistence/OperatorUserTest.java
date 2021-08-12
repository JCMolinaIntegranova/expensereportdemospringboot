package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.repository.AdminUserJpaRepository;
import com.integranova.spring.expensereportdemo.repository.AppUserJpaRepository;
import com.integranova.spring.expensereportdemo.repository.OperatorUserJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OperatorUserTest {

    private static AppUserJpaRepository mockAppUserJpaRepository;

    private static AdminUserJpaRepository mockAdminUserJpaRepository;

    private static OperatorUserJpaRepository mockOperatorUserJpaRepository;

    private static Agent mockAgent;

    AppUser instanceAppUser;

    AdminUser instanceAdminUser;

    OperatorUser instanceOperatorUser;
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
        mockAdminUserJpaRepository = mock(AdminUserJpaRepository.class);
        mockOperatorUserJpaRepository = mock(OperatorUserJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceAppUser = new AppUser(new AppUserOid(VALUE_APPUSERLOGIN));
        instanceAppUser.setAppUserRepository(mockAppUserJpaRepository);
        instanceAppUser.setAgent(mockAgent);
        instanceAdminUser = new AdminUser(new AdminUserOid(VALUE_APPUSERLOGIN));
        instanceAdminUser.setAdminUserRepository(mockAdminUserJpaRepository);
        instanceAdminUser.setAgent(mockAgent);
        instanceOperatorUser = new OperatorUser(new OperatorUserOid(VALUE_APPUSERLOGIN));
        instanceOperatorUser.setOperatorUserRepository(mockOperatorUserJpaRepository);
        instanceOperatorUser.setAgent(mockAgent);
        when(mockAppUserJpaRepository.findChildAdminUser(VALUE_APPUSERLOGIN)).thenReturn(instanceAdminUser);
        when(mockAppUserJpaRepository.findChildOperatorUser(VALUE_APPUSERLOGIN)).thenReturn(instanceOperatorUser);
        when(mockAdminUserJpaRepository.findParent(VALUE_APPUSERLOGIN)).thenReturn(instanceAppUser);
        when(mockOperatorUserJpaRepository.findParent(VALUE_APPUSERLOGIN)).thenReturn(instanceAppUser);
        instanceOperatorUser.setAppUserLogin(VALUE_APPUSERLOGIN);
        instanceOperatorUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        instanceOperatorUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        instanceOperatorUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceOperatorUser = null;
    }

    @Test
    public void testDefaultConstructor() {
        OperatorUser value = new OperatorUser();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        OperatorUser value = new OperatorUser(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        OperatorUser value = new OperatorUser(new OperatorUserOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        OperatorUser value = new OperatorUser(new OperatorUserOid("appUserLogin"));
        assertNotNull(value);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceOperatorUser.getAppUserLogin().toString());
    }

    @Test
    public void test4setAppUserLogin() {
        String value = "appUserLogin";
        instanceOperatorUser.setAppUserLogin(value);
        assertEquals(value, instanceOperatorUser.getAppUserLogin());
    }

    @Test
    public void test4getAppUserUserName() {
        assertEquals(VALUE_APPUSERUSERNAME.toString(), instanceOperatorUser.getAppUserUserName().toString());
    }

    @Test
    public void test4setAppUserUserName() {
        String value = "appUserUserName";
        instanceOperatorUser.setAppUserUserName(value);
        assertEquals(value, instanceOperatorUser.getAppUserUserName());
    }

    @Test
    public void test4isModifiedAppUserUserName() throws SystemException {
        instanceOperatorUser = new OperatorUser(new OperatorUserOid(VALUE_APPUSERLOGIN));
        instanceOperatorUser.setOperatorUserRepository(mockOperatorUserJpaRepository);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserName());
        instanceOperatorUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserName());
    }


    @Test
    public void test4getAppUserUserSurname() {
        assertEquals(VALUE_APPUSERUSERSURNAME.toString(), instanceOperatorUser.getAppUserUserSurname().toString());
    }

    @Test
    public void test4setAppUserUserSurname() {
        String value = "appUserUserSurname";
        instanceOperatorUser.setAppUserUserSurname(value);
        assertEquals(value, instanceOperatorUser.getAppUserUserSurname());
    }

    @Test
    public void test4isModifiedAppUserUserSurname() throws SystemException {
        instanceOperatorUser = new OperatorUser(new OperatorUserOid(VALUE_APPUSERLOGIN));
        instanceOperatorUser.setOperatorUserRepository(mockOperatorUserJpaRepository);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserSurname());
        instanceOperatorUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserSurname());
    }


    @Test
    public void test4getAppUserUserType() {
        assertEquals(VALUE_APPUSERUSERTYPE.toString(), instanceOperatorUser.getAppUserUserType().toString());
    }

    @Test
    public void test4setAppUserUserType() {
        String value = "appUserUserType";
        instanceOperatorUser.setAppUserUserType(value);
        assertEquals(value, instanceOperatorUser.getAppUserUserType());
    }

    @Test
    public void test4isModifiedAppUserUserType() throws SystemException {
        instanceOperatorUser = new OperatorUser(new OperatorUserOid(VALUE_APPUSERLOGIN));
        instanceOperatorUser.setOperatorUserRepository(mockOperatorUserJpaRepository);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserType());
        instanceOperatorUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        assertTrue(instanceOperatorUser.isModifiedAppUserUserType());
    }


    @Test
    public void test4getValues() {
        assertNotNull(instanceOperatorUser.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceOperatorUser.getAttribute(OperatorUserConstants.ATTR_NAME_APPUSERLOGIN));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals("", instanceOperatorUser.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceOperatorUser.cleanDerivations();
        assertNotNull(instanceOperatorUser);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceOperatorUser.getAppUserLogin(), instanceOperatorUser.getOid().getAppUserLogin());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceOperatorUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceOperatorUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceOperatorUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceOperatorUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceOperatorUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceOperatorUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceOperatorUser.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceOperatorUser.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceOperatorUser.getActiveFacets().contains(Constants.OPERATORUSER));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceOperatorUser.getFacets().contains(Constants.OPERATORUSER));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceOperatorUser.checkHorizontalVisibility(null));
    }
}
