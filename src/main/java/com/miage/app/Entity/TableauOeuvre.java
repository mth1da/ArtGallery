package com.miage.app.Entity;

public class TableauOeuvre extends Oeuvre{
    public TableauOeuvre(int id, String name, int idProprio, int idArtiste, double p, String type) {
        super(id, name, idProprio, idArtiste, p, type);
    }

    @Override
    public String getPresentationOeuvre() {
        String s="Ma fameuse oeuvre de type "+this.getType()+
                " se nomme "+this.getName()+
                " et a pour prix "+this.getPrice()+
                "€.";
        return s;
    }

    @Override
    protected void getInfoSupp() {

    }
}
