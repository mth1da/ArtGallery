<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %><%--
  Created by IntelliJ IDEA.
  User: Salon
  Date: 17/03/2023
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <center> Home page </center>
<br>
<p> Connection réussie ! </p>
    <a href="modifyProfile.jsp">Modifier mon profil</a>
    <a href="artist.jsp">Les artistes</a>
    <%
    if (session.getAttribute("status").equals("proprietaire")) {
     %>
    <a href="Oeuvres.jsp">Mes oeuvres</a>
    <a href="types.jsp">Types d'oeuvres</a>
                <%   }
    %>

    <a href="Exhibition.jsp">Les expositions</a>
    <a href="Reservation.jsp">Mes réservations</a>

</body>
</html>
