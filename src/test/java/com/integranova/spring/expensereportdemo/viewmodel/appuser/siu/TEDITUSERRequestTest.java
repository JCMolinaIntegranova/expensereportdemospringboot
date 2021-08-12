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
public class TEDITUSERRequestTest {

    private TEDITUSERRequest instanceTEDITUSERRequest;

    // Default values
    private static AppUserOid defValue4appUserTEDITUSERpthisAppUser = new AppUserOid();
    private static AppUser defValue4appUserTEDITUSERpthisAppUserInstance = new AppUser(new AppUserOid(""));
    private static String defValue4appUserTEDITUSERpName = "";
    private static String defValue4appUserTEDITUSERpSurname = "";
    private static String defValue4appUserTEDITUSERpType = "";


    // test4getAppUserTEDITUSERpthisAppUser

    // test4setAppUserTEDITUSERpthisAppUser
    private static AppUserOid test4setAppUserTEDITUSERpthisAppUserArg1;

    // test4getAppUserTEDITUSERpName

    // test4setAppUserTEDITUSERpName
    private static String test4setAppUserTEDITUSERpNameArg1;

    // test4getAppUserTEDITUSERpSurname

    // test4setAppUserTEDITUSERpSurname
    private static String test4setAppUserTEDITUSERpSurnameArg1;

    // test4getAppUserTEDITUSERpType

    // test4setAppUserTEDITUSERpType
    private static String test4setAppUserTEDITUSERpTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUserTEDITUSERpthisAppUser();
        setUpMockData4test4setAppUserTEDITUSERpthisAppUser();
        setUpMockData4test4getAppUserTEDITUSERpName();
        setUpMockData4test4setAppUserTEDITUSERpName();
        setUpMockData4test4getAppUserTEDITUSERpSurname();
        setUpMockData4test4setAppUserTEDITUSERpSurname();
        setUpMockData4test4getAppUserTEDITUSERpType();
        setUpMockData4test4setAppUserTEDITUSERpType();
    }

    private static void setUpMockData4test4getAppUserTEDITUSERpthisAppUser() {
    }

    private static void setUpMockData4test4setAppUserTEDITUSERpthisAppUser() {
        test4setAppUserTEDITUSERpthisAppUserArg1 = new AppUserOid();
    }

    private static void setUpMockData4test4getAppUserTEDITUSERpName() {
    }

    private static void setUpMockData4test4setAppUserTEDITUSERpName() {
        test4setAppUserTEDITUSERpNameArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTEDITUSERpSurname() {
    }

    private static void setUpMockData4test4setAppUserTEDITUSERpSurname() {
        test4setAppUserTEDITUSERpSurnameArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTEDITUSERpType() {
    }

    private static void setUpMockData4test4setAppUserTEDITUSERpType() {
        test4setAppUserTEDITUSERpTypeArg1 = "";
    }

    @Before
    public void setUp() {
        instanceTEDITUSERRequest = new TEDITUSERRequest();
        instanceTEDITUSERRequest.setAppUserTEDITUSERpthisAppUser(defValue4appUserTEDITUSERpthisAppUser);
        instanceTEDITUSERRequest.setAppUserTEDITUSERpthisAppUserInstance(defValue4appUserTEDITUSERpthisAppUserInstance);
        instanceTEDITUSERRequest.setAppUserTEDITUSERpName(defValue4appUserTEDITUSERpName);
        instanceTEDITUSERRequest.setAppUserTEDITUSERpSurname(defValue4appUserTEDITUSERpSurname);
        instanceTEDITUSERRequest.setAppUserTEDITUSERpType(defValue4appUserTEDITUSERpType);
    }

    @Test
    public void test4getAppUserTEDITUSERpthisAppUser() {
        assertEquals(defValue4appUserTEDITUSERpthisAppUser, instanceTEDITUSERRequest.getAppUserTEDITUSERpthisAppUser());
    }

    @Test
    public void test4setAppUserTEDITUSERpthisAppUser() {
        instanceTEDITUSERRequest.setAppUserTEDITUSERpthisAppUser(test4setAppUserTEDITUSERpthisAppUserArg1);
        assertNotNull(instanceTEDITUSERRequest);
    }

    @Test
    public void test4getAppUserTEDITUSERpName() {
        assertEquals(defValue4appUserTEDITUSERpName, instanceTEDITUSERRequest.getAppUserTEDITUSERpName());
    }

    @Test
    public void test4setAppUserTEDITUSERpName() {
        instanceTEDITUSERRequest.setAppUserTEDITUSERpName(test4setAppUserTEDITUSERpNameArg1);
        assertNotNull(instanceTEDITUSERRequest);
    }

    @Test
    public void test4getAppUserTEDITUSERpSurname() {
        assertEquals(defValue4appUserTEDITUSERpSurname, instanceTEDITUSERRequest.getAppUserTEDITUSERpSurname());
    }

    @Test
    public void test4setAppUserTEDITUSERpSurname() {
        instanceTEDITUSERRequest.setAppUserTEDITUSERpSurname(test4setAppUserTEDITUSERpSurnameArg1);
        assertNotNull(instanceTEDITUSERRequest);
    }

    @Test
    public void test4getAppUserTEDITUSERpType() {
        assertEquals(defValue4appUserTEDITUSERpType, instanceTEDITUSERRequest.getAppUserTEDITUSERpType());
    }

    @Test
    public void test4setAppUserTEDITUSERpType() {
        instanceTEDITUSERRequest.setAppUserTEDITUSERpType(test4setAppUserTEDITUSERpTypeArg1);
        assertNotNull(instanceTEDITUSERRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTEDITUSERRequest = new TEDITUSERRequest();
    	instanceTEDITUSERRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTEDITUSERRequest.checkArguments();
    }
}
