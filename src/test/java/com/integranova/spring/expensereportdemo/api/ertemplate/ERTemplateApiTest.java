package com.integranova.spring.expensereportdemo.api.ertemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.ertemplate.ERTemplateApi;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.service.ERTemplateService;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest;
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
public class ERTemplateApiTest {

    @Mock
    private ERTemplateService mockERTemplateService;

    @InjectMocks
    private ERTemplateApi instanceERTemplateApi;

    // testGetDSERTemplates
    private static String testGetDSERTemplatesArg1;
    private static String testGetDSERTemplatesArg2;
    private static String testGetDSERTemplatesArg3;
    private static DSERTemplates testGetDSERTemplatesResult;

    // testGetDSERTemplates2
    private static String testGetDSERTemplates2Arg1;
    private static String testGetDSERTemplates2Arg2;
    private static String testGetDSERTemplates2Arg3;
    private static DSERTemplates testGetDSERTemplates2Result;

    // testGetDSERTemplates3
    private static String testGetDSERTemplates3Arg1;
    private static String testGetDSERTemplates3Arg2;
    private static String testGetDSERTemplates3Arg3;
    private static DSERTemplates testGetDSERTemplates3Result;

    // testGetDSERTemplates4
    private static String testGetDSERTemplates4Arg1;
    private static String testGetDSERTemplates4Arg2;
    private static String testGetDSERTemplates4Arg3;
    private static DSERTemplates testGetDSERTemplates4Result;

    // testGetERTemplate
    private static Long testGetERTemplateArg1;
    private static ERTemplate testGetERTemplateResult;

    // testGetERTemplateDynamic
    private static QueryRequest testGetERTemplateDynamicArg1;
    private static ERTemplateOid mockGetERTemplateDynamicArg1;
    private static String mockGetERTemplateDynamicArg2;
    private static InstanceResponseViewModel testGetERTemplateDynamicResult;

    // testGetERTemplateWithDisplaySetDynamic
    private static QueryRequest testGetERTemplateWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetERTemplateWithDisplaySetDynamicResult;

    // testGetERTemplatePopulationDynamic
    private static QueryRequest testGetERTemplatePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetERTemplatePopulationDynamicResult;

    // testERTemplateCreateinstance
    private static CreateinstanceRequest testERTemplateCreateinstanceArg1;
    private static ServiceResponse testERTemplateCreateinstanceResult;

    // testERTemplateDeleteinstance
    private static DeleteinstanceRequest testERTemplateDeleteinstanceArg1;
    private static ServiceResponse testERTemplateDeleteinstanceResult;

    // testERTemplateEditinstance
    private static EditinstanceRequest testERTemplateEditinstanceArg1;
    private static ServiceResponse testERTemplateEditinstanceResult;

    // testERTemplateEditName
    private static EditNameRequest testERTemplateEditNameArg1;
    private static ServiceResponse testERTemplateEditNameResult;

    // testERTemplateEditDescription
    private static EditDescriptionRequest testERTemplateEditDescriptionArg1;
    private static ServiceResponse testERTemplateEditDescriptionResult;

    // testERTemplateClearName
    private static ClearNameRequest testERTemplateClearNameArg1;
    private static ServiceResponse testERTemplateClearNameResult;

    // testERTemplateClearDescription
    private static ClearDescriptionRequest testERTemplateClearDescriptionArg1;
    private static ServiceResponse testERTemplateClearDescriptionResult;

    // testERTemplateEnable
    private static EnableRequest testERTemplateEnableArg1;
    private static ServiceResponse testERTemplateEnableResult;

    // testERTemplateDisable
    private static DisableRequest testERTemplateDisableArg1;
    private static ServiceResponse testERTemplateDisableResult;

    // testERTemplateAssignTemplateToProject
    private static AssignTemplateToProjectRequest testERTemplateAssignTemplateToProjectArg1;
    private static ServiceResponse testERTemplateAssignTemplateToProjectResult;

    // testERTemplateDeassignTemplate
    private static DeassignTemplateRequest testERTemplateDeassignTemplateArg1;
    private static ServiceResponse testERTemplateDeassignTemplateResult;

    // testpiuPIUERTemplates
    private static PIUERTemplatesRequest testpiuPIUERTemplatesArg1;
    private static QueryRequest testpiuPIUERTemplatesMockArg1;
    private static List<DSERTemplates> testpiuPIUERTemplatesMockResult;
    private static PIUERTemplatesResponse testpiuPIUERTemplatesResult;

    // testpiuPIUERTemplates2
    private static PIUERTemplatesRequest testpiuPIUERTemplates2Arg1;
    private static QueryRequest testpiuPIUERTemplates2MockArg1;
    private static List<DSERTemplates> testpiuPIUERTemplates2MockResult;
    private static PIUERTemplatesResponse testpiuPIUERTemplates2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSERTemplates();
        setUpMockData4testGetDSERTemplates2();
        setUpMockData4testGetDSERTemplates3();
        setUpMockData4testGetDSERTemplates4();
        setUpMockData4testGetERTemplate();
        setUpMockData4testGetERTemplateDynamic();
        setUpMockData4testGetERTemplateWithDisplaySetDynamic();
        setUpMockData4testGetERTemplatePopulationDynamic();
        setUpMockData4testERTemplateCreateinstance();
        setUpMockData4testERTemplateDeleteinstance();
        setUpMockData4testERTemplateEditinstance();
        setUpMockData4testERTemplateEditName();
        setUpMockData4testERTemplateEditDescription();
        setUpMockData4testERTemplateClearName();
        setUpMockData4testERTemplateClearDescription();
        setUpMockData4testERTemplateEnable();
        setUpMockData4testERTemplateDisable();
        setUpMockData4testERTemplateAssignTemplateToProject();
        setUpMockData4testERTemplateDeassignTemplate();
        setUpMockData4testpiuPIUERTemplates();
        setUpMockData4testpiuPIUERTemplates2();
    }

    private static void setUpMockData4testGetDSERTemplates() {
        testGetDSERTemplatesArg1 = "";
        testGetDSERTemplatesArg2 = "";
        testGetDSERTemplatesArg3 = "";
        testGetDSERTemplatesResult = new DSERTemplates();
    }

    private static void setUpMockData4testGetDSERTemplates2() {
        testGetDSERTemplates2Arg1 = "";
        testGetDSERTemplates2Arg2 = null;
        testGetDSERTemplates2Arg3 = null;
        testGetDSERTemplates2Result = testGetDSERTemplatesResult;
    }

    private static void setUpMockData4testGetDSERTemplates3() {
        testGetDSERTemplates3Arg1 = "";
        testGetDSERTemplates3Arg2 = null;
        testGetDSERTemplates3Arg3 = "";
        testGetDSERTemplates3Result = testGetDSERTemplatesResult;
    }

    private static void setUpMockData4testGetDSERTemplates4() {
        testGetDSERTemplates4Arg1 = "";
        testGetDSERTemplates4Arg2 = "";
        testGetDSERTemplates4Arg3 = null;
        testGetDSERTemplates4Result = testGetDSERTemplatesResult;
    }

    private static void setUpMockData4testGetERTemplate() {
        testGetERTemplateArg1 = Long.valueOf(0);
        testGetERTemplateResult = new ERTemplate();
    }

    private static void setUpMockData4testGetERTemplateDynamic() {
        mockGetERTemplateDynamicArg1 = new ERTemplateOid();
        mockGetERTemplateDynamicArg2 = "";
        testGetERTemplateDynamicArg1 = new QueryRequest();
        testGetERTemplateDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetERTemplateWithDisplaySetDynamic() {
        testGetERTemplateWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetERTemplateWithDisplaySetDynamicArg1.setDisplaySetName("testGetERTemplateWithDisplaySetDynamicArg1");
        testGetERTemplateWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetERTemplatePopulationDynamic() {
        testGetERTemplatePopulationDynamicArg1 = new QueryRequest();
        testGetERTemplatePopulationDynamicArg1.setDisplaySetName("testGetERTemplatePopulationDynamicArg1");
        testGetERTemplatePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testERTemplateCreateinstance() {
        testERTemplateCreateinstanceArg1 = new CreateinstanceRequest();
        testERTemplateCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateDeleteinstance() {
        testERTemplateDeleteinstanceArg1 = new DeleteinstanceRequest();
        testERTemplateDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateEditinstance() {
        testERTemplateEditinstanceArg1 = new EditinstanceRequest();
        testERTemplateEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateEditName() {
        testERTemplateEditNameArg1 = new EditNameRequest();
        testERTemplateEditNameResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateEditDescription() {
        testERTemplateEditDescriptionArg1 = new EditDescriptionRequest();
        testERTemplateEditDescriptionResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateClearName() {
        testERTemplateClearNameArg1 = new ClearNameRequest();
        testERTemplateClearNameResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateClearDescription() {
        testERTemplateClearDescriptionArg1 = new ClearDescriptionRequest();
        testERTemplateClearDescriptionResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateEnable() {
        testERTemplateEnableArg1 = new EnableRequest();
        testERTemplateEnableResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateDisable() {
        testERTemplateDisableArg1 = new DisableRequest();
        testERTemplateDisableResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateAssignTemplateToProject() {
        testERTemplateAssignTemplateToProjectArg1 = new AssignTemplateToProjectRequest();
        testERTemplateAssignTemplateToProjectResult = new ServiceResponse();
    }

    private static void setUpMockData4testERTemplateDeassignTemplate() {
        testERTemplateDeassignTemplateArg1 = new DeassignTemplateRequest();
        testERTemplateDeassignTemplateResult = new ServiceResponse();
    }

    private static void setUpMockData4testpiuPIUERTemplates() {
        testpiuPIUERTemplatesMockArg1 = new QueryRequest();
        testpiuPIUERTemplatesMockArg1.setPageSize(0);
        testpiuPIUERTemplatesMockResult = new ArrayList<>();
        testpiuPIUERTemplatesArg1 = mock(PIUERTemplatesRequest.class);
        testpiuPIUERTemplatesResult = new PIUERTemplatesResponse();
    }

    private static void setUpMockData4testpiuPIUERTemplates2() {
        testpiuPIUERTemplates2MockArg1 = new QueryRequest();
        testpiuPIUERTemplates2MockArg1.setPageSize(1);
        testpiuPIUERTemplates2MockResult = new ArrayList<>();
        testpiuPIUERTemplates2MockResult.add(new DSERTemplates());
        testpiuPIUERTemplates2Arg1 = mock(PIUERTemplatesRequest.class);
        testpiuPIUERTemplates2Arg1.setPageSize(1);
        testpiuPIUERTemplates2Result = new PIUERTemplatesResponse();
        testpiuPIUERTemplates2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockERTemplateService.getDSERTemplates(testGetDSERTemplatesArg1, testGetDSERTemplatesArg2, testGetDSERTemplatesArg3)).thenReturn(testGetDSERTemplatesResult);

        when(mockERTemplateService.getById(testGetERTemplateArg1)).thenReturn(testGetERTemplateResult);

        when(mockERTemplateService.getERTemplateDynamic(mockGetERTemplateDynamicArg1, mockGetERTemplateDynamicArg2)).thenReturn(testGetERTemplateDynamicResult);

        when(mockERTemplateService.getDynamic(testGetERTemplateWithDisplaySetDynamicArg1)).thenReturn(testGetERTemplateWithDisplaySetDynamicResult);

        when(mockERTemplateService.getDynamic(testGetERTemplatePopulationDynamicArg1)).thenReturn(testGetERTemplatePopulationDynamicResult);

        when(mockERTemplateService.createinstance(testERTemplateCreateinstanceArg1)).thenReturn(testERTemplateCreateinstanceResult);

        when(mockERTemplateService.deleteinstance(testERTemplateDeleteinstanceArg1)).thenReturn(testERTemplateDeleteinstanceResult);

        when(mockERTemplateService.editinstance(testERTemplateEditinstanceArg1)).thenReturn(testERTemplateEditinstanceResult);

        when(mockERTemplateService.editName(testERTemplateEditNameArg1)).thenReturn(testERTemplateEditNameResult);

        when(mockERTemplateService.editDescription(testERTemplateEditDescriptionArg1)).thenReturn(testERTemplateEditDescriptionResult);

        when(mockERTemplateService.clearName(testERTemplateClearNameArg1)).thenReturn(testERTemplateClearNameResult);

        when(mockERTemplateService.clearDescription(testERTemplateClearDescriptionArg1)).thenReturn(testERTemplateClearDescriptionResult);

        when(mockERTemplateService.enable(testERTemplateEnableArg1)).thenReturn(testERTemplateEnableResult);

        when(mockERTemplateService.disable(testERTemplateDisableArg1)).thenReturn(testERTemplateDisableResult);

        when(mockERTemplateService.assignTemplateToProject(testERTemplateAssignTemplateToProjectArg1)).thenReturn(testERTemplateAssignTemplateToProjectResult);

        when(mockERTemplateService.deassignTemplate(testERTemplateDeassignTemplateArg1)).thenReturn(testERTemplateDeassignTemplateResult);

        when(testpiuPIUERTemplatesArg1.buildQueryRequest()).thenReturn(testpiuPIUERTemplatesMockArg1);

        when(mockERTemplateService.piuPIUERTemplates(testpiuPIUERTemplatesMockArg1)).thenReturn(testpiuPIUERTemplatesMockResult);

        when(testpiuPIUERTemplates2Arg1.buildQueryRequest()).thenReturn(testpiuPIUERTemplates2MockArg1);

        when(mockERTemplateService.piuPIUERTemplates(testpiuPIUERTemplates2MockArg1)).thenReturn(testpiuPIUERTemplates2MockResult);

        when(mockERTemplateService.getCount4PIUERTemplates(testpiuPIUERTemplates2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSERTemplates() {
        assertEquals(testGetDSERTemplatesResult, instanceERTemplateApi.getDSERTemplates(testGetDSERTemplatesArg1, testGetDSERTemplatesArg2, testGetDSERTemplatesArg3));
    }

    @Test
    public void testGetDSERTemplates2() {
        assertEquals(testGetDSERTemplates2Result, instanceERTemplateApi.getDSERTemplates(testGetDSERTemplates2Arg1, testGetDSERTemplates2Arg2, testGetDSERTemplates2Arg3));
    }

    @Test
    public void testGetDSERTemplates3() {
        assertEquals(testGetDSERTemplates3Result, instanceERTemplateApi.getDSERTemplates(testGetDSERTemplates3Arg1, testGetDSERTemplates3Arg2, testGetDSERTemplates3Arg3));
    }

    @Test
    public void testGetDSERTemplates4() {
        assertEquals(testGetDSERTemplates4Result, instanceERTemplateApi.getDSERTemplates(testGetDSERTemplates4Arg1, testGetDSERTemplates4Arg2, testGetDSERTemplates4Arg3));
    }

    @Test
    public void testGetERTemplate() {
        assertEquals(testGetERTemplateResult, instanceERTemplateApi.getERTemplate(testGetERTemplateArg1));
    }

    @Test
    public void testGetERTemplateDynamic() {
        assertEquals(testGetERTemplateDynamicResult, instanceERTemplateApi.getERTemplateDynamic(testGetERTemplateDynamicArg1));
    }

    @Test
    public void testGetERTemplateWithDisplaySetDynamic() {
        assertEquals(testGetERTemplateWithDisplaySetDynamicResult, instanceERTemplateApi.getERTemplateWithDisplaySetDynamic(testGetERTemplateWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetERTemplatePopulationDynamic() {
        assertEquals(testGetERTemplatePopulationDynamicResult, instanceERTemplateApi.getERTemplatePopulationDynamic(testGetERTemplatePopulationDynamicArg1));
    }

    @Test
    public void testERTemplateCreateinstance() {
        assertEquals(testERTemplateCreateinstanceResult, instanceERTemplateApi.eRTemplateCreateinstance(testERTemplateCreateinstanceArg1));
    }

    @Test
    public void testERTemplateDeleteinstance() {
        assertEquals(testERTemplateDeleteinstanceResult, instanceERTemplateApi.eRTemplateDeleteinstance(testERTemplateDeleteinstanceArg1));
    }

    @Test
    public void testERTemplateEditinstance() {
        assertEquals(testERTemplateEditinstanceResult, instanceERTemplateApi.eRTemplateEditinstance(testERTemplateEditinstanceArg1));
    }

    @Test
    public void testERTemplateEditName() {
        assertEquals(testERTemplateEditNameResult, instanceERTemplateApi.eRTemplateEditName(testERTemplateEditNameArg1));
    }

    @Test
    public void testERTemplateEditDescription() {
        assertEquals(testERTemplateEditDescriptionResult, instanceERTemplateApi.eRTemplateEditDescription(testERTemplateEditDescriptionArg1));
    }

    @Test
    public void testERTemplateClearName() {
        assertEquals(testERTemplateClearNameResult, instanceERTemplateApi.eRTemplateClearName(testERTemplateClearNameArg1));
    }

    @Test
    public void testERTemplateClearDescription() {
        assertEquals(testERTemplateClearDescriptionResult, instanceERTemplateApi.eRTemplateClearDescription(testERTemplateClearDescriptionArg1));
    }

    @Test
    public void testERTemplateEnable() {
        assertEquals(testERTemplateEnableResult, instanceERTemplateApi.eRTemplateEnable(testERTemplateEnableArg1));
    }

    @Test
    public void testERTemplateDisable() {
        assertEquals(testERTemplateDisableResult, instanceERTemplateApi.eRTemplateDisable(testERTemplateDisableArg1));
    }

    @Test
    public void testERTemplateAssignTemplateToProject() {
        assertEquals(testERTemplateAssignTemplateToProjectResult, instanceERTemplateApi.eRTemplateAssignTemplateToProject(testERTemplateAssignTemplateToProjectArg1));
    }

    @Test
    public void testERTemplateDeassignTemplate() {
        assertEquals(testERTemplateDeassignTemplateResult, instanceERTemplateApi.eRTemplateDeassignTemplate(testERTemplateDeassignTemplateArg1));
    }

    @Test
    public void testpiuPIUERTemplates() {
        assertEquals(testpiuPIUERTemplatesResult.getTotalItems(), instanceERTemplateApi.piuPIUERTemplates(testpiuPIUERTemplatesArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUERTemplates2() {
        assertEquals(testpiuPIUERTemplates2Result.getTotalItems(), instanceERTemplateApi.piuPIUERTemplates(testpiuPIUERTemplates2Arg1).getTotalItems());
    }
}
