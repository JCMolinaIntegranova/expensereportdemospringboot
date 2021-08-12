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
public class MakeOperatorRequestTest {

    private MakeOperatorRequest instanceMakeOperatorRequest;

    // Default values
    private static AppUserOid defValue4appUsermakeOperatorpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUsermakeOperatorpthisAppUserInstance = new AppUser(new AppUserOid(""));


    // test4getAppUsermakeOperatorpthisAppUser

    // test4setAppUsermakeOperatorpthisAppUser
    private static AppUserOid test4setAppUsermakeOperatorpthisAppUserArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUsermakeOperatorpthisAppUser();
        setUpMockData4test4setAppUsermakeOperatorpthisAppUser();
    }

    private static void setUpMockData4test4getAppUsermakeOperatorpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUsermakeOperatorpthisAppUser() {
        test4setAppUsermakeOperatorpthisAppUserArg1 = new AppUserOid();
    }

    @Before
    public void setUp() {
        instanceMakeOperatorRequest = new MakeOperatorRequest();
        instanceMakeOperatorRequest.setAppUsermakeOperatorpthisAppUser(defValue4appUsermakeOperatorpthisAppUser);
        instanceMakeOperatorRequest.setAppUsermakeOperatorpthisAppUserInstance(defValue4appUsermakeOperatorpthisAppUserInstance);
    }

    @Test
    public void test4getAppUsermakeOperatorpthisAppUser() {
        assertEquals(defValue4appUsermakeOperatorpthisAppUser, instanceMakeOperatorRequest.getAppUsermakeOperatorpthisAppUser());
    }

    @Test
    public void test4setAppUsermakeOperatorpthisAppUser() {
        instanceMakeOperatorRequest.setAppUsermakeOperatorpthisAppUser(test4setAppUsermakeOperatorpthisAppUserArg1);
        assertNotNull(instanceMakeOperatorRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceMakeOperatorRequest = new MakeOperatorRequest();
    	instanceMakeOperatorRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceMakeOperatorRequest.checkArguments();
    }
}
