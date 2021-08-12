package com.integranova.spring.expensereportdemo.api.expensereport;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.expensereport.ExpenseReportApi;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.service.ExpenseReportService;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest;
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
public class ExpenseReportApiTest {

    @Mock
    private ExpenseReportService mockExpenseReportService;

    @InjectMocks
    private ExpenseReportApi instanceExpenseReportApi;

    // testGetDSExpenseReport4MD
    private static String testGetDSExpenseReport4MDArg1;
    private static String testGetDSExpenseReport4MDArg2;
    private static String testGetDSExpenseReport4MDArg3;
    private static DSExpenseReport4MD testGetDSExpenseReport4MDResult;

    // testGetDSExpenseReport4MD2
    private static String testGetDSExpenseReport4MD2Arg1;
    private static String testGetDSExpenseReport4MD2Arg2;
    private static String testGetDSExpenseReport4MD2Arg3;
    private static DSExpenseReport4MD testGetDSExpenseReport4MD2Result;

    // testGetDSExpenseReport4MD3
    private static String testGetDSExpenseReport4MD3Arg1;
    private static String testGetDSExpenseReport4MD3Arg2;
    private static String testGetDSExpenseReport4MD3Arg3;
    private static DSExpenseReport4MD testGetDSExpenseReport4MD3Result;

    // testGetDSExpenseReport4MD4
    private static String testGetDSExpenseReport4MD4Arg1;
    private static String testGetDSExpenseReport4MD4Arg2;
    private static String testGetDSExpenseReport4MD4Arg3;
    private static DSExpenseReport4MD testGetDSExpenseReport4MD4Result;

    // testGetDSExpenseReportSup
    private static String testGetDSExpenseReportSupArg1;
    private static String testGetDSExpenseReportSupArg2;
    private static String testGetDSExpenseReportSupArg3;
    private static DSExpenseReportSup testGetDSExpenseReportSupResult;

    // testGetDSExpenseReportSup2
    private static String testGetDSExpenseReportSup2Arg1;
    private static String testGetDSExpenseReportSup2Arg2;
    private static String testGetDSExpenseReportSup2Arg3;
    private static DSExpenseReportSup testGetDSExpenseReportSup2Result;

    // testGetDSExpenseReportSup3
    private static String testGetDSExpenseReportSup3Arg1;
    private static String testGetDSExpenseReportSup3Arg2;
    private static String testGetDSExpenseReportSup3Arg3;
    private static DSExpenseReportSup testGetDSExpenseReportSup3Result;

    // testGetDSExpenseReportSup4
    private static String testGetDSExpenseReportSup4Arg1;
    private static String testGetDSExpenseReportSup4Arg2;
    private static String testGetDSExpenseReportSup4Arg3;
    private static DSExpenseReportSup testGetDSExpenseReportSup4Result;

    // testGetDSExpenseReport4HAT
    private static String testGetDSExpenseReport4HATArg1;
    private static String testGetDSExpenseReport4HATArg2;
    private static String testGetDSExpenseReport4HATArg3;
    private static DSExpenseReport4HAT testGetDSExpenseReport4HATResult;

    // testGetDSExpenseReport4HAT2
    private static String testGetDSExpenseReport4HAT2Arg1;
    private static String testGetDSExpenseReport4HAT2Arg2;
    private static String testGetDSExpenseReport4HAT2Arg3;
    private static DSExpenseReport4HAT testGetDSExpenseReport4HAT2Result;

    // testGetDSExpenseReport4HAT3
    private static String testGetDSExpenseReport4HAT3Arg1;
    private static String testGetDSExpenseReport4HAT3Arg2;
    private static String testGetDSExpenseReport4HAT3Arg3;
    private static DSExpenseReport4HAT testGetDSExpenseReport4HAT3Result;

    // testGetDSExpenseReport4HAT4
    private static String testGetDSExpenseReport4HAT4Arg1;
    private static String testGetDSExpenseReport4HAT4Arg2;
    private static String testGetDSExpenseReport4HAT4Arg3;
    private static DSExpenseReport4HAT testGetDSExpenseReport4HAT4Result;

    // testGetExpenseReport
    private static Long testGetExpenseReportArg1;
    private static ExpenseReport testGetExpenseReportResult;

    // testGetExpenseReportDynamic
    private static QueryRequest testGetExpenseReportDynamicArg1;
    private static ExpenseReportOid mockGetExpenseReportDynamicArg1;
    private static String mockGetExpenseReportDynamicArg2;
    private static InstanceResponseViewModel testGetExpenseReportDynamicResult;

    // testGetExpenseReportPreload
    private static QueryRequest testGetExpenseReportPreloadArg1;
    private static List<PreloadViewModel> testGetExpenseReportPreloadResult;

    // testGetExpenseReportWithDisplaySetDynamic
    private static QueryRequest testGetExpenseReportWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetExpenseReportWithDisplaySetDynamicResult;

    // testGetExpenseReportPopulationDynamic
    private static QueryRequest testGetExpenseReportPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetExpenseReportPopulationDynamicResult;

    // testGetExpenseReportByEmployee
    private static EmployeeOid testGetExpenseReportByEmployeeArg1;
    private static List<ExpenseReport> testGetExpenseReportByEmployeeResult;

    // testGetExpenseReportByExpenseCurrency
    private static ExpenseCurrencyOid testGetExpenseReportByExpenseCurrencyArg1;
    private static List<ExpenseReport> testGetExpenseReportByExpenseCurrencyResult;

    // testGetExpenseReportByPaymentType
    private static PaymentTypeOid testGetExpenseReportByPaymentTypeArg1;
    private static List<ExpenseReport> testGetExpenseReportByPaymentTypeResult;

    // testGetExpenseReportByProject
    private static ProjectOid testGetExpenseReportByProjectArg1;
    private static List<ExpenseReport> testGetExpenseReportByProjectResult;

    // testExpenseReportEclose
    private static EcloseRequest testExpenseReportEcloseArg1;
    private static ServiceResponse testExpenseReportEcloseResult;

    // testExpenseReportAuthorize
    private static AuthorizeRequest testExpenseReportAuthorizeArg1;
    private static ServiceResponse testExpenseReportAuthorizeResult;

    // testExpenseReportRejectautho
    private static RejectauthoRequest testExpenseReportRejectauthoArg1;
    private static ServiceResponse testExpenseReportRejectauthoResult;

    // testExpenseReportRejectauthoCheckPreconditions
    private static RejectauthoRequest testExpenseReportRejectauthoCheckPreconditionsArg1;
    private static ServiceResponse testExpenseReportRejectauthoCheckPreconditionsResult;

    // testExpenseReportCancelapprove
    private static CancelapproveRequest testExpenseReportCancelapproveArg1;
    private static ServiceResponse testExpenseReportCancelapproveResult;

    // testExpenseReportApprove
    private static ApproveRequest testExpenseReportApproveArg1;
    private static ServiceResponse testExpenseReportApproveResult;

    // testExpenseReportEditinstance
    private static EditinstanceRequest testExpenseReportEditinstanceArg1;
    private static ServiceResponse testExpenseReportEditinstanceResult;

    // testExpenseReportDELETEALL
    private static DELETEALLRequest testExpenseReportDELETEALLArg1;
    private static ServiceResponse testExpenseReportDELETEALLResult;

    // testExpenseReportTPAY
    private static TPAYRequest testExpenseReportTPAYArg1;
    private static ServiceResponse testExpenseReportTPAYResult;

    // testExpenseReportTNEW
    private static TNEWRequest testExpenseReportTNEWArg1;
    private static TNEWResponse testExpenseReportTNEWResult;

    // testExpenseReportTNEWCheckPreconditions
    private static TNEWRequest testExpenseReportTNEWCheckPreconditionsArg1;
    private static TNEWResponse testExpenseReportTNEWCheckPreconditionsResult;

    // testExpenseReportTREJECTPAYMENT
    private static TREJECTPAYMENTRequest testExpenseReportTREJECTPAYMENTArg1;
    private static ServiceResponse testExpenseReportTREJECTPAYMENTResult;

    // testExpenseReportTNEWFROMTEMPLATE
    private static TNEWFROMTEMPLATERequest testExpenseReportTNEWFROMTEMPLATEArg1;
    private static TNEWFROMTEMPLATEResponse testExpenseReportTNEWFROMTEMPLATEResult;

    // testExpenseReportTNEWFROMTEMPLATECheckPreconditions
    private static TNEWFROMTEMPLATERequest testExpenseReportTNEWFROMTEMPLATECheckPreconditionsArg1;
    private static TNEWFROMTEMPLATEResponse testExpenseReportTNEWFROMTEMPLATECheckPreconditionsResult;

    // testiiuIIUExpenseReport
    private static ExpenseReportOid testiiuIIUExpenseReportArg1;
    private static DSExpenseReport4MD testiiuIIUExpenseReportResult;

    // testpiuPIUExpenseReport
    private static PIUExpenseReportRequest testpiuPIUExpenseReportArg1;
    private static QueryRequest testpiuPIUExpenseReportMockArg1;
    private static List<DSExpenseReport4HAT> testpiuPIUExpenseReportMockResult;
    private static PIUExpenseReportResponse testpiuPIUExpenseReportResult;

    // testpiuPIUExpenseReport2
    private static PIUExpenseReportRequest testpiuPIUExpenseReport2Arg1;
    private static QueryRequest testpiuPIUExpenseReport2MockArg1;
    private static List<DSExpenseReport4HAT> testpiuPIUExpenseReport2MockResult;
    private static PIUExpenseReportResponse testpiuPIUExpenseReport2Result;

    // testpiuPIUExpenseReportToEmployee
    private static PIUExpenseReportToEmployeeRequest testpiuPIUExpenseReportToEmployeeArg1;
    private static QueryRequest testpiuPIUExpenseReportToEmployeeMockArg1;
    private static List<DSExpenseReport4MD> testpiuPIUExpenseReportToEmployeeMockResult;
    private static PIUExpenseReportToEmployeeResponse testpiuPIUExpenseReportToEmployeeResult;

    // testpiuPIUExpenseReportToEmployee2
    private static PIUExpenseReportToEmployeeRequest testpiuPIUExpenseReportToEmployee2Arg1;
    private static QueryRequest testpiuPIUExpenseReportToEmployee2MockArg1;
    private static List<DSExpenseReport4MD> testpiuPIUExpenseReportToEmployee2MockResult;
    private static PIUExpenseReportToEmployeeResponse testpiuPIUExpenseReportToEmployee2Result;

    // testpiuPIUExpenseReportProject
    private static PIUExpenseReportProjectRequest testpiuPIUExpenseReportProjectArg1;
    private static QueryRequest testpiuPIUExpenseReportProjectMockArg1;
    private static List<DSExpenseReport4MD> testpiuPIUExpenseReportProjectMockResult;
    private static PIUExpenseReportProjectResponse testpiuPIUExpenseReportProjectResult;

    // testpiuPIUExpenseReportProject2
    private static PIUExpenseReportProjectRequest testpiuPIUExpenseReportProject2Arg1;
    private static QueryRequest testpiuPIUExpenseReportProject2MockArg1;
    private static List<DSExpenseReport4MD> testpiuPIUExpenseReportProject2MockResult;
    private static PIUExpenseReportProjectResponse testpiuPIUExpenseReportProject2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSExpenseReport4MD();
        setUpMockData4testGetDSExpenseReport4MD2();
        setUpMockData4testGetDSExpenseReport4MD3();
        setUpMockData4testGetDSExpenseReport4MD4();
        setUpMockData4testGetDSExpenseReportSup();
        setUpMockData4testGetDSExpenseReportSup2();
        setUpMockData4testGetDSExpenseReportSup3();
        setUpMockData4testGetDSExpenseReportSup4();
        setUpMockData4testGetDSExpenseReport4HAT();
        setUpMockData4testGetDSExpenseReport4HAT2();
        setUpMockData4testGetDSExpenseReport4HAT3();
        setUpMockData4testGetDSExpenseReport4HAT4();
        setUpMockData4testGetExpenseReport();
        setUpMockData4testGetExpenseReportDynamic();
        setUpMockData4testGetExpenseReportPreload();
        setUpMockData4testGetExpenseReportWithDisplaySetDynamic();
        setUpMockData4testGetExpenseReportPopulationDynamic();
        setUpMockData4testGetExpenseReportByEmployee();
        setUpMockData4testGetExpenseReportByExpenseCurrency();
        setUpMockData4testGetExpenseReportByPaymentType();
        setUpMockData4testGetExpenseReportByProject();
        setUpMockData4testExpenseReportEclose();
        setUpMockData4testExpenseReportAuthorize();
        setUpMockData4testExpenseReportRejectautho();
        setUpMockData4testExpenseReportRejectauthoCheckPreconditions();
        setUpMockData4testExpenseReportCancelapprove();
        setUpMockData4testExpenseReportApprove();
        setUpMockData4testExpenseReportEditinstance();
        setUpMockData4testExpenseReportDELETEALL();
        setUpMockData4testExpenseReportTPAY();
        setUpMockData4testExpenseReportTNEW();
        setUpMockData4testExpenseReportTNEWCheckPreconditions();
        setUpMockData4testExpenseReportTREJECTPAYMENT();
        setUpMockData4testExpenseReportTNEWFROMTEMPLATE();
        setUpMockData4testExpenseReportTNEWFROMTEMPLATECheckPreconditions();
        setUpMockData4testiiuIIUExpenseReport();
        setUpMockData4testpiuPIUExpenseReport();
        setUpMockData4testpiuPIUExpenseReport2();
        setUpMockData4testpiuPIUExpenseReportToEmployee();
        setUpMockData4testpiuPIUExpenseReportToEmployee2();
        setUpMockData4testpiuPIUExpenseReportProject();
        setUpMockData4testpiuPIUExpenseReportProject2();
    }

    private static void setUpMockData4testGetDSExpenseReport4MD() {
        testGetDSExpenseReport4MDArg1 = "";
        testGetDSExpenseReport4MDArg2 = "";
        testGetDSExpenseReport4MDArg3 = "";
        testGetDSExpenseReport4MDResult = new DSExpenseReport4MD();
    }

    private static void setUpMockData4testGetDSExpenseReport4MD2() {
        testGetDSExpenseReport4MD2Arg1 = "";
        testGetDSExpenseReport4MD2Arg2 = null;
        testGetDSExpenseReport4MD2Arg3 = null;
        testGetDSExpenseReport4MD2Result = testGetDSExpenseReport4MDResult;
    }

    private static void setUpMockData4testGetDSExpenseReport4MD3() {
        testGetDSExpenseReport4MD3Arg1 = "";
        testGetDSExpenseReport4MD3Arg2 = null;
        testGetDSExpenseReport4MD3Arg3 = "";
        testGetDSExpenseReport4MD3Result = testGetDSExpenseReport4MDResult;
    }

    private static void setUpMockData4testGetDSExpenseReport4MD4() {
        testGetDSExpenseReport4MD4Arg1 = "";
        testGetDSExpenseReport4MD4Arg2 = "";
        testGetDSExpenseReport4MD4Arg3 = null;
        testGetDSExpenseReport4MD4Result = testGetDSExpenseReport4MDResult;
    }

    private static void setUpMockData4testGetDSExpenseReportSup() {
        testGetDSExpenseReportSupArg1 = "";
        testGetDSExpenseReportSupArg2 = "";
        testGetDSExpenseReportSupArg3 = "";
        testGetDSExpenseReportSupResult = new DSExpenseReportSup();
    }

    private static void setUpMockData4testGetDSExpenseReportSup2() {
        testGetDSExpenseReportSup2Arg1 = "";
        testGetDSExpenseReportSup2Arg2 = null;
        testGetDSExpenseReportSup2Arg3 = null;
        testGetDSExpenseReportSup2Result = testGetDSExpenseReportSupResult;
    }

    private static void setUpMockData4testGetDSExpenseReportSup3() {
        testGetDSExpenseReportSup3Arg1 = "";
        testGetDSExpenseReportSup3Arg2 = null;
        testGetDSExpenseReportSup3Arg3 = "";
        testGetDSExpenseReportSup3Result = testGetDSExpenseReportSupResult;
    }

    private static void setUpMockData4testGetDSExpenseReportSup4() {
        testGetDSExpenseReportSup4Arg1 = "";
        testGetDSExpenseReportSup4Arg2 = "";
        testGetDSExpenseReportSup4Arg3 = null;
        testGetDSExpenseReportSup4Result = testGetDSExpenseReportSupResult;
    }

    private static void setUpMockData4testGetDSExpenseReport4HAT() {
        testGetDSExpenseReport4HATArg1 = "";
        testGetDSExpenseReport4HATArg2 = "";
        testGetDSExpenseReport4HATArg3 = "";
        testGetDSExpenseReport4HATResult = new DSExpenseReport4HAT();
    }

    private static void setUpMockData4testGetDSExpenseReport4HAT2() {
        testGetDSExpenseReport4HAT2Arg1 = "";
        testGetDSExpenseReport4HAT2Arg2 = null;
        testGetDSExpenseReport4HAT2Arg3 = null;
        testGetDSExpenseReport4HAT2Result = testGetDSExpenseReport4HATResult;
    }

    private static void setUpMockData4testGetDSExpenseReport4HAT3() {
        testGetDSExpenseReport4HAT3Arg1 = "";
        testGetDSExpenseReport4HAT3Arg2 = null;
        testGetDSExpenseReport4HAT3Arg3 = "";
        testGetDSExpenseReport4HAT3Result = testGetDSExpenseReport4HATResult;
    }

    private static void setUpMockData4testGetDSExpenseReport4HAT4() {
        testGetDSExpenseReport4HAT4Arg1 = "";
        testGetDSExpenseReport4HAT4Arg2 = "";
        testGetDSExpenseReport4HAT4Arg3 = null;
        testGetDSExpenseReport4HAT4Result = testGetDSExpenseReport4HATResult;
    }

    private static void setUpMockData4testGetExpenseReport() {
        testGetExpenseReportArg1 = Long.valueOf(0);
        testGetExpenseReportResult = new ExpenseReport();
    }

    private static void setUpMockData4testGetExpenseReportDynamic() {
        mockGetExpenseReportDynamicArg1 = new ExpenseReportOid();
        mockGetExpenseReportDynamicArg2 = "";
        testGetExpenseReportDynamicArg1 = new QueryRequest();
        testGetExpenseReportDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseReportPreload() {
        testGetExpenseReportPreloadArg1 = new QueryRequest();
        testGetExpenseReportPreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseReportWithDisplaySetDynamic() {
        testGetExpenseReportWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetExpenseReportWithDisplaySetDynamicArg1.setDisplaySetName("testGetExpenseReportWithDisplaySetDynamicArg1");
        testGetExpenseReportWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseReportPopulationDynamic() {
        testGetExpenseReportPopulationDynamicArg1 = new QueryRequest();
        testGetExpenseReportPopulationDynamicArg1.setDisplaySetName("testGetExpenseReportPopulationDynamicArg1");
        testGetExpenseReportPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseReportByEmployee() {
        testGetExpenseReportByEmployeeArg1 = new EmployeeOid();
        testGetExpenseReportByEmployeeResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseReportByExpenseCurrency() {
        testGetExpenseReportByExpenseCurrencyArg1 = new ExpenseCurrencyOid();
        testGetExpenseReportByExpenseCurrencyResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseReportByPaymentType() {
        testGetExpenseReportByPaymentTypeArg1 = new PaymentTypeOid();
        testGetExpenseReportByPaymentTypeResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseReportByProject() {
        testGetExpenseReportByProjectArg1 = new ProjectOid();
        testGetExpenseReportByProjectResult = new ArrayList<>();
    }

    private static void setUpMockData4testExpenseReportEclose() {
        testExpenseReportEcloseArg1 = new EcloseRequest();
        testExpenseReportEcloseResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportAuthorize() {
        testExpenseReportAuthorizeArg1 = new AuthorizeRequest();
        testExpenseReportAuthorizeResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportRejectautho() {
        testExpenseReportRejectauthoArg1 = new RejectauthoRequest();
        testExpenseReportRejectauthoResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportRejectauthoCheckPreconditions() {
        testExpenseReportRejectauthoCheckPreconditionsArg1 = new RejectauthoRequest();
        testExpenseReportRejectauthoCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportCancelapprove() {
        testExpenseReportCancelapproveArg1 = new CancelapproveRequest();
        testExpenseReportCancelapproveResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportApprove() {
        testExpenseReportApproveArg1 = new ApproveRequest();
        testExpenseReportApproveResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportEditinstance() {
        testExpenseReportEditinstanceArg1 = new EditinstanceRequest();
        testExpenseReportEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportDELETEALL() {
        testExpenseReportDELETEALLArg1 = new DELETEALLRequest();
        testExpenseReportDELETEALLResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportTPAY() {
        testExpenseReportTPAYArg1 = new TPAYRequest();
        testExpenseReportTPAYResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportTNEW() {
        testExpenseReportTNEWArg1 = new TNEWRequest();
        testExpenseReportTNEWResult = new TNEWResponse();
    }

    private static void setUpMockData4testExpenseReportTNEWCheckPreconditions() {
        testExpenseReportTNEWCheckPreconditionsArg1 = new TNEWRequest();
        testExpenseReportTNEWCheckPreconditionsResult = new TNEWResponse();
    }

    private static void setUpMockData4testExpenseReportTREJECTPAYMENT() {
        testExpenseReportTREJECTPAYMENTArg1 = new TREJECTPAYMENTRequest();
        testExpenseReportTREJECTPAYMENTResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseReportTNEWFROMTEMPLATE() {
        testExpenseReportTNEWFROMTEMPLATEArg1 = new TNEWFROMTEMPLATERequest();
        testExpenseReportTNEWFROMTEMPLATEResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4testExpenseReportTNEWFROMTEMPLATECheckPreconditions() {
        testExpenseReportTNEWFROMTEMPLATECheckPreconditionsArg1 = new TNEWFROMTEMPLATERequest();
        testExpenseReportTNEWFROMTEMPLATECheckPreconditionsResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4testiiuIIUExpenseReport() {
        testiiuIIUExpenseReportArg1 = new ExpenseReportOid();
        testiiuIIUExpenseReportResult = new DSExpenseReport4MD();
    }

    private static void setUpMockData4testpiuPIUExpenseReport() {
        testpiuPIUExpenseReportMockArg1 = new QueryRequest();
        testpiuPIUExpenseReportMockArg1.setPageSize(0);
        testpiuPIUExpenseReportMockResult = new ArrayList<>();
        testpiuPIUExpenseReportArg1 = mock(PIUExpenseReportRequest.class);
        testpiuPIUExpenseReportResult = new PIUExpenseReportResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseReport2() {
        testpiuPIUExpenseReport2MockArg1 = new QueryRequest();
        testpiuPIUExpenseReport2MockArg1.setPageSize(1);
        testpiuPIUExpenseReport2MockResult = new ArrayList<>();
        testpiuPIUExpenseReport2MockResult.add(new DSExpenseReport4HAT());
        testpiuPIUExpenseReport2Arg1 = mock(PIUExpenseReportRequest.class);
        testpiuPIUExpenseReport2Arg1.setPageSize(1);
        testpiuPIUExpenseReport2Result = new PIUExpenseReportResponse();
        testpiuPIUExpenseReport2Result.setTotalItems(1);
    }

    private static void setUpMockData4testpiuPIUExpenseReportToEmployee() {
        testpiuPIUExpenseReportToEmployeeMockArg1 = new QueryRequest();
        testpiuPIUExpenseReportToEmployeeMockArg1.setPageSize(0);
        testpiuPIUExpenseReportToEmployeeMockResult = new ArrayList<>();
        testpiuPIUExpenseReportToEmployeeArg1 = mock(PIUExpenseReportToEmployeeRequest.class);
        testpiuPIUExpenseReportToEmployeeResult = new PIUExpenseReportToEmployeeResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseReportToEmployee2() {
        testpiuPIUExpenseReportToEmployee2MockArg1 = new QueryRequest();
        testpiuPIUExpenseReportToEmployee2MockArg1.setPageSize(1);
        testpiuPIUExpenseReportToEmployee2MockResult = new ArrayList<>();
        testpiuPIUExpenseReportToEmployee2MockResult.add(new DSExpenseReport4MD());
        testpiuPIUExpenseReportToEmployee2Arg1 = mock(PIUExpenseReportToEmployeeRequest.class);
        testpiuPIUExpenseReportToEmployee2Arg1.setPageSize(1);
        testpiuPIUExpenseReportToEmployee2Result = new PIUExpenseReportToEmployeeResponse();
        testpiuPIUExpenseReportToEmployee2Result.setTotalItems(1);
    }

    private static void setUpMockData4testpiuPIUExpenseReportProject() {
        testpiuPIUExpenseReportProjectMockArg1 = new QueryRequest();
        testpiuPIUExpenseReportProjectMockArg1.setPageSize(0);
        testpiuPIUExpenseReportProjectMockResult = new ArrayList<>();
        testpiuPIUExpenseReportProjectArg1 = mock(PIUExpenseReportProjectRequest.class);
        testpiuPIUExpenseReportProjectResult = new PIUExpenseReportProjectResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseReportProject2() {
        testpiuPIUExpenseReportProject2MockArg1 = new QueryRequest();
        testpiuPIUExpenseReportProject2MockArg1.setPageSize(1);
        testpiuPIUExpenseReportProject2MockResult = new ArrayList<>();
        testpiuPIUExpenseReportProject2MockResult.add(new DSExpenseReport4MD());
        testpiuPIUExpenseReportProject2Arg1 = mock(PIUExpenseReportProjectRequest.class);
        testpiuPIUExpenseReportProject2Arg1.setPageSize(1);
        testpiuPIUExpenseReportProject2Result = new PIUExpenseReportProjectResponse();
        testpiuPIUExpenseReportProject2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockExpenseReportService.getDSExpenseReport4MD(testGetDSExpenseReport4MDArg1, testGetDSExpenseReport4MDArg2, testGetDSExpenseReport4MDArg3)).thenReturn(testGetDSExpenseReport4MDResult);

        when(mockExpenseReportService.getDSExpenseReportSup(testGetDSExpenseReportSupArg1, testGetDSExpenseReportSupArg2, testGetDSExpenseReportSupArg3)).thenReturn(testGetDSExpenseReportSupResult);

        when(mockExpenseReportService.getDSExpenseReport4HAT(testGetDSExpenseReport4HATArg1, testGetDSExpenseReport4HATArg2, testGetDSExpenseReport4HATArg3)).thenReturn(testGetDSExpenseReport4HATResult);

        when(mockExpenseReportService.getById(testGetExpenseReportArg1)).thenReturn(testGetExpenseReportResult);

        when(mockExpenseReportService.getExpenseReportDynamic(mockGetExpenseReportDynamicArg1, mockGetExpenseReportDynamicArg2)).thenReturn(testGetExpenseReportDynamicResult);

        when(mockExpenseReportService.getPreload(testGetExpenseReportPreloadArg1)).thenReturn(testGetExpenseReportPreloadResult);

        when(mockExpenseReportService.getDynamic(testGetExpenseReportWithDisplaySetDynamicArg1)).thenReturn(testGetExpenseReportWithDisplaySetDynamicResult);

        when(mockExpenseReportService.getDynamic(testGetExpenseReportPopulationDynamicArg1)).thenReturn(testGetExpenseReportPopulationDynamicResult);

        when(mockExpenseReportService.getInstancesByRelated(any(Employee.class), eq("Employee"))).thenReturn(testGetExpenseReportByEmployeeResult);

        when(mockExpenseReportService.getInstancesByRelated(any(ExpenseCurrency.class), eq("ExpenseCurrency"))).thenReturn(testGetExpenseReportByExpenseCurrencyResult);

        when(mockExpenseReportService.getInstancesByRelated(any(PaymentType.class), eq("PaymentType"))).thenReturn(testGetExpenseReportByPaymentTypeResult);

        when(mockExpenseReportService.getInstancesByRelated(any(Project.class), eq("Project"))).thenReturn(testGetExpenseReportByProjectResult);

        when(mockExpenseReportService.eclose(testExpenseReportEcloseArg1)).thenReturn(testExpenseReportEcloseResult);

        when(mockExpenseReportService.authorize(testExpenseReportAuthorizeArg1)).thenReturn(testExpenseReportAuthorizeResult);

        when(mockExpenseReportService.rejectautho(testExpenseReportRejectauthoArg1)).thenReturn(testExpenseReportRejectauthoResult);

        when(mockExpenseReportService.rejectauthoCheckPreconditions(testExpenseReportRejectauthoCheckPreconditionsArg1)).thenReturn(testExpenseReportRejectauthoCheckPreconditionsResult);

        when(mockExpenseReportService.cancelapprove(testExpenseReportCancelapproveArg1)).thenReturn(testExpenseReportCancelapproveResult);

        when(mockExpenseReportService.approve(testExpenseReportApproveArg1)).thenReturn(testExpenseReportApproveResult);

        when(mockExpenseReportService.editinstance(testExpenseReportEditinstanceArg1)).thenReturn(testExpenseReportEditinstanceResult);

        when(mockExpenseReportService.dELETEALL(testExpenseReportDELETEALLArg1)).thenReturn(testExpenseReportDELETEALLResult);

        when(mockExpenseReportService.tPAY(testExpenseReportTPAYArg1)).thenReturn(testExpenseReportTPAYResult);

        when(mockExpenseReportService.tNEW(testExpenseReportTNEWArg1)).thenReturn(testExpenseReportTNEWResult);

        when(mockExpenseReportService.tNEWCheckPreconditions(testExpenseReportTNEWCheckPreconditionsArg1)).thenReturn(testExpenseReportTNEWCheckPreconditionsResult);

        when(mockExpenseReportService.tREJECTPAYMENT(testExpenseReportTREJECTPAYMENTArg1)).thenReturn(testExpenseReportTREJECTPAYMENTResult);

        when(mockExpenseReportService.tNEWFROMTEMPLATE(testExpenseReportTNEWFROMTEMPLATEArg1)).thenReturn(testExpenseReportTNEWFROMTEMPLATEResult);

        when(mockExpenseReportService.tNEWFROMTEMPLATECheckPreconditions(testExpenseReportTNEWFROMTEMPLATECheckPreconditionsArg1)).thenReturn(testExpenseReportTNEWFROMTEMPLATECheckPreconditionsResult);

        when(mockExpenseReportService.iIUExpenseReport(testiiuIIUExpenseReportArg1)).thenReturn(testiiuIIUExpenseReportResult);

        when(testpiuPIUExpenseReportArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReportMockArg1);

        when(mockExpenseReportService.piuPIUExpenseReport(testpiuPIUExpenseReportMockArg1)).thenReturn(testpiuPIUExpenseReportMockResult);

        when(testpiuPIUExpenseReport2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReport2MockArg1);

        when(mockExpenseReportService.piuPIUExpenseReport(testpiuPIUExpenseReport2MockArg1)).thenReturn(testpiuPIUExpenseReport2MockResult);

        when(mockExpenseReportService.getCount4PIUExpenseReport(testpiuPIUExpenseReport2MockArg1)).thenReturn(1);

        when(testpiuPIUExpenseReportToEmployeeArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReportToEmployeeMockArg1);

        when(mockExpenseReportService.piuPIUExpenseReportToEmployee(testpiuPIUExpenseReportToEmployeeMockArg1)).thenReturn(testpiuPIUExpenseReportToEmployeeMockResult);

        when(testpiuPIUExpenseReportToEmployee2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReportToEmployee2MockArg1);

        when(mockExpenseReportService.piuPIUExpenseReportToEmployee(testpiuPIUExpenseReportToEmployee2MockArg1)).thenReturn(testpiuPIUExpenseReportToEmployee2MockResult);

        when(mockExpenseReportService.getCount4PIUExpenseReportToEmployee(testpiuPIUExpenseReportToEmployee2MockArg1)).thenReturn(1);

        when(testpiuPIUExpenseReportProjectArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReportProjectMockArg1);

        when(mockExpenseReportService.piuPIUExpenseReportProject(testpiuPIUExpenseReportProjectMockArg1)).thenReturn(testpiuPIUExpenseReportProjectMockResult);

        when(testpiuPIUExpenseReportProject2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseReportProject2MockArg1);

        when(mockExpenseReportService.piuPIUExpenseReportProject(testpiuPIUExpenseReportProject2MockArg1)).thenReturn(testpiuPIUExpenseReportProject2MockResult);

        when(mockExpenseReportService.getCount4PIUExpenseReportProject(testpiuPIUExpenseReportProject2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSExpenseReport4MD() {
        assertEquals(testGetDSExpenseReport4MDResult, instanceExpenseReportApi.getDSExpenseReport4MD(testGetDSExpenseReport4MDArg1, testGetDSExpenseReport4MDArg2, testGetDSExpenseReport4MDArg3));
    }

    @Test
    public void testGetDSExpenseReport4MD2() {
        assertEquals(testGetDSExpenseReport4MD2Result, instanceExpenseReportApi.getDSExpenseReport4MD(testGetDSExpenseReport4MD2Arg1, testGetDSExpenseReport4MD2Arg2, testGetDSExpenseReport4MD2Arg3));
    }

    @Test
    public void testGetDSExpenseReport4MD3() {
        assertEquals(testGetDSExpenseReport4MD3Result, instanceExpenseReportApi.getDSExpenseReport4MD(testGetDSExpenseReport4MD3Arg1, testGetDSExpenseReport4MD3Arg2, testGetDSExpenseReport4MD3Arg3));
    }

    @Test
    public void testGetDSExpenseReport4MD4() {
        assertEquals(testGetDSExpenseReport4MD4Result, instanceExpenseReportApi.getDSExpenseReport4MD(testGetDSExpenseReport4MD4Arg1, testGetDSExpenseReport4MD4Arg2, testGetDSExpenseReport4MD4Arg3));
    }

    @Test
    public void testGetDSExpenseReportSup() {
        assertEquals(testGetDSExpenseReportSupResult, instanceExpenseReportApi.getDSExpenseReportSup(testGetDSExpenseReportSupArg1, testGetDSExpenseReportSupArg2, testGetDSExpenseReportSupArg3));
    }

    @Test
    public void testGetDSExpenseReportSup2() {
        assertEquals(testGetDSExpenseReportSup2Result, instanceExpenseReportApi.getDSExpenseReportSup(testGetDSExpenseReportSup2Arg1, testGetDSExpenseReportSup2Arg2, testGetDSExpenseReportSup2Arg3));
    }

    @Test
    public void testGetDSExpenseReportSup3() {
        assertEquals(testGetDSExpenseReportSup3Result, instanceExpenseReportApi.getDSExpenseReportSup(testGetDSExpenseReportSup3Arg1, testGetDSExpenseReportSup3Arg2, testGetDSExpenseReportSup3Arg3));
    }

    @Test
    public void testGetDSExpenseReportSup4() {
        assertEquals(testGetDSExpenseReportSup4Result, instanceExpenseReportApi.getDSExpenseReportSup(testGetDSExpenseReportSup4Arg1, testGetDSExpenseReportSup4Arg2, testGetDSExpenseReportSup4Arg3));
    }

    @Test
    public void testGetDSExpenseReport4HAT() {
        assertEquals(testGetDSExpenseReport4HATResult, instanceExpenseReportApi.getDSExpenseReport4HAT(testGetDSExpenseReport4HATArg1, testGetDSExpenseReport4HATArg2, testGetDSExpenseReport4HATArg3));
    }

    @Test
    public void testGetDSExpenseReport4HAT2() {
        assertEquals(testGetDSExpenseReport4HAT2Result, instanceExpenseReportApi.getDSExpenseReport4HAT(testGetDSExpenseReport4HAT2Arg1, testGetDSExpenseReport4HAT2Arg2, testGetDSExpenseReport4HAT2Arg3));
    }

    @Test
    public void testGetDSExpenseReport4HAT3() {
        assertEquals(testGetDSExpenseReport4HAT3Result, instanceExpenseReportApi.getDSExpenseReport4HAT(testGetDSExpenseReport4HAT3Arg1, testGetDSExpenseReport4HAT3Arg2, testGetDSExpenseReport4HAT3Arg3));
    }

    @Test
    public void testGetDSExpenseReport4HAT4() {
        assertEquals(testGetDSExpenseReport4HAT4Result, instanceExpenseReportApi.getDSExpenseReport4HAT(testGetDSExpenseReport4HAT4Arg1, testGetDSExpenseReport4HAT4Arg2, testGetDSExpenseReport4HAT4Arg3));
    }

    @Test
    public void testGetExpenseReport() {
        assertEquals(testGetExpenseReportResult, instanceExpenseReportApi.getExpenseReport(testGetExpenseReportArg1));
    }

    @Test
    public void testGetExpenseReportDynamic() {
        assertEquals(testGetExpenseReportDynamicResult, instanceExpenseReportApi.getExpenseReportDynamic(testGetExpenseReportDynamicArg1));
    }

    @Test
    public void testGetExpenseReportPreload() {
        assertEquals(testGetExpenseReportPreloadResult, instanceExpenseReportApi.getExpenseReportPreload(testGetExpenseReportPreloadArg1));
    }

    @Test
    public void testGetExpenseReportWithDisplaySetDynamic() {
        assertEquals(testGetExpenseReportWithDisplaySetDynamicResult, instanceExpenseReportApi.getExpenseReportWithDisplaySetDynamic(testGetExpenseReportWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetExpenseReportPopulationDynamic() {
        assertEquals(testGetExpenseReportPopulationDynamicResult, instanceExpenseReportApi.getExpenseReportPopulationDynamic(testGetExpenseReportPopulationDynamicArg1));
    }

    @Test
    public void testGetExpenseReportByEmployee() {
        assertEquals(testGetExpenseReportByEmployeeResult, instanceExpenseReportApi.getExpenseReportByEmployee(testGetExpenseReportByEmployeeArg1));
    }

    @Test
    public void testGetExpenseReportByExpenseCurrency() {
        assertEquals(testGetExpenseReportByExpenseCurrencyResult, instanceExpenseReportApi.getExpenseReportByExpenseCurrency(testGetExpenseReportByExpenseCurrencyArg1));
    }

    @Test
    public void testGetExpenseReportByPaymentType() {
        assertEquals(testGetExpenseReportByPaymentTypeResult, instanceExpenseReportApi.getExpenseReportByPaymentType(testGetExpenseReportByPaymentTypeArg1));
    }

    @Test
    public void testGetExpenseReportByProject() {
        assertEquals(testGetExpenseReportByProjectResult, instanceExpenseReportApi.getExpenseReportByProject(testGetExpenseReportByProjectArg1));
    }

    @Test
    public void testExpenseReportEclose() {
        assertEquals(testExpenseReportEcloseResult, instanceExpenseReportApi.expenseReportEclose(testExpenseReportEcloseArg1));
    }

    @Test
    public void testExpenseReportAuthorize() {
        assertEquals(testExpenseReportAuthorizeResult, instanceExpenseReportApi.expenseReportAuthorize(testExpenseReportAuthorizeArg1));
    }

    @Test
    public void testExpenseReportRejectautho() {
        assertEquals(testExpenseReportRejectauthoResult, instanceExpenseReportApi.expenseReportRejectautho(testExpenseReportRejectauthoArg1));
    }

    @Test
    public void testExpenseReportRejectauthoCheckPreconditions() {
        assertEquals(testExpenseReportRejectauthoCheckPreconditionsResult, instanceExpenseReportApi.expenseReportRejectauthoCheckPreconditions(testExpenseReportRejectauthoCheckPreconditionsArg1));
    }

    @Test
    public void testExpenseReportCancelapprove() {
        assertEquals(testExpenseReportCancelapproveResult, instanceExpenseReportApi.expenseReportCancelapprove(testExpenseReportCancelapproveArg1));
    }

    @Test
    public void testExpenseReportApprove() {
        assertEquals(testExpenseReportApproveResult, instanceExpenseReportApi.expenseReportApprove(testExpenseReportApproveArg1));
    }

    @Test
    public void testExpenseReportEditinstance() {
        assertEquals(testExpenseReportEditinstanceResult, instanceExpenseReportApi.expenseReportEditinstance(testExpenseReportEditinstanceArg1));
    }

    @Test
    public void testExpenseReportDELETEALL() {
        assertEquals(testExpenseReportDELETEALLResult, instanceExpenseReportApi.expenseReportDELETEALL(testExpenseReportDELETEALLArg1));
    }

    @Test
    public void testExpenseReportTPAY() {
        assertEquals(testExpenseReportTPAYResult, instanceExpenseReportApi.expenseReportTPAY(testExpenseReportTPAYArg1));
    }

    @Test
    public void testExpenseReportTNEW() {
        assertEquals(testExpenseReportTNEWResult, instanceExpenseReportApi.expenseReportTNEW(testExpenseReportTNEWArg1));
    }

    @Test
    public void testExpenseReportTNEWCheckPreconditions() {
        assertEquals(testExpenseReportTNEWCheckPreconditionsResult, instanceExpenseReportApi.expenseReportTNEWCheckPreconditions(testExpenseReportTNEWCheckPreconditionsArg1));
    }

    @Test
    public void testExpenseReportTREJECTPAYMENT() {
        assertEquals(testExpenseReportTREJECTPAYMENTResult, instanceExpenseReportApi.expenseReportTREJECTPAYMENT(testExpenseReportTREJECTPAYMENTArg1));
    }

    @Test
    public void testExpenseReportTNEWFROMTEMPLATE() {
        assertEquals(testExpenseReportTNEWFROMTEMPLATEResult, instanceExpenseReportApi.expenseReportTNEWFROMTEMPLATE(testExpenseReportTNEWFROMTEMPLATEArg1));
    }

    @Test
    public void testExpenseReportTNEWFROMTEMPLATECheckPreconditions() {
        assertEquals(testExpenseReportTNEWFROMTEMPLATECheckPreconditionsResult, instanceExpenseReportApi.expenseReportTNEWFROMTEMPLATECheckPreconditions(testExpenseReportTNEWFROMTEMPLATECheckPreconditionsArg1));
    }

    @Test
    public void testiiuIIUExpenseReport() {
        assertEquals(testiiuIIUExpenseReportResult, instanceExpenseReportApi.iiuIIUExpenseReport(testiiuIIUExpenseReportArg1));
    }

    @Test
    public void testpiuPIUExpenseReport() {
        assertEquals(testpiuPIUExpenseReportResult.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReport(testpiuPIUExpenseReportArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseReport2() {
        assertEquals(testpiuPIUExpenseReport2Result.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReport(testpiuPIUExpenseReport2Arg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseReportToEmployee() {
        assertEquals(testpiuPIUExpenseReportToEmployeeResult.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReportToEmployee(testpiuPIUExpenseReportToEmployeeArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseReportToEmployee2() {
        assertEquals(testpiuPIUExpenseReportToEmployee2Result.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReportToEmployee(testpiuPIUExpenseReportToEmployee2Arg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseReportProject() {
        assertEquals(testpiuPIUExpenseReportProjectResult.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReportProject(testpiuPIUExpenseReportProjectArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseReportProject2() {
        assertEquals(testpiuPIUExpenseReportProject2Result.getTotalItems(), instanceExpenseReportApi.piuPIUExpenseReportProject(testpiuPIUExpenseReportProject2Arg1).getTotalItems());
    }
}
