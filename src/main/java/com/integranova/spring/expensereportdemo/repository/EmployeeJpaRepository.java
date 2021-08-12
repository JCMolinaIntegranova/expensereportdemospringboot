package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {
    List<Employee> solveQuery(SQLSelect query);
    
    List<Employee> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<Employee> findByExpenseReports(ExpenseReport expenseReports);

    List<Employee> findByAssignments(Assignment assignments);

    List<Employee> findByTeams(Team teams);

    Long assocOperator000(Employee instance) throws SystemException;

    Long assocOperator000Range1(Employee instance);
    
    SQLCount assocOperator000Range1Query(Employee instance);

    Boolean assocOperator001(Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException;

    Boolean assocOperator001Range1(Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee);
    
    SQLExists assocOperator001Range1Query(Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee, SQLSelect superQuery);

    Long assocOperator002(Team employeeaddEmployeeToTeampevcTeam) throws SystemException;

    Long assocOperator002Range1(Team employeeaddEmployeeToTeampevcTeam);
    
    SQLCount assocOperator002Range1Query(Team employeeaddEmployeeToTeampevcTeam, SQLSelect superQuery);

    Collection<Assignment> assocOperator003(Employee instance) throws SystemException;

    Collection<Assignment> assocOperator003Range1(Employee instance);
    
    SQLPopulation assocOperator003Range1Query(Employee instance);

    Collection<Assignment> assocOperator004(Employee instance) throws SystemException;

    Collection<Assignment> assocOperator004Range1(Employee instance);
    
    SQLPopulation assocOperator004Range1Query(Employee instance);

    Collection<Team> assocOperator005(Employee instance, Employee employeeTDELETEpthisEmployee) throws SystemException;

    Collection<Team> assocOperator005Range1(Employee instance);
    
    SQLPopulation assocOperator005Range1Query(Employee instance);

    Collection<ExpenseReport> assocOperator006(Employee instance) throws SystemException;

    Collection<ExpenseReport> assocOperator006Range1(Employee instance);
    
    SQLPopulation assocOperator006Range1Query(Employee instance);
}
