package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import com.miage.app.logging.ConsoleLogger;

import java.sql.*;
import java.sql.ResultSet;


public class ArtisteBDD extends DAOContext implements ArtisteDAO {

    @Override
    public void createArtiste(String name, String lastName) {
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Requête permettant de créer un nouvel artiste avec les données récupérées
            String query= "INSERT INTO artiste (name, lastName) VALUES (?,?)";

            //Préparation de l'état de connexion
            st = connexion.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, lastName);

            //Execution
            st.executeUpdate();

        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally {
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    protected Artiste creatingObject(ResultSet re) {

        Artiste a=null;
        try{
            //Récupération des données de l'artiste
            int id=re.getInt("idArtiste");
            String name=re.getString("name");
            String lastname=re.getString("lastname");
            String fonction=re.getString("fonction");
            a=new Artiste(id,name,lastname,fonction);
            //Retourne instanciation de Artiste avec les données récupérés

        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        }
        return a;
    }


    @Override
    public Artiste getIdByNameAndLastName(String name, String lastName) {
        Artiste artiste = null;
        String strSql= "SELECT * FROM artiste WHERE name=? AND lastName=?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, name);
            st.setString(2,lastName);
            ResultSet re = st.executeQuery();
            while(re.next()){
                System.out.println(re.getInt("idArtiste"));
                artiste=creatingObject(re);
            }

        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally {
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return artiste;
    }
}
