package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.STDFunctions;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.crud.ExpenseLinePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.crud.ExpenseLinePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseLineService extends AbstractService {

    @Autowired
    private ExpenseLineJpaRepository repository;

    @Autowired
    private ExpenseLineService expenseLineSrv;

    @Autowired
    private ExpenseTypeService expenseTypeSrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;
    
    public ExpenseLine post(ExpenseLinePostViewModel payload) {
        ExpenseLine instance = new ExpenseLine();
        instance.setExpenseLineExpenseDate(payload.getExpenseLineExpenseDate());
        instance.setExpenseLineUnits(payload.getExpenseLineUnits());
        instance.setExpenseLinePrice(payload.getExpenseLinePrice());
        instance.setExpenseLineLnDescription(payload.getExpenseLineLnDescription());
        return repository.save(instance);
    }

    public ExpenseLine put(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine, ExpenseLinePutViewModel payload) throws ModelException {
        if (!repository.existsById(new ExpenseLineOid(expenseReportidExpenseRepor, expenseLineidExpenseLine))) throw new ModelException("Not found-Put");
        ExpenseLine instance = new ExpenseLine(new ExpenseLineOid(expenseReportidExpenseRepor, expenseLineidExpenseLine));
        instance.setExpenseLineExpenseDate(payload.getExpenseLineExpenseDate());
        instance.setExpenseLineUnits(payload.getExpenseLineUnits());
        instance.setExpenseLinePrice(payload.getExpenseLinePrice());
        instance.setExpenseLineLnDescription(payload.getExpenseLineLnDescription());
        return repository.save(instance);
    }

    public void delete(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine) throws ModelException {
        if (!repository.existsById(new ExpenseLineOid(expenseReportidExpenseRepor, expenseLineidExpenseLine))) throw new ModelException("Not found-Delete");
        repository.deleteById(new ExpenseLineOid(expenseReportidExpenseRepor, expenseLineidExpenseLine));
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ExpenseLineConstants.CLASS_NAME);
    }

    private List<ExpenseLine> solveExpenseLineTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ExpenseLineConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveExpenseLineTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ExpenseLineConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ExpenseLine
     *
     * @return Population of class ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseLine> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class ExpenseLine
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ExpenseLine> instances = get(queryRequest);
        if(ExpenseLineConstants.DSDSEXPENSELINE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseLine())).collect(Collectors.toList());
        }
        if(ExpenseLineConstants.DSDSEXPENSELINESUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseLineSup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSExpenseLine for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseLine for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine getDSExpenseLine(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseLine instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine(instance);
    }

    /*
     * Gets the properties of DisplaySet DSExpenseLineSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseLineSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup getDSExpenseLineSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseLine instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup(instance);
    }

    /*
     * Returns the population of class ExpenseLine that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ExpenseLine matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseLine> get(QueryRequest queryRequest) {
        return solveExpenseLineTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveExpenseLineTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveExpenseLineTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveExpenseLineTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveExpenseLineTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ExpenseLine by ID
     *
     * @param expenseReportidExpenseRepor Identification field expenseReportidExpenseRepor
     *
     * @param expenseLineidExpenseLine Identification field expenseLineidExpenseLine
     *
     * @return Instance of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseLine getById(Long expenseReportidExpenseRepor, Long expenseLineidExpenseLine) {
        return getByOID(new ExpenseLineOid(expenseReportidExpenseRepor, expenseLineidExpenseLine));
    }
    
    /*
     * Returns an instance of ExpenseLine by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseLine getByOID(ExpenseLineOid oid) {
        Optional<ExpenseLine> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ExpenseLine by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseLine getByOIDWithHV(ExpenseLineOid oid) {
        Optional<ExpenseLine> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ExpenseLine> getInstanceByOid(ExpenseLineOid oid) {
        return oid != null && oid.getExpenseReportidExpenseRepor() != null
               ? repository.findById(oid)
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ExpenseLine by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ExpenseLine
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseLine getByJsonOid(String jsonOid) {
        ExpenseLineOid oid = new ExpenseLineOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ExpenseLine related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseLine> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveExpenseLineTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ExpenseLine related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseLine> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ExpenseLine
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getExpenseLineDynamic(ExpenseLineOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public String getSuppInfo(ExpenseLineOid oid, String dsName) {
        ExpenseLine instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ExpenseLine instance, String dsName) {
        if (ExpenseLineConstants.DSDSEXPENSELINESUP.equals(dsName))
            return instance.buildDSExpenseLineSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ExpenseLine instance, String dsName) {
        if (ExpenseLineConstants.DSDSEXPENSELINE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseLine());
        if (ExpenseLineConstants.DSDSEXPENSELINESUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseLineSup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }




    // IIU Methods

    /*
     * Returns a viewmodel for class ExpenseLine with displayset DSExpenseLine for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class ExpenseLine with displayset DSExpenseLine
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine iIUExpenseLine(ExpenseLineOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUExpenseLine
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseLine using displayset DSExpenseLine that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine> piuPIUExpenseLine(QueryRequest queryRequest) {
        return solveExpenseLineTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseLine
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseLine
     */
    public int getCount4PIUExpenseLine(QueryRequest queryRequest) {
        return solveExpenseLineTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUExpenseLineToReports
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseLine using displayset DSExpenseLine that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine> piuPIUExpenseLineToReports(QueryRequest queryRequest) {
        return solveExpenseLineTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseLineToReports
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseLineToReports
     */
    public int getCount4PIUExpenseLineToReports(QueryRequest queryRequest) {
        return solveExpenseLineTypedQuery(queryRequest).size();
    }

    // Service: newline

    /*
     * Entry point for service newline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse newline(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseLineSrv.newlineTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service newline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse newlineTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) throws ModelException {
        request.setExpenseLinenewlinepagrExpenseTypeInstance(expenseTypeSrv.getByOIDWithHV(new ExpenseTypeOid().fromJsonString(request.getExpenseLinenewlinepagrExpenseType())));
        request.setExpenseLinenewlinepagrExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseLinenewlinepagrExpenseReport()));
        return expenseLineSrv.newlineImplementation(request);
    }

    /*
     * Implements service newline
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse newlineImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseType expenseLinenewlinepagrExpenseType = request.getExpenseLinenewlinepagrExpenseTypeInstance();
        ExpenseReport expenseLinenewlinepagrExpenseReport = request.getExpenseLinenewlinepagrExpenseReportInstance();
        Double expenseLinenewlinepatrUnits = request.getExpenseLinenewlinepatrUnits();
        Double expenseLinenewlinepatrPrice = request.getExpenseLinenewlinepatrPrice();
        Date expenseLinenewlinepatrExpenseDate = request.getExpenseLinenewlinepatrExpenseDate();
        String expenseLinenewlinepatrLnDescription = request.getExpenseLinenewlinepatrLnDescription();

        request.checkArguments();

        newlinePreconditions(request);
        ExpenseLine instance = new ExpenseLine();
        instance.add2ExpenseType(expenseLinenewlinepagrExpenseType);

        instance.add2ExpenseReport(expenseLinenewlinepagrExpenseReport);

        instance.setExpenseLineidExpenseLine(Long.valueOf(0));
        instance.setExpenseLineidExpenseLine(repository.nextExpenseLineidExpenseLine(instance.getExpenseReportidExpenseRepor()));
        instance.setExpenseLineUnits(expenseLinenewlinepatrUnits);
        instance.setExpenseLinePrice(expenseLinenewlinepatrPrice);
        instance.setExpenseLineExpenseDate(expenseLinenewlinepatrExpenseDate);
        instance.setExpenseLineLnDescription(expenseLinenewlinepatrLnDescription);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseLineSup());

        return response;
    }

    /*
     * Checks service newline preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse newlineCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setExpenseLinenewlinepagrExpenseTypeInstance(expenseTypeSrv.getByOIDWithHV(new ExpenseTypeOid().fromJsonString(request.getExpenseLinenewlinepagrExpenseType())));
        request.setExpenseLinenewlinepagrExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseLinenewlinepagrExpenseReport()));
        try {
            if("Clas_1057569177600646Pre_1".equals(request.getPreconditionId()))
                checkClas1057569177600646Pre1(request);
            if("Clas_1057569177600646Pre_2".equals(request.getPreconditionId()))
                checkClas1057569177600646Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void newlinePreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) 
            throws ModelException {
        checkClas1057569177600646Pre1(request);
        checkClas1057569177600646Pre2(request);
    }

    private void checkClas1057569177600646Pre1 (
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) 
            throws ModelException {
        // pagrExpenseReport.Status =  0

        ExpenseReport expenseLinenewlinepagrExpenseReport = request.getExpenseLinenewlinepagrExpenseReportInstance();
        boolean preconditionHolds = Long.valueOf(expenseLinenewlinepagrExpenseReport.getExpenseReportStatus()).equals(Long.valueOf(0));
        if (!preconditionHolds) throw new PreconditionException("The expense report with id " + STDFunctions.intToStrFun(expenseLinenewlinepagrExpenseReport.getExpenseReportidExpenseRepor()) + " must be open");
    }

    private void checkClas1057569177600646Pre2 (
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest request) 
            throws ModelException {
        // pagrExpenseType.FixedPrice = FALSE OR pagrExpenseType.Price = patrPrice

        ExpenseType expenseLinenewlinepagrExpenseType = request.getExpenseLinenewlinepagrExpenseTypeInstance();
        Double expenseLinenewlinepatrPrice = request.getExpenseLinenewlinepatrPrice();
        boolean preconditionHolds = expenseLinenewlinepagrExpenseType.getExpenseTypeFixedPrice().equals(false) || Double.valueOf(expenseLinenewlinepagrExpenseType.getExpenseTypePrice()).equals(expenseLinenewlinepatrPrice);
        if (!preconditionHolds) throw new PreconditionException("If the expense type has a fixed price it can not be modified");
    }

    // Service: deleteline

    /*
     * Entry point for service deleteline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deleteline(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseLineSrv.deletelineTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deleteline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deletelineTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) throws ModelException {
        request.setExpenseLinedeletelinepthisExpenseLineInstance(expenseLineSrv.getByOIDWithHV(request.getExpenseLinedeletelinepthisExpenseLine()));
        return expenseLineSrv.deletelineImplementation(request);
    }

    /*
     * Implements service deleteline
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deletelineImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseLine expenseLinedeletelinepthisExpenseLine = request.getExpenseLinedeletelinepthisExpenseLineInstance();

        request.checkArguments();

        deletelinePreconditions(request);
        ExpenseLine instance = expenseLinedeletelinepthisExpenseLine;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSExpenseLineSup());

        return response;
    }

    /*
     * Checks service deleteline preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse deletelineCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setExpenseLinedeletelinepthisExpenseLineInstance(expenseLineSrv.getByOIDWithHV(request.getExpenseLinedeletelinepthisExpenseLine()));
        try {
            if("Clas_1057569177600646Pre_3".equals(request.getPreconditionId()))
                checkClas1057569177600646Pre3(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void deletelinePreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) 
            throws ModelException {
        checkClas1057569177600646Pre3(request);
    }

    private void checkClas1057569177600646Pre3 (
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest request) 
            throws ModelException {
        // ExpenseReport.Status= 0

        ExpenseLine expenseLinedeletelinepthisExpenseLine = request.getExpenseLinedeletelinepthisExpenseLineInstance();
        boolean preconditionHolds = Long.valueOf(expenseLinedeletelinepthisExpenseLine.getExpenseReport().getExpenseReportStatus()).equals(Long.valueOf(0));
        if (!preconditionHolds) throw new PreconditionException("The expense report must be open");
    }

    // Service: editinstance

    /*
     * Entry point for service editinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editinstance(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseLineSrv.editinstanceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editinstanceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) throws ModelException {
        request.setExpenseLineeditinstancepthisExpenseLineInstance(expenseLineSrv.getByOIDWithHV(request.getExpenseLineeditinstancepthisExpenseLine()));
        return expenseLineSrv.editinstanceImplementation(request);
    }

    /*
     * Implements service editinstance
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editinstanceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseLine expenseLineeditinstancepthisExpenseLine = request.getExpenseLineeditinstancepthisExpenseLineInstance();
        Double expenseLineeditinstancepUnits = request.getExpenseLineeditinstancepUnits();
        Double expenseLineeditinstancepPrice = request.getExpenseLineeditinstancepPrice();
        Date expenseLineeditinstancepExpenseDate = request.getExpenseLineeditinstancepExpenseDate();
        String expenseLineeditinstancepLnDescription = request.getExpenseLineeditinstancepLnDescription();

        request.checkArguments();

        editinstancePreconditions(request);
        ExpenseLine instance = expenseLineeditinstancepthisExpenseLine;
        instance.setExpenseLineUnits(expenseLineeditinstancepUnits);
        instance.setExpenseLinePrice(expenseLineeditinstancepPrice);
        instance.setExpenseLineExpenseDate(expenseLineeditinstancepExpenseDate);
        instance.setExpenseLineLnDescription(expenseLineeditinstancepLnDescription);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseLineSup());

        return response;
    }

    /*
     * Checks service editinstance preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse editinstanceCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setExpenseLineeditinstancepthisExpenseLineInstance(expenseLineSrv.getByOIDWithHV(request.getExpenseLineeditinstancepthisExpenseLine()));
        try {
            if("Clas_1057569177600646Pre_4".equals(request.getPreconditionId()))
                checkClas1057569177600646Pre4(request);
            if("Clas_1057569177600646Pre_5".equals(request.getPreconditionId()))
                checkClas1057569177600646Pre5(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void editinstancePreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) 
            throws ModelException {
        checkClas1057569177600646Pre4(request);
        checkClas1057569177600646Pre5(request);
    }

    private void checkClas1057569177600646Pre4 (
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) 
            throws ModelException {
        // ExpenseReport.Status = 0

        ExpenseLine expenseLineeditinstancepthisExpenseLine = request.getExpenseLineeditinstancepthisExpenseLineInstance();
        boolean preconditionHolds = Long.valueOf(expenseLineeditinstancepthisExpenseLine.getExpenseReport().getExpenseReportStatus()).equals(Long.valueOf(0));
        if (!preconditionHolds) throw new PreconditionException("The expense report must be open");
    }

    private void checkClas1057569177600646Pre5 (
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest request) 
            throws ModelException {
        // ExpenseType.FixedPrice = FALSE OR ExpenseType.Price = pPrice

        Double expenseLineeditinstancepPrice = request.getExpenseLineeditinstancepPrice();
        ExpenseLine expenseLineeditinstancepthisExpenseLine = request.getExpenseLineeditinstancepthisExpenseLineInstance();
        boolean preconditionHolds = expenseLineeditinstancepthisExpenseLine.getExpenseType().getExpenseTypeFixedPrice().equals(false) || Double.valueOf(expenseLineeditinstancepthisExpenseLine.getExpenseType().getExpenseTypePrice()).equals(expenseLineeditinstancepPrice);
        if (!preconditionHolds) throw new PreconditionException("If the expense type has a fixed price it can not be modified");
    }

    // Service: deletepaidline

    /*
     * Entry point for service deletepaidline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deletepaidline(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseLineSrv.deletepaidlineTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deletepaidline
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deletepaidlineTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest request) throws ModelException {
        request.setExpenseLinedeletepaidlinepthisExpenseLineInstance(expenseLineSrv.getByOIDWithHV(request.getExpenseLinedeletepaidlinepthisExpenseLine()));
        return expenseLineSrv.deletepaidlineImplementation(request);
    }

    /*
     * Implements service deletepaidline
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deletepaidlineImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseLine expenseLinedeletepaidlinepthisExpenseLine = request.getExpenseLinedeletepaidlinepthisExpenseLineInstance();

        request.checkArguments();
        ExpenseLine instance = expenseLinedeletepaidlinepthisExpenseLine;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSExpenseLineSup());

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCExpenseLine(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCExpenseLine(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_ExpenseLine".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ExpenseLineConstants.CLASS_NAME, ExpenseLineConstants.ATTR_NAME_EXPENSELINEIDEXPENSELINE, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildExpenseLineRelatedInstance(relatedInstanceJsonOid);
        }
        if (ExpenseLineConstants.ROLE_NAME_EXPENSETYPE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseLineRelatedInstance4ExpenseType(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseLineRelatedInstance4ExpenseReport(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildExpenseLineRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ExpenseLine(mapper.readValue(relatedInstanceJsonOid, ExpenseLineOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseLineRelatedInstance4ExpenseType(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseType(mapper.readValue(relatedInstanceJsonOid, ExpenseTypeOid.class)): expenseTypeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseLineRelatedInstance4ExpenseReport(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class)): expenseReportSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ExpenseLineOid oid = new ExpenseLineOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT + "." + ExpenseReportConstants.ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseReportidExpenseRepor(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseLineConstants.ATTR_FIELD_EXPENSELINEIDEXPENSELINE, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseLineidExpenseLine(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExpenseLineService.class).error(e.getMessage());
        }
    }

}
