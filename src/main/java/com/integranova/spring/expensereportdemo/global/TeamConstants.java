package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>Team</code> model class.
 */
public final class TeamConstants {

    private TeamConstants() {

    }

    // Class
    /** <code>Team</code> class id. */
    public static final String CLASS_ID = "Clas_1622453649408348_Alias";
    /** <code>Team</code> class name. */
    public static final String CLASS_NAME = "Team";
    /** <code>Team</code> class alias. */
    public static final String CLASS_ALIAS = "Team";
    /** <code>Team</code> class table name. */
    public static final String TBL_NAME = "Team";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "teamid,teamname,teammaxEmployees";

    public static final String DSDSTEAMS = "DS_Teams";
    public static final String DSDSTEAM = "DS_Team";
    

    // Attribute (teamid)
    /** <code>teamid</code> attribute id. */
    public static final String ATTR_ID_TEAMID = "Clas_1622453649408348Atr_2_Alias";
    /** <code>teamid</code> attribute name. */
    public static final String ATTR_NAME_TEAMID = "teamid";
    /** <code>teamid</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMID = "Team ID";

    /** <code>teamid</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMID = "";
    /** Agents allowed to view the attribute teamid **/
    public static final String TEAMID_AGENTS = "AdminUser,OperatorUser";
    // Attribute (teamname)
    /** <code>teamname</code> attribute id. */
    public static final String ATTR_ID_TEAMNAME = "Clas_1622453649408348Atr_3_Alias";
    /** <code>teamname</code> attribute name. */
    public static final String ATTR_NAME_TEAMNAME = "teamname";
    /** <code>teamname</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMNAME = "Name";

    /** <code>teamname</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMNAME = "";
    /** Agents allowed to view the attribute teamname **/
    public static final String TEAMNAME_AGENTS = "AdminUser,OperatorUser";
    // Attribute (teammaxEmployees)
    /** <code>teammaxEmployees</code> attribute id. */
    public static final String ATTR_ID_TEAMMAXEMPLOYEES = "Clas_1622453649408348Atr_4_Alias";
    /** <code>teammaxEmployees</code> attribute name. */
    public static final String ATTR_NAME_TEAMMAXEMPLOYEES = "teammaxEmployees";
    /** <code>teammaxEmployees</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMMAXEMPLOYEES = "Max Employees";

    /** <code>teammaxEmployees</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMMAXEMPLOYEES = "";
    /** Agents allowed to view the attribute teammaxEmployees **/
    public static final String TEAMMAXEMPLOYEES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (teamcountEmployees)
    /** <code>teamcountEmployees</code> attribute id. */
    public static final String ATTR_ID_TEAMCOUNTEMPLOYEES = "Clas_1622453649408348Atr_5_Alias";
    /** <code>teamcountEmployees</code> attribute name. */
    public static final String ATTR_NAME_TEAMCOUNTEMPLOYEES = "teamcountEmployees";
    /** <code>teamcountEmployees</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMCOUNTEMPLOYEES = "# employees";

    /** <code>teamcountEmployees</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMCOUNTEMPLOYEES = "";
    /** Agents allowed to view the attribute teamcountEmployees **/
    public static final String TEAMCOUNTEMPLOYEES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (teamtotalExpenses)
    /** <code>teamtotalExpenses</code> attribute id. */
    public static final String ATTR_ID_TEAMTOTALEXPENSES = "Clas_1622453649408348Atr_6_Alias";
    /** <code>teamtotalExpenses</code> attribute name. */
    public static final String ATTR_NAME_TEAMTOTALEXPENSES = "teamtotalExpenses";
    /** <code>teamtotalExpenses</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMTOTALEXPENSES = "Total expenses";

    /** <code>teamtotalExpenses</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMTOTALEXPENSES = "";
    /** Agents allowed to view the attribute teamtotalExpenses **/
    public static final String TEAMTOTALEXPENSES_AGENTS = "AdminUser,OperatorUser";
    // Attribute (teamcapacity)
    /** <code>teamcapacity</code> attribute id. */
    public static final String ATTR_ID_TEAMCAPACITY = "Clas_1622453649408348Atr_7_Alias";
    /** <code>teamcapacity</code> attribute name. */
    public static final String ATTR_NAME_TEAMCAPACITY = "teamcapacity";
    /** <code>teamcapacity</code> attribute alias. */
    public static final String ATTR_ALIAS_TEAMCAPACITY = "Capcity";

    /** <code>teamcapacity</code> attribute facet sequence. */
    public static final String PATH_FACETS_TEAMCAPACITY = "";
    /** Agents allowed to view the attribute teamcapacity **/
    public static final String TEAMCAPACITY_AGENTS = "AdminUser,OperatorUser";


    // Field (id)
    /** <code>id</code> field name. */
    public static final String FLD_TEAMID = "id";    
    /** <code>teamid</code> attribute field name. */
    public static final String ATTR_FIELD_TEAMID = "teamid";
    // Field (name)
    /** <code>name</code> field name. */
    public static final String FLD_TEAMNAME = "name";    
    /** <code>name</code> field length. */
    public static final int FLD_TEAMNAMELENGTH = 100;
    /** <code>teamname</code> attribute field name. */
    public static final String ATTR_FIELD_TEAMNAME = "teamname";
    // Field (maxEmployees)
    /** <code>maxEmployees</code> field name. */
    public static final String FLD_TEAMMAXEMPLOYEES = "maxEmployees";    
    /** <code>teammaxEmployees</code> attribute field name. */
    public static final String ATTR_FIELD_TEAMMAXEMPLOYEES = "teammaxEmployees";


    // Compound role (Employees)
    /** <code>Employees</code> role id. */
    public static final String ROLE_ID_EMPLOYEES = "Agr_1622453780480680_Alias";
    /** <code>Employees</code> role name. */
    public static final String ROLE_NAME_EMPLOYEES = "employees";
    /** <code>Teams</code> role alias. */
    public static final String ROLE_ALIAS_EMPLOYEES = "Employees";


    /** <code>Employees</code> inverse role name. */
    public static final String ROLE_INVNAME_EMPLOYEES = EmployeeConstants.ROLE_NAME_TEAMS;
    /** <code>Employees</code> role facet sequence. */
    public static final String PATH_FACETS_EMPLOYEES = "";
    /** <code>Employees</code> role target class. */
    public static final String ROLE_TARGET_EMPLOYEES = EmployeeConstants.CLASS_NAME;
    /** Agents allowed to navigate through Employees **/
    public static final String EMPLOYEES_AGENTS = "AdminUser,OperatorUser";
    // Compound role (Projects)
    /** <code>Projects</code> role id. */
    public static final String ROLE_ID_PROJECTS = "Agr_1622454829056100_Alias";
    /** <code>Projects</code> role name. */
    public static final String ROLE_NAME_PROJECTS = "projects";
    /** <code>Team</code> role alias. */
    public static final String ROLE_ALIAS_PROJECTS = "Projects";


    /** <code>Projects</code> inverse role name. */
    public static final String ROLE_INVNAME_PROJECTS = ProjectConstants.ROLE_NAME_TEAM;
    /** <code>Projects</code> role facet sequence. */
    public static final String PATH_FACETS_PROJECTS = "";
    /** <code>Projects</code> role target class. */
    public static final String ROLE_TARGET_PROJECTS = ProjectConstants.CLASS_NAME;
    /** Agents allowed to navigate through Projects **/
    public static final String PROJECTS_AGENTS = "AdminUser,OperatorUser";

    // Service (createinstance)
    /** <code>createinstance</code> service id. */
    public static final String SERV_ID_CREATEINSTANCE = "Clas_1622453649408348Ser_1_Alias";
    /** <code>createinstance</code> service name. */
    public static final String SERV_NAME_CREATEINSTANCE = "createinstance";
    /** <code>createinstance</code> service alias. */
    public static final String SERV_ALIAS_CREATEINSTANCE = "Create";
    /** Agents allowed to execute the service createinstance **/
    public static final String CREATEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>teamcreateinstancepatrname</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_TEAMCREATEINSTANCEPATRNAME = "p_atrname";
    /** <code>teamcreateinstancepatrname</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_TEAMCREATEINSTANCEPATRNAME = "Clas_1622453649408348Ser_1Arg_2_Alias";
    /** <code>teamcreateinstancepatrname</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_TEAMCREATEINSTANCEPATRNAME = "Name";
    /** <code>teamcreateinstancepatrmaxEmployees</code> inbound argument name. */
    public static final String ARG_NAME_CREATEINSTANCE_TEAMCREATEINSTANCEPATRMAXEMPLOYEES = "p_atrmaxEmployees";
    /** <code>teamcreateinstancepatrmaxEmployees</code> inbound argument id. */
    public static final String ARG_ID_CREATEINSTANCE_TEAMCREATEINSTANCEPATRMAXEMPLOYEES = "Clas_1622453649408348Ser_1Arg_3_Alias";
    /** <code>teamcreateinstancepatrmaxEmployees</code> inbound argument alias. */
    public static final String ARG_ALIAS_CREATEINSTANCE_TEAMCREATEINSTANCEPATRMAXEMPLOYEES = "Max Employees";
    // Service (deleteinstance)
    /** <code>deleteinstance</code> service id. */
    public static final String SERV_ID_DELETEINSTANCE = "Clas_1622453649408348Ser_2_Alias";
    /** <code>deleteinstance</code> service name. */
    public static final String SERV_NAME_DELETEINSTANCE = "deleteinstance";
    /** <code>deleteinstance</code> service alias. */
    public static final String SERV_ALIAS_DELETEINSTANCE = "Delete";
    /** Agents allowed to execute the service deleteinstance **/
    public static final String DELETEINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>teamdeleteinstancepthisTeam</code> inbound argument name. */
    public static final String ARG_NAME_DELETEINSTANCE_TEAMDELETEINSTANCEPTHISTEAM = "p_thisTeam";
    /** <code>teamdeleteinstancepthisTeam</code> inbound argument id. */
    public static final String ARG_ID_DELETEINSTANCE_TEAMDELETEINSTANCEPTHISTEAM = "Clas_1622453649408348Ser_2Arg_1_Alias";
    /** <code>teamdeleteinstancepthisTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEINSTANCE_TEAMDELETEINSTANCEPTHISTEAM = "Team";
    // Service (editinstance)
    /** <code>editinstance</code> service id. */
    public static final String SERV_ID_EDITINSTANCE = "Clas_1622453649408348Ser_3_Alias";
    /** <code>editinstance</code> service name. */
    public static final String SERV_NAME_EDITINSTANCE = "editinstance";
    /** <code>editinstance</code> service alias. */
    public static final String SERV_ALIAS_EDITINSTANCE = "Edit";
    /** Agents allowed to execute the service editinstance **/
    public static final String EDITINSTANCE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>teameditinstancepthisTeam</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_TEAMEDITINSTANCEPTHISTEAM = "p_thisTeam";
    /** <code>teameditinstancepthisTeam</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPTHISTEAM = "Clas_1622453649408348Ser_3Arg_1_Alias";
    /** <code>teameditinstancepthisTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPTHISTEAM = "Team";
    /** <code>teameditinstancepname</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_TEAMEDITINSTANCEPNAME = "p_name";
    /** <code>teameditinstancepname</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPNAME = "Clas_1622453649408348Ser_3Arg_2_Alias";
    /** <code>teameditinstancepname</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPNAME = "Name";
    /** <code>teameditinstancepmaxEmployees</code> inbound argument name. */
    public static final String ARG_NAME_EDITINSTANCE_TEAMEDITINSTANCEPMAXEMPLOYEES = "p_maxEmployees";
    /** <code>teameditinstancepmaxEmployees</code> inbound argument id. */
    public static final String ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPMAXEMPLOYEES = "Clas_1622453649408348Ser_3Arg_3_Alias";
    /** <code>teameditinstancepmaxEmployees</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPMAXEMPLOYEES = "Max Employees";
    // Service (addEmployeeToTeam)
    /** <code>addEmployeeToTeam</code> service id. */
    public static final String SERV_ID_ADDEMPLOYEETOTEAM = "Clas_1622453649408348Ser_4_Alias";
    /** <code>addEmployeeToTeam</code> service name. */
    public static final String SERV_NAME_ADDEMPLOYEETOTEAM = "addEmployeeToTeam";
    /** <code>addEmployeeToTeam</code> service alias. */
    public static final String SERV_ALIAS_ADDEMPLOYEETOTEAM = "addEmployeeToTeam";
    /** Agents allowed to execute the service addEmployeeToTeam **/
    public static final String ADDEMPLOYEETOTEAM_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>teamaddEmployeeToTeampthisTeam</code> inbound argument name. */
    public static final String ARG_NAME_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPTHISTEAM = "p_thisTeam";
    /** <code>teamaddEmployeeToTeampthisTeam</code> inbound argument id. */
    public static final String ARG_ID_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPTHISTEAM = "Clas_1622453649408348Ser_4Arg_1_Alias";
    /** <code>teamaddEmployeeToTeampthisTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPTHISTEAM = "Teams";
    /** <code>teamaddEmployeeToTeampevcEmployee</code> inbound argument name. */
    public static final String ARG_NAME_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPEVCEMPLOYEE = "p_evcEmployee";
    /** <code>teamaddEmployeeToTeampevcEmployee</code> inbound argument id. */
    public static final String ARG_ID_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPEVCEMPLOYEE = "Clas_1622453649408348Ser_4Arg_2_Alias";
    /** <code>teamaddEmployeeToTeampevcEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPEVCEMPLOYEE = "Employees";
    // Service (removeEmployeeFromTeam)
    /** <code>removeEmployeeFromTeam</code> service id. */
    public static final String SERV_ID_REMOVEEMPLOYEEFROMTEAM = "Clas_1622453649408348Ser_5_Alias";
    /** <code>removeEmployeeFromTeam</code> service name. */
    public static final String SERV_NAME_REMOVEEMPLOYEEFROMTEAM = "removeEmployeeFromTeam";
    /** <code>removeEmployeeFromTeam</code> service alias. */
    public static final String SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM = "removeEmployeeFromTeam";
    /** Agents allowed to execute the service removeEmployeeFromTeam **/
    public static final String REMOVEEMPLOYEEFROMTEAM_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>teamremoveEmployeeFromTeampthisTeam</code> inbound argument name. */
    public static final String ARG_NAME_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPTHISTEAM = "p_thisTeam";
    /** <code>teamremoveEmployeeFromTeampthisTeam</code> inbound argument id. */
    public static final String ARG_ID_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPTHISTEAM = "Clas_1622453649408348Ser_5Arg_1_Alias";
    /** <code>teamremoveEmployeeFromTeampthisTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPTHISTEAM = "Teams";
    /** <code>teamremoveEmployeeFromTeampevcEmployee</code> inbound argument name. */
    public static final String ARG_NAME_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPEVCEMPLOYEE = "p_evcEmployee";
    /** <code>teamremoveEmployeeFromTeampevcEmployee</code> inbound argument id. */
    public static final String ARG_ID_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPEVCEMPLOYEE = "Clas_1622453649408348Ser_5Arg_2_Alias";
    /** <code>teamremoveEmployeeFromTeampevcEmployee</code> inbound argument alias. */
    public static final String ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPEVCEMPLOYEE = "Employees";
    // Service (validate)
    /** <code>validate</code> service id. */
    public static final String SERV_ID_VALIDATE = "Clas_1622453649408348Ser_6_Alias";
    /** <code>validate</code> service name. */
    public static final String SERV_NAME_VALIDATE = "validate";
    /** <code>validate</code> service alias. */
    public static final String SERV_ALIAS_VALIDATE = "validate";
    /** Agents allowed to execute the service validate **/
    public static final String VALIDATE_SRVAGENTS = "";
    // Preconditions
    /** <code>validate</code> precondition 0 id. */
    public static final String PRE_ID_VALIDATE_0 = "Clas_1622453649408348Pre_1_MsgError";
    // Inbound arguments
    /** <code>teamvalidatepthisTeam</code> inbound argument name. */
    public static final String ARG_NAME_VALIDATE_TEAMVALIDATEPTHISTEAM = "p_thisTeam";
    /** <code>teamvalidatepthisTeam</code> inbound argument id. */
    public static final String ARG_ID_VALIDATE_TEAMVALIDATEPTHISTEAM = "Clas_1622453649408348Ser_6Arg_1_Alias";
    /** <code>teamvalidatepthisTeam</code> inbound argument alias. */
    public static final String ARG_ALIAS_VALIDATE_TEAMVALIDATEPTHISTEAM = "Team";

    public static final String FILTER_NAME_FTEAMSBYNAME = "FTeamsByName";
    public static final String VAR_NAME_FTEAMSBYNAME_VNAME = "vName";
    public static final String VAR_NAME_FTEAMSBYNAME_VCAPACITY = "vCapacity";
    public static final String FILTER_NAME_FTEAMSWITHCAPACITY = "FTeamsWithCapacity";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_TEAMNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_TEAMMAXEMPLOYEES.toUpperCase(), Constants.Type.INT.getTypeName());
        attributeTypes.put(ATTR_NAME_TEAMCOUNTEMPLOYEES.toUpperCase(), Constants.Type.INT.getTypeName());
        attributeTypes.put(ATTR_NAME_TEAMTOTALEXPENSES.toUpperCase(), Constants.Type.REAL.getTypeName());
        attributeTypes.put(ATTR_NAME_TEAMCAPACITY.toUpperCase(), Constants.Type.INT.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_TEAMID.toUpperCase(), TEAMID_AGENTS);
    	attributeAgents.put(ATTR_NAME_TEAMNAME.toUpperCase(), TEAMNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_TEAMMAXEMPLOYEES.toUpperCase(), TEAMMAXEMPLOYEES_AGENTS);
    	attributeAgents.put(ATTR_NAME_TEAMCOUNTEMPLOYEES.toUpperCase(), TEAMCOUNTEMPLOYEES_AGENTS);
    	attributeAgents.put(ATTR_NAME_TEAMTOTALEXPENSES.toUpperCase(), TEAMTOTALEXPENSES_AGENTS);
    	attributeAgents.put(ATTR_NAME_TEAMCAPACITY.toUpperCase(), TEAMCAPACITY_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'Team', it returns the identification keys
     * - If className is a facet of the inheritance net of 'Team', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_TEAMID);
        }
        // Facet 'Team' (This facet)
        if (TeamConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_TEAMID);
        }
        return returnList;
    }
}
