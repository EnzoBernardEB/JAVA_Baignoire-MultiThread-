package enzo.ereBienneBie.utilisateurs;


public class Hote extends Personne {

    private final int delaiDeReponse;

    public Hote(String prenom, String nom, int age, int delaiDeReponse) {
        super(prenom, nom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        if(this.delaiDeReponse>1) {
        System.out.println(this.prenom+" "+this.nom+" ("+this.age+" ans) qui s'engage à prépondre dans les "+delaiDeReponse+" heures.");
        } else {
            System.out.println(this.prenom+" "+this.nom+" ("+this.age+" ans) qui s'engage à prépondre dans l'heure");
        }
    }

    @Override
    public int compareTo(Personne o) {
        if(o instanceof Hote && this.delaiDeReponse > ((Hote) o).delaiDeReponse)
            return 1;
        return 0;
    }
}
