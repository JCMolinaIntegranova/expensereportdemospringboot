package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates")
public class DSERTemplates {

    @ApiModelProperty(name = "ID")
    @JsonProperty("id")
    private Long dSERTemplatesId;

    @ApiModelProperty(name = "Name")
    @JsonProperty("name")
    private String dSERTemplatesName;

    @ApiModelProperty(name = "Enabled?")
    @JsonProperty("enabled")
    private Boolean dSERTemplatesEnabled;

    @ApiModelProperty(name = "Total")
    @JsonProperty("total")
    private Double dSERTemplatesTotal;

    @ApiModelProperty(name = "Description")
    @JsonProperty("description")
    private String dSERTemplatesDescription;

    public DSERTemplates() {
    
    }
    
    public DSERTemplates(ERTemplate instance) {
        if (instance != null) {
            try {
                this.dSERTemplatesId = instance.getERTemplateid();
                this.dSERTemplatesName = instance.getERTemplatename();
                this.dSERTemplatesEnabled = instance.getERTemplateenabled();
                this.dSERTemplatesTotal = instance.getERTemplatetotal();
                this.dSERTemplatesDescription = instance.getERTemplatedescription();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSERTemplatesId() {
        return this.dSERTemplatesId;
    }
    
    public void setDSERTemplatesId(Long dSERTemplatesId) {
        this.dSERTemplatesId = dSERTemplatesId;
    }

    public String getDSERTemplatesName() {
        return this.dSERTemplatesName;
    }
    
    public void setDSERTemplatesName(String dSERTemplatesName) {
        this.dSERTemplatesName = dSERTemplatesName;
    }

    public Boolean getDSERTemplatesEnabled() {
        return this.dSERTemplatesEnabled;
    }
    
    public void setDSERTemplatesEnabled(Boolean dSERTemplatesEnabled) {
        this.dSERTemplatesEnabled = dSERTemplatesEnabled;
    }

    public Double getDSERTemplatesTotal() {
        return this.dSERTemplatesTotal;
    }
    
    public void setDSERTemplatesTotal(Double dSERTemplatesTotal) {
        this.dSERTemplatesTotal = dSERTemplatesTotal;
    }

    public String getDSERTemplatesDescription() {
        return this.dSERTemplatesDescription;
    }
    
    public void setDSERTemplatesDescription(String dSERTemplatesDescription) {
        this.dSERTemplatesDescription = dSERTemplatesDescription;
    }
}
