package mypackage;

import java.util.List;

public class Oeuvre {

    public String nomOeuvre;
    public String dateOeuvre;
    public String stylePeinture;
    public String pays;
    public Artiste artiste;

    public String getNomOeuvre() {
        return this.nomOeuvre;
    }

    public String getDateOeuvre() {
        return this.dateOeuvre;
    }

    public String getStylePeinture() {
        return this.stylePeinture;
    }

    public String getPays() {
        return this.pays;
    }

    public Artiste getArtiste() {
        return this.artiste;
    }

    //Ajouter une oeuvre

    public List<Oeuvre> ajoutOeuvre(Oeuvre oeuvre) {

        Utilisateur.oeuvres.add(oeuvre);
        return Utilisateur.oeuvres;
            
    }

    //Supprimer une oeuvre

    public List<Oeuvre> supprimeOeuvre(Oeuvre oeuvre) {

        Utilisateur.oeuvres.remove(oeuvre);
        return Utilisateur.oeuvres;
            
    }

    //Afficher les informations d’une oeuvre

    public void afficheInfosOeuvre(Oeuvre oeuvre) {
        System.out.println("Nom de l'oeuvre: " + oeuvre.getNomOeuvre());
        System.out.println("Date de l'oeuvre: " + oeuvre.getDateOeuvre());
        System.out.println("Style de peinture: " + oeuvre.getStylePeinture());
        System.out.println("Thème de l'oeuvre: " + oeuvre.getPays());
        System.out.println("Artiste: " + oeuvre.getArtiste());
    }

}
