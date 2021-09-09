<%-- 
    Document   : selectExam
    Created on : Sep 8, 2018, 11:16:46 AM
    Author     : Maria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="mypackage.Exam"%>
<%@page import="mypackage.StartExamServlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Select Exam Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 2) {
        %>

    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {

    %>
    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>

    <center>
        <br><br>
        <%            ArrayList<Exam> exams = (ArrayList<Exam>) request.getAttribute("examslist");
            int type = (Integer) request.getAttribute("type");
            if (exams.isEmpty()) {
        %>


        <%
            if (type == 1) {
        %>

        There are no exams to get started.<br>

        <%
        } else {
        %>

        There are no exams to add users.<br>


        <%
            }
        %>


        <%
        } else {
            String callServlet = "";
            String submitValue = "";
            if (type == 1) {
                callServlet = "StartExamServlet";
                submitValue = "Start";
        %>

        <h2>Select Exam to start</h2>

        <%
        } else {
            callServlet = "GetUsersServlet";
            submitValue = "Select";
        %>

        <h2>Select Exam to add users</h2>

        <%
            }
            Exam exam = exams.get(0);
        %>
        <br>
        <form action=<%= callServlet%>>
            <table>
                <tr>
                    <th></th>
                    <th>Exam ID</th>
                    <th>Date</th> 
                    <th>Time</th>
                </tr>
                <tr>
                    <td><input type="radio" name="exam" value="<%= exam.getEx_id()%>" checked></td>
                    <td><%= exam.getEx_id()%></td>
                    <td><%= exam.getDate()%></td>
                    <td><%= exam.getTime()%></td>
                </tr>


                <%
                    for (int i = 1; i < exams.size(); i++) {
                        exam = exams.get(i);
                %>

                <tr>
                    <td><input type="radio" name="exam" value="<%= exam.getEx_id()%>"></td>
                    <td><%= exam.getEx_id()%></td>
                    <td><%= exam.getDate()%></td>
                    <td><%= exam.getTime()%></td>
                </tr>
                <%
                    }

                %> 

            </table>

            <br>
            <input type="submit" class="btn" value=<%= submitValue%>>
        </form>



        <%
            }
        %>

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

    <%
        }

    %>

</body>
</html>
