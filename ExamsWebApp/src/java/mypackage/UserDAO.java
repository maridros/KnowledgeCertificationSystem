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
import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class UserDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static UserBean login(UserBean bean) {
        Statement stmt = null;
        String username = bean.getUname();
        String password = bean.getPass();
        
        String searchQuery = "select * from user where uname='" + username + "' AND pass='" + password + "' AND admin=0";
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                bean.setValid(false); //na frontisw na pernaw kai to msg!!!
            }
            else if(found) {
                int u_id = rs.getInt("u_id");
                String name = rs.getString("name");
                String uname = rs.getString("uname");
                int ex_id = rs.getInt("ex_id");
                
                bean.setU_id(u_id);
                bean.setName(name);
                bean.setUname(uname);
                bean.setEx_id(ex_id);
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
    
    
    public static UserBean getUserById(int uId) {
        Statement stmt = null;
        UserBean user = new UserBean();
        
        String searchQuery = "select * from user where u_id=" + uId + " AND admin=0";
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                System.out.println("Error getting user with id = " + uId + "!");
            }
            else if(found) {
                String name = rs.getString("name");
                String uname = rs.getString("uname");
                int ex_id = rs.getInt("ex_id");
                
                user.setU_id(uId);
                user.setName(name);
                user.setUname(uname);
                user.setEx_id(ex_id);
            }
        } catch (SQLException e) {
            System.out.println("Geting User info failed: An Exception has occurred!" + e);
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
        
        
        return user;
    }
    
    public static boolean addUser(UserBean user) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String insertQuery = "insert into user (name, uname, pass, admin)"
                + "values ('" + user.getName() + "', '" + user.getUname() 
                + "', '" + user.getPass() + "', 0)";
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(insertQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding new user, " + user.getUname() + ", failed: An Exception has occurred!" + ex);
            success = false;
        } finally {
            
            stmt = null;

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {
                }
                currentCon = null;
            }
        }
        
        return success;
        
    }
    
    public static ArrayList<UserBean> getUsers() {

        ArrayList<UserBean> users = new ArrayList();
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;

        String selectQuery = "select * from user where admin=0";

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int uId = rs.getInt("u_id");
                String name = rs.getString("name");
                String uname = rs.getString("uname");

                UserBean user = new UserBean();

                user.setU_id(uId);
                user.setName(name);
                user.setUname(uname);
                

                users.add(user);
            }

        } catch (SQLException ex) {
            System.out.println("Getting users from database failed: An Exception has occurred!" + ex);
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


        return users;

    }
    
}
