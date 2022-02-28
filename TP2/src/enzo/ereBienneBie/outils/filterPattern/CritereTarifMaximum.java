package enzo.ereBienneBie.outils.filterPattern;

import enzo.ereBienneBie.logements.Logement;



public class CritereTarifMaximum implements Criteres {
    int tarif;

    public CritereTarifMaximum(int tarif) {
        this.tarif = tarif;
    }

    @Override
    public boolean possedeLeCritere(Logement logement) {
            if(logement.getTarifJournalier()<=tarif) {
                return true;
            }
        return false;
    }
}
