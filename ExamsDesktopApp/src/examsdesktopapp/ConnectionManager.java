/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsdesktopapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maria
 */
public class ConnectionManager {
    
    static Connection con;
    static String db;
    
    public static Connection getConnection() {
        try {
            String db = "jdbc:mysql://localhost:3306/examsdata";
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                con = DriverManager.getConnection(db, "root", "");
                
            } catch(SQLException ex) {
               ex.printStackTrace();
            } 
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        return con;

    }
}
