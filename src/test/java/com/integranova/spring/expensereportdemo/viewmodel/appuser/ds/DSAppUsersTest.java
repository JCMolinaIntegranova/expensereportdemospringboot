package com.integranova.spring.expensereportdemo.viewmodel.appuser.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.AppUser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSAppUsersTest {

    private DSAppUsers instanceDSAppUsers;

    // testDSAppUsers
    private static AppUser testDSAppUsersArg1;

    // testDSAppUsers2
    private static AppUser testDSAppUsers2Arg1;

    // testgetDSAppUsersLogin

    // testsetDSAppUsersLogin
    private static String testsetDSAppUsersLoginArg1;

    // testgetDSAppUsersUserSurname

    // testsetDSAppUsersUserSurname
    private static String testsetDSAppUsersUserSurnameArg1;

    // testgetDSAppUsersUserName

    // testsetDSAppUsersUserName
    private static String testsetDSAppUsersUserNameArg1;

    // testgetDSAppUsersUserType

    // testsetDSAppUsersUserType
    private static String testsetDSAppUsersUserTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSAppUsers();
        setUpMockData4testDSAppUsers2();
        setUpMockData4testgetDSAppUsersLogin();
        setUpMockData4testsetDSAppUsersLogin();
        setUpMockData4testgetDSAppUsersUserSurname();
        setUpMockData4testsetDSAppUsersUserSurname();
        setUpMockData4testgetDSAppUsersUserName();
        setUpMockData4testsetDSAppUsersUserName();
        setUpMockData4testgetDSAppUsersUserType();
        setUpMockData4testsetDSAppUsersUserType();
    }

    private static void setUpMockData4testDSAppUsers() {
        testDSAppUsersArg1 = new AppUser();
    }

    private static void setUpMockData4testDSAppUsers2() {
        testDSAppUsers2Arg1 = null;
    }

    private static void setUpMockData4testgetDSAppUsersLogin() {
    }

    private static void setUpMockData4testsetDSAppUsersLogin() {
        testsetDSAppUsersLoginArg1 = "";
    }

    private static void setUpMockData4testgetDSAppUsersUserSurname() {
    }

    private static void setUpMockData4testsetDSAppUsersUserSurname() {
        testsetDSAppUsersUserSurnameArg1 = "";
    }

    private static void setUpMockData4testgetDSAppUsersUserName() {
    }

    private static void setUpMockData4testsetDSAppUsersUserName() {
        testsetDSAppUsersUserNameArg1 = "";
    }

    private static void setUpMockData4testgetDSAppUsersUserType() {
    }

    private static void setUpMockData4testsetDSAppUsersUserType() {
        testsetDSAppUsersUserTypeArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSAppUsers = new DSAppUsers();
        instanceDSAppUsers.setDSAppUsersLogin("");
        instanceDSAppUsers.setDSAppUsersUserSurname("");
        instanceDSAppUsers.setDSAppUsersUserName("");
        instanceDSAppUsers.setDSAppUsersUserType("");
    }

    @Test
    public void testDSAppUsers() {
        instanceDSAppUsers = new DSAppUsers(testDSAppUsersArg1);
        assertNotNull(instanceDSAppUsers);
    }

    @Test
    public void testDSAppUsers2() {
        instanceDSAppUsers = new DSAppUsers(testDSAppUsers2Arg1);
        assertNotNull(instanceDSAppUsers);
    }

    @Test
    public void testgetDSAppUsersLogin() {
        assertEquals("", instanceDSAppUsers.getDSAppUsersLogin());
    }

    @Test
    public void testsetDSAppUsersLogin() {
        instanceDSAppUsers.setDSAppUsersLogin(testsetDSAppUsersLoginArg1);
        assertNotNull(instanceDSAppUsers);
    }

    @Test
    public void testgetDSAppUsersUserSurname() {
        assertEquals("", instanceDSAppUsers.getDSAppUsersUserSurname());
    }

    @Test
    public void testsetDSAppUsersUserSurname() {
        instanceDSAppUsers.setDSAppUsersUserSurname(testsetDSAppUsersUserSurnameArg1);
        assertNotNull(instanceDSAppUsers);
    }

    @Test
    public void testgetDSAppUsersUserName() {
        assertEquals("", instanceDSAppUsers.getDSAppUsersUserName());
    }

    @Test
    public void testsetDSAppUsersUserName() {
        instanceDSAppUsers.setDSAppUsersUserName(testsetDSAppUsersUserNameArg1);
        assertNotNull(instanceDSAppUsers);
    }

    @Test
    public void testgetDSAppUsersUserType() {
        assertEquals("", instanceDSAppUsers.getDSAppUsersUserType());
    }

    @Test
    public void testsetDSAppUsersUserType() {
        instanceDSAppUsers.setDSAppUsersUserType(testsetDSAppUsersUserTypeArg1);
        assertNotNull(instanceDSAppUsers);
    }
}
