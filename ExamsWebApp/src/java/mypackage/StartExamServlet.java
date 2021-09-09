/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "StartExamServlet", urlPatterns = {"/StartExamServlet"})
public class StartExamServlet extends HttpServlet {
    
    
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
                int exId = Integer.parseInt(request.getParameter("exam"));
                if(startExam(exId)) {
                    response.sendRedirect("examStarted.jsp?exid=" + exId);
                } else {
                    String error = "Error! Starting exam failed!";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                }
                    
            } else {
                response.sendRedirect("index.jsp");
            }
            
        } catch (IOException ex) {
            System.out.println(ex);
            String error = "Error! Starting exam failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

    }

    
    
    private boolean startExam(int exId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;
        
        String updateQuery = "update exam set started = 1 where ex_id = " + exId;
        
        try {
            
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);
            
        } catch (SQLException ex) {
            System.out.println("Starting exam with id " + exId + "failed: An Exception has occurred!" + ex);
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
