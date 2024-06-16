/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author senvith
 */
public class sqlconnecter {
    
     public static void CreateAcc(String username, String name, String password) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst;
        String query = "INSERT INTO admin (name, username, password) VALUES (?, ?, ?)";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Account acount create successful");
        } catch (SQLException e) {
            System.out.println(e);
           JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    public static ResultSet checkuser(String username, String Password) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst;
        ResultSet rs = null;
        String query = "SELECT username, password FROM admin WHERE username = ? AND password = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, Password);
            rs = pst.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println(e);   
        }

    return rs;
    }
     
   
     
    
    //database add to apoiment

    public static void submitData(String ndcname, String npaname, String npnumber, String npemail, String npdate, String nptime, String tdname) {
         Connection conn = DBConnection.connect();
        PreparedStatement pst = null;
       String query = "INSERT INTO " + tdname + " (Dname, Pname, Phone, Email, Date, Time) VALUES (? , ?, ?, ?, ?, ?)";

        System.out.println(tdname);
        try {
            System.out.println("in try ");
            pst = conn.prepareStatement(query);
            pst.setString(1, ndcname);
            pst.setString(2, npaname);
            pst.setString(3, npnumber);
            pst.setString(4, npemail);
            pst.setString(5, npdate);
            pst.setString(6, nptime);
            pst.executeUpdate();
            
            
             JOptionPane.showMessageDialog(null, "Add successful");
        } catch (SQLException e) {
            System.out.println("in catch");
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    //loading table
       public static ResultSet loadtable(String tdname) {
      
             PreparedStatement pst;
        ResultSet rs = null;
       Connection conn = DBConnection.connect();
        

        String query = "SELECT * FROM " + tdname + "";

        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            return rs;
        }
    
    }


public static void delete(String phone, String tableName) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
   // System.out.println(phone);
    
    try {
        conn = DBConnection.connect();
        String query = "DELETE FROM " + tableName + " WHERE Phone = ?";
        pst = conn.prepareStatement(query);
        pst.setString(1, phone);
        int rowsAffected = pst.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Delete successful");
        } else {
            JOptionPane.showMessageDialog(null, "No records found to delete");
        }
    } catch (SQLException e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

    public static void Update(String tdcname1, String tpname1, String tpno, String tpemail1, String tpdate1, String tptime1, int ID, String tdname) {
        Connection conn = DBConnection.connect();
        PreparedStatement pst = null;
        
        
        System.out.println(tdname);

         try {
        String query = " UPDATE " + tdname + " SET Dname= ? ,Pname=?,Phone=?,Email=?,Date=?,Time=? WHERE Id=?";
        pst = conn.prepareStatement(query);
        pst.setString(1, tdcname1);
        pst.setString(2, tpname1);
        pst.setString(3, tpno);
        pst.setString(4, tpemail1);
        pst.setString(5, tpdate1);
        pst.setString(6, tptime1);
        pst.setInt(7, ID);

        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
}
         
    }
}
 

   







