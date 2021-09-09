<%-- 
    Document   : adminAdded
    Created on : Sep 22, 2018, 2:37:21 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Add Admin Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 1) {
        %>
        <br><br>
    <center>
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {
        String message = (String) request.getAttribute("message");

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
        <h2><%=message%></h2>

        <br>
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
