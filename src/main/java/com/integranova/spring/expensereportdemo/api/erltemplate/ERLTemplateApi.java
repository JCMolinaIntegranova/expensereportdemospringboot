package com.integranova.spring.expensereportdemo.api.erltemplate;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ERLTemplateService;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.crud.ERLTemplatePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.crud.ERLTemplatePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.piu.PIUTemplateLinesResponse;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
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
@RequestMapping("/api/ERLTemplateApi")
@Api(value = "ERLTemplate")
public class ERLTemplateApi {

    @Autowired
    ERLTemplateService service;

    @GetMapping(value="/")
    public List<ERLTemplate> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{eRTemplateTemplateid}/{eRLTemplateid}")
    public ERLTemplate getInstance(Long eRTemplateTemplateid, Long eRLTemplateid) {
    	return service.getById(eRTemplateTemplateid, eRLTemplateid);
    }

    @PostMapping(value="/")
    public ERLTemplate postInstance(@RequestBody ERLTemplatePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{eRTemplateTemplateid}/{eRLTemplateid}")
    public ERLTemplate putInstance(Long eRTemplateTemplateid, Long eRLTemplateid, @RequestBody ERLTemplatePutViewModel payload) throws ModelException {
    	return service.put(eRTemplateTemplateid, eRLTemplateid, payload);
    }
    
    @DeleteMapping(value="/{eRTemplateTemplateid}/{eRLTemplateid}")
    public void deleteInstance(Long eRTemplateTemplateid, Long eRLTemplateid) throws ModelException {
    	service.delete(eRTemplateTemplateid, eRLTemplateid);
    }

    @PostMapping(value = "/GetDSTemplateLines")
    @ApiOperation(value = "Returns displayset DSTemplateLines for an instance of ERLTemplate")
    public DSTemplateLines getDSTemplateLines(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSTemplateLines(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetERLTemplate")
    @ApiOperation(value = "Returns an instance of ERLTemplate", hidden = true)
    public ERLTemplate getERLTemplate(Long eRTemplateTemplateid, Long eRLTemplateid) {
        return service.getById(eRTemplateTemplateid, eRLTemplateid);
    }
    
    @PostMapping(value = "/GetERLTemplateDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getERLTemplateDynamic(@RequestBody QueryRequest request) {
        ERLTemplateOid oid = new ERLTemplateOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getERLTemplateDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getERLTemplateWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getERLTemplatePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByTemplate")
    @ApiOperation(value = "Returns instances related with another one through Template")
    public List<ERLTemplate> getERLTemplateByTemplate(ERTemplateOid relatedInstanceOid) {
        ERTemplate relatedInstance = new ERTemplate(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Template");
    }

    @PostMapping(value = "/GetByExpenseType")
    @ApiOperation(value = "Returns instances related with another one through ExpenseType")
    public List<ERLTemplate> getERLTemplateByExpenseType(ExpenseTypeOid relatedInstanceOid) {
        ExpenseType relatedInstance = new ExpenseType(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "ExpenseType");
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "ERLTemplate's creation event")
    public ServiceResponse eRLTemplateCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "ERLTemplate's destruction event")
    public ServiceResponse eRLTemplateDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ERLTemplate's change event")
    public ServiceResponse eRLTemplateEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/editUnits")
    @ApiOperation(value = "editUnits")
    public ServiceResponse eRLTemplateEditUnits(@RequestBody EditUnitsRequest request) {
        return service.editUnits(request);
    }
    

    @PostMapping(value = "/editPrice")
    @ApiOperation(value = "editPrice")
    public ServiceResponse eRLTemplateEditPrice(@RequestBody EditPriceRequest request) {
        return service.editPrice(request);
    }
    

    @PostMapping(value = "/editDescription")
    @ApiOperation(value = "editDescription")
    public ServiceResponse eRLTemplateEditDescription(@RequestBody EditDescriptionRequest request) {
        return service.editDescription(request);
    }
    

    @PostMapping(value = "/clearUnits")
    @ApiOperation(value = "clearUnits")
    public ServiceResponse eRLTemplateClearUnits(@RequestBody ClearUnitsRequest request) {
        return service.clearUnits(request);
    }
    

    @PostMapping(value = "/clearPrice")
    @ApiOperation(value = "clearPrice")
    public ServiceResponse eRLTemplateClearPrice(@RequestBody ClearPriceRequest request) {
        return service.clearPrice(request);
    }
    

    @PostMapping(value = "/clearDescription")
    @ApiOperation(value = "clearDescription")
    public ServiceResponse eRLTemplateClearDescription(@RequestBody ClearDescriptionRequest request) {
        return service.clearDescription(request);
    }
    


    @PostMapping(value = "/PIUTemplateLines")
    @ApiOperation(value = "Template Lines")
    public PIUTemplateLinesResponse piuPIUTemplateLines(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUTemplateLinesResponse response;
        try
        {
            response = new PIUTemplateLinesResponse(service.piuPIUTemplateLines(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUTemplateLines(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUTemplateLinesResponse();
            response.setException(e);
        }
        return response;
    }

}
