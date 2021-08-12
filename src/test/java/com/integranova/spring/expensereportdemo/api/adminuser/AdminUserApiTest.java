package com.integranova.spring.expensereportdemo.api.adminuser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.adminuser.AdminUserApi;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.service.AdminUserService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserApiTest {

    @Mock
    private AdminUserService mockAdminUserService;

    @InjectMocks
    private AdminUserApi instanceAdminUserApi;

    // testGetAdminUser
    private static String testGetAdminUserArg1;
    private static AdminUser testGetAdminUserResult;

    // testGetAdminUserDynamic
    private static QueryRequest testGetAdminUserDynamicArg1;
    private static AdminUserOid mockGetAdminUserDynamicArg1;
    private static String mockGetAdminUserDynamicArg2;
    private static InstanceResponseViewModel testGetAdminUserDynamicResult;

    // testGetAdminUserWithDisplaySetDynamic
    private static QueryRequest testGetAdminUserWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetAdminUserWithDisplaySetDynamicResult;

    // testGetAdminUserPopulationDynamic
    private static QueryRequest testGetAdminUserPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetAdminUserPopulationDynamicResult;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetAdminUser();
        setUpMockData4testGetAdminUserDynamic();
        setUpMockData4testGetAdminUserWithDisplaySetDynamic();
        setUpMockData4testGetAdminUserPopulationDynamic();
    }

    private static void setUpMockData4testGetAdminUser() {
        testGetAdminUserArg1 = "";
        testGetAdminUserResult = new AdminUser();
    }

    private static void setUpMockData4testGetAdminUserDynamic() {
        mockGetAdminUserDynamicArg1 = new AdminUserOid();
        mockGetAdminUserDynamicArg2 = "";
        testGetAdminUserDynamicArg1 = new QueryRequest();
        testGetAdminUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetAdminUserWithDisplaySetDynamic() {
        testGetAdminUserWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetAdminUserWithDisplaySetDynamicArg1.setDisplaySetName("testGetAdminUserWithDisplaySetDynamicArg1");
        testGetAdminUserWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetAdminUserPopulationDynamic() {
        testGetAdminUserPopulationDynamicArg1 = new QueryRequest();
        testGetAdminUserPopulationDynamicArg1.setDisplaySetName("testGetAdminUserPopulationDynamicArg1");
        testGetAdminUserPopulationDynamicResult = new PopulationResponseViewModel();
    }

    @Before
    public void setUp() {

        when(mockAdminUserService.getById(testGetAdminUserArg1)).thenReturn(testGetAdminUserResult);

        when(mockAdminUserService.getAdminUserDynamic(mockGetAdminUserDynamicArg1, mockGetAdminUserDynamicArg2)).thenReturn(testGetAdminUserDynamicResult);

        when(mockAdminUserService.getDynamic(testGetAdminUserWithDisplaySetDynamicArg1)).thenReturn(testGetAdminUserWithDisplaySetDynamicResult);

        when(mockAdminUserService.getDynamic(testGetAdminUserPopulationDynamicArg1)).thenReturn(testGetAdminUserPopulationDynamicResult);
    }

    @Test
    public void testGetAdminUser() {
        assertEquals(testGetAdminUserResult, instanceAdminUserApi.getAdminUser(testGetAdminUserArg1));
    }

    @Test
    public void testGetAdminUserDynamic() {
        assertEquals(testGetAdminUserDynamicResult, instanceAdminUserApi.getAdminUserDynamic(testGetAdminUserDynamicArg1));
    }

    @Test
    public void testGetAdminUserWithDisplaySetDynamic() {
        assertEquals(testGetAdminUserWithDisplaySetDynamicResult, instanceAdminUserApi.getAdminUserWithDisplaySetDynamic(testGetAdminUserWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetAdminUserPopulationDynamic() {
        assertEquals(testGetAdminUserPopulationDynamicResult, instanceAdminUserApi.getAdminUserPopulationDynamic(testGetAdminUserPopulationDynamicArg1));
    }
}
