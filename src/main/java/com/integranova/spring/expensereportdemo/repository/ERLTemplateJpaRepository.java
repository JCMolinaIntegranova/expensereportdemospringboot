package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ERLTemplateJpaRepository extends JpaRepository<ERLTemplate, ERLTemplateOid> {
    List<ERLTemplate> solveQuery(SQLSelect query);
    
    List<ERLTemplate> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ERLTemplate> findByTemplate(ERTemplate template);

    List<ERLTemplate> findByExpenseType(ExpenseType expenseType);
    
    Long nextERLTemplateid(Long eRTemplateTemplateid);
}
