package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class PaymentTypeJpaRepositoryImpl extends AbstractRepository implements PaymentTypeJpaRepositoryCustom {

    @Override
    public List<PaymentType> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<PaymentType> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<PaymentType> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<PaymentType> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, PaymentType.class);
    }
    
    public List<PaymentType> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<PaymentType> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
