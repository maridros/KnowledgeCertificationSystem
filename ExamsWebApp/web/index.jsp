<%-- 
    Document   : index
    Created on : Sep 4, 2018, 2:21:32 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Start Page</title>
    </head>
    <body>
    <center>
        <br><br>
        <div style="width: fit-content; border: 8px solid #056868; border-radius: 10px 10px 10px 10px;
             padding: 20px;   background: #edf9f9; text-align: center" >
            <br>
            <a href="logginForm.jsp?typeofuser=1">Login as System Administrator</a><br>
        <br><hr><br>
        <a href="logginForm.jsp?typeofuser=2">Login as exams center Administrator</a><br>
        <br><hr><br>
        <a href="logginForm.jsp?typeofuser=3">Login as User</a>
        <br>
        </div>
    </center>
    </body>
</html>
