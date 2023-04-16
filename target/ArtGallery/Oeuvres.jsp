<%@ page import="com.miage.app.Entity.Oeuvre" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.dao.OeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.OeuvreBDD" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: merya
  Date: 19/03/2023
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Voici mes oeuvres

<%
    String s=session.getAttribute("currentUser").toString();
    UserDAO userDAO=new ProprietaireBDD();
    int us= ((ProprietaireBDD) userDAO).getUserIdBymail(s);
    OeuvreDAO oe=new OeuvreBDD();
    List< Oeuvre> lesOeuvres = (List<Oeuvre>) oe.getAllUserOeuvres(us);
    for(Oeuvre o : lesOeuvres){
        %>
<h4><%= o.getPresentationOeuvre()%></h4>
 <%   }
%>

<a href="AjoutOeuvre.jsp">Ajouter une oeuvre</a>
<a href="SuppOeuvre.jsp">Supprimer une oeuvre</a>
<a href="modifyOeuvre.jsp">Modifier une oeuvre</a>

</body>
</html>
