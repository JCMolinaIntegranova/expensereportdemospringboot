package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ExpenseCurrencyJpaRepositoryCustom {

    public List<ExpenseCurrency> executeQuery(String query);

    public List<ExpenseCurrency> executeQuery(String query, List<SQLParam> params);
}
