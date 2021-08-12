package com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine")
public class DSExpenseLine {

    @ApiModelProperty(name = "Nº Line")
    @JsonProperty("idexpenseline")
    private Long dSExpenseLineIdExpenseLine;

    @ApiModelProperty(name = "Date")
    @JsonProperty("expensedate")
    private Date dSExpenseLineExpenseDate;

    @ApiModelProperty(name = "Description")
    @JsonProperty("lndescription")
    private String dSExpenseLineLnDescription;

    @ApiModelProperty(name = "Price")
    @JsonProperty("price")
    private Double dSExpenseLinePrice;

    @ApiModelProperty(name = "Qty")
    @JsonProperty("units")
    private Double dSExpenseLineUnits;

    @ApiModelProperty(name = "Total")
    @JsonProperty("totalline")
    private Double dSExpenseLineTotalLine;

    @ApiModelProperty(name = "Total (Currency)")
    @JsonProperty("totallinecurr")
    private Double dSExpenseLineTotalLineCurr;

    public DSExpenseLine() {
    
    }
    
    public DSExpenseLine(ExpenseLine instance) {
        if (instance != null) {
            try {
                this.dSExpenseLineIdExpenseLine = instance.getExpenseLineidExpenseLine();
                this.dSExpenseLineExpenseDate = instance.getExpenseLineExpenseDate();
                this.dSExpenseLineLnDescription = instance.getExpenseLineLnDescription();
                this.dSExpenseLinePrice = instance.getExpenseLinePrice();
                this.dSExpenseLineUnits = instance.getExpenseLineUnits();
                this.dSExpenseLineTotalLine = instance.getExpenseLineTotalLine();
                this.dSExpenseLineTotalLineCurr = instance.getExpenseLineTotalLineCurr();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSExpenseLineIdExpenseLine() {
        return this.dSExpenseLineIdExpenseLine;
    }
    
    public void setDSExpenseLineIdExpenseLine(Long dSExpenseLineIdExpenseLine) {
        this.dSExpenseLineIdExpenseLine = dSExpenseLineIdExpenseLine;
    }

    public Date getDSExpenseLineExpenseDate() {
        return this.dSExpenseLineExpenseDate;
    }
    
    public void setDSExpenseLineExpenseDate(Date dSExpenseLineExpenseDate) {
        this.dSExpenseLineExpenseDate = dSExpenseLineExpenseDate;
    }

    public String getDSExpenseLineLnDescription() {
        return this.dSExpenseLineLnDescription;
    }
    
    public void setDSExpenseLineLnDescription(String dSExpenseLineLnDescription) {
        this.dSExpenseLineLnDescription = dSExpenseLineLnDescription;
    }

    public Double getDSExpenseLinePrice() {
        return this.dSExpenseLinePrice;
    }
    
    public void setDSExpenseLinePrice(Double dSExpenseLinePrice) {
        this.dSExpenseLinePrice = dSExpenseLinePrice;
    }

    public Double getDSExpenseLineUnits() {
        return this.dSExpenseLineUnits;
    }
    
    public void setDSExpenseLineUnits(Double dSExpenseLineUnits) {
        this.dSExpenseLineUnits = dSExpenseLineUnits;
    }

    public Double getDSExpenseLineTotalLine() {
        return this.dSExpenseLineTotalLine;
    }
    
    public void setDSExpenseLineTotalLine(Double dSExpenseLineTotalLine) {
        this.dSExpenseLineTotalLine = dSExpenseLineTotalLine;
    }

    public Double getDSExpenseLineTotalLineCurr() {
        return this.dSExpenseLineTotalLineCurr;
    }
    
    public void setDSExpenseLineTotalLineCurr(Double dSExpenseLineTotalLineCurr) {
        this.dSExpenseLineTotalLineCurr = dSExpenseLineTotalLineCurr;
    }
}
