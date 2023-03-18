package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
import com.miage.app.dao.ArtisteDAO;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ArtisteBDD extends DAOContext implements ArtisteDAO {

    @Override
    public void createArtiste(Artiste artiste){

        //Requête permettant de créer un nouvel artiste avec les données récupérées
        String strSql="INSERT INTO ARTISTE (idArtiste,name,lastname,datenaissance,fonction) VALUES (?,?,?,?,?)";
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Préparer l'état de connexion
            st = connexion.prepareStatement(strSql);

            st.setInt(1, artiste.getId());
            st.setString(2, artiste.getName());
            st.setString(3, artiste.getLastName());
            st.setInt(4, artiste.getAge());
            st.setString(5, artiste.getStatus());

            //Execution
            st.executeUpdate();

            //Ferme la connexion
            DAOContext.getDeconnect();

        }catch (Exception ignored){

        }

    }

    @Override
    public void updateArtiste(Artiste artiste) {


    }

    @Override
    public void deleteArtiste(Artiste artiste) {

        //Requête permettant de supprimer un artiste
        String strSql="DELETE FROM VISITEUR WHERE idArtiste= ?";
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Préparer l'état de connexion
            st = connexion.prepareStatement(strSql);
            st.setInt(1, artiste.getId());

            //Exécution
            st.executeUpdate();

            //Ferme la connexion
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
    }

    @Override
    public Artiste getArtisteById(int id) {
        Artiste artiste=null;

        //Requete permettant de selectionner un artiste à l'aide de son id
        String strSql="select * FROM ARTISTE WHERE idArtiste= ?";
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Préparer l'état de connexion
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);

            //Execution de la requête
            ResultSet re=st.executeQuery();

            //On parcourt les données de la table
            while(re.next()){
                //Instanciation de Artiste avec les données récupérées
                artiste=creatingObject(re);
            }

            //Ferme la connexion
            DAOContext.getDeconnect();

        }catch (Exception ignored){

        }
        return artiste;
    }

    @Override
    public Iterable<Artiste> getAllArtistes() {
        return null;
    }


    @Override
    protected Artiste creatingObject(ResultSet re) throws SQLException {

        //Récupération des données de l'artiste
        int id=re.getInt("idArtiste");
        String status=re.getString("name");
        String name=re.getString("lastname");
        String lastname=re.getString("datenaissance");
        int age=re.getInt("fonction");

        //Retourne instanciation de Artiste avec les données récupérés
        return new Artiste(id,status,name,lastname,age);
    }
}
