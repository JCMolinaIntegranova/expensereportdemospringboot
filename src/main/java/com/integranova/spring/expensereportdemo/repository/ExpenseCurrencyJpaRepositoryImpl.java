package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ExpenseCurrencyJpaRepositoryImpl extends AbstractRepository implements ExpenseCurrencyJpaRepositoryCustom {

    @Override
    public List<ExpenseCurrency> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ExpenseCurrency> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ExpenseCurrency> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ExpenseCurrency> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ExpenseCurrency.class);
    }
    
    public List<ExpenseCurrency> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ExpenseCurrency> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
