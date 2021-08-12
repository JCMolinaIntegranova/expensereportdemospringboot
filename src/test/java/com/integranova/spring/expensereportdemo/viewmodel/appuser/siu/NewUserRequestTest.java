package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewUserRequestTest {

    private NewUserRequest instanceNewUserRequest;

    // Default values
    private static String defValue4appUsernewUserpatrLogin = "";
    private static String defValue4appUsernewUserpatrUserName = "";
    private static String defValue4appUsernewUserpatrUserSurname = "";
    private static String defValue4appUsernewUserpatrUserType = "";
    private static String defValue4appUsernewUserppassword = "";


    // test4getAppUsernewUserpatrLogin

    // test4setAppUsernewUserpatrLogin
    private static String test4setAppUsernewUserpatrLoginArg1;

    // test4getAppUsernewUserpatrUserName

    // test4setAppUsernewUserpatrUserName
    private static String test4setAppUsernewUserpatrUserNameArg1;

    // test4getAppUsernewUserpatrUserSurname

    // test4setAppUsernewUserpatrUserSurname
    private static String test4setAppUsernewUserpatrUserSurnameArg1;

    // test4getAppUsernewUserpatrUserType

    // test4setAppUsernewUserpatrUserType
    private static String test4setAppUsernewUserpatrUserTypeArg1;

    // test4getAppUsernewUserppassword

    // test4setAppUsernewUserppassword
    private static String test4setAppUsernewUserppasswordArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsernewUserpatrLogin();
        setUpMockData4test4setAppUsernewUserpatrLogin();
        setUpMockData4test4getAppUsernewUserpatrUserName();
        setUpMockData4test4setAppUsernewUserpatrUserName();
        setUpMockData4test4getAppUsernewUserpatrUserSurname();
        setUpMockData4test4setAppUsernewUserpatrUserSurname();
        setUpMockData4test4getAppUsernewUserpatrUserType();
        setUpMockData4test4setAppUsernewUserpatrUserType();
        setUpMockData4test4getAppUsernewUserppassword();
        setUpMockData4test4setAppUsernewUserppassword();
    }

    private static void setUpMockData4test4getAppUsernewUserpatrLogin() {
    }

    private static void setUpMockData4test4setAppUsernewUserpatrLogin() {
        test4setAppUsernewUserpatrLoginArg1 = "";
    }

    private static void setUpMockData4test4getAppUsernewUserpatrUserName() {
    }

    private static void setUpMockData4test4setAppUsernewUserpatrUserName() {
        test4setAppUsernewUserpatrUserNameArg1 = "";
    }

    private static void setUpMockData4test4getAppUsernewUserpatrUserSurname() {
    }

    private static void setUpMockData4test4setAppUsernewUserpatrUserSurname() {
        test4setAppUsernewUserpatrUserSurnameArg1 = "";
    }

    private static void setUpMockData4test4getAppUsernewUserpatrUserType() {
    }

    private static void setUpMockData4test4setAppUsernewUserpatrUserType() {
        test4setAppUsernewUserpatrUserTypeArg1 = "";
    }

    private static void setUpMockData4test4getAppUsernewUserppassword() {
    }

    private static void setUpMockData4test4setAppUsernewUserppassword() {
        test4setAppUsernewUserppasswordArg1 = "";
    }

    @Before
    public void setUp() {
        instanceNewUserRequest = new NewUserRequest();
        instanceNewUserRequest.setAppUsernewUserpatrLogin(defValue4appUsernewUserpatrLogin);
        instanceNewUserRequest.setAppUsernewUserpatrUserName(defValue4appUsernewUserpatrUserName);
        instanceNewUserRequest.setAppUsernewUserpatrUserSurname(defValue4appUsernewUserpatrUserSurname);
        instanceNewUserRequest.setAppUsernewUserpatrUserType(defValue4appUsernewUserpatrUserType);
        instanceNewUserRequest.setAppUsernewUserppassword(defValue4appUsernewUserppassword);
    }

    @Test
    public void test4getAppUsernewUserpatrLogin() {
        assertEquals(defValue4appUsernewUserpatrLogin, instanceNewUserRequest.getAppUsernewUserpatrLogin());
    }

    @Test
    public void test4setAppUsernewUserpatrLogin() {
        instanceNewUserRequest.setAppUsernewUserpatrLogin(test4setAppUsernewUserpatrLoginArg1);
        assertNotNull(instanceNewUserRequest);
    }

    @Test
    public void test4getAppUsernewUserpatrUserName() {
        assertEquals(defValue4appUsernewUserpatrUserName, instanceNewUserRequest.getAppUsernewUserpatrUserName());
    }

    @Test
    public void test4setAppUsernewUserpatrUserName() {
        instanceNewUserRequest.setAppUsernewUserpatrUserName(test4setAppUsernewUserpatrUserNameArg1);
        assertNotNull(instanceNewUserRequest);
    }

    @Test
    public void test4getAppUsernewUserpatrUserSurname() {
        assertEquals(defValue4appUsernewUserpatrUserSurname, instanceNewUserRequest.getAppUsernewUserpatrUserSurname());
    }

    @Test
    public void test4setAppUsernewUserpatrUserSurname() {
        instanceNewUserRequest.setAppUsernewUserpatrUserSurname(test4setAppUsernewUserpatrUserSurnameArg1);
        assertNotNull(instanceNewUserRequest);
    }

    @Test
    public void test4getAppUsernewUserpatrUserType() {
        assertEquals(defValue4appUsernewUserpatrUserType, instanceNewUserRequest.getAppUsernewUserpatrUserType());
    }

    @Test
    public void test4setAppUsernewUserpatrUserType() {
        instanceNewUserRequest.setAppUsernewUserpatrUserType(test4setAppUsernewUserpatrUserTypeArg1);
        assertNotNull(instanceNewUserRequest);
    }

    @Test
    public void test4getAppUsernewUserppassword() {
        assertEquals(defValue4appUsernewUserppassword, instanceNewUserRequest.getAppUsernewUserppassword());
    }

    @Test
    public void test4setAppUsernewUserppassword() {
        instanceNewUserRequest.setAppUsernewUserppassword(test4setAppUsernewUserppasswordArg1);
        assertNotNull(instanceNewUserRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceNewUserRequest = new NewUserRequest();
    	instanceNewUserRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceNewUserRequest.checkArguments();
    }
}
