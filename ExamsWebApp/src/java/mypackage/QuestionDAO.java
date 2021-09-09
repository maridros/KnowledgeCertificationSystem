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
public class QuestionDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public static Question getQuestion(int offset) {
        Statement stmt = null;
        Question q = new Question();
        
        String searchQuery = "select * from questions order by q_id limit 1 offset " + offset;
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                System.out.println("Error getting question in row " + (offset + 1) + "!");
            }
            else if(found) {
                int q_id = rs.getInt("q_id");
                String question = rs.getString("question");
                String answer1 = rs.getString("answer1");
                String answer2 = rs.getString("answer2");
                String answer3 = rs.getString("answer3");
                String answer4 = rs.getString("answer4");
                int correct = rs.getInt("correct");
                
                q.setQ_id(q_id);
                q.setQuestion(question);
                q.setAnswer1(answer1);
                q.setAnswer2(answer2);
                q.setAnswer3(answer3);
                q.setAnswer4(answer4);
                q.setCorrect(correct);
                q.setuAnswer(0); //IT ISN'T ANSWERED YET FROM USER
            }
        } catch (SQLException ex) {
            System.out.println("Storing Question failed: An Exception has occurred!" + ex);
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
        
        return q;
    }
    
    
    public static boolean addQuestion(Question q) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String insertQuery = "insert into questions (question, answer1, answer2, answer3, answer4, correct)"
                + "values ('" + q.getQuestion() + "', '" + q.getAnswer1() + "', '" + q.getAnswer2() + 
                "', '" + q.getAnswer3() + "', '" + q.getAnswer4() + "', " + q.getCorrect() + ")";
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(insertQuery);
            
        } catch (SQLException ex) {
            System.out.println("Adding new question failed: An Exception has occurred!" + ex);
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
