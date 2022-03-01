package tp.baignoire;

public class Robinet implements Runnable {
    private Baignoire baignoire;
    private final int debit;

    public Robinet(Baignoire baignoire, int debit) {
        this.baignoire = baignoire;
        this.debit = debit;
    }

    public void debite() throws InterruptedException {
        do {
            if ((this.baignoire.getVolume() + this.debit) <= this.baignoire.getVolumeMaximum()) {
                if(baignoire.getNbDeFuite() >3) {
                    synchronized (this) {
                        System.out.println("On éteint, ça fuit");
                        wait();
                    }
                }
                synchronized (baignoire) {
                    this.baignoire.setVolume(this.baignoire.getVolume() + this.debit);
                    System.out.println("Nouveau volume : " + baignoire.getVolume() + "/" + baignoire.getVolumeMaximum());

                }
                Thread.sleep(1);
            } else {
                if (!this.baignoire.getPossedeFuite()) {
                    this.baignoire.setEstRemplie(true);
                    System.out.println("La baignoire est remplie");
                }
            }
        } while (this.baignoire.getEstRemplie() == false);

    }

    @Override
    public void run() {
        try {
            this.debite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
