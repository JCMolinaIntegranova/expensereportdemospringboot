package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ERTemplateOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field id **/
    @JsonProperty(value = "id")
    private Long eRTemplateid;

    /** Default constructor. **/
    public ERTemplateOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param eRTemplateid value of the <code>eRTemplateid</code> attribute.
     */
    public ERTemplateOid(Long eRTemplateid) {
        this.eRTemplateid = eRTemplateid;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ERTemplateOid(List<Object> col) {
        this.eRTemplateid = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (eRTemplateid == null)
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
    public Long getERTemplateid() {
        return eRTemplateid;
    }

    /**
     * Sets the value of id attribute.
     * 
     * @param eRTemplateid the new value.
     */
    public void setERTemplateid(Long eRTemplateid) {
        this.eRTemplateid = eRTemplateid;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return eRTemplateid.hashCode();
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
        } else if (!(obj instanceof ERTemplateOid)) {
            returnValue = false;
        } else {
            ERTemplateOid oid = (ERTemplateOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.eRTemplateid, eRTemplateid);
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
        return "[eRTemplateid=" + eRTemplateid + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = eRTemplateid;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = ERTemplateConstants.ATTR_NAME_ERTEMPLATEID;
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
        return ERTemplateConstants.CLASS_NAME;
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
        ERTemplateOid candidateOID = null;
        try {
            candidateOID = new ERTemplateOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ERTemplateOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ERTemplateOid temp;
        try {
            temp = mapper.readValue(jsonString, ERTemplateOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.eRTemplateid = temp.eRTemplateid;
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
