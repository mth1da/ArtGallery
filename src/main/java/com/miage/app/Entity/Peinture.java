package com.miage.app.Entity;

public class Peinture extends  Oeuvre{
    public Peinture(int id, String name, int idProprio, int idArtiste, double p) {
        super(id, name, idProprio, idArtiste, p);
    }

    @Override
    public String getPresentationOeuvre() {
        return "La peinture nommée "+getName()+"est très impressionante du fait de sa particularité"+
                "peinte avec de l'encre spécial ce qui élève son prix a "+getPrice();
    }

    @Override
    protected String getInfoSupp() {
        return "peint à l'encre acrylique";
    }
}
