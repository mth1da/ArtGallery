<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.dao.TypeOeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.TypeOeuvreBDD" %>
<%@ page import="com.miage.app.Entity.TypeOeuvre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 15/04/2023
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Types d'Oeuvre</title>
</head>
<body>
Voici les types d'oeuvres :

<%
  TypeOeuvreDAO type=new TypeOeuvreBDD();
  List<TypeOeuvre> types = (List<TypeOeuvre>) type.getAllTypes();
  for(TypeOeuvre type_oeuvre : types){
%>
<h4><%= type_oeuvre.getType()%></h4>
<p><%= type_oeuvre.getCaracteristique()%></p>
<%   }
%>

<a href="addType.jsp">Ajouter un type d'oeuvre</a>
<a href="deleteType.jsp">Supprimer un type d'oeuvre</a>

</body>
</html>
