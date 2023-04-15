<%--
  Created by IntelliJ IDEA.
  User: Salon
  Date: 15/04/2023
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="needs-validation" novalidate action="modifyOeuvre" method="post">
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="validationCustom01"> Titre de l'oeuvre </label>
            <input type="text" class="form-control" name="title" id="validationCustom01" required>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationCustom02"> Prix de l'oeuvre </label>
            <input type="text" class="form-control" name="price" id="validationCustom02" required>
        </div>
        <input type="submit" value="Modifier"><input type="Hidden" name="id" id="modifyOeuvre">
    </div>
</form>

</body>
</html>
