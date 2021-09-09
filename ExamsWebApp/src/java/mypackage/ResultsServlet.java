/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maria
 */
public class ResultsServlet extends HttpServlet {

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
                if (typeOfUser == 1 || typeOfUser == 2) {
                    int resultType = Integer.parseInt(request.getParameter("resulttype"));
                    switch (resultType) {
                        case 1:
                            {
                                ExamCenterResults[] results = getAll();
                                request.setAttribute("results", results);
                                request.getRequestDispatcher("resultsAll.jsp").forward(request, response);
                                break;
                            }
                        case 2:
                            {
                                int ecId = 0;
                                String ecIdStr = request.getParameter("ecid1");
                                if(!(ecIdStr.equals("")))
                                    ecId = Integer.parseInt(request.getParameter("ecid1"));
                                ExamCenterResults results = getResultsByExamCenter(ecId, null);
                                request.setAttribute("results", results);
                                request.getRequestDispatcher("resultsByExamCenter.jsp").forward(request, response);
                                break;
                            }
                        case 3:
                            {
                                int ecId = 0;
                                String ecIdStr = request.getParameter("ecid2");
                                if(!(ecIdStr.equals("")))
                                    ecId = Integer.parseInt(request.getParameter("ecid2"));
                                String date = request.getParameter("exdate");
                                ExamCenterResults results = getResultsByExamCenter(ecId, date);
                                request.setAttribute("results", results);
                                request.getRequestDispatcher("resultsByExamCenter.jsp").forward(request, response);
                                break;
                            }
                        case 4:
                            {                                
                                int uId = 0;
                                String uIdStr = request.getParameter("uid");
                                if(!(uIdStr.equals("")))
                                    uId= Integer.parseInt(request.getParameter("uid"));
                                ExamCenterResults results = getResultsByUser(uId);
                                request.setAttribute("results", results);
                                request.getRequestDispatcher("resultsByUser.jsp").forward(request, response);
                                break;
                            }
                        default:
                            break;
                    }
                    
                    
                } else {
                    response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException | ServletException | NumberFormatException ex) {
            System.out.println(ex);
            String error = "Error! Loading results failed!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
        
        
        
    }
    
    
    
    //call web service from client to get all results
    private ExamCenterResults[] getAll() {
        
        ResultsClient client = new ResultsClient();
        String responce = client.getResults(String.class);
        Gson gson = new Gson();
        ExamCenterResults[] results = gson.fromJson(responce, ExamCenterResults[].class);
        client.close();
        return results;
    }
    
    //call web service from client to get results of an exam center (value of date = null)
    //or of an exam center in a specific date
    private ExamCenterResults getResultsByExamCenter(int ecid, String date) {
        ResultsClient client = new ResultsClient();
        String responce = client.getResultsByExamCenter(String.class, String.valueOf(ecid), date);
        Gson gson = new Gson();
        ExamCenterResults results = gson.fromJson(responce, ExamCenterResults.class);
        client.close();
        return results;
    }
    
    //call web service from client to get results of a specific user
    private ExamCenterResults getResultsByUser(int uid) {
        ResultsClient client = new ResultsClient();
        String responce = client.getResultsByUser(String.class, String.valueOf(uid));
        Gson gson = new Gson();
        ExamCenterResults results = gson.fromJson(responce, ExamCenterResults.class);
        client.close();
        return results;
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
