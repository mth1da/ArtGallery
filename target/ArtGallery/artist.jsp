<%@ page import="com.miage.app.dao.ArtisteDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ArtisteBDD" %>
<%@ page import="com.miage.app.Entity.Artiste" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.app.Entity.Oeuvre" %>
<%@ page import="com.miage.app.dao.OeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.OeuvreBDD" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 16/04/2023
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Voici les artistes :

<%
    ArtisteDAO artiste=new ArtisteBDD();
    List<Artiste> artistes = (List<Artiste>) artiste.getAllArtists();
    for(Artiste arti : artistes){
%>
<h4><%= arti.getName()%> <%= arti.getLastName()%></h4>
<%
        OeuvreDAO oeuvre=new OeuvreBDD();
        List<Oeuvre> oeuvres = (List<Oeuvre>) oeuvre.getAllOeuvresByArtistId(arti.getId());
        for(Oeuvre oe : oeuvres){
%>
<p><%= oe.getName()%>, <%= oe.getPrice()%></p>
<%
        }
    }
%>
</body>
</html>
