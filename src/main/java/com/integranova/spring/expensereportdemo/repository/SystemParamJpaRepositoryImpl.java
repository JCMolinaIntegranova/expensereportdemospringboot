package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class SystemParamJpaRepositoryImpl extends AbstractRepository implements SystemParamJpaRepositoryCustom {

    @Override
    public List<SystemParam> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<SystemParam> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<SystemParam> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<SystemParam> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, SystemParam.class);
    }
    
    public List<SystemParam> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<SystemParam> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
