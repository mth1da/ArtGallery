package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.TableauOeuvre;
import com.miage.app.Entity.User;
import com.miage.app.Entity.Visiteur;
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



    }

    @Override
    public void updateOeuvre(Oeuvre o) {

    }

    @Override
    public void deleteOeuvre(Oeuvre o) {

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
