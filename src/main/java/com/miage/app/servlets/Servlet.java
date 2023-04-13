package com.miage.app.servlets;

import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;
import com.miage.app.services.Inscription;
import com.miage.app.services.InscriptionProprietaire;
import com.miage.app.services.InscriptionVisiteur;
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
        out.println(status);

        //Création d'un tableau de string
        String [] str=new String[4];

        try{
            //Récupération des données du formulaire pour les mettre dans le tableau
            str[0]=request.getParameter("name");
            str[1]=request.getParameter("firstname");
            str[2]=request.getParameter("password");
            str[3]=request.getParameter("email");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        }


        //création du compte selon si c'est un propriétaire ou visiteur
        try{
            if(status.equals("visiteur")){
                UserDAO ust=new VisiteurBDD();
                Inscription v=new InscriptionVisiteur(str,ust);
                v.creeCompte();
            }else if(status.equals("proprietaire")){
                UserDAO ust=new ProprietaireBDD();
                Inscription v=new InscriptionProprietaire(str,ust);
                v.creeCompte();
            }
        } catch(IllegalArgumentException e){
            System.out.println("Caught SQLException: " + e.getMessage());
        }

    }


}
