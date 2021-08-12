package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.repository.ExchangeHistoryJpaRepository;
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
 * Persistent representation of the <code>ExpenseCurrency</code> model class.
 * <p>
 * Model Class: <code>ExpenseCurrency</code><br>
 */
@Entity(name = ExpenseCurrencyConstants.CLASS_NAME)
@Table(name = ExpenseCurrencyConstants.TBL_NAME)
public class ExpenseCurrency extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    @JsonIgnore
    private transient ExchangeHistoryJpaRepository exchangeHistoryRepository;

    /** Class identification function. */
    @Id
    @Column(name = ExpenseCurrencyConstants.FLD_EXPENSECURRENCYCURRENCYCODE )
    @Size(max = 5)
    @JsonProperty(value="currencycode")
    private String expenseCurrencyCurrencyCode;

    /** Class member attribute. */
    @Column(name = ExpenseCurrencyConstants.FLD_EXPENSECURRENCYCURRENCYNAME )
    @Size(max = 25)
    @JsonProperty(value="currencyname")
    private String expenseCurrencyCurrencyName;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseCurrencyCurrencyName;

    /** Class member attribute. */
    @Column(name = ExpenseCurrencyConstants.FLD_EXPENSECURRENCYCURACRONYM )
    @Size(max = 5)
    @JsonProperty(value="curacronym")
    private String expenseCurrencyCurAcronym;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseCurrencyCurAcronym;

    /** Class member attribute. */
    @Column(name = ExpenseCurrencyConstants.FLD_EXPENSECURRENCYEXCHANGE )
    @JsonProperty(value="exchange")
    private Double expenseCurrencyExchange;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseCurrencyExchange;

    /** Related Class. */
    @OneToMany(mappedBy = ExpenseCurrencyConstants.ROLE_INVNAME_EXPENSEREPORTS)
    @JsonIgnore
    private Collection <ExpenseReport> expenseReports;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReports;

    /** Related Class. */
    @OneToMany(mappedBy = ExpenseCurrencyConstants.ROLE_INVNAME_EXCHANGEHISTORYITEMS)
    @JsonIgnore
    private Collection <ExchangeHistory> exchangeHistoryItems;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExchangeHistoryItems;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ExpenseCurrency() {
        expenseCurrencyCurrencyCode = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ExpenseCurrency</code>.
     * @param oid Object Identifier of the instance of <code>ExpenseCurrency</code> to be created.
     * @throws SystemException
     */
    public ExpenseCurrency(ExpenseCurrencyOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            expenseCurrencyCurrencyCode = oid.getExpenseCurrencyCurrencyCode();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseCurrency</code>
     * @return The value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code>.
     */
    public String getExpenseCurrencyCurrencyCode() {
        return (expenseCurrencyCurrencyCode == null ? expenseCurrencyCurrencyCode : expenseCurrencyCurrencyCode.trim());
    }

    /**
     * Sets the value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseCurrency</code>
     * @param expenseCurrencyCurrencyCode The new value of the <code>expenseCurrencyCurrencyCode</code> attribute<br>in class <code>ExpenseCurrency</code>.
     */
    public void setExpenseCurrencyCurrencyCode(String expenseCurrencyCurrencyCode) {
        this.expenseCurrencyCurrencyCode = expenseCurrencyCurrencyCode;
    }

   /**
    * Returns the value of the <code>expenseCurrencyCurrencyName</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyCurrencyName</code>. Variable String Size=25<br>
    * Comments: <br>
    * @return The value of the <code>expenseCurrencyCurrencyName</code> attribute.
    */

    public String getExpenseCurrencyCurrencyName()  {
    	String value;
        value =  expenseCurrencyCurrencyName;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseCurrencyCurrencyName</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyCurrencyName</code>. Variable String Size=25<br>
    * Comments: <br>
    * @param expenseCurrencyCurrencyName The new value of the <code>expenseCurrencyCurrencyName</code> attribute.
    */
    public void setExpenseCurrencyCurrencyName (String expenseCurrencyCurrencyName) {
        modifiedExpenseCurrencyCurrencyName = true;
        this.expenseCurrencyCurrencyName = expenseCurrencyCurrencyName;
    }

   /**
    * Returns the value of the <code>modifiedExpenseCurrencyCurrencyName</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseCurrencyCurrencyName</code> class property.
    */
    public boolean isModifiedExpenseCurrencyCurrencyName() {
        return modifiedExpenseCurrencyCurrencyName;
    }

   /**
    * Sets the value of the <code>modifiedExpenseCurrencyCurrencyName</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseCurrencyCurrencyName</code>.
    */
    public void setModifiedExpenseCurrencyCurrencyName(boolean modified) {
        this.modifiedExpenseCurrencyCurrencyName = modified;
    }

   /**
    * Returns the value of the <code>expenseCurrencyCurAcronym</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyCurAcronym</code>. Variable String Size=5<br>
    * Comments: <br>
    * @return The value of the <code>expenseCurrencyCurAcronym</code> attribute.
    */

    public String getExpenseCurrencyCurAcronym()  {
    	String value;
        value =  expenseCurrencyCurAcronym;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseCurrencyCurAcronym</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyCurAcronym</code>. Variable String Size=5<br>
    * Comments: <br>
    * @param expenseCurrencyCurAcronym The new value of the <code>expenseCurrencyCurAcronym</code> attribute.
    */
    public void setExpenseCurrencyCurAcronym (String expenseCurrencyCurAcronym) {
        modifiedExpenseCurrencyCurAcronym = true;
        this.expenseCurrencyCurAcronym = expenseCurrencyCurAcronym;
    }

   /**
    * Returns the value of the <code>modifiedExpenseCurrencyCurAcronym</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseCurrencyCurAcronym</code> class property.
    */
    public boolean isModifiedExpenseCurrencyCurAcronym() {
        return modifiedExpenseCurrencyCurAcronym;
    }

   /**
    * Sets the value of the <code>modifiedExpenseCurrencyCurAcronym</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseCurrencyCurAcronym</code>.
    */
    public void setModifiedExpenseCurrencyCurAcronym(boolean modified) {
        this.modifiedExpenseCurrencyCurAcronym = modified;
    }

   /**
    * Returns the value of the <code>expenseCurrencyExchange</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyExchange</code>. Variable Real<br>
    * Comments: Exchange relative to pattern currency<br>
    * @return The value of the <code>expenseCurrencyExchange</code> attribute.
    */

    public Double getExpenseCurrencyExchange()  {
    	Double value;
        value =  expenseCurrencyExchange;
        return value;
    }

   /**
    * Sets the value of the <code>expenseCurrencyExchange</code> attribute.<br>
    * Model Attribute: <code>expenseCurrencyExchange</code>. Variable Real<br>
    * Comments: Exchange relative to pattern currency<br>
    * @param expenseCurrencyExchange The new value of the <code>expenseCurrencyExchange</code> attribute.
    */
    public void setExpenseCurrencyExchange (Double expenseCurrencyExchange) {
        modifiedExpenseCurrencyExchange = true;
        this.expenseCurrencyExchange = expenseCurrencyExchange;
    }

   /**
    * Returns the value of the <code>modifiedExpenseCurrencyExchange</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseCurrencyExchange</code> class property.
    */
    public boolean isModifiedExpenseCurrencyExchange() {
        return modifiedExpenseCurrencyExchange;
    }

   /**
    * Sets the value of the <code>modifiedExpenseCurrencyExchange</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseCurrencyExchange</code>.
    */
    public void setModifiedExpenseCurrencyExchange(boolean modified) {
        this.modifiedExpenseCurrencyExchange = modified;
    }

    /**
     * Returns the instance of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
     * Model Relationship:
     * <code>[ExpenseReport] ExpenseReports 0:M  ------ 1:1  ExpenseCurrency [ExpenseCurrency]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
     */
    public Collection <ExpenseReport> getExpenseReports() {
        if (expenseReports == null || expenseReports.isEmpty()) {
            expenseReports = expenseReportRepository.findByExpenseCurrency(this);
        }
        return expenseReports;
    }


   /**
    * Adds an instance of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
    * @param expenseReports The instance to add to the <code>ExpenseReports</code> role.
    */
    public void add2ExpenseReports(ExpenseReport expenseReports) {
        this.getExpenseReports().add(expenseReports);
    }
    /**
     * Sets instances of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
     * @param expenseReports The new value for the <code>ExpenseReports</code> role.
     */
    public void setExpenseReports(Collection < ExpenseReport > expenseReports) {
        this.expenseReports = expenseReports;
    }

   /**
    * This method gets the attribute value <code>modifiedExpenseReports</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExpenseReports</code> has been modified.
    */
    public boolean isModifiedExpenseReports(){
        return modifiedExpenseReports;
    }

    /**
     * Returns the instance of <code>ExchangeHistory</code> related through the <code>ExchangeHistoryItems</code> role.
     * Model Relationship:
     * <code>[ExchangeHistory] ExchangeHistoryItems 0:M  ------ 1:1  ExpenseCurrency [ExpenseCurrency]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExchangeHistory</code> related through the <code>ExchangeHistoryItems</code> role.
     */
    public Collection <ExchangeHistory> getExchangeHistoryItems() {
        if (exchangeHistoryItems == null || exchangeHistoryItems.isEmpty()) {
            exchangeHistoryItems = exchangeHistoryRepository.findByExpenseCurrency(this);
        }
        return exchangeHistoryItems;
    }


   /**
    * Adds an instance of <code>ExchangeHistory</code> related through the <code>ExchangeHistoryItems</code> role.
    * @param exchangeHistoryItems The instance to add to the <code>ExchangeHistoryItems</code> role.
    */
    public void add2ExchangeHistoryItems(ExchangeHistory exchangeHistoryItems) {
        this.getExchangeHistoryItems().add(exchangeHistoryItems);
    }
    /**
     * Sets instances of <code>ExchangeHistory</code> related through the <code>ExchangeHistoryItems</code> role.
     * @param exchangeHistoryItems The new value for the <code>ExchangeHistoryItems</code> role.
     */
    public void setExchangeHistoryItems(Collection < ExchangeHistory > exchangeHistoryItems) {
        this.exchangeHistoryItems = exchangeHistoryItems;
    }

   /**
    * This method gets the attribute value <code>modifiedExchangeHistoryItems</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedExchangeHistoryItems</code> has been modified.
    */
    public boolean isModifiedExchangeHistoryItems(){
        return modifiedExchangeHistoryItems;
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
        expenseCurrencyCurrencyName = "";
        expenseCurrencyCurAcronym = "";
        expenseCurrencyExchange = Double.valueOf(0);
        expenseReports = new ArrayList<>();
        exchangeHistoryItems = new ArrayList<>();
        values = new HashMap<>();
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);
        exchangeHistoryRepository = BeanUtil.getBean(ExchangeHistoryJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseReportRepository(ExpenseReportJpaRepository expenseReportRepository) {
        this.expenseReportRepository = expenseReportRepository;
    }

    protected void setExchangeHistoryRepository(ExchangeHistoryJpaRepository exchangeHistoryRepository) {
        this.exchangeHistoryRepository = exchangeHistoryRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ExpenseCurrency.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ExpenseCurrencyConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS)){
            returnedType = new ExpenseReport().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS)){
            returnedType = new ExchangeHistory().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedExpenseCurrencyCurrencyName = false;
    	values.put("expenseCurrencyCurrencyName", getExpenseCurrencyCurrencyName());
    	modifiedExpenseCurrencyCurAcronym = false;
    	values.put("expenseCurrencyCurAcronym", getExpenseCurrencyCurAcronym());
    	modifiedExpenseCurrencyExchange = false;
    	values.put("expenseCurrencyExchange", getExpenseCurrencyExchange());
    	modifiedExpenseReports = false;
    	modifiedExchangeHistoryItems = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>ExpenseCurrencyOid</code> object that identifies this instance of <code>ExpenseCurrency</code>.
     * @return <code>ExpenseCurrencyOid </code> object that identifies this instance of <code>ExpenseCurrency</code>
     */
    public ExpenseCurrencyOid getOid() {
        return new ExpenseCurrencyOid(getExpenseCurrencyCurrencyCode());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ExpenseCurrencyConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EXPENSECURRENCY)) {
            // Add this class
            activeFacets.add(Constants.EXPENSECURRENCY);
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

    public String buildDSExpenseCurrency() {
        try {
            return getExpenseCurrencyCurrencyCode() + " " + getExpenseCurrencyCurAcronym() + " " + getExpenseCurrencyCurrencyName() + " " + (getExpenseCurrencyExchange() != null ? getExpenseCurrencyExchange().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSExpenseCurrencySup() {
        try {
            return getExpenseCurrencyCurAcronym();
        } catch(Exception e) {
            return "";
        }
    }
}
