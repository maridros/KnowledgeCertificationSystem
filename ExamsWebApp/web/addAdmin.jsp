<%-- 
    Document   : addAdmin
    Created on : Sep 21, 2018, 11:33:16 PM
    Author     : Maria
--%>

<%@page import="mypackage.ExamCenter"%>
<%@page import="mypackage.UserBean"%>
<%@page import="java.util.ArrayList"%>
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

    %>

    <center>
        <%            ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("userslist");
            if (users.isEmpty()) {
        %>


        <br><br>
        There are no users to add to exam,<br>
        because all users are already connected with an exam<br>
        or because there are no users.<br><br>
        


        <%
        } else {
            ArrayList<ExamCenter> examCenters = (ArrayList<ExamCenter>) request.getAttribute("examcenterslist");
            if (examCenters.isEmpty()) {

        %>
        <br><br>
        There are no exam centers to add an admin.<br><br>


        <%        } else {
            UserBean user = users.get(0);

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
        <form action="AddAdminToExamCenterServlet">

            <h2>Select Exam Center</h2>

            <select name="examcenter">
                <%                    
                    for (int n = 0; n < examCenters.size(); n++) {
                        ExamCenter ec = examCenters.get(n);
                %>

                <option value="<%=ec.getEc_id()%>">ID: <%= ec.getEc_id()%>, Name: <%= ec.getName()%>, Address: <%= ec.getAddress()%></option>

                <%
                    }
                %>

            </select>
            <br><br>

            <h2>Select Admin from users</h2>

            <table>
                <tr>
                    <th></th>
                    <th>User ID</th>
                    <th>Name</th> 
                    <th>Username</th>
                </tr>
                <tr>
                    <td><input type="radio" name="user" value="<%= user.getU_id()%>" checked></td>
                    <td><%= user.getU_id()%></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getUname()%></td>
                </tr>


                <%
                    for (int i = 1; i < users.size(); i++) {
                        user = users.get(i);
                %>

                <tr>
                    <td><input type="radio" name="user" value="<%= user.getU_id()%>"></td>
                    <td><%= user.getU_id()%></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getUname()%></td>
                </tr>

                <%
                    }

                %>
            </table>

            <br>
            <input type="submit" class="btn" value="Submit">

        </form>

        <%            }
        %>
    </center>
    <br>

    <%
        }
    %>

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
