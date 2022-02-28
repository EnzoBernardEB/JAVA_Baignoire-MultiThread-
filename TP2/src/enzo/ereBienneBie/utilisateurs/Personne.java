package enzo.ereBienneBie.utilisateurs;

public abstract class Personne implements Comparable<Personne> {
    protected final String prenom;
    protected final String nom;
    protected final int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    @Override
    public int compareTo(Personne o) {
        if(this.age >  o.getAge() )
            return 1;
        return 0;
    }

    public void afficher() {}

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
}
