package enzo.ereBienneBie.logements;

import enzo.ereBienneBie.utilisateurs.Hote;

public class Appartement extends Logement {
    private int numeroEtage;
    private int superficieBalcon;

    public Appartement(Hote hote, int tarifJournalier, String adresse, int superficie, int nbVoyageursMax, int numeroEtage, int superficieBalcon) {
        super(hote, tarifJournalier, adresse, superficie, nbVoyageursMax);
        this.superficieBalcon = superficieBalcon;
        this.numeroEtage = numeroEtage;
    }

    @Override
    public int getSuperficieTotal() {
        return 0;
    }

    @Override
    public void afficher() {
        this.hote.afficher();
        System.out.print("Le logement est un appartement située "+this.adresse+" au ");
        if(numeroEtage==1) {
            System.out.print("1er étage.");
        } else if(numeroEtage== 0) {
            System.out.print("rez-de-chaussée.");
        } else {
            System.out.print(numeroEtage+"ème étage.");
        }
        System.out.println("Superficie : "+this.superficie+"m²");
        if(this.superficieBalcon > 0) {
            System.out.println("Balcon : oui ("+this.superficieBalcon+"m²)");
        } else {
            System.out.println("Balcon : Non");
        }
    }
}
