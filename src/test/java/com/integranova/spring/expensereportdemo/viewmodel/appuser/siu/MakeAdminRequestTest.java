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
public class MakeAdminRequestTest {

    private MakeAdminRequest instanceMakeAdminRequest;

    // Default values
    private static AppUserOid defValue4appUsermakeAdminpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsermakeAdminpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUsermakeAdminpthisAppUser

    // test4setAppUsermakeAdminpthisAppUser
    private static AppUserOid test4setAppUsermakeAdminpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsermakeAdminpthisAppUser();
        setUpMockData4test4setAppUsermakeAdminpthisAppUser();
    }

    private static void setUpMockData4test4getAppUsermakeAdminpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsermakeAdminpthisAppUser() {
        test4setAppUsermakeAdminpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceMakeAdminRequest = new MakeAdminRequest();
        instanceMakeAdminRequest.setAppUsermakeAdminpthisAppUser(defValue4appUsermakeAdminpthisAppUser);
        instanceMakeAdminRequest.setAppUsermakeAdminpthisAppUserInstance(defValue4appUsermakeAdminpthisAppUserInstance);
    }

    @Test
    public void test4getAppUsermakeAdminpthisAppUser() {
        assertEquals(defValue4appUsermakeAdminpthisAppUser, instanceMakeAdminRequest.getAppUsermakeAdminpthisAppUser());
    }

    @Test
    public void test4setAppUsermakeAdminpthisAppUser() {
        instanceMakeAdminRequest.setAppUsermakeAdminpthisAppUser(test4setAppUsermakeAdminpthisAppUserArg1);
        assertNotNull(instanceMakeAdminRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceMakeAdminRequest = new MakeAdminRequest();
    	instanceMakeAdminRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceMakeAdminRequest.checkArguments();
    }
}
