package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ExpenseReportJpaRepositoryCustom {

    public List<ExpenseReport> executeQuery(String query);

    public List<ExpenseReport> executeQuery(String query, List<SQLParam> params);
}
