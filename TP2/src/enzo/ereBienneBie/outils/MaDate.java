package enzo.ereBienneBie.outils;

import java.util.Date;

public class MaDate extends Date {

    /**
     *
     * @param jour
     * @param mois
     * @param annee
     */
    public MaDate(int jour, int mois, int annee) {
        super(annee-1900,mois-1,jour);
    }

    @Override
    public String toString() {
        return this.getDate()+"/"+this.getMonth()+"/"+this.getYear();
    }
}
