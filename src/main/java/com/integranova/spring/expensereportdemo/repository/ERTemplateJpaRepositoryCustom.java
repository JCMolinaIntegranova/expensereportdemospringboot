package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface ERTemplateJpaRepositoryCustom {

    public List<ERTemplate> executeQuery(String query);

    public List<ERTemplate> executeQuery(String query, List<SQLParam> params);
}
