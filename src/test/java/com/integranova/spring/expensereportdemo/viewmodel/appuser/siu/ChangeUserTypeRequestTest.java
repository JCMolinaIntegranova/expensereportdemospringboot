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
public class ChangeUserTypeRequestTest {

    private ChangeUserTypeRequest instanceChangeUserTypeRequest;

    // Default values
    private static AppUserOid defValue4appUserchangeUserTypepthisAppUser = new AppUserOid();
    private static AppUser defValue4appUserchangeUserTypepthisAppUserInstance = new AppUser(new AppUserOid(""));
    private static String defValue4appUserchangeUserTypepNewType = "";


    // test4getAppUserchangeUserTypepthisAppUser

    // test4setAppUserchangeUserTypepthisAppUser
    private static AppUserOid test4setAppUserchangeUserTypepthisAppUserArg1;

    // test4getAppUserchangeUserTypepNewType

    // test4setAppUserchangeUserTypepNewType
    private static String test4setAppUserchangeUserTypepNewTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUserchangeUserTypepthisAppUser();
        setUpMockData4test4setAppUserchangeUserTypepthisAppUser();
        setUpMockData4test4getAppUserchangeUserTypepNewType();
        setUpMockData4test4setAppUserchangeUserTypepNewType();
    }

    private static void setUpMockData4test4getAppUserchangeUserTypepthisAppUser() {
    }

    private static void setUpMockData4test4setAppUserchangeUserTypepthisAppUser() {
        test4setAppUserchangeUserTypepthisAppUserArg1 = new AppUserOid();
    }

    private static void setUpMockData4test4getAppUserchangeUserTypepNewType() {
    }

    private static void setUpMockData4test4setAppUserchangeUserTypepNewType() {
        test4setAppUserchangeUserTypepNewTypeArg1 = "";
    }

    @Before
    public void setUp() {
        instanceChangeUserTypeRequest = new ChangeUserTypeRequest();
        instanceChangeUserTypeRequest.setAppUserchangeUserTypepthisAppUser(defValue4appUserchangeUserTypepthisAppUser);
        instanceChangeUserTypeRequest.setAppUserchangeUserTypepthisAppUserInstance(defValue4appUserchangeUserTypepthisAppUserInstance);
        instanceChangeUserTypeRequest.setAppUserchangeUserTypepNewType(defValue4appUserchangeUserTypepNewType);
    }

    @Test
    public void test4getAppUserchangeUserTypepthisAppUser() {
        assertEquals(defValue4appUserchangeUserTypepthisAppUser, instanceChangeUserTypeRequest.getAppUserchangeUserTypepthisAppUser());
    }

    @Test
    public void test4setAppUserchangeUserTypepthisAppUser() {
        instanceChangeUserTypeRequest.setAppUserchangeUserTypepthisAppUser(test4setAppUserchangeUserTypepthisAppUserArg1);
        assertNotNull(instanceChangeUserTypeRequest);
    }

    @Test
    public void test4getAppUserchangeUserTypepNewType() {
        assertEquals(defValue4appUserchangeUserTypepNewType, instanceChangeUserTypeRequest.getAppUserchangeUserTypepNewType());
    }

    @Test
    public void test4setAppUserchangeUserTypepNewType() {
        instanceChangeUserTypeRequest.setAppUserchangeUserTypepNewType(test4setAppUserchangeUserTypepNewTypeArg1);
        assertNotNull(instanceChangeUserTypeRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceChangeUserTypeRequest = new ChangeUserTypeRequest();
    	instanceChangeUserTypeRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceChangeUserTypeRequest.checkArguments();
    }
}
