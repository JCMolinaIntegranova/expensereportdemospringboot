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
public class EditUserRequestTest {

    private EditUserRequest instanceEditUserRequest;

    // Default values
    private static AppUserOid defValue4appUsereditUserpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsereditUserpthisAppUserInstance = new AppUser(new AppUserOid(""));
    private static String defValue4appUsereditUserpUserName = "";
    private static String defValue4appUsereditUserpUserSurname = "";


    // test4getAppUsereditUserpthisAppUser

    // test4setAppUsereditUserpthisAppUser
    private static AppUserOid test4setAppUsereditUserpthisAppUserArg1;

    // test4getAppUsereditUserpUserName

    // test4setAppUsereditUserpUserName
    private static String test4setAppUsereditUserpUserNameArg1;

    // test4getAppUsereditUserpUserSurname

    // test4setAppUsereditUserpUserSurname
    private static String test4setAppUsereditUserpUserSurnameArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsereditUserpthisAppUser();
        setUpMockData4test4setAppUsereditUserpthisAppUser();
        setUpMockData4test4getAppUsereditUserpUserName();
        setUpMockData4test4setAppUsereditUserpUserName();
        setUpMockData4test4getAppUsereditUserpUserSurname();
        setUpMockData4test4setAppUsereditUserpUserSurname();
    }

    private static void setUpMockData4test4getAppUsereditUserpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsereditUserpthisAppUser() {
        test4setAppUsereditUserpthisAppUserArg1 = new AppUserOid();
    }

    private static void setUpMockData4test4getAppUsereditUserpUserName() {
    }

    private static void setUpMockData4test4setAppUsereditUserpUserName() {
        test4setAppUsereditUserpUserNameArg1 = "";
    }

    private static void setUpMockData4test4getAppUsereditUserpUserSurname() {
    }

    private static void setUpMockData4test4setAppUsereditUserpUserSurname() {
        test4setAppUsereditUserpUserSurnameArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditUserRequest = new EditUserRequest();
        instanceEditUserRequest.setAppUsereditUserpthisAppUser(defValue4appUsereditUserpthisAppUser);
        instanceEditUserRequest.setAppUsereditUserpthisAppUserInstance(defValue4appUsereditUserpthisAppUserInstance);
        instanceEditUserRequest.setAppUsereditUserpUserName(defValue4appUsereditUserpUserName);
        instanceEditUserRequest.setAppUsereditUserpUserSurname(defValue4appUsereditUserpUserSurname);
    }

    @Test
    public void test4getAppUsereditUserpthisAppUser() {
        assertEquals(defValue4appUsereditUserpthisAppUser, instanceEditUserRequest.getAppUsereditUserpthisAppUser());
    }

    @Test
    public void test4setAppUsereditUserpthisAppUser() {
        instanceEditUserRequest.setAppUsereditUserpthisAppUser(test4setAppUsereditUserpthisAppUserArg1);
        assertNotNull(instanceEditUserRequest);
    }

    @Test
    public void test4getAppUsereditUserpUserName() {
        assertEquals(defValue4appUsereditUserpUserName, instanceEditUserRequest.getAppUsereditUserpUserName());
    }

    @Test
    public void test4setAppUsereditUserpUserName() {
        instanceEditUserRequest.setAppUsereditUserpUserName(test4setAppUsereditUserpUserNameArg1);
        assertNotNull(instanceEditUserRequest);
    }

    @Test
    public void test4getAppUsereditUserpUserSurname() {
        assertEquals(defValue4appUsereditUserpUserSurname, instanceEditUserRequest.getAppUsereditUserpUserSurname());
    }

    @Test
    public void test4setAppUsereditUserpUserSurname() {
        instanceEditUserRequest.setAppUsereditUserpUserSurname(test4setAppUsereditUserpUserSurnameArg1);
        assertNotNull(instanceEditUserRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditUserRequest = new EditUserRequest();
    	instanceEditUserRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditUserRequest.checkArguments();
    }
}
