package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.repository.AppUserJpaRepository;
import com.integranova.spring.expensereportdemo.service.BeanUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>AppUser</code> model class.
 * <p>
 * Model Class: <code>AppUser</code><br>
 */
@Entity(name = AppUserConstants.CLASS_NAME)
@Table(name = AppUserConstants.TBL_NAME)
public class AppUser extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient AppUserJpaRepository appUserRepository;

    /** Class identification function. */
    @Id
    @Column(name = AppUserConstants.FLD_APPUSERLOGIN )
    @Size(max = 50)
    @JsonProperty(value="login")
    private String appUserLogin;

    /** Class member attribute. */
    @Column(name = AppUserConstants.FLD_APPUSERUSERNAME )
    @Size(max = 30)
    @JsonProperty(value="username")
    private String appUserUserName;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAppUserUserName;

    /** Class member attribute. */
    @Column(name = AppUserConstants.FLD_APPUSERUSERSURNAME )
    @Size(max = 50)
    @JsonProperty(value="usersurname")
    private String appUserUserSurname;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAppUserUserSurname;

    /** Class member attribute. */
    @Column(name = AppUserConstants.FLD_APPUSERUSERTYPE )
    @Size(max = 3)
    @JsonProperty(value="usertype")
    private String appUserUserType;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAppUserUserType;

    @Column(name = AppUserConstants.FLD_P4SSW0RD )
    private String passWord;

    @Transient
    @JsonIgnore
    private boolean modifiedPassWord;

    /** Class child member. */
    @OneToOne(mappedBy = "parentAppUser")
    private AdminUser childAdminUser;

    /** Class child member. */
    @OneToOne(mappedBy = "parentAppUser")
    private OperatorUser childOperatorUser;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public AppUser() {
        appUserLogin = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>AppUser</code>.
     * @param oid Object Identifier of the instance of <code>AppUser</code> to be created.
     * @throws SystemException
     */
    public AppUser(AppUserOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            appUserLogin = oid.getAppUserLogin();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>appUserLogin</code> attribute<br>in class <code>AppUser</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AppUser</code>
     * @return The value of the <code>appUserLogin</code> attribute<br>in class <code>AppUser</code>.
     */
    public String getAppUserLogin() {
        return (appUserLogin == null ? appUserLogin : appUserLogin.trim());
    }

    /**
     * Sets the value of the <code>appUserLogin</code> attribute<br>in class <code>AppUser</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AppUser</code>
     * @param appUserLogin The new value of the <code>appUserLogin</code> attribute<br>in class <code>AppUser</code>.
     */
    public void setAppUserLogin(String appUserLogin) {
        this.appUserLogin = appUserLogin;
    }

   /**
    * Returns the value of the <code>appUserUserName</code> attribute.<br>
    * Model Attribute: <code>appUserUserName</code>. Variable String Size=30<br>
    * Comments: <br>
    * @return The value of the <code>appUserUserName</code> attribute.
    */

    public String getAppUserUserName()  {
    	String value;
        value =  appUserUserName;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>appUserUserName</code> attribute.<br>
    * Model Attribute: <code>appUserUserName</code>. Variable String Size=30<br>
    * Comments: <br>
    * @param appUserUserName The new value of the <code>appUserUserName</code> attribute.
    */
    public void setAppUserUserName (String appUserUserName) {
        modifiedAppUserUserName = true;
        this.appUserUserName = appUserUserName;
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserName</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserName</code> class property.
    */
    public boolean isModifiedAppUserUserName() {
        return modifiedAppUserUserName;
    }

   /**
    * Sets the value of the <code>modifiedAppUserUserName</code> class property.<br>
    * @param modified The new value of the <code>modifiedAppUserUserName</code>.
    */
    public void setModifiedAppUserUserName(boolean modified) {
        this.modifiedAppUserUserName = modified;
    }

   /**
    * Returns the value of the <code>appUserUserSurname</code> attribute.<br>
    * Model Attribute: <code>appUserUserSurname</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>appUserUserSurname</code> attribute.
    */

    public String getAppUserUserSurname()  {
    	String value;
        value =  appUserUserSurname;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>appUserUserSurname</code> attribute.<br>
    * Model Attribute: <code>appUserUserSurname</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param appUserUserSurname The new value of the <code>appUserUserSurname</code> attribute.
    */
    public void setAppUserUserSurname (String appUserUserSurname) {
        modifiedAppUserUserSurname = true;
        this.appUserUserSurname = appUserUserSurname;
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserSurname</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserSurname</code> class property.
    */
    public boolean isModifiedAppUserUserSurname() {
        return modifiedAppUserUserSurname;
    }

   /**
    * Sets the value of the <code>modifiedAppUserUserSurname</code> class property.<br>
    * @param modified The new value of the <code>modifiedAppUserUserSurname</code>.
    */
    public void setModifiedAppUserUserSurname(boolean modified) {
        this.modifiedAppUserUserSurname = modified;
    }

   /**
    * Returns the value of the <code>appUserUserType</code> attribute.<br>
    * Model Attribute: <code>appUserUserType</code>. Variable String Size=3<br>
    * Comments: ADM --> Administrator
OPR --> Operator
SUP --> SuperAdministrator<br>
    * @return The value of the <code>appUserUserType</code> attribute.
    */

    public String getAppUserUserType()  {
    	String value;
        value =  appUserUserType;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>appUserUserType</code> attribute.<br>
    * Model Attribute: <code>appUserUserType</code>. Variable String Size=3<br>
    * Comments: ADM --> Administrator
OPR --> Operator
SUP --> SuperAdministrator<br>
    * @param appUserUserType The new value of the <code>appUserUserType</code> attribute.
    */
    public void setAppUserUserType (String appUserUserType) {
        modifiedAppUserUserType = true;
        this.appUserUserType = appUserUserType;
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserType</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserType</code> class property.
    */
    public boolean isModifiedAppUserUserType() {
        return modifiedAppUserUserType;
    }

   /**
    * Sets the value of the <code>modifiedAppUserUserType</code> class property.<br>
    * @param modified The new value of the <code>modifiedAppUserUserType</code>.
    */
    public void setModifiedAppUserUserType(boolean modified) {
        this.modifiedAppUserUserType = modified;
    }

   /**
    * Returns the password of this agent entity.
    * @return password of this agent entity
    */
    public String getPassWord() {
        return passWord;
    }

   /**
    * Sets the password of this agent entity.
    * @param passWord Password of this agent entity
    */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
        this.modifiedPassWord = true;
    }

   /**
    * Returns the value of the <code>modifiedPassWord</code> class property.<br>
    * @return The value of the <code>modifiedPassWord</code> class property.
    */
    public boolean isModifiedPassWord() {
        return modifiedPassWord;
    }

    /**
     * Returns the facet <code>AdminUser</code> instance.
     *
     * @return The facet <code>AdminUser</code> instance. Null if this instance is 
               not specialized.
     */
    public AdminUser getChildAdminUser() {
        if (childAdminUser == null || childAdminUser.isNull()) {
                this.setChildAdminUser(appUserRepository.findChildAdminUser(getOid().getAppUserLogin()));
        }
        return (childAdminUser == null ? new AdminUser(null) : childAdminUser);
    }

    /**
     * Sets the facet <code>AdminUser</code> instance.
     * @param childAdminUser the facet of this object.
     */
    public void setChildAdminUser (AdminUser childAdminUser) {
        this.childAdminUser = childAdminUser;
    }

    /**
     * Returns the facet <code>OperatorUser</code> instance.
     *
     * @return The facet <code>OperatorUser</code> instance. Null if this instance is 
               not specialized.
     */
    public OperatorUser getChildOperatorUser() {
        if (childOperatorUser == null || childOperatorUser.isNull()) {
                this.setChildOperatorUser(appUserRepository.findChildOperatorUser(getOid().getAppUserLogin()));
        }
        return (childOperatorUser == null ? new OperatorUser(null) : childOperatorUser);
    }

    /**
     * Sets the facet <code>OperatorUser</code> instance.
     * @param childOperatorUser the facet of this object.
     */
    public void setChildOperatorUser (OperatorUser childOperatorUser) {
        this.childOperatorUser = childOperatorUser;
    }
   /**
    * Returns The Facet <code>AdminUser</code> of this instance in an inheritance net.
    * @return the Facet of <code>AdminUser</code> of this instance in an inheritance net.
    */
    public AdminUser getAdminUserFacet() {
            return getChildAdminUser();
    }
   /**
    * Returns The Facet <code>OperatorUser</code> of this instance in an inheritance net.
    * @return the Facet of <code>OperatorUser</code> of this instance in an inheritance net.
    */
    public OperatorUser getOperatorUserFacet() {
            return getChildOperatorUser();
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        appUserUserName = "";
        appUserUserSurname = "";
        appUserUserType = "";
        childAdminUser = null;
        childOperatorUser = null;
        values = new HashMap<>();
        appUserRepository = BeanUtil.getBean(AppUserJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setAppUserRepository(AppUserJpaRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return AppUser.class.getMethods();
    }


    /**
     * Provides the getter method name of the <code>inheritance</code> inheritance relationship.
     * @param inheritance the relationship name which getter method must be returned
     * @return the getter Method name for the given relationship or "" if the relationship does not exist
     */
    protected String getMethodNameInheritance(String inheritance) {
    	String getMethodName = "";
            if (inheritance.equalsIgnoreCase("childAdminUser")) {
                getMethodName = "getChildAdminUser";
            }
            if (inheritance.equalsIgnoreCase("childOperatorUser")) {
                getMethodName = "getChildOperatorUser";
            }
            if (inheritance.equalsIgnoreCase("adminuserfacet")) {
                getMethodName = "getAdminUserFacet";
            }
            if (inheritance.equalsIgnoreCase("operatoruserfacet")) {
                getMethodName = "getOperatorUserFacet";
            }
        return getMethodName; 
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return AppUserConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedAppUserUserName = false;
    	values.put("appUserUserName", getAppUserUserName());
    	modifiedAppUserUserSurname = false;
    	values.put("appUserUserSurname", getAppUserUserSurname());
    	modifiedAppUserUserType = false;
    	values.put("appUserUserType", getAppUserUserType());
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>AppUserOid</code> object that identifies this instance of <code>AppUser</code>.
     * @return <code>AppUserOid </code> object that identifies this instance of <code>AppUser</code>
     */
    public AppUserOid getOid() {
        return new AppUserOid(getAppUserLogin());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(AppUserConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }

    /**
     * Gets the list of active facets.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getActiveFacets() {
        return this.getFacets();
    }

     /**
     * Gets the list of active facets recursively from the root of the inheritance net.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getFacets() {
        List<String> activeFacets = new ArrayList<>();

        // Add this class
        if (!activeFacets.contains(Constants.APPUSER)) {
            activeFacets.add(Constants.APPUSER);
        }
        // Add descendants of this class
        if (!getAdminUserFacet().isNull())	{
            activeFacets.addAll(getAdminUserFacet().getFacets());
        }
        if (!getOperatorUserFacet().isNull())	{
            activeFacets.addAll(getOperatorUserFacet().getFacets());
        }
        return activeFacets;
    }

   /**
    * Returns true if this instance can be observed by the connected agent.
    * @param agent Connected agent instance
    * @return TRUE if the connected agent can observe this instance. FALSE otherwise.
    */
    public boolean checkHorizontalVisibility(IEntity agent) {
        boolean returnValue = (!this.isNull());

        if (agent == null) return returnValue;


        if (getAgent().isFacetActive(Constants.AGENT_OPERATORUSER)) {
            OperatorUser agentInstance = (OperatorUser) getAgent().getAgentInstance(Constants.OPERATORUSER);

            // Check the HV formula.
            /* 
            AGENT.UserType = UserType
            */
            try {
                if ((agentInstance.getAppUserUserType()).equals(this.getAppUserUserType())) {
                    returnValue = true;
                }
            } catch (Exception e) {
            	returnValue = false;
            }
        }
        if (getAgent().isFacetActive(Constants.AGENT_APPUSER) || getAgent().isFacetActive(Constants.AGENT_ADMINUSER)) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * Checks Integrity Constraints defined in the class this entity is an instance of.
     * <p>
     * Raises an exception whenever an Integrity Constraint does not hold.
     * @throws IntegrityConstraintException if an integrity constraint isn't fulfilled.
     * @throws SystemException if there is any error on having checked integrity constraints.
     */
    public void checkIntegrityConstraints() throws IntegrityConstraintException, SystemException {
        /* There are no Integrity Constraints defined in this class */
    }

    public String buildDSAppUsers() {
        try {
            return getAppUserLogin() + " " + getAppUserUserSurname() + " " + getAppUserUserName() + " " + getAppUserUserType();
        } catch(Exception e) {
            return "";
        }
    }
}
