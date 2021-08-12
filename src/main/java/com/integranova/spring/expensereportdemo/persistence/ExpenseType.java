package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.service.BeanUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>ExpenseType</code> model class.
 * <p>
 * Model Class: <code>ExpenseType</code><br>
 */
@Entity(name = ExpenseTypeConstants.CLASS_NAME)
@Table(name = ExpenseTypeConstants.TBL_NAME)
public class ExpenseType extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ExpenseLineJpaRepository expenseLineRepository;

    @JsonIgnore
    private transient ERLTemplateJpaRepository eRLTemplateRepository;

    /** Class identification function. */
    @Id
    @Column(name = ExpenseTypeConstants.FLD_EXPENSETYPETYPECODE )
    @Size(max = 5)
    @JsonProperty(value="typecode")
    private String expenseTypeTypeCode;

    /** Class member attribute. */
    @Column(name = ExpenseTypeConstants.FLD_EXPENSETYPETYDESCRIPTION )
    @Size(max = 25)
    @JsonProperty(value="tydescription")
    private String expenseTypeTyDescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseTypeTyDescription;

    /** Class member attribute. */
    @Column(name = ExpenseTypeConstants.FLD_EXPENSETYPEPRICE )
    @JsonProperty(value="price")
    private Double expenseTypePrice;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseTypePrice;

    /** Class member attribute. */
    @Column(name = ExpenseTypeConstants.FLD_EXPENSETYPEFIXEDPRICE )
    @JsonProperty(value="fixedprice")
    private Boolean expenseTypeFixedPrice;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseTypeFixedPrice;

    /** Related Class. */
    @OneToMany(mappedBy = ExpenseTypeConstants.ROLE_INVNAME_EXPENSELINES)
    @JsonIgnore
    private Collection <ExpenseLine> expenseLines;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLines;

    /** Related Class. */
    @OneToMany(mappedBy = ExpenseTypeConstants.ROLE_INVNAME_TEMPLATELINES)
    @JsonIgnore
    private Collection <ERLTemplate> templateLines;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTemplateLines;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ExpenseType() {
        expenseTypeTypeCode = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ExpenseType</code>.
     * @param oid Object Identifier of the instance of <code>ExpenseType</code> to be created.
     * @throws SystemException
     */
    public ExpenseType(ExpenseTypeOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            expenseTypeTypeCode = oid.getExpenseTypeTypeCode();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>expenseTypeTypeCode</code> attribute<br>in class <code>ExpenseType</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseType</code>
     * @return The value of the <code>expenseTypeTypeCode</code> attribute<br>in class <code>ExpenseType</code>.
     */
    public String getExpenseTypeTypeCode() {
        return (expenseTypeTypeCode == null ? expenseTypeTypeCode : expenseTypeTypeCode.trim());
    }

    /**
     * Sets the value of the <code>expenseTypeTypeCode</code> attribute<br>in class <code>ExpenseType</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseType</code>
     * @param expenseTypeTypeCode The new value of the <code>expenseTypeTypeCode</code> attribute<br>in class <code>ExpenseType</code>.
     */
    public void setExpenseTypeTypeCode(String expenseTypeTypeCode) {
        this.expenseTypeTypeCode = expenseTypeTypeCode;
    }

   /**
    * Returns the value of the <code>expenseTypeTyDescription</code> attribute.<br>
    * Model Attribute: <code>expenseTypeTyDescription</code>. Variable String Size=25<br>
    * Comments: <br>
    * @return The value of the <code>expenseTypeTyDescription</code> attribute.
    */

    public String getExpenseTypeTyDescription()  {
    	String value;
        value =  expenseTypeTyDescription;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseTypeTyDescription</code> attribute.<br>
    * Model Attribute: <code>expenseTypeTyDescription</code>. Variable String Size=25<br>
    * Comments: <br>
    * @param expenseTypeTyDescription The new value of the <code>expenseTypeTyDescription</code> attribute.
    */
    public void setExpenseTypeTyDescription (String expenseTypeTyDescription) {
        modifiedExpenseTypeTyDescription = true;
        this.expenseTypeTyDescription = expenseTypeTyDescription;
    }

   /**
    * Returns the value of the <code>modifiedExpenseTypeTyDescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseTypeTyDescription</code> class property.
    */
    public boolean isModifiedExpenseTypeTyDescription() {
        return modifiedExpenseTypeTyDescription;
    }

   /**
    * Sets the value of the <code>modifiedExpenseTypeTyDescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseTypeTyDescription</code>.
    */
    public void setModifiedExpenseTypeTyDescription(boolean modified) {
        this.modifiedExpenseTypeTyDescription = modified;
    }

   /**
    * Returns the value of the <code>expenseTypePrice</code> attribute.<br>
    * Model Attribute: <code>expenseTypePrice</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>expenseTypePrice</code> attribute.
    */

    public Double getExpenseTypePrice()  {
    	Double value;
        value =  expenseTypePrice;
        return value;
    }

   /**
    * Sets the value of the <code>expenseTypePrice</code> attribute.<br>
    * Model Attribute: <code>expenseTypePrice</code>. Variable Real<br>
    * Comments: <br>
    * @param expenseTypePrice The new value of the <code>expenseTypePrice</code> attribute.
    */
    public void setExpenseTypePrice (Double expenseTypePrice) {
        modifiedExpenseTypePrice = true;
        this.expenseTypePrice = expenseTypePrice;
    }

   /**
    * Returns the value of the <code>modifiedExpenseTypePrice</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseTypePrice</code> class property.
    */
    public boolean isModifiedExpenseTypePrice() {
        return modifiedExpenseTypePrice;
    }

   /**
    * Sets the value of the <code>modifiedExpenseTypePrice</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseTypePrice</code>.
    */
    public void setModifiedExpenseTypePrice(boolean modified) {
        this.modifiedExpenseTypePrice = modified;
    }

   /**
    * Returns the value of the <code>expenseTypeFixedPrice</code> attribute.<br>
    * Model Attribute: <code>expenseTypeFixedPrice</code>. Variable Bool<br>
    * Comments: Req: Some expense types will have a fixed price.<br>
    * @return The value of the <code>expenseTypeFixedPrice</code> attribute.
    */

    public Boolean getExpenseTypeFixedPrice()  {
    	Boolean value;
        value =  expenseTypeFixedPrice;
        return value;
    }

   /**
    * Sets the value of the <code>expenseTypeFixedPrice</code> attribute.<br>
    * Model Attribute: <code>expenseTypeFixedPrice</code>. Variable Bool<br>
    * Comments: Req: Some expense types will have a fixed price.<br>
    * @param expenseTypeFixedPrice The new value of the <code>expenseTypeFixedPrice</code> attribute.
    */
    public void setExpenseTypeFixedPrice (Boolean expenseTypeFixedPrice) {
        modifiedExpenseTypeFixedPrice = true;
        this.expenseTypeFixedPrice = expenseTypeFixedPrice;
    }

   /**
    * Returns the value of the <code>modifiedExpenseTypeFixedPrice</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseTypeFixedPrice</code> class property.
    */
    public boolean isModifiedExpenseTypeFixedPrice() {
        return modifiedExpenseTypeFixedPrice;
    }

   /**
    * Sets the value of the <code>modifiedExpenseTypeFixedPrice</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseTypeFixedPrice</code>.
    */
    public void setModifiedExpenseTypeFixedPrice(boolean modified) {
        this.modifiedExpenseTypeFixedPrice = modified;
    }

    /**
     * Returns the instance of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
     * Model Relationship:
     * <code>[ExpenseLine] ExpenseLines 0:M  ------ 1:1  ExpenseType [ExpenseType]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
     */
    public Collection <ExpenseLine> getExpenseLines() {
        if (expenseLines == null || expenseLines.isEmpty()) {
            expenseLines = expenseLineRepository.findByExpenseType(this);
        }
        return expenseLines;
    }


   /**
    * Adds an instance of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
    * @param expenseLines The instance to add to the <code>ExpenseLines</code> role.
    */
    public void add2ExpenseLines(ExpenseLine expenseLines) {
        this.getExpenseLines().add(expenseLines);
    }
    /**
     * Sets instances of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
     * @param expenseLines The new value for the <code>ExpenseLines</code> role.
     */
    public void setExpenseLines(Collection < ExpenseLine > expenseLines) {
        this.expenseLines = expenseLines;
    }

   /**
    * This method gets the attribute value <code>modifiedExpenseLines</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExpenseLines</code> has been modified.
    */
    public boolean isModifiedExpenseLines(){
        return modifiedExpenseLines;
    }

    /**
     * Returns the instance of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
     * Model Relationship:
     * <code>[ERLTemplate] TemplateLines 0:M  ------ 1:1  ExpenseType [ExpenseType]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
     */
    public Collection <ERLTemplate> getTemplateLines() {
        if (templateLines == null || templateLines.isEmpty()) {
            templateLines = eRLTemplateRepository.findByExpenseType(this);
        }
        return templateLines;
    }


   /**
    * Adds an instance of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
    * @param templateLines The instance to add to the <code>TemplateLines</code> role.
    */
    public void add2TemplateLines(ERLTemplate templateLines) {
        this.getTemplateLines().add(templateLines);
    }
    /**
     * Sets instances of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
     * @param templateLines The new value for the <code>TemplateLines</code> role.
     */
    public void setTemplateLines(Collection < ERLTemplate > templateLines) {
        this.templateLines = templateLines;
    }

   /**
    * This method gets the attribute value <code>modifiedTemplateLines</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTemplateLines</code> has been modified.
    */
    public boolean isModifiedTemplateLines(){
        return modifiedTemplateLines;
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
        expenseTypeTyDescription = "";
        expenseTypePrice = Double.valueOf(0);
        expenseTypeFixedPrice = false;
        expenseLines = new ArrayList<>();
        templateLines = new ArrayList<>();
        values = new HashMap<>();
        expenseLineRepository = BeanUtil.getBean(ExpenseLineJpaRepository.class);
        eRLTemplateRepository = BeanUtil.getBean(ERLTemplateJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseLineRepository(ExpenseLineJpaRepository expenseLineRepository) {
        this.expenseLineRepository = expenseLineRepository;
    }

    protected void setERLTemplateRepository(ERLTemplateJpaRepository eRLTemplateRepository) {
        this.eRLTemplateRepository = eRLTemplateRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ExpenseType.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ExpenseTypeConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ExpenseTypeConstants.ROLE_NAME_EXPENSELINES)){
            returnedType = new ExpenseLine().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES)){
            returnedType = new ERLTemplate().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedExpenseTypeTyDescription = false;
    	values.put("expenseTypeTyDescription", getExpenseTypeTyDescription());
    	modifiedExpenseTypePrice = false;
    	values.put("expenseTypePrice", getExpenseTypePrice());
    	modifiedExpenseTypeFixedPrice = false;
    	values.put("expenseTypeFixedPrice", getExpenseTypeFixedPrice());
    	modifiedExpenseLines = false;
    	modifiedTemplateLines = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>ExpenseTypeOid</code> object that identifies this instance of <code>ExpenseType</code>.
     * @return <code>ExpenseTypeOid </code> object that identifies this instance of <code>ExpenseType</code>
     */
    public ExpenseTypeOid getOid() {
        return new ExpenseTypeOid(getExpenseTypeTypeCode());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ExpenseTypeConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EXPENSETYPE)) {
            // Add this class
            activeFacets.add(Constants.EXPENSETYPE);
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

    public String buildDSExpenseType() {
        try {
            return getExpenseTypeTypeCode() + " " + (getExpenseTypePrice() != null ? getExpenseTypePrice().toString() : "") + " " + getExpenseTypeTyDescription() + " " + (getExpenseTypeFixedPrice() != null ? getExpenseTypeFixedPrice().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSExpenseTypeSup() {
        try {
            return getExpenseTypeTyDescription();
        } catch(Exception e) {
            return "";
        }
    }
}
