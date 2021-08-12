package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeHistoryJpaRepository extends JpaRepository<ExchangeHistory, ExchangeHistoryOid> {
    List<ExchangeHistory> solveQuery(SQLSelect query);
    
    List<ExchangeHistory> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    List<ExchangeHistory> findByExpenseCurrency(ExpenseCurrency expenseCurrency);
}
