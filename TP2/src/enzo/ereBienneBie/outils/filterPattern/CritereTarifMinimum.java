package enzo.ereBienneBie.outils.filterPattern;

import enzo.ereBienneBie.logements.Logement;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CritereTarifMinimum implements Criteres {
    int tarif;

    public CritereTarifMinimum(int tarif) {
        this.tarif = tarif;
    }

    @Override
    public boolean possedeLeCritere(Logement logement) {
            if(logement.getTarifJournalier()>=tarif)
                return true;
            return false;
    }
}
