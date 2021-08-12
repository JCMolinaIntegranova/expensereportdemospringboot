package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>ERLTemplate</code> model class.
 * <p>
 * Model Class: <code>ERLTemplate</code><br>
 */
@Entity(name = ERLTemplateConstants.CLASS_NAME)
@Table(name = ERLTemplateConstants.TBL_NAME)
@IdClass(ERLTemplateOid.class)
public class ERLTemplate extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ERTemplateJpaRepository eRTemplateRepository;

    @JsonIgnore
    private transient ExpenseTypeJpaRepository expenseTypeRepository;

    /** Class identification function. */
    @Id
    @Column(name = ERLTemplateConstants.FLD_ERTEMPLATETEMPLATEID, insertable = false, updatable = false )
    @JsonProperty(value="template_id")
    private Long eRTemplateTemplateid;

    /** Class identification function. */
    @Id
    @Column(name = ERLTemplateConstants.FLD_ERLTEMPLATEID )
    @JsonProperty(value="id")
    private Long eRLTemplateid;

    /** Class member attribute. */
    @Column(name = ERLTemplateConstants.FLD_ERLTEMPLATEUNITS )
    @JsonProperty(value="units")
    private Double eRLTemplateunits;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERLTemplateunits;

    /** Class member attribute. */
    @Column(name = ERLTemplateConstants.FLD_ERLTEMPLATEPRICE )
    @JsonProperty(value="price")
    private Double eRLTemplateprice;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERLTemplateprice;

    /** Class member attribute. */
    @Column(name = ERLTemplateConstants.FLD_ERLTEMPLATEDESCRIPTION )
    @Size(max = 200)
    @JsonProperty(value="description")
    private String eRLTemplatedescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERLTemplatedescription;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totalline")
    protected Double eRLTemplatetotalLine;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ERLTemplateConstants.FLD_ERTEMPLATETEMPLATEID, referencedColumnName=ERTemplateConstants.FLD_ERTEMPLATEID, insertable = false, updatable = false)
    })
    @JsonIgnore
    private ERTemplate template;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTemplate;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ERLTemplateConstants.FLD_EXPENSETYPETYPECODE, referencedColumnName=ExpenseTypeConstants.FLD_EXPENSETYPETYPECODE)
    })
    @JsonIgnore
    private ExpenseType expenseType;
    /** Related attribute. */
    @Column(name = ERLTemplateConstants.FLD_EXPENSETYPETYPECODE, insertable = false, updatable = false)
    private String expenseTypeTypeCode;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseType;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ERLTemplate() {
        eRTemplateTemplateid = null;
        eRLTemplateid = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ERLTemplate</code>.
     * @param oid Object Identifier of the instance of <code>ERLTemplate</code> to be created.
     * @throws SystemException
     */
    public ERLTemplate(ERLTemplateOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            eRTemplateTemplateid = oid.getERTemplateTemplateid();
            eRLTemplateid = oid.getERLTemplateid();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code> through <code>Template</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERTemplate</code>
     * @return The value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code> through <code>Template</code>.
     */
    public Long getERTemplateTemplateid() {
        return (template != null ? template.getERTemplateid() : eRTemplateTemplateid);
    }

    /**
     * Sets the value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code> through <code>Template</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERTemplate</code>
     * @param eRTemplateTemplateid The new value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code> through <code>Template</code>.
     */
    public void setERTemplateTemplateid(Long eRTemplateTemplateid) {
        this.eRTemplateTemplateid = eRTemplateTemplateid;
    }


    /**
     * Returns the value of the <code>eRLTemplateid</code> attribute<br>in class <code>ERLTemplate</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERLTemplate</code>
     * @return The value of the <code>eRLTemplateid</code> attribute<br>in class <code>ERLTemplate</code>.
     */
    public Long getERLTemplateid() {
        return eRLTemplateid;
    }

    /**
     * Sets the value of the <code>eRLTemplateid</code> attribute<br>in class <code>ERLTemplate</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERLTemplate</code>
     * @param eRLTemplateid The new value of the <code>eRLTemplateid</code> attribute<br>in class <code>ERLTemplate</code>.
     */
    public void setERLTemplateid(Long eRLTemplateid) {
        this.eRLTemplateid = eRLTemplateid;
    }

   /**
    * Returns the value of the <code>eRLTemplateunits</code> attribute.<br>
    * Model Attribute: <code>eRLTemplateunits</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>eRLTemplateunits</code> attribute.
    */

    public Double getERLTemplateunits()  {
    	Double value;
        value =  eRLTemplateunits;
        return value;
    }

   /**
    * Sets the value of the <code>eRLTemplateunits</code> attribute.<br>
    * Model Attribute: <code>eRLTemplateunits</code>. Variable Real<br>
    * Comments: <br>
    * @param eRLTemplateunits The new value of the <code>eRLTemplateunits</code> attribute.
    */
    public void setERLTemplateunits (Double eRLTemplateunits) {
        modifiedERLTemplateunits = true;
        this.eRLTemplateunits = eRLTemplateunits;
    }

   /**
    * Returns the value of the <code>modifiedERLTemplateunits</code> class property.<br>
    *
    * @return The value of the <code>modifiedERLTemplateunits</code> class property.
    */
    public boolean isModifiedERLTemplateunits() {
        return modifiedERLTemplateunits;
    }

   /**
    * Sets the value of the <code>modifiedERLTemplateunits</code> class property.<br>
    * @param modified The new value of the <code>modifiedERLTemplateunits</code>.
    */
    public void setModifiedERLTemplateunits(boolean modified) {
        this.modifiedERLTemplateunits = modified;
    }

   /**
    * Returns the value of the <code>eRLTemplateprice</code> attribute.<br>
    * Model Attribute: <code>eRLTemplateprice</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>eRLTemplateprice</code> attribute.
    */

    public Double getERLTemplateprice()  {
    	Double value;
        value =  eRLTemplateprice;
        return value;
    }

   /**
    * Sets the value of the <code>eRLTemplateprice</code> attribute.<br>
    * Model Attribute: <code>eRLTemplateprice</code>. Variable Real<br>
    * Comments: <br>
    * @param eRLTemplateprice The new value of the <code>eRLTemplateprice</code> attribute.
    */
    public void setERLTemplateprice (Double eRLTemplateprice) {
        modifiedERLTemplateprice = true;
        this.eRLTemplateprice = eRLTemplateprice;
    }

   /**
    * Returns the value of the <code>modifiedERLTemplateprice</code> class property.<br>
    *
    * @return The value of the <code>modifiedERLTemplateprice</code> class property.
    */
    public boolean isModifiedERLTemplateprice() {
        return modifiedERLTemplateprice;
    }

   /**
    * Sets the value of the <code>modifiedERLTemplateprice</code> class property.<br>
    * @param modified The new value of the <code>modifiedERLTemplateprice</code>.
    */
    public void setModifiedERLTemplateprice(boolean modified) {
        this.modifiedERLTemplateprice = modified;
    }

   /**
    * Returns the value of the <code>eRLTemplatedescription</code> attribute.<br>
    * Model Attribute: <code>eRLTemplatedescription</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>eRLTemplatedescription</code> attribute.
    */

    public String getERLTemplatedescription()  {
    	String value;
        value =  eRLTemplatedescription;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>eRLTemplatedescription</code> attribute.<br>
    * Model Attribute: <code>eRLTemplatedescription</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param eRLTemplatedescription The new value of the <code>eRLTemplatedescription</code> attribute.
    */
    public void setERLTemplatedescription (String eRLTemplatedescription) {
        modifiedERLTemplatedescription = true;
        this.eRLTemplatedescription = eRLTemplatedescription;
    }

   /**
    * Returns the value of the <code>modifiedERLTemplatedescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedERLTemplatedescription</code> class property.
    */
    public boolean isModifiedERLTemplatedescription() {
        return modifiedERLTemplatedescription;
    }

   /**
    * Sets the value of the <code>modifiedERLTemplatedescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedERLTemplatedescription</code>.
    */
    public void setModifiedERLTemplatedescription(boolean modified) {
        this.modifiedERLTemplatedescription = modified;
    }

   /**
    * Returns the value of the <code>eRLTemplatetotalLine</code> attribute.<br>
    * Model Attribute: <code>eRLTemplatetotalLine</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>eRLTemplatetotalLine</code> attribute.
    */

    public Double getERLTemplatetotalLine()  {
    	Double value;
        try {
            value = eRLTemplatetotalLineDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ERLTemplate, Attribute: eRLTemplatetotalLine");
        }
        return value;
    }

    /**
     * Returns the instance of <code>ERTemplate</code> related through the <code>Template</code> role.
     * Model Relationship:
     * <code>[ERTemplate] Template 1:1  ------ 0:M  TemplateLines [ERLTemplate]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ERTemplate</code> related through the <code>Template</code> role.
     */
    public ERTemplate getTemplate() {
        if (template == null) {
            if (eRTemplateTemplateid != null) {
                template = eRTemplateRepository.findById(eRTemplateTemplateid).orElse(null);
            } else {
                template = null;
            }
        }
        return (template == null ? new ERTemplate(null) : template);
    }


   /**
    * Adds an instance of <code>ERTemplate</code> related through the <code>Template</code> role.
    * @param template The instance to add to the <code>Template</code> role.
    */
    public void add2Template(ERTemplate template) {
        if (template == null || template.isNull()) {
            this.modifiedTemplate = true;
            this.eRTemplateTemplateid = null;
        } else {
            this.eRTemplateTemplateid = template.getERTemplateid();
        }
        this.template = (template == null  || template.isNull() ? null : template);
    }

   /**
    * This method gets the attribute value <code>modifiedTemplate</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTemplate</code> has been modified.
    */
    public boolean isModifiedTemplate(){
        return modifiedTemplate;
    }

    /**
     * Returns the instance of <code>ExpenseType</code> related through the <code>ExpenseType</code> role.
     * Model Relationship:
     * <code>[ExpenseType] ExpenseType 1:1  ------ 0:M  TemplateLines [ERLTemplate]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseType</code> related through the <code>ExpenseType</code> role.
     */
    public ExpenseType getExpenseType() {
        if (expenseType == null) {
            if (expenseTypeTypeCode != null) {
                expenseType = expenseTypeRepository.findById(expenseTypeTypeCode).orElse(null);
            } else {
                expenseType = null;
            }
        }
        return (expenseType == null ? new ExpenseType(null) : expenseType);
    }


   /**
    * Adds an instance of <code>ExpenseType</code> related through the <code>ExpenseType</code> role.
    * @param expenseType The instance to add to the <code>ExpenseType</code> role.
    */
    public void add2ExpenseType(ExpenseType expenseType) {
        if (expenseType == null || expenseType.isNull()) {
            this.modifiedExpenseType = true;
            this.expenseTypeTypeCode = null;
        } else {
            this.expenseTypeTypeCode = expenseType.getExpenseTypeTypeCode();
        }
        this.expenseType = (expenseType == null  || expenseType.isNull() ? null : expenseType);
    }

   /**
    * This method gets the attribute value <code>modifiedExpenseType</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExpenseType</code> has been modified.
    */
    public boolean isModifiedExpenseType(){
        return modifiedExpenseType;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>eRLTemplatetotalLine</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>eRLTemplatetotalLine</code> derived attribute.
     */
    public Double eRLTemplatetotalLineDerivations() {

        eRLTemplatetotalLine = null;

        eRLTemplatetotalLineDerivationsDefault();
        return eRLTemplatetotalLine;
    }

    private void eRLTemplatetotalLineDerivationsDefault() {
        if (eRLTemplatetotalLine != null) return;
        // Default derivation
        // EFFECT   : units * price
        eRLTemplatetotalLine = this.getERLTemplateunits() * this.getERLTemplateprice();
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        eRLTemplateunits = Double.valueOf(0);
        eRLTemplateprice = Double.valueOf(0);
        eRLTemplatedescription = "";
        template = null;
        expenseType = null;
        values = new HashMap<>();
        eRTemplateRepository = BeanUtil.getBean(ERTemplateJpaRepository.class);
        expenseTypeRepository = BeanUtil.getBean(ExpenseTypeJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setERTemplateRepository(ERTemplateJpaRepository eRTemplateRepository) {
        this.eRTemplateRepository = eRTemplateRepository;
    }

    protected void setExpenseTypeRepository(ExpenseTypeJpaRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ERLTemplate.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ERLTemplateConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
    }

    /**
     * Returns the data type of the <code>attribute</code> defined in <code>role</code>.
     * @param role the owner class of the attribute.
     * @param attribute the attribute name whose data type name is to be returned.
     * @return the data type name of the given attribute or null if the attribute does not exist.
     */
    @Override
    public String getAttributeTypeRelated(String role, String attribute) {
        String returnedType = "";
        if (role.equalsIgnoreCase(ERLTemplateConstants.ROLE_NAME_TEMPLATE)){
            returnedType = new ERTemplate().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ERLTemplateConstants.ROLE_NAME_EXPENSETYPE)){
            returnedType = new ExpenseType().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedERLTemplateunits = false;
    	values.put("eRLTemplateunits", getERLTemplateunits());
    	modifiedERLTemplateprice = false;
    	values.put("eRLTemplateprice", getERLTemplateprice());
    	modifiedERLTemplatedescription = false;
    	values.put("eRLTemplatedescription", getERLTemplatedescription());
    	modifiedTemplate = false;
    	modifiedExpenseType = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            eRLTemplatetotalLine = null;
    }

    /**
     * Returns the <code>ERLTemplateOid</code> object that identifies this instance of <code>ERLTemplate</code>.
     * @return <code>ERLTemplateOid </code> object that identifies this instance of <code>ERLTemplate</code>
     */
    public ERLTemplateOid getOid() {
        return new ERLTemplateOid(getERTemplateTemplateid(), getERLTemplateid());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ERLTemplateConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ERLTemplateConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ERLTEMPLATE)) {
            // Add this class
            activeFacets.add(Constants.ERLTEMPLATE);
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


        if (getAgent().isFacetActive(Constants.AGENT_ADMINUSER) || getAgent().isFacetActive(Constants.AGENT_OPERATORUSER)) {
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

    public String buildDSTemplateLines() {
        try {
            return (getERLTemplateid() != null ? getERLTemplateid().toString() : "") + " " + (getERLTemplateunits() != null ? getERLTemplateunits().toString() : "") + " " + getERLTemplatedescription() + " " + (getERLTemplateprice() != null ? getERLTemplateprice().toString() : "") + " " + (getERLTemplatetotalLine() != null ? getERLTemplatetotalLine().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }
}
