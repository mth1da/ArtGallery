package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.Entity.Peinture;
import com.miage.app.Entity.TableauOeuvre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeintureBDD extends OeuvreBDD{
    @Override
    public String getType() {
        return "peinture";
    }

    @Override
    protected Oeuvre creatingObject(ResultSet re) {

        try{
            int id=re.getInt("idOeuvre");
            String title=re.getString("title");
            int idArtist=re.getInt("idArtiste");
            int idUser=re.getInt("idUser");
            double price=re.getDouble("price");
            Oeuvre user=new Peinture(id,title,idArtist,idUser,price);
            return user;
        } catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
        return null;
    }
}
