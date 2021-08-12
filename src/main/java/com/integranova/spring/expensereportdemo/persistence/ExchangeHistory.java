package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
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
 * Persistent representation of the <code>ExchangeHistory</code> model class.
 * <p>
 * Model Class: <code>ExchangeHistory</code><br>
 */
@Entity(name = ExchangeHistoryConstants.CLASS_NAME)
@Table(name = ExchangeHistoryConstants.TBL_NAME)
@IdClass(ExchangeHistoryOid.class)
public class ExchangeHistory extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ExpenseCurrencyJpaRepository expenseCurrencyRepository;

    /** Class identification function. */
    @Id
    @Column(name = ExchangeHistoryConstants.FLD_EXPENSECURRENCYCURRENCYCODE, insertable = false, updatable = false )
    @Size(max = 5)
    @JsonProperty(value="currencycode")
    private String expenseCurrencyCurrencyCode;

    /** Class identification function. */
    @Id
    @Column(name = ExchangeHistoryConstants.FLD_EXCHANGEHISTORYENTRYDATE )
    @JsonProperty(value="entrydate")
    private Date exchangeHistoryentryDate;

    /** Class member attribute. */
    @Column(name = ExchangeHistoryConstants.FLD_EXCHANGEHISTORYOLDVALUE )
    @JsonProperty(value="oldvalue")
    private Double exchangeHistoryoldValue;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExchangeHistoryoldValue;

    /** Class member attribute. */
    @Column(name = ExchangeHistoryConstants.FLD_EXCHANGEHISTORYNEWVALUE )
    @JsonProperty(value="newvalue")
    private Double exchangeHistorynewValue;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExchangeHistorynewValue;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExchangeHistoryConstants.FLD_EXPENSECURRENCYCURRENCYCODE, referencedColumnName=ExpenseCurrencyConstants.FLD_EXPENSECURRENCYCURRENCYCODE, insertable = false, updatable = false)
    })
    @JsonIgnore
    private ExpenseCurrency expenseCurrency;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseCurrency;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ExchangeHistory() {
        expenseCurrencyCurrencyCode = null;
        exchangeHistoryentryDate = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ExchangeHistory</code>.
     * @param oid Object Identifier of the instance of <code>ExchangeHistory</code> to be created.
     * @throws SystemException
     */
    public ExchangeHistory(ExchangeHistoryOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            expenseCurrencyCurrencyCode = oid.getExpenseCurrencyCurrencyCode();
            exchangeHistoryentryDate = oid.getExchangeHistoryentryDate();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code> through <code>ExpenseCurrency</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseCurrency</code>
     * @return The value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code> through <code>ExpenseCurrency</code>.
     */
    public String getExpenseCurrencyCurrencyCode() {
        return (expenseCurrency != null ? expenseCurrency.getExpenseCurrencyCurrencyCode() : expenseCurrencyCurrencyCode);
    }

    /**
     * Sets the value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code> through <code>ExpenseCurrency</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseCurrency</code>
     * @param expenseCurrencyCurrencyCode The new value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code> through <code>ExpenseCurrency</code>.
     */
    public void setExpenseCurrencyCurrencyCode(String expenseCurrencyCurrencyCode) {
        this.expenseCurrencyCurrencyCode = expenseCurrencyCurrencyCode;
    }


    /**
     * Returns the value of the <code>exchangeHistoryentryDate</code> attribute<br>in class <code>ExchangeHistory</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExchangeHistory</code>
     * @return The value of the <code>exchangeHistoryentryDate</code> attribute<br>in class <code>ExchangeHistory</code>.
     */
    public Date getExchangeHistoryentryDate() {
        return exchangeHistoryentryDate;
    }

    /**
     * Sets the value of the <code>exchangeHistoryentryDate</code> attribute<br>in class <code>ExchangeHistory</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExchangeHistory</code>
     * @param exchangeHistoryentryDate The new value of the <code>exchangeHistoryentryDate</code> attribute<br>in class <code>ExchangeHistory</code>.
     */
    public void setExchangeHistoryentryDate(Date exchangeHistoryentryDate) {
        this.exchangeHistoryentryDate = exchangeHistoryentryDate;
    }

   /**
    * Returns the value of the <code>exchangeHistoryoldValue</code> attribute.<br>
    * Model Attribute: <code>exchangeHistoryoldValue</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>exchangeHistoryoldValue</code> attribute.
    */

    public Double getExchangeHistoryoldValue()  {
    	Double value;
        value =  exchangeHistoryoldValue;
        return value;
    }

   /**
    * Sets the value of the <code>exchangeHistoryoldValue</code> attribute.<br>
    * Model Attribute: <code>exchangeHistoryoldValue</code>. Variable Real<br>
    * Comments: <br>
    * @param exchangeHistoryoldValue The new value of the <code>exchangeHistoryoldValue</code> attribute.
    */
    public void setExchangeHistoryoldValue (Double exchangeHistoryoldValue) {
        modifiedExchangeHistoryoldValue = true;
        this.exchangeHistoryoldValue = exchangeHistoryoldValue;
    }

   /**
    * Returns the value of the <code>modifiedExchangeHistoryoldValue</code> class property.<br>
    *
    * @return The value of the <code>modifiedExchangeHistoryoldValue</code> class property.
    */
    public boolean isModifiedExchangeHistoryoldValue() {
        return modifiedExchangeHistoryoldValue;
    }

   /**
    * Sets the value of the <code>modifiedExchangeHistoryoldValue</code> class property.<br>
    * @param modified The new value of the <code>modifiedExchangeHistoryoldValue</code>.
    */
    public void setModifiedExchangeHistoryoldValue(boolean modified) {
        this.modifiedExchangeHistoryoldValue = modified;
    }

   /**
    * Returns the value of the <code>exchangeHistorynewValue</code> attribute.<br>
    * Model Attribute: <code>exchangeHistorynewValue</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>exchangeHistorynewValue</code> attribute.
    */

    public Double getExchangeHistorynewValue()  {
    	Double value;
        value =  exchangeHistorynewValue;
        return value;
    }

   /**
    * Sets the value of the <code>exchangeHistorynewValue</code> attribute.<br>
    * Model Attribute: <code>exchangeHistorynewValue</code>. Variable Real<br>
    * Comments: <br>
    * @param exchangeHistorynewValue The new value of the <code>exchangeHistorynewValue</code> attribute.
    */
    public void setExchangeHistorynewValue (Double exchangeHistorynewValue) {
        modifiedExchangeHistorynewValue = true;
        this.exchangeHistorynewValue = exchangeHistorynewValue;
    }

   /**
    * Returns the value of the <code>modifiedExchangeHistorynewValue</code> class property.<br>
    *
    * @return The value of the <code>modifiedExchangeHistorynewValue</code> class property.
    */
    public boolean isModifiedExchangeHistorynewValue() {
        return modifiedExchangeHistorynewValue;
    }

   /**
    * Sets the value of the <code>modifiedExchangeHistorynewValue</code> class property.<br>
    * @param modified The new value of the <code>modifiedExchangeHistorynewValue</code>.
    */
    public void setModifiedExchangeHistorynewValue(boolean modified) {
        this.modifiedExchangeHistorynewValue = modified;
    }

    /**
     * Returns the instance of <code>ExpenseCurrency</code> related through the <code>ExpenseCurrency</code> role.
     * Model Relationship:
     * <code>[ExpenseCurrency] ExpenseCurrency 1:1  ------ 0:M  ExchangeHistoryItems [ExchangeHistory]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseCurrency</code> related through the <code>ExpenseCurrency</code> role.
     */
    public ExpenseCurrency getExpenseCurrency() {
        if (expenseCurrency == null) {
            if (expenseCurrencyCurrencyCode != null) {
                expenseCurrency = expenseCurrencyRepository.findById(expenseCurrencyCurrencyCode).orElse(null);
            } else {
                expenseCurrency = null;
            }
        }
        return (expenseCurrency == null ? new ExpenseCurrency(null) : expenseCurrency);
    }


   /**
    * Adds an instance of <code>ExpenseCurrency</code> related through the <code>ExpenseCurrency</code> role.
    * @param expenseCurrency The instance to add to the <code>ExpenseCurrency</code> role.
    */
    public void add2ExpenseCurrency(ExpenseCurrency expenseCurrency) {
        if (expenseCurrency == null || expenseCurrency.isNull()) {
            this.modifiedExpenseCurrency = true;
            this.expenseCurrencyCurrencyCode = null;
        } else {
            this.expenseCurrencyCurrencyCode = expenseCurrency.getExpenseCurrencyCurrencyCode();
        }
        this.expenseCurrency = (expenseCurrency == null  || expenseCurrency.isNull() ? null : expenseCurrency);
    }

   /**
    * This method gets the attribute value <code>modifiedExpenseCurrency</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExpenseCurrency</code> has been modified.
    */
    public boolean isModifiedExpenseCurrency(){
        return modifiedExpenseCurrency;
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
        exchangeHistoryoldValue = Double.valueOf(0);
        exchangeHistorynewValue = Double.valueOf(0);
        expenseCurrency = null;
        values = new HashMap<>();
        expenseCurrencyRepository = BeanUtil.getBean(ExpenseCurrencyJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseCurrencyRepository(ExpenseCurrencyJpaRepository expenseCurrencyRepository) {
        this.expenseCurrencyRepository = expenseCurrencyRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ExchangeHistory.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ExchangeHistoryConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY)){
            returnedType = new ExpenseCurrency().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedExchangeHistoryoldValue = false;
    	values.put("exchangeHistoryoldValue", getExchangeHistoryoldValue());
    	modifiedExchangeHistorynewValue = false;
    	values.put("exchangeHistorynewValue", getExchangeHistorynewValue());
    	modifiedExpenseCurrency = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>ExchangeHistoryOid</code> object that identifies this instance of <code>ExchangeHistory</code>.
     * @return <code>ExchangeHistoryOid </code> object that identifies this instance of <code>ExchangeHistory</code>
     */
    public ExchangeHistoryOid getOid() {
        return new ExchangeHistoryOid(getExpenseCurrencyCurrencyCode(), getExchangeHistoryentryDate());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ExchangeHistoryConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ExchangeHistoryConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EXCHANGEHISTORY)) {
            // Add this class
            activeFacets.add(Constants.EXCHANGEHISTORY);
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
}
