package com.integranova.spring.expensereportdemo.api.expensereport;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.service.ExpenseReportService;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud.ExpenseReportPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud.ExpenseReportPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
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
@RequestMapping("/api/ExpenseReportApi")
@Api(value = "Expense report")
public class ExpenseReportApi {

    @Autowired
    ExpenseReportService service;

    @GetMapping(value="/")
    public List<ExpenseReport> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{expenseReportidExpenseRepor}")
    public ExpenseReport getInstance(Long expenseReportidExpenseRepor) {
    	return service.getById(expenseReportidExpenseRepor);
    }

    @PostMapping(value="/")
    public ExpenseReport postInstance(@RequestBody ExpenseReportPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{expenseReportidExpenseRepor}")
    public ExpenseReport putInstance(Long expenseReportidExpenseRepor, @RequestBody ExpenseReportPutViewModel payload) throws ModelException {
    	return service.put(expenseReportidExpenseRepor, payload);
    }
    
    @DeleteMapping(value="/{expenseReportidExpenseRepor}")
    public void deleteInstance(Long expenseReportidExpenseRepor) throws ModelException {
    	service.delete(expenseReportidExpenseRepor);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getExpenseReportPreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSExpenseReport4MD")
    @ApiOperation(value = "Returns displayset DSExpenseReport4MD for an instance of ExpenseReport")
    public DSExpenseReport4MD getDSExpenseReport4MD(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseReport4MD(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSExpenseReportSup")
    @ApiOperation(value = "Returns displayset DSExpenseReportSup for an instance of ExpenseReport")
    public DSExpenseReportSup getDSExpenseReportSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseReportSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSExpenseReport4HAT")
    @ApiOperation(value = "Returns displayset DSExpenseReport4HAT for an instance of ExpenseReport")
    public DSExpenseReport4HAT getDSExpenseReport4HAT(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseReport4HAT(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetExpenseReport")
    @ApiOperation(value = "Returns an instance of ExpenseReport", hidden = true)
    public ExpenseReport getExpenseReport(Long expenseReportidExpenseRepor) {
        return service.getById(expenseReportidExpenseRepor);
    }
    
    @PostMapping(value = "/GetExpenseReportDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getExpenseReportDynamic(@RequestBody QueryRequest request) {
        ExpenseReportOid oid = new ExpenseReportOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getExpenseReportDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getExpenseReportWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getExpenseReportPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByEmployee")
    @ApiOperation(value = "Returns instances related with another one through Employee")
    public List<ExpenseReport> getExpenseReportByEmployee(EmployeeOid relatedInstanceOid) {
        Employee relatedInstance = new Employee(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Employee");
    }

    @PostMapping(value = "/GetByExpenseCurrency")
    @ApiOperation(value = "Returns instances related with another one through ExpenseCurrency")
    public List<ExpenseReport> getExpenseReportByExpenseCurrency(ExpenseCurrencyOid relatedInstanceOid) {
        ExpenseCurrency relatedInstance = new ExpenseCurrency(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "ExpenseCurrency");
    }

    @PostMapping(value = "/GetByPaymentType")
    @ApiOperation(value = "Returns instances related with another one through PaymentType")
    public List<ExpenseReport> getExpenseReportByPaymentType(PaymentTypeOid relatedInstanceOid) {
        PaymentType relatedInstance = new PaymentType(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "PaymentType");
    }

    @PostMapping(value = "/GetByProject")
    @ApiOperation(value = "Returns instances related with another one through Project")
    public List<ExpenseReport> getExpenseReportByProject(ProjectOid relatedInstanceOid) {
        Project relatedInstance = new Project(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Project");
    }

    @PostMapping(value = "/eclose")
    @ApiOperation(value = "Once the information has been introduced in the system, the employee will issue it closing the expenses report.  Then it will be pending to be approved.")
    public ServiceResponse expenseReportEclose(@RequestBody EcloseRequest request) {
        return service.eclose(request);
    }
    

    @PostMapping(value = "/authorize")
    @ApiOperation(value = "A responsible of expenses will authorise the expenses if proceeds and it will be pending to be payment approved.")
    public ServiceResponse expenseReportAuthorize(@RequestBody AuthorizeRequest request) {
        return service.authorize(request);
    }
    

    @PostMapping(value = "/rejectautho")
    @ApiOperation(value = "The Expense Report will be rejected with a optional comment indicating why it has been rejected.  The expenses report will be then back open to be modified.")
    public ServiceResponse expenseReportRejectautho(@RequestBody RejectauthoRequest request) {
        return service.rejectautho(request);
    }
    

    @PostMapping(value = "/rejectauthoCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for rejectautho")
    public ServiceResponse expenseReportRejectauthoCheckPreconditions(@RequestBody RejectauthoRequest request) {
        return service.rejectauthoCheckPreconditions(request);
    }

    @PostMapping(value = "/cancelapprove")
    @ApiOperation(value = "Allows to the cancel the payment approval given to an existing Expense Report")
    public ServiceResponse expenseReportCancelapprove(@RequestBody CancelapproveRequest request) {
        return service.cancelapprove(request);
    }
    

    @PostMapping(value = "/approve")
    @ApiOperation(value = "Req: Payments responsible will approve the payment.")
    public ServiceResponse expenseReportApprove(@RequestBody ApproveRequest request) {
        return service.approve(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "ExpenseReport's change event")
    public ServiceResponse expenseReportEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/DELETEALL")
    @ApiOperation(value = "Allows to delete an existing Expense Report and all its lines")
    public ServiceResponse expenseReportDELETEALL(@RequestBody DELETEALLRequest request) {
        return service.dELETEALL(request);
    }
    

    @PostMapping(value = "/TPAY")
    @ApiOperation(value = "Mark an Expense as Paid indicating the Payment Type")
    public ServiceResponse expenseReportTPAY(@RequestBody TPAYRequest request) {
        return service.tPAY(request);
    }
    

    @PostMapping(value = "/TNEW")
    @ApiOperation(value = "Allows creating a New Expense Report")
    public TNEWResponse expenseReportTNEW(@RequestBody TNEWRequest request) {
        return service.tNEW(request);
    }
    

    @PostMapping(value = "/TNEWCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for TNEW")
    public TNEWResponse expenseReportTNEWCheckPreconditions(@RequestBody TNEWRequest request) {
        return service.tNEWCheckPreconditions(request);
    }

    @PostMapping(value = "/TREJECTPAYMENT")
    @ApiOperation(value = "Payments responsible will approve the payment. Once approved, it will lock to be marked as paid.")
    public ServiceResponse expenseReportTREJECTPAYMENT(@RequestBody TREJECTPAYMENTRequest request) {
        return service.tREJECTPAYMENT(request);
    }
    

    @PostMapping(value = "/TNEWFROMTEMPLATE")
    @ApiOperation(value = "Allows creating a New Expense Report")
    public TNEWFROMTEMPLATEResponse expenseReportTNEWFROMTEMPLATE(@RequestBody TNEWFROMTEMPLATERequest request) {
        return service.tNEWFROMTEMPLATE(request);
    }
    

    @PostMapping(value = "/TNEWFROMTEMPLATECheckPreconditions")
    @ApiOperation(value = "Checks preconditions for TNEWFROMTEMPLATE")
    public TNEWFROMTEMPLATEResponse expenseReportTNEWFROMTEMPLATECheckPreconditions(@RequestBody TNEWFROMTEMPLATERequest request) {
        return service.tNEWFROMTEMPLATECheckPreconditions(request);
    }

    @PostMapping(value = "/IIU_ExpenseReport")
    @ApiOperation(value = "Expense Report")
    public DSExpenseReport4MD iiuIIUExpenseReport(@RequestBody ExpenseReportOid oid) {
        return service.iIUExpenseReport(oid);
    }

    @PostMapping(value = "/PIU_ExpenseReport")
    @ApiOperation(value = "Expense Reports")
    public PIUExpenseReportResponse piuPIUExpenseReport(@RequestBody PIUExpenseReportRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseReportResponse response;
        try
        {
            response = new PIUExpenseReportResponse(service.piuPIUExpenseReport(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseReport(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseReportResponse();
            response.setException(e);
        }
        return response;
    }

    @PostMapping(value = "/PIU_ExpenseReportToEmployee")
    @ApiOperation(value = "Expense Reports")
    public PIUExpenseReportToEmployeeResponse piuPIUExpenseReportToEmployee(@RequestBody PIUExpenseReportToEmployeeRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseReportToEmployeeResponse response;
        try
        {
            response = new PIUExpenseReportToEmployeeResponse(service.piuPIUExpenseReportToEmployee(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseReportToEmployee(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseReportToEmployeeResponse();
            response.setException(e);
        }
        return response;
    }

    @PostMapping(value = "/PIU_ExpenseReportProject")
    @ApiOperation(value = "Expense Reports")
    public PIUExpenseReportProjectResponse piuPIUExpenseReportProject(@RequestBody PIUExpenseReportProjectRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseReportProjectResponse response;
        try
        {
            response = new PIUExpenseReportProjectResponse(service.piuPIUExpenseReportProject(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseReportProject(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseReportProjectResponse();
            response.setException(e);
        }
        return response;
    }

}
