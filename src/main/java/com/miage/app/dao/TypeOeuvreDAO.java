package com.miage.app.dao;

import com.miage.app.Entity.TypeOeuvre;

public interface TypeOeuvreDAO {

   void createType(String name, String description);

    void deleteType(int idType);

    Iterable<TypeOeuvre> getAllTypes();
}
