<%-- 
    Document   : logginForm
    Created on : Sep 2, 2018, 2:57:28 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="mypackage.LoginServlet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login Page</title>
    </head>
    <body>
        <%

            String typeOfUser = request.getParameter("typeofuser");

        %>
        <br><br>
    <center>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>Please enter your username:</td>
                    <td><input type="text" name="uname" required/></td>
                </tr>
                <tr>
                    <td>Please enter your password:</td>
                    <td><input type="password" name="pass" required/></td>
                </tr>
            </table>
            <br><br>

            <input type="hidden" name="u" value="<%=typeOfUser%>"/>

            <input type="submit" class="btn" value="Submit">

        </form>
    </center>
</body>
</html>
