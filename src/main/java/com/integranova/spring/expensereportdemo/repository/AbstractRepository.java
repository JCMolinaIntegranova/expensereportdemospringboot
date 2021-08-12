package com.integranova.spring.expensereportdemo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.integranova.spring.expensereportdemo.global.UserFunctions;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import com.integranova.spring.expensereportdemo.utils.Agent;

public class AbstractRepository {
    
    @Autowired
    protected Agent agent;

    @Autowired
    protected UserFunctions userFunctionsSrv;

    @PersistenceContext
    protected EntityManager em;
    
    public void setEntityManager(EntityManager em) {
    	this.em = em;
    }

    public int solveCountQuery(SQLSelect select) {
        return new TypedQueryBuilder<>(em, Long.class).build4Count(select).getSingleResult().intValue();
    }
}
