package com.integranova.spring.expensereportdemo.api.adminuser;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.service.AdminUserService;
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
@RequestMapping("/api/AdminUserApi")
@Api(value = "AdminUser")
public class AdminUserApi {

    @Autowired
    AdminUserService service;

    @GetMapping(value="/")
    public List<AdminUser> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{appUserLogin}")
    public AdminUser getInstance(String appUserLogin) {
    	return service.getById(appUserLogin);
    }
    
    @DeleteMapping(value="/{appUserLogin}")
    public void deleteInstance(String appUserLogin) throws ModelException {
    	service.delete(appUserLogin);
    }

    @GetMapping(value = "/GetAdminUser")
    @ApiOperation(value = "Returns an instance of AdminUser", hidden = true)
    public AdminUser getAdminUser(String appUserLogin) {
        return service.getById(appUserLogin);
    }
    
    @PostMapping(value = "/GetAdminUserDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getAdminUserDynamic(@RequestBody QueryRequest request) {
        AdminUserOid oid = new AdminUserOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAdminUserDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getAdminUserWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getAdminUserPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }




}
