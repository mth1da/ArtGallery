package com.miage.app;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Proprietaire;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.CritiqueDAO;
import com.miage.app.dao.UserDAO;
import com.miage.app.dao.jdbc.CritiqueBDD;
import com.miage.app.dao.jdbc.ProprietaireBDD;
import com.miage.app.dao.jdbc.UserBDD;
import com.miage.app.dao.jdbc.VisiteurBDD;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        User r=new Visiteur("Ghulam","Meryam","mrm@gmail.com","ijij");

        /**User user=new Visiteur("amel","naloufi","okkk","OKKK");**/
        UserDAO dao=new VisiteurBDD();
        /**dao.createUser(user);**/

        r.setNom("sfkgnjfgn");
        r.setPrenom("mez");
        dao.updateUser(r);


    }
}
