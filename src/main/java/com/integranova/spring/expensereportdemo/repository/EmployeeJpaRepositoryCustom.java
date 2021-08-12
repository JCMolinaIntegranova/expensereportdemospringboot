package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface EmployeeJpaRepositoryCustom {

    public List<Employee> executeQuery(String query);

    public List<Employee> executeQuery(String query, List<SQLParam> params);
}
