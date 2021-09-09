<%-- 
    Document   : exam
    Created on : Sep 5, 2018, 4:19:18 PM
    Author     : Maria
--%>

<%@page import="mypackage.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Exam Page</title>
    </head>
    <body style="margin: 10px">
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

        ArrayList qList = (ArrayList) session.getAttribute("questions");
        int i = (Integer) session.getAttribute("qNum");
        Question q = (Question) qList.get(i);
    %>
    <br><br>
    <center>
    <div style="width: fit-content; border: 8px solid #056868; border-radius: 20px 20px 20px 20px;
             padding: 50px;   background: #edf9f9; align-self: center">
    <h3> <%= q.getQuestion()%> </h3>
    <form action="ExamServlet">
        <table>
            <tr>
                <td style="background-color: #edf9f9;"><input type="radio" name="answer" value="1" checked> <%= q.getAnswer1()%></td>
            </tr>
            <tr>
                <td style="background-color: #edf9f9;"><input type="radio" name="answer" value="2"> <%= q.getAnswer2()%></td>
            </tr>
            <tr>
                <td style="background-color: #edf9f9;"><input type="radio" name="answer" value="3"> <%= q.getAnswer3()%></td>
            </tr>
            <tr>
                <td style="background-color: #edf9f9;"><input type="radio" name="answer" value="4"> <%= q.getAnswer4()%></td>
            </tr>
        
        </table>
        
        <br>
        <button type="submit" class="btn" style="margin: 5px" name="button" value="submitBtn" onclick="return confirm('Are you sure for your answer?');">Submit</button>
        <button type="submit" class="btn" style="margin: 5px" name="button" value="skipBtn">Skip</button>
    </form>
    </div>
    </center>
        


    <%
        }
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
