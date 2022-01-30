package enzo.ereBienneBie.utilisateurs;

public class Voyageur extends Personne{

    public Voyageur(String nom,String prenom, int age) {
        super(prenom,nom,age);
    }

    @Override
    public void afficher() {
        System.out.print(this.prenom+" "+this.nom+" ("+this.age+" ans)");
    }
}
