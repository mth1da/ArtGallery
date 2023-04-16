package com.miage.app.dao.repository;


import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;
import com.miage.app.dao.OeuvreDAO;

import java.util.ArrayList;
import java.util.List;

public class OeuvreRepository implements OeuvreDAO {
    private static List<Oeuvre> oeuvreList=new ArrayList<>();

    @Override
    public void createOeuvre(String title, int userID, Artiste art, Double price) {

    }


    @Override
    public void updateOeuvre(String title, Double price, int id) {

    }

    @Override
    public void deleteOeuvre(int idOeuvre) {

    }

    @Override
    public Iterable<Oeuvre> getAllUserOeuvres(int id) {
        return null;
    }


}
