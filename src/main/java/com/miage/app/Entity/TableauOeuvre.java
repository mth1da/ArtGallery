package com.miage.app.Entity;

public class TableauOeuvre extends Oeuvre{
    public TableauOeuvre(int id, String name, int idProprio, int idArtiste, double p) {
        super(id, name, idProprio, idArtiste, p);
    }

    @Override
    public String getPresentationOeuvre() {
        String s="Ma fameuse oeuvres se nomme  "+this.getName()+" elle a pour prix "+this.getPrice();
        return s;
    }

    @Override
    protected String getInfoSupp() {
        return  "";
    }
}
