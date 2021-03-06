ALTER TABLE TM_EmployeeTeam ADD CONSTRAINT fkc_TM_EmployeeTeam_Employees FOREIGN KEY (Employee_id_Employee) REFERENCES Employee;
ALTER TABLE TM_EmployeeTeam ADD CONSTRAINT fkc_TM_EmployeeTeam_Teams FOREIGN KEY (Team_id) REFERENCES Team;
ALTER TABLE TM_ProjectERTemplate ADD CONSTRAINT fkc_TM_ProjectERTemplate_Projects FOREIGN KEY (Project_id_Project) REFERENCES Project;
ALTER TABLE TM_ProjectERTemplate ADD CONSTRAINT fkc_TM_ProjectERTemplate_ERTemplates FOREIGN KEY (ERTemplate_id) REFERENCES ERTemplate;
ALTER TABLE ExpenseLine ADD CONSTRAINT fkc_ExpenseLine_ExpenseReport FOREIGN KEY (id_ExpenseRepor) REFERENCES ExpenseReport;
ALTER TABLE ExpenseLine ADD CONSTRAINT fkc_ExpenseLine_ExpenseType FOREIGN KEY (TypeCode) REFERENCES ExpenseType;
ALTER TABLE ExpenseReport ADD CONSTRAINT fkc_ExpenseReport_Employee FOREIGN KEY (id_Employee) REFERENCES Employee;
ALTER TABLE ExpenseReport ADD CONSTRAINT fkc_ExpenseReport_ExpenseCurrency FOREIGN KEY (CurrencyCode) REFERENCES ExpenseCurrency;
ALTER TABLE ExpenseReport ADD CONSTRAINT fkc_ExpenseReport_PaymentType FOREIGN KEY (id_PaymentType) REFERENCES PaymentType;
ALTER TABLE ExpenseReport ADD CONSTRAINT fkc_ExpenseReport_Project FOREIGN KEY (id_Project) REFERENCES Project;
ALTER TABLE Project ADD CONSTRAINT fkc_Project_Team FOREIGN KEY (id) REFERENCES Team;
ALTER TABLE Assignment ADD CONSTRAINT fkc_Assignment_Employee FOREIGN KEY (id_Employee) REFERENCES Employee;
ALTER TABLE Assignment ADD CONSTRAINT fkc_Assignment_Project FOREIGN KEY (id_Project) REFERENCES Project;
ALTER TABLE AdminUser ADD CONSTRAINT fkc_AdminUser_ FOREIGN KEY (Login) REFERENCES AppUser;
ALTER TABLE OperatorUser ADD CONSTRAINT fkc_OperatorUser_ FOREIGN KEY (Login) REFERENCES AppUser;
ALTER TABLE ERLTemplate ADD CONSTRAINT fkc_ERLTemplate_Template FOREIGN KEY (Template_id) REFERENCES ERTemplate;
ALTER TABLE ERLTemplate ADD CONSTRAINT fkc_ERLTemplate_ExpenseType FOREIGN KEY (TypeCode) REFERENCES ExpenseType;
ALTER TABLE ExchangeHistory ADD CONSTRAINT fkc_ExchangeHistory_ExpenseCurrency FOREIGN KEY (CurrencyCode) REFERENCES ExpenseCurrency;
