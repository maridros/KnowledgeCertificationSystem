<%-- 
    Document   : addQuestions
    Created on : Sep 8, 2018, 10:49:27 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Add Questions Page</title>
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
        <h2>Add new question:</h2>

        <form action="addQuestionsServlet">
            <table>

                <tr>
                    <td><b>Question:</b></td>
                    <td><textarea rows="10" cols="100" name="question" required></textarea></td>
                </tr>

                <tr>
                    <td><b>Answer 1:</b></td>
                    <td><textarea rows="4" cols="80" name="a" required></textarea></td>
                </tr>
                <tr>
                    <td><b>Answer 2:</b></td>
                    <td><textarea rows="4" cols="80" name="b" required></textarea></td>
                </tr>
                <tr>
                    <td><b>Answer 3:</b></td>
                    <td><textarea rows="4" cols="80" name="c" required></textarea></td>
                </tr>
                <tr>
                    <td><b>Answer 4:</b></td>
                    <td><textarea rows="4" cols="80" name="d" required></textarea></td>
                </tr>

                <tr>
                    <td><b>Correct Answer:</b></td>
                    <td>
                        <input type="radio" name="answer" value="1" required> Answer 1 &nbsp;
                        <input type="radio" name="answer" value="2"> Answer 2 &nbsp;
                        <input type="radio" name="answer" value="3"> Answer 3 &nbsp;
                        <input type="radio" name="answer" value="4"> Answer 4 &nbsp;
                    </td>
                </tr>


            </table>

            <br>
            <input type="submit" class="btn" value="Add">

        </form>
    </center>
    <br>

    <%
        }
    } else {

    %>
    <br><br>
    <center>
        You are not logged in or you are not System Administrator,<br>
        <a href="index.jsp">Return to Login Page</a>
    </center>

    <%        }

    %>

</body>
</html>
