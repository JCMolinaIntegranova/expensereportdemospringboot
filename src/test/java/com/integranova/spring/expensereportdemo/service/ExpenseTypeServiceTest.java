package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
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
public class ExpenseTypeServiceTest extends ClassTest {

    @InjectMocks
    private ExpenseTypeService instanceExpenseTypeService;
    
    @Mock
    private static ExpenseTypeJpaRepository mockRepository;
    
    @Mock
    private static ExpenseTypeService mockExpenseTypeService;
    
    @Mock
    private static ExpenseLineService mockExpenseLineService;
    
    @Mock
    private static ERLTemplateService mockERLTemplateService;

    private static ExpenseType mockInstance1;
    
    private static ExpenseType mockInstance2;

    private static List<ExpenseType> mockPopulation;

    private static String mockexpenseTypeTypeCode;

    private static Optional<ExpenseType> mockExpenseType; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ExpenseType> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ExpenseType> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByOrderCriteriaOCExpenseType
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCExpenseTypeArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCExpenseTypeResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSExpenseType
    private static QueryRequest test4getDynamicPreload4DSExpenseTypeArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseTypeResult;

    // test4getDynamicPreload4DSExpenseTypeSup
    private static QueryRequest test4getDynamicPreload4DSExpenseTypeSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseTypeSupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static String test4getByIdArg1;
    private static ExpenseType test4getByIdResult;

    // test4getByRelated
    private static ExpenseType test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ExpenseType> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ExpenseType test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ExpenseType> test4getInstancesByRelatedResult;

    // test4getExpenseTypeDynamic
    private static ExpenseTypeOid test4getExpenseTypeDynamicArg1;
    private static String test4getExpenseTypeDynamicArg2;
    private static InstanceResponseViewModel test4getExpenseTypeDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ExpenseTypeOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ExpenseTypeOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSExpenseTypeSup
    private static ExpenseTypeOid test4getSuppInfoWithDSDSExpenseTypeSupArg1;
    private static String test4getSuppInfoWithDSDSExpenseTypeSupArg2;

    // test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3;

    // test4getDSExpenseType
    private static String test4getDSExpenseTypeArg1;
    private static String test4getDSExpenseTypeArg2;
    private static String test4getDSExpenseTypeArg3;
    private static DSExpenseType test4getDSExpenseTypeResult;

    // test4getPreloadDSExpenseType
    private static QueryRequest test4getPreloadDSExpenseTypeArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseTypeResult;

    // test4getDSExpenseTypeSup
    private static String test4getDSExpenseTypeSupArg1;
    private static String test4getDSExpenseTypeSupArg2;
    private static String test4getDSExpenseTypeSupArg3;
    private static DSExpenseTypeSup test4getDSExpenseTypeSupResult;

    // test4getPreloadDSExpenseTypeSup
    private static QueryRequest test4getPreloadDSExpenseTypeSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseTypeSupResult;

    // test4iIUExpenseType
    private static ExpenseTypeOid test4iIUExpenseTypeArg1;
    private static DSExpenseType test4iIUExpenseTypeResult;

    // test4piuPIUExpenseType
    private static QueryRequest test4piuPIUExpenseTypeArg1;
    private static List<DSExpenseType> test4piuPIUExpenseTypeResult;

    // test4getCount4PIUExpenseType
    private static QueryRequest test4getCount4PIUExpenseTypeArg1;
    private static int test4getCount4PIUExpenseTypeResult;

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

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockexpenseTypeTypeCode = "";
        mockInstance1 = new ExpenseType();
        mockInstance2 = new ExpenseType();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockExpenseType = Optional.of(new ExpenseType(new ExpenseTypeOid(mockexpenseTypeTypeCode)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseType();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSExpenseType();
        setUpMockData4test4getDynamicPreload4DSExpenseTypeSup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getExpenseTypeDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSExpenseTypeSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath();
        setUpMockData4test4getDSExpenseType();
        setUpMockData4test4getPreloadDSExpenseType();
        setUpMockData4test4getDSExpenseTypeSup();
        setUpMockData4test4getPreloadDSExpenseTypeSup();
        setUpMockData4test4iIUExpenseType();
        setUpMockData4test4piuPIUExpenseType();
        setUpMockData4test4getCount4PIUExpenseType();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("expenseTypeTypeCode");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseType() {
        test4getDynamicPopulationByOrderCriteriaOCExpenseTypeArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCExpenseTypeArg1.setDisplaySetItems("expenseTypeTypeCode");
        test4getDynamicPopulationByOrderCriteriaOCExpenseTypeArg1.setOrderCriteriaName("OCExpenseType");
        test4getDynamicPopulationByOrderCriteriaOCExpenseTypeResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("expenseTypeTypeCode");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ExpenseTypeOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseType() {
        test4getDynamicPreload4DSExpenseTypeArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseTypeArg1.setDisplaySetName(ExpenseTypeConstants.DSDSEXPENSETYPE);
        test4getDynamicPreload4DSExpenseTypeResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseTypeService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseTypeArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseTypeSup() {
        test4getDynamicPreload4DSExpenseTypeSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseTypeSupArg1.setDisplaySetName(ExpenseTypeConstants.DSDSEXPENSETYPESUP);
        test4getDynamicPreload4DSExpenseTypeSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseTypeService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseTypeSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockExpenseType.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ExpenseType();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ExpenseType();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getExpenseTypeDynamic() {
        test4getExpenseTypeDynamicArg1 = new ExpenseTypeOid();
        test4getExpenseTypeDynamicArg2 = "";
        test4getExpenseTypeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ExpenseTypeOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ExpenseTypeOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSExpenseTypeSup() {
        test4getSuppInfoWithDSDSExpenseTypeSupArg1 = new ExpenseTypeOid("");
        test4getSuppInfoWithDSDSExpenseTypeSupArg2 = ExpenseTypeConstants.DSDSEXPENSETYPESUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2 = ExpenseTypeConstants.ROLE_NAME_EXPENSELINES;
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2 = ExpenseTypeConstants.ROLE_NAME_EXPENSELINES;
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1 = new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2 = ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES;
        test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath() {
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1 = new ERLTemplateOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2 = ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES;
        test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSExpenseType() {
        test4getDSExpenseTypeArg1 = "";
        test4getDSExpenseTypeArg2 = "";
        test4getDSExpenseTypeArg3 = "";
        test4getDSExpenseTypeResult = new DSExpenseType();
    }

    private static void setUpMockData4test4getPreloadDSExpenseType() {
        test4getPreloadDSExpenseTypeArg1 = new QueryRequest();
        test4getPreloadDSExpenseTypeArg1.setDisplaySetName(ExpenseTypeConstants.DSDSEXPENSETYPE);
        test4getPreloadDSExpenseTypeResult = mockPopulation.stream().map(i -> ExpenseTypeService.buildPreloadViewModel(i, test4getPreloadDSExpenseTypeArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSExpenseTypeSup() {
        test4getDSExpenseTypeSupArg1 = "";
        test4getDSExpenseTypeSupArg2 = "";
        test4getDSExpenseTypeSupArg3 = "";
        test4getDSExpenseTypeSupResult = new DSExpenseTypeSup();
    }

    private static void setUpMockData4test4getPreloadDSExpenseTypeSup() {
        test4getPreloadDSExpenseTypeSupArg1 = new QueryRequest();
        test4getPreloadDSExpenseTypeSupArg1.setDisplaySetName(ExpenseTypeConstants.DSDSEXPENSETYPESUP);
        test4getPreloadDSExpenseTypeSupResult = mockPopulation.stream().map(i -> ExpenseTypeService.buildPreloadViewModel(i, test4getPreloadDSExpenseTypeSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUExpenseType() {
        test4iIUExpenseTypeArg1 = new ExpenseTypeOid();
        test4iIUExpenseTypeResult = new DSExpenseType();
    }

    private static void setUpMockData4test4piuPIUExpenseType() {
        test4piuPIUExpenseTypeArg1 = new QueryRequest();
        test4piuPIUExpenseTypeResult = mockPopulation.stream().map(i -> new DSExpenseType(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseType() {
        test4getCount4PIUExpenseTypeArg1 = new QueryRequest();
        test4getCount4PIUExpenseTypeResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTypeCode("");
        test4createinstanceInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTyDescription("");
        test4createinstanceInitializedArgumentsArg1.setExpenseTypecreateinstancepatrPrice(Double.valueOf(0));
        test4createinstanceInitializedArgumentsArg1.setExpenseTypecreateinstancepatrFixedPrice(false);
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTypeCode("");
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTyDescription("");
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseTypecreateinstancepatrPrice(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseTypecreateinstancepatrFixedPrice(false);
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTypeCode("");
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseTypecreateinstancepatrTyDescription("");
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseTypecreateinstancepatrPrice(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseTypecreateinstancepatrFixedPrice(false);
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4deleteinstanceInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseTypeInstance(new ExpenseType(test4deleteinstanceInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseType()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4deleteinstanceTxnInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseTypeInstance(new ExpenseType(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseType()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExpenseTypedeleteinstancepthisExpenseTypeInstance(new ExpenseType(test4deleteinstanceImplementationInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseType()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4editinstanceInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseTypeInstance(new ExpenseType(test4editinstanceInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseType()));
        test4editinstanceInitializedArgumentsArg1.setExpenseTypeeditinstancepPrice(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setExpenseTypeeditinstancepTyDescription("");
        test4editinstanceInitializedArgumentsArg1.setExpenseTypeeditinstancepFixedPrice(false);
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseTypeInstance(new ExpenseType(test4editinstanceTxnInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseType()));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseTypeeditinstancepPrice(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseTypeeditinstancepTyDescription("");
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseTypeeditinstancepFixedPrice(false);
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseType(new ExpenseTypeOid(""));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseTypeeditinstancepthisExpenseTypeInstance(new ExpenseType(test4editinstanceImplementationInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseType()));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseTypeeditinstancepPrice(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseTypeeditinstancepTyDescription("");
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseTypeeditinstancepFixedPrice(false);
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceExpenseTypeService, "expenseTypeSrv", instanceExpenseTypeService);

        when(mockExpenseTypeService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseType())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseTypeInstance());

        when(mockExpenseTypeService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseType())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseTypedeleteinstancepthisExpenseTypeInstance());

        when(mockExpenseTypeService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseType())).thenReturn(test4editinstanceInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseTypeInstance());

        when(mockExpenseTypeService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseType())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getExpenseTypeeditinstancepthisExpenseTypeInstance());

        when(mockRepository.findById(mockexpenseTypeTypeCode)).thenAnswer(new Answer<Optional<ExpenseType>>(){
        	public Optional<ExpenseType> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockexpenseTypeTypeCode)) {
        			return mockExpenseType;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ExpenseType.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceExpenseTypeService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceExpenseTypeService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceExpenseTypeService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceExpenseTypeService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceExpenseTypeService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCExpenseType() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCExpenseTypeResult), getResult(TOTALITEMS, instanceExpenseTypeService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCExpenseTypeArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceExpenseTypeService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseType() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseTypeResult), getResult(TOTALITEMS, instanceExpenseTypeService.getDynamic(test4getDynamicPreload4DSExpenseTypeArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseTypeSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseTypeSupResult), getResult(TOTALITEMS, instanceExpenseTypeService.getDynamic(test4getDynamicPreload4DSExpenseTypeSupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceExpenseTypeService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceExpenseTypeService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceExpenseTypeService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceExpenseTypeService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getExpenseTypeDynamic() {
        assertEquals(test4getExpenseTypeDynamicResult.getResultCode(), instanceExpenseTypeService.getExpenseTypeDynamic(test4getExpenseTypeDynamicArg1, test4getExpenseTypeDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceExpenseTypeService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceExpenseTypeService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4getSuppInfoWithDSDSExpenseTypeSup() {
        instanceExpenseTypeService.getSuppInfo(test4getSuppInfoWithDSDSExpenseTypeSupArg1, test4getSuppInfoWithDSDSExpenseTypeSupArg2);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath() {
        instanceExpenseTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath() {
        instanceExpenseTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPath() {
        instanceExpenseTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleTemplateLinesWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4buildRelatedInstance4RoleTemplateLinesWithRemainingPath() {
        instanceExpenseTypeService.buildRelatedInstance(test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg1, test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg2, test4buildRelatedInstance4RoleTemplateLinesWithRemainingPathArg3);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4getDSExpenseType() {
        assertEquals(test4getDSExpenseTypeResult.getClass(), instanceExpenseTypeService.getDSExpenseType(test4getDSExpenseTypeArg1, test4getDSExpenseTypeArg2, test4getDSExpenseTypeArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseType() {
        instanceExpenseTypeService.getPreload(test4getPreloadDSExpenseTypeArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4getDSExpenseTypeSup() {
        assertEquals(test4getDSExpenseTypeSupResult.getClass(), instanceExpenseTypeService.getDSExpenseTypeSup(test4getDSExpenseTypeSupArg1, test4getDSExpenseTypeSupArg2, test4getDSExpenseTypeSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseTypeSup() {
        instanceExpenseTypeService.getPreload(test4getPreloadDSExpenseTypeSupArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4iIUExpenseType() {
        assertEquals(test4iIUExpenseTypeResult.getDSExpenseTypeTypeCode(), instanceExpenseTypeService.iIUExpenseType(test4iIUExpenseTypeArg1).getDSExpenseTypeTypeCode());
    }

    @Test
    public void test4piuPIUExpenseType() {
        instanceExpenseTypeService.piuPIUExpenseType(test4piuPIUExpenseTypeArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4getCount4PIUExpenseType() {
        instanceExpenseTypeService.getCount4PIUExpenseType(test4getCount4PIUExpenseTypeArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceExpenseTypeService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceExpenseTypeService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceExpenseTypeService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceExpenseTypeService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceExpenseTypeService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceExpenseTypeService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseTypeService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseTypeService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
