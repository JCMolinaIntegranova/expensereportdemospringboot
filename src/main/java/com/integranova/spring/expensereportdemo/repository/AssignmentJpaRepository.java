package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> solveQuery(SQLSelect query);
    
    List<Assignment> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<Assignment> findByEmployee(Employee employee);

    List<Assignment> findByProject(Project project);

    Boolean assocOperator000(Employee assignmentnewAssignmentpagrEmployee) throws SystemException;

    Collection<Assignment> assocOperator000Range1(Employee assignmentnewAssignmentpagrEmployee);
    
    SQLPopulation assocOperator000Range1Query(Employee assignmentnewAssignmentpagrEmployee);

    Boolean assocOperator001(Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee) throws SystemException;

    Boolean assocOperator001Range1(Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee);
    
    SQLExists assocOperator001Range1Query(Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee, SQLSelect superQuery);
}
