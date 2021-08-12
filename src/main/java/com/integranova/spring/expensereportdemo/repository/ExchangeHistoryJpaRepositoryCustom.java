package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ExchangeHistoryJpaRepositoryCustom {

    public List<ExchangeHistory> executeQuery(String query);

    public List<ExchangeHistory> executeQuery(String query, List<SQLParam> params);
}
