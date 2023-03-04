package project;

public class Exposition {
    
    public int id;
    public String date;
    public Lieu lieu;
    public int nbVisiteMax;
    public int superficieSalle;

    Exposition(int id, String date, Lieu lieu, int nbVisiteMax, int superficieSalle) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.nbVisiteMax = nbVisiteMax;
        this.superficieSalle = superficieSalle;
    }
}
