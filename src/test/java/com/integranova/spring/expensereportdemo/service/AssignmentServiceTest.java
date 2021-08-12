package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AssignmentServiceTest extends ClassTest {

    @InjectMocks
    private AssignmentService instanceAssignmentService;
    
    @Mock
    private static AssignmentJpaRepository mockRepository;
    
    @Mock
    private static AssignmentService mockAssignmentService;
    
    @Mock
    private static ProjectService mockProjectService;
    
    @Mock
    private static EmployeeService mockEmployeeService;

    private static Assignment mockInstance1;
    
    private static Assignment mockInstance2;

    private static List<Assignment> mockPopulation;

    private static Long mockassignmentAssignmentID;

    private static Optional<Assignment> mockAssignment; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<Assignment> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<Assignment> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFAssignments_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFAssignments_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFAssignments_NoFVarsResult;

    // test4getDynamicPopulationByFilterFAssignments_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFAssignments_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFAssignments_WithFVarsResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static Long test4getByIdArg1;
    private static Assignment test4getByIdResult;

    // test4getByRelated
    private static Assignment test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<Assignment> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static Assignment test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<Assignment> test4getInstancesByRelatedResult;

    // test4getAssignmentDynamic
    private static AssignmentOid test4getAssignmentDynamicArg1;
    private static String test4getAssignmentDynamicArg2;
    private static InstanceResponseViewModel test4getAssignmentDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static AssignmentOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static AssignmentOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleEmployeeWithRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectWithRemainingPath
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg3;

    // test4getDSAssignmentDetails
    private static String test4getDSAssignmentDetailsArg1;
    private static String test4getDSAssignmentDetailsArg2;
    private static String test4getDSAssignmentDetailsArg3;
    private static DSAssignmentDetails test4getDSAssignmentDetailsResult;

    // test4getDSAssignments
    private static String test4getDSAssignmentsArg1;
    private static String test4getDSAssignmentsArg2;
    private static String test4getDSAssignmentsArg3;
    private static DSAssignments test4getDSAssignmentsResult;

    // test4iIUAssignment
    private static AssignmentOid test4iIUAssignmentArg1;
    private static DSAssignmentDetails test4iIUAssignmentResult;

    // test4piuPIUAssignments
    private static QueryRequest test4piuPIUAssignmentsArg1;
    private static List<DSAssignments> test4piuPIUAssignmentsResult;

    // test4getCount4PIUAssignments
    private static QueryRequest test4getCount4PIUAssignmentsArg1;
    private static int test4getCount4PIUAssignmentsResult;

    // test4piuPIUAssignmentsWithFilterFAssignments_NoFVars
    private static QueryRequest test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsArg1;
    private static List<DSAssignments> test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsResult;

    // test4piuPIUAssignmentsWithFilterFAssignments_WithFVars
    private static QueryRequest test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsArg1;
    private static List<DSAssignments> test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsResult;

    // test4newAssignmentDefault
    private static NewAssignmentRequest test4newAssignmentDefaultArg1;

    // test4newAssignmentInitializedArguments
    private static NewAssignmentRequest test4newAssignmentInitializedArgumentsArg1;

    // test4newAssignmentTxnDefault
    private static NewAssignmentRequest test4newAssignmentTxnDefaultArg1;
    private static ServiceResponse test4newAssignmentTxnDefaultResult;

    // test4newAssignmentTxnInitializedArguments
    private static NewAssignmentRequest test4newAssignmentTxnInitializedArgumentsArg1;
    private static ServiceResponse test4newAssignmentTxnInitializedArgumentsResult;

    // test4newAssignmentImplementationDefault
    private static NewAssignmentRequest test4newAssignmentImplementationDefaultArg1;
    private static ServiceResponse test4newAssignmentImplementationDefaultResult;

    // test4newAssignmentImplementationInitializedArguments
    private static NewAssignmentRequest test4newAssignmentImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4newAssignmentImplementationInitializedArgumentsResult;

    // test4newAssignmentCheckPreconditions
    private static NewAssignmentRequest newAssignmentCheckPreconditionsArg1;
    private static ServiceResponse newAssignmentCheckPreconditionsResult;

    // test4deleteAssignmentDefault
    private static DeleteAssignmentRequest test4deleteAssignmentDefaultArg1;

    // test4deleteAssignmentInitializedArguments
    private static DeleteAssignmentRequest test4deleteAssignmentInitializedArgumentsArg1;

    // test4deleteAssignmentTxnDefault
    private static DeleteAssignmentRequest test4deleteAssignmentTxnDefaultArg1;
    private static ServiceResponse test4deleteAssignmentTxnDefaultResult;

    // test4deleteAssignmentTxnInitializedArguments
    private static DeleteAssignmentRequest test4deleteAssignmentTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deleteAssignmentTxnInitializedArgumentsResult;

    // test4deleteAssignmentImplementationDefault
    private static DeleteAssignmentRequest test4deleteAssignmentImplementationDefaultArg1;
    private static ServiceResponse test4deleteAssignmentImplementationDefaultResult;

    // test4deleteAssignmentImplementationInitializedArguments
    private static DeleteAssignmentRequest test4deleteAssignmentImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deleteAssignmentImplementationInitializedArgumentsResult;

    // test4editAssignmentDefault
    private static EditAssignmentRequest test4editAssignmentDefaultArg1;

    // test4editAssignmentInitializedArguments
    private static EditAssignmentRequest test4editAssignmentInitializedArgumentsArg1;

    // test4editAssignmentTxnDefault
    private static EditAssignmentRequest test4editAssignmentTxnDefaultArg1;
    private static ServiceResponse test4editAssignmentTxnDefaultResult;

    // test4editAssignmentTxnInitializedArguments
    private static EditAssignmentRequest test4editAssignmentTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editAssignmentTxnInitializedArgumentsResult;

    // test4editAssignmentImplementationDefault
    private static EditAssignmentRequest test4editAssignmentImplementationDefaultArg1;
    private static ServiceResponse test4editAssignmentImplementationDefaultResult;

    // test4editAssignmentImplementationInitializedArguments
    private static EditAssignmentRequest test4editAssignmentImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editAssignmentImplementationInitializedArgumentsResult;

    // test4terminateAssignmentDefault
    private static TerminateAssignmentRequest test4terminateAssignmentDefaultArg1;

    // test4terminateAssignmentInitializedArguments
    private static TerminateAssignmentRequest test4terminateAssignmentInitializedArgumentsArg1;

    // test4terminateAssignmentTxnDefault
    private static TerminateAssignmentRequest test4terminateAssignmentTxnDefaultArg1;
    private static ServiceResponse test4terminateAssignmentTxnDefaultResult;

    // test4terminateAssignmentTxnInitializedArguments
    private static TerminateAssignmentRequest test4terminateAssignmentTxnInitializedArgumentsArg1;
    private static ServiceResponse test4terminateAssignmentTxnInitializedArgumentsResult;

    // test4terminateAssignmentImplementationDefault
    private static TerminateAssignmentRequest test4terminateAssignmentImplementationDefaultArg1;
    private static ServiceResponse test4terminateAssignmentImplementationDefaultResult;

    // test4terminateAssignmentImplementationInitializedArguments
    private static TerminateAssignmentRequest test4terminateAssignmentImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4terminateAssignmentImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockassignmentAssignmentID = Long.valueOf(0);
        mockInstance1 = new Assignment();
        mockInstance2 = new Assignment();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockAssignment = Optional.of(new Assignment(new AssignmentOid(mockassignmentAssignmentID)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFAssignments_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFAssignments_WithFVars();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getAssignmentDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleEmployeeWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectWithRemainingPath();
        setUpMockData4test4getDSAssignmentDetails();
        setUpMockData4test4getDSAssignments();
        setUpMockData4test4iIUAssignment();
        setUpMockData4test4piuPIUAssignments();
        setUpMockData4test4getCount4PIUAssignments();
        setUpMockData4test4piuPIUAssignmentsWithFilterFAssignments_NoFVars();
        setUpMockData4test4piuPIUAssignmentsWithFilterFAssignments_WithFVars();
        setUpMockData4test4newAssignmentDefault();
        setUpMockData4test4newAssignmentInitializedArguments();
        setUpMockData4test4newAssignmentTxnDefault();
        setUpMockData4test4newAssignmentTxnInitializedArguments();
        setUpMockData4test4newAssignmentImplementationDefault();
        setUpMockData4test4newAssignmentImplementationInitializedArguments();
        setUpMockData4test4newAssignmentCheckPreconditions();
        setUpMockData4test4deleteAssignmentDefault();
        setUpMockData4test4deleteAssignmentInitializedArguments();
        setUpMockData4test4deleteAssignmentTxnDefault();
        setUpMockData4test4deleteAssignmentTxnInitializedArguments();
        setUpMockData4test4deleteAssignmentImplementationDefault();
        setUpMockData4test4deleteAssignmentImplementationInitializedArguments();
        setUpMockData4test4editAssignmentDefault();
        setUpMockData4test4editAssignmentInitializedArguments();
        setUpMockData4test4editAssignmentTxnDefault();
        setUpMockData4test4editAssignmentTxnInitializedArguments();
        setUpMockData4test4editAssignmentImplementationDefault();
        setUpMockData4test4editAssignmentImplementationInitializedArguments();
        setUpMockData4test4terminateAssignmentDefault();
        setUpMockData4test4terminateAssignmentInitializedArguments();
        setUpMockData4test4terminateAssignmentTxnDefault();
        setUpMockData4test4terminateAssignmentTxnInitializedArguments();
        setUpMockData4test4terminateAssignmentImplementationDefault();
        setUpMockData4test4terminateAssignmentImplementationInitializedArguments();
    }

    private static void setUpMockData4test4solveQuery() {
        test4solveQueryArg1 = new QueryRequest();
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4get() {
        test4getResult = new ArrayList<>();
    }

    private static void setUpMockData4test4getQueryRequest() {
        test4getQueryRequestArg1 = new QueryRequest();
        test4getQueryRequestResult = mockPopulation;
    }

    private static void setUpMockData4test4getDynamicPopulation() {
        test4getDynamicPopulationArg1 = new QueryRequest();
        test4getDynamicPopulationArg1.setDisplaySetItems("assignmentAssignmentID");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFAssignments_NoFVars() {
        test4getDynamicPopulationByFilterFAssignments_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFAssignments_NoFVarsArg1.setDisplaySetItems("assignmentAssignmentID");
        test4getDynamicPopulationByFilterFAssignments_NoFVarsArg1.addFilterRequest(new FilterRequest(AssignmentConstants.FILTER_NAME_FASSIGNMENTS,new ArrayList<>()));
        test4getDynamicPopulationByFilterFAssignments_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFAssignments_WithFVars() {
        test4getDynamicPopulationByFilterFAssignments_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFAssignments_WithFVarsArg1.setDisplaySetItems("assignmentAssignmentID");
        test4getDynamicPopulationByFilterFAssignments_WithFVarsArg1.addFilterRequest(new FilterRequest(AssignmentConstants.FILTER_NAME_FASSIGNMENTS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT, new Project()), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VNAME, ""), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VSURNAME, ""), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VACTIVE, false)))));
        test4getDynamicPopulationByFilterFAssignments_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("assignmentAssignmentID");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new AssignmentOid(Long.valueOf(0)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = Long.valueOf(0);
        test4getByIdResult = mockAssignment.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new Assignment();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new Assignment();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getAssignmentDynamic() {
        test4getAssignmentDynamicArg1 = new AssignmentOid();
        test4getAssignmentDynamicArg2 = "";
        test4getAssignmentDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new AssignmentOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new AssignmentOid(Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath() {
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2 = AssignmentConstants.ROLE_NAME_EMPLOYEE;
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeeWithRemainingPath() {
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2 = AssignmentConstants.ROLE_NAME_EMPLOYEE;
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectWithoutRemainingPath() {
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2 = AssignmentConstants.ROLE_NAME_PROJECT;
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectWithRemainingPath() {
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg2 = AssignmentConstants.ROLE_NAME_PROJECT;
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSAssignmentDetails() {
        test4getDSAssignmentDetailsArg1 = "";
        test4getDSAssignmentDetailsArg2 = "";
        test4getDSAssignmentDetailsArg3 = "";
        test4getDSAssignmentDetailsResult = new DSAssignmentDetails();
    }

    private static void setUpMockData4test4getDSAssignments() {
        test4getDSAssignmentsArg1 = "";
        test4getDSAssignmentsArg2 = "";
        test4getDSAssignmentsArg3 = "";
        test4getDSAssignmentsResult = new DSAssignments();
    }

    private static void setUpMockData4test4iIUAssignment() {
        test4iIUAssignmentArg1 = new AssignmentOid();
        test4iIUAssignmentResult = new DSAssignmentDetails();
    }

    private static void setUpMockData4test4piuPIUAssignments() {
        test4piuPIUAssignmentsArg1 = new QueryRequest();
        test4piuPIUAssignmentsResult = mockPopulation.stream().map(i -> new DSAssignments(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUAssignments() {
        test4getCount4PIUAssignmentsArg1 = new QueryRequest();
        test4getCount4PIUAssignmentsResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUAssignmentsWithFilterFAssignments_NoFVars() {
        test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsArg1 = new QueryRequest();
        test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsArg1.addFilterRequest(new FilterRequest(AssignmentConstants.FILTER_NAME_FASSIGNMENTS,new ArrayList<>()));
        test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsResult = mockPopulation.stream().map(i -> new DSAssignments(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUAssignmentsWithFilterFAssignments_WithFVars() {
        test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsArg1 = new QueryRequest();
        test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsArg1.addFilterRequest(new FilterRequest(AssignmentConstants.FILTER_NAME_FASSIGNMENTS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT, new Project()), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VNAME, ""), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VSURNAME, ""), new FilterVariableRequest(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VACTIVE, false)))));
        test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsResult = mockPopulation.stream().map(i -> new DSAssignments(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4newAssignmentDefault() {
        test4newAssignmentDefaultArg1 = new NewAssignmentRequest();
    }

    private static void setUpMockData4test4newAssignmentInitializedArguments() {
        test4newAssignmentInitializedArgumentsArg1 = new NewAssignmentRequest();
        test4newAssignmentInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProject(new ProjectOid(Long.valueOf(0)));
        test4newAssignmentInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProjectInstance(new Project(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProject()));
        test4newAssignmentInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployee(new EmployeeOid(""));
        test4newAssignmentInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployeeInstance(new Employee(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployee()));
        test4newAssignmentInitializedArgumentsArg1.setAssignmentnewAssignmentpatrFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    private static void setUpMockData4test4newAssignmentTxnDefault() {
        test4newAssignmentTxnDefaultArg1 = new NewAssignmentRequest();
        test4newAssignmentTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newAssignmentTxnInitializedArguments() {
        test4newAssignmentTxnInitializedArgumentsArg1 = new NewAssignmentRequest();
        test4newAssignmentTxnInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProject(new ProjectOid(Long.valueOf(0)));
        test4newAssignmentTxnInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProjectInstance(new Project(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProject()));
        test4newAssignmentTxnInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployee(new EmployeeOid(""));
        test4newAssignmentTxnInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployeeInstance(new Employee(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployee()));
        test4newAssignmentTxnInitializedArgumentsArg1.setAssignmentnewAssignmentpatrFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newAssignmentTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newAssignmentImplementationDefault() {
        test4newAssignmentImplementationDefaultArg1 = new NewAssignmentRequest();
        test4newAssignmentImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newAssignmentImplementationInitializedArguments() {
        test4newAssignmentImplementationInitializedArgumentsArg1 = new NewAssignmentRequest();
        test4newAssignmentImplementationInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProject(new ProjectOid(Long.valueOf(0)));
        test4newAssignmentImplementationInitializedArgumentsArg1.setAssignmentnewAssignmentpagrProjectInstance(new Project(test4newAssignmentImplementationInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProject()));
        test4newAssignmentImplementationInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployee(new EmployeeOid(""));
        test4newAssignmentImplementationInitializedArgumentsArg1.setAssignmentnewAssignmentpagrEmployeeInstance(new Employee(test4newAssignmentImplementationInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployee()));
        test4newAssignmentImplementationInitializedArgumentsArg1.setAssignmentnewAssignmentpatrFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newAssignmentImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newAssignmentCheckPreconditions() {
        newAssignmentCheckPreconditionsArg1 = new NewAssignmentRequest();
        newAssignmentCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteAssignmentDefault() {
        test4deleteAssignmentDefaultArg1 = new DeleteAssignmentRequest();
    }

    private static void setUpMockData4test4deleteAssignmentInitializedArguments() {
        test4deleteAssignmentInitializedArgumentsArg1 = new DeleteAssignmentRequest();
        test4deleteAssignmentInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4deleteAssignmentInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignmentInstance(new Assignment(test4deleteAssignmentInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignment()));
    }

    private static void setUpMockData4test4deleteAssignmentTxnDefault() {
        test4deleteAssignmentTxnDefaultArg1 = new DeleteAssignmentRequest();
        test4deleteAssignmentTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteAssignmentTxnInitializedArguments() {
        test4deleteAssignmentTxnInitializedArgumentsArg1 = new DeleteAssignmentRequest();
        test4deleteAssignmentTxnInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4deleteAssignmentTxnInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignmentInstance(new Assignment(test4deleteAssignmentTxnInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignment()));
        test4deleteAssignmentTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteAssignmentImplementationDefault() {
        test4deleteAssignmentImplementationDefaultArg1 = new DeleteAssignmentRequest();
        test4deleteAssignmentImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteAssignmentImplementationInitializedArguments() {
        test4deleteAssignmentImplementationInitializedArgumentsArg1 = new DeleteAssignmentRequest();
        test4deleteAssignmentImplementationInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4deleteAssignmentImplementationInitializedArgumentsArg1.setAssignmentdeleteAssignmentpthisAssignmentInstance(new Assignment(test4deleteAssignmentImplementationInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignment()));
        test4deleteAssignmentImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editAssignmentDefault() {
        test4editAssignmentDefaultArg1 = new EditAssignmentRequest();
    }

    private static void setUpMockData4test4editAssignmentInitializedArguments() {
        test4editAssignmentInitializedArgumentsArg1 = new EditAssignmentRequest();
        test4editAssignmentInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4editAssignmentInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignmentInstance(new Assignment(test4editAssignmentInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignment()));
        test4editAssignmentInitializedArgumentsArg1.setAssignmenteditAssignmentpFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    private static void setUpMockData4test4editAssignmentTxnDefault() {
        test4editAssignmentTxnDefaultArg1 = new EditAssignmentRequest();
        test4editAssignmentTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editAssignmentTxnInitializedArguments() {
        test4editAssignmentTxnInitializedArgumentsArg1 = new EditAssignmentRequest();
        test4editAssignmentTxnInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4editAssignmentTxnInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignmentInstance(new Assignment(test4editAssignmentTxnInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignment()));
        test4editAssignmentTxnInitializedArgumentsArg1.setAssignmenteditAssignmentpFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4editAssignmentTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editAssignmentImplementationDefault() {
        test4editAssignmentImplementationDefaultArg1 = new EditAssignmentRequest();
        test4editAssignmentImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editAssignmentImplementationInitializedArguments() {
        test4editAssignmentImplementationInitializedArgumentsArg1 = new EditAssignmentRequest();
        test4editAssignmentImplementationInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4editAssignmentImplementationInitializedArgumentsArg1.setAssignmenteditAssignmentpthisAssignmentInstance(new Assignment(test4editAssignmentImplementationInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignment()));
        test4editAssignmentImplementationInitializedArgumentsArg1.setAssignmenteditAssignmentpFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4editAssignmentImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4terminateAssignmentDefault() {
        test4terminateAssignmentDefaultArg1 = new TerminateAssignmentRequest();
    }

    private static void setUpMockData4test4terminateAssignmentInitializedArguments() {
        test4terminateAssignmentInitializedArgumentsArg1 = new TerminateAssignmentRequest();
        test4terminateAssignmentInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4terminateAssignmentInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignmentInstance(new Assignment(test4terminateAssignmentInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignment()));
        test4terminateAssignmentInitializedArgumentsArg1.setAssignmentterminateAssignmentpTerminationDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    private static void setUpMockData4test4terminateAssignmentTxnDefault() {
        test4terminateAssignmentTxnDefaultArg1 = new TerminateAssignmentRequest();
        test4terminateAssignmentTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4terminateAssignmentTxnInitializedArguments() {
        test4terminateAssignmentTxnInitializedArgumentsArg1 = new TerminateAssignmentRequest();
        test4terminateAssignmentTxnInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4terminateAssignmentTxnInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignmentInstance(new Assignment(test4terminateAssignmentTxnInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignment()));
        test4terminateAssignmentTxnInitializedArgumentsArg1.setAssignmentterminateAssignmentpTerminationDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4terminateAssignmentTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4terminateAssignmentImplementationDefault() {
        test4terminateAssignmentImplementationDefaultArg1 = new TerminateAssignmentRequest();
        test4terminateAssignmentImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4terminateAssignmentImplementationInitializedArguments() {
        test4terminateAssignmentImplementationInitializedArgumentsArg1 = new TerminateAssignmentRequest();
        test4terminateAssignmentImplementationInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignment(new AssignmentOid(Long.valueOf(0)));
        test4terminateAssignmentImplementationInitializedArgumentsArg1.setAssignmentterminateAssignmentpthisAssignmentInstance(new Assignment(test4terminateAssignmentImplementationInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignment()));
        test4terminateAssignmentImplementationInitializedArgumentsArg1.setAssignmentterminateAssignmentpTerminationDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4terminateAssignmentImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceAssignmentService, "assignmentSrv", instanceAssignmentService);

        when(mockProjectService.getByOIDWithHV(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProject())).thenReturn(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProjectInstance());

        when(mockEmployeeService.getByOIDWithHV(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployee())).thenReturn(test4newAssignmentInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployeeInstance());

        when(mockProjectService.getByOIDWithHV(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProject())).thenReturn(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrProjectInstance());

        when(mockEmployeeService.getByOIDWithHV(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployee())).thenReturn(test4newAssignmentTxnInitializedArgumentsArg1.getAssignmentnewAssignmentpagrEmployeeInstance());

        when(mockAssignmentService.getByOIDWithHV(test4deleteAssignmentInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignment())).thenReturn(test4deleteAssignmentInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignmentInstance());

        when(mockAssignmentService.getByOIDWithHV(test4deleteAssignmentTxnInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignment())).thenReturn(test4deleteAssignmentTxnInitializedArgumentsArg1.getAssignmentdeleteAssignmentpthisAssignmentInstance());

        when(mockAssignmentService.getByOIDWithHV(test4editAssignmentInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignment())).thenReturn(test4editAssignmentInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignmentInstance());

        when(mockAssignmentService.getByOIDWithHV(test4editAssignmentTxnInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignment())).thenReturn(test4editAssignmentTxnInitializedArgumentsArg1.getAssignmenteditAssignmentpthisAssignmentInstance());

        when(mockAssignmentService.getByOIDWithHV(test4terminateAssignmentInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignment())).thenReturn(test4terminateAssignmentInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignmentInstance());

        when(mockAssignmentService.getByOIDWithHV(test4terminateAssignmentTxnInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignment())).thenReturn(test4terminateAssignmentTxnInitializedArgumentsArg1.getAssignmentterminateAssignmentpthisAssignmentInstance());

        when(mockRepository.findById(mockassignmentAssignmentID)).thenAnswer(new Answer<Optional<Assignment>>(){
        	public Optional<Assignment> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockassignmentAssignmentID)) {
        			return mockAssignment;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(Assignment.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceAssignmentService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceAssignmentService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceAssignmentService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceAssignmentService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceAssignmentService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFAssignments_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFAssignments_NoFVarsResult), getResult(RESULTCODE, instanceAssignmentService.getDynamic(test4getDynamicPopulationByFilterFAssignments_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFAssignments_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFAssignments_WithFVarsResult), getResult(RESULTCODE, instanceAssignmentService.getDynamic(test4getDynamicPopulationByFilterFAssignments_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceAssignmentService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceAssignmentService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceAssignmentService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceAssignmentService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceAssignmentService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getAssignmentDynamic() {
        assertEquals(test4getAssignmentDynamicResult.getResultCode(), instanceAssignmentService.getAssignmentDynamic(test4getAssignmentDynamicArg1, test4getAssignmentDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceAssignmentService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceAssignmentService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath() {
        instanceAssignmentService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1, test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2, test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeeWithRemainingPath() {
        instanceAssignmentService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1, test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2, test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectWithoutRemainingPath() {
        instanceAssignmentService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1, test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2, test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectWithRemainingPath() {
        instanceAssignmentService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectWithRemainingPathArg1, test4buildRelatedInstance4RoleProjectWithRemainingPathArg2, test4buildRelatedInstance4RoleProjectWithRemainingPathArg3);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4getDSAssignmentDetails() {
        assertEquals(test4getDSAssignmentDetailsResult.getClass(), instanceAssignmentService.getDSAssignmentDetails(test4getDSAssignmentDetailsArg1, test4getDSAssignmentDetailsArg2, test4getDSAssignmentDetailsArg3).getClass());
    }

    @Test
    public void test4getDSAssignments() {
        assertEquals(test4getDSAssignmentsResult.getClass(), instanceAssignmentService.getDSAssignments(test4getDSAssignmentsArg1, test4getDSAssignmentsArg2, test4getDSAssignmentsArg3).getClass());
    }

    @Test
    public void test4iIUAssignment() {
        assertEquals(test4iIUAssignmentResult.getDSAssignmentDetailsProjectDotProjectName(), instanceAssignmentService.iIUAssignment(test4iIUAssignmentArg1).getDSAssignmentDetailsProjectDotProjectName());
    }

    @Test
    public void test4piuPIUAssignments() {
        instanceAssignmentService.piuPIUAssignments(test4piuPIUAssignmentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4getCount4PIUAssignments() {
        instanceAssignmentService.getCount4PIUAssignments(test4getCount4PIUAssignmentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4piuPIUAssignmentsWithFilterFAssignments_NoFVars() {
        instanceAssignmentService.piuPIUAssignments(test4piuPIUAssignmentsWithFilterFAssignments_NoFVarsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4piuPIUAssignmentsWithFilterFAssignments_WithFVars() {
        instanceAssignmentService.piuPIUAssignments(test4piuPIUAssignmentsWithFilterFAssignments_WithFVarsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4newAssignmentDefault() {
        instanceAssignmentService.newAssignment(test4newAssignmentDefaultArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4newAssignmentInitializedArguments() {
        instanceAssignmentService.newAssignment(test4newAssignmentInitializedArgumentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4newAssignmentTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.newAssignmentTxn(test4newAssignmentTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4newAssignmentTxnDefaultResult;
        }
        assertEquals(test4newAssignmentTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newAssignmentTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.newAssignmentTxn(test4newAssignmentTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newAssignmentTxnInitializedArgumentsResult;
        }
        assertEquals(test4newAssignmentTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newAssignmentImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.newAssignmentImplementation(test4newAssignmentImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4newAssignmentImplementationDefaultResult;
        }
        assertEquals(test4newAssignmentImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newAssignmentImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.newAssignmentImplementation(test4newAssignmentImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newAssignmentImplementationInitializedArgumentsResult;
        }
        assertEquals(test4newAssignmentImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newAssignmentCheckPreconditions() {
        assertEquals(newAssignmentCheckPreconditionsResult.getResultCode(), instanceAssignmentService.newAssignmentCheckPreconditions(newAssignmentCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4deleteAssignmentDefault() {
        instanceAssignmentService.deleteAssignment(test4deleteAssignmentDefaultArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4deleteAssignmentInitializedArguments() {
        instanceAssignmentService.deleteAssignment(test4deleteAssignmentInitializedArgumentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4deleteAssignmentTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.deleteAssignmentTxn(test4deleteAssignmentTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteAssignmentTxnDefaultResult;
        }
        assertEquals(test4deleteAssignmentTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteAssignmentTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.deleteAssignmentTxn(test4deleteAssignmentTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteAssignmentTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteAssignmentTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteAssignmentImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.deleteAssignmentImplementation(test4deleteAssignmentImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteAssignmentImplementationDefaultResult;
        }
        assertEquals(test4deleteAssignmentImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteAssignmentImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.deleteAssignmentImplementation(test4deleteAssignmentImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteAssignmentImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteAssignmentImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editAssignmentDefault() {
        instanceAssignmentService.editAssignment(test4editAssignmentDefaultArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4editAssignmentInitializedArguments() {
        instanceAssignmentService.editAssignment(test4editAssignmentInitializedArgumentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4editAssignmentTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.editAssignmentTxn(test4editAssignmentTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editAssignmentTxnDefaultResult;
        }
        assertEquals(test4editAssignmentTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editAssignmentTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.editAssignmentTxn(test4editAssignmentTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editAssignmentTxnInitializedArgumentsResult;
        }
        assertEquals(test4editAssignmentTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editAssignmentImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.editAssignmentImplementation(test4editAssignmentImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editAssignmentImplementationDefaultResult;
        }
        assertEquals(test4editAssignmentImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editAssignmentImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.editAssignmentImplementation(test4editAssignmentImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editAssignmentImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editAssignmentImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4terminateAssignmentDefault() {
        instanceAssignmentService.terminateAssignment(test4terminateAssignmentDefaultArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4terminateAssignmentInitializedArguments() {
        instanceAssignmentService.terminateAssignment(test4terminateAssignmentInitializedArgumentsArg1);
        assertNotNull(instanceAssignmentService);
    }

    @Test
    public void test4terminateAssignmentTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.terminateAssignmentTxn(test4terminateAssignmentTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4terminateAssignmentTxnDefaultResult;
        }
        assertEquals(test4terminateAssignmentTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4terminateAssignmentTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.terminateAssignmentTxn(test4terminateAssignmentTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4terminateAssignmentTxnInitializedArgumentsResult;
        }
        assertEquals(test4terminateAssignmentTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4terminateAssignmentImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.terminateAssignmentImplementation(test4terminateAssignmentImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4terminateAssignmentImplementationDefaultResult;
        }
        assertEquals(test4terminateAssignmentImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4terminateAssignmentImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAssignmentService.terminateAssignmentImplementation(test4terminateAssignmentImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4terminateAssignmentImplementationInitializedArgumentsResult;
        }
        assertEquals(test4terminateAssignmentImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
