package com.miage.app.dao;

import com.miage.app.Entity.Oeuvre;

public interface DataStorageDAO {

    public abstract void create(Object object);

    public abstract void update(Object object);

    public abstract void delete(Object object);

    public abstract Oeuvre getObjectById(Object object);

    public abstract Iterable<Object> getAllObjects();

}
