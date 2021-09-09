/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsdesktopapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Maria
 */
public class SysAdminDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static SysAdminBean login(SysAdminBean bean) {
        Statement stmt = null;
        String username = bean.getUname();
        String password = bean.getPass();
        
        String searchQuery = "select * from sys_admin where uname='" + username + "'AND pass='" + password + "'";
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                bean.setValid(false);
            }
            else if(found) {
                int sa_id = rs.getInt("sa_id");
                String uname = rs.getString("uname");
                
                bean.setSa_id(sa_id);
                bean.setUname(uname);
                bean.setValid(true);
            }
        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred!" + ex);
        }
        
        finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {}
                stmt = null;
            }
            
            if(currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {}
                currentCon = null;
            }
        }
        
        return bean;
    }
}
