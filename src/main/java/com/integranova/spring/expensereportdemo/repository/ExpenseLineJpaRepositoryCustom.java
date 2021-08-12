package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ExpenseLineJpaRepositoryCustom {

    public List<ExpenseLine> executeQuery(String query);

    public List<ExpenseLine> executeQuery(String query, List<SQLParam> params);
}
