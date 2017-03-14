<%@ page import="Firebase.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Георгий
  Date: 13.03.2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%
Connection com = new Connection();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple jsp page</title>
  </head>
  <body>
    <h3 class="message"><%=com.getMessage()%></h3>
  </body>
</html>
