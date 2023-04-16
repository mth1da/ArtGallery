package com.miage.app.services;

import com.miage.app.Entity.Artiste;
import com.miage.app.dao.ArtisteDAO;
import com.miage.app.dao.OeuvreDAO;

public class GestionOeuvres {

    private OeuvreDAO oeuvreDAO;
    private ArtisteDAO artisteDAO;
    public GestionOeuvres(OeuvreDAO oeuvreDAO, ArtisteDAO artisteDAO){
        this.oeuvreDAO = oeuvreDAO;
        this.artisteDAO = artisteDAO;
    }

    public boolean ifArtisteExists(Artiste a) {
        return a != null;
    }

    public void addArtiste(Artiste a, String name, String lastName) {
        if(!ifArtisteExists(a)) {
            this.artisteDAO.createArtiste(name, lastName);
        }
    }

    public void creerOeuvre(String title, int userID, Artiste art, Double price) {
        this.oeuvreDAO.createOeuvre(title, userID, art, price);
    }

    public void suppOeuvre(int id) {
        this.oeuvreDAO.deleteOeuvre(id);
    }

    public void modifOeuvre(String title, Double price, int id) {
        this.oeuvreDAO.updateOeuvre(title, price, id);
    }


}