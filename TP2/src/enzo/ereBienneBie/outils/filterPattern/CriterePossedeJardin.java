package enzo.ereBienneBie.outils.filterPattern;

import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.logements.Maison;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CriterePossedeJardin implements Criteres, Predicate {
    int possedeJardin;

    public CriterePossedeJardin(int possedeJardin) {
        this.possedeJardin = possedeJardin;
    }

    @Override
    public boolean possedeLeCritere(Logement logement) {
        if(possedeJardin==1){
            if(logement instanceof Maison && ((Maison)logement).getSuperficieJardin() >0 && possedeJardin==1) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public Predicate and(Predicate other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate or(Predicate other) {
        return Predicate.super.or(other);
    }
}
