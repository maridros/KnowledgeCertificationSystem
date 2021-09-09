<%-- 
    Document   : selectUsers
    Created on : Sep 8, 2018, 1:00:09 PM
    Author     : Maria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="mypackage.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Select Users Page</title>
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
    <br><br>
    <center>
        <%            ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("userslist");
            int exId = (Integer) request.getAttribute("exam");
            if (users.isEmpty()) {
        %>



        There are no users to add to exam,<br>
        because all users are already connected with an exam<br>
        or because there are no users<br><br>
        <a href="adminLogged.jsp">Return to menu</a>


        <%
        } else {

        %>

        <h2>Select Users for selected exam</h2>

        <%        UserBean user = users.get(0);

        %>

        <br>
        <form action="AddUsersToExamServlet">
            <table>
                <tr>
                    <th></th>
                    <th>User ID</th>
                    <th>Name</th> 
                    <th>Username</th>
                </tr>
                <tr>
                    <td><input type="checkbox" name="users" value="<%= user.getU_id()%>"></td>
                    <td><%= user.getU_id()%></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getUname()%></td>
                </tr>


                <%
                    for (int i = 1; i < users.size(); i++) {
                        user = users.get(i);
                %>

                <tr>
                    <td><input type="checkbox" name="users" value="<%= user.getU_id()%>"></td>
                    <td><%= user.getU_id()%></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getUname()%></td>
                </tr>

                <%
                    }

                %>
            </table>
            <input type="hidden" name="exid" value="<%=exId%>"/>
            <br>
            <input type="submit" class="btn" value="Submit">

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

    <%        }

    %>

</body>
</html>
