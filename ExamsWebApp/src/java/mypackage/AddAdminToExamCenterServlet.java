/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maria
 */
public class AddAdminToExamCenterServlet extends HttpServlet {

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
                if (typeOfUser == 1) {

                    int ecId = Integer.parseInt(request.getParameter("examcenter"));
                    int uId = Integer.parseInt(request.getParameter("user"));
                    UserBean admin = UserDAO.getUserById(uId);
                    if (addAdmin(admin, ecId)) {
                        String msg = "New admin, " + admin.getName() + ", was added as administrator of exam center with ID "
                                + ecId + ".";

                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("adminAdded.jsp").forward(request, response);
                    } else {
                        String error = "Error! Adding new admin failed!";
                        request.setAttribute("error", error);
                        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                    }

                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (IOException | ServletException ex) {
            System.out.println(ex);
            String error = "Error! Adding new admin failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

    }

    private boolean addAdmin(UserBean user, int ecId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;

        String updateQuery = "update user set admin=1, ec_id=" + ecId + " where u_id=" + user.getU_id();

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);

        } catch (SQLException ex) {
            System.out.println("Adding new admin, " + user.getUname() + ", failed: An Exception has occurred!" + ex);
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
