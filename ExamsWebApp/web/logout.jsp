<%-- 
    Document   : logout
    Created on : Sep 25, 2018, 2:39:26 PM
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("currentSessionUser")!=null) {
                session.setAttribute("currentSessionUser", null);
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
