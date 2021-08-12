package com.integranova.spring.expensereportdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.integranova.spring.expensereportdemo.sqlutils.NativeQueryBuilder;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;

@Service
public class GenericRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Object> solveQuery(SQLSelect query) {
        return new NativeQueryBuilder(em).build(query).execute();
    }

    public List<Object> solveQuery(SQLSelect query, List<SQLParam> params) {
        return new NativeQueryBuilder(em).build(query).setParameters(params).execute();
    }
    
    public Object solveNativeScalarQuery(String queryText) {
    	return new NativeQueryBuilder(em).build(queryText).getSingleResult();
    }
    
    public Object solveNativeScalarQuery(String queryText, List<SQLParam> params) {
    	return new NativeQueryBuilder(em).build(queryText).setParameters(params).getSingleResult();
    }
    
    public List<Object> solveNativeQuery(String queryText) {
    	return new NativeQueryBuilder(em).build(queryText).execute();
    }
    
    public List<Object> solveNativeQuery(String queryText, List<SQLParam> params) {
    	return new NativeQueryBuilder(em).build(queryText).setParameters(params).execute();
    }

    public SPBuilder getSPBuilder() {
    	return new SPBuilder(em);
    }
}

