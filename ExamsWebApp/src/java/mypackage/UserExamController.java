/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Maria
 */
public class UserExamController {
    private Connection currentCon = null;
    private ResultSet rs = null;
    
    public boolean checkAccess(UserBean user) {
        Statement stmt1 = null;
        boolean found_log = false;
        
        int uId = user.getU_id();
        int exId = user.getEx_id();
        String uname = user.getUname();
        String logId = "log_" + uname + "_" + uId;
        String selectQuery1 = "select * from user_answers where user_log_id = '" + logId + "' AND ex_id=" + exId;
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt1 = currentCon.createStatement();
            rs = stmt1.executeQuery(selectQuery1);
            found_log = rs.next();
            
            
        } catch (SQLException ex) {
            System.out.println("Checking user log failed: An Exception has occurred!" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                stmt1 = null;
                //stmt2 = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {
                }
                currentCon = null;
            }
        }
        
        if(found_log)
            return false;
        else
            return true;
    }
}
