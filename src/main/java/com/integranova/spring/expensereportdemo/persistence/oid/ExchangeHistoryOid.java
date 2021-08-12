package com.integranova.spring.expensereportdemo.persistence.oid;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import java.util.List;
import java.io.Serializable;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.integranova.spring.expensereportdemo.global.STDFunctions;

public class ExchangeHistoryOid implements IOid, Serializable {

    private static final long serialVersionUID = 1L;

    /** Identification function field CurrencyCode **/
    @JsonProperty(value = "currencycode")
    private String expenseCurrencyCurrencyCode;
    /** Identification function field entryDate **/
    @JsonProperty(value = "entrydate")
    private Date exchangeHistoryentryDate;

    /** Default constructor. **/
    public ExchangeHistoryOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param expenseCurrencyCurrencyCode value of the <code>expenseCurrencyCurrencyCode</code> attribute.
     * @param exchangeHistoryentryDate value of the <code>exchangeHistoryentryDate</code> attribute.
     */
    public ExchangeHistoryOid(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) {
        this.expenseCurrencyCurrencyCode = expenseCurrencyCurrencyCode;
        this.exchangeHistoryentryDate = exchangeHistoryentryDate;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ExchangeHistoryOid(List<Object> col) {
        this.expenseCurrencyCurrencyCode = (String) col.get(0);
        this.exchangeHistoryentryDate = (Date) col.get(1);
    }

    /**
     * Constructor that initializes the attributes values from the identifiers of the related instances.
     * @param expensecurrencyOID the OID of <code>ExpenseCurrency</code>
     * @param entryDate value of the <code>entryDate</code> attribute
     */
    public ExchangeHistoryOid(ExpenseCurrencyOid expensecurrencyOID, java.sql.Date entryDate) {
        this.expenseCurrencyCurrencyCode = expensecurrencyOID.getExpenseCurrencyCurrencyCode();
        this.exchangeHistoryentryDate = entryDate;
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (expenseCurrencyCurrencyCode == null || exchangeHistoryentryDate == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of CurrencyCode attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public String getExpenseCurrencyCurrencyCode() {
        return expenseCurrencyCurrencyCode;
    }

    /**
     * Sets the value of CurrencyCode attribute.
     * 
     * @param expenseCurrencyCurrencyCode the new value.
     */
    public void setExpenseCurrencyCurrencyCode(String expenseCurrencyCurrencyCode) {
        this.expenseCurrencyCurrencyCode = expenseCurrencyCurrencyCode;
    }
    /**
     * Gets the value of entryDate attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Date getExchangeHistoryentryDate() {
        return exchangeHistoryentryDate;
    }

    /**
     * Sets the value of entryDate attribute.
     * 
     * @param exchangeHistoryentryDate the new value.
     */
    public void setExchangeHistoryentryDate(Date exchangeHistoryentryDate) {
        this.exchangeHistoryentryDate = exchangeHistoryentryDate;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return expenseCurrencyCurrencyCode.hashCode() + exchangeHistoryentryDate.hashCode();
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
        } else if (!(obj instanceof ExchangeHistoryOid)) {
            returnValue = false;
        } else {
            ExchangeHistoryOid oid = (ExchangeHistoryOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.expenseCurrencyCurrencyCode, expenseCurrencyCurrencyCode) && Utilities.isEqual(oid.exchangeHistoryentryDate, exchangeHistoryentryDate);
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
        return "[expenseCurrencyCurrencyCode=" + expenseCurrencyCurrencyCode + ", exchangeHistoryentryDate=" + exchangeHistoryentryDate + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[2];
        values[0] = expenseCurrencyCurrencyCode;
        values[1] = exchangeHistoryentryDate;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[2];
        values[0] = ExchangeHistoryConstants.ATTR_NAME_EXPENSECURRENCY_EXPENSECURRENCYCURRENCYCODE;
        values[1] = ExchangeHistoryConstants.ATTR_NAME_EXCHANGEHISTORYENTRYDATE;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[2];
        dataTypes[0] = Constants.Type.STRING.getTypeName();
        dataTypes[1] = Constants.Type.DATE.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return ExchangeHistoryConstants.CLASS_NAME;
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
        ExchangeHistoryOid candidateOID = null;
        try {
            candidateOID = new ExchangeHistoryOid(STDFunctions.rightTrimFun((String) instance[0]), (Date) instance[1]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ExchangeHistoryOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ExchangeHistoryOid temp;
        try {
            temp = mapper.readValue(jsonString, ExchangeHistoryOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.expenseCurrencyCurrencyCode = temp.expenseCurrencyCurrencyCode;
            this.exchangeHistoryentryDate = temp.exchangeHistoryentryDate;
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
