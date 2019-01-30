
package com.dhcs.userinterface.role.ambulancestaff;

import com.dhcs.business.doctor.Doctor;
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
 * @author Shivesh
 */
public class RequestHospitalJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ArrayList<Enterprise> enterpriseList;
    private static final Logger logger = Logger.getLogger(RequestHospitalJPanel.class);
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestHospitalJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, ArrayList<Enterprise> enterpriseListInj ) {
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

        requestTestJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        medicalCategoryJcomboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        hospitalNamejComboBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        requestTestJButton.setText("Request Hospital");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 580, 210, 50));

        backJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 130, 50));

        valueLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, 30));

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel1.setText("Medical Category");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 210, 50));

        medicalCategoryJcomboBox.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        add(medicalCategoryJcomboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 230, 50));

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel2.setText("Hospital Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 200, 50));

        hospitalNamejComboBox.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        add(hospitalNamejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 230, 50));
    }// </editor-fold>//GEN-END:initComponents

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

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AmbulanceStaffWorkAreaJPanel ambulanceStaffWorkAreaJPanel = (AmbulanceStaffWorkAreaJPanel) component;
        ambulanceStaffWorkAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

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
