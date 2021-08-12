package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.service.ExpenseLineService;
import com.integranova.spring.expensereportdemo.service.ExpenseReportService;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathInstance;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud.ExpenseReportPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud.ExpenseReportPutViewModel;
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
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseReportService extends AbstractService {

    @Autowired
    private ExpenseReportJpaRepository repository;

    @Autowired
    private ExpenseReportService expenseReportSrv;

    @Autowired
    private ExpenseCurrencyService expenseCurrencySrv;

    @Autowired
    private PaymentTypeService paymentTypeSrv;

    @Autowired
    private ProjectService projectSrv;

    @Autowired
    private EmployeeService employeeSrv;

    @Autowired
    private ExpenseLineService expenseLineSrv;

    @Autowired
    private ERTemplateService eRTemplateSrv;

    @Autowired
    private ERLTemplateService eRLTemplateSrv;

    @Autowired
    private ExpenseTypeService expenseTypeSrv;
    
    public ExpenseReport post(ExpenseReportPostViewModel payload) {
        ExpenseReport instance = new ExpenseReport();
        instance.setExpenseReportPresentDate(payload.getExpenseReportPresentDate());
        instance.setExpenseReportCause(payload.getExpenseReportCause());
        instance.setExpenseReportAdvances(payload.getExpenseReportAdvances());
        instance.setExpenseReportExchange(payload.getExpenseReportExchange());
        return repository.save(instance);
    }

    public ExpenseReport put(Long expenseReportidExpenseRepor, ExpenseReportPutViewModel payload) throws ModelException {
        if (!repository.existsById(expenseReportidExpenseRepor)) throw new ModelException("Not found-Put");
        ExpenseReport instance = new ExpenseReport(new ExpenseReportOid(expenseReportidExpenseRepor));
        instance.setExpenseReportStatus(payload.getExpenseReportStatus());
        instance.setExpenseReportCause(payload.getExpenseReportCause());
        instance.setExpenseReportAuthoDate(payload.getExpenseReportAuthoDate());
        instance.setExpenseReportAuthoComments(payload.getExpenseReportAuthoComments());
        instance.setExpenseReportPaymentDate(payload.getExpenseReportPaymentDate());
        instance.setExpenseReportPayComments(payload.getExpenseReportPayComments());
        instance.setExpenseReportAdvances(payload.getExpenseReportAdvances());
        instance.setExpenseReportExchange(payload.getExpenseReportExchange());
        return repository.save(instance);
    }

    public void delete(Long expenseReportidExpenseRepor) throws ModelException {
        if (!repository.existsById(expenseReportidExpenseRepor)) throw new ModelException("Not found-Delete");
        repository.deleteById(expenseReportidExpenseRepor);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ExpenseReportConstants.CLASS_NAME);
    }

    private List<ExpenseReport> solveExpenseReportTypedQuery(QueryRequest request) {
        return applyOrderCriteriaInMemory(request, repository.solveQuery(processQueryRequest(request, ExpenseReportConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance))).collect(Collectors.toList());
    }
    
    private int solveExpenseReportTypedCountQuery(QueryRequest request) {
        return applyOrderCriteriaInMemory(request, repository.solveQuery(processQueryRequest(request, ExpenseReportConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance))).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class ExpenseReport
     *
     * @return Population of class ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseReport> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class ExpenseReport
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ExpenseReport> instances = get(queryRequest);
        if(ExpenseReportConstants.DSDSEXPENSEREPORT4MD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseReport4MD())).collect(Collectors.toList());
        }
        if(ExpenseReportConstants.DSDSEXPENSEREPORTSUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseReportSup())).collect(Collectors.toList());
        }
        if(ExpenseReportConstants.DSDSEXPENSEREPORT4HAT.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseReport4HAT())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSExpenseReport4MD for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseReport4MD for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD getDSExpenseReport4MD(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseReport instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD(instance);
    }

    /*
     * Gets the properties of DisplaySet DSExpenseReportSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseReportSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup getDSExpenseReportSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseReport instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup(instance);
    }

    /*
     * Gets the properties of DisplaySet DSExpenseReport4HAT for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseReport4HAT for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT getDSExpenseReport4HAT(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseReport instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT(instance);
    }

    /*
     * Returns the population of class ExpenseReport that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ExpenseReport matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseReport> get(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveExpenseReportTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveExpenseReportTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveExpenseReportTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveExpenseReportTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ExpenseReport by ID
     *
     * @param expenseReportidExpenseRepor Identification field expenseReportidExpenseRepor
     *
     * @return Instance of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseReport getById(Long expenseReportidExpenseRepor) {
        return getByOID(new ExpenseReportOid(expenseReportidExpenseRepor));
    }
    
    /*
     * Returns an instance of ExpenseReport by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseReport getByOID(ExpenseReportOid oid) {
        Optional<ExpenseReport> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ExpenseReport by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseReport getByOIDWithHV(ExpenseReportOid oid) {
        Optional<ExpenseReport> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ExpenseReport> getInstanceByOid(ExpenseReportOid oid) {
        return oid != null && oid.getExpenseReportidExpenseRepor() != null
               ? repository.findById(oid.getExpenseReportidExpenseRepor())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ExpenseReport by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ExpenseReport
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseReport getByJsonOid(String jsonOid) {
        ExpenseReportOid oid = new ExpenseReportOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ExpenseReport related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseReport> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveExpenseReportTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ExpenseReport related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseReport> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ExpenseReport
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ExpenseReport
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getExpenseReportDynamic(ExpenseReportOid oid, String displaySetItems) {
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
    public String getSuppInfo(ExpenseReportOid oid, String dsName) {
        ExpenseReport instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ExpenseReport instance, String dsName) {
        if (ExpenseReportConstants.DSDSEXPENSEREPORTSUP.equals(dsName))
            return instance.buildDSExpenseReportSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ExpenseReport instance, String dsName) {
        if (ExpenseReportConstants.DSDSEXPENSEREPORT4MD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseReport4MD());
        if (ExpenseReportConstants.DSDSEXPENSEREPORTSUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseReportSup());
        if (ExpenseReportConstants.DSDSEXPENSEREPORT4HAT.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseReport4HAT());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES.equalsIgnoreCase(filterRequest.getName()))
            fExpenseReportDates(filterRequest, sql);
        if (ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS.equalsIgnoreCase(filterRequest.getName()))
            fExpenseReportStatus(filterRequest, sql);
        if (ExpenseReportConstants.FILTER_NAME_FBYPROJECT.equalsIgnoreCase(filterRequest.getName()))
            fByProject(filterRequest, sql);
        if (ExpenseReportConstants.FILTER_NAME_FBYID.equalsIgnoreCase(filterRequest.getName()))
            fByID(filterRequest, sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, ExpenseReport instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, ExpenseReport instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, ExpenseReport entity) {
        if (ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFExpenseReportAmount(filterRequest,  entity);
        return true;
    }


    private void fExpenseReportDates(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Date vIniDate = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE) ? (Date) filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE, FilterVariableRequest.DATE) : null;
        Date vFinalDate = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE) ? (Date) filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE, FilterVariableRequest.DATE) : null;

        // vIniDate <= PresentDate
        if (vIniDate != null) {
            // '<=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandLiteral operand112 = new SQLWhereOperandLiteral(vIniDate, Constants.Type.DATE.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPRESENTDATE, Constants.Type.DATE.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PresentDate <= vFinalDate
        if (vFinalDate != null) {
            // '<=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPRESENTDATE, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vFinalDate, Constants.Type.DATE.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        sql.addConjunction(conjunction);
    }

    private void fExpenseReportStatus(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vStatus = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS) ? (Long) filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS, FilterVariableRequest.INT) : null;

        // vStatus = Status
        if (vStatus != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandLiteral operand112 = new SQLWhereOperandLiteral(vStatus, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTSTATUS, Constants.Type.INT.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fByProject(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Project vfProject = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT) ? projectSrv.getByJsonOid(toJson(filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT))) : null;

        // Project = vfProject
        if (vfProject != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ExpenseReportConstants.ROLE_NAME_PROJECT, ProjectConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT, ProjectConstants.CLASS_NAME, ProjectConstants.CLASS_NAME, vfProject.getOid(), ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fByID(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vID = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FBYID_VID) ? (Long) filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FBYID_VID, FilterVariableRequest.INT) : null;

        // idExpenseRepor = vID
        if (vID != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vID, Constants.Type.INT.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFExpenseReportAmount(FilterRequest filterRequest, ExpenseReport entity) {
        boolean result = true;
        Double vAmount = filterRequest.hasFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT) ? (Double) filterRequest.getFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT, FilterVariableRequest.REAL) : null;

        // TotExpensesCur + 100 > vAmount
        try {
            if (vAmount != null) {
                result = entity.getExpenseReportTotExpensesCur() + Long.valueOf(100) > vAmount;
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }

        // TotExpensesCur - 100 < vAmount
        try {
            if (vAmount != null) {
                result = entity.getExpenseReportTotExpensesCur() - Long.valueOf(100) < vAmount;
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class ExpenseReport with displayset DSExpenseReport4MD for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class ExpenseReport with displayset DSExpenseReport4MD
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD iIUExpenseReport(ExpenseReportOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUExpenseReport
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseReport using displayset DSExpenseReport4HAT that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT> piuPIUExpenseReport(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseReport
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseReport
     */
    public int getCount4PIUExpenseReport(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUExpenseReportToEmployee
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseReport using displayset DSExpenseReport4MD that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD> piuPIUExpenseReportToEmployee(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseReportToEmployee
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseReportToEmployee
     */
    public int getCount4PIUExpenseReportToEmployee(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUExpenseReportProject
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseReport using displayset DSExpenseReport4MD that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD> piuPIUExpenseReportProject(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseReportProject
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseReportProject
     */
    public int getCount4PIUExpenseReportProject(QueryRequest queryRequest) {
        return solveExpenseReportTypedQuery(queryRequest).size();
    }

    // Service: newexpense

    /*
     * Entry point for service newexpense
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse newexpense(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.newexpenseTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service newexpense
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse newexpenseTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest request) throws ModelException {
        request.setExpenseReportnewexpensepagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseReportnewexpensepagrExpenseCurrency()));
        request.setExpenseReportnewexpensepagrPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getExpenseReportnewexpensepagrPaymentType()));
        request.setExpenseReportnewexpensepagrProjectInstance(projectSrv.getByOIDWithHV(request.getExpenseReportnewexpensepagrProject()));
        request.setExpenseReportnewexpensepagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getExpenseReportnewexpensepagrEmployee()));
        return expenseReportSrv.newexpenseImplementation(request);
    }

    /*
     * Implements service newexpense
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse newexpenseImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency expenseReportnewexpensepagrExpenseCurrency = request.getExpenseReportnewexpensepagrExpenseCurrencyInstance();
        PaymentType expenseReportnewexpensepagrPaymentType = request.getExpenseReportnewexpensepagrPaymentTypeInstance();
        Project expenseReportnewexpensepagrProject = request.getExpenseReportnewexpensepagrProjectInstance();
        Employee expenseReportnewexpensepagrEmployee = request.getExpenseReportnewexpensepagrEmployeeInstance();
        Date expenseReportnewexpensepatrPresentDate = request.getExpenseReportnewexpensepatrPresentDate();
        String expenseReportnewexpensepatrCause = request.getExpenseReportnewexpensepatrCause();
        Double expenseReportnewexpensepatrAdvances = request.getExpenseReportnewexpensepatrAdvances();
        Double expenseReportnewexpensepatrExchange = request.getExpenseReportnewexpensepatrExchange();

        request.checkArguments();
        ExpenseReport instance = new ExpenseReport();
        instance.add2ExpenseCurrency(expenseReportnewexpensepagrExpenseCurrency);

        if (expenseReportnewexpensepagrPaymentType != null && !expenseReportnewexpensepagrPaymentType.isNull()) {
            instance.add2PaymentType(expenseReportnewexpensepagrPaymentType);
        }

        instance.add2Project(expenseReportnewexpensepagrProject);

        instance.add2Employee(expenseReportnewexpensepagrEmployee);

        instance.setExpenseReportidExpenseRepor(Long.valueOf(0));
        instance.setExpenseReportStatus(Long.valueOf(0));
        instance.setExpenseReportAuthoDate(null);
        instance.setExpenseReportAuthoComments(null);
        instance.setExpenseReportPaymentDate(null);
        instance.setExpenseReportPresentDate(expenseReportnewexpensepatrPresentDate);
        instance.setExpenseReportCause(expenseReportnewexpensepatrCause);
        instance.setExpenseReportAdvances(expenseReportnewexpensepatrAdvances);
        instance.setExpenseReportExchange(expenseReportnewexpensepatrExchange);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: delexpense

    /*
     * Entry point for service delexpense
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse delexpense(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.delexpenseTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service delexpense
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse delexpenseTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest request) throws ModelException {
        request.setExpenseReportdelexpensepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportdelexpensepthisExpenseReport()));
        return expenseReportSrv.delexpenseImplementation(request);
    }

    /*
     * Implements service delexpense
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse delexpenseImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportdelexpensepthisExpenseReport = request.getExpenseReportdelexpensepthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportdelexpensepthisExpenseReport;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: eclose

    /*
     * Entry point for service eclose
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse eclose(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.ecloseTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service eclose
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse ecloseTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest request) throws ModelException {
        request.setExpenseReporteclosepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReporteclosepthisExpenseReport()));
        return expenseReportSrv.ecloseImplementation(request);
    }

    /*
     * Implements service eclose
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse ecloseImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReporteclosepthisExpenseReport = request.getExpenseReporteclosepthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReporteclosepthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(1));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: authorize

    /*
     * Entry point for service authorize
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse authorize(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.authorizeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service authorize
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse authorizeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest request) throws ModelException {
        request.setExpenseReportauthorizepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportauthorizepthisExpenseReport()));
        return expenseReportSrv.authorizeImplementation(request);
    }

    /*
     * Implements service authorize
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse authorizeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportauthorizepthisExpenseReport = request.getExpenseReportauthorizepthisExpenseReportInstance();
        Date expenseReportauthorizepsDate = request.getExpenseReportauthorizepsDate();
        String expenseReportauthorizepsComments = request.getExpenseReportauthorizepsComments();

        request.checkArguments();
        ExpenseReport instance = expenseReportauthorizepthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(2));
        instance.setExpenseReportAuthoDate(expenseReportauthorizepsDate);
        instance.setExpenseReportAuthoComments(expenseReportauthorizepsComments);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: pay

    /*
     * Entry point for service pay
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse pay(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.payTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service pay
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse payTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest request) throws ModelException {
        request.setExpenseReportpaypthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportpaypthisExpenseReport()));
        return expenseReportSrv.payImplementation(request);
    }

    /*
     * Implements service pay
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse payImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportpaypthisExpenseReport = request.getExpenseReportpaypthisExpenseReportInstance();
        Date expenseReportpaypeDate = request.getExpenseReportpaypeDate();
        String expenseReportpaypsComments = request.getExpenseReportpaypsComments();

        request.checkArguments();
        ExpenseReport instance = expenseReportpaypthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(4));
        instance.setExpenseReportPaymentDate(expenseReportpaypeDate);
        instance.setExpenseReportPayComments(expenseReportpaypsComments);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: rejectautho

    /*
     * Entry point for service rejectautho
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse rejectautho(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.rejectauthoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service rejectautho
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse rejectauthoTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) throws ModelException {
        request.setExpenseReportrejectauthopthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportrejectauthopthisExpenseReport()));
        return expenseReportSrv.rejectauthoImplementation(request);
    }

    /*
     * Implements service rejectautho
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse rejectauthoImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportrejectauthopthisExpenseReport = request.getExpenseReportrejectauthopthisExpenseReportInstance();
        String expenseReportrejectauthopeComments = request.getExpenseReportrejectauthopeComments();

        request.checkArguments();

        rejectauthoPreconditions(request);
        ExpenseReport instance = expenseReportrejectauthopthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(1));
        instance.setExpenseReportAuthoComments(expenseReportrejectauthopeComments);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    /*
     * Checks service rejectautho preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse rejectauthoCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setExpenseReportrejectauthopthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportrejectauthopthisExpenseReport()));
        try {
            if("Clas_1057569177600553Pre_1".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre1(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void rejectauthoPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) 
            throws ModelException {
        checkClas1057569177600553Pre1(request);
    }

    private void checkClas1057569177600553Pre1 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest request) 
            throws ModelException {
        // Status = 2

        ExpenseReport expenseReportrejectauthopthisExpenseReport = request.getExpenseReportrejectauthopthisExpenseReportInstance();
        boolean preconditionHolds = Long.valueOf(expenseReportrejectauthopthisExpenseReport.getExpenseReportStatus()).equals(Long.valueOf(2));
        if (!preconditionHolds) throw new PreconditionException("The expense report created by " + expenseReportrejectauthopthisExpenseReport.getEmployee().getEmployeeEmpName() + " " + expenseReportrejectauthopthisExpenseReport.getEmployee().getEmployeeEmpSurname() + " is not approved");
    }

    // Service: rejectpayment

    /*
     * Entry point for service rejectpayment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse rejectpayment(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.rejectpaymentTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service rejectpayment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse rejectpaymentTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest request) throws ModelException {
        request.setExpenseReportrejectpaymentpthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportrejectpaymentpthisExpenseReport()));
        return expenseReportSrv.rejectpaymentImplementation(request);
    }

    /*
     * Implements service rejectpayment
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse rejectpaymentImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportrejectpaymentpthisExpenseReport = request.getExpenseReportrejectpaymentpthisExpenseReportInstance();
        String expenseReportrejectpaymentpeComments = request.getExpenseReportrejectpaymentpeComments();

        request.checkArguments();

        rejectpaymentPreconditions(request);
        ExpenseReport instance = expenseReportrejectpaymentpthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(3));
        instance.setExpenseReportPayComments(expenseReportrejectpaymentpeComments);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    private void rejectpaymentPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest request) 
            throws ModelException {
        checkClas1057569177600553Pre2(request);
    }

    private void checkClas1057569177600553Pre2 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest request) 
            throws ModelException {
        // status = 4

        ExpenseReport expenseReportrejectpaymentpthisExpenseReport = request.getExpenseReportrejectpaymentpthisExpenseReportInstance();
        boolean preconditionHolds = Long.valueOf(expenseReportrejectpaymentpthisExpenseReport.getExpenseReportStatus()).equals(Long.valueOf(4));
        if (!preconditionHolds) throw new PreconditionException("The expense report is not paid.");
    }

    // Service: InsPaymentType

    /*
     * Entry point for service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse insPaymentType(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.insPaymentTypeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse insPaymentTypeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest request) throws ModelException {
        request.setExpenseReportInsPaymentTypepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportInsPaymentTypepthisExpenseReport()));
        request.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getExpenseReportInsPaymentTypepevcPaymentType()));
        return expenseReportSrv.insPaymentTypeImplementation(request, true);
    }

    /*
     * Implements service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse insPaymentTypeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportInsPaymentTypepthisExpenseReport = request.getExpenseReportInsPaymentTypepthisExpenseReportInstance();
        PaymentType expenseReportInsPaymentTypepevcPaymentType = request.getExpenseReportInsPaymentTypepevcPaymentTypeInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportInsPaymentTypepthisExpenseReport;

        instance.add2PaymentType(expenseReportInsPaymentTypepevcPaymentType);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest();
            relatedRequest.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(expenseReportInsPaymentTypepevcPaymentType);
            relatedRequest.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(expenseReportInsPaymentTypepthisExpenseReport);
            paymentTypeSrv.insPaymentTypeImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: DelPaymentType

    /*
     * Entry point for service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse delPaymentType(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.delPaymentTypeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse delPaymentTypeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest request) throws ModelException {
        request.setExpenseReportDelPaymentTypepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportDelPaymentTypepthisExpenseReport()));
        request.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getExpenseReportDelPaymentTypepevcPaymentType()));
        return expenseReportSrv.delPaymentTypeImplementation(request, true);
    }

    /*
     * Implements service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse delPaymentTypeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportDelPaymentTypepthisExpenseReport = request.getExpenseReportDelPaymentTypepthisExpenseReportInstance();
        PaymentType expenseReportDelPaymentTypepevcPaymentType = request.getExpenseReportDelPaymentTypepevcPaymentTypeInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportDelPaymentTypepthisExpenseReport;

        instance.add2PaymentType(null);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest();
            relatedRequest.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(expenseReportDelPaymentTypepevcPaymentType);
            relatedRequest.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(expenseReportDelPaymentTypepthisExpenseReport);
            paymentTypeSrv.delPaymentTypeImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: cancelapprove

    /*
     * Entry point for service cancelapprove
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse cancelapprove(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.cancelapproveTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cancelapprove
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse cancelapproveTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest request) throws ModelException {
        request.setExpenseReportcancelapprovepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportcancelapprovepthisExpenseReport()));
        return expenseReportSrv.cancelapproveImplementation(request);
    }

    /*
     * Implements service cancelapprove
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse cancelapproveImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportcancelapprovepthisExpenseReport = request.getExpenseReportcancelapprovepthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportcancelapprovepthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(2));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: approve

    /*
     * Entry point for service approve
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse approve(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.approveTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service approve
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse approveTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest request) throws ModelException {
        request.setExpenseReportapprovepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportapprovepthisExpenseReport()));
        return expenseReportSrv.approveImplementation(request);
    }

    /*
     * Implements service approve
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse approveImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportapprovepthisExpenseReport = request.getExpenseReportapprovepthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportapprovepthisExpenseReport;
        instance.setExpenseReportStatus(Long.valueOf(3));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
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
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest request) throws ModelException {
        request.setExpenseReporteditinstancepthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReporteditinstancepthisExpenseReport()));
        return expenseReportSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReporteditinstancepthisExpenseReport = request.getExpenseReporteditinstancepthisExpenseReportInstance();
        String expenseReporteditinstancepCause = request.getExpenseReporteditinstancepCause();
        Double expenseReporteditinstancepAdvances = request.getExpenseReporteditinstancepAdvances();
        Double expenseReporteditinstancepExchange = request.getExpenseReporteditinstancepExchange();

        request.checkArguments();
        ExpenseReport instance = expenseReporteditinstancepthisExpenseReport;
        instance.setExpenseReportCause(expenseReporteditinstancepCause);
        instance.setExpenseReportAdvances(expenseReporteditinstancepAdvances);
        instance.setExpenseReportExchange(expenseReporteditinstancepExchange);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: dummy

    /*
     * Entry point for service dummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse dummy(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse();
        try {
            response = expenseReportSrv.dummyTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service dummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse dummyTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest request) throws ModelException {
        request.setExpenseReportdummypthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportdummypthisExpenseReport()));
        return expenseReportSrv.dummyImplementation(request);
    }

    /*
     * Implements service dummy
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse dummyImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest request) throws ModelException {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse();
        ExpenseReport expenseReportdummypthisExpenseReport = request.getExpenseReportdummypthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportdummypthisExpenseReport;
        instance.setExpenseReportStatus(expenseReportdummypthisExpenseReport.getExpenseReportStatus());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        // Value expressions for outgoing argument 'expenseReportdummypsResultCode'
        // DEFAULT  : "0"
        response.setExpenseReportdummypsResultCode("0");


        return response;
    }

    // Service: DELETEALL

    /*
     * Entry point for service DELETEALL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse dELETEALL(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.dELETEALLTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DELETEALL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse dELETEALLTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest request) throws ModelException, SystemException {
        request.setExpenseReportDELETEALLptpthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportDELETEALLptpthisExpenseReport()));
        return expenseReportSrv.dELETEALLImplementation(request);
    }

    /*
     * Implements service DELETEALL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse dELETEALLImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportDELETEALLptpthisExpenseReport = request.getExpenseReportDELETEALLptpthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportDELETEALLptpthisExpenseReport;

        for(ExpenseLine step1Entity : repository.assocOperator006(expenseReportDELETEALLptpthisExpenseReport)) {
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest();
            step1Request.setExpenseLinedeletepaidlinepthisExpenseLineInstance(step1Entity);
            expenseLineSrv.deletepaidlineImplementation(step1Request);
        }

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest();
        step2Request.setExpenseReportdelexpensepthisExpenseReportInstance(expenseReportDELETEALLptpthisExpenseReport);
        expenseReportSrv.delexpenseImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: TPAY

    /*
     * Entry point for service TPAY
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tPAY(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.tPAYTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TPAY
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tPAYTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest request) throws ModelException {
        request.setExpenseReportTPAYpsPayTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getExpenseReportTPAYpsPayType()));
        request.setExpenseReportTPAYptpthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportTPAYptpthisExpenseReport()));
        return expenseReportSrv.tPAYImplementation(request);
    }

    /*
     * Implements service TPAY
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tPAYImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Date expenseReportTPAYptpeDate = request.getExpenseReportTPAYptpeDate();
        String expenseReportTPAYpsComments = request.getExpenseReportTPAYpsComments();
        PaymentType expenseReportTPAYpsPayType = request.getExpenseReportTPAYpsPayTypeInstance();
        ExpenseReport expenseReportTPAYptpthisExpenseReport = request.getExpenseReportTPAYptpthisExpenseReportInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportTPAYptpthisExpenseReport;

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest();
        step1Request.setExpenseReportpaypthisExpenseReportInstance(expenseReportTPAYptpthisExpenseReport);
        step1Request.setExpenseReportpaypeDate(expenseReportTPAYptpeDate);
        step1Request.setExpenseReportpaypsComments(expenseReportTPAYpsComments);
        expenseReportSrv.payImplementation(step1Request);

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest();
        step2Request.setExpenseReportInsPaymentTypepthisExpenseReportInstance(expenseReportTPAYptpthisExpenseReport);
        step2Request.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(expenseReportTPAYpsPayType);
        expenseReportSrv.insPaymentTypeImplementation(step2Request, true);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: TNEW

    /*
     * Entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse tNEW(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse();
        try {
            response = expenseReportSrv.tNEWTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse tNEWTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) throws ModelException {
        request.setExpenseReportTNEWptpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getExpenseReportTNEWptpagrEmployee()));
        request.setExpenseReportTNEWptpagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(request.getExpenseReportTNEWptpagrExpenseCurrency())));
        request.setExpenseReportTNEWptpagrProjectInstance(projectSrv.getByOIDWithHV(request.getExpenseReportTNEWptpagrProject()));
        return expenseReportSrv.tNEWImplementation(request);
    }

    /*
     * Implements service TNEW
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse tNEWImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) throws ModelException {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse();
        ExpenseCurrency expenseReportTNEWptpagrExpenseCurrency = request.getExpenseReportTNEWptpagrExpenseCurrencyInstance();
        Project expenseReportTNEWptpagrProject = request.getExpenseReportTNEWptpagrProjectInstance();
        Employee expenseReportTNEWptpagrEmployee = request.getExpenseReportTNEWptpagrEmployeeInstance();
        Date expenseReportTNEWptpatrPresentDate = request.getExpenseReportTNEWptpatrPresentDate();
        String expenseReportTNEWptpatrCause = request.getExpenseReportTNEWptpatrCause();
        Double expenseReportTNEWptpatrAdvances = request.getExpenseReportTNEWptpatrAdvances();

        request.checkArguments();

        tNEWPreconditions(request);
        ExpenseReport instance;

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest();
        step1Request.setExpenseReportnewexpensepagrExpenseCurrencyInstance(expenseReportTNEWptpagrExpenseCurrency);
        step1Request.setExpenseReportnewexpensepagrPaymentTypeInstance(null);
        step1Request.setExpenseReportnewexpensepagrProjectInstance(expenseReportTNEWptpagrProject);
        step1Request.setExpenseReportnewexpensepagrEmployeeInstance(expenseReportTNEWptpagrEmployee);
        step1Request.setExpenseReportnewexpensepatrPresentDate(expenseReportTNEWptpatrPresentDate);
        step1Request.setExpenseReportnewexpensepatrCause(expenseReportTNEWptpatrCause);
        step1Request.setExpenseReportnewexpensepatrAdvances(expenseReportTNEWptpatrAdvances);
        step1Request.setExpenseReportnewexpensepatrExchange(expenseReportTNEWptpagrExpenseCurrency.getExpenseCurrencyExchange());
        instance = (ExpenseReport) expenseReportSrv.newexpenseImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        // Value expressions for outgoing argument 'expenseReportTNEWnewExpenseReport'
        // DEFAULT  : THIS
        response.setExpenseReportTNEWnewExpenseReportInstance(instance);


        return response;
    }

    /*
     * Checks service TNEW preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse tNEWCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse();
        request.setExpenseReportTNEWptpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getExpenseReportTNEWptpagrEmployee()));
        request.setExpenseReportTNEWptpagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(request.getExpenseReportTNEWptpagrExpenseCurrency())));
        request.setExpenseReportTNEWptpagrProjectInstance(projectSrv.getByOIDWithHV(request.getExpenseReportTNEWptpagrProject()));
        try {
            if("Clas_1057569177600553Pre_4".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre4(request);
            if("Clas_1057569177600553Pre_6".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre6(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tNEWPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) 
            throws ModelException {
        checkClas1057569177600553Pre4(request);
        checkClas1057569177600553Pre6(request);
    }

    private void checkClas1057569177600553Pre4 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) 
            throws ModelException {
        // EXIST( ptpagrProject.Assignments ) WHERE (ptpagrProject.Assignments.Employee = ptpagrEmployee AND ptpagrProject.Assignments.IsActive = true AND ptpagrProject.Assignments.FromDate <= ptpatrPresentDate) = true

        Project expenseReportTNEWptpagrProject = request.getExpenseReportTNEWptpagrProjectInstance();
        Employee expenseReportTNEWptpagrEmployee = request.getExpenseReportTNEWptpagrEmployeeInstance();
        Date expenseReportTNEWptpatrPresentDate = request.getExpenseReportTNEWptpatrPresentDate();
        try {
            boolean preconditionHolds = repository.assocOperator001(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Employee " + expenseReportTNEWptpagrEmployee.getEmployeeEmpFullName() + " does not have an active assignment to the project on the date the expense report is presented");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1057569177600553Pre6 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest request) 
            throws ModelException {
        // EXIST( ptpagrProject.Team.Employees ) WHERE (ptpagrProject.Team.Employees = ptpagrEmployee) = true

        Project expenseReportTNEWptpagrProject = request.getExpenseReportTNEWptpagrProjectInstance();
        Employee expenseReportTNEWptpagrEmployee = request.getExpenseReportTNEWptpagrEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator002(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Employee must belong to the team the project is assigned to");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: TREJECTPAYMENT

    /*
     * Entry point for service TREJECTPAYMENT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tREJECTPAYMENT(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseReportSrv.tREJECTPAYMENTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TREJECTPAYMENT
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tREJECTPAYMENTTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest request) throws ModelException {
        request.setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getExpenseReportTREJECTPAYMENTptthisExpenseReport()));
        request.setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getExpenseReportTREJECTPAYMENTptPaymentType()));
        return expenseReportSrv.tREJECTPAYMENTImplementation(request);
    }

    /*
     * Implements service TREJECTPAYMENT
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tREJECTPAYMENTImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseReport expenseReportTREJECTPAYMENTptthisExpenseReport = request.getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance();
        String expenseReportTREJECTPAYMENTptComments = request.getExpenseReportTREJECTPAYMENTptComments();
        PaymentType expenseReportTREJECTPAYMENTptPaymentType = request.getExpenseReportTREJECTPAYMENTptPaymentTypeInstance();

        request.checkArguments();
        ExpenseReport instance = expenseReportTREJECTPAYMENTptthisExpenseReport;

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest();
        step1Request.setExpenseReportrejectpaymentpthisExpenseReportInstance(expenseReportTREJECTPAYMENTptthisExpenseReport);
        step1Request.setExpenseReportrejectpaymentpeComments(expenseReportTREJECTPAYMENTptComments);
        expenseReportSrv.rejectpaymentImplementation(step1Request);

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest();
        step2Request.setExpenseReportDelPaymentTypepthisExpenseReportInstance(expenseReportTREJECTPAYMENTptthisExpenseReport);
        step2Request.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(expenseReportTREJECTPAYMENTptPaymentType);
        expenseReportSrv.delPaymentTypeImplementation(step2Request, true);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        return response;
    }

    // Service: TNEWFROMTEMPLATE

    /*
     * Entry point for service TNEWFROMTEMPLATE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse tNEWFROMTEMPLATE(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse();
        try {
            response = expenseReportSrv.tNEWFROMTEMPLATETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWFROMTEMPLATE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse tNEWFROMTEMPLATETxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) throws ModelException, SystemException {
        request.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee()));
        request.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(request.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency())));
        request.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(projectSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEptpagrProject()));
        request.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEpTemplate()));
        return expenseReportSrv.tNEWFROMTEMPLATEImplementation(request);
    }

    /*
     * Implements service TNEWFROMTEMPLATE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse tNEWFROMTEMPLATEImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) throws ModelException, SystemException {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse();
        ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate = request.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance();
        ExpenseCurrency expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency = request.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance();
        Project expenseReportTNEWFROMTEMPLATEptpagrProject = request.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance();
        Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee = request.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance();
        Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate = request.getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate();
        String expenseReportTNEWFROMTEMPLATEptpatrCause = request.getExpenseReportTNEWFROMTEMPLATEptpatrCause();
        Double expenseReportTNEWFROMTEMPLATEptpatrAdvances = request.getExpenseReportTNEWFROMTEMPLATEptpatrAdvances();

        request.checkArguments();

        tNEWFROMTEMPLATEPreconditions(request);
        ExpenseReport instance;

        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest();
        step1Request.setExpenseReportnewexpensepagrExpenseCurrencyInstance(expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency);
        step1Request.setExpenseReportnewexpensepagrPaymentTypeInstance(null);
        step1Request.setExpenseReportnewexpensepagrProjectInstance(expenseReportTNEWFROMTEMPLATEptpagrProject);
        step1Request.setExpenseReportnewexpensepagrEmployeeInstance(expenseReportTNEWFROMTEMPLATEptpagrEmployee);
        step1Request.setExpenseReportnewexpensepatrPresentDate(expenseReportTNEWFROMTEMPLATEptpatrPresentDate);
        step1Request.setExpenseReportnewexpensepatrCause(expenseReportTNEWFROMTEMPLATEptpatrCause);
        step1Request.setExpenseReportnewexpensepatrAdvances(expenseReportTNEWFROMTEMPLATEptpatrAdvances);
        step1Request.setExpenseReportnewexpensepatrExchange(expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency.getExpenseCurrencyExchange());
        instance = (ExpenseReport) expenseReportSrv.newexpenseImplementation(step1Request).getInstance();

        for(ERLTemplate step2Entity : repository.assocOperator007(expenseReportTNEWFROMTEMPLATEpTemplate)) {
            com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest();
            step2Request.setExpenseLinenewlinepagrExpenseTypeInstance(step2Entity.getExpenseType());
            step2Request.setExpenseLinenewlinepagrExpenseReportInstance(instance);
            step2Request.setExpenseLinenewlinepatrUnits(step2Entity.getERLTemplateunits());
            step2Request.setExpenseLinenewlinepatrPrice(step2Entity.getERLTemplateprice());
            step2Request.setExpenseLinenewlinepatrExpenseDate(expenseReportTNEWFROMTEMPLATEptpatrPresentDate);
            step2Request.setExpenseLinenewlinepatrLnDescription(step2Entity.getERLTemplatedescription());
            expenseLineSrv.newlineImplementation(step2Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseReportSup());

        // Value expressions for outgoing argument 'expenseReportTNEWFROMTEMPLATEnewExpenseReport'
        // DEFAULT  : THIS
        response.setExpenseReportTNEWFROMTEMPLATEnewExpenseReportInstance(instance);


        // Value expressions for outgoing argument 'expenseReportTNEWFROMTEMPLATEpsNumberOfLines'
        // DEFAULT  : COUNT(pTemplate.TemplateLines)
        response.setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines(repository.assocOperator008(expenseReportTNEWFROMTEMPLATEpTemplate));


        return response;
    }

    /*
     * Checks service TNEWFROMTEMPLATE preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse tNEWFROMTEMPLATECheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse response = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse();
        request.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee()));
        request.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(request.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency())));
        request.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(projectSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEptpagrProject()));
        request.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getExpenseReportTNEWFROMTEMPLATEpTemplate()));
        try {
            if("Clas_1057569177600553Pre_7".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre7(request);
            if("Clas_1057569177600553Pre_8".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre8(request);
            if("Clas_1057569177600553Pre_9".equals(request.getPreconditionId()))
                checkClas1057569177600553Pre9(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tNEWFROMTEMPLATEPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) 
            throws ModelException {
        checkClas1057569177600553Pre7(request);
        checkClas1057569177600553Pre8(request);
        checkClas1057569177600553Pre9(request);
    }

    private void checkClas1057569177600553Pre7 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) 
            throws ModelException {
        // EXIST( ptpagrProject.Assignments ) WHERE (ptpagrProject.Assignments.Employee = ptpagrEmployee AND ptpagrProject.Assignments.IsActive = true AND ptpagrProject.Assignments.FromDate <= ptpatrPresentDate) = true

        Project expenseReportTNEWFROMTEMPLATEptpagrProject = request.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance();
        Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee = request.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance();
        Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate = request.getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate();
        try {
            boolean preconditionHolds = repository.assocOperator003(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee, expenseReportTNEWFROMTEMPLATEptpatrPresentDate).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Employee " + expenseReportTNEWFROMTEMPLATEptpagrEmployee.getEmployeeEmpFullName() + " does not have an active assignment to the project on the date the expense report is presented");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1057569177600553Pre8 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) 
            throws ModelException {
        // EXIST( ptpagrProject.Team.Employees ) WHERE (ptpagrProject.Team.Employees = ptpagrEmployee) = true

        Project expenseReportTNEWFROMTEMPLATEptpagrProject = request.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance();
        Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee = request.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator004(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Employee must belong to the team the project is assigned to");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1057569177600553Pre9 (
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest request) 
            throws ModelException {
        // EXIST( ptpagrProject.ERTemplates ) WHERE (ptpagrProject.ERTemplates = pTemplate) = true

        Project expenseReportTNEWFROMTEMPLATEptpagrProject = request.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance();
        ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate = request.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance();
        try {
            boolean preconditionHolds = repository.assocOperator005(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEpTemplate).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Template must be assigned to project");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCExpenseReportDate(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }

    private Stream<ExpenseReport> applyOrderCriteriaInMemory(QueryRequest queryRequest, Stream<ExpenseReport> instances){
        if ("OC_ExpenseReportAmount".equalsIgnoreCase(queryRequest.getOrderCriteriaName()))
            return applyOCInMemoryOCExpenseReportAmount(instances);
        return instances;
    }
    

    private void applyOCOCExpenseReportDate(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_ExpenseReportDate".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPRESENTDATE, false), false);
        }
    }

    private Stream<ExpenseReport> applyOCInMemoryOCExpenseReportAmount(Stream<ExpenseReport> instances) {
        return instances.sorted((i1, i2) -> (-1) * Double.compare(i1.getExpenseReportTotExpenses(), i2.getExpenseReportTotExpenses()) + (-1) * Double.compare(i1.getExpenseReportAdvances(), i2.getExpenseReportAdvances()));
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildExpenseReportRelatedInstance(relatedInstanceJsonOid);
        }
        if (ExpenseReportConstants.ROLE_NAME_EXPENSELINES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseReportRelatedInstance4ExpenseLine(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseReportConstants.ROLE_NAME_EMPLOYEE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseReportRelatedInstance4Employee(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseReportRelatedInstance4ExpenseCurrency(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseReportRelatedInstance4PaymentType(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseReportConstants.ROLE_NAME_PROJECT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseReportRelatedInstance4Project(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildExpenseReportRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseReportRelatedInstance4ExpenseLine(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseLine(mapper.readValue(relatedInstanceJsonOid, ExpenseLineOid.class)): expenseLineSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseReportRelatedInstance4Employee(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Employee(mapper.readValue(relatedInstanceJsonOid, EmployeeOid.class)): employeeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseReportRelatedInstance4ExpenseCurrency(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseCurrency(mapper.readValue(relatedInstanceJsonOid, ExpenseCurrencyOid.class)): expenseCurrencySrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseReportRelatedInstance4PaymentType(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PaymentType(mapper.readValue(relatedInstanceJsonOid, PaymentTypeOid.class)): paymentTypeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseReportRelatedInstance4Project(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Project(mapper.readValue(relatedInstanceJsonOid, ProjectOid.class)): projectSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ExpenseReportOid oid = new ExpenseReportOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseReportConstants.ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseReportidExpenseRepor(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExpenseReportService.class).error(e.getMessage());
        }
    }

}
