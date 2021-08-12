package com.integranova.spring.expensereportdemo.api.systemparam;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.service.SystemParamService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.crud.SystemParamPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.crud.SystemParamPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.piu.PIUSystemParamsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest;
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
@RequestMapping("/api/SystemParamApi")
@Api(value = "SystemParam")
public class SystemParamApi {

    @Autowired
    SystemParamService service;

    @GetMapping(value="/")
    public List<SystemParam> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{systemParamparamCode}")
    public SystemParam getInstance(String systemParamparamCode) {
    	return service.getById(systemParamparamCode);
    }

    @PostMapping(value="/")
    public SystemParam postInstance(@RequestBody SystemParamPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{systemParamparamCode}")
    public SystemParam putInstance(String systemParamparamCode, @RequestBody SystemParamPutViewModel payload) throws ModelException {
    	return service.put(systemParamparamCode, payload);
    }
    
    @DeleteMapping(value="/{systemParamparamCode}")
    public void deleteInstance(String systemParamparamCode) throws ModelException {
    	service.delete(systemParamparamCode);
    }

    @PostMapping(value = "/GetDSSystemParams")
    @ApiOperation(value = "Returns displayset DSSystemParams for an instance of SystemParam")
    public DSSystemParams getDSSystemParams(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSSystemParams(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetSystemParam")
    @ApiOperation(value = "Returns an instance of SystemParam", hidden = true)
    public SystemParam getSystemParam(String systemParamparamCode) {
        return service.getById(systemParamparamCode);
    }
    
    @PostMapping(value = "/GetSystemParamDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getSystemParamDynamic(@RequestBody QueryRequest request) {
        SystemParamOid oid = new SystemParamOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getSystemParamDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getSystemParamWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getSystemParamPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "SystemParam's creation event")
    public ServiceResponse systemParamCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "SystemParam's destruction event")
    public ServiceResponse systemParamDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "SystemParam's change event")
    public ServiceResponse systemParamEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    


    @PostMapping(value = "/PIUSystemParams")
    @ApiOperation(value = "System Parameters")
    public PIUSystemParamsResponse piuPIUSystemParams(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUSystemParamsResponse response;
        try
        {
            response = new PIUSystemParamsResponse(service.piuPIUSystemParams(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUSystemParams(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUSystemParamsResponse();
            response.setException(e);
        }
        return response;
    }

}
