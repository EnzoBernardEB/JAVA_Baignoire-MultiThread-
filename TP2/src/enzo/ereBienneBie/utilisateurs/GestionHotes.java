package enzo.ereBienneBie.utilisateurs;

import enzo.ereBienneBie.menu.Menu;

public class GestionHotes {

    public static void listerHotes() {

        System.out.println("-------------------------------------");
        System.out.println("Liste des hôtes ");

        // Afficher la liste des hôtes

        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        switch (Menu.choix(3)) {
            case 1:
                ajouterHote();
                break;
            case 2:
                supprimerHote();
                break;
            case 3:
                Menu.listerMenu();
                break;
        }
    }

    private static void ajouterHote() {

        System.out.println("-------------------------------------");
        System.out.println("Ajouter un nouvel hôte");

        // TODO

        listerHotes();
    }

    private static void supprimerHote() {

        System.out.println("-------------------------------------");
        System.out.println("Supprimer un hôte");

        // TODO

        listerHotes();
    }
}
