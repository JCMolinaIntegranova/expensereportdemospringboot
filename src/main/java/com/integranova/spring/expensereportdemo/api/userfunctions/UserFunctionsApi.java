package com.integranova.spring.expensereportdemo.api.userfunctions;

import com.integranova.spring.expensereportdemo.global.UserFunctions;
import com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/UserFunctionsApi")
@Api(value = "User Functions")
public class UserFunctionsApi {

    @Autowired
    UserFunctions service;

    @PostMapping(value = "/getEmployeeByName")
    @ApiOperation(value = "getEmployeeByName")
    public GetEmployeeByNameResponse getEmployeeByName(@RequestBody GetEmployeeByNameRequest request) {
        Map<String, Object> outArgs = new HashMap<>();
        return new GetEmployeeByNameResponse(service.getEmployeeByNameFun(request, outArgs).getOid(), outArgs);
    }
}
