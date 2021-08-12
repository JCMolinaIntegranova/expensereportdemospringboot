package com.integranova.spring.expensereportdemo.api.expensecurrency;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.service.ExpenseCurrencyService;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.crud.ExpenseCurrencyPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.crud.ExpenseCurrencyPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.piu.PIUExpenseCurrencyResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest;
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
@RequestMapping("/api/ExpenseCurrencyApi")
@Api(value = "The currency in which the expense was incurred")
public class ExpenseCurrencyApi {

    @Autowired
    ExpenseCurrencyService service;

    @GetMapping(value="/")
    public List<ExpenseCurrency> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{expenseCurrencyCurrencyCode}")
    public ExpenseCurrency getInstance(String expenseCurrencyCurrencyCode) {
    	return service.getById(expenseCurrencyCurrencyCode);
    }

    @PostMapping(value="/")
    public ExpenseCurrency postInstance(@RequestBody ExpenseCurrencyPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{expenseCurrencyCurrencyCode}")
    public ExpenseCurrency putInstance(String expenseCurrencyCurrencyCode, @RequestBody ExpenseCurrencyPutViewModel payload) throws ModelException {
    	return service.put(expenseCurrencyCurrencyCode, payload);
    }
    
    @DeleteMapping(value="/{expenseCurrencyCurrencyCode}")
    public void deleteInstance(String expenseCurrencyCurrencyCode) throws ModelException {
    	service.delete(expenseCurrencyCurrencyCode);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getExpenseCurrencyPreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSExpenseCurrency")
    @ApiOperation(value = "Returns displayset DSExpenseCurrency for an instance of ExpenseCurrency")
    public DSExpenseCurrency getDSExpenseCurrency(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseCurrency(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSExpenseCurrencySup")
    @ApiOperation(value = "Returns displayset DSExpenseCurrencySup for an instance of ExpenseCurrency")
    public DSExpenseCurrencySup getDSExpenseCurrencySup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseCurrencySup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetExpenseCurrency")
    @ApiOperation(value = "Returns an instance of ExpenseCurrency", hidden = true)
    public ExpenseCurrency getExpenseCurrency(String expenseCurrencyCurrencyCode) {
        return service.getById(expenseCurrencyCurrencyCode);
    }
    
    @PostMapping(value = "/GetExpenseCurrencyDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getExpenseCurrencyDynamic(@RequestBody QueryRequest request) {
        ExpenseCurrencyOid oid = new ExpenseCurrencyOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getExpenseCurrencyDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getExpenseCurrencyWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getExpenseCurrencyPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "ExpenseCurrency's creation event")
    public ServiceResponse expenseCurrencyCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "ExpenseCurrency's destruction event")
    public ServiceResponse expenseCurrencyDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ExpenseCurrency's change event")
    public ServiceResponse expenseCurrencyEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/resetExchange")
    @ApiOperation(value = "Reset exchange")
    public ServiceResponse expenseCurrencyResetExchange(@RequestBody ResetExchangeRequest request) {
        return service.resetExchange(request);
    }
    

    @PostMapping(value = "/editExchange")
    @ApiOperation(value = "Update exchange")
    public ServiceResponse expenseCurrencyEditExchange(@RequestBody EditExchangeRequest request) {
        return service.editExchange(request);
    }
    

    @PostMapping(value = "/TNEW")
    @ApiOperation(value = "Create")
    public ServiceResponse expenseCurrencyTNEW(@RequestBody TNEWRequest request) {
        return service.tNEW(request);
    }
    

    @PostMapping(value = "/TEDITEXCHANGE")
    @ApiOperation(value = "Update exchange")
    public ServiceResponse expenseCurrencyTEDITEXCHANGE(@RequestBody TEDITEXCHANGERequest request) {
        return service.tEDITEXCHANGE(request);
    }
    

    @PostMapping(value = "/IIU_ExpenseCurrency")
    @ApiOperation(value = "Expense Currency")
    public DSExpenseCurrency iiuIIUExpenseCurrency(@RequestBody ExpenseCurrencyOid oid) {
        return service.iIUExpenseCurrency(oid);
    }

    @PostMapping(value = "/PIU_ExpenseCurrency")
    @ApiOperation(value = "Expense Currencies")
    public PIUExpenseCurrencyResponse piuPIUExpenseCurrency(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseCurrencyResponse response;
        try
        {
            response = new PIUExpenseCurrencyResponse(service.piuPIUExpenseCurrency(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseCurrency(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseCurrencyResponse();
            response.setException(e);
        }
        return response;
    }

}
