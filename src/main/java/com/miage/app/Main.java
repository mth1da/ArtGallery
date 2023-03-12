package com.miage.app;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.miage.app.Fonctionnalitees.Authentification;
import com.miage.app.Fonctionnalitees.Critique;
import com.miage.app.Fonctionnalitees.InsciptionService;
import com.miage.app.Fonctionnalitees.InscriptionProprio;
import com.miage.app.Fonctionnalitees.InscriptionVisiteur;
import com.miage.app.Repertoire.Repertoire;
import com.miage.app.Personne.User;

public class Main extends JFrame{
    static Scanner sc=new Scanner(System.in);
    public void initialize(){
        JPanel mp=new JPanel();
        setTitle("welcome");
        setSize(500,600);
        setVisible(true);

    }
    public static void main(String [] args){
        //Main m=new Main();
      // m.initialize();

        System.out.println("Bienvenue dans la galerie d'Art");
        System.out.println("Veuillez vous connecter afin d'accéder aux différentes fonctionnalitées");
        System.out.println("Si vous souhaitez vous connecter tapez 1");
        System.out.println("Si vous souhaitez vous inscrire tapez 2");
        int value=sc.nextInt();
        
        if(value==1){
            Authentification a=new Authentification("12/12/2023", "iphone");
            a.seConnecter();
            if(a.getStatutConnexion()){
                User u=a.getUser();
            }
        }
        else{
            System.out.println("Si vous souhaitez vous inscrire en tant que propriétaire tapez 1");
            System.out.println("Sinon tapez 2");
            int rep=sc.nextInt();
            InsciptionService v;
            if(rep==1){
                v=new InscriptionProprio("12/12/2023","iphone");
            }else{
                v=new InscriptionVisiteur();
            }
            v.creeCompte();
            if(v.getStatutInscription()){
                User u2=v.getUser();
            }
        }
       
        Authentification a=new Authentification("12/12/2023", "iphone");
            a.seConnecter();
            if(a.getStatutConnexion()){
                User u=a.getUser();
            }
        
        Repertoire.displayUsersInscrit();
        Repertoire.displayUsersConnceter();
        Repertoire.displayCritiques();

        //pays enum
        //lieu enum
        //verification autre classe
    }
}
