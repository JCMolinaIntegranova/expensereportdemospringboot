package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeJpaRepository extends JpaRepository<ExpenseType, String> {
    List<ExpenseType> solveQuery(SQLSelect query);
    
    List<ExpenseType> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ExpenseType> findByExpenseLines(ExpenseLine expenseLines);

    List<ExpenseType> findByTemplateLines(ERLTemplate templateLines);
}
