package com.dhcs.business.role;

import com.dhcs.business.EcoSystem;
import com.dhcs.business.enterprise.Enterprise;
import com.dhcs.business.organization.Organization;
import com.dhcs.business.useraccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Shivesh 
 */
public abstract class Role {
    
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business,  ArrayList<Enterprise> enterpriseList);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}