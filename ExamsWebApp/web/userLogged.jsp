<%-- 
    Document   : userLogged
    Created on : Sep 2, 2018, 5:58:49 PM
    Author     : Maria
--%>

<%@page import="mypackage.UserExamController"%>
<%@page import="mypackage.UserDAO"%>
<%@page import="mypackage.Exam"%>
<%@page import="mypackage.ExamDAO"%>
<%@page import="mypackage.UserBean"%>
<%@page import="mypackage.RandomQuestionsServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>User Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 3) {
        %>
        <br><br>
    <center>
        You are not logged in or you are not a registered user,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {
        UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));
    %>
    <div class="topnav">
        <a href="logout.jsp">Logout</a>
    </div>
    <center>
        <br><br>
        <div>
        
            <h1 style="color: #056868; text-shadow: 3px 2px #888888;">Welcome <%=currentUser.getName()%></h1><br>
        <%
            int exId = currentUser.getEx_id();
            Exam exam = null;
            boolean access = false;
            if (exId != 0) {
                exam = ExamDAO.getExam(exId);
                UserExamController uEC = new UserExamController();
                access = uEC.checkAccess(currentUser);
            }

            if (exam != null && exam.getStarted() == 1 && access == true) {
        %>

        <br><br>
        <center>
        <div style="width: fit-content; border: 2px solid #056868; border-radius: 10px 10px 10px 10px;
             padding: 20px;   background: #edf9f9; box-shadow: 5px 10px #888888; text-align: center">
        <a href="RandomQuestionsServlet"><b>Start exam</b></a>    
        </div>
        </center>

        <%
        } else if (access == false && exam != null) {
        %>

        <p>You have completed your exam.</p>
        <p>Good luck with your results!</p>

        <%
        } else {

        %>

        <p>
            Your exam isn't started yet.
        </p>

        <%                
            }

        %>
        </div>
    </center>

    <%            }
    } else {
    %>
    <br><br>
    <center>
        You are not logged in or you are not a registered user,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
        }

    %>

</body>
</html>
