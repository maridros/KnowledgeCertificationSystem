<%-- 
    Document   : addExam
    Created on : Sep 25, 2018, 8:45:17 PM
    Author     : Maria
--%>

<%@page import="mypackage.ExamCenter"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }

            today = yyyy + '-' + mm + '-' + dd;
            document.getElementById("datefield").setAttribute("min", today);
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Add Exam Page</title>
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
        <%
            ArrayList<ExamCenter> examCenters = (ArrayList<ExamCenter>) request.getAttribute("examcenterslist");
            if (examCenters.isEmpty()) {
        %>

        There are no exam centers to add an exam.<br><br>

        <%
        } else {
            //long millis=System.currentTimeMillis(); 
            //String today = new java.sql.Date(millis).toString();

        %>
        <form action="AddExamServlet">
            <h2>Select Exam Center</h2>

            <select name="examcenter">
                <%                    for (int n = 0; n < examCenters.size(); n++) {
                        ExamCenter ec = examCenters.get(n);
                %>

                <option value="<%=ec.getEc_id()%>">ID: <%= ec.getEc_id()%>, Name: <%= ec.getName()%>, Address: <%= ec.getAddress()%></option>

                <%
                    }
                %>
            </select>
            <br><br>
            <h2>Add Exam</h2>
            <table>
                <tr>
                    <td><b>Date: </b></td>
                    <td><input type="date" id="datefield" name="exdate"></td>
                </tr>
                <tr>
                    <td><b>Time: </b></td>
                    <td><input type="time" name="extime"></td>
                </tr>
            </table>
            <br>
            <input type="submit" class="btn" value="Add">
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
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
        }

    %>
</body>
</html>
