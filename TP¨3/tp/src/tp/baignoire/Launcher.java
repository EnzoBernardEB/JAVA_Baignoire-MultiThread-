package tp.baignoire;

import tp.baignoire.exception.VolumeInvalideException;

public class Launcher {
    public static void main(String[] args) {
        try {
            Baignoire baignoire = new Baignoire(1000,0,30);
            Robinet robinet = new Robinet(baignoire,50);
            baignoire.setRobinet(robinet);


            Thread baignoireThread = new Thread(baignoire);
            Thread robinetThread = new Thread(robinet);
            robinetThread.start();
            baignoireThread.start();


        } catch (VolumeInvalideException e) {
            System.out.println(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
