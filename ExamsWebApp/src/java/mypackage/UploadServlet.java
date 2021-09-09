/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Maria
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    
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
        
        //check session
        HttpSession session = request.getSession(false);
        if(session == null) {
            response.sendRedirect("index.jsp");
            return;
        } else {
            int typeOfUser = (Integer) session.getAttribute("typeOfUser");
            if(typeOfUser!=1) {
                response.sendRedirect("index.jsp");
                return;
            }
        }
        
        
        // Create path components to save the file
        final String path = "C:\\Users\\Maria\\Desktop\\data"; //destination
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
                if(getQuestionsFromExcel(path, fileName)) {
                    response.sendRedirect("uploadSuccessPage.jsp");
                } else {
                    response.sendRedirect("uploadErrorPage.jsp");
                }
                
                
            
            
            
        } catch (FileNotFoundException fne) {
            System.out.println(fne);
            response.sendRedirect("uploadErrorPage.jsp");
            
            
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }

    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    
    private boolean getQuestionsFromExcel(String path, String fileName) {
        
        String file = path + "\\" + fileName;
        boolean success = true;
        
        
        ArrayList<Question> questions = new ArrayList();
        int tmp;
        
        try {

            FileInputStream excelFile = new FileInputStream(new File(file));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            
            Row currentRow = iterator.next();

            while (iterator.hasNext()) {

                currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Question q = new Question();

                
                
                for(int i=0; i<6; i++) {

                    Cell currentCell = cellIterator.next();
                    
                    if(i==0)
                        q.setQuestion(currentCell.getStringCellValue());
                    else if(i==1)
                        q.setAnswer1(currentCell.getStringCellValue());
                    else if(i==2)
                        q.setAnswer2(currentCell.getStringCellValue());
                    else if(i==3)
                        q.setAnswer3(currentCell.getStringCellValue());
                    else if(i==4)
                        q.setAnswer4(currentCell.getStringCellValue());
                    else if(i==5) {
                        tmp = (int) (currentCell.getNumericCellValue());
                        q.setCorrect(tmp);
                    }
                    
                        
                    
                }
                
                
                
                questions.add(q);
                System.out.println();

            }
            
            workbook.close();
            excelFile.close();
            
        } catch (IOException e) {
            System.out.println(e);
            success = false;
            
        } 
        
        if(success == true) {
            success = passQuestionsToDB(questions);
        }
        
        //deleteFile(file);
        return success;
        
    }
    
    private boolean passQuestionsToDB(ArrayList<Question> questions) {
        boolean success = true;
        if(questions.isEmpty()) {
            System.out.println("No questions found in file!");
            success = false;
        } else {
            for (int i=0; i<questions.size(); i++) {
                QuestionDAO.addQuestion(questions.get(i));
            }
        }
        
        return success;
        
    }
    /*
    private void deleteFile(String filePath) {
        File file = new File(filePath);
        if(file.delete())
            System.out.println("File " + filePath + " deleted");
        else
            System.out.println("File " + filePath + " deleting failled");
    }
    */
    
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
