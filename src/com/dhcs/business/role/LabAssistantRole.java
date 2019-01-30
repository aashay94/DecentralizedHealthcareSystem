/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhcs.business.role;

import com.dhcs.business.EcoSystem;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import java.util.ArrayList;
import com.dhcs.userinterface.role.labassistant.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Shivesh
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ArrayList<Enterprise> enterpriseList) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, business);
    }
    
}
