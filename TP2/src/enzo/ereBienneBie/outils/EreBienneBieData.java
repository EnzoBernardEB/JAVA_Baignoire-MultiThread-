package enzo.ereBienneBie.outils;

import enzo.ereBienneBie.datafile.file;
import enzo.ereBienneBie.logements.Logement;
import enzo.ereBienneBie.utilisateurs.Hote;
import enzo.ereBienneBie.utilisateurs.Voyageur;

import javax.swing.*;
import java.util.ArrayList;

public class EreBienneBieData {
    private static volatile EreBienneBieData instance = null;
    public ArrayList<Hote> listeHotes;
    public ArrayList<Logement> listeLogements;
    //public ArrayList<Voyageur> listeVoyageurs;

    // private constructor
    private EreBienneBieData() {
        this.listeHotes = file.recupererHotesXML();
        this.listeLogements = file.recupererLogementsXML();
    }

    public static EreBienneBieData getInstance() {
        if (instance == null) {
            synchronized (EreBienneBieData.class) {
                // Double check
                if (instance == null) {
                    instance = new EreBienneBieData();
                }
            }
        }
        return instance;
    }
}
