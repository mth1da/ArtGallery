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

    public ArtisteBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createArtiste(Artiste artiste){
        String strSql="INSERT INTO VISITEUR (id,status,name,lastname,age) VALUES (?,?,?,?,?)";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, artiste.getId());
            st.setString(2, artiste.getName());
            st.setString(3, artiste.getLastName());
            st.setInt(4, artiste.getAge());
            st.setString(5, artiste.getStatus());
            st.executeUpdate();
        }catch (Exception exception){

        }
    }

    @Override
    public void updateArtiste(Artiste artiste) {

    }

    @Override
    public void deleteArtiste(Artiste artiste) {
        String strSql="DELETE FROM VISITEUR WHERE id= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, artiste.getId());
            st.executeUpdate();
        }catch (Exception exception){

        }
    }

    @Override
    public Artiste getArtisteById(int id) {
        Artiste artiste=null;
        String strSql="select * FROM ARTISTE WHERE id= ?";
        try{
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                artiste=creatingObject(re);
            }
        }catch (Exception exception){

        }
        System.out.println(artiste);
        return artiste;
    }

    @Override
    public Iterable<Artiste> getAllArtistes() {
        return null;
    }


    @Override
    protected Artiste creatingObject(ResultSet re) throws SQLException {
        int id=re.getInt("id");
        String status=re.getString("status");
        String name=re.getString("name");
        String lastname=re.getString("lastname");
        int age=re.getInt("age");
        Artiste artiste=new Artiste(id,status,name,lastname,age);
        return artiste;
    }
}
