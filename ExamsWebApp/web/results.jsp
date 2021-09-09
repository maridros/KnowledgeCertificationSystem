<%-- 
    Document   : results
    Created on : Sep 24, 2018, 4:22:58 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Results Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 1 && typeOfUser != 2) {
        %>
        <br><br>
    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>


    <%
    } else {

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

    <%        } else if (typeOfUser == 2) {

    %>

    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>

    <%        }

    %>
    <br><br>
    <center>
        <form action="ResultsServlet">
            <table>

                <tr>
                    <td><input type="radio" name="resulttype" value="1" checked></td>
                    <td>Get all results</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="radio" name="resulttype" value="2"></td>
                    <td>Get results of exam center with ID: </td>
                    <td><input type="number" name="ecid1"/></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="radio" name="resulttype" value="3"></td>
                    <td>Get results of exam center with ID: </td>
                    <td><input type="number" name="ecid2"/></td>
                    <td>in date: </td>
                    <td><input type="date" name="exdate"></td>
                </tr>
                <tr>
                    <td><input type="radio" name="resulttype" value="4"></td>
                    <td>Get results of user with ID: </td>
                    <td><input type="number" name="uid"/></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br>
            <input type="submit" class="btn" value="Submit">
        </form>

    </center>

    <%            }
    } else {
    %>
    <br><br>
    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>


    <%
        }

    %>
</body>
</html>
