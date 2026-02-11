package edu.dosw.lab.comportamiento.reto7;

/**
 * Receptor: dispositivo Música.
 */
public class Musica {

    private boolean reproduciendo;

    public Musica() {
        this.reproduciendo = false;
    }

    public void reproducir() {
        reproduciendo = true;
    }

    public void detener() {
        reproduciendo = false;
    }

    public boolean isReproduciendo() {
        return reproduciendo;
    }
}
