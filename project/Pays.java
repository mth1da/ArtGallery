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

    public static String pays;

    Pays(String pays) {

    }

    public static String getPays() {
        return pays;
    }
}
