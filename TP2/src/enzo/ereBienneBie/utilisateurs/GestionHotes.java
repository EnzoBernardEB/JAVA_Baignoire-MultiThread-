package enzo.ereBienneBie.utilisateurs;

import enzo.ereBienneBie.menu.Menu;
import enzo.ereBienneBie.outils.ChoixScanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionHotes {

    public static void listerHotes(Scanner scanner) {

        System.out.println("-------------------------------------");
        System.out.println("Liste des hôtes ");
        if (Menu.listHotes.size() > 0) {
            for (Hote hote : Menu.listHotes) {
                hote.afficher();
            }
        } else  {
            System.out.println("Pas d'hote pour le moment.");
        }

        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        switch (ChoixScanner.choixMultiProposition(scanner,3)) {
            case 1:
                try {
                    Menu.listHotes.add(ajouterHote(scanner));
                    listerHotes(scanner);
                } catch (InputMismatchException e) {
                    System.out.println("L'entrée n'est pas valide. Veuillez bien saisir un nombre pour l'age et le delai de réponse");
                    listerHotes(scanner);
                }
                break;
            case 2:
                supprimerHote(scanner);
                break;
            case 3:
                Menu.listerMenu(scanner);
                break;
        }
    }

    private static Hote ajouterHote(Scanner scanner) throws InputMismatchException {

        System.out.println("-------------------------------------");
        System.out.println("Ajouter un nouvel hôte");
        System.out.println("Nom =>");
        String nom = scanner.next();
        System.out.println("Prenom =>");
        String prenom = scanner.next();
        System.out.println("Age =>");
        int age = ChoixScanner.verificationRetourIntAvecExceptionLance(scanner);
        System.out.println("Delai de réponse =>");
        int delaiDeReponse = ChoixScanner.verificationRetourIntAvecExceptionLance(scanner);
        Hote nouvelHote = new Hote(prenom, nom, age, delaiDeReponse);
        return nouvelHote;
    }

    private static void supprimerHote(Scanner scanner) {

        System.out.println("-------------------------------------");
        System.out.println("Supprimer un hôte");

        // TODO

        listerHotes(scanner);
    }


}
