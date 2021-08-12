package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ExpenseCurrency</code> model class.
 */
public final class ExpenseCurrencyConstants {

    private ExpenseCurrencyConstants() {

    }

    // Class
    /** <code>ExpenseCurrency</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600792_Alias";
    /** <code>ExpenseCurrency</code> class name. */
    public static final String CLASS_NAME = "ExpenseCurrency";
    /** <code>ExpenseCurrency</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Currency";
    /** <code>ExpenseCurrency</code> class table name. */
    public static final String TBL_NAME = "ExpenseCurrency";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "expenseCurrencyCurrencyCode,expenseCurrencyCurrencyName,expenseCurrencyCurAcronym,expenseCurrencyExchange";

    public static final String DSDSEXPENSECURRENCY = "DS_ExpenseCurrency";
    public static final String DSDSEXPENSECURRENCYSUP = "DS_ExpenseCurrencySup";
    

    // Attribute (expenseCurrencyCurrencyCode)
    /** <code>expenseCurrencyCurrencyCode</code> attribute id. */
    public static final String ATTR_ID_EXPENSECURRENCYCURRENCYCODE = "Clas_1057569177600792Atr_2_Alias";
    /** <code>expenseCurrencyCurrencyCode</code> attribute name. */
    public static final String ATTR_NAME_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
    /** <code>expenseCurrencyCurrencyCode</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSECURRENCYCURRENCYCODE = "Currency Code";

    /** <code>expenseCurrencyCurrencyCode</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCYCURRENCYCODE = "";
    /** Agents allowed to view the attribute expenseCurrencyCurrencyCode **/
    public static final String EXPENSECURRENCYCURRENCYCODE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseCurrencyCurrencyName)
    /** <code>expenseCurrencyCurrencyName</code> attribute id. */
    public static final String ATTR_ID_EXPENSECURRENCYCURRENCYNAME = "Clas_1057569177600792Atr_1_Alias";
    /** <code>expenseCurrencyCurrencyName</code> attribute name. */
    public static final String ATTR_NAME_EXPENSECURRENCYCURRENCYNAME = "expenseCurrencyCurrencyName";
    /** <code>expenseCurrencyCurrencyName</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSECURRENCYCURRENCYNAME = "Name";

    /** <code>expenseCurrencyCurrencyName</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCYCURRENCYNAME = "";
    /** Agents allowed to view the attribute expenseCurrencyCurrencyName **/
    public static final String EXPENSECURRENCYCURRENCYNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseCurrencyCurAcronym)
    /** <code>expenseCurrencyCurAcronym</code> attribute id. */
    public static final String ATTR_ID_EXPENSECURRENCYCURACRONYM = "Clas_1057569177600792Atr_3_Alias";
    /** <code>expenseCurrencyCurAcronym</code> attribute name. */
    public static final String ATTR_NAME_EXPENSECURRENCYCURACRONYM = "expenseCurrencyCurAcronym";
    /** <code>expenseCurrencyCurAcronym</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSECURRENCYCURACRONYM = "Acronym";

    /** <code>expenseCurrencyCurAcronym</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCYCURACRONYM = "";
    /** Agents allowed to view the attribute expenseCurrencyCurAcronym **/
    public static final String EXPENSECURRENCYCURACRONYM_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseCurrencyExchange)
    /** <code>expenseCurrencyExchange</code> attribute id. */
    public static final String ATTR_ID_EXPENSECURRENCYEXCHANGE = "Clas_1057569177600792Atr_4_Alias";
    /** <code>expenseCurrencyExchange</code> attribute name. */
    public static final String ATTR_NAME_EXPENSECURRENCYEXCHANGE = "expenseCurrencyExchange";
    /** <code>expenseCurrencyExchange</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSECURRENCYEXCHANGE = "Exchange";

    /** <code>expenseCurrencyExchange</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCYEXCHANGE = "";
    /** Agents allowed to view the attribute expenseCurrencyExchange **/
    public static final String EXPENSECURRENCYEXCHANGE_AGENTS = "AdminUser,OperatorUser";


    // Field (CurrencyCode)
    /** <code>CurrencyCode</code> field name. */
    public static final String FLD_EXPENSECURRENCYCURRENCYCODE = "CurrencyCode";    
    /** <code>CurrencyCode</code> field length. */
    public static final int FLD_EXPENSECURRENCYCURRENCYCODELENGTH = 5;
    /** <code>expenseCurrencyCurrencyCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
    // Field (CurrencyName)
    /** <code>CurrencyName</code> field name. */
    public static final String FLD_EXPENSECURRENCYCURRENCYNAME = "CurrencyName";    
    /** <code>CurrencyName</code> field length. */
    public static final int FLD_EXPENSECURRENCYCURRENCYNAMELENGTH = 25;
    /** <code>expenseCurrencyCurrencyName</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCYCURRENCYNAME = "expenseCurrencyCurrencyName";
    // Field (CurAcronym)
    /** <code>CurAcronym</code> field name. */
    public static final String FLD_EXPENSECURRENCYCURACRONYM = "CurAcronym";    
    /** <code>CurAcronym</code> field length. */
    public static final int FLD_EXPENSECURRENCYCURACRONYMLENGTH = 5;
    /** <code>expenseCurrencyCurAcronym</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCYCURACRONYM = "expenseCurrencyCurAcronym";
    // Field (Exchange)
    /** <code>Exchange</code> field name. */
    public static final String FLD_EXPENSECURRENCYEXCHANGE = "Exchange";    
    /** <code>expenseCurrencyExchange</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCYEXCHANGE = "expenseCurrencyExchange";


    // Compound role (ExpenseReports)
    /** <code>ExpenseReports</code> role id. */
    public static final String ROLE_ID_EXPENSEREPORTS = "Agr_1057569177600778_Alias";
    /** <code>ExpenseReports</code> role name. */
    public static final String ROLE_NAME_EXPENSEREPORTS = "expenseReports";
    /** <code>ExpenseCurrency</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSEREPORTS = "Expense Reports";


    /** <code>ExpenseReports</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSEREPORTS = ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY;
    /** <code>ExpenseReports</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORTS = "";
    /** <code>ExpenseReports</code> role target class. */
    public static final String ROLE_TARGET_EXPENSEREPORTS = ExpenseReportConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseReports **/
    public static final String EXPENSEREPORTS_AGENTS = "AdminUser,OperatorUser";
    // Compound role (ExchangeHistoryItems)
    /** <code>ExchangeHistoryItems</code> role id. */
    public static final String ROLE_ID_EXCHANGEHISTORYITEMS = "Agr_1622465314816174_Alias";
    /** <code>ExchangeHistoryItems</code> role name. */
    public static final String ROLE_NAME_EXCHANGEHISTORYITEMS = "exchangeHistoryItems";
    /** <code>ExpenseCurrency</code> role alias. */
    public static final String ROLE_ALIAS_EXCHANGEHISTORYITEMS = "ExchangeHistoryItems";


    /** <code>ExchangeHistoryItems</code> inverse role name. */
    public static final String ROLE_INVNAME_EXCHANGEHISTORYITEMS = ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY;
    /** <code>ExchangeHistoryItems</code> role facet sequence. */
    public static final String PATH_FACETS_EXCHANGEHISTORYITEMS = "";
    /** <code>ExchangeHistoryItems</code> role target class. */
    public static final String ROLE_TARGET_EXCHANGEHISTORYITEMS = ExchangeHistoryConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExchangeHistoryItems **/
    public static final String EXCHANGEHISTORYITEMS_AGENTS = "AdminUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1057569177600792Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencycreateinstancepatrCurrencyName</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYNAME = "p_atrCurrencyName";
    /** <code>expenseCurrencycreateinstancepatrCurrencyName</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYNAME = "Clas_1057569177600792Ser_1Arg_1_Alias";
    /** <code>expenseCurrencycreateinstancepatrCurrencyName</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYNAME = "Name";
    /** <code>expenseCurrencycreateinstancepatrCurrencyCode</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYCODE = "p_atrCurrencyCode";
    /** <code>expenseCurrencycreateinstancepatrCurrencyCode</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYCODE = "Clas_1057569177600792Ser_1Arg_2_Alias";
    /** <code>expenseCurrencycreateinstancepatrCurrencyCode</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYCODE = "Currency Code";
    /** <code>expenseCurrencycreateinstancepatrCurAcronym</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURACRONYM = "p_atrCurAcronym";
    /** <code>expenseCurrencycreateinstancepatrCurAcronym</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURACRONYM = "Clas_1057569177600792Ser_1Arg_3_Alias";
    /** <code>expenseCurrencycreateinstancepatrCurAcronym</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURACRONYM = "Acronym";
    /** <code>expenseCurrencycreateinstancepatrExchange</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATREXCHANGE = "p_atrExchange";
    /** <code>expenseCurrencycreateinstancepatrExchange</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATREXCHANGE = "Clas_1057569177600792Ser_1Arg_4_Alias";
    /** <code>expenseCurrencycreateinstancepatrExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATREXCHANGE = "Exchange";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1057569177600792Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencydeleteinstancepthisExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_EXPENSECURRENCYDELETEINSTANCEPTHISEXPENSECURRENCY = "p_thisExpenseCurrency";
    /** <code>expenseCurrencydeleteinstancepthisExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_EXPENSECURRENCYDELETEINSTANCEPTHISEXPENSECURRENCY = "Clas_1057569177600792Ser_2Arg_1_Alias";
    /** <code>expenseCurrencydeleteinstancepthisExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_EXPENSECURRENCYDELETEINSTANCEPTHISEXPENSECURRENCY = "Expense Currency";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600792Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencyeditinstancepthisExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPTHISEXPENSECURRENCY = "p_thisExpenseCurrency";
    /** <code>expenseCurrencyeditinstancepthisExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPTHISEXPENSECURRENCY = "Clas_1057569177600792Ser_3Arg_1_Alias";
    /** <code>expenseCurrencyeditinstancepthisExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPTHISEXPENSECURRENCY = "Expense Currency";
    /** <code>expenseCurrencyeditinstancepCurrencyName</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURRENCYNAME = "p_CurrencyName";
    /** <code>expenseCurrencyeditinstancepCurrencyName</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURRENCYNAME = "Clas_1057569177600792Ser_3Arg_2_Alias";
    /** <code>expenseCurrencyeditinstancepCurrencyName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURRENCYNAME = "Name";
    /** <code>expenseCurrencyeditinstancepCurAcronym</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURACRONYM = "p_CurAcronym";
    /** <code>expenseCurrencyeditinstancepCurAcronym</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURACRONYM = "Clas_1057569177600792Ser_3Arg_3_Alias";
    /** <code>expenseCurrencyeditinstancepCurAcronym</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURACRONYM = "Acronym";
    /** <code>expenseCurrencyeditinstancepExchange</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPEXCHANGE = "p_Exchange";
    /** <code>expenseCurrencyeditinstancepExchange</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPEXCHANGE = "Clas_1057569177600792Ser_3Arg_4_Alias";
    /** <code>expenseCurrencyeditinstancepExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPEXCHANGE = "Exchange";
    // Service (resetExchange)
    /** <code>resetExchange</code> service id. */
    public static final String SERV_ID_RESETEXCHANGE = "Clas_1057569177600792Ser_5_Alias";
    /** <code>resetExchange</code> service name. */
    public static final String SERV_NAME_RESETEXCHANGE = "resetExchange";
    /** <code>resetExchange</code> service alias. */
    public static final String SERV_ALIAS_RESETEXCHANGE = "Reset exchange";
    /** Agents allowed to execute the service resetExchange **/
    public static final String RESETEXCHANGE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencyresetExchangepthisExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_RESETEXCHANGE_EXPENSECURRENCYRESETEXCHANGEPTHISEXPENSECURRENCY = "p_thisExpenseCurrency";
    /** <code>expenseCurrencyresetExchangepthisExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_RESETEXCHANGE_EXPENSECURRENCYRESETEXCHANGEPTHISEXPENSECURRENCY = "Clas_1057569177600792Ser_5Arg_1_Alias";
    /** <code>expenseCurrencyresetExchangepthisExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_RESETEXCHANGE_EXPENSECURRENCYRESETEXCHANGEPTHISEXPENSECURRENCY = "Expense Currency";
    // Service (editExchange)
    /** <code>editExchange</code> service id. */
    public static final String SERV_ID_EDITEXCHANGE = "Clas_1057569177600792Ser_6_Alias";
    /** <code>editExchange</code> service name. */
    public static final String SERV_NAME_EDITEXCHANGE = "editExchange";
    /** <code>editExchange</code> service alias. */
    public static final String SERV_ALIAS_EDITEXCHANGE = "Update exchange";
    /** Agents allowed to execute the service editExchange **/
    public static final String EDITEXCHANGE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencyeditExchangepthisExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPTHISEXPENSECURRENCY = "p_thisExpenseCurrency";
    /** <code>expenseCurrencyeditExchangepthisExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPTHISEXPENSECURRENCY = "Clas_1057569177600792Ser_6Arg_1_Alias";
    /** <code>expenseCurrencyeditExchangepthisExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPTHISEXPENSECURRENCY = "Expense Currency";
    /** <code>expenseCurrencyeditExchangepExchange</code> inbound argument name. */
    public static final String ARG_NAME_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPEXCHANGE = "pExchange";
    /** <code>expenseCurrencyeditExchangepExchange</code> inbound argument id. */
    public static final String ARG_ID_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPEXCHANGE = "Clas_1057569177600792Ser_6Arg_2_Alias";
    /** <code>expenseCurrencyeditExchangepExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPEXCHANGE = "New Exchange";
    // Service (TNEW)
    /** <code>TNEW</code> service id. */
    public static final String SERV_ID_TNEW = "Clas_1057569177600792Ser_7_Alias";
    /** <code>TNEW</code> service name. */
    public static final String SERV_NAME_TNEW = "TNEW";
    /** <code>TNEW</code> service alias. */
    public static final String SERV_ALIAS_TNEW = "Create";
    /** Agents allowed to execute the service TNEW **/
    public static final String TNEW_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencyTNEWpCurrencyName</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSECURRENCYTNEWPCURRENCYNAME = "pCurrencyName";
    /** <code>expenseCurrencyTNEWpCurrencyName</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURRENCYNAME = "Clas_1057569177600792Ser_7Arg_2_Alias";
    /** <code>expenseCurrencyTNEWpCurrencyName</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURRENCYNAME = "Name";
    /** <code>expenseCurrencyTNEWpCurrencyCode</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSECURRENCYTNEWPCURRENCYCODE = "pCurrencyCode";
    /** <code>expenseCurrencyTNEWpCurrencyCode</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURRENCYCODE = "Clas_1057569177600792Ser_7Arg_3_Alias";
    /** <code>expenseCurrencyTNEWpCurrencyCode</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURRENCYCODE = "Currency Code";
    /** <code>expenseCurrencyTNEWpCurAcronym</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSECURRENCYTNEWPCURACRONYM = "pCurAcronym";
    /** <code>expenseCurrencyTNEWpCurAcronym</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURACRONYM = "Clas_1057569177600792Ser_7Arg_4_Alias";
    /** <code>expenseCurrencyTNEWpCurAcronym</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURACRONYM = "Acronym";
    /** <code>expenseCurrencyTNEWpExchange</code> inbound argument name. */
    public static final String ARG_NAME_TNEW_EXPENSECURRENCYTNEWPEXCHANGE = "pExchange";
    /** <code>expenseCurrencyTNEWpExchange</code> inbound argument id. */
    public static final String ARG_ID_TNEW_EXPENSECURRENCYTNEWPEXCHANGE = "Clas_1057569177600792Ser_7Arg_5_Alias";
    /** <code>expenseCurrencyTNEWpExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPEXCHANGE = "Exchange";
    // Service (TEDITEXCHANGE)
    /** <code>TEDITEXCHANGE</code> service id. */
    public static final String SERV_ID_TEDITEXCHANGE = "Clas_1057569177600792Ser_8_Alias";
    /** <code>TEDITEXCHANGE</code> service name. */
    public static final String SERV_NAME_TEDITEXCHANGE = "TEDITEXCHANGE";
    /** <code>TEDITEXCHANGE</code> service alias. */
    public static final String SERV_ALIAS_TEDITEXCHANGE = "Update exchange";
    /** Agents allowed to execute the service TEDITEXCHANGE **/
    public static final String TEDITEXCHANGE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPTHISEXPENSECURRENCY = "p_thisExpenseCurrency";
    /** <code>expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPTHISEXPENSECURRENCY = "Clas_1057569177600792Ser_8Arg_1_Alias";
    /** <code>expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPTHISEXPENSECURRENCY = "Expense Currency";
    /** <code>expenseCurrencyTEDITEXCHANGEpExchange</code> inbound argument name. */
    public static final String ARG_NAME_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPEXCHANGE = "pExchange";
    /** <code>expenseCurrencyTEDITEXCHANGEpExchange</code> inbound argument id. */
    public static final String ARG_ID_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPEXCHANGE = "Clas_1057569177600792Ser_8Arg_2_Alias";
    /** <code>expenseCurrencyTEDITEXCHANGEpExchange</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPEXCHANGE = "New Exchange";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EXPENSECURRENCYCURRENCYNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSECURRENCYCURACRONYM.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSECURRENCYEXCHANGE.toUpperCase(), Constants.Type.REAL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EXPENSECURRENCYCURRENCYCODE.toUpperCase(), EXPENSECURRENCYCURRENCYCODE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSECURRENCYCURRENCYNAME.toUpperCase(), EXPENSECURRENCYCURRENCYNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSECURRENCYCURACRONYM.toUpperCase(), EXPENSECURRENCYCURACRONYM_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSECURRENCYEXCHANGE.toUpperCase(), EXPENSECURRENCYEXCHANGE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ExpenseCurrency', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ExpenseCurrency', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE);
        }
        // Facet 'ExpenseCurrency' (This facet)
        if (ExpenseCurrencyConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE);
        }
        return returnList;
    }
}
