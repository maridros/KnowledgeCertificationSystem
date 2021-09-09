/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
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
@WebServlet(name = "RandomQuestionsServlet", urlPatterns = {"/RandomQuestionsServlet"})
public class RandomQuestionsServlet extends HttpServlet {
    
    
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
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;
        int count = 0;

        String countQuery = "select count(*) from questions";
        
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(countQuery);
            boolean found = rs.next();

            if (found) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Count questions failed: An Exception has occurred!" + ex);
            String error = "Error! Loading questions failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
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
        

        Question q = new Question();
        ArrayList<Question> qList = new ArrayList();
        ArrayList<Integer> qRow = new ArrayList();
        Integer tmp;
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            tmp = r.nextInt(count);
            while (qRow.contains(tmp)) {
                tmp = r.nextInt(count);
            }
            qRow.add(tmp);
            q = QuestionDAO.getQuestion(tmp);
            qList.add(q);
        }

        
        HttpSession session = request.getSession(false);
        try {
            if (session != null) {
                

                session.setAttribute("questions", qList);
                session.setAttribute("qNum", 0); //first question

                
                response.sendRedirect("exam.jsp"); 

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException ex) {
            System.out.println(ex);
            String error = "Error! Loading questions failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

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
