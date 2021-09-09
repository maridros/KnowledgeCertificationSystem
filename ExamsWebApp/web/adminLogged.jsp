<%-- 
    Document   : adminLogged
    Created on : Sep 6, 2018, 3:48:46 PM
    Author     : Maria
--%>

<%@page import="mypackage.AdminBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Admin Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 2) {
        %>
        <br><br>
    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {
        AdminBean currentUser = (AdminBean) (session.getAttribute("currentSessionUser"));
    %>
    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>
    <center>
        <br><br>
        <h2>Welcome <%=currentUser.getUname()%></h2>
    </center> 


    <%
        }
    } else {

    %>
    <br><br>
    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%        }


    %>

</body>
</html>
