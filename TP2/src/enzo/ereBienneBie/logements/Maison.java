package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.utilisateurs.Hote;

public class Maison extends Logement {
    private final int superficieJardin;
    private final boolean possedePiscine;

    public Maison(String nom,Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int superficieJardin,boolean possedePiscine) {
        super(nom,hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    public int getSuperficieJardin() {
        return superficieJardin;
    }

    public boolean isPossedePiscine() {
        return possedePiscine;
    }

    @Override
    public int getSuperficieTotal() {
        return 0;
    }

    @Override
    public void afficher() {
        this.hote.afficher();
        System.out.println("Prix : "+this.getTarifJournalier());
        System.out.println("Le logement "+this.nom+" est une maison située "+this.adresse+".");
        System.out.println("Superficie : "+this.superficie+"m²");
        if(this.superficieJardin > 0) {
            System.out.println("Jardin : oui ("+this.superficieJardin+"m²)");
        } else {
            System.out.println("Jardin : Non");
        }
        if(this.possedePiscine) {
            System.out.println("Piscine : oui");
        } else {
            System.out.println("Piscine : non");
        }
    }
}
