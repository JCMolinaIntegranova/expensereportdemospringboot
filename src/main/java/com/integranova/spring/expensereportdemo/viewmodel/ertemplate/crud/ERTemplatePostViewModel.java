package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ERTemplatePostViewModel {

    @JsonProperty(value="name")
    private String eRTemplatename;

    @JsonProperty(value="description")
    private String eRTemplatedescription;

    public String getERTemplatename() {
        return eRTemplatename;
    }
    
    public void setERTemplatename(String eRTemplatename) {
        this.eRTemplatename = eRTemplatename;
    }

    public String getERTemplatedescription() {
        return eRTemplatedescription;
    }
    
    public void setERTemplatedescription(String eRTemplatedescription) {
        this.eRTemplatedescription = eRTemplatedescription;
    }
}
