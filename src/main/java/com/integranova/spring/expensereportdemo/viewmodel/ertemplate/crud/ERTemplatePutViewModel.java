package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ERTemplatePutViewModel {

    @JsonProperty(value="name")
    private String eRTemplatename;

    @JsonProperty(value="description")
    private String eRTemplatedescription;

    @JsonProperty(value="enabled")
    private Boolean eRTemplateenabled;

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

    public Boolean getERTemplateenabled() {
        return eRTemplateenabled;
    }
    
    public void setERTemplateenabled(Boolean eRTemplateenabled) {
        this.eRTemplateenabled = eRTemplateenabled;
    }
}
