package com.integranova.spring.expensereportdemo.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with the constants relative to the <code>AppUser</code> model class.
 */
public final class AppUserConstants {

    private AppUserConstants() {

    }

    // Class
    /** <code>AppUser</code> class id. */
    public static final String CLASS_ID = "Clas_1468421898240231_Alias";
    /** <code>AppUser</code> class name. */
    public static final String CLASS_NAME = "AppUser";
    /** <code>AppUser</code> class alias. */
    public static final String CLASS_ALIAS = "User";
    /** <code>AppUser</code> class table name. */
    public static final String TBL_NAME = "AppUser";

    // Default DisplaySet
    public static final String DEFAULT_DISPLAYSET = "appUserLogin,passWord,appUserUserName,appUserUserSurname,appUserUserType";

    public static final String DSDSAPPUSERS = "DS_AppUsers";
    
    // Facet (AdminUser)
    /** <code>AdminUser</code> facet sequence. */
    public static final String CLASS_FACETS_ADMINUSER = AdminUserConstants.CLASS_NAME;
	
    public static final String CLASS_FACET_GETTER_ADMINUSER = Constants.CHILD_PREFIX + AdminUserConstants.CLASS_NAME;
    // Facet (OperatorUser)
    /** <code>OperatorUser</code> facet sequence. */
    public static final String CLASS_FACETS_OPERATORUSER = OperatorUserConstants.CLASS_NAME;
	
    public static final String CLASS_FACET_GETTER_OPERATORUSER = Constants.CHILD_PREFIX + OperatorUserConstants.CLASS_NAME;

    // Attribute (appUserLogin)
    /** <code>appUserLogin</code> attribute id. */
    public static final String ATTR_ID_APPUSERLOGIN = "Clas_1468421898240231Atr_1_Alias";
    /** <code>appUserLogin</code> attribute name. */
    public static final String ATTR_NAME_APPUSERLOGIN = "appUserLogin";
    /** <code>appUserLogin</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERLOGIN = "Login";

    /** <code>appUserLogin</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERLOGIN = "";
    /** Agents allowed to view the attribute appUserLogin **/
    public static final String APPUSERLOGIN_AGENTS = "AdminUser,OperatorUser,AppUser,AdminUser,OperatorUser";
    // Attribute (appUserUserName)
    /** <code>appUserUserName</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERNAME = "Clas_1468421898240231Atr_2_Alias";
    /** <code>appUserUserName</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERNAME = "appUserUserName";
    /** <code>appUserUserName</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERNAME = "Name";

    /** <code>appUserUserName</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERNAME = "";
    /** Agents allowed to view the attribute appUserUserName **/
    public static final String APPUSERUSERNAME_AGENTS = "AdminUser,OperatorUser,AppUser,AdminUser,OperatorUser";
    // Attribute (appUserUserSurname)
    /** <code>appUserUserSurname</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERSURNAME = "Clas_1468421898240231Atr_3_Alias";
    /** <code>appUserUserSurname</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERSURNAME = "appUserUserSurname";
    /** <code>appUserUserSurname</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERSURNAME = "Surname";

    /** <code>appUserUserSurname</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERSURNAME = "";
    /** Agents allowed to view the attribute appUserUserSurname **/
    public static final String APPUSERUSERSURNAME_AGENTS = "AdminUser,OperatorUser,AppUser,AdminUser,OperatorUser";
    // Attribute (appUserUserType)
    /** <code>appUserUserType</code> attribute id. */
    public static final String ATTR_ID_APPUSERUSERTYPE = "Clas_1468421898240231Atr_4_Alias";
    /** <code>appUserUserType</code> attribute name. */
    public static final String ATTR_NAME_APPUSERUSERTYPE = "appUserUserType";
    /** <code>appUserUserType</code> attribute alias. */
    public static final String ATTR_ALIAS_APPUSERUSERTYPE = "Type";

    /** <code>appUserUserType</code> attribute facet sequence. */
    public static final String PATH_FACETS_APPUSERUSERTYPE = "";
    /** Agents allowed to view the attribute appUserUserType **/
    public static final String APPUSERUSERTYPE_AGENTS = "AdminUser,OperatorUser,AppUser,AdminUser,OperatorUser";


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
    // Field (UserName)
    /** <code>UserName</code> field name. */
    public static final String FLD_APPUSERUSERNAME = "UserName";    
    /** <code>UserName</code> field length. */
    public static final int FLD_APPUSERUSERNAMELENGTH = 30;
    /** <code>appUserUserName</code> attribute field name. */
    public static final String ATTR_FIELD_APPUSERUSERNAME = "appUserUserName";
    // Field (UserSurname)
    /** <code>UserSurname</code> field name. */
    public static final String FLD_APPUSERUSERSURNAME = "UserSurname";    
    /** <code>UserSurname</code> field length. */
    public static final int FLD_APPUSERUSERSURNAMELENGTH = 50;
    /** <code>appUserUserSurname</code> attribute field name. */
    public static final String ATTR_FIELD_APPUSERUSERSURNAME = "appUserUserSurname";
    // Field (UserType)
    /** <code>UserType</code> field name. */
    public static final String FLD_APPUSERUSERTYPE = "UserType";    
    /** <code>UserType</code> field length. */
    public static final int FLD_APPUSERUSERTYPELENGTH = 3;
    /** <code>appUserUserType</code> attribute field name. */
    public static final String ATTR_FIELD_APPUSERUSERTYPE = "appUserUserType";



    // Service (newUser)
    /** <code>newUser</code> service id. */
    public static final String SERV_ID_NEWUSER = "Clas_1468421898240231Ser_2_Alias";
    /** <code>newUser</code> service name. */
    public static final String SERV_NAME_NEWUSER = "newUser";
    /** <code>newUser</code> service alias. */
    public static final String SERV_ALIAS_NEWUSER = "New User";
    /** Agents allowed to execute the service newUser **/
    public static final String NEWUSER_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>appUsernewUserpatrLogin</code> inbound argument name. */
    public static final String ARG_NAME_NEWUSER_APPUSERNEWUSERPATRLOGIN = "p_atrLogin";
    /** <code>appUsernewUserpatrLogin</code> inbound argument id. */
    public static final String ARG_ID_NEWUSER_APPUSERNEWUSERPATRLOGIN = "Clas_1468421898240231Ser_2Arg_1_Alias";
    /** <code>appUsernewUserpatrLogin</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRLOGIN = "Login";
    /** <code>appUsernewUserpatrUserName</code> inbound argument name. */
    public static final String ARG_NAME_NEWUSER_APPUSERNEWUSERPATRUSERNAME = "p_atrUserName";
    /** <code>appUsernewUserpatrUserName</code> inbound argument id. */
    public static final String ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERNAME = "Clas_1468421898240231Ser_2Arg_2_Alias";
    /** <code>appUsernewUserpatrUserName</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERNAME = "Name";
    /** <code>appUsernewUserpatrUserSurname</code> inbound argument name. */
    public static final String ARG_NAME_NEWUSER_APPUSERNEWUSERPATRUSERSURNAME = "p_atrUserSurname";
    /** <code>appUsernewUserpatrUserSurname</code> inbound argument id. */
    public static final String ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERSURNAME = "Clas_1468421898240231Ser_2Arg_3_Alias";
    /** <code>appUsernewUserpatrUserSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERSURNAME = "Surname";
    /** <code>appUsernewUserpatrUserType</code> inbound argument name. */
    public static final String ARG_NAME_NEWUSER_APPUSERNEWUSERPATRUSERTYPE = "p_atrUserType";
    /** <code>appUsernewUserpatrUserType</code> inbound argument id. */
    public static final String ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERTYPE = "Clas_1468421898240231Ser_2Arg_5_Alias";
    /** <code>appUsernewUserpatrUserType</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERTYPE = "Type";
    /** <code>appUsernewUserppassword</code> inbound argument name. */
    public static final String ARG_NAME_NEWUSER_APPUSERNEWUSERPP4SSW0RD = "p_password";
    /** <code>appUsernewUserppassword</code> inbound argument id. */
    public static final String ARG_ID_NEWUSER_APPUSERNEWUSERPP4SSW0RD = "Clas_1468421898240231Ser_2Arg_4_Alias";
    /** <code>appUsernewUserppassword</code> inbound argument alias. */
    public static final String ARG_ALIAS_NEWUSER_APPUSERNEWUSERPP4SSW0RD = "password";
    // Service (deleteUser)
    /** <code>deleteUser</code> service id. */
    public static final String SERV_ID_DELETEUSER = "Clas_1468421898240231Ser_3_Alias";
    /** <code>deleteUser</code> service name. */
    public static final String SERV_NAME_DELETEUSER = "deleteUser";
    /** <code>deleteUser</code> service alias. */
    public static final String SERV_ALIAS_DELETEUSER = "Delete User";
    /** Agents allowed to execute the service deleteUser **/
    public static final String DELETEUSER_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>appUserdeleteUserpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_DELETEUSER_APPUSERDELETEUSERPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUserdeleteUserpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_DELETEUSER_APPUSERDELETEUSERPTHISAPPUSER = "Clas_1468421898240231Ser_3Arg_1_Alias";
    /** <code>appUserdeleteUserpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_DELETEUSER_APPUSERDELETEUSERPTHISAPPUSER = "User";
    // Service (editUser)
    /** <code>editUser</code> service id. */
    public static final String SERV_ID_EDITUSER = "Clas_1468421898240231Ser_4_Alias";
    /** <code>editUser</code> service name. */
    public static final String SERV_NAME_EDITUSER = "editUser";
    /** <code>editUser</code> service alias. */
    public static final String SERV_ALIAS_EDITUSER = "editUser";
    /** Agents allowed to execute the service editUser **/
    public static final String EDITUSER_SRVAGENTS = "AdminUser,OperatorUser,AppUser";
    // Inbound arguments
    /** <code>appUsereditUserpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_EDITUSER_APPUSEREDITUSERPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsereditUserpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_EDITUSER_APPUSEREDITUSERPTHISAPPUSER = "Clas_1468421898240231Ser_4Arg_1_Alias";
    /** <code>appUsereditUserpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITUSER_APPUSEREDITUSERPTHISAPPUSER = "User";
    /** <code>appUsereditUserpUserName</code> inbound argument name. */
    public static final String ARG_NAME_EDITUSER_APPUSEREDITUSERPUSERNAME = "p_UserName";
    /** <code>appUsereditUserpUserName</code> inbound argument id. */
    public static final String ARG_ID_EDITUSER_APPUSEREDITUSERPUSERNAME = "Clas_1468421898240231Ser_4Arg_2_Alias";
    /** <code>appUsereditUserpUserName</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITUSER_APPUSEREDITUSERPUSERNAME = "Name";
    /** <code>appUsereditUserpUserSurname</code> inbound argument name. */
    public static final String ARG_NAME_EDITUSER_APPUSEREDITUSERPUSERSURNAME = "p_UserSurname";
    /** <code>appUsereditUserpUserSurname</code> inbound argument id. */
    public static final String ARG_ID_EDITUSER_APPUSEREDITUSERPUSERSURNAME = "Clas_1468421898240231Ser_4Arg_3_Alias";
    /** <code>appUsereditUserpUserSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_EDITUSER_APPUSEREDITUSERPUSERSURNAME = "Surname";
    // Service (setPassword)
    /** <code>setPassword</code> service id. */
    public static final String SERV_ID_SETP4SSW0RD = "Clas_1468421898240231Ser_5_Alias";
    /** <code>setPassword</code> service name. */
    public static final String SERV_NAME_SETP4SSW0RD = "setPassword";
    /** <code>setPassword</code> service alias. */
    public static final String SERV_ALIAS_SETP4SSW0RD = "Set password";
    /** Agents allowed to execute the service setPassword **/
    public static final String SETP4SSW0RD_SRVAGENTS = "AdminUser,OperatorUser,AppUser";
    // Inbound arguments
    /** <code>appUsersetPasswordpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_SETP4SSW0RD_APPUSERSETP4SSW0RDPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsersetPasswordpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_SETP4SSW0RD_APPUSERSETP4SSW0RDPTHISAPPUSER = "Clas_1468421898240231Ser_5Arg_1_Alias";
    /** <code>appUsersetPasswordpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_SETP4SSW0RD_APPUSERSETP4SSW0RDPTHISAPPUSER = "User";
    /** <code>appUsersetPasswordpNewPassword</code> inbound argument name. */
    public static final String ARG_NAME_SETP4SSW0RD_APPUSERSETP4SSW0RDPNEWP4SSW0RD = "p_NewPassword";
    /** <code>appUsersetPasswordpNewPassword</code> inbound argument id. */
    public static final String ARG_ID_SETP4SSW0RD_APPUSERSETP4SSW0RDPNEWP4SSW0RD = "Clas_1468421898240231Ser_5Arg_2_Alias";
    /** <code>appUsersetPasswordpNewPassword</code> inbound argument alias. */
    public static final String ARG_ALIAS_SETP4SSW0RD_APPUSERSETP4SSW0RDPNEWP4SSW0RD = "New password";
    // Service (makeAdmin)
    /** <code>makeAdmin</code> service id. */
    public static final String SERV_ID_MAKEADMIN = "Clas_1468421898240231Ser_6_Alias";
    /** <code>makeAdmin</code> service name. */
    public static final String SERV_NAME_MAKEADMIN = "makeAdmin";
    /** <code>makeAdmin</code> service alias. */
    public static final String SERV_ALIAS_MAKEADMIN = "makeAdmin";
    /** Agents allowed to execute the service makeAdmin **/
    public static final String MAKEADMIN_SRVAGENTS = "";
    // Inbound arguments
    /** <code>appUsermakeAdminpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_MAKEADMIN_APPUSERMAKEADMINPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsermakeAdminpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_MAKEADMIN_APPUSERMAKEADMINPTHISAPPUSER = "Clas_1468421898240231Ser_6Arg_1_Alias";
    /** <code>appUsermakeAdminpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_MAKEADMIN_APPUSERMAKEADMINPTHISAPPUSER = "User";
    // Service (makeOperator)
    /** <code>makeOperator</code> service id. */
    public static final String SERV_ID_MAKEOPERATOR = "Clas_1468421898240231Ser_7_Alias";
    /** <code>makeOperator</code> service name. */
    public static final String SERV_NAME_MAKEOPERATOR = "makeOperator";
    /** <code>makeOperator</code> service alias. */
    public static final String SERV_ALIAS_MAKEOPERATOR = "makeOperator";
    /** Agents allowed to execute the service makeOperator **/
    public static final String MAKEOPERATOR_SRVAGENTS = "";
    // Inbound arguments
    /** <code>appUsermakeOperatorpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_MAKEOPERATOR_APPUSERMAKEOPERATORPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsermakeOperatorpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_MAKEOPERATOR_APPUSERMAKEOPERATORPTHISAPPUSER = "Clas_1468421898240231Ser_7Arg_1_Alias";
    /** <code>appUsermakeOperatorpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_MAKEOPERATOR_APPUSERMAKEOPERATORPTHISAPPUSER = "User";
    // Service (changeUserType)
    /** <code>changeUserType</code> service id. */
    public static final String SERV_ID_CHANGEUSERTYPE = "Clas_1468421898240231Ser_8_Alias";
    /** <code>changeUserType</code> service name. */
    public static final String SERV_NAME_CHANGEUSERTYPE = "changeUserType";
    /** <code>changeUserType</code> service alias. */
    public static final String SERV_ALIAS_CHANGEUSERTYPE = "changeUserType";
    /** Agents allowed to execute the service changeUserType **/
    public static final String CHANGEUSERTYPE_SRVAGENTS = "";
    // Inbound arguments
    /** <code>appUserchangeUserTypepthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUserchangeUserTypepthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPTHISAPPUSER = "Clas_1468421898240231Ser_8Arg_1_Alias";
    /** <code>appUserchangeUserTypepthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPTHISAPPUSER = "User";
    /** <code>appUserchangeUserTypepNewType</code> inbound argument name. */
    public static final String ARG_NAME_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPNEWTYPE = "pNewType";
    /** <code>appUserchangeUserTypepNewType</code> inbound argument id. */
    public static final String ARG_ID_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPNEWTYPE = "Clas_1468421898240231Ser_8Arg_2_Alias";
    /** <code>appUserchangeUserTypepNewType</code> inbound argument alias. */
    public static final String ARG_ALIAS_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPNEWTYPE = "New Type";
    // Service (cancelAdmin)
    /** <code>cancelAdmin</code> service id. */
    public static final String SERV_ID_CANCELADMIN = "Clas_1468421898240231Ser_11_Alias";
    /** <code>cancelAdmin</code> service name. */
    public static final String SERV_NAME_CANCELADMIN = "cancelAdmin";
    /** <code>cancelAdmin</code> service alias. */
    public static final String SERV_ALIAS_CANCELADMIN = "cancelAdmin";
    /** Agents allowed to execute the service cancelAdmin **/
    public static final String CANCELADMIN_SRVAGENTS = "";
    // Inbound arguments
    /** <code>appUsercancelAdminpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_CANCELADMIN_APPUSERCANCELADMINPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsercancelAdminpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_CANCELADMIN_APPUSERCANCELADMINPTHISAPPUSER = "Clas_1468421898240231Ser_11Arg_1_Alias";
    /** <code>appUsercancelAdminpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_CANCELADMIN_APPUSERCANCELADMINPTHISAPPUSER = "User";
    // Service (cancelOperator)
    /** <code>cancelOperator</code> service id. */
    public static final String SERV_ID_CANCELOPERATOR = "Clas_1468421898240231Ser_12_Alias";
    /** <code>cancelOperator</code> service name. */
    public static final String SERV_NAME_CANCELOPERATOR = "cancelOperator";
    /** <code>cancelOperator</code> service alias. */
    public static final String SERV_ALIAS_CANCELOPERATOR = "cancelOperator";
    /** Agents allowed to execute the service cancelOperator **/
    public static final String CANCELOPERATOR_SRVAGENTS = "";
    // Inbound arguments
    /** <code>appUsercancelOperatorpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_CANCELOPERATOR_APPUSERCANCELOPERATORPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUsercancelOperatorpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_CANCELOPERATOR_APPUSERCANCELOPERATORPTHISAPPUSER = "Clas_1468421898240231Ser_12Arg_1_Alias";
    /** <code>appUsercancelOperatorpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_CANCELOPERATOR_APPUSERCANCELOPERATORPTHISAPPUSER = "User";
    // Service (TNEWUSER)
    /** <code>TNEWUSER</code> service id. */
    public static final String SERV_ID_TNEWUSER = "Clas_1468421898240231Ser_9_Alias";
    /** <code>TNEWUSER</code> service name. */
    public static final String SERV_NAME_TNEWUSER = "TNEWUSER";
    /** <code>TNEWUSER</code> service alias. */
    public static final String SERV_ALIAS_TNEWUSER = "New User";
    /** Agents allowed to execute the service TNEWUSER **/
    public static final String TNEWUSER_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>appUserTNEWUSERpLogin</code> inbound argument name. */
    public static final String ARG_NAME_TNEWUSER_APPUSERTNEWUSERPLOGIN = "pLogin";
    /** <code>appUserTNEWUSERpLogin</code> inbound argument id. */
    public static final String ARG_ID_TNEWUSER_APPUSERTNEWUSERPLOGIN = "Clas_1468421898240231Ser_9Arg_3_Alias";
    /** <code>appUserTNEWUSERpLogin</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPLOGIN = "Login";
    /** <code>appUserTNEWUSERpName</code> inbound argument name. */
    public static final String ARG_NAME_TNEWUSER_APPUSERTNEWUSERPNAME = "pName";
    /** <code>appUserTNEWUSERpName</code> inbound argument id. */
    public static final String ARG_ID_TNEWUSER_APPUSERTNEWUSERPNAME = "Clas_1468421898240231Ser_9Arg_5_Alias";
    /** <code>appUserTNEWUSERpName</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPNAME = "Name";
    /** <code>appUserTNEWUSERpSurname</code> inbound argument name. */
    public static final String ARG_NAME_TNEWUSER_APPUSERTNEWUSERPSURNAME = "pSurname";
    /** <code>appUserTNEWUSERpSurname</code> inbound argument id. */
    public static final String ARG_ID_TNEWUSER_APPUSERTNEWUSERPSURNAME = "Clas_1468421898240231Ser_9Arg_6_Alias";
    /** <code>appUserTNEWUSERpSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPSURNAME = "Surname";
    /** <code>appUserTNEWUSERpType</code> inbound argument name. */
    public static final String ARG_NAME_TNEWUSER_APPUSERTNEWUSERPTYPE = "pType";
    /** <code>appUserTNEWUSERpType</code> inbound argument id. */
    public static final String ARG_ID_TNEWUSER_APPUSERTNEWUSERPTYPE = "Clas_1468421898240231Ser_9Arg_7_Alias";
    /** <code>appUserTNEWUSERpType</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPTYPE = "Type";
    /** <code>appUserTNEWUSERpPassword</code> inbound argument name. */
    public static final String ARG_NAME_TNEWUSER_APPUSERTNEWUSERPP4SSW0RD = "pPassword";
    /** <code>appUserTNEWUSERpPassword</code> inbound argument id. */
    public static final String ARG_ID_TNEWUSER_APPUSERTNEWUSERPP4SSW0RD = "Clas_1468421898240231Ser_9Arg_9_Alias";
    /** <code>appUserTNEWUSERpPassword</code> inbound argument alias. */
    public static final String ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPP4SSW0RD = "Password";
    // Service (TEDITUSER)
    /** <code>TEDITUSER</code> service id. */
    public static final String SERV_ID_TEDITUSER = "Clas_1468421898240231Ser_10_Alias";
    /** <code>TEDITUSER</code> service name. */
    public static final String SERV_NAME_TEDITUSER = "TEDITUSER";
    /** <code>TEDITUSER</code> service alias. */
    public static final String SERV_ALIAS_TEDITUSER = "Edit User";
    /** Agents allowed to execute the service TEDITUSER **/
    public static final String TEDITUSER_SRVAGENTS = "AdminUser,OperatorUser";
    // Inbound arguments
    /** <code>appUserTEDITUSERpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_TEDITUSER_APPUSERTEDITUSERPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUserTEDITUSERpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_TEDITUSER_APPUSERTEDITUSERPTHISAPPUSER = "Clas_1468421898240231Ser_10Arg_1_Alias";
    /** <code>appUserTEDITUSERpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITUSER_APPUSERTEDITUSERPTHISAPPUSER = "User";
    /** <code>appUserTEDITUSERpName</code> inbound argument name. */
    public static final String ARG_NAME_TEDITUSER_APPUSERTEDITUSERPNAME = "pName";
    /** <code>appUserTEDITUSERpName</code> inbound argument id. */
    public static final String ARG_ID_TEDITUSER_APPUSERTEDITUSERPNAME = "Clas_1468421898240231Ser_10Arg_2_Alias";
    /** <code>appUserTEDITUSERpName</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITUSER_APPUSERTEDITUSERPNAME = "Name";
    /** <code>appUserTEDITUSERpSurname</code> inbound argument name. */
    public static final String ARG_NAME_TEDITUSER_APPUSERTEDITUSERPSURNAME = "pSurname";
    /** <code>appUserTEDITUSERpSurname</code> inbound argument id. */
    public static final String ARG_ID_TEDITUSER_APPUSERTEDITUSERPSURNAME = "Clas_1468421898240231Ser_10Arg_3_Alias";
    /** <code>appUserTEDITUSERpSurname</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITUSER_APPUSERTEDITUSERPSURNAME = "Surname";
    /** <code>appUserTEDITUSERpType</code> inbound argument name. */
    public static final String ARG_NAME_TEDITUSER_APPUSERTEDITUSERPTYPE = "pType";
    /** <code>appUserTEDITUSERpType</code> inbound argument id. */
    public static final String ARG_ID_TEDITUSER_APPUSERTEDITUSERPTYPE = "Clas_1468421898240231Ser_10Arg_4_Alias";
    /** <code>appUserTEDITUSERpType</code> inbound argument alias. */
    public static final String ARG_ALIAS_TEDITUSER_APPUSERTEDITUSERPTYPE = "Type";
    // Service (TDELETE)
    /** <code>TDELETE</code> service id. */
    public static final String SERV_ID_TDELETE = "Clas_1468421898240231Ser_13_Alias";
    /** <code>TDELETE</code> service name. */
    public static final String SERV_NAME_TDELETE = "TDELETE";
    /** <code>TDELETE</code> service alias. */
    public static final String SERV_ALIAS_TDELETE = "Delete User";
    /** Agents allowed to execute the service TDELETE **/
    public static final String TDELETE_SRVAGENTS = "AdminUser";
    // Inbound arguments
    /** <code>appUserTDELETEpthisAppUser</code> inbound argument name. */
    public static final String ARG_NAME_TDELETE_APPUSERTDELETEPTHISAPPUSER = "p_thisAppUser";
    /** <code>appUserTDELETEpthisAppUser</code> inbound argument id. */
    public static final String ARG_ID_TDELETE_APPUSERTDELETEPTHISAPPUSER = "Clas_1468421898240231Ser_13Arg_1_Alias";
    /** <code>appUserTDELETEpthisAppUser</code> inbound argument alias. */
    public static final String ARG_ALIAS_TDELETE_APPUSERTDELETEPTHISAPPUSER = "User";

    public static final String FILTER_NAME_FAPPUSERS = "F_AppUsers";
    public static final String VAR_NAME_FAPPUSERS_VNAME = "v_Name";
    public static final String VAR_NAME_FAPPUSERS_VSURNAME = "v_Surname";
    public static final String VAR_NAME_FAPPUSERS_VTYPE = "v_Type";

    public static final Map<String, String> ATTRIBUTE_TYPES;
    static {
        Map<String, String> attributeTypes = new HashMap<>();
        attributeTypes.put(ATTR_NAME_APPUSERUSERNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_APPUSERUSERSURNAME.toUpperCase(), Constants.Type.STRING.getTypeName());
        attributeTypes.put(ATTR_NAME_APPUSERUSERTYPE.toUpperCase(), Constants.Type.STRING.getTypeName());
        ATTRIBUTE_TYPES = Collections.unmodifiableMap(attributeTypes);
    }

    public static final Map<String, String> ATTRIBUTE_AGENTS;
    static {
    	Map<String, String> attributeAgents = new HashMap<>();
    	attributeAgents.put(ATTR_NAME_APPUSERLOGIN.toUpperCase(), APPUSERLOGIN_AGENTS);
    	attributeAgents.put(ATTR_NAME_APPUSERUSERNAME.toUpperCase(), APPUSERUSERNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_APPUSERUSERSURNAME.toUpperCase(), APPUSERUSERSURNAME_AGENTS);
    	attributeAgents.put(ATTR_NAME_APPUSERUSERTYPE.toUpperCase(), APPUSERUSERTYPE_AGENTS);
    	ATTRIBUTE_AGENTS = Collections.unmodifiableMap(attributeAgents);
    }

    /**
     * Method that returns the identification fields in this table.
     * - If className is 'AppUser', it returns the identification keys
     * - If className is a facet of the inheritance net of 'AppUser', it returns the foreign keys to the table of the facet className
     * - Otherwise it returns an empty array
     * @param className Facet whose keys are to be returned
     * @return Keys in the table for facet className
     */
    public static final List<String> getIdFields(String className) {
        List<String> returnList = new ArrayList<>();
        if (className == null || className.isEmpty()){
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'AdminUser'
        if (AdminUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'OperatorUser'
        if (OperatorUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        // Facet 'AppUser' (This facet)
        if (AppUserConstants.CLASS_NAME.equalsIgnoreCase(className)) {
            returnList.add(ATTR_FIELD_APPUSERLOGIN);
        }
        return returnList;
    }
}
