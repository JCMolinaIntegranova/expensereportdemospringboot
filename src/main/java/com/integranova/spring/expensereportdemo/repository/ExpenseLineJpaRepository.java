package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseLineJpaRepository extends JpaRepository<ExpenseLine, ExpenseLineOid> {
    List<ExpenseLine> solveQuery(SQLSelect query);
    
    List<ExpenseLine> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ExpenseLine> findByExpenseType(ExpenseType expenseType);

    List<ExpenseLine> findByExpenseReport(ExpenseReport expenseReport);
    
    Long nextExpenseLineidExpenseLine(Long expenseReportidExpenseRepor);
}
