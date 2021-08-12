package com.integranova.spring.expensereportdemo.api.expenseline;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ExpenseLineService;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.crud.ExpenseLinePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.crud.ExpenseLinePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu.PIUExpenseLineResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu.PIUExpenseLineToReportsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest;
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
@RequestMapping("/api/ExpenseLineApi")
@Api(value = "Expense Line")
public class ExpenseLineApi {

    @Autowired
    ExpenseLineService service;

    @GetMapping(value="/")
    public List<ExpenseLine> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{expenseReportidExpenseRepor}/{expenseLineidExpenseLine}")
    public ExpenseLine getInstance(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine) {
    	return service.getById(expenseReportidExpenseRepor, expenseLineidExpenseLine);
    }

    @PostMapping(value="/")
    public ExpenseLine postInstance(@RequestBody ExpenseLinePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{expenseReportidExpenseRepor}/{expenseLineidExpenseLine}")
    public ExpenseLine putInstance(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine, @RequestBody ExpenseLinePutViewModel payload) throws ModelException {
    	return service.put(expenseReportidExpenseRepor, expenseLineidExpenseLine, payload);
    }
    
    @DeleteMapping(value="/{expenseReportidExpenseRepor}/{expenseLineidExpenseLine}")
    public void deleteInstance(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine) throws ModelException {
    	service.delete(expenseReportidExpenseRepor, expenseLineidExpenseLine);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getExpenseLinePreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSExpenseLine")
    @ApiOperation(value = "Returns displayset DSExpenseLine for an instance of ExpenseLine")
    public DSExpenseLine getDSExpenseLine(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseLine(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSExpenseLineSup")
    @ApiOperation(value = "Returns displayset DSExpenseLineSup for an instance of ExpenseLine")
    public DSExpenseLineSup getDSExpenseLineSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSExpenseLineSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetExpenseLine")
    @ApiOperation(value = "Returns an instance of ExpenseLine", hidden = true)
    public ExpenseLine getExpenseLine(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine) {
        return service.getById(expenseReportidExpenseRepor, expenseLineidExpenseLine);
    }
    
    @PostMapping(value = "/GetExpenseLineDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getExpenseLineDynamic(@RequestBody QueryRequest request) {
        ExpenseLineOid oid = new ExpenseLineOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getExpenseLineDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getExpenseLineWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getExpenseLinePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByExpenseType")
    @ApiOperation(value = "Returns instances related with another one through ExpenseType")
    public List<ExpenseLine> getExpenseLineByExpenseType(ExpenseTypeOid relatedInstanceOid) {
        ExpenseType relatedInstance = new ExpenseType(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "ExpenseType");
    }

    @PostMapping(value = "/GetByExpenseReport")
    @ApiOperation(value = "Returns instances related with another one through ExpenseReport")
    public List<ExpenseLine> getExpenseLineByExpenseReport(ExpenseReportOid relatedInstanceOid) {
        ExpenseReport relatedInstance = new ExpenseReport(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "ExpenseReport");
    }

    @PostMapping(value = "/newline")
    @ApiOperation(value = "Allows to create a New Line of an existing Expenses Report")
    public ServiceResponse expenseLineNewline(@RequestBody NewlineRequest request) {
        return service.newline(request);
    }
    

    @PostMapping(value = "/newlineCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for newline")
    public ServiceResponse expenseLineNewlineCheckPreconditions(@RequestBody NewlineRequest request) {
        return service.newlineCheckPreconditions(request);
    }

    @PostMapping(value = "/deleteline")
    @ApiOperation(value = "Delete a line of expense report")
    public ServiceResponse expenseLineDeleteline(@RequestBody DeletelineRequest request) {
        return service.deleteline(request);
    }
    

    @PostMapping(value = "/deletelineCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for deleteline")
    public ServiceResponse expenseLineDeletelineCheckPreconditions(@RequestBody DeletelineRequest request) {
        return service.deletelineCheckPreconditions(request);
    }

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "Allows to edit an existing expenses line")
    public ServiceResponse expenseLineEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/editinstanceCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for editinstance")
    public ServiceResponse expenseLineEditinstanceCheckPreconditions(@RequestBody EditinstanceRequest request) {
        return service.editinstanceCheckPreconditions(request);
    }

    @PostMapping(value = "/IIU_ExpenseLine")
    @ApiOperation(value = "Expense Line")
    public DSExpenseLine iiuIIUExpenseLine(@RequestBody ExpenseLineOid oid) {
        return service.iIUExpenseLine(oid);
    }

    @PostMapping(value = "/PIU_ExpenseLine")
    @ApiOperation(value = "Expense Lines")
    public PIUExpenseLineResponse piuPIUExpenseLine(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseLineResponse response;
        try
        {
            response = new PIUExpenseLineResponse(service.piuPIUExpenseLine(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseLine(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseLineResponse();
            response.setException(e);
        }
        return response;
    }

    @PostMapping(value = "/PIU_ExpenseLineToReports")
    @ApiOperation(value = "Lines")
    public PIUExpenseLineToReportsResponse piuPIUExpenseLineToReports(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUExpenseLineToReportsResponse response;
        try
        {
            response = new PIUExpenseLineToReportsResponse(service.piuPIUExpenseLineToReports(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUExpenseLineToReports(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUExpenseLineToReportsResponse();
            response.setException(e);
        }
        return response;
    }

}
