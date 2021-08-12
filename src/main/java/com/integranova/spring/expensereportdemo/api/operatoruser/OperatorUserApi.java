package com.integranova.spring.expensereportdemo.api.operatoruser;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.service.OperatorUserService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/OperatorUserApi")
@Api(value = "OperatorUser")
public class OperatorUserApi {

    @Autowired
    OperatorUserService service;

    @GetMapping(value="/")
    public List<OperatorUser> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{appUserLogin}")
    public OperatorUser getInstance(String appUserLogin) {
    	return service.getById(appUserLogin);
    }
    
    @DeleteMapping(value="/{appUserLogin}")
    public void deleteInstance(String appUserLogin) throws ModelException {
    	service.delete(appUserLogin);
    }

    @GetMapping(value = "/GetOperatorUser")
    @ApiOperation(value = "Returns an instance of OperatorUser", hidden = true)
    public OperatorUser getOperatorUser(String appUserLogin) {
        return service.getById(appUserLogin);
    }
    
    @PostMapping(value = "/GetOperatorUserDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getOperatorUserDynamic(@RequestBody QueryRequest request) {
        OperatorUserOid oid = new OperatorUserOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getOperatorUserDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getOperatorUserWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getOperatorUserPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }




}
