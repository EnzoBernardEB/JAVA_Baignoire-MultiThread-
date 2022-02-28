package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.utilisateurs.Hote;

public abstract class Logement implements Comparable<Logement>{
    protected final String nom;
    protected final Hote hote;
    protected final int tarifJournalier;
    protected final String adresse;
    protected final int superficie;
    protected final int nbVoyageursMax;

    public Logement(String nom,Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax) {
        this.nom = nom;
        this.hote = hote;
        this.tarifJournalier = tarifJournalier;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public String getNom() {
        return nom;
    }


    public int getTarifJournalier() {
        return tarifJournalier;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }


    public abstract int getSuperficieTotal();
    public abstract void afficher();

    @Override
    public int compareTo(Logement o) {
        if(this.tarifJournalier>o.tarifJournalier) {
            return 1;
        }
        return 0;
    }
}
