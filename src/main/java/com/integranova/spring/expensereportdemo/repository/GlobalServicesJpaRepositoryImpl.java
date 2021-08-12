package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class GlobalServicesJpaRepositoryImpl extends AbstractRepository implements GlobalServicesJpaRepository {

    // AssocOperator: AssocOperator000
    public Collection<Project> assocOperator000(Double gLOBALTESTpTotExpenses, String gLOBALTESTpProjectName) throws SystemException {
        try {
            // FOR ALL Project WHERE (Project.TotExpenses = pTotExpenses AND Project.ProjectName = pProjectName) DO Project.deleteinstance(Project)
            Collection<Project> results = new ArrayList<>();
            for(Project item : assocOperator000Range1(gLOBALTESTpProjectName)) {
                // Project.TotExpenses = pTotExpenses
                if(Double.valueOf(item.getProjectTotExpenses()).equals(gLOBALTESTpTotExpenses))
                    results.add(item);
            }
            return results;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }



    public Collection<Project> assocOperator000Range1 (String gLOBALTESTpProjectName) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(gLOBALTESTpProjectName);
        return new TypedQueryBuilder<Project>(em, Project.class).build(sql).execute();
    }


    public SQLPopulation assocOperator000Range1Query (String gLOBALTESTpProjectName) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProjectConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Project.ProjectName = pProjectName
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProjectConstants.CLASS_NAME + "." + ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(gLOBALTESTpProjectName, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }
    // AssocOperator: AssocOperator001
    public Collection<ExpenseReport> assocOperator001() throws SystemException {
        try {
            // FOR ALL ExpenseReport DO ExpenseReport.dummy(ExpenseReport; psResultCode)
            return assocOperator001Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }



    public Collection<ExpenseReport> assocOperator001Range1 () throws SystemException {

        SQLSelect sql = assocOperator001Range1Query();
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }


    public SQLPopulation assocOperator001Range1Query () throws SystemException {
        try {
            return new SQLPopulation("", ExpenseReportConstants.CLASS_NAME);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }
    // AssocOperator: AssocOperator002
    public Long assocOperator002() throws SystemException {
        try {
            // COUNT (Project)
            return assocOperator002Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }



    public Long assocOperator002Range1 () throws SystemException {
        SQLCount sql = assocOperator002Range1Query(null);
        return Long.valueOf(new TypedQueryBuilder<Project>(em, Project.class).build(sql).execute().size());
    }


    public SQLCount assocOperator002Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", ProjectConstants.CLASS_NAME, ProjectConstants.CLASS_NAME, null, ProjectConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", ProjectConstants.CLASS_NAME, ProjectConstants.CLASS_NAME, null, ProjectConstants.CLASS_NAME);
            }
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }
}
