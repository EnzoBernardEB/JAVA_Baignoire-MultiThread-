package enzo.ereBienneBie.outils;

import enzo.ereBienneBie.outils.exceptions.ExceptionNombresDateInvalide;
import enzo.ereBienneBie.outils.exceptions.ExceptionformatDateString;

import java.util.Calendar;
import java.util.Date;

public final class Utile {

    private Utile() {
    }

    public static Date construireDate(String date) throws Exception {
        String[] elements = date.split(" ");
        Calendar calendrier = Calendar.getInstance();
        int annee = convertirEnInt(elements[2]);
        int jour = convertirEnInt(elements[0]);
        int moisRechercher = recupererMois(elements[1]);

        verifierJourComprisDansMois(jour);

        calendrier.set(Calendar.YEAR, annee);
        calendrier.set(Calendar.MONTH, moisRechercher - 1);
        calendrier.set(Calendar.DAY_OF_MONTH, jour);

        return calendrier.getTime();
    }

    public static Date construireDate(int jour, int mois, int annee) throws Exception {
        verifierJourComprisDansMois(jour);
        verifierMoisComprisDansAnnee(mois);
        Calendar calendrier = Calendar.getInstance();
        calendrier.set(Calendar.YEAR, annee);
        calendrier.set(Calendar.MONTH, mois);
        calendrier.set(Calendar.DAY_OF_MONTH, jour);
        return calendrier.getTime();
    }

    private static void verifierJourComprisDansMois(int jour) throws ExceptionNombresDateInvalide {
        if (jour > 31 || jour <= 0) {
            throw new ExceptionNombresDateInvalide();
        }
    }

    private static void verifierMoisComprisDansAnnee(int mois) {
        if (mois > 12 || mois <= 0) {
            System.out.println(new ExceptionNombresDateInvalide().toString());
            System.exit(1);
        }
    }

    /**
     *
     * @param elementAConvertir
     * @return un int
     * @throws ExceptionformatDateString
     */
    private static int convertirEnInt(String elementAConvertir) throws ExceptionformatDateString {
        try {
            return Integer.parseInt(elementAConvertir);
        } catch (NumberFormatException exception) {
            throw new ExceptionformatDateString();
        }
    }

    private static int recupererMois(String mois) throws ExceptionformatDateString {
        for (Mois m : Mois.values()) {
            if (m.name().equalsIgnoreCase(mois)) {
                return m.mois;
            }
        }
        throw new ExceptionformatDateString();
    }
}
