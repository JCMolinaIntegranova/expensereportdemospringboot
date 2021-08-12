package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ERLTemplateJpaRepositoryCustom {

    public List<ERLTemplate> executeQuery(String query);

    public List<ERLTemplate> executeQuery(String query, List<SQLParam> params);
}
