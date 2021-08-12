package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ExpenseType</code> model class.
 */
public final class ExpenseTypeConstants {

    private ExpenseTypeConstants() {

    }

    // Class
    /** <code>ExpenseType</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600995_Alias";
    /** <code>ExpenseType</code> class name. */
    public static final String CLASS_NAME = "ExpenseType";
    /** <code>ExpenseType</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Type";
    /** <code>ExpenseType</code> class table name. */
    public static final String TBL_NAME = "ExpenseType";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "expenseTypeTypeCode,expenseTypeTyDescription,expenseTypePrice,expenseTypeFixedPrice";

    public static final String DSDSEXPENSETYPE = "DS_ExpenseType";
    public static final String DSDSEXPENSETYPESUP = "DS_ExpenseTypeSup";
    

    // Attribute (expenseTypeTypeCode)
    /** <code>expenseTypeTypeCode</code> attribute id. */
    public static final String ATTR_ID_EXPENSETYPETYPECODE = "Clas_1057569177600995Atr_1_Alias";
    /** <code>expenseTypeTypeCode</code> attribute name. */
    public static final String ATTR_NAME_EXPENSETYPETYPECODE = "expenseTypeTypeCode";
    /** <code>expenseTypeTypeCode</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSETYPETYPECODE = "Expense Type Code";

    /** <code>expenseTypeTypeCode</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPETYPECODE = "";
    /** Agents allowed to view the attribute expenseTypeTypeCode **/
    public static final String EXPENSETYPETYPECODE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseTypeTyDescription)
    /** <code>expenseTypeTyDescription</code> attribute id. */
    public static final String ATTR_ID_EXPENSETYPETYDESCRIPTION = "Clas_1057569177600995Atr_2_Alias";
    /** <code>expenseTypeTyDescription</code> attribute name. */
    public static final String ATTR_NAME_EXPENSETYPETYDESCRIPTION = "expenseTypeTyDescription";
    /** <code>expenseTypeTyDescription</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSETYPETYDESCRIPTION = "Description";

    /** <code>expenseTypeTyDescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPETYDESCRIPTION = "";
    /** Agents allowed to view the attribute expenseTypeTyDescription **/
    public static final String EXPENSETYPETYDESCRIPTION_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseTypePrice)
    /** <code>expenseTypePrice</code> attribute id. */
    public static final String ATTR_ID_EXPENSETYPEPRICE = "Clas_1057569177600995Atr_3_Alias";
    /** <code>expenseTypePrice</code> attribute name. */
    public static final String ATTR_NAME_EXPENSETYPEPRICE = "expenseTypePrice";
    /** <code>expenseTypePrice</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSETYPEPRICE = "Unit Price";

    /** <code>expenseTypePrice</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPEPRICE = "";
    /** Agents allowed to view the attribute expenseTypePrice **/
    public static final String EXPENSETYPEPRICE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (expenseTypeFixedPrice)
    /** <code>expenseTypeFixedPrice</code> attribute id. */
    public static final String ATTR_ID_EXPENSETYPEFIXEDPRICE = "Clas_1057569177600995Atr_4_Alias";
    /** <code>expenseTypeFixedPrice</code> attribute name. */
    public static final String ATTR_NAME_EXPENSETYPEFIXEDPRICE = "expenseTypeFixedPrice";
    /** <code>expenseTypeFixedPrice</code> attribute alias. */
    public static final String ATTR_ALIAS_EXPENSETYPEFIXEDPRICE = "Fixed Price";

    /** <code>expenseTypeFixedPrice</code> attribute facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPEFIXEDPRICE = "";
    /** Agents allowed to view the attribute expenseTypeFixedPrice **/
    public static final String EXPENSETYPEFIXEDPRICE_AGENTS = "AdminUser,OperatorUser";


    // Field (TypeCode)
    /** <code>TypeCode</code> field name. */
    public static final String FLD_EXPENSETYPETYPECODE = "TypeCode";    
    /** <code>TypeCode</code> field length. */
    public static final int FLD_EXPENSETYPETYPECODELENGTH = 5;
    /** <code>expenseTypeTypeCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPETYPECODE = "expenseTypeTypeCode";
    // Field (TyDescription)
    /** <code>TyDescription</code> field name. */
    public static final String FLD_EXPENSETYPETYDESCRIPTION = "TyDescription";    
    /** <code>TyDescription</code> field length. */
    public static final int FLD_EXPENSETYPETYDESCRIPTIONLENGTH = 25;
    /** <code>expenseTypeTyDescription</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPETYDESCRIPTION = "expenseTypeTyDescription";
    // Field (Price)
    /** <code>Price</code> field name. */
    public static final String FLD_EXPENSETYPEPRICE = "Price";    
    /** <code>expenseTypePrice</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPEPRICE = "expenseTypePrice";
    // Field (FixedPrice)
    /** <code>FixedPrice</code> field name. */
    public static final String FLD_EXPENSETYPEFIXEDPRICE = "FixedPrice";    
    /** <code>expenseTypeFixedPrice</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPEFIXEDPRICE = "expenseTypeFixedPrice";


    // Compound role (ExpenseLines)
    /** <code>ExpenseLines</code> role id. */
    public static final String ROLE_ID_EXPENSELINES = "Agr_1057569177600789_Alias";
    /** <code>ExpenseLines</code> role name. */
    public static final String ROLE_NAME_EXPENSELINES = "expenseLines";
    /** <code>ExpenseType</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSELINES = "Expense Lines";


    /** <code>ExpenseLines</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSELINES = ExpenseLineConstants.ROLE_NAME_EXPENSETYPE;
    /** <code>ExpenseLines</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSELINES = "";
    /** <code>ExpenseLines</code> role target class. */
    public static final String ROLE_TARGET_EXPENSELINES = ExpenseLineConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseLines **/
    public static final String EXPENSELINES_AGENTS = "AdminUser,OperatorUser";
    // Compound role (TemplateLines)
    /** <code>TemplateLines</code> role id. */
    public static final String ROLE_ID_TEMPLATELINES = "Agr_1622460727296136_Alias";
    /** <code>TemplateLines</code> role name. */
    public static final String ROLE_NAME_TEMPLATELINES = "templateLines";
    /** <code>ExpenseType</code> role alias. */
    public static final String ROLE_ALIAS_TEMPLATELINES = "TemplateLines";


    /** <code>TemplateLines</code> inverse role name. */
    public static final String ROLE_INVNAME_TEMPLATELINES = ERLTemplateConstants.ROLE_NAME_EXPENSETYPE;
    /** <code>TemplateLines</code> role facet sequence. */
    public static final String PATH_FACETS_TEMPLATELINES = "";
    /** <code>TemplateLines</code> role target class. */
    public static final String ROLE_TARGET_TEMPLATELINES = ERLTemplateConstants.CLASS_NAME;
    /** Agents allowed to navigate through TemplateLines **/
    public static final String TEMPLATELINES_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1057569177600995Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseTypecreateinstancepatrTypeCode</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYPECODE = "p_atrTypeCode";
    /** <code>expenseTypecreateinstancepatrTypeCode</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYPECODE = "Clas_1057569177600995Ser_1Arg_1_Alias";
    /** <code>expenseTypecreateinstancepatrTypeCode</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYPECODE = "Expense Type Code";
    /** <code>expenseTypecreateinstancepatrTyDescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYDESCRIPTION = "p_atrTyDescription";
    /** <code>expenseTypecreateinstancepatrTyDescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYDESCRIPTION = "Clas_1057569177600995Ser_1Arg_2_Alias";
    /** <code>expenseTypecreateinstancepatrTyDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYDESCRIPTION = "Description";
    /** <code>expenseTypecreateinstancepatrPrice</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRPRICE = "p_atrPrice";
    /** <code>expenseTypecreateinstancepatrPrice</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRPRICE = "Clas_1057569177600995Ser_1Arg_3_Alias";
    /** <code>expenseTypecreateinstancepatrPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRPRICE = "Unit Price";
    /** <code>expenseTypecreateinstancepatrFixedPrice</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRFIXEDPRICE = "p_atrFixedPrice";
    /** <code>expenseTypecreateinstancepatrFixedPrice</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRFIXEDPRICE = "Clas_1057569177600995Ser_1Arg_4_Alias";
    /** <code>expenseTypecreateinstancepatrFixedPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRFIXEDPRICE = "Fixed Price";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1057569177600995Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseTypedeleteinstancepthisExpenseType</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_EXPENSETYPEDELETEINSTANCEPTHISEXPENSETYPE = "p_thisExpenseType";
    /** <code>expenseTypedeleteinstancepthisExpenseType</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_EXPENSETYPEDELETEINSTANCEPTHISEXPENSETYPE = "Clas_1057569177600995Ser_2Arg_1_Alias";
    /** <code>expenseTypedeleteinstancepthisExpenseType</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_EXPENSETYPEDELETEINSTANCEPTHISEXPENSETYPE = "Expense Type";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600995Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>expenseTypeeditinstancepthisExpenseType</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTHISEXPENSETYPE = "p_thisExpenseType";
    /** <code>expenseTypeeditinstancepthisExpenseType</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTHISEXPENSETYPE = "Clas_1057569177600995Ser_3Arg_1_Alias";
    /** <code>expenseTypeeditinstancepthisExpenseType</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTHISEXPENSETYPE = "Expense Type";
    /** <code>expenseTypeeditinstancepPrice</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPPRICE = "p_Price";
    /** <code>expenseTypeeditinstancepPrice</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPPRICE = "Clas_1057569177600995Ser_3Arg_2_Alias";
    /** <code>expenseTypeeditinstancepPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPPRICE = "Unit Price";
    /** <code>expenseTypeeditinstancepTyDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTYDESCRIPTION = "p_TyDescription";
    /** <code>expenseTypeeditinstancepTyDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTYDESCRIPTION = "Clas_1057569177600995Ser_3Arg_3_Alias";
    /** <code>expenseTypeeditinstancepTyDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTYDESCRIPTION = "Description";
    /** <code>expenseTypeeditinstancepFixedPrice</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPFIXEDPRICE = "p_FixedPrice";
    /** <code>expenseTypeeditinstancepFixedPrice</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPFIXEDPRICE = "Clas_1057569177600995Ser_3Arg_4_Alias";
    /** <code>expenseTypeeditinstancepFixedPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPFIXEDPRICE = "Fixed Price";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_EXPENSETYPETYDESCRIPTION.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSETYPEPRICE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_EXPENSETYPEFIXEDPRICE.toUpperCase(), Constants.Type.BOOL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_EXPENSETYPETYPECODE.toUpperCase(), EXPENSETYPETYPECODE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSETYPETYDESCRIPTION.toUpperCase(), EXPENSETYPETYDESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSETYPEPRICE.toUpperCase(), EXPENSETYPEPRICE_AGENTS);
    	attributeAgents.put(ATTR_NAME_EXPENSETYPEFIXEDPRICE.toUpperCase(), EXPENSETYPEFIXEDPRICE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ExpenseType', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ExpenseType', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_EXPENSETYPETYPECODE);
        }
        // Facet 'ExpenseType' (This facet)
        if (ExpenseTypeConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_EXPENSETYPETYPECODE);
        }
        return returnList;
    }
}
