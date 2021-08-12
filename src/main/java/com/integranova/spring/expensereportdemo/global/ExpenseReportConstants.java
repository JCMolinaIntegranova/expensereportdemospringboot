package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ExpenseReport</code> model class.
 */
public final class ExpenseReportConstants {

    private ExpenseReportConstants() {

    }

    // Class
    /** <code>ExpenseReport</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600553_Alias";
    /** <code>ExpenseReport</code> class name. */
    public static final String CLASS_NAME = "ExpenseReport";
    /** <code>ExpenseReport</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Report";
    /** <code>ExpenseReport</code> class table name. */
    public static final String TBL_NAME = "ExpenseReport";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "expenseReportidExpenseRepor,employeeidEmployee,expenseCurrencyCurrencyCode,paymentTypeidPaymentType,projectidProject,expenseReportPresentDate,expenseReportStatus,expenseReportCause,expenseReportAuthoDate,expenseReportAuthoComments,expenseReportPaymentDate,expenseReportPayComments,expenseReportAdvances,expenseReportExchange";

    public static final String DSDSEXPENSEREPORT4MD = "DS_ExpenseReport4MD";
    public static final String DSDSEXPENSEREPORTSUP = "DS_ExpenseReportSup";
    public static final String DSDSEXPENSEREPORT4HAT = "DS_ExpenseReport4HAT";
    

    // Attribute (expenseReportidExpenseRepor)
    /** <code>expenseReportidExpenseRepor</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTIDEXPENSEREPOR = "Clas_1057569177600553Atr_1_Alias";
    /** <code>expenseReportidExpenseRepor</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR = "expenseReportidExpenseRepor";
    /** <code>expenseReportidExpenseRepor</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTIDEXPENSEREPOR = "id_ExpenseRepor";

    /** <code>expenseReportidExpenseRepor</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTIDEXPENSEREPOR = "";
    /** Agents allowed to view the attribute expenseReportidExpenseRepor **/
    public static final String EXPENSEREPORTIDEXPENSEREPOR_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportPresentDate)
    /** <code>expenseReportPresentDate</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTPRESENTDATE = "Clas_1057569177600553Atr_2_Alias";
    /** <code>expenseReportPresentDate</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTPRESENTDATE = "expenseReportPresentDate";
    /** <code>expenseReportPresentDate</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTPRESENTDATE = "Presentation Date";

    /** <code>expenseReportPresentDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTPRESENTDATE = "";
    /** Agents allowed to view the attribute expenseReportPresentDate **/
    public static final String EXPENSEREPORTPRESENTDATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportStatus)
    /** <code>expenseReportStatus</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTSTATUS = "Clas_1057569177600553Atr_3_Alias";
    /** <code>expenseReportStatus</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTSTATUS = "expenseReportStatus";
    /** <code>expenseReportStatus</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTSTATUS = "Status";

    /** <code>expenseReportStatus</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTSTATUS = "";
    /** Agents allowed to view the attribute expenseReportStatus **/
    public static final String EXPENSEREPORTSTATUS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportCause)
    /** <code>expenseReportCause</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTCAUSE = "Clas_1057569177600553Atr_4_Alias";
    /** <code>expenseReportCause</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTCAUSE = "expenseReportCause";
    /** <code>expenseReportCause</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTCAUSE = "Cause";

    /** <code>expenseReportCause</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTCAUSE = "";
    /** Agents allowed to view the attribute expenseReportCause **/
    public static final String EXPENSEREPORTCAUSE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportAuthoDate)
    /** <code>expenseReportAuthoDate</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTAUTHODATE = "Clas_1057569177600553Atr_5_Alias";
    /** <code>expenseReportAuthoDate</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTAUTHODATE = "expenseReportAuthoDate";
    /** <code>expenseReportAuthoDate</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTAUTHODATE = "Authorization Date";

    /** <code>expenseReportAuthoDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTAUTHODATE = "";
    /** Agents allowed to view the attribute expenseReportAuthoDate **/
    public static final String EXPENSEREPORTAUTHODATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportAuthoComments)
    /** <code>expenseReportAuthoComments</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTAUTHOCOMMENTS = "Clas_1057569177600553Atr_6_Alias";
    /** <code>expenseReportAuthoComments</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTAUTHOCOMMENTS = "expenseReportAuthoComments";
    /** <code>expenseReportAuthoComments</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTAUTHOCOMMENTS = "Authorization Comments";

    /** <code>expenseReportAuthoComments</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTAUTHOCOMMENTS = "";
    /** Agents allowed to view the attribute expenseReportAuthoComments **/
    public static final String EXPENSEREPORTAUTHOCOMMENTS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportPaymentDate)
    /** <code>expenseReportPaymentDate</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTPAYMENTDATE = "Clas_1057569177600553Atr_7_Alias";
    /** <code>expenseReportPaymentDate</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTPAYMENTDATE = "expenseReportPaymentDate";
    /** <code>expenseReportPaymentDate</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTPAYMENTDATE = "Payment Date";

    /** <code>expenseReportPaymentDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTPAYMENTDATE = "";
    /** Agents allowed to view the attribute expenseReportPaymentDate **/
    public static final String EXPENSEREPORTPAYMENTDATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportPayComments)
    /** <code>expenseReportPayComments</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTPAYCOMMENTS = "Clas_1057569177600553Atr_8_Alias";
    /** <code>expenseReportPayComments</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTPAYCOMMENTS = "expenseReportPayComments";
    /** <code>expenseReportPayComments</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTPAYCOMMENTS = "Payment Comments";

    /** <code>expenseReportPayComments</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTPAYCOMMENTS = "";
    /** Agents allowed to view the attribute expenseReportPayComments **/
    public static final String EXPENSEREPORTPAYCOMMENTS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportTotExpenses)
    /** <code>expenseReportTotExpenses</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTTOTEXPENSES = "Clas_1057569177600553Atr_9_Alias";
    /** <code>expenseReportTotExpenses</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTTOTEXPENSES = "expenseReportTotExpenses";
    /** <code>expenseReportTotExpenses</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTTOTEXPENSES = "Total Expenses";

    /** <code>expenseReportTotExpenses</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTTOTEXPENSES = "";
    /** Agents allowed to view the attribute expenseReportTotExpenses **/
    public static final String EXPENSEREPORTTOTEXPENSES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportTotExpensesCur)
    /** <code>expenseReportTotExpensesCur</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTTOTEXPENSESCUR = "Clas_1057569177600553Atr_10_Alias";
    /** <code>expenseReportTotExpensesCur</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTTOTEXPENSESCUR = "expenseReportTotExpensesCur";
    /** <code>expenseReportTotExpensesCur</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTTOTEXPENSESCUR = "Total Expenses in Currency";

    /** <code>expenseReportTotExpensesCur</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTTOTEXPENSESCUR = "";
    /** Agents allowed to view the attribute expenseReportTotExpensesCur **/
    public static final String EXPENSEREPORTTOTEXPENSESCUR_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportAdvances)
    /** <code>expenseReportAdvances</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTADVANCES = "Clas_1057569177600553Atr_11_Alias";
    /** <code>expenseReportAdvances</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTADVANCES = "expenseReportAdvances";
    /** <code>expenseReportAdvances</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTADVANCES = "Advances";

    /** <code>expenseReportAdvances</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTADVANCES = "";
    /** Agents allowed to view the attribute expenseReportAdvances **/
    public static final String EXPENSEREPORTADVANCES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportAdvancesCur)
    /** <code>expenseReportAdvancesCur</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTADVANCESCUR = "Clas_1057569177600553Atr_12_Alias";
    /** <code>expenseReportAdvancesCur</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTADVANCESCUR = "expenseReportAdvancesCur";
    /** <code>expenseReportAdvancesCur</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTADVANCESCUR = "Advances in Currency";

    /** <code>expenseReportAdvancesCur</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTADVANCESCUR = "";
    /** Agents allowed to view the attribute expenseReportAdvancesCur **/
    public static final String EXPENSEREPORTADVANCESCUR_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportExchange)
    /** <code>expenseReportExchange</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTEXCHANGE = "Clas_1057569177600553Atr_13_Alias";
    /** <code>expenseReportExchange</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTEXCHANGE = "expenseReportExchange";
    /** <code>expenseReportExchange</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTEXCHANGE = "Exchange";

    /** <code>expenseReportExchange</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTEXCHANGE = "";
    /** Agents allowed to view the attribute expenseReportExchange **/
    public static final String EXPENSEREPORTEXCHANGE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportBalance)
    /** <code>expenseReportBalance</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTBALANCE = "Clas_1057569177600553Atr_14_Alias";
    /** <code>expenseReportBalance</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTBALANCE = "expenseReportBalance";
    /** <code>expenseReportBalance</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTBALANCE = "Balance";

    /** <code>expenseReportBalance</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTBALANCE = "";
    /** Agents allowed to view the attribute expenseReportBalance **/
    public static final String EXPENSEREPORTBALANCE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseReportBalanceCur)
    /** <code>expenseReportBalanceCur</code> attribute id. */
    public static final String ATTR_ID_EXPENSEREPORTBALANCECUR = "Clas_1057569177600553Atr_15_Alias";
    /** <code>expenseReportBalanceCur</code> attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORTBALANCECUR = "expenseReportBalanceCur";
    /** <code>expenseReportBalanceCur</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSEREPORTBALANCECUR = "Balance in Currency";

    /** <code>expenseReportBalanceCur</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTBALANCECUR = "";
    /** Agents allowed to view the attribute expenseReportBalanceCur **/
    public static final String EXPENSEREPORTBALANCECUR_AGENTS = "AdminUser,OperatorUser";


    // Field (id_ExpenseRepor)
    /** <code>id_ExpenseRepor</code> field name. */
    public static final String FLD_EXPENSEREPORTIDEXPENSEREPOR = "id_ExpenseRepor";    
    /** <code>expenseReportidExpenseRepor</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR = "expenseReportidExpenseRepor";
    // Field (id_Employee)
    /** <code>id_Employee</code> field name. */
    public static final String FLD_EMPLOYEEIDEMPLOYEE = "id_Employee";    
    /** <code>id_Employee</code> field length. */
    public static final int FLD_EMPLOYEEIDEMPLOYEELENGTH = 10;
    /** <code>Employee.employeeidEmployee</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEE_EMPLOYEEIDEMPLOYEE = "employeeidEmployee";
    // Field (CurrencyCode)
    /** <code>CurrencyCode</code> field name. */
    public static final String FLD_EXPENSECURRENCYCURRENCYCODE = "CurrencyCode";    
    /** <code>CurrencyCode</code> field length. */
    public static final int FLD_EXPENSECURRENCYCURRENCYCODELENGTH = 5;
    /** <code>ExpenseCurrency.expenseCurrencyCurrencyCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
    // Field (id_PaymentType)
    /** <code>id_PaymentType</code> field name. */
    public static final String FLD_PAYMENTTYPEIDPAYMENTTYPE = "id_PaymentType";    
    /** <code>id_PaymentType</code> field length. */
    public static final int FLD_PAYMENTTYPEIDPAYMENTTYPELENGTH = 5;
    /** <code>PaymentType.paymentTypeidPaymentType</code> attribute field name. */
    public static final String ATTR_FIELD_PAYMENTTYPE_PAYMENTTYPEIDPAYMENTTYPE = "paymentTypeidPaymentType";
    // Field (id_Project)
    /** <code>id_Project</code> field name. */
    public static final String FLD_PROJECTIDPROJECT = "id_Project";    
    /** <code>Project.projectidProject</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECT_PROJECTIDPROJECT = "projectidProject";
    // Field (PresentDate)
    /** <code>PresentDate</code> field name. */
    public static final String FLD_EXPENSEREPORTPRESENTDATE = "PresentDate";    
    /** <code>expenseReportPresentDate</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTPRESENTDATE = "expenseReportPresentDate";
    // Field (Status)
    /** <code>Status</code> field name. */
    public static final String FLD_EXPENSEREPORTSTATUS = "Status";    
    /** <code>expenseReportStatus</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTSTATUS = "expenseReportStatus";
    // Field (Cause)
    /** <code>Cause</code> field name. */
    public static final String FLD_EXPENSEREPORTCAUSE = "Cause";    
    /** <code>Cause</code> field length. */
    public static final int FLD_EXPENSEREPORTCAUSELENGTH = 255;
    /** <code>expenseReportCause</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTCAUSE = "expenseReportCause";
    // Field (AuthoDate)
    /** <code>AuthoDate</code> field name. */
    public static final String FLD_EXPENSEREPORTAUTHODATE = "AuthoDate";    
    /** <code>expenseReportAuthoDate</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTAUTHODATE = "expenseReportAuthoDate";
    // Field (AuthoComments)
    /** <code>AuthoComments</code> field name. */
    public static final String FLD_EXPENSEREPORTAUTHOCOMMENTS = "AuthoComments";    
    /** <code>AuthoComments</code> field length. */
    public static final int FLD_EXPENSEREPORTAUTHOCOMMENTSLENGTH = 255;
    /** <code>expenseReportAuthoComments</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTAUTHOCOMMENTS = "expenseReportAuthoComments";
    // Field (PaymentDate)
    /** <code>PaymentDate</code> field name. */
    public static final String FLD_EXPENSEREPORTPAYMENTDATE = "PaymentDate";    
    /** <code>expenseReportPaymentDate</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTPAYMENTDATE = "expenseReportPaymentDate";
    // Field (PayComments)
    /** <code>PayComments</code> field name. */
    public static final String FLD_EXPENSEREPORTPAYCOMMENTS = "PayComments";    
    /** <code>PayComments</code> field length. */
    public static final int FLD_EXPENSEREPORTPAYCOMMENTSLENGTH = 255;
    /** <code>expenseReportPayComments</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTPAYCOMMENTS = "expenseReportPayComments";
    // Field (Advances)
    /** <code>Advances</code> field name. */
    public static final String FLD_EXPENSEREPORTADVANCES = "Advances";    
    /** <code>expenseReportAdvances</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTADVANCES = "expenseReportAdvances";
    // Field (Exchange)
    /** <code>Exchange</code> field name. */
    public static final String FLD_EXPENSEREPORTEXCHANGE = "Exchange";    
    /** <code>expenseReportExchange</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORTEXCHANGE = "expenseReportExchange";

    // Component role (Employee)
    /** <code>Employee</code> role id. */
    public static final String ROLE_ID_EMPLOYEE = "Agr_1057569177600817_Alias";
    /** <code>Employee</code> role name. */
    public static final String ROLE_NAME_EMPLOYEE = "employee";
    /** <code>Employee</code> role alias. */
    public static final String ROLE_ALIAS_EMPLOYEE = "Employee";

    /** <code>Employee</code> inverse role name. */
    public static final String ROLE_INVNAME_EMPLOYEE = EmployeeConstants.ROLE_NAME_EXPENSEREPORTS;
    /** <code>Employee</code> role facet sequence. */
    public static final String PATH_FACETS_EMPLOYEE = "";
    /** <code>Employee</code> role target class. */
    public static final String ROLE_TARGET_EMPLOYEE = EmployeeConstants.CLASS_NAME;

    /** Agents allowed to navigate through Employee **/
    public static final String EMPLOYEE_AGENTS = "AdminUser,OperatorUser";
    // Component role (ExpenseCurrency)
    /** <code>ExpenseCurrency</code> role id. */
    public static final String ROLE_ID_EXPENSECURRENCY = "Agr_1057569177600778_Alias";
    /** <code>ExpenseCurrency</code> role name. */
    public static final String ROLE_NAME_EXPENSECURRENCY = "expenseCurrency";
    /** <code>ExpenseCurrency</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSECURRENCY = "Expense Currency";

    /** <code>ExpenseCurrency</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSECURRENCY = ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS;
    /** <code>ExpenseCurrency</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCY = "";
    /** <code>ExpenseCurrency</code> role target class. */
    public static final String ROLE_TARGET_EXPENSECURRENCY = ExpenseCurrencyConstants.CLASS_NAME;

    /** Agents allowed to navigate through ExpenseCurrency **/
    public static final String EXPENSECURRENCY_AGENTS = "AdminUser,OperatorUser";
    // Component role (PaymentType)
    /** <code>PaymentType</code> role id. */
    public static final String ROLE_ID_PAYMENTTYPE = "Agr_1057569177600784_Alias";
    /** <code>PaymentType</code> role name. */
    public static final String ROLE_NAME_PAYMENTTYPE = "paymentType";
    /** <code>PaymentType</code> role alias. */
    public static final String ROLE_ALIAS_PAYMENTTYPE = "Payment Type";

    /** <code>PaymentType</code> inverse role name. */
    public static final String ROLE_INVNAME_PAYMENTTYPE = PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT;
    /** <code>PaymentType</code> role facet sequence. */
    public static final String PATH_FACETS_PAYMENTTYPE = "";
    /** <code>PaymentType</code> role target class. */
    public static final String ROLE_TARGET_PAYMENTTYPE = PaymentTypeConstants.CLASS_NAME;

    /** Agents allowed to navigate through PaymentType **/
    public static final String PAYMENTTYPE_AGENTS = "AdminUser,OperatorUser";
    // Component role (Project)
    /** <code>Project</code> role id. */
    public static final String ROLE_ID_PROJECT = "Agr_1057569177600487_Alias";
    /** <code>Project</code> role name. */
    public static final String ROLE_NAME_PROJECT = "project";
    /** <code>Project</code> role alias. */
    public static final String ROLE_ALIAS_PROJECT = "Project";

    /** <code>Project</code> inverse role name. */
    public static final String ROLE_INVNAME_PROJECT = ProjectConstants.ROLE_NAME_EXPENSEREPORT;
    /** <code>Project</code> role facet sequence. */
    public static final String PATH_FACETS_PROJECT = "";
    /** <code>Project</code> role target class. */
    public static final String ROLE_TARGET_PROJECT = ProjectConstants.CLASS_NAME;

    /** Agents allowed to navigate through Project **/
    public static final String PROJECT_AGENTS = "AdminUser,OperatorUser";

    // Compound role (ExpenseLines)
    /** <code>ExpenseLines</code> role id. */
    public static final String ROLE_ID_EXPENSELINES = "Agr_1298562547712121_Alias";
    /** <code>ExpenseLines</code> role name. */
    public static final String ROLE_NAME_EXPENSELINES = "expenseLines";
    /** <code>ExpenseReport</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSELINES = "ExpenseLines";


    /** <code>ExpenseLines</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSELINES = ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT;
    /** <code>ExpenseLines</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSELINES = "";
    /** <code>ExpenseLines</code> role target class. */
    public static final String ROLE_TARGET_EXPENSELINES = ExpenseLineConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseLines **/
    public static final String EXPENSELINES_AGENTS = "AdminUser,OperatorUser";

    // Service (newexpense)
    /** <code>newexpense</code> service id. */
    public static final String SERV_ID_NEWEXPENSE = "Clas_1057569177600553Ser_1_Alias";
    /** <code>newexpense</code> service name. */
    public static final String SERV_NAME_NEWEXPENSE = "newexpense";
    /** <code>newexpense</code> service alias. */
    public static final String SERV_ALIAS_NEWEXPENSE = "Create a Expense Report";
    /** Agents allowed to execute the service newexpense **/
    public static final String NEWEXPENSE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportnewexpensepagrExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREXPENSECURRENCY = "p_agrExpenseCurrency";
    /** <code>expenseReportnewexpensepagrExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREXPENSECURRENCY = "Clas_1057569177600553Ser_1Arg_2_Alias";
    /** <code>expenseReportnewexpensepagrExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREXPENSECURRENCY = "Expense Currency";
    /** <code>expenseReportnewexpensepagrPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPAYMENTTYPE = "p_agrPaymentType";
    /** <code>expenseReportnewexpensepagrPaymentType</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPAYMENTTYPE = "Clas_1057569177600553Ser_1Arg_3_Alias";
    /** <code>expenseReportnewexpensepagrPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPAYMENTTYPE = "Payment Type";
    /** <code>expenseReportnewexpensepagrProject</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPROJECT = "p_agrProject";
    /** <code>expenseReportnewexpensepagrProject</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPROJECT = "Clas_1057569177600553Ser_1Arg_13_Alias";
    /** <code>expenseReportnewexpensepagrProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPROJECT = "Project";
    /** <code>expenseReportnewexpensepagrEmployee</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREMPLOYEE = "p_agrEmployee";
    /** <code>expenseReportnewexpensepagrEmployee</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREMPLOYEE = "Clas_1057569177600553Ser_1Arg_14_Alias";
    /** <code>expenseReportnewexpensepagrEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREMPLOYEE = "Employee";
    /** <code>expenseReportnewexpensepatrPresentDate</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRPRESENTDATE = "p_atrPresentDate";
    /** <code>expenseReportnewexpensepatrPresentDate</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRPRESENTDATE = "Clas_1057569177600553Ser_1Arg_5_Alias";
    /** <code>expenseReportnewexpensepatrPresentDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRPRESENTDATE = "Presentation Date";
    /** <code>expenseReportnewexpensepatrCause</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRCAUSE = "p_atrCause";
    /** <code>expenseReportnewexpensepatrCause</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRCAUSE = "Clas_1057569177600553Ser_1Arg_6_Alias";
    /** <code>expenseReportnewexpensepatrCause</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRCAUSE = "Cause";
    /** <code>expenseReportnewexpensepatrAdvances</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRADVANCES = "p_atrAdvances";
    /** <code>expenseReportnewexpensepatrAdvances</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRADVANCES = "Clas_1057569177600553Ser_1Arg_7_Alias";
    /** <code>expenseReportnewexpensepatrAdvances</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRADVANCES = "Advances";
    /** <code>expenseReportnewexpensepatrExchange</code> inbound argument name. */
    public static final String ARG_NAME_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATREXCHANGE = "p_atrExchange";
    /** <code>expenseReportnewexpensepatrExchange</code> inbound argument id. */
    public static final String ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATREXCHANGE = "Clas_1057569177600553Ser_1Arg_8_Alias";
    /** <code>expenseReportnewexpensepatrExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATREXCHANGE = "Exchange";
    // Service (delexpense)
    /** <code>delexpense</code> service id. */
    public static final String SERV_ID_DELEXPENSE = "Clas_1057569177600553Ser_2_Alias";
    /** <code>delexpense</code> service name. */
    public static final String SERV_NAME_DELEXPENSE = "delexpense";
    /** <code>delexpense</code> service alias. */
    public static final String SERV_ALIAS_DELEXPENSE = "Delete a expense report";
    /** Agents allowed to execute the service delexpense **/
    public static final String DELEXPENSE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportdelexpensepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_DELEXPENSE_EXPENSEREPORTDELEXPENSEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportdelexpensepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_DELEXPENSE_EXPENSEREPORTDELEXPENSEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_2Arg_1_Alias";
    /** <code>expenseReportdelexpensepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELEXPENSE_EXPENSEREPORTDELEXPENSEPTHISEXPENSEREPORT = "Expense Report";
    // Service (eclose)
    /** <code>eclose</code> service id. */
    public static final String SERV_ID_ECLOSE = "Clas_1057569177600553Ser_3_Alias";
    /** <code>eclose</code> service name. */
    public static final String SERV_NAME_ECLOSE = "eclose";
    /** <code>eclose</code> service alias. */
    public static final String SERV_ALIAS_ECLOSE = "Close a Expense Report";
    /** Agents allowed to execute the service eclose **/
    public static final String ECLOSE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReporteclosepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_ECLOSE_EXPENSEREPORTECLOSEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReporteclosepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_ECLOSE_EXPENSEREPORTECLOSEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_3Arg_1_Alias";
    /** <code>expenseReporteclosepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_ECLOSE_EXPENSEREPORTECLOSEPTHISEXPENSEREPORT = "Expense Report";
    // Service (authorize)
    /** <code>authorize</code> service id. */
    public static final String SERV_ID_AUTHORIZE = "Clas_1057569177600553Ser_4_Alias";
    /** <code>authorize</code> service name. */
    public static final String SERV_NAME_AUTHORIZE = "authorize";
    /** <code>authorize</code> service alias. */
    public static final String SERV_ALIAS_AUTHORIZE = "Mark as Authorized";
    /** Agents allowed to execute the service authorize **/
    public static final String AUTHORIZE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportauthorizepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_AUTHORIZE_EXPENSEREPORTAUTHORIZEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportauthorizepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_AUTHORIZE_EXPENSEREPORTAUTHORIZEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_4Arg_1_Alias";
    /** <code>expenseReportauthorizepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_AUTHORIZE_EXPENSEREPORTAUTHORIZEPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportauthorizepsDate</code> inbound argument name. */
    public static final String ARG_NAME_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSDATE = "ps_Date";
    /** <code>expenseReportauthorizepsDate</code> inbound argument id. */
    public static final String ARG_ID_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSDATE = "Clas_1057569177600553Ser_4Arg_2_Alias";
    /** <code>expenseReportauthorizepsDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSDATE = "Date";
    /** <code>expenseReportauthorizepsComments</code> inbound argument name. */
    public static final String ARG_NAME_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSCOMMENTS = "ps_Comments";
    /** <code>expenseReportauthorizepsComments</code> inbound argument id. */
    public static final String ARG_ID_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSCOMMENTS = "Clas_1057569177600553Ser_4Arg_3_Alias";
    /** <code>expenseReportauthorizepsComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSCOMMENTS = "Comments";
    // Service (pay)
    /** <code>pay</code> service id. */
    public static final String SERV_ID_PAY = "Clas_1057569177600553Ser_5_Alias";
    /** <code>pay</code> service name. */
    public static final String SERV_NAME_PAY = "pay";
    /** <code>pay</code> service alias. */
    public static final String SERV_ALIAS_PAY = "pay";
    /** Agents allowed to execute the service pay **/
    public static final String PAY_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportpaypthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_PAY_EXPENSEREPORTPAYPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportpaypthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_PAY_EXPENSEREPORTPAYPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_5Arg_1_Alias";
    /** <code>expenseReportpaypthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_PAY_EXPENSEREPORTPAYPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportpaypeDate</code> inbound argument name. */
    public static final String ARG_NAME_PAY_EXPENSEREPORTPAYPEDATE = "pe_Date";
    /** <code>expenseReportpaypeDate</code> inbound argument id. */
    public static final String ARG_ID_PAY_EXPENSEREPORTPAYPEDATE = "Clas_1057569177600553Ser_5Arg_2_Alias";
    /** <code>expenseReportpaypeDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_PAY_EXPENSEREPORTPAYPEDATE = "Payment Date";
    /** <code>expenseReportpaypsComments</code> inbound argument name. */
    public static final String ARG_NAME_PAY_EXPENSEREPORTPAYPSCOMMENTS = "ps_Comments";
    /** <code>expenseReportpaypsComments</code> inbound argument id. */
    public static final String ARG_ID_PAY_EXPENSEREPORTPAYPSCOMMENTS = "Clas_1057569177600553Ser_5Arg_3_Alias";
    /** <code>expenseReportpaypsComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_PAY_EXPENSEREPORTPAYPSCOMMENTS = "Comments";
    // Service (rejectautho)
    /** <code>rejectautho</code> service id. */
    public static final String SERV_ID_REJECTAUTHO = "Clas_1057569177600553Ser_6_Alias";
    /** <code>rejectautho</code> service name. */
    public static final String SERV_NAME_REJECTAUTHO = "rejectautho";
    /** <code>rejectautho</code> service alias. */
    public static final String SERV_ALIAS_REJECTAUTHO = "Reject Auhorization";
    /** Agents allowed to execute the service rejectautho **/
    public static final String REJECTAUTHO_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>rejectautho</code> precondition 0 id. */
    public static final String PRE_ID_REJECTAUTHO_0 = "Clas_1057569177600553Pre_1_MsgError";
    // Inbound arguments
    /** <code>expenseReportrejectauthopthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportrejectauthopthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_6Arg_1_Alias";
    /** <code>expenseReportrejectauthopthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportrejectauthopeComments</code> inbound argument name. */
    public static final String ARG_NAME_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPECOMMENTS = "pe_Comments";
    /** <code>expenseReportrejectauthopeComments</code> inbound argument id. */
    public static final String ARG_ID_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPECOMMENTS = "Clas_1057569177600553Ser_6Arg_2_Alias";
    /** <code>expenseReportrejectauthopeComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPECOMMENTS = "Comments";
    // Service (rejectpayment)
    /** <code>rejectpayment</code> service id. */
    public static final String SERV_ID_REJECTPAYMENT = "Clas_1057569177600553Ser_7_Alias";
    /** <code>rejectpayment</code> service name. */
    public static final String SERV_NAME_REJECTPAYMENT = "rejectpayment";
    /** <code>rejectpayment</code> service alias. */
    public static final String SERV_ALIAS_REJECTPAYMENT = "Reject Payment";
    /** Agents allowed to execute the service rejectpayment **/
    public static final String REJECTPAYMENT_SRVAGENTS = "";
    // Preconditions
    /** <code>rejectpayment</code> precondition 0 id. */
    public static final String PRE_ID_REJECTPAYMENT_0 = "Clas_1057569177600553Pre_2_MsgError";
    // Inbound arguments
    /** <code>expenseReportrejectpaymentpthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportrejectpaymentpthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_7Arg_1_Alias";
    /** <code>expenseReportrejectpaymentpthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportrejectpaymentpeComments</code> inbound argument name. */
    public static final String ARG_NAME_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPECOMMENTS = "pe_Comments";
    /** <code>expenseReportrejectpaymentpeComments</code> inbound argument id. */
    public static final String ARG_ID_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPECOMMENTS = "Clas_1057569177600553Ser_7Arg_2_Alias";
    /** <code>expenseReportrejectpaymentpeComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPECOMMENTS = "Comments";
    // Service (InsPaymentType)
    /** <code>InsPaymentType</code> service id. */
    public static final String SERV_ID_INSPAYMENTTYPE = "Clas_1057569177600553Ser_8_Alias";
    /** <code>InsPaymentType</code> service name. */
    public static final String SERV_NAME_INSPAYMENTTYPE = "InsPaymentType";
    /** <code>InsPaymentType</code> service alias. */
    public static final String SERV_ALIAS_INSPAYMENTTYPE = "InsPaymentType";
    /** Agents allowed to execute the service InsPaymentType **/
    public static final String INSPAYMENTTYPE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportInsPaymentTypepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportInsPaymentTypepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_8Arg_1_Alias";
    /** <code>expenseReportInsPaymentTypepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportInsPaymentTypepevcPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPEVCPAYMENTTYPE = "p_evcPaymentType";
    /** <code>expenseReportInsPaymentTypepevcPaymentType</code> inbound argument id. */
    public static final String ARG_ID_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPEVCPAYMENTTYPE = "Clas_1057569177600553Ser_8Arg_2_Alias";
    /** <code>expenseReportInsPaymentTypepevcPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPEVCPAYMENTTYPE = "Payment Type";
    // Service (DelPaymentType)
    /** <code>DelPaymentType</code> service id. */
    public static final String SERV_ID_DELPAYMENTTYPE = "Clas_1057569177600553Ser_9_Alias";
    /** <code>DelPaymentType</code> service name. */
    public static final String SERV_NAME_DELPAYMENTTYPE = "DelPaymentType";
    /** <code>DelPaymentType</code> service alias. */
    public static final String SERV_ALIAS_DELPAYMENTTYPE = "DelPaymentType";
    /** Agents allowed to execute the service DelPaymentType **/
    public static final String DELPAYMENTTYPE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportDelPaymentTypepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportDelPaymentTypepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_9Arg_1_Alias";
    /** <code>expenseReportDelPaymentTypepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportDelPaymentTypepevcPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPEVCPAYMENTTYPE = "p_evcPaymentType";
    /** <code>expenseReportDelPaymentTypepevcPaymentType</code> inbound argument id. */
    public static final String ARG_ID_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPEVCPAYMENTTYPE = "Clas_1057569177600553Ser_9Arg_2_Alias";
    /** <code>expenseReportDelPaymentTypepevcPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPEVCPAYMENTTYPE = "Payment Type";
    // Service (cancelapprove)
    /** <code>cancelapprove</code> service id. */
    public static final String SERV_ID_CANCELAPPROVE = "Clas_1057569177600553Ser_10_Alias";
    /** <code>cancelapprove</code> service name. */
    public static final String SERV_NAME_CANCELAPPROVE = "cancelapprove";
    /** <code>cancelapprove</code> service alias. */
    public static final String SERV_ALIAS_CANCELAPPROVE = "Cancel Approval";
    /** Agents allowed to execute the service cancelapprove **/
    public static final String CANCELAPPROVE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportcancelapprovepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_CANCELAPPROVE_EXPENSEREPORTCANCELAPPROVEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportcancelapprovepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_CANCELAPPROVE_EXPENSEREPORTCANCELAPPROVEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_10Arg_1_Alias";
    /** <code>expenseReportcancelapprovepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_CANCELAPPROVE_EXPENSEREPORTCANCELAPPROVEPTHISEXPENSEREPORT = "Expense Report";
    // Service (approve)
    /** <code>approve</code> service id. */
    public static final String SERV_ID_APPROVE = "Clas_1057569177600553Ser_11_Alias";
    /** <code>approve</code> service name. */
    public static final String SERV_NAME_APPROVE = "approve";
    /** <code>approve</code> service alias. */
    public static final String SERV_ALIAS_APPROVE = "Mark as Approved";
    /** Agents allowed to execute the service approve **/
    public static final String APPROVE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportapprovepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_APPROVE_EXPENSEREPORTAPPROVEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportapprovepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_APPROVE_EXPENSEREPORTAPPROVEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_11Arg_1_Alias";
    /** <code>expenseReportapprovepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_APPROVE_EXPENSEREPORTAPPROVEPTHISEXPENSEREPORT = "Expense Report";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600553Ser_12_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "edit_instance";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReporteditinstancepthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReporteditinstancepthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_12Arg_1_Alias";
    /** <code>expenseReporteditinstancepthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReporteditinstancepCause</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPCAUSE = "p_Cause";
    /** <code>expenseReporteditinstancepCause</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPCAUSE = "Clas_1057569177600553Ser_12Arg_2_Alias";
    /** <code>expenseReporteditinstancepCause</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPCAUSE = "Cause";
    /** <code>expenseReporteditinstancepAdvances</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPADVANCES = "p_Advances";
    /** <code>expenseReporteditinstancepAdvances</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPADVANCES = "Clas_1057569177600553Ser_12Arg_3_Alias";
    /** <code>expenseReporteditinstancepAdvances</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPADVANCES = "Advances";
    /** <code>expenseReporteditinstancepExchange</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPEXCHANGE = "p_Exchange";
    /** <code>expenseReporteditinstancepExchange</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPEXCHANGE = "Clas_1057569177600553Ser_12Arg_4_Alias";
    /** <code>expenseReporteditinstancepExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPEXCHANGE = "Exchange";
    // Service (dummy)
    /** <code>dummy</code> service id. */
    public static final String SERV_ID_DUMMY = "Clas_1057569177600553Ser_19_Alias";
    /** <code>dummy</code> service name. */
    public static final String SERV_NAME_DUMMY = "dummy";
    /** <code>dummy</code> service alias. */
    public static final String SERV_ALIAS_DUMMY = "dummy";
    /** Agents allowed to execute the service dummy **/
    public static final String DUMMY_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseReportdummypthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_DUMMY_EXPENSEREPORTDUMMYPTHISEXPENSEREPORT = "p_thisExpenseReport";
    /** <code>expenseReportdummypthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_DUMMY_EXPENSEREPORTDUMMYPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_19Arg_1_Alias";
    /** <code>expenseReportdummypthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_DUMMY_EXPENSEREPORTDUMMYPTHISEXPENSEREPORT = "Expense Report";
    // Outbound arguments
    /** <code>expenseReportdummypsResultCode</code> outbound argument name. */
    public static final String ARG_NAME_DUMMY_EXPENSEREPORTDUMMYPSRESULTCODE = "expenseReportdummypsResultCode";
    /** <code>expenseReportdummypsResultCode</code> outbound argument id. */
    public static final String ARG_ID_DUMMY_EXPENSEREPORTDUMMYPSRESULTCODE = "Clas_1057569177600553Ser_19Arg_2_Alias";
    /** <code>expenseReportdummypsResultCode</code> outbound argument alias. */
    public static final String ARG_ALIAS_DUMMY_EXPENSEREPORTDUMMYPSRESULTCODE = "Result Code";
    // Service (DELETEALL)
    /** <code>DELETEALL</code> service id. */
    public static final String SERV_ID_DELETEALL = "Clas_1057569177600553Ser_13_Alias";
    /** <code>DELETEALL</code> service name. */
    public static final String SERV_NAME_DELETEALL = "DELETEALL";
    /** <code>DELETEALL</code> service alias. */
    public static final String SERV_ALIAS_DELETEALL = "Delete an Expense Report";
    /** Agents allowed to execute the service DELETEALL **/
    public static final String DELETEALL_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportDELETEALLptpthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_DELETEALL_EXPENSEREPORTDELETEALLPTPTHISEXPENSEREPORT = "pt_p_thisExpenseReport";
    /** <code>expenseReportDELETEALLptpthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_DELETEALL_EXPENSEREPORTDELETEALLPTPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_13Arg_1_Alias";
    /** <code>expenseReportDELETEALLptpthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEALL_EXPENSEREPORTDELETEALLPTPTHISEXPENSEREPORT = "Expense Report";
    // Service (TPAY)
    /** <code>TPAY</code> service id. */
    public static final String SERV_ID_TPAY = "Clas_1057569177600553Ser_14_Alias";
    /** <code>TPAY</code> service name. */
    public static final String SERV_NAME_TPAY = "TPAY";
    /** <code>TPAY</code> service alias. */
    public static final String SERV_ALIAS_TPAY = "Mark as Paid";
    /** Agents allowed to execute the service TPAY **/
    public static final String TPAY_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportTPAYptpeDate</code> inbound argument name. */
    public static final String ARG_NAME_TPAY_EXPENSEREPORTTPAYPTPEDATE = "pt_pe_Date";
    /** <code>expenseReportTPAYptpeDate</code> inbound argument id. */
    public static final String ARG_ID_TPAY_EXPENSEREPORTTPAYPTPEDATE = "Clas_1057569177600553Ser_14Arg_1_Alias";
    /** <code>expenseReportTPAYptpeDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPTPEDATE = "Payment Date";
    /** <code>expenseReportTPAYpsPayType</code> inbound argument name. */
    public static final String ARG_NAME_TPAY_EXPENSEREPORTTPAYPSPAYTYPE = "ps_PayType";
    /** <code>expenseReportTPAYpsPayType</code> inbound argument id. */
    public static final String ARG_ID_TPAY_EXPENSEREPORTTPAYPSPAYTYPE = "Clas_1057569177600553Ser_14Arg_2_Alias";
    /** <code>expenseReportTPAYpsPayType</code> inbound argument alias. */
    public static final String ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPSPAYTYPE = "Payment Type";
    /** <code>expenseReportTPAYptpthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_TPAY_EXPENSEREPORTTPAYPTPTHISEXPENSEREPORT = "pt_p_thisExpenseReport";
    /** <code>expenseReportTPAYptpthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_TPAY_EXPENSEREPORTTPAYPTPTHISEXPENSEREPORT = "Clas_1057569177600553Ser_14Arg_3_Alias";
    /** <code>expenseReportTPAYptpthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPTPTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportTPAYpsComments</code> inbound argument name. */
    public static final String ARG_NAME_TPAY_EXPENSEREPORTTPAYPSCOMMENTS = "ps_Comments";
    /** <code>expenseReportTPAYpsComments</code> inbound argument id. */
    public static final String ARG_ID_TPAY_EXPENSEREPORTTPAYPSCOMMENTS = "Clas_1057569177600553Ser_14Arg_4_Alias";
    /** <code>expenseReportTPAYpsComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPSCOMMENTS = "Comments";
    // Service (TNEW)
    /** <code>TNEW</code> service id. */
    public static final String SERV_ID_TNEW = "Clas_1057569177600553Ser_15_Alias";
    /** <code>TNEW</code> service name. */
    public static final String SERV_NAME_TNEW = "TNEW";
    /** <code>TNEW</code> service alias. */
    public static final String SERV_ALIAS_TNEW = "New Expense Report";
    /** Agents allowed to execute the service TNEW **/
    public static final String TNEW_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>TNEW</code> precondition 0 id. */
    public static final String PRE_ID_TNEW_0 = "Clas_1057569177600553Pre_4_MsgError";
    /** <code>TNEW</code> precondition 1 id. */
    public static final String PRE_ID_TNEW_1 = "Clas_1057569177600553Pre_6_MsgError";
    // Inbound arguments
    /** <code>expenseReportTNEWptpagrEmployee</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE = "pt_p_agrEmployee";
    /** <code>expenseReportTNEWptpagrEmployee</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE = "Clas_1057569177600553Ser_15Arg_1_Alias";
    /** <code>expenseReportTNEWptpagrEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE = "Employee";
    /** <code>expenseReportTNEWptpagrExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY = "pt_p_agrExpenseCurrency";
    /** <code>expenseReportTNEWptpagrExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY = "Clas_1057569177600553Ser_15Arg_2_Alias";
    /** <code>expenseReportTNEWptpagrExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY = "Expense Currency";
    /** <code>expenseReportTNEWptpagrProject</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT = "pt_p_agrProject";
    /** <code>expenseReportTNEWptpagrProject</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT = "Clas_1057569177600553Ser_15Arg_3_Alias";
    /** <code>expenseReportTNEWptpagrProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT = "Project";
    /** <code>expenseReportTNEWptpatrPresentDate</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE = "pt_p_atrPresentDate";
    /** <code>expenseReportTNEWptpatrPresentDate</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE = "Clas_1057569177600553Ser_15Arg_4_Alias";
    /** <code>expenseReportTNEWptpatrPresentDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE = "Presentation Date";
    /** <code>expenseReportTNEWptpatrCause</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE = "pt_p_atrCause";
    /** <code>expenseReportTNEWptpatrCause</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE = "Clas_1057569177600553Ser_15Arg_5_Alias";
    /** <code>expenseReportTNEWptpatrCause</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE = "Cause";
    /** <code>expenseReportTNEWptpatrAdvances</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES = "pt_p_atrAdvances";
    /** <code>expenseReportTNEWptpatrAdvances</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES = "Clas_1057569177600553Ser_15Arg_6_Alias";
    /** <code>expenseReportTNEWptpatrAdvances</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES = "Advance";
    // Outbound arguments
    /** <code>expenseReportTNEWnewExpenseReport</code> outbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSEREPORTTNEWNEWEXPENSEREPORT = "expenseReportTNEWnewExpenseReport";
    /** <code>expenseReportTNEWnewExpenseReport</code> outbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSEREPORTTNEWNEWEXPENSEREPORT = "Clas_1057569177600553Ser_15Arg_207_Alias";
    /** <code>expenseReportTNEWnewExpenseReport</code> outbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSEREPORTTNEWNEWEXPENSEREPORT = "Expense Report";
    // Service (TREJECTPAYMENT)
    /** <code>TREJECTPAYMENT</code> service id. */
    public static final String SERV_ID_TREJECTPAYMENT = "Clas_1057569177600553Ser_16_Alias";
    /** <code>TREJECTPAYMENT</code> service name. */
    public static final String SERV_NAME_TREJECTPAYMENT = "TREJECTPAYMENT";
    /** <code>TREJECTPAYMENT</code> service alias. */
    public static final String SERV_ALIAS_TREJECTPAYMENT = "Reject Payment";
    /** Agents allowed to execute the service TREJECTPAYMENT **/
    public static final String TREJECTPAYMENT_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>expenseReportTREJECTPAYMENTptthisExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTTHISEXPENSEREPORT = "pt_thisExpenseReport";
    /** <code>expenseReportTREJECTPAYMENTptthisExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTTHISEXPENSEREPORT = "Clas_1057569177600553Ser_16Arg_2_Alias";
    /** <code>expenseReportTREJECTPAYMENTptthisExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTTHISEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportTREJECTPAYMENTptPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTPAYMENTTYPE = "pt_PaymentType";
    /** <code>expenseReportTREJECTPAYMENTptPaymentType</code> inbound argument id. */
    public static final String ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTPAYMENTTYPE = "Clas_1057569177600553Ser_16Arg_3_Alias";
    /** <code>expenseReportTREJECTPAYMENTptPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTPAYMENTTYPE = "Payment Type";
    /** <code>expenseReportTREJECTPAYMENTptComments</code> inbound argument name. */
    public static final String ARG_NAME_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTCOMMENTS = "pt_Comments";
    /** <code>expenseReportTREJECTPAYMENTptComments</code> inbound argument id. */
    public static final String ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTCOMMENTS = "Clas_1057569177600553Ser_16Arg_4_Alias";
    /** <code>expenseReportTREJECTPAYMENTptComments</code> inbound argument alias. */
    public static final String ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTCOMMENTS = "Comments";
    // Service (TNEWFROMTEMPLATE)
    /** <code>TNEWFROMTEMPLATE</code> service id. */
    public static final String SERV_ID_TNEWFROMTEMPLATE = "Clas_1057569177600553Ser_20_Alias";
    /** <code>TNEWFROMTEMPLATE</code> service name. */
    public static final String SERV_NAME_TNEWFROMTEMPLATE = "TNEWFROMTEMPLATE";
    /** <code>TNEWFROMTEMPLATE</code> service alias. */
    public static final String SERV_ALIAS_TNEWFROMTEMPLATE = "New Expense Report from Template";
    /** Agents allowed to execute the service TNEWFROMTEMPLATE **/
    public static final String TNEWFROMTEMPLATE_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>TNEWFROMTEMPLATE</code> precondition 0 id. */
    public static final String PRE_ID_TNEWFROMTEMPLATE_0 = "Clas_1057569177600553Pre_7_MsgError";
    /** <code>TNEWFROMTEMPLATE</code> precondition 1 id. */
    public static final String PRE_ID_TNEWFROMTEMPLATE_1 = "Clas_1057569177600553Pre_8_MsgError";
    /** <code>TNEWFROMTEMPLATE</code> precondition 2 id. */
    public static final String PRE_ID_TNEWFROMTEMPLATE_2 = "Clas_1057569177600553Pre_9_MsgError";
    // Inbound arguments
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrEmployee</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE = "pt_p_agrEmployee";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrEmployee</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE = "Clas_1057569177600553Ser_20Arg_2_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE = "Employee";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY = "pt_p_agrExpenseCurrency";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY = "Clas_1057569177600553Ser_20Arg_3_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY = "Expense Currency";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrProject</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT = "pt_p_agrProject";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrProject</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT = "Clas_1057569177600553Ser_20Arg_4_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpagrProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT = "Project";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrPresentDate</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE = "pt_p_atrPresentDate";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrPresentDate</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE = "Clas_1057569177600553Ser_20Arg_5_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrPresentDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE = "Presentation Date";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrCause</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE = "pt_p_atrCause";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrCause</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE = "Clas_1057569177600553Ser_20Arg_6_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrCause</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE = "Cause";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrAdvances</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES = "pt_p_atrAdvances";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrAdvances</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES = "Clas_1057569177600553Ser_20Arg_7_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEptpatrAdvances</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES = "Advance";
    /** <code>expenseReportTNEWFROMTEMPLATEpTemplate</code> inbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE = "pTemplate";
    /** <code>expenseReportTNEWFROMTEMPLATEpTemplate</code> inbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE = "Clas_1057569177600553Ser_20Arg_9_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEpTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE = "Expense Report Template";
    // Outbound arguments
    /** <code>expenseReportTNEWFROMTEMPLATEnewExpenseReport</code> outbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATENEWEXPENSEREPORT = "expenseReportTNEWFROMTEMPLATEnewExpenseReport";
    /** <code>expenseReportTNEWFROMTEMPLATEnewExpenseReport</code> outbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATENEWEXPENSEREPORT = "Clas_1057569177600553Ser_20Arg_8_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEnewExpenseReport</code> outbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATENEWEXPENSEREPORT = "Expense Report";
    /** <code>expenseReportTNEWFROMTEMPLATEpsNumberOfLines</code> outbound argument name. */
    public static final String ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPSNUMBEROFLINES = "expenseReportTNEWFROMTEMPLATEpsNumberOfLines";
    /** <code>expenseReportTNEWFROMTEMPLATEpsNumberOfLines</code> outbound argument id. */
    public static final String ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPSNUMBEROFLINES = "Clas_1057569177600553Ser_20Arg_73_Alias";
    /** <code>expenseReportTNEWFROMTEMPLATEpsNumberOfLines</code> outbound argument alias. */
    public static final String ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPSNUMBEROFLINES = "Number of Lines";

    public static final String FILTER_NAME_FEXPENSEREPORTAMOUNT = "F_ExpenseReportAmount";
    public static final String VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT = "v_Amount";
    public static final String FILTER_NAME_FEXPENSEREPORTDATES = "F_ExpenseReportDates";
    public static final String VAR_NAME_FEXPENSEREPORTDATES_VINIDATE = "v_IniDate";
    public static final String VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE = "v_FinalDate";
    public static final String FILTER_NAME_FEXPENSEREPORTSTATUS = "F_ExpenseReportStatus";
    public static final String VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS = "v_Status";
    public static final String FILTER_NAME_FBYPROJECT = "F_ByProject";
    public static final String VAR_NAME_FBYPROJECT_VFPROJECT = "vf_Project";
    public static final String FILTER_NAME_FBYID = "F_ByID";
    public static final String VAR_NAME_FBYID_VID = "v_ID";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTPRESENTDATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTSTATUS.toUpperCase(), Constants.Type.INT.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTCAUSE.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTAUTHODATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTAUTHOCOMMENTS.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTPAYMENTDATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTPAYCOMMENTS.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTTOTEXPENSES.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTTOTEXPENSESCUR.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTADVANCES.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTADVANCESCUR.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTEXCHANGE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTBALANCE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSEREPORTBALANCECUR.toUpperCase(), Constants.Type.REAL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR.toUpperCase(), EXPENSEREPORTIDEXPENSEREPOR_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTPRESENTDATE.toUpperCase(), EXPENSEREPORTPRESENTDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTSTATUS.toUpperCase(), EXPENSEREPORTSTATUS_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTCAUSE.toUpperCase(), EXPENSEREPORTCAUSE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTAUTHODATE.toUpperCase(), EXPENSEREPORTAUTHODATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTAUTHOCOMMENTS.toUpperCase(), EXPENSEREPORTAUTHOCOMMENTS_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTPAYMENTDATE.toUpperCase(), EXPENSEREPORTPAYMENTDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTPAYCOMMENTS.toUpperCase(), EXPENSEREPORTPAYCOMMENTS_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTTOTEXPENSES.toUpperCase(), EXPENSEREPORTTOTEXPENSES_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTTOTEXPENSESCUR.toUpperCase(), EXPENSEREPORTTOTEXPENSESCUR_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTADVANCES.toUpperCase(), EXPENSEREPORTADVANCES_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTADVANCESCUR.toUpperCase(), EXPENSEREPORTADVANCESCUR_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTEXCHANGE.toUpperCase(), EXPENSEREPORTEXCHANGE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTBALANCE.toUpperCase(), EXPENSEREPORTBALANCE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSEREPORTBALANCECUR.toUpperCase(), EXPENSEREPORTBALANCECUR_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_EMPLOYEE.toUpperCase(), EMPLOYEE_AGENTS);
        roleAgents.put(ROLE_NAME_EXPENSECURRENCY.toUpperCase(), EXPENSECURRENCY_AGENTS);
        roleAgents.put(ROLE_NAME_PAYMENTTYPE.toUpperCase(), PAYMENTTYPE_AGENTS);
        roleAgents.put(ROLE_NAME_PROJECT.toUpperCase(), PROJECT_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ExpenseReport', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ExpenseReport', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR);
        }
        // Facet 'ExpenseReport' (This facet)
        if (ExpenseReportConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR);
        }
        return returnList;
    }
}
