package com.miage.app.Entity;

public class Sculpture extends Oeuvre{
    public Sculpture(int id, String name, int idProprio, int idArtiste, double p) {
        super(id, name, idProprio, idArtiste, p);
    }

    @Override
    public String getPresentationOeuvre() {
        return "la sculpture "+getName()+" est la pour montrer la grandeur du sculpteur"+
                "du fait de son poid le prix de la sculpture s'élève à "+getPrice();
    }

    @Override
    protected String getInfoSupp() {
        return "Son poids est > 500kg";
    }
}
