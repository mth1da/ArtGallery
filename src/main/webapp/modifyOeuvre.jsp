<%@ page import="com.miage.app.Entity.User" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.Entity.Oeuvre" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.dao.OeuvreDAO" %>
<%@ page import="com.miage.app.dao.ArtisteDAO" %>
<%@ page import="com.miage.app.dao.jdbc.OeuvreBDD" %>
<%@ page import="com.miage.app.dao.jdbc.ArtisteBDD" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.app.dao.*" %>
<%@ page import="com.miage.app.dao.jdbc.*" %>
<%@ page import="com.miage.app.Entity.Artiste" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>


  <%
    String s=session.getAttribute("currentUser").toString();
    UserDAO userDAO=new ProprietaireBDD();
    int us= ((ProprietaireBDD) userDAO).getUserIdBymail(s);
    OeuvreDAO oe=new OeuvreBDD();
    List< Oeuvre> lesOeuvres = (List<Oeuvre>) oe.getAllUserOeuvres(us);
    for(Oeuvre o : lesOeuvres) {
  %>
  <form class="needs-validation" novalidate action="modifyOeuvre" method="post">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationCustom01"> Titre de l'oeuvre </label>
      <input type="text" class="form-control" name="title" id="validationCustom01" value="<%=o.getName()%>" required>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustom02"> Prix de l'oeuvre </label>
      <input type="text" class="form-control" name="price" id="validationCustom02" value="<%=o.getPrice()%>" required>
    </div>
    <input type="submit" value="Modifier"><input type="Hidden" value="<%=o.getId()%>" name="id" id="modifyOeuvre">
  </div>
  </form>
      <%
            }
        %>

</body>
</html>