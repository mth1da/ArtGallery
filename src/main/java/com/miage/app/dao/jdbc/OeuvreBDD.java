package com.miage.app.dao.jdbc;

import com.miage.app.Entity.*;
import com.miage.app.dao.OeuvreDAO;
import com.miage.app.dao.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OeuvreBDD extends DAOContext implements OeuvreDAO {

    public OeuvreBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createOeuvre(Oeuvre o) {
        String strSql="INSERT INTO oeuvre (idOeuvre, title, idArtiste, idUser, price) VALUES (?,?,?,?,?)";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, o.getId());
            st.setString(2, o.getName());
            st.setInt(3, o.getIdProprio());
            st.setInt(4,o.getIdArtiste());
            st.setDouble(5,o.getPrice());
            st.executeQuery();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

        }
    }

    @Override
    public void updateOeuvre(Oeuvre o) {
        String query="UPDATE oeuvre SET title=?, price=? WHERE idOeuvre=?";
        try {
            DAOContext.getConnect();
            st = connexion.prepareStatement(query);
            st.setString(1, o.getName());
            st.setDouble(2, o.getPrice());
            st.setInt(3, o.getId());
            st.executeUpdate();
            DAOContext.getDeconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOeuvre(Oeuvre o) {
        String strSql="DELETE FROM oeuvre WHERE idOeuvre= ?";
        try{
            DAOContext.getConnect();
            st = connexion.prepareStatement(strSql);
            st.setInt(1, o.getId());
            st.executeUpdate();
            DAOContext.getDeconnect();
        }catch (Exception ignored){

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
