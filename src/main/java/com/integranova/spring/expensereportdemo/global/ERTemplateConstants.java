package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ERTemplate</code> model class.
 */
public final class ERTemplateConstants {

    private ERTemplateConstants() {

    }

    // Class
    /** <code>ERTemplate</code> class id. */
    public static final String CLASS_ID = "Clas_1622460465152786_Alias";
    /** <code>ERTemplate</code> class name. */
    public static final String CLASS_NAME = "ERTemplate";
    /** <code>ERTemplate</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Report Template";
    /** <code>ERTemplate</code> class table name. */
    public static final String TBL_NAME = "ERTemplate";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "eRTemplateid,eRTemplatename,eRTemplateenabled";

    public static final String DSDSERTEMPLATES = "DSERTemplates";
    

    // Attribute (eRTemplateid)
    /** <code>eRTemplateid</code> attribute id. */
    public static final String ATTR_ID_ERTEMPLATEID = "Clas_1622460465152786Atr_2_Alias";
    /** <code>eRTemplateid</code> attribute name. */
    public static final String ATTR_NAME_ERTEMPLATEID = "eRTemplateid";
    /** <code>eRTemplateid</code> attribute alias. */
    public static final String ATTR_ALIAS_ERTEMPLATEID = "ID";

    /** <code>eRTemplateid</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATEID = "";
    /** Agents allowed to view the attribute eRTemplateid **/
    public static final String ERTEMPLATEID_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRTemplatename)
    /** <code>eRTemplatename</code> attribute id. */
    public static final String ATTR_ID_ERTEMPLATENAME = "Clas_1622460465152786Atr_3_Alias";
    /** <code>eRTemplatename</code> attribute name. */
    public static final String ATTR_NAME_ERTEMPLATENAME = "eRTemplatename";
    /** <code>eRTemplatename</code> attribute alias. */
    public static final String ATTR_ALIAS_ERTEMPLATENAME = "Name";

    /** <code>eRTemplatename</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATENAME = "";
    /** Agents allowed to view the attribute eRTemplatename **/
    public static final String ERTEMPLATENAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRTemplatedescription)
    /** <code>eRTemplatedescription</code> attribute id. */
    public static final String ATTR_ID_ERTEMPLATEDESCRIPTION = "Clas_1622460465152786Atr_4_Alias";
    /** <code>eRTemplatedescription</code> attribute name. */
    public static final String ATTR_NAME_ERTEMPLATEDESCRIPTION = "eRTemplatedescription";
    /** <code>eRTemplatedescription</code> attribute alias. */
    public static final String ATTR_ALIAS_ERTEMPLATEDESCRIPTION = "Description";

    /** <code>eRTemplatedescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATEDESCRIPTION = "";
    /** Agents allowed to view the attribute eRTemplatedescription **/
    public static final String ERTEMPLATEDESCRIPTION_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRTemplatetotal)
    /** <code>eRTemplatetotal</code> attribute id. */
    public static final String ATTR_ID_ERTEMPLATETOTAL = "Clas_1622460465152786Atr_5_Alias";
    /** <code>eRTemplatetotal</code> attribute name. */
    public static final String ATTR_NAME_ERTEMPLATETOTAL = "eRTemplatetotal";
    /** <code>eRTemplatetotal</code> attribute alias. */
    public static final String ATTR_ALIAS_ERTEMPLATETOTAL = "Total";

    /** <code>eRTemplatetotal</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATETOTAL = "";
    /** Agents allowed to view the attribute eRTemplatetotal **/
    public static final String ERTEMPLATETOTAL_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRTemplateenabled)
    /** <code>eRTemplateenabled</code> attribute id. */
    public static final String ATTR_ID_ERTEMPLATEENABLED = "Clas_1622460465152786Atr_6_Alias";
    /** <code>eRTemplateenabled</code> attribute name. */
    public static final String ATTR_NAME_ERTEMPLATEENABLED = "eRTemplateenabled";
    /** <code>eRTemplateenabled</code> attribute alias. */
    public static final String ATTR_ALIAS_ERTEMPLATEENABLED = "Enabled?";

    /** <code>eRTemplateenabled</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATEENABLED = "";
    /** Agents allowed to view the attribute eRTemplateenabled **/
    public static final String ERTEMPLATEENABLED_AGENTS = "AdminUser,OperatorUser";


    // Field (id)
    /** <code>id</code> field name. */
    public static final String FLD_ERTEMPLATEID = "id";    
    /** <code>eRTemplateid</code> attribute field name. */
    public static final String ATTR_FIELD_ERTEMPLATEID = "eRTemplateid";
    // Field (name)
    /** <code>name</code> field name. */
    public static final String FLD_ERTEMPLATENAME = "name";    
    /** <code>name</code> field length. */
    public static final int FLD_ERTEMPLATENAMELENGTH = 100;
    /** <code>eRTemplatename</code> attribute field name. */
    public static final String ATTR_FIELD_ERTEMPLATENAME = "eRTemplatename";
    // Field (description)
    /** <code>description</code> field name. */
    public static final String FLD_ERTEMPLATEDESCRIPTION = "description";    
    /** <code>eRTemplatedescription</code> attribute field name. */
    public static final String ATTR_FIELD_ERTEMPLATEDESCRIPTION = "eRTemplatedescription";
    // Field (enabled)
    /** <code>enabled</code> field name. */
    public static final String FLD_ERTEMPLATEENABLED = "enabled";    
    /** <code>eRTemplateenabled</code> attribute field name. */
    public static final String ATTR_FIELD_ERTEMPLATEENABLED = "eRTemplateenabled";


    // Compound role (Projects)
    /** <code>Projects</code> role id. */
    public static final String ROLE_ID_PROJECTS = "Agr_1622464266240221_Alias";
    /** <code>Projects</code> role name. */
    public static final String ROLE_NAME_PROJECTS = "projects";
    /** <code>ERTemplates</code> role alias. */
    public static final String ROLE_ALIAS_PROJECTS = "Projects";


    /** <code>Projects</code> inverse role name. */
    public static final String ROLE_INVNAME_PROJECTS = ProjectConstants.ROLE_NAME_ERTEMPLATES;
    /** <code>Projects</code> role facet sequence. */
    public static final String PATH_FACETS_PROJECTS = "";
    /** <code>Projects</code> role target class. */
    public static final String ROLE_TARGET_PROJECTS = ProjectConstants.CLASS_NAME;
    /** Agents allowed to navigate through Projects **/
    public static final String PROJECTS_AGENTS = "AdminUser,OperatorUser";
    // Compound role (TemplateLines)
    /** <code>TemplateLines</code> role id. */
    public static final String ROLE_ID_TEMPLATELINES = "Agr_1622460596224865_Alias";
    /** <code>TemplateLines</code> role name. */
    public static final String ROLE_NAME_TEMPLATELINES = "templateLines";
    /** <code>Template</code> role alias. */
    public static final String ROLE_ALIAS_TEMPLATELINES = "TemplateLines";


    /** <code>TemplateLines</code> inverse role name. */
    public static final String ROLE_INVNAME_TEMPLATELINES = ERLTemplateConstants.ROLE_NAME_TEMPLATE;
    /** <code>TemplateLines</code> role facet sequence. */
    public static final String PATH_FACETS_TEMPLATELINES = "";
    /** <code>TemplateLines</code> role target class. */
    public static final String ROLE_TARGET_TEMPLATELINES = ERLTemplateConstants.CLASS_NAME;
    /** Agents allowed to navigate through TemplateLines **/
    public static final String TEMPLATELINES_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1622460465152786Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplatecreateinstancepatrname</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRNAME = "p_atrname";
    /** <code>eRTemplatecreateinstancepatrname</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRNAME = "Clas_1622460465152786Ser_1Arg_2_Alias";
    /** <code>eRTemplatecreateinstancepatrname</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRNAME = "Name";
    /** <code>eRTemplatecreateinstancepatrdescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRDESCRIPTION = "p_atrdescription";
    /** <code>eRTemplatecreateinstancepatrdescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRDESCRIPTION = "Clas_1622460465152786Ser_1Arg_3_Alias";
    /** <code>eRTemplatecreateinstancepatrdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRDESCRIPTION = "Description";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1622460465152786Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplatedeleteinstancepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_ERTEMPLATEDELETEINSTANCEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplatedeleteinstancepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_ERTEMPLATEDELETEINSTANCEPTHISERTEMPLATE = "Clas_1622460465152786Ser_2Arg_1_Alias";
    /** <code>eRTemplatedeleteinstancepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_ERTEMPLATEDELETEINSTANCEPTHISERTEMPLATE = "Expense Report Template";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1622460465152786Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateeditinstancepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateeditinstancepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPTHISERTEMPLATE = "Clas_1622460465152786Ser_3Arg_1_Alias";
    /** <code>eRTemplateeditinstancepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPTHISERTEMPLATE = "Expense Report Template";
    /** <code>eRTemplateeditinstancepname</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPNAME = "p_name";
    /** <code>eRTemplateeditinstancepname</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPNAME = "Clas_1622460465152786Ser_3Arg_2_Alias";
    /** <code>eRTemplateeditinstancepname</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPNAME = "Name";
    /** <code>eRTemplateeditinstancepdescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPDESCRIPTION = "p_description";
    /** <code>eRTemplateeditinstancepdescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPDESCRIPTION = "Clas_1622460465152786Ser_3Arg_3_Alias";
    /** <code>eRTemplateeditinstancepdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPDESCRIPTION = "Description";
    // Service (editName)
    /** <code>editName</code> service id. */
    public static final String SERV_ID_EDITNAME = "Clas_1622460465152786Ser_4_Alias";
    /** <code>editName</code> service name. */
    public static final String SERV_NAME_EDITNAME = "editName";
    /** <code>editName</code> service alias. */
    public static final String SERV_ALIAS_EDITNAME = "editName";
    /** Agents allowed to execute the service editName **/
    public static final String EDITNAME_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateeditNamepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITNAME_ERTEMPLATEEDITNAMEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateeditNamepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITNAME_ERTEMPLATEEDITNAMEPTHISERTEMPLATE = "Clas_1622460465152786Ser_4Arg_1_Alias";
    /** <code>eRTemplateeditNamepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITNAME_ERTEMPLATEEDITNAMEPTHISERTEMPLATE = "Expense Report Template";
    /** <code>eRTemplateeditNamepName</code> inbound argument name. */
    public static final String ARG_NAME_EDITNAME_ERTEMPLATEEDITNAMEPNAME = "pName";
    /** <code>eRTemplateeditNamepName</code> inbound argument id. */
    public static final String ARG_ID_EDITNAME_ERTEMPLATEEDITNAMEPNAME = "Clas_1622460465152786Ser_4Arg_2_Alias";
    /** <code>eRTemplateeditNamepName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITNAME_ERTEMPLATEEDITNAMEPNAME = "Name";
    // Service (editDescription)
    /** <code>editDescription</code> service id. */
    public static final String SERV_ID_EDITDESCRIPTION = "Clas_1622460465152786Ser_5_Alias";
    /** <code>editDescription</code> service name. */
    public static final String SERV_NAME_EDITDESCRIPTION = "editDescription";
    /** <code>editDescription</code> service alias. */
    public static final String SERV_ALIAS_EDITDESCRIPTION = "editDescription";
    /** Agents allowed to execute the service editDescription **/
    public static final String EDITDESCRIPTION_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateeditDescriptionpthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateeditDescriptionpthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPTHISERTEMPLATE = "Clas_1622460465152786Ser_5Arg_1_Alias";
    /** <code>eRTemplateeditDescriptionpthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPTHISERTEMPLATE = "Expense Report Template";
    /** <code>eRTemplateeditDescriptionpDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "pDescription";
    /** <code>eRTemplateeditDescriptionpDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "Clas_1622460465152786Ser_5Arg_2_Alias";
    /** <code>eRTemplateeditDescriptionpDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "Description";
    // Service (clearName)
    /** <code>clearName</code> service id. */
    public static final String SERV_ID_CLEARNAME = "Clas_1622460465152786Ser_6_Alias";
    /** <code>clearName</code> service name. */
    public static final String SERV_NAME_CLEARNAME = "clearName";
    /** <code>clearName</code> service alias. */
    public static final String SERV_ALIAS_CLEARNAME = "clearName";
    /** Agents allowed to execute the service clearName **/
    public static final String CLEARNAME_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateclearNamepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CLEARNAME_ERTEMPLATECLEARNAMEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateclearNamepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_CLEARNAME_ERTEMPLATECLEARNAMEPTHISERTEMPLATE = "Clas_1622460465152786Ser_6Arg_1_Alias";
    /** <code>eRTemplateclearNamepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CLEARNAME_ERTEMPLATECLEARNAMEPTHISERTEMPLATE = "Expense Report Template";
    // Service (clearDescription)
    /** <code>clearDescription</code> service id. */
    public static final String SERV_ID_CLEARDESCRIPTION = "Clas_1622460465152786Ser_7_Alias";
    /** <code>clearDescription</code> service name. */
    public static final String SERV_NAME_CLEARDESCRIPTION = "clearDescription";
    /** <code>clearDescription</code> service alias. */
    public static final String SERV_ALIAS_CLEARDESCRIPTION = "clearDescription";
    /** Agents allowed to execute the service clearDescription **/
    public static final String CLEARDESCRIPTION_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateclearDescriptionpthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CLEARDESCRIPTION_ERTEMPLATECLEARDESCRIPTIONPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateclearDescriptionpthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_CLEARDESCRIPTION_ERTEMPLATECLEARDESCRIPTIONPTHISERTEMPLATE = "Clas_1622460465152786Ser_7Arg_1_Alias";
    /** <code>eRTemplateclearDescriptionpthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CLEARDESCRIPTION_ERTEMPLATECLEARDESCRIPTIONPTHISERTEMPLATE = "Expense Report Template";
    // Service (enable)
    /** <code>enable</code> service id. */
    public static final String SERV_ID_ENABLE = "Clas_1622460465152786Ser_8_Alias";
    /** <code>enable</code> service name. */
    public static final String SERV_NAME_ENABLE = "enable";
    /** <code>enable</code> service alias. */
    public static final String SERV_ALIAS_ENABLE = "Activate";
    /** Agents allowed to execute the service enable **/
    public static final String ENABLE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateenablepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_ENABLE_ERTEMPLATEENABLEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateenablepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_ENABLE_ERTEMPLATEENABLEPTHISERTEMPLATE = "Clas_1622460465152786Ser_8Arg_1_Alias";
    /** <code>eRTemplateenablepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_ENABLE_ERTEMPLATEENABLEPTHISERTEMPLATE = "Expense Report Template";
    // Service (disable)
    /** <code>disable</code> service id. */
    public static final String SERV_ID_DISABLE = "Clas_1622460465152786Ser_9_Alias";
    /** <code>disable</code> service name. */
    public static final String SERV_NAME_DISABLE = "disable";
    /** <code>disable</code> service alias. */
    public static final String SERV_ALIAS_DISABLE = "Activate";
    /** Agents allowed to execute the service disable **/
    public static final String DISABLE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplatedisablepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_DISABLE_ERTEMPLATEDISABLEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplatedisablepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_DISABLE_ERTEMPLATEDISABLEPTHISERTEMPLATE = "Clas_1622460465152786Ser_9Arg_1_Alias";
    /** <code>eRTemplatedisablepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_DISABLE_ERTEMPLATEDISABLEPTHISERTEMPLATE = "Expense Report Template";
    // Service (assignTemplateToProject)
    /** <code>assignTemplateToProject</code> service id. */
    public static final String SERV_ID_ASSIGNTEMPLATETOPROJECT = "Clas_1622460465152786Ser_10_Alias";
    /** <code>assignTemplateToProject</code> service name. */
    public static final String SERV_NAME_ASSIGNTEMPLATETOPROJECT = "assignTemplateToProject";
    /** <code>assignTemplateToProject</code> service alias. */
    public static final String SERV_ALIAS_ASSIGNTEMPLATETOPROJECT = "assignTemplateToProject";
    /** Agents allowed to execute the service assignTemplateToProject **/
    public static final String ASSIGNTEMPLATETOPROJECT_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplateassignTemplateToProjectpthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplateassignTemplateToProjectpthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPTHISERTEMPLATE = "Clas_1622460465152786Ser_10Arg_1_Alias";
    /** <code>eRTemplateassignTemplateToProjectpthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPTHISERTEMPLATE = "ERTemplates";
    /** <code>eRTemplateassignTemplateToProjectpevcProject</code> inbound argument name. */
    public static final String ARG_NAME_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPEVCPROJECT = "p_evcProject";
    /** <code>eRTemplateassignTemplateToProjectpevcProject</code> inbound argument id. */
    public static final String ARG_ID_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPEVCPROJECT = "Clas_1622460465152786Ser_10Arg_2_Alias";
    /** <code>eRTemplateassignTemplateToProjectpevcProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPEVCPROJECT = "Projects";
    // Service (deassignTemplate)
    /** <code>deassignTemplate</code> service id. */
    public static final String SERV_ID_DEASSIGNTEMPLATE = "Clas_1622460465152786Ser_11_Alias";
    /** <code>deassignTemplate</code> service name. */
    public static final String SERV_NAME_DEASSIGNTEMPLATE = "deassignTemplate";
    /** <code>deassignTemplate</code> service alias. */
    public static final String SERV_ALIAS_DEASSIGNTEMPLATE = "deassignTemplate";
    /** Agents allowed to execute the service deassignTemplate **/
    public static final String DEASSIGNTEMPLATE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRTemplatedeassignTemplatepthisERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPTHISERTEMPLATE = "p_thisERTemplate";
    /** <code>eRTemplatedeassignTemplatepthisERTemplate</code> inbound argument id. */
    public static final String ARG_ID_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPTHISERTEMPLATE = "Clas_1622460465152786Ser_11Arg_1_Alias";
    /** <code>eRTemplatedeassignTemplatepthisERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPTHISERTEMPLATE = "ERTemplates";
    /** <code>eRTemplatedeassignTemplatepevcProject</code> inbound argument name. */
    public static final String ARG_NAME_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPEVCPROJECT = "p_evcProject";
    /** <code>eRTemplatedeassignTemplatepevcProject</code> inbound argument id. */
    public static final String ARG_ID_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPEVCPROJECT = "Clas_1622460465152786Ser_11Arg_2_Alias";
    /** <code>eRTemplatedeassignTemplatepevcProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPEVCPROJECT = "Projects";

    public static final String FILTER_NAME_FERTEMPLATES = "FERTemplates";
    public static final String VAR_NAME_FERTEMPLATES_VNAME = "vName";
    public static final String VAR_NAME_FERTEMPLATES_VDESCRIPTION = "vDescription";
    public static final String VAR_NAME_FERTEMPLATES_VENABLED = "vEnabled";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_ERTEMPLATENAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_ERTEMPLATEDESCRIPTION.toUpperCase(), Constants.Type.TEXT.getTypeName());
        attributeTypes.put(ATTR_NAME_ERTEMPLATETOTAL.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_ERTEMPLATEENABLED.toUpperCase(), Constants.Type.BOOL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_ERTEMPLATEID.toUpperCase(), ERTEMPLATEID_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERTEMPLATENAME.toUpperCase(), ERTEMPLATENAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERTEMPLATEDESCRIPTION.toUpperCase(), ERTEMPLATEDESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERTEMPLATETOTAL.toUpperCase(), ERTEMPLATETOTAL_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERTEMPLATEENABLED.toUpperCase(), ERTEMPLATEENABLED_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ERTemplate', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ERTemplate', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_ERTEMPLATEID);
        }
        // Facet 'ERTemplate' (This facet)
        if (ERTemplateConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_ERTEMPLATEID);
        }
        return returnList;
    }
}
