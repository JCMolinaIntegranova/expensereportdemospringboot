package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameterAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ERTemplateJpaRepositoryImpl extends AbstractRepository implements ERTemplateJpaRepositoryCustom {

    @Override
    public List<ERTemplate> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ERTemplate> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ERTemplate> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ERTemplate> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ERTemplate.class);
    }
    
    public List<ERTemplate> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ERTemplate> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Project expenseReportTNEWFROMTEMPLATEptpagrProject) throws SystemException {
        try {
            // EXIST (ptpagrProject.ERTemplates) WHERE (ptpagrProject.ERTemplates.id = id)
            return assocOperator000Range1(expenseReportTNEWFROMTEMPLATEptpagrProject);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ERTemplate, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 (Project expenseReportTNEWFROMTEMPLATEptpagrProject) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(expenseReportTNEWFROMTEMPLATEptpagrProject, null);
        return !new TypedQueryBuilder<ERTemplate>(em, ERTemplate.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (Project expenseReportTNEWFROMTEMPLATEptpagrProject, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, ERTemplateConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            } else {
                sql = new SQLExists(ERTemplateConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.ERTemplates.id = id
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand112 = new SQLWhereOperandOVParameterAttribute(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES + "." + ERTemplateConstants.ATTR_NAME_ERTEMPLATEID, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEID, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ERTemplate, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Double assocOperator001(ERTemplate instance) throws SystemException {
        try {
            // SUM (TemplateLines.totalLine)
            Double result = 0.0;
            for(ERLTemplate item : assocOperator001Range1(instance)){
                result += item.getERLTemplatetotalLine();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ERTemplate, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Collection<ERLTemplate> assocOperator001Range1 (ERTemplate instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<ERLTemplate>(em, ERLTemplate.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLPopulation assocOperator001Range1Query (ERTemplate instance) throws SystemException {
        try {
            return new SQLPopulation(ERTemplateConstants.CLASS_NAME, ERLTemplateConstants.CLASS_NAME, instance.getOid(), ERTemplateConstants.ROLE_NAME_TEMPLATELINES);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ERTemplate, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }
}
