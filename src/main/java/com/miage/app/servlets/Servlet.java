package com.miage.app.servlets;

import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "srvt", value = "/srv")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        PrintWriter out = response.getWriter();


        //Création d'un tableau de string
        String [] str=new String[4];

        //Récupération des données du formulaire pour les mettre dans le tableau
        str[0]=request.getParameter("name");
        str[1]=request.getParameter("firstname");
        str[2]=request.getParameter("password");
        str[3]=request.getParameter("email");

        //création du compte selon si c'est un propriétaire ou visiteur
        UserDAO userDAO=null;
        User user=null;
        if(status.equals("visiteur")){
            userDAO=new VisiteurBDD();
            user=new Visiteur(str[0],str[1],str[2],str[3]);
        }else if(status.equals("proprietaire")){
            userDAO=new ProprietaireBDD();
            user=new Proprietaire(str[0],str[1],str[2],str[3]);
        }
        Inscription v=new InscriptionLocal(userDAO,user);
        v.creeCompte();
        out.println("Inscription réussi veuiller vous connecter");

    }


}
