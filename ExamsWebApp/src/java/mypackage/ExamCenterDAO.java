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
public class ExamCenterDAO {

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
    
    
    public static ArrayList<ExamCenter> getExamCenters() {

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
    
    
    
    
}
