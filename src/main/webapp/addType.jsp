<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 16/04/2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <title>Ajouter un type d'oeuvre</title>
</head>

<body>
  <form class="needs-validation" novalidate action="add-type" method="post">
    <div class="form-control">
      <div class="col-md-4 mb-3">
        <label for="validationName"> Nom du type d'oeuvre </label>
        <input type="text" class="form-control" name="nom_type" id="validationName" placeholder="Peinture" required>
        <div class="valid-feedback">
          Looks good!
        </div>
      </div>
      <div class="col-md-4 mb-3">
        <label for="validationDescription"> Description </label>
        <textarea id="validationDescription" class="form-control" name="description"></textarea>
        <div class="valid-feedback">
          Looks good!
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
