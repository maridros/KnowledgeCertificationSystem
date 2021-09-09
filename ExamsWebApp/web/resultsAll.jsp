<%-- 
    Document   : resultsAll
    Created on : Sep 25, 2018, 8:45:26 AM
    Author     : Maria
--%>

<%@page import="mypackage.ExamQuestion"%>
<%@page import="mypackage.UserResults"%>
<%@page import="mypackage.ExamResults"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypackage.ExamCenterResults"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/results.css" rel="stylesheet" type="text/css"/>
        <title>Results Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("typeOfUser") != null) {
                int typeOfUser = (Integer) session.getAttribute("typeOfUser");
                if (typeOfUser != 1 && typeOfUser != 2) {
        %>
        <br><br>
    <center>
        You are not logged in or you are not Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%
    } else {

        if (typeOfUser == 1) {

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

    <%        } else if (typeOfUser == 2) {

    %>

    <div class="topnav">
        <a href="logout.jsp">Logout</a>
        <a href="GetExamsServlet?type=1">Start exam</a>
        <a href="GetExamsServlet?type=2">Add users to exam</a>
        <a href="results.jsp">Results</a>
    </div>

    <%        }
    %>
    
    <center>
        <div class="title">
            <br><br>
        <h2>Results:</h2>
        <br>
        </div>

        <%
            ExamCenterResults[] results = (ExamCenterResults[]) request.getAttribute("results");
            for (int i = 0; i < results.length; i++) {
        %>
        <div class="results">
            <br>
        <b>Exam Center Informations:</b><br>
        ID: <%= results[i].getEc_id()%>, Name: <%= results[i].getName()%>, Address: <%= results[i].getAddress()%><br>
        <br>
        </div>
        
        <%
            ArrayList<ExamResults> exRes = results[i].getExamResults();
            for (int j = 0; j < exRes.size(); j++) {
        %>
        <div class="exresults">
            <br>
        <b>Exam informations:</b><br>
        ID: <%= exRes.get(j).getEx_id()%>, Date: <%= exRes.get(j).getDate()%>, Time: <%= exRes.get(j).getTime()%><br><br>
        </div>
        <%
            ArrayList<UserResults> uRes = exRes.get(j).getUserResults();
            for (int n = 0; n < uRes.size(); n++) {

        %>
        <br>
        <h3>Result <%= n+1 %> of exam with ID <%= exRes.get(j).getEx_id() %></h3>
        <table>
            <tr>
                <td><b style="font-size: 18px">User Informations:</b></td>
                <td><b style="font-size: 18px">ID: <%= uRes.get(n).getU_id()%>, Name: <%= uRes.get(n).getName()%>, Username: <%= uRes.get(n).getUname()%></b></td>
            </tr>
            <tr>
                <td><h3>Questions:</h3></td>
                <td></td>
            </tr>
            <%
                ArrayList<ExamQuestion> q = uRes.get(n).getExamQuestions();
                for (int w = 0; w < q.size(); w++) {
            %>

            <tr>
                <td><b>Question ID:</b></td>
                <td><%= q.get(w).getQ_id()%></td>
            </tr>
            <tr>
                <td><b>Question:</b></td>
                <td><%= q.get(w).getQuestion()%></td>    
            </tr>
            <tr>
                <td></td>
                <td>1. <%= q.get(w).getAnswer1()%></td>    
            </tr>
            <tr>
                <td></td>
                <td>2. <%= q.get(w).getAnswer2()%></td>    
            </tr>
            <tr>
                <td></td>
                <td>3. <%= q.get(w).getAnswer3()%></td>    
            </tr>
            <tr>
                <td></td>
                <td>4. <%= q.get(w).getAnswer4()%></td>    
            </tr>
            <tr>
                <td><b>User answer:</b></td>
                <td><%= q.get(w).getuAnswer()%> (Date: <%= q.get(w).getuDate()%>, Time: <%= q.get(w).getuTime()%>)</td>    
            </tr>
            <tr>
                <td><b>Correct answer:</b></td>
                <td><%= q.get(w).getCorrect()%></td>    
            </tr>
            <tr>
                <td><hr></td>
                 <td><hr></td>
            </tr>
            <%
                }
            %>
            
        </table>
            <br><br>
        <%
                }

            }


        %>
        <br><br><br>
        <%            }
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
