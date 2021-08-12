package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.service.BeanUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>Employee</code> model class.
 * <p>
 * Model Class: <code>Employee</code><br>
 */
@Entity(name = EmployeeConstants.CLASS_NAME)
@Table(name = EmployeeConstants.TBL_NAME)
public class Employee extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient EmployeeJpaRepository employeeRepository;

    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    @JsonIgnore
    private transient AssignmentJpaRepository assignmentRepository;

    @JsonIgnore
    private transient TeamJpaRepository teamRepository;

    /** Class identification function. */
    @Id
    @Column(name = EmployeeConstants.FLD_EMPLOYEEIDEMPLOYEE )
    @Size(max = 10)
    @JsonProperty(value="id_employee")
    private String employeeidEmployee;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEEEMPNAME )
    @Size(max = 25)
    @JsonProperty(value="empname")
    private String employeeEmpName;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeeEmpName;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEEEMPSURNAME )
    @Size(max = 25)
    @JsonProperty(value="empsurname")
    private String employeeEmpSurname;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeeEmpSurname;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEESITE )
    @Size(max = 50)
    @JsonProperty(value="site")
    private String employeeSite;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeeSite;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEEPHONENUMBERS )
    @Size(max = 50)
    @JsonProperty(value="phonenumbers")
    private String employeePhoneNumbers;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeePhoneNumbers;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEEEMAIL )
    @Size(max = 100)
    @JsonProperty(value="email")
    private String employeeemail;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeeemail;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="empfullname")
    protected String employeeEmpFullName;

    /** Class member attribute. */
    @Column(name = EmployeeConstants.FLD_EMPLOYEEPICTURE )
    @JsonProperty(value="picture")
    private byte[] employeePicture;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployeePicture;

    @Transient
    @JsonIgnore
    public boolean employeePictureInit = false;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="numofexpreports")
    protected Long employeeNumOfExpReports;

    /** Related Class. */
    @OneToMany(mappedBy = EmployeeConstants.ROLE_INVNAME_EXPENSEREPORTS)
    @JsonIgnore
    private Collection <ExpenseReport> expenseReports;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReports;

    /** Related Class. */
    @OneToMany(mappedBy = EmployeeConstants.ROLE_INVNAME_ASSIGNMENTS)
    @JsonIgnore
    private Collection <Assignment> assignments;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAssignments;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_EMPLOYEETEAM,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMEMPLOYEETEAM_EMPLOYEEEMPLOYEEIDEMPLOYEE, referencedColumnName=EmployeeConstants.FLD_EMPLOYEEIDEMPLOYEE)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMEMPLOYEETEAM_TEAMTEAMID, referencedColumnName=TeamConstants.FLD_TEAMID)
    })
    @JsonIgnore
    private Collection <Team> teams;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTeams;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Employee() {
        employeeidEmployee = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Employee</code>.
     * @param oid Object Identifier of the instance of <code>Employee</code> to be created.
     * @throws SystemException
     */
    public Employee(EmployeeOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            employeeidEmployee = oid.getEmployeeidEmployee();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>employeeidEmployee</code> attribute<br>in class <code>Employee</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Employee</code>
     * @return The value of the <code>employeeidEmployee</code> attribute<br>in class <code>Employee</code>.
     */
    public String getEmployeeidEmployee() {
        return (employeeidEmployee == null ? employeeidEmployee : employeeidEmployee.trim());
    }

    /**
     * Sets the value of the <code>employeeidEmployee</code> attribute<br>in class <code>Employee</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Employee</code>
     * @param employeeidEmployee The new value of the <code>employeeidEmployee</code> attribute<br>in class <code>Employee</code>.
     */
    public void setEmployeeidEmployee(String employeeidEmployee) {
        this.employeeidEmployee = employeeidEmployee;
    }

   /**
    * Returns the value of the <code>employeeEmpName</code> attribute.<br>
    * Model Attribute: <code>employeeEmpName</code>. Variable String Size=25<br>
    * Comments: Req: Name<br>
    * @return The value of the <code>employeeEmpName</code> attribute.
    */

    public String getEmployeeEmpName()  {
    	String value;
        value =  employeeEmpName;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>employeeEmpName</code> attribute.<br>
    * Model Attribute: <code>employeeEmpName</code>. Variable String Size=25<br>
    * Comments: Req: Name<br>
    * @param employeeEmpName The new value of the <code>employeeEmpName</code> attribute.
    */
    public void setEmployeeEmpName (String employeeEmpName) {
        modifiedEmployeeEmpName = true;
        this.employeeEmpName = employeeEmpName;
    }

   /**
    * Returns the value of the <code>modifiedEmployeeEmpName</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeeEmpName</code> class property.
    */
    public boolean isModifiedEmployeeEmpName() {
        return modifiedEmployeeEmpName;
    }

   /**
    * Sets the value of the <code>modifiedEmployeeEmpName</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeeEmpName</code>.
    */
    public void setModifiedEmployeeEmpName(boolean modified) {
        this.modifiedEmployeeEmpName = modified;
    }

   /**
    * Returns the value of the <code>employeeEmpSurname</code> attribute.<br>
    * Model Attribute: <code>employeeEmpSurname</code>. Variable String Size=25<br>
    * Comments: Req: Name and Surname<br>
    * @return The value of the <code>employeeEmpSurname</code> attribute.
    */

    public String getEmployeeEmpSurname()  {
    	String value;
        value =  employeeEmpSurname;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>employeeEmpSurname</code> attribute.<br>
    * Model Attribute: <code>employeeEmpSurname</code>. Variable String Size=25<br>
    * Comments: Req: Name and Surname<br>
    * @param employeeEmpSurname The new value of the <code>employeeEmpSurname</code> attribute.
    */
    public void setEmployeeEmpSurname (String employeeEmpSurname) {
        modifiedEmployeeEmpSurname = true;
        this.employeeEmpSurname = employeeEmpSurname;
    }

   /**
    * Returns the value of the <code>modifiedEmployeeEmpSurname</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeeEmpSurname</code> class property.
    */
    public boolean isModifiedEmployeeEmpSurname() {
        return modifiedEmployeeEmpSurname;
    }

   /**
    * Sets the value of the <code>modifiedEmployeeEmpSurname</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeeEmpSurname</code>.
    */
    public void setModifiedEmployeeEmpSurname(boolean modified) {
        this.modifiedEmployeeEmpSurname = modified;
    }

   /**
    * Returns the value of the <code>employeeSite</code> attribute.<br>
    * Model Attribute: <code>employeeSite</code>. Variable String Size=50<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @return The value of the <code>employeeSite</code> attribute.
    */

    public String getEmployeeSite()  {
    	String value;
        value =  employeeSite;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>employeeSite</code> attribute.<br>
    * Model Attribute: <code>employeeSite</code>. Variable String Size=50<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @param employeeSite The new value of the <code>employeeSite</code> attribute.
    */
    public void setEmployeeSite (String employeeSite) {
        modifiedEmployeeSite = true;
        this.employeeSite = employeeSite;
    }

   /**
    * Returns the value of the <code>modifiedEmployeeSite</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeeSite</code> class property.
    */
    public boolean isModifiedEmployeeSite() {
        return modifiedEmployeeSite;
    }

   /**
    * Sets the value of the <code>modifiedEmployeeSite</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeeSite</code>.
    */
    public void setModifiedEmployeeSite(boolean modified) {
        this.modifiedEmployeeSite = modified;
    }

   /**
    * Returns the value of the <code>employeePhoneNumbers</code> attribute.<br>
    * Model Attribute: <code>employeePhoneNumbers</code>. Variable String Size=50<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @return The value of the <code>employeePhoneNumbers</code> attribute.
    */

    public String getEmployeePhoneNumbers()  {
    	String value;
        value =  employeePhoneNumbers;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>employeePhoneNumbers</code> attribute.<br>
    * Model Attribute: <code>employeePhoneNumbers</code>. Variable String Size=50<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @param employeePhoneNumbers The new value of the <code>employeePhoneNumbers</code> attribute.
    */
    public void setEmployeePhoneNumbers (String employeePhoneNumbers) {
        modifiedEmployeePhoneNumbers = true;
        this.employeePhoneNumbers = employeePhoneNumbers;
    }

   /**
    * Returns the value of the <code>modifiedEmployeePhoneNumbers</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeePhoneNumbers</code> class property.
    */
    public boolean isModifiedEmployeePhoneNumbers() {
        return modifiedEmployeePhoneNumbers;
    }

   /**
    * Sets the value of the <code>modifiedEmployeePhoneNumbers</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeePhoneNumbers</code>.
    */
    public void setModifiedEmployeePhoneNumbers(boolean modified) {
        this.modifiedEmployeePhoneNumbers = modified;
    }

   /**
    * Returns the value of the <code>employeeemail</code> attribute.<br>
    * Model Attribute: <code>employeeemail</code>. Variable String Size=100<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @return The value of the <code>employeeemail</code> attribute.
    */

    public String getEmployeeemail()  {
    	String value;
        value =  employeeemail;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>employeeemail</code> attribute.<br>
    * Model Attribute: <code>employeeemail</code>. Variable String Size=100<br>
    * Comments: Req: Site, phone numbers, email.<br>
    * @param employeeemail The new value of the <code>employeeemail</code> attribute.
    */
    public void setEmployeeemail (String employeeemail) {
        modifiedEmployeeemail = true;
        this.employeeemail = employeeemail;
    }

   /**
    * Returns the value of the <code>modifiedEmployeeemail</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeeemail</code> class property.
    */
    public boolean isModifiedEmployeeemail() {
        return modifiedEmployeeemail;
    }

   /**
    * Sets the value of the <code>modifiedEmployeeemail</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeeemail</code>.
    */
    public void setModifiedEmployeeemail(boolean modified) {
        this.modifiedEmployeeemail = modified;
    }

   /**
    * Returns the value of the <code>employeeEmpFullName</code> attribute.<br>
    * Model Attribute: <code>employeeEmpFullName</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>employeeEmpFullName</code> attribute.
    */

    public String getEmployeeEmpFullName()  {
    	String value;
        try {
            value = employeeEmpFullNameDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Employee, Attribute: employeeEmpFullName");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>employeePicture</code> attribute.<br>
    * Model Attribute: <code>employeePicture</code>. Variable Blob<br>
    * Comments: <br>
    * @return The value of the <code>employeePicture</code> attribute.
    */

    public byte[] getEmployeePicture()  {
    	byte[] value;
        value =  employeePicture;
        return value;
    }

   /**
    * Sets the value of the <code>employeePicture</code> attribute.<br>
    * Model Attribute: <code>employeePicture</code>. Variable Blob<br>
    * Comments: <br>
    * @param employeePicture The new value of the <code>employeePicture</code> attribute.
    */
    public void setEmployeePicture (byte[] employeePicture) {
        this.employeePictureInit = true;
        modifiedEmployeePicture = true;
        this.employeePicture = employeePicture;
    }

   /**
    * Returns the value of the <code>modifiedEmployeePicture</code> class property.<br>
    *
    * @return The value of the <code>modifiedEmployeePicture</code> class property.
    */
    public boolean isModifiedEmployeePicture() {
        return modifiedEmployeePicture;
    }

   /**
    * Sets the value of the <code>modifiedEmployeePicture</code> class property.<br>
    * @param modified The new value of the <code>modifiedEmployeePicture</code>.
    */
    public void setModifiedEmployeePicture(boolean modified) {
        this.modifiedEmployeePicture = modified;
    }

   /**
    * Returns the value of the <code>employeeNumOfExpReports</code> attribute.<br>
    * Model Attribute: <code>employeeNumOfExpReports</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>employeeNumOfExpReports</code> attribute.
    */

    public Long getEmployeeNumOfExpReports()  {
    	Long value;
        try {
            value = employeeNumOfExpReportsDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Employee, Attribute: employeeNumOfExpReports");
        }
        return value;
    }

    /**
     * Returns the instance of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
     * Model Relationship:
     * <code>[ExpenseReport] ExpenseReports 0:M  ------ 1:1  Employee [Employee]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseReport</code> related through the <code>ExpenseReports</code> role.
     */
    public Collection <ExpenseReport> getExpenseReports() {
        if (expenseReports == null || expenseReports.isEmpty()) {
            expenseReports = expenseReportRepository.findByEmployee(this);
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
     * Returns the instance of <code>Assignment</code> related through the <code>Assignments</code> role.
     * Model Relationship:
     * <code>[Assignment] Assignments 0:M  ------ 1:1  Employee [Employee]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Assignment</code> related through the <code>Assignments</code> role.
     */
    public Collection <Assignment> getAssignments() {
        if (assignments == null || assignments.isEmpty()) {
            assignments = assignmentRepository.findByEmployee(this);
        }
        return assignments;
    }


   /**
    * Adds an instance of <code>Assignment</code> related through the <code>Assignments</code> role.
    * @param assignments The instance to add to the <code>Assignments</code> role.
    */
    public void add2Assignments(Assignment assignments) {
        this.getAssignments().add(assignments);
    }
    /**
     * Sets instances of <code>Assignment</code> related through the <code>Assignments</code> role.
     * @param assignments The new value for the <code>Assignments</code> role.
     */
    public void setAssignments(Collection < Assignment > assignments) {
        this.assignments = assignments;
    }

   /**
    * This method gets the attribute value <code>modifiedAssignments</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAssignments</code> has been modified.
    */
    public boolean isModifiedAssignments(){
        return modifiedAssignments;
    }

    /**
     * Returns the instance of <code>Team</code> related through the <code>Teams</code> role.
     * Model Relationship:
     * <code>[Team] Teams 0:M  ------ 0:M  Employees [Employee]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Team</code> related through the <code>Teams</code> role.
     */
    public Collection <Team> getTeams() {
        if (teams == null || teams.isEmpty()) {
            teams = teamRepository.findByEmployees(this);
        }
        return teams;
    }


   /**
    * Adds an instance of <code>Team</code> related through the <code>Teams</code> role.
    * @param teams The instance to add to the <code>Teams</code> role.
    */
    public void add2Teams(Team teams) {
        this.getTeams().add(teams);
    }
    /**
     * Sets instances of <code>Team</code> related through the <code>Teams</code> role.
     * @param teams The new value for the <code>Teams</code> role.
     */
    public void setTeams(Collection < Team > teams) {
        this.teams = teams;
    }

   /**
    * This method gets the attribute value <code>modifiedTeams</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTeams</code> has been modified.
    */
    public boolean isModifiedTeams(){
        return modifiedTeams;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>employeeEmpFullName</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>employeeEmpFullName</code> derived attribute.
     */
    public String employeeEmpFullNameDerivations() {

        employeeEmpFullName = null;

        employeeEmpFullNameDerivationsDefault();
        return employeeEmpFullName;
    }

    private void employeeEmpFullNameDerivationsDefault() {
        if (employeeEmpFullName != null) return;
        // Default derivation
        // EFFECT   : EmpName + \" \" + EmpSurname
        employeeEmpFullName = this.getEmployeeEmpName() + " " + this.getEmployeeEmpSurname();
    }

    /**
     * Computes the value of the <code>employeeNumOfExpReports</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>employeeNumOfExpReports</code> derived attribute.
     */
    public Long employeeNumOfExpReportsDerivations() throws SystemException {

        employeeNumOfExpReports = null;

        employeeNumOfExpReportsDerivationsDefault();
        return employeeNumOfExpReports;
    }

    private void employeeNumOfExpReportsDerivationsDefault() throws SystemException {
        if (employeeNumOfExpReports != null) return;
        // Default derivation
        // EFFECT   : COUNT(ExpenseReports)
        employeeNumOfExpReports = employeeRepository.assocOperator000(this);
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        employeeEmpName = "";
        employeeEmpSurname = "";
        employeeSite = "";
        employeePhoneNumbers = null;
        employeeemail = "";
        employeePicture = null;
        expenseReports = new ArrayList<>();
        assignments = new ArrayList<>();
        teams = new ArrayList<>();
        values = new HashMap<>();
        employeeRepository = BeanUtil.getBean(EmployeeJpaRepository.class);
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);
        assignmentRepository = BeanUtil.getBean(AssignmentJpaRepository.class);
        teamRepository = BeanUtil.getBean(TeamJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setEmployeeRepository(EmployeeJpaRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    protected void setExpenseReportRepository(ExpenseReportJpaRepository expenseReportRepository) {
        this.expenseReportRepository = expenseReportRepository;
    }

    protected void setAssignmentRepository(AssignmentJpaRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    protected void setTeamRepository(TeamJpaRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return Employee.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return EmployeeConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(EmployeeConstants.ROLE_NAME_EXPENSEREPORTS)){
            returnedType = new ExpenseReport().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(EmployeeConstants.ROLE_NAME_ASSIGNMENTS)){
            returnedType = new Assignment().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(EmployeeConstants.ROLE_NAME_TEAMS)){
            returnedType = new Team().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedEmployeeEmpName = false;
    	values.put("employeeEmpName", getEmployeeEmpName());
    	modifiedEmployeeEmpSurname = false;
    	values.put("employeeEmpSurname", getEmployeeEmpSurname());
    	modifiedEmployeeSite = false;
    	values.put("employeeSite", getEmployeeSite());
    	modifiedEmployeePhoneNumbers = false;
    	values.put("employeePhoneNumbers", getEmployeePhoneNumbers());
    	modifiedEmployeeemail = false;
    	values.put("employeeemail", getEmployeeemail());
    	if (modifiedEmployeePicture) {
    		values.put("employeePicture", employeePicture);
    		modifiedEmployeePicture = false;
    	}
    	modifiedExpenseReports = false;
    	modifiedAssignments = false;
    	modifiedTeams = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            employeeEmpFullName = null;
            employeeNumOfExpReports = null;
    }

    /**
     * Returns the <code>EmployeeOid</code> object that identifies this instance of <code>Employee</code>.
     * @return <code>EmployeeOid </code> object that identifies this instance of <code>Employee</code>
     */
    public EmployeeOid getOid() {
        return new EmployeeOid(getEmployeeidEmployee());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(EmployeeConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.EMPLOYEE)) {
            // Add this class
            activeFacets.add(Constants.EMPLOYEE);
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

    public String buildDSEmployee() {
        try {
            return getEmployeeidEmployee() + " " + (getEmployeePicture() != null ? Arrays.toString(getEmployeePicture()) : "") + " " + getEmployeeEmpName() + " " + getEmployeeEmpSurname() + " " + getEmployeePhoneNumbers() + " " + getEmployeeSite() + " " + getEmployeeemail() + " " + (getEmployeeNumOfExpReports() != null ? getEmployeeNumOfExpReports().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSEmployeeSup() {
        try {
            return getEmployeeEmpName() + " " + getEmployeeEmpSurname();
        } catch(Exception e) {
            return "";
        }
    }
}
