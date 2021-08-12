package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>Assignment</code> model class.
 */
public final class AssignmentConstants {

    private AssignmentConstants() {

    }

    // Class
    /** <code>Assignment</code> class id. */
    public static final String CLASS_ID = "Clas_1468338274304118_Alias";
    /** <code>Assignment</code> class name. */
    public static final String CLASS_NAME = "Assignment";
    /** <code>Assignment</code> class alias. */
    public static final String CLASS_ALIAS = "Assignment";
    /** <code>Assignment</code> class table name. */
    public static final String TBL_NAME = "Assignment";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "assignmentAssignmentID,employeeidEmployee,projectidProject,assignmentFromDate,assignmentToDate";

    public static final String DSDSASSIGNMENTDETAILS = "DS_AssignmentDetails";
    public static final String DSDSASSIGNMENTS = "DS_Assignments";
    

    // Attribute (assignmentAssignmentID)
    /** <code>assignmentAssignmentID</code> attribute id. */
    public static final String ATTR_ID_ASSIGNMENTASSIGNMENTID = "Clas_1468338274304118Atr_1_Alias";
    /** <code>assignmentAssignmentID</code> attribute name. */
    public static final String ATTR_NAME_ASSIGNMENTASSIGNMENTID = "assignmentAssignmentID";
    /** <code>assignmentAssignmentID</code> attribute alias. */
    public static final String ATTR_ALIAS_ASSIGNMENTASSIGNMENTID = "id_Assignment";

    /** <code>assignmentAssignmentID</code> attribute facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTASSIGNMENTID = "";
    /** Agents allowed to view the attribute assignmentAssignmentID **/
    public static final String ASSIGNMENTASSIGNMENTID_AGENTS = "AdminUser,OperatorUser";
    // Attribute (assignmentFromDate)
    /** <code>assignmentFromDate</code> attribute id. */
    public static final String ATTR_ID_ASSIGNMENTFROMDATE = "Clas_1468338274304118Atr_2_Alias";
    /** <code>assignmentFromDate</code> attribute name. */
    public static final String ATTR_NAME_ASSIGNMENTFROMDATE = "assignmentFromDate";
    /** <code>assignmentFromDate</code> attribute alias. */
    public static final String ATTR_ALIAS_ASSIGNMENTFROMDATE = "From";

    /** <code>assignmentFromDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTFROMDATE = "";
    /** Agents allowed to view the attribute assignmentFromDate **/
    public static final String ASSIGNMENTFROMDATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (assignmentToDate)
    /** <code>assignmentToDate</code> attribute id. */
    public static final String ATTR_ID_ASSIGNMENTTODATE = "Clas_1468338274304118Atr_3_Alias";
    /** <code>assignmentToDate</code> attribute name. */
    public static final String ATTR_NAME_ASSIGNMENTTODATE = "assignmentToDate";
    /** <code>assignmentToDate</code> attribute alias. */
    public static final String ATTR_ALIAS_ASSIGNMENTTODATE = "To";

    /** <code>assignmentToDate</code> attribute facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTTODATE = "";
    /** Agents allowed to view the attribute assignmentToDate **/
    public static final String ASSIGNMENTTODATE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (assignmentIsActive)
    /** <code>assignmentIsActive</code> attribute id. */
    public static final String ATTR_ID_ASSIGNMENTISACTIVE = "Clas_1468338274304118Atr_4_Alias";
    /** <code>assignmentIsActive</code> attribute name. */
    public static final String ATTR_NAME_ASSIGNMENTISACTIVE = "assignmentIsActive";
    /** <code>assignmentIsActive</code> attribute alias. */
    public static final String ATTR_ALIAS_ASSIGNMENTISACTIVE = "Active?";

    /** <code>assignmentIsActive</code> attribute facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTISACTIVE = "";
    /** Agents allowed to view the attribute assignmentIsActive **/
    public static final String ASSIGNMENTISACTIVE_AGENTS = "AdminUser,OperatorUser";
    // Attribute (assignmentDetails)
    /** <code>assignmentDetails</code> attribute id. */
    public static final String ATTR_ID_ASSIGNMENTDETAILS = "Clas_1468338274304118Atr_5_Alias";
    /** <code>assignmentDetails</code> attribute name. */
    public static final String ATTR_NAME_ASSIGNMENTDETAILS = "assignmentDetails";
    /** <code>assignmentDetails</code> attribute alias. */
    public static final String ATTR_ALIAS_ASSIGNMENTDETAILS = "Details";

    /** <code>assignmentDetails</code> attribute facet sequence. */
    public static final String PATH_FACETS_ASSIGNMENTDETAILS = "";
    /** Agents allowed to view the attribute assignmentDetails **/
    public static final String ASSIGNMENTDETAILS_AGENTS = "AdminUser,OperatorUser";


    // Field (Assignment_ID)
    /** <code>Assignment_ID</code> field name. */
    public static final String FLD_ASSIGNMENTASSIGNMENTID = "Assignment_ID";    
    /** <code>assignmentAssignmentID</code> attribute field name. */
    public static final String ATTR_FIELD_ASSIGNMENTASSIGNMENTID = "assignmentAssignmentID";
    // Field (id_Employee)
    /** <code>id_Employee</code> field name. */
    public static final String FLD_EMPLOYEEIDEMPLOYEE = "id_Employee";    
    /** <code>id_Employee</code> field length. */
    public static final int FLD_EMPLOYEEIDEMPLOYEELENGTH = 10;
    /** <code>Employee.employeeidEmployee</code> attribute field name. */
    public static final String ATTR_FIELD_EMPLOYEE_EMPLOYEEIDEMPLOYEE = "employeeidEmployee";
    // Field (id_Project)
    /** <code>id_Project</code> field name. */
    public static final String FLD_PROJECTIDPROJECT = "id_Project";    
    /** <code>Project.projectidProject</code> attribute field name. */
    public static final String ATTR_FIELD_PROJECT_PROJECTIDPROJECT = "projectidProject";
    // Field (FromDate)
    /** <code>FromDate</code> field name. */
    public static final String FLD_ASSIGNMENTFROMDATE = "FromDate";    
    /** <code>assignmentFromDate</code> attribute field name. */
    public static final String ATTR_FIELD_ASSIGNMENTFROMDATE = "assignmentFromDate";
    // Field (ToDate)
    /** <code>ToDate</code> field name. */
    public static final String FLD_ASSIGNMENTTODATE = "ToDate";    
    /** <code>assignmentToDate</code> attribute field name. */
    public static final String ATTR_FIELD_ASSIGNMENTTODATE = "assignmentToDate";

    // Component role (Employee)
    /** <code>Employee</code> role id. */
    public static final String ROLE_ID_EMPLOYEE = "Agr_1468338405376498_Alias";
    /** <code>Employee</code> role name. */
    public static final String ROLE_NAME_EMPLOYEE = "employee";
    /** <code>Employee</code> role alias. */
    public static final String ROLE_ALIAS_EMPLOYEE = "Employee";

    /** <code>Employee</code> inverse role name. */
    public static final String ROLE_INVNAME_EMPLOYEE = EmployeeConstants.ROLE_NAME_ASSIGNMENTS;
    /** <code>Employee</code> role facet sequence. */
    public static final String PATH_FACETS_EMPLOYEE = "";
    /** <code>Employee</code> role target class. */
    public static final String ROLE_TARGET_EMPLOYEE = EmployeeConstants.CLASS_NAME;

    /** Agents allowed to navigate through Employee **/
    public static final String EMPLOYEE_AGENTS = "AdminUser,OperatorUser";
    // Component role (Project)
    /** <code>Project</code> role id. */
    public static final String ROLE_ID_PROJECT = "Agr_1468338405376416_Alias";
    /** <code>Project</code> role name. */
    public static final String ROLE_NAME_PROJECT = "project";
    /** <code>Project</code> role alias. */
    public static final String ROLE_ALIAS_PROJECT = "Project";

    /** <code>Project</code> inverse role name. */
    public static final String ROLE_INVNAME_PROJECT = ProjectConstants.ROLE_NAME_ASSIGNMENTS;
    /** <code>Project</code> role facet sequence. */
    public static final String PATH_FACETS_PROJECT = "";
    /** <code>Project</code> role target class. */
    public static final String ROLE_TARGET_PROJECT = ProjectConstants.CLASS_NAME;

    /** Agents allowed to navigate through Project **/
    public static final String PROJECT_AGENTS = "AdminUser,OperatorUser";


    // Service (newAssignment)
    /** <code>newAssignment</code> service id. */
    public static final String SERV_ID_NEWASSIGNMENT = "Clas_1468338274304118Ser_1_Alias";
    /** <code>newAssignment</code> service name. */
    public static final String SERV_NAME_NEWASSIGNMENT = "newAssignment";
    /** <code>newAssignment</code> service alias. */
    public static final String SERV_ALIAS_NEWASSIGNMENT = "Create";
    /** Agents allowed to execute the service newAssignment **/
    public static final String NEWASSIGNMENT_SRVAGENTS = "AdminUser,OperatorUser";
    // Preconditions
    /** <code>newAssignment</code> precondition 0 id. */
    public static final String PRE_ID_NEWASSIGNMENT_0 = "Clas_1468338274304118Pre_1_MsgError";
    /** <code>newAssignment</code> precondition 1 id. */
    public static final String PRE_ID_NEWASSIGNMENT_1 = "Clas_1468338274304118Pre_2_MsgError";
    // Inbound arguments
    /** <code>assignmentnewAssignmentpagrProject</code> inbound argument name. */
    public static final String ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT = "p_agrProject";
    /** <code>assignmentnewAssignmentpagrProject</code> inbound argument id. */
    public static final String ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT = "Clas_1468338274304118Ser_1Arg_9_Alias";
    /** <code>assignmentnewAssignmentpagrProject</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT = "Project";
    /** <code>assignmentnewAssignmentpagrEmployee</code> inbound argument name. */
    public static final String ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE = "p_agrEmployee";
    /** <code>assignmentnewAssignmentpagrEmployee</code> inbound argument id. */
    public static final String ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE = "Clas_1468338274304118Ser_1Arg_10_Alias";
    /** <code>assignmentnewAssignmentpagrEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE = "Employee";
    /** <code>assignmentnewAssignmentpatrFromDate</code> inbound argument name. */
    public static final String ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPATRFROMDATE = "p_atrFromDate";
    /** <code>assignmentnewAssignmentpatrFromDate</code> inbound argument id. */
    public static final String ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPATRFROMDATE = "Clas_1468338274304118Ser_1Arg_4_Alias";
    /** <code>assignmentnewAssignmentpatrFromDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPATRFROMDATE = "From";
    // Service (deleteAssignment)
    /** <code>deleteAssignment</code> service id. */
    public static final String SERV_ID_DELETEASSIGNMENT = "Clas_1468338274304118Ser_2_Alias";
    /** <code>deleteAssignment</code> service name. */
    public static final String SERV_NAME_DELETEASSIGNMENT = "deleteAssignment";
    /** <code>deleteAssignment</code> service alias. */
    public static final String SERV_ALIAS_DELETEASSIGNMENT = "Delete";
    /** Agents allowed to execute the service deleteAssignment **/
    public static final String DELETEASSIGNMENT_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>assignmentdeleteAssignmentpthisAssignment</code> inbound argument name. */
    public static final String ARG_NAME_DELETEASSIGNMENT_ASSIGNMENTDELETEASSIGNMENTPTHISASSIGNMENT = "p_thisAssignment";
    /** <code>assignmentdeleteAssignmentpthisAssignment</code> inbound argument id. */
    public static final String ARG_ID_DELETEASSIGNMENT_ASSIGNMENTDELETEASSIGNMENTPTHISASSIGNMENT = "Clas_1468338274304118Ser_2Arg_1_Alias";
    /** <code>assignmentdeleteAssignmentpthisAssignment</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEASSIGNMENT_ASSIGNMENTDELETEASSIGNMENTPTHISASSIGNMENT = "Assignment";
    // Service (editAssignment)
    /** <code>editAssignment</code> service id. */
    public static final String SERV_ID_EDITASSIGNMENT = "Clas_1468338274304118Ser_3_Alias";
    /** <code>editAssignment</code> service name. */
    public static final String SERV_NAME_EDITASSIGNMENT = "editAssignment";
    /** <code>editAssignment</code> service alias. */
    public static final String SERV_ALIAS_EDITASSIGNMENT = "Edit";
    /** Agents allowed to execute the service editAssignment **/
    public static final String EDITASSIGNMENT_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>assignmenteditAssignmentpthisAssignment</code> inbound argument name. */
    public static final String ARG_NAME_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPTHISASSIGNMENT = "p_thisAssignment";
    /** <code>assignmenteditAssignmentpthisAssignment</code> inbound argument id. */
    public static final String ARG_ID_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPTHISASSIGNMENT = "Clas_1468338274304118Ser_3Arg_1_Alias";
    /** <code>assignmenteditAssignmentpthisAssignment</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPTHISASSIGNMENT = "Assignment";
    /** <code>assignmenteditAssignmentpFromDate</code> inbound argument name. */
    public static final String ARG_NAME_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPFROMDATE = "p_FromDate";
    /** <code>assignmenteditAssignmentpFromDate</code> inbound argument id. */
    public static final String ARG_ID_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPFROMDATE = "Clas_1468338274304118Ser_3Arg_2_Alias";
    /** <code>assignmenteditAssignmentpFromDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPFROMDATE = "From";
    // Service (terminateAssignment)
    /** <code>terminateAssignment</code> service id. */
    public static final String SERV_ID_TERMINATEASSIGNMENT = "Clas_1468338274304118Ser_5_Alias";
    /** <code>terminateAssignment</code> service name. */
    public static final String SERV_NAME_TERMINATEASSIGNMENT = "terminateAssignment";
    /** <code>terminateAssignment</code> service alias. */
    public static final String SERV_ALIAS_TERMINATEASSIGNMENT = "Terminate";
    /** Agents allowed to execute the service terminateAssignment **/
    public static final String TERMINATEASSIGNMENT_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>assignmentterminateAssignmentpthisAssignment</code> inbound argument name. */
    public static final String ARG_NAME_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTHISASSIGNMENT = "p_thisAssignment";
    /** <code>assignmentterminateAssignmentpthisAssignment</code> inbound argument id. */
    public static final String ARG_ID_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTHISASSIGNMENT = "Clas_1468338274304118Ser_5Arg_1_Alias";
    /** <code>assignmentterminateAssignmentpthisAssignment</code> inbound argument alias. */
    public static final String ARG_ALIAS_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTHISASSIGNMENT = "Assignment";
    /** <code>assignmentterminateAssignmentpTerminationDate</code> inbound argument name. */
    public static final String ARG_NAME_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTERMINATIONDATE = "pTerminationDate";
    /** <code>assignmentterminateAssignmentpTerminationDate</code> inbound argument id. */
    public static final String ARG_ID_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTERMINATIONDATE = "Clas_1468338274304118Ser_5Arg_2_Alias";
    /** <code>assignmentterminateAssignmentpTerminationDate</code> inbound argument alias. */
    public static final String ARG_ALIAS_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTERMINATIONDATE = "Termination date";

    public static final String FILTER_NAME_FASSIGNMENTS = "F_Assignments";
    public static final String VAR_NAME_FASSIGNMENTS_VPROJECT = "v_Project";
    public static final String VAR_NAME_FASSIGNMENTS_VNAME = "v_Name";
    public static final String VAR_NAME_FASSIGNMENTS_VSURNAME = "v_Surname";
    public static final String VAR_NAME_FASSIGNMENTS_VACTIVE = "v_Active";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_ASSIGNMENTFROMDATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_ASSIGNMENTTODATE.toUpperCase(), Constants.Type.DATE.getTypeName());
        attributeTypes.put(ATTR_NAME_ASSIGNMENTISACTIVE.toUpperCase(), Constants.Type.BOOL.getTypeName());
        attributeTypes.put(ATTR_NAME_ASSIGNMENTDETAILS.toUpperCase(), Constants.Type.STRING.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_ASSIGNMENTASSIGNMENTID.toUpperCase(), ASSIGNMENTASSIGNMENTID_AGENTS);
    	attributeAgents.put(ATTR_NAME_ASSIGNMENTFROMDATE.toUpperCase(), ASSIGNMENTFROMDATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_ASSIGNMENTTODATE.toUpperCase(), ASSIGNMENTTODATE_AGENTS);
    	attributeAgents.put(ATTR_NAME_ASSIGNMENTISACTIVE.toUpperCase(), ASSIGNMENTISACTIVE_AGENTS);
    	attributeAgents.put(ATTR_NAME_ASSIGNMENTDETAILS.toUpperCase(), ASSIGNMENTDETAILS_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    public static final Map<String, String> ROLE_AGENTS;
    static {
        Map<String, String> roleAgents = new HashMap<>();
        roleAgents.put(ROLE_NAME_EMPLOYEE.toUpperCase(), EMPLOYEE_AGENTS);
        roleAgents.put(ROLE_NAME_PROJECT.toUpperCase(), PROJECT_AGENTS);
        ROLE_AGENTS = Collections.unmodifiableMap(roleAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'Assignment', it returns the identification keys
     * - If className is a facet of the inheritance net of 'Assignment', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_ASSIGNMENTASSIGNMENTID);
        }
        // Facet 'Assignment' (This facet)
        if (AssignmentConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_ASSIGNMENTASSIGNMENTID);
        }
        return returnList;
    }
}
