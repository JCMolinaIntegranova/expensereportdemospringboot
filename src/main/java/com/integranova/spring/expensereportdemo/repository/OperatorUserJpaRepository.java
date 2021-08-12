package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorUserJpaRepository extends JpaRepository<OperatorUser, String> {
    List<OperatorUser> solveQuery(SQLSelect query);
    
    List<OperatorUser> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    AppUser findParent(String oid);
}
