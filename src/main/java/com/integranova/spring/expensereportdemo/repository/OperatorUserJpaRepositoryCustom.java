package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface OperatorUserJpaRepositoryCustom {

    public List<OperatorUser> executeQuery(String query);

    public List<OperatorUser> executeQuery(String query, List<SQLParam> params);
}
