package com.miage.app.dao;

import com.miage.app.Entity.Critique;

import java.util.List;

public interface CritiqueDAO {

    public abstract void createCritique(Critique cr);

    public abstract void updateCritiqueNote(Critique cr);

    public abstract void updateCritiqueComment(Critique cr);

    public abstract void deleteCritique(Critique cr);

    public abstract Critique getCritiqueById(int id);

    public abstract Iterable<Critique> getAllCritiques();


}
