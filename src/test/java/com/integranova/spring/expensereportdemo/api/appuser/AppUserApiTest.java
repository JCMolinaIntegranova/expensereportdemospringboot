package com.integranova.spring.expensereportdemo.api.appuser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.appuser.AppUserApi;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.service.AppUserService;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersResponse;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class AppUserApiTest {

    @Mock
    private AppUserService mockAppUserService;

    @InjectMocks
    private AppUserApi instanceAppUserApi;

    // testGetDSAppUsers
    private static String testGetDSAppUsersArg1;
    private static String testGetDSAppUsersArg2;
    private static String testGetDSAppUsersArg3;
    private static DSAppUsers testGetDSAppUsersResult;

    // testGetDSAppUsers2
    private static String testGetDSAppUsers2Arg1;
    private static String testGetDSAppUsers2Arg2;
    private static String testGetDSAppUsers2Arg3;
    private static DSAppUsers testGetDSAppUsers2Result;

    // testGetDSAppUsers3
    private static String testGetDSAppUsers3Arg1;
    private static String testGetDSAppUsers3Arg2;
    private static String testGetDSAppUsers3Arg3;
    private static DSAppUsers testGetDSAppUsers3Result;

    // testGetDSAppUsers4
    private static String testGetDSAppUsers4Arg1;
    private static String testGetDSAppUsers4Arg2;
    private static String testGetDSAppUsers4Arg3;
    private static DSAppUsers testGetDSAppUsers4Result;

    // testGetAppUser
    private static String testGetAppUserArg1;
    private static AppUser testGetAppUserResult;

    // testGetAppUserDynamic
    private static QueryRequest testGetAppUserDynamicArg1;
    private static AppUserOid mockGetAppUserDynamicArg1;
    private static String mockGetAppUserDynamicArg2;
    private static InstanceResponseViewModel testGetAppUserDynamicResult;

    // testGetAppUserWithDisplaySetDynamic
    private static QueryRequest testGetAppUserWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetAppUserWithDisplaySetDynamicResult;

    // testGetAppUserPopulationDynamic
    private static QueryRequest testGetAppUserPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetAppUserPopulationDynamicResult;

    // testAppUserNewUser
    private static NewUserRequest testAppUserNewUserArg1;
    private static ServiceResponse testAppUserNewUserResult;

    // testAppUserDeleteUser
    private static DeleteUserRequest testAppUserDeleteUserArg1;
    private static ServiceResponse testAppUserDeleteUserResult;

    // testAppUserEditUser
    private static EditUserRequest testAppUserEditUserArg1;
    private static ServiceResponse testAppUserEditUserResult;

    // testAppUserSetPassword
    private static SetPasswordRequest testAppUserSetPasswordArg1;
    private static ServiceResponse testAppUserSetPasswordResult;

    // testAppUserTNEWUSER
    private static TNEWUSERRequest testAppUserTNEWUSERArg1;
    private static ServiceResponse testAppUserTNEWUSERResult;

    // testAppUserTEDITUSER
    private static TEDITUSERRequest testAppUserTEDITUSERArg1;
    private static ServiceResponse testAppUserTEDITUSERResult;

    // testAppUserTDELETE
    private static TDELETERequest testAppUserTDELETEArg1;
    private static ServiceResponse testAppUserTDELETEResult;

    // testpiuPIUAppUsers
    private static PIUAppUsersRequest testpiuPIUAppUsersArg1;
    private static QueryRequest testpiuPIUAppUsersMockArg1;
    private static List<DSAppUsers> testpiuPIUAppUsersMockResult;
    private static PIUAppUsersResponse testpiuPIUAppUsersResult;

    // testpiuPIUAppUsers2
    private static PIUAppUsersRequest testpiuPIUAppUsers2Arg1;
    private static QueryRequest testpiuPIUAppUsers2MockArg1;
    private static List<DSAppUsers> testpiuPIUAppUsers2MockResult;
    private static PIUAppUsersResponse testpiuPIUAppUsers2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSAppUsers();
        setUpMockData4testGetDSAppUsers2();
        setUpMockData4testGetDSAppUsers3();
        setUpMockData4testGetDSAppUsers4();
        setUpMockData4testGetAppUser();
        setUpMockData4testGetAppUserDynamic();
        setUpMockData4testGetAppUserWithDisplaySetDynamic();
        setUpMockData4testGetAppUserPopulationDynamic();
        setUpMockData4testAppUserNewUser();
        setUpMockData4testAppUserDeleteUser();
        setUpMockData4testAppUserEditUser();
        setUpMockData4testAppUserSetPassword();
        setUpMockData4testAppUserTNEWUSER();
        setUpMockData4testAppUserTEDITUSER();
        setUpMockData4testAppUserTDELETE();
        setUpMockData4testpiuPIUAppUsers();
        setUpMockData4testpiuPIUAppUsers2();
    }

    private static void setUpMockData4testGetDSAppUsers() {
        testGetDSAppUsersArg1 = "";
        testGetDSAppUsersArg2 = "";
        testGetDSAppUsersArg3 = "";
        testGetDSAppUsersResult = new DSAppUsers();
    }

    private static void setUpMockData4testGetDSAppUsers2() {
        testGetDSAppUsers2Arg1 = "";
        testGetDSAppUsers2Arg2 = null;
        testGetDSAppUsers2Arg3 = null;
        testGetDSAppUsers2Result = testGetDSAppUsersResult;
    }

    private static void setUpMockData4testGetDSAppUsers3() {
        testGetDSAppUsers3Arg1 = "";
        testGetDSAppUsers3Arg2 = null;
        testGetDSAppUsers3Arg3 = "";
        testGetDSAppUsers3Result = testGetDSAppUsersResult;
    }

    private static void setUpMockData4testGetDSAppUsers4() {
        testGetDSAppUsers4Arg1 = "";
        testGetDSAppUsers4Arg2 = "";
        testGetDSAppUsers4Arg3 = null;
        testGetDSAppUsers4Result = testGetDSAppUsersResult;
    }

    private static void setUpMockData4testGetAppUser() {
        testGetAppUserArg1 = "";
        testGetAppUserResult = new AppUser();
    }

    private static void setUpMockData4testGetAppUserDynamic() {
        mockGetAppUserDynamicArg1 = new AppUserOid();
        mockGetAppUserDynamicArg2 = "";
        testGetAppUserDynamicArg1 = new QueryRequest();
        testGetAppUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetAppUserWithDisplaySetDynamic() {
        testGetAppUserWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetAppUserWithDisplaySetDynamicArg1.setDisplaySetName("testGetAppUserWithDisplaySetDynamicArg1");
        testGetAppUserWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetAppUserPopulationDynamic() {
        testGetAppUserPopulationDynamicArg1 = new QueryRequest();
        testGetAppUserPopulationDynamicArg1.setDisplaySetName("testGetAppUserPopulationDynamicArg1");
        testGetAppUserPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testAppUserNewUser() {
        testAppUserNewUserArg1 = new NewUserRequest();
        testAppUserNewUserResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserDeleteUser() {
        testAppUserDeleteUserArg1 = new DeleteUserRequest();
        testAppUserDeleteUserResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserEditUser() {
        testAppUserEditUserArg1 = new EditUserRequest();
        testAppUserEditUserResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserSetPassword() {
        testAppUserSetPasswordArg1 = new SetPasswordRequest();
        testAppUserSetPasswordResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserTNEWUSER() {
        testAppUserTNEWUSERArg1 = new TNEWUSERRequest();
        testAppUserTNEWUSERResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserTEDITUSER() {
        testAppUserTEDITUSERArg1 = new TEDITUSERRequest();
        testAppUserTEDITUSERResult = new ServiceResponse();
    }

    private static void setUpMockData4testAppUserTDELETE() {
        testAppUserTDELETEArg1 = new TDELETERequest();
        testAppUserTDELETEResult = new ServiceResponse();
    }

    private static void setUpMockData4testpiuPIUAppUsers() {
        testpiuPIUAppUsersMockArg1 = new QueryRequest();
        testpiuPIUAppUsersMockArg1.setPageSize(0);
        testpiuPIUAppUsersMockResult = new ArrayList<>();
        testpiuPIUAppUsersArg1 = mock(PIUAppUsersRequest.class);
        testpiuPIUAppUsersResult = new PIUAppUsersResponse();
    }

    private static void setUpMockData4testpiuPIUAppUsers2() {
        testpiuPIUAppUsers2MockArg1 = new QueryRequest();
        testpiuPIUAppUsers2MockArg1.setPageSize(1);
        testpiuPIUAppUsers2MockResult = new ArrayList<>();
        testpiuPIUAppUsers2MockResult.add(new DSAppUsers());
        testpiuPIUAppUsers2Arg1 = mock(PIUAppUsersRequest.class);
        testpiuPIUAppUsers2Arg1.setPageSize(1);
        testpiuPIUAppUsers2Result = new PIUAppUsersResponse();
        testpiuPIUAppUsers2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockAppUserService.getDSAppUsers(testGetDSAppUsersArg1, testGetDSAppUsersArg2, testGetDSAppUsersArg3)).thenReturn(testGetDSAppUsersResult);

        when(mockAppUserService.getById(testGetAppUserArg1)).thenReturn(testGetAppUserResult);

        when(mockAppUserService.getAppUserDynamic(mockGetAppUserDynamicArg1, mockGetAppUserDynamicArg2)).thenReturn(testGetAppUserDynamicResult);

        when(mockAppUserService.getDynamic(testGetAppUserWithDisplaySetDynamicArg1)).thenReturn(testGetAppUserWithDisplaySetDynamicResult);

        when(mockAppUserService.getDynamic(testGetAppUserPopulationDynamicArg1)).thenReturn(testGetAppUserPopulationDynamicResult);

        when(mockAppUserService.newUser(testAppUserNewUserArg1)).thenReturn(testAppUserNewUserResult);

        when(mockAppUserService.deleteUser(testAppUserDeleteUserArg1)).thenReturn(testAppUserDeleteUserResult);

        when(mockAppUserService.editUser(testAppUserEditUserArg1)).thenReturn(testAppUserEditUserResult);

        when(mockAppUserService.setPassword(testAppUserSetPasswordArg1)).thenReturn(testAppUserSetPasswordResult);

        when(mockAppUserService.tNEWUSER(testAppUserTNEWUSERArg1)).thenReturn(testAppUserTNEWUSERResult);

        when(mockAppUserService.tEDITUSER(testAppUserTEDITUSERArg1)).thenReturn(testAppUserTEDITUSERResult);

        when(mockAppUserService.tDELETE(testAppUserTDELETEArg1)).thenReturn(testAppUserTDELETEResult);

        when(testpiuPIUAppUsersArg1.buildQueryRequest()).thenReturn(testpiuPIUAppUsersMockArg1);

        when(mockAppUserService.piuPIUAppUsers(testpiuPIUAppUsersMockArg1)).thenReturn(testpiuPIUAppUsersMockResult);

        when(testpiuPIUAppUsers2Arg1.buildQueryRequest()).thenReturn(testpiuPIUAppUsers2MockArg1);

        when(mockAppUserService.piuPIUAppUsers(testpiuPIUAppUsers2MockArg1)).thenReturn(testpiuPIUAppUsers2MockResult);

        when(mockAppUserService.getCount4PIUAppUsers(testpiuPIUAppUsers2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSAppUsers() {
        assertEquals(testGetDSAppUsersResult, instanceAppUserApi.getDSAppUsers(testGetDSAppUsersArg1, testGetDSAppUsersArg2, testGetDSAppUsersArg3));
    }

    @Test
    public void testGetDSAppUsers2() {
        assertEquals(testGetDSAppUsers2Result, instanceAppUserApi.getDSAppUsers(testGetDSAppUsers2Arg1, testGetDSAppUsers2Arg2, testGetDSAppUsers2Arg3));
    }

    @Test
    public void testGetDSAppUsers3() {
        assertEquals(testGetDSAppUsers3Result, instanceAppUserApi.getDSAppUsers(testGetDSAppUsers3Arg1, testGetDSAppUsers3Arg2, testGetDSAppUsers3Arg3));
    }

    @Test
    public void testGetDSAppUsers4() {
        assertEquals(testGetDSAppUsers4Result, instanceAppUserApi.getDSAppUsers(testGetDSAppUsers4Arg1, testGetDSAppUsers4Arg2, testGetDSAppUsers4Arg3));
    }

    @Test
    public void testGetAppUser() {
        assertEquals(testGetAppUserResult, instanceAppUserApi.getAppUser(testGetAppUserArg1));
    }

    @Test
    public void testGetAppUserDynamic() {
        assertEquals(testGetAppUserDynamicResult, instanceAppUserApi.getAppUserDynamic(testGetAppUserDynamicArg1));
    }

    @Test
    public void testGetAppUserWithDisplaySetDynamic() {
        assertEquals(testGetAppUserWithDisplaySetDynamicResult, instanceAppUserApi.getAppUserWithDisplaySetDynamic(testGetAppUserWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetAppUserPopulationDynamic() {
        assertEquals(testGetAppUserPopulationDynamicResult, instanceAppUserApi.getAppUserPopulationDynamic(testGetAppUserPopulationDynamicArg1));
    }

    @Test
    public void testAppUserNewUser() {
        assertEquals(testAppUserNewUserResult, instanceAppUserApi.appUserNewUser(testAppUserNewUserArg1));
    }

    @Test
    public void testAppUserDeleteUser() {
        assertEquals(testAppUserDeleteUserResult, instanceAppUserApi.appUserDeleteUser(testAppUserDeleteUserArg1));
    }

    @Test
    public void testAppUserEditUser() {
        assertEquals(testAppUserEditUserResult, instanceAppUserApi.appUserEditUser(testAppUserEditUserArg1));
    }

    @Test
    public void testAppUserSetPassword() {
        assertEquals(testAppUserSetPasswordResult, instanceAppUserApi.appUserSetPassword(testAppUserSetPasswordArg1));
    }

    @Test
    public void testAppUserTNEWUSER() {
        assertEquals(testAppUserTNEWUSERResult, instanceAppUserApi.appUserTNEWUSER(testAppUserTNEWUSERArg1));
    }

    @Test
    public void testAppUserTEDITUSER() {
        assertEquals(testAppUserTEDITUSERResult, instanceAppUserApi.appUserTEDITUSER(testAppUserTEDITUSERArg1));
    }

    @Test
    public void testAppUserTDELETE() {
        assertEquals(testAppUserTDELETEResult, instanceAppUserApi.appUserTDELETE(testAppUserTDELETEArg1));
    }

    @Test
    public void testpiuPIUAppUsers() {
        assertEquals(testpiuPIUAppUsersResult.getTotalItems(), instanceAppUserApi.piuPIUAppUsers(testpiuPIUAppUsersArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUAppUsers2() {
        assertEquals(testpiuPIUAppUsers2Result.getTotalItems(), instanceAppUserApi.piuPIUAppUsers(testpiuPIUAppUsers2Arg1).getTotalItems());
    }
}
