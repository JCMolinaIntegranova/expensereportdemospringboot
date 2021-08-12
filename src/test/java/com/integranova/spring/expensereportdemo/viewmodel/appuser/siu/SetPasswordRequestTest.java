package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SetPasswordRequestTest {

    private SetPasswordRequest instanceSetPasswordRequest;

    // Default values
    private static AppUserOid defValue4appUsersetPasswordpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsersetPasswordpthisAppUserInstance = new AppUser(new AppUserOid(""));
    private static String defValue4appUsersetPasswordpNewPassword = "";


    // test4getAppUsersetPasswordpthisAppUser

    // test4setAppUsersetPasswordpthisAppUser
    private static AppUserOid test4setAppUsersetPasswordpthisAppUserArg1;

    // test4getAppUsersetPasswordpNewPassword

    // test4setAppUsersetPasswordpNewPassword
    private static String test4setAppUsersetPasswordpNewPasswordArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsersetPasswordpthisAppUser();
        setUpMockData4test4setAppUsersetPasswordpthisAppUser();
        setUpMockData4test4getAppUsersetPasswordpNewPassword();
        setUpMockData4test4setAppUsersetPasswordpNewPassword();
    }

    private static void setUpMockData4test4getAppUsersetPasswordpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsersetPasswordpthisAppUser() {
        test4setAppUsersetPasswordpthisAppUserArg1 = new AppUserOid();
    }

    private static void setUpMockData4test4getAppUsersetPasswordpNewPassword() {
    }

    private static void setUpMockData4test4setAppUsersetPasswordpNewPassword() {
        test4setAppUsersetPasswordpNewPasswordArg1 = "";
    }

    @Before
    public void setUp() {
        instanceSetPasswordRequest = new SetPasswordRequest();
        instanceSetPasswordRequest.setAppUsersetPasswordpthisAppUser(defValue4appUsersetPasswordpthisAppUser);
        instanceSetPasswordRequest.setAppUsersetPasswordpthisAppUserInstance(defValue4appUsersetPasswordpthisAppUserInstance);
        instanceSetPasswordRequest.setAppUsersetPasswordpNewPassword(defValue4appUsersetPasswordpNewPassword);
    }

    @Test
    public void test4getAppUsersetPasswordpthisAppUser() {
        assertEquals(defValue4appUsersetPasswordpthisAppUser, instanceSetPasswordRequest.getAppUsersetPasswordpthisAppUser());
    }

    @Test
    public void test4setAppUsersetPasswordpthisAppUser() {
        instanceSetPasswordRequest.setAppUsersetPasswordpthisAppUser(test4setAppUsersetPasswordpthisAppUserArg1);
        assertNotNull(instanceSetPasswordRequest);
    }

    @Test
    public void test4getAppUsersetPasswordpNewPassword() {
        assertEquals(defValue4appUsersetPasswordpNewPassword, instanceSetPasswordRequest.getAppUsersetPasswordpNewPassword());
    }

    @Test
    public void test4setAppUsersetPasswordpNewPassword() {
        instanceSetPasswordRequest.setAppUsersetPasswordpNewPassword(test4setAppUsersetPasswordpNewPasswordArg1);
        assertNotNull(instanceSetPasswordRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceSetPasswordRequest = new SetPasswordRequest();
    	instanceSetPasswordRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceSetPasswordRequest.checkArguments();
    }
}
