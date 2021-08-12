package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
import com.integranova.spring.expensereportdemo.service.BeanUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Date;
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
 * Persistent representation of the <code>ExpenseLine</code> model class.
 * <p>
 * Model Class: <code>ExpenseLine</code><br>
 */
@Entity(name = ExpenseLineConstants.CLASS_NAME)
@Table(name = ExpenseLineConstants.TBL_NAME)
@IdClass(ExpenseLineOid.class)
public class ExpenseLine extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ExpenseTypeJpaRepository expenseTypeRepository;

    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    /** Class identification function. */
    @Id
    @Column(name = ExpenseLineConstants.FLD_EXPENSEREPORTIDEXPENSEREPOR, insertable = false, updatable = false )
    @JsonProperty(value="id_expenserepor")
    private Long expenseReportidExpenseRepor;

    /** Class identification function. */
    @Id
    @Column(name = ExpenseLineConstants.FLD_EXPENSELINEIDEXPENSELINE )
    @JsonProperty(value="id_expenseline")
    private Long expenseLineidExpenseLine;

    /** Class member attribute. */
    @Column(name = ExpenseLineConstants.FLD_EXPENSELINEEXPENSEDATE )
    @JsonProperty(value="expensedate")
    private Date expenseLineExpenseDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLineExpenseDate;

    /** Class member attribute. */
    @Column(name = ExpenseLineConstants.FLD_EXPENSELINEUNITS )
    @JsonProperty(value="units")
    private Double expenseLineUnits;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLineUnits;

    /** Class member attribute. */
    @Column(name = ExpenseLineConstants.FLD_EXPENSELINEPRICE )
    @JsonProperty(value="price")
    private Double expenseLinePrice;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLinePrice;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totalline")
    protected Double expenseLineTotalLine;

    /** Class member attribute. */
    @Column(name = ExpenseLineConstants.FLD_EXPENSELINELNDESCRIPTION )
    @Size(max = 255)
    @JsonProperty(value="lndescription")
    private String expenseLineLnDescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLineLnDescription;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totallinecurr")
    protected Double expenseLineTotalLineCurr;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseLineConstants.FLD_EXPENSETYPETYPECODE, referencedColumnName=ExpenseTypeConstants.FLD_EXPENSETYPETYPECODE)
    })
    @JsonIgnore
    private ExpenseType expenseType;
    /** Related attribute. */
    @Column(name = ExpenseLineConstants.FLD_EXPENSETYPETYPECODE, insertable = false, updatable = false)
    private String expenseTypeTypeCode;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseType;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseLineConstants.FLD_EXPENSEREPORTIDEXPENSEREPOR, referencedColumnName=ExpenseReportConstants.FLD_EXPENSEREPORTIDEXPENSEREPOR, insertable = false, updatable = false)
    })
    @JsonIgnore
    private ExpenseReport expenseReport;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReport;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ExpenseLine() {
        expenseReportidExpenseRepor = null;
        expenseLineidExpenseLine = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ExpenseLine</code>.
     * @param oid Object Identifier of the instance of <code>ExpenseLine</code> to be created.
     * @throws SystemException
     */
    public ExpenseLine(ExpenseLineOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            expenseReportidExpenseRepor = oid.getExpenseReportidExpenseRepor();
            expenseLineidExpenseLine = oid.getExpenseLineidExpenseLine();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code> through <code>ExpenseReport</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseReport</code>
     * @return The value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code> through <code>ExpenseReport</code>.
     */
    public Long getExpenseReportidExpenseRepor() {
        return (expenseReport != null ? expenseReport.getExpenseReportidExpenseRepor() : expenseReportidExpenseRepor);
    }

    /**
     * Sets the value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code> through <code>ExpenseReport</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseReport</code>
     * @param expenseReportidExpenseRepor The new value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code> through <code>ExpenseReport</code>.
     */
    public void setExpenseReportidExpenseRepor(Long expenseReportidExpenseRepor) {
        this.expenseReportidExpenseRepor = expenseReportidExpenseRepor;
    }


    /**
     * Returns the value of the <code>expenseLineidExpenseLine</code> attribute<br>in class <code>ExpenseLine</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseLine</code>
     * @return The value of the <code>expenseLineidExpenseLine</code> attribute<br>in class <code>ExpenseLine</code>.
     */
    public Long getExpenseLineidExpenseLine() {
        return expenseLineidExpenseLine;
    }

    /**
     * Sets the value of the <code>expenseLineidExpenseLine</code> attribute<br>in class <code>ExpenseLine</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseLine</code>
     * @param expenseLineidExpenseLine The new value of the <code>expenseLineidExpenseLine</code> attribute<br>in class <code>ExpenseLine</code>.
     */
    public void setExpenseLineidExpenseLine(Long expenseLineidExpenseLine) {
        this.expenseLineidExpenseLine = expenseLineidExpenseLine;
    }

   /**
    * Returns the value of the <code>expenseLineExpenseDate</code> attribute.<br>
    * Model Attribute: <code>expenseLineExpenseDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>expenseLineExpenseDate</code> attribute.
    */

    public Date getExpenseLineExpenseDate()  {
    	Date value;
        value =  expenseLineExpenseDate;
        return value;
    }

   /**
    * Sets the value of the <code>expenseLineExpenseDate</code> attribute.<br>
    * Model Attribute: <code>expenseLineExpenseDate</code>. Variable Date<br>
    * Comments: <br>
    * @param expenseLineExpenseDate The new value of the <code>expenseLineExpenseDate</code> attribute.
    */
    public void setExpenseLineExpenseDate (Date expenseLineExpenseDate) {
        modifiedExpenseLineExpenseDate = true;
        this.expenseLineExpenseDate = expenseLineExpenseDate;
    }

   /**
    * Returns the value of the <code>modifiedExpenseLineExpenseDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseLineExpenseDate</code> class property.
    */
    public boolean isModifiedExpenseLineExpenseDate() {
        return modifiedExpenseLineExpenseDate;
    }

   /**
    * Sets the value of the <code>modifiedExpenseLineExpenseDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseLineExpenseDate</code>.
    */
    public void setModifiedExpenseLineExpenseDate(boolean modified) {
        this.modifiedExpenseLineExpenseDate = modified;
    }

   /**
    * Returns the value of the <code>expenseLineUnits</code> attribute.<br>
    * Model Attribute: <code>expenseLineUnits</code>. Variable Real<br>
    * Comments: Req: The meaning will depend on expense type. Some types will not allow operator to use this.<br>
    * @return The value of the <code>expenseLineUnits</code> attribute.
    */

    public Double getExpenseLineUnits()  {
    	Double value;
        value =  expenseLineUnits;
        return value;
    }

   /**
    * Sets the value of the <code>expenseLineUnits</code> attribute.<br>
    * Model Attribute: <code>expenseLineUnits</code>. Variable Real<br>
    * Comments: Req: The meaning will depend on expense type. Some types will not allow operator to use this.<br>
    * @param expenseLineUnits The new value of the <code>expenseLineUnits</code> attribute.
    */
    public void setExpenseLineUnits (Double expenseLineUnits) {
        modifiedExpenseLineUnits = true;
        this.expenseLineUnits = expenseLineUnits;
    }

   /**
    * Returns the value of the <code>modifiedExpenseLineUnits</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseLineUnits</code> class property.
    */
    public boolean isModifiedExpenseLineUnits() {
        return modifiedExpenseLineUnits;
    }

   /**
    * Sets the value of the <code>modifiedExpenseLineUnits</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseLineUnits</code>.
    */
    public void setModifiedExpenseLineUnits(boolean modified) {
        this.modifiedExpenseLineUnits = modified;
    }

   /**
    * Returns the value of the <code>expenseLinePrice</code> attribute.<br>
    * Model Attribute: <code>expenseLinePrice</code>. Variable Real<br>
    * Comments: Req: Prize to apply. Prize per unit in pattern currency. Depends on expense type.<br>
    * @return The value of the <code>expenseLinePrice</code> attribute.
    */

    public Double getExpenseLinePrice()  {
    	Double value;
        value =  expenseLinePrice;
        return value;
    }

   /**
    * Sets the value of the <code>expenseLinePrice</code> attribute.<br>
    * Model Attribute: <code>expenseLinePrice</code>. Variable Real<br>
    * Comments: Req: Prize to apply. Prize per unit in pattern currency. Depends on expense type.<br>
    * @param expenseLinePrice The new value of the <code>expenseLinePrice</code> attribute.
    */
    public void setExpenseLinePrice (Double expenseLinePrice) {
        modifiedExpenseLinePrice = true;
        this.expenseLinePrice = expenseLinePrice;
    }

   /**
    * Returns the value of the <code>modifiedExpenseLinePrice</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseLinePrice</code> class property.
    */
    public boolean isModifiedExpenseLinePrice() {
        return modifiedExpenseLinePrice;
    }

   /**
    * Sets the value of the <code>modifiedExpenseLinePrice</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseLinePrice</code>.
    */
    public void setModifiedExpenseLinePrice(boolean modified) {
        this.modifiedExpenseLinePrice = modified;
    }

   /**
    * Returns the value of the <code>expenseLineTotalLine</code> attribute.<br>
    * Model Attribute: <code>expenseLineTotalLine</code>. Variable Real<br>
    * Comments: Req: Expense Line total. Both currencies<br>
    * @return The value of the <code>expenseLineTotalLine</code> attribute.
    */

    public Double getExpenseLineTotalLine()  {
    	Double value;
        try {
            value = expenseLineTotalLineDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseLine, Attribute: expenseLineTotalLine");
        }
        return value;
    }

   /**
    * Returns the value of the <code>expenseLineLnDescription</code> attribute.<br>
    * Model Attribute: <code>expenseLineLnDescription</code>. Variable String Size=255<br>
    * Comments: Description<br>
    * @return The value of the <code>expenseLineLnDescription</code> attribute.
    */

    public String getExpenseLineLnDescription()  {
    	String value;
        value =  expenseLineLnDescription;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseLineLnDescription</code> attribute.<br>
    * Model Attribute: <code>expenseLineLnDescription</code>. Variable String Size=255<br>
    * Comments: Description<br>
    * @param expenseLineLnDescription The new value of the <code>expenseLineLnDescription</code> attribute.
    */
    public void setExpenseLineLnDescription (String expenseLineLnDescription) {
        modifiedExpenseLineLnDescription = true;
        this.expenseLineLnDescription = expenseLineLnDescription;
    }

   /**
    * Returns the value of the <code>modifiedExpenseLineLnDescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseLineLnDescription</code> class property.
    */
    public boolean isModifiedExpenseLineLnDescription() {
        return modifiedExpenseLineLnDescription;
    }

   /**
    * Sets the value of the <code>modifiedExpenseLineLnDescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseLineLnDescription</code>.
    */
    public void setModifiedExpenseLineLnDescription(boolean modified) {
        this.modifiedExpenseLineLnDescription = modified;
    }

   /**
    * Returns the value of the <code>expenseLineTotalLineCurr</code> attribute.<br>
    * Model Attribute: <code>expenseLineTotalLineCurr</code>. Variable Real<br>
    * Comments: Req: Expense Line total. Both currencies<br>
    * @return The value of the <code>expenseLineTotalLineCurr</code> attribute.
    */

    public Double getExpenseLineTotalLineCurr()  {
    	Double value;
        try {
            value = expenseLineTotalLineCurrDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseLine, Attribute: expenseLineTotalLineCurr");
        }
        return value;
    }

    /**
     * Returns the instance of <code>ExpenseType</code> related through the <code>ExpenseType</code> role.
     * Model Relationship:
     * <code>[ExpenseType] ExpenseType 1:1  ------ 0:M  ExpenseLines [ExpenseLine]</code>
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
     * Returns the instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     * Model Relationship:
     * <code>[ExpenseReport] ExpenseReport 1:1  ------ 0:M  ExpenseLines [ExpenseLine]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     */
    public ExpenseReport getExpenseReport() {
        if (expenseReport == null) {
            if (expenseReportidExpenseRepor != null) {
                expenseReport = expenseReportRepository.findById(expenseReportidExpenseRepor).orElse(null);
            } else {
                expenseReport = null;
            }
        }
        return (expenseReport == null ? new ExpenseReport(null) : expenseReport);
    }


   /**
    * Adds an instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
    * @param expenseReport The instance to add to the <code>ExpenseReport</code> role.
    */
    public void add2ExpenseReport(ExpenseReport expenseReport) {
        if (expenseReport == null || expenseReport.isNull()) {
            this.modifiedExpenseReport = true;
            this.expenseReportidExpenseRepor = null;
        } else {
            this.expenseReportidExpenseRepor = expenseReport.getExpenseReportidExpenseRepor();
        }
        this.expenseReport = (expenseReport == null  || expenseReport.isNull() ? null : expenseReport);
    }

   /**
    * This method gets the attribute value <code>modifiedExpenseReport</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExpenseReport</code> has been modified.
    */
    public boolean isModifiedExpenseReport(){
        return modifiedExpenseReport;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>expenseLineTotalLine</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseLineTotalLine</code> derived attribute.
     */
    public Double expenseLineTotalLineDerivations() {

        expenseLineTotalLine = null;

        expenseLineTotalLineDerivationsDefault();
        return expenseLineTotalLine;
    }

    private void expenseLineTotalLineDerivationsDefault() {
        if (expenseLineTotalLine != null) return;
        // Default derivation
        // EFFECT   : Price * Units
        expenseLineTotalLine = this.getExpenseLinePrice() * this.getExpenseLineUnits();
    }

    /**
     * Computes the value of the <code>expenseLineTotalLineCurr</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseLineTotalLineCurr</code> derived attribute.
     */
    public Double expenseLineTotalLineCurrDerivations() {

        expenseLineTotalLineCurr = null;

        expenseLineTotalLineCurrDerivationsDefault();
        return expenseLineTotalLineCurr;
    }

    private void expenseLineTotalLineCurrDerivationsDefault() {
        if (expenseLineTotalLineCurr != null) return;
        // Default derivation
        // EFFECT   : TotalLine * ExpenseReport.Exchange
        expenseLineTotalLineCurr = this.getExpenseLineTotalLine() * this.getExpenseReport().getExpenseReportExchange();
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        expenseLineExpenseDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        expenseLineUnits = Double.valueOf(0);
        expenseLinePrice = Double.valueOf(0);
        expenseLineLnDescription = "";
        expenseType = null;
        expenseReport = null;
        values = new HashMap<>();
        expenseTypeRepository = BeanUtil.getBean(ExpenseTypeJpaRepository.class);
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseTypeRepository(ExpenseTypeJpaRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    protected void setExpenseReportRepository(ExpenseReportJpaRepository expenseReportRepository) {
        this.expenseReportRepository = expenseReportRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ExpenseLine.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ExpenseLineConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ExpenseLineConstants.ROLE_NAME_EXPENSETYPE)){
            returnedType = new ExpenseType().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT)){
            returnedType = new ExpenseReport().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedExpenseLineExpenseDate = false;
    	values.put("expenseLineExpenseDate", getExpenseLineExpenseDate());
    	modifiedExpenseLineUnits = false;
    	values.put("expenseLineUnits", getExpenseLineUnits());
    	modifiedExpenseLinePrice = false;
    	values.put("expenseLinePrice", getExpenseLinePrice());
    	modifiedExpenseLineLnDescription = false;
    	values.put("expenseLineLnDescription", getExpenseLineLnDescription());
    	modifiedExpenseType = false;
    	modifiedExpenseReport = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            expenseLineTotalLine = null;
            expenseLineTotalLineCurr = null;
    }

    /**
     * Returns the <code>ExpenseLineOid</code> object that identifies this instance of <code>ExpenseLine</code>.
     * @return <code>ExpenseLineOid </code> object that identifies this instance of <code>ExpenseLine</code>
     */
    public ExpenseLineOid getOid() {
        return new ExpenseLineOid(getExpenseReportidExpenseRepor(), getExpenseLineidExpenseLine());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ExpenseLineConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ExpenseLineConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EXPENSELINE)) {
            // Add this class
            activeFacets.add(Constants.EXPENSELINE);
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

    public String buildDSExpenseLine() {
        try {
            return (getExpenseLineidExpenseLine() != null ? getExpenseLineidExpenseLine().toString() : "") + " " + (getExpenseLineExpenseDate() != null ? getExpenseLineExpenseDate().toString() : "") + " " + getExpenseLineLnDescription() + " " + (getExpenseLinePrice() != null ? getExpenseLinePrice().toString() : "") + " " + (getExpenseLineUnits() != null ? getExpenseLineUnits().toString() : "") + " " + (getExpenseLineTotalLine() != null ? getExpenseLineTotalLine().toString() : "") + " " + (getExpenseLineTotalLineCurr() != null ? getExpenseLineTotalLineCurr().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSExpenseLineSup() {
        try {
            return (getExpenseLineExpenseDate() != null ? getExpenseLineExpenseDate().toString() : "") + " " + (getExpenseLineTotalLine() != null ? getExpenseLineTotalLine().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }
}
