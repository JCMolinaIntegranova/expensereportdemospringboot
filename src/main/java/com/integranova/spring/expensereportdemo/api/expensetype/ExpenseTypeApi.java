package com.integranova.spring.expensereportdemo.api.expensetype;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ExpenseTypeService;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.crud.ExpenseTypePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.crud.ExpenseTypePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.piu.PIUExpenseTypeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
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
@RequestMapping("/api/ExpenseTypeApi")
@Api(value = "Expense Type")
public class ExpenseTypeApi {

    @Autowired
    ExpenseTypeService service;

    @GetMapping(value="/")
    public List<ExpenseType> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{expenseTypeTypeCode}")
    public ExpenseType getInstance(String expenseTypeTypeCode) {
    	return service.getById(expenseTypeTypeCode);
    }

    @PostMapping(value="/")
    public ExpenseType postInstance(@RequestBody ExpenseTypePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{expenseTypeTypeCode}")
    public ExpenseType putInstance(String expenseTypeTypeCode, @RequestBody ExpenseTypePutViewModel payload) throws ModelException {
    	return service.put(expenseTypeTypeCode, payload);
    }
    
    @DeleteMapping(value="/{expenseTypeTypeCode}")
    public void deleteInstance(String expenseTypeTypeCode) throws ModelException {
    	service.delete(expenseTypeTypeCode);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getExpenseTypePreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSExpenseType")
    @ApiOperation(value = "Returns displayset DSExpenseType for an instance of ExpenseType")
    public DSExpenseType getDSExpenseType(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseType(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSExpenseTypeSup")
    @ApiOperation(value = "Returns displayset DSExpenseTypeSup for an instance of ExpenseType")
    public DSExpenseTypeSup getDSExpenseTypeSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseTypeSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetExpenseType")
    @ApiOperation(value = "Returns an instance of ExpenseType", hidden = true)
    public ExpenseType getExpenseType(String expenseTypeTypeCode) {
        return service.getById(expenseTypeTypeCode);
    }
    
    @PostMapping(value = "/GetExpenseTypeDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getExpenseTypeDynamic(@RequestBody QueryRequest request) {
        ExpenseTypeOid oid = new ExpenseTypeOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getExpenseTypeDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getExpenseTypeWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getExpenseTypePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "ExpenseType's creation event")
    public ServiceResponse expenseTypeCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "ExpenseType's destruction event")
    public ServiceResponse expenseTypeDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ExpenseType's change event")
    public ServiceResponse expenseTypeEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/IIU_ExpenseType")
    @ApiOperation(value = "Expense Type")
    public DSExpenseType iiuIIUExpenseType(@RequestBody ExpenseTypeOid oid) {
        return service.iIUExpenseType(oid);
    }

    @PostMapping(value = "/PIU_ExpenseType")
    @ApiOperation(value = "Expense Types")
    public PIUExpenseTypeResponse piuPIUExpenseType(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseTypeResponse response;
        try
        {
            response = new PIUExpenseTypeResponse(service.piuPIUExpenseType(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseType(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseTypeResponse();
            response.setException(e);
        }
        return response;
    }

}
