package com.integranova.spring.expensereportdemo.api.globalservices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.globalservices.GlobalServicesApi;
import com.integranova.spring.expensereportdemo.service.GlobalServicesService;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class GlobalServicesApiTest {

    @Mock
    private GlobalServicesService mockGlobalServicesService;

    @InjectMocks
    private GlobalServicesApi instanceGlobalServicesApi;

    // testGLOBALTEST
    private static GLOBALTESTRequest testGLOBALTESTArg1;
    private static GLOBALTESTResponse testGLOBALTESTResult;

    // testGLOBALTESTCheckPreconditions
    private static GLOBALTESTRequest testGLOBALTESTCheckPreconditionsArg1;
    private static GLOBALTESTResponse testGLOBALTESTCheckPreconditionsResult;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGLOBALTEST();
        setUpMockData4testGLOBALTESTCheckPreconditions();
    }

    private static void setUpMockData4testGLOBALTEST() {
        testGLOBALTESTArg1 = new GLOBALTESTRequest();
        testGLOBALTESTResult = new GLOBALTESTResponse();
    }

    private static void setUpMockData4testGLOBALTESTCheckPreconditions() {
        testGLOBALTESTCheckPreconditionsArg1 = new GLOBALTESTRequest();
        testGLOBALTESTCheckPreconditionsResult = new GLOBALTESTResponse();
    }

    @Before
    public void setUp() {

        when(mockGlobalServicesService.gLOBALTEST(testGLOBALTESTArg1)).thenReturn(testGLOBALTESTResult);

        when(mockGlobalServicesService.gLOBALTESTCheckPreconditions(testGLOBALTESTCheckPreconditionsArg1)).thenReturn(testGLOBALTESTCheckPreconditionsResult);
    }

    @Test
    public void testGLOBALTEST() {
        assertEquals(testGLOBALTESTResult, instanceGlobalServicesApi.gLOBALTEST(testGLOBALTESTArg1));
    }

    @Test
    public void testGLOBALTESTCheckPreconditions() {
        assertEquals(testGLOBALTESTCheckPreconditionsResult, instanceGlobalServicesApi.gLOBALTESTCheckPreconditions(testGLOBALTESTCheckPreconditionsArg1));
    }
}
