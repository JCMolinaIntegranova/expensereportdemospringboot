package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLForAllDistinct;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamJpaRepository extends JpaRepository<Team, Long> {
    List<Team> solveQuery(SQLSelect query);
    
    List<Team> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<Team> findByEmployees(Employee employees);

    List<Team> findByProjects(Project projects);

    Boolean assocOperator000(Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException;

    Boolean assocOperator000Range1(Employee employeeaddEmployeeToTeampthisEmployee);
    
    SQLExists assocOperator000Range1Query(Employee employeeaddEmployeeToTeampthisEmployee, SQLSelect superQuery);

    Boolean assocOperator001(Employee employeeremoveEmployeeFromTeampthisEmployee) throws SystemException;

    Boolean assocOperator001Range1(Employee employeeremoveEmployeeFromTeampthisEmployee);
    
    SQLExists assocOperator001Range1Query(Employee employeeremoveEmployeeFromTeampthisEmployee, SQLSelect superQuery);

    Boolean assocOperator002(Team instance) throws SystemException;

    Boolean assocOperator002Range1(Team instance);
    
    SQLExists assocOperator002Range1Query(Team instance);

    Long assocOperator003(Team instance) throws SystemException;

    Long assocOperator003Range1(Team instance);
    
    SQLCount assocOperator003Range1Query(Team instance);

    Double assocOperator004(Team instance) throws SystemException;

    Collection<ExpenseReport> assocOperator004Range1(Team instance);
    
    SQLPopulation assocOperator004Range1Query(Team instance);

    Boolean assocOperator005(Team instance) throws SystemException;

    Boolean assocOperator005Range1(Team instance);
    
    SQLForAllDistinct assocOperator005Range1Query(Team instance);
}
