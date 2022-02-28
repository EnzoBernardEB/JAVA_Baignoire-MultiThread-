package enzo.ereBienneBie.outils.filterPattern;

import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.logements.Maison;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CriterePossedePiscine implements Criteres {
    int possedePiscine;
    public CriterePossedePiscine(int possedePiscine) {
        this.possedePiscine = possedePiscine;
    }

    @Override
    public boolean possedeLeCritere(Logement logement) {
        if(possedePiscine == 1) {
            if(logement instanceof Maison && ((Maison)logement).isPossedePiscine()) {
                return true;
            }
            return false;
        }
        return true;
    }

}
