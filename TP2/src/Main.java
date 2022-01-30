import enzo.ereBienneBie.logements.Appartement;
import enzo.ereBienneBie.logements.Maison;
import enzo.ereBienneBie.outils.MaDate;
import enzo.ereBienneBie.outils.Utile;
import enzo.ereBienneBie.outils.exceptions.ExceptionNombresDateInvalide;
import enzo.ereBienneBie.outils.exceptions.ExceptionformatDateString;
import enzo.ereBienneBie.reservations.Reservation;
import enzo.ereBienneBie.reservations.Sejour;
import enzo.ereBienneBie.reservations.SejourCourt;
import enzo.ereBienneBie.reservations.SejourLong;
import enzo.ereBienneBie.utilisateurs.Hote;
import enzo.ereBienneBie.utilisateurs.Voyageur;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Hote bob = new Hote("Bob", "Innette",42,24);
        Voyageur robert = new Voyageur("Robert", "Lingo",32);

        Maison maison1 = new Maison(bob,89,"13 avenue la bas,37 254 Tours",89,4,200,true);
        Maison maison2 = new Maison(bob,89,"13 avenue la bas,37 254 Tours",89,4,0,false);
        Appartement appart1 = new Appartement(bob,89,"13 avenue la bas,37 254 Tours",89,4,1,12);
        Appartement appart2 = new Appartement(bob,89,"13 avenue la bas,37 254 Tours",89,4,0,0);
        Appartement appart3 = new Appartement(bob,89,"13 avenue la bas,37 254 Tours",89,4,2,0);
        try {
            Date dateSejour1 = Utile.construireDate(12,12,2022);
            MaDate dateSejour = new MaDate(12,11,2022);
            Sejour sejour1 = new SejourCourt(dateSejour,4,maison1,2);
            Sejour sejour2 = new SejourCourt(dateSejour,5,maison2,2);
            Sejour sejour3 = new SejourCourt(dateSejour,6,appart1,2);
            Sejour sejour4 = new SejourLong(dateSejour,8,appart2,2);
            Sejour sejour5 = new SejourLong(dateSejour,10,appart3,2);
            //Sejour sejour = new Sejour(Utile.construireDate(31,13,2021),4,appart,2);

            Reservation reservation1 = new Reservation(robert,sejour1);
            Reservation reservation2 = new Reservation(robert,sejour2);
            Reservation reservation3 = new Reservation(robert,sejour3);
            Reservation reservation4 = new Reservation(robert,sejour4);
            Reservation reservation5 = new Reservation(robert,sejour5);
            reservation1.afficher();
            reservation2.afficher();
            reservation3.afficher();
            reservation4.afficher();
            reservation5.afficher();
            maison1.afficher();

        } catch (ExceptionformatDateString exceptionformatDateString) {
            System.out.println(exceptionformatDateString.toString());
        } catch (ExceptionNombresDateInvalide exceptionNombresDateInvalide) {
            System.out.println(exceptionNombresDateInvalide.toString());
        }






//        Date date = new Date();
//        System.out.println(convertirDateEnString(date));

    }

    public static String convertirDateEnString(Date date) {
        String jour = date.getDay()<10 ? "0"+ date.getDate() : Integer.toString(date.getDate());
        String mois = date.getMonth()<9 ? "0"+ (date.getMonth() + 1) : Integer.toString(date.getMonth()+1);
        String annee = Integer.toString(date.getYear()+1900);

        return jour+"/"+mois+"/"+annee;
    }

}
