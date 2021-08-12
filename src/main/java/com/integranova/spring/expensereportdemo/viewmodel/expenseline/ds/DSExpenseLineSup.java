package com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup")
public class DSExpenseLineSup {

    @ApiModelProperty(name = "Date")
    @JsonProperty("expensedate")
    private Date dSExpenseLineSupExpenseDate;

    @ApiModelProperty(name = "Total Line")
    @JsonProperty("totalline")
    private Double dSExpenseLineSupTotalLine;

    public DSExpenseLineSup() {
    
    }
    
    public DSExpenseLineSup(ExpenseLine instance) {
        if (instance != null) {
            try {
                this.dSExpenseLineSupExpenseDate = instance.getExpenseLineExpenseDate();
                this.dSExpenseLineSupTotalLine = instance.getExpenseLineTotalLine();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Date getDSExpenseLineSupExpenseDate() {
        return this.dSExpenseLineSupExpenseDate;
    }
    
    public void setDSExpenseLineSupExpenseDate(Date dSExpenseLineSupExpenseDate) {
        this.dSExpenseLineSupExpenseDate = dSExpenseLineSupExpenseDate;
    }

    public Double getDSExpenseLineSupTotalLine() {
        return this.dSExpenseLineSupTotalLine;
    }
    
    public void setDSExpenseLineSupTotalLine(Double dSExpenseLineSupTotalLine) {
        this.dSExpenseLineSupTotalLine = dSExpenseLineSupTotalLine;
    }
}
