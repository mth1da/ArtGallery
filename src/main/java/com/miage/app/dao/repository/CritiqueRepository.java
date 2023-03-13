package com.miage.app.dao.repository;

import com.miage.app.Entity.Artiste;
import com.miage.app.Entity.Critique;
import com.miage.app.dao.CritiqueDAO;

import java.util.ArrayList;
import java.util.List;

public class CritiqueRepository implements CritiqueDAO {
    private static List<Critique> critiqueList=new ArrayList<>();

    @Override
    public void createCritique(Critique cr) {
        critiqueList.add(cr);
    }

    @Override
    public void updateCritiqueNote(Critique cr) {

    }

    @Override
    public void updateCritiqueComment(Critique cr) {

    }


    @Override
    public void deleteCritique(Critique cr) {
        critiqueList.remove(cr);
    }

    @Override
    public Critique getCritiqueById(int id) {
        return critiqueList.get(id);
    }

    @Override
    public Iterable<Critique> getAllCritiques() {
        return critiqueList;
    }




}
