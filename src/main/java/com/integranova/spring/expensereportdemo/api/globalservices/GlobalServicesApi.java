package com.integranova.spring.expensereportdemo.api.globalservices;

import com.integranova.spring.expensereportdemo.service.GlobalServicesService;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest;
import com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/globalservicesApi")
@Api(value = "Global Services")
public class GlobalServicesApi {

    @Autowired
    GlobalServicesService service;

    @PostMapping(value = "/GLOBALTEST")
    @ApiOperation(value = "GLOBALTEST")
    public GLOBALTESTResponse gLOBALTEST(@RequestBody GLOBALTESTRequest request) {
        return service.gLOBALTEST(request);
    }

    @PostMapping(value = "/GLOBALTESTCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for GLOBALTEST")
    public GLOBALTESTResponse gLOBALTESTCheckPreconditions(@RequestBody GLOBALTESTRequest request) {
        return service.gLOBALTESTCheckPreconditions(request);
    }
}
