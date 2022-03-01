package tp.baignoire;

import tp.baignoire.exception.VolumeInvalideException;

public class Baignoire implements Runnable{
    private boolean estRemplie;
    private final int volumeMaximum;
    private int volume;
    private int volumeFuite;
    private boolean possedeFuite;
    private Robinet robinet;
    private int nbDeFuite;


    public Baignoire(int volumeMaximum, int volume, int volumeFuite) throws VolumeInvalideException, InterruptedException {
        this.volumeMaximum = volumeMaximum;
        this.volumeFuite = volumeFuite;
        this.possedeFuite = true;
        this.nbDeFuite = 0;

        if (volume <= volumeMaximum && volume >= 0) {
            this.volume = volume;
            if (volume > 0)
                this.fuite();
        } else {
            throw new VolumeInvalideException();
        }
        if (volume == volumeMaximum) {
            this.estRemplie = true;
        } else {
            this.estRemplie = false;
        }
    }

    public void setVolume(int volume) throws VolumeInvalideException {
        if (volume <= volumeMaximum && volume >= 0) {
            this.volume = volume;
        } else {
            throw new VolumeInvalideException();
        }
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMaximum() {
        return volumeMaximum;
    }

    public void setEstRemplie(boolean estRemplie) {
        this.estRemplie = estRemplie;
    }

    public boolean getEstRemplie() {
        return estRemplie;
    }

    public boolean getPossedeFuite() {
        return possedeFuite;
    }

    public void setRobinet(Robinet robinet) {
        this.robinet = robinet;
    }

    public int getNbDeFuite() {
        return nbDeFuite;
    }

    public void fuite() throws InterruptedException {
        do {
            if (this.volume == 0) {
                this.volumeFuite--;
                System.out.println("Fuite reparé de 1 : Nouveau debit fuite => " + this.volumeFuite);
            } else {
                nbDeFuite++;
                synchronized (this) {
                    if ((this.volume - this.volumeFuite) >= 0) {
                        this.setVolume(this.volume - this.volumeFuite);
                        System.out.println("Fuite ! Nouveau volume : " + this.volume + "/" + this.volumeMaximum);
                    } else {
                        this.setVolume(0);
                    }
                }
            }
            Thread.sleep(1);
        } while (this.volumeFuite != 0);
        System.out.println("Baignoire réparé");
        this.possedeFuite = false;
        synchronized (robinet) {
            robinet.notify();
            nbDeFuite =0;
        }
    }

    @Override
    public void run() {
        try {
            this.fuite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
