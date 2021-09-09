<%-- 
    Document   : uploadExcel
    Created on : Sep 9, 2018, 2:20:13 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Upload Excel File</title>
    </head>
    <body> 
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser == 1) {

        %>
        <div class="topnav">
            <a href="logout.jsp">Logout</a>
            <a href="addQuestions.jsp">Add questions manually</a>
            <a href="uploadExcel.jsp">Add questions from excel</a>
            <a href="addUsers.jsp">Add users</a>
            <a href="addExamCenter.jsp">Add exam center</a>
            <a href="GetExamCentersServlet">Add new exam</a>
            <a href="GetUsersAndExamCentersServlet">Add Admin to exam center</a>
            <a href="results.jsp">Results</a>
        </div>
    <center>
        <br><br>
        <h3>Excel File Upload:</h3>
        

        <form method="post" action="UploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"/> <br>

            <br>
            <input type="submit" class="btn" value="Upload" name="upload" id="upload" />
        </form>
    </center>



        <%        } else {
        %>
        <br><br>
    <center>
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
        }
    } else {

    %>
    <br><br>
    <center>
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%        }

    %>


</body>
</html>
