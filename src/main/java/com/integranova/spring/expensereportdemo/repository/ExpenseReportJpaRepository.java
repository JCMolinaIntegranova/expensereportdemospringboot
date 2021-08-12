package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseReportJpaRepository extends JpaRepository<ExpenseReport, Long> {
    List<ExpenseReport> solveQuery(SQLSelect query);
    
    List<ExpenseReport> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ExpenseReport> findByExpenseLines(ExpenseLine expenseLines);

    List<ExpenseReport> findByEmployee(Employee employee);

    List<ExpenseReport> findByExpenseCurrency(ExpenseCurrency expenseCurrency);

    List<ExpenseReport> findByPaymentType(PaymentType paymentType);

    List<ExpenseReport> findByProject(Project project);

    Double assocOperator000(ExpenseReport instance) throws SystemException;

    Collection<ExpenseLine> assocOperator000Range1(ExpenseReport instance);
    
    SQLPopulation assocOperator000Range1Query(ExpenseReport instance);

    Boolean assocOperator001(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException;

    Collection<Assignment> assocOperator001Range1(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate);
    
    SQLPopulation assocOperator001Range1Query(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate);

    Boolean assocOperator002(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee) throws SystemException;

    Boolean assocOperator002Range1(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee);
    
    SQLExists assocOperator002Range1Query(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, SQLSelect superQuery);

    Boolean assocOperator003(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate) throws SystemException;

    Collection<Assignment> assocOperator003Range1(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate);
    
    SQLPopulation assocOperator003Range1Query(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate);

    Boolean assocOperator004(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee) throws SystemException;

    Boolean assocOperator004Range1(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee);
    
    SQLExists assocOperator004Range1Query(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, SQLSelect superQuery);

    Boolean assocOperator005(Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException;

    Boolean assocOperator005Range1(Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate);
    
    SQLExists assocOperator005Range1Query(Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate, SQLSelect superQuery);

    Collection<ExpenseLine> assocOperator006(ExpenseReport instance) throws SystemException;

    Collection<ExpenseLine> assocOperator006Range1(ExpenseReport instance);
    
    SQLPopulation assocOperator006Range1Query(ExpenseReport instance);

    Collection<ERLTemplate> assocOperator007(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException;

    Collection<ERLTemplate> assocOperator007Range1(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate);
    
    SQLPopulation assocOperator007Range1Query(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate);

    Long assocOperator008(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException;

    Long assocOperator008Range1(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate);
    
    SQLCount assocOperator008Range1Query(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate, SQLSelect superQuery);
}
