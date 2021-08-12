package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.repository.OperatorUserJpaRepository;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>OperatorUser</code> model class.
 * <p>
 * Model Class: <code>OperatorUser</code><br>
 */
@Entity(name = OperatorUserConstants.CLASS_NAME)
@Table(name = OperatorUserConstants.TBL_NAME)
public class OperatorUser extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient OperatorUserJpaRepository operatorUserRepository;

    /** Class identification function. */
    @Id
    @Column(name = OperatorUserConstants.FLD_APPUSERLOGIN, insertable = false, updatable = false )
    @Size(max = 50)
    @JsonProperty(value="login")
    private String appUserLogin;

    @Column(name = OperatorUserConstants.FLD_P4SSW0RD )
    private String passWord;

    @Transient
    @JsonIgnore
    private boolean modifiedPassWord;

    /** Class member parent. */
    @OneToOne
    @JoinColumns({
        @JoinColumn(name=OperatorUserConstants.FLD_APPUSERLOGIN, referencedColumnName=AppUserConstants.FLD_APPUSERLOGIN)
    })
    private AppUser parentAppUser;

    /** Class member parent initialized. */
    @Transient
    @JsonIgnore
    private boolean parentAppUserInitialized;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public OperatorUser() {
        appUserLogin = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>OperatorUser</code>.
     * @param oid Object Identifier of the instance of <code>OperatorUser</code> to be created.
     * @throws SystemException
     */
    public OperatorUser(OperatorUserOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            appUserLogin = oid.getAppUserLogin();
            initAttributes();
        }
    }


    public String getOperatorUserLogin() {
        return getAppUserLogin();
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
    public String getOperatorUserUserName()  {
        return getAppUserUserName();
    }

    public String getAppUserUserName()  {
    	String value;
        value = getParentAppUser().getAppUserUserName();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>appUserUserName</code> attribute.<br>
    * Model Attribute: <code>appUserUserName</code>. Variable String Size=30<br>
    * Comments: <br>
    * @param appUserUserName The new value of the <code>appUserUserName</code> attribute.
    */
    public void setAppUserUserName (String appUserUserName) {
        getParentAppUser().setAppUserUserName(appUserUserName);
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserName</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserName</code> class property.
    * @throws SystemException in case of any error.
    */
    public boolean isModifiedAppUserUserName() throws SystemException {
        return getAppUserFacet().isModifiedAppUserUserName();
    }

   /**
    * Returns the value of the <code>appUserUserSurname</code> attribute.<br>
    * Model Attribute: <code>appUserUserSurname</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>appUserUserSurname</code> attribute.
    */
    public String getOperatorUserUserSurname()  {
        return getAppUserUserSurname();
    }

    public String getAppUserUserSurname()  {
    	String value;
        value = getParentAppUser().getAppUserUserSurname();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>appUserUserSurname</code> attribute.<br>
    * Model Attribute: <code>appUserUserSurname</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param appUserUserSurname The new value of the <code>appUserUserSurname</code> attribute.
    */
    public void setAppUserUserSurname (String appUserUserSurname) {
        getParentAppUser().setAppUserUserSurname(appUserUserSurname);
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserSurname</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserSurname</code> class property.
    * @throws SystemException in case of any error.
    */
    public boolean isModifiedAppUserUserSurname() throws SystemException {
        return getAppUserFacet().isModifiedAppUserUserSurname();
    }

   /**
    * Returns the value of the <code>appUserUserType</code> attribute.<br>
    * Model Attribute: <code>appUserUserType</code>. Variable String Size=3<br>
    * Comments: ADM --> Administrator
OPR --> Operator
SUP --> SuperAdministrator<br>
    * @return The value of the <code>appUserUserType</code> attribute.
    */
    public String getOperatorUserUserType()  {
        return getAppUserUserType();
    }

    public String getAppUserUserType()  {
    	String value;
        value = getParentAppUser().getAppUserUserType();
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
        getParentAppUser().setAppUserUserType(appUserUserType);
    }

   /**
    * Returns the value of the <code>modifiedAppUserUserType</code> class property.<br>
    *
    * @return The value of the <code>modifiedAppUserUserType</code> class property.
    * @throws SystemException in case of any error.
    */
    public boolean isModifiedAppUserUserType() throws SystemException {
        return getAppUserFacet().isModifiedAppUserUserType();
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
        this.getParentAppUser().setPassWord(passWord);
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
     * Returns the parent <code>AppUser</code> instance.
     * @return The parent <code>AppUser</code> instance.
     */
    public AppUser getParentAppUser() {
        if (!parentAppUserInitialized) {
            setParentAppUser(operatorUserRepository.findParent(getAppUserLogin()));
        }
        return parentAppUser;
    }

    /**
     * Sets the parent <code>AppUser</code> instance.
     * @param parentAppUser the parent of this object.
     */
    public void setParentAppUser (AppUser parentAppUser) {
        this.parentAppUser = parentAppUser;
        this.parentAppUserInitialized = true;
    }
   /**
    * Returns The Facet <code>AppUser</code> of this instance in an inheritance net.
    * @return the Facet of <code>AppUser</code> of this instance in an inheritance net.
    */
    public AppUser getAppUserFacet() {
            return getParentAppUser();
    }
   /**
    * Returns The Facet <code>AdminUser</code> of this instance in an inheritance net.
    * @return the Facet of <code>AdminUser</code> of this instance in an inheritance net.
    */
    public AdminUser getAdminUserFacet() {
            return getParentAppUser().getChildAdminUser();
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
        parentAppUser = null;
        values = new HashMap<>();
        operatorUserRepository = BeanUtil.getBean(OperatorUserJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setOperatorUserRepository(OperatorUserJpaRepository operatorUserRepository) {
        this.operatorUserRepository = operatorUserRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return OperatorUser.class.getMethods();
    }


    /**
     * Provides the getter method name of the <code>inheritance</code> inheritance relationship.
     * @param inheritance the relationship name which getter method must be returned
     * @return the getter Method name for the given relationship or "" if the relationship does not exist
     */
    protected String getMethodNameInheritance(String inheritance) {
    	String getMethodName = "";
            if (inheritance.equalsIgnoreCase("parentAppUser")) {
                getMethodName = "getParentAppUser";
            }
            if (inheritance.equalsIgnoreCase("appuserfacet")) {
                getMethodName = "getAppUserFacet";
            }
            if (inheritance.equalsIgnoreCase("adminuserfacet")) {
                getMethodName = "getAdminUserFacet";
            }
        return getMethodName; 
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return OperatorUserConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
        getAppUserFacet().cleanDerivations();
    }

    /**
     * Returns the <code>OperatorUserOid</code> object that identifies this instance of <code>OperatorUser</code>.
     * @return <code>OperatorUserOid </code> object that identifies this instance of <code>OperatorUser</code>
     */
    public OperatorUserOid getOid() {
        return new OperatorUserOid(getAppUserLogin());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(OperatorUserConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }

    /**
     * Gets the list of active facets.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getActiveFacets() {
        return this.getAppUserFacet().getFacets();
    }

     /**
     * Gets the list of active facets recursively from the root of the inheritance net.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getFacets() {
        List<String> activeFacets = new ArrayList<>();

        if (!activeFacets.contains(Constants.OPERATORUSER)) {
            // Add this class
            activeFacets.add(Constants.OPERATORUSER);
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


        // Check inherited Horizontal Visibility Constraints
        if (!getParentAppUser().checkHorizontalVisibility(agent)) {
            returnValue = false;
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
}
