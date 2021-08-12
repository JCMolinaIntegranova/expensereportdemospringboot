package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class AssignmentJpaRepositoryImpl extends AbstractRepository implements AssignmentJpaRepositoryCustom {

    @Override
    public List<Assignment> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Assignment> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Assignment> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Assignment> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Assignment.class);
    }
    
    public List<Assignment> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Assignment> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Employee assignmentnewAssignmentpagrEmployee) throws SystemException {
        try {
            // EXIST (pagrEmployee.Assignments) WHERE (pagrEmployee.Assignments.Employee = pagrEmployee AND pagrEmployee.Assignments.IsActive = true)
            for(Assignment item : assocOperator000Range1(assignmentnewAssignmentpagrEmployee)){
                // pagrEmployee.Assignments.IsActive = true
                if(item.getAssignmentIsActive().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Assignment, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<Assignment> assocOperator000Range1 (Employee assignmentnewAssignmentpagrEmployee) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(assignmentnewAssignmentpagrEmployee);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (Employee assignmentnewAssignmentpagrEmployee) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(AssignmentConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE + "." + EmployeeConstants.ROLE_NAME_ASSIGNMENTS, assignmentnewAssignmentpagrEmployee.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // pagrEmployee.Assignments.Employee = pagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE + "." + EmployeeConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ROLE_NAME_EMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, assignmentnewAssignmentpagrEmployee.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, assignmentnewAssignmentpagrEmployee.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Assignment, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee) throws SystemException {
        try {
            // EXIST (pagrProject.Team.Employees) WHERE (pagrProject.Team.Employees = pagrEmployee)
            return assocOperator001Range1(assignmentnewAssignmentpagrProject, assignmentnewAssignmentpagrEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Assignment, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(assignmentnewAssignmentpagrProject, assignmentnewAssignmentpagrEmployee, null);
        return !new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (Project assignmentnewAssignmentpagrProject, Employee assignmentnewAssignmentpagrEmployee, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, AssignmentConstants.CLASS_NAME, AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, assignmentnewAssignmentpagrProject.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT);
            } else {
                sql = new SQLExists(AssignmentConstants.CLASS_NAME, AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, assignmentnewAssignmentpagrProject.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // pagrProject.Team.Employees = pagrEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT + "." + ProjectConstants.ROLE_NAME_TEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, ProjectConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, assignmentnewAssignmentpagrProject.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, assignmentnewAssignmentpagrEmployee.getOid(), AssignmentConstants.ARG_NAME_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Assignment, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }
}
