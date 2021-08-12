package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>AdminUser</code> model class.
 */
public final class AdminUserConstants {

    private AdminUserConstants() {

    }

    // Class
    /** <code>AdminUser</code> class id. */
    public static final String CLASS_ID = "Clas_1468422160384126_Alias";
    /** <code>AdminUser</code> class name. */
    public static final String CLASS_NAME = "AdminUser";
    /** <code>AdminUser</code> class alias. */
    public static final String CLASS_ALIAS = "AdminUser";
    /** <code>AdminUser</code> class table name. */
    public static final String TBL_NAME = "AdminUser";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "appUserLogin,passWord";

    
    // Facet (AppUser)
    /** <code>AppUser</code> facet sequence. */
    public static final String CLASS_FACETS_APPUSER = AppUserConstants.CLASS_NAME;
	
    public static final String CLASS_FACET_GETTER_APPUSER = Constants.PARENT_PREFIX + AppUserConstants.CLASS_NAME;
    // Facet (OperatorUser)
    /** <code>OperatorUser</code> facet sequence. */
    public static final String CLASS_FACETS_OPERATORUSER = AppUserConstants.CLASS_NAME + "." + OperatorUserConstants.CLASS_NAME;
	
    public static final String CLASS_FACET_GETTER_OPERATORUSER = CLASS_FACET_GETTER_APPUSER + "." + AppUserConstants.CLASS_FACET_GETTER_OPERATORUSER;

    // Attribute (appUserLogin)
    /** <code>appUserLogin</code> attribute id. */
    public static final String ATTR_ID_APPUSERLOGIN = AppUserConstants.ATTR_ID_APPUSERLOGIN;
    /** <code>appUserLogin</code> attribute name. */
    public static final String ATTR_NAME_APPUSERLOGIN = AppUserConstants.ATTR_NAME_APPUSERLOGIN;
    /** <code>appUserLogin</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERLOGIN = AppUserConstants.ATTR_ALIAS_APPUSERLOGIN;

    /** <code>appUserLogin</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERLOGIN = AppUserConstants.CLASS_NAME;
    // Attribute (appUserUserName)
    /** <code>appUserUserName</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERNAME = AppUserConstants.ATTR_ID_APPUSERUSERNAME;
    /** <code>appUserUserName</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERNAME = AppUserConstants.ATTR_NAME_APPUSERUSERNAME;
    /** <code>appUserUserName</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERNAME = AppUserConstants.ATTR_ALIAS_APPUSERUSERNAME;

    /** <code>appUserUserName</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERNAME = AppUserConstants.CLASS_NAME;
    // Attribute (appUserUserSurname)
    /** <code>appUserUserSurname</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERSURNAME = AppUserConstants.ATTR_ID_APPUSERUSERSURNAME;
    /** <code>appUserUserSurname</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERSURNAME = AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME;
    /** <code>appUserUserSurname</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERSURNAME = AppUserConstants.ATTR_ALIAS_APPUSERUSERSURNAME;

    /** <code>appUserUserSurname</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERSURNAME = AppUserConstants.CLASS_NAME;
    // Attribute (appUserUserType)
    /** <code>appUserUserType</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERTYPE = AppUserConstants.ATTR_ID_APPUSERUSERTYPE;
    /** <code>appUserUserType</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERTYPE = AppUserConstants.ATTR_NAME_APPUSERUSERTYPE;
    /** <code>appUserUserType</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERTYPE = AppUserConstants.ATTR_ALIAS_APPUSERUSERTYPE;

    /** <code>appUserUserType</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERTYPE = AppUserConstants.CLASS_NAME;


    // Field (Login)
    /** <code>Login</code> field name. */
    public static final String FLD_APPUSERLOGIN = "Login";    
    /** <code>Login</code> field length. */
    public static final int FLD_APPUSERLOGINLENGTH = 50;
    /** <code>appUserLogin</code> attribute field name. */
    public static final String ATTR_FIELD_APPUSERLOGIN = "appUserLogin";
    // Field (PassWord)
    /** <code>PassWord</code> field name. */
    public static final String FLD_P4SSW0RD = "PassWord";





    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.putAll(AppUserConstants.ATTRIBUTE_TYPES);
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
        attributeAgents.putAll(AppUserConstants.ATTRIBUTE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'AdminUser', it returns the identification keys
     * - If className is a facet of the inheritance net of 'AdminUser', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'AppUser'
        if (AppUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'OperatorUser'
        if (OperatorUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'AdminUser' (This facet)
        if (AdminUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        return returnList;
    }
}
