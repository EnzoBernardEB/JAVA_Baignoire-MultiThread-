package enzo.ereBienneBie.reservations;

import enzo.ereBienneBie.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {
    private int tarif;

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de " + nbNuits * logement.getTarifJournalier() + "€");
    }

    @Override
    public void miseAjourDuTarif(int nouveauTarif) {
        this.logement.setTarifJournalier(nouveauTarif);
    }
}
