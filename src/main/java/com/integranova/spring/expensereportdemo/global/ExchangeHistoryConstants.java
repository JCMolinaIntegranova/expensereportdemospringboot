package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ExchangeHistory</code> model class.
 */
public final class ExchangeHistoryConstants {

    private ExchangeHistoryConstants() {

    }

    // Class
    /** <code>ExchangeHistory</code> class id. */
    public static final String CLASS_ID = "Clas_1622465314816112_Alias";
    /** <code>ExchangeHistory</code> class name. */
    public static final String CLASS_NAME = "ExchangeHistory";
    /** <code>ExchangeHistory</code> class alias. */
    public static final String CLASS_ALIAS = "Exchange History";
    /** <code>ExchangeHistory</code> class table name. */
    public static final String TBL_NAME = "ExchangeHistory";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "expenseCurrencyCurrencyCode,exchangeHistoryentryDate,exchangeHistoryoldValue,exchangeHistorynewValue";

    

    // Attribute (exchangeHistoryentryDate)
    /** <code>exchangeHistoryentryDate</code> attribute id. */
    public static final String ATTR_ID_EXCHANGEHISTORYENTRYDATE = "Clas_1622465314816112Atr_2_Alias";
    /** <code>exchangeHistoryentryDate</code> attribute name. */
    public static final String ATTR_NAME_EXCHANGEHISTORYENTRYDATE = "exchangeHistoryentryDate";
    /** <code>exchangeHistoryentryDate</code> attribute alias. */
    public static final String ATTR_ALIAS_EXCHANGEHISTORYENTRYDATE = "Date";

    /** <code>exchangeHistoryentryDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXCHANGEHISTORYENTRYDATE = "";
    /** Agents allowed to view the attribute exchangeHistoryentryDate **/
    public static final String EXCHANGEHISTORYENTRYDATE_AGENTS = "";
    // Attribute (exchangeHistoryoldValue)
    /** <code>exchangeHistoryoldValue</code> attribute id. */
    public static final String ATTR_ID_EXCHANGEHISTORYOLDVALUE = "Clas_1622465314816112Atr_3_Alias";
    /** <code>exchangeHistoryoldValue</code> attribute name. */
    public static final String ATTR_NAME_EXCHANGEHISTORYOLDVALUE = "exchangeHistoryoldValue";
    /** <code>exchangeHistoryoldValue</code> attribute alias. */
    public static final String ATTR_ALIAS_EXCHANGEHISTORYOLDVALUE = "Old Value";

    /** <code>exchangeHistoryoldValue</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXCHANGEHISTORYOLDVALUE = "";
    /** Agents allowed to view the attribute exchangeHistoryoldValue **/
    public static final String EXCHANGEHISTORYOLDVALUE_AGENTS = "";
    // Attribute (exchangeHistorynewValue)
    /** <code>exchangeHistorynewValue</code> attribute id. */
    public static final String ATTR_ID_EXCHANGEHISTORYNEWVALUE = "Clas_1622465314816112Atr_4_Alias";
    /** <code>exchangeHistorynewValue</code> attribute name. */
    public static final String ATTR_NAME_EXCHANGEHISTORYNEWVALUE = "exchangeHistorynewValue";
    /** <code>exchangeHistorynewValue</code> attribute alias. */
    public static final String ATTR_ALIAS_EXCHANGEHISTORYNEWVALUE = "New Value";

    /** <code>exchangeHistorynewValue</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXCHANGEHISTORYNEWVALUE = "";
    /** Agents allowed to view the attribute exchangeHistorynewValue **/
    public static final String EXCHANGEHISTORYNEWVALUE_AGENTS = "";

    // Attribute (ExpenseCurrency.expenseCurrencyCurrencyCode)
    /** <code>ExpenseCurrency.expenseCurrencyCurrencyCode</code> identification attribute name. */
    public static final String ATTR_NAME_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE = "expenseCurrency.expenseCurrencyCurrencyCode";

    // Field (CurrencyCode)
    /** <code>CurrencyCode</code> field name. */
    public static final String FLD_EXPENSECURRENCYCURRENCYCODE = "CurrencyCode";    
    /** <code>CurrencyCode</code> field length. */
    public static final int FLD_EXPENSECURRENCYCURRENCYCODELENGTH = 5;
    /** <code>ExpenseCurrency.expenseCurrencyCurrencyCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE = "expenseCurrencyCurrencyCode";
    // Field (entryDate)
    /** <code>entryDate</code> field name. */
    public static final String FLD_EXCHANGEHISTORYENTRYDATE = "entryDate";    
    /** <code>exchangeHistoryentryDate</code> attribute field name. */
    public static final String ATTR_FIELD_EXCHANGEHISTORYENTRYDATE = "exchangeHistoryentryDate";
    // Field (oldValue)
    /** <code>oldValue</code> field name. */
    public static final String FLD_EXCHANGEHISTORYOLDVALUE = "oldValue";    
    /** <code>exchangeHistoryoldValue</code> attribute field name. */
    public static final String ATTR_FIELD_EXCHANGEHISTORYOLDVALUE = "exchangeHistoryoldValue";
    // Field (newValue)
    /** <code>newValue</code> field name. */
    public static final String FLD_EXCHANGEHISTORYNEWVALUE = "newValue";    
    /** <code>exchangeHistorynewValue</code> attribute field name. */
    public static final String ATTR_FIELD_EXCHANGEHISTORYNEWVALUE = "exchangeHistorynewValue";

    // Component role (ExpenseCurrency)
    /** <code>ExpenseCurrency</code> role id. */
    public static final String ROLE_ID_EXPENSECURRENCY = "Agr_1622465314816174_Alias";
    /** <code>ExpenseCurrency</code> role name. */
    public static final String ROLE_NAME_EXPENSECURRENCY = "expenseCurrency";
    /** <code>ExpenseCurrency</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSECURRENCY = "ExpenseCurrency";

    /** <code>ExpenseCurrency</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSECURRENCY = ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS;
    /** <code>ExpenseCurrency</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSECURRENCY = "";
    /** <code>ExpenseCurrency</code> role target class. */
    public static final String ROLE_TARGET_EXPENSECURRENCY = ExpenseCurrencyConstants.CLASS_NAME;

    /** Agents allowed to navigate through ExpenseCurrency **/
    public static final String EXPENSECURRENCY_AGENTS = "AdminUser";


    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1622465314816112Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>exchangeHistorycreateinstancepagrExpenseCurrency</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPAGREXPENSECURRENCY = "p_agrExpenseCurrency";
    /** <code>exchangeHistorycreateinstancepagrExpenseCurrency</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPAGREXPENSECURRENCY = "Clas_1622465314816112Ser_1Arg_2_Alias";
    /** <code>exchangeHistorycreateinstancepagrExpenseCurrency</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPAGREXPENSECURRENCY = "ExpenseCurrency";
    /** <code>exchangeHistorycreateinstancepatroldValue</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATROLDVALUE = "p_atroldValue";
    /** <code>exchangeHistorycreateinstancepatroldValue</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATROLDVALUE = "Clas_1622465314816112Ser_1Arg_3_Alias";
    /** <code>exchangeHistorycreateinstancepatroldValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATROLDVALUE = "Old Value";
    /** <code>exchangeHistorycreateinstancepatrnewValue</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATRNEWVALUE = "p_atrnewValue";
    /** <code>exchangeHistorycreateinstancepatrnewValue</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATRNEWVALUE = "Clas_1622465314816112Ser_1Arg_4_Alias";
    /** <code>exchangeHistorycreateinstancepatrnewValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATRNEWVALUE = "New Value";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1622465314816112Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>exchangeHistorydeleteinstancepthisExchangeHistory</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_EXCHANGEHISTORYDELETEINSTANCEPTHISEXCHANGEHISTORY = "p_thisExchangeHistory";
    /** <code>exchangeHistorydeleteinstancepthisExchangeHistory</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_EXCHANGEHISTORYDELETEINSTANCEPTHISEXCHANGEHISTORY = "Clas_1622465314816112Ser_2Arg_1_Alias";
    /** <code>exchangeHistorydeleteinstancepthisExchangeHistory</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_EXCHANGEHISTORYDELETEINSTANCEPTHISEXCHANGEHISTORY = "Exchange History";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1622465314816112Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>exchangeHistoryeditinstancepthisExchangeHistory</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPTHISEXCHANGEHISTORY = "p_thisExchangeHistory";
    /** <code>exchangeHistoryeditinstancepthisExchangeHistory</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPTHISEXCHANGEHISTORY = "Clas_1622465314816112Ser_3Arg_1_Alias";
    /** <code>exchangeHistoryeditinstancepthisExchangeHistory</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPTHISEXCHANGEHISTORY = "Exchange History";
    /** <code>exchangeHistoryeditinstancepoldValue</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPOLDVALUE = "p_oldValue";
    /** <code>exchangeHistoryeditinstancepoldValue</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPOLDVALUE = "Clas_1622465314816112Ser_3Arg_2_Alias";
    /** <code>exchangeHistoryeditinstancepoldValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPOLDVALUE = "Old Value";
    /** <code>exchangeHistoryeditinstancepnewValue</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPNEWVALUE = "p_newValue";
    /** <code>exchangeHistoryeditinstancepnewValue</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPNEWVALUE = "Clas_1622465314816112Ser_3Arg_3_Alias";
    /** <code>exchangeHistoryeditinstancepnewValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPNEWVALUE = "New Value";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EXCHANGEHISTORYOLDVALUE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXCHANGEHISTORYNEWVALUE.toUpperCase(), Constants.Type.REAL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EXCHANGEHISTORYENTRYDATE.toUpperCase(), EXCHANGEHISTORYENTRYDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXCHANGEHISTORYOLDVALUE.toUpperCase(), EXCHANGEHISTORYOLDVALUE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXCHANGEHISTORYNEWVALUE.toUpperCase(), EXCHANGEHISTORYNEWVALUE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_EXPENSECURRENCY.toUpperCase(), EXPENSECURRENCY_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ExchangeHistory', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ExchangeHistory', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ROLE_NAME_EXPENSECURRENCY + "." + ExpenseCurrencyConstants.ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE);
            returnList.add(ATTR_FIELD_EXCHANGEHISTORYENTRYDATE);
        }
        // Facet 'ExchangeHistory' (This facet)
        if (ExchangeHistoryConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ROLE_NAME_EXPENSECURRENCY + "." + ExpenseCurrencyConstants.ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE);
            returnList.add(ATTR_FIELD_EXCHANGEHISTORYENTRYDATE);
        }
        return returnList;
    }
}
