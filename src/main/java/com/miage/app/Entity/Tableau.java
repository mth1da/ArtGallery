package com.miage.app.Entity;

public class Tableau extends Oeuvre{
    public Tableau(int id, String name, int idProprio, int idArtiste, double p, String nom_type) {
        super(id, name, idProprio, idArtiste, p, nom_type);
    }

    @Override
    public String getPresentationOeuvre() {
        return "Un tableau nommé"+getName()+" est le moyen d'exprimer ses sentiments"+
                "son prix inestimable est "+getPrice();
    }

    @Override
    protected String getInfoSupp() {
        return "Une hauteur > 2metre";
    }
}
