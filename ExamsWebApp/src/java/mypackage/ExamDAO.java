/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;



/**
 *
 * @author Maria
 */
public class ExamDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static Exam getExam(int exId) {
        Statement stmt = null;
        Exam ex = new Exam();
        
        String searchQuery = "select * from exam where ex_id=" + exId;
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                System.out.println("Error getting exam with id = " + exId + "!");
            }
            else if(found) {
                Date d = rs.getDate("date");
                Time t = rs.getTime("time");
                int ec_id = rs.getInt("ec_id");
                int started = rs.getInt("started");
                
                ex.setEx_id(exId);
                ex.setDate(d);
                ex.setTime(t);
                ex.setEc_id(ec_id);
                ex.setStarted(started);
            }
        } catch (SQLException e) {
            System.out.println("Storing Question failed: An Exception has occurred!" + e);
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
        
        
        return ex;
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
