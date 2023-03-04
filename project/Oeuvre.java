package project;


import java.util.List;

public class Oeuvre {

    public String nomOeuvre;
    public String dateOeuvre;
    public String mouvement;
    public Artiste artiste;
    public int prix;

    public Oeuvre(String nomOeuvre, String dateOeuvre, String mouvement, Artiste artiste, int prix) {
        this.nomOeuvre = nomOeuvre;
        this.dateOeuvre = dateOeuvre;
        this.mouvement = mouvement;
        this.artiste = artiste;
        this.prix = prix;
    }

    public String getNomOeuvre() {
        return this.nomOeuvre;
    }

    public String getDateOeuvre() {
        return this.dateOeuvre;
    }

    public String getMouvement() {
        return this.mouvement;
    }

    public int getPrix() {
        return this.prix;
    }

    //Ajouter une oeuvre

    public List<Oeuvre> ajoutOeuvre(Oeuvre oeuvre) {

        Proprio.oeuvres.add(oeuvre);
        return Proprio.oeuvres;
            
    }

    //Supprimer une oeuvre

    public List<Oeuvre> supprimeOeuvre(Oeuvre oeuvre) {

        Proprio.oeuvres.remove(oeuvre);
        return Proprio.oeuvres;
            
    }

    //Afficher les informations d’une oeuvre

    public void afficheInfosOeuvre(Oeuvre oeuvre) {
        System.out.println("Nom de l'oeuvre: " + oeuvre.getNomOeuvre());
        System.out.println("Date de l'oeuvre: " + oeuvre.getDateOeuvre());
        System.out.println("Mouvement: " + oeuvre.getMouvement());
        System.out.println("Thème de l'oeuvre: " + Pays.getPays());
        System.out.println("Artiste: " + Artiste.getArtiste());
        System.out.println("Prix: " + oeuvre.getPrix());
    }

}
