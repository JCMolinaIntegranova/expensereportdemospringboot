package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserJpaRepository extends JpaRepository<AppUser, String> {
    List<AppUser> solveQuery(SQLSelect query);
    
    List<AppUser> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    AdminUser findChildAdminUser(String oid);

    OperatorUser findChildOperatorUser(String oid);
}
