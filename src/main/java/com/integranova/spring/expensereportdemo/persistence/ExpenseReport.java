package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.PaymentTypeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.service.BeanUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>ExpenseReport</code> model class.
 * <p>
 * Model Class: <code>ExpenseReport</code><br>
 */
@Entity(name = ExpenseReportConstants.CLASS_NAME)
@Table(name = ExpenseReportConstants.TBL_NAME)
public class ExpenseReport extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    @JsonIgnore
    private transient ExpenseLineJpaRepository expenseLineRepository;

    @JsonIgnore
    private transient EmployeeJpaRepository employeeRepository;

    @JsonIgnore
    private transient ExpenseCurrencyJpaRepository expenseCurrencyRepository;

    @JsonIgnore
    private transient PaymentTypeJpaRepository paymentTypeRepository;

    @JsonIgnore
    private transient ProjectJpaRepository projectRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTIDEXPENSEREPOR )
    @JsonProperty(value="id_expenserepor")
    private Long expenseReportidExpenseRepor;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTPRESENTDATE )
    @JsonProperty(value="presentdate")
    private Date expenseReportPresentDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportPresentDate;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTSTATUS )
    @JsonProperty(value="status")
    private Long expenseReportStatus;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportStatus;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTCAUSE )
    @Size(max = 255)
    @JsonProperty(value="cause")
    private String expenseReportCause;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportCause;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTAUTHODATE )
    @JsonProperty(value="authodate")
    private Date expenseReportAuthoDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportAuthoDate;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTAUTHOCOMMENTS )
    @Size(max = 255)
    @JsonProperty(value="authocomments")
    private String expenseReportAuthoComments;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportAuthoComments;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTPAYMENTDATE )
    @JsonProperty(value="paymentdate")
    private Date expenseReportPaymentDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportPaymentDate;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTPAYCOMMENTS )
    @Size(max = 255)
    @JsonProperty(value="paycomments")
    private String expenseReportPayComments;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportPayComments;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totexpenses")
    protected Double expenseReportTotExpenses;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totexpensescur")
    protected Double expenseReportTotExpensesCur;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTADVANCES )
    @JsonProperty(value="advances")
    private Double expenseReportAdvances;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportAdvances;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="advancescur")
    protected Double expenseReportAdvancesCur;

    /** Class member attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSEREPORTEXCHANGE )
    @JsonProperty(value="exchange")
    private Double expenseReportExchange;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReportExchange;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="balance")
    protected Double expenseReportBalance;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="balancecur")
    protected Double expenseReportBalanceCur;

    /** Related Class. */
    @OneToMany(mappedBy = ExpenseReportConstants.ROLE_INVNAME_EXPENSELINES)
    @JsonIgnore
    private Collection <ExpenseLine> expenseLines;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseLines;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseReportConstants.FLD_EMPLOYEEIDEMPLOYEE, referencedColumnName=EmployeeConstants.FLD_EMPLOYEEIDEMPLOYEE)
    })
    @JsonIgnore
    private Employee employee;
    /** Related attribute. */
    @Column(name = ExpenseReportConstants.FLD_EMPLOYEEIDEMPLOYEE, insertable = false, updatable = false)
    private String employeeidEmployee;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployee;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseReportConstants.FLD_EXPENSECURRENCYCURRENCYCODE, referencedColumnName=ExpenseCurrencyConstants.FLD_EXPENSECURRENCYCURRENCYCODE)
    })
    @JsonIgnore
    private ExpenseCurrency expenseCurrency;
    /** Related attribute. */
    @Column(name = ExpenseReportConstants.FLD_EXPENSECURRENCYCURRENCYCODE, insertable = false, updatable = false)
    private String expenseCurrencyCurrencyCode;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseCurrency;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseReportConstants.FLD_PAYMENTTYPEIDPAYMENTTYPE, referencedColumnName=PaymentTypeConstants.FLD_PAYMENTTYPEIDPAYMENTTYPE)
    })
    @JsonIgnore
    private PaymentType paymentType;
    /** Related attribute. */
    @Column(name = ExpenseReportConstants.FLD_PAYMENTTYPEIDPAYMENTTYPE, insertable = false, updatable = false)
    private String paymentTypeidPaymentType;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPaymentType;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ExpenseReportConstants.FLD_PROJECTIDPROJECT, referencedColumnName=ProjectConstants.FLD_PROJECTIDPROJECT)
    })
    @JsonIgnore
    private Project project;
    /** Related attribute. */
    @Column(name = ExpenseReportConstants.FLD_PROJECTIDPROJECT, insertable = false, updatable = false)
    private Long projectidProject;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProject;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ExpenseReport() {
        expenseReportidExpenseRepor = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ExpenseReport</code>.
     * @param oid Object Identifier of the instance of <code>ExpenseReport</code> to be created.
     * @throws SystemException
     */
    public ExpenseReport(ExpenseReportOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            expenseReportidExpenseRepor = oid.getExpenseReportidExpenseRepor();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseReport</code>
     * @return The value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code>.
     */
    public Long getExpenseReportidExpenseRepor() {
        return expenseReportidExpenseRepor;
    }

    /**
     * Sets the value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ExpenseReport</code>
     * @param expenseReportidExpenseRepor The new value of the <code>expenseReportidExpenseRepor</code> attribute<br>in class <code>ExpenseReport</code>.
     */
    public void setExpenseReportidExpenseRepor(Long expenseReportidExpenseRepor) {
        this.expenseReportidExpenseRepor = expenseReportidExpenseRepor;
    }

   /**
    * Returns the value of the <code>expenseReportPresentDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportPresentDate</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportPresentDate</code> attribute.
    */

    public Date getExpenseReportPresentDate()  {
    	Date value;
        value =  expenseReportPresentDate;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportPresentDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportPresentDate</code>. Constant Date<br>
    * Comments: <br>
    * @param expenseReportPresentDate The new value of the <code>expenseReportPresentDate</code> attribute.
    */
    public void setExpenseReportPresentDate (Date expenseReportPresentDate) {
        modifiedExpenseReportPresentDate = true;
        this.expenseReportPresentDate = expenseReportPresentDate;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportPresentDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportPresentDate</code> class property.
    */
    public boolean isModifiedExpenseReportPresentDate() {
        return modifiedExpenseReportPresentDate;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportPresentDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportPresentDate</code>.
    */
    public void setModifiedExpenseReportPresentDate(boolean modified) {
        this.modifiedExpenseReportPresentDate = modified;
    }

   /**
    * Returns the value of the <code>expenseReportStatus</code> attribute.<br>
    * Model Attribute: <code>expenseReportStatus</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportStatus</code> attribute.
    */

    public Long getExpenseReportStatus()  {
    	Long value;
        value =  expenseReportStatus;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportStatus</code> attribute.<br>
    * Model Attribute: <code>expenseReportStatus</code>. Variable Int<br>
    * Comments: <br>
    * @param expenseReportStatus The new value of the <code>expenseReportStatus</code> attribute.
    */
    public void setExpenseReportStatus (Long expenseReportStatus) {
        modifiedExpenseReportStatus = true;
        this.expenseReportStatus = expenseReportStatus;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportStatus</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportStatus</code> class property.
    */
    public boolean isModifiedExpenseReportStatus() {
        return modifiedExpenseReportStatus;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportStatus</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportStatus</code>.
    */
    public void setModifiedExpenseReportStatus(boolean modified) {
        this.modifiedExpenseReportStatus = modified;
    }

   /**
    * Returns the value of the <code>expenseReportCause</code> attribute.<br>
    * Model Attribute: <code>expenseReportCause</code>. Variable String Size=255<br>
    * Comments: Req: Header and footer: General information of the Expense.
             - Trip cause, visit to or general expense cause.<br>
    * @return The value of the <code>expenseReportCause</code> attribute.
    */

    public String getExpenseReportCause()  {
    	String value;
        value =  expenseReportCause;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseReportCause</code> attribute.<br>
    * Model Attribute: <code>expenseReportCause</code>. Variable String Size=255<br>
    * Comments: Req: Header and footer: General information of the Expense.
             - Trip cause, visit to or general expense cause.<br>
    * @param expenseReportCause The new value of the <code>expenseReportCause</code> attribute.
    */
    public void setExpenseReportCause (String expenseReportCause) {
        modifiedExpenseReportCause = true;
        this.expenseReportCause = expenseReportCause;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportCause</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportCause</code> class property.
    */
    public boolean isModifiedExpenseReportCause() {
        return modifiedExpenseReportCause;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportCause</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportCause</code>.
    */
    public void setModifiedExpenseReportCause(boolean modified) {
        this.modifiedExpenseReportCause = modified;
    }

   /**
    * Returns the value of the <code>expenseReportAuthoDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportAuthoDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportAuthoDate</code> attribute.
    */

    public Date getExpenseReportAuthoDate()  {
    	Date value;
        value =  expenseReportAuthoDate;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportAuthoDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportAuthoDate</code>. Variable Date<br>
    * Comments: <br>
    * @param expenseReportAuthoDate The new value of the <code>expenseReportAuthoDate</code> attribute.
    */
    public void setExpenseReportAuthoDate (Date expenseReportAuthoDate) {
        modifiedExpenseReportAuthoDate = true;
        this.expenseReportAuthoDate = expenseReportAuthoDate;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportAuthoDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportAuthoDate</code> class property.
    */
    public boolean isModifiedExpenseReportAuthoDate() {
        return modifiedExpenseReportAuthoDate;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportAuthoDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportAuthoDate</code>.
    */
    public void setModifiedExpenseReportAuthoDate(boolean modified) {
        this.modifiedExpenseReportAuthoDate = modified;
    }

   /**
    * Returns the value of the <code>expenseReportAuthoComments</code> attribute.<br>
    * Model Attribute: <code>expenseReportAuthoComments</code>. Variable String Size=255<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportAuthoComments</code> attribute.
    */

    public String getExpenseReportAuthoComments()  {
    	String value;
        value =  expenseReportAuthoComments;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseReportAuthoComments</code> attribute.<br>
    * Model Attribute: <code>expenseReportAuthoComments</code>. Variable String Size=255<br>
    * Comments: <br>
    * @param expenseReportAuthoComments The new value of the <code>expenseReportAuthoComments</code> attribute.
    */
    public void setExpenseReportAuthoComments (String expenseReportAuthoComments) {
        modifiedExpenseReportAuthoComments = true;
        this.expenseReportAuthoComments = expenseReportAuthoComments;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportAuthoComments</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportAuthoComments</code> class property.
    */
    public boolean isModifiedExpenseReportAuthoComments() {
        return modifiedExpenseReportAuthoComments;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportAuthoComments</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportAuthoComments</code>.
    */
    public void setModifiedExpenseReportAuthoComments(boolean modified) {
        this.modifiedExpenseReportAuthoComments = modified;
    }

   /**
    * Returns the value of the <code>expenseReportPaymentDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportPaymentDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportPaymentDate</code> attribute.
    */

    public Date getExpenseReportPaymentDate()  {
    	Date value;
        value =  expenseReportPaymentDate;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportPaymentDate</code> attribute.<br>
    * Model Attribute: <code>expenseReportPaymentDate</code>. Variable Date<br>
    * Comments: <br>
    * @param expenseReportPaymentDate The new value of the <code>expenseReportPaymentDate</code> attribute.
    */
    public void setExpenseReportPaymentDate (Date expenseReportPaymentDate) {
        modifiedExpenseReportPaymentDate = true;
        this.expenseReportPaymentDate = expenseReportPaymentDate;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportPaymentDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportPaymentDate</code> class property.
    */
    public boolean isModifiedExpenseReportPaymentDate() {
        return modifiedExpenseReportPaymentDate;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportPaymentDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportPaymentDate</code>.
    */
    public void setModifiedExpenseReportPaymentDate(boolean modified) {
        this.modifiedExpenseReportPaymentDate = modified;
    }

   /**
    * Returns the value of the <code>expenseReportPayComments</code> attribute.<br>
    * Model Attribute: <code>expenseReportPayComments</code>. Variable String Size=255<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportPayComments</code> attribute.
    */

    public String getExpenseReportPayComments()  {
    	String value;
        value =  expenseReportPayComments;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>expenseReportPayComments</code> attribute.<br>
    * Model Attribute: <code>expenseReportPayComments</code>. Variable String Size=255<br>
    * Comments: <br>
    * @param expenseReportPayComments The new value of the <code>expenseReportPayComments</code> attribute.
    */
    public void setExpenseReportPayComments (String expenseReportPayComments) {
        modifiedExpenseReportPayComments = true;
        this.expenseReportPayComments = expenseReportPayComments;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportPayComments</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportPayComments</code> class property.
    */
    public boolean isModifiedExpenseReportPayComments() {
        return modifiedExpenseReportPayComments;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportPayComments</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportPayComments</code>.
    */
    public void setModifiedExpenseReportPayComments(boolean modified) {
        this.modifiedExpenseReportPayComments = modified;
    }

   /**
    * Returns the value of the <code>expenseReportTotExpenses</code> attribute.<br>
    * Model Attribute: <code>expenseReportTotExpenses</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency. 
Req: Header and footer: General information of the Expense.
             - Total expenses. Both currencies<br>
    * @return The value of the <code>expenseReportTotExpenses</code> attribute.
    */

    public Double getExpenseReportTotExpenses()  {
    	Double value;
        try {
            value = expenseReportTotExpensesDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseReport, Attribute: expenseReportTotExpenses");
        }
        return value;
    }

   /**
    * Returns the value of the <code>expenseReportTotExpensesCur</code> attribute.<br>
    * Model Attribute: <code>expenseReportTotExpensesCur</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency. 
Req: Header and footer: General information of the Expense.
             - Total expenses. Both currencies<br>
    * @return The value of the <code>expenseReportTotExpensesCur</code> attribute.
    */

    public Double getExpenseReportTotExpensesCur()  {
    	Double value;
        try {
            value = expenseReportTotExpensesCurDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseReport, Attribute: expenseReportTotExpensesCur");
        }
        return value;
    }

   /**
    * Returns the value of the <code>expenseReportAdvances</code> attribute.<br>
    * Model Attribute: <code>expenseReportAdvances</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency. 
Req: Header and footer: General information of the Expense.
             - Total advanced amount. Both currencies<br>
    * @return The value of the <code>expenseReportAdvances</code> attribute.
    */

    public Double getExpenseReportAdvances()  {
    	Double value;
        value =  expenseReportAdvances;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportAdvances</code> attribute.<br>
    * Model Attribute: <code>expenseReportAdvances</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency. 
Req: Header and footer: General information of the Expense.
             - Total advanced amount. Both currencies<br>
    * @param expenseReportAdvances The new value of the <code>expenseReportAdvances</code> attribute.
    */
    public void setExpenseReportAdvances (Double expenseReportAdvances) {
        modifiedExpenseReportAdvances = true;
        this.expenseReportAdvances = expenseReportAdvances;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportAdvances</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportAdvances</code> class property.
    */
    public boolean isModifiedExpenseReportAdvances() {
        return modifiedExpenseReportAdvances;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportAdvances</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportAdvances</code>.
    */
    public void setModifiedExpenseReportAdvances(boolean modified) {
        this.modifiedExpenseReportAdvances = modified;
    }

   /**
    * Returns the value of the <code>expenseReportAdvancesCur</code> attribute.<br>
    * Model Attribute: <code>expenseReportAdvancesCur</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency. 
Req: Header and footer: General information of the Expense.
             - Total advanced amount. Both currencies<br>
    * @return The value of the <code>expenseReportAdvancesCur</code> attribute.
    */

    public Double getExpenseReportAdvancesCur()  {
    	Double value;
        try {
            value = expenseReportAdvancesCurDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseReport, Attribute: expenseReportAdvancesCur");
        }
        return value;
    }

   /**
    * Returns the value of the <code>expenseReportExchange</code> attribute.<br>
    * Model Attribute: <code>expenseReportExchange</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>expenseReportExchange</code> attribute.
    */

    public Double getExpenseReportExchange()  {
    	Double value;
        value =  expenseReportExchange;
        return value;
    }

   /**
    * Sets the value of the <code>expenseReportExchange</code> attribute.<br>
    * Model Attribute: <code>expenseReportExchange</code>. Variable Real<br>
    * Comments: <br>
    * @param expenseReportExchange The new value of the <code>expenseReportExchange</code> attribute.
    */
    public void setExpenseReportExchange (Double expenseReportExchange) {
        modifiedExpenseReportExchange = true;
        this.expenseReportExchange = expenseReportExchange;
    }

   /**
    * Returns the value of the <code>modifiedExpenseReportExchange</code> class property.<br>
    *
    * @return The value of the <code>modifiedExpenseReportExchange</code> class property.
    */
    public boolean isModifiedExpenseReportExchange() {
        return modifiedExpenseReportExchange;
    }

   /**
    * Sets the value of the <code>modifiedExpenseReportExchange</code> class property.<br>
    * @param modified The new value of the <code>modifiedExpenseReportExchange</code>.
    */
    public void setModifiedExpenseReportExchange(boolean modified) {
        this.modifiedExpenseReportExchange = modified;
    }

   /**
    * Returns the value of the <code>expenseReportBalance</code> attribute.<br>
    * Model Attribute: <code>expenseReportBalance</code>. Variable Real<br>
    * Comments: Req: Advances must be discounted out from the expense report balance.<br>
    * @return The value of the <code>expenseReportBalance</code> attribute.
    */

    public Double getExpenseReportBalance()  {
    	Double value;
        try {
            value = expenseReportBalanceDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseReport, Attribute: expenseReportBalance");
        }
        return value;
    }

   /**
    * Returns the value of the <code>expenseReportBalanceCur</code> attribute.<br>
    * Model Attribute: <code>expenseReportBalanceCur</code>. Variable Real<br>
    * Comments: Req: Expenses will reflect both: pattern currency and its equivalent to other currency.<br>
    * @return The value of the <code>expenseReportBalanceCur</code> attribute.
    */

    public Double getExpenseReportBalanceCur()  {
    	Double value;
        try {
            value = expenseReportBalanceCurDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ExpenseReport, Attribute: expenseReportBalanceCur");
        }
        return value;
    }

    /**
     * Returns the instance of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
     * Model Relationship:
     * <code>[ExpenseLine] ExpenseLines 0:M  ------ 1:1  ExpenseReport [ExpenseReport]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseLine</code> related through the <code>ExpenseLines</code> role.
     */
    public Collection <ExpenseLine> getExpenseLines() {
        if (expenseLines == null || expenseLines.isEmpty()) {
            expenseLines = expenseLineRepository.findByExpenseReport(this);
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
     * Returns the instance of <code>Employee</code> related through the <code>Employee</code> role.
     * Model Relationship:
     * <code>[Employee] Employee 1:1  ------ 0:M  ExpenseReports [ExpenseReport]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Employee</code> related through the <code>Employee</code> role.
     */
    public Employee getEmployee() {
        if (employee == null) {
            if (employeeidEmployee != null) {
                employee = employeeRepository.findById(employeeidEmployee).orElse(null);
            } else {
                employee = null;
            }
        }
        return (employee == null ? new Employee(null) : employee);
    }


   /**
    * Adds an instance of <code>Employee</code> related through the <code>Employee</code> role.
    * @param employee The instance to add to the <code>Employee</code> role.
    */
    public void add2Employee(Employee employee) {
        if (employee == null || employee.isNull()) {
            this.modifiedEmployee = true;
            this.employeeidEmployee = null;
        } else {
            this.employeeidEmployee = employee.getEmployeeidEmployee();
        }
        this.employee = (employee == null  || employee.isNull() ? null : employee);
    }

   /**
    * This method gets the attribute value <code>modifiedEmployee</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedEmployee</code> has been modified.
    */
    public boolean isModifiedEmployee(){
        return modifiedEmployee;
    }

    /**
     * Returns the instance of <code>ExpenseCurrency</code> related through the <code>ExpenseCurrency</code> role.
     * Model Relationship:
     * <code>[ExpenseCurrency] ExpenseCurrency 1:1  ------ 0:M  ExpenseReports [ExpenseReport]</code>
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
     * Returns the instance of <code>PaymentType</code> related through the <code>PaymentType</code> role.
     * Model Relationship:
     * <code>[PaymentType] PaymentType 0:1  ------ 0:M  ExpenseReport [ExpenseReport]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PaymentType</code> related through the <code>PaymentType</code> role.
     */
    public PaymentType getPaymentType() {
        if (paymentType == null) {
            if (paymentTypeidPaymentType != null) {
                paymentType = paymentTypeRepository.findById(paymentTypeidPaymentType).orElse(null);
            } else {
                paymentType = null;
            }
        }
        return (paymentType == null ? new PaymentType(null) : paymentType);
    }


   /**
    * Adds an instance of <code>PaymentType</code> related through the <code>PaymentType</code> role.
    * @param paymentType The instance to add to the <code>PaymentType</code> role.
    */
    public void add2PaymentType(PaymentType paymentType) {
        if (paymentType == null || paymentType.isNull()) {
            this.modifiedPaymentType = true;
            this.paymentTypeidPaymentType = null;
        } else {
            this.paymentTypeidPaymentType = paymentType.getPaymentTypeidPaymentType();
        }
        this.paymentType = (paymentType == null  || paymentType.isNull() ? null : paymentType);
    }

   /**
    * This method gets the attribute value <code>modifiedPaymentType</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPaymentType</code> has been modified.
    */
    public boolean isModifiedPaymentType(){
        return modifiedPaymentType;
    }

    /**
     * Returns the instance of <code>Project</code> related through the <code>Project</code> role.
     * Model Relationship:
     * <code>[Project] Project 1:1  ------ 0:M  ExpenseReport [ExpenseReport]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Project</code> related through the <code>Project</code> role.
     */
    public Project getProject() {
        if (project == null) {
            if (projectidProject != null) {
                project = projectRepository.findById(projectidProject).orElse(null);
            } else {
                project = null;
            }
        }
        return (project == null ? new Project(null) : project);
    }


   /**
    * Adds an instance of <code>Project</code> related through the <code>Project</code> role.
    * @param project The instance to add to the <code>Project</code> role.
    */
    public void add2Project(Project project) {
        if (project == null || project.isNull()) {
            this.modifiedProject = true;
            this.projectidProject = null;
        } else {
            this.projectidProject = project.getProjectidProject();
        }
        this.project = (project == null  || project.isNull() ? null : project);
    }

   /**
    * This method gets the attribute value <code>modifiedProject</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedProject</code> has been modified.
    */
    public boolean isModifiedProject(){
        return modifiedProject;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>expenseReportTotExpenses</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseReportTotExpenses</code> derived attribute.
     */
    public Double expenseReportTotExpensesDerivations() throws SystemException {

        expenseReportTotExpenses = null;

        expenseReportTotExpensesDerivationsDefault();
        return expenseReportTotExpenses;
    }

    private void expenseReportTotExpensesDerivationsDefault() throws SystemException {
        if (expenseReportTotExpenses != null) return;
        // Default derivation
        // EFFECT   : SUM( ExpenseLines.TotalLine )
        expenseReportTotExpenses = expenseReportRepository.assocOperator000(this);
    }

    /**
     * Computes the value of the <code>expenseReportTotExpensesCur</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseReportTotExpensesCur</code> derived attribute.
     */
    public Double expenseReportTotExpensesCurDerivations() {

        expenseReportTotExpensesCur = null;

        expenseReportTotExpensesCurDerivationsDefault();
        return expenseReportTotExpensesCur;
    }

    private void expenseReportTotExpensesCurDerivationsDefault() {
        if (expenseReportTotExpensesCur != null) return;
        // Default derivation
        // EFFECT   : TotExpenses * Exchange
        expenseReportTotExpensesCur = this.getExpenseReportTotExpenses() * this.getExpenseReportExchange();
    }

    /**
     * Computes the value of the <code>expenseReportAdvancesCur</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseReportAdvancesCur</code> derived attribute.
     */
    public Double expenseReportAdvancesCurDerivations() {

        expenseReportAdvancesCur = null;

        expenseReportAdvancesCurDerivationsDefault();
        return expenseReportAdvancesCur;
    }

    private void expenseReportAdvancesCurDerivationsDefault() {
        if (expenseReportAdvancesCur != null) return;
        // Default derivation
        // EFFECT   : Advances * Exchange
        expenseReportAdvancesCur = this.getExpenseReportAdvances() * this.getExpenseReportExchange();
    }

    /**
     * Computes the value of the <code>expenseReportBalance</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseReportBalance</code> derived attribute.
     */
    public Double expenseReportBalanceDerivations() {

        expenseReportBalance = null;

        expenseReportBalanceDerivationsDefault();
        return expenseReportBalance;
    }

    private void expenseReportBalanceDerivationsDefault() {
        if (expenseReportBalance != null) return;
        // Default derivation
        // EFFECT   : TotExpenses - Advances
        expenseReportBalance = this.getExpenseReportTotExpenses() - this.getExpenseReportAdvances();
    }

    /**
     * Computes the value of the <code>expenseReportBalanceCur</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>expenseReportBalanceCur</code> derived attribute.
     */
    public Double expenseReportBalanceCurDerivations() {

        expenseReportBalanceCur = null;

        expenseReportBalanceCurDerivationsDefault();
        return expenseReportBalanceCur;
    }

    private void expenseReportBalanceCurDerivationsDefault() {
        if (expenseReportBalanceCur != null) return;
        // Default derivation
        // EFFECT   : Balance * Exchange
        expenseReportBalanceCur = this.getExpenseReportBalance() * this.getExpenseReportExchange();
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        expenseReportPresentDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        expenseReportStatus = Long.valueOf(0);
        expenseReportCause = "";
        expenseReportAuthoDate = null;
        expenseReportAuthoComments = null;
        expenseReportPaymentDate = null;
        expenseReportPayComments = null;
        expenseReportAdvances = Double.valueOf(0);
        expenseReportExchange = Double.valueOf(0);
        expenseLines = new ArrayList<>();
        employee = null;
        expenseCurrency = null;
        paymentType = null;
        project = null;
        values = new HashMap<>();
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);
        expenseLineRepository = BeanUtil.getBean(ExpenseLineJpaRepository.class);
        employeeRepository = BeanUtil.getBean(EmployeeJpaRepository.class);
        expenseCurrencyRepository = BeanUtil.getBean(ExpenseCurrencyJpaRepository.class);
        paymentTypeRepository = BeanUtil.getBean(PaymentTypeJpaRepository.class);
        projectRepository = BeanUtil.getBean(ProjectJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setExpenseReportRepository(ExpenseReportJpaRepository expenseReportRepository) {
        this.expenseReportRepository = expenseReportRepository;
    }

    protected void setExpenseLineRepository(ExpenseLineJpaRepository expenseLineRepository) {
        this.expenseLineRepository = expenseLineRepository;
    }

    protected void setEmployeeRepository(EmployeeJpaRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    protected void setExpenseCurrencyRepository(ExpenseCurrencyJpaRepository expenseCurrencyRepository) {
        this.expenseCurrencyRepository = expenseCurrencyRepository;
    }

    protected void setPaymentTypeRepository(PaymentTypeJpaRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    protected void setProjectRepository(ProjectJpaRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ExpenseReport.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ExpenseReportConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ExpenseReportConstants.ROLE_NAME_EXPENSELINES)){
            returnedType = new ExpenseLine().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseReportConstants.ROLE_NAME_EMPLOYEE)){
            returnedType = new Employee().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY)){
            returnedType = new ExpenseCurrency().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE)){
            returnedType = new PaymentType().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ExpenseReportConstants.ROLE_NAME_PROJECT)){
            returnedType = new Project().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedExpenseReportPresentDate = false;
    	values.put("expenseReportPresentDate", getExpenseReportPresentDate());
    	modifiedExpenseReportStatus = false;
    	values.put("expenseReportStatus", getExpenseReportStatus());
    	modifiedExpenseReportCause = false;
    	values.put("expenseReportCause", getExpenseReportCause());
    	modifiedExpenseReportAuthoDate = false;
    	values.put("expenseReportAuthoDate", getExpenseReportAuthoDate());
    	modifiedExpenseReportAuthoComments = false;
    	values.put("expenseReportAuthoComments", getExpenseReportAuthoComments());
    	modifiedExpenseReportPaymentDate = false;
    	values.put("expenseReportPaymentDate", getExpenseReportPaymentDate());
    	modifiedExpenseReportPayComments = false;
    	values.put("expenseReportPayComments", getExpenseReportPayComments());
    	modifiedExpenseReportAdvances = false;
    	values.put("expenseReportAdvances", getExpenseReportAdvances());
    	modifiedExpenseReportExchange = false;
    	values.put("expenseReportExchange", getExpenseReportExchange());
    	modifiedExpenseLines = false;
    	modifiedEmployee = false;
    	modifiedExpenseCurrency = false;
    	modifiedPaymentType = false;
    	modifiedProject = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            expenseReportTotExpenses = null;
            expenseReportTotExpensesCur = null;
            expenseReportAdvancesCur = null;
            expenseReportBalance = null;
            expenseReportBalanceCur = null;
    }

    /**
     * Returns the <code>ExpenseReportOid</code> object that identifies this instance of <code>ExpenseReport</code>.
     * @return <code>ExpenseReportOid </code> object that identifies this instance of <code>ExpenseReport</code>
     */
    public ExpenseReportOid getOid() {
        return new ExpenseReportOid(getExpenseReportidExpenseRepor());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ExpenseReportConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ExpenseReportConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EXPENSEREPORT)) {
            // Add this class
            activeFacets.add(Constants.EXPENSEREPORT);
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

    public String buildDSExpenseReport4MD() {
        try {
            return (getExpenseReportidExpenseRepor() != null ? getExpenseReportidExpenseRepor().toString() : "") + " " + (getExpenseReportPresentDate() != null ? getExpenseReportPresentDate().toString() : "") + " " + getProject().getProjectProjectName() + " " + getExpenseReportCause() + " " + getExpenseCurrency().getExpenseCurrencyCurrencyName() + " " + (getExpenseReportExchange() != null ? getExpenseReportExchange().toString() : "") + " " + (getExpenseReportBalanceCur() != null ? getExpenseReportBalanceCur().toString() : "") + " " + (getExpenseReportStatus() != null ? getExpenseReportStatus().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSExpenseReportSup() {
        try {
            return (getExpenseReportPresentDate() != null ? getExpenseReportPresentDate().toString() : "") + " " + (getExpenseReportStatus() != null ? getExpenseReportStatus().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSExpenseReport4HAT() {
        try {
            return (getExpenseReportidExpenseRepor() != null ? getExpenseReportidExpenseRepor().toString() : "") + " " + (getExpenseReportPresentDate() != null ? getExpenseReportPresentDate().toString() : "") + " " + getProject().getProjectProjectName() + " " + getEmployee().getEmployeeEmpName() + " " + getExpenseReportCause() + " " + getExpenseCurrency().getExpenseCurrencyCurrencyName() + " " + (getExpenseReportExchange() != null ? getExpenseReportExchange().toString() : "") + " " + (getExpenseReportBalanceCur() != null ? getExpenseReportBalanceCur().toString() : "") + " " + (getExpenseReportStatus() != null ? getExpenseReportStatus().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }
}
