package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * Persistent representation of the <code>Assignment</code> model class.
 * <p>
 * Model Class: <code>Assignment</code><br>
 */
@Entity(name = AssignmentConstants.CLASS_NAME)
@Table(name = AssignmentConstants.TBL_NAME)
public class Assignment extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private transient EmployeeJpaRepository employeeRepository;

    @JsonIgnore
    private transient ProjectJpaRepository projectRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = AssignmentConstants.FLD_ASSIGNMENTASSIGNMENTID )
    @JsonProperty(value="assignment_id")
    private Long assignmentAssignmentID;

    /** Class member attribute. */
    @Column(name = AssignmentConstants.FLD_ASSIGNMENTFROMDATE )
    @JsonProperty(value="fromdate")
    private Date assignmentFromDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAssignmentFromDate;

    /** Class member attribute. */
    @Column(name = AssignmentConstants.FLD_ASSIGNMENTTODATE )
    @JsonProperty(value="todate")
    private Date assignmentToDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAssignmentToDate;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="isactive")
    protected Boolean assignmentIsActive;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="details")
    protected String assignmentDetails;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=AssignmentConstants.FLD_EMPLOYEEIDEMPLOYEE, referencedColumnName=EmployeeConstants.FLD_EMPLOYEEIDEMPLOYEE)
    })
    @JsonIgnore
    private Employee employee;
    /** Related attribute. */
    @Column(name = AssignmentConstants.FLD_EMPLOYEEIDEMPLOYEE, insertable = false, updatable = false)
    private String employeeidEmployee;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployee;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=AssignmentConstants.FLD_PROJECTIDPROJECT, referencedColumnName=ProjectConstants.FLD_PROJECTIDPROJECT)
    })
    @JsonIgnore
    private Project project;
    /** Related attribute. */
    @Column(name = AssignmentConstants.FLD_PROJECTIDPROJECT, insertable = false, updatable = false)
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
    public Assignment() {
        assignmentAssignmentID = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Assignment</code>.
     * @param oid Object Identifier of the instance of <code>Assignment</code> to be created.
     * @throws SystemException
     */
    public Assignment(AssignmentOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            assignmentAssignmentID = oid.getAssignmentAssignmentID();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>assignmentAssignmentID</code> attribute<br>in class <code>Assignment</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Assignment</code>
     * @return The value of the <code>assignmentAssignmentID</code> attribute<br>in class <code>Assignment</code>.
     */
    public Long getAssignmentAssignmentID() {
        return assignmentAssignmentID;
    }

    /**
     * Sets the value of the <code>assignmentAssignmentID</code> attribute<br>in class <code>Assignment</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Assignment</code>
     * @param assignmentAssignmentID The new value of the <code>assignmentAssignmentID</code> attribute<br>in class <code>Assignment</code>.
     */
    public void setAssignmentAssignmentID(Long assignmentAssignmentID) {
        this.assignmentAssignmentID = assignmentAssignmentID;
    }

   /**
    * Returns the value of the <code>assignmentFromDate</code> attribute.<br>
    * Model Attribute: <code>assignmentFromDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>assignmentFromDate</code> attribute.
    */

    public Date getAssignmentFromDate()  {
    	Date value;
        value =  assignmentFromDate;
        return value;
    }

   /**
    * Sets the value of the <code>assignmentFromDate</code> attribute.<br>
    * Model Attribute: <code>assignmentFromDate</code>. Variable Date<br>
    * Comments: <br>
    * @param assignmentFromDate The new value of the <code>assignmentFromDate</code> attribute.
    */
    public void setAssignmentFromDate (Date assignmentFromDate) {
        modifiedAssignmentFromDate = true;
        this.assignmentFromDate = assignmentFromDate;
    }

   /**
    * Returns the value of the <code>modifiedAssignmentFromDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedAssignmentFromDate</code> class property.
    */
    public boolean isModifiedAssignmentFromDate() {
        return modifiedAssignmentFromDate;
    }

   /**
    * Sets the value of the <code>modifiedAssignmentFromDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedAssignmentFromDate</code>.
    */
    public void setModifiedAssignmentFromDate(boolean modified) {
        this.modifiedAssignmentFromDate = modified;
    }

   /**
    * Returns the value of the <code>assignmentToDate</code> attribute.<br>
    * Model Attribute: <code>assignmentToDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>assignmentToDate</code> attribute.
    */

    public Date getAssignmentToDate()  {
    	Date value;
        value =  assignmentToDate;
        return value;
    }

   /**
    * Sets the value of the <code>assignmentToDate</code> attribute.<br>
    * Model Attribute: <code>assignmentToDate</code>. Variable Date<br>
    * Comments: <br>
    * @param assignmentToDate The new value of the <code>assignmentToDate</code> attribute.
    */
    public void setAssignmentToDate (Date assignmentToDate) {
        modifiedAssignmentToDate = true;
        this.assignmentToDate = assignmentToDate;
    }

   /**
    * Returns the value of the <code>modifiedAssignmentToDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedAssignmentToDate</code> class property.
    */
    public boolean isModifiedAssignmentToDate() {
        return modifiedAssignmentToDate;
    }

   /**
    * Sets the value of the <code>modifiedAssignmentToDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedAssignmentToDate</code>.
    */
    public void setModifiedAssignmentToDate(boolean modified) {
        this.modifiedAssignmentToDate = modified;
    }

   /**
    * Returns the value of the <code>assignmentIsActive</code> attribute.<br>
    * Model Attribute: <code>assignmentIsActive</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>assignmentIsActive</code> attribute.
    */

    public Boolean getAssignmentIsActive()  {
    	Boolean value;
        try {
            value = assignmentIsActiveDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Assignment, Attribute: assignmentIsActive");
        }
        return value;
    }

   /**
    * Returns the value of the <code>assignmentDetails</code> attribute.<br>
    * Model Attribute: <code>assignmentDetails</code>. Variable String Size=10<br>
    * Comments: <br>
    * @return The value of the <code>assignmentDetails</code> attribute.
    */

    public String getAssignmentDetails()  {
    	String value;
        try {
            value = assignmentDetailsDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Assignment, Attribute: assignmentDetails");
        }
        return (value == null ? null : value.trim());
    }

    /**
     * Returns the instance of <code>Employee</code> related through the <code>Employee</code> role.
     * Model Relationship:
     * <code>[Employee] Employee 1:1  ------ 0:M  Assignments [Assignment]</code>
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
     * Returns the instance of <code>Project</code> related through the <code>Project</code> role.
     * Model Relationship:
     * <code>[Project] Project 1:1  ------ 0:M  Assignments [Assignment]</code>
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
     * Computes the value of the <code>assignmentIsActive</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>assignmentIsActive</code> derived attribute.
     */
    public Boolean assignmentIsActiveDerivations() {

        assignmentIsActive = null;

        assignmentIsActiveDerivationsConditional1();
        assignmentIsActiveDerivationsDefault();
        return assignmentIsActive;
    }

    private void assignmentIsActiveDerivationsConditional1() {
        if (assignmentIsActive != null) return;
        // CONDITION: ToDate <> NULL
        // EFFECT   : FALSE
        boolean assignmentIsActiveCond = this.getAssignmentToDate() != null;
        if (assignmentIsActiveCond) {
            assignmentIsActive = Boolean.FALSE;
        }
    }

    private void assignmentIsActiveDerivationsDefault() {
        if (assignmentIsActive != null) return;
        // Default derivation
        // EFFECT   : TRUE
        assignmentIsActive = Boolean.TRUE;
    }

    /**
     * Computes the value of the <code>assignmentDetails</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>assignmentDetails</code> derived attribute.
     */
    public String assignmentDetailsDerivations() {

        assignmentDetails = null;

        assignmentDetailsDerivationsDefault();
        return assignmentDetails;
    }

    private void assignmentDetailsDerivationsDefault() {
        if (assignmentDetails != null) return;
        // Default derivation
        // EFFECT   : \"Details\"
        assignmentDetails = "Details";
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        assignmentFromDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        assignmentToDate = null;
        employee = null;
        project = null;
        values = new HashMap<>();
        employeeRepository = BeanUtil.getBean(EmployeeJpaRepository.class);
        projectRepository = BeanUtil.getBean(ProjectJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setEmployeeRepository(EmployeeJpaRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    protected void setProjectRepository(ProjectJpaRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return Assignment.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return AssignmentConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(AssignmentConstants.ROLE_NAME_EMPLOYEE)){
            returnedType = new Employee().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(AssignmentConstants.ROLE_NAME_PROJECT)){
            returnedType = new Project().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedAssignmentFromDate = false;
    	values.put("assignmentFromDate", getAssignmentFromDate());
    	modifiedAssignmentToDate = false;
    	values.put("assignmentToDate", getAssignmentToDate());
    	modifiedEmployee = false;
    	modifiedProject = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            assignmentIsActive = null;
            assignmentDetails = null;
    }

    /**
     * Returns the <code>AssignmentOid</code> object that identifies this instance of <code>Assignment</code>.
     * @return <code>AssignmentOid </code> object that identifies this instance of <code>Assignment</code>
     */
    public AssignmentOid getOid() {
        return new AssignmentOid(getAssignmentAssignmentID());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(AssignmentConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(AssignmentConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ASSIGNMENT)) {
            // Add this class
            activeFacets.add(Constants.ASSIGNMENT);
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

    public String buildDSAssignmentDetails() {
        try {
            return getProject().getProjectProjectName() + " " + getProject().getProjectProDescription() + " " + getEmployee().getEmployeeEmpFullName() + " " + (getAssignmentFromDate() != null ? getAssignmentFromDate().toString() : "") + " " + (getAssignmentToDate() != null ? getAssignmentToDate().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSAssignments() {
        try {
            return getProject().getProjectProjectName() + " " + getEmployee().getEmployeeEmpFullName() + " " + (getAssignmentIsActive() != null ? getAssignmentIsActive().toString() : "") + " " + getAssignmentDetails();
        } catch(Exception e) {
            return "";
        }
    }
}
