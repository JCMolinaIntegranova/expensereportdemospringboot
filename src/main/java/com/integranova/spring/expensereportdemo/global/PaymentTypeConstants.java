package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>PaymentType</code> model class.
 */
public final class PaymentTypeConstants {

    private PaymentTypeConstants() {

    }

    // Class
    /** <code>PaymentType</code> class id. */
    public static final String CLASS_ID = "Clas_1057569177600423_Alias";
    /** <code>PaymentType</code> class name. */
    public static final String CLASS_NAME = "PaymentType";
    /** <code>PaymentType</code> class alias. */
    public static final String CLASS_ALIAS = "Payment Type";
    /** <code>PaymentType</code> class table name. */
    public static final String TBL_NAME = "PaymentType";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "paymentTypeidPaymentType,paymentTypePayDescription";

    public static final String DSDSPAYMENTTYPE = "DS_PaymentType";
    public static final String DSDSPAYMENTTYPESUP = "DS_PaymentTypeSup";
    

    // Attribute (paymentTypeidPaymentType)
    /** <code>paymentTypeidPaymentType</code> attribute id. */
    public static final String ATTR_ID_PAYMENTTYPEIDPAYMENTTYPE = "Clas_1057569177600423Atr_1_Alias";
    /** <code>paymentTypeidPaymentType</code> attribute name. */
    public static final String ATTR_NAME_PAYMENTTYPEIDPAYMENTTYPE = "paymentTypeidPaymentType";
    /** <code>paymentTypeidPaymentType</code> attribute alias. */
    public static final String ATTR_ALIAS_PAYMENTTYPEIDPAYMENTTYPE = "Payment Type";

    /** <code>paymentTypeidPaymentType</code> attribute facet sequence. */
    public static final String PATH_FACETS_PAYMENTTYPEIDPAYMENTTYPE = "";
    /** Agents allowed to view the attribute paymentTypeidPaymentType **/
    public static final String PAYMENTTYPEIDPAYMENTTYPE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (paymentTypePayDescription)
    /** <code>paymentTypePayDescription</code> attribute id. */
    public static final String ATTR_ID_PAYMENTTYPEPAYDESCRIPTION = "Clas_1057569177600423Atr_2_Alias";
    /** <code>paymentTypePayDescription</code> attribute name. */
    public static final String ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION = "paymentTypePayDescription";
    /** <code>paymentTypePayDescription</code> attribute alias. */
    public static final String ATTR_ALIAS_PAYMENTTYPEPAYDESCRIPTION = "Description";

    /** <code>paymentTypePayDescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_PAYMENTTYPEPAYDESCRIPTION = "";
    /** Agents allowed to view the attribute paymentTypePayDescription **/
    public static final String PAYMENTTYPEPAYDESCRIPTION_AGENTS = "AdminUser,OperatorUser";


    // Field (id_PaymentType)
    /** <code>id_PaymentType</code> field name. */
    public static final String FLD_PAYMENTTYPEIDPAYMENTTYPE = "id_PaymentType";    
    /** <code>id_PaymentType</code> field length. */
    public static final int FLD_PAYMENTTYPEIDPAYMENTTYPELENGTH = 5;
    /** <code>paymentTypeidPaymentType</code> attribute field name. */
    public static final String ATTR_FIELD_PAYMENTTYPEIDPAYMENTTYPE = "paymentTypeidPaymentType";
    // Field (PayDescription)
    /** <code>PayDescription</code> field name. */
    public static final String FLD_PAYMENTTYPEPAYDESCRIPTION = "PayDescription";    
    /** <code>PayDescription</code> field length. */
    public static final int FLD_PAYMENTTYPEPAYDESCRIPTIONLENGTH = 50;
    /** <code>paymentTypePayDescription</code> attribute field name. */
    public static final String ATTR_FIELD_PAYMENTTYPEPAYDESCRIPTION = "paymentTypePayDescription";


    // Compound role (ExpenseReport)
    /** <code>ExpenseReport</code> role id. */
    public static final String ROLE_ID_EXPENSEREPORT = "Agr_1057569177600784_Alias";
    /** <code>ExpenseReport</code> role name. */
    public static final String ROLE_NAME_EXPENSEREPORT = "expenseReport";
    /** <code>PaymentType</code> role alias. */
    public static final String ROLE_ALIAS_EXPENSEREPORT = "Expense Report";


    /** <code>ExpenseReport</code> inverse role name. */
    public static final String ROLE_INVNAME_EXPENSEREPORT = ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE;
    /** <code>ExpenseReport</code> role facet sequence. */
    public static final String PATH_FACETS_EXPENSEREPORT = "";
    /** <code>ExpenseReport</code> role target class. */
    public static final String ROLE_TARGET_EXPENSEREPORT = ExpenseReportConstants.CLASS_NAME;
    /** Agents allowed to navigate through ExpenseReport **/
    public static final String EXPENSEREPORT_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1057569177600423Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>paymentTypecreateinstancepatridPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRIDPAYMENTTYPE = "p_atrid_PaymentType";
    /** <code>paymentTypecreateinstancepatridPaymentType</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRIDPAYMENTTYPE = "Clas_1057569177600423Ser_1Arg_1_Alias";
    /** <code>paymentTypecreateinstancepatridPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRIDPAYMENTTYPE = "Payment Type";
    /** <code>paymentTypecreateinstancepatrPayDescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRPAYDESCRIPTION = "p_atrPayDescription";
    /** <code>paymentTypecreateinstancepatrPayDescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRPAYDESCRIPTION = "Clas_1057569177600423Ser_1Arg_2_Alias";
    /** <code>paymentTypecreateinstancepatrPayDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRPAYDESCRIPTION = "Description";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1057569177600423Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>paymentTypedeleteinstancepthisPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_PAYMENTTYPEDELETEINSTANCEPTHISPAYMENTTYPE = "p_thisPaymentType";
    /** <code>paymentTypedeleteinstancepthisPaymentType</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_PAYMENTTYPEDELETEINSTANCEPTHISPAYMENTTYPE = "Clas_1057569177600423Ser_2Arg_1_Alias";
    /** <code>paymentTypedeleteinstancepthisPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_PAYMENTTYPEDELETEINSTANCEPTHISPAYMENTTYPE = "Payment Type";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1057569177600423Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>paymentTypeeditinstancepthisPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPTHISPAYMENTTYPE = "p_thisPaymentType";
    /** <code>paymentTypeeditinstancepthisPaymentType</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPTHISPAYMENTTYPE = "Clas_1057569177600423Ser_3Arg_1_Alias";
    /** <code>paymentTypeeditinstancepthisPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPTHISPAYMENTTYPE = "Payment Type";
    /** <code>paymentTypeeditinstancepPayDescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPPAYDESCRIPTION = "p_PayDescription";
    /** <code>paymentTypeeditinstancepPayDescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPPAYDESCRIPTION = "Clas_1057569177600423Ser_3Arg_2_Alias";
    /** <code>paymentTypeeditinstancepPayDescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPPAYDESCRIPTION = "Description";
    // Service (InsPaymentType)
    /** <code>InsPaymentType</code> service id. */
    public static final String SERV_ID_INSPAYMENTTYPE = "Clas_1057569177600423Ser_4_Alias";
    /** <code>InsPaymentType</code> service name. */
    public static final String SERV_NAME_INSPAYMENTTYPE = "InsPaymentType";
    /** <code>InsPaymentType</code> service alias. */
    public static final String SERV_ALIAS_INSPAYMENTTYPE = "InsPaymentType";
    /** Agents allowed to execute the service InsPaymentType **/
    public static final String INSPAYMENTTYPE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>paymentTypeInsPaymentTypepthisPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPTHISPAYMENTTYPE = "p_thisPaymentType";
    /** <code>paymentTypeInsPaymentTypepthisPaymentType</code> inbound argument id. */
    public static final String ARG_ID_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPTHISPAYMENTTYPE = "Clas_1057569177600423Ser_4Arg_1_Alias";
    /** <code>paymentTypeInsPaymentTypepthisPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPTHISPAYMENTTYPE = "Payment Type";
    /** <code>paymentTypeInsPaymentTypepevcExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPEVCEXPENSEREPORT = "p_evcExpenseReport";
    /** <code>paymentTypeInsPaymentTypepevcExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPEVCEXPENSEREPORT = "Clas_1057569177600423Ser_4Arg_2_Alias";
    /** <code>paymentTypeInsPaymentTypepevcExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPEVCEXPENSEREPORT = "Expense Report";
    // Service (DelPaymentType)
    /** <code>DelPaymentType</code> service id. */
    public static final String SERV_ID_DELPAYMENTTYPE = "Clas_1057569177600423Ser_5_Alias";
    /** <code>DelPaymentType</code> service name. */
    public static final String SERV_NAME_DELPAYMENTTYPE = "DelPaymentType";
    /** <code>DelPaymentType</code> service alias. */
    public static final String SERV_ALIAS_DELPAYMENTTYPE = "DelPaymentType";
    /** Agents allowed to execute the service DelPaymentType **/
    public static final String DELPAYMENTTYPE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>paymentTypeDelPaymentTypepthisPaymentType</code> inbound argument name. */
    public static final String ARG_NAME_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPTHISPAYMENTTYPE = "p_thisPaymentType";
    /** <code>paymentTypeDelPaymentTypepthisPaymentType</code> inbound argument id. */
    public static final String ARG_ID_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPTHISPAYMENTTYPE = "Clas_1057569177600423Ser_5Arg_1_Alias";
    /** <code>paymentTypeDelPaymentTypepthisPaymentType</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPTHISPAYMENTTYPE = "Payment Type";
    /** <code>paymentTypeDelPaymentTypepevcExpenseReport</code> inbound argument name. */
    public static final String ARG_NAME_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPEVCEXPENSEREPORT = "p_evcExpenseReport";
    /** <code>paymentTypeDelPaymentTypepevcExpenseReport</code> inbound argument id. */
    public static final String ARG_ID_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPEVCEXPENSEREPORT = "Clas_1057569177600423Ser_5Arg_2_Alias";
    /** <code>paymentTypeDelPaymentTypepevcExpenseReport</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPEVCEXPENSEREPORT = "Expense Report";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION.toUpperCase(), Constants.Type.STRING.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_PAYMENTTYPEIDPAYMENTTYPE.toUpperCase(), PAYMENTTYPEIDPAYMENTTYPE_AGENTS);
    	attributeAgents.put(ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION.toUpperCase(), PAYMENTTYPEPAYDESCRIPTION_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'PaymentType', it returns the identification keys
     * - If className is a facet of the inheritance net of 'PaymentType', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_PAYMENTTYPEIDPAYMENTTYPE);
        }
        // Facet 'PaymentType' (This facet)
        if (PaymentTypeConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_PAYMENTTYPEIDPAYMENTTYPE);
        }
        return returnList;
    }
}
