package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface AdminUserJpaRepositoryCustom {

    public List<AdminUser> executeQuery(String query);

    public List<AdminUser> executeQuery(String query, List<SQLParam> params);
}
