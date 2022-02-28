package enzo.ereBienneBie.outils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoixScanner {

    /**
     * Méthode qui permet de retourner le numéro de la proposition choisi par l'utilisateur. Rentrer en parametre le nombre de proposition.
     * @param scanner
     * @param nbrDeChoixTotal
     * @return
     */
    public static int choixMultiProposition(Scanner scanner,int nbrDeChoixTotal) {
        int choix = 0;
        do {
            try {
                choix = scanner.nextInt();
                if(  choix < 1 || choix > nbrDeChoixTotal) {
                    System.out.println("Entre 1 et "+nbrDeChoixTotal);
                }
            } catch (InputMismatchException erreur) {
                System.out.println("Ce n'est pas valide ! Saisissez des nombres");
                scanner.next();
            }
        } while(( choix < 1 || choix > nbrDeChoixTotal));

        return choix;
    }

    /**
     * Méthode qui vérifie si l'utilisateur saisie bien un Int. Si pas valide, relance l'exception InputMissMatchException à traité plus haut
     * @param scanner
     * @return
     * @throws InputMismatchException
     */
    public static int verificationRetourIntAvecExceptionLance(Scanner scanner) throws InputMismatchException {
        int retour = 0;
        try {
            retour = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
        return retour;
    }

    /**
     * Méthode qui vérifie si l'utilisateur saisie bien un Int, boucle tant que la saisie n'est pas valide. Exception InputMissMatchExecption traité.
     * @param scanner
     * @return Un entier
     *
     */
    public static int verificationRetourIntAvecExceptionTraite(Scanner scanner) {
        int retour = 0;
        boolean valide = false;
        do {
            try {
                retour = scanner.nextInt();
                valide=true;
            } catch (InputMismatchException e) {
                System.out.println("La saisie n'est pas valide, veuillez saisir un nombre.");
                scanner.next();
            }
        } while (!valide);

        return retour;
    }
}
