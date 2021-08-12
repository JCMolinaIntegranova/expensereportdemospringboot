package com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse")
public class GLOBALTESTResponse extends ServiceResponse {

    @ApiModelProperty(name = "Result Code")
    @JsonProperty("psresultcode")
    private String gLOBALTESTpsResultCode;

    public GLOBALTESTResponse() {
        super();
    }

    @JsonIgnore
    public String getGLOBALTESTpsResultCode() {
        return this.gLOBALTESTpsResultCode;
    }
    
    public void setGLOBALTESTpsResultCode(String gLOBALTESTpsResultCode) {
        this.gLOBALTESTpsResultCode = gLOBALTESTpsResultCode;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("gLOBALTESTpsResultCode", gLOBALTESTpsResultCode);
        return outArgs;
    }
}
