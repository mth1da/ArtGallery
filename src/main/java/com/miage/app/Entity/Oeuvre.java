package com.miage.app.Entity;

public abstract class Oeuvre {
    private final int id;
    private final String name;
    private final int idProprio;
    private final int idArtiste;
    private double price;

    protected Oeuvre(int id, String name, int idProprio, int idArtiste,double p) {
        this.id = id;
        this.name = name;
        this.idProprio = idProprio;
        this.idArtiste = idArtiste;
        this.price=p;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getIdProprio(){
        return this.idProprio;
    }

    public int getIdArtiste(){
        return this.idArtiste;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public abstract String getPresentationOeuvre();

    protected abstract void getInfoSupp();


}
