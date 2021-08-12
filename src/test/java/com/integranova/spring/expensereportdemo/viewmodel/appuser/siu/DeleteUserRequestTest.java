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
public class DeleteUserRequestTest {

    private DeleteUserRequest instanceDeleteUserRequest;

    // Default values
    private static AppUserOid defValue4appUserdeleteUserpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUserdeleteUserpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUserdeleteUserpthisAppUser

    // test4setAppUserdeleteUserpthisAppUser
    private static AppUserOid test4setAppUserdeleteUserpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUserdeleteUserpthisAppUser();
        setUpMockData4test4setAppUserdeleteUserpthisAppUser();
    }

    private static void setUpMockData4test4getAppUserdeleteUserpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUserdeleteUserpthisAppUser() {
        test4setAppUserdeleteUserpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceDeleteUserRequest = new DeleteUserRequest();
        instanceDeleteUserRequest.setAppUserdeleteUserpthisAppUser(defValue4appUserdeleteUserpthisAppUser);
        instanceDeleteUserRequest.setAppUserdeleteUserpthisAppUserInstance(defValue4appUserdeleteUserpthisAppUserInstance);
    }

    @Test
    public void test4getAppUserdeleteUserpthisAppUser() {
        assertEquals(defValue4appUserdeleteUserpthisAppUser, instanceDeleteUserRequest.getAppUserdeleteUserpthisAppUser());
    }

    @Test
    public void test4setAppUserdeleteUserpthisAppUser() {
        instanceDeleteUserRequest.setAppUserdeleteUserpthisAppUser(test4setAppUserdeleteUserpthisAppUserArg1);
        assertNotNull(instanceDeleteUserRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteUserRequest = new DeleteUserRequest();
    	instanceDeleteUserRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteUserRequest.checkArguments();
    }
}
