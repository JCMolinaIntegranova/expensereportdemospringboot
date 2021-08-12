---------------------------------------------
-- GLOBAL SERVICES
---------------------------------------------
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('IGl_1539588620288177UIServ_1', 'GLOBALTEST', 'GLOBALTEST', '', 'S');


---------------------------------------------
-- CLASS Employee
---------------------------------------------
-- PIU: Employee.PIUEmployee
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIPobCl_1', 'PIUEmployee', 'Employees', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_1', 'idEmployee', 'Employee Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_9', 'Picture', 'Picture', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_2', 'EmpName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_3', 'EmpSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_4', 'PhoneNumbers', 'Phone Numbers', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_7', 'Site', 'Site', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_8', 'email', 'E-mail', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607CjtoVis_1ICtjoVis_10', 'NumOfExpReports', '# Exp.Reports', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_4', 'SIUchangePicture', 'Change Picture', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_6', 'SIUaddEmployeeToTeam', 'Add to Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_7', 'SIUremoveEmployeeFromTeam', 'Remove from Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_1', 'Clas_1057569177600607AccOfer_1ElemAcc_5', 'MDIUEmployeeExpenses', 'Detail', '');

-- PIU: Employee._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIPobCl_Auto', '_Auto_', 'Employee', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_1', 'idEmployee', 'Employee Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_2', 'EmpName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_3', 'EmpSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_4', 'Site', 'Site', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_5', 'PhoneNumbers', 'Phone Numbers', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_6', 'email', 'E-mail', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_7', 'EmpFullName', 'Full Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_8', 'Picture', 'Picture', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607CjtoVis_AutoICtjoVis_9', 'NumOfExpReports', '# Exp.Reports', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_4', 'SIUchangePicture', 'Change Picture', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_5', 'SIUaddEmployeeToTeam', 'Add Employee to Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_6', 'SIUremoveEmployeeFromTeam', 'Remove Employee from Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_7', 'SIUTDELETE', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_8', 'IIUEmployee', 'Employee', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_9', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607AccOfer_AutoElemAcc_10', 'MDIUEmployeeExpenses', 'Employee Details', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607NavOfer_AutoElemNav_2', 'PIUAssignments', 'Assignments', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIPobCl_Auto', 'Clas_1057569177600607NavOfer_AutoElemNav_3', 'PIUTeams', 'Teams', '');

-- IIU: Employee.IIUEmployee
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIInst_1', 'IIUEmployee', 'Employee', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_4', 'SIUchangePicture', 'Change Picture', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_6', 'SIUaddEmployeeToTeam', 'Add to Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_7', 'SIUremoveEmployeeFromTeam', 'Remove from Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_1', 'Clas_1057569177600607AccOfer_1ElemAcc_5', 'MDIUEmployeeExpenses', 'Detail', '');

-- IIU: Employee.IIUEmployeeReports
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIInst_2', 'IIUEmployeeReports', 'Reports of Employee', '', 'I');

-- IIU: Employee._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIInst_4', '_Auto_', 'Employee', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_4', 'SIUchangePicture', 'Change Picture', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_5', 'SIUaddEmployeeToTeam', 'Add Employee to Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_6', 'SIUremoveEmployeeFromTeam', 'Remove Employee from Team', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_7', 'SIUTDELETE', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_8', 'IIUEmployee', 'Employee', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_9', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607AccOfer_AutoElemAcc_10', 'MDIUEmployeeExpenses', 'Employee Details', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607NavOfer_AutoElemNav_2', 'PIUAssignments', 'Assignments', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600607UIInst_4', 'Clas_1057569177600607NavOfer_AutoElemNav_3', 'PIUTeams', 'Teams', '');

-- MDIU: Employee.MDIUEmployeeExpenses
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607UIMaDet_1', 'MDIUEmployeeExpenses', 'Employee Details', '', 'M');
INSERT INTO IUDetail (idIU, idIUDetail, IUDetailName, IUDetailAlias, IUDetailDescription) VALUES ('Clas_1057569177600607UIMaDet_1', 'Clas_1057569177600607UIMaDet_1Det_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
-- SIU: Employee.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: Employee.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: Employee.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: Employee.SIUchangePicture
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_4UIServ_1', 'SIUchangePicture', 'Change Picture', '', 'S');
-- SIU: Employee.SIUaddEmployeeToTeam
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_7UIServ_1', 'SIUaddEmployeeToTeam', 'Add Employee to Team', '', 'S');
-- SIU: Employee.SIUremoveEmployeeFromTeam
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_8UIServ_1', 'SIUremoveEmployeeFromTeam', 'Remove Employee from Team', '', 'S');
-- SIU: Employee.SIUTDELETE
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600607Ser_9UIServ_1', 'SIUTDELETE', 'Delete', '', 'S');

---------------------------------------------
-- CLASS ExpenseLine
---------------------------------------------
-- PIU: ExpenseLine.PIUExpenseLine
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646UIPobCl_1', 'PIUExpenseLine', 'Expense Lines', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_1', 'idExpenseLine', 'Nº Line', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_2', 'ExpenseDate', 'Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_3', 'LnDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_4', 'Price', 'Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_5', 'Units', 'Qty', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_6', 'TotalLine', 'Total', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646CjtoVis_1ICtjoVis_7', 'TotalLineCurr', 'Total (Currency)', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646AccOfer_1ElemAcc_1', 'SIUnewline', 'Create a New Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit a Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646AccOfer_1ElemAcc_3', 'SIUdeleteline', 'Delete Line', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646NavOfer_1ElemNav_2', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIPobCl_1', 'Clas_1057569177600646NavOfer_1ElemNav_1', 'IIUExpenseReport', 'Expense Reports', '');

-- PIU: ExpenseLine.PIUExpenseLineToReports
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646UIPobCl_2', 'PIUExpenseLineToReports', 'Lines', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_1', 'idExpenseLine', 'Nº Line', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_2', 'ExpenseDate', 'Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_3', 'LnDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_4', 'Price', 'Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_5', 'Units', 'Qty', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_6', 'TotalLine', 'Total', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646CjtoVis_1ICtjoVis_7', 'TotalLineCurr', 'Total (Currency)', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646AccOfer_1ElemAcc_1', 'SIUnewline', 'Create a New Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit a Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646AccOfer_1ElemAcc_3', 'SIUdeleteline', 'Delete Line', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIPobCl_2', 'Clas_1057569177600646NavOfer_2ElemNav_1', 'IIUExpenseType', 'Expense Type', '');

-- PIU: ExpenseLine._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646UIPobCl_Auto', '_Auto_', 'Expense Line', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_1', 'idExpenseLine', 'Nº Line', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_2', 'Units', 'Quantity', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_3', 'Price', 'Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_4', 'ExpenseDate', 'Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_5', 'TotalLine', 'Total Line', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_6', 'LnDescription', 'LnDescription', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646CjtoVis_AutoICtjoVis_7', 'TotalLineCurr', 'Total Line Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646AccOfer_AutoElemAcc_1', 'SIUnewline', 'Create a New Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646AccOfer_AutoElemAcc_2', 'SIUdeleteline', 'Delete Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit a Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646AccOfer_AutoElemAcc_4', 'IIUExpenseLine', 'Expense Line', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646NavOfer_AutoElemNav_1', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIPobCl_Auto', 'Clas_1057569177600646NavOfer_AutoElemNav_2', 'IIUExpenseReport', 'Expense Report', '');

-- IIU: ExpenseLine.IIUExpenseLine
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646UIInst_1', 'IIUExpenseLine', 'Expense Line', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_1', 'Clas_1057569177600646AccOfer_1ElemAcc_1', 'SIUnewline', 'Create a New Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_1', 'Clas_1057569177600646AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit a Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_1', 'Clas_1057569177600646AccOfer_1ElemAcc_3', 'SIUdeleteline', 'Delete Line', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIInst_1', 'Clas_1057569177600646NavOfer_1ElemNav_2', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIInst_1', 'Clas_1057569177600646NavOfer_1ElemNav_1', 'IIUExpenseReport', 'Expense Reports', '');

-- IIU: ExpenseLine._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646UIInst_3', '_Auto_', 'Expense Line', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646AccOfer_AutoElemAcc_1', 'SIUnewline', 'Create a New Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646AccOfer_AutoElemAcc_2', 'SIUdeleteline', 'Delete Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit a Line', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646AccOfer_AutoElemAcc_4', 'IIUExpenseLine', 'Expense Line', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646NavOfer_AutoElemNav_1', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600646UIInst_3', 'Clas_1057569177600646NavOfer_AutoElemNav_2', 'IIUExpenseReport', 'Expense Report', '');

-- SIU: ExpenseLine.SIUnewline
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646Ser_1UIServ_1', 'SIUnewline', 'Create a New Line', '', 'S');
-- SIU: ExpenseLine.SIUdeleteline
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646Ser_2UIServ_1', 'SIUdeleteline', 'Delete Line', '', 'S');
-- SIU: ExpenseLine.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600646Ser_3UIServ_1', 'SIUeditinstance', 'Edit a Line', '', 'S');

---------------------------------------------
-- CLASS ExpenseReport
---------------------------------------------
-- PIU: ExpenseReport.PIUExpenseReport
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIPobCl_1', 'PIUExpenseReport', 'Expense Reports', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_1', 'idExpenseRepor', 'ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_2', 'PresentDate', 'Presentation Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_3', 'Project.ProjectName', 'Project', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_4', 'Employee.EmpName', 'Employee', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_5', 'Cause', 'Cause', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_6', 'ExpenseCurrency.CurrencyName', 'Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_7', 'Exchange', 'Exchange', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_8', 'BalanceCur', 'Balance in Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553CjtoVis_3ICtjoVis_9', 'Status', 'Status', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_9', 'SIUTNEW', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_3', 'SIUeclose', 'Close', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_4', 'SIUauthorize', 'Authorize', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_5', 'SIUrejectautho', 'Reject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_6', 'SIUapprove', 'Approve', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_7', 'SIUcancelapprove', 'Cancel', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_8', 'SIUTPAY', 'Pay', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553AccOfer_1ElemAcc_10', 'SIUDELETEALL', 'Delete', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_1', 'Clas_1057569177600553NavOfer_1ElemNav_1', 'MDIUExpenseReportLines', 'Detail', '');

-- PIU: ExpenseReport.PIUExpenseReportToEmployee
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIPobCl_2', 'PIUExpenseReportToEmployee', 'Expense Reports', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_1', 'idExpenseRepor', 'ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_2', 'PresentDate', 'Presentation Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_13', 'Project.ProjectName', 'Project', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_3', 'Cause', 'Cause', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_12', 'ExpenseCurrency.CurrencyName', 'Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_15', 'Exchange', 'Exchange', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_5', 'BalanceCur', 'Balance in Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553CjtoVis_1ICtjoVis_8', 'Status', 'Status', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_9', 'SIUTNEW', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_3', 'SIUeclose', 'Close', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_4', 'SIUauthorize', 'Authorize', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_5', 'SIUrejectautho', 'Reject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_6', 'SIUapprove', 'Approve', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_7', 'SIUcancelapprove', 'Cancel', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_8', 'SIUTPAY', 'Pay', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553AccOfer_1ElemAcc_10', 'SIUDELETEALL', 'Delete', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_2', 'Clas_1057569177600553NavOfer_2ElemNav_6', 'MDIUExpenseReportLines', 'Detail', '');

-- PIU: ExpenseReport.PIUExpenseReportProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIPobCl_4', 'PIUExpenseReportProject', 'Expense Reports', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_1', 'idExpenseRepor', 'ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_2', 'PresentDate', 'Presentation Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_13', 'Project.ProjectName', 'Project', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_3', 'Cause', 'Cause', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_12', 'ExpenseCurrency.CurrencyName', 'Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_15', 'Exchange', 'Exchange', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_5', 'BalanceCur', 'Balance in Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553CjtoVis_1ICtjoVis_8', 'Status', 'Status', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_9', 'SIUTNEW', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_3', 'SIUeclose', 'Close', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_4', 'SIUauthorize', 'Authorize', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_5', 'SIUrejectautho', 'Reject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_6', 'SIUapprove', 'Approve', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_7', 'SIUcancelapprove', 'Cancel', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_8', 'SIUTPAY', 'Pay', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553AccOfer_1ElemAcc_10', 'SIUDELETEALL', 'Delete', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_4', 'Clas_1057569177600553NavOfer_4ElemNav_10', 'MDIUExpenseReportLines', 'Detail', '');

-- PIU: ExpenseReport._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIPobCl_Auto', '_Auto_', 'Expense Report', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_1', 'idExpenseRepor', 'id_ExpenseRepor', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_2', 'PresentDate', 'Presentation Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_3', 'Status', 'Status', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_4', 'Cause', 'Cause', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_5', 'AuthoDate', 'Authorization Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_6', 'AuthoComments', 'Authorization Comments', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_7', 'PaymentDate', 'Payment Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_8', 'PayComments', 'Payment Comments', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_9', 'TotExpenses', 'Total Expenses', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_10', 'TotExpensesCur', 'Total Expenses in Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_11', 'Advances', 'Advances', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_12', 'AdvancesCur', 'Advances in Currency', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_13', 'Exchange', 'Exchange', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_14', 'Balance', 'Balance', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553CjtoVis_AutoICtjoVis_15', 'BalanceCur', 'Balance in Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_1', 'SIUeclose', 'Close a Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_2', 'SIUauthorize', 'Mark as Authorized', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_3', 'SIUrejectautho', 'Reject Auhorization', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_4', 'SIUcancelapprove', 'Cancel Approval', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_5', 'SIUapprove', 'Mark as Approved', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_6', 'SIUeditinstance', 'Edit Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_7', 'SIUDELETEALL', 'Delete an Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_8', 'SIUTPAY', 'Mark as Paid', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_9', 'SIUTNEW', 'New Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_10', 'SIUTREJECTPAYMENT', 'Reject Payment', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_11', 'SIUTNEWFROMTEMPLATE', 'New Expense Report from Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_12', 'IIUExpenseReport', 'Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553AccOfer_AutoElemAcc_13', 'MDIUExpenseReportLines', 'Expense Reports and Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553NavOfer_AutoElemNav_1', 'PIUExpenseLineToReports', 'Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553NavOfer_AutoElemNav_2', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553NavOfer_AutoElemNav_3', 'IIUExpenseCurrency', 'Expense Currency', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553NavOfer_AutoElemNav_4', 'IIUPaymentType', 'Payment Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIPobCl_Auto', 'Clas_1057569177600553NavOfer_AutoElemNav_5', 'IIUProjectReports', 'Project', '');

-- IIU: ExpenseReport.IIUExpenseReport
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIInst_1', 'IIUExpenseReport', 'Expense Report', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_1', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_2', 'SIUeclose', 'Close', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_3', 'SIUauthorize', 'Authorize', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_4', 'SIUrejectautho', 'Reject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_5', 'SIUapprove', 'Approve', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_6', 'SIUcancelapprove', 'Cancel', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_1', 'Clas_1057569177600553AccOfer_2ElemAcc_7', 'SIUTPAY', 'Pay', '');

-- IIU: ExpenseReport._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIInst_5', '_Auto_', 'Expense Report', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_1', 'SIUeclose', 'Close a Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_2', 'SIUauthorize', 'Mark as Authorized', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_3', 'SIUrejectautho', 'Reject Auhorization', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_4', 'SIUcancelapprove', 'Cancel Approval', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_5', 'SIUapprove', 'Mark as Approved', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_6', 'SIUeditinstance', 'Edit Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_7', 'SIUDELETEALL', 'Delete an Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_8', 'SIUTPAY', 'Mark as Paid', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_9', 'SIUTNEW', 'New Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_10', 'SIUTREJECTPAYMENT', 'Reject Payment', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_11', 'SIUTNEWFROMTEMPLATE', 'New Expense Report from Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_12', 'IIUExpenseReport', 'Expense Report', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553AccOfer_AutoElemAcc_13', 'MDIUExpenseReportLines', 'Expense Reports and Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553NavOfer_AutoElemNav_1', 'PIUExpenseLineToReports', 'Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553NavOfer_AutoElemNav_2', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553NavOfer_AutoElemNav_3', 'IIUExpenseCurrency', 'Expense Currency', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553NavOfer_AutoElemNav_4', 'IIUPaymentType', 'Payment Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600553UIInst_5', 'Clas_1057569177600553NavOfer_AutoElemNav_5', 'IIUProjectReports', 'Project', '');

-- MDIU: ExpenseReport.MDIUExpenseReportLines
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553UIMaDet_1', 'MDIUExpenseReportLines', 'Expense Reports and Lines', '', 'M');
INSERT INTO IUDetail (idIU, idIUDetail, IUDetailName, IUDetailAlias, IUDetailDescription) VALUES ('Clas_1057569177600553UIMaDet_1', 'Clas_1057569177600553UIMaDet_1Det_1', 'PIUExpenseLineToReports', 'Lines', '');
-- SIU: ExpenseReport.SIUeclose
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_3UIServ_1', 'SIUeclose', 'Close a Expense Report', '', 'S');
-- SIU: ExpenseReport.SIUauthorize
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_4UIServ_1', 'SIUauthorize', 'Mark as Authorized', '', 'S');
-- SIU: ExpenseReport.SIUrejectautho
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_6UIServ_1', 'SIUrejectautho', 'Reject Auhorization', '', 'S');
-- SIU: ExpenseReport.SIUcancelapprove
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_10UIServ_1', 'SIUcancelapprove', 'Cancel Approval', '', 'S');
-- SIU: ExpenseReport.SIUapprove
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_11UIServ_1', 'SIUapprove', 'Mark as Approved', '', 'S');
-- SIU: ExpenseReport.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_12UIServ_1', 'SIUeditinstance', 'Edit Expense Report', '', 'S');
-- SIU: ExpenseReport.SIUDELETEALL
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_13UIServ_1', 'SIUDELETEALL', 'Delete an Expense Report', '', 'S');
-- SIU: ExpenseReport.SIUTPAY
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_14UIServ_1', 'SIUTPAY', 'Mark as Paid', '', 'S');
-- SIU: ExpenseReport.SIUTNEW
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_15UIServ_1', 'SIUTNEW', 'New Expense Report', '', 'S');
-- SIU: ExpenseReport.SIUTREJECTPAYMENT
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_16UIServ_1', 'SIUTREJECTPAYMENT', 'Reject Payment', '', 'S');
-- SIU: ExpenseReport.SIUTNEWFROMTEMPLATE
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600553Ser_20UIServ_1', 'SIUTNEWFROMTEMPLATE', 'New Expense Report from Template', '', 'S');

---------------------------------------------
-- CLASS PaymentType
---------------------------------------------
-- PIU: PaymentType.PIUPaymentType
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423UIPobCl_1', 'PIUPaymentType', 'Payment Types', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600423UIPobCl_1', 'Clas_1057569177600423CjtoVis_1ICtjoVis_1', 'idPaymentType', 'Payment Type', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600423UIPobCl_1', 'Clas_1057569177600423CjtoVis_1ICtjoVis_2', 'PayDescription', 'Description', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_1', 'Clas_1057569177600423AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add Payment Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_1', 'Clas_1057569177600423AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Payment Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_1', 'Clas_1057569177600423AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Payment Type', '');

-- PIU: PaymentType._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423UIPobCl_Auto', '_Auto_', 'Payment Type', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423CjtoVis_AutoICtjoVis_1', 'idPaymentType', 'Payment Type', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423CjtoVis_AutoICtjoVis_2', 'PayDescription', 'Description', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423AccOfer_AutoElemAcc_4', 'SIUInsPaymentType', 'InsPaymentType', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423AccOfer_AutoElemAcc_5', 'IIUPaymentType', 'Payment Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600423UIPobCl_Auto', 'Clas_1057569177600423NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');

-- IIU: PaymentType.IIUPaymentType
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423UIInst_1', 'IIUPaymentType', 'Payment Type', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_1', 'Clas_1057569177600423AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add Payment Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_1', 'Clas_1057569177600423AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Payment Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_1', 'Clas_1057569177600423AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Payment Type', '');

-- IIU: PaymentType._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423UIInst_2', '_Auto_', 'Payment Type', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423AccOfer_AutoElemAcc_4', 'SIUInsPaymentType', 'InsPaymentType', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423AccOfer_AutoElemAcc_5', 'IIUPaymentType', 'Payment Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600423UIInst_2', 'Clas_1057569177600423NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');

-- SIU: PaymentType.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: PaymentType.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: PaymentType.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: PaymentType.SIUInsPaymentType
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600423Ser_4UIServ_1', 'SIUInsPaymentType', 'InsPaymentType', '', 'S');

---------------------------------------------
-- CLASS Project
---------------------------------------------
-- PIU: Project.PIUProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIPobCl_1', 'PIUProject', 'Projects', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_1', 'idProject', 'Project Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_2', 'ProjectName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_5', 'Team.name', 'Team', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_3', 'ProDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_4', 'TotExpenses', 'Total Expenses', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_6', 'MaxExpense', 'Max Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_7', 'MinExpense', 'Min Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719CjtoVis_1ICtjoVis_8', 'AvgExpense', 'Avg Expense', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719AccOfer_1ElemAcc_5', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719AccOfer_1ElemAcc_4', 'MDIUProjectExpenses', 'Project and Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIPobCl_1', 'Clas_1057569177600719NavOfer_2ElemNav_1', 'MDIUERTemplates', 'ER Templates', '');

-- PIU: Project.SELProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIPobCl_2', 'SELProject', 'Projects', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_1', 'idProject', 'Project Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_2', 'ProjectName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_5', 'Team.name', 'Team', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_3', 'ProDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_4', 'TotExpenses', 'Total Expenses', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_6', 'MaxExpense', 'Max Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_7', 'MinExpense', 'Min Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719CjtoVis_1ICtjoVis_8', 'AvgExpense', 'Avg Expense', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719AccOfer_1ElemAcc_5', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_2', 'Clas_1057569177600719AccOfer_1ElemAcc_4', 'MDIUProjectExpenses', 'Project and Expense Reports', '');

-- PIU: Project._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIPobCl_Auto', '_Auto_', 'Project', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_1', 'idProject', 'Project Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_2', 'ProjectName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_3', 'ProDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_4', 'TotExpenses', 'Total Expenses', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_5', 'CompletionDate', 'Completion Date', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_6', 'MaxExpense', 'Max Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_7', 'MinExpense', 'Min Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_8', 'AvgExpense', 'Avg Expense', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719CjtoVis_AutoICtjoVis_9', 'Completed', 'Completed?', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create New Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_4', 'SIUassignTemplateToProject', 'Assign Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_5', 'SIUdeassignTemplate', 'Deassign Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_6', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_7', 'IIUProject', 'Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_8', 'IIUProjectReports', 'Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719AccOfer_AutoElemAcc_9', 'MDIUProjectExpenses', 'Project and Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719NavOfer_AutoElemNav_2', 'PIUAssignments', 'Assignments', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719NavOfer_AutoElemNav_3', 'IIUTeam', 'Team', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIPobCl_Auto', 'Clas_1057569177600719NavOfer_AutoElemNav_4', 'PIUERTemplates', 'Expense Report Templates', '');

-- IIU: Project.IIUProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIInst_1', 'IIUProject', 'Project', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_1', 'Clas_1057569177600719AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_1', 'Clas_1057569177600719AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_1', 'Clas_1057569177600719AccOfer_1ElemAcc_5', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_1', 'Clas_1057569177600719AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_1', 'Clas_1057569177600719AccOfer_1ElemAcc_4', 'MDIUProjectExpenses', 'Project and Expense Reports', '');

-- IIU: Project.IIUProjectReports
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIInst_2', 'IIUProjectReports', 'Project', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_2', 'Clas_1057569177600719AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Add', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_2', 'Clas_1057569177600719AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_2', 'Clas_1057569177600719AccOfer_1ElemAcc_5', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_2', 'Clas_1057569177600719AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_2', 'Clas_1057569177600719AccOfer_1ElemAcc_4', 'MDIUProjectExpenses', 'Project and Expense Reports', '');

-- IIU: Project._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIInst_5', '_Auto_', 'Project', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create New Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_4', 'SIUassignTemplateToProject', 'Assign Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_5', 'SIUdeassignTemplate', 'Deassign Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_6', 'SIUTCOMPLETE', 'Complete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_7', 'IIUProject', 'Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_8', 'IIUProjectReports', 'Project', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719AccOfer_AutoElemAcc_9', 'MDIUProjectExpenses', 'Project and Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719NavOfer_AutoElemNav_2', 'PIUAssignments', 'Assignments', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719NavOfer_AutoElemNav_3', 'IIUTeam', 'Team', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600719UIInst_5', 'Clas_1057569177600719NavOfer_AutoElemNav_4', 'PIUERTemplates', 'Expense Report Templates', '');

-- MDIU: Project.MDIUProjectExpenses
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719UIMaDet_1', 'MDIUProjectExpenses', 'Project and Expense Reports', '', 'M');
INSERT INTO IUDetail (idIU, idIUDetail, IUDetailName, IUDetailAlias, IUDetailDescription) VALUES ('Clas_1057569177600719UIMaDet_1', 'Clas_1057569177600719UIMaDet_1Det_1', 'PIUExpenseReportProject', 'Expense Reports', '');
-- SIU: Project.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_1UIServ_1', 'SIUcreateinstance', 'Create New Project', '', 'S');
-- SIU: Project.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: Project.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: Project.SIUassignTemplateToProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_6UIServ_1', 'SIUassignTemplateToProject', 'Assign Template', '', 'S');
-- SIU: Project.SIUdeassignTemplate
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_7UIServ_1', 'SIUdeassignTemplate', 'Deassign Template', '', 'S');
-- SIU: Project.SIUTCOMPLETE
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600719Ser_5UIServ_1', 'SIUTCOMPLETE', 'Complete', '', 'S');

---------------------------------------------
-- CLASS ExpenseType
---------------------------------------------
-- PIU: ExpenseType.PIUExpenseType
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995UIPobCl_1', 'PIUExpenseType', 'Expense Types', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995CjtoVis_1ICtjoVis_1', 'TypeCode', 'Expense Type Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995CjtoVis_1ICtjoVis_2', 'Price', 'Unit Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995CjtoVis_1ICtjoVis_3', 'TyDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995CjtoVis_1ICtjoVis_4', 'FixedPrice', 'Fixed Price', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_1', 'Clas_1057569177600995AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Type', '');

-- PIU: ExpenseType._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995UIPobCl_Auto', '_Auto_', 'Expense Type', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995CjtoVis_AutoICtjoVis_1', 'TypeCode', 'Expense Type Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995CjtoVis_AutoICtjoVis_2', 'TyDescription', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995CjtoVis_AutoICtjoVis_3', 'Price', 'Unit Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995CjtoVis_AutoICtjoVis_4', 'FixedPrice', 'Fixed Price', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995AccOfer_AutoElemAcc_4', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995NavOfer_AutoElemNav_1', 'PIUExpenseLineToReports', 'Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600995UIPobCl_Auto', 'Clas_1057569177600995NavOfer_AutoElemNav_2', 'PIUTemplateLines', 'Template Lines', '');

-- IIU: ExpenseType.IIUExpenseType
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995UIInst_1', 'IIUExpenseType', 'Expense Type', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_1', 'Clas_1057569177600995AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_1', 'Clas_1057569177600995AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_1', 'Clas_1057569177600995AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Type', '');

-- IIU: ExpenseType._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995UIInst_2', '_Auto_', 'Expense Type', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995AccOfer_AutoElemAcc_4', 'IIUExpenseType', 'Expense Type', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995NavOfer_AutoElemNav_1', 'PIUExpenseLineToReports', 'Lines', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600995UIInst_2', 'Clas_1057569177600995NavOfer_AutoElemNav_2', 'PIUTemplateLines', 'Template Lines', '');

-- SIU: ExpenseType.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: ExpenseType.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: ExpenseType.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600995Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');

---------------------------------------------
-- CLASS ExpenseCurrency
---------------------------------------------
-- PIU: ExpenseCurrency.PIUExpenseCurrency
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792UIPobCl_1', 'PIUExpenseCurrency', 'Expense Currencies', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792CjtoVis_1ICtjoVis_1', 'CurrencyCode', 'Currency Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792CjtoVis_1ICtjoVis_2', 'CurAcronym', 'Acronym', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792CjtoVis_1ICtjoVis_3', 'CurrencyName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792CjtoVis_1ICtjoVis_4', 'Exchange', 'Exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_1', 'Clas_1057569177600792AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Currency', '');

-- PIU: ExpenseCurrency._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792UIPobCl_Auto', '_Auto_', 'Expense Currency', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792CjtoVis_AutoICtjoVis_1', 'CurrencyName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792CjtoVis_AutoICtjoVis_2', 'CurrencyCode', 'Currency Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792CjtoVis_AutoICtjoVis_3', 'CurAcronym', 'Acronym', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792CjtoVis_AutoICtjoVis_4', 'Exchange', 'Exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_4', 'SIUresetExchange', 'Reset exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_5', 'SIUeditExchange', 'Update exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_6', 'SIUTNEW', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_7', 'SIUTEDITEXCHANGE', 'Update exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792AccOfer_AutoElemAcc_8', 'IIUExpenseCurrency', 'Expense Currency', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600792UIPobCl_Auto', 'Clas_1057569177600792NavOfer_AutoElemNav_2', '_Auto_', 'Exchange History', '');

-- IIU: ExpenseCurrency.IIUExpenseCurrency
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792UIInst_1', 'IIUExpenseCurrency', 'Expense Currency', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_1', 'Clas_1057569177600792AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'New Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_1', 'Clas_1057569177600792AccOfer_1ElemAcc_2', 'SIUdeleteinstance', 'Delete Currency', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_1', 'Clas_1057569177600792AccOfer_1ElemAcc_3', 'SIUeditinstance', 'Edit Currency', '');

-- IIU: ExpenseCurrency._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792UIInst_2', '_Auto_', 'Expense Currency', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_4', 'SIUresetExchange', 'Reset exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_5', 'SIUeditExchange', 'Update exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_6', 'SIUTNEW', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_7', 'SIUTEDITEXCHANGE', 'Update exchange', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792AccOfer_AutoElemAcc_8', 'IIUExpenseCurrency', 'Expense Currency', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792NavOfer_AutoElemNav_1', 'PIUExpenseReportToEmployee', 'Expense Reports', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1057569177600792UIInst_2', 'Clas_1057569177600792NavOfer_AutoElemNav_2', '_Auto_', 'Exchange History', '');

-- SIU: ExpenseCurrency.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: ExpenseCurrency.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: ExpenseCurrency.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: ExpenseCurrency.SIUresetExchange
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_5UIServ_1', 'SIUresetExchange', 'Reset exchange', '', 'S');
-- SIU: ExpenseCurrency.SIUeditExchange
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_6UIServ_1', 'SIUeditExchange', 'Update exchange', '', 'S');
-- SIU: ExpenseCurrency.SIUTNEW
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_7UIServ_1', 'SIUTNEW', 'Create', '', 'S');
-- SIU: ExpenseCurrency.SIUTEDITEXCHANGE
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1057569177600792Ser_8UIServ_1', 'SIUTEDITEXCHANGE', 'Update exchange', '', 'S');

---------------------------------------------
-- CLASS Assignment
---------------------------------------------
-- PIU: Assignment.PIUAssignments
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118UIPobCl_1', 'PIUAssignments', 'Assignments', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118CjtoVis_2ICtjoVis_1', 'Project.ProjectName', 'Project', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118CjtoVis_2ICtjoVis_2', 'Employee.EmpFullName', 'Employee', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118CjtoVis_2ICtjoVis_3', 'IsActive', 'Active?', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118CjtoVis_2ICtjoVis_4', 'Details', 'Details', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118AccOfer_1ElemAcc_1', 'SIUnewAssignment', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118AccOfer_1ElemAcc_2', 'SIUeditAssignment', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118AccOfer_1ElemAcc_3', 'SIUterminateAssignment', 'Terminate', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118AccOfer_1ElemAcc_4', 'SIUdeleteAssignment', 'Delete', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1468338274304118UIPobCl_1', 'Clas_1468338274304118NavOfer_1ElemNav_1', 'IIUAssignment', 'Details', '');

-- PIU: Assignment._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118UIPobCl_Auto', '_Auto_', 'Assignment', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118CjtoVis_AutoICtjoVis_1', 'AssignmentID', 'id_Assignment', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118CjtoVis_AutoICtjoVis_2', 'FromDate', 'From', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118CjtoVis_AutoICtjoVis_3', 'ToDate', 'To', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118CjtoVis_AutoICtjoVis_4', 'IsActive', 'Active?', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118CjtoVis_AutoICtjoVis_5', 'Details', 'Details', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118AccOfer_AutoElemAcc_1', 'SIUnewAssignment', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118AccOfer_AutoElemAcc_2', 'SIUdeleteAssignment', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118AccOfer_AutoElemAcc_3', 'SIUeditAssignment', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118AccOfer_AutoElemAcc_4', 'SIUterminateAssignment', 'Terminate', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118AccOfer_AutoElemAcc_5', 'IIUAssignment', 'Assignment Details', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118NavOfer_AutoElemNav_1', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1468338274304118UIPobCl_Auto', 'Clas_1468338274304118NavOfer_AutoElemNav_2', 'IIUProjectReports', 'Project', '');

-- IIU: Assignment.IIUAssignment
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118UIInst_1', 'IIUAssignment', 'Assignment Details', '', 'I');

-- IIU: Assignment._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118UIInst_2', '_Auto_', 'Assignment', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118AccOfer_AutoElemAcc_1', 'SIUnewAssignment', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118AccOfer_AutoElemAcc_2', 'SIUdeleteAssignment', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118AccOfer_AutoElemAcc_3', 'SIUeditAssignment', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118AccOfer_AutoElemAcc_4', 'SIUterminateAssignment', 'Terminate', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118AccOfer_AutoElemAcc_5', 'IIUAssignment', 'Assignment Details', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118NavOfer_AutoElemNav_1', 'IIUEmployeeReports', 'Reports of Employee', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1468338274304118UIInst_2', 'Clas_1468338274304118NavOfer_AutoElemNav_2', 'IIUProjectReports', 'Project', '');

-- SIU: Assignment.SIUnewAssignment
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118Ser_1UIServ_1', 'SIUnewAssignment', 'Create', '', 'S');
-- SIU: Assignment.SIUdeleteAssignment
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118Ser_2UIServ_1', 'SIUdeleteAssignment', 'Delete', '', 'S');
-- SIU: Assignment.SIUeditAssignment
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118Ser_3UIServ_1', 'SIUeditAssignment', 'Edit', '', 'S');
-- SIU: Assignment.SIUterminateAssignment
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468338274304118Ser_5UIServ_1', 'SIUterminateAssignment', 'Terminate', '', 'S');

---------------------------------------------
-- CLASS AppUser
---------------------------------------------
-- PIU: AppUser.PIUAppUsers
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231UIPobCl_1', 'PIUAppUsers', 'Users', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231CjtoVis_1ICtjoVis_1', 'Login', 'Login', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231CjtoVis_1ICtjoVis_3', 'UserSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231CjtoVis_1ICtjoVis_2', 'UserName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231CjtoVis_1ICtjoVis_4', 'UserType', 'Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231AccOfer_1ElemAcc_1', 'SIUTNEWUSER', 'New', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231AccOfer_1ElemAcc_2', 'SIUTEDITUSER', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231AccOfer_1ElemAcc_3', 'SIUsetPassword', 'Change pwd', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_1', 'Clas_1468421898240231AccOfer_1ElemAcc_5', 'SIUTDELETE', 'Delete', '');

-- PIU: AppUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231UIPobCl_Auto', '_Auto_', 'User', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231CjtoVis_AutoICtjoVis_1', 'Login', 'Login', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231CjtoVis_AutoICtjoVis_2', 'UserName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231CjtoVis_AutoICtjoVis_3', 'UserSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231CjtoVis_AutoICtjoVis_4', 'UserType', 'Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_1', 'SIUnewUser', 'New User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_2', 'SIUdeleteUser', 'Delete User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_3', 'SIUeditUser', 'editUser', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_4', 'SIUsetPassword', 'Set password', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_5', 'SIUTNEWUSER', 'New User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_6', 'SIUTEDITUSER', 'Edit User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_7', 'SIUTDELETE', 'Delete User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIPobCl_Auto', 'Clas_1468421898240231AccOfer_AutoElemAcc_8', '_Auto_', 'User', '');

-- IIU: AppUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231UIInst_1', '_Auto_', 'User', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_1', 'SIUnewUser', 'New User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_2', 'SIUdeleteUser', 'Delete User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_3', 'SIUeditUser', 'editUser', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_4', 'SIUsetPassword', 'Set password', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_5', 'SIUTNEWUSER', 'New User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_6', 'SIUTEDITUSER', 'Edit User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_7', 'SIUTDELETE', 'Delete User', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468421898240231UIInst_1', 'Clas_1468421898240231AccOfer_AutoElemAcc_8', '_Auto_', 'User', '');

-- SIU: AppUser.SIUnewUser
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_2UIServ_1', 'SIUnewUser', 'New User', '', 'S');
-- SIU: AppUser.SIUdeleteUser
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_3UIServ_1', 'SIUdeleteUser', 'Delete User', '', 'S');
-- SIU: AppUser.SIUeditUser
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_4UIServ_1', 'SIUeditUser', 'editUser', '', 'S');
-- SIU: AppUser.SIUsetPassword
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_5UIServ_1', 'SIUsetPassword', 'Set password', '', 'S');
-- SIU: AppUser.SIUTNEWUSER
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_9UIServ_1', 'SIUTNEWUSER', 'New User', '', 'S');
-- SIU: AppUser.SIUTEDITUSER
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_10UIServ_1', 'SIUTEDITUSER', 'Edit User', '', 'S');
-- SIU: AppUser.SIUTDELETE
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468421898240231Ser_13UIServ_1', 'SIUTDELETE', 'Delete User', '', 'S');

---------------------------------------------
-- CLASS AdminUser
---------------------------------------------
-- PIU: AdminUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468422160384126UIPobCl_Auto', '_Auto_', 'AdminUser', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384126UIPobCl_Auto', 'Clas_1468422160384126CjtoVis_AutoICtjoVis_1', 'Login', 'Login', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384126UIPobCl_Auto', 'Clas_1468422160384126CjtoVis_AutoICtjoVis_2', 'UserName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384126UIPobCl_Auto', 'Clas_1468422160384126CjtoVis_AutoICtjoVis_3', 'UserSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384126UIPobCl_Auto', 'Clas_1468422160384126CjtoVis_AutoICtjoVis_4', 'UserType', 'Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468422160384126UIPobCl_Auto', 'Clas_1468422160384126AccOfer_AutoElemAcc_1', '_Auto_', 'AdminUser', '');

-- IIU: AdminUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468422160384126UIInst_0', '_Auto_', 'AdminUser', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468422160384126UIInst_0', 'Clas_1468422160384126AccOfer_AutoElemAcc_1', '_Auto_', 'AdminUser', '');


---------------------------------------------
-- CLASS OperatorUser
---------------------------------------------
-- PIU: OperatorUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468422160384512UIPobCl_Auto', '_Auto_', 'OperatorUser', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384512UIPobCl_Auto', 'Clas_1468422160384512CjtoVis_AutoICtjoVis_1', 'Login', 'Login', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384512UIPobCl_Auto', 'Clas_1468422160384512CjtoVis_AutoICtjoVis_2', 'UserName', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384512UIPobCl_Auto', 'Clas_1468422160384512CjtoVis_AutoICtjoVis_3', 'UserSurname', 'Surname', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1468422160384512UIPobCl_Auto', 'Clas_1468422160384512CjtoVis_AutoICtjoVis_4', 'UserType', 'Type', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468422160384512UIPobCl_Auto', 'Clas_1468422160384512AccOfer_AutoElemAcc_1', '_Auto_', 'OperatorUser', '');

-- IIU: OperatorUser._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1468422160384512UIInst_0', '_Auto_', 'OperatorUser', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1468422160384512UIInst_0', 'Clas_1468422160384512AccOfer_AutoElemAcc_1', '_Auto_', 'OperatorUser', '');


---------------------------------------------
-- CLASS Team
---------------------------------------------
-- PIU: Team.PIUTeams
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348UIPobCl_1', 'PIUTeams', 'Teams', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348CjtoVis_1ICtjoVis_1', 'id', 'Team ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348CjtoVis_1ICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348CjtoVis_1ICtjoVis_3', 'maxEmployees', 'Max Employees', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348CjtoVis_1ICtjoVis_4', 'countEmployees', '# employees', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348CjtoVis_1ICtjoVis_5', 'totalExpenses', 'Total expenses', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_1', 'Clas_1622453649408348AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');

-- PIU: Team._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348UIPobCl_Auto', '_Auto_', 'Team', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_1', 'id', 'Team ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_3', 'maxEmployees', 'Max Employees', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_4', 'countEmployees', '# employees', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_5', 'totalExpenses', 'Total expenses', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348CjtoVis_AutoICtjoVis_6', 'capacity', 'Capcity', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_4', 'SIUaddEmployeeToTeam', 'addEmployeeToTeam', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_5', 'SIUremoveEmployeeFromTeam', 'removeEmployeeFromTeam', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348AccOfer_AutoElemAcc_6', 'IIUTeam', 'Team', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348NavOfer_AutoElemNav_1', 'PIUEmployee', 'Employees', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622453649408348UIPobCl_Auto', 'Clas_1622453649408348NavOfer_AutoElemNav_2', 'SELProject', 'Projects', '');

-- IIU: Team.IIUTeam
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348UIInst_1', 'IIUTeam', 'Team', '', 'I');

-- IIU: Team._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348UIInst_2', '_Auto_', 'Team', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_4', 'SIUaddEmployeeToTeam', 'addEmployeeToTeam', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_5', 'SIUremoveEmployeeFromTeam', 'removeEmployeeFromTeam', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348AccOfer_AutoElemAcc_6', 'IIUTeam', 'Team', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348NavOfer_AutoElemNav_1', 'PIUEmployee', 'Employees', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622453649408348UIInst_2', 'Clas_1622453649408348NavOfer_AutoElemNav_2', 'SELProject', 'Projects', '');

-- SIU: Team.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: Team.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: Team.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: Team.SIUaddEmployeeToTeam
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348Ser_4UIServ_1', 'SIUaddEmployeeToTeam', 'addEmployeeToTeam', '', 'S');
-- SIU: Team.SIUremoveEmployeeFromTeam
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622453649408348Ser_5UIServ_1', 'SIUremoveEmployeeFromTeam', 'removeEmployeeFromTeam', '', 'S');

---------------------------------------------
-- CLASS ERTemplate
---------------------------------------------
-- PIU: ERTemplate.PIUERTemplates
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786UIPobCl_1', 'PIUERTemplates', 'Expense Report Templates', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786CjtoVis_1ICtjoVis_1', 'id', 'ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786CjtoVis_1ICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786CjtoVis_1ICtjoVis_3', 'enabled', 'Enabled?', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786CjtoVis_1ICtjoVis_4', 'total', 'Total', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786CjtoVis_1ICtjoVis_5', 'description', 'Description', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786AccOfer_1ElemAcc_3', 'SIUenable', 'Enable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786AccOfer_1ElemAcc_4', 'SIUdisable', 'Disable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_1', 'Clas_1622460465152786AccOfer_1ElemAcc_5', 'SIUdeleteinstance', 'Delete', '');

-- PIU: ERTemplate._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786UIPobCl_Auto', '_Auto_', 'Expense Report Template', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786CjtoVis_AutoICtjoVis_1', 'id', 'ID', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786CjtoVis_AutoICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786CjtoVis_AutoICtjoVis_3', 'description', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786CjtoVis_AutoICtjoVis_4', 'total', 'Total', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786CjtoVis_AutoICtjoVis_5', 'enabled', 'Enabled?', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_4', 'SIUeditName', 'editName', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_5', 'SIUeditDescription', 'editDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_6', 'SIUclearName', 'clearName', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_7', 'SIUclearDescription', 'clearDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_8', 'SIUenable', 'Enable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_9', 'SIUdisable', 'Disable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_10', 'SIUassignTemplateToProject', 'assignTemplateToProject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_11', 'SIUdeassignTemplate', 'deassignTemplate', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_12', '_Auto_', 'Expense Report Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786AccOfer_AutoElemAcc_13', 'MDIUERTemplates', 'Expense Report Templates', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786NavOfer_AutoElemNav_1', 'SELProject', 'Projects', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460465152786UIPobCl_Auto', 'Clas_1622460465152786NavOfer_AutoElemNav_2', 'PIUTemplateLines', 'Template Lines', '');

-- IIU: ERTemplate._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786UIInst_2', '_Auto_', 'Expense Report Template', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_4', 'SIUeditName', 'editName', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_5', 'SIUeditDescription', 'editDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_6', 'SIUclearName', 'clearName', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_7', 'SIUclearDescription', 'clearDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_8', 'SIUenable', 'Enable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_9', 'SIUdisable', 'Disable', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_10', 'SIUassignTemplateToProject', 'assignTemplateToProject', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_11', 'SIUdeassignTemplate', 'deassignTemplate', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_12', '_Auto_', 'Expense Report Template', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786AccOfer_AutoElemAcc_13', 'MDIUERTemplates', 'Expense Report Templates', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786NavOfer_AutoElemNav_1', 'SELProject', 'Projects', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460465152786UIInst_2', 'Clas_1622460465152786NavOfer_AutoElemNav_2', 'PIUTemplateLines', 'Template Lines', '');

-- MDIU: ERTemplate.MDIUERTemplates
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786UIMaDet_1', 'MDIUERTemplates', 'Expense Report Templates', '', 'M');
INSERT INTO IUDetail (idIU, idIUDetail, IUDetailName, IUDetailAlias, IUDetailDescription) VALUES ('Clas_1622460465152786UIMaDet_1', 'Clas_1622460465152786UIMaDet_1Det_1', 'PIUTemplateLines', 'Template Lines', '');
-- SIU: ERTemplate.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: ERTemplate.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: ERTemplate.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: ERTemplate.SIUeditName
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_4UIServ_1', 'SIUeditName', 'editName', '', 'S');
-- SIU: ERTemplate.SIUeditDescription
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_5UIServ_1', 'SIUeditDescription', 'editDescription', '', 'S');
-- SIU: ERTemplate.SIUclearName
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_6UIServ_1', 'SIUclearName', 'clearName', '', 'S');
-- SIU: ERTemplate.SIUclearDescription
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_7UIServ_1', 'SIUclearDescription', 'clearDescription', '', 'S');
-- SIU: ERTemplate.SIUenable
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_8UIServ_1', 'SIUenable', 'Enable', '', 'S');
-- SIU: ERTemplate.SIUdisable
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_9UIServ_1', 'SIUdisable', 'Disable', '', 'S');
-- SIU: ERTemplate.SIUassignTemplateToProject
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_10UIServ_1', 'SIUassignTemplateToProject', 'assignTemplateToProject', '', 'S');
-- SIU: ERTemplate.SIUdeassignTemplate
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460465152786Ser_11UIServ_1', 'SIUdeassignTemplate', 'deassignTemplate', '', 'S');

---------------------------------------------
-- CLASS ERLTemplate
---------------------------------------------
-- PIU: ERLTemplate.PIUTemplateLines
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994UIPobCl_1', 'PIUTemplateLines', 'Template Lines', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994CjtoVis_1ICtjoVis_1', 'id', 'Line #', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994CjtoVis_1ICtjoVis_2', 'units', 'Units', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994CjtoVis_1ICtjoVis_3', 'description', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994CjtoVis_1ICtjoVis_4', 'price', 'Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994CjtoVis_1ICtjoVis_5', 'totalLine', 'Line Total', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_1', 'Clas_1622460596224994AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');

-- PIU: ERLTemplate._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994UIPobCl_Auto', '_Auto_', 'Expense Report Line Template', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994CjtoVis_AutoICtjoVis_1', 'id', 'Line #', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994CjtoVis_AutoICtjoVis_2', 'units', 'Units', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994CjtoVis_AutoICtjoVis_3', 'price', 'Price', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994CjtoVis_AutoICtjoVis_4', 'description', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994CjtoVis_AutoICtjoVis_5', 'totalLine', 'Line Total', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_4', 'SIUeditUnits', 'editUnits', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_5', 'SIUeditPrice', 'editPrice', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_6', 'SIUeditDescription', 'editDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_7', 'SIUclearUnits', 'clearUnits', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_8', 'SIUclearPrice', 'clearPrice', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_9', 'SIUclearDescription', 'clearDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994AccOfer_AutoElemAcc_10', '_Auto_', 'Expense Report Line Template', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994NavOfer_AutoElemNav_1', '_Auto_', 'Expense Report Template', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460596224994UIPobCl_Auto', 'Clas_1622460596224994NavOfer_AutoElemNav_2', 'IIUExpenseType', 'Expense Type', '');

-- IIU: ERLTemplate._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994UIInst_1', '_Auto_', 'Expense Report Line Template', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_4', 'SIUeditUnits', 'editUnits', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_5', 'SIUeditPrice', 'editPrice', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_6', 'SIUeditDescription', 'editDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_7', 'SIUclearUnits', 'clearUnits', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_8', 'SIUclearPrice', 'clearPrice', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_9', 'SIUclearDescription', 'clearDescription', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994AccOfer_AutoElemAcc_10', '_Auto_', 'Expense Report Line Template', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994NavOfer_AutoElemNav_1', '_Auto_', 'Expense Report Template', '');
INSERT INTO IUNavigation (idIU, idIUNavigation, IUNavigationName, IUNavigationAlias, IUNavigationDescription) VALUES ('Clas_1622460596224994UIInst_1', 'Clas_1622460596224994NavOfer_AutoElemNav_2', 'IIUExpenseType', 'Expense Type', '');

-- SIU: ERLTemplate.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: ERLTemplate.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: ERLTemplate.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');
-- SIU: ERLTemplate.SIUeditUnits
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_4UIServ_1', 'SIUeditUnits', 'editUnits', '', 'S');
-- SIU: ERLTemplate.SIUeditPrice
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_5UIServ_1', 'SIUeditPrice', 'editPrice', '', 'S');
-- SIU: ERLTemplate.SIUeditDescription
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_6UIServ_1', 'SIUeditDescription', 'editDescription', '', 'S');
-- SIU: ERLTemplate.SIUclearUnits
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_7UIServ_1', 'SIUclearUnits', 'clearUnits', '', 'S');
-- SIU: ERLTemplate.SIUclearPrice
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_8UIServ_1', 'SIUclearPrice', 'clearPrice', '', 'S');
-- SIU: ERLTemplate.SIUclearDescription
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622460596224994Ser_9UIServ_1', 'SIUclearDescription', 'clearDescription', '', 'S');

---------------------------------------------
-- CLASS ExchangeHistory
---------------------------------------------
-- SIU: ExchangeHistory.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622465314816112Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: ExchangeHistory.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622465314816112Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: ExchangeHistory.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622465314816112Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');

---------------------------------------------
-- CLASS SystemParam
---------------------------------------------
-- PIU: SystemParam.PIUSystemParams
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378UIPobCl_1', 'PIUSystemParams', 'System Parameters', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378CjtoVis_1ICtjoVis_1', 'paramCode', 'Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378CjtoVis_1ICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378CjtoVis_1ICtjoVis_3', 'typeName', 'Type', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378CjtoVis_1ICtjoVis_4', 'paramValue', 'Value', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378CjtoVis_1ICtjoVis_5', 'description', 'Description', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378AccOfer_1ElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378AccOfer_1ElemAcc_2', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_1', 'Clas_1622477111296378AccOfer_1ElemAcc_3', 'SIUdeleteinstance', 'Delete', '');

-- PIU: SystemParam._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378UIPobCl_Auto', '_Auto_', 'System Parameter', '', 'P');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378CjtoVis_AutoICtjoVis_1', 'paramCode', 'Code', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378CjtoVis_AutoICtjoVis_2', 'name', 'Name', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378CjtoVis_AutoICtjoVis_3', 'description', 'Description', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378CjtoVis_AutoICtjoVis_4', 'typeName', 'Type', '');
INSERT INTO IUAttribute (idIU, idIUAttribute, IUAttributeName, IUAttributeAlias, IUAttributeDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378CjtoVis_AutoICtjoVis_5', 'paramValue', 'Value', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIPobCl_Auto', 'Clas_1622477111296378AccOfer_AutoElemAcc_4', '_Auto_', 'System Parameter', '');

-- IIU: SystemParam._Auto_
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378UIInst_1', '_Auto_', 'System Parameter', '', 'I');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIInst_1', 'Clas_1622477111296378AccOfer_AutoElemAcc_1', 'SIUcreateinstance', 'Create', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIInst_1', 'Clas_1622477111296378AccOfer_AutoElemAcc_2', 'SIUdeleteinstance', 'Delete', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIInst_1', 'Clas_1622477111296378AccOfer_AutoElemAcc_3', 'SIUeditinstance', 'Edit', '');
INSERT INTO IUAction (idIU, idIUAction, IUActionName, IUActionAlias, IUActionDescription) VALUES ('Clas_1622477111296378UIInst_1', 'Clas_1622477111296378AccOfer_AutoElemAcc_4', '_Auto_', 'System Parameter', '');

-- SIU: SystemParam.SIUcreateinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378Ser_1UIServ_1', 'SIUcreateinstance', 'Create', '', 'S');
-- SIU: SystemParam.SIUdeleteinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378Ser_2UIServ_1', 'SIUdeleteinstance', 'Delete', '', 'S');
-- SIU: SystemParam.SIUeditinstance
INSERT INTO IU (idIU, IUName, IUAlias, IUDescription, IUType) VALUES ('Clas_1622477111296378Ser_3UIServ_1', 'SIUeditinstance', 'Edit', '', 'S');

---------------------------------------------
-- HAT NODES
---------------------------------------------
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_2', null, 'User', 'User', '', ' | User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_3', 'Clas_1468421898240231UIPobCl_1', 'Users', 'Users', '', ' | User | Users');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_4', 'Clas_1468421898240231Ser_2UIServ_1', 'New User', 'New User', '', ' | User | New User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_5', 'Clas_1468421898240231Ser_3UIServ_1', 'Delete User', 'Delete User', '', ' | User | Delete User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_6', 'Clas_1468421898240231Ser_4UIServ_1', 'editUser', 'editUser', '', ' | User | editUser');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_7', 'Clas_1468421898240231Ser_5UIServ_1', 'Set password', 'Set password', '', ' | User | Set password');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_8', 'Clas_1468421898240231Ser_9UIServ_1', 'New User', 'New User', '', ' | User | New User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_9', 'Clas_1468421898240231Ser_10UIServ_1', 'Edit User', 'Edit User', '', ' | User | Edit User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_10', 'Clas_1468421898240231Ser_13UIServ_1', 'Delete User', 'Delete User', '', ' | User | Delete User');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_13', null, 'Assignment', 'Assignment', '', ' | Assignment');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_14', 'Clas_1468338274304118UIInst_1', 'Assignment Details', 'Assignment Details', '', ' | Assignment | Assignment Details');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_15', 'Clas_1468338274304118UIPobCl_1', 'Assignments', 'Assignments', '', ' | Assignment | Assignments');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_16', 'Clas_1468338274304118Ser_1UIServ_1', 'Create', 'Create', '', ' | Assignment | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_17', 'Clas_1468338274304118Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Assignment | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_18', 'Clas_1468338274304118Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Assignment | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_19', 'Clas_1468338274304118Ser_5UIServ_1', 'Terminate', 'Terminate', '', ' | Assignment | Terminate');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_20', null, 'Employee', 'Employee', '', ' | Employee');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_21', 'Clas_1057569177600607UIInst_1', 'Employee', 'Employee', '', ' | Employee | Employee');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_22', 'Clas_1057569177600607UIInst_2', 'Reports of Employee', 'Reports of Employee', '', ' | Employee | Reports of Employee');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_23', 'Clas_1057569177600607UIPobCl_1', 'Employees', 'Employees', '', ' | Employee | Employees');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_24', 'Clas_1057569177600607UIMaDet_1', 'Employee Details', 'Employee Details', '', ' | Employee | Employee Details');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_25', 'Clas_1057569177600607Ser_1UIServ_1', 'Create', 'Create', '', ' | Employee | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_26', 'Clas_1057569177600607Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Employee | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_27', 'Clas_1057569177600607Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Employee | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_28', 'Clas_1057569177600607Ser_4UIServ_1', 'Change Picture', 'Change Picture', '', ' | Employee | Change Picture');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_29', 'Clas_1057569177600607Ser_7UIServ_1', 'Add Employee to Team', 'Add Employee to Team', '', ' | Employee | Add Employee to Team');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_30', 'Clas_1057569177600607Ser_8UIServ_1', 'Remove Employee from Team', 'Remove Employee from Team', '', ' | Employee | Remove Employee from Team');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_31', 'Clas_1057569177600607Ser_9UIServ_1', 'Delete', 'Delete', '', ' | Employee | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_32', null, 'Expense Report Line Template', 'Expense Report Line Template', '', ' | Expense Report Line Template');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_33', 'Clas_1622460596224994UIPobCl_1', 'Template Lines', 'Template Lines', '', ' | Expense Report Line Template | Template Lines');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_34', 'Clas_1622460596224994Ser_1UIServ_1', 'Create', 'Create', '', ' | Expense Report Line Template | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_35', 'Clas_1622460596224994Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Expense Report Line Template | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_36', 'Clas_1622460596224994Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Expense Report Line Template | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_37', 'Clas_1622460596224994Ser_4UIServ_1', 'editUnits', 'editUnits', '', ' | Expense Report Line Template | editUnits');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_38', 'Clas_1622460596224994Ser_5UIServ_1', 'editPrice', 'editPrice', '', ' | Expense Report Line Template | editPrice');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_39', 'Clas_1622460596224994Ser_6UIServ_1', 'editDescription', 'editDescription', '', ' | Expense Report Line Template | editDescription');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_40', 'Clas_1622460596224994Ser_7UIServ_1', 'clearUnits', 'clearUnits', '', ' | Expense Report Line Template | clearUnits');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_41', 'Clas_1622460596224994Ser_8UIServ_1', 'clearPrice', 'clearPrice', '', ' | Expense Report Line Template | clearPrice');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_42', 'Clas_1622460596224994Ser_9UIServ_1', 'clearDescription', 'clearDescription', '', ' | Expense Report Line Template | clearDescription');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_43', null, 'Expense Report Template', 'Expense Report Template', '', ' | Expense Report Template');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_44', 'Clas_1622460465152786UIPobCl_1', 'Expense Report Templates', 'Expense Report Templates', '', ' | Expense Report Template | Expense Report Templates');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_45', 'Clas_1622460465152786UIMaDet_1', 'Expense Report Templates', 'Expense Report Templates', '', ' | Expense Report Template | Expense Report Templates');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_46', 'Clas_1622460465152786Ser_1UIServ_1', 'Create', 'Create', '', ' | Expense Report Template | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_47', 'Clas_1622460465152786Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Expense Report Template | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_48', 'Clas_1622460465152786Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Expense Report Template | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_49', 'Clas_1622460465152786Ser_4UIServ_1', 'editName', 'editName', '', ' | Expense Report Template | editName');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_50', 'Clas_1622460465152786Ser_5UIServ_1', 'editDescription', 'editDescription', '', ' | Expense Report Template | editDescription');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_51', 'Clas_1622460465152786Ser_6UIServ_1', 'clearName', 'clearName', '', ' | Expense Report Template | clearName');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_52', 'Clas_1622460465152786Ser_7UIServ_1', 'clearDescription', 'clearDescription', '', ' | Expense Report Template | clearDescription');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_53', 'Clas_1622460465152786Ser_8UIServ_1', 'Enable', 'Enable', '', ' | Expense Report Template | Enable');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_54', 'Clas_1622460465152786Ser_9UIServ_1', 'Disable', 'Disable', '', ' | Expense Report Template | Disable');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_55', 'Clas_1622460465152786Ser_10UIServ_1', 'assignTemplateToProject', 'assignTemplateToProject', '', ' | Expense Report Template | assignTemplateToProject');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_56', 'Clas_1622460465152786Ser_11UIServ_1', 'deassignTemplate', 'deassignTemplate', '', ' | Expense Report Template | deassignTemplate');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_57', null, 'Exchange History', 'Exchange History', '', ' | Exchange History');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_58', 'Clas_1622465314816112UIPobCl_Auto', 'Exchange History', 'Exchange History', '', ' | Exchange History | Exchange History');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_59', 'Clas_1622465314816112Ser_1UIServ_1', 'Create', 'Create', '', ' | Exchange History | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_60', 'Clas_1622465314816112Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Exchange History | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_61', 'Clas_1622465314816112Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Exchange History | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_62', null, 'Expense Currency', 'Expense Currency', '', ' | Expense Currency');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_63', 'Clas_1057569177600792UIInst_1', 'Expense Currency', 'Expense Currency', '', ' | Expense Currency | Expense Currency');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_64', 'Clas_1057569177600792UIPobCl_1', 'Expense Currencies', 'Expense Currencies', '', ' | Expense Currency | Expense Currencies');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_65', 'Clas_1057569177600792Ser_1UIServ_1', 'Create', 'Create', '', ' | Expense Currency | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_66', 'Clas_1057569177600792Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Expense Currency | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_67', 'Clas_1057569177600792Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Expense Currency | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_68', 'Clas_1057569177600792Ser_5UIServ_1', 'Reset exchange', 'Reset exchange', '', ' | Expense Currency | Reset exchange');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_69', 'Clas_1057569177600792Ser_6UIServ_1', 'Update exchange', 'Update exchange', '', ' | Expense Currency | Update exchange');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_70', 'Clas_1057569177600792Ser_7UIServ_1', 'Create', 'Create', '', ' | Expense Currency | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_71', 'Clas_1057569177600792Ser_8UIServ_1', 'Update exchange', 'Update exchange', '', ' | Expense Currency | Update exchange');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_72', null, 'Expense Line', 'Expense Line', '', ' | Expense Line');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_73', 'Clas_1057569177600646UIInst_1', 'Expense Line', 'Expense Line', '', ' | Expense Line | Expense Line');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_74', 'Clas_1057569177600646UIPobCl_1', 'Expense Lines', 'Expense Lines', '', ' | Expense Line | Expense Lines');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_75', 'Clas_1057569177600646UIPobCl_2', 'Lines', 'Lines', '', ' | Expense Line | Lines');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_76', 'Clas_1057569177600646Ser_1UIServ_1', 'Create a New Line', 'Create a New Line', '', ' | Expense Line | Create a New Line');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_77', 'Clas_1057569177600646Ser_2UIServ_1', 'Delete Line', 'Delete Line', '', ' | Expense Line | Delete Line');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_78', 'Clas_1057569177600646Ser_3UIServ_1', 'Edit a Line', 'Edit a Line', '', ' | Expense Line | Edit a Line');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_79', null, 'Expense Report', 'Expense Report', '', ' | Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_80', 'Clas_1057569177600553UIInst_1', 'Expense Report', 'Expense Report', '', ' | Expense Report | Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_81', 'Clas_1057569177600553UIPobCl_1', 'Expense Reports', 'Expense Reports', '', ' | Expense Report | Expense Reports');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_82', 'Clas_1057569177600553UIPobCl_2', 'Expense Reports', 'Expense Reports', '', ' | Expense Report | Expense Reports');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_83', 'Clas_1057569177600553UIPobCl_4', 'Expense Reports', 'Expense Reports', '', ' | Expense Report | Expense Reports');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_84', 'Clas_1057569177600553UIMaDet_1', 'Expense Reports and Lines', 'Expense Reports and Lines', '', ' | Expense Report | Expense Reports and Lines');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_85', 'Clas_1057569177600553Ser_3UIServ_1', 'Close a Expense Report', 'Close a Expense Report', '', ' | Expense Report | Close a Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_86', 'Clas_1057569177600553Ser_4UIServ_1', 'Mark as Authorized', 'Mark as Authorized', '', ' | Expense Report | Mark as Authorized');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_87', 'Clas_1057569177600553Ser_6UIServ_1', 'Reject Auhorization', 'Reject Auhorization', '', ' | Expense Report | Reject Auhorization');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_88', 'Clas_1057569177600553Ser_10UIServ_1', 'Cancel Approval', 'Cancel Approval', '', ' | Expense Report | Cancel Approval');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_89', 'Clas_1057569177600553Ser_11UIServ_1', 'Mark as Approved', 'Mark as Approved', '', ' | Expense Report | Mark as Approved');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_90', 'Clas_1057569177600553Ser_12UIServ_1', 'Edit Expense Report', 'Edit Expense Report', '', ' | Expense Report | Edit Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_91', 'Clas_1057569177600553Ser_13UIServ_1', 'Delete an Expense Report', 'Delete an Expense Report', '', ' | Expense Report | Delete an Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_92', 'Clas_1057569177600553Ser_14UIServ_1', 'Mark as Paid', 'Mark as Paid', '', ' | Expense Report | Mark as Paid');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_93', 'Clas_1057569177600553Ser_15UIServ_1', 'New Expense Report', 'New Expense Report', '', ' | Expense Report | New Expense Report');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_94', 'Clas_1057569177600553Ser_16UIServ_1', 'Reject Payment', 'Reject Payment', '', ' | Expense Report | Reject Payment');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_95', 'Clas_1057569177600553Ser_20UIServ_1', 'New Expense Report from Template', 'New Expense Report from Template', '', ' | Expense Report | New Expense Report from Template');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_96', null, 'Expense Type', 'Expense Type', '', ' | Expense Type');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_97', 'Clas_1057569177600995UIInst_1', 'Expense Type', 'Expense Type', '', ' | Expense Type | Expense Type');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_98', 'Clas_1057569177600995UIPobCl_1', 'Expense Types', 'Expense Types', '', ' | Expense Type | Expense Types');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_99', 'Clas_1057569177600995Ser_1UIServ_1', 'Create', 'Create', '', ' | Expense Type | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_100', 'Clas_1057569177600995Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Expense Type | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_101', 'Clas_1057569177600995Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Expense Type | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_102', null, 'Payment Type', 'Payment Type', '', ' | Payment Type');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_103', 'Clas_1057569177600423UIInst_1', 'Payment Type', 'Payment Type', '', ' | Payment Type | Payment Type');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_104', 'Clas_1057569177600423UIPobCl_1', 'Payment Types', 'Payment Types', '', ' | Payment Type | Payment Types');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_105', 'Clas_1057569177600423Ser_1UIServ_1', 'Create', 'Create', '', ' | Payment Type | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_106', 'Clas_1057569177600423Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Payment Type | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_107', 'Clas_1057569177600423Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Payment Type | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_108', 'Clas_1057569177600423Ser_4UIServ_1', 'InsPaymentType', 'InsPaymentType', '', ' | Payment Type | InsPaymentType');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_109', null, 'Project', 'Project', '', ' | Project');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_110', 'Clas_1057569177600719UIInst_1', 'Project', 'Project', '', ' | Project | Project');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_111', 'Clas_1057569177600719UIInst_2', 'Project', 'Project', '', ' | Project | Project');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_112', 'Clas_1057569177600719UIPobCl_1', 'Projects', 'Projects', '', ' | Project | Projects');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_113', 'Clas_1057569177600719UIPobCl_2', 'Projects', 'Projects', '', ' | Project | Projects');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_114', 'Clas_1057569177600719UIMaDet_1', 'Project and Expense Reports', 'Project and Expense Reports', '', ' | Project | Project and Expense Reports');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_115', 'Clas_1057569177600719Ser_1UIServ_1', 'Create New Project', 'Create New Project', '', ' | Project | Create New Project');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_116', 'Clas_1057569177600719Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Project | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_117', 'Clas_1057569177600719Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Project | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_118', 'Clas_1057569177600719Ser_6UIServ_1', 'Assign Template', 'Assign Template', '', ' | Project | Assign Template');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_119', 'Clas_1057569177600719Ser_7UIServ_1', 'Deassign Template', 'Deassign Template', '', ' | Project | Deassign Template');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_120', 'Clas_1057569177600719Ser_5UIServ_1', 'Complete', 'Complete', '', ' | Project | Complete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_121', null, 'System Parameter', 'System Parameter', '', ' | System Parameter');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_122', 'Clas_1622477111296378UIPobCl_1', 'System Parameters', 'System Parameters', '', ' | System Parameter | System Parameters');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_123', 'Clas_1622477111296378Ser_1UIServ_1', 'Create', 'Create', '', ' | System Parameter | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_124', 'Clas_1622477111296378Ser_2UIServ_1', 'Delete', 'Delete', '', ' | System Parameter | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_125', 'Clas_1622477111296378Ser_3UIServ_1', 'Edit', 'Edit', '', ' | System Parameter | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_126', null, 'Team', 'Team', '', ' | Team');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_127', 'Clas_1622453649408348UIInst_1', 'Team', 'Team', '', ' | Team | Team');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_128', 'Clas_1622453649408348UIPobCl_1', 'Teams', 'Teams', '', ' | Team | Teams');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_129', 'Clas_1622453649408348Ser_1UIServ_1', 'Create', 'Create', '', ' | Team | Create');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_130', 'Clas_1622453649408348Ser_2UIServ_1', 'Delete', 'Delete', '', ' | Team | Delete');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_131', 'Clas_1622453649408348Ser_3UIServ_1', 'Edit', 'Edit', '', ' | Team | Edit');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_132', 'Clas_1622453649408348Ser_4UIServ_1', 'addEmployeeToTeam', 'addEmployeeToTeam', '', ' | Team | addEmployeeToTeam');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_133', 'Clas_1622453649408348Ser_5UIServ_1', 'removeEmployeeFromTeam', 'removeEmployeeFromTeam', '', ' | Team | removeEmployeeFromTeam');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_134', null, 'Global Services', 'Global Services', '', ' | Global Services');
INSERT INTO MenuItem (idMenuItem, idIU, MenuItemName, MenuItemAlias, MenuItemDescription, MenuItemPath) VALUES ('Vis_1628594110464467_AutoNodoJer_135', 'IGl_1539588620288177UIServ_1', 'GLOBALTEST', 'GLOBALTEST', '', ' | Global Services | GLOBALTEST');
