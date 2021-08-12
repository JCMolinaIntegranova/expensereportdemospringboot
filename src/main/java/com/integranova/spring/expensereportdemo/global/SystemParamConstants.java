package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>SystemParam</code> model class.
 */
public final class SystemParamConstants {

    private SystemParamConstants() {

    }

    // Class
    /** <code>SystemParam</code> class id. */
    public static final String CLASS_ID = "Clas_1622477111296378_Alias";
    /** <code>SystemParam</code> class name. */
    public static final String CLASS_NAME = "SystemParam";
    /** <code>SystemParam</code> class alias. */
    public static final String CLASS_ALIAS = "System Parameter";
    /** <code>SystemParam</code> class table name. */
    public static final String TBL_NAME = "SystemParam";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "systemParamparamCode,systemParamname,systemParamtypeName,systemParamparamValue";

    public static final String DSDSSYSTEMPARAMS = "DS_SystemParams";
    

    // Attribute (systemParamparamCode)
    /** <code>systemParamparamCode</code> attribute id. */
    public static final String ATTR_ID_SYSTEMPARAMPARAMCODE = "Clas_1622477111296378Atr_2_Alias";
    /** <code>systemParamparamCode</code> attribute name. */
    public static final String ATTR_NAME_SYSTEMPARAMPARAMCODE = "systemParamparamCode";
    /** <code>systemParamparamCode</code> attribute alias. */
    public static final String ATTR_ALIAS_SYSTEMPARAMPARAMCODE = "Code";

    /** <code>systemParamparamCode</code> attribute facet sequence. */
    public static final String PATH_FACETS_SYSTEMPARAMPARAMCODE = "";
    /** Agents allowed to view the attribute systemParamparamCode **/
    public static final String SYSTEMPARAMPARAMCODE_AGENTS = "AdminUser";
    // Attribute (systemParamname)
    /** <code>systemParamname</code> attribute id. */
    public static final String ATTR_ID_SYSTEMPARAMNAME = "Clas_1622477111296378Atr_3_Alias";
    /** <code>systemParamname</code> attribute name. */
    public static final String ATTR_NAME_SYSTEMPARAMNAME = "systemParamname";
    /** <code>systemParamname</code> attribute alias. */
    public static final String ATTR_ALIAS_SYSTEMPARAMNAME = "Name";

    /** <code>systemParamname</code> attribute facet sequence. */
    public static final String PATH_FACETS_SYSTEMPARAMNAME = "";
    /** Agents allowed to view the attribute systemParamname **/
    public static final String SYSTEMPARAMNAME_AGENTS = "AdminUser";
    // Attribute (systemParamdescription)
    /** <code>systemParamdescription</code> attribute id. */
    public static final String ATTR_ID_SYSTEMPARAMDESCRIPTION = "Clas_1622477111296378Atr_4_Alias";
    /** <code>systemParamdescription</code> attribute name. */
    public static final String ATTR_NAME_SYSTEMPARAMDESCRIPTION = "systemParamdescription";
    /** <code>systemParamdescription</code> attribute alias. */
    public static final String ATTR_ALIAS_SYSTEMPARAMDESCRIPTION = "Description";

    /** <code>systemParamdescription</code> attribute facet sequence. */
    public static final String PATH_FACETS_SYSTEMPARAMDESCRIPTION = "";
    /** Agents allowed to view the attribute systemParamdescription **/
    public static final String SYSTEMPARAMDESCRIPTION_AGENTS = "AdminUser";
    // Attribute (systemParamtypeName)
    /** <code>systemParamtypeName</code> attribute id. */
    public static final String ATTR_ID_SYSTEMPARAMTYPENAME = "Clas_1622477111296378Atr_5_Alias";
    /** <code>systemParamtypeName</code> attribute name. */
    public static final String ATTR_NAME_SYSTEMPARAMTYPENAME = "systemParamtypeName";
    /** <code>systemParamtypeName</code> attribute alias. */
    public static final String ATTR_ALIAS_SYSTEMPARAMTYPENAME = "Type";

    /** <code>systemParamtypeName</code> attribute facet sequence. */
    public static final String PATH_FACETS_SYSTEMPARAMTYPENAME = "";
    /** Agents allowed to view the attribute systemParamtypeName **/
    public static final String SYSTEMPARAMTYPENAME_AGENTS = "AdminUser";
    // Attribute (systemParamparamValue)
    /** <code>systemParamparamValue</code> attribute id. */
    public static final String ATTR_ID_SYSTEMPARAMPARAMVALUE = "Clas_1622477111296378Atr_6_Alias";
    /** <code>systemParamparamValue</code> attribute name. */
    public static final String ATTR_NAME_SYSTEMPARAMPARAMVALUE = "systemParamparamValue";
    /** <code>systemParamparamValue</code> attribute alias. */
    public static final String ATTR_ALIAS_SYSTEMPARAMPARAMVALUE = "Value";

    /** <code>systemParamparamValue</code> attribute facet sequence. */
    public static final String PATH_FACETS_SYSTEMPARAMPARAMVALUE = "";
    /** Agents allowed to view the attribute systemParamparamValue **/
    public static final String SYSTEMPARAMPARAMVALUE_AGENTS = "AdminUser";


    // Field (paramCode)
    /** <code>paramCode</code> field name. */
    public static final String FLD_SYSTEMPARAMPARAMCODE = "paramCode";    
    /** <code>paramCode</code> field length. */
    public static final int FLD_SYSTEMPARAMPARAMCODELENGTH = 5;
    /** <code>systemParamparamCode</code> attribute field name. */
    public static final String ATTR_FIELD_SYSTEMPARAMPARAMCODE = "systemParamparamCode";
    // Field (name)
    /** <code>name</code> field name. */
    public static final String FLD_SYSTEMPARAMNAME = "name";    
    /** <code>name</code> field length. */
    public static final int FLD_SYSTEMPARAMNAMELENGTH = 20;
    /** <code>systemParamname</code> attribute field name. */
    public static final String ATTR_FIELD_SYSTEMPARAMNAME = "systemParamname";
    // Field (description)
    /** <code>description</code> field name. */
    public static final String FLD_SYSTEMPARAMDESCRIPTION = "description";    
    /** <code>systemParamdescription</code> attribute field name. */
    public static final String ATTR_FIELD_SYSTEMPARAMDESCRIPTION = "systemParamdescription";
    // Field (typeName)
    /** <code>typeName</code> field name. */
    public static final String FLD_SYSTEMPARAMTYPENAME = "typeName";    
    /** <code>typeName</code> field length. */
    public static final int FLD_SYSTEMPARAMTYPENAMELENGTH = 10;
    /** <code>systemParamtypeName</code> attribute field name. */
    public static final String ATTR_FIELD_SYSTEMPARAMTYPENAME = "systemParamtypeName";
    // Field (paramValue)
    /** <code>paramValue</code> field name. */
    public static final String FLD_SYSTEMPARAMPARAMVALUE = "paramValue";    
    /** <code>paramValue</code> field length. */
    public static final int FLD_SYSTEMPARAMPARAMVALUELENGTH = 100;
    /** <code>systemParamparamValue</code> attribute field name. */
    public static final String ATTR_FIELD_SYSTEMPARAMPARAMVALUE = "systemParamparamValue";



    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1622477111296378Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>systemParamcreateinstancepatrparamCode</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMCODE = "p_atrparamCode";
    /** <code>systemParamcreateinstancepatrparamCode</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMCODE = "Clas_1622477111296378Ser_1Arg_2_Alias";
    /** <code>systemParamcreateinstancepatrparamCode</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMCODE = "Code";
    /** <code>systemParamcreateinstancepatrname</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRNAME = "p_atrname";
    /** <code>systemParamcreateinstancepatrname</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRNAME = "Clas_1622477111296378Ser_1Arg_3_Alias";
    /** <code>systemParamcreateinstancepatrname</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRNAME = "Name";
    /** <code>systemParamcreateinstancepatrdescription</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRDESCRIPTION = "p_atrdescription";
    /** <code>systemParamcreateinstancepatrdescription</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRDESCRIPTION = "Clas_1622477111296378Ser_1Arg_4_Alias";
    /** <code>systemParamcreateinstancepatrdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRDESCRIPTION = "Description";
    /** <code>systemParamcreateinstancepatrtypeName</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRTYPENAME = "p_atrtypeName";
    /** <code>systemParamcreateinstancepatrtypeName</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRTYPENAME = "Clas_1622477111296378Ser_1Arg_5_Alias";
    /** <code>systemParamcreateinstancepatrtypeName</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRTYPENAME = "Type";
    /** <code>systemParamcreateinstancepatrparamValue</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMVALUE = "p_atrparamValue";
    /** <code>systemParamcreateinstancepatrparamValue</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMVALUE = "Clas_1622477111296378Ser_1Arg_6_Alias";
    /** <code>systemParamcreateinstancepatrparamValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMVALUE = "Value";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1622477111296378Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>systemParamdeleteinstancepthisSystemParam</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_SYSTEMPARAMDELETEINSTANCEPTHISSYSTEMPARAM = "p_thisSystemParam";
    /** <code>systemParamdeleteinstancepthisSystemParam</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_SYSTEMPARAMDELETEINSTANCEPTHISSYSTEMPARAM = "Clas_1622477111296378Ser_2Arg_1_Alias";
    /** <code>systemParamdeleteinstancepthisSystemParam</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_SYSTEMPARAMDELETEINSTANCEPTHISSYSTEMPARAM = "System Parameter";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1622477111296378Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>systemParameditinstancepthisSystemParam</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTHISSYSTEMPARAM = "p_thisSystemParam";
    /** <code>systemParameditinstancepthisSystemParam</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTHISSYSTEMPARAM = "Clas_1622477111296378Ser_3Arg_1_Alias";
    /** <code>systemParameditinstancepthisSystemParam</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTHISSYSTEMPARAM = "System Parameter";
    /** <code>systemParameditinstancepname</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPNAME = "p_name";
    /** <code>systemParameditinstancepname</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPNAME = "Clas_1622477111296378Ser_3Arg_2_Alias";
    /** <code>systemParameditinstancepname</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPNAME = "Name";
    /** <code>systemParameditinstancepdescription</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPDESCRIPTION = "p_description";
    /** <code>systemParameditinstancepdescription</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPDESCRIPTION = "Clas_1622477111296378Ser_3Arg_3_Alias";
    /** <code>systemParameditinstancepdescription</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPDESCRIPTION = "Description";
    /** <code>systemParameditinstanceptypeName</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTYPENAME = "p_typeName";
    /** <code>systemParameditinstanceptypeName</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTYPENAME = "Clas_1622477111296378Ser_3Arg_4_Alias";
    /** <code>systemParameditinstanceptypeName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTYPENAME = "Type";
    /** <code>systemParameditinstancepparamValue</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPPARAMVALUE = "p_paramValue";
    /** <code>systemParameditinstancepparamValue</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPPARAMVALUE = "Clas_1622477111296378Ser_3Arg_5_Alias";
    /** <code>systemParameditinstancepparamValue</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPPARAMVALUE = "Value";


    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_SYSTEMPARAMNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_SYSTEMPARAMDESCRIPTION.toUpperCase(), Constants.Type.TEXT.getTypeName());
        attributeTypes.put(ATTR_NAME_SYSTEMPARAMTYPENAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_SYSTEMPARAMPARAMVALUE.toUpperCase(), Constants.Type.STRING.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_SYSTEMPARAMPARAMCODE.toUpperCase(), SYSTEMPARAMPARAMCODE_AGENTS);
    	attributeAgents.put(ATTR_NAME_SYSTEMPARAMNAME.toUpperCase(), SYSTEMPARAMNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_SYSTEMPARAMDESCRIPTION.toUpperCase(), SYSTEMPARAMDESCRIPTION_AGENTS);
    	attributeAgents.put(ATTR_NAME_SYSTEMPARAMTYPENAME.toUpperCase(), SYSTEMPARAMTYPENAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_SYSTEMPARAMPARAMVALUE.toUpperCase(), SYSTEMPARAMPARAMVALUE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'SystemParam', it returns the identification keys
     * - If className is a facet of the inheritance net of 'SystemParam', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_SYSTEMPARAMPARAMCODE);
        }
        // Facet 'SystemParam' (This facet)
        if (SystemParamConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_SYSTEMPARAMPARAMCODE);
        }
        return returnList;
    }
}
