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
import com.dhcs.userinterface.systemadminworkarea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem system, ArrayList<Enterprise> enterpriseList) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
