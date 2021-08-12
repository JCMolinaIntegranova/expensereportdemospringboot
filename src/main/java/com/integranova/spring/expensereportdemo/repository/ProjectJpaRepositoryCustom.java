package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ProjectJpaRepositoryCustom {

    public List<Project> executeQuery(String query);

    public List<Project> executeQuery(String query, List<SQLParam> params);
}
