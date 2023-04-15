<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.Entity.User" %>
<%@ page import="com.miage.app.dao.ReservationDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ReservationBDD" %>
<%@ page import="com.miage.app.Entity.Reservation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: merya
  Date: 12/03/2023
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Toutes mes reservaions</h1>
<%
    int userID=Integer.parseInt(session.getAttribute("userId").toString());
    ReservationDAO re=new ReservationBDD();
    List<Reservation> reservation = (List<Reservation>) re.getReservationByUser(userID);
    for(Reservation o : reservation){
%>
<form action="deleteReser" method="get">
    <h4><%= o.getInfoReservation()%></h4>
    <input type="hidden" name="idRe" value="<%= o.getIdReservation()%>">
    <button type="submit" >Delete</button>
</form>

<%   }
%>
</body>
</html>
