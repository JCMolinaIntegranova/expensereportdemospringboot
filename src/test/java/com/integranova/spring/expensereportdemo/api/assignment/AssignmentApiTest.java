package com.integranova.spring.expensereportdemo.api.assignment;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.assignment.AssignmentApi;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.service.AssignmentService;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest;
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
public class AssignmentApiTest {

    @Mock
    private AssignmentService mockAssignmentService;

    @InjectMocks
    private AssignmentApi instanceAssignmentApi;

    // testGetDSAssignmentDetails
    private static String testGetDSAssignmentDetailsArg1;
    private static String testGetDSAssignmentDetailsArg2;
    private static String testGetDSAssignmentDetailsArg3;
    private static DSAssignmentDetails testGetDSAssignmentDetailsResult;

    // testGetDSAssignmentDetails2
    private static String testGetDSAssignmentDetails2Arg1;
    private static String testGetDSAssignmentDetails2Arg2;
    private static String testGetDSAssignmentDetails2Arg3;
    private static DSAssignmentDetails testGetDSAssignmentDetails2Result;

    // testGetDSAssignmentDetails3
    private static String testGetDSAssignmentDetails3Arg1;
    private static String testGetDSAssignmentDetails3Arg2;
    private static String testGetDSAssignmentDetails3Arg3;
    private static DSAssignmentDetails testGetDSAssignmentDetails3Result;

    // testGetDSAssignmentDetails4
    private static String testGetDSAssignmentDetails4Arg1;
    private static String testGetDSAssignmentDetails4Arg2;
    private static String testGetDSAssignmentDetails4Arg3;
    private static DSAssignmentDetails testGetDSAssignmentDetails4Result;

    // testGetDSAssignments
    private static String testGetDSAssignmentsArg1;
    private static String testGetDSAssignmentsArg2;
    private static String testGetDSAssignmentsArg3;
    private static DSAssignments testGetDSAssignmentsResult;

    // testGetDSAssignments2
    private static String testGetDSAssignments2Arg1;
    private static String testGetDSAssignments2Arg2;
    private static String testGetDSAssignments2Arg3;
    private static DSAssignments testGetDSAssignments2Result;

    // testGetDSAssignments3
    private static String testGetDSAssignments3Arg1;
    private static String testGetDSAssignments3Arg2;
    private static String testGetDSAssignments3Arg3;
    private static DSAssignments testGetDSAssignments3Result;

    // testGetDSAssignments4
    private static String testGetDSAssignments4Arg1;
    private static String testGetDSAssignments4Arg2;
    private static String testGetDSAssignments4Arg3;
    private static DSAssignments testGetDSAssignments4Result;

    // testGetAssignment
    private static Long testGetAssignmentArg1;
    private static Assignment testGetAssignmentResult;

    // testGetAssignmentDynamic
    private static QueryRequest testGetAssignmentDynamicArg1;
    private static AssignmentOid mockGetAssignmentDynamicArg1;
    private static String mockGetAssignmentDynamicArg2;
    private static InstanceResponseViewModel testGetAssignmentDynamicResult;

    // testGetAssignmentWithDisplaySetDynamic
    private static QueryRequest testGetAssignmentWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetAssignmentWithDisplaySetDynamicResult;

    // testGetAssignmentPopulationDynamic
    private static QueryRequest testGetAssignmentPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetAssignmentPopulationDynamicResult;

    // testGetAssignmentByEmployee
    private static EmployeeOid testGetAssignmentByEmployeeArg1;
    private static List<Assignment> testGetAssignmentByEmployeeResult;

    // testGetAssignmentByProject
    private static ProjectOid testGetAssignmentByProjectArg1;
    private static List<Assignment> testGetAssignmentByProjectResult;

    // testAssignmentNewAssignment
    private static NewAssignmentRequest testAssignmentNewAssignmentArg1;
    private static ServiceResponse testAssignmentNewAssignmentResult;

    // testAssignmentNewAssignmentCheckPreconditions
    private static NewAssignmentRequest testAssignmentNewAssignmentCheckPreconditionsArg1;
    private static ServiceResponse testAssignmentNewAssignmentCheckPreconditionsResult;

    // testAssignmentDeleteAssignment
    private static DeleteAssignmentRequest testAssignmentDeleteAssignmentArg1;
    private static ServiceResponse testAssignmentDeleteAssignmentResult;

    // testAssignmentEditAssignment
    private static EditAssignmentRequest testAssignmentEditAssignmentArg1;
    private static ServiceResponse testAssignmentEditAssignmentResult;

    // testAssignmentTerminateAssignment
    private static TerminateAssignmentRequest testAssignmentTerminateAssignmentArg1;
    private static ServiceResponse testAssignmentTerminateAssignmentResult;

    // testiiuIIUAssignment
    private static AssignmentOid testiiuIIUAssignmentArg1;
    private static DSAssignmentDetails testiiuIIUAssignmentResult;

    // testpiuPIUAssignments
    private static PIUAssignmentsRequest testpiuPIUAssignmentsArg1;
    private static QueryRequest testpiuPIUAssignmentsMockArg1;
    private static List<DSAssignments> testpiuPIUAssignmentsMockResult;
    private static PIUAssignmentsResponse testpiuPIUAssignmentsResult;

    // testpiuPIUAssignments2
    private static PIUAssignmentsRequest testpiuPIUAssignments2Arg1;
    private static QueryRequest testpiuPIUAssignments2MockArg1;
    private static List<DSAssignments> testpiuPIUAssignments2MockResult;
    private static PIUAssignmentsResponse testpiuPIUAssignments2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSAssignmentDetails();
        setUpMockData4testGetDSAssignmentDetails2();
        setUpMockData4testGetDSAssignmentDetails3();
        setUpMockData4testGetDSAssignmentDetails4();
        setUpMockData4testGetDSAssignments();
        setUpMockData4testGetDSAssignments2();
        setUpMockData4testGetDSAssignments3();
        setUpMockData4testGetDSAssignments4();
        setUpMockData4testGetAssignment();
        setUpMockData4testGetAssignmentDynamic();
        setUpMockData4testGetAssignmentWithDisplaySetDynamic();
        setUpMockData4testGetAssignmentPopulationDynamic();
        setUpMockData4testGetAssignmentByEmployee();
        setUpMockData4testGetAssignmentByProject();
        setUpMockData4testAssignmentNewAssignment();
        setUpMockData4testAssignmentNewAssignmentCheckPreconditions();
        setUpMockData4testAssignmentDeleteAssignment();
        setUpMockData4testAssignmentEditAssignment();
        setUpMockData4testAssignmentTerminateAssignment();
        setUpMockData4testiiuIIUAssignment();
        setUpMockData4testpiuPIUAssignments();
        setUpMockData4testpiuPIUAssignments2();
    }

    private static void setUpMockData4testGetDSAssignmentDetails() {
        testGetDSAssignmentDetailsArg1 = "";
        testGetDSAssignmentDetailsArg2 = "";
        testGetDSAssignmentDetailsArg3 = "";
        testGetDSAssignmentDetailsResult = new DSAssignmentDetails();
    }

    private static void setUpMockData4testGetDSAssignmentDetails2() {
        testGetDSAssignmentDetails2Arg1 = "";
        testGetDSAssignmentDetails2Arg2 = null;
        testGetDSAssignmentDetails2Arg3 = null;
        testGetDSAssignmentDetails2Result = testGetDSAssignmentDetailsResult;
    }

    private static void setUpMockData4testGetDSAssignmentDetails3() {
        testGetDSAssignmentDetails3Arg1 = "";
        testGetDSAssignmentDetails3Arg2 = null;
        testGetDSAssignmentDetails3Arg3 = "";
        testGetDSAssignmentDetails3Result = testGetDSAssignmentDetailsResult;
    }

    private static void setUpMockData4testGetDSAssignmentDetails4() {
        testGetDSAssignmentDetails4Arg1 = "";
        testGetDSAssignmentDetails4Arg2 = "";
        testGetDSAssignmentDetails4Arg3 = null;
        testGetDSAssignmentDetails4Result = testGetDSAssignmentDetailsResult;
    }

    private static void setUpMockData4testGetDSAssignments() {
        testGetDSAssignmentsArg1 = "";
        testGetDSAssignmentsArg2 = "";
        testGetDSAssignmentsArg3 = "";
        testGetDSAssignmentsResult = new DSAssignments();
    }

    private static void setUpMockData4testGetDSAssignments2() {
        testGetDSAssignments2Arg1 = "";
        testGetDSAssignments2Arg2 = null;
        testGetDSAssignments2Arg3 = null;
        testGetDSAssignments2Result = testGetDSAssignmentsResult;
    }

    private static void setUpMockData4testGetDSAssignments3() {
        testGetDSAssignments3Arg1 = "";
        testGetDSAssignments3Arg2 = null;
        testGetDSAssignments3Arg3 = "";
        testGetDSAssignments3Result = testGetDSAssignmentsResult;
    }

    private static void setUpMockData4testGetDSAssignments4() {
        testGetDSAssignments4Arg1 = "";
        testGetDSAssignments4Arg2 = "";
        testGetDSAssignments4Arg3 = null;
        testGetDSAssignments4Result = testGetDSAssignmentsResult;
    }

    private static void setUpMockData4testGetAssignment() {
        testGetAssignmentArg1 = Long.valueOf(0);
        testGetAssignmentResult = new Assignment();
    }

    private static void setUpMockData4testGetAssignmentDynamic() {
        mockGetAssignmentDynamicArg1 = new AssignmentOid();
        mockGetAssignmentDynamicArg2 = "";
        testGetAssignmentDynamicArg1 = new QueryRequest();
        testGetAssignmentDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetAssignmentWithDisplaySetDynamic() {
        testGetAssignmentWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetAssignmentWithDisplaySetDynamicArg1.setDisplaySetName("testGetAssignmentWithDisplaySetDynamicArg1");
        testGetAssignmentWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetAssignmentPopulationDynamic() {
        testGetAssignmentPopulationDynamicArg1 = new QueryRequest();
        testGetAssignmentPopulationDynamicArg1.setDisplaySetName("testGetAssignmentPopulationDynamicArg1");
        testGetAssignmentPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetAssignmentByEmployee() {
        testGetAssignmentByEmployeeArg1 = new EmployeeOid();
        testGetAssignmentByEmployeeResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetAssignmentByProject() {
        testGetAssignmentByProjectArg1 = new ProjectOid();
        testGetAssignmentByProjectResult = new ArrayList<>();
    }

    private static void setUpMockData4testAssignmentNewAssignment() {
        testAssignmentNewAssignmentArg1 = new NewAssignmentRequest();
        testAssignmentNewAssignmentResult = new ServiceResponse();
    }

    private static void setUpMockData4testAssignmentNewAssignmentCheckPreconditions() {
        testAssignmentNewAssignmentCheckPreconditionsArg1 = new NewAssignmentRequest();
        testAssignmentNewAssignmentCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testAssignmentDeleteAssignment() {
        testAssignmentDeleteAssignmentArg1 = new DeleteAssignmentRequest();
        testAssignmentDeleteAssignmentResult = new ServiceResponse();
    }

    private static void setUpMockData4testAssignmentEditAssignment() {
        testAssignmentEditAssignmentArg1 = new EditAssignmentRequest();
        testAssignmentEditAssignmentResult = new ServiceResponse();
    }

    private static void setUpMockData4testAssignmentTerminateAssignment() {
        testAssignmentTerminateAssignmentArg1 = new TerminateAssignmentRequest();
        testAssignmentTerminateAssignmentResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUAssignment() {
        testiiuIIUAssignmentArg1 = new AssignmentOid();
        testiiuIIUAssignmentResult = new DSAssignmentDetails();
    }

    private static void setUpMockData4testpiuPIUAssignments() {
        testpiuPIUAssignmentsMockArg1 = new QueryRequest();
        testpiuPIUAssignmentsMockArg1.setPageSize(0);
        testpiuPIUAssignmentsMockResult = new ArrayList<>();
        testpiuPIUAssignmentsArg1 = mock(PIUAssignmentsRequest.class);
        testpiuPIUAssignmentsResult = new PIUAssignmentsResponse();
    }

    private static void setUpMockData4testpiuPIUAssignments2() {
        testpiuPIUAssignments2MockArg1 = new QueryRequest();
        testpiuPIUAssignments2MockArg1.setPageSize(1);
        testpiuPIUAssignments2MockResult = new ArrayList<>();
        testpiuPIUAssignments2MockResult.add(new DSAssignments());
        testpiuPIUAssignments2Arg1 = mock(PIUAssignmentsRequest.class);
        testpiuPIUAssignments2Arg1.setPageSize(1);
        testpiuPIUAssignments2Result = new PIUAssignmentsResponse();
        testpiuPIUAssignments2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockAssignmentService.getDSAssignmentDetails(testGetDSAssignmentDetailsArg1, testGetDSAssignmentDetailsArg2, testGetDSAssignmentDetailsArg3)).thenReturn(testGetDSAssignmentDetailsResult);

        when(mockAssignmentService.getDSAssignments(testGetDSAssignmentsArg1, testGetDSAssignmentsArg2, testGetDSAssignmentsArg3)).thenReturn(testGetDSAssignmentsResult);

        when(mockAssignmentService.getById(testGetAssignmentArg1)).thenReturn(testGetAssignmentResult);

        when(mockAssignmentService.getAssignmentDynamic(mockGetAssignmentDynamicArg1, mockGetAssignmentDynamicArg2)).thenReturn(testGetAssignmentDynamicResult);

        when(mockAssignmentService.getDynamic(testGetAssignmentWithDisplaySetDynamicArg1)).thenReturn(testGetAssignmentWithDisplaySetDynamicResult);

        when(mockAssignmentService.getDynamic(testGetAssignmentPopulationDynamicArg1)).thenReturn(testGetAssignmentPopulationDynamicResult);

        when(mockAssignmentService.getInstancesByRelated(any(Employee.class), eq("Employee"))).thenReturn(testGetAssignmentByEmployeeResult);

        when(mockAssignmentService.getInstancesByRelated(any(Project.class), eq("Project"))).thenReturn(testGetAssignmentByProjectResult);

        when(mockAssignmentService.newAssignment(testAssignmentNewAssignmentArg1)).thenReturn(testAssignmentNewAssignmentResult);

        when(mockAssignmentService.newAssignmentCheckPreconditions(testAssignmentNewAssignmentCheckPreconditionsArg1)).thenReturn(testAssignmentNewAssignmentCheckPreconditionsResult);

        when(mockAssignmentService.deleteAssignment(testAssignmentDeleteAssignmentArg1)).thenReturn(testAssignmentDeleteAssignmentResult);

        when(mockAssignmentService.editAssignment(testAssignmentEditAssignmentArg1)).thenReturn(testAssignmentEditAssignmentResult);

        when(mockAssignmentService.terminateAssignment(testAssignmentTerminateAssignmentArg1)).thenReturn(testAssignmentTerminateAssignmentResult);

        when(mockAssignmentService.iIUAssignment(testiiuIIUAssignmentArg1)).thenReturn(testiiuIIUAssignmentResult);

        when(testpiuPIUAssignmentsArg1.buildQueryRequest()).thenReturn(testpiuPIUAssignmentsMockArg1);

        when(mockAssignmentService.piuPIUAssignments(testpiuPIUAssignmentsMockArg1)).thenReturn(testpiuPIUAssignmentsMockResult);

        when(testpiuPIUAssignments2Arg1.buildQueryRequest()).thenReturn(testpiuPIUAssignments2MockArg1);

        when(mockAssignmentService.piuPIUAssignments(testpiuPIUAssignments2MockArg1)).thenReturn(testpiuPIUAssignments2MockResult);

        when(mockAssignmentService.getCount4PIUAssignments(testpiuPIUAssignments2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSAssignmentDetails() {
        assertEquals(testGetDSAssignmentDetailsResult, instanceAssignmentApi.getDSAssignmentDetails(testGetDSAssignmentDetailsArg1, testGetDSAssignmentDetailsArg2, testGetDSAssignmentDetailsArg3));
    }

    @Test
    public void testGetDSAssignmentDetails2() {
        assertEquals(testGetDSAssignmentDetails2Result, instanceAssignmentApi.getDSAssignmentDetails(testGetDSAssignmentDetails2Arg1, testGetDSAssignmentDetails2Arg2, testGetDSAssignmentDetails2Arg3));
    }

    @Test
    public void testGetDSAssignmentDetails3() {
        assertEquals(testGetDSAssignmentDetails3Result, instanceAssignmentApi.getDSAssignmentDetails(testGetDSAssignmentDetails3Arg1, testGetDSAssignmentDetails3Arg2, testGetDSAssignmentDetails3Arg3));
    }

    @Test
    public void testGetDSAssignmentDetails4() {
        assertEquals(testGetDSAssignmentDetails4Result, instanceAssignmentApi.getDSAssignmentDetails(testGetDSAssignmentDetails4Arg1, testGetDSAssignmentDetails4Arg2, testGetDSAssignmentDetails4Arg3));
    }

    @Test
    public void testGetDSAssignments() {
        assertEquals(testGetDSAssignmentsResult, instanceAssignmentApi.getDSAssignments(testGetDSAssignmentsArg1, testGetDSAssignmentsArg2, testGetDSAssignmentsArg3));
    }

    @Test
    public void testGetDSAssignments2() {
        assertEquals(testGetDSAssignments2Result, instanceAssignmentApi.getDSAssignments(testGetDSAssignments2Arg1, testGetDSAssignments2Arg2, testGetDSAssignments2Arg3));
    }

    @Test
    public void testGetDSAssignments3() {
        assertEquals(testGetDSAssignments3Result, instanceAssignmentApi.getDSAssignments(testGetDSAssignments3Arg1, testGetDSAssignments3Arg2, testGetDSAssignments3Arg3));
    }

    @Test
    public void testGetDSAssignments4() {
        assertEquals(testGetDSAssignments4Result, instanceAssignmentApi.getDSAssignments(testGetDSAssignments4Arg1, testGetDSAssignments4Arg2, testGetDSAssignments4Arg3));
    }

    @Test
    public void testGetAssignment() {
        assertEquals(testGetAssignmentResult, instanceAssignmentApi.getAssignment(testGetAssignmentArg1));
    }

    @Test
    public void testGetAssignmentDynamic() {
        assertEquals(testGetAssignmentDynamicResult, instanceAssignmentApi.getAssignmentDynamic(testGetAssignmentDynamicArg1));
    }

    @Test
    public void testGetAssignmentWithDisplaySetDynamic() {
        assertEquals(testGetAssignmentWithDisplaySetDynamicResult, instanceAssignmentApi.getAssignmentWithDisplaySetDynamic(testGetAssignmentWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetAssignmentPopulationDynamic() {
        assertEquals(testGetAssignmentPopulationDynamicResult, instanceAssignmentApi.getAssignmentPopulationDynamic(testGetAssignmentPopulationDynamicArg1));
    }

    @Test
    public void testGetAssignmentByEmployee() {
        assertEquals(testGetAssignmentByEmployeeResult, instanceAssignmentApi.getAssignmentByEmployee(testGetAssignmentByEmployeeArg1));
    }

    @Test
    public void testGetAssignmentByProject() {
        assertEquals(testGetAssignmentByProjectResult, instanceAssignmentApi.getAssignmentByProject(testGetAssignmentByProjectArg1));
    }

    @Test
    public void testAssignmentNewAssignment() {
        assertEquals(testAssignmentNewAssignmentResult, instanceAssignmentApi.assignmentNewAssignment(testAssignmentNewAssignmentArg1));
    }

    @Test
    public void testAssignmentNewAssignmentCheckPreconditions() {
        assertEquals(testAssignmentNewAssignmentCheckPreconditionsResult, instanceAssignmentApi.assignmentNewAssignmentCheckPreconditions(testAssignmentNewAssignmentCheckPreconditionsArg1));
    }

    @Test
    public void testAssignmentDeleteAssignment() {
        assertEquals(testAssignmentDeleteAssignmentResult, instanceAssignmentApi.assignmentDeleteAssignment(testAssignmentDeleteAssignmentArg1));
    }

    @Test
    public void testAssignmentEditAssignment() {
        assertEquals(testAssignmentEditAssignmentResult, instanceAssignmentApi.assignmentEditAssignment(testAssignmentEditAssignmentArg1));
    }

    @Test
    public void testAssignmentTerminateAssignment() {
        assertEquals(testAssignmentTerminateAssignmentResult, instanceAssignmentApi.assignmentTerminateAssignment(testAssignmentTerminateAssignmentArg1));
    }

    @Test
    public void testiiuIIUAssignment() {
        assertEquals(testiiuIIUAssignmentResult, instanceAssignmentApi.iiuIIUAssignment(testiiuIIUAssignmentArg1));
    }

    @Test
    public void testpiuPIUAssignments() {
        assertEquals(testpiuPIUAssignmentsResult.getTotalItems(), instanceAssignmentApi.piuPIUAssignments(testpiuPIUAssignmentsArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUAssignments2() {
        assertEquals(testpiuPIUAssignments2Result.getTotalItems(), instanceAssignmentApi.piuPIUAssignments(testpiuPIUAssignments2Arg1).getTotalItems());
    }
}
