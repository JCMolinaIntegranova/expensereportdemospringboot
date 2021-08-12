package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProjectOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_Project **/
    @JsonProperty(value = "id_project")
    private Long projectidProject;

    /** Default constructor. **/
    public ProjectOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param projectidProject value of the <code>projectidProject</code> attribute.
     */
    public ProjectOid(Long projectidProject) {
        this.projectidProject = projectidProject;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ProjectOid(List<Object> col) {
        this.projectidProject = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (projectidProject == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_Project attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getProjectidProject() {
        return projectidProject;
    }

    /**
     * Sets the value of id_Project attribute.
     * 
     * @param projectidProject the new value.
     */
    public void setProjectidProject(Long projectidProject) {
        this.projectidProject = projectidProject;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return projectidProject.hashCode();
        } catch (NullPointerException e) {
            return super.hashCode();
        }
    }

    /**
     * Says if the this object is the same object as <code>obj</code>.
     * 
     * @param obj object to compare this instance with.
     * @return true if the objects are the same object.
     */
    public boolean equals(Object obj) {
        boolean returnValue;
        if (obj == null) {
            returnValue = false;
        } else if (!(obj instanceof ProjectOid)) {
            returnValue = false;
        } else {
            ProjectOid oid = (ProjectOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.projectidProject, projectidProject);
            }
        }
        return returnValue;
    }

    /**
     * Returns a String representation of the instance's identifier.
     * 
     * @return String representing the object
     */
    public String toString() {
        return "[projectidProject=" + projectidProject + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = projectidProject;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = ProjectConstants.ATTR_NAME_PROJECTIDPROJECT;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[1];
        dataTypes[0] = Constants.Type.AUTONUMERIC.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return ProjectConstants.CLASS_NAME;
    }

    /**
     * Compare the value of the OID in the array of objects with this
     * 
     * @param instance array of objects with the values of the OID to compare this
     *                 instance with.
     * @return true if the objects are the same object.
     */
    public boolean compareToRS(Object[] instance) {
        boolean returnValue = true;
        boolean hasError = false;
        ProjectOid candidateOID = null;
        try {
            candidateOID = new ProjectOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ProjectOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ProjectOid temp;
        try {
            temp = mapper.readValue(jsonString, ProjectOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.projectidProject = temp.projectidProject;
        }
        return this;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            json = "";
        }
        return json;
    }
}
