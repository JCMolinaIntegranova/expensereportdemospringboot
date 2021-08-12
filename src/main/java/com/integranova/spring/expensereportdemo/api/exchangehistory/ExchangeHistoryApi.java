package com.integranova.spring.expensereportdemo.api.exchangehistory;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.service.ExchangeHistoryService;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.crud.ExchangeHistoryPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.crud.ExchangeHistoryPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Date;
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
@RequestMapping("/api/ExchangeHistoryApi")
@Api(value = "ExchangeHistory")
public class ExchangeHistoryApi {

    @Autowired
    ExchangeHistoryService service;

    @GetMapping(value="/")
    public List<ExchangeHistory> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{expenseCurrencyCurrencyCode}/{exchangeHistoryentryDate}")
    public ExchangeHistory getInstance(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) {
    	return service.getById(expenseCurrencyCurrencyCode, exchangeHistoryentryDate);
    }

    @PostMapping(value="/")
    public ExchangeHistory postInstance(@RequestBody ExchangeHistoryPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{expenseCurrencyCurrencyCode}/{exchangeHistoryentryDate}")
    public ExchangeHistory putInstance(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate, @RequestBody ExchangeHistoryPutViewModel payload) throws ModelException {
    	return service.put(expenseCurrencyCurrencyCode, exchangeHistoryentryDate, payload);
    }
    
    @DeleteMapping(value="/{expenseCurrencyCurrencyCode}/{exchangeHistoryentryDate}")
    public void deleteInstance(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) throws ModelException {
    	service.delete(expenseCurrencyCurrencyCode, exchangeHistoryentryDate);
    }

    @GetMapping(value = "/GetExchangeHistory")
    @ApiOperation(value = "Returns an instance of ExchangeHistory", hidden = true)
    public ExchangeHistory getExchangeHistory(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) {
        return service.getById(expenseCurrencyCurrencyCode, exchangeHistoryentryDate);
    }
    
    @PostMapping(value = "/GetExchangeHistoryDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getExchangeHistoryDynamic(@RequestBody QueryRequest request) {
        ExchangeHistoryOid oid = new ExchangeHistoryOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getExchangeHistoryDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getExchangeHistoryWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getExchangeHistoryPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByExpenseCurrency")
    @ApiOperation(value = "Returns instances related with another one through ExpenseCurrency")
    public List<ExchangeHistory> getExchangeHistoryByExpenseCurrency(ExpenseCurrencyOid relatedInstanceOid) {
        ExpenseCurrency relatedInstance = new ExpenseCurrency(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "ExpenseCurrency");
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "ExchangeHistory's creation event")
    public ServiceResponse exchangeHistoryCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "ExchangeHistory's destruction event")
    public ServiceResponse exchangeHistoryDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ExchangeHistory's change event")
    public ServiceResponse exchangeHistoryEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    



}
