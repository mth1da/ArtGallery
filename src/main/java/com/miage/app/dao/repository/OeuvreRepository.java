package com.miage.app.dao.repository;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Oeuvre;
import com.miage.app.dao.OeuvreDAO;

import java.util.ArrayList;
import java.util.List;

public class OeuvreRepository implements OeuvreDAO {
    private static List<Oeuvre> oeuvreList=new ArrayList<>();
    @Override
    public void createOeuvre(Oeuvre o) {
        oeuvreList.add(o);
    }

    @Override
    public void updateOeuvre(Oeuvre o) {

    }

    @Override
    public void deleteOeuvre(Oeuvre o) {
        oeuvreList.remove(o);
    }

    @Override
    public Oeuvre getOeuvreById(int o) {
        Oeuvre oeuvre=null;
        for(Oeuvre currOeuvre : oeuvreList){
            if(currOeuvre.getId()==o){
                oeuvre=currOeuvre;
            }
        }
        return oeuvre;
    }

    @Override
    public Iterable<Oeuvre> getAllOeuvres() {
        return oeuvreList;
    }


}
