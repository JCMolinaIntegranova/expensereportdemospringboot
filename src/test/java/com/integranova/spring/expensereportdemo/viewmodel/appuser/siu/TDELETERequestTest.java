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
public class TDELETERequestTest {

    private TDELETERequest instanceTDELETERequest;

    // Default values
    private static AppUserOid defValue4appUserTDELETEpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUserTDELETEpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUserTDELETEpthisAppUser

    // test4setAppUserTDELETEpthisAppUser
    private static AppUserOid test4setAppUserTDELETEpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUserTDELETEpthisAppUser();
        setUpMockData4test4setAppUserTDELETEpthisAppUser();
    }

    private static void setUpMockData4test4getAppUserTDELETEpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUserTDELETEpthisAppUser() {
        test4setAppUserTDELETEpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceTDELETERequest = new TDELETERequest();
        instanceTDELETERequest.setAppUserTDELETEpthisAppUser(defValue4appUserTDELETEpthisAppUser);
        instanceTDELETERequest.setAppUserTDELETEpthisAppUserInstance(defValue4appUserTDELETEpthisAppUserInstance);
    }

    @Test
    public void test4getAppUserTDELETEpthisAppUser() {
        assertEquals(defValue4appUserTDELETEpthisAppUser, instanceTDELETERequest.getAppUserTDELETEpthisAppUser());
    }

    @Test
    public void test4setAppUserTDELETEpthisAppUser() {
        instanceTDELETERequest.setAppUserTDELETEpthisAppUser(test4setAppUserTDELETEpthisAppUserArg1);
        assertNotNull(instanceTDELETERequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTDELETERequest = new TDELETERequest();
    	instanceTDELETERequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTDELETERequest.checkArguments();
    }
}
