package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.utilisateurs.Hote;

public abstract class Logement {
    protected Hote hote;
    protected int tarifJournalier;
    protected String adresse;
    protected int superficie;
    protected int nbVoyageursMax;

    public Logement(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifJournalier = tarifJournalier;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public Hote getHote() {
        return hote;
    }

    public int getTarifJournalier() {
        return tarifJournalier;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public void setTarifJournalier(int tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }

    public abstract int getSuperficieTotal();
    public abstract void afficher();
}
