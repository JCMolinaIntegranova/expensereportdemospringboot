package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.integranova.spring.expensereportdemo.global.STDFunctions;

public class EmployeeOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_Employee **/
    @JsonProperty(value = "id_employee")
    private String employeeidEmployee;

    /** Default constructor. **/
    public EmployeeOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param employeeidEmployee value of the <code>employeeidEmployee</code> attribute.
     */
    public EmployeeOid(String employeeidEmployee) {
        this.employeeidEmployee = employeeidEmployee;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public EmployeeOid(List<Object> col) {
        this.employeeidEmployee = (String) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (employeeidEmployee == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_Employee attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public String getEmployeeidEmployee() {
        return employeeidEmployee;
    }

    /**
     * Sets the value of id_Employee attribute.
     * 
     * @param employeeidEmployee the new value.
     */
    public void setEmployeeidEmployee(String employeeidEmployee) {
        this.employeeidEmployee = employeeidEmployee;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return employeeidEmployee.hashCode();
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
        } else if (!(obj instanceof EmployeeOid)) {
            returnValue = false;
        } else {
            EmployeeOid oid = (EmployeeOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.employeeidEmployee, employeeidEmployee);
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
        return "[employeeidEmployee=" + employeeidEmployee + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = employeeidEmployee;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = EmployeeConstants.ATTR_NAME_EMPLOYEEIDEMPLOYEE;
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
        return EmployeeConstants.CLASS_NAME;
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
        EmployeeOid candidateOID = null;
        try {
            candidateOID = new EmployeeOid(STDFunctions.rightTrimFun((String) instance[0]));
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public EmployeeOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        EmployeeOid temp;
        try {
            temp = mapper.readValue(jsonString, EmployeeOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.employeeidEmployee = temp.employeeidEmployee;
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
