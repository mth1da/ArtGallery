<%--
  Created by IntelliJ IDEA.
  User: merya
  Date: 14/04/2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name=(String)request.getParameter("name");
    String email=(String)request.getParameter("email");
%>

<%=name %>

<%=email %>
</body>
</html>
