<%@ page import="com.miage.app.dao.TypeOeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.TypeOeuvreBDD" %>
<%@ page import="com.miage.app.Entity.TypeOeuvre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 16/04/2023
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>
<%
  TypeOeuvreDAO type=new TypeOeuvreBDD();
  List<TypeOeuvre> types = (List<TypeOeuvre>) type.getAllTypes();
  for(TypeOeuvre type_oeuvre : types){
%>
<form class="needs-validation" novalidate action="delete-type" method="post">
  <input type="submit" value="Supprimer"><input type="Hidden" value="<%=type_oeuvre.getId()%>" name="id" id="deleteType"><h6><%= type_oeuvre.getType()%></h6>
</form>
<%   }
%>
</body>
</html>
