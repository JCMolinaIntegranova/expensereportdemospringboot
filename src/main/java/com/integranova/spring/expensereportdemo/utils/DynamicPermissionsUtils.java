package com.integranova.spring.expensereportdemo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Sets;
import com.integranova.spring.expensereportdemo.viewmodel.VisibleIUPermissions;

public class DynamicPermissionsUtils {

    private static final String ADMINUSER_ROLE = "AdminUser";
    private static final String OPERATORUSER_ROLE = "OperatorUser";
    private static final String APPUSER_ROLE = "AppUser";

    private String userId;

    List<String> userRoles;
    
    List<String> visibleHATNodes;

    List<VisibleIUPermissions> visibleIUs;
    
    public DynamicPermissionsUtils(String userId, String userRoles) {
        this.userId = userId;
        this.userRoles = Arrays.asList(userRoles.split(","));
        this.visibleHATNodes = new ArrayList<>();
        this.visibleIUs = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getVisibleHATNodesForUser() {
        getDefaultVisibleHATNodesForUser();
        return visibleHATNodes;
    }
    
    private void getDefaultVisibleHATNodesForUser() {
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_1", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_2", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_3", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_6", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_7", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_8", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_9", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_10", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_13", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_14", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_15", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_16", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_17", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_18", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_19", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_20", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_21", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_22", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_23", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_24", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_25", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_26", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_27", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_28", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_29", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_30", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_31", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_32", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_33", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_34", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_35", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_36", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_37", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_38", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_39", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_40", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_41", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_42", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_43", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_44", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_45", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_46", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_47", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_48", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_49", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_50", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_51", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_52", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_53", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_54", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_55", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_56", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_57", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_58", Arrays.asList());
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_59", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_60", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_61", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_62", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_63", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_64", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_65", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_66", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_67", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_68", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_69", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_70", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_71", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_72", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_73", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_74", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_75", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_76", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_77", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_78", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_79", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_80", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_81", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_82", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_83", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_84", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_85", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_86", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_87", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_88", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_89", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_90", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_91", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_92", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_93", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_94", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_95", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_96", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_97", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_98", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_99", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_100", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_101", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_102", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_103", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_104", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_105", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_106", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_107", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_108", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_109", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_110", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_111", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_112", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_113", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_114", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_115", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_116", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_117", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_118", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_119", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_120", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_121", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_122", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_123", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_124", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_125", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_126", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_127", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_128", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_129", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_130", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_131", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_132", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_133", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_134", Arrays.asList(ADMINUSER_ROLE));
        addHATNodeForRoles("Vis_1628594110464467_AutoNodoJer_135", Arrays.asList(ADMINUSER_ROLE));
    }
    
    private void addHATNodeForRoles(String nodeId, List<String> nodeRoles) {
        if (modelElementRolesIncludeAnyUserRole(nodeRoles))
            visibleHATNodes.add(nodeId);
    }
    
    public List<VisibleIUPermissions> getVisibleIUsForUser() {
        return getDefaultVisibleIUsForUser();
    }

    private List<VisibleIUPermissions> getDefaultVisibleIUsForUser() {
        visibleIUs = new ArrayList<>();
        addVisibleGlobalSIUs();
        addVisibleClassIUs();
        return visibleIUs;
    }

    private void addVisibleGlobalSIUs() {
        addVisibleIUPermissions4GlobalService("IGl_1539588620288177UIServ_1", Arrays.asList(ADMINUSER_ROLE));
    }
    
    private void addVisibleIUPermissions4GlobalService(String globalServiceId, List<String> nodeRoles) {
        if (modelElementRolesIncludeAnyUserRole(nodeRoles))
            visibleIUs.add(new VisibleIUPermissions(globalServiceId));
    }

    private void addVisibleClassIUs() {
        addVisibleClassIUsOfEmployee();
        addVisibleClassIUsOfExpenseLine();
        addVisibleClassIUsOfExpenseReport();
        addVisibleClassIUsOfPaymentType();
        addVisibleClassIUsOfProject();
        addVisibleClassIUsOfExpenseType();
        addVisibleClassIUsOfExpenseCurrency();
        addVisibleClassIUsOfAssignment();
        addVisibleClassIUsOfAppUser();
        addVisibleClassIUsOfTeam();
        addVisibleClassIUsOfERTemplate();
        addVisibleClassIUsOfERLTemplate();
        addVisibleClassIUsOfExchangeHistory();
        addVisibleClassIUsOfSystemParam();
    }

    private void addVisibleClassIUsOfEmployee() {
        // PIUEmployee
        addPIUClas1057569177600607UIPobCl1();
        // IIUEmployee
        addIIUClas1057569177600607UIInst1();
        // IIUEmployeeReports
        addIIUClas1057569177600607UIInst2();
        // MDIUEmployeeExpenses
        addMDIUClas1057569177600607UIMaDet1();
        // SIUcreateinstance
        addSIUClas1057569177600607Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1057569177600607Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600607Ser3UIServ1();
        // SIUchangePicture
        addSIUClas1057569177600607Ser4UIServ1();
        // SIUaddEmployeeToTeam
        addSIUClas1057569177600607Ser7UIServ1();
        // SIUremoveEmployeeFromTeam
        addSIUClas1057569177600607Ser8UIServ1();
        // SIUTDELETE
        addSIUClas1057569177600607Ser9UIServ1();
    }

    private void addVisibleClassIUsOfExpenseLine() {
        // PIUExpenseLine
        addPIUClas1057569177600646UIPobCl1();
        // PIUExpenseLineToReports
        addPIUClas1057569177600646UIPobCl2();
        // IIUExpenseLine
        addIIUClas1057569177600646UIInst1();
        // SIUnewline
        addSIUClas1057569177600646Ser1UIServ1();
        // SIUdeleteline
        addSIUClas1057569177600646Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600646Ser3UIServ1();
    }

    private void addVisibleClassIUsOfExpenseReport() {
        // PIUExpenseReport
        addPIUClas1057569177600553UIPobCl1();
        // PIUExpenseReportToEmployee
        addPIUClas1057569177600553UIPobCl2();
        // PIUExpenseReportProject
        addPIUClas1057569177600553UIPobCl4();
        // IIUExpenseReport
        addIIUClas1057569177600553UIInst1();
        // MDIUExpenseReportLines
        addMDIUClas1057569177600553UIMaDet1();
        // SIUeclose
        addSIUClas1057569177600553Ser3UIServ1();
        // SIUauthorize
        addSIUClas1057569177600553Ser4UIServ1();
        // SIUrejectautho
        addSIUClas1057569177600553Ser6UIServ1();
        // SIUcancelapprove
        addSIUClas1057569177600553Ser10UIServ1();
        // SIUapprove
        addSIUClas1057569177600553Ser11UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600553Ser12UIServ1();
        // SIUDELETEALL
        addSIUClas1057569177600553Ser13UIServ1();
        // SIUTPAY
        addSIUClas1057569177600553Ser14UIServ1();
        // SIUTNEW
        addSIUClas1057569177600553Ser15UIServ1();
        // SIUTREJECTPAYMENT
        addSIUClas1057569177600553Ser16UIServ1();
        // SIUTNEWFROMTEMPLATE
        addSIUClas1057569177600553Ser20UIServ1();
    }

    private void addVisibleClassIUsOfPaymentType() {
        // PIUPaymentType
        addPIUClas1057569177600423UIPobCl1();
        // IIUPaymentType
        addIIUClas1057569177600423UIInst1();
        // SIUcreateinstance
        addSIUClas1057569177600423Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1057569177600423Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600423Ser3UIServ1();
        // SIUInsPaymentType
        addSIUClas1057569177600423Ser4UIServ1();
    }

    private void addVisibleClassIUsOfProject() {
        // PIUProject
        addPIUClas1057569177600719UIPobCl1();
        // SELProject
        addPIUClas1057569177600719UIPobCl2();
        // IIUProject
        addIIUClas1057569177600719UIInst1();
        // IIUProjectReports
        addIIUClas1057569177600719UIInst2();
        // MDIUProjectExpenses
        addMDIUClas1057569177600719UIMaDet1();
        // SIUcreateinstance
        addSIUClas1057569177600719Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1057569177600719Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600719Ser3UIServ1();
        // SIUassignTemplateToProject
        addSIUClas1057569177600719Ser6UIServ1();
        // SIUdeassignTemplate
        addSIUClas1057569177600719Ser7UIServ1();
        // SIUTCOMPLETE
        addSIUClas1057569177600719Ser5UIServ1();
    }

    private void addVisibleClassIUsOfExpenseType() {
        // PIUExpenseType
        addPIUClas1057569177600995UIPobCl1();
        // IIUExpenseType
        addIIUClas1057569177600995UIInst1();
        // SIUcreateinstance
        addSIUClas1057569177600995Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1057569177600995Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600995Ser3UIServ1();
    }

    private void addVisibleClassIUsOfExpenseCurrency() {
        // PIUExpenseCurrency
        addPIUClas1057569177600792UIPobCl1();
        // IIUExpenseCurrency
        addIIUClas1057569177600792UIInst1();
        // SIUcreateinstance
        addSIUClas1057569177600792Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1057569177600792Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1057569177600792Ser3UIServ1();
        // SIUresetExchange
        addSIUClas1057569177600792Ser5UIServ1();
        // SIUeditExchange
        addSIUClas1057569177600792Ser6UIServ1();
        // SIUTNEW
        addSIUClas1057569177600792Ser7UIServ1();
        // SIUTEDITEXCHANGE
        addSIUClas1057569177600792Ser8UIServ1();
    }

    private void addVisibleClassIUsOfAssignment() {
        // PIUAssignments
        addPIUClas1468338274304118UIPobCl1();
        // IIUAssignment
        addIIUClas1468338274304118UIInst1();
        // SIUnewAssignment
        addSIUClas1468338274304118Ser1UIServ1();
        // SIUdeleteAssignment
        addSIUClas1468338274304118Ser2UIServ1();
        // SIUeditAssignment
        addSIUClas1468338274304118Ser3UIServ1();
        // SIUterminateAssignment
        addSIUClas1468338274304118Ser5UIServ1();
    }

    private void addVisibleClassIUsOfAppUser() {
        // PIUAppUsers
        addPIUClas1468421898240231UIPobCl1();
        // SIUnewUser
        addSIUClas1468421898240231Ser2UIServ1();
        // SIUdeleteUser
        addSIUClas1468421898240231Ser3UIServ1();
        // SIUeditUser
        addSIUClas1468421898240231Ser4UIServ1();
        // SIUsetPassword
        addSIUClas1468421898240231Ser5UIServ1();
        // SIUTNEWUSER
        addSIUClas1468421898240231Ser9UIServ1();
        // SIUTEDITUSER
        addSIUClas1468421898240231Ser10UIServ1();
        // SIUTDELETE
        addSIUClas1468421898240231Ser13UIServ1();
    }

    private void addVisibleClassIUsOfTeam() {
        // PIUTeams
        addPIUClas1622453649408348UIPobCl1();
        // IIUTeam
        addIIUClas1622453649408348UIInst1();
        // SIUcreateinstance
        addSIUClas1622453649408348Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1622453649408348Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1622453649408348Ser3UIServ1();
        // SIUaddEmployeeToTeam
        addSIUClas1622453649408348Ser4UIServ1();
        // SIUremoveEmployeeFromTeam
        addSIUClas1622453649408348Ser5UIServ1();
    }

    private void addVisibleClassIUsOfERTemplate() {
        // PIUERTemplates
        addPIUClas1622460465152786UIPobCl1();
        // MDIUERTemplates
        addMDIUClas1622460465152786UIMaDet1();
        // SIUcreateinstance
        addSIUClas1622460465152786Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1622460465152786Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1622460465152786Ser3UIServ1();
        // SIUeditName
        addSIUClas1622460465152786Ser4UIServ1();
        // SIUeditDescription
        addSIUClas1622460465152786Ser5UIServ1();
        // SIUclearName
        addSIUClas1622460465152786Ser6UIServ1();
        // SIUclearDescription
        addSIUClas1622460465152786Ser7UIServ1();
        // SIUenable
        addSIUClas1622460465152786Ser8UIServ1();
        // SIUdisable
        addSIUClas1622460465152786Ser9UIServ1();
        // SIUassignTemplateToProject
        addSIUClas1622460465152786Ser10UIServ1();
        // SIUdeassignTemplate
        addSIUClas1622460465152786Ser11UIServ1();
    }

    private void addVisibleClassIUsOfERLTemplate() {
        // PIUTemplateLines
        addPIUClas1622460596224994UIPobCl1();
        // SIUcreateinstance
        addSIUClas1622460596224994Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1622460596224994Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1622460596224994Ser3UIServ1();
        // SIUeditUnits
        addSIUClas1622460596224994Ser4UIServ1();
        // SIUeditPrice
        addSIUClas1622460596224994Ser5UIServ1();
        // SIUeditDescription
        addSIUClas1622460596224994Ser6UIServ1();
        // SIUclearUnits
        addSIUClas1622460596224994Ser7UIServ1();
        // SIUclearPrice
        addSIUClas1622460596224994Ser8UIServ1();
        // SIUclearDescription
        addSIUClas1622460596224994Ser9UIServ1();
    }

    private void addVisibleClassIUsOfExchangeHistory() {
        // SIUcreateinstance
        addSIUClas1622465314816112Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1622465314816112Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1622465314816112Ser3UIServ1();
    }

    private void addVisibleClassIUsOfSystemParam() {
        // PIUSystemParams
        addPIUClas1622477111296378UIPobCl1();
        // SIUcreateinstance
        addSIUClas1622477111296378Ser1UIServ1();
        // SIUdeleteinstance
        addSIUClas1622477111296378Ser2UIServ1();
        // SIUeditinstance
        addSIUClas1622477111296378Ser3UIServ1();
    }

    private void addPIUClas1057569177600607UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600607UIPobCl_1");
            addDSItems4Clas1057569177600607CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600607AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600646UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600646UIPobCl_1");
            addDSItems4Clas1057569177600646CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600646AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600646NavOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600646UIPobCl2() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600646UIPobCl_2");
            addDSItems4Clas1057569177600646CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600646AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600646NavOfer2(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600553UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600553UIPobCl_1");
            addDSItems4Clas1057569177600553CjtoVis3(iuPermissions);
            addActionItems4Clas1057569177600553AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600553NavOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600553UIPobCl2() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600553UIPobCl_2");
            addDSItems4Clas1057569177600553CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600553AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600553NavOfer2(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600553UIPobCl4() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600553UIPobCl_4");
            addDSItems4Clas1057569177600553CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600553AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600553NavOfer4(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600423UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600423UIPobCl_1");
            addDSItems4Clas1057569177600423CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600423AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600719UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600719UIPobCl_1");
            addDSItems4Clas1057569177600719CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600719AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600719NavOfer2(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600719UIPobCl2() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600719UIPobCl_2");
            addDSItems4Clas1057569177600719CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600719AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600995UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600995UIPobCl_1");
            addDSItems4Clas1057569177600995CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600995AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1057569177600792UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600792UIPobCl_1");
            addDSItems4Clas1057569177600792CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600792AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1468338274304118UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1468338274304118UIPobCl_1");
            addDSItems4Clas1468338274304118CjtoVis2(iuPermissions);
            addActionItems4Clas1468338274304118AccOfer1(iuPermissions);
            addNavigationItems4Clas1468338274304118NavOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1468421898240231UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1468421898240231UIPobCl_1");
            addDSItems4Clas1468421898240231CjtoVis1(iuPermissions);
            addActionItems4Clas1468421898240231AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1622453649408348UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622453649408348UIPobCl_1");
            addDSItems4Clas1622453649408348CjtoVis1(iuPermissions);
            addActionItems4Clas1622453649408348AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1622460465152786UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622460465152786UIPobCl_1");
            addDSItems4Clas1622460465152786CjtoVis1(iuPermissions);
            addActionItems4Clas1622460465152786AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1622460596224994UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622460596224994UIPobCl_1");
            addDSItems4Clas1622460596224994CjtoVis1(iuPermissions);
            addActionItems4Clas1622460596224994AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addPIUClas1622477111296378UIPobCl1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622477111296378UIPobCl_1");
            addDSItems4Clas1622477111296378CjtoVis1(iuPermissions);
            addActionItems4Clas1622477111296378AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600607UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600607UIInst_1");
            addDSItems4Clas1057569177600607CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600607AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600607UIInst2() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600607UIInst_2");
            addDSItems4Clas1057569177600607CjtoVis1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600646UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600646UIInst_1");
            addDSItems4Clas1057569177600646CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600646AccOfer1(iuPermissions);
            addNavigationItems4Clas1057569177600646NavOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600553UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600553UIInst_1");
            addDSItems4Clas1057569177600553CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600553AccOfer2(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600423UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600423UIInst_1");
            addDSItems4Clas1057569177600423CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600423AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600719UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600719UIInst_1");
            addDSItems4Clas1057569177600719CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600719AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600719UIInst2() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600719UIInst_2");
            addDSItems4Clas1057569177600719CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600719AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600995UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600995UIInst_1");
            addDSItems4Clas1057569177600995CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600995AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1057569177600792UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600792UIInst_1");
            addDSItems4Clas1057569177600792CjtoVis1(iuPermissions);
            addActionItems4Clas1057569177600792AccOfer1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1468338274304118UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1468338274304118UIInst_1");
            addDSItems4Clas1468338274304118CjtoVis1(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addIIUClas1622453649408348UIInst1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622453649408348UIInst_1");
            addDSItems4Clas1622453649408348CjtoVis2(iuPermissions);
            visibleIUs.add(iuPermissions);
        }
    }

    private void addMDIUClas1057569177600607UIMaDet1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600607UIMaDet_1");
            addDetail(iuPermissions, "Clas_1057569177600607UIMaDet_1Det_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
            visibleIUs.add(iuPermissions);
        }
    }

    private void addMDIUClas1057569177600553UIMaDet1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600553UIMaDet_1");
            addDetail(iuPermissions, "Clas_1057569177600553UIMaDet_1Det_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
            visibleIUs.add(iuPermissions);
        }
    }

    private void addMDIUClas1057569177600719UIMaDet1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1057569177600719UIMaDet_1");
            addDetail(iuPermissions, "Clas_1057569177600719UIMaDet_1Det_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
            visibleIUs.add(iuPermissions);
        }
    }

    private void addMDIUClas1622460465152786UIMaDet1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            VisibleIUPermissions iuPermissions = new VisibleIUPermissions("Clas_1622460465152786UIMaDet_1");
            addDetail(iuPermissions, "Clas_1622460465152786UIMaDet_1Det_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
            visibleIUs.add(iuPermissions);
        }
    }

    private void addSIUClas1057569177600607Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser7UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_7UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser8UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_8UIServ_1"));
        }
    }

    private void addSIUClas1057569177600607Ser9UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600607Ser_9UIServ_1"));
        }
    }

    private void addSIUClas1057569177600646Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600646Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600646Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600646Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600646Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600646Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser6UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_6UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser10UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_10UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser11UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_11UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser12UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_12UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser13UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_13UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser14UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_14UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser15UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_15UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser16UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_16UIServ_1"));
        }
    }

    private void addSIUClas1057569177600553Ser20UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600553Ser_20UIServ_1"));
        }
    }

    private void addSIUClas1057569177600423Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600423Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600423Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600423Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600423Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600423Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600423Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600423Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser6UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_6UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser7UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_7UIServ_1"));
        }
    }

    private void addSIUClas1057569177600719Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600719Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1057569177600995Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600995Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600995Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600995Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600995Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600995Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser6UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_6UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser7UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_7UIServ_1"));
        }
    }

    private void addSIUClas1057569177600792Ser8UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1057569177600792Ser_8UIServ_1"));
        }
    }

    private void addSIUClas1468338274304118Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468338274304118Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1468338274304118Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468338274304118Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1468338274304118Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468338274304118Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1468338274304118Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468338274304118Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser9UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_9UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser10UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_10UIServ_1"));
        }
    }

    private void addSIUClas1468421898240231Ser13UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1468421898240231Ser_13UIServ_1"));
        }
    }

    private void addSIUClas1622453649408348Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622453649408348Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1622453649408348Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622453649408348Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1622453649408348Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622453649408348Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1622453649408348Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622453649408348Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1622453649408348Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622453649408348Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser6UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_6UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser7UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_7UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser8UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_8UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser9UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_9UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser10UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_10UIServ_1"));
        }
    }

    private void addSIUClas1622460465152786Ser11UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460465152786Ser_11UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser4UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_4UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser5UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_5UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser6UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_6UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser7UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_7UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser8UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_8UIServ_1"));
        }
    }

    private void addSIUClas1622460596224994Ser9UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622460596224994Ser_9UIServ_1"));
        }
    }

    private void addSIUClas1622465314816112Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622465314816112Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1622465314816112Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622465314816112Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1622465314816112Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622465314816112Ser_3UIServ_1"));
        }
    }

    private void addSIUClas1622477111296378Ser1UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622477111296378Ser_1UIServ_1"));
        }
    }

    private void addSIUClas1622477111296378Ser2UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622477111296378Ser_2UIServ_1"));
        }
    }

    private void addSIUClas1622477111296378Ser3UIServ1() {
        if (modelElementRolesIncludeAnyUserRole(Arrays.asList(ADMINUSER_ROLE))) {
            visibleIUs.add(new VisibleIUPermissions("Clas_1622477111296378Ser_3UIServ_1"));
        }
    }


    private void addDSItems4Clas1057569177600607CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_9", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_8", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600607CjtoVis_1ICtjoVis_10", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600646CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600646CjtoVis_1ICtjoVis_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600553CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_13", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_12", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_15", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_1ICtjoVis_8", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600553CjtoVis3(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_8", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600553CjtoVis_3ICtjoVis_9", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600423CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600423CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600423CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600719CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_6", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_7", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600719CjtoVis_1ICtjoVis_8", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600995CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600995CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600995CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600995CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600995CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1057569177600792CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1057569177600792CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600792CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600792CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1057569177600792CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1468338274304118CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_1ICtjoVis_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_1ICtjoVis_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1468338274304118CjtoVis2(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_2ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_2ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_2ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468338274304118CjtoVis_2ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1468421898240231CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1468421898240231CjtoVis_1ICtjoVis_1", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468421898240231CjtoVis_1ICtjoVis_3", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468421898240231CjtoVis_1ICtjoVis_2", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1468421898240231CjtoVis_1ICtjoVis_4", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1622453649408348CjtoVis2(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_2ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_2ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_2ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_2ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_2ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1622453649408348CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622453649408348CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1622460465152786CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1622460465152786CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460465152786CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460465152786CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460465152786CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460465152786CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1622460596224994CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1622460596224994CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460596224994CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460596224994CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460596224994CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622460596224994CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItems4Clas1622477111296378CjtoVis1(VisibleIUPermissions iuPermissions) {
        addDSItem(iuPermissions, "Clas_1622477111296378CjtoVis_1ICtjoVis_1", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622477111296378CjtoVis_1ICtjoVis_2", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622477111296378CjtoVis_1ICtjoVis_3", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622477111296378CjtoVis_1ICtjoVis_4", Arrays.asList(ADMINUSER_ROLE));
        addDSItem(iuPermissions, "Clas_1622477111296378CjtoVis_1ICtjoVis_5", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600607AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600607AccOfer_1ElemAcc_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600646AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600646AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600646AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600646AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600553AccOfer2(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_2ElemAcc_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600553AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_9", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_7", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_8", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600553AccOfer_1ElemAcc_10", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600423AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600423AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600423AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600423AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600719AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600719AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600719AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600719AccOfer_1ElemAcc_5", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600719AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600719AccOfer_1ElemAcc_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600995AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600995AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600995AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600995AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1057569177600792AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1057569177600792AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600792AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1057569177600792AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1468338274304118AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1468338274304118AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468338274304118AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468338274304118AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468338274304118AccOfer_1ElemAcc_4", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addActionItems4Clas1468421898240231AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1468421898240231AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468421898240231AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468421898240231AccOfer_1ElemAcc_3", Arrays.asList(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1468421898240231AccOfer_1ElemAcc_5", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1622453649408348AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1622453649408348AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622453649408348AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622453649408348AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1622460465152786AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1622460465152786AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460465152786AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460465152786AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460465152786AccOfer_1ElemAcc_4", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460465152786AccOfer_1ElemAcc_5", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1622460596224994AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1622460596224994AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460596224994AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622460596224994AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addActionItems4Clas1622477111296378AccOfer1(VisibleIUPermissions iuPermissions) {
        addActionItem(iuPermissions, "Clas_1622477111296378AccOfer_1ElemAcc_1", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622477111296378AccOfer_1ElemAcc_2", Arrays.asList(ADMINUSER_ROLE));
        addActionItem(iuPermissions, "Clas_1622477111296378AccOfer_1ElemAcc_3", Arrays.asList(ADMINUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600646NavOfer1(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600646NavOfer_1ElemNav_2", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
        addNavigationItem(iuPermissions, "Clas_1057569177600646NavOfer_1ElemNav_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600646NavOfer2(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600646NavOfer_2ElemNav_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600553NavOfer1(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600553NavOfer_1ElemNav_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600553NavOfer2(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600553NavOfer_2ElemNav_6", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600553NavOfer4(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600553NavOfer_4ElemNav_10", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1057569177600719NavOfer2(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1057569177600719NavOfer_2ElemNav_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addNavigationItems4Clas1468338274304118NavOfer1(VisibleIUPermissions iuPermissions) {
        addNavigationItem(iuPermissions, "Clas_1468338274304118NavOfer_1ElemNav_1", Arrays.asList(ADMINUSER_ROLE, OPERATORUSER_ROLE));
    }

    private void addDSItem(VisibleIUPermissions iuPermissions, String dsItemId, List<String> modelElementRoles) {
        if (modelElementRolesIncludeAnyUserRole(modelElementRoles))
            iuPermissions.getVisibleAttributes().add(dsItemId);
    }

    private void addActionItem(VisibleIUPermissions iuPermissions, String actionId, List<String> modelElementRoles) {
        if (modelElementRolesIncludeAnyUserRole(modelElementRoles))
            iuPermissions.getVisibleActions().add(actionId);
    }

    private void addNavigationItem(VisibleIUPermissions iuPermissions, String navigationId, List<String> modelElementRoles) {
        if (modelElementRolesIncludeAnyUserRole(modelElementRoles))
            iuPermissions.getVisibleNavigations().add(navigationId);
    }

    private void addDetail(VisibleIUPermissions iuPermissions, String detailId, List<String> modelElementRoles) {
        if (modelElementRolesIncludeAnyUserRole(modelElementRoles))
            iuPermissions.getVisibleDetails().add(detailId);
    }

    private boolean modelElementRolesIncludeAnyUserRole(List<String> modelElementRoles) {
        return !Sets.intersection(Sets.newHashSet(modelElementRoles), Sets.newHashSet(userRoles)).isEmpty();
    }

}
