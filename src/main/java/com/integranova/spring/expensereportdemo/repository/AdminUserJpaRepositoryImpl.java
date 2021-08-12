package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLJoin;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class AdminUserJpaRepositoryImpl extends AbstractRepository implements AdminUserJpaRepositoryCustom {

    @Override
    public List<AdminUser> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<AdminUser> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<AdminUser> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<AdminUser> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, AdminUser.class);
    }
    
    public List<AdminUser> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<AdminUser> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public AppUser findParent(String oid) {
        return em.find(AppUser.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param parentAlias Alias of the parent entity.
     */
    public void addFacetWhereparentappuser (String myAlias, SQLJoin join, String parentAlias) {
        join.getWheres().add(myAlias + "." + AdminUserConstants.FLD_APPUSERLOGIN + " = " + parentAlias + "." + AppUserConstants.ATTR_FIELD_APPUSERLOGIN);
    }
}
