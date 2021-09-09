<%-- 
    Document   : addExamCenter
    Created on : Sep 10, 2018, 10:47:18 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Add Exam Center Page</title>
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
        <h2>Add new exam center:</h2>

        <form action="addExamCenterServlet">
            <table>

                <tr>
                    <td><b>Name of Exam Center:</b></td>
                    <td><textarea rows="1" cols="50" name="name" required></textarea></td>
                </tr>

                <tr>
                    <td><b>Address of Exam Center:</b></td>
                    <td><textarea rows="2" cols="50" name="address" required></textarea></td>
                </tr>

            </table>

            <br>
            <input type="submit"  class="btn" value="Add">

        </form>
    </center>
    <br>

    <%
        }
    } else {
    %>
    <br><br>
    <center>
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
        }

    %>
</body>
</html>
