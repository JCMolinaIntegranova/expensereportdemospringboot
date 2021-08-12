package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathInstance;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class ProjectJpaRepositoryImpl extends AbstractRepository implements ProjectJpaRepositoryCustom {

    @Override
    public List<Project> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Project> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Project> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Project> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Project.class);
    }
    
    public List<Project> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Project> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {
        try {
            // EXIST (Assignments) WHERE (Assignments.Employee = ptpagrEmployee AND Assignments.IsActive = true AND Assignments.FromDate <= ptpatrPresentDate)
            for(Assignment item : assocOperator000Range1(instance, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate)){
                // Assignments.IsActive = true
                if(item.getAssignmentIsActive().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<Assignment> assocOperator000Range1 (Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (Project instance, Employee expenseReportTNEWptpagrEmployee, Date expenseReportTNEWptpatrPresentDate) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ProjectConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_ASSIGNMENTS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Assignments.Employee = ptpagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ROLE_NAME_EMPLOYEE, EmployeeConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, expenseReportTNEWptpagrEmployee.getOid(), ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Assignments.FromDate <= ptpatrPresentDate
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ProjectConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ATTR_NAME_ASSIGNMENTFROMDATE, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(expenseReportTNEWptpatrPresentDate, Constants.Type.DATE.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Double assocOperator001(Project instance) throws SystemException {
        try {
            // SUM (ExpenseReport.TotExpenses)
            Double result = 0.0;
            for(ExpenseReport item : assocOperator001Range1(instance)){
                result += item.getExpenseReportTotExpenses();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Collection<ExpenseReport> assocOperator001Range1 (Project instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLPopulation assocOperator001Range1Query (Project instance) throws SystemException {
        try {
            return new SQLPopulation(ProjectConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_EXPENSEREPORT);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Double assocOperator002(Project instance) throws SystemException {
        try {
            // MAX (ExpenseReport.TotExpenses)
            Double result = Double.MIN_VALUE;
            for(ExpenseReport item : assocOperator002Range1(instance)){
                if(result < item.getExpenseReportTotExpenses())
                    result = item.getExpenseReportTotExpenses();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Collection<ExpenseReport> assocOperator002Range1 (Project instance) throws SystemException {

        SQLSelect sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLPopulation assocOperator002Range1Query (Project instance) throws SystemException {
        try {
            return new SQLPopulation(ProjectConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_EXPENSEREPORT);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Double assocOperator003(Project instance) throws SystemException {
        try {
            // MIN (ExpenseReport.TotExpenses)
            Double result = Double.MAX_VALUE;
            for(ExpenseReport item : assocOperator003Range1(instance)){
                if(result > item.getExpenseReportTotExpenses())
                    result = item.getExpenseReportTotExpenses();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Collection<ExpenseReport> assocOperator003Range1 (Project instance) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLPopulation assocOperator003Range1Query (Project instance) throws SystemException {
        try {
            return new SQLPopulation(ProjectConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_EXPENSEREPORT);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Double assocOperator004(Project instance) throws SystemException {
        try {
            // AVG (ExpenseReport.TotExpenses)
            Double result = 0.0;
            int count = 0;
            Collection<ExpenseReport> items = assocOperator004Range1(instance);
            if (!items.isEmpty()) {
                for(ExpenseReport item : items){
                    result += item.getExpenseReportTotExpenses();
                    count++;

                }
                result = count != 0 ? result / count : 0;
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Collection<ExpenseReport> assocOperator004Range1 (Project instance) throws SystemException {

        SQLSelect sql = assocOperator004Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLPopulation assocOperator004Range1Query (Project instance) throws SystemException {
        try {
            return new SQLPopulation(ProjectConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_EXPENSEREPORT);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Collection<Assignment> assocOperator005(Project instance) throws SystemException {
        try {
            // FOR ALL Assignments DO Assignments.terminateAssignment(Assignments, pCompletionDate)
        return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Project, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Collection<Assignment> assocOperator005Range1 (Project instance) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLPopulation assocOperator005Range1Query (Project instance) throws SystemException {
        try {
            return new SQLPopulation(ProjectConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, instance.getOid(), ProjectConstants.ROLE_NAME_ASSIGNMENTS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Project, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }
}
