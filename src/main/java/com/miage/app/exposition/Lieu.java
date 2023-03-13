package com.miage.app.exposition;

public enum Lieu {
    
    PARIS("Paris"),
    MARSEILLE("Marseille"),
    LYON("Lyon"),
    TOULOUSE("Toulouse"),
    NICE("Nice"),
    NANTES("Nantes"),
    MONTPELLIER("Montpellier"),
    STRASBOURG("Strasbourg");

    public static String lieu;

    Lieu(String lieu) {

    }

    public static String getLieu() {
        return lieu;
    }

}