package com.miage.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion {

    public static boolean connexionValide(ResultSet re) throws SQLException {
        if(re.next()) {
            return true;
        }
        return false;
    }

    public static boolean emailValide(String email){return true;}
    public static boolean mdpValide(String mdp){
        return  true;
    }
    public static boolean verifCompteExiste(String email){
        return true;
    }

}
