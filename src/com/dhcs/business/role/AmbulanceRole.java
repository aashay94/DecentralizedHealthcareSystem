/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcs.business.role;

import com.dhcs.business.EcoSystem;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.AmbulanceOrganization;
import com.dhcs.business.organization.DoctorOrganization;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import com.dhcs.userinterface.role.ambulancestaff.AmbulanceStaffWorkAreaJPanel;
import com.dhcs.userinterface.role.doctor.DoctorWorkAreaJPanel;

/**
 *
 * @author shive
 */
public class AmbulanceRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,
            EcoSystem business, ArrayList<Enterprise> enterpriseList) {
        return new AmbulanceStaffWorkAreaJPanel(userProcessContainer, account, (AmbulanceOrganization)organization, enterprise,enterpriseList);
    }
    
}
