package com.miage.app.Fonctionnalitees;

import com.miage.app.Personne.User;
import com.miage.app.Repertoire.Repertoire;

public class Critique {
    private final User user;
    private String commentaire;
    private int note;
    private String date;


    public Critique(User user,String commentaire , int note,String date){
        this.commentaire=commentaire;
        this.note=note;
        this.date=date;
        if(user.getInfoConnexion()){
            this.user=user;
        }else{
            System.out.println("la critique ne peut etre faite qu'une fois connecté");
            throw new Error("critique échouée");
        }
    }

    public User getUser(){
        return this.user;
    }

    public String getCommentaire(){
        return commentaire;
    }

    public int getNote(){
        return note;
    }

    public String getDate(){
        return this.date;
    }

    public void updateCommentaire(String newCom){
        this.commentaire=newCom;
    }

    public void updateNote(int note){
        this.note=note;
    }

    public void displayCritique(){
        System.out.println(user.getPseudo()+" "+date+" : "+commentaire+" \n note : "+note);
    }

    public static void deleteCritique(Critique cr){
        Repertoire.dellCritiques(cr);
    }

    public static void addCritique(Critique cr){
        Repertoire.addCritiques(cr);
    }
       
}
