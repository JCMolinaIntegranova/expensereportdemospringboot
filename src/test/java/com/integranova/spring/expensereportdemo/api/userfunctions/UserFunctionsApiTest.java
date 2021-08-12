package com.integranova.spring.expensereportdemo.api.userfunctions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;

import com.integranova.spring.expensereportdemo.api.userfunctions.UserFunctionsApi;
import com.integranova.spring.expensereportdemo.global.UserFunctions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameResponse;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.Employee;

@RunWith(MockitoJUnitRunner.class)
public class UserFunctionsApiTest {

    @Mock
    private UserFunctions mockUserFunctions;

    @InjectMocks
    private UserFunctionsApi instanceUserFunctionsApi;

    // testGetEmployeeByName
    private static GetEmployeeByNameRequest testGetEmployeeByNameArg1;
    private static GetEmployeeByNameResponse testGetEmployeeByNameResult;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetEmployeeByName();
    }

    private static void setUpMockData4testGetEmployeeByName() {
        testGetEmployeeByNameArg1 = new GetEmployeeByNameRequest();
        testGetEmployeeByNameResult = new GetEmployeeByNameResponse();
        testGetEmployeeByNameResult.setFunctionResult(new EmployeeOid());
    }

    @Before
    public void setUp() {

        when(mockUserFunctions.getEmployeeByNameFun(eq(testGetEmployeeByNameArg1), anyMap())).thenReturn(new Employee());
    }

    @Test
    public void testGetEmployeeByName() {
        assertEquals(testGetEmployeeByNameResult.getFunctionResult(), instanceUserFunctionsApi.getEmployeeByName(testGetEmployeeByNameArg1).getFunctionResult());
    }
}
