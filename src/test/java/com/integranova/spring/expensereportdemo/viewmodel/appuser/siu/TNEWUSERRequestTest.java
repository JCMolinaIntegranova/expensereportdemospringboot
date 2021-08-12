package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TNEWUSERRequestTest {

    private TNEWUSERRequest instanceTNEWUSERRequest;

    // Default values
    private static String defValue4appUserTNEWUSERpLogin = "";
    private static String defValue4appUserTNEWUSERpName = "";
    private static String defValue4appUserTNEWUSERpSurname = "";
    private static String defValue4appUserTNEWUSERpType = "";
    private static String defValue4appUserTNEWUSERpPassword = "";


    // test4getAppUserTNEWUSERpLogin

    // test4setAppUserTNEWUSERpLogin
    private static String test4setAppUserTNEWUSERpLoginArg1;

    // test4getAppUserTNEWUSERpName

    // test4setAppUserTNEWUSERpName
    private static String test4setAppUserTNEWUSERpNameArg1;

    // test4getAppUserTNEWUSERpSurname

    // test4setAppUserTNEWUSERpSurname
    private static String test4setAppUserTNEWUSERpSurnameArg1;

    // test4getAppUserTNEWUSERpType

    // test4setAppUserTNEWUSERpType
    private static String test4setAppUserTNEWUSERpTypeArg1;

    // test4getAppUserTNEWUSERpPassword

    // test4setAppUserTNEWUSERpPassword
    private static String test4setAppUserTNEWUSERpPasswordArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAppUserTNEWUSERpLogin();
        setUpMockData4test4setAppUserTNEWUSERpLogin();
        setUpMockData4test4getAppUserTNEWUSERpName();
        setUpMockData4test4setAppUserTNEWUSERpName();
        setUpMockData4test4getAppUserTNEWUSERpSurname();
        setUpMockData4test4setAppUserTNEWUSERpSurname();
        setUpMockData4test4getAppUserTNEWUSERpType();
        setUpMockData4test4setAppUserTNEWUSERpType();
        setUpMockData4test4getAppUserTNEWUSERpPassword();
        setUpMockData4test4setAppUserTNEWUSERpPassword();
    }

    private static void setUpMockData4test4getAppUserTNEWUSERpLogin() {
    }

    private static void setUpMockData4test4setAppUserTNEWUSERpLogin() {
        test4setAppUserTNEWUSERpLoginArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTNEWUSERpName() {
    }

    private static void setUpMockData4test4setAppUserTNEWUSERpName() {
        test4setAppUserTNEWUSERpNameArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTNEWUSERpSurname() {
    }

    private static void setUpMockData4test4setAppUserTNEWUSERpSurname() {
        test4setAppUserTNEWUSERpSurnameArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTNEWUSERpType() {
    }

    private static void setUpMockData4test4setAppUserTNEWUSERpType() {
        test4setAppUserTNEWUSERpTypeArg1 = "";
    }

    private static void setUpMockData4test4getAppUserTNEWUSERpPassword() {
    }

    private static void setUpMockData4test4setAppUserTNEWUSERpPassword() {
        test4setAppUserTNEWUSERpPasswordArg1 = "";
    }

    @Before
    public void setUp() {
        instanceTNEWUSERRequest = new TNEWUSERRequest();
        instanceTNEWUSERRequest.setAppUserTNEWUSERpLogin(defValue4appUserTNEWUSERpLogin);
        instanceTNEWUSERRequest.setAppUserTNEWUSERpName(defValue4appUserTNEWUSERpName);
        instanceTNEWUSERRequest.setAppUserTNEWUSERpSurname(defValue4appUserTNEWUSERpSurname);
        instanceTNEWUSERRequest.setAppUserTNEWUSERpType(defValue4appUserTNEWUSERpType);
        instanceTNEWUSERRequest.setAppUserTNEWUSERpPassword(defValue4appUserTNEWUSERpPassword);
    }

    @Test
    public void test4getAppUserTNEWUSERpLogin() {
        assertEquals(defValue4appUserTNEWUSERpLogin, instanceTNEWUSERRequest.getAppUserTNEWUSERpLogin());
    }

    @Test
    public void test4setAppUserTNEWUSERpLogin() {
        instanceTNEWUSERRequest.setAppUserTNEWUSERpLogin(test4setAppUserTNEWUSERpLoginArg1);
        assertNotNull(instanceTNEWUSERRequest);
    }

    @Test
    public void test4getAppUserTNEWUSERpName() {
        assertEquals(defValue4appUserTNEWUSERpName, instanceTNEWUSERRequest.getAppUserTNEWUSERpName());
    }

    @Test
    public void test4setAppUserTNEWUSERpName() {
        instanceTNEWUSERRequest.setAppUserTNEWUSERpName(test4setAppUserTNEWUSERpNameArg1);
        assertNotNull(instanceTNEWUSERRequest);
    }

    @Test
    public void test4getAppUserTNEWUSERpSurname() {
        assertEquals(defValue4appUserTNEWUSERpSurname, instanceTNEWUSERRequest.getAppUserTNEWUSERpSurname());
    }

    @Test
    public void test4setAppUserTNEWUSERpSurname() {
        instanceTNEWUSERRequest.setAppUserTNEWUSERpSurname(test4setAppUserTNEWUSERpSurnameArg1);
        assertNotNull(instanceTNEWUSERRequest);
    }

    @Test
    public void test4getAppUserTNEWUSERpType() {
        assertEquals(defValue4appUserTNEWUSERpType, instanceTNEWUSERRequest.getAppUserTNEWUSERpType());
    }

    @Test
    public void test4setAppUserTNEWUSERpType() {
        instanceTNEWUSERRequest.setAppUserTNEWUSERpType(test4setAppUserTNEWUSERpTypeArg1);
        assertNotNull(instanceTNEWUSERRequest);
    }

    @Test
    public void test4getAppUserTNEWUSERpPassword() {
        assertEquals(defValue4appUserTNEWUSERpPassword, instanceTNEWUSERRequest.getAppUserTNEWUSERpPassword());
    }

    @Test
    public void test4setAppUserTNEWUSERpPassword() {
        instanceTNEWUSERRequest.setAppUserTNEWUSERpPassword(test4setAppUserTNEWUSERpPasswordArg1);
        assertNotNull(instanceTNEWUSERRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTNEWUSERRequest = new TNEWUSERRequest();
    	instanceTNEWUSERRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTNEWUSERRequest.checkArguments();
    }
}
