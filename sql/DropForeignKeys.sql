ALTER TABLE TM_EmployeeTeam DROP CONSTRAINT fkc_TM_EmployeeTeam_Employees;
ALTER TABLE TM_EmployeeTeam DROP CONSTRAINT fkc_TM_EmployeeTeam_Teams;
ALTER TABLE TM_ProjectERTemplate DROP CONSTRAINT fkc_TM_ProjectERTemplate_Projects;
ALTER TABLE TM_ProjectERTemplate DROP CONSTRAINT fkc_TM_ProjectERTemplate_ERTemplates;
ALTER TABLE ExpenseLine DROP CONSTRAINT fkc_ExpenseLine_ExpenseReport;
ALTER TABLE ExpenseLine DROP CONSTRAINT fkc_ExpenseLine_ExpenseType;
ALTER TABLE ExpenseReport DROP CONSTRAINT fkc_ExpenseReport_Employee;
ALTER TABLE ExpenseReport DROP CONSTRAINT fkc_ExpenseReport_ExpenseCurrency;
ALTER TABLE ExpenseReport DROP CONSTRAINT fkc_ExpenseReport_PaymentType;
ALTER TABLE ExpenseReport DROP CONSTRAINT fkc_ExpenseReport_Project;
ALTER TABLE Project DROP CONSTRAINT fkc_Project_Team;
ALTER TABLE Assignment DROP CONSTRAINT fkc_Assignment_Employee;
ALTER TABLE Assignment DROP CONSTRAINT fkc_Assignment_Project;
ALTER TABLE AdminUser DROP CONSTRAINT fkc_AdminUser_;
ALTER TABLE OperatorUser DROP CONSTRAINT fkc_OperatorUser_;
ALTER TABLE ERLTemplate DROP CONSTRAINT fkc_ERLTemplate_Template;
ALTER TABLE ERLTemplate DROP CONSTRAINT fkc_ERLTemplate_ExpenseType;
ALTER TABLE ExchangeHistory DROP CONSTRAINT fkc_ExchangeHistory_ExpenseCurrency;
