package com.integranova.spring.expensereportdemo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.IntegrityConstraintException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
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
 * Persistent representation of the <code>ERTemplate</code> model class.
 * <p>
 * Model Class: <code>ERTemplate</code><br>
 */
@Entity(name = ERTemplateConstants.CLASS_NAME)
@Table(name = ERTemplateConstants.TBL_NAME)
public class ERTemplate extends AbstractAppEntity implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient ERTemplateJpaRepository eRTemplateRepository;

    @JsonIgnore
    private transient ProjectJpaRepository projectRepository;

    @JsonIgnore
    private transient ERLTemplateJpaRepository eRLTemplateRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = ERTemplateConstants.FLD_ERTEMPLATEID )
    @JsonProperty(value="id")
    private Long eRTemplateid;

    /** Class member attribute. */
    @Column(name = ERTemplateConstants.FLD_ERTEMPLATENAME )
    @Size(max = 100)
    @JsonProperty(value="name")
    private String eRTemplatename;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERTemplatename;

    /** Class member attribute. */
    @Column(name = ERTemplateConstants.FLD_ERTEMPLATEDESCRIPTION )
    @JsonProperty(value="description")
    private String eRTemplatedescription;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERTemplatedescription;

    @Transient
    @JsonIgnore
    public boolean eRTemplatedescriptionInit = false;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="total")
    protected Double eRTemplatetotal;

    /** Class member attribute. */
    @Column(name = ERTemplateConstants.FLD_ERTEMPLATEENABLED )
    @JsonProperty(value="enabled")
    private Boolean eRTemplateenabled;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedERTemplateenabled;

    /** Related Class. */
    @ManyToMany(mappedBy=ERTemplateConstants.ROLE_INVNAME_PROJECTS)
    @JsonIgnore
    private Collection <Project> projects;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProjects;

    /** Related Class. */
    @OneToMany(mappedBy = ERTemplateConstants.ROLE_INVNAME_TEMPLATELINES)
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
    public ERTemplate() {
        eRTemplateid = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ERTemplate</code>.
     * @param oid Object Identifier of the instance of <code>ERTemplate</code> to be created.
     * @throws SystemException
     */
    public ERTemplate(ERTemplateOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            eRTemplateid = oid.getERTemplateid();
            initAttributes();
        }
    }


    /**
     * Returns the value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERTemplate</code>
     * @return The value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code>.
     */
    public Long getERTemplateid() {
        return eRTemplateid;
    }

    /**
     * Sets the value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ERTemplate</code>
     * @param eRTemplateid The new value of the <code>eRTemplateid</code> attribute<br>in class <code>ERTemplate</code>.
     */
    public void setERTemplateid(Long eRTemplateid) {
        this.eRTemplateid = eRTemplateid;
    }

   /**
    * Returns the value of the <code>eRTemplatename</code> attribute.<br>
    * Model Attribute: <code>eRTemplatename</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>eRTemplatename</code> attribute.
    */

    public String getERTemplatename()  {
    	String value;
        value =  eRTemplatename;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>eRTemplatename</code> attribute.<br>
    * Model Attribute: <code>eRTemplatename</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param eRTemplatename The new value of the <code>eRTemplatename</code> attribute.
    */
    public void setERTemplatename (String eRTemplatename) {
        modifiedERTemplatename = true;
        this.eRTemplatename = eRTemplatename;
    }

   /**
    * Returns the value of the <code>modifiedERTemplatename</code> class property.<br>
    *
    * @return The value of the <code>modifiedERTemplatename</code> class property.
    */
    public boolean isModifiedERTemplatename() {
        return modifiedERTemplatename;
    }

   /**
    * Sets the value of the <code>modifiedERTemplatename</code> class property.<br>
    * @param modified The new value of the <code>modifiedERTemplatename</code>.
    */
    public void setModifiedERTemplatename(boolean modified) {
        this.modifiedERTemplatename = modified;
    }

   /**
    * Returns the value of the <code>eRTemplatedescription</code> attribute.<br>
    * Model Attribute: <code>eRTemplatedescription</code>. Variable Text<br>
    * Comments: <br>
    * @return The value of the <code>eRTemplatedescription</code> attribute.
    */

    public String getERTemplatedescription()  {
    	String value;
        value =  eRTemplatedescription;
        return value;
    }

   /**
    * Sets the value of the <code>eRTemplatedescription</code> attribute.<br>
    * Model Attribute: <code>eRTemplatedescription</code>. Variable Text<br>
    * Comments: <br>
    * @param eRTemplatedescription The new value of the <code>eRTemplatedescription</code> attribute.
    */
    public void setERTemplatedescription (String eRTemplatedescription) {
        this.eRTemplatedescriptionInit = true;
        modifiedERTemplatedescription = true;
        this.eRTemplatedescription = eRTemplatedescription;
    }

   /**
    * Returns the value of the <code>modifiedERTemplatedescription</code> class property.<br>
    *
    * @return The value of the <code>modifiedERTemplatedescription</code> class property.
    */
    public boolean isModifiedERTemplatedescription() {
        return modifiedERTemplatedescription;
    }

   /**
    * Sets the value of the <code>modifiedERTemplatedescription</code> class property.<br>
    * @param modified The new value of the <code>modifiedERTemplatedescription</code>.
    */
    public void setModifiedERTemplatedescription(boolean modified) {
        this.modifiedERTemplatedescription = modified;
    }

   /**
    * Returns the value of the <code>eRTemplatetotal</code> attribute.<br>
    * Model Attribute: <code>eRTemplatetotal</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>eRTemplatetotal</code> attribute.
    */

    public Double getERTemplatetotal()  {
    	Double value;
        try {
            value = eRTemplatetotalDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ERTemplate, Attribute: eRTemplatetotal");
        }
        return value;
    }

   /**
    * Returns the value of the <code>eRTemplateenabled</code> attribute.<br>
    * Model Attribute: <code>eRTemplateenabled</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>eRTemplateenabled</code> attribute.
    */

    public Boolean getERTemplateenabled()  {
    	Boolean value;
        value =  eRTemplateenabled;
        return value;
    }

   /**
    * Sets the value of the <code>eRTemplateenabled</code> attribute.<br>
    * Model Attribute: <code>eRTemplateenabled</code>. Variable Bool<br>
    * Comments: <br>
    * @param eRTemplateenabled The new value of the <code>eRTemplateenabled</code> attribute.
    */
    public void setERTemplateenabled (Boolean eRTemplateenabled) {
        modifiedERTemplateenabled = true;
        this.eRTemplateenabled = eRTemplateenabled;
    }

   /**
    * Returns the value of the <code>modifiedERTemplateenabled</code> class property.<br>
    *
    * @return The value of the <code>modifiedERTemplateenabled</code> class property.
    */
    public boolean isModifiedERTemplateenabled() {
        return modifiedERTemplateenabled;
    }

   /**
    * Sets the value of the <code>modifiedERTemplateenabled</code> class property.<br>
    * @param modified The new value of the <code>modifiedERTemplateenabled</code>.
    */
    public void setModifiedERTemplateenabled(boolean modified) {
        this.modifiedERTemplateenabled = modified;
    }

    /**
     * Returns the instance of <code>Project</code> related through the <code>Projects</code> role.
     * Model Relationship:
     * <code>[Project] Projects 0:M  ------ 0:M  ERTemplates [ERTemplate]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Project</code> related through the <code>Projects</code> role.
     */
    public Collection <Project> getProjects() {
        if (projects == null || projects.isEmpty()) {
            projects = projectRepository.findByERTemplates(this);
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
     * Returns the instance of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
     * Model Relationship:
     * <code>[ERLTemplate] TemplateLines 0:M  ------ 1:1  Template [ERTemplate]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ERLTemplate</code> related through the <code>TemplateLines</code> role.
     */
    public Collection <ERLTemplate> getTemplateLines() {
        if (templateLines == null || templateLines.isEmpty()) {
            templateLines = eRLTemplateRepository.findByTemplate(this);
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
     * Computes the value of the <code>eRTemplatetotal</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>eRTemplatetotal</code> derived attribute.
     */
    public Double eRTemplatetotalDerivations() throws SystemException {

        eRTemplatetotal = null;

        eRTemplatetotalDerivationsDefault();
        return eRTemplatetotal;
    }

    private void eRTemplatetotalDerivationsDefault() throws SystemException {
        if (eRTemplatetotal != null) return;
        // Default derivation
        // EFFECT   : SUM(TemplateLines.totalLine)
        eRTemplatetotal = eRTemplateRepository.assocOperator001(this);
    }
   /**
    * This method initializes the properties of the entity and its relations.
    */
    private void initAttributes() {
        eRTemplatename = "";
        eRTemplatedescription = null;
        eRTemplateenabled = false;
        projects = new ArrayList<>();
        templateLines = new ArrayList<>();
        values = new HashMap<>();
        eRTemplateRepository = BeanUtil.getBean(ERTemplateJpaRepository.class);
        projectRepository = BeanUtil.getBean(ProjectJpaRepository.class);
        eRLTemplateRepository = BeanUtil.getBean(ERLTemplateJpaRepository.class);

        clearModifiedFlags();
    }

    protected void setERTemplateRepository(ERTemplateJpaRepository eRTemplateRepository) {
        this.eRTemplateRepository = eRTemplateRepository;
    }

    protected void setProjectRepository(ProjectJpaRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    protected void setERLTemplateRepository(ERLTemplateJpaRepository eRLTemplateRepository) {
        this.eRLTemplateRepository = eRLTemplateRepository;
    }

    @Override
    protected Method[] getMethods() {
    	return ERTemplate.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ERTemplateConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
        if (role.equalsIgnoreCase(ERTemplateConstants.ROLE_NAME_PROJECTS)){
            returnedType = new Project().getAttributeType(attribute);
        }
        if (role.equalsIgnoreCase(ERTemplateConstants.ROLE_NAME_TEMPLATELINES)){
            returnedType = new ERLTemplate().getAttributeType(attribute);
        }
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedERTemplatename = false;
    	values.put("eRTemplatename", getERTemplatename());
    	if (modifiedERTemplatedescription) {
    		values.put("eRTemplatedescription", eRTemplatedescription);
    		modifiedERTemplatedescription = false;
    	}
    	modifiedERTemplateenabled = false;
    	values.put("eRTemplateenabled", getERTemplateenabled());
    	modifiedProjects = false;
    	modifiedTemplateLines = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            eRTemplatetotal = null;
    }

    /**
     * Returns the <code>ERTemplateOid</code> object that identifies this instance of <code>ERTemplate</code>.
     * @return <code>ERTemplateOid </code> object that identifies this instance of <code>ERTemplate</code>
     */
    public ERTemplateOid getOid() {
        return new ERTemplateOid(getERTemplateid());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ERTemplateConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ERTEMPLATE)) {
            // Add this class
            activeFacets.add(Constants.ERTEMPLATE);
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

    public String buildDSERTemplates() {
        try {
            return (getERTemplateid() != null ? getERTemplateid().toString() : "") + " " + getERTemplatename() + " " + (getERTemplateenabled() != null ? getERTemplateenabled().toString() : "") + " " + (getERTemplatetotal() != null ? getERTemplatetotal().toString() : "") + " " + getERTemplatedescription();
        } catch(Exception e) {
            return "";
        }
    }
}
