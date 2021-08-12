package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>Project</code> model class.
 */
public final class ProjectConstants {

    private ProjectConstants() {

    }

    // Class
    /** <code>Project</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600719_Alias";
    /** <code>Project</code> class name. */
    public static final String CLASS_NAME = "Project";
    /** <code>Project</code> class alias. */
    public static final String CLASS_ALIAS = "Project";
    /** <code>Project</code> class table name. */
    public static final String TBL_NAME = "Project";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "projectidProject,teamid,projectProjectName,projectProDescription,projectCompletionDate";

    public static final String DSDSPROJECT = "DS_Project";
    public static final String DSDSPROJECTSUP = "DS_ProjectSup";
    

    // Attribute (projectidProject)
    /** <code>projectidProject</code> attribute id. */
    public static final String ATTR_ID_PROJECTIDPROJECT = "Clas_1057569177600719Atr_1_Alias";
    /** <code>projectidProject</code> attribute name. */
    public static final String ATTR_NAME_PROJECTIDPROJECT = "projectidProject";
    /** <code>projectidProject</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTIDPROJECT = "Project Code";

    /** <code>projectidProject</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTIDPROJECT = "";
    /** Agents allowed to view the attribute projectidProject **/
    public static final String PROJECTIDPROJECT_AGENTS = "AdminUser,OperatorUser";
    // Attribute (projectProjectName)
    /** <code>projectProjectName</code> attribute id. */
    public static final String ATTR_ID_PROJECTPROJECTNAME = "Clas_1057569177600719Atr_2_Alias";
    /** <code>projectProjectName</code> attribute name. */
    public static final String ATTR_NAME_PROJECTPROJECTNAME = "projectProjectName";
    /** <code>projectProjectName</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTPROJECTNAME = "Name";

    /** <code>projectProjectName</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTPROJECTNAME = "";
    /** Agents allowed to view the attribute projectProjectName **/
    public static final String PROJECTPROJECTNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (projectProDescription)
    /** <code>projectProDescription</code> attribute id. */
    public static final String ATTR_ID_PROJECTPRODESCRIPTION = "Clas_1057569177600719Atr_3_Alias";
    /** <code>projectProDescription</code> attribute name. */
    public static final String ATTR_NAME_PROJECTPRODESCRIPTION = "projectProDescription";
    /** <code>projectProDescription</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTPRODESCRIPTION = "Description";

    /** <code>projectProDescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTPRODESCRIPTION = "";
    /** Agents allowed to view the attribute projectProDescription **/
    public static final String PROJECTPRODESCRIPTION_AGENTS = "AdminUser,OperatorUser";
    // Attribute (projectTotExpenses)
    /** <code>projectTotExpenses</code> attribute id. */
    public static final String ATTR_ID_PROJECTTOTEXPENSES = "Clas_1057569177600719Atr_4_Alias";
    /** <code>projectTotExpenses</code> attribute name. */
    public static final String ATTR_NAME_PROJECTTOTEXPENSES = "projectTotExpenses";
    /** <code>projectTotExpenses</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTTOTEXPENSES = "Total Expenses";

    /** <code>projectTotExpenses</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTTOTEXPENSES = "";
    /** Agents allowed to view the attribute projectTotExpenses **/
    public static final String PROJECTTOTEXPENSES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (projectCompletionDate)
    /** <code>projectCompletionDate</code> attribute id. */
    public static final String ATTR_ID_PROJECTCOMPLETIONDATE = "Clas_1057569177600719Atr_5_Alias";
    /** <code>projectCompletionDate</code> attribute name. */
    public static final String ATTR_NAME_PROJECTCOMPLETIONDATE = "projectCompletionDate";
    /** <code>projectCompletionDate</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTCOMPLETIONDATE = "Completion Date";

    /** <code>projectCompletionDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTCOMPLETIONDATE = "";
    /** Agents allowed to view the attribute projectCompletionDate **/
    public static final String PROJECTCOMPLETIONDATE_AGENTS = "AdminUser";
    // Attribute (projectMaxExpense)
    /** <code>projectMaxExpense</code> attribute id. */
    public static final String ATTR_ID_PROJECTMAXEXPENSE = "Clas_1057569177600719Atr_6_Alias";
    /** <code>projectMaxExpense</code> attribute name. */
    public static final String ATTR_NAME_PROJECTMAXEXPENSE = "projectMaxExpense";
    /** <code>projectMaxExpense</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTMAXEXPENSE = "Max Expense";

    /** <code>projectMaxExpense</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTMAXEXPENSE = "";
    /** Agents allowed to view the attribute projectMaxExpense **/
    public static final String PROJECTMAXEXPENSE_AGENTS = "AdminUser";
    // Attribute (projectMinExpense)
    /** <code>projectMinExpense</code> attribute id. */
    public static final String ATTR_ID_PROJECTMINEXPENSE = "Clas_1057569177600719Atr_7_Alias";
    /** <code>projectMinExpense</code> attribute name. */
    public static final String ATTR_NAME_PROJECTMINEXPENSE = "projectMinExpense";
    /** <code>projectMinExpense</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTMINEXPENSE = "Min Expense";

    /** <code>projectMinExpense</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTMINEXPENSE = "";
    /** Agents allowed to view the attribute projectMinExpense **/
    public static final String PROJECTMINEXPENSE_AGENTS = "AdminUser";
    // Attribute (projectAvgExpense)
    /** <code>projectAvgExpense</code> attribute id. */
    public static final String ATTR_ID_PROJECTAVGEXPENSE = "Clas_1057569177600719Atr_8_Alias";
    /** <code>projectAvgExpense</code> attribute name. */
    public static final String ATTR_NAME_PROJECTAVGEXPENSE = "projectAvgExpense";
    /** <code>projectAvgExpense</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTAVGEXPENSE = "Avg Expense";

    /** <code>projectAvgExpense</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTAVGEXPENSE = "";
    /** Agents allowed to view the attribute projectAvgExpense **/
    public static final String PROJECTAVGEXPENSE_AGENTS = "AdminUser";
    // Attribute (projectCompleted)
    /** <code>projectCompleted</code> attribute id. */
    public static final String ATTR_ID_PROJECTCOMPLETED = "Clas_1057569177600719Atr_9_Alias";
    /** <code>projectCompleted</code> attribute name. */
    public static final String ATTR_NAME_PROJECTCOMPLETED = "projectCompleted";
    /** <code>projectCompleted</code> attribute alias. */
    public static final String ATTR_ALIAS_PROJECTCOMPLETED = "Completed?";

    /** <code>projectCompleted</code> attribute facet sequence. */
    public static final String PATH_FACETS_PROJECTCOMPLETED = "";
    /** Agents allowed to view the attribute projectCompleted **/
    public static final String PROJECTCOMPLETED_AGENTS = "AdminUser,OperatorUser";


    // Field (id_Project)
    /** <code>id_Project</code> field name. */
    public static final String FLD_PROJECTIDPROJECT = "id_Project";    
    /** <code>projectidProject</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECTIDPROJECT = "projectidProject";
    // Field (id)
    /** <code>id</code> field name. */
    public static final String FLD_TEAMID = "id";    
    /** <code>Team.teamid</code> attribute field name. */
    public static final String ATTR_FIELD_TEAM_TEAMID = "teamid";
    // Field (ProjectName)
    /** <code>ProjectName</code> field name. */
    public static final String FLD_PROJECTPROJECTNAME = "ProjectName";    
    /** <code>ProjectName</code> field length. */
    public static final int FLD_PROJECTPROJECTNAMELENGTH = 50;
    /** <code>projectProjectName</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECTPROJECTNAME = "projectProjectName";
    // Field (ProDescription)
    /** <code>ProDescription</code> field name. */
    public static final String FLD_PROJECTPRODESCRIPTION = "ProDescription";    
    /** <code>ProDescription</code> field length. */
    public static final int FLD_PROJECTPRODESCRIPTIONLENGTH = 255;
    /** <code>projectProDescription</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECTPRODESCRIPTION = "projectProDescription";
    // Field (CompletionDate)
    /** <code>CompletionDate</code> field name. */
    public static final String FLD_PROJECTCOMPLETIONDATE = "CompletionDate";    
    /** <code>projectCompletionDate</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECTCOMPLETIONDATE = "projectCompletionDate";

    // Component role (Team)
    /** <code>Team</code> role id. */
    public static final String ROLE_ID_TEAM = "Agr_1622454829056100_Alias";
    /** <code>Team</code> role name. */
    public static final String ROLE_NAME_TEAM = "team";
    /** <code>Team</code> role alias. */
    public static final String ROLE_ALIAS_TEAM = "Team";

    /** <code>Team</code> inverse role name. */
    public static final String ROLE_INVNAME_TEAM = TeamConstants.ROLE_NAME_PROJECTS;
    /** <code>Team</code> role facet sequence. */
    public static final String PATH_FACETS_TEAM = "";
    /** <code>Team</code> role target class. */
    public static final String ROLE_TARGET_TEAM = TeamConstants.CLASS_NAME;

    /** Agents allowed to navigate through Team **/
    public static final String TEAM_AGENTS = "AdminUser,OperatorUser";
    // Component role (ERTemplates)
    /** <code>ERTemplates</code> role id. */
    public static final String ROLE_ID_ERTEMPLATES = "Agr_1622464266240221_Alias";
    /** <code>ERTemplates</code> role name. */
    public static final String ROLE_NAME_ERTEMPLATES = "eRTemplates";
    /** <code>ERTemplates</code> role alias. */
    public static final String ROLE_ALIAS_ERTEMPLATES = "ERTemplates";

    /** <code>ERTemplates</code> inverse role name. */
    public static final String ROLE_INVNAME_ERTEMPLATES = ERTemplateConstants.ROLE_NAME_PROJECTS;
    /** <code>ERTemplates</code> role facet sequence. */
    public static final String PATH_FACETS_ERTEMPLATES = "";
    /** <code>ERTemplates</code> role target class. */
    public static final String ROLE_TARGET_ERTEMPLATES = ERTemplateConstants.CLASS_NAME;

    /** Agents allowed to navigate through ERTemplates **/
    public static final String ERTEMPLATES_AGENTS = "AdminUser,OperatorUser";

    // Compound role (ExpenseReport)
    /** <code>ExpenseReport</code> role id. */
    public static final String ROLE_ID_EXPENSEREPORT = "Agr_1057569177600487_Alias";
    /** <code>ExpenseReport</code> role name. */
    public static final String ROLE_NAME_EXPENSEREPORT = "expenseReport";
    /** <code>Project</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSEREPORT = "Expense Report";


    /** <code>ExpenseReport</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSEREPORT = ExpenseReportConstants.ROLE_NAME_PROJECT;
    /** <code>ExpenseReport</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORT = "";
    /** <code>ExpenseReport</code> role target class. */
    public static final String ROLE_TARGET_EXPENSEREPORT = ExpenseReportConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseReport **/
    public static final String EXPENSEREPORT_AGENTS = "AdminUser,OperatorUser";
    // Compound role (Assignments)
    /** <code>Assignments</code> role id. */
    public static final String ROLE_ID_ASSIGNMENTS = "Agr_1468338405376416_Alias";
    /** <code>Assignments</code> role name. */
    public static final String ROLE_NAME_ASSIGNMENTS = "assignments";
    /** <code>Project</code> role alias. */
    public static final String ROLE_ALIAS_ASSIGNMENTS = "Assignments";


    /** <code>Assignments</code> inverse role name. */
    public static final String ROLE_INVNAME_ASSIGNMENTS = AssignmentConstants.ROLE_NAME_PROJECT;
    /** <code>Assignments</code> role facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTS = "";
    /** <code>Assignments</code> role target class. */
    public static final String ROLE_TARGET_ASSIGNMENTS = AssignmentConstants.CLASS_NAME;
    /** Agents allowed to navigate through Assignments **/
    public static final String ASSIGNMENTS_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1057569177600719Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>projectcreateinstancepagrTeam</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_PROJECTCREATEINSTANCEPAGRTEAM = "p_agrTeam";
    /** <code>projectcreateinstancepagrTeam</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPAGRTEAM = "Clas_1057569177600719Ser_1Arg_7_Alias";
    /** <code>projectcreateinstancepagrTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPAGRTEAM = "Team";
    /** <code>projectcreateinstancepatrProjectName</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPROJECTNAME = "p_atrProjectName";
    /** <code>projectcreateinstancepatrProjectName</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPROJECTNAME = "Clas_1057569177600719Ser_1Arg_2_Alias";
    /** <code>projectcreateinstancepatrProjectName</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPROJECTNAME = "Name";
    /** <code>projectcreateinstancepatrProDescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPRODESCRIPTION = "p_atrProDescription";
    /** <code>projectcreateinstancepatrProDescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPRODESCRIPTION = "Clas_1057569177600719Ser_1Arg_3_Alias";
    /** <code>projectcreateinstancepatrProDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPRODESCRIPTION = "Description";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1057569177600719Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>projectdeleteinstancepthisProject</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_PROJECTDELETEINSTANCEPTHISPROJECT = "p_thisProject";
    /** <code>projectdeleteinstancepthisProject</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_PROJECTDELETEINSTANCEPTHISPROJECT = "Clas_1057569177600719Ser_2Arg_1_Alias";
    /** <code>projectdeleteinstancepthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_PROJECTDELETEINSTANCEPTHISPROJECT = "Project";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600719Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>projecteditinstancepthisProject</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_PROJECTEDITINSTANCEPTHISPROJECT = "p_thisProject";
    /** <code>projecteditinstancepthisProject</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPTHISPROJECT = "Clas_1057569177600719Ser_3Arg_1_Alias";
    /** <code>projecteditinstancepthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPTHISPROJECT = "Project";
    /** <code>projecteditinstancepProjectName</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_PROJECTEDITINSTANCEPPROJECTNAME = "p_ProjectName";
    /** <code>projecteditinstancepProjectName</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPPROJECTNAME = "Clas_1057569177600719Ser_3Arg_2_Alias";
    /** <code>projecteditinstancepProjectName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPPROJECTNAME = "Name";
    /** <code>projecteditinstancepProDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_PROJECTEDITINSTANCEPPRODESCRIPTION = "p_ProDescription";
    /** <code>projecteditinstancepProDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPPRODESCRIPTION = "Clas_1057569177600719Ser_3Arg_3_Alias";
    /** <code>projecteditinstancepProDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPPRODESCRIPTION = "Description";
    // Service (markAsCompleted)
    /** <code>markAsCompleted</code> service id. */
    public static final String SERV_ID_MARKASCOMPLETED = "Clas_1057569177600719Ser_4_Alias";
    /** <code>markAsCompleted</code> service name. */
    public static final String SERV_NAME_MARKASCOMPLETED = "markAsCompleted";
    /** <code>markAsCompleted</code> service alias. */
    public static final String SERV_ALIAS_MARKASCOMPLETED = "Mark as completed";
    /** Agents allowed to execute the service markAsCompleted **/
    public static final String MARKASCOMPLETED_SRVAGENTS = "";
    // Inbound arguments
    /** <code>projectmarkAsCompletedpthisProject</code> inbound argument name. */
    public static final String ARG_NAME_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPTHISPROJECT = "p_thisProject";
    /** <code>projectmarkAsCompletedpthisProject</code> inbound argument id. */
    public static final String ARG_ID_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPTHISPROJECT = "Clas_1057569177600719Ser_4Arg_1_Alias";
    /** <code>projectmarkAsCompletedpthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPTHISPROJECT = "Project";
    /** <code>projectmarkAsCompletedpCompletionDate</code> inbound argument name. */
    public static final String ARG_NAME_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPCOMPLETIONDATE = "pCompletionDate";
    /** <code>projectmarkAsCompletedpCompletionDate</code> inbound argument id. */
    public static final String ARG_ID_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPCOMPLETIONDATE = "Clas_1057569177600719Ser_4Arg_2_Alias";
    /** <code>projectmarkAsCompletedpCompletionDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPCOMPLETIONDATE = "Completion Date";
    // Service (assignTemplateToProject)
    /** <code>assignTemplateToProject</code> service id. */
    public static final String SERV_ID_ASSIGNTEMPLATETOPROJECT = "Clas_1057569177600719Ser_6_Alias";
    /** <code>assignTemplateToProject</code> service name. */
    public static final String SERV_NAME_ASSIGNTEMPLATETOPROJECT = "assignTemplateToProject";
    /** <code>assignTemplateToProject</code> service alias. */
    public static final String SERV_ALIAS_ASSIGNTEMPLATETOPROJECT = "Assign Template";
    /** Agents allowed to execute the service assignTemplateToProject **/
    public static final String ASSIGNTEMPLATETOPROJECT_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>projectassignTemplateToProjectpthisProject</code> inbound argument name. */
    public static final String ARG_NAME_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPTHISPROJECT = "p_thisProject";
    /** <code>projectassignTemplateToProjectpthisProject</code> inbound argument id. */
    public static final String ARG_ID_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPTHISPROJECT = "Clas_1057569177600719Ser_6Arg_1_Alias";
    /** <code>projectassignTemplateToProjectpthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPTHISPROJECT = "Projects";
    /** <code>projectassignTemplateToProjectpevcERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPEVCERTEMPLATE = "p_evcERTemplate";
    /** <code>projectassignTemplateToProjectpevcERTemplate</code> inbound argument id. */
    public static final String ARG_ID_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPEVCERTEMPLATE = "Clas_1057569177600719Ser_6Arg_2_Alias";
    /** <code>projectassignTemplateToProjectpevcERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPEVCERTEMPLATE = "ERTemplates";
    // Service (deassignTemplate)
    /** <code>deassignTemplate</code> service id. */
    public static final String SERV_ID_DEASSIGNTEMPLATE = "Clas_1057569177600719Ser_7_Alias";
    /** <code>deassignTemplate</code> service name. */
    public static final String SERV_NAME_DEASSIGNTEMPLATE = "deassignTemplate";
    /** <code>deassignTemplate</code> service alias. */
    public static final String SERV_ALIAS_DEASSIGNTEMPLATE = "Deassign Template";
    /** Agents allowed to execute the service deassignTemplate **/
    public static final String DEASSIGNTEMPLATE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>projectdeassignTemplatepthisProject</code> inbound argument name. */
    public static final String ARG_NAME_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPTHISPROJECT = "p_thisProject";
    /** <code>projectdeassignTemplatepthisProject</code> inbound argument id. */
    public static final String ARG_ID_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPTHISPROJECT = "Clas_1057569177600719Ser_7Arg_1_Alias";
    /** <code>projectdeassignTemplatepthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPTHISPROJECT = "Projects";
    /** <code>projectdeassignTemplatepevcERTemplate</code> inbound argument name. */
    public static final String ARG_NAME_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPEVCERTEMPLATE = "p_evcERTemplate";
    /** <code>projectdeassignTemplatepevcERTemplate</code> inbound argument id. */
    public static final String ARG_ID_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPEVCERTEMPLATE = "Clas_1057569177600719Ser_7Arg_2_Alias";
    /** <code>projectdeassignTemplatepevcERTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPEVCERTEMPLATE = "ERTemplates";
    // Service (TCOMPLETE)
    /** <code>TCOMPLETE</code> service id. */
    public static final String SERV_ID_TCOMPLETE = "Clas_1057569177600719Ser_5_Alias";
    /** <code>TCOMPLETE</code> service name. */
    public static final String SERV_NAME_TCOMPLETE = "TCOMPLETE";
    /** <code>TCOMPLETE</code> service alias. */
    public static final String SERV_ALIAS_TCOMPLETE = "Complete";
    /** Agents allowed to execute the service TCOMPLETE **/
    public static final String TCOMPLETE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>projectTCOMPLETEpthisProject</code> inbound argument name. */
    public static final String ARG_NAME_TCOMPLETE_PROJECTTCOMPLETEPTHISPROJECT = "p_thisProject";
    /** <code>projectTCOMPLETEpthisProject</code> inbound argument id. */
    public static final String ARG_ID_TCOMPLETE_PROJECTTCOMPLETEPTHISPROJECT = "Clas_1057569177600719Ser_5Arg_1_Alias";
    /** <code>projectTCOMPLETEpthisProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_TCOMPLETE_PROJECTTCOMPLETEPTHISPROJECT = "Project";
    /** <code>projectTCOMPLETEpCompletionDate</code> inbound argument name. */
    public static final String ARG_NAME_TCOMPLETE_PROJECTTCOMPLETEPCOMPLETIONDATE = "pCompletionDate";
    /** <code>projectTCOMPLETEpCompletionDate</code> inbound argument id. */
    public static final String ARG_ID_TCOMPLETE_PROJECTTCOMPLETEPCOMPLETIONDATE = "Clas_1057569177600719Ser_5Arg_2_Alias";
    /** <code>projectTCOMPLETEpCompletionDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TCOMPLETE_PROJECTTCOMPLETEPCOMPLETIONDATE = "Completion Date";

    public static final String FILTER_NAME_FPROJECTS = "FProjects";
    public static final String VAR_NAME_FPROJECTS_VNAME = "vName";
    public static final String VAR_NAME_FPROJECTS_VCOMPLETED = "vCompleted";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_PROJECTPROJECTNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTPRODESCRIPTION.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTTOTEXPENSES.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTCOMPLETIONDATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTMAXEXPENSE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTMINEXPENSE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTAVGEXPENSE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_PROJECTCOMPLETED.toUpperCase(), Constants.Type.BOOL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_PROJECTIDPROJECT.toUpperCase(), PROJECTIDPROJECT_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTPROJECTNAME.toUpperCase(), PROJECTPROJECTNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTPRODESCRIPTION.toUpperCase(), PROJECTPRODESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTTOTEXPENSES.toUpperCase(), PROJECTTOTEXPENSES_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTCOMPLETIONDATE.toUpperCase(), PROJECTCOMPLETIONDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTMAXEXPENSE.toUpperCase(), PROJECTMAXEXPENSE_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTMINEXPENSE.toUpperCase(), PROJECTMINEXPENSE_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTAVGEXPENSE.toUpperCase(), PROJECTAVGEXPENSE_AGENTS);
    	attributeAgents.put(ATTR_NAME_PROJECTCOMPLETED.toUpperCase(), PROJECTCOMPLETED_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_TEAM.toUpperCase(), TEAM_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'Project', it returns the identification keys
     * - If className is a facet of the inheritance net of 'Project', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_PROJECTIDPROJECT);
        }
        // Facet 'Project' (This facet)
        if (ProjectConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_PROJECTIDPROJECT);
        }
        return returnList;
    }
}
