package com.integranova.spring.expensereportdemo.global;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConstantsTest {

	@Test
	public void test4isBasicType() {
		assertTrue(Constants.Type.AUTONUMERIC.isBasicType());
		assertTrue(Constants.Type.BLOB.isBasicType());
		assertTrue(Constants.Type.BOOL.isBasicType());
		assertTrue(Constants.Type.DATE.isBasicType());
		assertTrue(Constants.Type.DATETIME.isBasicType());
		assertTrue(Constants.Type.INT.isBasicType());
		assertTrue(Constants.Type.NAT.isBasicType());
		assertTrue(Constants.Type.REAL.isBasicType());
		assertTrue(Constants.Type.STRING.isBasicType());
		assertTrue(Constants.Type.TEXT.isBasicType());
		assertTrue(Constants.Type.TIME.isBasicType());
	}
    
	@Test
	public void test4getTypeName() {
		assertEquals("Autonumeric", Constants.Type.AUTONUMERIC.getTypeName());
		assertEquals("Blob", Constants.Type.BLOB.getTypeName());
		assertEquals("Bool", Constants.Type.BOOL.getTypeName());
		assertEquals("Date", Constants.Type.DATE.getTypeName());
		assertEquals("DateTime", Constants.Type.DATETIME.getTypeName());
		assertEquals("Int", Constants.Type.INT.getTypeName());
		assertEquals("Nat", Constants.Type.NAT.getTypeName());
		assertEquals("Real", Constants.Type.REAL.getTypeName());
		assertEquals("String", Constants.Type.STRING.getTypeName());
		assertEquals("Text", Constants.Type.TEXT.getTypeName());
		assertEquals("Time", Constants.Type.TIME.getTypeName());
	}

	@Test
	public void test4getSQLType() {
		assertEquals(java.sql.Types.INTEGER, Constants.getSQLType("Autonumeric"));
		assertEquals(java.sql.Types.BLOB, Constants.getSQLType("Blob"));
		assertEquals(java.sql.Types.BOOLEAN, Constants.getSQLType("Bool"));
		assertEquals(java.sql.Types.DATE, Constants.getSQLType("Date"));
		assertEquals(java.sql.Types.TIMESTAMP, Constants.getSQLType("DateTime"));
		assertEquals(java.sql.Types.INTEGER, Constants.getSQLType("Int"));
		assertEquals(java.sql.Types.INTEGER, Constants.getSQLType("Nat"));
		assertEquals(java.sql.Types.REAL, Constants.getSQLType("Real"));
		assertEquals(java.sql.Types.VARCHAR, Constants.getSQLType("String"));
		assertEquals(java.sql.Types.CLOB, Constants.getSQLType("Text"));
		assertEquals(java.sql.Types.TIME, Constants.getSQLType("Time"));
        assertEquals(-1, Constants.getSQLType("DUMMY"));
	}

	@Test
	public void test4isClassType() {
		assertTrue(Constants.Type.EMPLOYEE.isClassType());
		assertTrue(Constants.Type.EXPENSELINE.isClassType());
		assertTrue(Constants.Type.EXPENSEREPORT.isClassType());
		assertTrue(Constants.Type.PAYMENTTYPE.isClassType());
		assertTrue(Constants.Type.PROJECT.isClassType());
		assertTrue(Constants.Type.EXPENSETYPE.isClassType());
		assertTrue(Constants.Type.EXPENSECURRENCY.isClassType());
		assertTrue(Constants.Type.ASSIGNMENT.isClassType());
		assertTrue(Constants.Type.APPUSER.isClassType());
		assertTrue(Constants.Type.ADMINUSER.isClassType());
		assertTrue(Constants.Type.OPERATORUSER.isClassType());
		assertTrue(Constants.Type.TEAM.isClassType());
		assertTrue(Constants.Type.ERTEMPLATE.isClassType());
		assertTrue(Constants.Type.ERLTEMPLATE.isClassType());
		assertTrue(Constants.Type.EXCHANGEHISTORY.isClassType());
		assertTrue(Constants.Type.SYSTEMPARAM.isClassType());
	}
    
	@Test
	public void test4getEntityClassName() {
         String packagePrefix = "com.integranova.spring.expensereportdemo.persistence.";
		assertEquals(packagePrefix + "Employee", Constants.Type.EMPLOYEE.getEntityClassName());
		assertEquals(packagePrefix + "ExpenseLine", Constants.Type.EXPENSELINE.getEntityClassName());
		assertEquals(packagePrefix + "ExpenseReport", Constants.Type.EXPENSEREPORT.getEntityClassName());
		assertEquals(packagePrefix + "PaymentType", Constants.Type.PAYMENTTYPE.getEntityClassName());
		assertEquals(packagePrefix + "Project", Constants.Type.PROJECT.getEntityClassName());
		assertEquals(packagePrefix + "ExpenseType", Constants.Type.EXPENSETYPE.getEntityClassName());
		assertEquals(packagePrefix + "ExpenseCurrency", Constants.Type.EXPENSECURRENCY.getEntityClassName());
		assertEquals(packagePrefix + "Assignment", Constants.Type.ASSIGNMENT.getEntityClassName());
		assertEquals(packagePrefix + "AppUser", Constants.Type.APPUSER.getEntityClassName());
		assertEquals(packagePrefix + "AdminUser", Constants.Type.ADMINUSER.getEntityClassName());
		assertEquals(packagePrefix + "OperatorUser", Constants.Type.OPERATORUSER.getEntityClassName());
		assertEquals(packagePrefix + "Team", Constants.Type.TEAM.getEntityClassName());
		assertEquals(packagePrefix + "ERTemplate", Constants.Type.ERTEMPLATE.getEntityClassName());
		assertEquals(packagePrefix + "ERLTemplate", Constants.Type.ERLTEMPLATE.getEntityClassName());
		assertEquals(packagePrefix + "ExchangeHistory", Constants.Type.EXCHANGEHISTORY.getEntityClassName());
		assertEquals(packagePrefix + "SystemParam", Constants.Type.SYSTEMPARAM.getEntityClassName());
	}
    
    @Test
    public void test4getClassName() {
        assertEquals("Employee", Constants.getClassName("EMPLOYEE"));
        assertEquals("ExpenseLine", Constants.getClassName("EXPENSELINE"));
        assertEquals("ExpenseReport", Constants.getClassName("EXPENSEREPORT"));
        assertEquals("PaymentType", Constants.getClassName("PAYMENTTYPE"));
        assertEquals("Project", Constants.getClassName("PROJECT"));
        assertEquals("ExpenseType", Constants.getClassName("EXPENSETYPE"));
        assertEquals("ExpenseCurrency", Constants.getClassName("EXPENSECURRENCY"));
        assertEquals("Assignment", Constants.getClassName("ASSIGNMENT"));
        assertEquals("AppUser", Constants.getClassName("APPUSER"));
        assertEquals("AdminUser", Constants.getClassName("ADMINUSER"));
        assertEquals("OperatorUser", Constants.getClassName("OPERATORUSER"));
        assertEquals("Team", Constants.getClassName("TEAM"));
        assertEquals("ERTemplate", Constants.getClassName("ERTEMPLATE"));
        assertEquals("ERLTemplate", Constants.getClassName("ERLTEMPLATE"));
        assertEquals("ExchangeHistory", Constants.getClassName("EXCHANGEHISTORY"));
        assertEquals("SystemParam", Constants.getClassName("SYSTEMPARAM"));
    }
    
    @Test
    public void test4getClassAlias() {
        assertEquals("Employee", Constants.getClassAlias("EMPLOYEE"));
        assertEquals("Expense Line", Constants.getClassAlias("EXPENSELINE"));
        assertEquals("Expense Report", Constants.getClassAlias("EXPENSEREPORT"));
        assertEquals("Payment Type", Constants.getClassAlias("PAYMENTTYPE"));
        assertEquals("Project", Constants.getClassAlias("PROJECT"));
        assertEquals("Expense Type", Constants.getClassAlias("EXPENSETYPE"));
        assertEquals("Expense Currency", Constants.getClassAlias("EXPENSECURRENCY"));
        assertEquals("Assignment", Constants.getClassAlias("ASSIGNMENT"));
        assertEquals("User", Constants.getClassAlias("APPUSER"));
        assertEquals("AdminUser", Constants.getClassAlias("ADMINUSER"));
        assertEquals("OperatorUser", Constants.getClassAlias("OPERATORUSER"));
        assertEquals("Team", Constants.getClassAlias("TEAM"));
        assertEquals("Expense Report Template", Constants.getClassAlias("ERTEMPLATE"));
        assertEquals("Expense Report Line Template", Constants.getClassAlias("ERLTEMPLATE"));
        assertEquals("Exchange History", Constants.getClassAlias("EXCHANGEHISTORY"));
        assertEquals("System Parameter", Constants.getClassAlias("SYSTEMPARAM"));
    }

    @Test
    public void test4getServiceName4Employee() {
        assertEquals("createinstance", Constants.getServiceName("EMPLOYEE", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("EMPLOYEE", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("EMPLOYEE", "EDITINSTANCE"));
        assertEquals("changePicture", Constants.getServiceName("EMPLOYEE", "CHANGEPICTURE"));
        assertEquals("addEmployeeToTeam", Constants.getServiceName("EMPLOYEE", "ADDEMPLOYEETOTEAM"));
        assertEquals("removeEmployeeFromTeam", Constants.getServiceName("EMPLOYEE", "REMOVEEMPLOYEEFROMTEAM"));
        assertEquals("TDELETE", Constants.getServiceName("EMPLOYEE", "TDELETE"));
    }

    @Test
    public void test4getServiceAlias4Employee() {
        assertEquals("Create", Constants.getServiceAlias("EMPLOYEE", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("EMPLOYEE", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("EMPLOYEE", "EDITINSTANCE"));
        assertEquals("Change Picture", Constants.getServiceAlias("EMPLOYEE", "CHANGEPICTURE"));
        assertEquals("addEmployeeToTeam", Constants.getServiceAlias("EMPLOYEE", "ADDEMPLOYEETOTEAM"));
        assertEquals("removeEmployeeFromTeam", Constants.getServiceAlias("EMPLOYEE", "REMOVEEMPLOYEEFROMTEAM"));
        assertEquals("Delete", Constants.getServiceAlias("EMPLOYEE", "TDELETE"));
    }
    
    @Test
    public void test4getFilterName4Employee() {
        assertEquals("F_EmployeeName", Constants.getFilterName("EMPLOYEE", "FEMPLOYEENAME"));
    }

    @Test
    public void test4getServiceName4ExpenseLine() {
        assertEquals("newline", Constants.getServiceName("EXPENSELINE", "NEWLINE"));
        assertEquals("deleteline", Constants.getServiceName("EXPENSELINE", "DELETELINE"));
        assertEquals("editinstance", Constants.getServiceName("EXPENSELINE", "EDITINSTANCE"));
        assertEquals("deletepaidline", Constants.getServiceName("EXPENSELINE", "DELETEPAIDLINE"));
    }

    @Test
    public void test4getServiceAlias4ExpenseLine() {
        assertEquals("Create a New Line", Constants.getServiceAlias("EXPENSELINE", "NEWLINE"));
        assertEquals("Delete Line", Constants.getServiceAlias("EXPENSELINE", "DELETELINE"));
        assertEquals("Edit a Line", Constants.getServiceAlias("EXPENSELINE", "EDITINSTANCE"));
        assertEquals("delete_paidline", Constants.getServiceAlias("EXPENSELINE", "DELETEPAIDLINE"));
    }

    @Test
    public void test4getServiceName4ExpenseReport() {
        assertEquals("newexpense", Constants.getServiceName("EXPENSEREPORT", "NEWEXPENSE"));
        assertEquals("delexpense", Constants.getServiceName("EXPENSEREPORT", "DELEXPENSE"));
        assertEquals("eclose", Constants.getServiceName("EXPENSEREPORT", "ECLOSE"));
        assertEquals("authorize", Constants.getServiceName("EXPENSEREPORT", "AUTHORIZE"));
        assertEquals("pay", Constants.getServiceName("EXPENSEREPORT", "PAY"));
        assertEquals("rejectautho", Constants.getServiceName("EXPENSEREPORT", "REJECTAUTHO"));
        assertEquals("rejectpayment", Constants.getServiceName("EXPENSEREPORT", "REJECTPAYMENT"));
        assertEquals("InsPaymentType", Constants.getServiceName("EXPENSEREPORT", "INSPAYMENTTYPE"));
        assertEquals("DelPaymentType", Constants.getServiceName("EXPENSEREPORT", "DELPAYMENTTYPE"));
        assertEquals("cancelapprove", Constants.getServiceName("EXPENSEREPORT", "CANCELAPPROVE"));
        assertEquals("approve", Constants.getServiceName("EXPENSEREPORT", "APPROVE"));
        assertEquals("editinstance", Constants.getServiceName("EXPENSEREPORT", "EDITINSTANCE"));
        assertEquals("dummy", Constants.getServiceName("EXPENSEREPORT", "DUMMY"));
        assertEquals("DELETEALL", Constants.getServiceName("EXPENSEREPORT", "DELETEALL"));
        assertEquals("TPAY", Constants.getServiceName("EXPENSEREPORT", "TPAY"));
        assertEquals("TNEW", Constants.getServiceName("EXPENSEREPORT", "TNEW"));
        assertEquals("TREJECTPAYMENT", Constants.getServiceName("EXPENSEREPORT", "TREJECTPAYMENT"));
        assertEquals("TNEWFROMTEMPLATE", Constants.getServiceName("EXPENSEREPORT", "TNEWFROMTEMPLATE"));
    }

    @Test
    public void test4getServiceAlias4ExpenseReport() {
        assertEquals("Create a Expense Report", Constants.getServiceAlias("EXPENSEREPORT", "NEWEXPENSE"));
        assertEquals("Delete a expense report", Constants.getServiceAlias("EXPENSEREPORT", "DELEXPENSE"));
        assertEquals("Close a Expense Report", Constants.getServiceAlias("EXPENSEREPORT", "ECLOSE"));
        assertEquals("Mark as Authorized", Constants.getServiceAlias("EXPENSEREPORT", "AUTHORIZE"));
        assertEquals("pay", Constants.getServiceAlias("EXPENSEREPORT", "PAY"));
        assertEquals("Reject Auhorization", Constants.getServiceAlias("EXPENSEREPORT", "REJECTAUTHO"));
        assertEquals("Reject Payment", Constants.getServiceAlias("EXPENSEREPORT", "REJECTPAYMENT"));
        assertEquals("InsPaymentType", Constants.getServiceAlias("EXPENSEREPORT", "INSPAYMENTTYPE"));
        assertEquals("DelPaymentType", Constants.getServiceAlias("EXPENSEREPORT", "DELPAYMENTTYPE"));
        assertEquals("Cancel Approval", Constants.getServiceAlias("EXPENSEREPORT", "CANCELAPPROVE"));
        assertEquals("Mark as Approved", Constants.getServiceAlias("EXPENSEREPORT", "APPROVE"));
        assertEquals("edit_instance", Constants.getServiceAlias("EXPENSEREPORT", "EDITINSTANCE"));
        assertEquals("dummy", Constants.getServiceAlias("EXPENSEREPORT", "DUMMY"));
        assertEquals("Delete an Expense Report", Constants.getServiceAlias("EXPENSEREPORT", "DELETEALL"));
        assertEquals("Mark as Paid", Constants.getServiceAlias("EXPENSEREPORT", "TPAY"));
        assertEquals("New Expense Report", Constants.getServiceAlias("EXPENSEREPORT", "TNEW"));
        assertEquals("Reject Payment", Constants.getServiceAlias("EXPENSEREPORT", "TREJECTPAYMENT"));
        assertEquals("New Expense Report from Template", Constants.getServiceAlias("EXPENSEREPORT", "TNEWFROMTEMPLATE"));
    }
    
    @Test
    public void test4getFilterName4ExpenseReport() {
        assertEquals("F_ExpenseReportAmount", Constants.getFilterName("EXPENSEREPORT", "FEXPENSEREPORTAMOUNT"));
        assertEquals("F_ExpenseReportDates", Constants.getFilterName("EXPENSEREPORT", "FEXPENSEREPORTDATES"));
        assertEquals("F_ExpenseReportStatus", Constants.getFilterName("EXPENSEREPORT", "FEXPENSEREPORTSTATUS"));
        assertEquals("F_ByProject", Constants.getFilterName("EXPENSEREPORT", "FBYPROJECT"));
        assertEquals("F_ByID", Constants.getFilterName("EXPENSEREPORT", "FBYID"));
    }

    @Test
    public void test4getServiceName4PaymentType() {
        assertEquals("createinstance", Constants.getServiceName("PAYMENTTYPE", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("PAYMENTTYPE", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("PAYMENTTYPE", "EDITINSTANCE"));
        assertEquals("InsPaymentType", Constants.getServiceName("PAYMENTTYPE", "INSPAYMENTTYPE"));
        assertEquals("DelPaymentType", Constants.getServiceName("PAYMENTTYPE", "DELPAYMENTTYPE"));
    }

    @Test
    public void test4getServiceAlias4PaymentType() {
        assertEquals("Create", Constants.getServiceAlias("PAYMENTTYPE", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("PAYMENTTYPE", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("PAYMENTTYPE", "EDITINSTANCE"));
        assertEquals("InsPaymentType", Constants.getServiceAlias("PAYMENTTYPE", "INSPAYMENTTYPE"));
        assertEquals("DelPaymentType", Constants.getServiceAlias("PAYMENTTYPE", "DELPAYMENTTYPE"));
    }

    @Test
    public void test4getServiceName4Project() {
        assertEquals("createinstance", Constants.getServiceName("PROJECT", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("PROJECT", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("PROJECT", "EDITINSTANCE"));
        assertEquals("markAsCompleted", Constants.getServiceName("PROJECT", "MARKASCOMPLETED"));
        assertEquals("assignTemplateToProject", Constants.getServiceName("PROJECT", "ASSIGNTEMPLATETOPROJECT"));
        assertEquals("deassignTemplate", Constants.getServiceName("PROJECT", "DEASSIGNTEMPLATE"));
        assertEquals("TCOMPLETE", Constants.getServiceName("PROJECT", "TCOMPLETE"));
    }

    @Test
    public void test4getServiceAlias4Project() {
        assertEquals("Create", Constants.getServiceAlias("PROJECT", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("PROJECT", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("PROJECT", "EDITINSTANCE"));
        assertEquals("Mark as completed", Constants.getServiceAlias("PROJECT", "MARKASCOMPLETED"));
        assertEquals("Assign Template", Constants.getServiceAlias("PROJECT", "ASSIGNTEMPLATETOPROJECT"));
        assertEquals("Deassign Template", Constants.getServiceAlias("PROJECT", "DEASSIGNTEMPLATE"));
        assertEquals("Complete", Constants.getServiceAlias("PROJECT", "TCOMPLETE"));
    }
    
    @Test
    public void test4getFilterName4Project() {
        assertEquals("FProjects", Constants.getFilterName("PROJECT", "FPROJECTS"));
    }

    @Test
    public void test4getServiceName4ExpenseType() {
        assertEquals("createinstance", Constants.getServiceName("EXPENSETYPE", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("EXPENSETYPE", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("EXPENSETYPE", "EDITINSTANCE"));
    }

    @Test
    public void test4getServiceAlias4ExpenseType() {
        assertEquals("Create", Constants.getServiceAlias("EXPENSETYPE", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("EXPENSETYPE", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("EXPENSETYPE", "EDITINSTANCE"));
    }

    @Test
    public void test4getServiceName4ExpenseCurrency() {
        assertEquals("createinstance", Constants.getServiceName("EXPENSECURRENCY", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("EXPENSECURRENCY", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("EXPENSECURRENCY", "EDITINSTANCE"));
        assertEquals("resetExchange", Constants.getServiceName("EXPENSECURRENCY", "RESETEXCHANGE"));
        assertEquals("editExchange", Constants.getServiceName("EXPENSECURRENCY", "EDITEXCHANGE"));
        assertEquals("TNEW", Constants.getServiceName("EXPENSECURRENCY", "TNEW"));
        assertEquals("TEDITEXCHANGE", Constants.getServiceName("EXPENSECURRENCY", "TEDITEXCHANGE"));
    }

    @Test
    public void test4getServiceAlias4ExpenseCurrency() {
        assertEquals("Create", Constants.getServiceAlias("EXPENSECURRENCY", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("EXPENSECURRENCY", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("EXPENSECURRENCY", "EDITINSTANCE"));
        assertEquals("Reset exchange", Constants.getServiceAlias("EXPENSECURRENCY", "RESETEXCHANGE"));
        assertEquals("Update exchange", Constants.getServiceAlias("EXPENSECURRENCY", "EDITEXCHANGE"));
        assertEquals("Create", Constants.getServiceAlias("EXPENSECURRENCY", "TNEW"));
        assertEquals("Update exchange", Constants.getServiceAlias("EXPENSECURRENCY", "TEDITEXCHANGE"));
    }

    @Test
    public void test4getServiceName4Assignment() {
        assertEquals("newAssignment", Constants.getServiceName("ASSIGNMENT", "NEWASSIGNMENT"));
        assertEquals("deleteAssignment", Constants.getServiceName("ASSIGNMENT", "DELETEASSIGNMENT"));
        assertEquals("editAssignment", Constants.getServiceName("ASSIGNMENT", "EDITASSIGNMENT"));
        assertEquals("terminateAssignment", Constants.getServiceName("ASSIGNMENT", "TERMINATEASSIGNMENT"));
    }

    @Test
    public void test4getServiceAlias4Assignment() {
        assertEquals("Create", Constants.getServiceAlias("ASSIGNMENT", "NEWASSIGNMENT"));
        assertEquals("Delete", Constants.getServiceAlias("ASSIGNMENT", "DELETEASSIGNMENT"));
        assertEquals("Edit", Constants.getServiceAlias("ASSIGNMENT", "EDITASSIGNMENT"));
        assertEquals("Terminate", Constants.getServiceAlias("ASSIGNMENT", "TERMINATEASSIGNMENT"));
    }
    
    @Test
    public void test4getFilterName4Assignment() {
        assertEquals("F_Assignments", Constants.getFilterName("ASSIGNMENT", "FASSIGNMENTS"));
    }

    @Test
    public void test4getServiceName4AppUser() {
        assertEquals("newUser", Constants.getServiceName("APPUSER", "NEWUSER"));
        assertEquals("deleteUser", Constants.getServiceName("APPUSER", "DELETEUSER"));
        assertEquals("editUser", Constants.getServiceName("APPUSER", "EDITUSER"));
        assertEquals("makeAdmin", Constants.getServiceName("APPUSER", "MAKEADMIN"));
        assertEquals("makeOperator", Constants.getServiceName("APPUSER", "MAKEOPERATOR"));
        assertEquals("changeUserType", Constants.getServiceName("APPUSER", "CHANGEUSERTYPE"));
        assertEquals("cancelAdmin", Constants.getServiceName("APPUSER", "CANCELADMIN"));
        assertEquals("cancelOperator", Constants.getServiceName("APPUSER", "CANCELOPERATOR"));
        assertEquals("TNEWUSER", Constants.getServiceName("APPUSER", "TNEWUSER"));
        assertEquals("TEDITUSER", Constants.getServiceName("APPUSER", "TEDITUSER"));
        assertEquals("TDELETE", Constants.getServiceName("APPUSER", "TDELETE"));
    }

    @Test
    public void test4getServiceAlias4AppUser() {
        assertEquals("New User", Constants.getServiceAlias("APPUSER", "NEWUSER"));
        assertEquals("Delete User", Constants.getServiceAlias("APPUSER", "DELETEUSER"));
        assertEquals("editUser", Constants.getServiceAlias("APPUSER", "EDITUSER"));
        assertEquals("makeAdmin", Constants.getServiceAlias("APPUSER", "MAKEADMIN"));
        assertEquals("makeOperator", Constants.getServiceAlias("APPUSER", "MAKEOPERATOR"));
        assertEquals("changeUserType", Constants.getServiceAlias("APPUSER", "CHANGEUSERTYPE"));
        assertEquals("cancelAdmin", Constants.getServiceAlias("APPUSER", "CANCELADMIN"));
        assertEquals("cancelOperator", Constants.getServiceAlias("APPUSER", "CANCELOPERATOR"));
        assertEquals("New User", Constants.getServiceAlias("APPUSER", "TNEWUSER"));
        assertEquals("Edit User", Constants.getServiceAlias("APPUSER", "TEDITUSER"));
        assertEquals("Delete User", Constants.getServiceAlias("APPUSER", "TDELETE"));
    }
    
    @Test
    public void test4getFilterName4AppUser() {
        assertEquals("F_AppUsers", Constants.getFilterName("APPUSER", "FAPPUSERS"));
    }

    @Test
    public void test4getServiceName4AdminUser() {
    }

    @Test
    public void test4getServiceAlias4AdminUser() {
    }

    @Test
    public void test4getServiceName4OperatorUser() {
    }

    @Test
    public void test4getServiceAlias4OperatorUser() {
    }

    @Test
    public void test4getServiceName4Team() {
        assertEquals("createinstance", Constants.getServiceName("TEAM", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("TEAM", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("TEAM", "EDITINSTANCE"));
        assertEquals("addEmployeeToTeam", Constants.getServiceName("TEAM", "ADDEMPLOYEETOTEAM"));
        assertEquals("removeEmployeeFromTeam", Constants.getServiceName("TEAM", "REMOVEEMPLOYEEFROMTEAM"));
        assertEquals("validate", Constants.getServiceName("TEAM", "VALIDATE"));
    }

    @Test
    public void test4getServiceAlias4Team() {
        assertEquals("Create", Constants.getServiceAlias("TEAM", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("TEAM", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("TEAM", "EDITINSTANCE"));
        assertEquals("addEmployeeToTeam", Constants.getServiceAlias("TEAM", "ADDEMPLOYEETOTEAM"));
        assertEquals("removeEmployeeFromTeam", Constants.getServiceAlias("TEAM", "REMOVEEMPLOYEEFROMTEAM"));
        assertEquals("validate", Constants.getServiceAlias("TEAM", "VALIDATE"));
    }
    
    @Test
    public void test4getFilterName4Team() {
        assertEquals("FTeamsByName", Constants.getFilterName("TEAM", "FTEAMSBYNAME"));
        assertEquals("FTeamsWithCapacity", Constants.getFilterName("TEAM", "FTEAMSWITHCAPACITY"));
    }

    @Test
    public void test4getServiceName4ERTemplate() {
        assertEquals("createinstance", Constants.getServiceName("ERTEMPLATE", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("ERTEMPLATE", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("ERTEMPLATE", "EDITINSTANCE"));
        assertEquals("editName", Constants.getServiceName("ERTEMPLATE", "EDITNAME"));
        assertEquals("editDescription", Constants.getServiceName("ERTEMPLATE", "EDITDESCRIPTION"));
        assertEquals("clearName", Constants.getServiceName("ERTEMPLATE", "CLEARNAME"));
        assertEquals("clearDescription", Constants.getServiceName("ERTEMPLATE", "CLEARDESCRIPTION"));
        assertEquals("enable", Constants.getServiceName("ERTEMPLATE", "ENABLE"));
        assertEquals("disable", Constants.getServiceName("ERTEMPLATE", "DISABLE"));
        assertEquals("assignTemplateToProject", Constants.getServiceName("ERTEMPLATE", "ASSIGNTEMPLATETOPROJECT"));
        assertEquals("deassignTemplate", Constants.getServiceName("ERTEMPLATE", "DEASSIGNTEMPLATE"));
    }

    @Test
    public void test4getServiceAlias4ERTemplate() {
        assertEquals("Create", Constants.getServiceAlias("ERTEMPLATE", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("ERTEMPLATE", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("ERTEMPLATE", "EDITINSTANCE"));
        assertEquals("editName", Constants.getServiceAlias("ERTEMPLATE", "EDITNAME"));
        assertEquals("editDescription", Constants.getServiceAlias("ERTEMPLATE", "EDITDESCRIPTION"));
        assertEquals("clearName", Constants.getServiceAlias("ERTEMPLATE", "CLEARNAME"));
        assertEquals("clearDescription", Constants.getServiceAlias("ERTEMPLATE", "CLEARDESCRIPTION"));
        assertEquals("Activate", Constants.getServiceAlias("ERTEMPLATE", "ENABLE"));
        assertEquals("Activate", Constants.getServiceAlias("ERTEMPLATE", "DISABLE"));
        assertEquals("assignTemplateToProject", Constants.getServiceAlias("ERTEMPLATE", "ASSIGNTEMPLATETOPROJECT"));
        assertEquals("deassignTemplate", Constants.getServiceAlias("ERTEMPLATE", "DEASSIGNTEMPLATE"));
    }
    
    @Test
    public void test4getFilterName4ERTemplate() {
        assertEquals("FERTemplates", Constants.getFilterName("ERTEMPLATE", "FERTEMPLATES"));
    }

    @Test
    public void test4getServiceName4ERLTemplate() {
        assertEquals("createinstance", Constants.getServiceName("ERLTEMPLATE", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("ERLTEMPLATE", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("ERLTEMPLATE", "EDITINSTANCE"));
        assertEquals("editUnits", Constants.getServiceName("ERLTEMPLATE", "EDITUNITS"));
        assertEquals("editPrice", Constants.getServiceName("ERLTEMPLATE", "EDITPRICE"));
        assertEquals("editDescription", Constants.getServiceName("ERLTEMPLATE", "EDITDESCRIPTION"));
        assertEquals("clearUnits", Constants.getServiceName("ERLTEMPLATE", "CLEARUNITS"));
        assertEquals("clearPrice", Constants.getServiceName("ERLTEMPLATE", "CLEARPRICE"));
        assertEquals("clearDescription", Constants.getServiceName("ERLTEMPLATE", "CLEARDESCRIPTION"));
    }

    @Test
    public void test4getServiceAlias4ERLTemplate() {
        assertEquals("Create", Constants.getServiceAlias("ERLTEMPLATE", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("ERLTEMPLATE", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("ERLTEMPLATE", "EDITINSTANCE"));
        assertEquals("editUnits", Constants.getServiceAlias("ERLTEMPLATE", "EDITUNITS"));
        assertEquals("editPrice", Constants.getServiceAlias("ERLTEMPLATE", "EDITPRICE"));
        assertEquals("editDescription", Constants.getServiceAlias("ERLTEMPLATE", "EDITDESCRIPTION"));
        assertEquals("clearUnits", Constants.getServiceAlias("ERLTEMPLATE", "CLEARUNITS"));
        assertEquals("clearPrice", Constants.getServiceAlias("ERLTEMPLATE", "CLEARPRICE"));
        assertEquals("clearDescription", Constants.getServiceAlias("ERLTEMPLATE", "CLEARDESCRIPTION"));
    }

    @Test
    public void test4getServiceName4ExchangeHistory() {
        assertEquals("createinstance", Constants.getServiceName("EXCHANGEHISTORY", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("EXCHANGEHISTORY", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("EXCHANGEHISTORY", "EDITINSTANCE"));
    }

    @Test
    public void test4getServiceAlias4ExchangeHistory() {
        assertEquals("Create", Constants.getServiceAlias("EXCHANGEHISTORY", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("EXCHANGEHISTORY", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("EXCHANGEHISTORY", "EDITINSTANCE"));
    }

    @Test
    public void test4getServiceName4SystemParam() {
        assertEquals("createinstance", Constants.getServiceName("SYSTEMPARAM", "CREATEINSTANCE"));
        assertEquals("deleteinstance", Constants.getServiceName("SYSTEMPARAM", "DELETEINSTANCE"));
        assertEquals("editinstance", Constants.getServiceName("SYSTEMPARAM", "EDITINSTANCE"));
    }

    @Test
    public void test4getServiceAlias4SystemParam() {
        assertEquals("Create", Constants.getServiceAlias("SYSTEMPARAM", "CREATEINSTANCE"));
        assertEquals("Delete", Constants.getServiceAlias("SYSTEMPARAM", "DELETEINSTANCE"));
        assertEquals("Edit", Constants.getServiceAlias("SYSTEMPARAM", "EDITINSTANCE"));
    }
}

