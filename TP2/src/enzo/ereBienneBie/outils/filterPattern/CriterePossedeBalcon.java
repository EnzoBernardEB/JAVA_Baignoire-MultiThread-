package enzo.ereBienneBie.outils.filterPattern;

import enzo.ereBienneBie.logements.Appartement;
import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.logements.Maison;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CriterePossedeBalcon implements Criteres {
    int possedeBalcon;
    public CriterePossedeBalcon(int possedeBalcon) {
        this.possedeBalcon = possedeBalcon;
    }

    @Override
    public boolean possedeLeCritere(Logement logement) {
        if(possedeBalcon==1) {
            if(logement instanceof Appartement && ((Appartement)logement).getSuperficieBalcon()>0) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;

    }
}
