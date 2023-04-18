package com.miage.app.servlets;

import com.miage.app.services.Connexion;
import com.miage.app.services.ConnexionGoogle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginGoogleServlet", value = "/LoginGoogleServlet")
public class LoginGoogleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connexion c=new ConnexionGoogle();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
