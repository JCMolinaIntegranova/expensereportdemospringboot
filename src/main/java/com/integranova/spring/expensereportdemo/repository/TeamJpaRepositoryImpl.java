package com.integranova.spring.expensereportdemo.repository;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.sqlutils.SQLCount;
import com.integranova.spring.expensereportdemo.sqlutils.SQLExists;
import com.integranova.spring.expensereportdemo.sqlutils.SQLForAllDistinct;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathInstance;
import com.integranova.spring.expensereportdemo.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class TeamJpaRepositoryImpl extends AbstractRepository implements TeamJpaRepositoryCustom {

    @Override
    public List<Team> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Team> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Team> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Team> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Team.class);
    }
    
    public List<Team> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Team> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException {
        try {
            // EXIST (Employees) WHERE (Employees = pthisEmployee)
            return assocOperator000Range1(employeeaddEmployeeToTeampthisEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 (Employee employeeaddEmployeeToTeampthisEmployee) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(employeeaddEmployeeToTeampthisEmployee, null);
        return !new TypedQueryBuilder<Team>(em, Team.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (Employee employeeaddEmployeeToTeampthisEmployee, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, TeamConstants.CLASS_NAME, TeamConstants.ROLE_NAME_EMPLOYEES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Employees = pthisEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(TeamConstants.ROLE_NAME_EMPLOYEES, EmployeeConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, employeeaddEmployeeToTeampthisEmployee.getOid(), EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(Employee employeeremoveEmployeeFromTeampthisEmployee) throws SystemException {
        try {
            // EXIST (Employees) WHERE (Employees = pthisEmployee)
            return assocOperator001Range1(employeeremoveEmployeeFromTeampthisEmployee);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 0 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (Employee employeeremoveEmployeeFromTeampthisEmployee) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(employeeremoveEmployeeFromTeampthisEmployee, null);
        return !new TypedQueryBuilder<Team>(em, Team.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (Employee employeeremoveEmployeeFromTeampthisEmployee, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, TeamConstants.CLASS_NAME, TeamConstants.ROLE_NAME_EMPLOYEES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Employees = pthisEmployee
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(TeamConstants.ROLE_NAME_EMPLOYEES, EmployeeConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE, EmployeeConstants.CLASS_NAME, EmployeeConstants.CLASS_NAME, employeeremoveEmployeeFromTeampthisEmployee.getOid(), EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(Team instance) throws SystemException {
        try {
            // EXIST (Employees)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (Team instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Team>(em, Team.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (Team instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(TeamConstants.CLASS_NAME, TeamConstants.ROLE_NAME_EMPLOYEES, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Long assocOperator003(Team instance) throws SystemException {
        try {
            // COUNT (Employees)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Long assocOperator003Range1 (Team instance) throws SystemException {
        SQLCount sql = assocOperator003Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Team>(em, Team.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLCount assocOperator003Range1Query (Team instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(TeamConstants.CLASS_NAME, TeamConstants.ROLE_NAME_EMPLOYEES, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Double assocOperator004(Team instance) throws SystemException {
        try {
            // SUM (Employees.ExpenseReports.TotExpenses)
            Double result = 0.0;
            for(ExpenseReport item : assocOperator004Range1(instance)){
                result += item.getExpenseReportTotExpenses();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Collection<ExpenseReport> assocOperator004Range1 (Team instance) throws SystemException {

        SQLSelect sql = assocOperator004Range1Query(instance);
        return new TypedQueryBuilder<ExpenseReport>(em, ExpenseReport.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLPopulation assocOperator004Range1Query (Team instance) throws SystemException {
        try {
            return new SQLPopulation(TeamConstants.CLASS_NAME, ExpenseReportConstants.CLASS_NAME, instance.getOid(), TeamConstants.ROLE_NAME_EMPLOYEES + "." + EmployeeConstants.ROLE_NAME_EXPENSEREPORTS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Boolean assocOperator005(Team instance) throws SystemException {
        try {
            // FOR ALL Employees DISTINCT (Employees.idEmployee)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Team, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Boolean assocOperator005Range1 (Team instance) throws SystemException {
        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLForAllDistinct assocOperator005Range1Query (Team instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLForAllDistinct(TeamConstants.CLASS_NAME, TeamConstants.ROLE_NAME_EMPLOYEES + "." + EmployeeConstants.ATTR_NAME_EMPLOYEEIDEMPLOYEE, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Team, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }
}
