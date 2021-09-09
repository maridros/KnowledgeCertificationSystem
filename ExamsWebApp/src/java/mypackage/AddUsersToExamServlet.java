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
@WebServlet(name = "AddUsersToExamServlet", urlPatterns = {"/AddUsersToExamServlet"})
public class AddUsersToExamServlet extends HttpServlet {

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

                    int exId = Integer.parseInt(request.getParameter("exid"));
                    int uId = 0;
                    UserBean user = new UserBean();
                    ArrayList<UserBean> users = new ArrayList();
                    boolean errorflag = false;
                    String error = "";

                    String select[] = request.getParameterValues("users");
                    if (select != null && select.length != 0) {

                        for (int i = 0; i < select.length; i++) {
                            uId = Integer.parseInt(select[i]);
                            if (addUserToExam(uId, exId)) {
                                user = UserDAO.getUserById(uId);
                                users.add(user);
                            } else {
                                errorflag = true;
                                error += "Adding user with Id " + uId
                                        + " to exam with id " + exId
                                        + "failed! \n";
                            }

                        }

                    }

                    if (errorflag == true) {
                        request.setAttribute("error", error);
                        request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                    } else {
                        request.setAttribute("userslist", users);
                        request.setAttribute("exid", exId);
                        request.getRequestDispatcher("usersAdded.jsp").forward(request, response);
                    }

                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (IOException | ServletException ex) {
            System.out.println(ex);
            String error = "Error! Adding users to exam failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private boolean addUserToExam(int uId, int exId) {
        Connection currentCon = null;
        Statement stmt = null;
        boolean success = true;

        String updateQuery = "update user set ex_id = " + exId + " where u_id = " + uId;

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);

        } catch (SQLException ex) {
            System.out.println("Adding user with Id " + uId
                    + " to exam with id " + exId
                    + "failed: An Exception has occurred!" + ex);
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
