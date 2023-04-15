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
    public void createArtiste(String name, String lastName){
        //Requête permettant de créer un nouvel artiste avec les données récupérées
        String strSql= "INSERT INTO artiste (name, lastName) VALUES (?,?)";
        try{
            //Création de la connection avec BDD
            DAOContext.getConnect();
            //Préparer l'état de connexion
            st = connexion.prepareStatement(strSql);
            st.setString(1, name);
            st.setString(2,lastName);
            //Execution
            st.executeUpdate();
            //Ferme la connexion
            DAOContext.getDeconnect();
        }catch (SQLException e) {
            throw new RuntimeException(e);
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
            st = connexion.prepareStatement(strSql);
            st.setInt(1, artiste.getId());
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

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

        //Requete permettant de selectionner un artiste à l'aide de son id

        String strSql="select * FROM ARTISTE WHERE idArtiste= ?";
        try{

            //Création de la connection avec BDD
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                artiste=creatingObject(re);
            }
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
        String name=re.getString("name");
        String lastName=re.getString("lastName");
        String fonction =re.getString("fonction");

        //Retourne instanciation de Artiste avec les données récupérés

        return new Artiste(id,name, lastName, fonction);
    }
}
