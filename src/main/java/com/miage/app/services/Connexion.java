package com.miage.app.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {

    public static void connexionValide(HttpServletResponse response, ResultSet re) throws SQLException, IOException {
        if(re.next()) {
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
