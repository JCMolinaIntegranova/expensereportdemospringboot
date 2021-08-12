package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface TeamJpaRepositoryCustom {

    public List<Team> executeQuery(String query);

    public List<Team> executeQuery(String query, List<SQLParam> params);
}
