package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import java.sql.*;
import java.sql.ResultSet;


public class ArtisteBDD extends DAOContext implements ArtisteDAO {

    @Override
    public void createArtiste(Artiste artiste) throws SQLException {

    }

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

    }

    @Override
    public void deleteArtiste(Artiste artiste) {

    }

    @Override
    public Artiste getArtisteById(int id) {
        return null;
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
}
