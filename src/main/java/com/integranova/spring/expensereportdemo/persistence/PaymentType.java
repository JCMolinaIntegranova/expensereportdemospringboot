package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
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
 * Persistent representation of the <code>PaymentType</code> model class.
 * <p>
 * Model Class: <code>PaymentType</code><br>
 */
@Entity(name = PaymentTypeConstants.CLASS_NAME)
@Table(name = PaymentTypeConstants.TBL_NAME)
public class PaymentType extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    /** Class identification function. */
    @Id
    @Column(name = PaymentTypeConstants.FLD_PAYMENTTYPEIDPAYMENTTYPE )
    @Size(max = 5)
    @JsonProperty(value="id_paymenttype")
    private String paymentTypeidPaymentType;

    /** Class member attribute. */
    @Column(name = PaymentTypeConstants.FLD_PAYMENTTYPEPAYDESCRIPTION )
    @Size(max = 50)
    @JsonProperty(value="paydescription")
    private String paymentTypePayDescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPaymentTypePayDescription;

    /** Related Class. */
    @OneToMany(mappedBy = PaymentTypeConstants.ROLE_INVNAME_EXPENSEREPORT)
    @JsonIgnore
    private Collection <ExpenseReport> expenseReport;
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
    public PaymentType() {
        paymentTypeidPaymentType = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>PaymentType</code>.
     * @param oid Object Identifier of the instance of <code>PaymentType</code> to be created.
     * @throws SystemException
     */
    public PaymentType(PaymentTypeOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            paymentTypeidPaymentType = oid.getPaymentTypeidPaymentType();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>paymentTypeidPaymentType</code> attribute<br>in class <code>PaymentType</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PaymentType</code>
     * @return The value of the <code>paymentTypeidPaymentType</code> attribute<br>in class <code>PaymentType</code>.
     */
    public String getPaymentTypeidPaymentType() {
        return (paymentTypeidPaymentType == null ? paymentTypeidPaymentType : paymentTypeidPaymentType.trim());
    }

    /**
     * Sets the value of the <code>paymentTypeidPaymentType</code> attribute<br>in class <code>PaymentType</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PaymentType</code>
     * @param paymentTypeidPaymentType The new value of the <code>paymentTypeidPaymentType</code> attribute<br>in class <code>PaymentType</code>.
     */
    public void setPaymentTypeidPaymentType(String paymentTypeidPaymentType) {
        this.paymentTypeidPaymentType = paymentTypeidPaymentType;
    }

   /**
    * Returns the value of the <code>paymentTypePayDescription</code> attribute.<br>
    * Model Attribute: <code>paymentTypePayDescription</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>paymentTypePayDescription</code> attribute.
    */

    public String getPaymentTypePayDescription()  {
    	String value;
        value =  paymentTypePayDescription;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>paymentTypePayDescription</code> attribute.<br>
    * Model Attribute: <code>paymentTypePayDescription</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param paymentTypePayDescription The new value of the <code>paymentTypePayDescription</code> attribute.
    */
    public void setPaymentTypePayDescription (String paymentTypePayDescription) {
        modifiedPaymentTypePayDescription = true;
        this.paymentTypePayDescription = paymentTypePayDescription;
    }

   /**
    * Returns the value of the <code>modifiedPaymentTypePayDescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedPaymentTypePayDescription</code> class property.
    */
    public boolean isModifiedPaymentTypePayDescription() {
        return modifiedPaymentTypePayDescription;
    }

   /**
    * Sets the value of the <code>modifiedPaymentTypePayDescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedPaymentTypePayDescription</code>.
    */
    public void setModifiedPaymentTypePayDescription(boolean modified) {
        this.modifiedPaymentTypePayDescription = modified;
    }

    /**
     * Returns the instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     * Model Relationship:
     * <code>[ExpenseReport] ExpenseReport 0:M  ------ 0:1  PaymentType [PaymentType]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     */
    public Collection <ExpenseReport> getExpenseReport() {
        if (expenseReport == null || expenseReport.isEmpty()) {
            expenseReport = expenseReportRepository.findByPaymentType(this);
        }
        return expenseReport;
    }


   /**
    * Adds an instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
    * @param expenseReport The instance to add to the <code>ExpenseReport</code> role.
    */
    public void add2ExpenseReport(ExpenseReport expenseReport) {
        this.getExpenseReport().add(expenseReport);
    }
    /**
     * Sets instances of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     * @param expenseReport The new value for the <code>ExpenseReport</code> role.
     */
    public void setExpenseReport(Collection < ExpenseReport > expenseReport) {
        this.expenseReport = expenseReport;
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
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        paymentTypePayDescription = "";
        expenseReport = new ArrayList<>();
        values = new HashMap<>();
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseReportRepository(ExpenseReportJpaRepository expenseReportRepository) {
        this.expenseReportRepository = expenseReportRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return PaymentType.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return PaymentTypeConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT)){
            returnedType = new ExpenseReport().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedPaymentTypePayDescription = false;
    	values.put("paymentTypePayDescription", getPaymentTypePayDescription());
    	modifiedExpenseReport = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>PaymentTypeOid</code> object that identifies this instance of <code>PaymentType</code>.
     * @return <code>PaymentTypeOid </code> object that identifies this instance of <code>PaymentType</code>
     */
    public PaymentTypeOid getOid() {
        return new PaymentTypeOid(getPaymentTypeidPaymentType());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(PaymentTypeConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PAYMENTTYPE)) {
            // Add this class
            activeFacets.add(Constants.PAYMENTTYPE);
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

    public String buildDSPaymentType() {
        try {
            return getPaymentTypeidPaymentType() + " " + getPaymentTypePayDescription();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSPaymentTypeSup() {
        try {
            return getPaymentTypePayDescription();
        } catch(Exception e) {
            return "";
        }
    }
}
