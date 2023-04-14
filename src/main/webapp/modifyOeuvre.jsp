<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.Entity.Oeuvre" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.dao.OeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.OeuvreBDD" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>

<form class="needs-validation" novalidate action="modifyOeuvre" method="post">
  <%
    String s=session.getAttribute("currentUser").toString();
    UserDAO userDAO=new ProprietaireBDD();
    int us= ((ProprietaireBDD) userDAO).getUserIdBymail(s);
    OeuvreDAO oe=new OeuvreBDD();
    List< Oeuvre> lesOeuvres = (List<Oeuvre>) oe.getAllUserOeuvres(us);
    for(Oeuvre o : lesOeuvres){
  %>
  <input type="Hidden" value="<%=o.getId()%>" name="id" id="suppOeuvre"><a href="modify.jsp">Modifier</a><h6><%= o.getPresentationOeuvre()%></h6>
  <%   }
  %>
</form>
</body>
</html>