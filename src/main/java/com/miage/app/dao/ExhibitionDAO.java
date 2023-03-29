package com.miage.app.dao;

import com.miage.app.Entity.Exhibition;
import com.miage.app.Entity.Oeuvre;

public interface ExhibitionDAO {

    public abstract void createExhibition(Exhibition exhibition);

    public abstract void updateExhibition(Exhibition exhibition);

    public abstract void deleteExhibition(Exhibition exhibition);

    public abstract Exhibition getExhibitionById(int o);

    public abstract Iterable<Exhibition> getAllExhibition();


}
