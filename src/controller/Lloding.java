/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.sqlconnecter;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author senvi
 */
public class Lloding {
    
    
     public void load(JTable table, String tableName) {
    ResultSet rs = sqlconnecter.loadtable(tableName);  // Assuming sqlQ.loadTable(String) returns a ResultSet
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); 
    
         System.out.println(table);
         System.out.println(tableName);
    
// Clear existing rows

    try {
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
     
     
     
       public void delete(JTable s1,String tdname) {
       
        int r = s1.getSelectedRow();
        System.out.println(r);
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Select table", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
              String i = s1.getValueAt(r, 2).toString();
          sqlconnecter.delete(i, tdname);
          load(s1,tdname);

      
        }
        
    }

    public void update(String tdcname1, String tpname1, String tpno, String tpemail1, String tpdate1, String tptime1, int ID, String tdname, JTable dentaltable) {
        
         
         System.out.println(tdname);
       
        sqlconnecter.Update(tdcname1,tpname1,tpno,tpemail1,tpdate1,tptime1,ID,tdname);
        
      
       load(dentaltable, tdname);
        
    }

 
       
       
  

    
}
