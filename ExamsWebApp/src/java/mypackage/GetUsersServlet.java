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
@WebServlet(name = "GetUsersServlet", urlPatterns = {"/GetUsersServlet"})
public class GetUsersServlet extends HttpServlet {
    
    
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
                    
                    int exId = Integer.parseInt(request.getParameter("exam"));
                    request.setAttribute("exam", exId);
                    ArrayList<UserBean> users = getUsers();
                    request.setAttribute("userslist", users);                  
                    request.getRequestDispatcher("selectUsers.jsp").forward(request, response);
                    
                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException | ServletException ex) {
            System.out.println(ex);
            String error = "Error! Loading users list failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

    }
    
    

    private ArrayList<UserBean> getUsers() {

        ArrayList<UserBean> users = new ArrayList();
        Connection currentCon = null;
        ResultSet rs = null;
        Statement stmt = null;

        String selectQuery = "select * from user where ex_id IS NULL AND admin=0";

        try {

            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int uId = rs.getInt("u_id");
                String name = rs.getString("name");
                String uname = rs.getString("uname");

                UserBean user = new UserBean();

                user.setU_id(uId);
                user.setName(name);
                user.setUname(uname);
                

                users.add(user);
            }

        } catch (SQLException ex) {
            System.out.println("Getting users from database failed: An Exception has occurred!" + ex);
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


        return users;

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
