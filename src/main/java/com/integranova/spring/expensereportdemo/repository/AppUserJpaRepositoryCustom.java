package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface AppUserJpaRepositoryCustom {

    public List<AppUser> executeQuery(String query);

    public List<AppUser> executeQuery(String query, List<SQLParam> params);
}
