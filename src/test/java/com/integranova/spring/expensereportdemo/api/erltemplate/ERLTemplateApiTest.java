package com.integranova.spring.expensereportdemo.api.erltemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.erltemplate.ERLTemplateApi;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ERLTemplateService;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.piu.PIUTemplateLinesResponse;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
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
public class ERLTemplateApiTest {

    @Mock
    private ERLTemplateService mockERLTemplateService;

    @InjectMocks
    private ERLTemplateApi instanceERLTemplateApi;

    // testGetDSTemplateLines
    private static String testGetDSTemplateLinesArg1;
    private static String testGetDSTemplateLinesArg2;
    private static String testGetDSTemplateLinesArg3;
    private static DSTemplateLines testGetDSTemplateLinesResult;

    // testGetDSTemplateLines2
    private static String testGetDSTemplateLines2Arg1;
    private static String testGetDSTemplateLines2Arg2;
    private static String testGetDSTemplateLines2Arg3;
    private static DSTemplateLines testGetDSTemplateLines2Result;

    // testGetDSTemplateLines3
    private static String testGetDSTemplateLines3Arg1;
    private static String testGetDSTemplateLines3Arg2;
    private static String testGetDSTemplateLines3Arg3;
    private static DSTemplateLines testGetDSTemplateLines3Result;

    // testGetDSTemplateLines4
    private static String testGetDSTemplateLines4Arg1;
    private static String testGetDSTemplateLines4Arg2;
    private static String testGetDSTemplateLines4Arg3;
    private static DSTemplateLines testGetDSTemplateLines4Result;

    // testGetERLTemplate
    private static Long testGetERLTemplateArg1;
    private static Long testGetERLTemplateArg2;
    private static ERLTemplate testGetERLTemplateResult;

    // testGetERLTemplateDynamic
    private static QueryRequest testGetERLTemplateDynamicArg1;
    private static ERLTemplateOid mockGetERLTemplateDynamicArg1;
    private static String mockGetERLTemplateDynamicArg2;
    private static InstanceResponseViewModel testGetERLTemplateDynamicResult;

    // testGetERLTemplateWithDisplaySetDynamic
    private static QueryRequest testGetERLTemplateWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetERLTemplateWithDisplaySetDynamicResult;

    // testGetERLTemplatePopulationDynamic
    private static QueryRequest testGetERLTemplatePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetERLTemplatePopulationDynamicResult;

    // testGetERLTemplateByTemplate
    private static ERTemplateOid testGetERLTemplateByTemplateArg1;
    private static List<ERLTemplate> testGetERLTemplateByTemplateResult;

    // testGetERLTemplateByExpenseType
    private static ExpenseTypeOid testGetERLTemplateByExpenseTypeArg1;
    private static List<ERLTemplate> testGetERLTemplateByExpenseTypeResult;

    // testERLTemplateCreateinstance
    private static CreateinstanceRequest testERLTemplateCreateinstanceArg1;
    private static ServiceResponse testERLTemplateCreateinstanceResult;

    // testERLTemplateDeleteinstance
    private static DeleteinstanceRequest testERLTemplateDeleteinstanceArg1;
    private static ServiceResponse testERLTemplateDeleteinstanceResult;

    // testERLTemplateEditinstance
    private static EditinstanceRequest testERLTemplateEditinstanceArg1;
    private static ServiceResponse testERLTemplateEditinstanceResult;

    // testERLTemplateEditUnits
    private static EditUnitsRequest testERLTemplateEditUnitsArg1;
    private static ServiceResponse testERLTemplateEditUnitsResult;

    // testERLTemplateEditPrice
    private static EditPriceRequest testERLTemplateEditPriceArg1;
    private static ServiceResponse testERLTemplateEditPriceResult;

    // testERLTemplateEditDescription
    private static EditDescriptionRequest testERLTemplateEditDescriptionArg1;
    private static ServiceResponse testERLTemplateEditDescriptionResult;

    // testERLTemplateClearUnits
    private static ClearUnitsRequest testERLTemplateClearUnitsArg1;
    private static ServiceResponse testERLTemplateClearUnitsResult;

    // testERLTemplateClearPrice
    private static ClearPriceRequest testERLTemplateClearPriceArg1;
    private static ServiceResponse testERLTemplateClearPriceResult;

    // testERLTemplateClearDescription
    private static ClearDescriptionRequest testERLTemplateClearDescriptionArg1;
    private static ServiceResponse testERLTemplateClearDescriptionResult;

    // testpiuPIUTemplateLines
    private static PopulationRequestViewModel testpiuPIUTemplateLinesArg1;
    private static QueryRequest testpiuPIUTemplateLinesMockArg1;
    private static List<DSTemplateLines> testpiuPIUTemplateLinesMockResult;
    private static PIUTemplateLinesResponse testpiuPIUTemplateLinesResult;

    // testpiuPIUTemplateLines2
    private static PopulationRequestViewModel testpiuPIUTemplateLines2Arg1;
    private static QueryRequest testpiuPIUTemplateLines2MockArg1;
    private static List<DSTemplateLines> testpiuPIUTemplateLines2MockResult;
    private static PIUTemplateLinesResponse testpiuPIUTemplateLines2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSTemplateLines();
        setUpMockData4testGetDSTemplateLines2();
        setUpMockData4testGetDSTemplateLines3();
        setUpMockData4testGetDSTemplateLines4();
        setUpMockData4testGetERLTemplate();
        setUpMockData4testGetERLTemplateDynamic();
        setUpMockData4testGetERLTemplateWithDisplaySetDynamic();
        setUpMockData4testGetERLTemplatePopulationDynamic();
        setUpMockData4testGetERLTemplateByTemplate();
        setUpMockData4testGetERLTemplateByExpenseType();
        setUpMockData4testERLTemplateCreateinstance();
        setUpMockData4testERLTemplateDeleteinstance();
        setUpMockData4testERLTemplateEditinstance();
        setUpMockData4testERLTemplateEditUnits();
        setUpMockData4testERLTemplateEditPrice();
        setUpMockData4testERLTemplateEditDescription();
        setUpMockData4testERLTemplateClearUnits();
        setUpMockData4testERLTemplateClearPrice();
        setUpMockData4testERLTemplateClearDescription();
        setUpMockData4testpiuPIUTemplateLines();
        setUpMockData4testpiuPIUTemplateLines2();
    }

    private static void setUpMockData4testGetDSTemplateLines() {
        testGetDSTemplateLinesArg1 = "";
        testGetDSTemplateLinesArg2 = "";
        testGetDSTemplateLinesArg3 = "";
        testGetDSTemplateLinesResult = new DSTemplateLines();
    }

    private static void setUpMockData4testGetDSTemplateLines2() {
        testGetDSTemplateLines2Arg1 = "";
        testGetDSTemplateLines2Arg2 = null;
        testGetDSTemplateLines2Arg3 = null;
        testGetDSTemplateLines2Result = testGetDSTemplateLinesResult;
    }

    private static void setUpMockData4testGetDSTemplateLines3() {
        testGetDSTemplateLines3Arg1 = "";
        testGetDSTemplateLines3Arg2 = null;
        testGetDSTemplateLines3Arg3 = "";
        testGetDSTemplateLines3Result = testGetDSTemplateLinesResult;
    }

    private static void setUpMockData4testGetDSTemplateLines4() {
        testGetDSTemplateLines4Arg1 = "";
        testGetDSTemplateLines4Arg2 = "";
        testGetDSTemplateLines4Arg3 = null;
        testGetDSTemplateLines4Result = testGetDSTemplateLinesResult;
    }

    private static void setUpMockData4testGetERLTemplate() {
        testGetERLTemplateArg1 = Long.valueOf(0);
        testGetERLTemplateArg2 = Long.valueOf(0);
        testGetERLTemplateResult = new ERLTemplate();
    }

    private static void setUpMockData4testGetERLTemplateDynamic() {
        mockGetERLTemplateDynamicArg1 = new ERLTemplateOid();
        mockGetERLTemplateDynamicArg2 = "";
        testGetERLTemplateDynamicArg1 = new QueryRequest();
        testGetERLTemplateDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetERLTemplateWithDisplaySetDynamic() {
        testGetERLTemplateWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetERLTemplateWithDisplaySetDynamicArg1.setDisplaySetName("testGetERLTemplateWithDisplaySetDynamicArg1");
        testGetERLTemplateWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetERLTemplatePopulationDynamic() {
        testGetERLTemplatePopulationDynamicArg1 = new QueryRequest();
        testGetERLTemplatePopulationDynamicArg1.setDisplaySetName("testGetERLTemplatePopulationDynamicArg1");
        testGetERLTemplatePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetERLTemplateByTemplate() {
        testGetERLTemplateByTemplateArg1 = new ERTemplateOid();
        testGetERLTemplateByTemplateResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetERLTemplateByExpenseType() {
        testGetERLTemplateByExpenseTypeArg1 = new ExpenseTypeOid();
        testGetERLTemplateByExpenseTypeResult = new ArrayList<>();
    }

    private static void setUpMockData4testERLTemplateCreateinstance() {
        testERLTemplateCreateinstanceArg1 = new CreateinstanceRequest();
        testERLTemplateCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateDeleteinstance() {
        testERLTemplateDeleteinstanceArg1 = new DeleteinstanceRequest();
        testERLTemplateDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateEditinstance() {
        testERLTemplateEditinstanceArg1 = new EditinstanceRequest();
        testERLTemplateEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateEditUnits() {
        testERLTemplateEditUnitsArg1 = new EditUnitsRequest();
        testERLTemplateEditUnitsResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateEditPrice() {
        testERLTemplateEditPriceArg1 = new EditPriceRequest();
        testERLTemplateEditPriceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateEditDescription() {
        testERLTemplateEditDescriptionArg1 = new EditDescriptionRequest();
        testERLTemplateEditDescriptionResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateClearUnits() {
        testERLTemplateClearUnitsArg1 = new ClearUnitsRequest();
        testERLTemplateClearUnitsResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateClearPrice() {
        testERLTemplateClearPriceArg1 = new ClearPriceRequest();
        testERLTemplateClearPriceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERLTemplateClearDescription() {
        testERLTemplateClearDescriptionArg1 = new ClearDescriptionRequest();
        testERLTemplateClearDescriptionResult = new ServiceResponse();
    }

    private static void setUpMockData4testpiuPIUTemplateLines() {
        testpiuPIUTemplateLinesMockArg1 = new QueryRequest();
        testpiuPIUTemplateLinesMockArg1.setPageSize(0);
        testpiuPIUTemplateLinesMockResult = new ArrayList<>();
        testpiuPIUTemplateLinesArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUTemplateLinesResult = new PIUTemplateLinesResponse();
    }

    private static void setUpMockData4testpiuPIUTemplateLines2() {
        testpiuPIUTemplateLines2MockArg1 = new QueryRequest();
        testpiuPIUTemplateLines2MockArg1.setPageSize(1);
        testpiuPIUTemplateLines2MockResult = new ArrayList<>();
        testpiuPIUTemplateLines2MockResult.add(new DSTemplateLines());
        testpiuPIUTemplateLines2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUTemplateLines2Arg1.setPageSize(1);
        testpiuPIUTemplateLines2Result = new PIUTemplateLinesResponse();
        testpiuPIUTemplateLines2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockERLTemplateService.getDSTemplateLines(testGetDSTemplateLinesArg1, testGetDSTemplateLinesArg2, testGetDSTemplateLinesArg3)).thenReturn(testGetDSTemplateLinesResult);

        when(mockERLTemplateService.getById(testGetERLTemplateArg1, testGetERLTemplateArg2)).thenReturn(testGetERLTemplateResult);

        when(mockERLTemplateService.getERLTemplateDynamic(mockGetERLTemplateDynamicArg1, mockGetERLTemplateDynamicArg2)).thenReturn(testGetERLTemplateDynamicResult);

        when(mockERLTemplateService.getDynamic(testGetERLTemplateWithDisplaySetDynamicArg1)).thenReturn(testGetERLTemplateWithDisplaySetDynamicResult);

        when(mockERLTemplateService.getDynamic(testGetERLTemplatePopulationDynamicArg1)).thenReturn(testGetERLTemplatePopulationDynamicResult);

        when(mockERLTemplateService.getInstancesByRelated(any(ERTemplate.class), eq("Template"))).thenReturn(testGetERLTemplateByTemplateResult);

        when(mockERLTemplateService.getInstancesByRelated(any(ExpenseType.class), eq("ExpenseType"))).thenReturn(testGetERLTemplateByExpenseTypeResult);

        when(mockERLTemplateService.createinstance(testERLTemplateCreateinstanceArg1)).thenReturn(testERLTemplateCreateinstanceResult);

        when(mockERLTemplateService.deleteinstance(testERLTemplateDeleteinstanceArg1)).thenReturn(testERLTemplateDeleteinstanceResult);

        when(mockERLTemplateService.editinstance(testERLTemplateEditinstanceArg1)).thenReturn(testERLTemplateEditinstanceResult);

        when(mockERLTemplateService.editUnits(testERLTemplateEditUnitsArg1)).thenReturn(testERLTemplateEditUnitsResult);

        when(mockERLTemplateService.editPrice(testERLTemplateEditPriceArg1)).thenReturn(testERLTemplateEditPriceResult);

        when(mockERLTemplateService.editDescription(testERLTemplateEditDescriptionArg1)).thenReturn(testERLTemplateEditDescriptionResult);

        when(mockERLTemplateService.clearUnits(testERLTemplateClearUnitsArg1)).thenReturn(testERLTemplateClearUnitsResult);

        when(mockERLTemplateService.clearPrice(testERLTemplateClearPriceArg1)).thenReturn(testERLTemplateClearPriceResult);

        when(mockERLTemplateService.clearDescription(testERLTemplateClearDescriptionArg1)).thenReturn(testERLTemplateClearDescriptionResult);

        when(testpiuPIUTemplateLinesArg1.buildQueryRequest()).thenReturn(testpiuPIUTemplateLinesMockArg1);

        when(mockERLTemplateService.piuPIUTemplateLines(testpiuPIUTemplateLinesMockArg1)).thenReturn(testpiuPIUTemplateLinesMockResult);

        when(testpiuPIUTemplateLines2Arg1.buildQueryRequest()).thenReturn(testpiuPIUTemplateLines2MockArg1);

        when(mockERLTemplateService.piuPIUTemplateLines(testpiuPIUTemplateLines2MockArg1)).thenReturn(testpiuPIUTemplateLines2MockResult);

        when(mockERLTemplateService.getCount4PIUTemplateLines(testpiuPIUTemplateLines2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSTemplateLines() {
        assertEquals(testGetDSTemplateLinesResult, instanceERLTemplateApi.getDSTemplateLines(testGetDSTemplateLinesArg1, testGetDSTemplateLinesArg2, testGetDSTemplateLinesArg3));
    }

    @Test
    public void testGetDSTemplateLines2() {
        assertEquals(testGetDSTemplateLines2Result, instanceERLTemplateApi.getDSTemplateLines(testGetDSTemplateLines2Arg1, testGetDSTemplateLines2Arg2, testGetDSTemplateLines2Arg3));
    }

    @Test
    public void testGetDSTemplateLines3() {
        assertEquals(testGetDSTemplateLines3Result, instanceERLTemplateApi.getDSTemplateLines(testGetDSTemplateLines3Arg1, testGetDSTemplateLines3Arg2, testGetDSTemplateLines3Arg3));
    }

    @Test
    public void testGetDSTemplateLines4() {
        assertEquals(testGetDSTemplateLines4Result, instanceERLTemplateApi.getDSTemplateLines(testGetDSTemplateLines4Arg1, testGetDSTemplateLines4Arg2, testGetDSTemplateLines4Arg3));
    }

    @Test
    public void testGetERLTemplate() {
        assertEquals(testGetERLTemplateResult, instanceERLTemplateApi.getERLTemplate(testGetERLTemplateArg1, testGetERLTemplateArg2));
    }

    @Test
    public void testGetERLTemplateDynamic() {
        assertEquals(testGetERLTemplateDynamicResult, instanceERLTemplateApi.getERLTemplateDynamic(testGetERLTemplateDynamicArg1));
    }

    @Test
    public void testGetERLTemplateWithDisplaySetDynamic() {
        assertEquals(testGetERLTemplateWithDisplaySetDynamicResult, instanceERLTemplateApi.getERLTemplateWithDisplaySetDynamic(testGetERLTemplateWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetERLTemplatePopulationDynamic() {
        assertEquals(testGetERLTemplatePopulationDynamicResult, instanceERLTemplateApi.getERLTemplatePopulationDynamic(testGetERLTemplatePopulationDynamicArg1));
    }

    @Test
    public void testGetERLTemplateByTemplate() {
        assertEquals(testGetERLTemplateByTemplateResult, instanceERLTemplateApi.getERLTemplateByTemplate(testGetERLTemplateByTemplateArg1));
    }

    @Test
    public void testGetERLTemplateByExpenseType() {
        assertEquals(testGetERLTemplateByExpenseTypeResult, instanceERLTemplateApi.getERLTemplateByExpenseType(testGetERLTemplateByExpenseTypeArg1));
    }

    @Test
    public void testERLTemplateCreateinstance() {
        assertEquals(testERLTemplateCreateinstanceResult, instanceERLTemplateApi.eRLTemplateCreateinstance(testERLTemplateCreateinstanceArg1));
    }

    @Test
    public void testERLTemplateDeleteinstance() {
        assertEquals(testERLTemplateDeleteinstanceResult, instanceERLTemplateApi.eRLTemplateDeleteinstance(testERLTemplateDeleteinstanceArg1));
    }

    @Test
    public void testERLTemplateEditinstance() {
        assertEquals(testERLTemplateEditinstanceResult, instanceERLTemplateApi.eRLTemplateEditinstance(testERLTemplateEditinstanceArg1));
    }

    @Test
    public void testERLTemplateEditUnits() {
        assertEquals(testERLTemplateEditUnitsResult, instanceERLTemplateApi.eRLTemplateEditUnits(testERLTemplateEditUnitsArg1));
    }

    @Test
    public void testERLTemplateEditPrice() {
        assertEquals(testERLTemplateEditPriceResult, instanceERLTemplateApi.eRLTemplateEditPrice(testERLTemplateEditPriceArg1));
    }

    @Test
    public void testERLTemplateEditDescription() {
        assertEquals(testERLTemplateEditDescriptionResult, instanceERLTemplateApi.eRLTemplateEditDescription(testERLTemplateEditDescriptionArg1));
    }

    @Test
    public void testERLTemplateClearUnits() {
        assertEquals(testERLTemplateClearUnitsResult, instanceERLTemplateApi.eRLTemplateClearUnits(testERLTemplateClearUnitsArg1));
    }

    @Test
    public void testERLTemplateClearPrice() {
        assertEquals(testERLTemplateClearPriceResult, instanceERLTemplateApi.eRLTemplateClearPrice(testERLTemplateClearPriceArg1));
    }

    @Test
    public void testERLTemplateClearDescription() {
        assertEquals(testERLTemplateClearDescriptionResult, instanceERLTemplateApi.eRLTemplateClearDescription(testERLTemplateClearDescriptionArg1));
    }

    @Test
    public void testpiuPIUTemplateLines() {
        assertEquals(testpiuPIUTemplateLinesResult.getTotalItems(), instanceERLTemplateApi.piuPIUTemplateLines(testpiuPIUTemplateLinesArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUTemplateLines2() {
        assertEquals(testpiuPIUTemplateLines2Result.getTotalItems(), instanceERLTemplateApi.piuPIUTemplateLines(testpiuPIUTemplateLines2Arg1).getTotalItems());
    }
}
