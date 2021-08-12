package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrname")
    private String eRTemplatecreateinstancepatrname;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrdescription")
    private String eRTemplatecreateinstancepatrdescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplatecreateinstancepatrname();
    }

    @JsonIgnore
    public String getERTemplatecreateinstancepatrname() {
        return this.eRTemplatecreateinstancepatrname;
    }
    
    public void setERTemplatecreateinstancepatrname(String eRTemplatecreateinstancepatrname) {
        this.eRTemplatecreateinstancepatrname = eRTemplatecreateinstancepatrname;
    }

    private void checkERTemplatecreateinstancepatrname() throws NotNullArgumentException {
        if(this.getERTemplatecreateinstancepatrname() == null) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_CREATEINSTANCE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRNAME, ERTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERTEMPLATECREATEINSTANCEPATRNAME);
        }
    }

    @JsonIgnore
    public String getERTemplatecreateinstancepatrdescription() {
        return this.eRTemplatecreateinstancepatrdescription;
    }
    
    public void setERTemplatecreateinstancepatrdescription(String eRTemplatecreateinstancepatrdescription) {
        this.eRTemplatecreateinstancepatrdescription = eRTemplatecreateinstancepatrdescription;
    }
}
