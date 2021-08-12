package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ERLTemplatePutViewModel {

    @JsonProperty(value="units")
    private Double eRLTemplateunits;

    @JsonProperty(value="price")
    private Double eRLTemplateprice;

    @JsonProperty(value="description")
    private String eRLTemplatedescription;

    public Double getERLTemplateunits() {
        return eRLTemplateunits;
    }
    
    public void setERLTemplateunits(Double eRLTemplateunits) {
        this.eRLTemplateunits = eRLTemplateunits;
    }

    public Double getERLTemplateprice() {
        return eRLTemplateprice;
    }
    
    public void setERLTemplateprice(Double eRLTemplateprice) {
        this.eRLTemplateprice = eRLTemplateprice;
    }

    public String getERLTemplatedescription() {
        return eRLTemplatedescription;
    }
    
    public void setERLTemplatedescription(String eRLTemplatedescription) {
        this.eRLTemplatedescription = eRLTemplatedescription;
    }
}
