package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
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

public class ExpenseLineJpaRepositoryImpl extends AbstractRepository implements ExpenseLineJpaRepositoryCustom {

    @Override
    public List<ExpenseLine> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ExpenseLine> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ExpenseLine> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ExpenseLine> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ExpenseLine.class);
    }
    
    public List<ExpenseLine> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ExpenseLine> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextExpenseLineidExpenseLine(Long expenseReportidExpenseRepor) {
        try {
            SQLMax sql = new SQLMax(null, ExpenseLineConstants.CLASS_NAME, ExpenseLineConstants.CLASS_NAME + "." + ExpenseLineConstants.ATTR_FIELD_EXPENSELINEIDEXPENSELINE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT + "." + ExpenseReportConstants.ATTR_FIELD_EXPENSEREPORTIDEXPENSEREPOR, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(expenseReportidExpenseRepor, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExpenseLine.class).error(e.getMessage());
            return 1L;
        }
    }
}
