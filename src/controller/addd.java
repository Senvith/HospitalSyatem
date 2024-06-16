/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlconnecter;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author senvi
 */
public class addd {

    public void submitdata(JComboBox<String> dcname1, JTextField paname, JTextField pnumber, JTextField pemail, JTextField pdate, JTextField ptime, String tdname) {
        
        
        
     String ndcnameCombo = (String) dcname1.getSelectedItem();
     String npaname  = paname.getText();
     String npnumber = pnumber.getText();
     String npemail  = pemail.getText();
     String npdate   = pdate.getText();
     String nptime = ptime.getText();
    
        
     sqlconnecter.submitData(ndcnameCombo, npaname, npnumber, npemail, npdate,nptime, tdname);
    }
    
    
 


}