package project;

public enum Pays {

    FRANCE("France"),
    CANADA("Canada"),
    EU("Etats-Unis"),
    CHINE("Chine"),
    BRESIL("Brésil"),
    ALGERIE("Algérie"),
    ITALIE("Italie"),
    TUNISIE("Tunisie"),
    PAKISTAN("Pakistan");

    public String pays;

    Pays(String pays) {
        this.pays = pays;
    }

    public String getPays() {
        return this.pays;
    }
}
