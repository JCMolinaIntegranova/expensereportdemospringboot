package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLJoin;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class AppUserJpaRepositoryImpl extends AbstractRepository implements AppUserJpaRepositoryCustom {

    @Override
    public List<AppUser> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<AppUser> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<AppUser> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<AppUser> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, AppUser.class);
    }
    
    public List<AppUser> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<AppUser> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public AdminUser findChildAdminUser(String oid) {
        return em.find(AdminUser.class, oid);
    }

    public OperatorUser findChildOperatorUser(String oid) {
        return em.find(OperatorUser.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereadminuser (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + AppUserConstants.ATTR_FIELD_APPUSERLOGIN + " = " + childAlias + "." + AdminUserConstants.FLD_APPUSERLOGIN);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereoperatoruser (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + AppUserConstants.ATTR_FIELD_APPUSERLOGIN + " = " + childAlias + "." + OperatorUserConstants.FLD_APPUSERLOGIN);
    }

}
