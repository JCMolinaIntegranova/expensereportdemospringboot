package com.integranova.spring.expensereportdemo.api.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.employee.EmployeeApi;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.service.EmployeeService;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup;
import com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
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
public class EmployeeApiTest {

    @Mock
    private EmployeeService mockEmployeeService;

    @InjectMocks
    private EmployeeApi instanceEmployeeApi;

    // testGetDSEmployee
    private static String testGetDSEmployeeArg1;
    private static String testGetDSEmployeeArg2;
    private static String testGetDSEmployeeArg3;
    private static DSEmployee testGetDSEmployeeResult;

    // testGetDSEmployee2
    private static String testGetDSEmployee2Arg1;
    private static String testGetDSEmployee2Arg2;
    private static String testGetDSEmployee2Arg3;
    private static DSEmployee testGetDSEmployee2Result;

    // testGetDSEmployee3
    private static String testGetDSEmployee3Arg1;
    private static String testGetDSEmployee3Arg2;
    private static String testGetDSEmployee3Arg3;
    private static DSEmployee testGetDSEmployee3Result;

    // testGetDSEmployee4
    private static String testGetDSEmployee4Arg1;
    private static String testGetDSEmployee4Arg2;
    private static String testGetDSEmployee4Arg3;
    private static DSEmployee testGetDSEmployee4Result;

    // testGetDSEmployeeSup
    private static String testGetDSEmployeeSupArg1;
    private static String testGetDSEmployeeSupArg2;
    private static String testGetDSEmployeeSupArg3;
    private static DSEmployeeSup testGetDSEmployeeSupResult;

    // testGetDSEmployeeSup2
    private static String testGetDSEmployeeSup2Arg1;
    private static String testGetDSEmployeeSup2Arg2;
    private static String testGetDSEmployeeSup2Arg3;
    private static DSEmployeeSup testGetDSEmployeeSup2Result;

    // testGetDSEmployeeSup3
    private static String testGetDSEmployeeSup3Arg1;
    private static String testGetDSEmployeeSup3Arg2;
    private static String testGetDSEmployeeSup3Arg3;
    private static DSEmployeeSup testGetDSEmployeeSup3Result;

    // testGetDSEmployeeSup4
    private static String testGetDSEmployeeSup4Arg1;
    private static String testGetDSEmployeeSup4Arg2;
    private static String testGetDSEmployeeSup4Arg3;
    private static DSEmployeeSup testGetDSEmployeeSup4Result;

    // testGetEmployee
    private static String testGetEmployeeArg1;
    private static Employee testGetEmployeeResult;

    // testGetEmployeeDynamic
    private static QueryRequest testGetEmployeeDynamicArg1;
    private static EmployeeOid mockGetEmployeeDynamicArg1;
    private static String mockGetEmployeeDynamicArg2;
    private static InstanceResponseViewModel testGetEmployeeDynamicResult;

    // testGetEmployeePreload
    private static QueryRequest testGetEmployeePreloadArg1;
    private static List<PreloadViewModel> testGetEmployeePreloadResult;

    // testGetEmployeeWithDisplaySetDynamic
    private static QueryRequest testGetEmployeeWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetEmployeeWithDisplaySetDynamicResult;

    // testGetEmployeePopulationDynamic
    private static QueryRequest testGetEmployeePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetEmployeePopulationDynamicResult;

    // testEmployeeCreateinstance
    private static CreateinstanceRequest testEmployeeCreateinstanceArg1;
    private static ServiceResponse testEmployeeCreateinstanceResult;

    // testEmployeeDeleteinstance
    private static DeleteinstanceRequest testEmployeeDeleteinstanceArg1;
    private static ServiceResponse testEmployeeDeleteinstanceResult;

    // testEmployeeEditinstance
    private static EditinstanceRequest testEmployeeEditinstanceArg1;
    private static ServiceResponse testEmployeeEditinstanceResult;

    // testEmployeeChangePicture
    private static ChangePictureRequest testEmployeeChangePictureArg1;
    private static ServiceResponse testEmployeeChangePictureResult;

    // testEmployeeAddEmployeeToTeam
    private static AddEmployeeToTeamRequest testEmployeeAddEmployeeToTeamArg1;
    private static ServiceResponse testEmployeeAddEmployeeToTeamResult;

    // testEmployeeAddEmployeeToTeamCheckPreconditions
    private static AddEmployeeToTeamRequest testEmployeeAddEmployeeToTeamCheckPreconditionsArg1;
    private static ServiceResponse testEmployeeAddEmployeeToTeamCheckPreconditionsResult;

    // testEmployeeRemoveEmployeeFromTeam
    private static RemoveEmployeeFromTeamRequest testEmployeeRemoveEmployeeFromTeamArg1;
    private static ServiceResponse testEmployeeRemoveEmployeeFromTeamResult;

    // testEmployeeTDELETE
    private static TDELETERequest testEmployeeTDELETEArg1;
    private static ServiceResponse testEmployeeTDELETEResult;

    // testiiuIIUEmployee
    private static EmployeeOid testiiuIIUEmployeeArg1;
    private static DSEmployee testiiuIIUEmployeeResult;

    // testiiuIIUEmployeeReports
    private static EmployeeOid testiiuIIUEmployeeReportsArg1;
    private static DSEmployee testiiuIIUEmployeeReportsResult;

    // testpiuPIUEmployee
    private static PIUEmployeeRequest testpiuPIUEmployeeArg1;
    private static QueryRequest testpiuPIUEmployeeMockArg1;
    private static List<DSEmployee> testpiuPIUEmployeeMockResult;
    private static PIUEmployeeResponse testpiuPIUEmployeeResult;

    // testpiuPIUEmployee2
    private static PIUEmployeeRequest testpiuPIUEmployee2Arg1;
    private static QueryRequest testpiuPIUEmployee2MockArg1;
    private static List<DSEmployee> testpiuPIUEmployee2MockResult;
    private static PIUEmployeeResponse testpiuPIUEmployee2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSEmployee();
        setUpMockData4testGetDSEmployee2();
        setUpMockData4testGetDSEmployee3();
        setUpMockData4testGetDSEmployee4();
        setUpMockData4testGetDSEmployeeSup();
        setUpMockData4testGetDSEmployeeSup2();
        setUpMockData4testGetDSEmployeeSup3();
        setUpMockData4testGetDSEmployeeSup4();
        setUpMockData4testGetEmployee();
        setUpMockData4testGetEmployeeDynamic();
        setUpMockData4testGetEmployeePreload();
        setUpMockData4testGetEmployeeWithDisplaySetDynamic();
        setUpMockData4testGetEmployeePopulationDynamic();
        setUpMockData4testEmployeeCreateinstance();
        setUpMockData4testEmployeeDeleteinstance();
        setUpMockData4testEmployeeEditinstance();
        setUpMockData4testEmployeeChangePicture();
        setUpMockData4testEmployeeAddEmployeeToTeam();
        setUpMockData4testEmployeeAddEmployeeToTeamCheckPreconditions();
        setUpMockData4testEmployeeRemoveEmployeeFromTeam();
        setUpMockData4testEmployeeTDELETE();
        setUpMockData4testiiuIIUEmployee();
        setUpMockData4testiiuIIUEmployeeReports();
        setUpMockData4testpiuPIUEmployee();
        setUpMockData4testpiuPIUEmployee2();
    }

    private static void setUpMockData4testGetDSEmployee() {
        testGetDSEmployeeArg1 = "";
        testGetDSEmployeeArg2 = "";
        testGetDSEmployeeArg3 = "";
        testGetDSEmployeeResult = new DSEmployee();
    }

    private static void setUpMockData4testGetDSEmployee2() {
        testGetDSEmployee2Arg1 = "";
        testGetDSEmployee2Arg2 = null;
        testGetDSEmployee2Arg3 = null;
        testGetDSEmployee2Result = testGetDSEmployeeResult;
    }

    private static void setUpMockData4testGetDSEmployee3() {
        testGetDSEmployee3Arg1 = "";
        testGetDSEmployee3Arg2 = null;
        testGetDSEmployee3Arg3 = "";
        testGetDSEmployee3Result = testGetDSEmployeeResult;
    }

    private static void setUpMockData4testGetDSEmployee4() {
        testGetDSEmployee4Arg1 = "";
        testGetDSEmployee4Arg2 = "";
        testGetDSEmployee4Arg3 = null;
        testGetDSEmployee4Result = testGetDSEmployeeResult;
    }

    private static void setUpMockData4testGetDSEmployeeSup() {
        testGetDSEmployeeSupArg1 = "";
        testGetDSEmployeeSupArg2 = "";
        testGetDSEmployeeSupArg3 = "";
        testGetDSEmployeeSupResult = new DSEmployeeSup();
    }

    private static void setUpMockData4testGetDSEmployeeSup2() {
        testGetDSEmployeeSup2Arg1 = "";
        testGetDSEmployeeSup2Arg2 = null;
        testGetDSEmployeeSup2Arg3 = null;
        testGetDSEmployeeSup2Result = testGetDSEmployeeSupResult;
    }

    private static void setUpMockData4testGetDSEmployeeSup3() {
        testGetDSEmployeeSup3Arg1 = "";
        testGetDSEmployeeSup3Arg2 = null;
        testGetDSEmployeeSup3Arg3 = "";
        testGetDSEmployeeSup3Result = testGetDSEmployeeSupResult;
    }

    private static void setUpMockData4testGetDSEmployeeSup4() {
        testGetDSEmployeeSup4Arg1 = "";
        testGetDSEmployeeSup4Arg2 = "";
        testGetDSEmployeeSup4Arg3 = null;
        testGetDSEmployeeSup4Result = testGetDSEmployeeSupResult;
    }

    private static void setUpMockData4testGetEmployee() {
        testGetEmployeeArg1 = "";
        testGetEmployeeResult = new Employee();
    }

    private static void setUpMockData4testGetEmployeeDynamic() {
        mockGetEmployeeDynamicArg1 = new EmployeeOid();
        mockGetEmployeeDynamicArg2 = "";
        testGetEmployeeDynamicArg1 = new QueryRequest();
        testGetEmployeeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetEmployeePreload() {
        testGetEmployeePreloadArg1 = new QueryRequest();
        testGetEmployeePreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetEmployeeWithDisplaySetDynamic() {
        testGetEmployeeWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetEmployeeWithDisplaySetDynamicArg1.setDisplaySetName("testGetEmployeeWithDisplaySetDynamicArg1");
        testGetEmployeeWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetEmployeePopulationDynamic() {
        testGetEmployeePopulationDynamicArg1 = new QueryRequest();
        testGetEmployeePopulationDynamicArg1.setDisplaySetName("testGetEmployeePopulationDynamicArg1");
        testGetEmployeePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testEmployeeCreateinstance() {
        testEmployeeCreateinstanceArg1 = new CreateinstanceRequest();
        testEmployeeCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeDeleteinstance() {
        testEmployeeDeleteinstanceArg1 = new DeleteinstanceRequest();
        testEmployeeDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeEditinstance() {
        testEmployeeEditinstanceArg1 = new EditinstanceRequest();
        testEmployeeEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeChangePicture() {
        testEmployeeChangePictureArg1 = new ChangePictureRequest();
        testEmployeeChangePictureResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeAddEmployeeToTeam() {
        testEmployeeAddEmployeeToTeamArg1 = new AddEmployeeToTeamRequest();
        testEmployeeAddEmployeeToTeamResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeAddEmployeeToTeamCheckPreconditions() {
        testEmployeeAddEmployeeToTeamCheckPreconditionsArg1 = new AddEmployeeToTeamRequest();
        testEmployeeAddEmployeeToTeamCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeRemoveEmployeeFromTeam() {
        testEmployeeRemoveEmployeeFromTeamArg1 = new RemoveEmployeeFromTeamRequest();
        testEmployeeRemoveEmployeeFromTeamResult = new ServiceResponse();
    }

    private static void setUpMockData4testEmployeeTDELETE() {
        testEmployeeTDELETEArg1 = new TDELETERequest();
        testEmployeeTDELETEResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUEmployee() {
        testiiuIIUEmployeeArg1 = new EmployeeOid();
        testiiuIIUEmployeeResult = new DSEmployee();
    }

    private static void setUpMockData4testiiuIIUEmployeeReports() {
        testiiuIIUEmployeeReportsArg1 = new EmployeeOid();
        testiiuIIUEmployeeReportsResult = new DSEmployee();
    }

    private static void setUpMockData4testpiuPIUEmployee() {
        testpiuPIUEmployeeMockArg1 = new QueryRequest();
        testpiuPIUEmployeeMockArg1.setPageSize(0);
        testpiuPIUEmployeeMockResult = new ArrayList<>();
        testpiuPIUEmployeeArg1 = mock(PIUEmployeeRequest.class);
        testpiuPIUEmployeeResult = new PIUEmployeeResponse();
    }

    private static void setUpMockData4testpiuPIUEmployee2() {
        testpiuPIUEmployee2MockArg1 = new QueryRequest();
        testpiuPIUEmployee2MockArg1.setPageSize(1);
        testpiuPIUEmployee2MockResult = new ArrayList<>();
        testpiuPIUEmployee2MockResult.add(new DSEmployee());
        testpiuPIUEmployee2Arg1 = mock(PIUEmployeeRequest.class);
        testpiuPIUEmployee2Arg1.setPageSize(1);
        testpiuPIUEmployee2Result = new PIUEmployeeResponse();
        testpiuPIUEmployee2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockEmployeeService.getDSEmployee(testGetDSEmployeeArg1, testGetDSEmployeeArg2, testGetDSEmployeeArg3)).thenReturn(testGetDSEmployeeResult);

        when(mockEmployeeService.getDSEmployeeSup(testGetDSEmployeeSupArg1, testGetDSEmployeeSupArg2, testGetDSEmployeeSupArg3)).thenReturn(testGetDSEmployeeSupResult);

        when(mockEmployeeService.getById(testGetEmployeeArg1)).thenReturn(testGetEmployeeResult);

        when(mockEmployeeService.getEmployeeDynamic(mockGetEmployeeDynamicArg1, mockGetEmployeeDynamicArg2)).thenReturn(testGetEmployeeDynamicResult);

        when(mockEmployeeService.getPreload(testGetEmployeePreloadArg1)).thenReturn(testGetEmployeePreloadResult);

        when(mockEmployeeService.getDynamic(testGetEmployeeWithDisplaySetDynamicArg1)).thenReturn(testGetEmployeeWithDisplaySetDynamicResult);

        when(mockEmployeeService.getDynamic(testGetEmployeePopulationDynamicArg1)).thenReturn(testGetEmployeePopulationDynamicResult);

        when(mockEmployeeService.createinstance(testEmployeeCreateinstanceArg1)).thenReturn(testEmployeeCreateinstanceResult);

        when(mockEmployeeService.deleteinstance(testEmployeeDeleteinstanceArg1)).thenReturn(testEmployeeDeleteinstanceResult);

        when(mockEmployeeService.editinstance(testEmployeeEditinstanceArg1)).thenReturn(testEmployeeEditinstanceResult);

        when(mockEmployeeService.changePicture(testEmployeeChangePictureArg1)).thenReturn(testEmployeeChangePictureResult);

        when(mockEmployeeService.addEmployeeToTeam(testEmployeeAddEmployeeToTeamArg1)).thenReturn(testEmployeeAddEmployeeToTeamResult);

        when(mockEmployeeService.addEmployeeToTeamCheckPreconditions(testEmployeeAddEmployeeToTeamCheckPreconditionsArg1)).thenReturn(testEmployeeAddEmployeeToTeamCheckPreconditionsResult);

        when(mockEmployeeService.removeEmployeeFromTeam(testEmployeeRemoveEmployeeFromTeamArg1)).thenReturn(testEmployeeRemoveEmployeeFromTeamResult);

        when(mockEmployeeService.tDELETE(testEmployeeTDELETEArg1)).thenReturn(testEmployeeTDELETEResult);

        when(mockEmployeeService.iIUEmployee(testiiuIIUEmployeeArg1)).thenReturn(testiiuIIUEmployeeResult);

        when(mockEmployeeService.iIUEmployeeReports(testiiuIIUEmployeeReportsArg1)).thenReturn(testiiuIIUEmployeeReportsResult);

        when(testpiuPIUEmployeeArg1.buildQueryRequest()).thenReturn(testpiuPIUEmployeeMockArg1);

        when(mockEmployeeService.piuPIUEmployee(testpiuPIUEmployeeMockArg1)).thenReturn(testpiuPIUEmployeeMockResult);

        when(testpiuPIUEmployee2Arg1.buildQueryRequest()).thenReturn(testpiuPIUEmployee2MockArg1);

        when(mockEmployeeService.piuPIUEmployee(testpiuPIUEmployee2MockArg1)).thenReturn(testpiuPIUEmployee2MockResult);

        when(mockEmployeeService.getCount4PIUEmployee(testpiuPIUEmployee2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSEmployee() {
        assertEquals(testGetDSEmployeeResult, instanceEmployeeApi.getDSEmployee(testGetDSEmployeeArg1, testGetDSEmployeeArg2, testGetDSEmployeeArg3));
    }

    @Test
    public void testGetDSEmployee2() {
        assertEquals(testGetDSEmployee2Result, instanceEmployeeApi.getDSEmployee(testGetDSEmployee2Arg1, testGetDSEmployee2Arg2, testGetDSEmployee2Arg3));
    }

    @Test
    public void testGetDSEmployee3() {
        assertEquals(testGetDSEmployee3Result, instanceEmployeeApi.getDSEmployee(testGetDSEmployee3Arg1, testGetDSEmployee3Arg2, testGetDSEmployee3Arg3));
    }

    @Test
    public void testGetDSEmployee4() {
        assertEquals(testGetDSEmployee4Result, instanceEmployeeApi.getDSEmployee(testGetDSEmployee4Arg1, testGetDSEmployee4Arg2, testGetDSEmployee4Arg3));
    }

    @Test
    public void testGetDSEmployeeSup() {
        assertEquals(testGetDSEmployeeSupResult, instanceEmployeeApi.getDSEmployeeSup(testGetDSEmployeeSupArg1, testGetDSEmployeeSupArg2, testGetDSEmployeeSupArg3));
    }

    @Test
    public void testGetDSEmployeeSup2() {
        assertEquals(testGetDSEmployeeSup2Result, instanceEmployeeApi.getDSEmployeeSup(testGetDSEmployeeSup2Arg1, testGetDSEmployeeSup2Arg2, testGetDSEmployeeSup2Arg3));
    }

    @Test
    public void testGetDSEmployeeSup3() {
        assertEquals(testGetDSEmployeeSup3Result, instanceEmployeeApi.getDSEmployeeSup(testGetDSEmployeeSup3Arg1, testGetDSEmployeeSup3Arg2, testGetDSEmployeeSup3Arg3));
    }

    @Test
    public void testGetDSEmployeeSup4() {
        assertEquals(testGetDSEmployeeSup4Result, instanceEmployeeApi.getDSEmployeeSup(testGetDSEmployeeSup4Arg1, testGetDSEmployeeSup4Arg2, testGetDSEmployeeSup4Arg3));
    }

    @Test
    public void testGetEmployee() {
        assertEquals(testGetEmployeeResult, instanceEmployeeApi.getEmployee(testGetEmployeeArg1));
    }

    @Test
    public void testGetEmployeeDynamic() {
        assertEquals(testGetEmployeeDynamicResult, instanceEmployeeApi.getEmployeeDynamic(testGetEmployeeDynamicArg1));
    }

    @Test
    public void testGetEmployeePreload() {
        assertEquals(testGetEmployeePreloadResult, instanceEmployeeApi.getEmployeePreload(testGetEmployeePreloadArg1));
    }

    @Test
    public void testGetEmployeeWithDisplaySetDynamic() {
        assertEquals(testGetEmployeeWithDisplaySetDynamicResult, instanceEmployeeApi.getEmployeeWithDisplaySetDynamic(testGetEmployeeWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetEmployeePopulationDynamic() {
        assertEquals(testGetEmployeePopulationDynamicResult, instanceEmployeeApi.getEmployeePopulationDynamic(testGetEmployeePopulationDynamicArg1));
    }

    @Test
    public void testEmployeeCreateinstance() {
        assertEquals(testEmployeeCreateinstanceResult, instanceEmployeeApi.employeeCreateinstance(testEmployeeCreateinstanceArg1));
    }

    @Test
    public void testEmployeeDeleteinstance() {
        assertEquals(testEmployeeDeleteinstanceResult, instanceEmployeeApi.employeeDeleteinstance(testEmployeeDeleteinstanceArg1));
    }

    @Test
    public void testEmployeeEditinstance() {
        assertEquals(testEmployeeEditinstanceResult, instanceEmployeeApi.employeeEditinstance(testEmployeeEditinstanceArg1));
    }

    @Test
    public void testEmployeeChangePicture() {
        assertEquals(testEmployeeChangePictureResult, instanceEmployeeApi.employeeChangePicture(testEmployeeChangePictureArg1));
    }

    @Test
    public void testEmployeeAddEmployeeToTeam() {
        assertEquals(testEmployeeAddEmployeeToTeamResult, instanceEmployeeApi.employeeAddEmployeeToTeam(testEmployeeAddEmployeeToTeamArg1));
    }

    @Test
    public void testEmployeeAddEmployeeToTeamCheckPreconditions() {
        assertEquals(testEmployeeAddEmployeeToTeamCheckPreconditionsResult, instanceEmployeeApi.employeeAddEmployeeToTeamCheckPreconditions(testEmployeeAddEmployeeToTeamCheckPreconditionsArg1));
    }

    @Test
    public void testEmployeeRemoveEmployeeFromTeam() {
        assertEquals(testEmployeeRemoveEmployeeFromTeamResult, instanceEmployeeApi.employeeRemoveEmployeeFromTeam(testEmployeeRemoveEmployeeFromTeamArg1));
    }

    @Test
    public void testEmployeeTDELETE() {
        assertEquals(testEmployeeTDELETEResult, instanceEmployeeApi.employeeTDELETE(testEmployeeTDELETEArg1));
    }

    @Test
    public void testiiuIIUEmployee() {
        assertEquals(testiiuIIUEmployeeResult, instanceEmployeeApi.iiuIIUEmployee(testiiuIIUEmployeeArg1));
    }

    @Test
    public void testiiuIIUEmployeeReports() {
        assertEquals(testiiuIIUEmployeeReportsResult, instanceEmployeeApi.iiuIIUEmployeeReports(testiiuIIUEmployeeReportsArg1));
    }

    @Test
    public void testpiuPIUEmployee() {
        assertEquals(testpiuPIUEmployeeResult.getTotalItems(), instanceEmployeeApi.piuPIUEmployee(testpiuPIUEmployeeArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUEmployee2() {
        assertEquals(testpiuPIUEmployee2Result.getTotalItems(), instanceEmployeeApi.piuPIUEmployee(testpiuPIUEmployee2Arg1).getTotalItems());
    }
}
