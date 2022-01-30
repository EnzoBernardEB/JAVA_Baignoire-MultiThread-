package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.utilisateurs.Hote;

public class Maison extends Logement {
    private int superficieJardin;
    private boolean possedePiscine;

    public Maison(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int superficieJardin,boolean possedePiscine) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    @Override
    public int getSuperficieTotal() {
        return 0;
    }

    @Override
    public void afficher() {
        this.hote.afficher();
        System.out.println("Le logement est une maison située "+this.adresse+".");
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
