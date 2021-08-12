package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ERTemplateJpaRepository extends JpaRepository<ERTemplate, Long> {
    List<ERTemplate> solveQuery(SQLSelect query);
    
    List<ERTemplate> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ERTemplate> findByProjects(Project projects);

    List<ERTemplate> findByTemplateLines(ERLTemplate templateLines);

    Boolean assocOperator000(Project expenseReportTNEWFROMTEMPLATEptpagrProject) throws SystemException;

    Boolean assocOperator000Range1(Project expenseReportTNEWFROMTEMPLATEptpagrProject);
    
    SQLExists assocOperator000Range1Query(Project expenseReportTNEWFROMTEMPLATEptpagrProject, SQLSelect superQuery);

    Double assocOperator001(ERTemplate instance) throws SystemException;

    Collection<ERLTemplate> assocOperator001Range1(ERTemplate instance);
    
    SQLPopulation assocOperator001Range1Query(ERTemplate instance);
}
