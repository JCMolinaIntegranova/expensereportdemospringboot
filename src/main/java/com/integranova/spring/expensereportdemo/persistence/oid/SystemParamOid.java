package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.integranova.spring.expensereportdemo.global.STDFunctions;

public class SystemParamOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field paramCode **/
    @JsonProperty(value = "paramcode")
    private String systemParamparamCode;

    /** Default constructor. **/
    public SystemParamOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param systemParamparamCode value of the <code>systemParamparamCode</code> attribute.
     */
    public SystemParamOid(String systemParamparamCode) {
        this.systemParamparamCode = systemParamparamCode;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public SystemParamOid(List<Object> col) {
        this.systemParamparamCode = (String) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (systemParamparamCode == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of paramCode attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public String getSystemParamparamCode() {
        return systemParamparamCode;
    }

    /**
     * Sets the value of paramCode attribute.
     * 
     * @param systemParamparamCode the new value.
     */
    public void setSystemParamparamCode(String systemParamparamCode) {
        this.systemParamparamCode = systemParamparamCode;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return systemParamparamCode.hashCode();
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
        } else if (!(obj instanceof SystemParamOid)) {
            returnValue = false;
        } else {
            SystemParamOid oid = (SystemParamOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.systemParamparamCode, systemParamparamCode);
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
        return "[systemParamparamCode=" + systemParamparamCode + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = systemParamparamCode;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = SystemParamConstants.ATTR_NAME_SYSTEMPARAMPARAMCODE;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[1];
        dataTypes[0] = Constants.Type.STRING.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return SystemParamConstants.CLASS_NAME;
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
        SystemParamOid candidateOID = null;
        try {
            candidateOID = new SystemParamOid(STDFunctions.rightTrimFun((String) instance[0]));
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public SystemParamOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        SystemParamOid temp;
        try {
            temp = mapper.readValue(jsonString, SystemParamOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.systemParamparamCode = temp.systemParamparamCode;
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
