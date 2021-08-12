package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface AssignmentJpaRepositoryCustom {

    public List<Assignment> executeQuery(String query);

    public List<Assignment> executeQuery(String query, List<SQLParam> params);
}
