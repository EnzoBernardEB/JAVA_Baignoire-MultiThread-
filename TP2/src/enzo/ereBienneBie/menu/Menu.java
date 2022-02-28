package enzo.ereBienneBie.menu;

import com.sun.org.apache.bcel.internal.generic.DCONST;
import enzo.ereBienneBie.logements.Appartement;
import enzo.ereBienneBie.logements.GestoionLogements;
import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.logements.Maison;
import enzo.ereBienneBie.outils.ChoixScanner;
import enzo.ereBienneBie.outils.EreBienneBieData;
import enzo.ereBienneBie.outils.Search;
import enzo.ereBienneBie.reservations.Reservation;
import enzo.ereBienneBie.utilisateurs.GestionHotes;
import enzo.ereBienneBie.utilisateurs.Hote;
import enzo.ereBienneBie.utilisateurs.Personne;
import enzo.ereBienneBie.utilisateurs.Voyageur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Scanner scanner;
    public static ArrayList<Hote> listHotes = EreBienneBieData.getInstance().listeHotes;
    public static ArrayList<Logement> listLogements = EreBienneBieData.getInstance().listeLogements;
    //static ArrayList<Voyageur> listVoyageurs = EreBienneBieData.getInstance().listeVoyageurs;
    static ArrayList<Reservation> listReservations;

    public static void main(String[] args) {

        System.out.println("Bienvenu chez AirBnB");
        scanner = new Scanner(System.in);

//        for (Hote hotea:EreBienneBieData.getInstance().listeHotes
//             ) { hotea.afficher();
//        }
//        for (Logement log:EreBienneBieData.getInstance().listeLogements
//        ) { log.afficher();}


        //listerMenu(scanner);
        Search.SearchBuilder searchBuilder = new Search.SearchBuilder(2).tarifMinParNuit(150).possedeBalcon(false).tarifMaxParNuit(200);
        Search search = searchBuilder.build();
        ArrayList<Logement> retour = search.result();
        for (Logement log: retour
             ) {
            System.out.println("---");
            log.afficher();
        }


        scanner.close();
    }

    public static void listerMenu(Scanner scanner) {

        System.out.println("-------------------------------------");
        System.out.println("Saisir une option : ");
        System.out.println("1 : Liste des hôtes");
        System.out.println("2 : Liste des logements");
        System.out.println("3 : Liste des voyageurs");
        System.out.println("4 : Liste des réservations");
        System.out.println("5 : Fermer le programme");

        switch (ChoixScanner.choixMultiProposition(scanner,5)) {
            case 1:
                GestionHotes.listerHotes(scanner);
                break;
            case 2:
                GestoionLogements.listerLogements();
                break;
            case 3:
                //GestionVoyageurs.listerVoyageurs();
                break;
            case 4:
                //GestionReservations.listerReservations();
                break;
            case 5:
                System.out.println("A bientôt");
                break;
        }
    }


//    private static void init() {
//
//		listHotes = new ArrayList<>();
//		listLogements = new ArrayList<>();
//		listVoyageurs = new ArrayList<>();
//		listReservations = new ArrayList<>();
//
//
//		// Création des Hotes
//		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
//		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
//		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
//		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);
//
//		listHotes.add(hote1);
//		listHotes.add(hote2);
//		listHotes.add(hote3);
//		listHotes.add(hote4);
//
//		// Création de Logement
//		Maison maison1 = new Maison("MenuMaison1",hote1, 40, "18 rue De Tours, 37000 Tours", 140, 2, 500, true);
//		Maison maison2 = new Maison("MenuMaison2",hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
//		Maison maison3 = new Maison("MenuMaison3",hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
//		Appartement appartement1 = new Appartement("MenuAPpart1",hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
//		Appartement appartement2 = new Appartement("MenuAPpart2",hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);
//
//		listLogements.add(maison1);
//		listLogements.add(maison2);
//		listLogements.add(maison3);
//		listLogements.add(appartement1);
//		listLogements.add(appartement2);
//
//		// Création de voyageurs
//		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
//		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);
//
//		listVoyageurs.add(voyageur1);
//		listVoyageurs.add(voyageur2);
//	}

    private static Maison chercherMaison(String nom) {
        for (Logement logement: listLogements) {
            if(logement instanceof Maison && logement.getNom().equals(nom))
                return (Maison)logement;
        }
        return null;
    }
    private static Appartement chercherAppart(String nom) {
        for (Logement logement: listLogements) {
            if(logement instanceof Appartement && logement.getNom().equals(nom))
                return (Appartement)logement;
        }
        return null;
    }

    private static Logement chercherLogementParNom(String nom) {
        for (Logement logement: listLogements) {
            if(logement.getNom().equals(nom))
                return logement;
        }
        return null;
    }

    private static <E extends Logement> E chercherLogementGeneriqueParNom(String nom) {
        for (Logement logement: listLogements) {
            if(logement.getNom().equals(nom))
                return (E) logement;
        }
        return null;
    }



}
