<%@ page import="com.miage.app.Entity.User" %>
<%@ page import="com.miage.app.dao.UserDAO" %>
<%@ page import="com.miage.app.dao.jdbc.VisiteurBDD" %>
<%@ page import="com.miage.app.dao.jdbc.ProprietaireBDD" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 18/03/2023
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>

<%
    UserDAO userDAO=null;
    if (session.getAttribute("status").equals("visiteur")) {
        userDAO = new VisiteurBDD();
    }else if (session.getAttribute("status").equals("proprietaire")) {
        userDAO=new ProprietaireBDD();
    }
    User user=userDAO.getUserByMail(session.getAttribute("currentUser").toString());
    %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Modifier Mon Profil</title>
</head>
<body>
    <form method="post" action="editservlet" class="needs-validation" novalidate>
        <div class="form-row">

            <div class="col-md-4 mb-3">
                <label for="validationCustom01">First name</label>
                <input type="text" class="form-control" id="validationCustom01" placeholder="First name" name="firstname" value="<%= user.getPreNom()%>" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>

            <div class="col-md-4 mb-3">
                <label for="validationCustom02">Last name</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="Last name" name="lastname" value="<%= user.getNom()%>" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationCustomUsername">email</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                    </div>
                    <input type="text" class="form-control" id="validationCustomUsername" placeholder="email" name="email" aria-describedby="inputGroupPrepend" value="<%= user.getEmail()%>" required>
                    <div class="invalid-feedback">
                        Please choose an email.
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationCustom04">Password</label>
            <input type="text" class="form-control" name="password" id="validationCustom04" placeholder="Password"  value="<%= user.getMdp()%>" required>
            <div class="invalid-feedback">
                Please provide a valid state.
            </div>
        </div>
        <p name="status"><%= session.getAttribute("status")%></p>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label" for="invalidCheck">
                    Agree to terms and conditions
                </label>
                <div class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
        </div>
        <br>
        <button class="btn btn-primary" type="submit">Sauvegarder les modifications</button>
    </form>

    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                let forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                let validation = Array.prototype.filter.call(forms, function(form) {
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
</body>
</html>
