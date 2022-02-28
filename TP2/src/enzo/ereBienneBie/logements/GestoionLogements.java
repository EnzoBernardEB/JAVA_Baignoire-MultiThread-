package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.menu.Menu;
import enzo.ereBienneBie.utilisateurs.Hote;

import java.util.Scanner;

public class GestoionLogements {
    public static void listerLogements() {

        for (Logement logement : Menu.listLogements) {
            logement.afficher();
        }
    }
}
