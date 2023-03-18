package com.miage.app.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {

    //Vérifie si la connexion est valide
    public static void connexionValide(HttpServletResponse response, ResultSet re) throws SQLException, IOException {
        //Parcourt les données de la table user
        if(re.next()) {
            //Redirection vers la page home si authentification réussie
            response.sendRedirect("Home.jsp");
        }
    }

    public static boolean emailValide(String email){return true;}
    public static boolean mdpValide(String mdp){
        return  true;
    }
    public static boolean verifCompteExiste(String email){
        return true;
    }

}
