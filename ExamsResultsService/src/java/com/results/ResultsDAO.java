/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.results;

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
public class ResultsDAO {
    
    
    
    public static ExamCenterResults getResultsByUser(int uId) {
        
        ExamCenterResults results = new ExamCenterResults();
        int ecFlag = 0;
        int exFlag = 0;
        int exCnt = -1;
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        
        String selectQuery = "select user_answers.u_id, user.name, user.uname, "
                + "user_answers.ex_id, user_answers.user_log_id, "
                + "exam.ec_id, exam.date, exam.time, "
                + "exams_center.name, exams_center.address "
                + "from user_answers, user, exam, exams_center "
                + "where user_answers.u_id=user.u_id "
                + "and user_answers.ex_id=exam.ex_id "
                + "and exam.ec_id=exams_center.ec_id "
                + "and user_answers.u_id=" + uId
                + " order by exam.ec_id, user_answers.ex_id, user_answers.u_id";
        
        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                
                String userLogTable = rs.getString("user_log_id");
                String name = rs.getString(2);
                String uname = rs.getString("uname");
                int ecId = rs.getInt("ec_id");
                int exId = rs.getInt("ex_id");
                String date = rs.getDate("date").toString();
                String time = rs.getTime("time").toString();
                String ecName = rs.getString(9);
                String ecAddress = rs.getString("address");
                
                if(ecFlag != ecId) {
                    ecFlag = ecId;
                    results.setEc_id(ecId);
                    results.setName(ecName);
                    results.setAddress(ecAddress);
                    
                }
                
                if(exFlag != exId) {
                    exFlag = exId;
                    ExamResults exRes = new ExamResults();
                    exRes.setEx_id(exId);
                    exRes.setDate(date);
                    exRes.setTime(time);
                    results.getExamResults().add(exRes);
                    exCnt++;
                }
                
                UserResults uRes = new UserResults();
                uRes.setU_id(uId);
                uRes.setName(name);
                uRes.setUname(uname);
                
                
                
                
                
                Statement stmt1 = null;
                ResultSet rs1 = null;
                String selectULogQuery = "select * from " + userLogTable;
                stmt1 = currentCon.createStatement();
                rs1 = stmt1.executeQuery(selectULogQuery);
                ArrayList<ExamQuestion> questions = new ArrayList();
                while (rs1.next()) {
                    int qId = rs1.getInt("q_id");
                    int userAnswer = rs1.getInt("user_answer");
                    Date ans_date = rs1.getDate("ans_date");
                    Time ans_time = rs1.getTime("ans_time");
                    String ansDate = ans_date.toString();
                    String ansTime = ans_time.toString();
                    
                    ExamQuestion q = getQuestionById(qId);
                    
                    q.setuAnswer(userAnswer);
                    q.setuDate(ansDate);
                    q.setuTime(ansTime);
                    
                    questions.add(q);
                    
                    
                }
                
                uRes.setExamQuestions(questions);
                results.getExamResults().get(exCnt).getUserResults().add(uRes);
                
                
                
            }

        } catch (SQLException ex) {
            System.out.println("Getting results from database failed: An Exception has occurred!" + ex);
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
        
        
        return results;
        
    }
    
    
    
    public static ExamCenterResults getResultsByExamCenterAndDate(int ecId, String date) {
        
        ExamCenterResults results = new ExamCenterResults();
        int ecFlag = 0;
        int exFlag = 0;
        int exCnt = -1;
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        
        String selectQuery = "select user_answers.u_id, user.name, user.uname, "
                + "user_answers.ex_id, user_answers.user_log_id, "
                + "exam.ec_id, exam.date, exam.time, "
                + "exams_center.name, exams_center.address "
                + "from user_answers, user, exam, exams_center "
                + "where user_answers.u_id=user.u_id "
                + "and user_answers.ex_id=exam.ex_id "
                + "and exam.ec_id=exams_center.ec_id "
                + "and exam.ec_id=" + ecId
                + " and exam.date='" + date + "' "
                + "order by exam.ec_id, user_answers.ex_id, user_answers.u_id";
        
        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                
                String userLogTable = rs.getString("user_log_id");
                int uId = rs.getInt("u_id");
                String name = rs.getString(2);
                String uname = rs.getString("uname");
                int exId = rs.getInt("ex_id");
                //String date = rs.getDate("date").toString();
                String time = rs.getTime("time").toString();
                String ecName = rs.getString(9);
                String ecAddress = rs.getString("address");
                
                if(ecFlag != ecId) {
                    ecFlag = ecId;
                    results.setEc_id(ecId);
                    results.setName(ecName);
                    results.setAddress(ecAddress);
                    
                }
                
                if(exFlag != exId) {
                    exFlag = exId;
                    ExamResults exRes = new ExamResults();
                    exRes.setEx_id(exId);
                    exRes.setDate(date);
                    exRes.setTime(time);
                    results.getExamResults().add(exRes);
                    exCnt++;
                }
                
                UserResults uRes = new UserResults();
                uRes.setU_id(uId);
                uRes.setName(name);
                uRes.setUname(uname);
                
                
                
                
                
                Statement stmt1 = null;
                ResultSet rs1 = null;
                String selectULogQuery = "select * from " + userLogTable;
                stmt1 = currentCon.createStatement();
                rs1 = stmt1.executeQuery(selectULogQuery);
                ArrayList<ExamQuestion> questions = new ArrayList();
                while (rs1.next()) {
                    int qId = rs1.getInt("q_id");
                    int userAnswer = rs1.getInt("user_answer");
                    Date ans_date = rs1.getDate("ans_date");
                    Time ans_time = rs1.getTime("ans_time");
                    String ansDate = ans_date.toString();
                    String ansTime = ans_time.toString();
                    
                    ExamQuestion q = getQuestionById(qId);
                    
                    q.setuAnswer(userAnswer);
                    q.setuDate(ansDate);
                    q.setuTime(ansTime);
                    
                    questions.add(q);
                    
                    
                }
                
                uRes.setExamQuestions(questions);
                results.getExamResults().get(exCnt).getUserResults().add(uRes);
                
                
                
            }

        } catch (SQLException ex) {
            System.out.println("Getting results from database failed: An Exception has occurred!" + ex);
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
        
        
        return results;
        
    }
    
    
    
    
    public static ExamCenterResults getResultsByExamCenter(int ecId) {
        
        ExamCenterResults results = new ExamCenterResults();
        int ecFlag = 0;
        int exFlag = 0;
        int exCnt = -1;
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        
        String selectQuery = "select user_answers.u_id, user.name, user.uname, "
                + "user_answers.ex_id, user_answers.user_log_id, "
                + "exam.ec_id, exam.date, exam.time, "
                + "exams_center.name, exams_center.address "
                + "from user_answers, user, exam, exams_center "
                + "where user_answers.u_id=user.u_id "
                + "and user_answers.ex_id=exam.ex_id "
                + "and exam.ec_id=exams_center.ec_id "
                + "and exam.ec_id=" + ecId
                + " order by exam.ec_id, user_answers.ex_id, user_answers.u_id";
        
        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                
                String userLogTable = rs.getString("user_log_id");
                int uId = rs.getInt("u_id");
                String name = rs.getString(2);
                String uname = rs.getString("uname");
                int exId = rs.getInt("ex_id");
                String date = rs.getDate("date").toString();
                String time = rs.getTime("time").toString();
                String ecName = rs.getString(9);
                String ecAddress = rs.getString("address");
                
                if(ecFlag != ecId) {
                    ecFlag = ecId;
                    results.setEc_id(ecId);
                    results.setName(ecName);
                    results.setAddress(ecAddress);
                    
                }
                
                if(exFlag != exId) {
                    exFlag = exId;
                    ExamResults exRes = new ExamResults();
                    exRes.setEx_id(exId);
                    exRes.setDate(date);
                    exRes.setTime(time);
                    results.getExamResults().add(exRes);
                    exCnt++;
                }
                
                UserResults uRes = new UserResults();
                uRes.setU_id(uId);
                uRes.setName(name);
                uRes.setUname(uname);
                
                
                
                
                
                Statement stmt1 = null;
                ResultSet rs1 = null;
                String selectULogQuery = "select * from " + userLogTable;
                stmt1 = currentCon.createStatement();
                rs1 = stmt1.executeQuery(selectULogQuery);
                ArrayList<ExamQuestion> questions = new ArrayList();
                while (rs1.next()) {
                    int qId = rs1.getInt("q_id");
                    int userAnswer = rs1.getInt("user_answer");
                    Date ans_date = rs1.getDate("ans_date");
                    Time ans_time = rs1.getTime("ans_time");
                    String ansDate = ans_date.toString();
                    String ansTime = ans_time.toString();
                    
                    ExamQuestion q = getQuestionById(qId);
                    
                    q.setuAnswer(userAnswer);
                    q.setuDate(ansDate);
                    q.setuTime(ansTime);
                    
                    questions.add(q);
                    
                    
                }
                
                uRes.setExamQuestions(questions);
                results.getExamResults().get(exCnt).getUserResults().add(uRes);
                
                
                
            }

        } catch (SQLException ex) {
            System.out.println("Getting results from database failed: An Exception has occurred!" + ex);
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
        
        
        return results;
        
    }
    
    
    
    public static ArrayList<ExamCenterResults> getAllResults() {
        
        ArrayList<ExamCenterResults> results = new ArrayList();
        int ecFlag = 0;
        int exFlag = 0;
        int ecCnt = -1;
        int exCnt = -1;
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        
        String selectQuery = "select user_answers.u_id, user.name, user.uname, "
                + "user_answers.ex_id, user_answers.user_log_id, "
                + "exam.ec_id, exam.date, exam.time, "
                + "exams_center.name, exams_center.address "
                + "from user_answers, user, exam, exams_center "
                + "where user_answers.u_id=user.u_id "
                + "and user_answers.ex_id=exam.ex_id "
                + "and exam.ec_id=exams_center.ec_id "
                + "order by exam.ec_id, user_answers.ex_id, user_answers.u_id";
        
        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                
                String userLogTable = rs.getString("user_log_id");
                //String uIdStr = userLogTable.substring((userLogTable.lastIndexOf("_") + 1), userLogTable.length());
                //int uId = Integer.parseInt(uIdStr);
                int uId = rs.getInt("u_id");
                String name = rs.getString(2);
                String uname = rs.getString("uname");
                int exId = rs.getInt("ex_id");
                int ecId = rs.getInt("ec_id");
                String date = rs.getDate("date").toString();
                String time = rs.getTime("time").toString();
                String ecName = rs.getString(9);
                String ecAddress = rs.getString("address");
                
                if(ecFlag != ecId) {
                    ecFlag = ecId;
                    ExamCenterResults ecRes = new ExamCenterResults();
                    ecRes.setEc_id(ecId);
                    ecRes.setName(ecName);
                    ecRes.setAddress(ecAddress);
                    results.add(ecRes);
                    ecCnt++;
                    exCnt = -1;
                }
                
                if(exFlag != exId) {
                    exFlag = exId;
                    ExamResults exRes = new ExamResults();
                    exRes.setEx_id(exId);
                    exRes.setDate(date);
                    exRes.setTime(time);
                    results.get(ecCnt).getExamResults().add(exRes);
                    exCnt++;
                }
                
                UserResults uRes = new UserResults();
                uRes.setU_id(uId);
                uRes.setName(name);
                uRes.setUname(uname);
                
                
                
                
                
                Statement stmt1 = null;
                ResultSet rs1 = null;
                String selectULogQuery = "select * from " + userLogTable;
                stmt1 = currentCon.createStatement();
                rs1 = stmt1.executeQuery(selectULogQuery);
                //int flag = 0;
                //int ex_id = 0;
                ArrayList<ExamQuestion> questions = new ArrayList();
                while (rs1.next()) {
                    /*
                    if(flag == 0) {
                        ex_id = rs1.getInt("ex_id");
                        flag = 1;
                    }
                    */
                    int qId = rs1.getInt("q_id");
                    int userAnswer = rs1.getInt("user_answer");
                    Date ans_date = rs1.getDate("ans_date");
                    Time ans_time = rs1.getTime("ans_time");
                    String ansDate = ans_date.toString();
                    String ansTime = ans_time.toString();
                    
                    ExamQuestion q = getQuestionById(qId);
                    
                    q.setuAnswer(userAnswer);
                    q.setuDate(ansDate);
                    q.setuTime(ansTime);
                    
                    questions.add(q);
                    
                    
                }
                
                uRes.setExamQuestions(questions);
                results.get(ecCnt).getExamResults().get(exCnt).getUserResults().add(uRes);
                
                
                
            }

        } catch (SQLException ex) {
            System.out.println("Getting results from database failed: An Exception has occurred!" + ex);
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
        
        
        return results;
        
    }
    
    private static ExamQuestion getQuestionById(int qId) {
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        ExamQuestion q = new ExamQuestion();
        
        String searchQuery = "select * from questions where q_id=" + qId;
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean found = rs.next();
            
            if(!found) {
                System.out.println("Error getting question with ID " + qId + "!");
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
}
