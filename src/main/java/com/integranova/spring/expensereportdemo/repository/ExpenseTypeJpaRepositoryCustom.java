package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ExpenseTypeJpaRepositoryCustom {

    public List<ExpenseType> executeQuery(String query);

    public List<ExpenseType> executeQuery(String query, List<SQLParam> params);
}
