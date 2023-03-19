package com.miage.app;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionProprietaire;
import com.miage.app.services.InscriptionVisiteur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletPro", urlPatterns = "/servletProprietaire")
public class SignupServletProprietaire extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Création d'un tableau de string
        String [] str=new String[4];

        //Récupération des données du formulaire pour les mettre dans le tableau
        str[0]=request.getParameter("name");
        str[1]=request.getParameter("firstname");
        str[2]=request.getParameter("password");
        str[3]=request.getParameter("email");
        String rep="";

        //Création de propriétaire
        UserDAO ust=new ProprietaireBDD();
        Inscription v=new InscriptionProprietaire(str,ust);
        rep= String.valueOf(v.creeCompte());
        PrintWriter out = response.getWriter();
        out.println(rep);
    }
}
