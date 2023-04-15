package com.miage.app.dao.jdbc;

import com.miage.app.Entity.*;
import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OeuvreBDD extends DAOContext implements OeuvreDAO {

    public OeuvreBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createOeuvre(String title, int userID, Artiste art, Double price) {
        String strSql="INSERT INTO oeuvre (title, idUser, idArtiste, price) VALUES (?,?,?,?)";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setString(1, title);
            st.setInt(2, userID);
            st.setInt(3,art.getId());
            st.setDouble(4, price);
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOeuvre(String title, Double price, int id) {
        String query="UPDATE oeuvre SET title=?, price=? WHERE idOeuvre=?";
        try {
            DAOContext.getConnect();
            st = connexion.prepareStatement(query);
            st.setString(1, title);
            st.setDouble(2, price);
            st.setInt(3, id);
            st.executeUpdate();
            DAOContext.getDeconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOeuvre(int idOeuvre) {
        String strSql="DELETE FROM oeuvre WHERE idOeuvre=?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, idOeuvre);
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Oeuvre getOeuvreById(int o) {
        return null;
    }

    @Override
    public Iterable<Oeuvre> getAllOeuvres() {
        return null;
    }

    @Override
    public Iterable<Oeuvre> getAllUserOeuvres(int id) {
        List<Oeuvre> oeuvreList=new ArrayList<>();
        String strSql="select * FROM OEUVRE WHERE idUser= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, id);
            ResultSet re=st.executeQuery();
            while(re.next()){
                Oeuvre oeuvre=creatingObject(re);
                oeuvreList.add(oeuvre);
            }
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
        return oeuvreList;
    }

    @Override
    protected Oeuvre creatingObject(ResultSet re) throws SQLException {
        int id=re.getInt("idOeuvre");
        String title=re.getString("title");
        int idArtist=re.getInt("idArtiste");
        int idUser=re.getInt("idUser");
        double price=re.getDouble("price");
        Oeuvre user=new TableauOeuvre(id,title,idArtist,idUser,price);
        return user;
    }
}
