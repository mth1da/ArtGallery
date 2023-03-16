package com.miage.app.dao.jdbc;

import com.miage.app.Entity.Critique;
import com.miage.app.dao.CritiqueDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CritiqueBDD extends DAOContext implements CritiqueDAO {

    public CritiqueBDD(){
        this.connexion=DAOContext.getConnect();
    }

    @Override
    public void createCritique(Critique cr) {

    }

    @Override
    public void updateCritiqueNote(Critique cr) {

    }

    @Override
    public void updateCritiqueComment(Critique cr) {

    }


    @Override
    public void deleteCritique(Critique cr) {

    }

    @Override
    public Critique getCritiqueById(int id) {
        return null;
    }

    @Override
    public Iterable<Critique> getAllCritiques() {
        return null;
    }


    @Override
    protected Critique creatingObject(ResultSet re) throws SQLException  {
        return null;
    }
}
