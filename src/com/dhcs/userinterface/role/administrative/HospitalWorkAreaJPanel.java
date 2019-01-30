/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcs.userinterface.role.administrative;

import com.dhcs.business.doctor.Doctor;
import com.dhcs.business.employee.Employee;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.enterprise.MedicalCouncilEnterprise;
import com.dhcs.business.organization.DoctorOrganization;
import com.dhcs.business.organization.HospitalOrganization;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import com.dhcs.business.workqueue.HospitalWorkRequest;
import com.dhcs.business.workqueue.LabTestWorkRequest;
import com.dhcs.business.workqueue.WorkRequest;
import com.dhcs.userinterface.role.labassistant.ProcessWorkRequestJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author shive
 */
public class HospitalWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ArrayList<Enterprise> enterpriseList;
    private HospitalOrganization hospitalOrganization;
    private static final Logger logger = Logger.getLogger(HospitalWorkAreaJPanel.class);

    /**
     * Creates new form HospitalWorkAreaJPanel
     */
    public HospitalWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account,
            Organization organizationInj, ArrayList<Enterprise> enterpriseListinj) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.enterpriseList = enterpriseListinj;
        this.hospitalOrganization = (HospitalOrganization) organizationInj;

        populateTable();
    }

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) hospitalWorkRequestTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];
            HospitalWorkRequest hrequest = (HospitalWorkRequest) request;

            row[0] = hrequest;
            row[1] = hrequest.getMedicalCondition();
            row[2] = hrequest.getHospitalStatus();
            //Pending, Sent to Doctor, Doctor Assigned

            row[3] = hrequest.getDoctor();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        hospitalManageContainerPanel = new javax.swing.JPanel();
        manageOrganizationJButton = new javax.swing.JButton();
        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalWorkRequestTable = new javax.swing.JTable();
        ambWorkReqProcessjButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 28)); // NOI18N
        jLabel1.setText(" Hospital Admin Work Panel");

        hospitalManageContainerPanel.setBackground(new java.awt.Color(255, 255, 204));
        hospitalManageContainerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Hospital Organisation"));

        manageOrganizationJButton.setBackground(new java.awt.Color(0, 51, 51));
        manageOrganizationJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageOrganizationJButton.setText("Add New Organization");
        manageOrganizationJButton.setBorder(null);
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        userJButton.setBackground(new java.awt.Color(0, 153, 51));
        userJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        userJButton.setForeground(new java.awt.Color(255, 255, 255));
        userJButton.setText("User Directory");
        userJButton.setBorder(null);
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setBackground(new java.awt.Color(0, 102, 51));
        manageEmployeeJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        manageEmployeeJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeJButton.setText("Employee Directory");
        manageEmployeeJButton.setBorder(null);
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hospitalManageContainerPanelLayout = new javax.swing.GroupLayout(hospitalManageContainerPanel);
        hospitalManageContainerPanel.setLayout(hospitalManageContainerPanelLayout);
        hospitalManageContainerPanelLayout.setHorizontalGroup(
            hospitalManageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalManageContainerPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        hospitalManageContainerPanelLayout.setVerticalGroup(
            hospitalManageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalManageContainerPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(hospitalManageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jPanel1.setBackground(new java.awt.Color(208, 240, 201));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Work Request"));

        hospitalWorkRequestTable.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        hospitalWorkRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medical Travel Agency", "Medical Attention Required", "Status", "Doctor Assigned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hospitalWorkRequestTable.setRowHeight(25);
        jScrollPane1.setViewportView(hospitalWorkRequestTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        ambWorkReqProcessjButton.setText("Process Request");
        ambWorkReqProcessjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambWorkReqProcessjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ambWorkReqProcessjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(hospitalManageContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ambWorkReqProcessjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(hospitalManageContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        logger.debug("Hospital Admin Work Panel: User Directory");
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed
        logger.debug("Hospital Admin Work Panel: Employee Directory");
        if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)) {
            //Hospital Org
            ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
            userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        }
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        logger.debug("Hospital Admin Work Panel: Add New Organization");
        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory(), enterprise.getEnterpriseType());
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void ambWorkReqProcessjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambWorkReqProcessjButtonActionPerformed

        int selectedRow = hospitalWorkRequestTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }

        HospitalWorkRequest request = (HospitalWorkRequest) hospitalWorkRequestTable.getValueAt(selectedRow, 0);

        boolean doctorFound = false;
        ArrayList<Doctor> doctorsAssigned = new ArrayList<Doctor>();
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof DoctorOrganization) {
                for (Employee employee : org.getEmployeeDirectory().getEmployeeList()) {
                    Doctor d = (Doctor) employee;
                    if (d.getSpec().equals(request.getMedicalCondition())) {
                        doctorFound = true;
                        doctorsAssigned.add(d);
                    }
                }
            }
        }

        if (!doctorFound) {
            for (Enterprise enterpriseinj : enterpriseList) {
                if (enterpriseinj instanceof MedicalCouncilEnterprise) {
                    MedicalCouncilEnterprise med = (MedicalCouncilEnterprise) enterpriseinj;
                    for (Employee employee : med.getOrganizationDirectory().getOrganizationList().get(0).
                            getEmployeeDirectory().getEmployeeList()) {
                        Doctor d = (Doctor) employee;
                        if (d.getSpec().equals(request.getMedicalCondition())) {
                            doctorFound = true;
                            doctorsAssigned.add(d);
                        }
                    }
                }
            }
        }

        if (!doctorFound) {
            request.setHospitalStatus("Rejected");
            request.setStatus("Rejected");
        } else {

            request.setHospitalStatus("Doctor in line");
            request.setDoctorStatus("Pending");

            for (Enterprise enterpriseInj : enterpriseList) {
                    for (Organization org : enterpriseInj.getOrganizationDirectory().getOrganizationList()) {
                    //for (Employee employee: org.getEmployeeDirectory().getEmployeeList()){
                        for (UserAccount userAcc : org.getUserAccountDirectory().getUserAccountList()) {
                            if (userAcc.getEmployee() instanceof Doctor) {
                                for(Doctor  doctor: doctorsAssigned){

                                    if (((Doctor) userAcc.getEmployee()).getName().equals(doctor.getName())
                                            && ((Doctor) userAcc.getEmployee()).getSpec().equals(doctor.getSpec())) {

                                        ((Doctor) userAcc.getEmployee()).getWorkQueue().getWorkRequestList().add(request);
                                    }
                              }
                            }
                        }
                }
            }

        }

        populateTable();

    }//GEN-LAST:event_ambWorkReqProcessjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ambWorkReqProcessjButton;
    private javax.swing.JPanel hospitalManageContainerPanel;
    private javax.swing.JTable hospitalWorkRequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton userJButton;
    // End of variables declaration//GEN-END:variables
}
