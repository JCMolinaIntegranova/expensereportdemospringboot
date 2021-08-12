package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.repository.PaymentTypeJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
public class PaymentTypeServiceTest extends ClassTest {

    @InjectMocks
    private PaymentTypeService instancePaymentTypeService;
    
    @Mock
    private static PaymentTypeJpaRepository mockRepository;
    
    @Mock
    private static PaymentTypeService mockPaymentTypeService;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;

    private static PaymentType mockInstance1;
    
    private static PaymentType mockInstance2;

    private static List<PaymentType> mockPopulation;

    private static String mockpaymentTypeidPaymentType;

    private static Optional<PaymentType> mockPaymentType; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<PaymentType> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<PaymentType> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByOrderCriteriaOCPaymentType
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCPaymentTypeArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCPaymentTypeResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSPaymentType
    private static QueryRequest test4getDynamicPreload4DSPaymentTypeArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSPaymentTypeResult;

    // test4getDynamicPreload4DSPaymentTypeSup
    private static QueryRequest test4getDynamicPreload4DSPaymentTypeSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSPaymentTypeSupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static String test4getByIdArg1;
    private static PaymentType test4getByIdResult;

    // test4getByRelated
    private static PaymentType test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<PaymentType> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static PaymentType test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<PaymentType> test4getInstancesByRelatedResult;

    // test4getPaymentTypeDynamic
    private static PaymentTypeOid test4getPaymentTypeDynamicArg1;
    private static String test4getPaymentTypeDynamicArg2;
    private static InstanceResponseViewModel test4getPaymentTypeDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static PaymentTypeOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static PaymentTypeOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSPaymentTypeSup
    private static PaymentTypeOid test4getSuppInfoWithDSDSPaymentTypeSupArg1;
    private static String test4getSuppInfoWithDSDSPaymentTypeSupArg2;

    // test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3;

    // test4getDSPaymentType
    private static String test4getDSPaymentTypeArg1;
    private static String test4getDSPaymentTypeArg2;
    private static String test4getDSPaymentTypeArg3;
    private static DSPaymentType test4getDSPaymentTypeResult;

    // test4getPreloadDSPaymentType
    private static QueryRequest test4getPreloadDSPaymentTypeArg1;
    private static List<PreloadViewModel> test4getPreloadDSPaymentTypeResult;

    // test4getDSPaymentTypeSup
    private static String test4getDSPaymentTypeSupArg1;
    private static String test4getDSPaymentTypeSupArg2;
    private static String test4getDSPaymentTypeSupArg3;
    private static DSPaymentTypeSup test4getDSPaymentTypeSupResult;

    // test4getPreloadDSPaymentTypeSup
    private static QueryRequest test4getPreloadDSPaymentTypeSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSPaymentTypeSupResult;

    // test4iIUPaymentType
    private static PaymentTypeOid test4iIUPaymentTypeArg1;
    private static DSPaymentType test4iIUPaymentTypeResult;

    // test4piuPIUPaymentType
    private static QueryRequest test4piuPIUPaymentTypeArg1;
    private static List<DSPaymentType> test4piuPIUPaymentTypeResult;

    // test4getCount4PIUPaymentType
    private static QueryRequest test4getCount4PIUPaymentTypeArg1;
    private static int test4getCount4PIUPaymentTypeResult;

    // test4createinstanceDefault
    private static CreateinstanceRequest test4createinstanceDefaultArg1;

    // test4createinstanceInitializedArguments
    private static CreateinstanceRequest test4createinstanceInitializedArgumentsArg1;

    // test4createinstanceTxnDefault
    private static CreateinstanceRequest test4createinstanceTxnDefaultArg1;
    private static ServiceResponse test4createinstanceTxnDefaultResult;

    // test4createinstanceTxnInitializedArguments
    private static CreateinstanceRequest test4createinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceTxnInitializedArgumentsResult;

    // test4createinstanceImplementationDefault
    private static CreateinstanceRequest test4createinstanceImplementationDefaultArg1;
    private static ServiceResponse test4createinstanceImplementationDefaultResult;

    // test4createinstanceImplementationInitializedArguments
    private static CreateinstanceRequest test4createinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceImplementationInitializedArgumentsResult;

    // test4deleteinstanceDefault
    private static DeleteinstanceRequest test4deleteinstanceDefaultArg1;

    // test4deleteinstanceInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceInitializedArgumentsArg1;

    // test4deleteinstanceTxnDefault
    private static DeleteinstanceRequest test4deleteinstanceTxnDefaultArg1;
    private static ServiceResponse test4deleteinstanceTxnDefaultResult;

    // test4deleteinstanceTxnInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceTxnInitializedArgumentsResult;

    // test4deleteinstanceImplementationDefault
    private static DeleteinstanceRequest test4deleteinstanceImplementationDefaultArg1;
    private static ServiceResponse test4deleteinstanceImplementationDefaultResult;

    // test4deleteinstanceImplementationInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceImplementationInitializedArgumentsResult;

    // test4editinstanceDefault
    private static EditinstanceRequest test4editinstanceDefaultArg1;

    // test4editinstanceInitializedArguments
    private static EditinstanceRequest test4editinstanceInitializedArgumentsArg1;

    // test4editinstanceTxnDefault
    private static EditinstanceRequest test4editinstanceTxnDefaultArg1;
    private static ServiceResponse test4editinstanceTxnDefaultResult;

    // test4editinstanceTxnInitializedArguments
    private static EditinstanceRequest test4editinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceTxnInitializedArgumentsResult;

    // test4editinstanceImplementationDefault
    private static EditinstanceRequest test4editinstanceImplementationDefaultArg1;
    private static ServiceResponse test4editinstanceImplementationDefaultResult;

    // test4editinstanceImplementationInitializedArguments
    private static EditinstanceRequest test4editinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceImplementationInitializedArgumentsResult;

    // test4insPaymentTypeDefault
    private static InsPaymentTypeRequest test4insPaymentTypeDefaultArg1;

    // test4insPaymentTypeInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeInitializedArgumentsArg1;

    // test4insPaymentTypeTxnDefault
    private static InsPaymentTypeRequest test4insPaymentTypeTxnDefaultArg1;
    private static ServiceResponse test4insPaymentTypeTxnDefaultResult;

    // test4insPaymentTypeTxnInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4insPaymentTypeTxnInitializedArgumentsResult;

    // test4insPaymentTypeImplementationDefault
    private static InsPaymentTypeRequest test4insPaymentTypeImplementationDefaultArg1;
    private static boolean test4insPaymentTypeImplementationDefaultArg2;
    private static ServiceResponse test4insPaymentTypeImplementationDefaultResult;

    // test4insPaymentTypeImplementationInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeImplementationInitializedArgumentsArg1;
    private static boolean test4insPaymentTypeImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4insPaymentTypeImplementationInitializedArgumentsResult;

    // test4delPaymentTypeDefault
    private static DelPaymentTypeRequest test4delPaymentTypeDefaultArg1;

    // test4delPaymentTypeInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeInitializedArgumentsArg1;

    // test4delPaymentTypeTxnDefault
    private static DelPaymentTypeRequest test4delPaymentTypeTxnDefaultArg1;
    private static ServiceResponse test4delPaymentTypeTxnDefaultResult;

    // test4delPaymentTypeTxnInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4delPaymentTypeTxnInitializedArgumentsResult;

    // test4delPaymentTypeImplementationDefault
    private static DelPaymentTypeRequest test4delPaymentTypeImplementationDefaultArg1;
    private static boolean test4delPaymentTypeImplementationDefaultArg2;
    private static ServiceResponse test4delPaymentTypeImplementationDefaultResult;

    // test4delPaymentTypeImplementationInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeImplementationInitializedArgumentsArg1;
    private static boolean test4delPaymentTypeImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4delPaymentTypeImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockpaymentTypeidPaymentType = "";
        mockInstance1 = new PaymentType();
        mockInstance2 = new PaymentType();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockPaymentType = Optional.of(new PaymentType(new PaymentTypeOid(mockpaymentTypeidPaymentType)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCPaymentType();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSPaymentType();
        setUpMockData4test4getDynamicPreload4DSPaymentTypeSup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getPaymentTypeDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSPaymentTypeSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath();
        setUpMockData4test4getDSPaymentType();
        setUpMockData4test4getPreloadDSPaymentType();
        setUpMockData4test4getDSPaymentTypeSup();
        setUpMockData4test4getPreloadDSPaymentTypeSup();
        setUpMockData4test4iIUPaymentType();
        setUpMockData4test4piuPIUPaymentType();
        setUpMockData4test4getCount4PIUPaymentType();
        setUpMockData4test4createinstanceDefault();
        setUpMockData4test4createinstanceInitializedArguments();
        setUpMockData4test4createinstanceTxnDefault();
        setUpMockData4test4createinstanceTxnInitializedArguments();
        setUpMockData4test4createinstanceImplementationDefault();
        setUpMockData4test4createinstanceImplementationInitializedArguments();
        setUpMockData4test4deleteinstanceDefault();
        setUpMockData4test4deleteinstanceInitializedArguments();
        setUpMockData4test4deleteinstanceTxnDefault();
        setUpMockData4test4deleteinstanceTxnInitializedArguments();
        setUpMockData4test4deleteinstanceImplementationDefault();
        setUpMockData4test4deleteinstanceImplementationInitializedArguments();
        setUpMockData4test4editinstanceDefault();
        setUpMockData4test4editinstanceInitializedArguments();
        setUpMockData4test4editinstanceTxnDefault();
        setUpMockData4test4editinstanceTxnInitializedArguments();
        setUpMockData4test4editinstanceImplementationDefault();
        setUpMockData4test4editinstanceImplementationInitializedArguments();
        setUpMockData4test4insPaymentTypeDefault();
        setUpMockData4test4insPaymentTypeInitializedArguments();
        setUpMockData4test4insPaymentTypeTxnDefault();
        setUpMockData4test4insPaymentTypeTxnInitializedArguments();
        setUpMockData4test4insPaymentTypeImplementationDefault();
        setUpMockData4test4insPaymentTypeImplementationInitializedArguments();
        setUpMockData4test4delPaymentTypeDefault();
        setUpMockData4test4delPaymentTypeInitializedArguments();
        setUpMockData4test4delPaymentTypeTxnDefault();
        setUpMockData4test4delPaymentTypeTxnInitializedArguments();
        setUpMockData4test4delPaymentTypeImplementationDefault();
        setUpMockData4test4delPaymentTypeImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("paymentTypeidPaymentType");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCPaymentType() {
        test4getDynamicPopulationByOrderCriteriaOCPaymentTypeArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCPaymentTypeArg1.setDisplaySetItems("paymentTypeidPaymentType");
        test4getDynamicPopulationByOrderCriteriaOCPaymentTypeArg1.setOrderCriteriaName("OCPaymentType");
        test4getDynamicPopulationByOrderCriteriaOCPaymentTypeResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("paymentTypeidPaymentType");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new PaymentTypeOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSPaymentType() {
        test4getDynamicPreload4DSPaymentTypeArg1 = new QueryRequest();
        test4getDynamicPreload4DSPaymentTypeArg1.setDisplaySetName(PaymentTypeConstants.DSDSPAYMENTTYPE);
        test4getDynamicPreload4DSPaymentTypeResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> PaymentTypeService.buildPreloadViewModel(i, test4getDynamicPreload4DSPaymentTypeArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSPaymentTypeSup() {
        test4getDynamicPreload4DSPaymentTypeSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSPaymentTypeSupArg1.setDisplaySetName(PaymentTypeConstants.DSDSPAYMENTTYPESUP);
        test4getDynamicPreload4DSPaymentTypeSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> PaymentTypeService.buildPreloadViewModel(i, test4getDynamicPreload4DSPaymentTypeSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockPaymentType.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new PaymentType();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new PaymentType();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getPaymentTypeDynamic() {
        test4getPaymentTypeDynamicArg1 = new PaymentTypeOid();
        test4getPaymentTypeDynamicArg2 = "";
        test4getPaymentTypeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new PaymentTypeOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new PaymentTypeOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSPaymentTypeSup() {
        test4getSuppInfoWithDSDSPaymentTypeSupArg1 = new PaymentTypeOid("");
        test4getSuppInfoWithDSDSPaymentTypeSupArg2 = PaymentTypeConstants.DSDSPAYMENTTYPESUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2 = PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2 = PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSPaymentType() {
        test4getDSPaymentTypeArg1 = "";
        test4getDSPaymentTypeArg2 = "";
        test4getDSPaymentTypeArg3 = "";
        test4getDSPaymentTypeResult = new DSPaymentType();
    }

    private static void setUpMockData4test4getPreloadDSPaymentType() {
        test4getPreloadDSPaymentTypeArg1 = new QueryRequest();
        test4getPreloadDSPaymentTypeArg1.setDisplaySetName(PaymentTypeConstants.DSDSPAYMENTTYPE);
        test4getPreloadDSPaymentTypeResult = mockPopulation.stream().map(i -> PaymentTypeService.buildPreloadViewModel(i, test4getPreloadDSPaymentTypeArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSPaymentTypeSup() {
        test4getDSPaymentTypeSupArg1 = "";
        test4getDSPaymentTypeSupArg2 = "";
        test4getDSPaymentTypeSupArg3 = "";
        test4getDSPaymentTypeSupResult = new DSPaymentTypeSup();
    }

    private static void setUpMockData4test4getPreloadDSPaymentTypeSup() {
        test4getPreloadDSPaymentTypeSupArg1 = new QueryRequest();
        test4getPreloadDSPaymentTypeSupArg1.setDisplaySetName(PaymentTypeConstants.DSDSPAYMENTTYPESUP);
        test4getPreloadDSPaymentTypeSupResult = mockPopulation.stream().map(i -> PaymentTypeService.buildPreloadViewModel(i, test4getPreloadDSPaymentTypeSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUPaymentType() {
        test4iIUPaymentTypeArg1 = new PaymentTypeOid();
        test4iIUPaymentTypeResult = new DSPaymentType();
    }

    private static void setUpMockData4test4piuPIUPaymentType() {
        test4piuPIUPaymentTypeArg1 = new QueryRequest();
        test4piuPIUPaymentTypeResult = mockPopulation.stream().map(i -> new DSPaymentType(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUPaymentType() {
        test4getCount4PIUPaymentTypeArg1 = new QueryRequest();
        test4getCount4PIUPaymentTypeResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setPaymentTypecreateinstancepatridPaymentType("");
        test4createinstanceInitializedArgumentsArg1.setPaymentTypecreateinstancepatrPayDescription("");
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setPaymentTypecreateinstancepatridPaymentType("");
        test4createinstanceTxnInitializedArgumentsArg1.setPaymentTypecreateinstancepatrPayDescription("");
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setPaymentTypecreateinstancepatridPaymentType("");
        test4createinstanceImplementationInitializedArgumentsArg1.setPaymentTypecreateinstancepatrPayDescription("");
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentType(new PaymentTypeOid(""));
        test4deleteinstanceInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentTypeInstance(new PaymentType(test4deleteinstanceInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentType()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentType(new PaymentTypeOid(""));
        test4deleteinstanceTxnInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentTypeInstance(new PaymentType(test4deleteinstanceTxnInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentType()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentType(new PaymentTypeOid(""));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setPaymentTypedeleteinstancepthisPaymentTypeInstance(new PaymentType(test4deleteinstanceImplementationInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentType()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentType(new PaymentTypeOid(""));
        test4editinstanceInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentTypeInstance(new PaymentType(test4editinstanceInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentType()));
        test4editinstanceInitializedArgumentsArg1.setPaymentTypeeditinstancepPayDescription("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentType(new PaymentTypeOid(""));
        test4editinstanceTxnInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentTypeInstance(new PaymentType(test4editinstanceTxnInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentType()));
        test4editinstanceTxnInitializedArgumentsArg1.setPaymentTypeeditinstancepPayDescription("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentType(new PaymentTypeOid(""));
        test4editinstanceImplementationInitializedArgumentsArg1.setPaymentTypeeditinstancepthisPaymentTypeInstance(new PaymentType(test4editinstanceImplementationInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentType()));
        test4editinstanceImplementationInitializedArgumentsArg1.setPaymentTypeeditinstancepPayDescription("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeDefault() {
        test4insPaymentTypeDefaultArg1 = new InsPaymentTypeRequest();
    }

    private static void setUpMockData4test4insPaymentTypeInitializedArguments() {
        test4insPaymentTypeInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(new PaymentType(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentType()));
        test4insPaymentTypeInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReport()));
    }

    private static void setUpMockData4test4insPaymentTypeTxnDefault() {
        test4insPaymentTypeTxnDefaultArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeTxnInitializedArguments() {
        test4insPaymentTypeTxnInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(new PaymentType(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentType()));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReport()));
        test4insPaymentTypeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeImplementationDefault() {
        test4insPaymentTypeImplementationDefaultArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeImplementationDefaultArg2 = true;
        test4insPaymentTypeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeImplementationInitializedArguments() {
        test4insPaymentTypeImplementationInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(new PaymentType(test4insPaymentTypeImplementationInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentType()));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4insPaymentTypeImplementationInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReport()));
        test4insPaymentTypeImplementationInitializedArgumentsArg2 = true;
        test4insPaymentTypeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeDefault() {
        test4delPaymentTypeDefaultArg1 = new DelPaymentTypeRequest();
    }

    private static void setUpMockData4test4delPaymentTypeInitializedArguments() {
        test4delPaymentTypeInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(new PaymentType(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentType()));
        test4delPaymentTypeInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReport()));
    }

    private static void setUpMockData4test4delPaymentTypeTxnDefault() {
        test4delPaymentTypeTxnDefaultArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeTxnInitializedArguments() {
        test4delPaymentTypeTxnInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(new PaymentType(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentType()));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReport()));
        test4delPaymentTypeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeImplementationDefault() {
        test4delPaymentTypeImplementationDefaultArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeImplementationDefaultArg2 = true;
        test4delPaymentTypeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeImplementationInitializedArguments() {
        test4delPaymentTypeImplementationInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(new PaymentType(test4delPaymentTypeImplementationInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentType()));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(new ExpenseReport(test4delPaymentTypeImplementationInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReport()));
        test4delPaymentTypeImplementationInitializedArgumentsArg2 = true;
        test4delPaymentTypeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instancePaymentTypeService, "paymentTypeSrv", instancePaymentTypeService);

        when(mockPaymentTypeService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentType())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentTypeInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentType())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getPaymentTypedeleteinstancepthisPaymentTypeInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentType())).thenReturn(test4editinstanceInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentTypeInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentType())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getPaymentTypeeditinstancepthisPaymentTypeInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentType())).thenReturn(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReport())).thenReturn(test4insPaymentTypeInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentType())).thenReturn(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepthisPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReport())).thenReturn(test4insPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeInsPaymentTypepevcExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentType())).thenReturn(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReport())).thenReturn(test4delPaymentTypeInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentType())).thenReturn(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepthisPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReport())).thenReturn(test4delPaymentTypeTxnInitializedArgumentsArg1.getPaymentTypeDelPaymentTypepevcExpenseReportInstance());

        when(mockRepository.findById(mockpaymentTypeidPaymentType)).thenAnswer(new Answer<Optional<PaymentType>>(){
        	public Optional<PaymentType> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockpaymentTypeidPaymentType)) {
        			return mockPaymentType;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(PaymentType.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instancePaymentTypeService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instancePaymentTypeService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instancePaymentTypeService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instancePaymentTypeService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instancePaymentTypeService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCPaymentType() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCPaymentTypeResult), getResult(TOTALITEMS, instancePaymentTypeService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCPaymentTypeArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instancePaymentTypeService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSPaymentType() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSPaymentTypeResult), getResult(TOTALITEMS, instancePaymentTypeService.getDynamic(test4getDynamicPreload4DSPaymentTypeArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSPaymentTypeSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSPaymentTypeSupResult), getResult(TOTALITEMS, instancePaymentTypeService.getDynamic(test4getDynamicPreload4DSPaymentTypeSupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instancePaymentTypeService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instancePaymentTypeService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instancePaymentTypeService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instancePaymentTypeService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getPaymentTypeDynamic() {
        assertEquals(test4getPaymentTypeDynamicResult.getResultCode(), instancePaymentTypeService.getPaymentTypeDynamic(test4getPaymentTypeDynamicArg1, test4getPaymentTypeDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instancePaymentTypeService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instancePaymentTypeService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4getSuppInfoWithDSDSPaymentTypeSup() {
        instancePaymentTypeService.getSuppInfo(test4getSuppInfoWithDSDSPaymentTypeSupArg1, test4getSuppInfoWithDSDSPaymentTypeSupArg2);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        instancePaymentTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        instancePaymentTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4getDSPaymentType() {
        assertEquals(test4getDSPaymentTypeResult.getClass(), instancePaymentTypeService.getDSPaymentType(test4getDSPaymentTypeArg1, test4getDSPaymentTypeArg2, test4getDSPaymentTypeArg3).getClass());
    }

    @Test
    public void test4getPreloadDSPaymentType() {
        instancePaymentTypeService.getPreload(test4getPreloadDSPaymentTypeArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4getDSPaymentTypeSup() {
        assertEquals(test4getDSPaymentTypeSupResult.getClass(), instancePaymentTypeService.getDSPaymentTypeSup(test4getDSPaymentTypeSupArg1, test4getDSPaymentTypeSupArg2, test4getDSPaymentTypeSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSPaymentTypeSup() {
        instancePaymentTypeService.getPreload(test4getPreloadDSPaymentTypeSupArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4iIUPaymentType() {
        assertEquals(test4iIUPaymentTypeResult.getDSPaymentTypeIdPaymentType(), instancePaymentTypeService.iIUPaymentType(test4iIUPaymentTypeArg1).getDSPaymentTypeIdPaymentType());
    }

    @Test
    public void test4piuPIUPaymentType() {
        instancePaymentTypeService.piuPIUPaymentType(test4piuPIUPaymentTypeArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4getCount4PIUPaymentType() {
        instancePaymentTypeService.getCount4PIUPaymentType(test4getCount4PIUPaymentTypeArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4createinstanceDefault() {
        instancePaymentTypeService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instancePaymentTypeService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instancePaymentTypeService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instancePaymentTypeService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instancePaymentTypeService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instancePaymentTypeService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeDefault() {
        instancePaymentTypeService.insPaymentType(test4insPaymentTypeDefaultArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4insPaymentTypeInitializedArguments() {
        instancePaymentTypeService.insPaymentType(test4insPaymentTypeInitializedArgumentsArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4insPaymentTypeTxnDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.insPaymentTypeTxn(test4insPaymentTypeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4insPaymentTypeTxnDefaultResult;
        }
        assertEquals(test4insPaymentTypeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.insPaymentTypeTxn(test4insPaymentTypeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4insPaymentTypeTxnInitializedArgumentsResult;
        }
        assertEquals(test4insPaymentTypeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.insPaymentTypeImplementation(test4insPaymentTypeImplementationDefaultArg1, test4insPaymentTypeImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4insPaymentTypeImplementationDefaultResult;
        }
        assertEquals(test4insPaymentTypeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.insPaymentTypeImplementation(test4insPaymentTypeImplementationInitializedArgumentsArg1, test4insPaymentTypeImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4insPaymentTypeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4insPaymentTypeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeDefault() {
        instancePaymentTypeService.delPaymentType(test4delPaymentTypeDefaultArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4delPaymentTypeInitializedArguments() {
        instancePaymentTypeService.delPaymentType(test4delPaymentTypeInitializedArgumentsArg1);
        assertNotNull(instancePaymentTypeService);
    }

    @Test
    public void test4delPaymentTypeTxnDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.delPaymentTypeTxn(test4delPaymentTypeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4delPaymentTypeTxnDefaultResult;
        }
        assertEquals(test4delPaymentTypeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.delPaymentTypeTxn(test4delPaymentTypeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4delPaymentTypeTxnInitializedArgumentsResult;
        }
        assertEquals(test4delPaymentTypeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.delPaymentTypeImplementation(test4delPaymentTypeImplementationDefaultArg1, test4delPaymentTypeImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4delPaymentTypeImplementationDefaultResult;
        }
        assertEquals(test4delPaymentTypeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instancePaymentTypeService.delPaymentTypeImplementation(test4delPaymentTypeImplementationInitializedArgumentsArg1, test4delPaymentTypeImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4delPaymentTypeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4delPaymentTypeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
