<%-- 
    Document   : usersAdded
    Created on : Sep 8, 2018, 7:11:55 PM
    Author     : Maria
--%>

<%@page import="mypackage.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Users added to exam</title>
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
    %>

    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>
    <br><br>
    <center>
        <%
            ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("userslist");
            int exId = (Integer) request.getAttribute("exid");
            if (users.isEmpty()) {
        %>

        <h2>No users were added.</h2>

        <%
        } else {
            UserBean user = new UserBean();
        %>

        <h2>The following users were added to exam with ID = <%= exId%>: </h2>
        <br>
        <table>
            <tr>
                <th>User ID</th>
                <th>Name</th> 
                <th>Username</th>
            </tr>
            <%
                for (int i = 0; i < users.size(); i++) {
                    user = users.get(i);
            %>

            <tr>
                <td><%= user.getU_id()%></td>
                <td><%= user.getName()%></td>
                <td><%= user.getUname()%></td>
            </tr>



            <%
                }
            %>
        </table>




        <%
            }
        %>
        <br>
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
