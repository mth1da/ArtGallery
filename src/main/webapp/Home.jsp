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
<p> Connection réussi ! </p>
    <a href="modifyProfile.jsp">modifier son profil</a>
    <%
    if (session.getAttribute("status").equals("proprietaire")) {
     %>
    <a href="Oeuvres.jsp">Mes oeuvres</a>
                <%   }
    %>

    <a href="Exhibition.jsp">les exhibitions</a>
    <a href="Reservation.jsp">Mes reservations</a>

</body>
</html>
