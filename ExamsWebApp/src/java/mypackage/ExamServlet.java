/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maria
 */
@WebServlet(name = "ExamServlet", urlPatterns = {"/ExamServlet"})
public class ExamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        try {
            if (session != null) {
                String button = request.getParameter("button");
                int i = (Integer) session.getAttribute("qNum");
                ArrayList<Question> qList = (ArrayList) session.getAttribute("questions");
                UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser");

                if ("submitBtn".equals(button)) {
                    int uAns = Integer.parseInt(request.getParameter("answer"));
                    qList.get(i).setuAnswer(uAns);
                    Time t = java.sql.Time.valueOf(LocalTime.now());
                    long millis = System.currentTimeMillis();
                    Date d = new java.sql.Date(millis);
                    qList.get(i).setuTime(t);
                    qList.get(i).setuDate(d);
                    session.setAttribute("questions", qList);

                }

                //find next question
                int j = i + 1;
                int answer = -1;
                while (j < 5 && answer != 0) {
                    answer = qList.get(j).getuAnswer();
                    j++;
                }

                if (answer != 0) {
                    j = 0;
                    while (j < i + 1 && answer != 0) {
                        answer = qList.get(j).getuAnswer();
                        j++;
                    }
                }

                if (answer != 0) {

                    int uId = currentUser.getU_id();
                    String uname = currentUser.getUname();
                    int exId = currentUser.getEx_id();
                    String logId = "log_" + uname + "_" + uId;
                    if (createUserLog(logId, uId, exId, qList)) {
                        response.sendRedirect("userLogged.jsp");
                    } else {
                        String error = "Error! Storing answers of exam failed!";
                        request.setAttribute("error", error);
                        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                    }

                } else {
                    j--;
                    session.setAttribute("qNum", j);
                    response.sendRedirect("exam.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException ex) {
            System.out.println(ex);
            String error = "Error! Loading exam and storing answers failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private boolean createUserLog(String logId, int uId, int exId, ArrayList<Question> qList) {
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        Statement stmt3 = null;
        boolean success = true;
        boolean tmp = true;

        String createQuery = "create table " + logId + "(ua_id int(10) unsigned NOT NULL AUTO_INCREMENT, "
                + "q_id int(10) unsigned NOT NULL, "
                + "user_answer int(10) unsigned NOT NULL, "
                + "ans_date date NOT NULL, "
                + "ans_time time NOT NULL, "
                + "PRIMARY KEY(ua_id))";

        String selectQuery = "select * from user_answers where user_log_id = '" + logId + "'";
        String insertQuery = "insert into user_answers (user_log_id, u_id, ex_id) values ('" + logId + "', "
                + uId + ", " + exId + ")";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt1 = currentCon.createStatement();
            rs = stmt1.executeQuery(selectQuery);
            boolean found = rs.next();
            if (!found) {
                stmt2 = currentCon.createStatement();
                stmt2.executeUpdate(insertQuery);
                stmt3 = currentCon.createStatement();
                stmt3.executeUpdate(createQuery);
            }

        } catch (SQLException ex) {
            System.out.println("Creating user log failed: An Exception has occurred!" + ex);
            success = false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                stmt1 = null;
                stmt2 = null;
                stmt3 = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {
                }
                currentCon = null;
            }
        }
        if (success) {
            for (int i = 0; i < 5; i++) {
                tmp = updateUserAnswers(qList.get(i), logId);
                if (!tmp) {
                    success = false;
                }
            }
            if(success) {
                success = createLogFile(logId, uId, exId, qList);
            }

        }

        return success;
    }

    private boolean updateUserAnswers(Question q, String logId) {
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        boolean success = true;

        String insertQuery = "insert into " + logId + " (q_id, user_answer, ans_date, ans_time) "
                + "values (" + q.getQ_id() + ", " + q.getuAnswer() + ", '"
                + q.getuDate() + "', '" + q.getuTime() + "')";

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(insertQuery);

        } catch (SQLException ex) {
            System.out.println("Adding user answer failed: An Exception has occurred!" + ex);
            success = false;
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

        return success;
    }

    private boolean createLogFile(String logId, int uId, int exId, ArrayList<Question> qList) {
        PrintWriter writer = null;
        String filename = "C:/Users/Maria/Desktop/logFiles/"+ logId +".txt";
        boolean success = true;
        try {
            
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("================================================================");
            writer.println("User ID: " + uId);
            writer.println("Exam ID: " + exId);
            writer.println("================================================================");
            writer.println("Questions:");
            writer.println("----------------------------------------------------------------");
            for(int i=0; i<qList.size(); i++) {
                Question q = qList.get(i);
                writer.println("Question ID: " + q.getQ_id());
                writer.println(q.getQuestion());
                writer.println("1. " + q.getAnswer1());
                writer.println("2. " + q.getAnswer2());
                writer.println("3. " + q.getAnswer3());
                writer.println("4. " + q.getAnswer4());
                writer.println("Correct: " + q.getCorrect());
                writer.println("User answer: " + q.getuAnswer() + " (Date: " + q.getuDate() + ", Time: " + q.getuTime() + ")");
                writer.println("----------------------------------------------------------------");
            }
            writer.close();
            
        } catch (IOException ex) {
            System.out.println(ex);
            success = false;
        }  finally {
            writer.close();
        }
        return success;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
