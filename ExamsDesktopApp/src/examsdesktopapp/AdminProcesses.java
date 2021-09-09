/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsdesktopapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class AdminProcesses {
    
    public static AdminBean login(String uname, String upass) {
        AdminBean admin = new AdminBean();
        admin.setUname(uname);
        admin.setPass(upass);
        admin.setValid(false);
        admin = AdminDAO.login(admin);
        return admin;
    }
    
    public static boolean startExam(int exId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String updateQuery = "update exam set started = 1 where ex_id = " + exId;
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);
            
        } catch (SQLException ex) {
            System.out.println("Starting exam with id " + exId + " failed: An Exception has occurred!" + ex);
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
    
    public static String[] getNonStartedExams(int ecId) {
        
        String query = "select * from exam where started = 0 AND ec_id = " + ecId;
        ArrayList<Exam> exams = new ArrayList();
        exams = getExams(ecId, query);
        String[] array = new String[exams.size()];
        for(int i=0; i<array.length; i++) {
            array[i]="Exam ID: " + exams.get(i).getEx_id() + " | Date: " + exams.get(i).getDate() + " | Time: " + exams.get(i).getTime();
        }
        return array;
    }
    
    public static String[] getTodayNonStartedExams(int ecId) {
        
        String query = "select * from exam where started = 0 AND ec_id = " + ecId + " AND date = curdate()";
        ArrayList<Exam> exams = new ArrayList();
        exams = getExams(ecId, query);
        String[] array = new String[exams.size()];
        for(int i=0; i<array.length; i++) {
            array[i]="Exam ID: " + exams.get(i).getEx_id() + " | Date: " + exams.get(i).getDate() + " | Time: " + exams.get(i).getTime();
        }
        return array;
    }
    
    
    
    
    public static ArrayList<Exam> getExams(int ecId, String query) {

        ArrayList<Exam> exams = new ArrayList();
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;

        String selectQuery = query;

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int exId = rs.getInt("ex_id");
                Date exDate = rs.getDate("date");
                Time exTime = rs.getTime("time");

                Exam exam = new Exam();

                exam.setEx_id(exId);
                exam.setDate(exDate);
                exam.setTime(exTime);
                exam.setStarted(0);
                exam.setEc_id(ecId);

                exams.add(exam);
            }

        } catch (SQLException ex) {
            System.out.println("Getting exams from database failed: An Exception has occurred!" + ex);
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


        return exams;

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

        String selectQuery = "select * from user where ex_id IS NULL AND admin=0";

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
    
    private static boolean addUserToExam(int uId, int exId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String updateQuery = "update user set ex_id = " + exId + " where u_id = " + uId;
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding user with Id " + uId
                    + " to exam with id " + exId
                    + "failed: An Exception has occurred!" + ex);
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
    
    public static boolean addUsersToExam(ArrayList<Integer> usersId, int exId) {
        boolean success = true;
        boolean tmp;
        for(int i=0; i<usersId.size(); i++) {
            int uId = usersId.get(i);
            tmp = addUserToExam(uId, exId);
            if(!tmp)
                success = false;
        }
        return success;
    }
    
    
    
}
