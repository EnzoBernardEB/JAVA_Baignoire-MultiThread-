package enzo.ereBienneBie.outils;

import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.outils.filterPattern.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Search {
    //required parameters
    private final int nbVoyageurs;

    //optional parameters
    private final int tarifMinParNuit;
    private final int tarifMaxParNuit;
    private final int possedePiscine;
    private final int possedeJardin;
    private final int possedeBalcon;


    public int getnbVoyageurs() {
        return nbVoyageurs;
    }

    public int getTarifMinParNuit() {
        return tarifMinParNuit;
    }

    public int getTarifMaxParNuit() {
        return tarifMaxParNuit;
    }

    public int getPossedePiscine() {
        return possedePiscine;
    }

    public int getPossedeJardin() {
        return possedeJardin;
    }

    public int getPossedeBalcon() {
        return possedeBalcon;
    }

    private Search(SearchBuilder builder) {
        this.nbVoyageurs=builder.nbVoyageurs;
        this.tarifMaxParNuit = builder.tarifMaxParNuit;
        this.tarifMinParNuit = builder.tarifMinParNuit;
        this.possedeBalcon = builder.possedeBalcon;
        this.possedeJardin = builder.possedeJardin;
        this.possedePiscine = builder.possedePiscine;
    }

    //Builder Class
    public static class SearchBuilder{

        //required parameters
        private final int nbVoyageurs;

        //optional parameters
        private int tarifMinParNuit=0;
        private int tarifMaxParNuit=Integer.MAX_VALUE;
        private int possedePiscine=-1;
        private int possedeJardin=-1;
        private int possedeBalcon=-1;


        public SearchBuilder(int nbVoyageurs){
            this.nbVoyageurs = nbVoyageurs;
        }

        public SearchBuilder tarifMinParNuit(int tarif) {
            this.tarifMinParNuit = tarif;
            return this;
        }

        public SearchBuilder tarifMaxParNuit(int tarif) {
            this.tarifMaxParNuit = tarif;
            return this;
        }
        public SearchBuilder possedePiscine(boolean possedePiscine) {
            if(possedePiscine)
                this.possedePiscine = 1;
            return this;
        }
        public SearchBuilder possedeJardin(boolean possedeJardin) {
            if(possedeJardin)
                this.possedeJardin = 1;
            return this;
        }
        public SearchBuilder possedeBalcon(boolean possedeBalcon) {
            if(possedeBalcon)
                this.possedeBalcon = 1;
            return this;
        }

        public Search build(){
            return new Search(this);
        }

    }
    public ArrayList<Logement> result() {
        ArrayList<Logement> retour;
        Criteres tarifMin= new CritereTarifMinimum(this.tarifMinParNuit);
        Criteres tarifMax = new CritereTarifMaximum(this.tarifMaxParNuit);
        Criteres possedeBalcon = new CriterePossedeBalcon(this.possedeBalcon);
        Criteres possedePiscine = new CriterePossedePiscine(this.possedePiscine);
        Criteres possedeJardin = new CriterePossedeJardin(this.possedeJardin);

        retour = EreBienneBieData.getInstance().listeLogements.stream()
                .filter(logement -> (tarifMax.possedeLeCritere(logement)
                        && (tarifMin.possedeLeCritere(logement))
                        && (possedeBalcon.possedeLeCritere(logement))
                        && (possedeJardin.possedeLeCritere(logement))
                        && (possedePiscine.possedeLeCritere(logement))))
                .collect(Collectors.toCollection(ArrayList::new));
        return retour;

    }
}
