package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
    List<Project> solveQuery(SQLSelect query);
    
    List<Project> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<Project> findByExpenseReport(ExpenseReport expenseReport);

    List<Project> findByAssignments(Assignment assignments);

    List<Project> findByTeam(Team team);

    List<Project> findByERTemplates(ERTemplate eRTemplates);

    Boolean assocOperator000(Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException;

    Collection<Assignment> assocOperator000Range1(Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate);
    
    SQLPopulation assocOperator000Range1Query(Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate);

    Double assocOperator001(Project instance) throws SystemException;

    Collection<ExpenseReport> assocOperator001Range1(Project instance);
    
    SQLPopulation assocOperator001Range1Query(Project instance);

    Double assocOperator002(Project instance) throws SystemException;

    Collection<ExpenseReport> assocOperator002Range1(Project instance);
    
    SQLPopulation assocOperator002Range1Query(Project instance);

    Double assocOperator003(Project instance) throws SystemException;

    Collection<ExpenseReport> assocOperator003Range1(Project instance);
    
    SQLPopulation assocOperator003Range1Query(Project instance);

    Double assocOperator004(Project instance) throws SystemException;

    Collection<ExpenseReport> assocOperator004Range1(Project instance);
    
    SQLPopulation assocOperator004Range1Query(Project instance);

    Collection<Assignment> assocOperator005(Project instance) throws SystemException;

    Collection<Assignment> assocOperator005Range1(Project instance);
    
    SQLPopulation assocOperator005Range1Query(Project instance);
}
