<%--
  Created by IntelliJ IDEA.
  User: merya
  Date: 11/03/2023
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>

<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
             class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form action="loginuser" method="post">
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-facebook-f"></i>
            </button>

            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-twitter"></i>
            </button>

            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-linkedin-in"></i>
            </button>
          </div>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0">Or</p>
          </div>

          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" name="email" id="form3Example3" class="form-control form-control-lg"
                   placeholder="Enter a valid email address" />
            <label class="form-label" for="form3Example3" >Email address</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" id="form3Example4" name="password" class="form-control form-control-lg"
                   placeholder="Enter password" />
            <label class="form-label" for="form3Example4" >Password</label>
          </div>
          <label for="status">Status</label>
          <select name="status" id="status">
            <option value="proprietaire">Propriétaire</option>
            <option value="visiteur">Visiteur</option>
          </select>
          <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <div class="form-check mb-0">
              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
              <label class="form-check-label" for="form2Example3">
                Remember me
              </label>
            </div>
            <a href="#!" class="text-body">Forgot password?</a>
          </div>


          <div class="text-center text-lg-start mt-4 pt-2">

            <! -- ICIIIIII -->
            <button type="submit" class="btn btn-primary btn-lg"
                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="#!"
                                                                              class="link-danger">Register</a></p>
          </div>

        </form>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="963886692136-igaobtmcoq8u208flvjevr1j51m8fmuc.apps.googleusercontent.com">
        </head>
        <body>
        <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
        <img id="myImg"><br>
        <p id="name"></p>
        <div id="statuss">
        </div>
        <script type="text/javascript">
          function onSignIn(googleUser) {
            window.location.href='success.jsp';
            var profile = googleUser.getBasicProfile();
            var imagurl=profile.getImageUrl();
            var name=profile.getName();
            var email=profile.getEmail();
            document.getElementById("myImg").src = imagurl;
            document.getElementById("name").innerHTML = name;
            document.getElementById("myP").style.visibility = "hidden";
            document.getElementById("statuss").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'
          }
        </script>
        <button onclick="myFunction()">Sign Out</button>
        <script>
          function myFunction() {
            gapi.auth2.getAuthInstance().disconnect();
            location.reload();
          }
        </script>
      </div>
    </div>
  </div>
  <div
          class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © 2020. All rights reserved.
    </div>
    <!-- Copyright -->

    <!-- Right -->
    <div>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-google"></i>
      </a>
      <a href="#!" class="text-white">
        <i class="fab fa-linkedin-in"></i>
      </a>
    </div>
    <!-- Right -->
  </div>
</section>

</body>
</html>
