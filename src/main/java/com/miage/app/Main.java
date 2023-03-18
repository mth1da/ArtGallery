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

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


        /**User user=new Visiteur("amel","naloufi","okkk","OKKK");**/
        UserDAO dao=new ProprietaireBDD();
        /**dao.createUser(user);**/

        dao.getUserById(1).displayUser();
        //dao.deleteUser(user);

        //Iterable contenant les utilisateurs
        Iterable<User> po=dao.getAllUser();

        //Affichage des utilisateurs en parcourant la liste
        for(User us:po){
            us.displayUser();
        }

        //Création de la connexion
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/artGallery","root","");

        //Création d'un état de connexion
        Statement statement=con.createStatement();

        //Exécution de la requête qui sélectionne tous les utilisateurs
        ResultSet re=statement.executeQuery("Select * from user");

        //Tant que l'on parcourt les données de la table
        while(re.next()){
            //On affiche les emails des utilisateurs
            System.out.println(re.getString("email"));
        }

        //Fermeture de la connexion
        con.close();


    }
}
