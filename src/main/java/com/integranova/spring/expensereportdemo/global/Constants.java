package com.integranova.spring.expensereportdemo.global;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.utils.Agent;

/**
 * Class with the constants relative to the project.
 */
public final class Constants {

    public static final String REGEXP_DOT_SEPARATOR = "\\.";
    public static final String ROLENAMEPREFIX = "ROLE_NAME_";
    public static final String ATTRNAMEPREFIX = "ATTR_NAME_";
    public static final String ATTRFIELDPREFIX = "ATTR_FIELD_";
    public static final String PARENT_PREFIX = "parent";
    public static final String CHILD_PREFIX = "child";
    
    /** Name of the persistence unit **/
    public static final String PERSISTENCEUNITNAME = "Expensereportdemo";

    /** Default block size. */
    public static final int DEFAULT_BLOCKSIZE = 40;
    /** Default password length. */
    public static final int PASSWORDLENGTH = 8;
    // Intermediate relation (TM_EmployeeTeam)
    /** <code>TM_EmployeeTeam</code> intermediate relation table name. */
    public static final String TBL_NAME_EMPLOYEETEAM = "TM_EmployeeTeam";
    public static final String ROLE_TABLE_TEAM_EMPLOYEES = TBL_NAME_EMPLOYEETEAM;
    public static final String ROLE_TABLE_EMPLOYEE_TEAMS = TBL_NAME_EMPLOYEETEAM;
    /** <code>employeeEmployeeidEmployee</code> field name. */
    public static final String FLD_TMEMPLOYEETEAM_EMPLOYEEEMPLOYEEIDEMPLOYEE = "employeeEmployeeidEmployee";
    /** <code>employeeEmployeeidEmployee</code> field length. */
    public static final int FLD_TMEMPLOYEETEAM_EMPLOYEEEMPLOYEEIDEMPLOYEELENGTH = 10;
    /** <code>teamTeamid</code> field name. */
    public static final String FLD_TMEMPLOYEETEAM_TEAMTEAMID = "teamTeamid";
    // Intermediate relation (TM_ProjectERTemplate)
    /** <code>TM_ProjectERTemplate</code> intermediate relation table name. */
    public static final String TBL_NAME_PROJECTERTEMPLATE = "TM_ProjectERTemplate";
    public static final String ROLE_TABLE_ERTEMPLATE_PROJECTS = TBL_NAME_PROJECTERTEMPLATE;
    public static final String ROLE_TABLE_PROJECT_ERTEMPLATES = TBL_NAME_PROJECTERTEMPLATE;
    /** <code>projectProjectidProject</code> field name. */
    public static final String FLD_TMPROJECTERTEMPLATE_PROJECTPROJECTIDPROJECT = "projectProjectidProject";
    /** <code>eRTemplateERTemplateid</code> field name. */
    public static final String FLD_TMPROJECTERTEMPLATE_ERTEMPLATEERTEMPLATEID = "eRTemplateERTemplateid";


    public enum ModelClasses {
        GLOBAL, USR_FUNCTIONS, EMPLOYEE, EXPENSELINE, EXPENSEREPORT, PAYMENTTYPE, PROJECT, EXPENSETYPE, EXPENSECURRENCY, ASSIGNMENT, APPUSER, ADMINUSER, OPERATORUSER, TEAM, ERTEMPLATE, ERLTEMPLATE, EXCHANGEHISTORY, SYSTEMPARAM;
    }

    /** <code>Employee</code> Model class name. */
    public static final String EMPLOYEE = "Employee";
    /** <code>ExpenseLine</code> Model class name. */
    public static final String EXPENSELINE = "ExpenseLine";
    /** <code>ExpenseReport</code> Model class name. */
    public static final String EXPENSEREPORT = "ExpenseReport";
    /** <code>PaymentType</code> Model class name. */
    public static final String PAYMENTTYPE = "PaymentType";
    /** <code>Project</code> Model class name. */
    public static final String PROJECT = "Project";
    /** <code>ExpenseType</code> Model class name. */
    public static final String EXPENSETYPE = "ExpenseType";
    /** <code>ExpenseCurrency</code> Model class name. */
    public static final String EXPENSECURRENCY = "ExpenseCurrency";
    /** <code>Assignment</code> Model class name. */
    public static final String ASSIGNMENT = "Assignment";
    /** <code>AppUser</code> Model class name. */
    public static final String APPUSER = "AppUser";
    /** <code>AdminUser</code> Model class name. */
    public static final String ADMINUSER = "AdminUser";
    /** <code>OperatorUser</code> Model class name. */
    public static final String OPERATORUSER = "OperatorUser";
    /** <code>Team</code> Model class name. */
    public static final String TEAM = "Team";
    /** <code>ERTemplate</code> Model class name. */
    public static final String ERTEMPLATE = "ERTemplate";
    /** <code>ERLTemplate</code> Model class name. */
    public static final String ERLTEMPLATE = "ERLTemplate";
    /** <code>ExchangeHistory</code> Model class name. */
    public static final String EXCHANGEHISTORY = "ExchangeHistory";
    /** <code>SystemParam</code> Model class name. */
    public static final String SYSTEMPARAM = "SystemParam";

    public enum Type {
        AUTONUMERIC, BLOB, BOOL, DATE, DATETIME, INT, NAT, REAL, STRING, TEXT, TIME, OID, EMPLOYEE, EXPENSELINE, EXPENSEREPORT, PAYMENTTYPE, PROJECT, EXPENSETYPE, EXPENSECURRENCY, ASSIGNMENT, APPUSER, ADMINUSER, OPERATORUSER, TEAM, ERTEMPLATE, ERLTEMPLATE, EXCHANGEHISTORY, SYSTEMPARAM;

        private static final int BASIC_TYPE = 10;

        /**
         * Method that indicates if is a basic type.
         * 
         * @return true if it is a basic type
         */
        public boolean isBasicType() {
            return ordinal() <= BASIC_TYPE;
        }

        /**
         * Method that indicates if is a class type.
         * 
         * @return true if it is a class type
         */
        public boolean isClassType() {
            return ordinal() > BASIC_TYPE;
        }

        /**
         * Method that indicates the name of the type.
         * 
         * @return the name of the type
         */
        public String getTypeName() {
            String returnValue = "";
            switch (this) {
            case AUTONUMERIC:
                returnValue = "Autonumeric";
                break;
            case BLOB:
                returnValue = "Blob";
                break;
            case BOOL:
                returnValue = "Bool";
                break;
            case DATE:
                returnValue = "Date";
                break;
            case DATETIME:
                returnValue = "DateTime";
                break;
            case INT:
                returnValue = "Int";
                break;
            case NAT:
                returnValue = "Nat";
                break;
            case REAL:
                returnValue = "Real";
                break;
            case STRING:
                returnValue = "String";
                break;
            case TEXT:
                returnValue = "Text";
                break;
            case TIME:
                returnValue = "Time";
                break;
            default:
                returnValue = this.name();
            }
            return returnValue;
        }

        /**
         * Method that indicates the name of the entity class.
         * 
         * @return the name of the entity class
         */
        public String getEntityClassName() {
            String returnValue = "";
            switch (this) {
            case EMPLOYEE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.Employee";
                break;
            case EXPENSELINE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ExpenseLine";
                break;
            case EXPENSEREPORT:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ExpenseReport";
                break;
            case PAYMENTTYPE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.PaymentType";
                break;
            case PROJECT:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.Project";
                break;
            case EXPENSETYPE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ExpenseType";
                break;
            case EXPENSECURRENCY:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency";
                break;
            case ASSIGNMENT:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.Assignment";
                break;
            case APPUSER:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.AppUser";
                break;
            case ADMINUSER:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.AdminUser";
                break;
            case OPERATORUSER:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.OperatorUser";
                break;
            case TEAM:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.Team";
                break;
            case ERTEMPLATE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ERTemplate";
                break;
            case ERLTEMPLATE:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ERLTemplate";
                break;
            case EXCHANGEHISTORY:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.ExchangeHistory";
                break;
            case SYSTEMPARAM:
                returnValue = "com.integranova.spring.expensereportdemo.persistence.SystemParam";
                break;
            default:
                returnValue = null;
            }
            return returnValue;
        }
    }

    public static final String LEFTJOIN = "Left Join";
    public static final String INNERJOIN = "Inner Join";

    /** Normal Filter */
    public static final Integer NORMAL_FILTER = 0;
    /** Navigational Filter in a Service argument */
    public static final Integer NAVFILTER_LOCAL_SERVICE = 1;
    /** Navigational Filter in a Service argument */
    public static final Integer NAVFILTER_GLOBAL_SERVICE = 2;
    /** Navigational Filter in a Navigation */
    public static final Integer NAVFILTER_NAVIG = 3;
    /** Navigational Filter in a Variable Navigational Filter */
    public static final Integer NAVFILTER_VARIABLE = 4;
    /** By supplementary information */
    public static final Integer SUP_INFO = 5;

    public static final String SELECTEDOBJECT = "SelectedObject";
    
    public static final String FILTER_BY_RELATED = "_Related";
    public static final String FILTER_BY_RELATED_FVAR_PATH = "relatedInstancePath";
    public static final String FILTER_BY_RELATED_FVAR_OID = "relatedInstanceOid";
    public static final String FILTER_BY_OID = "_OID";
    public static final String FILTER_BY_OID_FVAR_OID = "oid";
    
    /** Filter fum an lmd names */
    public static final String FILTER_FUM_NAME = "FUM";
    public static final String FILTER_LMD_NAME = "LMD";

    /** Filters variables initial and final dates */
    public static final String FILTER_VARIABLE_FDESDE = "FDesde";
    public static final String FILTER_VARIABLE_FHASTA = "FHasta";

    public static final String FILTER_VARIABLE_INITDATE = "InitDate";
    public static final String FILTER_VARIABLE_FINALDATE = "FinalDate";

    /** Default values for date, time and datetime */
    public static final String DATE_DEFAULTVALUE = "1970-01-01";
    public static final String TIME_DEFAULTVALUE = "00:00:00";
    public static final String DATETIME_DEFAULTVALUE = "1970-01-01 00:00:00";
    public static final String DATE_MAXVALUE = "3000-01-01";
    public static final String TIME_MAXVALUE = "23:59:59";
    public static final String DATETIME_MAXVALUE = "3000-01-01 00:00:00";
    
    public static final String AGENTKEYWORD = "AGENT";

    public static final String AGENT_APPUSER = "AGENT_AppUser";

    public static final String AGENT_ADMINUSER = "AGENT_AdminUser";

    public static final String AGENT_OPERATORUSER = "AGENT_OperatorUser";

    // Service (GLOBALTEST)
    /** <code>GLOBALTEST</code> service id. */
    public static final String G_SERV_ID_GLOBALTEST = "IGl_1539588620288177_Alias";
    /** <code>GLOBALTEST</code> service name. */
    public static final String G_SERV_NAME_GLOBALTEST = "GLOBALTEST";
    /** Agents allowed to execute the service GLOBALTEST **/
    public static final String GS_GLOBALTEST_SRVAGENTS = "AdminUser";
    /** <code>gLOBALTESTpTotExpenses</code> inbound argument id. */
    public static final String GS_ARG_NAME_GLOBALTEST_GLOBALTESTPTOTEXPENSES = "gLOBALTESTpTotExpenses";
    public static final String GS_ARG_ID_GLOBALTEST_GLOBALTESTPTOTEXPENSES = "IGl_1539588620288177Arg_1_Alias";
    /** <code>gLOBALTESTpProjectName</code> inbound argument id. */
    public static final String GS_ARG_NAME_GLOBALTEST_GLOBALTESTPPROJECTNAME = "gLOBALTESTpProjectName";
    public static final String GS_ARG_ID_GLOBALTEST_GLOBALTESTPPROJECTNAME = "IGl_1539588620288177Arg_2_Alias";
    /** <code>gLOBALTESTpsResultCode</code> outbound argument id. */
    public static final String GS_ARG_ID_GLOBALTEST_GLOBALTESTPSRESULTCODE = "IGl_1539588620288177Arg_3_Alias";
    /** <code>GLOBALTEST</code> precondition 0 id. */
    public static final String GS_PRE_ID_GLOBALTEST_0 = "IGl_1539588620288177Pre_1_Alias";

    // User Function (getEmployeeByName)
    /** <code>getEmployeeByName</code> service id. */
    public static final String UF_ID_GETEMPLOYEEBYNAME = "FGl_1576510029824642_Alias";
    /** <code>getEmployeeByName</code> service name. */
    public static final String UF_NAME_GETEMPLOYEEBYNAME = "getEmployeeByName";
    /** <code>pfName</code> inbound argument id. */
    public static final String UF_ARG_NAME_GETEMPLOYEEBYNAME_PFNAME = "pfName";
    public static final String UF_ARG_ID_GETEMPLOYEEBYNAME_PFNAME = "FGl_1576510029824642Arg_1_Alias";
    /** <code>outFound</code> outbound argument id. */
    public static final String UF_ARG_ID_GETEMPLOYEEBYNAME_OUTFOUND = "FGl_1576510029824642Arg_2_Alias";

    /**
     * This method looks for the sequence of facets from the received in the
     * argument to the owner of the attribute or role received in the other argument
     * 
     * @param departureClass the class of the inheritance net where the attribute or
     *                       role is defined
     * @param element        is the name of an attribute or role of the own
     *                       inheritance net
     * @return the sequence of facets obtained
     */
    public static List<String> getSequenceFacetsElement(String departureClass, String element) {

        String constantSearched = "PATH_FACETS_" + element.toUpperCase();
        List<String> result = new ArrayList<>();
        Class<?> constantClass;
        Field targetField = null;

        constantClass = getConstantClass(departureClass);

        boolean noSuchFieldError = false;
        if (constantClass != null) {
            try {
                targetField = constantClass.getField(constantSearched);
            } catch (NoSuchFieldException e1) {
                noSuchFieldError = true;
            }
        }

        if (!noSuchFieldError && targetField != null) {
            try {
                String targetFacets = (String) targetField.get(null);
                if (!targetFacets.equals("")) {
                    for (String facet : targetFacets.split(REGEXP_DOT_SEPARATOR)) {
                        result.add(facet.trim());
                    }
                }
            } catch (IllegalAccessException e) {
                logMessage(e.getMessage());
            }
        }

        return result;
    }

    /**
     * This method looks for the sequence of facets from the received in the
     * argument to the received in the other argument
     * 
     * @param departureClass the class of the inheritance net where it is looked for
     *                       the other facet
     * @param element        is the name of a facet of the own inheritance net
     * @return the sequence of facets obtained
     */
    public static List<String> getSequenceFacetsFacet(String departureClass, String element) {
        return getFacetsGetterSequence(departureClass, element);
    }

    /**
     * This method looks for the sequence of facets from the received in the
     * argument to the received in the other argument
     * 
     * @param departureClass the class of the inheritance net where it is looked for
     *                       the other facet
     * @param element        is the name of a facet of the own inheritance net
     * @return the sequence of facets obtained
     */
    public static List<String> getFacetsGetterSequence(String departureClass, String element) {

        String constantSearched = "CLASS_FACET_GETTER_" + element.toUpperCase();
        List<String> result = new ArrayList<>();
        Class<?> constantClass;
        Field targetField = null;

        constantClass = getConstantClass(departureClass);
        if (constantClass != null) {
            try {
                targetField = constantClass.getField(constantSearched);
            } catch (NoSuchFieldException e1) {
                logMessage(e1.getMessage());
            }
        }

        if (targetField != null) {
            try {
                String targetFacets = (String) targetField.get(null);
                if (!targetFacets.equals("")) {
                    for (String facet : targetFacets.split(REGEXP_DOT_SEPARATOR)) {
                        result.add(facet.trim());
                    }
                }
            } catch (IllegalAccessException e) {
                logMessage(e.getMessage());
            }
        }

        return result;
    }

    /**
     * This method looks for the owner facet of the attribute or role received in
     * the other argument
     * 
     * @param departureclass the class of the inheritance net where the attribute or
     *                       role is defined
     * @param element        is the name of an attribute or role of the own
     *                       inheritance net
     * @return the owner facet of the role or attribute
     */
    public static String getTargetFacetElement(String departureClass, String element) {
        List<String> sequenceFacets = getSequenceFacetsElement(departureClass, element);
        String returnValue = "";
        if (!sequenceFacets.isEmpty())
            returnValue = sequenceFacets.get(sequenceFacets.size() - 1);
        else
            returnValue = departureClass;
        return returnValue;
    }

    /**
     * This method looks for the owner facet of the attribute or role received in
     * the other argument
     * 
     * @param departureclass the class of the inheritance net where the attribute or
     *                       role is defined
     * @param element        is the name of an attribute or role of the own
     *                       inheritance net
     * @return the owner facet of the role or attribute
     */
    public static String getTargetFacetFacet(String departureClass, String element) {
        List<String> sequenceFacets = getSequenceFacetsFacet(departureClass, element);
        String returnValue = "";
        if (!sequenceFacets.isEmpty())
            returnValue = sequenceFacets.get(sequenceFacets.size() - 1);
        else
            returnValue = departureClass;
        return returnValue;
    }

    /**
     * This method looks for the name of the field in the database
     * 
     * @param nameClass     is the name of the class where the field is
     * @param attributeName is the name of the field
     * @return the right name of the field in the database
     * @throws SystemException
     */
    public static String nameField(String nameClass, String attributeName) {
        String fieldName;
        String localAttributeName = ATTRFIELDPREFIX + attributeName.toUpperCase();
        try {
            Class<?> constantClass = getConstantClass(nameClass);

            if (constantClass != null) {
                Field targetField = constantClass.getField(localAttributeName);
                fieldName = (String) targetField.get(null);
            } else {
                fieldName = attributeName;
            }

        } catch (NoSuchFieldException e) {
            fieldName = attributeName;
        } catch (IllegalAccessException e) {
            fieldName = attributeName;
            logMessage(e.getMessage());
        }

        return (fieldName.equalsIgnoreCase(FILTER_FUM_NAME) ? FILTER_LMD_NAME.toLowerCase() : fieldName);
    }

    /**
     * This method obtains the name of the table which represents the class
     * 
     * @param nameClass is the name of the class whose table it is looked for
     * @return the name of the table
     */
    public static String nameTable(String nameClass) {
        String tableName = "TBL_NAME";
        try {
            Class<?> constantClass = getConstantClass(nameClass);
            tableName = (constantClass != null ? (String) constantClass.getField(tableName).get(null) : "TBL_NAME");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(e.getMessage());
        }
        return tableName;
    }

    /**
     * This method obtains the list of the OID Fields of the received class
     * 
     * @param className is the name of the class whose OID Fields are looked for
     * @return the list of OID Fields
     */
    public static List<String> getOIDFields(String className) {
        return getIdFields(className, getConstantClass(className));
    }

    @SuppressWarnings("unchecked")
    private static List<String> getIdFields(String className, Class<?> constantClass) {
        List<String> result = new ArrayList<>();
        try {
            Method getIdFieldsMethod = getIdFieldsMethod(constantClass);
            if (getIdFieldsMethod != null) {
                Object[] arguments = new Object[1];
                arguments[0] = className;
                result = (List<String>) getIdFieldsMethod.invoke(null, arguments);
            }
        } catch (Exception e) {
            logMessage(e.getMessage());
        }
        return result;
    }

    private static Method getIdFieldsMethod(Class<?> constantClass) throws NoSuchMethodException {
        return (constantClass != null ? constantClass.getMethod("getIdFields", String.class) : null);
    }

    /**
     * This method obtains the list of the Fields of the received class in a TM
     * table
     * 
     * @param className         is the name of the class whose OID Fields are looked
     *                          for
     * @param intermediateTable is the name of the intermediate table
     * @return the list of OID Fields
     * @throws SystemException
     */
    @SuppressWarnings("unchecked")
    public static List<String> getTMOIDFields(String className, String intermediateTable) throws SystemException {
        List<String> result = new ArrayList<>();
        Class<?> constantClass = getConstantClass(className);
        if (constantClass != null) {
            try {

                Method getTMIdFields;
                getTMIdFields = constantClass.getMethod("getTMIdFields", String.class);
                Object[] arguments = new Object[1];
                arguments[0] = intermediateTable;
                result = (List<String>) getTMIdFields.invoke(null, arguments);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new SystemException(e);
            }
        }
        return result;
    }

    /**
     * This method obtains the reached class through a role
     * 
     * @param nameClass is the name of the source class
     * @param roleName  is the name of the role
     * @return the reached class from nameClass with the role roleName
     */
    public static String roleTargetClass(String nameClass, String roleName) {
        String targetClassName = "";
        String attributeName = "ROLE_TARGET_" + roleName.toUpperCase();

        try {
            Class<?> constantClass = getConstantClass(nameClass);
            if (constantClass != null) {
                Field targetField = constantClass.getField(attributeName);
                targetClassName = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException e) {
            targetClassName = "";
        } catch (IllegalAccessException e) {
            logMessage(e.getMessage());
        }

        return targetClassName;
    }

    /**
     * Gets the inverse role of a given role from a given class.
     * 
     * @param className the class owner of the roles.
     * @param roleName  the direct role .
     * @return the inverse role of roleName that arrives to className.
     * @throws SystemException
     */
    public static String getInverseSingleRole(String className, String roleName) throws SystemException {
        String result = "";
        try {
            Class<?> constantClass = getConstantClass(className);
            result = (constantClass != null
                    ? (String) constantClass.getField("ROLE_INVNAME_" + roleName.toUpperCase()).get(null)
                    : "");
        } catch (Exception e) {
            throw new SystemException(e);
        }

        return result;
    }

    /**
     * Returns the class reached via the role given. The role can be a single role
     * or a path with several roles.
     * 
     * @param className the departure class of the role.
     * @param rolesPath the roles path to process.
     * @return the final class reached after processing the role.
     */
    public static String pathTargetClass(String className, String rolesPath) {
        return pathTargetClass(className, rolesPath, false);
    }

    /**
     * Returns the class reached via the role given. The role can be a single role
     * or a path with several roles.
     * 
     * @param className       the departure class of the role.
     * @param rolesPath       the roles path to process.
     * @param ignoreFirstItem whether the first item in rolesPath has to be ignored
     *                        when processing the roles path.
     * @return the final class reached after processing the role.
     */
    public static String pathTargetClass(String className, String rolesPath, boolean ignoreFirstItem) {
        String result = "";
        try {
            if (rolesPath.equals("")) {
                // If there is no roles path then the final class is the same as the departure
                // class.
                result = className;
            } else {
                // Split the role into every single role it may contain.
                String currentClass = className;
                // Iterate to process each one of the single roles.
                boolean isFirstItemProcessed = false;
                for (String role : rolesPath.split(REGEXP_DOT_SEPARATOR)) {
                    if (ignoreFirstItem && !isFirstItemProcessed) {
                        isFirstItemProcessed = true;
                        continue;
                    }
                    // Get the target class of this role and set it as the temporal reached class to
                    // continue the iteration from this class.
                    currentClass = roleTargetClass(currentClass, role);
                }
                // The final reached class is the one reached navigating the initial role.
                result = currentClass;
            }
        } catch (Exception e) {
            logMessage(e.getMessage());
        }
        return result;
    }

    /**
     * Gets the inverse role of a given role from a given class.
     * 
     * @param className the class owner of the roles.
     * @param roleName  the direct role .
     * @return the inverse role of roleName that arrives to className.
     * @throws SystemException
     */
    public static String getInverseRole(String className, String roleName) throws SystemException {
        String result;
        String newRoleName = roleName;
        try {
            if (roleName.isEmpty()) {
                // If there is no role then the is not inverse role.
                result = roleName;
            } else {
                // Split the role into every single role it may contain.
                StringBuilder inverseRole = new StringBuilder();
                String currentClass = className;

                // Iterate to process each one of the single roles.
                for (String role : newRoleName.split(REGEXP_DOT_SEPARATOR)) {
                    // Get the target class of this role and set it as the temporal reached class to
                    // continue the iteration from this class.
                    // create the inverse role.
                    if (inverseRole.toString().equals("")) {
                        inverseRole.append(getInverseSingleRole(currentClass, role));
                    } else {
                        inverseRole.insert(0, ".");
                        inverseRole.insert(0, getInverseSingleRole(currentClass, role));
                    }
                    currentClass = roleTargetClass(currentClass, role);
                }
                // The final reached class is the one reached navigating the initial role.
                result = inverseRole.toString();

            }
        } catch (Exception e) {
            result = "";
        }

        return result;
    }

    /**
     * Gets table name of a many-to-many relationship for a given class and role
     * name
     * 
     * @param definitionClass
     * @param roleName
     * @return {@link String}
     * @throws SystemException
     */
    public static String getManyToManyTableName(String definitionClass, String roleName) {
        String result = "";
        try {
            result = (String) Constants.class
                    .getField("ROLE_TABLE_" + definitionClass.toUpperCase() + "_" + roleName.toUpperCase()).get(null);
        } catch (NoSuchFieldException e) {
            result = "";
        } catch (Exception e) {
            logMessage(e.getMessage());
        }
        return result;
    }

    /**
     * Checks visibility of an agent
     * 
     * @param agent
     * @param initialClass
     * @param path
     * @return {@link Boolean}
     * @throws SystemException
     */
    public static Boolean checkVisibility(Agent agent, String initialClass, String path) throws SystemException {
        Boolean returnValue = null;
        String remainingRolesPath = "";
        String role = path;
        int pointIndex = role.indexOf('.');

        if (pointIndex > 0) {
            role = path.substring(0, pointIndex);
            remainingRolesPath = path.substring(pointIndex + 1);
        }
        try {
            String roleOwner = Constants.getTargetFacetElement(initialClass, role);
            if (!roleOwner.equalsIgnoreCase(initialClass)) {
                returnValue = Constants.checkVisibility(agent, roleOwner, path);
            } else {
                String agents = getAgents(initialClass, role);
                for (String agentName : agents.split(",")) {
                    agentName = agentName.trim();
                    returnValue = checkVisibilityForAgentFacet(agent, agentName, initialClass, role,
                            remainingRolesPath);
                    if (returnValue != null)
                        break;
                }
            }
        } catch (SecurityException | IllegalArgumentException e) {
            throw new SystemException(e);
        }
        return returnValue;
    }

    private static String getAgents(String className, String roleName) throws SystemException {
        String agents = "";
        try {
            Class<?> roleOwner = getConstantClass(className);
            Field field = (roleOwner != null ? roleOwner.getField(roleName.toUpperCase() + "_AGENTS") : null);
            agents = (field != null ? (String) field.get(null) : "");
        } catch (Exception e) {
            throw new SystemException(e);
        }
        return agents;
    }

    private static Boolean checkVisibilityForAgentFacet(Agent agentClass, String agentFacet, String className,
            String role, String rolesPath) throws SystemException {
        Boolean returnValue = null;
        if (agentClass.isFacetActive(agentFacet)) {
            returnValue = (rolesPath.isEmpty()
                    || checkVisibility(agentClass, roleTargetClass(className, role), rolesPath));
        }
        return returnValue;
    }

    /**
     * Returns the constant class of a model class
     * 
     * @param className Name of class to search
     * @return Class object
     */
    public static Class<?> getConstantClass(String className) {
        Class<?> returnValue = null;
        if (className.equalsIgnoreCase(""))
            returnValue = Constants.class;
        if (className.equalsIgnoreCase("function"))
            returnValue = Constants.class;
        if (className.equalsIgnoreCase(EMPLOYEE))
            returnValue = EmployeeConstants.class;
        if (className.equalsIgnoreCase(EXPENSELINE))
            returnValue = ExpenseLineConstants.class;
        if (className.equalsIgnoreCase(EXPENSEREPORT))
            returnValue = ExpenseReportConstants.class;
        if (className.equalsIgnoreCase(PAYMENTTYPE))
            returnValue = PaymentTypeConstants.class;
        if (className.equalsIgnoreCase(PROJECT))
            returnValue = ProjectConstants.class;
        if (className.equalsIgnoreCase(EXPENSETYPE))
            returnValue = ExpenseTypeConstants.class;
        if (className.equalsIgnoreCase(EXPENSECURRENCY))
            returnValue = ExpenseCurrencyConstants.class;
        if (className.equalsIgnoreCase(ASSIGNMENT))
            returnValue = AssignmentConstants.class;
        if (className.equalsIgnoreCase(APPUSER))
            returnValue = AppUserConstants.class;
        if (className.equalsIgnoreCase(ADMINUSER))
            returnValue = AdminUserConstants.class;
        if (className.equalsIgnoreCase(OPERATORUSER))
            returnValue = OperatorUserConstants.class;
        if (className.equalsIgnoreCase(TEAM))
            returnValue = TeamConstants.class;
        if (className.equalsIgnoreCase(ERTEMPLATE))
            returnValue = ERTemplateConstants.class;
        if (className.equalsIgnoreCase(ERLTEMPLATE))
            returnValue = ERLTemplateConstants.class;
        if (className.equalsIgnoreCase(EXCHANGEHISTORY))
            returnValue = ExchangeHistoryConstants.class;
        if (className.equalsIgnoreCase(SYSTEMPARAM))
            returnValue = SystemParamConstants.class;
        return returnValue;
    }

    /**
     * Returns the name of a model class with the correct capitalization
     * 
     * @param className Name of class to search
     * @return Model class name
     */
    public static String getClassName(String className) {
        String returnValue = "";
        if (className.equalsIgnoreCase(""))
            returnValue = "";
        if (className.equalsIgnoreCase("FUNCTION"))
            returnValue = "Function";

        try {
            Class<?> constantClass = getConstantClass(className);

            if (constantClass != null) {
                Field targetField = constantClass.getField("CLASS_NAME");
                returnValue = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(e.getMessage());
        }

        return returnValue;
    }

    /**
     * Returns the name of a model service with the correct capitalization
     * 
     * @param className   Name of class to search (empty string if it is a global
     *                    service)
     * @param serviceName Name of service to search
     * @return Model service name
     */
    public static String getServiceName(String className, String serviceName) {
        String returnValue = "";
        if (serviceName.equals(""))
            returnValue = "";
        try {
            Class<?> constantClass = getConstantClass(className);

            if (constantClass != null) {
                Field targetField = null;
                if (className.equals(""))
                    targetField = constantClass.getField("G_SERV_NAME_" + serviceName.toUpperCase());
                else if (className.equalsIgnoreCase("Function"))
                    targetField = constantClass.getField("UF_NAME_" + serviceName.toUpperCase());
                else
                    targetField = constantClass.getField("SERV_NAME_" + serviceName.toUpperCase());
                returnValue = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(e.getMessage());
        }

        return returnValue;
    }

    /**
     * Returns the name of a model argument with the correct capitalization
     * 
     * @param className          Name of class to search (empty string if it is a
     *                           global service)
     * @param serviceName        Name of service to search
     * @param argumentName       Name of the argument to search
     * @param navFilterClassName Name of the class owning the navigational filter
     * @return Model argument name
     */
    public static String getArgumentName(String className, String serviceName, String argumentName, String navFilterClassName) {
        String returnValue = "";
        if (argumentName.equals(""))
            returnValue = "";
        try {
            if (serviceName.equals("")) {
                Class<?> filterNavClass = Class
                        .forName("com.integranova.spring.expensereportdemo.query.impl.filter.navigational." + className
                                + navFilterClassName + "NavigationalFilter");
                serviceName = filterNavClass
                        .getAnnotation(com.integranova.spring.expensereportdemo.metadata.NavFilterServiceName.class)
                        .name();
            }
            Class<?> constantClass = getConstantClass(className);

            if (constantClass != null) {
                Field targetField = constantClass
                        .getField("ARG_NAME_" + serviceName.toUpperCase() + "_" + argumentName.toUpperCase());
                returnValue = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException e) {
            returnValue = argumentName;
        } catch (IllegalAccessException | ClassNotFoundException e) {
            logMessage(e.getMessage());
        }

        return returnValue;
    }

    /**
     * Returns the name of a model filter with the correct capitalization
     * 
     * @param className  Name of class to search
     * @param filterName Name of filter to search
     * @return Model filter name
     */
    public static String getFilterName(String className, String filterName) {
        String returnValue = "";
        if (className.equals("") || filterName.equals(""))
            returnValue = "";
        if (filterName.equalsIgnoreCase("LMD") || filterName.equalsIgnoreCase("FUM"))
            returnValue = "LMD";
        try {
            Class<?> constantClass = getConstantClass(className);

            if (constantClass != null) {
                Field targetField = constantClass.getField("FILTER_NAME_" + filterName.toUpperCase());
                returnValue = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(e.getMessage());
        }

        return returnValue;
    }

    /**
     * Returns the name of a model filter variable with the correct capitalization
     * 
     * @param className    Name of class to search
     * @param filterName   Name of filter to search
     * @param variableName Name of filter variable to search
     * @return Model filter variable name
     */
    public static String getVariableName(String className, String filterName, String variableName) {
        String returnValue = "";
        if (className.equals("") || filterName.equals("") || variableName.equals(""))
            returnValue = "";
        if (filterName.equalsIgnoreCase("LMD") || filterName.equalsIgnoreCase("FUM"))
            returnValue = "LMD";
        try {
            Class<?> constantClass = getConstantClass(className);

            if (constantClass != null) {
                Field targetField = constantClass
                        .getField("VAR_NAME_" + filterName.toUpperCase() + "_" + variableName.toUpperCase());
                returnValue = (String) targetField.get(null);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(e.getMessage());
        }

        return returnValue;
    }

    /**
     * This method returns the corresponding java.sql.Type of a given type
     * 
     * @param paramType represents the OASIS Type
     * @return the equivalent java.sql Type to the OASIS type passed as parameter
     */
    public static int getSQLType(String paramType) {
        int returnValue = -1;
        if (paramType.equalsIgnoreCase("AUTONUMERIC"))
            returnValue = java.sql.Types.INTEGER;
        else if (paramType.equalsIgnoreCase("BOOL"))
            returnValue = java.sql.Types.BOOLEAN;
        else if (paramType.equalsIgnoreCase("BLOB"))
            returnValue = java.sql.Types.BLOB;
        else if (paramType.equalsIgnoreCase("DATE"))
            returnValue = java.sql.Types.DATE;
        else if (paramType.equalsIgnoreCase("DATETIME"))
            returnValue = java.sql.Types.TIMESTAMP;
        else if (paramType.equalsIgnoreCase("INT"))
            returnValue = java.sql.Types.INTEGER;
        else if (paramType.equalsIgnoreCase("NAT"))
            returnValue = java.sql.Types.INTEGER;
        else if (paramType.equalsIgnoreCase("REAL"))
            returnValue = java.sql.Types.REAL;
        else if (paramType.equalsIgnoreCase("STRING"))
            returnValue = java.sql.Types.VARCHAR;
        else if (paramType.equalsIgnoreCase("TEXT"))
            returnValue = java.sql.Types.CLOB;
        else if (paramType.equalsIgnoreCase("TIME"))
            returnValue = java.sql.Types.TIME;

        return returnValue;
    }

    /**
     * This method indicates if the received class is leged
     * 
     * @param className the name of the class to check for leged
     * @return true if the received class is leged
     */
    public static boolean isLeged(String className) {
        boolean returnValue = false;
        if ("NO_LEGACY_VIEWS".equals(className))
            returnValue = true;
        return returnValue;
    }

    /**
     * Method that returns the identification fields of a class in an intermediate
     * table.
     * 
     * @param tableName The name of the intermediateTable
     * @return Keys of the intermediate table refering to a class
     */
    public static List<String> getTMFields(String tableName) {
        List<String> fields = new ArrayList<>();
        // Intermediate relation (TM_EmployeeTeam)
        if (tableName.equalsIgnoreCase(Constants.TBL_NAME_EMPLOYEETEAM)) {
            fields.add(FLD_TMEMPLOYEETEAM_EMPLOYEEEMPLOYEEIDEMPLOYEE);
            fields.add(FLD_TMEMPLOYEETEAM_TEAMTEAMID);
        }
        // Intermediate relation (TM_ProjectERTemplate)
        if (tableName.equalsIgnoreCase(Constants.TBL_NAME_PROJECTERTEMPLATE)) {
            fields.add(FLD_TMPROJECTERTEMPLATE_PROJECTPROJECTIDPROJECT);
            fields.add(FLD_TMPROJECTERTEMPLATE_ERTEMPLATEERTEMPLATEID);
        }
        return fields;
    }

    /***
     * Returns the alias of a class
     * 
     * @param className Name of the class
     * @return Alias of the class
     */
    public static String getClassAlias(String className) {
        String classAlias;
        String classAliasConstant = "CLASS_ALIAS";
        Class<?> constantClass = getConstantClass(className);
        if (constantClass != null) {
            try {
                Field targetField = constantClass.getField(classAliasConstant);
                classAlias = (String) targetField.get(null);
            } catch (Exception e) {
                classAlias = className;
            }

        } else {
            classAlias = className;
        }
        return classAlias;
    }

    /***
     * Returns the alias of a service
     * 
     * @param className   Name of the class owning the service
     * @param serviceName Name of the service
     * @return Alias of the service
     */
    public static String getServiceAlias(String className, String serviceName) {
        String serviceAlias = null;
        String serviceAliasConstant = "SERV_ALIAS_" + serviceName.toUpperCase();
        Class<?> constantClass = getConstantClass(className);
        if (constantClass != null) {
            try {
                Field targetField = constantClass.getField(serviceAliasConstant);
                serviceAlias = (String) targetField.get(null);
            } catch (Exception e) {
                serviceAlias = serviceName;
            }
        }
        return (serviceAlias != null ? serviceAlias : serviceName);
    }

    /***
     * Returns the alias of an inbound argument
     * 
     * @param className    Name of the class owning the service
     * @param serviceName  Name of the service owning the argument
     * @param argumentName Name of the argument
     * @return Alias of the argument
     */
    public static String getInboundArgumentAlias(String className, String serviceName, String argumentName) {
        String argumentAlias;
        String argumentAliasConstant = "ARG_ALIAS_" + serviceName.toUpperCase() + "_" + argumentName.toUpperCase();
        Class<?> constantClass = getConstantClass(className);
        if (constantClass != null) {
            try {
                Field targetField = constantClass.getField(argumentAliasConstant);
                argumentAlias = (String) targetField.get(null);
            } catch (Exception e) {
                argumentAlias = argumentName;
            }
        } else {
            argumentAlias = argumentName;
        }

        return argumentAlias;
    }

    /**
     * Method that normalizes a Display Set Item path.
     * 
     * @param startingClass Name of the class owning the displayset
     * @param path          Display Set Item path
     * @return normalized Display Set Item path
     */
    public static String normalizeDSItemPath(String startingClass, String path) {
        StringBuilder result = new StringBuilder();
        String[] pathItems = path.split(REGEXP_DOT_SEPARATOR);
        String lastItem = pathItems[pathItems.length - 1];
        String currentClass = startingClass;
        Class<?> constantClass;
        Field targetField = null;
        String separator = "";
        // Role names before attribute name
        for (int i = 0; i < pathItems.length - 1; i++) {
            String roleName = pathItems[i];
            String roleNameConstant = ROLENAMEPREFIX + roleName.toUpperCase();
            constantClass = getConstantClass(currentClass);
            try {
                targetField = (constantClass != null ? constantClass.getField(roleNameConstant) : null);
                String normalizedRoleName = (targetField != null ? (String) targetField.get(null) : roleName);
                result.append(separator);
                result.append(normalizedRoleName);
                separator = ".";
                currentClass = roleTargetClass(currentClass, normalizedRoleName);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                logMessage(Arrays.toString(e.getStackTrace()));
            }
        }

        // Attribute name
        constantClass = getConstantClass(currentClass);
        String attributeNameConstant = ATTRNAMEPREFIX + lastItem.toUpperCase();
        try {
            targetField = (constantClass != null ? constantClass.getField(attributeNameConstant) : null);
            String normalizedAttributeName = (targetField != null ? (String) targetField.get(null) : lastItem);
            result.append(separator);
            result.append(normalizedAttributeName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logMessage(Arrays.toString(e.getStackTrace()));
        }

        return result.toString();
    }

    public static String normalizePath(String startingClass, String path, boolean ignoreFirstItem){

    	String[] pathItems = path.split(REGEXP_DOT_SEPARATOR);
    	String currentClass = startingClass;

        if (currentClass.isEmpty()) {
            ignoreFirstItem = true;
            currentClass = pathItems[0];
        }
    
        return processPathItems(currentClass, pathItems, ignoreFirstItem);

    }
    
    private static String processPathItems(String initialClass, String[] pathItems, boolean ignoreFirstItem) {
    	StringBuilder result = new StringBuilder();
    	String currentClass = initialClass;
        // Path items names
        Integer itemsCount = 0;
    	for(String roleName : pathItems) {
    		itemsCount++;
            if (ignoreFirstItem && itemsCount.equals(1)){
                result.append(roleName);
            } else {
            	String roleNameConstant = ROLENAMEPREFIX + roleName.toUpperCase();
            	String attrNameConstant = ATTRNAMEPREFIX + roleName.toUpperCase();
                Field targetField = getField(getConstantClass(currentClass), roleNameConstant, attrNameConstant);
                if (targetField != null) {
                	String normalizedPathItemName = getNormalizedPathItemName(targetField);
                	currentClass = getReachedClass(currentClass, roleNameConstant, normalizedPathItemName);
                    result.append((result.length() > 0 ? "." : "") + normalizedPathItemName);
                }
            }
        }
    	return result.toString();
    }
        
    private static boolean isRole(Class<?> constantClass, String roleNameConstant) {
    	return getRoleField(constantClass, roleNameConstant) != null;
    }
    
    private static Field getField(Class<?> constantClass, String roleNameConstant, String attributeNameConstant) {
    	Field field = constantClass != null ? getRoleField(constantClass, roleNameConstant) : null;
    	if (field == null) field = getAttributeField(constantClass, attributeNameConstant);
    	return field;
    }
    
    private static Field getRoleField(Class<?> constantClass, String roleNameConstant) {
    	Field targetField;
        try {
            targetField = constantClass != null ? constantClass.getField(roleNameConstant) : null;
        } catch (NoSuchFieldException nsfe) {
            targetField = null;
        }
        return targetField;
    }
    
    private static Field getAttributeField(Class<?> constantClass, String attributeNameConstant) {
    	Field targetField;
        try {
            targetField = constantClass != null ? constantClass.getField(attributeNameConstant) : null;
        } catch (NoSuchFieldException nsfe) {
        	logMessage(Arrays.toString(nsfe.getStackTrace()));
            targetField = null;
        }
    	return targetField;
    }

    private static String getReachedClass(String currentClass, String roleNameConstant, String normalizedPathItemName) {
        return (isRole(getConstantClass(currentClass), roleNameConstant))
            ? roleTargetClass(currentClass, normalizedPathItemName)
            : currentClass;
    }
    
    private static String getNormalizedPathItemName(Field targetField) {
    	try {
    		return targetField != null ? (String)targetField.get(null) : null;
    	} catch (IllegalAccessException iae) {
        	logMessage(Arrays.toString(iae.getStackTrace()));
    		return "";
    	}
    }

    private static void logMessage(String message) {
        Logger logger = LoggerFactory.getLogger(Constants.class);
        logger.debug(message);
    }
}
