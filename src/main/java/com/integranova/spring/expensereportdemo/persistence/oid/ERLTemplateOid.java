package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ERLTemplateOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field id **/
    @JsonProperty(value = "template_id")
    private Long eRTemplateTemplateid;
    /** Identification function field id **/
    @JsonProperty(value = "id")
    private Long eRLTemplateid;

    /** Default constructor. **/
    public ERLTemplateOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param eRTemplateTemplateid value of the <code>eRTemplateTemplateid</code> attribute.
     * @param eRLTemplateid value of the <code>eRLTemplateid</code> attribute.
     */
    public ERLTemplateOid(Long eRTemplateTemplateid, Long eRLTemplateid) {
        this.eRTemplateTemplateid = eRTemplateTemplateid;
        this.eRLTemplateid = eRLTemplateid;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ERLTemplateOid(List<Object> col) {
        this.eRTemplateTemplateid = (Long) col.get(0);
        this.eRLTemplateid = (Long) col.get(1);
    }

    /**
     * Constructor that initializes the attributes values from the identifiers of the related instances.
     * @param templateOID the OID of <code>ERTemplate</code>
     * @param id value of the <code>id</code> attribute
     */
    public ERLTemplateOid(ERTemplateOid templateOID, java.lang.Long id) {
        this.eRTemplateTemplateid = templateOID.getERTemplateid();
        this.eRLTemplateid = id;
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (eRTemplateTemplateid == null || eRLTemplateid == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getERTemplateTemplateid() {
        return eRTemplateTemplateid;
    }

    /**
     * Sets the value of id attribute.
     * 
     * @param eRTemplateTemplateid the new value.
     */
    public void setERTemplateTemplateid(Long eRTemplateTemplateid) {
        this.eRTemplateTemplateid = eRTemplateTemplateid;
    }
    /**
     * Gets the value of id attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getERLTemplateid() {
        return eRLTemplateid;
    }

    /**
     * Sets the value of id attribute.
     * 
     * @param eRLTemplateid the new value.
     */
    public void setERLTemplateid(Long eRLTemplateid) {
        this.eRLTemplateid = eRLTemplateid;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return eRTemplateTemplateid.hashCode() + eRLTemplateid.hashCode();
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
        } else if (!(obj instanceof ERLTemplateOid)) {
            returnValue = false;
        } else {
            ERLTemplateOid oid = (ERLTemplateOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.eRTemplateTemplateid, eRTemplateTemplateid) && Utilities.isEqual(oid.eRLTemplateid, eRLTemplateid);
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
        return "[eRTemplateTemplateid=" + eRTemplateTemplateid + ", eRLTemplateid=" + eRLTemplateid + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[2];
        values[0] = eRTemplateTemplateid;
        values[1] = eRLTemplateid;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[2];
        values[0] = ERLTemplateConstants.ATTR_NAME_TEMPLATE_ERTEMPLATEID;
        values[1] = ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEID;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[2];
        dataTypes[0] = Constants.Type.AUTONUMERIC.getTypeName();
        dataTypes[1] = Constants.Type.AUTONUMERIC.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return ERLTemplateConstants.CLASS_NAME;
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
        ERLTemplateOid candidateOID = null;
        try {
            candidateOID = new ERLTemplateOid((Long) instance[0], (Long) instance[1]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ERLTemplateOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ERLTemplateOid temp;
        try {
            temp = mapper.readValue(jsonString, ERLTemplateOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.eRTemplateTemplateid = temp.eRTemplateTemplateid;
            this.eRLTemplateid = temp.eRLTemplateid;
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
