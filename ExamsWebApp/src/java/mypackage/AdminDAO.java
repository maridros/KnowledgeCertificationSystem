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
public class AdminDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static AdminBean login(AdminBean bean) {
        Statement stmt = null;
        String username = bean.getUname();
        String password = bean.getPass();

        String searchQuery = "select * from user where uname='" + username + "' AND pass='" + password + "' AND admin=1";
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();

            if (!found) {
                bean.setValid(false);
            } else if (found) {

                int ca_id = rs.getInt("u_id");
                String uname = rs.getString("uname");
                int ec_id = rs.getInt("ec_id");
                bean.setCa_id(ca_id);
                bean.setUname(uname);
                bean.setEc_id(ec_id);
                bean.setValid(true);
            }
        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred!" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {
                }
                currentCon = null;
            }
        }

        return bean;
    }
}
