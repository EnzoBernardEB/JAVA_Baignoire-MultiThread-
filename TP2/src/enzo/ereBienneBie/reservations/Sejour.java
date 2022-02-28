package enzo.ereBienneBie.reservations;

import enzo.ereBienneBie.logements.Logement;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sejour implements SejourInterface,Cloneable {
    protected Date dateArrivee;
    protected int nbNuits;
    protected Logement logement;
    protected int nbVoyageurs;
    protected Date dateActuelle;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = new Date(dateArrivee.getDate(),dateArrivee.getMonth(),dateArrivee.getYear());
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        this.dateActuelle = new Date();
    }

    public Date getDateArrivee() {
        return new Date(this.dateArrivee.getDate(),dateArrivee.getMonth(),dateArrivee.getYear());
    }

    public Date getDateActuelle() {
        return new Date(this.dateArrivee.getDate(),dateArrivee.getMonth(),dateArrivee.getYear());
    }

    @Override
    public boolean verificationDateArrivee() {
        if (dateArrivee.compareTo(this.dateActuelle) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        if (nbNuits >= 1 && nbNuits <= 31) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        if (logement.getNbVoyageursMax() >= nbVoyageurs) {
            return true;
        }
        return false;
    }

    public abstract void setLogement(Logement logement);

    @Override
    public void afficher() {
        //SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
        logement.afficher();
        //System.out.println("La date d'arrivée est le "+date.format(dateArrivee)+" pour "+nbNuits+" nuits.");
        System.out.println("La date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");

    }

    public abstract void miseAjourDuTarif();

    @Override
    protected abstract Sejour clone();
}
