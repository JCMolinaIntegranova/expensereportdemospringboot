package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest")
public class NewlineRequest {

    @ApiModelProperty(name = "Expense Type")
    @JsonProperty("p_agrexpensetype_json")
    private String expenseLinenewlinepagrExpenseType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseType expenseLinenewlinepagrExpenseTypeInstance;

    @ApiModelProperty(name = "ExpenseReport")
    @JsonProperty("p_agrexpensereport_oid")
    private ExpenseReportOid expenseLinenewlinepagrExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseLinenewlinepagrExpenseReportInstance;

    @ApiModelProperty(name = "Quantity")
    @JsonProperty("p_atrunits")
    private Double expenseLinenewlinepatrUnits;

    @ApiModelProperty(name = "Price")
    @JsonProperty("p_atrprice")
    private Double expenseLinenewlinepatrPrice;

    @ApiModelProperty(name = "Date")
    @JsonProperty("p_atrexpensedate")
    private Date expenseLinenewlinepatrExpenseDate;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrlndescription")
    private String expenseLinenewlinepatrLnDescription;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseLinenewlinepagrExpenseType();
        checkExpenseLinenewlinepagrExpenseReport();
        checkExpenseLinenewlinepatrUnits();
        checkExpenseLinenewlinepatrPrice();
        checkExpenseLinenewlinepatrExpenseDate();
        checkExpenseLinenewlinepatrLnDescription();
    }

    @JsonIgnore
    public String getExpenseLinenewlinepagrExpenseType() {
        return this.expenseLinenewlinepagrExpenseType;
    }
    
    public void setExpenseLinenewlinepagrExpenseType(String expenseLinenewlinepagrExpenseType) {
        this.expenseLinenewlinepagrExpenseType = expenseLinenewlinepagrExpenseType;
    }

    @JsonIgnore
    public ExpenseType getExpenseLinenewlinepagrExpenseTypeInstance() {
        return this.expenseLinenewlinepagrExpenseTypeInstance;
    }
    
    public void setExpenseLinenewlinepagrExpenseTypeInstance(ExpenseType expenseLinenewlinepagrExpenseType) {
        this.expenseLinenewlinepagrExpenseTypeInstance = expenseLinenewlinepagrExpenseType;
    }

    private void checkExpenseLinenewlinepagrExpenseType() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepagrExpenseTypeInstance() == null || this.getExpenseLinenewlinepagrExpenseTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPAGREXPENSETYPE, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPAGREXPENSETYPE);
        }
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseLinenewlinepagrExpenseReport() {
        return this.expenseLinenewlinepagrExpenseReport;
    }
    
    public void setExpenseLinenewlinepagrExpenseReport(ExpenseReportOid expenseLinenewlinepagrExpenseReport) {
        this.expenseLinenewlinepagrExpenseReport = expenseLinenewlinepagrExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseLinenewlinepagrExpenseReportInstance() {
        return this.expenseLinenewlinepagrExpenseReportInstance;
    }
    
    public void setExpenseLinenewlinepagrExpenseReportInstance(ExpenseReport expenseLinenewlinepagrExpenseReport) {
        this.expenseLinenewlinepagrExpenseReportInstance = expenseLinenewlinepagrExpenseReport;
    }

    private void checkExpenseLinenewlinepagrExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepagrExpenseReportInstance() == null || this.getExpenseLinenewlinepagrExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPAGREXPENSEREPORT, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPAGREXPENSEREPORT);
        }
    }

    @JsonIgnore
    public Double getExpenseLinenewlinepatrUnits() {
        return this.expenseLinenewlinepatrUnits;
    }
    
    public void setExpenseLinenewlinepatrUnits(Double expenseLinenewlinepatrUnits) {
        this.expenseLinenewlinepatrUnits = expenseLinenewlinepatrUnits;
    }

    private void checkExpenseLinenewlinepatrUnits() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepatrUnits() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRUNITS, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRUNITS);
        }
    }

    @JsonIgnore
    public Double getExpenseLinenewlinepatrPrice() {
        return this.expenseLinenewlinepatrPrice;
    }
    
    public void setExpenseLinenewlinepatrPrice(Double expenseLinenewlinepatrPrice) {
        this.expenseLinenewlinepatrPrice = expenseLinenewlinepatrPrice;
    }

    private void checkExpenseLinenewlinepatrPrice() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepatrPrice() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRPRICE, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRPRICE);
        }
    }

    @JsonIgnore
    public Date getExpenseLinenewlinepatrExpenseDate() {
        return this.expenseLinenewlinepatrExpenseDate;
    }
    
    public void setExpenseLinenewlinepatrExpenseDate(Date expenseLinenewlinepatrExpenseDate) {
        this.expenseLinenewlinepatrExpenseDate = expenseLinenewlinepatrExpenseDate;
    }

    private void checkExpenseLinenewlinepatrExpenseDate() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepatrExpenseDate() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPATREXPENSEDATE, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATREXPENSEDATE);
        }
    }

    @JsonIgnore
    public String getExpenseLinenewlinepatrLnDescription() {
        return this.expenseLinenewlinepatrLnDescription;
    }
    
    public void setExpenseLinenewlinepatrLnDescription(String expenseLinenewlinepatrLnDescription) {
        this.expenseLinenewlinepatrLnDescription = expenseLinenewlinepatrLnDescription;
    }

    private void checkExpenseLinenewlinepatrLnDescription() throws NotNullArgumentException {
        if(this.getExpenseLinenewlinepatrLnDescription() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_NEWLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_NEWLINE_EXPENSELINENEWLINEPATRLNDESCRIPTION, ExpenseLineConstants.SERV_ALIAS_NEWLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_NEWLINE_EXPENSELINENEWLINEPATRLNDESCRIPTION);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
