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
            st = connexion.prepareStatement(strSql);
            st.setInt(1, artiste.getId());
            st.executeUpdate();
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
        String status=re.getString("name");
        String name=re.getString("lastname");
        String lastname=re.getString("datenaissance");
        int age=re.getInt("fonction");

        //Retourne instanciation de Artiste avec les données récupérés

        return new Artiste(id,status,name,lastname,age);
    }

    @Override
    public Iterable<Artiste> getAllUserArtiste(int id) {
        List<Artiste> artisteList=new ArrayList<>();
        String strSql="select * FROM ARTISTE WHERE idUser= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Artiste artiste=creatingObject(re);
                artisteList.add(artiste);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return artisteList;
    }
}
