/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
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
@WebServlet(name = "GetExamsServlet", urlPatterns = {"/GetExamsServlet"})
public class GetExamsServlet extends HttpServlet {
    
    
    
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

                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser == 2) {

                    AdminBean admin = (AdminBean) session.getAttribute("currentSessionUser");
                    int ecId = admin.getEc_id();
                    int type = Integer.parseInt(request.getParameter("type"));
                    request.setAttribute("type", type);
                    String query = "";
                    if(type==1) {
                        query = "select * from exam where started = 0 AND ec_id = " + ecId + " AND date = curdate()";
                    } else {
                        query = "select * from exam where started = 0 AND ec_id = " + ecId;
                    }
                    ArrayList<Exam> exams = getExams(ecId, query);
                    request.setAttribute("examslist", exams);                  
                    request.getRequestDispatcher("selectExam.jsp").forward(request, response);
                    
                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException | ServletException ex) {
            System.out.println(ex);
            String error = "Error! Loading exams list failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

    }
    

    private ArrayList<Exam> getExams(int ecId, String query) {

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
