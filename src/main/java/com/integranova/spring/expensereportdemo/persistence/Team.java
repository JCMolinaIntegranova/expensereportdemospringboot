package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>Team</code> model class.
 * <p>
 * Model Class: <code>Team</code><br>
 */
@Entity(name = TeamConstants.CLASS_NAME)
@Table(name = TeamConstants.TBL_NAME)
public class Team extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient TeamJpaRepository teamRepository;

    @JsonIgnore
    private transient EmployeeJpaRepository employeeRepository;

    @JsonIgnore
    private transient ProjectJpaRepository projectRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = TeamConstants.FLD_TEAMID )
    @JsonProperty(value="id")
    private Long teamid;

    /** Class member attribute. */
    @Column(name = TeamConstants.FLD_TEAMNAME )
    @Size(max = 100)
    @JsonProperty(value="name")
    private String teamname;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTeamname;

    /** Class member attribute. */
    @Column(name = TeamConstants.FLD_TEAMMAXEMPLOYEES )
    @JsonProperty(value="maxemployees")
    private Long teammaxEmployees;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTeammaxEmployees;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="countemployees")
    protected Long teamcountEmployees;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totalexpenses")
    protected Double teamtotalExpenses;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="capacity")
    protected Long teamcapacity;

    /** Related Class. */
    @ManyToMany(mappedBy=TeamConstants.ROLE_INVNAME_EMPLOYEES)
    @JsonIgnore
    private Collection <Employee> employees;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEmployees;

    /** Related Class. */
    @OneToMany(mappedBy = TeamConstants.ROLE_INVNAME_PROJECTS)
    @JsonIgnore
    private Collection <Project> projects;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProjects;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Team() {
        teamid = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Team</code>.
     * @param oid Object Identifier of the instance of <code>Team</code> to be created.
     * @throws SystemException
     */
    public Team(TeamOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            teamid = oid.getTeamid();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>teamid</code> attribute<br>in class <code>Team</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Team</code>
     * @return The value of the <code>teamid</code> attribute<br>in class <code>Team</code>.
     */
    public Long getTeamid() {
        return teamid;
    }

    /**
     * Sets the value of the <code>teamid</code> attribute<br>in class <code>Team</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Team</code>
     * @param teamid The new value of the <code>teamid</code> attribute<br>in class <code>Team</code>.
     */
    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

   /**
    * Returns the value of the <code>teamname</code> attribute.<br>
    * Model Attribute: <code>teamname</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>teamname</code> attribute.
    */

    public String getTeamname()  {
    	String value;
        value =  teamname;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>teamname</code> attribute.<br>
    * Model Attribute: <code>teamname</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param teamname The new value of the <code>teamname</code> attribute.
    */
    public void setTeamname (String teamname) {
        modifiedTeamname = true;
        this.teamname = teamname;
    }

   /**
    * Returns the value of the <code>modifiedTeamname</code> class property.<br>
    *
    * @return The value of the <code>modifiedTeamname</code> class property.
    */
    public boolean isModifiedTeamname() {
        return modifiedTeamname;
    }

   /**
    * Sets the value of the <code>modifiedTeamname</code> class property.<br>
    * @param modified The new value of the <code>modifiedTeamname</code>.
    */
    public void setModifiedTeamname(boolean modified) {
        this.modifiedTeamname = modified;
    }

   /**
    * Returns the value of the <code>teammaxEmployees</code> attribute.<br>
    * Model Attribute: <code>teammaxEmployees</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>teammaxEmployees</code> attribute.
    */

    public Long getTeammaxEmployees()  {
    	Long value;
        value =  teammaxEmployees;
        return value;
    }

   /**
    * Sets the value of the <code>teammaxEmployees</code> attribute.<br>
    * Model Attribute: <code>teammaxEmployees</code>. Variable Int<br>
    * Comments: <br>
    * @param teammaxEmployees The new value of the <code>teammaxEmployees</code> attribute.
    */
    public void setTeammaxEmployees (Long teammaxEmployees) {
        modifiedTeammaxEmployees = true;
        this.teammaxEmployees = teammaxEmployees;
    }

   /**
    * Returns the value of the <code>modifiedTeammaxEmployees</code> class property.<br>
    *
    * @return The value of the <code>modifiedTeammaxEmployees</code> class property.
    */
    public boolean isModifiedTeammaxEmployees() {
        return modifiedTeammaxEmployees;
    }

   /**
    * Sets the value of the <code>modifiedTeammaxEmployees</code> class property.<br>
    * @param modified The new value of the <code>modifiedTeammaxEmployees</code>.
    */
    public void setModifiedTeammaxEmployees(boolean modified) {
        this.modifiedTeammaxEmployees = modified;
    }

   /**
    * Returns the value of the <code>teamcountEmployees</code> attribute.<br>
    * Model Attribute: <code>teamcountEmployees</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>teamcountEmployees</code> attribute.
    */

    public Long getTeamcountEmployees()  {
    	Long value;
        try {
            value = teamcountEmployeesDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Team, Attribute: teamcountEmployees");
        }
        return value;
    }

   /**
    * Returns the value of the <code>teamtotalExpenses</code> attribute.<br>
    * Model Attribute: <code>teamtotalExpenses</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>teamtotalExpenses</code> attribute.
    */

    public Double getTeamtotalExpenses()  {
    	Double value;
        try {
            value = teamtotalExpensesDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Team, Attribute: teamtotalExpenses");
        }
        return value;
    }

   /**
    * Returns the value of the <code>teamcapacity</code> attribute.<br>
    * Model Attribute: <code>teamcapacity</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>teamcapacity</code> attribute.
    */

    public Long getTeamcapacity()  {
    	Long value;
        try {
            value = teamcapacityDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Team, Attribute: teamcapacity");
        }
        return value;
    }

    /**
     * Returns the instance of <code>Employee</code> related through the <code>Employees</code> role.
     * Model Relationship:
     * <code>[Employee] Employees 0:M  ------ 0:M  Teams [Team]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Employee</code> related through the <code>Employees</code> role.
     */
    public Collection <Employee> getEmployees() {
        if (employees == null || employees.isEmpty()) {
            employees = employeeRepository.findByTeams(this);
        }
        return employees;
    }


   /**
    * Adds an instance of <code>Employee</code> related through the <code>Employees</code> role.
    * @param employees The instance to add to the <code>Employees</code> role.
    */
    public void add2Employees(Employee employees) {
        this.getEmployees().add(employees);
    }
    /**
     * Sets instances of <code>Employee</code> related through the <code>Employees</code> role.
     * @param employees The new value for the <code>Employees</code> role.
     */
    public void setEmployees(Collection < Employee > employees) {
        this.employees = employees;
    }

   /**
    * This method gets the attribute value <code>modifiedEmployees</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedEmployees</code> has been modified.
    */
    public boolean isModifiedEmployees(){
        return modifiedEmployees;
    }

    /**
     * Returns the instance of <code>Project</code> related through the <code>Projects</code> role.
     * Model Relationship:
     * <code>[Project] Projects 0:M  ------ 1:1  Team [Team]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Project</code> related through the <code>Projects</code> role.
     */
    public Collection <Project> getProjects() {
        if (projects == null || projects.isEmpty()) {
            projects = projectRepository.findByTeam(this);
        }
        return projects;
    }


   /**
    * Adds an instance of <code>Project</code> related through the <code>Projects</code> role.
    * @param projects The instance to add to the <code>Projects</code> role.
    */
    public void add2Projects(Project projects) {
        this.getProjects().add(projects);
    }
    /**
     * Sets instances of <code>Project</code> related through the <code>Projects</code> role.
     * @param projects The new value for the <code>Projects</code> role.
     */
    public void setProjects(Collection < Project > projects) {
        this.projects = projects;
    }

   /**
    * This method gets the attribute value <code>modifiedProjects</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedProjects</code> has been modified.
    */
    public boolean isModifiedProjects(){
        return modifiedProjects;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>teamcountEmployees</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>teamcountEmployees</code> derived attribute.
     */
    public Long teamcountEmployeesDerivations() throws SystemException {

        teamcountEmployees = null;

        teamcountEmployeesDerivationsConditional1();
        teamcountEmployeesDerivationsDefault();
        return teamcountEmployees;
    }

    private void teamcountEmployeesDerivationsConditional1() throws SystemException {
        if (teamcountEmployees != null) return;
        // CONDITION: EXIST( Employees ) = false
        // EFFECT   : 0
        boolean teamcountEmployeesCond = teamRepository.assocOperator002(this).equals(false);
        if (teamcountEmployeesCond) {
            teamcountEmployees = Long.valueOf(0);
        }
    }

    private void teamcountEmployeesDerivationsDefault() throws SystemException {
        if (teamcountEmployees != null) return;
        // Default derivation
        // EFFECT   : COUNT( Employees )
        teamcountEmployees = teamRepository.assocOperator003(this);
    }

    /**
     * Computes the value of the <code>teamtotalExpenses</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>teamtotalExpenses</code> derived attribute.
     */
    public Double teamtotalExpensesDerivations() throws SystemException {

        teamtotalExpenses = null;

        teamtotalExpensesDerivationsDefault();
        return teamtotalExpenses;
    }

    private void teamtotalExpensesDerivationsDefault() throws SystemException {
        if (teamtotalExpenses != null) return;
        // Default derivation
        // EFFECT   : SUM( Employees.ExpenseReports.TotExpenses )
        teamtotalExpenses = teamRepository.assocOperator004(this);
    }

    /**
     * Computes the value of the <code>teamcapacity</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>teamcapacity</code> derived attribute.
     */
    public Long teamcapacityDerivations() {

        teamcapacity = null;

        teamcapacityDerivationsDefault();
        return teamcapacity;
    }

    private void teamcapacityDerivationsDefault() {
        if (teamcapacity != null) return;
        // Default derivation
        // EFFECT   : maxEmployees - countEmployees
        teamcapacity = this.getTeammaxEmployees() - this.getTeamcountEmployees();
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        teamname = "";
        teammaxEmployees = Long.valueOf(0);
        employees = new ArrayList<>();
        projects = new ArrayList<>();
        values = new HashMap<>();
        teamRepository = BeanUtil.getBean(TeamJpaRepository.class);
        employeeRepository = BeanUtil.getBean(EmployeeJpaRepository.class);
        projectRepository = BeanUtil.getBean(ProjectJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setTeamRepository(TeamJpaRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    protected void setEmployeeRepository(EmployeeJpaRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    protected void setProjectRepository(ProjectJpaRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return Team.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return TeamConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(TeamConstants.ROLE_NAME_EMPLOYEES)){
            returnedType = new Employee().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(TeamConstants.ROLE_NAME_PROJECTS)){
            returnedType = new Project().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedTeamname = false;
    	values.put("teamname", getTeamname());
    	modifiedTeammaxEmployees = false;
    	values.put("teammaxEmployees", getTeammaxEmployees());
    	modifiedEmployees = false;
    	modifiedProjects = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            teamcountEmployees = null;
            teamtotalExpenses = null;
            teamcapacity = null;
    }

    /**
     * Returns the <code>TeamOid</code> object that identifies this instance of <code>Team</code>.
     * @return <code>TeamOid </code> object that identifies this instance of <code>Team</code>
     */
    public TeamOid getOid() {
        return new TeamOid(getTeamid());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(TeamConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.TEAM)) {
            // Add this class
            activeFacets.add(Constants.TEAM);
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

    public String buildDSTeams() {
        try {
            return (getTeamid() != null ? getTeamid().toString() : "") + " " + getTeamname() + " " + (getTeammaxEmployees() != null ? getTeammaxEmployees().toString() : "") + " " + (getTeamcountEmployees() != null ? getTeamcountEmployees().toString() : "") + " " + (getTeamtotalExpenses() != null ? getTeamtotalExpenses().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSTeam() {
        try {
            return (getTeamid() != null ? getTeamid().toString() : "") + " " + getTeamname() + " " + (getTeammaxEmployees() != null ? getTeammaxEmployees().toString() : "") + " " + (getTeamcountEmployees() != null ? getTeamcountEmployees().toString() : "") + " " + (getTeamtotalExpenses() != null ? getTeamtotalExpenses().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }
}
