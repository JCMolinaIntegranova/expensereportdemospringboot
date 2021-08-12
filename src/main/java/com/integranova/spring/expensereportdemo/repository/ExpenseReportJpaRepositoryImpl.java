package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameterAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class ExpenseReportJpaRepositoryImpl extends AbstractRepository implements ExpenseReportJpaRepositoryCustom {

    @Override
    public List<ExpenseReport> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ExpenseReport> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ExpenseReport> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ExpenseReport> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ExpenseReport.class);
    }
    
    public List<ExpenseReport> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ExpenseReport> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Double assocOperator000(ExpenseReport instance) throws SystemException {
        try {
            // SUM (ExpenseLines.TotalLine)
            Double result = 0.0;
            for(ExpenseLine item : assocOperator000Range1(instance)){
                result += item.getExpenseLineTotalLine();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<ExpenseLine> assocOperator000Range1 (ExpenseReport instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<ExpenseLine>(em, ExpenseLine.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (ExpenseReport instance) throws SystemException {
        try {
            return new SQLPopulation(ExpenseReportConstants.CLASS_NAME, ExpenseLineConstants.CLASS_NAME, instance.getOid(), ExpenseReportConstants.ROLE_NAME_EXPENSELINES);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {
        try {
            // EXIST (ptpagrProject.Assignments) WHERE (ptpagrProject.Assignments.Employee = ptpagrEmployee AND ptpagrProject.Assignments.IsActive = true AND ptpagrProject.Assignments.FromDate <= ptpatrPresentDate)
            for(Assignment item : assocOperator001Range1(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate)){
                // ptpagrProject.Assignments.IsActive = true
                if(item.getAssignmentIsActive().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Collection<Assignment> assocOperator001Range1 (Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLPopulation assocOperator001Range1Query (Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ExpenseReportConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.Assignments.Employee = ptpagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ROLE_NAME_EMPLOYEE, ProjectConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWptpagrEmployee.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ptpagrProject.Assignments.FromDate <= ptpatrPresentDate
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand113 = new SQLWhereOperandOVParameterAttribute(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ATTR_NAME_ASSIGNMENTFROMDATE, ProjectConstants.CLASS_NAME, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(expenseReportTNEWptpatrPresentDate, Constants.Type.DATE.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee) throws SystemException {
        try {
            // EXIST (ptpagrProject.Team.Employees) WHERE (ptpagrProject.Team.Employees = ptpagrEmployee)
            return assocOperator002Range1(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(expenseReportTNEWptpagrProject, expenseReportTNEWptpagrEmployee, null);
        return !new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (Project expenseReportTNEWptpagrProject, Employee expenseReportTNEWptpagrEmployee, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
            } else {
                sql = new SQLExists(ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.Team.Employees = ptpagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWptpagrEmployee.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate) throws SystemException {
        try {
            // EXIST (ptpagrProject.Assignments) WHERE (ptpagrProject.Assignments.Employee = ptpagrEmployee AND ptpagrProject.Assignments.IsActive = true AND ptpagrProject.Assignments.FromDate <= ptpatrPresentDate)
            for(Assignment item : assocOperator003Range1(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee, expenseReportTNEWFROMTEMPLATEptpatrPresentDate)){
                // ptpagrProject.Assignments.IsActive = true
                if(item.getAssignmentIsActive().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Collection<Assignment> assocOperator003Range1 (Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee, expenseReportTNEWFROMTEMPLATEptpatrPresentDate);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLPopulation assocOperator003Range1Query (Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ExpenseReportConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.Assignments.Employee = ptpagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ROLE_NAME_EMPLOYEE, ProjectConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrEmployee.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ptpagrProject.Assignments.FromDate <= ptpatrPresentDate
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand113 = new SQLWhereOperandOVParameterAttribute(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ATTR_NAME_ASSIGNMENTFROMDATE, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(expenseReportTNEWFROMTEMPLATEptpatrPresentDate, Constants.Type.DATE.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Boolean assocOperator004(Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee) throws SystemException {
        try {
            // EXIST (ptpagrProject.Team.Employees) WHERE (ptpagrProject.Team.Employees = ptpagrEmployee)
            return assocOperator004Range1(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Boolean assocOperator004Range1 (Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEptpagrEmployee, null);
        return !new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLExists assocOperator004Range1Query (Project expenseReportTNEWFROMTEMPLATEptpagrProject, Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            } else {
                sql = new SQLExists(ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.Team.Employees = ptpagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrEmployee.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Boolean assocOperator005(Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        try {
            // EXIST (ptpagrProject.ERTemplates) WHERE (ptpagrProject.ERTemplates = pTemplate)
            return assocOperator005Range1(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEpTemplate);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Boolean assocOperator005Range1 (Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(expenseReportTNEWFROMTEMPLATEptpagrProject, expenseReportTNEWFROMTEMPLATEpTemplate, null);
        return !new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLExists assocOperator005Range1Query (Project expenseReportTNEWFROMTEMPLATEptpagrProject, ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            } else {
                sql = new SQLExists(ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES, ProjectConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptpagrProject.ERTemplates = pTemplate
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_ERTEMPLATES, ProjectConstants.CLASS_NAME, ERTemplateConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEptpagrProject.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE, ERTemplateConstants.CLASS_NAME, ERTemplateConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEpTemplate.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public Collection<ExpenseLine> assocOperator006(ExpenseReport instance) throws SystemException {
        try {
            // FOR ALL ExpenseLines DO ExpenseLines.deletepaidline(ExpenseLines)
        return assocOperator006Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public Collection<ExpenseLine> assocOperator006Range1 (ExpenseReport instance) throws SystemException {

        SQLSelect sql = assocOperator006Range1Query(instance);
        return new TypedQueryBuilder<ExpenseLine>(em, ExpenseLine.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLPopulation assocOperator006Range1Query (ExpenseReport instance) throws SystemException {
        try {
            return new SQLPopulation(ExpenseReportConstants.CLASS_NAME, ExpenseLineConstants.CLASS_NAME, instance.getOid(), ExpenseReportConstants.ROLE_NAME_EXPENSELINES);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }

    // AssocOperator: AssocOperator007
    public Collection<ERLTemplate> assocOperator007(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        try {
            // FOR ALL pTemplate.TemplateLines DO ExpenseLines.newline(pTemplate.TemplateLines.ExpenseType, this, pTemplate.TemplateLines.units, pTemplate.TemplateLines.price, ptpatrPresentDate, pTemplate.TemplateLines.description)
        return assocOperator007Range1(expenseReportTNEWFROMTEMPLATEpTemplate);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator007, Method: assocOperator007");
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Collection<ERLTemplate> assocOperator007Range1 (ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(expenseReportTNEWFROMTEMPLATEpTemplate);
        return new TypedQueryBuilder<ERLTemplate>(em, ERLTemplate.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLPopulation assocOperator007Range1Query (ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        try {
            return new SQLPopulation(ExpenseReportConstants.CLASS_NAME, ERLTemplateConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE + "." + ERTemplateConstants.ROLE_NAME_TEMPLATELINES, expenseReportTNEWFROMTEMPLATEpTemplate.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query");
        }
    }

    // AssocOperator: AssocOperator008
    public Long assocOperator008(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        try {
            // COUNT (pTemplate.TemplateLines)
            return assocOperator008Range1(expenseReportTNEWFROMTEMPLATEpTemplate);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator008, Method: assocOperator008");
        }
    }

    // Range 1 for AssocOperator AssocOperator008
    public Long assocOperator008Range1 (ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) throws SystemException {
        SQLCount sql = assocOperator008Range1Query(expenseReportTNEWFROMTEMPLATEpTemplate, null);
        return Long.valueOf(new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator008
    public SQLCount assocOperator008Range1Query (ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE + "." + ERTemplateConstants.ROLE_NAME_TEMPLATELINES, ERTemplateConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEpTemplate.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE);
            } else {
                sql = new SQLCount(ExpenseReportConstants.CLASS_NAME, ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE + "." + ERTemplateConstants.ROLE_NAME_TEMPLATELINES, ERTemplateConstants.CLASS_NAME, expenseReportTNEWFROMTEMPLATEpTemplate.getOid(), ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE);
            }
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ExpenseReport, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query");
        }
    }
}
