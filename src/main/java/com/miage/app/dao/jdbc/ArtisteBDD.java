package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import com.miage.app.logging.ConsoleLogger;

import java.sql.*;
import java.sql.ResultSet;


public class ArtisteBDD extends DAOContext implements ArtisteDAO {
    ConsoleLogger consoleLogger = new ConsoleLogger();


    @Override
    public void createArtiste(Artiste artiste) {

        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Requête permettant de créer un nouvel artiste avec les données récupérées
            String query="INSERT INTO ARTISTE (idArtiste,firstname,lastname,datenaissance,fonction) VALUES (?,?,?,?,?)";

            //Préparation de l'état de connexion
            st = connexion.prepareStatement(query);
            st.setInt(1, artiste.getId());
            st.setString(2, artiste.getName());
            st.setString(3, artiste.getLastName());
            st.setInt(4, artiste.getAge());
            st.setString(5, artiste.getStatus());

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
    public void updateArtiste(Artiste artiste) {
        try {
            //connexion
            DAOContext.getConnect();

            String query="";

            st.executeUpdate();
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }

    }

    @Override
    public void deleteArtiste(Artiste artiste) {

        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Requête permettant de supprimer un artiste
            String query="DELETE FROM VISITEUR WHERE idArtiste= ?";

            //préparation
            st = connexion.prepareStatement(query);
            st.setInt(1, artiste.getId());

            //Execution
            st.executeUpdate();

        }catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally {
            try {
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
    }

    @Override
    public Artiste getArtisteById(int id) {

        Artiste artiste=null;
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();

            //Requete permettant de selectionner un artiste à l'aide de son id
            String query="select * FROM ARTISTE WHERE idArtiste= ?";

            //préparation
            st = connexion.prepareStatement(query);
            st.setInt(1, id);

            ResultSet re=st.executeQuery();
            while(re.next()){
                artiste=creatingObject(re);
            }

        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        } finally {
            try{
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                consoleLogger.writeError("Caught SQLException", e);
            }
        }
        return artiste;
    }

    @Override
    public Iterable<Artiste> getAllArtistes() {
        return null;
    }


    @Override
    protected Artiste creatingObject(ResultSet re) {

        try{
            //Récupération des données de l'artiste
            int id=re.getInt("idArtiste");
            String status=re.getString("name");
            String name=re.getString("lastname");
            String lastname=re.getString("datenaissance");
            int age=re.getInt("fonction");

            //Retourne instanciation de Artiste avec les données récupérés
            return new Artiste(id,status,name,lastname,age);
        } catch (SQLException e){
            consoleLogger.writeError("Caught SQLException", e);
        }
        return null;
    }
}
