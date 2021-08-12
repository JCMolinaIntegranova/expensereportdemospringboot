package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface SystemParamJpaRepositoryCustom {

    public List<SystemParam> executeQuery(String query);

    public List<SystemParam> executeQuery(String query, List<SQLParam> params);
}
