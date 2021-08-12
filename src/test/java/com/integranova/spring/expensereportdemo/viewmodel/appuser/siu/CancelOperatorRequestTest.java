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
public class CancelOperatorRequestTest {

    private CancelOperatorRequest instanceCancelOperatorRequest;

    // Default values
    private static AppUserOid defValue4appUsercancelOperatorpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsercancelOperatorpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUsercancelOperatorpthisAppUser

    // test4setAppUsercancelOperatorpthisAppUser
    private static AppUserOid test4setAppUsercancelOperatorpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsercancelOperatorpthisAppUser();
        setUpMockData4test4setAppUsercancelOperatorpthisAppUser();
    }

    private static void setUpMockData4test4getAppUsercancelOperatorpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsercancelOperatorpthisAppUser() {
        test4setAppUsercancelOperatorpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceCancelOperatorRequest = new CancelOperatorRequest();
        instanceCancelOperatorRequest.setAppUsercancelOperatorpthisAppUser(defValue4appUsercancelOperatorpthisAppUser);
        instanceCancelOperatorRequest.setAppUsercancelOperatorpthisAppUserInstance(defValue4appUsercancelOperatorpthisAppUserInstance);
    }

    @Test
    public void test4getAppUsercancelOperatorpthisAppUser() {
        assertEquals(defValue4appUsercancelOperatorpthisAppUser, instanceCancelOperatorRequest.getAppUsercancelOperatorpthisAppUser());
    }

    @Test
    public void test4setAppUsercancelOperatorpthisAppUser() {
        instanceCancelOperatorRequest.setAppUsercancelOperatorpthisAppUser(test4setAppUsercancelOperatorpthisAppUserArg1);
        assertNotNull(instanceCancelOperatorRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCancelOperatorRequest = new CancelOperatorRequest();
    	instanceCancelOperatorRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCancelOperatorRequest.checkArguments();
    }
}
