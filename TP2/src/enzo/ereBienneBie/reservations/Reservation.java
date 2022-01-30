package enzo.ereBienneBie.reservations;

import enzo.ereBienneBie.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private int identifiant;
    private Voyageur voyageur;
    private Sejour sejour;
    private boolean esValidee;
    private Date dateDeReservation;

    public Reservation(Voyageur voyageur, Sejour sejour) {
        this.voyageur = voyageur;
        this.sejour = sejour;

    }

    public void afficher() {
        voyageur.afficher();
        System.out.print(" a fait une reservation chez ");
        sejour.afficher();
        System.out.println();
    }
}
