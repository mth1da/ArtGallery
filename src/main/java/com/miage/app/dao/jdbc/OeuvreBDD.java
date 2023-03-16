package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Oeuvre;
import com.miage.app.dao.OeuvreDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    protected Oeuvre creatingObject(ResultSet re) throws SQLException {
        return null;
    }
}
