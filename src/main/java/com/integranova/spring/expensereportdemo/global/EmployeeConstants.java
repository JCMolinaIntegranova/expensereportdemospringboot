package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>Employee</code> model class.
 */
public final class EmployeeConstants {

    private EmployeeConstants() {

    }

    // Class
    /** <code>Employee</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600607_Alias";
    /** <code>Employee</code> class name. */
    public static final String CLASS_NAME = "Employee";
    /** <code>Employee</code> class alias. */
    public static final String CLASS_ALIAS = "Employee";
    /** <code>Employee</code> class table name. */
    public static final String TBL_NAME = "Employee";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "employeeidEmployee,employeeEmpName,employeeEmpSurname,employeeSite,employeePhoneNumbers,employeeemail";

    public static final String DSDSEMPLOYEE = "DS_Employee";
    public static final String DSDSEMPLOYEESUP = "DS_EmployeeSup";
    

    // Attribute (employeeidEmployee)
    /** <code>employeeidEmployee</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEIDEMPLOYEE = "Clas_1057569177600607Atr_1_Alias";
    /** <code>employeeidEmployee</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEIDEMPLOYEE = "employeeidEmployee";
    /** <code>employeeidEmployee</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEIDEMPLOYEE = "Employee Code";

    /** <code>employeeidEmployee</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEIDEMPLOYEE = "";
    /** Agents allowed to view the attribute employeeidEmployee **/
    public static final String EMPLOYEEIDEMPLOYEE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeEmpName)
    /** <code>employeeEmpName</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEEMPNAME = "Clas_1057569177600607Atr_2_Alias";
    /** <code>employeeEmpName</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEEMPNAME = "employeeEmpName";
    /** <code>employeeEmpName</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEEMPNAME = "Name";

    /** <code>employeeEmpName</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEEMPNAME = "";
    /** Agents allowed to view the attribute employeeEmpName **/
    public static final String EMPLOYEEEMPNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeEmpSurname)
    /** <code>employeeEmpSurname</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEEMPSURNAME = "Clas_1057569177600607Atr_3_Alias";
    /** <code>employeeEmpSurname</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEEMPSURNAME = "employeeEmpSurname";
    /** <code>employeeEmpSurname</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEEMPSURNAME = "Surname";

    /** <code>employeeEmpSurname</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEEMPSURNAME = "";
    /** Agents allowed to view the attribute employeeEmpSurname **/
    public static final String EMPLOYEEEMPSURNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeSite)
    /** <code>employeeSite</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEESITE = "Clas_1057569177600607Atr_4_Alias";
    /** <code>employeeSite</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEESITE = "employeeSite";
    /** <code>employeeSite</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEESITE = "Site";

    /** <code>employeeSite</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEESITE = "";
    /** Agents allowed to view the attribute employeeSite **/
    public static final String EMPLOYEESITE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeePhoneNumbers)
    /** <code>employeePhoneNumbers</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEPHONENUMBERS = "Clas_1057569177600607Atr_5_Alias";
    /** <code>employeePhoneNumbers</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEPHONENUMBERS = "employeePhoneNumbers";
    /** <code>employeePhoneNumbers</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEPHONENUMBERS = "Phone Numbers";

    /** <code>employeePhoneNumbers</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEPHONENUMBERS = "";
    /** Agents allowed to view the attribute employeePhoneNumbers **/
    public static final String EMPLOYEEPHONENUMBERS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeemail)
    /** <code>employeeemail</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEEMAIL = "Clas_1057569177600607Atr_6_Alias";
    /** <code>employeeemail</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEEMAIL = "employeeemail";
    /** <code>employeeemail</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEEMAIL = "E-mail";

    /** <code>employeeemail</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEEMAIL = "";
    /** Agents allowed to view the attribute employeeemail **/
    public static final String EMPLOYEEEMAIL_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeEmpFullName)
    /** <code>employeeEmpFullName</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEEMPFULLNAME = "Clas_1057569177600607Atr_7_Alias";
    /** <code>employeeEmpFullName</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEEMPFULLNAME = "employeeEmpFullName";
    /** <code>employeeEmpFullName</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEEMPFULLNAME = "Full Name";

    /** <code>employeeEmpFullName</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEEMPFULLNAME = "";
    /** Agents allowed to view the attribute employeeEmpFullName **/
    public static final String EMPLOYEEEMPFULLNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeePicture)
    /** <code>employeePicture</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEEPICTURE = "Clas_1057569177600607Atr_8_Alias";
    /** <code>employeePicture</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEEPICTURE = "employeePicture";
    /** <code>employeePicture</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEEPICTURE = "Picture";

    /** <code>employeePicture</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEEPICTURE = "";
    /** Agents allowed to view the attribute employeePicture **/
    public static final String EMPLOYEEPICTURE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (employeeNumOfExpReports)
    /** <code>employeeNumOfExpReports</code> attribute id. */
    public static final String ATTR_ID_EMPLOYEENUMOFEXPREPORTS = "Clas_1057569177600607Atr_9_Alias";
    /** <code>employeeNumOfExpReports</code> attribute name. */
    public static final String ATTR_NAME_EMPLOYEENUMOFEXPREPORTS = "employeeNumOfExpReports";
    /** <code>employeeNumOfExpReports</code> attribute alias. */
    public static final String ATTR_ALIAS_EMPLOYEENUMOFEXPREPORTS = "# Exp.Reports";

    /** <code>employeeNumOfExpReports</code> attribute facet sequence. */
    public static final String PATH_FACETS_EMPLOYEENUMOFEXPREPORTS = "";
    /** Agents allowed to view the attribute employeeNumOfExpReports **/
    public static final String EMPLOYEENUMOFEXPREPORTS_AGENTS = "AdminUser,OperatorUser";


    // Field (id_Employee)
    /** <code>id_Employee</code> field name. */
    public static final String FLD_EMPLOYEEIDEMPLOYEE = "id_Employee";    
    /** <code>id_Employee</code> field length. */
    public static final int FLD_EMPLOYEEIDEMPLOYEELENGTH = 10;
    /** <code>employeeidEmployee</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEIDEMPLOYEE = "employeeidEmployee";
    // Field (EmpName)
    /** <code>EmpName</code> field name. */
    public static final String FLD_EMPLOYEEEMPNAME = "EmpName";    
    /** <code>EmpName</code> field length. */
    public static final int FLD_EMPLOYEEEMPNAMELENGTH = 25;
    /** <code>employeeEmpName</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEEMPNAME = "employeeEmpName";
    // Field (EmpSurname)
    /** <code>EmpSurname</code> field name. */
    public static final String FLD_EMPLOYEEEMPSURNAME = "EmpSurname";    
    /** <code>EmpSurname</code> field length. */
    public static final int FLD_EMPLOYEEEMPSURNAMELENGTH = 25;
    /** <code>employeeEmpSurname</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEEMPSURNAME = "employeeEmpSurname";
    // Field (Site)
    /** <code>Site</code> field name. */
    public static final String FLD_EMPLOYEESITE = "Site";    
    /** <code>Site</code> field length. */
    public static final int FLD_EMPLOYEESITELENGTH = 50;
    /** <code>employeeSite</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEESITE = "employeeSite";
    // Field (PhoneNumbers)
    /** <code>PhoneNumbers</code> field name. */
    public static final String FLD_EMPLOYEEPHONENUMBERS = "PhoneNumbers";    
    /** <code>PhoneNumbers</code> field length. */
    public static final int FLD_EMPLOYEEPHONENUMBERSLENGTH = 50;
    /** <code>employeePhoneNumbers</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEPHONENUMBERS = "employeePhoneNumbers";
    // Field (email)
    /** <code>email</code> field name. */
    public static final String FLD_EMPLOYEEEMAIL = "email";    
    /** <code>email</code> field length. */
    public static final int FLD_EMPLOYEEEMAILLENGTH = 100;
    /** <code>employeeemail</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEEMAIL = "employeeemail";
    // Field (Picture)
    /** <code>Picture</code> field name. */
    public static final String FLD_EMPLOYEEPICTURE = "Picture";    
    /** <code>employeePicture</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEEPICTURE = "employeePicture";

    // Component role (Teams)
    /** <code>Teams</code> role id. */
    public static final String ROLE_ID_TEAMS = "Agr_1622453780480680_Alias";
    /** <code>Teams</code> role name. */
    public static final String ROLE_NAME_TEAMS = "teams";
    /** <code>Teams</code> role alias. */
    public static final String ROLE_ALIAS_TEAMS = "Teams";

    /** <code>Teams</code> inverse role name. */
    public static final String ROLE_INVNAME_TEAMS = TeamConstants.ROLE_NAME_EMPLOYEES;
    /** <code>Teams</code> role facet sequence. */
    public static final String PATH_FACETS_TEAMS = "";
    /** <code>Teams</code> role target class. */
    public static final String ROLE_TARGET_TEAMS = TeamConstants.CLASS_NAME;

    /** Agents allowed to navigate through Teams **/
    public static final String TEAMS_AGENTS = "AdminUser,OperatorUser";

    // Compound role (ExpenseReports)
    /** <code>ExpenseReports</code> role id. */
    public static final String ROLE_ID_EXPENSEREPORTS = "Agr_1057569177600817_Alias";
    /** <code>ExpenseReports</code> role name. */
    public static final String ROLE_NAME_EXPENSEREPORTS = "expenseReports";
    /** <code>Employee</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSEREPORTS = "Expense Reports";


    /** <code>ExpenseReports</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSEREPORTS = ExpenseReportConstants.ROLE_NAME_EMPLOYEE;
    /** <code>ExpenseReports</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTS = "";
    /** <code>ExpenseReports</code> role target class. */
    public static final String ROLE_TARGET_EXPENSEREPORTS = ExpenseReportConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseReports **/
    public static final String EXPENSEREPORTS_AGENTS = "AdminUser,OperatorUser";
    // Compound role (Assignments)
    /** <code>Assignments</code> role id. */
    public static final String ROLE_ID_ASSIGNMENTS = "Agr_1468338405376498_Alias";
    /** <code>Assignments</code> role name. */
    public static final String ROLE_NAME_ASSIGNMENTS = "assignments";
    /** <code>Employee</code> role alias. */
    public static final String ROLE_ALIAS_ASSIGNMENTS = "Assignments";


    /** <code>Assignments</code> inverse role name. */
    public static final String ROLE_INVNAME_ASSIGNMENTS = AssignmentConstants.ROLE_NAME_EMPLOYEE;
    /** <code>Assignments</code> role facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTS = "";
    /** <code>Assignments</code> role target class. */
    public static final String ROLE_TARGET_ASSIGNMENTS = AssignmentConstants.CLASS_NAME;
    /** Agents allowed to navigate through Assignments **/
    public static final String ASSIGNMENTS_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1057569177600607Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>employeecreateinstancepatridEmployee</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRIDEMPLOYEE = "p_atrid_Employee";
    /** <code>employeecreateinstancepatridEmployee</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRIDEMPLOYEE = "Clas_1057569177600607Ser_1Arg_1_Alias";
    /** <code>employeecreateinstancepatridEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRIDEMPLOYEE = "Employee Code";
    /** <code>employeecreateinstancepatrEmpName</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPNAME = "p_atrEmpName";
    /** <code>employeecreateinstancepatrEmpName</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPNAME = "Clas_1057569177600607Ser_1Arg_2_Alias";
    /** <code>employeecreateinstancepatrEmpName</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPNAME = "Name";
    /** <code>employeecreateinstancepatrEmpSurname</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPSURNAME = "p_atrEmpSurname";
    /** <code>employeecreateinstancepatrEmpSurname</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPSURNAME = "Clas_1057569177600607Ser_1Arg_3_Alias";
    /** <code>employeecreateinstancepatrEmpSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPSURNAME = "Surname";
    /** <code>employeecreateinstancepatrSite</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRSITE = "p_atrSite";
    /** <code>employeecreateinstancepatrSite</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRSITE = "Clas_1057569177600607Ser_1Arg_4_Alias";
    /** <code>employeecreateinstancepatrSite</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRSITE = "Site";
    /** <code>employeecreateinstancepatrPhoneNumbers</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPHONENUMBERS = "p_atrPhoneNumbers";
    /** <code>employeecreateinstancepatrPhoneNumbers</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPHONENUMBERS = "Clas_1057569177600607Ser_1Arg_5_Alias";
    /** <code>employeecreateinstancepatrPhoneNumbers</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPHONENUMBERS = "Phone Numbers";
    /** <code>employeecreateinstancepatremail</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMAIL = "p_atremail";
    /** <code>employeecreateinstancepatremail</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMAIL = "Clas_1057569177600607Ser_1Arg_6_Alias";
    /** <code>employeecreateinstancepatremail</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMAIL = "E-mail";
    /** <code>employeecreateinstancepatrPicture</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPICTURE = "p_atrPicture";
    /** <code>employeecreateinstancepatrPicture</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPICTURE = "Clas_1057569177600607Ser_1Arg_7_Alias";
    /** <code>employeecreateinstancepatrPicture</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRPICTURE = "Picture";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1057569177600607Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>employeedeleteinstancepthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_EMPLOYEEDELETEINSTANCEPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeedeleteinstancepthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_EMPLOYEEDELETEINSTANCEPTHISEMPLOYEE = "Clas_1057569177600607Ser_2Arg_1_Alias";
    /** <code>employeedeleteinstancepthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_EMPLOYEEDELETEINSTANCEPTHISEMPLOYEE = "Employee";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600607Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>employeeeditinstancepthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeeeditinstancepthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPTHISEMPLOYEE = "Clas_1057569177600607Ser_3Arg_1_Alias";
    /** <code>employeeeditinstancepthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPTHISEMPLOYEE = "Employee";
    /** <code>employeeeditinstancepEmpName</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPNAME = "p_EmpName";
    /** <code>employeeeditinstancepEmpName</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPNAME = "Clas_1057569177600607Ser_3Arg_2_Alias";
    /** <code>employeeeditinstancepEmpName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPNAME = "Name";
    /** <code>employeeeditinstancepEmpSurname</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPSURNAME = "p_EmpSurname";
    /** <code>employeeeditinstancepEmpSurname</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPSURNAME = "Clas_1057569177600607Ser_3Arg_3_Alias";
    /** <code>employeeeditinstancepEmpSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPSURNAME = "Surname";
    /** <code>employeeeditinstancepSite</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPSITE = "p_Site";
    /** <code>employeeeditinstancepSite</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPSITE = "Clas_1057569177600607Ser_3Arg_4_Alias";
    /** <code>employeeeditinstancepSite</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPSITE = "Site";
    /** <code>employeeeditinstancepPhoneNumbers</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPPHONENUMBERS = "p_PhoneNumbers";
    /** <code>employeeeditinstancepPhoneNumbers</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPPHONENUMBERS = "Clas_1057569177600607Ser_3Arg_5_Alias";
    /** <code>employeeeditinstancepPhoneNumbers</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPPHONENUMBERS = "Phone Numbers";
    /** <code>employeeeditinstancepemail</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMAIL = "p_email";
    /** <code>employeeeditinstancepemail</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMAIL = "Clas_1057569177600607Ser_3Arg_6_Alias";
    /** <code>employeeeditinstancepemail</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMAIL = "E-mail";
    // Service (changePicture)
    /** <code>changePicture</code> service id. */
    public static final String SERV_ID_CHANGEPICTURE = "Clas_1057569177600607Ser_4_Alias";
    /** <code>changePicture</code> service name. */
    public static final String SERV_NAME_CHANGEPICTURE = "changePicture";
    /** <code>changePicture</code> service alias. */
    public static final String SERV_ALIAS_CHANGEPICTURE = "Change Picture";
    /** Agents allowed to execute the service changePicture **/
    public static final String CHANGEPICTURE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>employeechangePicturepthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeechangePicturepthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPTHISEMPLOYEE = "Clas_1057569177600607Ser_4Arg_1_Alias";
    /** <code>employeechangePicturepthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPTHISEMPLOYEE = "Employee";
    /** <code>employeechangePicturepPicture</code> inbound argument name. */
    public static final String ARG_NAME_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPPICTURE = "p_Picture";
    /** <code>employeechangePicturepPicture</code> inbound argument id. */
    public static final String ARG_ID_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPPICTURE = "Clas_1057569177600607Ser_4Arg_2_Alias";
    /** <code>employeechangePicturepPicture</code> inbound argument alias. */
    public static final String ARG_ALIAS_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPPICTURE = "Picture";
    // Service (addEmployeeToTeam)
    /** <code>addEmployeeToTeam</code> service id. */
    public static final String SERV_ID_ADDEMPLOYEETOTEAM = "Clas_1057569177600607Ser_7_Alias";
    /** <code>addEmployeeToTeam</code> service name. */
    public static final String SERV_NAME_ADDEMPLOYEETOTEAM = "addEmployeeToTeam";
    /** <code>addEmployeeToTeam</code> service alias. */
    public static final String SERV_ALIAS_ADDEMPLOYEETOTEAM = "addEmployeeToTeam";
    /** Agents allowed to execute the service addEmployeeToTeam **/
    public static final String ADDEMPLOYEETOTEAM_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>addEmployeeToTeam</code> precondition 0 id. */
    public static final String PRE_ID_ADDEMPLOYEETOTEAM_0 = "Clas_1057569177600607Pre_1_MsgError";
    /** <code>addEmployeeToTeam</code> precondition 1 id. */
    public static final String PRE_ID_ADDEMPLOYEETOTEAM_1 = "Clas_1057569177600607Pre_2_MsgError";
    // Inbound arguments
    /** <code>employeeaddEmployeeToTeampthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeeaddEmployeeToTeampthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE = "Clas_1057569177600607Ser_7Arg_1_Alias";
    /** <code>employeeaddEmployeeToTeampthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE = "Employees";
    /** <code>employeeaddEmployeeToTeampevcTeam</code> inbound argument name. */
    public static final String ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM = "p_evcTeam";
    /** <code>employeeaddEmployeeToTeampevcTeam</code> inbound argument id. */
    public static final String ARG_ID_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM = "Clas_1057569177600607Ser_7Arg_2_Alias";
    /** <code>employeeaddEmployeeToTeampevcTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM = "Teams";
    // Service (removeEmployeeFromTeam)
    /** <code>removeEmployeeFromTeam</code> service id. */
    public static final String SERV_ID_REMOVEEMPLOYEEFROMTEAM = "Clas_1057569177600607Ser_8_Alias";
    /** <code>removeEmployeeFromTeam</code> service name. */
    public static final String SERV_NAME_REMOVEEMPLOYEEFROMTEAM = "removeEmployeeFromTeam";
    /** <code>removeEmployeeFromTeam</code> service alias. */
    public static final String SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM = "removeEmployeeFromTeam";
    /** Agents allowed to execute the service removeEmployeeFromTeam **/
    public static final String REMOVEEMPLOYEEFROMTEAM_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>employeeremoveEmployeeFromTeampthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeeremoveEmployeeFromTeampthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE = "Clas_1057569177600607Ser_8Arg_1_Alias";
    /** <code>employeeremoveEmployeeFromTeampthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE = "Employees";
    /** <code>employeeremoveEmployeeFromTeampevcTeam</code> inbound argument name. */
    public static final String ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM = "p_evcTeam";
    /** <code>employeeremoveEmployeeFromTeampevcTeam</code> inbound argument id. */
    public static final String ARG_ID_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM = "Clas_1057569177600607Ser_8Arg_2_Alias";
    /** <code>employeeremoveEmployeeFromTeampevcTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM = "Teams";
    // Service (TDELETE)
    /** <code>TDELETE</code> service id. */
    public static final String SERV_ID_TDELETE = "Clas_1057569177600607Ser_9_Alias";
    /** <code>TDELETE</code> service name. */
    public static final String SERV_NAME_TDELETE = "TDELETE";
    /** <code>TDELETE</code> service alias. */
    public static final String SERV_ALIAS_TDELETE = "Delete";
    /** Agents allowed to execute the service TDELETE **/
    public static final String TDELETE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>employeeTDELETEpthisEmployee</code> inbound argument name. */
    public static final String ARG_NAME_TDELETE_EMPLOYEETDELETEPTHISEMPLOYEE = "p_thisEmployee";
    /** <code>employeeTDELETEpthisEmployee</code> inbound argument id. */
    public static final String ARG_ID_TDELETE_EMPLOYEETDELETEPTHISEMPLOYEE = "Clas_1057569177600607Ser_9Arg_1_Alias";
    /** <code>employeeTDELETEpthisEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_TDELETE_EMPLOYEETDELETEPTHISEMPLOYEE = "Employee";

    public static final String FILTER_NAME_FEMPLOYEENAME = "F_EmployeeName";
    public static final String VAR_NAME_FEMPLOYEENAME_VFULLNAME = "v_FullName";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EMPLOYEEEMPNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEEEMPSURNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEESITE.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEEPHONENUMBERS.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEEEMAIL.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEEEMPFULLNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEEPICTURE.toUpperCase(), Constants.Type.BLOB.getTypeName());
        attributeTypes.put(ATTR_NAME_EMPLOYEENUMOFEXPREPORTS.toUpperCase(), Constants.Type.INT.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EMPLOYEEIDEMPLOYEE.toUpperCase(), EMPLOYEEIDEMPLOYEE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEEMPNAME.toUpperCase(), EMPLOYEEEMPNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEEMPSURNAME.toUpperCase(), EMPLOYEEEMPSURNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEESITE.toUpperCase(), EMPLOYEESITE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEPHONENUMBERS.toUpperCase(), EMPLOYEEPHONENUMBERS_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEEMAIL.toUpperCase(), EMPLOYEEEMAIL_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEEMPFULLNAME.toUpperCase(), EMPLOYEEEMPFULLNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEEPICTURE.toUpperCase(), EMPLOYEEPICTURE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EMPLOYEENUMOFEXPREPORTS.toUpperCase(), EMPLOYEENUMOFEXPREPORTS_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'Employee', it returns the identification keys
     * - If className is a facet of the inheritance net of 'Employee', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_EMPLOYEEIDEMPLOYEE);
        }
        // Facet 'Employee' (This facet)
        if (EmployeeConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_EMPLOYEEIDEMPLOYEE);
        }
        return returnList;
    }
}
