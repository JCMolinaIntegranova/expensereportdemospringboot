package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCurrencyJpaRepository extends JpaRepository<ExpenseCurrency, String> {
    List<ExpenseCurrency> solveQuery(SQLSelect query);
    
    List<ExpenseCurrency> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ExpenseCurrency> findByExpenseReports(ExpenseReport expenseReports);

    List<ExpenseCurrency> findByExchangeHistoryItems(ExchangeHistory exchangeHistoryItems);
}
