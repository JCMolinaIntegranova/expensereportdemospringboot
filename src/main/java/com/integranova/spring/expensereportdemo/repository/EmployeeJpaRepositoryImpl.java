package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandNull;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeJpaRepositoryImpl extends AbstractRepository implements EmployeeJpaRepositoryCustom {

    @Override
    public List<Employee> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Employee> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Employee> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Employee> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Employee.class);
    }
    
    public List<Employee> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Employee> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Long assocOperator000(Employee instance) throws SystemException {
        try {
            // COUNT (ExpenseReports)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Long assocOperator000Range1 (Employee instance) throws SystemException {
        SQLCount sql = assocOperator000Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Employee>(em, Employee.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLCount assocOperator000Range1Query (Employee instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(EmployeeConstants.CLASS_NAME, EmployeeConstants.ROLE_NAME_EXPENSEREPORTS, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException {
        try {
            // EXIST (pevcTeam.Employees) WHERE (pevcTeam.Employees = pthisEmployee)
            return assocOperator001Range1(employeeaddEmployeeToTeampevcTeam, employeeaddEmployeeToTeampthisEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(employeeaddEmployeeToTeampevcTeam, employeeaddEmployeeToTeampthisEmployee, null);
        return !new TypedQueryBuilder<Employee>(em, Employee.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (Team employeeaddEmployeeToTeampevcTeam, Employee employeeaddEmployeeToTeampthisEmployee, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, EmployeeConstants.CLASS_NAME, EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, TeamConstants.CLASS_NAME, employeeaddEmployeeToTeampevcTeam.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
            } else {
                sql = new SQLExists(EmployeeConstants.CLASS_NAME, EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, TeamConstants.CLASS_NAME, employeeaddEmployeeToTeampevcTeam.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // pevcTeam.Employees = pthisEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, TeamConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, employeeaddEmployeeToTeampevcTeam.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, employeeaddEmployeeToTeampthisEmployee.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Long assocOperator002(Team employeeaddEmployeeToTeampevcTeam) throws SystemException {
        try {
            // COUNT (pevcTeam.Employees)
            return assocOperator002Range1(employeeaddEmployeeToTeampevcTeam);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Long assocOperator002Range1 (Team employeeaddEmployeeToTeampevcTeam) throws SystemException {
        SQLCount sql = assocOperator002Range1Query(employeeaddEmployeeToTeampevcTeam, null);
        return Long.valueOf(new TypedQueryBuilder<Employee>(em, Employee.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLCount assocOperator002Range1Query (Team employeeaddEmployeeToTeampevcTeam, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, EmployeeConstants.CLASS_NAME, EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, TeamConstants.CLASS_NAME, employeeaddEmployeeToTeampevcTeam.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
            } else {
                sql = new SQLCount(EmployeeConstants.CLASS_NAME, EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM + "." + TeamConstants.ROLE_NAME_EMPLOYEES, TeamConstants.CLASS_NAME, employeeaddEmployeeToTeampevcTeam.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
            }
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Collection<Assignment> assocOperator003(Employee instance) throws SystemException {
        try {
            // FOR ALL Assignments WHERE (Assignments.ToDate = NULL) DO Assignments.terminateAssignment(Assignments, systemDate())
        return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Collection<Assignment> assocOperator003Range1 (Employee instance) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(instance);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLPopulation assocOperator003Range1Query (Employee instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(EmployeeConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, instance.getOid(), EmployeeConstants.ROLE_NAME_ASSIGNMENTS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Assignments.ToDate = NULL
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(EmployeeConstants.ROLE_NAME_ASSIGNMENTS + "." + AssignmentConstants.ATTR_NAME_ASSIGNMENTTODATE, Constants.Type.DATE.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Collection<Assignment> assocOperator004(Employee instance) throws SystemException {
        try {
            // FOR ALL Assignments WHERE (Assignments.IsActive = false) DO Assignments.deleteAssignment(Assignments)
            Collection<Assignment> results = new ArrayList<>();
            for(Assignment item : assocOperator004Range1(instance)){
                // Assignments.IsActive = false
                if(item.getAssignmentIsActive().equals(false))
                    results.add(item);
            }
            return results;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Collection<Assignment> assocOperator004Range1 (Employee instance) throws SystemException {

        SQLSelect sql = assocOperator004Range1Query(instance);
        return new TypedQueryBuilder<Assignment>(em, Assignment.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLPopulation assocOperator004Range1Query (Employee instance) throws SystemException {
        try {
            return new SQLPopulation(EmployeeConstants.CLASS_NAME, AssignmentConstants.CLASS_NAME, instance.getOid(), EmployeeConstants.ROLE_NAME_ASSIGNMENTS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Collection<Team> assocOperator005(Employee instance, Employee employeeTDELETEpthisEmployee) throws SystemException {
        try {
            // FOR ALL Teams DO removeEmployeeFromTeam(this, Teams)
        return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Collection<Team> assocOperator005Range1 (Employee instance) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<Team>(em, Team.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLPopulation assocOperator005Range1Query (Employee instance) throws SystemException {
        try {
            return new SQLPopulation(EmployeeConstants.CLASS_NAME, TeamConstants.CLASS_NAME, instance.getOid(), EmployeeConstants.ROLE_NAME_TEAMS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public Collection<ExpenseReport> assocOperator006(Employee instance) throws SystemException {
        try {
            // FOR ALL ExpenseReports DO ExpenseReports.DELETEALL(ExpenseReports)
        return assocOperator006Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Employee, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public Collection<ExpenseReport> assocOperator006Range1 (Employee instance) throws SystemException {

        SQLSelect sql = assocOperator006Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLPopulation assocOperator006Range1Query (Employee instance) throws SystemException {
        try {
            return new SQLPopulation(EmployeeConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), EmployeeConstants.ROLE_NAME_EXPENSEREPORTS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Employee, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }
}
