package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines")
public class DSTemplateLines {

    @ApiModelProperty(name = "Line #")
    @JsonProperty("id")
    private Long dSTemplateLinesId;

    @ApiModelProperty(name = "Units")
    @JsonProperty("units")
    private Double dSTemplateLinesUnits;

    @ApiModelProperty(name = "Description")
    @JsonProperty("description")
    private String dSTemplateLinesDescription;

    @ApiModelProperty(name = "Price")
    @JsonProperty("price")
    private Double dSTemplateLinesPrice;

    @ApiModelProperty(name = "Line Total")
    @JsonProperty("totalline")
    private Double dSTemplateLinesTotalLine;

    public DSTemplateLines() {
    
    }
    
    public DSTemplateLines(ERLTemplate instance) {
        if (instance != null) {
            try {
                this.dSTemplateLinesId = instance.getERLTemplateid();
                this.dSTemplateLinesUnits = instance.getERLTemplateunits();
                this.dSTemplateLinesDescription = instance.getERLTemplatedescription();
                this.dSTemplateLinesPrice = instance.getERLTemplateprice();
                this.dSTemplateLinesTotalLine = instance.getERLTemplatetotalLine();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSTemplateLinesId() {
        return this.dSTemplateLinesId;
    }
    
    public void setDSTemplateLinesId(Long dSTemplateLinesId) {
        this.dSTemplateLinesId = dSTemplateLinesId;
    }

    public Double getDSTemplateLinesUnits() {
        return this.dSTemplateLinesUnits;
    }
    
    public void setDSTemplateLinesUnits(Double dSTemplateLinesUnits) {
        this.dSTemplateLinesUnits = dSTemplateLinesUnits;
    }

    public String getDSTemplateLinesDescription() {
        return this.dSTemplateLinesDescription;
    }
    
    public void setDSTemplateLinesDescription(String dSTemplateLinesDescription) {
        this.dSTemplateLinesDescription = dSTemplateLinesDescription;
    }

    public Double getDSTemplateLinesPrice() {
        return this.dSTemplateLinesPrice;
    }
    
    public void setDSTemplateLinesPrice(Double dSTemplateLinesPrice) {
        this.dSTemplateLinesPrice = dSTemplateLinesPrice;
    }

    public Double getDSTemplateLinesTotalLine() {
        return this.dSTemplateLinesTotalLine;
    }
    
    public void setDSTemplateLinesTotalLine(Double dSTemplateLinesTotalLine) {
        this.dSTemplateLinesTotalLine = dSTemplateLinesTotalLine;
    }
}
