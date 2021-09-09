<%-- 
    Document   : uploadErrorPage
    Created on : Sep 30, 2018, 3:18:51 PM
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
        <br><br>
    <center>
        <img src="images/error.png" width="50" height="50" title="error" />
        <br><br>
        Uploading questions was unsuccessful.<br>
        You may did not specify a file to upload or the file is wrong formated.
        <br>
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
