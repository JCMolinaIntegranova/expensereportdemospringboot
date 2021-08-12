package com.integranova.spring.expensereportdemo.api.appuser;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.service.AppUserService;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.crud.AppUserPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.crud.AppUserPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersResponse;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
@RequestMapping("/api/AppUserApi")
@Api(value = "AppUser")
public class AppUserApi {

    @Autowired
    AppUserService service;

    @GetMapping(value="/")
    public List<AppUser> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{appUserLogin}")
    public AppUser getInstance(String appUserLogin) {
    	return service.getById(appUserLogin);
    }

    @PostMapping(value="/")
    public AppUser postInstance(@RequestBody AppUserPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{appUserLogin}")
    public AppUser putInstance(String appUserLogin, @RequestBody AppUserPutViewModel payload) throws ModelException {
    	return service.put(appUserLogin, payload);
    }
    
    @DeleteMapping(value="/{appUserLogin}")
    public void deleteInstance(String appUserLogin) throws ModelException {
    	service.delete(appUserLogin);
    }

    @PostMapping(value = "/GetDSAppUsers")
    @ApiOperation(value = "Returns displayset DSAppUsers for an instance of AppUser")
    public DSAppUsers getDSAppUsers(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSAppUsers(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetAppUser")
    @ApiOperation(value = "Returns an instance of AppUser", hidden = true)
    public AppUser getAppUser(String appUserLogin) {
        return service.getById(appUserLogin);
    }
    
    @PostMapping(value = "/GetAppUserDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getAppUserDynamic(@RequestBody QueryRequest request) {
        AppUserOid oid = new AppUserOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAppUserDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getAppUserWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getAppUserPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/newUser")
    @ApiOperation(value = "New User")
    public ServiceResponse appUserNewUser(@RequestBody NewUserRequest request) {
        return service.newUser(request);
    }
    

    @PostMapping(value = "/deleteUser")
    @ApiOperation(value = "Delete User")
    public ServiceResponse appUserDeleteUser(@RequestBody DeleteUserRequest request) {
        return service.deleteUser(request);
    }
    

    @PostMapping(value = "/editUser")
    @ApiOperation(value = "AppUser's change event")
    public ServiceResponse appUserEditUser(@RequestBody EditUserRequest request) {
        return service.editUser(request);
    }
    

    @PostMapping(value = "/setPassword")
    @ApiOperation(value = "Password event")
    public ServiceResponse appUserSetPassword(@RequestBody SetPasswordRequest request) {
        return service.setPassword(request);
    }
    

    @PostMapping(value = "/TNEWUSER")
    @ApiOperation(value = "New User")
    public ServiceResponse appUserTNEWUSER(@RequestBody TNEWUSERRequest request) {
        return service.tNEWUSER(request);
    }
    

    @PostMapping(value = "/TEDITUSER")
    @ApiOperation(value = "Edit User")
    public ServiceResponse appUserTEDITUSER(@RequestBody TEDITUSERRequest request) {
        return service.tEDITUSER(request);
    }
    

    @PostMapping(value = "/TDELETE")
    @ApiOperation(value = "Delete User")
    public ServiceResponse appUserTDELETE(@RequestBody TDELETERequest request) {
        return service.tDELETE(request);
    }
    


    @PostMapping(value = "/PIU_AppUsers")
    @ApiOperation(value = "Users")
    public PIUAppUsersResponse piuPIUAppUsers(@RequestBody PIUAppUsersRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAppUsersResponse response;
        try
        {
            response = new PIUAppUsersResponse(service.piuPIUAppUsers(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAppUsers(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAppUsersResponse();
            response.setException(e);
        }
        return response;
    }

}
