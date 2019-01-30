/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcs.userinterface.role.droneambulancestaff;

import com.dhcs.business.doctor.Doctor;
import com.dhcs.business.EcoSystem;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.LabOrganization;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import com.dhcs.business.workqueue.HospitalWorkRequest;
import com.dhcs.business.workqueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author raunak
 */
public class RequestHospitalJPanel extends javax.swing.JPanel {
    private static final Logger logger = Logger.getLogger(RequestHospitalJPanel.class);
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ArrayList<Enterprise> enterpriseList;
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestHospitalJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, ArrayList<Enterprise> enterpriseListInj) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.enterpriseList = enterpriseListInj;
        valueLabel.setText(enterprise.getName());
        populateMedicalCategoryJcomboBox();
        populateHospitalNamejComboBox(enterpriseListInj);
    }

   
    
    private void populateMedicalCategoryJcomboBox(){
            for(Doctor.Speciality spec: Doctor.Speciality.values()){
                medicalCategoryJcomboBox.addItem(spec);
            }

        }
        
        private void populateHospitalNamejComboBox(ArrayList<Enterprise> enterpriseList){
            
            for(Enterprise enterp: enterpriseList) {
                if(enterp.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)) {
                    hospitalNamejComboBox.addItem(enterp);
                }
            }
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        medicalCategoryJcomboBox = new javax.swing.JComboBox();
        hospitalNamejComboBox = new javax.swing.JComboBox();
        requestTestJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, 50));

        valueLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 120, 30));

        jLabel1.setText("Medical Category");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, 50));

        jLabel2.setText("Hospital Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 140, 50));

        medicalCategoryJcomboBox.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        add(medicalCategoryJcomboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 230, 50));

        hospitalNamejComboBox.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        add(hospitalNamejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 230, 50));

        requestTestJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        requestTestJButton.setText("Request Hospital");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, 210, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DroneAmbulanceStaffWorkAreaJPanel droneAmbulanceStaffWorkAreaJPanel = (DroneAmbulanceStaffWorkAreaJPanel) component;
        droneAmbulanceStaffWorkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        Doctor.Speciality speciality = (Doctor.Speciality) medicalCategoryJcomboBox.getSelectedItem();
        Enterprise enterpriseHospital = (Enterprise) hospitalNamejComboBox.getSelectedItem();

        HospitalWorkRequest request = new HospitalWorkRequest();
        request.setHospitalName(enterpriseHospital);
        request.setMedicalCondition(speciality);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setHospitalStatus("Pending");

        enterpriseHospital.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);

    }//GEN-LAST:event_requestTestJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox hospitalNamejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox medicalCategoryJcomboBox;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
