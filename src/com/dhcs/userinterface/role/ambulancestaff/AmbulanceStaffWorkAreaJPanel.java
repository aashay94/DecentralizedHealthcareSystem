package com.dhcs.userinterface.role.ambulancestaff;

import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.AmbulanceOrganization;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import com.dhcs.business.workqueue.HospitalWorkRequest;
import com.dhcs.business.workqueue.LabTestWorkRequest;
import com.dhcs.business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
/**
 *
 * @author shivesh
 */
public class AmbulanceStaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private AmbulanceOrganization ambulanceOrganization;
    private Enterprise enterprise;
    private ArrayList<Enterprise> enterpriseList;
    private static final Logger logger = Logger.getLogger(AmbulanceStaffWorkAreaJPanel.class);
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public AmbulanceStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, 
            Enterprise enterpriseInj,ArrayList<Enterprise> enterpriseListInj) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ambulanceOrganization = (AmbulanceOrganization)organization;
        this.enterprise = enterpriseInj;
        this.enterpriseList = enterpriseListInj;
        
        populateRequestTable();
    }
    
    
      public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            HospitalWorkRequest hrequest= (HospitalWorkRequest) request;
            row[0] = hrequest.getMedicalCondition();
            row[1] = hrequest.getHospitalName();
            row[2] = hrequest.getStatus();
                        
            model.addRow(row);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hospital Name", "Medical Condition", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 870, 100));

        requestJButton.setBackground(new java.awt.Color(204, 0, 0));
        requestJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        requestJButton.setText("Request Hospital");
        requestJButton.setBorder(null);
        requestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestJButtonActionPerformed(evt);
            }
        });
        add(requestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 489, 220, 50));

        refreshJButton.setBackground(new java.awt.Color(204, 255, 204));
        refreshJButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 99, 190, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void requestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestJButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestHospitalJPanel", new RequestHospitalJPanel(userProcessContainer, userAccount,
                enterprise, enterpriseList));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton requestJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
