package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>ERLTemplate</code> model class.
 */
public final class ERLTemplateConstants {

    private ERLTemplateConstants() {

    }

    // Class
    /** <code>ERLTemplate</code> class id. */
    public static final String CLASS_ID = "Clas_1622460596224994_Alias";
    /** <code>ERLTemplate</code> class name. */
    public static final String CLASS_NAME = "ERLTemplate";
    /** <code>ERLTemplate</code> class alias. */
    public static final String CLASS_ALIAS = "Expense Report Line Template";
    /** <code>ERLTemplate</code> class table name. */
    public static final String TBL_NAME = "ERLTemplate";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "eRTemplateTemplateid,eRLTemplateid,expenseTypeTypeCode,eRLTemplateunits,eRLTemplateprice,eRLTemplatedescription";

    public static final String DSDSTEMPLATELINES = "DSTemplateLines";
    

    // Attribute (eRLTemplateid)
    /** <code>eRLTemplateid</code> attribute id. */
    public static final String ATTR_ID_ERLTEMPLATEID = "Clas_1622460596224994Atr_2_Alias";
    /** <code>eRLTemplateid</code> attribute name. */
    public static final String ATTR_NAME_ERLTEMPLATEID = "eRLTemplateid";
    /** <code>eRLTemplateid</code> attribute alias. */
    public static final String ATTR_ALIAS_ERLTEMPLATEID = "Line #";

    /** <code>eRLTemplateid</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERLTEMPLATEID = "";
    /** Agents allowed to view the attribute eRLTemplateid **/
    public static final String ERLTEMPLATEID_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRLTemplateunits)
    /** <code>eRLTemplateunits</code> attribute id. */
    public static final String ATTR_ID_ERLTEMPLATEUNITS = "Clas_1622460596224994Atr_3_Alias";
    /** <code>eRLTemplateunits</code> attribute name. */
    public static final String ATTR_NAME_ERLTEMPLATEUNITS = "eRLTemplateunits";
    /** <code>eRLTemplateunits</code> attribute alias. */
    public static final String ATTR_ALIAS_ERLTEMPLATEUNITS = "Units";

    /** <code>eRLTemplateunits</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERLTEMPLATEUNITS = "";
    /** Agents allowed to view the attribute eRLTemplateunits **/
    public static final String ERLTEMPLATEUNITS_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRLTemplateprice)
    /** <code>eRLTemplateprice</code> attribute id. */
    public static final String ATTR_ID_ERLTEMPLATEPRICE = "Clas_1622460596224994Atr_4_Alias";
    /** <code>eRLTemplateprice</code> attribute name. */
    public static final String ATTR_NAME_ERLTEMPLATEPRICE = "eRLTemplateprice";
    /** <code>eRLTemplateprice</code> attribute alias. */
    public static final String ATTR_ALIAS_ERLTEMPLATEPRICE = "Price";

    /** <code>eRLTemplateprice</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERLTEMPLATEPRICE = "";
    /** Agents allowed to view the attribute eRLTemplateprice **/
    public static final String ERLTEMPLATEPRICE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRLTemplatedescription)
    /** <code>eRLTemplatedescription</code> attribute id. */
    public static final String ATTR_ID_ERLTEMPLATEDESCRIPTION = "Clas_1622460596224994Atr_5_Alias";
    /** <code>eRLTemplatedescription</code> attribute name. */
    public static final String ATTR_NAME_ERLTEMPLATEDESCRIPTION = "eRLTemplatedescription";
    /** <code>eRLTemplatedescription</code> attribute alias. */
    public static final String ATTR_ALIAS_ERLTEMPLATEDESCRIPTION = "Description";

    /** <code>eRLTemplatedescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERLTEMPLATEDESCRIPTION = "";
    /** Agents allowed to view the attribute eRLTemplatedescription **/
    public static final String ERLTEMPLATEDESCRIPTION_AGENTS = "AdminUser,OperatorUser";
    // Attribute (eRLTemplatetotalLine)
    /** <code>eRLTemplatetotalLine</code> attribute id. */
    public static final String ATTR_ID_ERLTEMPLATETOTALLINE = "Clas_1622460596224994Atr_6_Alias";
    /** <code>eRLTemplatetotalLine</code> attribute name. */
    public static final String ATTR_NAME_ERLTEMPLATETOTALLINE = "eRLTemplatetotalLine";
    /** <code>eRLTemplatetotalLine</code> attribute alias. */
    public static final String ATTR_ALIAS_ERLTEMPLATETOTALLINE = "Line Total";

    /** <code>eRLTemplatetotalLine</code> attribute facet sequence. */
    public static final String PATH_FACETS_ERLTEMPLATETOTALLINE = "";
    /** Agents allowed to view the attribute eRLTemplatetotalLine **/
    public static final String ERLTEMPLATETOTALLINE_AGENTS = "AdminUser,OperatorUser";

    // Attribute (Template.eRTemplateid)
    /** <code>Template.eRTemplateid</code> identification attribute name. */
    public static final String ATTR_NAME_TEMPLATE_ERTEMPLATEID = "template.eRTemplateid";

    // Field (Template_id)
    /** <code>Template_id</code> field name. */
    public static final String FLD_ERTEMPLATETEMPLATEID = "Template_id";    
    /** <code>Template.eRTemplateid</code> attribute field name. */
    public static final String ATTR_FIELD_TEMPLATE_ERTEMPLATEID = "eRTemplateTemplateid";
    // Field (id)
    /** <code>id</code> field name. */
    public static final String FLD_ERLTEMPLATEID = "id";    
    /** <code>eRLTemplateid</code> attribute field name. */
    public static final String ATTR_FIELD_ERLTEMPLATEID = "eRLTemplateid";
    // Field (TypeCode)
    /** <code>TypeCode</code> field name. */
    public static final String FLD_EXPENSETYPETYPECODE = "TypeCode";    
    /** <code>TypeCode</code> field length. */
    public static final int FLD_EXPENSETYPETYPECODELENGTH = 5;
    /** <code>ExpenseType.expenseTypeTypeCode</code> attribute field name. */
    public static final String ATTR_FIELD_EXPENSETYPE_EXPENSETYPETYPECODE = "expenseTypeTypeCode";
    // Field (units)
    /** <code>units</code> field name. */
    public static final String FLD_ERLTEMPLATEUNITS = "units";    
    /** <code>eRLTemplateunits</code> attribute field name. */
    public static final String ATTR_FIELD_ERLTEMPLATEUNITS = "eRLTemplateunits";
    // Field (price)
    /** <code>price</code> field name. */
    public static final String FLD_ERLTEMPLATEPRICE = "price";    
    /** <code>eRLTemplateprice</code> attribute field name. */
    public static final String ATTR_FIELD_ERLTEMPLATEPRICE = "eRLTemplateprice";
    // Field (description)
    /** <code>description</code> field name. */
    public static final String FLD_ERLTEMPLATEDESCRIPTION = "description";    
    /** <code>description</code> field length. */
    public static final int FLD_ERLTEMPLATEDESCRIPTIONLENGTH = 200;
    /** <code>eRLTemplatedescription</code> attribute field name. */
    public static final String ATTR_FIELD_ERLTEMPLATEDESCRIPTION = "eRLTemplatedescription";

    // Component role (Template)
    /** <code>Template</code> role id. */
    public static final String ROLE_ID_TEMPLATE = "Agr_1622460596224865_Alias";
    /** <code>Template</code> role name. */
    public static final String ROLE_NAME_TEMPLATE = "template";
    /** <code>Template</code> role alias. */
    public static final String ROLE_ALIAS_TEMPLATE = "Template";

    /** <code>Template</code> inverse role name. */
    public static final String ROLE_INVNAME_TEMPLATE = ERTemplateConstants.ROLE_NAME_TEMPLATELINES;
    /** <code>Template</code> role facet sequence. */
    public static final String PATH_FACETS_TEMPLATE = "";
    /** <code>Template</code> role target class. */
    public static final String ROLE_TARGET_TEMPLATE = ERTemplateConstants.CLASS_NAME;

    /** Agents allowed to navigate through Template **/
    public static final String TEMPLATE_AGENTS = "AdminUser,OperatorUser";
    // Component role (ExpenseType)
    /** <code>ExpenseType</code> role id. */
    public static final String ROLE_ID_EXPENSETYPE = "Agr_1622460727296136_Alias";
    /** <code>ExpenseType</code> role name. */
    public static final String ROLE_NAME_EXPENSETYPE = "expenseType";
    /** <code>ExpenseType</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSETYPE = "ExpenseType";

    /** <code>ExpenseType</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSETYPE = ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES;
    /** <code>ExpenseType</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSETYPE = "";
    /** <code>ExpenseType</code> role target class. */
    public static final String ROLE_TARGET_EXPENSETYPE = ExpenseTypeConstants.CLASS_NAME;

    /** Agents allowed to navigate through ExpenseType **/
    public static final String EXPENSETYPE_AGENTS = "AdminUser,OperatorUser";


    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1622460596224994Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplatecreateinstancepagrTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGRTEMPLATE = "p_agrTemplate";
    /** <code>eRLTemplatecreateinstancepagrTemplate</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGRTEMPLATE = "Clas_1622460596224994Ser_1Arg_2_Alias";
    /** <code>eRLTemplatecreateinstancepagrTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGRTEMPLATE = "Template";
    /** <code>eRLTemplatecreateinstancepagrExpenseType</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGREXPENSETYPE = "p_agrExpenseType";
    /** <code>eRLTemplatecreateinstancepagrExpenseType</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGREXPENSETYPE = "Clas_1622460596224994Ser_1Arg_3_Alias";
    /** <code>eRLTemplatecreateinstancepagrExpenseType</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGREXPENSETYPE = "ExpenseType";
    /** <code>eRLTemplatecreateinstancepatrunits</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRUNITS = "p_atrunits";
    /** <code>eRLTemplatecreateinstancepatrunits</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRUNITS = "Clas_1622460596224994Ser_1Arg_4_Alias";
    /** <code>eRLTemplatecreateinstancepatrunits</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRUNITS = "Units";
    /** <code>eRLTemplatecreateinstancepatrprice</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRPRICE = "p_atrprice";
    /** <code>eRLTemplatecreateinstancepatrprice</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRPRICE = "Clas_1622460596224994Ser_1Arg_5_Alias";
    /** <code>eRLTemplatecreateinstancepatrprice</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRPRICE = "Price";
    /** <code>eRLTemplatecreateinstancepatrdescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRDESCRIPTION = "p_atrdescription";
    /** <code>eRLTemplatecreateinstancepatrdescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRDESCRIPTION = "Clas_1622460596224994Ser_1Arg_6_Alias";
    /** <code>eRLTemplatecreateinstancepatrdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRDESCRIPTION = "Description";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1622460596224994Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplatedeleteinstancepthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_ERLTEMPLATEDELETEINSTANCEPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplatedeleteinstancepthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_ERLTEMPLATEDELETEINSTANCEPTHISERLTEMPLATE = "Clas_1622460596224994Ser_2Arg_1_Alias";
    /** <code>eRLTemplatedeleteinstancepthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_ERLTEMPLATEDELETEINSTANCEPTHISERLTEMPLATE = "Expense Report Line Template";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1622460596224994Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateeditinstancepthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateeditinstancepthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPTHISERLTEMPLATE = "Clas_1622460596224994Ser_3Arg_1_Alias";
    /** <code>eRLTemplateeditinstancepthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPTHISERLTEMPLATE = "Expense Report Line Template";
    /** <code>eRLTemplateeditinstancepunits</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPUNITS = "p_units";
    /** <code>eRLTemplateeditinstancepunits</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPUNITS = "Clas_1622460596224994Ser_3Arg_2_Alias";
    /** <code>eRLTemplateeditinstancepunits</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPUNITS = "Units";
    /** <code>eRLTemplateeditinstancepprice</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPPRICE = "p_price";
    /** <code>eRLTemplateeditinstancepprice</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPPRICE = "Clas_1622460596224994Ser_3Arg_3_Alias";
    /** <code>eRLTemplateeditinstancepprice</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPPRICE = "Price";
    /** <code>eRLTemplateeditinstancepdescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPDESCRIPTION = "p_description";
    /** <code>eRLTemplateeditinstancepdescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPDESCRIPTION = "Clas_1622460596224994Ser_3Arg_4_Alias";
    /** <code>eRLTemplateeditinstancepdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPDESCRIPTION = "Description";
    // Service (editUnits)
    /** <code>editUnits</code> service id. */
    public static final String SERV_ID_EDITUNITS = "Clas_1622460596224994Ser_4_Alias";
    /** <code>editUnits</code> service name. */
    public static final String SERV_NAME_EDITUNITS = "editUnits";
    /** <code>editUnits</code> service alias. */
    public static final String SERV_ALIAS_EDITUNITS = "editUnits";
    /** Agents allowed to execute the service editUnits **/
    public static final String EDITUNITS_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateeditUnitspthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITUNITS_ERLTEMPLATEEDITUNITSPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateeditUnitspthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITUNITS_ERLTEMPLATEEDITUNITSPTHISERLTEMPLATE = "Clas_1622460596224994Ser_4Arg_1_Alias";
    /** <code>eRLTemplateeditUnitspthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITUNITS_ERLTEMPLATEEDITUNITSPTHISERLTEMPLATE = "Expense Report Line Template";
    /** <code>eRLTemplateeditUnitspUnits</code> inbound argument name. */
    public static final String ARG_NAME_EDITUNITS_ERLTEMPLATEEDITUNITSPUNITS = "pUnits";
    /** <code>eRLTemplateeditUnitspUnits</code> inbound argument id. */
    public static final String ARG_ID_EDITUNITS_ERLTEMPLATEEDITUNITSPUNITS = "Clas_1622460596224994Ser_4Arg_2_Alias";
    /** <code>eRLTemplateeditUnitspUnits</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITUNITS_ERLTEMPLATEEDITUNITSPUNITS = "Units";
    // Service (editPrice)
    /** <code>editPrice</code> service id. */
    public static final String SERV_ID_EDITPRICE = "Clas_1622460596224994Ser_5_Alias";
    /** <code>editPrice</code> service name. */
    public static final String SERV_NAME_EDITPRICE = "editPrice";
    /** <code>editPrice</code> service alias. */
    public static final String SERV_ALIAS_EDITPRICE = "editPrice";
    /** Agents allowed to execute the service editPrice **/
    public static final String EDITPRICE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateeditPricepthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITPRICE_ERLTEMPLATEEDITPRICEPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateeditPricepthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITPRICE_ERLTEMPLATEEDITPRICEPTHISERLTEMPLATE = "Clas_1622460596224994Ser_5Arg_1_Alias";
    /** <code>eRLTemplateeditPricepthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITPRICE_ERLTEMPLATEEDITPRICEPTHISERLTEMPLATE = "Expense Report Line Template";
    /** <code>eRLTemplateeditPricepPrice</code> inbound argument name. */
    public static final String ARG_NAME_EDITPRICE_ERLTEMPLATEEDITPRICEPPRICE = "pPrice";
    /** <code>eRLTemplateeditPricepPrice</code> inbound argument id. */
    public static final String ARG_ID_EDITPRICE_ERLTEMPLATEEDITPRICEPPRICE = "Clas_1622460596224994Ser_5Arg_2_Alias";
    /** <code>eRLTemplateeditPricepPrice</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITPRICE_ERLTEMPLATEEDITPRICEPPRICE = "Price";
    // Service (editDescription)
    /** <code>editDescription</code> service id. */
    public static final String SERV_ID_EDITDESCRIPTION = "Clas_1622460596224994Ser_6_Alias";
    /** <code>editDescription</code> service name. */
    public static final String SERV_NAME_EDITDESCRIPTION = "editDescription";
    /** <code>editDescription</code> service alias. */
    public static final String SERV_ALIAS_EDITDESCRIPTION = "editDescription";
    /** Agents allowed to execute the service editDescription **/
    public static final String EDITDESCRIPTION_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateeditDescriptionpthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateeditDescriptionpthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPTHISERLTEMPLATE = "Clas_1622460596224994Ser_6Arg_1_Alias";
    /** <code>eRLTemplateeditDescriptionpthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPTHISERLTEMPLATE = "Expense Report Line Template";
    /** <code>eRLTemplateeditDescriptionpDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "pDescription";
    /** <code>eRLTemplateeditDescriptionpDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "Clas_1622460596224994Ser_6Arg_2_Alias";
    /** <code>eRLTemplateeditDescriptionpDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPDESCRIPTION = "Description";
    // Service (clearUnits)
    /** <code>clearUnits</code> service id. */
    public static final String SERV_ID_CLEARUNITS = "Clas_1622460596224994Ser_7_Alias";
    /** <code>clearUnits</code> service name. */
    public static final String SERV_NAME_CLEARUNITS = "clearUnits";
    /** <code>clearUnits</code> service alias. */
    public static final String SERV_ALIAS_CLEARUNITS = "clearUnits";
    /** Agents allowed to execute the service clearUnits **/
    public static final String CLEARUNITS_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateclearUnitspthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CLEARUNITS_ERLTEMPLATECLEARUNITSPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateclearUnitspthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_CLEARUNITS_ERLTEMPLATECLEARUNITSPTHISERLTEMPLATE = "Clas_1622460596224994Ser_7Arg_1_Alias";
    /** <code>eRLTemplateclearUnitspthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CLEARUNITS_ERLTEMPLATECLEARUNITSPTHISERLTEMPLATE = "Expense Report Line Template";
    // Service (clearPrice)
    /** <code>clearPrice</code> service id. */
    public static final String SERV_ID_CLEARPRICE = "Clas_1622460596224994Ser_8_Alias";
    /** <code>clearPrice</code> service name. */
    public static final String SERV_NAME_CLEARPRICE = "clearPrice";
    /** <code>clearPrice</code> service alias. */
    public static final String SERV_ALIAS_CLEARPRICE = "clearPrice";
    /** Agents allowed to execute the service clearPrice **/
    public static final String CLEARPRICE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateclearPricepthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CLEARPRICE_ERLTEMPLATECLEARPRICEPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateclearPricepthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_CLEARPRICE_ERLTEMPLATECLEARPRICEPTHISERLTEMPLATE = "Clas_1622460596224994Ser_8Arg_1_Alias";
    /** <code>eRLTemplateclearPricepthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CLEARPRICE_ERLTEMPLATECLEARPRICEPTHISERLTEMPLATE = "Expense Report Line Template";
    // Service (clearDescription)
    /** <code>clearDescription</code> service id. */
    public static final String SERV_ID_CLEARDESCRIPTION = "Clas_1622460596224994Ser_9_Alias";
    /** <code>clearDescription</code> service name. */
    public static final String SERV_NAME_CLEARDESCRIPTION = "clearDescription";
    /** <code>clearDescription</code> service alias. */
    public static final String SERV_ALIAS_CLEARDESCRIPTION = "clearDescription";
    /** Agents allowed to execute the service clearDescription **/
    public static final String CLEARDESCRIPTION_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>eRLTemplateclearDescriptionpthisERLTemplate</code> inbound argument name. */
    public static final String ARG_NAME_CLEARDESCRIPTION_ERLTEMPLATECLEARDESCRIPTIONPTHISERLTEMPLATE = "p_thisERLTemplate";
    /** <code>eRLTemplateclearDescriptionpthisERLTemplate</code> inbound argument id. */
    public static final String ARG_ID_CLEARDESCRIPTION_ERLTEMPLATECLEARDESCRIPTIONPTHISERLTEMPLATE = "Clas_1622460596224994Ser_9Arg_1_Alias";
    /** <code>eRLTemplateclearDescriptionpthisERLTemplate</code> inbound argument alias. */
    public static final String ARG_ALIAS_CLEARDESCRIPTION_ERLTEMPLATECLEARDESCRIPTIONPTHISERLTEMPLATE = "Expense Report Line Template";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_ERLTEMPLATEUNITS.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_ERLTEMPLATEPRICE.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_ERLTEMPLATEDESCRIPTION.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_ERLTEMPLATETOTALLINE.toUpperCase(), Constants.Type.REAL.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_ERLTEMPLATEID.toUpperCase(), ERLTEMPLATEID_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERLTEMPLATEUNITS.toUpperCase(), ERLTEMPLATEUNITS_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERLTEMPLATEPRICE.toUpperCase(), ERLTEMPLATEPRICE_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERLTEMPLATEDESCRIPTION.toUpperCase(), ERLTEMPLATEDESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_ERLTEMPLATETOTALLINE.toUpperCase(), ERLTEMPLATETOTALLINE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_TEMPLATE.toUpperCase(), TEMPLATE_AGENTS);
        roleAgents.put(ROLE_NAME_EXPENSETYPE.toUpperCase(), EXPENSETYPE_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'ERLTemplate', it returns the identification keys
     * - If className is a facet of the inheritance net of 'ERLTemplate', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ROLE_NAME_TEMPLATE + "." + ERTemplateConstants.ATTR_FIELD_ERTEMPLATEID);
            returnList.add(ATTR_FIELD_ERLTEMPLATEID);
        }
        // Facet 'ERLTemplate' (This facet)
        if (ERLTemplateConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ROLE_NAME_TEMPLATE + "." + ERTemplateConstants.ATTR_FIELD_ERTEMPLATEID);
            returnList.add(ATTR_FIELD_ERLTEMPLATEID);
        }
        return returnList;
    }
}
