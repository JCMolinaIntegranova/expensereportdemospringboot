package com.integranova.spring.expensereportdemo.service;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.GlobalServicesJpaRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GlobalServicesService extends AbstractService {

    @Autowired
    private GlobalServicesService globalServicesSrv;

    @Autowired
    private ProjectService projectSrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;

    @Autowired
    private GlobalServicesJpaRepository globalServicesRepository;

    /*
     * Entry point for global service GLOBALTEST
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse gLOBALTEST(
            com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse response = new com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse();
        try {
            response = globalServicesSrv.gLOBALTESTTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service GLOBALTEST
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse gLOBALTESTTxn(
            com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest request) throws ModelException, SystemException {
        return globalServicesSrv.gLOBALTESTImplementation(request);
    }

    /*
     * Implements global service GLOBALTEST
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse gLOBALTESTImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest request) throws ModelException, SystemException {
        com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse response = new com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse();
        Double gLOBALTESTpTotExpenses = request.getGLOBALTESTpTotExpenses();
        String gLOBALTESTpProjectName = request.getGLOBALTESTpProjectName();

        request.checkArguments();

        gLOBALTESTPreconditions();

        for(Project step1Entity : globalServicesRepository.assocOperator000(gLOBALTESTpTotExpenses, gLOBALTESTpProjectName)) {
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest();
            step1Request.setProjectdeleteinstancepthisProjectInstance(step1Entity);
            projectSrv.deleteinstanceImplementation(step1Request);
        }

        for(ExpenseReport step2Entity : globalServicesRepository.assocOperator001()) {
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest();
            step2Request.setExpenseReportdummypthisExpenseReportInstance(step2Entity);
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse step2Response = expenseReportSrv.dummyImplementation(step2Request);
        response.setGLOBALTESTpsResultCode(step2Response.getExpenseReportdummypsResultCode());
        }
        return response;
    }

    /*
     * Checks service GLOBALTEST preconditions individually
     * @param request Service request viewmodel
     * @returns Service response viewmodel with the execution results
     */
    public com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse gLOBALTESTCheckPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest request) {
        com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse response = new com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTResponse();
        try {
            if("IGl_1539588620288177Pre_1".equals(request.getPreconditionId()))
                checkIGl1539588620288177Pre1();
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void gLOBALTESTPreconditions() throws ModelException {
        checkIGl1539588620288177Pre1();
    }

    private void checkIGl1539588620288177Pre1 () throws ModelException {
        // COUNT( Project ) > 0

        try {
            boolean preconditionHolds = globalServicesRepository.assocOperator002() > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("There must be some project");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }
}
