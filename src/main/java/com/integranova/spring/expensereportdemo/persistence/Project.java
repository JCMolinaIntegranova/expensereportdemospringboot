package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
/**
 * Persistent representation of the <code>Project</code> model class.
 * <p>
 * Model Class: <code>Project</code><br>
 */
@Entity(name = ProjectConstants.CLASS_NAME)
@Table(name = ProjectConstants.TBL_NAME)
public class Project extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient ProjectJpaRepository projectRepository;

    @JsonIgnore
    private transient ExpenseReportJpaRepository expenseReportRepository;

    @JsonIgnore
    private transient AssignmentJpaRepository assignmentRepository;

    @JsonIgnore
    private transient TeamJpaRepository teamRepository;

    @JsonIgnore
    private transient ERTemplateJpaRepository eRTemplateRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = ProjectConstants.FLD_PROJECTIDPROJECT )
    @JsonProperty(value="id_project")
    private Long projectidProject;

    /** Class member attribute. */
    @Column(name = ProjectConstants.FLD_PROJECTPROJECTNAME )
    @Size(max = 50)
    @JsonProperty(value="projectname")
    private String projectProjectName;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProjectProjectName;

    /** Class member attribute. */
    @Column(name = ProjectConstants.FLD_PROJECTPRODESCRIPTION )
    @Size(max = 255)
    @JsonProperty(value="prodescription")
    private String projectProDescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProjectProDescription;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="totexpenses")
    protected Double projectTotExpenses;

    /** Class member attribute. */
    @Column(name = ProjectConstants.FLD_PROJECTCOMPLETIONDATE )
    @JsonProperty(value="completiondate")
    private Date projectCompletionDate;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProjectCompletionDate;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="maxexpense")
    protected Double projectMaxExpense;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="minexpense")
    protected Double projectMinExpense;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="avgexpense")
    protected Double projectAvgExpense;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="completed")
    protected Boolean projectCompleted;

    /** Related Class. */
    @OneToMany(mappedBy = ProjectConstants.ROLE_INVNAME_EXPENSEREPORT)
    @JsonIgnore
    private Collection <ExpenseReport> expenseReport;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedExpenseReport;

    /** Related Class. */
    @OneToMany(mappedBy = ProjectConstants.ROLE_INVNAME_ASSIGNMENTS)
    @JsonIgnore
    private Collection <Assignment> assignments;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAssignments;

    /** Related Class. */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name=ProjectConstants.FLD_TEAMID, referencedColumnName=TeamConstants.FLD_TEAMID)
    })
    @JsonIgnore
    private Team team;
    /** Related attribute. */
    @Column(name = ProjectConstants.FLD_TEAMID, insertable = false, updatable = false)
    private Long teamid;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTeam;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_PROJECTERTEMPLATE,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMPROJECTERTEMPLATE_PROJECTPROJECTIDPROJECT, referencedColumnName=ProjectConstants.FLD_PROJECTIDPROJECT)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMPROJECTERTEMPLATE_ERTEMPLATEERTEMPLATEID, referencedColumnName=ERTemplateConstants.FLD_ERTEMPLATEID)
    })
    @JsonIgnore
    private Collection <ERTemplate> eRTemplates;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERTemplates;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Project() {
        projectidProject = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Project</code>.
     * @param oid Object Identifier of the instance of <code>Project</code> to be created.
     * @throws SystemException
     */
    public Project(ProjectOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            projectidProject = oid.getProjectidProject();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>projectidProject</code> attribute<br>in class <code>Project</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Project</code>
     * @return The value of the <code>projectidProject</code> attribute<br>in class <code>Project</code>.
     */
    public Long getProjectidProject() {
        return projectidProject;
    }

    /**
     * Sets the value of the <code>projectidProject</code> attribute<br>in class <code>Project</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Project</code>
     * @param projectidProject The new value of the <code>projectidProject</code> attribute<br>in class <code>Project</code>.
     */
    public void setProjectidProject(Long projectidProject) {
        this.projectidProject = projectidProject;
    }

   /**
    * Returns the value of the <code>projectProjectName</code> attribute.<br>
    * Model Attribute: <code>projectProjectName</code>. Variable String Size=50<br>
    * Comments: Project Name<br>
    * @return The value of the <code>projectProjectName</code> attribute.
    */

    public String getProjectProjectName()  {
    	String value;
        value =  projectProjectName;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>projectProjectName</code> attribute.<br>
    * Model Attribute: <code>projectProjectName</code>. Variable String Size=50<br>
    * Comments: Project Name<br>
    * @param projectProjectName The new value of the <code>projectProjectName</code> attribute.
    */
    public void setProjectProjectName (String projectProjectName) {
        modifiedProjectProjectName = true;
        this.projectProjectName = projectProjectName;
    }

   /**
    * Returns the value of the <code>modifiedProjectProjectName</code> class property.<br>
    *
    * @return The value of the <code>modifiedProjectProjectName</code> class property.
    */
    public boolean isModifiedProjectProjectName() {
        return modifiedProjectProjectName;
    }

   /**
    * Sets the value of the <code>modifiedProjectProjectName</code> class property.<br>
    * @param modified The new value of the <code>modifiedProjectProjectName</code>.
    */
    public void setModifiedProjectProjectName(boolean modified) {
        this.modifiedProjectProjectName = modified;
    }

   /**
    * Returns the value of the <code>projectProDescription</code> attribute.<br>
    * Model Attribute: <code>projectProDescription</code>. Variable String Size=255<br>
    * Comments: Description of the project<br>
    * @return The value of the <code>projectProDescription</code> attribute.
    */

    public String getProjectProDescription()  {
    	String value;
        value =  projectProDescription;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>projectProDescription</code> attribute.<br>
    * Model Attribute: <code>projectProDescription</code>. Variable String Size=255<br>
    * Comments: Description of the project<br>
    * @param projectProDescription The new value of the <code>projectProDescription</code> attribute.
    */
    public void setProjectProDescription (String projectProDescription) {
        modifiedProjectProDescription = true;
        this.projectProDescription = projectProDescription;
    }

   /**
    * Returns the value of the <code>modifiedProjectProDescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedProjectProDescription</code> class property.
    */
    public boolean isModifiedProjectProDescription() {
        return modifiedProjectProDescription;
    }

   /**
    * Sets the value of the <code>modifiedProjectProDescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedProjectProDescription</code>.
    */
    public void setModifiedProjectProDescription(boolean modified) {
        this.modifiedProjectProDescription = modified;
    }

   /**
    * Returns the value of the <code>projectTotExpenses</code> attribute.<br>
    * Model Attribute: <code>projectTotExpenses</code>. Variable Real<br>
    * Comments: Total expenses of the project, calculated as the sum of all expenses reports<br>
    * @return The value of the <code>projectTotExpenses</code> attribute.
    */

    public Double getProjectTotExpenses()  {
    	Double value;
        try {
            value = projectTotExpensesDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Project, Attribute: projectTotExpenses");
        }
        return value;
    }

   /**
    * Returns the value of the <code>projectCompletionDate</code> attribute.<br>
    * Model Attribute: <code>projectCompletionDate</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>projectCompletionDate</code> attribute.
    */

    public Date getProjectCompletionDate()  {
    	Date value;
        value =  projectCompletionDate;
        return value;
    }

   /**
    * Sets the value of the <code>projectCompletionDate</code> attribute.<br>
    * Model Attribute: <code>projectCompletionDate</code>. Variable Date<br>
    * Comments: <br>
    * @param projectCompletionDate The new value of the <code>projectCompletionDate</code> attribute.
    */
    public void setProjectCompletionDate (Date projectCompletionDate) {
        modifiedProjectCompletionDate = true;
        this.projectCompletionDate = projectCompletionDate;
    }

   /**
    * Returns the value of the <code>modifiedProjectCompletionDate</code> class property.<br>
    *
    * @return The value of the <code>modifiedProjectCompletionDate</code> class property.
    */
    public boolean isModifiedProjectCompletionDate() {
        return modifiedProjectCompletionDate;
    }

   /**
    * Sets the value of the <code>modifiedProjectCompletionDate</code> class property.<br>
    * @param modified The new value of the <code>modifiedProjectCompletionDate</code>.
    */
    public void setModifiedProjectCompletionDate(boolean modified) {
        this.modifiedProjectCompletionDate = modified;
    }

   /**
    * Returns the value of the <code>projectMaxExpense</code> attribute.<br>
    * Model Attribute: <code>projectMaxExpense</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>projectMaxExpense</code> attribute.
    */

    public Double getProjectMaxExpense()  {
    	Double value;
        try {
            value = projectMaxExpenseDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Project, Attribute: projectMaxExpense");
        }
        return value;
    }

   /**
    * Returns the value of the <code>projectMinExpense</code> attribute.<br>
    * Model Attribute: <code>projectMinExpense</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>projectMinExpense</code> attribute.
    */

    public Double getProjectMinExpense()  {
    	Double value;
        try {
            value = projectMinExpenseDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Project, Attribute: projectMinExpense");
        }
        return value;
    }

   /**
    * Returns the value of the <code>projectAvgExpense</code> attribute.<br>
    * Model Attribute: <code>projectAvgExpense</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>projectAvgExpense</code> attribute.
    */

    public Double getProjectAvgExpense()  {
    	Double value;
        try {
            value = projectAvgExpenseDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Project, Attribute: projectAvgExpense");
        }
        return value;
    }

   /**
    * Returns the value of the <code>projectCompleted</code> attribute.<br>
    * Model Attribute: <code>projectCompleted</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>projectCompleted</code> attribute.
    */

    public Boolean getProjectCompleted()  {
    	Boolean value;
        try {
            value = projectCompletedDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Project, Attribute: projectCompleted");
        }
        return value;
    }

    /**
     * Returns the instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     * Model Relationship:
     * <code>[ExpenseReport] ExpenseReport 0:M  ------ 1:1  Project [Project]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ExpenseReport</code> related through the <code>ExpenseReport</code> role.
     */
    public Collection <ExpenseReport> getExpenseReport() {
        if (expenseReport == null || expenseReport.isEmpty()) {
            expenseReport = expenseReportRepository.findByProject(this);
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
     * Returns the instance of <code>Assignment</code> related through the <code>Assignments</code> role.
     * Model Relationship:
     * <code>[Assignment] Assignments 0:M  ------ 1:1  Project [Project]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Assignment</code> related through the <code>Assignments</code> role.
     */
    public Collection <Assignment> getAssignments() {
        if (assignments == null || assignments.isEmpty()) {
            assignments = assignmentRepository.findByProject(this);
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
     * Returns the instance of <code>Team</code> related through the <code>Team</code> role.
     * Model Relationship:
     * <code>[Team] Team 1:1  ------ 0:M  Projects [Project]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Team</code> related through the <code>Team</code> role.
     */
    public Team getTeam() {
        if (team == null) {
            if (teamid != null) {
                team = teamRepository.findById(teamid).orElse(null);
            } else {
                team = null;
            }
        }
        return (team == null ? new Team(null) : team);
    }


   /**
    * Adds an instance of <code>Team</code> related through the <code>Team</code> role.
    * @param team The instance to add to the <code>Team</code> role.
    */
    public void add2Team(Team team) {
        if (team == null || team.isNull()) {
            this.modifiedTeam = true;
            this.teamid = null;
        } else {
            this.teamid = team.getTeamid();
        }
        this.team = (team == null  || team.isNull() ? null : team);
    }

   /**
    * This method gets the attribute value <code>modifiedTeam</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTeam</code> has been modified.
    */
    public boolean isModifiedTeam(){
        return modifiedTeam;
    }

    /**
     * Returns the instance of <code>ERTemplate</code> related through the <code>ERTemplates</code> role.
     * Model Relationship:
     * <code>[ERTemplate] ERTemplates 0:M  ------ 0:M  Projects [Project]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ERTemplate</code> related through the <code>ERTemplates</code> role.
     */
    public Collection <ERTemplate> getERTemplates() {
        if (eRTemplates == null || eRTemplates.isEmpty()) {
            eRTemplates = eRTemplateRepository.findByProjects(this);
        }
        return eRTemplates;
    }


   /**
    * Adds an instance of <code>ERTemplate</code> related through the <code>ERTemplates</code> role.
    * @param eRTemplates The instance to add to the <code>ERTemplates</code> role.
    */
    public void add2ERTemplates(ERTemplate eRTemplates) {
        this.getERTemplates().add(eRTemplates);
    }
    /**
     * Sets instances of <code>ERTemplate</code> related through the <code>ERTemplates</code> role.
     * @param eRTemplates The new value for the <code>ERTemplates</code> role.
     */
    public void setERTemplates(Collection < ERTemplate > eRTemplates) {
        this.eRTemplates = eRTemplates;
    }

   /**
    * This method gets the attribute value <code>modifiedERTemplates</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedERTemplates</code> has been modified.
    */
    public boolean isModifiedERTemplates(){
        return modifiedERTemplates;
    }
    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Computes the value of the <code>projectTotExpenses</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>projectTotExpenses</code> derived attribute.
     */
    public Double projectTotExpensesDerivations() throws SystemException {

        projectTotExpenses = null;

        projectTotExpensesDerivationsDefault();
        return projectTotExpenses;
    }

    private void projectTotExpensesDerivationsDefault() throws SystemException {
        if (projectTotExpenses != null) return;
        // Default derivation
        // EFFECT   : SUM( ExpenseReport.TotExpenses)
        projectTotExpenses = projectRepository.assocOperator001(this);
    }

    /**
     * Computes the value of the <code>projectMaxExpense</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>projectMaxExpense</code> derived attribute.
     */
    public Double projectMaxExpenseDerivations() throws SystemException {

        projectMaxExpense = null;

        projectMaxExpenseDerivationsDefault();
        return projectMaxExpense;
    }

    private void projectMaxExpenseDerivationsDefault() throws SystemException {
        if (projectMaxExpense != null) return;
        // Default derivation
        // EFFECT   : MAX(ExpenseReport.TotExpenses)
        projectMaxExpense = projectRepository.assocOperator002(this);
    }

    /**
     * Computes the value of the <code>projectMinExpense</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>projectMinExpense</code> derived attribute.
     */
    public Double projectMinExpenseDerivations() throws SystemException {

        projectMinExpense = null;

        projectMinExpenseDerivationsDefault();
        return projectMinExpense;
    }

    private void projectMinExpenseDerivationsDefault() throws SystemException {
        if (projectMinExpense != null) return;
        // Default derivation
        // EFFECT   : MIN(ExpenseReport.TotExpenses)
        projectMinExpense = projectRepository.assocOperator003(this);
    }

    /**
     * Computes the value of the <code>projectAvgExpense</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>projectAvgExpense</code> derived attribute.
     */
    public Double projectAvgExpenseDerivations() throws SystemException {

        projectAvgExpense = null;

        projectAvgExpenseDerivationsDefault();
        return projectAvgExpense;
    }

    private void projectAvgExpenseDerivationsDefault() throws SystemException {
        if (projectAvgExpense != null) return;
        // Default derivation
        // EFFECT   : AVG(ExpenseReport.TotExpenses)
        projectAvgExpense = projectRepository.assocOperator004(this);
    }

    /**
     * Computes the value of the <code>projectCompleted</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>projectCompleted</code> derived attribute.
     */
    public Boolean projectCompletedDerivations() {

        projectCompleted = null;

        projectCompletedDerivationsDefault();
        return projectCompleted;
    }

    private void projectCompletedDerivationsDefault() {
        if (projectCompleted != null) return;
        // Default derivation
        // EFFECT   : CompletionDate <> NULL
        projectCompleted = this.getProjectCompletionDate() != null;
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        projectProjectName = "";
        projectProDescription = "";
        projectCompletionDate = null;
        expenseReport = new ArrayList<>();
        assignments = new ArrayList<>();
        team = null;
        eRTemplates = new ArrayList<>();
        values = new HashMap<>();
        projectRepository = BeanUtil.getBean(ProjectJpaRepository.class);
        expenseReportRepository = BeanUtil.getBean(ExpenseReportJpaRepository.class);
        assignmentRepository = BeanUtil.getBean(AssignmentJpaRepository.class);
        teamRepository = BeanUtil.getBean(TeamJpaRepository.class);
        eRTemplateRepository = BeanUtil.getBean(ERTemplateJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setProjectRepository(ProjectJpaRepository projectRepository) {
        this.projectRepository = projectRepository;
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

    protected void setERTemplateRepository(ERTemplateJpaRepository eRTemplateRepository) {
        this.eRTemplateRepository = eRTemplateRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return Project.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ProjectConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ProjectConstants.ROLE_NAME_EXPENSEREPORT)){
            returnedType = new ExpenseReport().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ProjectConstants.ROLE_NAME_ASSIGNMENTS)){
            returnedType = new Assignment().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ProjectConstants.ROLE_NAME_TEAM)){
            returnedType = new Team().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ProjectConstants.ROLE_NAME_ERTEMPLATES)){
            returnedType = new ERTemplate().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedProjectProjectName = false;
    	values.put("projectProjectName", getProjectProjectName());
    	modifiedProjectProDescription = false;
    	values.put("projectProDescription", getProjectProDescription());
    	modifiedProjectCompletionDate = false;
    	values.put("projectCompletionDate", getProjectCompletionDate());
    	modifiedExpenseReport = false;
    	modifiedAssignments = false;
    	modifiedTeam = false;
    	modifiedERTemplates = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            projectTotExpenses = null;
            projectMaxExpense = null;
            projectMinExpense = null;
            projectAvgExpense = null;
            projectCompleted = null;
    }

    /**
     * Returns the <code>ProjectOid</code> object that identifies this instance of <code>Project</code>.
     * @return <code>ProjectOid </code> object that identifies this instance of <code>Project</code>
     */
    public ProjectOid getOid() {
        return new ProjectOid(getProjectidProject());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ProjectConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ProjectConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PROJECT)) {
            // Add this class
            activeFacets.add(Constants.PROJECT);
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

    public String buildDSProject() {
        try {
            return (getProjectidProject() != null ? getProjectidProject().toString() : "") + " " + getProjectProjectName() + " " + getTeam().getTeamname() + " " + getProjectProDescription() + " " + (getProjectTotExpenses() != null ? getProjectTotExpenses().toString() : "") + " " + (getProjectMaxExpense() != null ? getProjectMaxExpense().toString() : "") + " " + (getProjectMinExpense() != null ? getProjectMinExpense().toString() : "") + " " + (getProjectAvgExpense() != null ? getProjectAvgExpense().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSProjectSup() {
        try {
            return getProjectProjectName();
        } catch(Exception e) {
            return "";
        }
    }
}
