package com.integranova.spring.expensereportdemo.api.operatoruser;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.operatoruser.OperatorUserApi;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.service.OperatorUserService;
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
public class OperatorUserApiTest {

    @Mock
    private OperatorUserService mockOperatorUserService;

    @InjectMocks
    private OperatorUserApi instanceOperatorUserApi;

    // testGetOperatorUser
    private static String testGetOperatorUserArg1;
    private static OperatorUser testGetOperatorUserResult;

    // testGetOperatorUserDynamic
    private static QueryRequest testGetOperatorUserDynamicArg1;
    private static OperatorUserOid mockGetOperatorUserDynamicArg1;
    private static String mockGetOperatorUserDynamicArg2;
    private static InstanceResponseViewModel testGetOperatorUserDynamicResult;

    // testGetOperatorUserWithDisplaySetDynamic
    private static QueryRequest testGetOperatorUserWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetOperatorUserWithDisplaySetDynamicResult;

    // testGetOperatorUserPopulationDynamic
    private static QueryRequest testGetOperatorUserPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetOperatorUserPopulationDynamicResult;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetOperatorUser();
        setUpMockData4testGetOperatorUserDynamic();
        setUpMockData4testGetOperatorUserWithDisplaySetDynamic();
        setUpMockData4testGetOperatorUserPopulationDynamic();
    }

    private static void setUpMockData4testGetOperatorUser() {
        testGetOperatorUserArg1 = "";
        testGetOperatorUserResult = new OperatorUser();
    }

    private static void setUpMockData4testGetOperatorUserDynamic() {
        mockGetOperatorUserDynamicArg1 = new OperatorUserOid();
        mockGetOperatorUserDynamicArg2 = "";
        testGetOperatorUserDynamicArg1 = new QueryRequest();
        testGetOperatorUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetOperatorUserWithDisplaySetDynamic() {
        testGetOperatorUserWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetOperatorUserWithDisplaySetDynamicArg1.setDisplaySetName("testGetOperatorUserWithDisplaySetDynamicArg1");
        testGetOperatorUserWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetOperatorUserPopulationDynamic() {
        testGetOperatorUserPopulationDynamicArg1 = new QueryRequest();
        testGetOperatorUserPopulationDynamicArg1.setDisplaySetName("testGetOperatorUserPopulationDynamicArg1");
        testGetOperatorUserPopulationDynamicResult = new PopulationResponseViewModel();
    }

    @Before
    public void setUp() {

        when(mockOperatorUserService.getById(testGetOperatorUserArg1)).thenReturn(testGetOperatorUserResult);

        when(mockOperatorUserService.getOperatorUserDynamic(mockGetOperatorUserDynamicArg1, mockGetOperatorUserDynamicArg2)).thenReturn(testGetOperatorUserDynamicResult);

        when(mockOperatorUserService.getDynamic(testGetOperatorUserWithDisplaySetDynamicArg1)).thenReturn(testGetOperatorUserWithDisplaySetDynamicResult);

        when(mockOperatorUserService.getDynamic(testGetOperatorUserPopulationDynamicArg1)).thenReturn(testGetOperatorUserPopulationDynamicResult);
    }

    @Test
    public void testGetOperatorUser() {
        assertEquals(testGetOperatorUserResult, instanceOperatorUserApi.getOperatorUser(testGetOperatorUserArg1));
    }

    @Test
    public void testGetOperatorUserDynamic() {
        assertEquals(testGetOperatorUserDynamicResult, instanceOperatorUserApi.getOperatorUserDynamic(testGetOperatorUserDynamicArg1));
    }

    @Test
    public void testGetOperatorUserWithDisplaySetDynamic() {
        assertEquals(testGetOperatorUserWithDisplaySetDynamicResult, instanceOperatorUserApi.getOperatorUserWithDisplaySetDynamic(testGetOperatorUserWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetOperatorUserPopulationDynamic() {
        assertEquals(testGetOperatorUserPopulationDynamicResult, instanceOperatorUserApi.getOperatorUserPopulationDynamic(testGetOperatorUserPopulationDynamicArg1));
    }
}
