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
public class CancelAdminRequestTest {

    private CancelAdminRequest instanceCancelAdminRequest;

    // Default values
    private static AppUserOid defValue4appUsercancelAdminpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsercancelAdminpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUsercancelAdminpthisAppUser

    // test4setAppUsercancelAdminpthisAppUser
    private static AppUserOid test4setAppUsercancelAdminpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsercancelAdminpthisAppUser();
        setUpMockData4test4setAppUsercancelAdminpthisAppUser();
    }

    private static void setUpMockData4test4getAppUsercancelAdminpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsercancelAdminpthisAppUser() {
        test4setAppUsercancelAdminpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceCancelAdminRequest = new CancelAdminRequest();
        instanceCancelAdminRequest.setAppUsercancelAdminpthisAppUser(defValue4appUsercancelAdminpthisAppUser);
        instanceCancelAdminRequest.setAppUsercancelAdminpthisAppUserInstance(defValue4appUsercancelAdminpthisAppUserInstance);
    }

    @Test
    public void test4getAppUsercancelAdminpthisAppUser() {
        assertEquals(defValue4appUsercancelAdminpthisAppUser, instanceCancelAdminRequest.getAppUsercancelAdminpthisAppUser());
    }

    @Test
    public void test4setAppUsercancelAdminpthisAppUser() {
        instanceCancelAdminRequest.setAppUsercancelAdminpthisAppUser(test4setAppUsercancelAdminpthisAppUserArg1);
        assertNotNull(instanceCancelAdminRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCancelAdminRequest = new CancelAdminRequest();
    	instanceCancelAdminRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCancelAdminRequest.checkArguments();
    }
}
