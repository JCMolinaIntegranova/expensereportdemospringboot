package com.integranova.spring.expensereportdemo.api.paymenttype;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.service.PaymentTypeService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud.PaymentTypePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud.PaymentTypePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.piu.PIUPaymentTypeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest;
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
@RequestMapping("/api/PaymentTypeApi")
@Api(value = "Different ways to pay")
public class PaymentTypeApi {

    @Autowired
    PaymentTypeService service;

    @GetMapping(value="/")
    public List<PaymentType> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{paymentTypeidPaymentType}")
    public PaymentType getInstance(String paymentTypeidPaymentType) {
    	return service.getById(paymentTypeidPaymentType);
    }

    @PostMapping(value="/")
    public PaymentType postInstance(@RequestBody PaymentTypePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{paymentTypeidPaymentType}")
    public PaymentType putInstance(String paymentTypeidPaymentType, @RequestBody PaymentTypePutViewModel payload) throws ModelException {
    	return service.put(paymentTypeidPaymentType, payload);
    }
    
    @DeleteMapping(value="/{paymentTypeidPaymentType}")
    public void deleteInstance(String paymentTypeidPaymentType) throws ModelException {
    	service.delete(paymentTypeidPaymentType);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getPaymentTypePreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSPaymentType")
    @ApiOperation(value = "Returns displayset DSPaymentType for an instance of PaymentType")
    public DSPaymentType getDSPaymentType(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSPaymentType(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSPaymentTypeSup")
    @ApiOperation(value = "Returns displayset DSPaymentTypeSup for an instance of PaymentType")
    public DSPaymentTypeSup getDSPaymentTypeSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSPaymentTypeSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetPaymentType")
    @ApiOperation(value = "Returns an instance of PaymentType", hidden = true)
    public PaymentType getPaymentType(String paymentTypeidPaymentType) {
        return service.getById(paymentTypeidPaymentType);
    }
    
    @PostMapping(value = "/GetPaymentTypeDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getPaymentTypeDynamic(@RequestBody QueryRequest request) {
        PaymentTypeOid oid = new PaymentTypeOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getPaymentTypeDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getPaymentTypeWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getPaymentTypePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "PaymentType's creation event")
    public ServiceResponse paymentTypeCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "PaymentType's destruction event")
    public ServiceResponse paymentTypeDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "PaymentType's change event")
    public ServiceResponse paymentTypeEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/InsPaymentType")
    @ApiOperation(value = "InsPaymentType")
    public ServiceResponse paymentTypeInsPaymentType(@RequestBody InsPaymentTypeRequest request) {
        return service.insPaymentType(request);
    }
    

    @PostMapping(value = "/IIU_PaymentType")
    @ApiOperation(value = "Payment Type")
    public DSPaymentType iiuIIUPaymentType(@RequestBody PaymentTypeOid oid) {
        return service.iIUPaymentType(oid);
    }

    @PostMapping(value = "/PIU_PaymentType")
    @ApiOperation(value = "Payment Types")
    public PIUPaymentTypeResponse piuPIUPaymentType(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUPaymentTypeResponse response;
        try
        {
            response = new PIUPaymentTypeResponse(service.piuPIUPaymentType(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUPaymentType(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUPaymentTypeResponse();
            response.setException(e);
        }
        return response;
    }

}
