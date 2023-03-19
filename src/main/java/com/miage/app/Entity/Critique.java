package com.miage.app.Entity;

public class Critique {
    private final int idCritique;
    private String commentaire;
    private int note;
    private final int oeuvre;
    private final int user;

    //Constructeur
    public Critique(int idCritique, String commentaire, int note, int oeuvre, int user) {
        this.idCritique = idCritique;
        this.commentaire = commentaire;
        this.note = note;
        this.oeuvre = oeuvre;
        this.user = user;
    }

    public int getIdCritique(){
        return this.idCritique;
    }

    public String getCommentaire(){
        return this.commentaire;
    }

    public int getNote(){
        return this.note;
    }

    public int getOeuvre(){
        return this.oeuvre;
    }

    public int getUser(){
        return this.user;
    }

    public void setNote(int newNote){
        this.note=newNote;
    }

    public void setCommentaire(String commentaire){
        this.commentaire=commentaire;
    }

}
