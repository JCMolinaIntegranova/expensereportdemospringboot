package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ExchangeHistoryJpaRepositoryImpl extends AbstractRepository implements ExchangeHistoryJpaRepositoryCustom {

    @Override
    public List<ExchangeHistory> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ExchangeHistory> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ExchangeHistory> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ExchangeHistory> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ExchangeHistory.class);
    }
    
    public List<ExchangeHistory> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ExchangeHistory> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
