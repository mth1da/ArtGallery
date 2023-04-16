<%@ page import="com.miage.app.Entity.User" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.VisiteurBDD" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %>
<%@ page import="com.miage.app.dao.TypeOeuvreDAO" %>
<%@ page import="com.miage.app.dao.jdbc.TypeOeuvreBDD" %>
<%@ page import="com.miage.app.Entity.TypeOeuvre" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Salon
  Date: 24/03/2023
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>

<%--
    UserDAO userDAO=null;
    userDAO=new ProprietaireBDD();
    User user=userDAO.getUserByMail(session.getAttribute("currentUser").toString());
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<%--
    int userID=Integer.parseInt(session.getAttribute("userId").toString());
--%>
<form class="needs-validation" novalidate action="addOeu" method="post">
    <div class="form-control">
        <div class="col-md-4 mb-3">
            <label for="validationCustom01"> Titre de l'oeuvre </label>
            <input type="text" class="form-control" name="title" id="validationCustom01" placeholder="La Joconde" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationCustom02"> Prénom de l'artiste </label>
            <input type="text" class="form-control" name="name" id="validationCustom02" placeholder="Leonardo" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationCustomName">Nom de l'artiste</label>
            <input type="text" name="lastName" class="form-control" id="validationCustomName" placeholder="Da Vinci" required>
            <div class="invalid-feedback">
                Please choose a name.
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationCustomSelect">Type d'Oeuvre</label>
            <div class="input-group">
                <select name="type" id="validationCustomSelect" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <option selected>Sélectionnez un type d'oeuvre</option>
                    <%
                        TypeOeuvreDAO type=new TypeOeuvreBDD();
                        List<TypeOeuvre> types = (List<TypeOeuvre>) type.getAllTypes();
                        for(TypeOeuvre type_oeuvre : types){
                    %>
                    <option value="<%= type_oeuvre.getType()%>"><%= type_oeuvre.getType()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label for="validationCustom03">Prix de l'oeuvre</label>
            <input type="text" name="price" class="form-control" id="validationCustom03" placeholder="Prix" required>
            <div class="invalid-feedback">
                Please provide a valid price.
            </div>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
            <label class="form-check-label" for="invalidCheck">
                Agree to terms and conditions
            </label>
            <div class="invalid-feedback">
                You must agree before submitting.
            </div>
        </div>
    <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>
</body>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</html>