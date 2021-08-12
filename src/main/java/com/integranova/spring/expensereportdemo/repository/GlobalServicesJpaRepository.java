package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<Project> assocOperator000(Double gLOBALTESTpTotExpenses, String gLOBALTESTpProjectName) throws SystemException;

    Collection<ExpenseReport> assocOperator001() throws SystemException;

    Long assocOperator002() throws SystemException;
}
