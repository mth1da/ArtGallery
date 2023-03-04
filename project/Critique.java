package project;

public class Critique {
    
    public User user;
    public String date;
    public String commentaire;

    Critique(String commentaire, String date, User user) {
        this.commentaire = commentaire;
        this.date = date;
        this.user = user;
    }
}
