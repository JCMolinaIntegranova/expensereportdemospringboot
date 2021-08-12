package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;

public interface PaymentTypeJpaRepositoryCustom {

    public List<PaymentType> executeQuery(String query);

    public List<PaymentType> executeQuery(String query, List<SQLParam> params);
}
