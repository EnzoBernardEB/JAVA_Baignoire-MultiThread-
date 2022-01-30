package enzo.ereBienneBie.reservations;

import enzo.ereBienneBie.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour{
    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;
    private int tarif;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        this.tarif = Math.round((this.logement.getTarifJournalier()*this.nbNuits)*(1-((float)PROMOTION_EN_POURCENTAGE/100)) );
        this.promotion = (nbNuits * logement.getTarifJournalier())-tarif;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de " + this.tarif + "€ ("+this.promotion+"€ de promotion)");
    }

    @Override
    public void miseAjourDuTarif(int nouveauTarif) {
        this.logement.setTarifJournalier(nouveauTarif);
    }
}
