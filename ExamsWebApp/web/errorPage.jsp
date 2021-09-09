<%-- 
    Document   : errorPage
    Created on : Sep 29, 2018, 5:28:47 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 1 && typeOfUser != 2 && typeOfUser != 3) {
        %>
        <br><br>
    <center>
        You are not logged in,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {
        String error = (String) request.getAttribute("error");
        if(typeOfUser == 1) {

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
    
    
    <%

    } else if(typeOfUser == 2) {

    %>
    
    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>
    
    <%

    } else if (typeOfUser == 3) {

    %>
    
    <div class="topnav">
        <a href="logout.jsp">Logout</a>
    </div>
    
    <%

    }

    %>
    
    <br><br>
    <center>
        <img src="images/error.png" width="50" height="50" title="error" />
        <br><br>
        <pre><%=error%></pre>
        <br>
    </center>


    <%

        }
    } else {

    %>
    <br><br>
    <center>
        You are not logged in,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%        }

    %>
    </body>
</html>
