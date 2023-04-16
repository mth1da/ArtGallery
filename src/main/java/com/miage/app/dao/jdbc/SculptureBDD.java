package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.Sculpture;
import com.miage.app.Entity.TableauOeuvre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SculptureBDD extends OeuvreBDD{
    @Override
    public String getType() {
        return "sculpture";
    }

    @Override
    protected Oeuvre creatingObject(ResultSet re) {

        try{
            int id=re.getInt("idOeuvre");
            String title=re.getString("title");
            int idArtist=re.getInt("idArtiste");
            int idUser=re.getInt("idUser");
            double price=re.getDouble("price");
            Oeuvre user=new Sculpture(id,title,idArtist,idUser,price);
            return user;
        } catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;
    }
}
