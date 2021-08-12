package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ExpenseLine</code> model class.
 */
public final class ExpenseLineConstants {

    private ExpenseLineConstants() {

    }

    // Class
    /** <code>ExpenseLine</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600646_Alias";
    /** <code>ExpenseLine</code> class name. */
    public static final String CLASS_NAME = "ExpenseLine";
    /** <code>ExpenseLine</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Line";
    /** <code>ExpenseLine</code> class table name. */
    public static final String TBL_NAME = "ExpenseLine";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "expenseReportidExpenseRepor,expenseLineidExpenseLine,expenseTypeTypeCode,expenseLineExpenseDate,expenseLineUnits,expenseLinePrice,expenseLineLnDescription";

    public static final String DSDSEXPENSELINE = "DS_ExpenseLine";
    public static final String DSDSEXPENSELINESUP = "DS_ExpenseLineSup";
    

    // Attribute (expenseLineidExpenseLine)
    /** <code>expenseLineidExpenseLine</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINEIDEXPENSELINE = "Clas_1057569177600646Atr_1_Alias";
    /** <code>expenseLineidExpenseLine</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINEIDEXPENSELINE = "expenseLineidExpenseLine";
    /** <code>expenseLineidExpenseLine</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINEIDEXPENSELINE = "Nº Line";

    /** <code>expenseLineidExpenseLine</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINEIDEXPENSELINE = "";
    /** Agents allowed to view the attribute expenseLineidExpenseLine **/
    public static final String EXPENSELINEIDEXPENSELINE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLineExpenseDate)
    /** <code>expenseLineExpenseDate</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINEEXPENSEDATE = "Clas_1057569177600646Atr_4_Alias";
    /** <code>expenseLineExpenseDate</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINEEXPENSEDATE = "expenseLineExpenseDate";
    /** <code>expenseLineExpenseDate</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINEEXPENSEDATE = "Date";

    /** <code>expenseLineExpenseDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINEEXPENSEDATE = "";
    /** Agents allowed to view the attribute expenseLineExpenseDate **/
    public static final String EXPENSELINEEXPENSEDATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLineUnits)
    /** <code>expenseLineUnits</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINEUNITS = "Clas_1057569177600646Atr_2_Alias";
    /** <code>expenseLineUnits</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINEUNITS = "expenseLineUnits";
    /** <code>expenseLineUnits</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINEUNITS = "Quantity";

    /** <code>expenseLineUnits</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINEUNITS = "";
    /** Agents allowed to view the attribute expenseLineUnits **/
    public static final String EXPENSELINEUNITS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLinePrice)
    /** <code>expenseLinePrice</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINEPRICE = "Clas_1057569177600646Atr_3_Alias";
    /** <code>expenseLinePrice</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINEPRICE = "expenseLinePrice";
    /** <code>expenseLinePrice</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINEPRICE = "Price";

    /** <code>expenseLinePrice</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINEPRICE = "";
    /** Agents allowed to view the attribute expenseLinePrice **/
    public static final String EXPENSELINEPRICE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLineTotalLine)
    /** <code>expenseLineTotalLine</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINETOTALLINE = "Clas_1057569177600646Atr_5_Alias";
    /** <code>expenseLineTotalLine</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINETOTALLINE = "expenseLineTotalLine";
    /** <code>expenseLineTotalLine</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINETOTALLINE = "Total Line";

    /** <code>expenseLineTotalLine</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINETOTALLINE = "";
    /** Agents allowed to view the attribute expenseLineTotalLine **/
    public static final String EXPENSELINETOTALLINE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLineLnDescription)
    /** <code>expenseLineLnDescription</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINELNDESCRIPTION = "Clas_1057569177600646Atr_6_Alias";
    /** <code>expenseLineLnDescription</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINELNDESCRIPTION = "expenseLineLnDescription";
    /** <code>expenseLineLnDescription</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINELNDESCRIPTION = "LnDescription";

    /** <code>expenseLineLnDescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINELNDESCRIPTION = "";
    /** Agents allowed to view the attribute expenseLineLnDescription **/
    public static final String EXPENSELINELNDESCRIPTION_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseLineTotalLineCurr)
    /** <code>expenseLineTotalLineCurr</code> attribute id. */
    public static final String ATTR_ID_EXPENSELINETOTALLINECURR = "Clas_1057569177600646Atr_7_Alias";
    /** <code>expenseLineTotalLineCurr</code> attribute name. */
    public static final String ATTR_NAME_EXPENSELINETOTALLINECURR = "expenseLineTotalLineCurr";
    /** <code>expenseLineTotalLineCurr</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSELINETOTALLINECURR = "Total Line Currency";

    /** <code>expenseLineTotalLineCurr</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSELINETOTALLINECURR = "";
    /** Agents allowed to view the attribute expenseLineTotalLineCurr **/
    public static final String EXPENSELINETOTALLINECURR_AGENTS = "AdminUser,OperatorUser";

    // Attribute (ExpenseReport.expenseReportidExpenseRepor)
    /** <code>ExpenseReport.expenseReportidExpenseRepor</code> identification attribute name. */
    public static final String ATTR_NAME_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR = "expenseReport.expenseReportidExpenseRepor";

    // Field (id_ExpenseRepor)
    /** <code>id_ExpenseRepor</code> field name. */
    public static final String FLD_EXPENSEREPORTIDEXPENSEREPOR = "id_ExpenseRepor";    
    /** <code>ExpenseReport.expenseReportidExpenseRepor</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSEREPORT_EXPENSEREPORTIDEXPENSEREPOR = "expenseReportidExpenseRepor";
    // Field (id_ExpenseLine)
    /** <code>id_ExpenseLine</code> field name. */
    public static final String FLD_EXPENSELINEIDEXPENSELINE = "id_ExpenseLine";    
    /** <code>expenseLineidExpenseLine</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSELINEIDEXPENSELINE = "expenseLineidExpenseLine";
    // Field (TypeCode)
    /** <code>TypeCode</code> field name. */
    public static final String FLD_EXPENSETYPETYPECODE = "TypeCode";    
    /** <code>TypeCode</code> field length. */
    public static final int FLD_EXPENSETYPETYPECODELENGTH = 5;
    /** <code>ExpenseType.expenseTypeTypeCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPE_EXPENSETYPETYPECODE = "expenseTypeTypeCode";
    // Field (ExpenseDate)
    /** <code>ExpenseDate</code> field name. */
    public static final String FLD_EXPENSELINEEXPENSEDATE = "ExpenseDate";    
    /** <code>expenseLineExpenseDate</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSELINEEXPENSEDATE = "expenseLineExpenseDate";
    // Field (Units)
    /** <code>Units</code> field name. */
    public static final String FLD_EXPENSELINEUNITS = "Units";    
    /** <code>expenseLineUnits</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSELINEUNITS = "expenseLineUnits";
    // Field (Price)
    /** <code>Price</code> field name. */
    public static final String FLD_EXPENSELINEPRICE = "Price";    
    /** <code>expenseLinePrice</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSELINEPRICE = "expenseLinePrice";
    // Field (LnDescription)
    /** <code>LnDescription</code> field name. */
    public static final String FLD_EXPENSELINELNDESCRIPTION = "LnDescription";    
    /** <code>LnDescription</code> field length. */
    public static final int FLD_EXPENSELINELNDESCRIPTIONLENGTH = 255;
    /** <code>expenseLineLnDescription</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSELINELNDESCRIPTION = "expenseLineLnDescription";

    // Component role (ExpenseType)
    /** <code>ExpenseType</code> role id. */
    public static final String ROLE_ID_EXPENSETYPE = "Agr_1057569177600789_Alias";
    /** <code>ExpenseType</code> role name. */
    public static final String ROLE_NAME_EXPENSETYPE = "expenseType";
    /** <code>ExpenseType</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSETYPE = "Expense Type";

    /** <code>ExpenseType</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSETYPE = ExpenseTypeConstants.ROLE_NAME_EXPENSELINES;
    /** <code>ExpenseType</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPE = "";
    /** <code>ExpenseType</code> role target class. */
    public static final String ROLE_TARGET_EXPENSETYPE = ExpenseTypeConstants.CLASS_NAME;

    /** Agents allowed to navigate through ExpenseType **/
    public static final String EXPENSETYPE_AGENTS = "AdminUser,OperatorUser";
    // Component role (ExpenseReport)
    /** <code>ExpenseReport</code> role id. */
    public static final String ROLE_ID_EXPENSEREPORT = "Agr_1298562547712121_Alias";
    /** <code>ExpenseReport</code> role name. */
    public static final String ROLE_NAME_EXPENSEREPORT = "expenseReport";
    /** <code>ExpenseReport</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSEREPORT = "ExpenseReport";

    /** <code>ExpenseReport</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSEREPORT = ExpenseReportConstants.ROLE_NAME_EXPENSELINES;
    /** <code>ExpenseReport</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORT = "";
    /** <code>ExpenseReport</code> role target class. */
    public static final String ROLE_TARGET_EXPENSEREPORT = ExpenseReportConstants.CLASS_NAME;

    /** Agents allowed to navigate through ExpenseReport **/
    public static final String EXPENSEREPORT_AGENTS = "AdminUser,OperatorUser";


    // Service (newline)
    /** <code>newline</code> service id. */
    public static final String SERV_ID_NEWLINE = "Clas_1057569177600646Ser_1_Alias";
    /** <code>newline</code> service name. */
    public static final String SERV_NAME_NEWLINE = "newline";
    /** <code>newline</code> service alias. */
    public static final String SERV_ALIAS_NEWLINE = "Create a New Line";
    /** Agents allowed to execute the service newline **/
    public static final String NEWLINE_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>newline</code> precondition 0 id. */
    public static final String PRE_ID_NEWLINE_0 = "Clas_1057569177600646Pre_1_MsgError";
    /** <code>newline</code> precondition 1 id. */
    public static final String PRE_ID_NEWLINE_1 = "Clas_1057569177600646Pre_2_MsgError";
    // Inbound arguments
    /** <code>expenseLinenewlinepagrExpenseType</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPAGREXPENSETYPE = "p_agrExpenseType";
    /** <code>expenseLinenewlinepagrExpenseType</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPAGREXPENSETYPE = "Clas_1057569177600646Ser_1Arg_2_Alias";
    /** <code>expenseLinenewlinepagrExpenseType</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPAGREXPENSETYPE = "Expense Type";
    /** <code>expenseLinenewlinepagrExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPAGREXPENSEREPORT = "p_agrExpenseReport";
    /** <code>expenseLinenewlinepagrExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPAGREXPENSEREPORT = "Clas_1057569177600646Ser_1Arg_7_Alias";
    /** <code>expenseLinenewlinepagrExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPAGREXPENSEREPORT = "ExpenseReport";
    /** <code>expenseLinenewlinepatrUnits</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPATRUNITS = "p_atrUnits";
    /** <code>expenseLinenewlinepatrUnits</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRUNITS = "Clas_1057569177600646Ser_1Arg_3_Alias";
    /** <code>expenseLinenewlinepatrUnits</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRUNITS = "Quantity";
    /** <code>expenseLinenewlinepatrPrice</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPATRPRICE = "p_atrPrice";
    /** <code>expenseLinenewlinepatrPrice</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRPRICE = "Clas_1057569177600646Ser_1Arg_4_Alias";
    /** <code>expenseLinenewlinepatrPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRPRICE = "Price";
    /** <code>expenseLinenewlinepatrExpenseDate</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPATREXPENSEDATE = "p_atrExpenseDate";
    /** <code>expenseLinenewlinepatrExpenseDate</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPATREXPENSEDATE = "Clas_1057569177600646Ser_1Arg_5_Alias";
    /** <code>expenseLinenewlinepatrExpenseDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATREXPENSEDATE = "Date";
    /** <code>expenseLinenewlinepatrLnDescription</code> inbound argument name. */
    public static final String ARG_NAME_NEWLINE_EXPENSELINENEWLINEPATRLNDESCRIPTION = "p_atrLnDescription";
    /** <code>expenseLinenewlinepatrLnDescription</code> inbound argument id. */
    public static final String ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRLNDESCRIPTION = "Clas_1057569177600646Ser_1Arg_6_Alias";
    /** <code>expenseLinenewlinepatrLnDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRLNDESCRIPTION = "Description";
    // Service (deleteline)
    /** <code>deleteline</code> service id. */
    public static final String SERV_ID_DELETELINE = "Clas_1057569177600646Ser_2_Alias";
    /** <code>deleteline</code> service name. */
    public static final String SERV_NAME_DELETELINE = "deleteline";
    /** <code>deleteline</code> service alias. */
    public static final String SERV_ALIAS_DELETELINE = "Delete Line";
    /** Agents allowed to execute the service deleteline **/
    public static final String DELETELINE_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>deleteline</code> precondition 0 id. */
    public static final String PRE_ID_DELETELINE_0 = "Clas_1057569177600646Pre_3_MsgError";
    // Inbound arguments
    /** <code>expenseLinedeletelinepthisExpenseLine</code> inbound argument name. */
    public static final String ARG_NAME_DELETELINE_EXPENSELINEDELETELINEPTHISEXPENSELINE = "p_thisExpenseLine";
    /** <code>expenseLinedeletelinepthisExpenseLine</code> inbound argument id. */
    public static final String ARG_ID_DELETELINE_EXPENSELINEDELETELINEPTHISEXPENSELINE = "Clas_1057569177600646Ser_2Arg_1_Alias";
    /** <code>expenseLinedeletelinepthisExpenseLine</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETELINE_EXPENSELINEDELETELINEPTHISEXPENSELINE = "Expense Line";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600646Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit a Line";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>editinstance</code> precondition 0 id. */
    public static final String PRE_ID_EDITINSTANCE_0 = "Clas_1057569177600646Pre_4_MsgError";
    /** <code>editinstance</code> precondition 1 id. */
    public static final String PRE_ID_EDITINSTANCE_1 = "Clas_1057569177600646Pre_5_MsgError";
    // Inbound arguments
    /** <code>expenseLineeditinstancepthisExpenseLine</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSELINEEDITINSTANCEPTHISEXPENSELINE = "p_thisExpenseLine";
    /** <code>expenseLineeditinstancepthisExpenseLine</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPTHISEXPENSELINE = "Clas_1057569177600646Ser_3Arg_1_Alias";
    /** <code>expenseLineeditinstancepthisExpenseLine</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPTHISEXPENSELINE = "Expense Line";
    /** <code>expenseLineeditinstancepExpenseDate</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSELINEEDITINSTANCEPEXPENSEDATE = "p_ExpenseDate";
    /** <code>expenseLineeditinstancepExpenseDate</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPEXPENSEDATE = "Clas_1057569177600646Ser_3Arg_2_Alias";
    /** <code>expenseLineeditinstancepExpenseDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPEXPENSEDATE = "Date";
    /** <code>expenseLineeditinstancepUnits</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSELINEEDITINSTANCEPUNITS = "p_Units";
    /** <code>expenseLineeditinstancepUnits</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPUNITS = "Clas_1057569177600646Ser_3Arg_3_Alias";
    /** <code>expenseLineeditinstancepUnits</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPUNITS = "Quantity";
    /** <code>expenseLineeditinstancepPrice</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSELINEEDITINSTANCEPPRICE = "p_Price";
    /** <code>expenseLineeditinstancepPrice</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPPRICE = "Clas_1057569177600646Ser_3Arg_4_Alias";
    /** <code>expenseLineeditinstancepPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPPRICE = "Price";
    /** <code>expenseLineeditinstancepLnDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSELINEEDITINSTANCEPLNDESCRIPTION = "p_LnDescription";
    /** <code>expenseLineeditinstancepLnDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPLNDESCRIPTION = "Clas_1057569177600646Ser_3Arg_5_Alias";
    /** <code>expenseLineeditinstancepLnDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPLNDESCRIPTION = "LnDescription";
    // Service (deletepaidline)
    /** <code>deletepaidline</code> service id. */
    public static final String SERV_ID_DELETEPAIDLINE = "Clas_1057569177600646Ser_4_Alias";
    /** <code>deletepaidline</code> service name. */
    public static final String SERV_NAME_DELETEPAIDLINE = "deletepaidline";
    /** <code>deletepaidline</code> service alias. */
    public static final String SERV_ALIAS_DELETEPAIDLINE = "delete_paidline";
    /** Agents allowed to execute the service deletepaidline **/
    public static final String DELETEPAIDLINE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>expenseLinedeletepaidlinepthisExpenseLine</code> inbound argument name. */
    public static final String ARG_NAME_DELETEPAIDLINE_EXPENSELINEDELETEPAIDLINEPTHISEXPENSELINE = "p_thisExpenseLine";
    /** <code>expenseLinedeletepaidlinepthisExpenseLine</code> inbound argument id. */
    public static final String ARG_ID_DELETEPAIDLINE_EXPENSELINEDELETEPAIDLINEPTHISEXPENSELINE = "Clas_1057569177600646Ser_4Arg_1_Alias";
    /** <code>expenseLinedeletepaidlinepthisExpenseLine</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEPAIDLINE_EXPENSELINEDELETEPAIDLINEPTHISEXPENSELINE = "Expense Line";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EXPENSELINEEXPENSEDATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSELINEUNITS.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSELINEPRICE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSELINETOTALLINE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSELINELNDESCRIPTION.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSELINETOTALLINECURR.toUpperCase(), Constants.Type.REAL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EXPENSELINEIDEXPENSELINE.toUpperCase(), EXPENSELINEIDEXPENSELINE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINEEXPENSEDATE.toUpperCase(), EXPENSELINEEXPENSEDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINEUNITS.toUpperCase(), EXPENSELINEUNITS_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINEPRICE.toUpperCase(), EXPENSELINEPRICE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINETOTALLINE.toUpperCase(), EXPENSELINETOTALLINE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINELNDESCRIPTION.toUpperCase(), EXPENSELINELNDESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSELINETOTALLINECURR.toUpperCase(), EXPENSELINETOTALLINECURR_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_EXPENSETYPE.toUpperCase(), EXPENSETYPE_AGENTS);
        roleAgents.put(ROLE_NAME_EXPENSEREPORT.toUpperCase(), EXPENSEREPORT_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ExpenseLine', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ExpenseLine', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ROLE_NAME_EXPENSEREPORT + "." + ExpenseReportConstants.ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR);
            returnList.add(ATTR_FIELD_EXPENSELINEIDEXPENSELINE);
        }
        // Facet 'ExpenseLine' (This facet)
        if (ExpenseLineConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ROLE_NAME_EXPENSEREPORT + "." + ExpenseReportConstants.ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR);
            returnList.add(ATTR_FIELD_EXPENSELINEIDEXPENSELINE);
        }
        return returnList;
    }
}
