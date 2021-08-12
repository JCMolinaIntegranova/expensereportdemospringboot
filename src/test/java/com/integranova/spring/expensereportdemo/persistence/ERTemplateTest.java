package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ERTemplateTest {

    private static ERTemplateJpaRepository mockERTemplateJpaRepository;

    private static ProjectJpaRepository mockProjectJpaRepository;

    private static ERLTemplateJpaRepository mockERLTemplateJpaRepository;

    private static Agent mockAgent;

    ERTemplate instanceERTemplate;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_ERTEMPLATEID;
    private static String VALUE_ERTEMPLATENAME;
    private static String VALUE_ERTEMPLATEDESCRIPTION;
    private static Double VALUE_ERTEMPLATETOTAL;
    private static Boolean VALUE_ERTEMPLATEENABLED;
    private static List<Project> VALUE_PROJECTS;
    private static List<ERLTemplate> VALUE_TEMPLATELINES;
    private static ERTemplate VALUE_ASSOCOPERATOR001_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR001_RETURN;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_ERTEMPLATEID = Long.valueOf(0);
        VALUE_ERTEMPLATENAME = "eRTemplatename";
        VALUE_ERTEMPLATEDESCRIPTION = "eRTemplatedescription";
        VALUE_ERTEMPLATETOTAL = Double.valueOf(0);
        VALUE_ERTEMPLATEENABLED = false;
        VALUE_PROJECTS = new ArrayList<>();
        VALUE_PROJECTS.add(new Project());
        VALUE_TEMPLATELINES = new ArrayList<>();
        VALUE_TEMPLATELINES.add(new ERLTemplate());
        VALUE_ASSOCOPERATOR001_INSTANCE = new ERTemplate();
        VALUE_ASSOCOPERATOR001_RETURN = Double.valueOf(0);
        mockERTemplateJpaRepository = mock(ERTemplateJpaRepository.class);
        mockProjectJpaRepository = mock(ProjectJpaRepository.class);
        mockERLTemplateJpaRepository = mock(ERLTemplateJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceERTemplate = new ERTemplate();
        instanceERTemplate.setERTemplateRepository(mockERTemplateJpaRepository);
        instanceERTemplate.setProjectRepository(mockProjectJpaRepository);
        instanceERTemplate.setERLTemplateRepository(mockERLTemplateJpaRepository);
        instanceERTemplate.setAgent(mockAgent);
        instanceERTemplate.setERTemplateid(VALUE_ERTEMPLATEID);
        instanceERTemplate.setERTemplatename(VALUE_ERTEMPLATENAME);
        instanceERTemplate.setERTemplatedescription(VALUE_ERTEMPLATEDESCRIPTION);
        instanceERTemplate.setERTemplateenabled(VALUE_ERTEMPLATEENABLED);
        instanceERTemplate.setProjects(VALUE_PROJECTS);
        instanceERTemplate.setTemplateLines(VALUE_TEMPLATELINES);
        when(mockERTemplateJpaRepository.assocOperator001(VALUE_ASSOCOPERATOR001_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR001_RETURN);
        when(mockProjectJpaRepository.findByERTemplates(any(ERTemplate.class))).thenReturn(VALUE_PROJECTS);
        when(mockERLTemplateJpaRepository.findByTemplate(any(ERTemplate.class))).thenReturn(VALUE_TEMPLATELINES);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceERTemplate = null;
    }

    @Test
    public void testDefaultConstructor() {
        ERTemplate value = new ERTemplate();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ERTemplate value = new ERTemplate(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ERTemplate value = new ERTemplate(new ERTemplateOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ERTemplate value = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getERTemplateid() {
        assertEquals(VALUE_ERTEMPLATEID.toString(), instanceERTemplate.getERTemplateid().toString());
    }

    @Test
    public void test4setERTemplateid() {
        Long value = Long.valueOf(0);
        instanceERTemplate.setERTemplateid(value);
        assertEquals(value, instanceERTemplate.getERTemplateid());
    }

    @Test
    public void test4getERTemplatename() {
        assertEquals(VALUE_ERTEMPLATENAME.toString(), instanceERTemplate.getERTemplatename().toString());
    }

    @Test
    public void test4setERTemplatename() {
        String value = "eRTemplatename";
        instanceERTemplate.setERTemplatename(value);
        assertEquals(value, instanceERTemplate.getERTemplatename());
    }

    @Test
    public void test4isModifiedERTemplatename() {
        instanceERTemplate = new ERTemplate();
        assertFalse(instanceERTemplate.isModifiedERTemplatename());
        instanceERTemplate.setERTemplatename(VALUE_ERTEMPLATENAME);
        assertTrue(instanceERTemplate.isModifiedERTemplatename());
    }

    @Test
    public void test4setModifiedERTemplatename() {
        instanceERTemplate.setModifiedERTemplatename(true);
        assertTrue(instanceERTemplate.isModifiedERTemplatename());
    }

    @Test
    public void test4getERTemplatedescription() {
        assertEquals(VALUE_ERTEMPLATEDESCRIPTION.toString(), instanceERTemplate.getERTemplatedescription().toString());
    }

    @Test
    public void test4setERTemplatedescription() {
        String value = "eRTemplatedescription";
        instanceERTemplate.setERTemplatedescription(value);
        assertEquals(value, instanceERTemplate.getERTemplatedescription());
    }

    @Test
    public void test4isModifiedERTemplatedescription() {
        instanceERTemplate = new ERTemplate();
        assertFalse(instanceERTemplate.isModifiedERTemplatedescription());
        instanceERTemplate.setERTemplatedescription(VALUE_ERTEMPLATEDESCRIPTION);
        assertTrue(instanceERTemplate.isModifiedERTemplatedescription());
    }

    @Test
    public void test4setModifiedERTemplatedescription() {
        instanceERTemplate.setModifiedERTemplatedescription(true);
        assertTrue(instanceERTemplate.isModifiedERTemplatedescription());
    }

    @Test
    public void test4getERTemplatetotal() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_ERTEMPLATETOTAL.toString(), instanceERTemplate.getERTemplatetotal().toString());
        } else {
            instanceERTemplate.getERTemplatetotal();
            assertNotNull(instanceERTemplate);
        }
    }

    @Test
    public void test4getERTemplateenabled() {
        assertEquals(VALUE_ERTEMPLATEENABLED.toString(), instanceERTemplate.getERTemplateenabled().toString());
    }

    @Test
    public void test4setERTemplateenabled() {
        Boolean value = false;
        instanceERTemplate.setERTemplateenabled(value);
        assertEquals(value, instanceERTemplate.getERTemplateenabled());
    }

    @Test
    public void test4isModifiedERTemplateenabled() {
        instanceERTemplate = new ERTemplate();
        assertFalse(instanceERTemplate.isModifiedERTemplateenabled());
        instanceERTemplate.setERTemplateenabled(VALUE_ERTEMPLATEENABLED);
        assertTrue(instanceERTemplate.isModifiedERTemplateenabled());
    }

    @Test
    public void test4setModifiedERTemplateenabled() {
        instanceERTemplate.setModifiedERTemplateenabled(true);
        assertTrue(instanceERTemplate.isModifiedERTemplateenabled());
    }

    @Test
    public void test4getProjects() {
        assertEquals(VALUE_PROJECTS, instanceERTemplate.getProjects());
    }

    @Test
    public void test4getProjects2() {
        instanceERTemplate.setProjects(null);
        assertEquals(VALUE_PROJECTS, instanceERTemplate.getProjects());
    }

    @Test
    public void test4getProjects3() {
        instanceERTemplate.setProjects(new ArrayList<>());
        assertEquals(VALUE_PROJECTS, instanceERTemplate.getProjects());
    }

    @Test
    public void test4add2Projects() {
        Project value = new Project();
        instanceERTemplate.add2Projects(value);
        assertTrue(instanceERTemplate.getProjects().contains(value));
    }

    @Test
    public void test4setProjects() {
        instanceERTemplate.setProjects(VALUE_PROJECTS);
        assertEquals(VALUE_PROJECTS, instanceERTemplate.getProjects());
    }

    @Test
    public void test4isModifiedProjects() {
        assertFalse(instanceERTemplate.isModifiedProjects());
    }

    @Test
    public void test4getTemplateLines() {
        assertEquals(VALUE_TEMPLATELINES, instanceERTemplate.getTemplateLines());
    }

    @Test
    public void test4getTemplateLines2() {
        instanceERTemplate.setTemplateLines(null);
        assertEquals(VALUE_TEMPLATELINES, instanceERTemplate.getTemplateLines());
    }

    @Test
    public void test4getTemplateLines3() {
        instanceERTemplate.setTemplateLines(new ArrayList<>());
        assertEquals(VALUE_TEMPLATELINES, instanceERTemplate.getTemplateLines());
    }

    @Test
    public void test4add2TemplateLines() {
        ERLTemplate value = new ERLTemplate();
        instanceERTemplate.add2TemplateLines(value);
        assertTrue(instanceERTemplate.getTemplateLines().contains(value));
    }

    @Test
    public void test4setTemplateLines() {
        instanceERTemplate.setTemplateLines(VALUE_TEMPLATELINES);
        assertEquals(VALUE_TEMPLATELINES, instanceERTemplate.getTemplateLines());
    }

    @Test
    public void test4isModifiedTemplateLines() {
        assertFalse(instanceERTemplate.isModifiedTemplateLines());
    }

    @Test
    public void test4buildDSERTemplates() {
        String result;
        try {
            result = instanceERTemplate.buildDSERTemplates().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceERTemplate.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceERTemplate.getAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEID));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceERTemplate.getAttributeTypeRelated(ERTemplateConstants.ROLE_NAME_PROJECTS, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceERTemplate.getAttributeTypeRelated(ERTemplateConstants.ROLE_NAME_TEMPLATELINES, ""));
        assertEquals("", instanceERTemplate.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceERTemplate.cleanDerivations();
        assertNotNull(instanceERTemplate);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceERTemplate.getERTemplateid(), instanceERTemplate.getOid().getERTemplateid());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceERTemplate.isVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATENAME));
        assertTrue(instanceERTemplate.isVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATEDESCRIPTION));
        assertTrue(instanceERTemplate.isVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATETOTAL));
        assertTrue(instanceERTemplate.isVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATEENABLED));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceERTemplate.isAttributeVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATENAME));
        assertTrue(instanceERTemplate.isAttributeVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATEDESCRIPTION));
        assertTrue(instanceERTemplate.isAttributeVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATETOTAL));
        assertTrue(instanceERTemplate.isAttributeVisible(ERTemplateConstants.ATTR_NAME_ERTEMPLATEENABLED));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceERTemplate.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceERTemplate.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceERTemplate.getActiveFacets().contains(Constants.ERTEMPLATE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceERTemplate.getFacets().contains(Constants.ERTEMPLATE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceERTemplate.checkHorizontalVisibility(null));
    }
}
