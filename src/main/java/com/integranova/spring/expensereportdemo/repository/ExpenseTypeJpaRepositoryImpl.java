package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ExpenseTypeJpaRepositoryImpl extends AbstractRepository implements ExpenseTypeJpaRepositoryCustom {

    @Override
    public List<ExpenseType> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ExpenseType> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ExpenseType> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ExpenseType> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ExpenseType.class);
    }
    
    public List<ExpenseType> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ExpenseType> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
