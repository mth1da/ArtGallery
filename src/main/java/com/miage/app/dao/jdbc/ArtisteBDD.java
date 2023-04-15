package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;
import com.miage.app.dao.ArtisteDAO;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally {
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally{
            try{
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally {
            try {
                //deconnexion
                DAOContext.getDeconnect();
            } catch (SQLException e){
                System.out.println("Caught SQLException: " + e.getMessage());
            }
        }
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


            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return artiste;
    }

    public static void main(String[] args) {
        ArtisteBDD artiste = new ArtisteBDD();
        System.out.println(artiste.getIdByNameAndLastName("Amel","Naloufi"));
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
            System.out.println("Caught SQLException: " + e.getMessage());
        } finally {
            try{
                DAOContext.getDeconnect();
            } catch (SQLException e) {
                System.out.println("Caught SQLException: " + e.getMessage());
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
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return a;
    }
}
