package com.dhcs.business.role;

import com.dhcs.business.EcoSystem;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.DoctorOrganization;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import java.util.ArrayList;
import com.dhcs.userinterface.role.doctor.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shivesh
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,
            EcoSystem business, ArrayList<Enterprise> enterpriseList) {
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization)organization, enterprise);
    }
    
    
}
