<%@ page import="com.miage.app.dao.ExhibitionDAO" %>
<%@ page import="com.miage.app.dao.jdbc.ExhibitionBDD" %>
<%@ page import="com.miage.app.Entity.Exhibition" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: merya
  Date: 24/03/2023
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    ExhibitionDAO oe=new ExhibitionBDD();
    List<Exhibition> lesExhibition = (List<Exhibition>) oe.getAllExhibition();
    for(Exhibition o : lesExhibition){
%>
<form action="buyExb" method="get">
    <input type="hidden" class="form-control" name="idExibi" id="validationCustom04" value="<%= o.getIdExhibition()%>" required>
<h4><%= o.getPresentationExhibition()%></h4><button type="submit">Reserver</button><br><br>
</form>
<%   }
%>
</body>
</html>
