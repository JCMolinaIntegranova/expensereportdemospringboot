package com.integranova.spring.expensereportdemo.api.ertemplate;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.service.ERTemplateService;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud.ERTemplatePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud.ERTemplatePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest;
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
@RequestMapping("/api/ERTemplateApi")
@Api(value = "ERTemplate")
public class ERTemplateApi {

    @Autowired
    ERTemplateService service;

    @GetMapping(value="/")
    public List<ERTemplate> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{eRTemplateid}")
    public ERTemplate getInstance(Long eRTemplateid) {
    	return service.getById(eRTemplateid);
    }

    @PostMapping(value="/")
    public ERTemplate postInstance(@RequestBody ERTemplatePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{eRTemplateid}")
    public ERTemplate putInstance(Long eRTemplateid, @RequestBody ERTemplatePutViewModel payload) throws ModelException {
    	return service.put(eRTemplateid, payload);
    }
    
    @DeleteMapping(value="/{eRTemplateid}")
    public void deleteInstance(Long eRTemplateid) throws ModelException {
    	service.delete(eRTemplateid);
    }

    @PostMapping(value = "/GetDSERTemplates")
    @ApiOperation(value = "Returns displayset DSERTemplates for an instance of ERTemplate")
    public DSERTemplates getDSERTemplates(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSERTemplates(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetERTemplate")
    @ApiOperation(value = "Returns an instance of ERTemplate", hidden = true)
    public ERTemplate getERTemplate(Long eRTemplateid) {
        return service.getById(eRTemplateid);
    }
    
    @PostMapping(value = "/GetERTemplateDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getERTemplateDynamic(@RequestBody QueryRequest request) {
        ERTemplateOid oid = new ERTemplateOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getERTemplateDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getERTemplateWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getERTemplatePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "ERTemplate's creation event")
    public ServiceResponse eRTemplateCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "ERTemplate's destruction event")
    public ServiceResponse eRTemplateDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ERTemplate's change event")
    public ServiceResponse eRTemplateEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/editName")
    @ApiOperation(value = "editName")
    public ServiceResponse eRTemplateEditName(@RequestBody EditNameRequest request) {
        return service.editName(request);
    }
    

    @PostMapping(value = "/editDescription")
    @ApiOperation(value = "editDescription")
    public ServiceResponse eRTemplateEditDescription(@RequestBody EditDescriptionRequest request) {
        return service.editDescription(request);
    }
    

    @PostMapping(value = "/clearName")
    @ApiOperation(value = "clearName")
    public ServiceResponse eRTemplateClearName(@RequestBody ClearNameRequest request) {
        return service.clearName(request);
    }
    

    @PostMapping(value = "/clearDescription")
    @ApiOperation(value = "clearDescription")
    public ServiceResponse eRTemplateClearDescription(@RequestBody ClearDescriptionRequest request) {
        return service.clearDescription(request);
    }
    

    @PostMapping(value = "/enable")
    @ApiOperation(value = "Activate")
    public ServiceResponse eRTemplateEnable(@RequestBody EnableRequest request) {
        return service.enable(request);
    }
    

    @PostMapping(value = "/disable")
    @ApiOperation(value = "Activate")
    public ServiceResponse eRTemplateDisable(@RequestBody DisableRequest request) {
        return service.disable(request);
    }
    

    @PostMapping(value = "/assignTemplateToProject")
    @ApiOperation(value = "assignTemplateToProject")
    public ServiceResponse eRTemplateAssignTemplateToProject(@RequestBody AssignTemplateToProjectRequest request) {
        return service.assignTemplateToProject(request);
    }
    

    @PostMapping(value = "/deassignTemplate")
    @ApiOperation(value = "deassignTemplate")
    public ServiceResponse eRTemplateDeassignTemplate(@RequestBody DeassignTemplateRequest request) {
        return service.deassignTemplate(request);
    }
    


    @PostMapping(value = "/PIUERTemplates")
    @ApiOperation(value = "Expense Report Templates")
    public PIUERTemplatesResponse piuPIUERTemplates(@RequestBody PIUERTemplatesRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUERTemplatesResponse response;
        try
        {
            response = new PIUERTemplatesResponse(service.piuPIUERTemplates(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUERTemplates(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUERTemplatesResponse();
            response.setException(e);
        }
        return response;
    }

}
