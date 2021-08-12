package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.GlobalServicesJpaRepository;
import com.integranova.spring.expensereportdemo.service.GlobalServicesService;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GlobalServicesServiceTest {

    @InjectMocks
    private GlobalServicesService instanceGlobalServicesService;

    @Mock
    private GlobalServicesJpaRepository mockRepository;
    
    @Mock
    private GlobalServicesService mockGlobalServicesService;
    
    @Mock
    private ProjectService mockProjectService;
    
    @Mock
    private ExpenseReportService mockExpenseReportService;

    // test4getSerCtx

    // test4gLOBALTEST
    private static GLOBALTESTRequest gLOBALTESTArg1;

    // test4gLOBALTESTInitializedArguments
    private static GLOBALTESTRequest test4gLOBALTESTInitializedArgumentsArg1;

    // test4gLOBALTESTTxn
    private static GLOBALTESTRequest gLOBALTESTTxnArg1;
    private static GLOBALTESTResponse gLOBALTESTTxnResult;

    // test4gLOBALTESTTxnInitializedArguments
    private static GLOBALTESTRequest test4gLOBALTESTTxnInitializedArgumentsArg1;
    private static GLOBALTESTResponse test4gLOBALTESTTxnInitializedArgumentsResult;

    // test4gLOBALTESTImplementation
    private static GLOBALTESTRequest gLOBALTESTImplementationArg1;
    private static GLOBALTESTResponse gLOBALTESTImplementationResult;

    // test4gLOBALTESTImplementationInitializedArguments
    private static GLOBALTESTRequest test4gLOBALTESTImplementationInitializedArgumentsArg1;
    private static GLOBALTESTResponse test4gLOBALTESTImplementationInitializedArgumentsResult;

    // test4gLOBALTESTCheckPreconditions
    private static GLOBALTESTRequest gLOBALTESTCheckPreconditionsArg1;
    private static GLOBALTESTResponse gLOBALTESTCheckPreconditionsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4getSerCtx();
        setUpMockData4test4gLOBALTEST();
        setUpMockData4test4gLOBALTESTInitializedArguments();
        setUpMockData4test4gLOBALTESTTxn();
        setUpMockData4test4gLOBALTESTTxnInitializedArguments();
        setUpMockData4test4gLOBALTESTImplementation();
        setUpMockData4test4gLOBALTESTImplementationInitializedArguments();
        setUpMockData4test4gLOBALTESTCheckPreconditions();
    }

    private static void setUpMockData4test4getSerCtx() {
    }

    private static void setUpMockData4test4gLOBALTEST() {
        gLOBALTESTArg1 = new GLOBALTESTRequest();
    }

    private static void setUpMockData4test4gLOBALTESTInitializedArguments() {
        test4gLOBALTESTInitializedArgumentsArg1 = new GLOBALTESTRequest();
        test4gLOBALTESTInitializedArgumentsArg1.setGLOBALTESTpTotExpenses(Double.valueOf(0));
        test4gLOBALTESTInitializedArgumentsArg1.setGLOBALTESTpProjectName("");
    }

    private static void setUpMockData4test4gLOBALTESTTxn() {
        gLOBALTESTTxnArg1 = new GLOBALTESTRequest();
        gLOBALTESTTxnResult = new GLOBALTESTResponse();
    }

    private static void setUpMockData4test4gLOBALTESTTxnInitializedArguments() {
        test4gLOBALTESTTxnInitializedArgumentsArg1 = new GLOBALTESTRequest();
        test4gLOBALTESTTxnInitializedArgumentsArg1.setGLOBALTESTpTotExpenses(Double.valueOf(0));
        test4gLOBALTESTTxnInitializedArgumentsArg1.setGLOBALTESTpProjectName("");
        test4gLOBALTESTTxnInitializedArgumentsResult = new GLOBALTESTResponse();
    }

    private static void setUpMockData4test4gLOBALTESTImplementation() {
        gLOBALTESTImplementationArg1 = new GLOBALTESTRequest();
        gLOBALTESTImplementationResult = new GLOBALTESTResponse();
    }

    private static void setUpMockData4test4gLOBALTESTImplementationInitializedArguments() {
        test4gLOBALTESTImplementationInitializedArgumentsArg1 = new GLOBALTESTRequest();
        test4gLOBALTESTImplementationInitializedArgumentsArg1.setGLOBALTESTpTotExpenses(Double.valueOf(0));
        test4gLOBALTESTImplementationInitializedArgumentsArg1.setGLOBALTESTpProjectName("");
        test4gLOBALTESTImplementationInitializedArgumentsResult = new GLOBALTESTResponse();
    }

    private static void setUpMockData4test4gLOBALTESTCheckPreconditions() {
        gLOBALTESTCheckPreconditionsArg1 = new GLOBALTESTRequest();
        gLOBALTESTCheckPreconditionsResult = new GLOBALTESTResponse();
    }

    @Before
    public void setUp() throws SystemException {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceGlobalServicesService, "globalServicesSrv", instanceGlobalServicesService);
        List<Project> mockValue4assocOperator000 = new ArrayList<>(Arrays.asList(new Project() ));
        when(mockRepository.assocOperator000(any(), any())).thenReturn(mockValue4assocOperator000);
        List<ExpenseReport> mockValue4assocOperator001 = new ArrayList<>(Arrays.asList(new ExpenseReport() ));
        when(mockRepository.assocOperator001()).thenReturn(mockValue4assocOperator001);
        Long mockValue4assocOperator002 = Long.valueOf(0);
        when(mockRepository.assocOperator002()).thenReturn(mockValue4assocOperator002);
    }
    
    @After
    public void tearDown() {
        instanceGlobalServicesService = null;
    }

    @Test
    public void test4getSerCtx() {
        instanceGlobalServicesService.getSerCtx();
        assertNotNull(instanceGlobalServicesService);
    }

    @Test
    public void test4gLOBALTEST() {
        instanceGlobalServicesService.gLOBALTEST(gLOBALTESTArg1);
        assertNotNull(instanceGlobalServicesService);
    }

    @Test
    public void test4gLOBALTESTInitializedArguments() {
        instanceGlobalServicesService.gLOBALTEST(test4gLOBALTESTInitializedArgumentsArg1);
        assertNotNull(instanceGlobalServicesService);
    }

    @Test
    public void test4gLOBALTESTTxn() {
        GLOBALTESTResponse result;
        try {
            result = instanceGlobalServicesService.gLOBALTESTTxn(gLOBALTESTTxnArg1);
        } catch (Exception e) {
            result = gLOBALTESTTxnResult;
        }
        assertEquals(gLOBALTESTTxnResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4gLOBALTESTTxnInitializedArguments() {
        GLOBALTESTResponse result;
        try {
            result = instanceGlobalServicesService.gLOBALTESTTxn(test4gLOBALTESTTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4gLOBALTESTTxnInitializedArgumentsResult;
        }
        assertEquals(test4gLOBALTESTTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4gLOBALTESTImplementation() {
        GLOBALTESTResponse result;
        try {
            result = instanceGlobalServicesService.gLOBALTESTImplementation(gLOBALTESTImplementationArg1);
        } catch (Exception e) {
            result = gLOBALTESTImplementationResult;
        }
        assertEquals(gLOBALTESTImplementationResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4gLOBALTESTImplementationInitializedArguments() {
        GLOBALTESTResponse result;
        try {
            result = instanceGlobalServicesService.gLOBALTESTImplementation(test4gLOBALTESTImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4gLOBALTESTImplementationInitializedArgumentsResult;
        }
        assertEquals(test4gLOBALTESTImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4gLOBALTESTCheckPreconditions() {
        assertEquals(gLOBALTESTCheckPreconditionsResult.getResultCode(), instanceGlobalServicesService.gLOBALTESTCheckPreconditions(gLOBALTESTCheckPreconditionsArg1).getResultCode());
    }
}
