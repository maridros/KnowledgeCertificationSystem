/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int typeOfUser = Integer.parseInt(request.getParameter("u"));
        
        try {
            
            switch (typeOfUser) {
                case 1:
                    {
                        SysAdminBean user = new SysAdminBean();
                        user.setUname(request.getParameter("uname"));
                        user.setPass(request.getParameter("pass"));
                        user = SysAdminDAO.login(user);
                        if(user.isValid()) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("typeOfUser", 1);
                            session.setAttribute("currentSessionUser", user);
                            response.sendRedirect("sysAdminLogged.jsp"); //logged-in page
                        }
                        else {
                            response.sendRedirect("invalidLogin.jsp"); //failed login page
                        }       break;
                    }
                case 2:
                    {
                        AdminBean user = new AdminBean();
                        user.setUname(request.getParameter("uname"));
                        user.setPass(request.getParameter("pass"));
                        user = AdminDAO.login(user);
                        if(user.isValid()) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("typeOfUser", 2);
                            session.setAttribute("currentSessionUser", user);
                            response.sendRedirect("adminLogged.jsp"); //logged-in page
                        }
                        else {
                            response.sendRedirect("invalidLogin.jsp"); //failed login page
                        }       break;
                    }
                default:
                    {
                        UserBean user = new UserBean();
                        user.setUname(request.getParameter("uname"));
                        user.setPass(request.getParameter("pass"));
                        user = UserDAO.login(user);
                        if(user.isValid()) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("typeOfUser", 3);
                            session.setAttribute("currentSessionUser", user);
                            response.sendRedirect("userLogged.jsp"); //logged-in page
                        }
                        else {
                            response.sendRedirect("invalidLogin.jsp"); //failed login page
                        }       break;
                    }
            }
            
            
            
            
        } catch (IOException e) {
            System.out.println(e);
            String error = "Error! Login failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

}
