package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>SystemParam</code> model class.
 * <p>
 * Model Class: <code>SystemParam</code><br>
 */
@Entity(name = SystemParamConstants.CLASS_NAME)
@Table(name = SystemParamConstants.TBL_NAME)
public class SystemParam extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    /** Class identification function. */
    @Id
    @Column(name = SystemParamConstants.FLD_SYSTEMPARAMPARAMCODE )
    @Size(max = 5)
    @JsonProperty(value="paramcode")
    private String systemParamparamCode;

    /** Class member attribute. */
    @Column(name = SystemParamConstants.FLD_SYSTEMPARAMNAME )
    @Size(max = 20)
    @JsonProperty(value="name")
    private String systemParamname;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSystemParamname;

    /** Class member attribute. */
    @Column(name = SystemParamConstants.FLD_SYSTEMPARAMDESCRIPTION )
    @JsonProperty(value="description")
    private String systemParamdescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSystemParamdescription;

    @Transient
    @JsonIgnore
    public boolean systemParamdescriptionInit = false;

    /** Class member attribute. */
    @Column(name = SystemParamConstants.FLD_SYSTEMPARAMTYPENAME )
    @Size(max = 10)
    @JsonProperty(value="typename")
    private String systemParamtypeName;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSystemParamtypeName;

    /** Class member attribute. */
    @Column(name = SystemParamConstants.FLD_SYSTEMPARAMPARAMVALUE )
    @Size(max = 100)
    @JsonProperty(value="paramvalue")
    private String systemParamparamValue;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSystemParamparamValue;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public SystemParam() {
        systemParamparamCode = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>SystemParam</code>.
     * @param oid Object Identifier of the instance of <code>SystemParam</code> to be created.
     * @throws SystemException
     */
    public SystemParam(SystemParamOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            systemParamparamCode = oid.getSystemParamparamCode();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>systemParamparamCode</code> attribute<br>in class <code>SystemParam</code>.
     * This is part of the identification for this class, which depends on the identification of <code>SystemParam</code>
     * @return The value of the <code>systemParamparamCode</code> attribute<br>in class <code>SystemParam</code>.
     */
    public String getSystemParamparamCode() {
        return (systemParamparamCode == null ? systemParamparamCode : systemParamparamCode.trim());
    }

    /**
     * Sets the value of the <code>systemParamparamCode</code> attribute<br>in class <code>SystemParam</code>.
     * This is part of the identification for this class, which depends on the identification of <code>SystemParam</code>
     * @param systemParamparamCode The new value of the <code>systemParamparamCode</code> attribute<br>in class <code>SystemParam</code>.
     */
    public void setSystemParamparamCode(String systemParamparamCode) {
        this.systemParamparamCode = systemParamparamCode;
    }

   /**
    * Returns the value of the <code>systemParamname</code> attribute.<br>
    * Model Attribute: <code>systemParamname</code>. Variable String Size=20<br>
    * Comments: <br>
    * @return The value of the <code>systemParamname</code> attribute.
    */

    public String getSystemParamname()  {
    	String value;
        value =  systemParamname;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>systemParamname</code> attribute.<br>
    * Model Attribute: <code>systemParamname</code>. Variable String Size=20<br>
    * Comments: <br>
    * @param systemParamname The new value of the <code>systemParamname</code> attribute.
    */
    public void setSystemParamname (String systemParamname) {
        modifiedSystemParamname = true;
        this.systemParamname = systemParamname;
    }

   /**
    * Returns the value of the <code>modifiedSystemParamname</code> class property.<br>
    *
    * @return The value of the <code>modifiedSystemParamname</code> class property.
    */
    public boolean isModifiedSystemParamname() {
        return modifiedSystemParamname;
    }

   /**
    * Sets the value of the <code>modifiedSystemParamname</code> class property.<br>
    * @param modified The new value of the <code>modifiedSystemParamname</code>.
    */
    public void setModifiedSystemParamname(boolean modified) {
        this.modifiedSystemParamname = modified;
    }

   /**
    * Returns the value of the <code>systemParamdescription</code> attribute.<br>
    * Model Attribute: <code>systemParamdescription</code>. Variable Text<br>
    * Comments: <br>
    * @return The value of the <code>systemParamdescription</code> attribute.
    */

    public String getSystemParamdescription()  {
    	String value;
        value =  systemParamdescription;
        return value;
    }

   /**
    * Sets the value of the <code>systemParamdescription</code> attribute.<br>
    * Model Attribute: <code>systemParamdescription</code>. Variable Text<br>
    * Comments: <br>
    * @param systemParamdescription The new value of the <code>systemParamdescription</code> attribute.
    */
    public void setSystemParamdescription (String systemParamdescription) {
        this.systemParamdescriptionInit = true;
        modifiedSystemParamdescription = true;
        this.systemParamdescription = systemParamdescription;
    }

   /**
    * Returns the value of the <code>modifiedSystemParamdescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedSystemParamdescription</code> class property.
    */
    public boolean isModifiedSystemParamdescription() {
        return modifiedSystemParamdescription;
    }

   /**
    * Sets the value of the <code>modifiedSystemParamdescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedSystemParamdescription</code>.
    */
    public void setModifiedSystemParamdescription(boolean modified) {
        this.modifiedSystemParamdescription = modified;
    }

   /**
    * Returns the value of the <code>systemParamtypeName</code> attribute.<br>
    * Model Attribute: <code>systemParamtypeName</code>. Variable String Size=10<br>
    * Comments: <br>
    * @return The value of the <code>systemParamtypeName</code> attribute.
    */

    public String getSystemParamtypeName()  {
    	String value;
        value =  systemParamtypeName;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>systemParamtypeName</code> attribute.<br>
    * Model Attribute: <code>systemParamtypeName</code>. Variable String Size=10<br>
    * Comments: <br>
    * @param systemParamtypeName The new value of the <code>systemParamtypeName</code> attribute.
    */
    public void setSystemParamtypeName (String systemParamtypeName) {
        modifiedSystemParamtypeName = true;
        this.systemParamtypeName = systemParamtypeName;
    }

   /**
    * Returns the value of the <code>modifiedSystemParamtypeName</code> class property.<br>
    *
    * @return The value of the <code>modifiedSystemParamtypeName</code> class property.
    */
    public boolean isModifiedSystemParamtypeName() {
        return modifiedSystemParamtypeName;
    }

   /**
    * Sets the value of the <code>modifiedSystemParamtypeName</code> class property.<br>
    * @param modified The new value of the <code>modifiedSystemParamtypeName</code>.
    */
    public void setModifiedSystemParamtypeName(boolean modified) {
        this.modifiedSystemParamtypeName = modified;
    }

   /**
    * Returns the value of the <code>systemParamparamValue</code> attribute.<br>
    * Model Attribute: <code>systemParamparamValue</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>systemParamparamValue</code> attribute.
    */

    public String getSystemParamparamValue()  {
    	String value;
        value =  systemParamparamValue;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>systemParamparamValue</code> attribute.<br>
    * Model Attribute: <code>systemParamparamValue</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param systemParamparamValue The new value of the <code>systemParamparamValue</code> attribute.
    */
    public void setSystemParamparamValue (String systemParamparamValue) {
        modifiedSystemParamparamValue = true;
        this.systemParamparamValue = systemParamparamValue;
    }

   /**
    * Returns the value of the <code>modifiedSystemParamparamValue</code> class property.<br>
    *
    * @return The value of the <code>modifiedSystemParamparamValue</code> class property.
    */
    public boolean isModifiedSystemParamparamValue() {
        return modifiedSystemParamparamValue;
    }

   /**
    * Sets the value of the <code>modifiedSystemParamparamValue</code> class property.<br>
    * @param modified The new value of the <code>modifiedSystemParamparamValue</code>.
    */
    public void setModifiedSystemParamparamValue(boolean modified) {
        this.modifiedSystemParamparamValue = modified;
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
        systemParamname = "";
        systemParamdescription = "";
        systemParamtypeName = "";
        systemParamparamValue = "";
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return SystemParam.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return SystemParamConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedSystemParamname = false;
    	values.put("systemParamname", getSystemParamname());
    	if (modifiedSystemParamdescription) {
    		values.put("systemParamdescription", systemParamdescription);
    		modifiedSystemParamdescription = false;
    	}
    	modifiedSystemParamtypeName = false;
    	values.put("systemParamtypeName", getSystemParamtypeName());
    	modifiedSystemParamparamValue = false;
    	values.put("systemParamparamValue", getSystemParamparamValue());
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>SystemParamOid</code> object that identifies this instance of <code>SystemParam</code>.
     * @return <code>SystemParamOid </code> object that identifies this instance of <code>SystemParam</code>
     */
    public SystemParamOid getOid() {
        return new SystemParamOid(getSystemParamparamCode());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(SystemParamConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.SYSTEMPARAM)) {
            // Add this class
            activeFacets.add(Constants.SYSTEMPARAM);
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


        if (getAgent().isFacetActive(Constants.AGENT_ADMINUSER)) {
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

    public String buildDSSystemParams() {
        try {
            return getSystemParamparamCode() + " " + getSystemParamname() + " " + getSystemParamtypeName() + " " + getSystemParamparamValue() + " " + getSystemParamdescription();
        } catch(Exception e) {
            return "";
        }
    }
}
