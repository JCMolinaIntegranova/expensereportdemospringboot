package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
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
public class AdminUserTest {

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
        instanceAdminUser.setAppUserLogin(VALUE_APPUSERLOGIN);
        instanceAdminUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        instanceAdminUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        instanceAdminUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceAdminUser = null;
    }

    @Test
    public void testDefaultConstructor() {
        AdminUser value = new AdminUser();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        AdminUser value = new AdminUser(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        AdminUser value = new AdminUser(new AdminUserOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        AdminUser value = new AdminUser(new AdminUserOid("appUserLogin"));
        assertNotNull(value);
    }

    @Test
    public void test4getAppUserLogin() {
        assertEquals(VALUE_APPUSERLOGIN.toString(), instanceAdminUser.getAppUserLogin().toString());
    }

    @Test
    public void test4setAppUserLogin() {
        String value = "appUserLogin";
        instanceAdminUser.setAppUserLogin(value);
        assertEquals(value, instanceAdminUser.getAppUserLogin());
    }

    @Test
    public void test4getAppUserUserName() {
        assertEquals(VALUE_APPUSERUSERNAME.toString(), instanceAdminUser.getAppUserUserName().toString());
    }

    @Test
    public void test4setAppUserUserName() {
        String value = "appUserUserName";
        instanceAdminUser.setAppUserUserName(value);
        assertEquals(value, instanceAdminUser.getAppUserUserName());
    }

    @Test
    public void test4isModifiedAppUserUserName() throws SystemException {
        instanceAdminUser = new AdminUser(new AdminUserOid(VALUE_APPUSERLOGIN));
        instanceAdminUser.setAdminUserRepository(mockAdminUserJpaRepository);
        assertTrue(instanceAdminUser.isModifiedAppUserUserName());
        instanceAdminUser.setAppUserUserName(VALUE_APPUSERUSERNAME);
        assertTrue(instanceAdminUser.isModifiedAppUserUserName());
    }


    @Test
    public void test4getAppUserUserSurname() {
        assertEquals(VALUE_APPUSERUSERSURNAME.toString(), instanceAdminUser.getAppUserUserSurname().toString());
    }

    @Test
    public void test4setAppUserUserSurname() {
        String value = "appUserUserSurname";
        instanceAdminUser.setAppUserUserSurname(value);
        assertEquals(value, instanceAdminUser.getAppUserUserSurname());
    }

    @Test
    public void test4isModifiedAppUserUserSurname() throws SystemException {
        instanceAdminUser = new AdminUser(new AdminUserOid(VALUE_APPUSERLOGIN));
        instanceAdminUser.setAdminUserRepository(mockAdminUserJpaRepository);
        assertTrue(instanceAdminUser.isModifiedAppUserUserSurname());
        instanceAdminUser.setAppUserUserSurname(VALUE_APPUSERUSERSURNAME);
        assertTrue(instanceAdminUser.isModifiedAppUserUserSurname());
    }


    @Test
    public void test4getAppUserUserType() {
        assertEquals(VALUE_APPUSERUSERTYPE.toString(), instanceAdminUser.getAppUserUserType().toString());
    }

    @Test
    public void test4setAppUserUserType() {
        String value = "appUserUserType";
        instanceAdminUser.setAppUserUserType(value);
        assertEquals(value, instanceAdminUser.getAppUserUserType());
    }

    @Test
    public void test4isModifiedAppUserUserType() throws SystemException {
        instanceAdminUser = new AdminUser(new AdminUserOid(VALUE_APPUSERLOGIN));
        instanceAdminUser.setAdminUserRepository(mockAdminUserJpaRepository);
        assertTrue(instanceAdminUser.isModifiedAppUserUserType());
        instanceAdminUser.setAppUserUserType(VALUE_APPUSERUSERTYPE);
        assertTrue(instanceAdminUser.isModifiedAppUserUserType());
    }


    @Test
    public void test4getValues() {
        assertNotNull(instanceAdminUser.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceAdminUser.getAttribute(AdminUserConstants.ATTR_NAME_APPUSERLOGIN));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals("", instanceAdminUser.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceAdminUser.cleanDerivations();
        assertNotNull(instanceAdminUser);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceAdminUser.getAppUserLogin(), instanceAdminUser.getOid().getAppUserLogin());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceAdminUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceAdminUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceAdminUser.isVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceAdminUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERNAME));
        assertTrue(instanceAdminUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME));
        assertTrue(instanceAdminUser.isAttributeVisible(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceAdminUser.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceAdminUser.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceAdminUser.getActiveFacets().contains(Constants.ADMINUSER));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceAdminUser.getFacets().contains(Constants.ADMINUSER));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceAdminUser.checkHorizontalVisibility(null));
    }
}
