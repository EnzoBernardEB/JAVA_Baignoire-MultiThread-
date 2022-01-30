package enzo.ereBienneBie.utilisateurs;

public abstract class Personne {
    protected String prenom;
    protected String nom;
    protected int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public void afficher() {}
}
