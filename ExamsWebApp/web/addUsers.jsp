<%-- 
    Document   : addUsers
    Created on : Sep 10, 2018, 9:18:04 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script>
            function myFunction() {
                var pass1 = document.getElementById("pass1").value;
                var pass2 = document.getElementById("pass2").value;
                var ok = true;
                if (pass1 !== pass2) {
                    alert("Passwords Do not match");
                    document.getElementById("pass1").style.borderColor = "#E34234";
                    document.getElementById("pass2").style.borderColor = "#E34234";
                    ok = false;
                } 
                return ok;
            }
        </script>
        <title>Add Users Page</title>
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
        <h2>Add new User:</h2>
        <form action="AddUsersServlet" method="post" onsubmit="return myFunction()">
            <table>

                <tr>
                    <td><b>Name:</b></td>
                    <td><input type="text" name="name" required/></td>
                </tr>

                <tr>
                    <td><b>Username:</b></td>
                    <td><input type="text" name="uname" required/></td>
                </tr>
                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" id="pass1" name="pass" required/></td>
                </tr>
                <tr>
                    <td><b>Password Confirm:</b></td>
                    <td><input type="password" id="pass2" name="pass1" required/></td>
                </tr>

            </table>

            <br>
            <input type="submit" class="btn" value="Add">

        </form>
    </center>
    <br>

    <%                }
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
