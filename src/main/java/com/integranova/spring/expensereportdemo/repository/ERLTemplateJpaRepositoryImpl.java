package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.sqlutils.SQLMax;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;

public class ERLTemplateJpaRepositoryImpl extends AbstractRepository implements ERLTemplateJpaRepositoryCustom {

    @Override
    public List<ERLTemplate> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ERLTemplate> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ERLTemplate> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ERLTemplate> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ERLTemplate.class);
    }
    
    public List<ERLTemplate> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ERLTemplate> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextERLTemplateid(Long eRTemplateTemplateid) {
        try {
            SQLMax sql = new SQLMax(null, ERLTemplateConstants.CLASS_NAME, ERLTemplateConstants.CLASS_NAME + "." + ERLTemplateConstants.ATTR_FIELD_ERLTEMPLATEID);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ERLTemplateConstants.ROLE_NAME_TEMPLATE + "." + ERTemplateConstants.ATTR_FIELD_ERTEMPLATEID, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(eRTemplateTemplateid, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(ERLTemplate.class).error(e.getMessage());
            return 1L;
        }
    }
}
