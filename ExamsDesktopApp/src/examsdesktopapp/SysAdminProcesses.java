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
import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class SysAdminProcesses {
    public static SysAdminBean login(String uname, String upass) {
        SysAdminBean sys_admin = new SysAdminBean();
        sys_admin.setUname(uname);
        sys_admin.setPass(upass);
        sys_admin.setValid(false);
        sys_admin = SysAdminDAO.login(sys_admin);
        return sys_admin;
    }
    
    
    public static String[] getUsersToString() {
        ArrayList<UserBean> users = getUsers();
        String[] array = new String[users.size()];
        for(int i=0; i<array.length; i++) {
            array[i]="User ID: " + users.get(i).getU_id() + " | Name: " + users.get(i).getName() + " | Username: " + users.get(i).getUname();
        }
        return array;
    }
    
    private static ArrayList<UserBean> getUsers() {

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
    
    
    
    public static String[] getExamCentersToString() {
        ArrayList<ExamCenter> examCenters = getExamCenters();
        String[] array = new String[examCenters.size()];
        for(int i=0; i<array.length; i++) {
            array[i]="ID: " + examCenters.get(i).getEc_id() + " | Name: " + examCenters.get(i).getName() + " | Address: " + examCenters.get(i).getAddress();
        }
        return array;
    }
    
    
    private static ArrayList<ExamCenter> getExamCenters() {

        ArrayList<ExamCenter> examCenters = new ArrayList();
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;

        String selectQuery = "select * from exams_center";

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int ecId = rs.getInt("ec_id");
                String name = rs.getString("name");
                String address = rs.getString("address");

                ExamCenter examCenter = new ExamCenter();

                examCenter.setEc_id(ecId);
                examCenter.setName(name);
                examCenter.setAddress(address);
                

                examCenters.add(examCenter);
            }

        } catch (SQLException ex) {
            System.out.println("Getting exams centers from database failed: An Exception has occurred!" + ex);
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


        return examCenters;

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
    
    
    public static boolean addExamCenter(ExamCenter ec) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String insertQuery = "insert into exams_center (name, address)"
                + "values ('" + ec.getName() + "', '" + ec.getAddress() + "')";
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(insertQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding new exam center, " + ec.getName() + ", failed: An Exception has occurred!" + ex);
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
    
    private static UserBean getUserById(int uId) {
        Connection currentCon = null;
        ResultSet rs = null;
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
                String pass = rs.getString("pass");
                int ex_id = rs.getInt("ex_id");
                
                user.setU_id(uId);
                user.setName(name);
                user.setUname(uname);
                user.setPass(pass);
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
    
    private static boolean addAdmin(UserBean user, int ecId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        
        String updateQuery = "update user set admin=1, ec_id=" + ecId + " where u_id=" + user.getU_id();
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding new admin, " + user.getUname() + ", failed: An Exception has occurred!" + ex);
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
    
    
    public static boolean addAdminFromUsers(int uId, int ecId) {
        UserBean user = getUserById(uId);
        boolean success = addAdmin(user, ecId);
        return success;
    }
    
    public static boolean addExam(Exam exam) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String insertQuery = "insert into exam (date, time, ec_id, started)"
                + "values ('" + exam.getDateStr() + "', '" + exam.getTimeStr()
                + "', " + exam.getEc_id() + ", 0)";
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(insertQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding new exam failed: An Exception has occurred!" + ex);
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
    
    
}
